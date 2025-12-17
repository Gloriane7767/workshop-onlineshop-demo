package com.gloriane;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Gloriane Application!");
        
        // Create customer
        Customer customer = new Customer("Gloriane Dev", "test.test@example.com");
        
        // Create order for the customer
        Order order = new Order(1, 0.0, customer);

        OrderItem[] orderItems = {
                new OrderItem("Notebook", 99.50),
                new OrderItem("Pen", 10.55),
                new OrderItem("backpack", 80.50),
                new OrderItem("water bottle", 60.50),
                new OrderItem("Calculator", 30.50),
                new OrderItem("Headphone", 20.50),
                new OrderItem("Charger", 45.50),
                new OrderItem("Mouse", 36.50),
                new OrderItem("USB cable", 80.50),
                new OrderItem("Planner", 30.50)
        };
        
        // Add items to the order

        order.addItems(orderItems);

        // ⬇️ ADD THESE LINES HERE (between line 26 and 29) ⬇️
        System.out.println("\n--- BEFORE REMOVING ITEM ---");
        order.displayOrderSummary();

        order.removeItem(orderItems[1]);  // Remove "Pen"

        System.out.println("\n--- AFTER REMOVING PEN ---");
// ⬆️ END OF NEW CODE ⬆️
        
        // Display detailed order information
        order.displayOrderSummary();
    }
}
