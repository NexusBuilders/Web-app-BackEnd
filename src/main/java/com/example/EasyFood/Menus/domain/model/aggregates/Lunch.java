package com.example.EasyFood.Menus.domain.model.aggregates;

import com.example.EasyFood.Menus.domain.model.commands.CreateLunchCommand;
import com.example.EasyFood.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "lunches")
@Getter
@Setter
@NoArgsConstructor
public class Lunch extends AuditableAbstractAggregateRoot<Lunch>{
    private String starterPlate;
    private String mainDish;
    private Double price;
    private String Image;
    private int restaurantId;


    public Lunch(CreateLunchCommand command){
        this.starterPlate = command.starterPlate();
        this.mainDish = command.mainDish();
        this.price = command.price();
        this.Image = command.image();
        this.restaurantId = command.restaurantId();
    }
}
