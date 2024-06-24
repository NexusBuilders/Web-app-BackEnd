package com.example.EasyFood.Orders.interfaces.acl;

import com.example.EasyFood.Orders.domain.model.commands.CreateOrderCommand;
import com.example.EasyFood.Orders.domain.service.OrderCommandService;
import com.example.EasyFood.Orders.domain.service.OrderQueryService;

public class OrderContextFacade {
    private final OrderCommandService orderCommandService;
    private final OrderQueryService orderQueryService;

    public OrderContextFacade(OrderCommandService orderCommandService, OrderQueryService orderQueryService) {
        this.orderCommandService = orderCommandService;
        this.orderQueryService = orderQueryService;
    }

    public Long CreateOrder(String address,
                            String arriveTime,
                            Double totalAmount, int customerId){
        var createOrderCommand = new CreateOrderCommand(address, arriveTime, totalAmount, customerId);
        var order = orderCommandService.handle(createOrderCommand);
        if (order.isEmpty()) {return 0L;}
        return order.get().getId();
    }


}
