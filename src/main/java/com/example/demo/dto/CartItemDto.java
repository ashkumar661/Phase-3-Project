package com.example.demo.dto;

import com.example.demo.model.Cart;
import com.example.demo.model.Products;

import lombok.Data;

@Data
public class CartItemDto {
	private int id;
    private int quantity;
    private Products product;
    private String productName;
    
    public CartItemDto() {
    }

    public CartItemDto(Cart cart) {
        this.setId(cart.getId());
        this.setQuantity(cart.getQuantity());
        this.setProduct(cart.getProduct());
        this.setProductName(cart.getProductName());
    }
}
