package com.example.EasyFood.Menus.interfaces.rest;
import com.example.EasyFood.Menus.domain.model.commands.DeleteDrinkCommand;
import com.example.EasyFood.Menus.domain.model.commands.UpdateDrinkCommand;
import com.example.EasyFood.Menus.domain.model.commands.UpdateLunchCommand;
import com.example.EasyFood.Menus.domain.model.queries.GetDrinkByIdQuery;
import com.example.EasyFood.Menus.domain.model.queries.GetDrinksByRestaurantId;
import com.example.EasyFood.Menus.domain.service.DrinkCommandService;
import com.example.EasyFood.Menus.domain.service.DrinkQueryService;
import com.example.EasyFood.Menus.interfaces.rest.resources.CreateDrinkResource;
import com.example.EasyFood.Menus.interfaces.rest.resources.CreateLunchResource;
import com.example.EasyFood.Menus.interfaces.rest.resources.DrinkResource;
import com.example.EasyFood.Menus.interfaces.rest.resources.LunchResource;
import com.example.EasyFood.Menus.interfaces.rest.transform.CreateDrinkCommandFromResourceAssembler;
import com.example.EasyFood.Menus.interfaces.rest.transform.DrinkResourceFromEntityAssembler;
import com.example.EasyFood.Menus.interfaces.rest.transform.LunchResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/drinks", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name= "Drink", description = "Drinks management endpoints")
public class DrinkController {
    private final DrinkQueryService drinkQueryService;
    private final DrinkCommandService drinkCommandService;

    public DrinkController(DrinkQueryService drinkQueryService, DrinkCommandService drinkCommandService) {
        this.drinkQueryService = drinkQueryService;
        this.drinkCommandService = drinkCommandService;
    }
    @PostMapping
    public ResponseEntity<DrinkResource> createDrink(@RequestBody CreateDrinkResource createDrinkResource) {
        var createDrinkCommand = CreateDrinkCommandFromResourceAssembler.toCommandResource(createDrinkResource);
        var drink = drinkCommandService.handle(createDrinkCommand);
        if(drink.isEmpty()) return ResponseEntity.badRequest().build();

        var drinkResource = DrinkResourceFromEntityAssembler.toResourceFromEntity(drink.get());
        return ResponseEntity.ok(drinkResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DrinkResource> getDrinkById(@PathVariable Long id) {
        var getDrinkByIdQuery = new GetDrinkByIdQuery(id);
        var drink = drinkQueryService.handle(getDrinkByIdQuery);
        if(drink.isEmpty()) return ResponseEntity.badRequest().build();
        var drinkResource = DrinkResourceFromEntityAssembler.toResourceFromEntity(drink.get());
        return ResponseEntity.ok(drinkResource);
    }
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<DrinkResource>> getDrinksByRestaurantId(@PathVariable Long restaurantId) {
        var getAllDrinksByIdRestaurant = new GetDrinksByRestaurantId(restaurantId);
        var drinks = drinkQueryService.handle(getAllDrinksByIdRestaurant);
        var drinkResources = drinks.stream()
                .map(DrinkResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(drinkResources);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DrinkResource> updateDrink(@PathVariable Long id, @RequestBody CreateDrinkResource resource) {
        var updateDrinkCommand = new UpdateDrinkCommand(id, resource.name(), resource.price(), resource.image());
        var drink = drinkCommandService.handle(updateDrinkCommand);
        if(drink.isEmpty()) return ResponseEntity.badRequest().build();

        var drinkResource = DrinkResourceFromEntityAssembler.toResourceFromEntity(drink.get());
        return ResponseEntity.ok(drinkResource);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrink(@PathVariable Long id) {
        var deleteDrinkCommand = new DeleteDrinkCommand(id);
        drinkCommandService.deleteDrink(deleteDrinkCommand);
        return ResponseEntity.noContent().build();
    }
}
