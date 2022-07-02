package com.example.demo.dto;

import com.example.demo.model.Order;

import lombok.Data;

@Data
public class OrderDto {
	private int id;
    private int userId;
    
    public OrderDto(Order order) {
        this.setId(order.getId());
    }
}
