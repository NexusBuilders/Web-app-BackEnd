package com.example.EasyFood.easyfood.infrastructure.persistence.jpa;

import com.example.EasyFood.easyfood.domain.model.entities.Product;
import com.example.EasyFood.easyfood.domain.model.valueobjects.ProductId;
import com.example.EasyFood.easyfood.domain.repository.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<Product, ProductId>, ProductRepository {
}
