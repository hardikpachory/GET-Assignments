package assignment_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cart {
	Map<Item, Integer> myCart;
	
	public Cart() {
		super();
		myCart = new HashMap<Item, Integer>(); // Initializing the Cart
	}

	void addToCart(Item item, Integer quantity) {
		if(!myCart.containsKey(item)) { // Checking if an item exists in the cart or not
		myCart.put(item, quantity);
		System.out.println("Item Added: " + item);
		}
		else {
			System.out.println("Item already exists.");
		}
	}
	
	Integer displayQty(Item item) {
		if(!myCart.containsKey(item)) { // Checking if an item exists in the cart or not
			return -1;
		}
		return myCart.get(item);
	}
	
	void updateQty(Item item, Integer quantity) {
		if(myCart.replace(item, quantity)!=null) { // Checking if an item exists in the cart or not
			System.out.println("Updated Item: " + item);
		}
		else System.out.println("Item not found. Item Inserted: " + item);
	}
	
	void deleteItem(Item item) {
		if(myCart.containsKey(item)) { // Checking if an item exists in the cart or not
			System.out.println("Item Removed: " + item);
			myCart.remove(item);
		}
		else System.out.println("Item Not Found.");
	}
	
	double displayBill() {
		double total = 0;
		if(myCart.size()==0)
			return total;
		for(Entry<Item, Integer> entry : myCart.entrySet()) { //Iterating through Entry Set of the map
			total += (entry.getKey().getItemPrice() * entry.getValue());
		}
		return total;
	}
	
}
