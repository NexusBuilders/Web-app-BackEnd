package com.example.EasyFood.easyfood.domain.service;

import com.example.EasyFood.easyfood.domain.model.entities.OrderHistory;

import java.util.List;

public interface OrderHistoryService {
    List<OrderHistory> getOrderHistoryByUserId(Long userId);
}
