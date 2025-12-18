package com.gloriane;

import java.util.*;

public class Order {
    // Core order properties
    private int id;
    private double totalPrice;
    private List<Product> products = new ArrayList<>();
    private Customer customer;

    // Constructor
    public Order(Customer customer) {
        this.id = generateId();
        this.customer = customer;
        this.totalPrice = 0.0;
    }

    private int generateId() {
        return UUID.randomUUID().toString().substring(0, 8).hashCode();
    }

    // Add single product
    public void addProduct(String name, double price, int quantity) {
        products.add(new Product(name, price, quantity));
        updateTotalPrice();
    }

    // Add multiple products
    public void addProducts(Product[] items) {
        for (Product item : items) {
            products.add(item);
        }
        updateTotalPrice();
    }

    // Remove product
    public void removeProduct(Product item) {
        products.remove(item);
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        totalPrice = 0.0;
        for (Product item : products) {
            totalPrice += item.getTotalPrice();
        }
    }

    // Getters
    public int getId() { return id; }
    public double getTotalPrice() { return totalPrice; }
    public String getCustomerName() { return customer.getName(); }
    public int getProductCount() { return products.size(); }

    // Display order summary
    public void displayOrderSummary() {
        System.out.println("=== ORDER DETAILS ===");
        System.out.println("Customer: " + getCustomerName());
        System.out.println("Products ordered:");
        for (Product item : products) {
            System.out.println("- " + item.getName() + ": $" + item.getTotalPrice());
        }
        System.out.println("Total items: " + getProductCount());
        System.out.println("Total amount: $" + getTotalPrice());
    }
}