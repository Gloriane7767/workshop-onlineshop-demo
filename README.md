
# Online Shop Demo Application

A simple Java-based online shop management system that demonstrates order processing, customer management, and product handling.

## Features

- **Customer Management**: Create and manage customer information
- **Order Processing**: Create orders and associate them with customers
- **Product Management**: Add and remove items from orders
- **Order Tracking**: View order summaries with detailed product lists
- **Price Calculation**: Automatic total price calculation based on order items
- **Order Management**: Manage multiple orders through OrderManager

## Project Structure

```text
workshop-onlineshop-demo/
└── src/main/java/com/gloriane/
├── Main.java # Application entry point
├── Customer.java # Customer entity
├── Order.java # Order entity with business logic
├── OrderItem.java # Individual product items
└── OrderManager.java # Manages multiple orders


## Classes Overview

### Customer
Represents a customer with name and email information.

### Order
- Manages a collection of OrderItems
- Generates unique order IDs
- Calculates total amounts
- Displays order summaries
- Supports adding/removing items

### OrderItem
Represents individual products with name and price.

### OrderManager
- Manages multiple orders
- Calculates total revenue across all orders
- Provides order collection operations

## How to Run

1. Ensure you have Java installed (Java 8 or higher)
2. Navigate to the project directory
3. Compile the project:
   ```bash
   javac src/main/java/com/gloriane/*.java
   ```

Run the application:
```
java -cp src/main/java com.gloriane.Main
```

### Usage Example
```java

// Create customer
Customer customer = new Customer("John Doe", "john@example.com");

// Create order
Order order = new Order(1, 0.0, customer);

// Create items
OrderItem[] items = {
new OrderItem("Laptop", 999.99),
new OrderItem("Mouse", 29.99)
};
```

```java
// Add items to order
order.addItems(items);

// Remove an item
order.removeItem(items[1]);

// Display order summary
order.displayOrderSummary();
```
## Key Methods
### Order Class
  - ```addItems(OrderItem[] items)``` - Add multiple items to order
  - ```removeItem(OrderItem item)``` - Remove specific item from order
  - ```getTotalAmount()``` - Calculate total order price
  - ```getProductCount()``` - Get number of items in order
  - ```displayOrderSummary()``` - Print detailed order information

### OrderManager Class
  - ```addOrder(Order order)``` - Add order to collection
  - ```removeOrder(int orderId)``` - Remove order by ID
  - ```calculateAllOrdersTotal()``` - Calculate total revenue
  - ```getOrderCount()``` - Get number of orders

### Future Enhancements
  - Product catalog management
  - Shopping cart functionality
  - Payment processing
  - Order status tracking (Pending, Shipped, Delivered)
  - Discount and coupon system
  - Invoice generation
  - Database integration

### Author
Gloriane Dev

### License
This is a demo project for educational purposes.

