package com.example.EasyFood.iam.application.internal.queryservices;

import com.example.EasyFood.iam.domain.model.entities.Role;
import com.example.EasyFood.iam.domain.model.queries.GetAllRolesQuery;
import com.example.EasyFood.iam.domain.model.queries.GetRoleByNameQuery;
import com.example.EasyFood.iam.domain.services.RoleQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleQueryServicesImpl implements RoleQueryService {

    @Override
    public List<Role> handle(GetAllRolesQuery query) {
        return List.of();
    }

    @Override
    public Optional<Role> handle(GetRoleByNameQuery query) {
        return Optional.empty();
    }
}