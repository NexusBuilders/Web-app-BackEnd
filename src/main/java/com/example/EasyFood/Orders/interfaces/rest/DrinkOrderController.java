package com.example.EasyFood.Orders.interfaces.rest;

import com.example.EasyFood.Orders.domain.model.queries.GetDrinksOrdersByOrderId;
import com.example.EasyFood.Orders.domain.service.DrinkOrderCommandService;
import com.example.EasyFood.Orders.domain.service.DrinkOrderQueryService;
import com.example.EasyFood.Orders.interfaces.rest.resources.CreateDrinkOrderResource;
import com.example.EasyFood.Orders.interfaces.rest.resources.DrinkOrderResource;
import com.example.EasyFood.Orders.interfaces.rest.transform.CreateDrinkOrderCommandFromResourceAssembler;
import com.example.EasyFood.Orders.interfaces.rest.transform.DrinkOrderResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/drinksOrders", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Drink Orders", description = "Drinks orders management endpoints")
public class DrinkOrderController {
    private final DrinkOrderCommandService drinkOrderCommandService;
    private final DrinkOrderQueryService drinkOrderQueryService;

    public DrinkOrderController(DrinkOrderCommandService drinkOrderCommandService, DrinkOrderQueryService drinkOrderQueryService) {
        this.drinkOrderCommandService = drinkOrderCommandService;
        this.drinkOrderQueryService = drinkOrderQueryService;
    }

    @PostMapping
    public ResponseEntity<DrinkOrderResource> createDrinkOrder(@RequestBody CreateDrinkOrderResource createDrinkOrderResource) {
        var createDrinkOrderCommand = CreateDrinkOrderCommandFromResourceAssembler.toCommandResource(createDrinkOrderResource);
        var drinkOrder = drinkOrderCommandService.handle(createDrinkOrderCommand);
        if(drinkOrder.isEmpty()) return ResponseEntity.badRequest().build();

        var drinkOrderResource = DrinkOrderResourceFromEntityAssembler.toResourceFromEntity(drinkOrder.get());
        return ResponseEntity.ok(drinkOrderResource);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<DrinkOrderResource>> getDrinkOrdersByOrderId(@PathVariable Long orderId) {
        var getAllDrinkOrdersByIdRestaurant = new GetDrinksOrdersByOrderId(orderId);
        var drinkOrders = drinkOrderQueryService.handle(getAllDrinkOrdersByIdRestaurant);
        var drinkOrdersResources = drinkOrders.stream()
                .map(DrinkOrderResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(drinkOrdersResources);
    }
}
