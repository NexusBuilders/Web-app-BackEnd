package com.example.EasyFood.iam.interfaces.rest.transform;

import com.example.EasyFood.iam.domain.model.commands.SignInCommand;
import com.example.EasyFood.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {

    public static SignInCommand toCommandFromResource(final SignInResource resource) {
        return new SignInCommand(resource.username(), resource.password());
    }
}
