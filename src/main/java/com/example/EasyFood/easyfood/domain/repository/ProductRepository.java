package com.example.EasyFood.easyfood.domain.repository;

import com.example.EasyFood.easyfood.domain.model.entities.Product;
import com.example.EasyFood.easyfood.domain.model.valueobjects.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, ProductId> {
}
