package com.example.EasyFood.Orders.domain.model.aggregates;

import com.example.EasyFood.Orders.domain.model.commands.CreateOrderCommand;
import com.example.EasyFood.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor
public class Order extends AuditableAbstractAggregateRoot<Order> {
    private String address;
    private String arriveTime;
    private Double totalAmount;

    public Order(CreateOrderCommand command) {
        this.address = command.address();
        this.arriveTime = command.arriveTime();
        this.totalAmount = command.totalAmount();
    }
}
