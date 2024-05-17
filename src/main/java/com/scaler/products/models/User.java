package com.scaler.products.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "ecomm_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "email_address", unique = true)
    private String email;
}
