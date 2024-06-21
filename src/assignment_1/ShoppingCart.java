package assignment_1;

public class ShoppingCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		Item i1 = new Item("Item 1", "Item 1 Desc", 45.23);
		Item i2 = new Item("Item 2", "Item 2 Desc", 55.23);
		Item i3 = new Item("Item 3", "Item 3 Desc", 65.23);
		cart.addToCart(i1, 100);
		cart.addToCart(i2, 150);
		cart.addToCart(i3, 200);
		System.out.println(cart.displayQty(i1));
		System.out.println(cart.displayQty(i2));
		System.out.println(cart.displayQty(i3));
		cart.updateQty(i1, 10);
		cart.updateQty(i2, 15);
		cart.updateQty(i3, 20);
		cart.updateQty(new Item("abc", "def", 23.45), 30);
		System.out.println(cart.displayBill());
	}

}
