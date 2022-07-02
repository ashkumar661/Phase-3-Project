package com.example.demo.service;

import java.util.List;
import java.util.logging.Logger;

import com.example.demo.model.Cart;
import com.example.demo.model.Products;
import com.example.demo.model.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportyShoeDAO {
	Logger log = Logger.getAnonymousLogger();

	@Autowired
	ProductRepository productRepo;
	@Autowired
	CartRepository cartRepo;
	@Autowired
	UserRepository userRepo;
	
	
	public User findbyuser(String userName) {
		return userRepo.findByUser(userName);
	}
	
	public User findbypassword(String userPassword) {
		return userRepo.findByPassword(userPassword);
	}
	
	public int getUserID(String userName) {
		return userRepo.findByUserName(userName);
	}
	
	
	public User registerUser(User pojo) {
		return userRepo.save(pojo);
	}
	
	public List<User> listofUsers(){
		return userRepo.findAllUsers();
	}
	
	public List<Products> getAll(){
		log.info("Inside getAll()");
		return productRepo.findAll();
	}
	
	
	public List<Products> getByProductID(int productType){
		return productRepo.findByProductID(productType);
	}
	
	public Products addproduct(Products addProduct) {
		return productRepo.save(addProduct);
	}
	
	public Cart addtoCart(Cart addProduct) {
		return cartRepo.save(addProduct);
	}
	
}
