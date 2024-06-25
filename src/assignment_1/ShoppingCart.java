package assignment_1;

public class ShoppingCart {

	public static void main(String[] args) {
		/*  Creating Object  */
		Cart cart = new Cart();
		
		/*  Creating items to add to our Cart  */
		Item i1 = new Item("Item 1", "Item 1 Desc", 45.23);
		Item i2 = new Item("Item 2", "Item 2 Desc", 55.23);
		Item i3 = new Item("Item 3", "Item 3 Desc", 65.23);
		
		/*  Displaying Current Total  */
		System.out.println("Total Bill: " + cart.displayBill());
		
		/*  Adding items it our Cart  */
		cart.addToCart(i1, 100);
		cart.addToCart(i2, 150);
		cart.addToCart(i3, 200);
		
		/*  Displaying Current Total  */
		System.out.println("Total Bill: " + cart.displayBill());
		
		/*  Displaying the quantity of different items  */
		System.out.println(i1.getItemName() + " | Quantity: "+ cart.displayQty(i1));
		System.out.println(i2.getItemName() + " | Quantity: "+ cart.displayQty(i2));
		System.out.println(i3.getItemName() + " | Quantity: "+ cart.displayQty(i3));
		
		/*  Updating our cart  */
		cart.updateQty(i1, 10);
		cart.updateQty(i2, 15);
		cart.updateQty(i3, 20);
		cart.updateQty(new Item("abc", "def", 23.45), 30);
		
		/*  Displaying Current Total  */
		System.out.println("Total Bill: " + cart.displayBill());
		
		/*  Performing deletion of an item  */
		cart.deleteItem(i2);
		cart.deleteItem(new Item("abc", "def", 23.45));
		
	}

}
