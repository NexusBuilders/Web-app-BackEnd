package com.example.EasyFood.easyfood.infrastructure.persistence.jpa;

import com.example.EasyFood.easyfood.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
