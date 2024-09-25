package com.scaler.myproject.repositories;

import com.scaler.myproject.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long id);

    List<Product> findByTitle(String word);

    List<Product> findByTitleContains(String str);

    //select * from products where title = <> and description = <>
    List<Product> findByTitleAndDescription(String title, String description);


}
