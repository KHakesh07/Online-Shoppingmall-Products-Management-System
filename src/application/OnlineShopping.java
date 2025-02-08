package application;
import java.util.Scanner;

import entities.Product;
import entities.Admin;
import entities.Customer;
import entities.Order;



import services.AdminServices;
import services.CustomerServices;
import services.OrderService;
import services.ProductServices;

public class OnlineShopping {
	private static ProductServices productService = new ProductServices();
	private static CustomerServices customerService = new CustomerServices();
	private static OrderService orderService = new OrderService();
	private static AdminServices adminService = new AdminServices();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. Admin Menu");
			System.out.println("2 Customer Menu");
			System.out.println("3.Exit");
			System.out.println("Choose an option: ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1://admin
				int adminChoice;
				do {
					System.out.println("\nAdmin Menu:");
					System.out.println("1.Add Product");
					System.out.println("2.Remove Product");
					System.out.println("3.View Products");
					System.out.println("4.Create Admin");
					System.out.println("5. View Admins");
					System.out.println("6. Update Order Status");
					System.out.println("7. View Orders");
					System.out.println("8. Return");
					System.out.println("Choose an option: ");
					adminChoice = sc.nextInt();
					
					switch (adminChoice) {
					case 1:
						addProduct(sc);
						break;
					case 2:
						removeProduct(sc);
						break;
					case 3:
						viewProducts();
						break;
					case 4:
						createAdmin(sc);
						break;
					case 5:
						viewAdmins();
						break;
					case 6:
						updateOrderStatus(sc);
						break;
					case 7:
						viewOrders();
						break;
					default:
						System.out.println("Invalid choice! Please try again. ");
					}
				} while (adminChoice != 0);
			case 2: //customer module
				int customerChoice;
				do {
					System.out.println("\nCustomer Menu: ");
					System.out.println("1. Create Customer");
					System.out.println("2. View Customers");
					System.out.println("3. Place Order");
					System.out.println("4. View Orders");
					System.out.println("5. View Products");
					System.out.println("6.Return");
					System.out.print("Choose an option: ");
					customerChoice = sc.nextInt();
					switch (customerChoice) {
					case 1:
						createCustomer(sc);
						break;
					case 2:
						viewCustomers();
						break;
					case 3:
						placeOrder(sc);
						break;
					case 4:
						viewOrders();
						break;
					case 5:
						viewProducts();
						break;
					case 6:
						System.out.println("Exiting Customer Menu. . .");
						break;
					default:
						System.out.println("Invalid choice! better be retry");
					}
				} while (customerChoice !=6);
				break;
			case 3:
				System.out.println("Exiting...");
				sc.close();
			default:
				System.out.println("Retry wwith correct choice");
			}
		}
	}
	
	private static void addProduct(Scanner sc) {
		System.out.println("Enter Product Id: ");
		int productId = sc.nextInt();
		System.out.println("Product Name: ");
		String name = sc.next();
		System.out.println("Product price :");
		double price = sc.nextDouble();
		System.out.println("Stock Quantity: ");
		int stockQuantity = sc.nextInt();
		
		Product product = new Product (productId, name, price, stockQuantity);
		productService.addProduct(product);
		System.out.println("Added");
	}
	
	private static void removeProduct(Scanner sc) {
		System.out.println("Product ID: ");
		int productId = sc.nextInt();
		
		productService.removeProduct(productId);
		System.out.println("Removed");
	}
	
	private static void viewProducts(){
		System.out.println("Avalialbe Products:");
		for(Product product : productService.getProducts()) {
			System.out.println(product);
		}
	}
	
	private static void createAdmin(Scanner sc) {
		System.out.println("Enter name: ");
		String username = sc.nextLine();
		System.out.println("Enter Admin id: ");
		int userId = sc.nextInt();
		System.out.println("Enter Email: ");
		String email = sc.nextLine();
		Admin admin = new Admin(userId, username, email);
		adminService.addAdmin(admin);
		System.out.println("Admin created success");
	}
	
	 private static void viewAdmins() {
	        System.out.println("\nRegistered Admins:");
	        for (Admin admin : adminService.getAdmins()) {
	            System.out.println(admin);
	        }
	    }
	 
	 private static void updateOrderStatus(Scanner sc) {
	        System.out.print("Enter Order ID: ");
	        int orderId = sc.nextInt();
	        System.out.print("Enter New Status (Pending/Completed/Cancelled/Delivered): ");
	        sc.nextLine(); // Consume newline
	        String status = sc.nextLine();

	        orderService.updateOrderStatus(orderId, status);
	        System.out.println("Order status updated successfully!");
	    }
	 private static void viewOrders() {
	        System.out.println("\nAll Orders:");
	        for (Order order : orderService.getOrders()) {
	            System.out.println(order);
	        }
	    }
	 private static void createCustomer(Scanner sc) {
	        System.out.print("Enter Customer Name: ");
	        sc.nextLine(); // Consume newline
	        String username = sc.nextLine();
	        System.out.print("Enter Customer ID: ");
	        int userId = sc.nextInt();
	        System.out.print("Enter Email: ");
	        String email = sc.nextLine();
	        System.out.print("Enter Address: ");
	        String address = sc.nextLine();

	        Customer customer = new Customer(userId, username, email, address);
	        customerService.addCustomer(customer);
	        System.out.println("Customer created successfully!");
	    }
	 private static void viewCustomers() {
	        System.out.println("\nRegistered Customers:");
	        for (Customer customer : customerService.getCustomers()) {
	            System.out.println(customer);
	        }
	    }
	 private static void placeOrder(Scanner sc) {

	        System.out.print("Enter Order ID: ");
	        int orderId = sc.nextInt();

	        Order order = new Order(orderId, null, null, null);
	        // Assuming adding products to the order logic exists here.
	        orderService.placeOrder(order);
	        System.out.println("Order placed successfully!");
	    }
}
