package com.web.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

	@GetMapping("/api/v1/inventory/{skuCode}")
	Boolean checkStock(@PathVariable String skuCode);
}
