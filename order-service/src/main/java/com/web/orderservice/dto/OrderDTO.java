package com.web.orderservice.dto;

import java.util.List;

import com.web.orderservice.model.OrderLineItems;

public class OrderDTO {

	private List<OrderLineItems> orderLineItems;

	public OrderDTO() {
		// TODO Auto-generated constructor stub
	}

	public OrderDTO(List<OrderLineItems> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}

	public List<OrderLineItems> getOrderLineItems() {
		return orderLineItems;
	}

	public void setOrderLineItems(List<OrderLineItems> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderLineItems=" + orderLineItems + "]";
	}

}
