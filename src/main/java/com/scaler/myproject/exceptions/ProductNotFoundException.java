package com.scaler.myproject.exceptions;

import com.scaler.myproject.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception {

    private Long id;
    private String message;

    public ProductNotFoundException(Long id, String message) {
        super(message);
        this.id = id;
    }
    public ProductNotFoundException(String message) {
        super(message);
    }
}
