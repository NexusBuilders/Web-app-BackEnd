package com.example.EasyFood.iam.interfaces.rest.transform;

import com.example.EasyFood.iam.domain.model.aggregates.User;
import com.example.EasyFood.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {

    public static AuthenticatedUserResource toResourceFromEntity(User entity, String token){
        return new AuthenticatedUserResource(entity.getId(), entity.getUsername(), token);
    }
}