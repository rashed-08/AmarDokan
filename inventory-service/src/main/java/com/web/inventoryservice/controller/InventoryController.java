package com.web.inventoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.inventoryservice.model.Inventory;
import com.web.inventoryservice.repository.InventoryRepository;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

	@Autowired
	private InventoryRepository repository;
	
	@GetMapping("/{skuCode}")
	public Boolean isInStock(@PathVariable String skuCode) {
		Inventory inventory = repository.findBySkuCode(skuCode));
	}
}
