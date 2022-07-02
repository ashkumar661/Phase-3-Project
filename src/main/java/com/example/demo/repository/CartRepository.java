package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.model.Cart;
import com.example.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
    
    @Transactional
    List<Cart> deleteByUser(User user);
    
}
