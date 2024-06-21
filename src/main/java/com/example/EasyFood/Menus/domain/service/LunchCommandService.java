package com.example.EasyFood.Menus.domain.service;

import com.example.EasyFood.Menus.domain.model.aggregates.Lunch;
import com.example.EasyFood.Menus.domain.model.commands.CreateLunchCommand;
import com.example.EasyFood.Menus.domain.model.commands.DeleteLunchCommand;
import com.example.EasyFood.Menus.domain.model.commands.UpdateLunchCommand;

import java.util.Optional;

public interface LunchCommandService {
    Optional<Lunch> handle(CreateLunchCommand command);
    Optional<Lunch> handle(UpdateLunchCommand command);
    void deleteLunch(DeleteLunchCommand command);
}
