package com.example.EasyFood.easyfood.domain.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "Users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String  name;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String phone;
    private String address;
    private String userType;

    public User() {
    }
    public User(String name, String lastName, String email, String password, String phone, String address, String userType) {
        super();
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.userType = userType;

    }
}
