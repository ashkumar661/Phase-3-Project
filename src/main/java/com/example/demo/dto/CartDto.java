package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDto {
	private List<CartItemDto> cartItems;
    private int totalCost;
    
    public CartDto(List<CartItemDto> cartItemDtoList, int totalCost) {
        this.cartItems = cartItemDtoList;
        this.totalCost = totalCost;
    }
    
    public CartDto() {
    	
    }
}
