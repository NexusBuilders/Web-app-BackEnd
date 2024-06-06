package com.example.EasyFood.easyfood.domain.service;

import com.example.EasyFood.easyfood.domain.model.entities.Product;
import com.example.EasyFood.easyfood.domain.model.valueobjects.ProductId;
import com.example.EasyFood.easyfood.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {
    private final ProductRepository productRepository;

    public StockService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(ProductId id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
