package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemsService {
	
	@Autowired
    private OrderItemsRepository orderItemsRepository;

    public void addOrderedProducts(OrderItem orderItem) {
        orderItemsRepository.save(orderItem);
    }
    
    public List<OrderItem> listOrders(Order order) {
		List<OrderItem> orderList = orderItemsRepository.findAllByOrderId(order);
		return orderList;
	}
}
