package com.web.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
