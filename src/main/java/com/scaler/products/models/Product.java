package com.scaler.products.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(length = 1255)
    private String description;
    private Double price;
    private String image;
    private String category;

}
