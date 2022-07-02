package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.dto.CartDto;
import com.example.demo.dto.CartItemDto;
import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.model.User;
import com.example.demo.repository.OrderItemsRepository;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CartService cartService;

	@Autowired
	OrderItemsRepository orderItemsRepository;

	public void placeOrder(User user) {
		// first let get cart items for the user
		CartDto cartDto = cartService.listCartItems(user);

		List<CartItemDto> cartItemDtoList = cartDto.getCartItems();

		// create the order and save it
		Order newOrder = new Order();
		newOrder.setCreatedDate(new Date());
		newOrder.setUser(user);
		newOrder.setTotalPrice(cartDto.getTotalCost());
		orderRepository.save(newOrder);

		for (CartItemDto cartItemDto : cartItemDtoList) {
			// create orderItem and save each one
			OrderItem orderItem = new OrderItem();
			orderItem.setCreatedDate(new Date());
			orderItem.setPrice(cartItemDto.getProduct().getPrice());
			orderItem.setProductName(cartItemDto.getProductName());
			orderItem.setProduct(cartItemDto.getProduct());
			orderItem.setQuantity(cartItemDto.getQuantity());
			orderItem.setOrder(newOrder);
			// add to order item list
			orderItemsRepository.save(orderItem);
		}
		cartService.deleteUserCartItems(user);
	}

	public List<Order> listOrders(int user) {
		List<Order> orderList = orderRepository.findAllByUserIdOrderByCreatedDateDesc(user);
		return orderList;
	}
	
	public List<Order> listAllOrders() {
		List<Order> orderList = orderRepository.findAll();
		return orderList;
	}

	public Order getOrder(Integer orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		return order.get();
	}

}
