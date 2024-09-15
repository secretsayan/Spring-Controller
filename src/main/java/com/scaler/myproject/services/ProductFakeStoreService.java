package com.scaler.myproject.services;

import com.scaler.myproject.dtos.FakeStoreProductDto;
import com.scaler.myproject.models.Category;
import com.scaler.myproject.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductFakeStoreService implements ProductService{

    private RestTemplate restTemplate;

    ProductFakeStoreService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Product convertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());

        Category category = new Category();
        category.setDesc(fakeStoreProductDto.getCategory());
        product.setCategory(category);


        return product;
    }

    @Override
    public Product getProductByID(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);

        if(fakeStoreProductDto == null){
            return null;
        }
        return convertFakeStoreDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }



}
