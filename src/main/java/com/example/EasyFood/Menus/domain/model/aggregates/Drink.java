package com.example.EasyFood.Menus.domain.model.aggregates;

import com.example.EasyFood.Menus.domain.model.commands.CreateDrinkCommand;
import com.example.EasyFood.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "drinks")
@Getter
@Setter
@NoArgsConstructor
public class Drink extends AuditableAbstractAggregateRoot<Drink> {
    private String name;
    private Double price;
    private String image;
    private int restaurantId;

    public Drink(CreateDrinkCommand command){
        this.name = command.name();
        this.price = command.price();
        this.image = command.image();
        this.restaurantId = command.restaurantId();
    }
}
