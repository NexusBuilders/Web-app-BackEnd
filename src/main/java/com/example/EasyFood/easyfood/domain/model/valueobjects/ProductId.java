package com.example.EasyFood.easyfood.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProductId(Long id) {
    public ProductId{
        if (id == null || id <=0){
            throw new IllegalArgumentException("ProducId must be a positive non-null value");
        }
    }

    public Long value(){
        return id;
    }
}
