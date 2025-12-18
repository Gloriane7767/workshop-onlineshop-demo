package com.gloriane;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Order {
    // Order status enum
    public enum OrderStatus {
        PENDING, CONFIRMED, PROCESSING, SHIPPED, DELIVERED, CANCELLED
    }
    
    // Core order properties
    private int id;
    private double totalPrice;
    private List<Product> products = new ArrayList<>();
    private Customer customer;
    private LocalDateTime orderDate;
    private OrderStatus status;

    // Constructor
    public Order(Customer customer) {
        this.id = generateId();
        this.customer = customer;
        this.totalPrice = 0.0;
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.PENDING;
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
    public LocalDateTime getOrderDate() {return orderDate;}
    public OrderStatus getStatus() {
        return status;
    }

    // Display order summary
    public void displayOrderSummary() {
        System.out.println("=== ORDER DETAILS ===");
        System.out.println("Order Date: " + getFormattedOrderDate());
        System.out.println("Status: " + status);
        System.out.println("Customer: " + getCustomerName());
        System.out.println("Products ordered:");
        for (Product item : products) {
            System.out.println("- " + item.getName() + ": $" + item.getTotalPrice());
        }
        System.out.println("Total items: " + getProductCount());
        System.out.println("Total amount: $" + getTotalPrice());
    }

    // Optional: Get formatted date as string
    public String getFormattedOrderDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return orderDate.format(formatter);
    }

    // Status update methods
    public void confirmOrder() {
        this.status = OrderStatus.CONFIRMED;
    }
    
    public void processOrder() {
        this.status = OrderStatus.PROCESSING;
    }
    
    public void shipOrder() {
        this.status = OrderStatus.SHIPPED;
    }
    
    public void deliverOrder() {
        this.status = OrderStatus.DELIVERED;
    }
    
    public void cancelOrder() {
        this.status = OrderStatus.CANCELLED;
    }
}