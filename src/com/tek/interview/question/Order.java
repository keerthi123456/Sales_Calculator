package com.tek.interview.question;

import java.util.ArrayList;
import java.util.List;

/*
 * Code for Order 
 */
class Order {

	private List<OrderLine> orderLines = new ArrayList<OrderLine>();

	public void add(OrderLine orderLine) throws Exception {
		if (orderLine == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		else {
			orderLines.add(orderLine);
		}
	}

	public int size() {
		return orderLines.size();
	}

	public OrderLine getOrderLine(int i) {
		return orderLines.get(i);
	}

	public void clear() {
		this.orderLines.clear();
	}
}

