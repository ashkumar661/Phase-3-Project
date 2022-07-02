package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Order;
import com.example.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	
	List<Order> findAllByUserIdOrderByCreatedDateDesc(int id);
}
