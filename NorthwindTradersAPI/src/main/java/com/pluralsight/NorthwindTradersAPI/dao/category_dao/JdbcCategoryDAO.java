package com.pluralsight.NorthwindTradersAPI.dao.category_dao;

import com.pluralsight.NorthwindTradersAPI.dao.DatabaseConfig;
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
public class JdbcCategoryDAO {

    private DatabaseConfig databaseConfig;

    @Autowired
    public JdbcCategoryDAO(DatabaseConfig databaseConfig) {
        this.databaseConfig = databaseConfig;
    }

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

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(databaseConfig.getUrl());
        basicDataSource.setUsername(databaseConfig.getUsername());
        basicDataSource.setPassword(databaseConfig.getPassword());

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

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(databaseConfig.getUrl());
        basicDataSource.setUsername(databaseConfig.getUsername());
        basicDataSource.setPassword(databaseConfig.getPassword());

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

    public void addCategory(Category category) {
        // Implementation for adding a category will be done later
    }
}
