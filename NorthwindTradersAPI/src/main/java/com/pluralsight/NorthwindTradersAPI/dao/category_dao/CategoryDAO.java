package com.pluralsight.NorthwindTradersAPI.dao.category_dao;

import com.pluralsight.NorthwindTradersAPI.models.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAllCategories();

    Category getCategoryById(int categoryId);

    Category addCategory(Category category);
}
