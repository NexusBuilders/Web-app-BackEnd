package com.example.EasyFood.Customers.infraestructure.persistence.jpa;

import com.example.EasyFood.Customers.domain.model.aggregates.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findCustomerById(Long id);
}
