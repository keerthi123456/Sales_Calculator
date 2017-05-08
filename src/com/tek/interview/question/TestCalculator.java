package com.tek.interview.question;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class TestCalculator {

	@Before
	public void setUp() throws Exception {
		System.out.println("unit test started >>>>>>>");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("unit test ended >>>>>>>>");
	}
	
	@Test
	public void test()throws Exception {
		
		Map<String, Order> orders = new TreeMap<String, Order>();
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order();
		
		// first null check for add method of order -- throws exception
		
		
		Map<String, Order> orders1 = new TreeMap<String, Order>();		
		order1.add(new OrderLine(1, new Item("book",(float) 12.49)));
		order1.add(new OrderLine(1, new Item("music CD", (float)14.99)));
		order1.add(new OrderLine(1, new Item("chocolate bar", (float)0.85)));	
		orders1.put("Order 1", order1);
		Calculator calc1 = new Calculator();
		calc1.calculate(orders1);
		assertEquals(28.33, Math.floor(calc1.sumOfOrders * 100) / 100, 0.0f);
		assertFalse(Math.floor(calc1.sumOfOrders * 100) / 100 == 0);
		
		
		Map<String, Order> orders2 = new TreeMap<String, Order>();		
		order2.add(new OrderLine(1, new Item("imported box of chocolate", (float)10)));
		order2.add(new OrderLine(1, new Item("imported bottle of perfume", (float)47.50)));
		orders2.put("Order 2", order2);
		
		Calculator calc2 = new Calculator();
		calc2.calculate(orders2);
		assertEquals(57.5,Math.floor(calc2.sumOfOrders * 100) / 100, 0.0f);
		
		

		// check if item is null ,exception thrown or not		
		try {
			Order ordr = new Order();
			ordr.add(new OrderLine(1,null));			
	        fail("expected exception was not occured.");
	    } catch(Exception e) {
	    	assertTrue(e instanceof Exception);
	    }
		
		// check if orderline is null, IllegalArgumentException thrown or not
		try {
			Order emptyOrder1 = new Order();
			OrderLine emptyOrderLine1 = null;
			emptyOrder1.add(emptyOrderLine1);
	    } catch(Exception e) {
	    	assertTrue(e instanceof IllegalArgumentException);
	    }
	}

}
