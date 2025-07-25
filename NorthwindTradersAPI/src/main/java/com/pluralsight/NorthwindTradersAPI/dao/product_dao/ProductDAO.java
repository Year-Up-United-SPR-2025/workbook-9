package com.pluralsight.NorthwindTradersAPI.dao.product_dao;

import com.pluralsight.NorthwindTradersAPI.models.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();

    Product getProductById(int productId);

    Product addProduct(Product product);
}