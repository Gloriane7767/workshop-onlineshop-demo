package com.gloriane;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Gloriane Application!");
        Customer customer = new Customer("Example User", "test.test@example.com");
        System.out.println(customer.getCustomer());

        Product product = new Product("Example Product", 29.99);
        System.out.println(product.getProduct());

        OrderItem orderItem1 = new OrderItem("Notebook", 99.50);
        System.out.println(orderItem1.getOrderItem());
        OrderItem orderItem2 = new OrderItem("Pen", 10.55);
        System.out.println(orderItem2.getOrderItem());
        OrderItem orderItem3= new OrderItem("backpack", 80.50);
        System.out.println(orderItem3.getOrderItem());
        OrderItem orderItem4 = new OrderItem("water bottle", 60.50);
        System.out.println(orderItem4.getOrderItem());
        OrderItem orderItem5 = new OrderItem("Calculator", 30.50);
        System.out.println(orderItem5.getOrderItem());
        OrderItem orderItem6 = new OrderItem("Headphone", 20.50);
        System.out.println(orderItem6.getOrderItem());
        OrderItem orderItem7 = new OrderItem("Charger", 45.50);
        System.out.println(orderItem7.getOrderItem());
        OrderItem orderItem8 = new OrderItem("Mouse", 36.50);
        System.out.println(orderItem8.getOrderItem());
        OrderItem orderItem9 = new OrderItem("USB cable", 80.50);
        System.out.println(orderItem9.getOrderItem());
        OrderItem orderItem10 = new OrderItem("Planner", 30.50);
        System.out.println(orderItem10.getOrderItem());
    }
}
