package com.scaler.myproject.controllers;

import com.scaler.myproject.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    public String getProducts() {
        return "List of products";
    }

    @RequestMapping("/{id}")
    public Product getProductById(@PathVariable long id) {
        return null;
    }

}
