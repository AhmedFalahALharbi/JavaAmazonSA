# Amazon.sa Java E-Commerce Backend

## Overview
This Java project serves as the backend for a simplified e-commerce platform, demonstrating key Object-Oriented Programming (OOP) concepts along with exception handling and collections usage.

## Key OOP Principles Demonstrated

- **Encapsulation:**  
  Each class (e.g., Product, Order, OrderDetails) encapsulates its properties with private/protected fields and exposes them via getters and setters.

- **Inheritance & Polymorphism:**  
  - The base class **Product** holds common attributes like productID, name, category, price, and stockQuantity.
  - **Electronics** and **Clothing** extend Product to include specific properties (warrantyMonths for Electronics and size for Clothing).  
  - Both subclasses override the `calculateDiscount()` method to provide type-specific discount logic (10% for Electronics, 15% for Clothing).

- **Exception Handling:**  
  A custom exception, **OutOfStockException**, is defined to handle cases where a product's stock is insufficient for an order, ensuring robust error management.

- **Java Collections:**  
  Orders are stored in an `ArrayList<Order>`, and a `HashMap<Integer, Order>` is used to maintain user order histories, illustrating practical use of Java collections.

## Project Structure

- **Product.java:**  
  Base class representing a product.

- **Electronics.java:**  
  Subclass of Product with an additional `warrantyMonths` property and an overridden discount calculation.

- **Clothing.java:**  
  Subclass of Product with an additional `size` property and an overridden discount calculation.

- **Order.java:**  
  Represents an order with properties such as orderID, userID, and a list of order details.

- **OrderDetails.java:**  
  Represents the details of an order item (productID, quantity, and subTotal).

- **OutOfStockException.java:**  
  Custom exception for handling insufficient stock scenarios.

- **Main.java:**  
  Contains the command-line interface (CLI) for placing orders and viewing order history.

## How to Run

1. Open the project in IntelliJ IDEA.
2. Build and run the `Main` class.
3. Follow the CLI prompts to place an order or view order history.

