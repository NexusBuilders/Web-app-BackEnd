package com.example.EasyFood.iam.domain.services;

import com.example.EasyFood.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
