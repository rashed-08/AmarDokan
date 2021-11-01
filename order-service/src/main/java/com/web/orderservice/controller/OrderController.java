package com.web.orderservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.orderservice.client.InventoryClient;
import com.web.orderservice.dto.OrderDTO;
import com.web.orderservice.model.Order;
import com.web.orderservice.repository.OrderRepository;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

	@Autowired
	private OrderRepository repository;
	@Autowired
	private InventoryClient inventoryClient;
	
	@GetMapping
	public String testHome() {
		return "return from order service";
	}
	
	@PostMapping
	public String placeOrder(@RequestBody OrderDTO dto) {
		boolean allProductInStock = dto.getOrderLineItems().stream().allMatch(orderLineItems -> inventoryClient.checkStock(orderLineItems.getSkuCode()));
		System.out.println("Working");
		if (allProductInStock) {
			Order order = new Order();
			order.setOrderLineItems(dto.getOrderLineItems());
			order.setOrderNumber(UUID.randomUUID().toString());
			
			repository.save(order);
			return "Order place successfully.";
		} else {
			return "Order failed, One of the product is the order is not in stock.";
		}
	}
}
