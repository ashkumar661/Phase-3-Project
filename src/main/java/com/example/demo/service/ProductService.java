package com.example.demo.service;

import java.util.*;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.Products;
import com.example.demo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> listProducts() {
        List<Products> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for(Products product : products) {
            ProductDto productDto = getDtoFromProduct(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public static ProductDto getDtoFromProduct(Products product) {
        ProductDto productDto = new ProductDto(product);
        return productDto;
    }

    public static Products getProductFromDto(ProductDto productDto) {
        Products product = new Products(productDto);
        return product;
    }

    public void addProduct(ProductDto productDto) {
        Products product = getProductFromDto(productDto);
        productRepository.save(product);
    }

    public void updateProduct(Integer productID, ProductDto productDto) {
        Products product = getProductFromDto(productDto);
        product.setId(productID);
        productRepository.save(product);
    }


    public Products getProductById(Integer productId) {
        Optional<Products> optionalProduct = productRepository.findById(productId);
        return optionalProduct.get();
    }
}
