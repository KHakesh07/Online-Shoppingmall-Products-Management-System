package services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import entities.Order;
import entities.Product;
import entities.ProductQuantityPair;

	public class OrderService {
	    private List<Order> orderList = new ArrayList<>();

	    public OrderService() {
	    }

	    public void placeOrder(Order order) {
	        orderList.add(order);
	    }

	    public void updateOrderStatus(int orderId, String status) {
	        Order order = getOrder(orderId);

	        if (order != null) {
	            if ("Completed".equalsIgnoreCase(status) && "Pending".equalsIgnoreCase(order.getStatus())) {
	                for (Map<Product, Integer> pair :Arrays.asList(order.getProducts())) {
	                    Product product = ((ProductQuantityPair) pair).getProduct();
	                    if (product == null) {
                        	System.out.println("Invalid product placed: "+order.getOrderId());
                        	return;
                        }
	                    int quantity = ((ProductQuantityPair) pair).getQuantity();

	                    if (product.getStockQuantity() >= quantity) {
	                        product.setStockQuantity(product.getStockQuantity() - quantity);
	                    } else {
	                        System.out.println("Insufficient stock for product: " + product.getName());
	                        return;
	                    }
	                }
	            } else if ("Cancelled".equalsIgnoreCase(status)) {
	                if ("Completed".equalsIgnoreCase(order.getStatus()) || "Pending".equalsIgnoreCase(order.getStatus())) {
	                    for (Map<Product, Integer> pair : Arrays.asList(order.getProducts())) {
	                        Product product = ((ProductQuantityPair) pair).getProduct();
	                        int quantity = ((ProductQuantityPair) pair).getQuantity();
	                        product.setStockQuantity(product.getStockQuantity() + quantity);
	                    }
	                }
	            } else if ("Delivered".equalsIgnoreCase(status) && "Completed".equalsIgnoreCase(order.getStatus())) {
	                // Only update the status to Delivered, no stock adjustment needed
	            } else {
	                System.out.println("Invalid Order");
	            }

	            order.setStatus(status);
	        }
	    }

	    public Order getOrder(int orderId) {
	        return orderList.stream().filter(order -> order.getOrderId() == orderId).findFirst().orElse(null);
	    }

	    public List<Order> getOrders() {
	        return orderList;
	    }
	}

