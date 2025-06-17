package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Drinks"));
        categories.add(new Category(2, "Snacks"));
        categories.add(new Category(3, "Fruits"));
        categories.add(new Category(4, "Vegetables"));
        categories.add(new Category(5, "Dairy"));
        categories.add(new Category(6, "Bakery"));
        categories.add(new Category(7, "Meat"));
        categories.add(new Category(8, "Seafood"));
        categories.add(new Category(9, "Frozen Foods"));
        categories.add(new Category(10, "Beverages"));
        categories.add(new Category(11, "Condiments"));
        categories.add(new Category(12, "Canned Goods"));
        categories.add(new Category(13, "Grains"));
        categories.add(new Category(14, "Sweets"));
        categories.add(new Category(15, "Household Items"));
        categories.add(new Category(16, "Personal Care"));
        categories.add(new Category(17, "Pet Supplies"));
        return categories;
    }

    @RequestMapping(path = "/categories/{id}", method = RequestMethod.GET)
    public List<Category> getCategories(@PathVariable int categoryId) {
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Drinks"));
        categories.add(new Category(2, "Snacks"));
        categories.add(new Category(3, "Fruits"));
        categories.add(new Category(4, "Vegetables"));
        categories.add(new Category(5, "Dairy"));
        categories.add(new Category(6, "Bakery"));
        categories.add(new Category(7, "Meat"));
        categories.add(new Category(8, "Seafood"));
        categories.add(new Category(9, "Frozen Foods"));
        categories.add(new Category(10, "Beverages"));
        categories.add(new Category(11, "Condiments"));
        categories.add(new Category(12, "Canned Goods"));
        categories.add(new Category(13, "Grains"));
        categories.add(new Category(14, "Sweets"));
        categories.add(new Category(15, "Household Items"));
        categories.add(new Category(16, "Personal Care"));
        categories.add(new Category(17, "Pet Supplies"));


        ArrayList<Category> resultingCategories = new ArrayList<>();
        return categories.stream().filter(c -> c.getCategoryId() == categoryId).toList();
    }

}
