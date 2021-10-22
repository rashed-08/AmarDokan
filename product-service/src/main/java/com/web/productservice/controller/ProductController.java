package com.web.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.web.productservice.model.Product;
import com.web.productservice.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductRepository repository;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getAllProduct() {
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody Product product) {
		repository.save(product);
	}
}
