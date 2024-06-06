package com.example.EasyFood.easyfood.domain.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int stock;

    @Column(nullable = false)
    private String location;
    private String description;
    private LocalDateTime lastUpdated;

    public void incrementStock(int amount){
        if(amount > 0){
            this.stock += amount;
            this.lastUpdated = LocalDateTime.now();
        }
    }

    public void decrementStock(int amount){
        if (amount > 0 && this.stock >= amount){
            this.stock -= amount;
            this.lastUpdated = LocalDateTime.now();
        }
    }
}