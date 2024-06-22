package com.example.EasyFood.iam.interfaces.rest.transform;

import com.example.EasyFood.iam.domain.model.commands.SignUpCommand;
import com.example.EasyFood.iam.domain.model.entities.Role;
import com.example.EasyFood.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {

    public static SignUpCommand toCommandFromResource(final SignUpResource resource) {
        var roles = resource.roles().stream().map(Role::toRoleFromName).toList();
        return new SignUpCommand(resource.username(), resource.password(), roles);
    }
}
