package com.scaler.products.models;


import lombok.Data;

@Data
public class Product {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String image;
    private String category;

}
