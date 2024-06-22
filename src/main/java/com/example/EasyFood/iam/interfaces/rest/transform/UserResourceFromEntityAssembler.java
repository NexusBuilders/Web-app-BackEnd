package com.example.EasyFood.iam.interfaces.rest.transform;

import com.example.EasyFood.iam.domain.model.aggregates.User;
import com.example.EasyFood.iam.domain.model.entities.Role;
import com.example.EasyFood.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity){
        var roles = entity.getRoles().stream().map(Role::getName).toList();
        return new UserResource(entity.getId(), entity.getUsername(), roles);
    }
}
