package com.tek.interview.question;


/*
 * represents an order line which contains the @link Item and the quantity.
 *
 */


public class OrderLine {
	
	/*
	 * @param item Item of the order
	 * 
	 * @param quantity Quantity of the item
	 */
	
	private int quantity;
	private Item item;
	
	public OrderLine(int quantity, Item item) throws Exception{
		this.quantity = quantity;
		this.item = item;
		
		if(this.item == null){
			System.err.println("ERROR - Item is NULL");
			throw new Exception("Item is NULL");
		}
		assert quantity > 0;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public Item getItem(){
		return item;
	}
}
