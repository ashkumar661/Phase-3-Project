package com.example.demo.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.demo.dto.AddToCartDto;
import com.example.demo.dto.CartDto;
import com.example.demo.model.Cart;
import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.model.Products;
import com.example.demo.model.User;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderItemsService;
import com.example.demo.service.OrderService;
import com.example.demo.service.SportyShoeDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SportyShoeController {
	@Autowired
	SportyShoeDAO dao;
	@Autowired
	private CartService cartService;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderItemsService orderItemService;

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		String userName = req.getParameter("username");
		String userPassword = req.getParameter("password");
		if (dao.findbyuser(userName).equals(dao.findbypassword(userPassword))) {
			int id = dao.getUserID(req.getParameter("username"));
			HttpSession session = req.getSession();
			session.setAttribute("userName", userName);
			session.setAttribute("ID", id);
			if (id == 4) {
				mv.setViewName("dashboard.jsp");
				return mv;
			} else {
				List<Products> list = dao.getAll();
				req.setAttribute("list", list);
				mv.setViewName("userdashboard.jsp");
				return mv;
			}
		} else {
			mv.setViewName("loginError.jsp");
			return mv;
		}
	}

	// Dashboard page for Users
	@RequestMapping("/userdashboard")
	public ModelAndView userDashboard(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		List<Products> list = dao.getAll();
		req.setAttribute("list", list);
		mv.setViewName("userdashboard.jsp");
		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView registerUser(HttpServletRequest req, HttpServletResponse res) {
		String userFirstName = req.getParameter("fname");
		String userLastName = req.getParameter("lname");
		String userEmail = req.getParameter("useremail");
		String userName = req.getParameter("username");
		String userPassword = req.getParameter("password");
		ModelAndView mv = new ModelAndView();
		User pojo = new User();
		pojo.setFirstName(userFirstName);
		pojo.setLastName(userLastName);
		pojo.setEmail(userEmail);
		pojo.setUserName(userName);
		pojo.setPassword(userPassword);
		User pJ = dao.registerUser(pojo);
		if (pJ != null) {
			mv.setViewName("registerSuccess.jsp");
		}
		return mv;
	}

	@RequestMapping("/getproductlist")
	public ModelAndView getProductList(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		List<Products> list = dao.getAll();
		req.setAttribute("list", list);
		mv.setViewName("listProducts.jsp");
		return mv;
	}

	// Displaying the selected product details to another page
	@RequestMapping("/productTypeSelection")
	public ModelAndView showProduct(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(req.getParameter("id"));
		List<Products> list = dao.getByProductID(id);
		req.setAttribute("list", list);
		mv.setViewName("selectedProduct.jsp");
		return mv;
	}

	// Add item to the cart
	@RequestMapping("/addtocart")
	public ModelAndView addToCart(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		int productID = Integer.parseInt(req.getParameter("productID"));
		String productname = req.getParameter("productName");
		Products product = new Products();
		product.setId(productID);
		product.setName(productname);
		int price = Integer.parseInt(req.getParameter("productPrice"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		int total = quantity * price;
		AddToCartDto addToCartDto = new AddToCartDto(productID, quantity, total);
		User user = new User();
		user.setId((int) session.getAttribute("ID"));
		ModelAndView mv = new ModelAndView();
		cartService.addToCart(addToCartDto, product, user);
		mv.setViewName("/userdashboard");
		return mv;
	}

	// List items in the cart
	@RequestMapping("/listcart")
	public ModelAndView getCartItems(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		ModelAndView mv = new ModelAndView();
		User user = new User();
		user.setId((int) session.getAttribute("ID"));
		CartDto cartDto = cartService.listCartItems(user);
		List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);
		int totalCost = cartDto.getTotalCost();
		req.setAttribute("list", cartList);
		req.setAttribute("totalCost", totalCost);
		mv.setViewName("cart.jsp");
		return mv;

	}

	// place order after checkout
	@RequestMapping("/purchaseOrder")
	public ModelAndView placeOrder(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		// retrieve user
		ModelAndView mv = new ModelAndView();
		User user = new User();
		user.setId((int) session.getAttribute("ID"));
		// place the order
		orderService.placeOrder(user);
		mv.setViewName("orderSuccess.jsp");
		return mv;
	}

	// get all orders of User
	@RequestMapping("/listPurchaseOrder")
	public ModelAndView getAllOrders(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = req.getSession();
		// retrieve user
		int id = (int) session.getAttribute("ID");
		// get orders
		List<Order> orderDtoList = orderService.listOrders(id);
		req.setAttribute("orderDtoList", orderDtoList);
		mv.setViewName("userOrderList.jsp");
		return mv;
	}

	// get orderitems for an order
	@RequestMapping("/getOrderItems{id}")
	public ModelAndView getOrderById(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		int id = Integer.parseInt(req.getParameter("id"));
		Order order = new Order();
		order.setId(id);
		List<OrderItem> orderItemList = orderItemService.listOrders(order);
		req.setAttribute("orderItemList", orderItemList);
		mv.setViewName("orderDetails.jsp");
		return mv;
	}

	// Admin access - listing signed-up users
	@RequestMapping("/listusers")
	public ModelAndView listUsers(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		List<User> list = dao.listofUsers();
		req.setAttribute("list", list);
		mv.setViewName("listofusers.jsp");
		return mv;
	}

	// Admin access - Add a product
	@RequestMapping("/adminAddProduct")
	public ModelAndView addProduct(HttpServletRequest req, HttpServletResponse res) {
		String productName = req.getParameter("productName");
		String price = req.getParameter("productPrice");
		int productPrice = Integer.parseInt(price);
		Products product = new Products();
		product.setName(productName);
		product.setPrice(productPrice);
		Products pro = dao.addproduct(product);
		ModelAndView mv = new ModelAndView();
		if (pro != null) {
			mv.setViewName("manageProducts.jsp");
		}
		return mv;
	}

	// Admin access- Get all purchased order
	@RequestMapping("/listAllPurchaseOrder")
	public ModelAndView getAllPurchaseOrders(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		// get orders
		List<Order> allOrderList = orderService.listAllOrders();
		req.setAttribute("allOrderList", allOrderList);
		mv.setViewName("adminPurchaseReport.jsp");
		return mv;
	}
}
