package com.gloriane;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Gloriane Application!");
        Customer customer = new Customer("Example User", "test.test@example.com");
        System.out.println(customer.getCustomer());

        Product product = new Product("Example Product", 29.99);
        System.out.println(product.getProduct());

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
        double total = 0.0;
        for (OrderItem item : orderItems) {
            System.out.println(item.getOrderItem());
            total += item.getPrice();
        }

        System.out.println("\nTotal Order Amount: $" + String.format("%.2f", total));
    }
}
