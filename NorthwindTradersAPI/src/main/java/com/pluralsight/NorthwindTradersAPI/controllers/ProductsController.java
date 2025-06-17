package com.pluralsight.NorthwindTradersAPI.controllers;

// Importing necessary classes for handling HTTP requests and models
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Marks this class as a REST controller that handles HTTP requests
@RestController
// Defines the base URL path for all endpoints in this controller
@RequestMapping("/products")
public class ProductsController {

    // A list to store product data
    private List<Product> products;

    // Constructor to initialize the list with sample products
    public ProductsController() {
        products = new ArrayList<>();
        products.add(new Product(1, "Milk", 1, 5.99));   // Product ID 1, belongs to category 1, price $5.99
        products.add(new Product(2, "Bread", 1, 3.99));  // Product ID 2, belongs to category 1, price $3.99
        products.add(new Product(3, "Water", 1, 1.99));  // Product ID 3, belongs to category 1, price $1.99
        products.add(new Product(4, "Pants", 2, 19.99)); // Product ID 4, belongs to category 2, price $19.99
        products.add(new Product(5, "TShirt", 2, 9.99)); // Product ID 5, belongs to category 2, price $9.99
    }

    // Handles GET requests to /products
    // Filters products based on optional query parameters: name, categoryId, or price
    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) Integer categoryId,
                                     @RequestParam(required = false) Double price) {
        return products.stream()
                .filter(p -> (name == null || p.getProductName().equalsIgnoreCase(name)) && // Filter by name if provided
                        (categoryId == null || p.getCategoryId() == categoryId) &&          // Filter by category if provided
                        (price == null || p.getPrice() == price))                           // Filter by price if provided
                .collect(Collectors.toList()); // Return filtered list
    }

    // Handles GET requests to /products/{id}
    // Retrieves a single product by its ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return products.stream()
                .filter(p -> p.getProductId() == id) // Find product by ID
                .findFirst()                         // Retrieve first matching product
                .orElse(null);                       // Return null if no product is found
    }
}