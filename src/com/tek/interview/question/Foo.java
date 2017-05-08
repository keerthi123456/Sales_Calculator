package com.tek.interview.question;

import java.util.Map;
import java.util.TreeMap;

public class Foo {
	
	public static void main(String[] args) throws Exception {
  		Map<String, Order> orders = new TreeMap<String, Order>();
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order();
		
		order1.add(new OrderLine(1, new Item("book",(float) 12.49)));
		order1.add(new OrderLine(1, new Item("music CD", (float)14.99)));
		order1.add(new OrderLine(1, new Item("chocolate bar", (float)0.85)));

		orders.put("Order 1", order1);

		// Reuse cart for an other order
		order2.add(new OrderLine(1, new Item("imported box of chocolate", (float)10)));
		order2.add(new OrderLine(1, new Item("imported bottle of perfume", (float)47.50)));
		orders.put("Order 2", order2);

		// Reuse cart for an other order
		order3.add(new OrderLine(1, new Item("Imported bottle of perfume", (float)27.99)));
		order3.add(new OrderLine(1, new Item("bottle of perfume", (float) 18.99)));
		order3.add(new OrderLine(1, new Item("packet of headache pills", (float) 9.75)));
		order3.add(new OrderLine(1, new Item("box of imported chocolates", (float) 11.25)));
		orders.put("Order 3", order3);
		
		new Calculator().calculate(orders);

	}
}
