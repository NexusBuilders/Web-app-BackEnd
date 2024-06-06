package com.example.EasyFood.easyfood.interfaces.rest;

import com.example.EasyFood.easyfood.domain.model.entities.OrderHistory;
import com.example.EasyFood.easyfood.domain.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order-history")
public class OrderHistoryController {

    @Autowired
    private OrderHistoryService orderHistoryService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderHistory>> getOrderHistoryByUserId(@PathVariable Long userId) {
        List<OrderHistory> orderHistory = orderHistoryService.getOrderHistoryByUserId(userId);
        return ResponseEntity.ok(orderHistory);
    }
}
