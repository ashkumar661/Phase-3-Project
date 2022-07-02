package com.example.demo.service;

import com.example.demo.repository.CartRepository;
import com.example.demo.dto.*;

import java.util.List;
import java.util.ArrayList;
import com.example.demo.model.Cart;
import com.example.demo.model.Products;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	public CartService() {
	}

	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	public void addToCart(AddToCartDto addToCartDto, Products product, User user) {
		Cart cart = new Cart(product, product.getName(), addToCartDto.getQuantity(), addToCartDto.getTotalPrice(),
				user);
		cartRepository.save(cart);
	}

	public CartDto listCartItems(User user) {
		List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
		List<CartItemDto> cartItems = new ArrayList<>();
		for (Cart cart : cartList) {
			CartItemDto cartItemDto = getDtoFromCart(cart);
			cartItems.add(cartItemDto);
		}
		int totalCost = 0;
		for (CartItemDto cartItemDto : cartItems) {
			totalCost += (cartItemDto.getProduct().getPrice() * cartItemDto.getQuantity());
		}
		return new CartDto(cartItems, totalCost);
	}

	public static CartItemDto getDtoFromCart(Cart cart) {
		return new CartItemDto(cart);
	}


	public void deleteCartItems(int userId) {
		cartRepository.deleteAll();
	}

	public void deleteUserCartItems(User user) {
		cartRepository.deleteByUser(user);

	}

}
