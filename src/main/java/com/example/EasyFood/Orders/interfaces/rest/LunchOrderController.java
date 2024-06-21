package com.example.EasyFood.Orders.interfaces.rest;

import com.example.EasyFood.Menus.interfaces.rest.transform.CreateLunchCommandFromResourceAssembler;
import com.example.EasyFood.Orders.domain.model.queries.GetDrinksOrdersByOrderId;
import com.example.EasyFood.Orders.domain.model.queries.GetLunchesOrdersByOrderId;
import com.example.EasyFood.Orders.domain.service.LunchOrderCommandService;
import com.example.EasyFood.Orders.domain.service.LunchOrderQueryService;
import com.example.EasyFood.Orders.interfaces.rest.resources.CreateDrinkOrderResource;
import com.example.EasyFood.Orders.interfaces.rest.resources.CreateLunchOrderResource;
import com.example.EasyFood.Orders.interfaces.rest.resources.DrinkOrderResource;
import com.example.EasyFood.Orders.interfaces.rest.resources.LunchOrderResource;
import com.example.EasyFood.Orders.interfaces.rest.transform.CreateDrinkOrderCommandFromResourceAssembler;
import com.example.EasyFood.Orders.interfaces.rest.transform.CreateLunchOrderCommandFromResourceAssembler;
import com.example.EasyFood.Orders.interfaces.rest.transform.DrinkOrderResourceFromEntityAssembler;
import com.example.EasyFood.Orders.interfaces.rest.transform.LunchOrderResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/lunchOrders", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Lunch Orders", description = "Lunch Orders management endpoints")
public class LunchOrderController {
    private final LunchOrderCommandService lunchOrderCommandService;
    private final LunchOrderQueryService lunchOrderQueryService;

    public LunchOrderController(LunchOrderCommandService lunchOrderCommandService, LunchOrderQueryService lunchOrderQueryService) {
        this.lunchOrderCommandService = lunchOrderCommandService;
        this.lunchOrderQueryService = lunchOrderQueryService;
    }

    @PostMapping
    public ResponseEntity<LunchOrderResource> createDrinkOrder(@RequestBody CreateLunchOrderResource createLunchOrderResource) {
        var createLunchOrderCommand = CreateLunchOrderCommandFromResourceAssembler.toCommandResource(createLunchOrderResource);
        var lunchOrder = lunchOrderCommandService.handle(createLunchOrderCommand);
        if(lunchOrder.isEmpty()) return ResponseEntity.badRequest().build();

        var lunchOrderResource = LunchOrderResourceFromEntityAssembler.toResourceFromEntity(lunchOrder.get());
        return ResponseEntity.ok(lunchOrderResource);
    }
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<LunchOrderResource>> getLunchOrdersByOrderId(@PathVariable Long orderId) {
        var getAllLunchOrdersByIdRestaurant = new GetLunchesOrdersByOrderId(orderId);
        var lunchOrders = lunchOrderQueryService.handle(getAllLunchOrdersByIdRestaurant);
        var lunchOrdersResources = lunchOrders.stream()
                .map(LunchOrderResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lunchOrdersResources);
    }
}
