package com.scaler.myproject.services;

import com.scaler.myproject.exceptions.ProductNotFoundException;
import com.scaler.myproject.models.Product;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    Product getProductByID(Long id) throws ProductNotFoundException;

    List<Product> getAllProducts() throws ProductNotFoundException;

    Product replaceProduct(Long id, Product product);

    Product updateProduct(Long id, Product product);

    Product createProduct(Product product);

    void deleteProduct();

}
