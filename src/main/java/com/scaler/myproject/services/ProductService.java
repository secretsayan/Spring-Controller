package com.scaler.myproject.services;

import com.scaler.myproject.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    Product getProductByID(Long id);

    List<Product> getAllProducts();

}
