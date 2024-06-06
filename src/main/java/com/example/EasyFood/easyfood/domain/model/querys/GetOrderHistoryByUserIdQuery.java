package com.example.EasyFood.easyfood.domain.model.querys;

import lombok.Getter;

@Getter
public class GetOrderHistoryByUserIdQuery {
    private Long userId;

    public GetOrderHistoryByUserIdQuery(Long userId) {
        this.userId = userId;
    }

}
