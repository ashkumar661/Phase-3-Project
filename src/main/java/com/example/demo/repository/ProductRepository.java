package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Products, Integer> {
	
	@Query("select product from Products product where product.id=?1")
	List<Products> findByProductID(int productType);
}
