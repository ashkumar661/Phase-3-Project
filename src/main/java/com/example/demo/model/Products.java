package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.dto.ProductDto;

import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Cart> carts;

    public Products() {
    }
    
    public Products(int id,String name) {
    	this.id=id;
    	this.name = name;
    }

    public Products(ProductDto productDto) {
        this.name = productDto.getName();
        this.price = productDto.getPrice();
    }
}
