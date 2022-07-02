package com.example.demo.dto;

import lombok.Data;

@Data
public class AddToCartDto {
    private int id;
    private int productId;
    private int quantity;
    private int totalPrice;

    public AddToCartDto() {
    }
    
    public AddToCartDto(int productId, int quantity, int total) {
    	this.productId = productId;
    	this.totalPrice = total;
    	this.quantity = quantity;
    }
}
