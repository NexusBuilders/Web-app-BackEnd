package com.example.EasyFood.iam.interfaces.rest.resources;

import com.example.EasyFood.iam.domain.model.valueobjects.Roles;

import java.util.List;

public record UserResource(Long id, String username, List<Roles> roles) {
}
