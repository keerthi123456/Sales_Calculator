package com.tek.interview.question;

import java.math.BigDecimal;
import java.util.Map;
/**
 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
 * is the item's price * quantity * taxes.
 * 
 * For each order, print the total Sales Tax paid and Total price without taxes for this order
 */
public class Calculator {
	
	float sumOfOrders = 0.0f;
	
	 public static float round(float d, int decimalPlace) {
	        BigDecimal bd = new BigDecimal(Float.toString(d));
	        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
	        return bd.floatValue();
	    }
	
	public void calculate(Map<String, Order> orders){
		float grandTotal = 0;
		
		// Iterate through the orders
		for(Map.Entry<String, Order> entry : orders.entrySet()){
			System.out.println("*******" + entry.getKey() + "*******");
			
			Order order = entry.getValue();
			float totalTax = 0, total = 0;
			
			// Iterate through the items in the order
			for(int i=0; i<order.size(); i++){
				float itemPrice = order.getOrderLine(i).getItem().getPrice();
				String itemDesc = order.getOrderLine(i).getItem().getDescription();
				float tax = 0;
				if(null != itemDesc && itemDesc.contains("imported")){
					if(null != (Float)itemPrice){
						tax = round(itemPrice * 0.15f, 2);// Extra 5% tax on imported items
					}
					else
						System.out.println("ERROR - Item price is NULL");
				}
				else{
					tax = round(itemPrice * 0.10f, 2);
				}
				
				// Calculate the total price
				float totalPrice = round(itemPrice + tax, 2);
				
				// Print out the item's total price
				System.out.println(order.getOrderLine(i).getQuantity()+" "+ itemDesc + ": " + totalPrice);

				// Keep a running total
				totalTax += tax;
				total += itemPrice;
			}
			// Print out the total taxes
			System.out.println("Sales Tax: " +totalTax);

			// Print out the total amount
			System.out.println("Total: " + Math.floor(total * 100) / 100);
			grandTotal += total;
			sumOfOrders += grandTotal;
		}
		System.out.println("Sum of orders: " + Math.floor(sumOfOrders * 100) / 100);
	}
}
