package entities;
import java.util.List;
import java.util.ArrayList;

public class Customer extends User {
	private String address;
	private ShoppingCart shoppingCart;
	private List<Order> orders;
	
	public Customer(int userId, String username, String email, String address) {
		super(userId, username, email);
		this.address = address;
		this.shoppingCart = new ShoppingCart();
		this.orders = new ArrayList<>();
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the shoppingCart
	 */
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}		

	public List<Order> getOrders() {
		return orders;
	}
	public void addOrder (Order order) {
		orders.add(order);
	}
	
	

}
