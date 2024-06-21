package com.example.EasyFood.Orders.interfaces.rest;
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
}
