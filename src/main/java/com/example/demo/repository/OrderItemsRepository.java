package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderItemsRepository extends JpaRepository<OrderItem, Integer>{
	
	@Query("select orderItem from OrderItem orderItem where orderItem.order=?1")
	List<OrderItem> findAllByOrderId(Order order);
}
