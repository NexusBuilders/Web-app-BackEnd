package com.example.EasyFood.Menus.interfaces.rest;

import com.example.EasyFood.Menus.domain.model.commands.DeleteDrinkCommand;
import com.example.EasyFood.Menus.domain.model.commands.DeleteLunchCommand;
import com.example.EasyFood.Menus.domain.model.commands.UpdateLunchCommand;
import com.example.EasyFood.Menus.domain.model.queries.GetDrinksByRestaurantId;
import com.example.EasyFood.Menus.domain.model.queries.GetLunchByIdQuery;
import com.example.EasyFood.Menus.domain.model.queries.GetLunchesByRestaurantId;
import com.example.EasyFood.Menus.domain.service.LunchCommandService;
import com.example.EasyFood.Menus.domain.service.LunchQueryService;
import com.example.EasyFood.Menus.interfaces.rest.resources.CreateLunchResource;
import com.example.EasyFood.Menus.interfaces.rest.resources.DrinkResource;
import com.example.EasyFood.Menus.interfaces.rest.resources.LunchResource;
import com.example.EasyFood.Menus.interfaces.rest.transform.CreateLunchCommandFromResourceAssembler;
import com.example.EasyFood.Menus.interfaces.rest.transform.DrinkResourceFromEntityAssembler;
import com.example.EasyFood.Menus.interfaces.rest.transform.LunchResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/lunches", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name= "Lunch", description = "Lunches management endpoints")
public class LunchController {
    private final LunchQueryService lunchQueryService;
    private final LunchCommandService lunchCommandService;

    public LunchController(LunchQueryService lunchQueryService, LunchCommandService lunchCommandService) {
        this.lunchQueryService = lunchQueryService;
        this.lunchCommandService = lunchCommandService;
    }


    @PostMapping
    public ResponseEntity<LunchResource> createLunch(@RequestBody CreateLunchResource createLunchResource) {
        var createLunchCommand = CreateLunchCommandFromResourceAssembler.toCommandResource(createLunchResource);
        var lunch = lunchCommandService.handle(createLunchCommand);
        if(lunch.isEmpty()) return ResponseEntity.badRequest().build();

        var lunchResource = LunchResourceFromEntityAssembler.toResourceFromEntity(lunch.get());
        return ResponseEntity.ok(lunchResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LunchResource> getLunchById(@PathVariable Long id) {
        var getLunchByIdQuery = new GetLunchByIdQuery(id);
        var lunch = lunchQueryService.handle(getLunchByIdQuery);
        if(lunch.isEmpty()) return ResponseEntity.badRequest().build();
        var lunchResource = LunchResourceFromEntityAssembler.toResourceFromEntity(lunch.get());
        return ResponseEntity.ok(lunchResource);
    }
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<LunchResource>> getLunchesByRestaurantId(@PathVariable Long restaurantId) {
        var getAllLunchesByIdRestaurant = new GetLunchesByRestaurantId(restaurantId);
        var lunches = lunchQueryService.handle(getAllLunchesByIdRestaurant);
        var lunchesResources = lunches.stream()
                .map(LunchResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(lunchesResources);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LunchResource> updateLunch(@PathVariable Long id, @RequestBody CreateLunchResource resource) {
        var updateLunchCommand = new UpdateLunchCommand(id, resource.starterPlate(), resource.mainDish(), resource.price(), resource.image());
        var lunch = lunchCommandService.handle(updateLunchCommand);
        if(lunch.isEmpty()) return ResponseEntity.badRequest().build();

        var lunchResource = LunchResourceFromEntityAssembler.toResourceFromEntity(lunch.get());
        return ResponseEntity.ok(lunchResource);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLunch(@PathVariable Long id) {
        var deleteLunchCommand = new DeleteLunchCommand(id);
        lunchCommandService.deleteLunch(deleteLunchCommand);
        return ResponseEntity.noContent().build();
    }
}
