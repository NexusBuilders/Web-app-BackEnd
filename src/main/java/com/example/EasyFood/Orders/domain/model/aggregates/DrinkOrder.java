package com.example.EasyFood.Orders.domain.model.aggregates;

import com.example.EasyFood.Orders.domain.model.commands.CreateDrinkOrderCommand;
import com.example.EasyFood.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "drinksOrders")
@Getter
@NoArgsConstructor
public class DrinkOrder extends AuditableAbstractAggregateRoot<DrinkOrder> {
    private int quantity;
    private int drinkId;
    private int orderId;
    public DrinkOrder(CreateDrinkOrderCommand command){
        this.quantity = command.quantity();
        this.drinkId = command.drinkId();
        this.orderId = command.orderId();
    }
}
