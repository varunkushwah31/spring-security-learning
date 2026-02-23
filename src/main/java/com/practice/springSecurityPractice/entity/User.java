package com.practice.springSecurityPractice.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;
    private String[] authorities;
    private String password;
}
