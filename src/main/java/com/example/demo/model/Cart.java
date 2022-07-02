package com.example.demo.model;

import java.util.Date;

import javax.persistence.*;

import com.example.demo.dto.AddToCartDto;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Entity
@Data
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date createdDate;
	private String productName;
	private int quantity;
	private int total;

	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Products product;

	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private User user;

    public Cart() { }
    
    public Cart(User user) { 
    	this.user=user;
    }

    public Cart(Products product, String name, int quantity,int total, User user){
        this.user = user;
        this.product = product;
        this.productName = name;
        this.quantity = quantity;
        this.total = total;
        this.createdDate= new Date();
    }
	

}
