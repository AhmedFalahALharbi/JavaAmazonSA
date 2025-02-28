import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static ArrayList<Order> orders = new ArrayList<>();
    private static HashMap<Integer, ArrayList<Order>> userOrderHistory = new HashMap<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static int nextOrderID = 1;
    private static int nextOrderDetailID = 1;

    public static void main(String[] args) {
        initializeProducts();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Place an Order");
            System.out.println("2. View Order History");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    placeOrder(scanner);
                    break;
                case 2:
                    viewOrderHistory(scanner);
                    break;
                case 3:
                    System.out.println("Exiting application.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void initializeProducts() {
        products.add(new Electronics(1, "Smartphone", 699.99, 10, 24));
        products.add(new Electronics(2, "Laptop", 1299.99, 5, 12));
        products.add(new Clothing(3, "T-Shirt", 29.99, 50, "M"));
        products.add(new Clothing(4, "Jeans", 59.99, 40, "L"));
    }

    private static void placeOrder(Scanner scanner) {
        System.out.print("Enter your user ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine();

        Order order = new Order(nextOrderID++, userID);

        while (true) {
            System.out.println("\nAvailable products:");
            for (Product p : products) {
                System.out.println(p.getProductID() + ". " + p.getName() + " - $" + p.getPrice()
                        + " (Stock: " + p.getStockQuantity() + ")");
            }
            System.out.print("Enter Product ID to add to order (or 0 to finish): ");
            int productID = scanner.nextInt();
            if (productID == 0) break;

            Product product = getProductByID(productID);
            if (product == null) {
                System.out.println("Product not found!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            if (quantity > product.getStockQuantity()) {
                try {
                    throw new OutOfStockException("Insufficient stock for product " + product.getName());
                } catch (OutOfStockException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }

            product.setStockQuantity(product.getStockQuantity() - quantity);

            double subTotal = quantity * product.getPrice(); // Simple subtotal calculation
            OrderDetails orderDetails = new OrderDetails(nextOrderDetailID++, order.getOrderID(), productID, quantity, subTotal);
            order.addOrderDetail(orderDetails);

            System.out.println("Product added to order.");
            scanner.nextLine(); // consume newline
        }

        orders.add(order);
        userOrderHistory.putIfAbsent(userID, new ArrayList<>());
        userOrderHistory.get(userID).add(order);

        System.out.println("Order placed successfully: " + order);
    }

    private static Product getProductByID(int productID) {
        for (Product p : products) {
            if (p.getProductID() == productID) {
                return p;
            }
        }
        return null;
    }

    private static void viewOrderHistory(Scanner scanner) {
        System.out.print("Enter your user ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Order> ordersForUser = userOrderHistory.get(userID);
        if (ordersForUser == null || ordersForUser.isEmpty()) {
            System.out.println("No orders found for user " + userID);
        } else {
            System.out.println("Order History for user " + userID + ":");
            for (Order order : ordersForUser) {
                System.out.println(order);
            }
        }
    }
}

