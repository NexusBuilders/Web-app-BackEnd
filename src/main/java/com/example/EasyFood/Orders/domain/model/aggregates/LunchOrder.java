package com.example.EasyFood.Orders.domain.model.aggregates;

import com.example.EasyFood.Orders.domain.model.commands.CreateLunchOrderCommand;
import com.example.EasyFood.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "luncesOrders")
@Getter
@NoArgsConstructor
public class LunchOrder extends AuditableAbstractAggregateRoot<LunchOrder> {
    private int quantity;
    private int lunchId;
    private int orderId;
    public LunchOrder(CreateLunchOrderCommand command){
        this.quantity = command.quantity();
        this.lunchId = command.lunchId();
        this.orderId = command.orderId();
    }
}
