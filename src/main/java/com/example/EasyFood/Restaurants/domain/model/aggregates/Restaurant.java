package com.example.EasyFood.Restaurants.domain.model.aggregates;

import com.example.EasyFood.Restaurants.domain.model.commands.CreateRestaurantCommand;
import com.example.EasyFood.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor
public class Restaurant extends AuditableAbstractAggregateRoot<Restaurant> {
    private String name;
    private String address;
    private String email;
    private String schedule;
    private String phone;
    private int userId;

    public Restaurant(CreateRestaurantCommand command){
        this.name = command.name();
        this.address = command.address();
        this.email = command.email();
        this.schedule = command.schedule();
        this.phone = command.phone();
        this.userId = command.userId();
    }
}
