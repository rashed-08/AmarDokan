package com.web.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.web.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
