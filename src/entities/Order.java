package entities;
import java.util.Map;
public class Order {
	private int orderId;
	private Customer customer;
	private Map<Product, Integer> products;
	private String status;
	public Order(int orderId, Customer customer, Map<Product, Integer> products, String status) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.products = products;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public Map<Product, Integer> getProducts() {
		return products;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void addProduct(Product product, int quantity) {
		products.put(product, quantity);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order ID: ").append(orderId)
		  .append(", Customer: ").append(customer.getUsername())
		  .append(", Status: ").append(status)
		  .append(", Products: [");
		for (Map.Entry<Product, Integer> entry : products.entrySet()) {
			sb.append(entry.getKey().getName()).append(" (x").append(entry.getValue()).append("), ");
		}
		sb.append("]");
		return sb.toString();
	}
	
	
	
}
