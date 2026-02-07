package com.scaler.myproject.services;

import com.scaler.myproject.exceptions.ProductNotFoundException;
import com.scaler.myproject.models.Product;
import org.springframework.data.domain.Page;
import java.util.List;

public interface ProductService {

    Product getProductByID(Long id) throws ProductNotFoundException;

    Product createProduct(Product product);


    Page<Product> getAllProducts(int pageNumber, int pageSize);


    Product replaceProduct(Long id, Product product) throws ProductNotFoundException;

    void deleteProduct(Long id);

}
