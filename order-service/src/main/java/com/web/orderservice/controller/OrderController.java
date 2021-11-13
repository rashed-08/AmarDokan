package com.web.orderservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.orderservice.client.InventoryClient;
import com.web.orderservice.dto.OrderDTO;
import com.web.orderservice.model.Order;
import com.web.orderservice.repository.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/v1/order")

public class OrderController {

	@Autowired
	private OrderRepository repository;
	@Autowired
	private InventoryClient inventoryClient;
	@Autowired
	private StreamBridge streamBridge;

	@PostMapping
	@CircuitBreaker(name = "orderService", fallbackMethod = "handleErrorCase")
	public String placeOrder(@RequestBody OrderDTO dto) {
		boolean allProductInStock = dto.getOrderLineItems().stream().allMatch(orderLineItems -> inventoryClient.checkStock(orderLineItems.getSkuCode()));
		if (allProductInStock) {
			Order order = new Order();
			order.setOrderLineItems(dto.getOrderLineItems());
			order.setOrderNumber(UUID.randomUUID().toString());
			repository.save(order);
			
			streamBridge.send("notificationEventSupplier-out-0", order.getId());
			
			return "Order place successfully.";
		} else {
			return "Order failed, One of the product is the order is not in stock.";
		}
	}

	public String handleErrorCase(OrderDTO dto, RuntimeException e) {
		return "Place order fallback method.";
	}

}
