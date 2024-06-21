package com.example.EasyFood.Restaurants.domain.model.aggregates;

import com.example.EasyFood.Restaurants.domain.model.commands.CreateStockCommand;
import com.example.EasyFood.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stocks")
@Getter
@Setter
@NoArgsConstructor
public class Stock extends AuditableAbstractAggregateRoot<Stock> {
    private String name;
    private int quantity;
    private String unity;
    private int restaurantId;

    public Stock(CreateStockCommand command){
        this.name = command.name();
        this.quantity = command.quantity();
        this.unity = command.unity();
        this.restaurantId = command.restaurantId();
    }
}
