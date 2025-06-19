package com.pluralsight.NorthwindTradersAPI.dao.category_dao;

import com.pluralsight.NorthwindTradersAPI.config.DatabaseConfig;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCategoryDAO implements CategoryDAO {

    private DatabaseConfig databaseConfig;
    private BasicDataSource basicDataSource;

    @Autowired
    public JdbcCategoryDAO(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
        this.basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(databaseConfig.getUrl());
        basicDataSource.setUsername(databaseConfig.getUsername());
        basicDataSource.setPassword(databaseConfig.getPassword());
    }

    @Override
    public List<Category> getAllCategories() {
        ArrayList<Category> categories = new ArrayList<>();

        String query = """
                SELECT
                    CategoryId,
                    CategoryName,
                    Description,
                    Picture
                FROM
                    categories
                """;

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                int categoryId = resultSet.getInt(1);
                String categoryName = resultSet.getString(2);
                String description = resultSet.getString(3);
                byte[] picture = resultSet.getBytes(4);
                Category category = new Category(categoryId, categoryName, description, picture);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categories;
    }

    @Override
    public Category getCategoryById(int categoryId) {
        String query = """
                SELECT
                    CategoryId,
                    CategoryName,
                    Description,
                    Picture
                FROM
                    categories
                WHERE
                    CategoryId = ?
                """;

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, categoryId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String categoryName = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    byte[] picture = resultSet.getBytes(4);
                    return new Category(categoryId, categoryName, description, picture);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Category addCategory(Category category) {
        String query = """
                INSERT INTO categories
                (CategoryName, Description, Picture)
                VALUES
                (?, ?, ?)
                """;

        try (
                Connection connection = basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setBytes(3, category.getPicture());
            int rows = preparedStatement.executeUpdate();
            try (ResultSet keys = preparedStatement.getGeneratedKeys()) {
                if (keys.next()) {
                    Category result = new Category();
                    result.setCategoryId(keys.getInt(1));
                    result.setCategoryName(category.getCategoryName());
                    result.setDescription(category.getDescription());
                    result.setPicture(category.getPicture());
                    return result;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
