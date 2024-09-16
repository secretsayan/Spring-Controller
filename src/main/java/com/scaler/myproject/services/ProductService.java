package com.scaler.myproject.services;

import com.scaler.myproject.models.Product;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    Product getProductByID(Long id);

    List<Product> getAllProducts();

    Product replaceProduct(Long id, Product product);

}
