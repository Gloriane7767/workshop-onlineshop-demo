package com.gloriane;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private int Id;
    private double totalPrice;
    private List<OrderItem> products = new ArrayList<>();
    private Customer customer; // This field stores the connection


    int getId() {
        return Id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Order(int id, double totalPrice, Customer customer) {
        this.Id = generateId();
        this.totalPrice = totalPrice;
        this.customer = customer;
    }

    private int generateId() {
        return UUID.randomUUID().toString().substring(0, 8).hashCode();
    }

    public int orderId() {
        return Id;
    }

    public void setTotalPrice(double totalprice) {
        if (totalprice <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        this.totalPrice = totalprice;
    }

    @Override
    public String toString() {
        return "Order: " + Id + " +  Products: " + products + ", Total price: $" + totalPrice;
    }

    // Add single item to order
    public void addItem(OrderItem item) {
        products.add(item);
    }

    // Add multiple items at once
    public void addItems(OrderItem[] items) {
        for (OrderItem item : items) {  // Loop through 'items' parameter, not 'products'
            products.add(item);          // Add each item to the products list
        }
    }

    // Get customer name (connects customer to order)
    public String getCustomerName() {
        return customer.getName();
    }

    // Count products in order
    public int getProductCount() {
        return products.size();
    }

    // Calculate total price
    public double getTotalAmount() {
        double totalPrice = 0.0;
        for (OrderItem item : products) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
    // Display order summary
    public void displayOrderSummary() {
        System.out.println("=== ORDER DETAILS ===");
        System.out.println("Customer: " + getCustomerName());
        System.out.println("Products ordered:");
        for (OrderItem item : products) {  // Use 'products' not 'Product'
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total items: " + getProductCount());
        System.out.println("Total amount: $" + getTotalAmount());
    }
}

