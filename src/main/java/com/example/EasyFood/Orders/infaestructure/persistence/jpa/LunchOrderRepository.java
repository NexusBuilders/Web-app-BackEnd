package com.example.EasyFood.Orders.infaestructure.persistence.jpa;

import com.example.EasyFood.Orders.domain.model.aggregates.LunchOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LunchOrderRepository extends JpaRepository<LunchOrder, Long> {
    List<LunchOrder> findAllByOrderId(Long orderId);
}
