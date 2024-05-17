package com.scaler.products.dtos;

import lombok.Data;

@Data
public class GetproductDto {
    private String name;
    private Double price;
    private String imageUrl;
}
