package com.gloriane;

import java.util.ArrayList;

public class Order {
    private String orderId;
    private ArrayList<OrderItem> products;

    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public ArrayList<OrderItem> getProducts() {
        return new ArrayList<>(products); // Return copy to protect encapsulation
    }

    public void addProduct(String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Product price must be positive");
        }
        products.add(new OrderItem(name, price));
    }

    public void removeProduct(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        boolean removed = products.removeIf(orderItem -> orderItem.getName().equals(name));
        if (!removed) {
            throw new IllegalArgumentException("Product not found in order");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem orderItem : products) {
            total += orderItem.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order{orderId='" + orderId + "', products=" + products + ", total=" + calculateTotal() + "}";
    }
}
