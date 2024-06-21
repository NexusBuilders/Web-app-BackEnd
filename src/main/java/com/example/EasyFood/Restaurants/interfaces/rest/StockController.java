package com.example.EasyFood.Restaurants.interfaces.rest;

import com.example.EasyFood.Restaurants.domain.model.commands.DeleteStockCommand;
import com.example.EasyFood.Restaurants.domain.model.commands.UpdateRestaurantCommand;
import com.example.EasyFood.Restaurants.domain.model.commands.UpdateStockCommand;
import com.example.EasyFood.Restaurants.domain.model.queries.GetAllStocksByIdRestaurantQuery;
import com.example.EasyFood.Restaurants.domain.model.queries.GetStockByIdQuery;
import com.example.EasyFood.Restaurants.domain.service.StockCommandService;
import com.example.EasyFood.Restaurants.domain.service.StockQueryService;
import com.example.EasyFood.Restaurants.interfaces.rest.resources.CreateRestaurantResource;
import com.example.EasyFood.Restaurants.interfaces.rest.resources.CreateStockResource;
import com.example.EasyFood.Restaurants.interfaces.rest.resources.RestaurantResource;
import com.example.EasyFood.Restaurants.interfaces.rest.resources.StockResource;
import com.example.EasyFood.Restaurants.interfaces.rest.transform.CreateStockCommandFromResourceAssembler;
import com.example.EasyFood.Restaurants.interfaces.rest.transform.RestaurantResourceFromEntityAssembler;
import com.example.EasyFood.Restaurants.interfaces.rest.transform.StockResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/stocks", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name= "Stock", description = "Stocks management endpoints")
public class StockController {
    private final StockQueryService stockQueryService;
    private final StockCommandService stockCommandService;

    public StockController(StockQueryService stockQueryService, StockCommandService stockCommandService) {
        this.stockQueryService = stockQueryService;
        this.stockCommandService = stockCommandService;
    }
    @PostMapping
    public ResponseEntity<StockResource> createStock(@RequestBody CreateStockResource createStockResource) {
        var createStockCommand = CreateStockCommandFromResourceAssembler.toCommandResource(createStockResource);
        var stock = stockCommandService.handle(createStockCommand);
        if(stock.isEmpty()) return ResponseEntity.badRequest().build();

        var stockResource = StockResourceFromEntityAssembler.toResourceFromEntity(stock.get());
        return ResponseEntity.ok(stockResource);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StockResource> getStockById(@PathVariable Long id) {
        var getStockByIdQuery = new GetStockByIdQuery(id);
        var stock = stockQueryService.handle(getStockByIdQuery);
        if(stock.isEmpty()) return ResponseEntity.badRequest().build();
        var stockResource = StockResourceFromEntityAssembler.toResourceFromEntity(stock.get());
        return ResponseEntity.ok(stockResource);
    }
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<StockResource>> getAllStocksByRestaurantId(@PathVariable Long restaurantId) {
        var getAllStockByIdRestaurant = new GetAllStocksByIdRestaurantQuery(restaurantId);
        var stocks = stockQueryService.handle(getAllStockByIdRestaurant);
        var stockResources = stocks.stream()
                .map(StockResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(stockResources);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StockResource> updateStock(@PathVariable Long id, @RequestBody CreateStockResource resource) {
        var updateStockCommand = new UpdateStockCommand(id, resource.name(), resource.quantity(), resource.unity());
        var stock = stockCommandService.handle(updateStockCommand);
        if(stock.isEmpty()) return ResponseEntity.badRequest().build();

        var stockResource = StockResourceFromEntityAssembler.toResourceFromEntity(stock.get());
        return ResponseEntity.ok(stockResource);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        var deleteStockCommand = new DeleteStockCommand(id);
        stockCommandService.deleteStock(deleteStockCommand);
        return ResponseEntity.noContent().build();
    }
}
