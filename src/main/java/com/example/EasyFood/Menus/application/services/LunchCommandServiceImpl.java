package com.example.EasyFood.Menus.application.services;

import com.example.EasyFood.Menus.domain.model.aggregates.Lunch;
import com.example.EasyFood.Menus.domain.model.commands.CreateLunchCommand;
import com.example.EasyFood.Menus.domain.model.commands.DeleteLunchCommand;
import com.example.EasyFood.Menus.domain.model.commands.UpdateLunchCommand;
import com.example.EasyFood.Menus.domain.service.LunchCommandService;
import com.example.EasyFood.Menus.infraestructure.persistence.jpa.LunchRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LunchCommandServiceImpl implements LunchCommandService {

    private final LunchRepository lunchRepository;

    public LunchCommandServiceImpl(LunchRepository lunchRepository) {
        this.lunchRepository = lunchRepository;
    }

    @Override
    public Optional<Lunch> handle(CreateLunchCommand command) {
        var lunch = new Lunch(command);
        lunchRepository.save(lunch);
        return Optional.of(lunch);
    }

    @Override
    public Optional<Lunch> handle(UpdateLunchCommand command) {
        var auxLunch = lunchRepository.findById(command.id());
        if (auxLunch.isPresent()) {
            Lunch lunch = auxLunch.get();
            lunch.setStarterPlate(command.starterPlate());
            lunch.setMainDish(command.mainDish());
            lunch.setPrice(command.price());
            lunch.setImage(command.image());
            lunchRepository.save(lunch);
            return Optional.of(lunch);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteLunch(DeleteLunchCommand command) {
        lunchRepository.deleteById(command.id());
    }


}
