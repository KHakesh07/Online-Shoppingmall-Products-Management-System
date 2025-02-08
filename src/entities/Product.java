package entities;

public class Product {
	private int productId;
	private String name;
	private double price;
	private int stockQuantity;
	
	public Product(int productId, String name, double price, int stockQuantity) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the stockQuantity
	 */
	public int getStockQuantity() {
		return stockQuantity;
	}

	/**
	 * @param stockQuantity the stockQuantity to set
	 */
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	@Override
	public String toString() {
		return "Prodcut [productId=" + productId + ", name=" + name + ", price=" + price + ", stockQuantity="
				+ stockQuantity + "]";
	}
	
	
	
	
}
