package com.gloriane;

public class Main {
    public static void main(String[] args) {
        // Create customer
        Customer customer = new Customer("Anna", "test.test@example.com");
        
        // Create order for the customer
        Order order = new Order(customer);

        // Status is PENDING by default
        order.confirmOrder();   // Status becomes CONFIRMED
        order.processOrder();   // Status becomes PROCESSING
        order.shipOrder();      // Status becomes SHIPPED
        order.deliverOrder();   // Status becomes DELIVERED



        Product[] products = {
                new Product("Notebook", 99.50, 1),
                new Product("Pen", 10.55, 1),
                new Product("backpack", 80.50, 1),
                new Product("water bottle", 60.50, 1),
                new Product("Calculator", 30.50, 1),
                new Product("Headphone", 20.50, 1),
                new Product("Charger", 45.50, 1),
                new Product("Mouse", 36.50, 1),
                new Product("USB cable", 80.50, 1),
                new Product("Planner", 30.50, 1)
        };
        
        // Add products to the order
        order.addProducts(products);
        
        // Display detailed order information
        order.displayOrderSummary();
    }
}
