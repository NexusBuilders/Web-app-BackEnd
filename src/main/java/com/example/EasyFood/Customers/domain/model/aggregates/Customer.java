package com.example.EasyFood.Customers.domain.model.aggregates;

import com.example.EasyFood.Customers.domain.model.commands.CreateCustomerCommand;
import com.example.EasyFood.shared.domain.model.aggregate.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer extends AuditableAbstractAggregateRoot<Customer> {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int userId;

    public Customer(CreateCustomerCommand command){
        this.firstName = command.firstName();
        this.lastName = command.lastName();
        this.email = command.email();
        this.phone = command.phone();
        this.userId = command.userId();
    }
}
