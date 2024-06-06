package com.example.EasyFood.easyfood.domain.model.entities;

import com.example.EasyFood.easyfood.domain.model.valueobjects.ProductId;
import com.example.EasyFood.easyfood.domain.model.valueobjects.Quantity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Getter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    private ProductId id;
    private String name;

    @Embedded
    private Quantity quantity;

    public Product(ProductId id, String name, Quantity quantity) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.quantity = Objects.requireNonNull(quantity);
    }
}
