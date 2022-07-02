package com.example.demo.dto;

import com.example.demo.model.Products;

import lombok.Data;

@Data
public class ProductDto {

    private Integer id;
    private String name;
    private int price;

    public ProductDto(Products product) {
        this.setId(product.getId());
        this.setName(product.getName());
        this.setPrice(product.getPrice());
    }

    public ProductDto(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
