package com.example.demo.dto;

import lombok.Data;

@Data
public class OrderItemsDto {
	
	private int price;
    private int quantity;
    private int orderId;
    private int productId;

    public OrderItemsDto () {}

    public OrderItemsDto(int price, int quantity, int orderId, int productId) {
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
    }
}
