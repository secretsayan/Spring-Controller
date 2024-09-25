package com.scaler.myproject.services;

import com.scaler.myproject.exceptions.ProductNotFoundException;
import com.scaler.myproject.models.Category;
import com.scaler.myproject.models.Product;
import com.scaler.myproject.repositories.CategoryRepository;
import com.scaler.myproject.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductByID(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
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
        //Before saving the Product object in the DB, save the category object.

        Category category = product.getCategory();

        if (category.getId() == null) {
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        } else {
            //we should check if the category id is valid or not.
        }

        Product savedProduct = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(savedProduct.getCategory().getId());
        Category category1 = optionalCategory.get();
        savedProduct.setCategory(category1);
        return savedProduct;
    }

    @Override
    public void deleteProduct() {

    }
}
