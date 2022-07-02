package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "orderitems")
public class OrderItem {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


	@Column(name = "product_name")
    private String productName;
	
    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;


    @Column(name = "created_date")
    private Date createdDate;
    
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Products product;
    
    public OrderItem(){}

    public OrderItem(Order order, Products product, int quantity, int price) {
        this.product = product;
        this.productName = product.getName();
        this.quantity = quantity;
        this.price = price;
        this.order= order;
        this.createdDate = new Date();
    }
}
