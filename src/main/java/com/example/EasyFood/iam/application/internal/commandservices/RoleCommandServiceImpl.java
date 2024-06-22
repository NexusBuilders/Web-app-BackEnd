package com.example.EasyFood.iam.application.internal.commandservices;

import com.example.EasyFood.iam.domain.model.commands.SeedRolesCommand;
import com.example.EasyFood.iam.domain.services.RoleCommandService;
import com.example.EasyFood.iam.infraestructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleCommandServiceImpl implements RoleCommandService {

    private final RoleRepository roleRepository;

    public RoleCommandServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void handle(SeedRolesCommand command) {

    }
}
