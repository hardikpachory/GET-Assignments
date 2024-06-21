package assignment_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cart {
	Map<Item, Integer> myCart;
	
	public Cart() {
		super();
		myCart = new HashMap<Item, Integer>();
		// TODO Auto-generated constructor stub
	}

	void addToCart(Item item, Integer quantity) {
		myCart.put(item, quantity);
		System.out.println("Item Added!");
	}
	
	Integer displayQty(Item item) {
		return myCart.get(item);
	}
	
	void updateQty(Item item, Integer quantity) {
		if(myCart.replace(item, quantity)!=null) {
			System.out.println("Updated!");
		}
		else System.out.println("Itemnot found. Item Inserted");
	}
	
	Integer deleteItem(Item item) {
		if(myCart.containsKey(item)) {
			return myCart.get(item);
		}
		return -1;
	}
	
	double displayBill() {
		double total = 0;
		if(myCart.size()==0)
			return total;
		for(Entry<Item, Integer> entry : myCart.entrySet()) {
			total += (entry.getKey().getItemPrice() * entry.getValue());
		}
		return total;
	}
	
}
