package com.example.EasyFood.iam.infraestructure.persistence.jpa.repositories;

import com.example.EasyFood.iam.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
