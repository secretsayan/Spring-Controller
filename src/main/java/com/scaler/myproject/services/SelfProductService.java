package com.scaler.myproject.services;

import com.scaler.myproject.exceptions.ProductNotFoundException;
import com.scaler.myproject.models.Product;
import com.scaler.myproject.repositories.ProductRespository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductService {

    private ProductRespository productRespository;

    SelfProductService(ProductRespository productRespository){
        this.productRespository = productRespository;
    }

    @Override
    public Product getProductByID(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() throws ProductNotFoundException {
        return List.of();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
