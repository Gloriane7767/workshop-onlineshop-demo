package com.gloriane;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Gloriane Application!");
        Customer customer = new Customer("Example User", "test.test@example.com");
        System.out.println(customer.getCustomer());


        Product product = new Product("Example Product", 29.99);
        System.out.println(product.getProduct());
    }
}
