package com.example.EasyFood.easyfood.domain.model.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Column
    private String orderDetails;

    @Column
    private Double totalAmount;
}
