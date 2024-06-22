package com.example.EasyFood.Orders.interfaces.rest;
import com.example.EasyFood.Menus.domain.model.queries.GetLunchesByRestaurantId;
import com.example.EasyFood.Menus.interfaces.rest.resources.LunchResource;
import com.example.EasyFood.Menus.interfaces.rest.transform.LunchResourceFromEntityAssembler;
import com.example.EasyFood.Orders.domain.model.queries.GetOrderByCustomerIdQuery;
import com.example.EasyFood.Orders.domain.model.queries.GetOrderByIdQuery;
import com.example.EasyFood.Orders.domain.service.OrderCommandService;
import com.example.EasyFood.Orders.domain.service.OrderQueryService;
import com.example.EasyFood.Orders.interfaces.rest.resources.CreateOrderResource;
import com.example.EasyFood.Orders.interfaces.rest.resources.OrderResource;
import com.example.EasyFood.Orders.interfaces.rest.transform.CreateOrderCommandFromResourceAssembler;
import com.example.EasyFood.Orders.interfaces.rest.transform.OrderResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Order", description = "Orders management endpoints")
public class OrderController {
    private final OrderQueryService orderQueryService;
    private final OrderCommandService orderCommandService;

    public OrderController(OrderQueryService orderQueryService, OrderCommandService orderCommandService) {
        this.orderQueryService = orderQueryService;
        this.orderCommandService = orderCommandService;
    }


    @PostMapping
    public ResponseEntity<OrderResource> createOrder(@RequestBody CreateOrderResource createOrderResource) {
        var createOrderCommand = CreateOrderCommandFromResourceAssembler.toCommandResource(createOrderResource);
        var order = orderCommandService.handle(createOrderCommand);
        if(order.isEmpty()) return ResponseEntity.badRequest().build();

        var orderResource = OrderResourceFromEntityAssembler.toResourceFromEntity(order.get());
        return ResponseEntity.ok(orderResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResource> getOrderById(@PathVariable Long id) {
        var getOrderByIdQuery = new GetOrderByIdQuery(id);
        var order = orderQueryService.handle(getOrderByIdQuery);
        if(order.isEmpty()) return ResponseEntity.badRequest().build();
        var orderResource = OrderResourceFromEntityAssembler.toResourceFromEntity(order.get());
        return ResponseEntity.ok(orderResource);
    }
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderResource>> getLunchesByRestaurantId(@PathVariable Long customerId) {
        var getAllOrdersByCustomerId = new GetOrderByCustomerIdQuery(customerId);
        var orders = orderQueryService.handle(getAllOrdersByCustomerId);
        var ordersResources = orders.stream()
                .map(OrderResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(ordersResources);
    }
}
