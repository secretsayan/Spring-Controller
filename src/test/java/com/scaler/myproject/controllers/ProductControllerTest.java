package com.scaler.myproject.controllers;

import com.scaler.myproject.exceptions.ProductNotFoundException;
import com.scaler.myproject.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    void validGetProductByIdTest() throws ProductNotFoundException {
        Product product = productController.getProductById(1L).getBody();
    }

    @Test
    void getProductById() {
    }
}