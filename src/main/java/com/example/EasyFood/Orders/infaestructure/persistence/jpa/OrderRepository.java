package com.example.EasyFood.Orders.infaestructure.persistence.jpa;

import com.example.EasyFood.Orders.domain.model.aggregates.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findOrderById(Long orderId);
}
