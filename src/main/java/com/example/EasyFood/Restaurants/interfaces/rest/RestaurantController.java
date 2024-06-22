package com.example.EasyFood.Restaurants.interfaces.rest;

import com.example.EasyFood.Orders.domain.model.queries.GetLunchesOrdersByOrderId;
import com.example.EasyFood.Orders.interfaces.rest.resources.LunchOrderResource;
import com.example.EasyFood.Orders.interfaces.rest.transform.LunchOrderResourceFromEntityAssembler;
import com.example.EasyFood.Restaurants.domain.model.commands.UpdateRestaurantCommand;
import com.example.EasyFood.Restaurants.domain.model.queries.GetAllRestaurantsQuery;
import com.example.EasyFood.Restaurants.domain.model.queries.GetRestaurantByIdQuery;
import com.example.EasyFood.Restaurants.domain.model.queries.GetRestaurantByUserIdQuery;
import com.example.EasyFood.Restaurants.domain.service.RestaurantCommandService;
import com.example.EasyFood.Restaurants.domain.service.RestaurantQueryService;
import com.example.EasyFood.Restaurants.interfaces.rest.resources.CreateRestaurantResource;
import com.example.EasyFood.Restaurants.interfaces.rest.resources.RestaurantResource;
import com.example.EasyFood.Restaurants.interfaces.rest.transform.CreateRestaurantCommandFromResourceAssembler;
import com.example.EasyFood.Restaurants.interfaces.rest.transform.RestaurantResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name= "Restaurant", description = "Restaurants management endpoints")
public class RestaurantController {
    private final RestaurantQueryService restaurantQueryService;
    private final RestaurantCommandService restaurantCommandService;

    public RestaurantController(RestaurantQueryService restaurantQueryService, RestaurantCommandService restaurantCommandService) {
        this.restaurantQueryService = restaurantQueryService;
        this.restaurantCommandService = restaurantCommandService;
    }
    @GetMapping()
    public ResponseEntity<List<RestaurantResource>> getAllRestaurants() {
        var getAllRestaurantsQuery = new GetAllRestaurantsQuery();
        var restaurants = restaurantQueryService.handle(getAllRestaurantsQuery);
        if (restaurants.isEmpty()) {return ResponseEntity.badRequest().build();}

        var restaurantsResource = restaurants.stream()
                .map(RestaurantResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(restaurantsResource);
    }
    @PostMapping
    public ResponseEntity<RestaurantResource> createRestaurant(@RequestBody CreateRestaurantResource createRestaurantResource) {
        var createRestaurantCommand = CreateRestaurantCommandFromResourceAssembler.toCommandResource(createRestaurantResource);
        var restaurant = restaurantCommandService.handle(createRestaurantCommand);
        if(restaurant.isEmpty()) return ResponseEntity.badRequest().build();

        var restaurantResource = RestaurantResourceFromEntityAssembler.toResourceFromEntity(restaurant.get());
        return ResponseEntity.ok(restaurantResource);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResource> getRestaurantById(@PathVariable Long id) {
        var getRestaurantByIdQuery = new GetRestaurantByIdQuery(id);
        var restaurant = restaurantQueryService.handle(getRestaurantByIdQuery);
        if(restaurant.isEmpty()) return ResponseEntity.badRequest().build();
        var restaurantResource = RestaurantResourceFromEntityAssembler.toResourceFromEntity(restaurant.get());
        return ResponseEntity.ok(restaurantResource);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RestaurantResource> updateRestaurant(@PathVariable Long id, @RequestBody CreateRestaurantResource resource) {
        var updateRestaurantCommand = new UpdateRestaurantCommand(id, resource.name(), resource.address(), resource.email(), resource.schedule(), resource.phone());
        var restaurant = restaurantCommandService.handle(updateRestaurantCommand);
        if(restaurant.isEmpty()) return ResponseEntity.badRequest().build();

        var restaurantResource = RestaurantResourceFromEntityAssembler.toResourceFromEntity(restaurant.get());
        return ResponseEntity.ok(restaurantResource);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RestaurantResource>> getRestaurantByUserId(@PathVariable Long userId) {
        var getRestaurantByUserId = new GetRestaurantByUserIdQuery(userId);
        var restaurant = restaurantQueryService.handle(getRestaurantByUserId);
        var restaurantResources = restaurant.stream()
                .map(RestaurantResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(restaurantResources);
    }

}
