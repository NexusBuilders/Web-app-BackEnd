package com.example.EasyFood.easyfood.domain.service;

import com.example.EasyFood.easyfood.domain.model.entities.OrderHistory;
import com.example.EasyFood.easyfood.infrastructure.persistence.jpa.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    private OrderHistoryRepository orderHistoryRepository;

    @Override
    public List<OrderHistory> getOrderHistoryByUserId(Long userId) {
        return orderHistoryRepository.findByUserId(userId);
    }
}
