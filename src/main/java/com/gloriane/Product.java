package com.gloriane;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Product {
    private int id;
    private String name;
    private double price;
    private List<OrderItem> products = new ArrayList<>();


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Product(String name, double price) {
        this.id = generateId();
        setName(name);
        setPrice(price);
    }

    private int generateId() {
        return UUID.randomUUID().toString().substring(0, 8).hashCode();
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Product: " + name + ", Price: $" + price;
    }

    public String getProduct() {
        return toString();
    }
}
