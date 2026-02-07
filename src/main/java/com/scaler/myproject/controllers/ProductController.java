package com.scaler.myproject.controllers;

import com.scaler.myproject.exceptions.ProductNotFoundException;
import com.scaler.myproject.models.Product;
import com.scaler.myproject.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

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

    @GetMapping()
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) {
        return productService.getAllProducts(pageNumber, pageSize);
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long productId,
                                 @RequestBody Product product) {
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long productId,
                                  @RequestBody Product product) throws ProductNotFoundException {
        return productService.replaceProduct(productId, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e) {
        return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.SERVICE_UNAVAILABLE
        );
    }



    @GetMapping("/all")
    public List<Product> getAllProducts() throws ProductNotFoundException {
        return productService.getAllProducts();
    }


    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<Void> handleSomeException() {
        return null;
    }
}
