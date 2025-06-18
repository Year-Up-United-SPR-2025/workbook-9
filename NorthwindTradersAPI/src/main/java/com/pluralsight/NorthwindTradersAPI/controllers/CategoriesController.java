package com.pluralsight.NorthwindTradersAPI.controllers;
import org.springframework.beans.factory.annotation.Qualifier;
import com.pluralsight.NorthwindTradersAPI.dao.category_dao.CategoryDAO;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriesController {

    private CategoryDAO categoryDAO;

    @Autowired
    public CategoriesController(@Qualifier("jdbcCategoryDAO") CategoryDAO categoryDAO) {
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

    @RequestMapping(path = "/categories", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category) {
        return categoryDAO.addCategory(category);
    }
}
