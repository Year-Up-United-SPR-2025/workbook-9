package com.pluralsight.NorthwindTradersAPI.controllers;

// Importing necessary classes for handling HTTP requests and models
import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Marks this class as a REST controller that handles HTTP requests
@RestController
// Defines the base URL path for all endpoints in this controller
@RequestMapping("/categories")
public class CategoriesController {

    // A list to store category data
    private List<Category> categories;

    // Constructor to initialize the list with sample categories
    public CategoriesController() {
        categories = new ArrayList<>();
        categories.add(new Category(1, "Drinks"));  // Category ID 1: Drinks
        categories.add(new Category(2, "Snacks"));  // Category ID 2: Snacks
        categories.add(new Category(3, "Fruits"));  // Category ID 3: Fruits
    }

    // Handles GET requests to /categories
    // Filters categories based on an optional query parameter: name
    @GetMapping
    public List<Category> getCategories(@RequestParam(required = false) String name) {
        return categories.stream()
                .filter(c -> name == null || c.getCategoryName().equalsIgnoreCase(name)) // Filter by name if provided
                .collect(Collectors.toList()); // Return filtered list
    }

    // Handles GET requests to /categories/{id}
    // Retrieves a single category by its ID
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return categories.stream()
                .filter(c -> c.getCategoryId() == id) // Find category by ID
                .findFirst()                          // Retrieve first matching category
                .orElse(null);                        // Return null if no category is found
    }
}