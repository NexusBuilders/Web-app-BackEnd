package com.example.EasyFood.iam.infraestructure.persistence.jpa.repositories;

import com.example.EasyFood.iam.domain.model.entities.Role;
import com.example.EasyFood.iam.domain.model.valueobjects.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
}
