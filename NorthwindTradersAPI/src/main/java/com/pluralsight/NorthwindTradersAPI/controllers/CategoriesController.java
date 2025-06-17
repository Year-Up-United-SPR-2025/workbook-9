package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.dao.category_dao.CategoryDAO; // Import the CategoryDAO
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesController {

    private CategoryDAO categoryDAO;

    @Autowired
    public CategoriesController(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getCategories() {
        return categoryDAO.getAllCategories();
    }

    @RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
    public Category getCategory(@PathVariable int id) {
        return categoryDAO.getCategoryById(id);
    }
}
