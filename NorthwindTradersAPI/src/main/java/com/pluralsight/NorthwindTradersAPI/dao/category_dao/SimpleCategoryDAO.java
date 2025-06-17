package com.pluralsight.NorthwindTradersAPI.dao.category_dao;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleCategoryDAO implements CategoryDAO {

    private List<Category> categories;

    public SimpleCategoryDAO() {
        // Initialize the categories list with some sample data
        categories = new ArrayList<>();
        categories.add(new Category(1, "Food", "Various food items", null)); // Assuming description and picture are optional
        categories.add(new Category(2, "Clothing", "Apparel and garments", null));
    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categories.stream()
                .filter(c -> c.getCategoryId() == categoryId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addCategory(Category category) {
        // Add the new category to the list
        categories.add(category);
    }
}
