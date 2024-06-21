package assignment_1;

import java.util.UUID;

public class Item {
	private String itemId;
	private String itemName;
	private String itemDesc;
	private double itemPrice;
	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String itemName, String itemDesc, double itemPrice) {
		super();
		this.itemId = UUID.randomUUID().toString();
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
	}
	
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
}
