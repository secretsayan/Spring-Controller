package com.scaler.myproject.controllers;

import com.scaler.myproject.exceptions.ProductNotFoundException;
import com.scaler.myproject.models.Product;
import com.scaler.myproject.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) throws ProductNotFoundException {
        Product product = productService.getProductByID(id);
        ResponseEntity<Product> responseEntity;
        if(product == null){
            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        }

        return  responseEntity;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() throws ProductNotFoundException {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<Void> handleSomeException() {
        return null;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) { // can use DTO as well.
        return productService.createProduct(product);
    }

}
