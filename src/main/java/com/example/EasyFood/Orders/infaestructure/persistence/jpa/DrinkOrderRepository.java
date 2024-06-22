package com.example.EasyFood.Orders.infaestructure.persistence.jpa;

import com.example.EasyFood.Orders.domain.model.aggregates.DrinkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DrinkOrderRepository extends JpaRepository<DrinkOrder, Long> {
    List<DrinkOrder> findAllByOrderId(Long orderId);
}
