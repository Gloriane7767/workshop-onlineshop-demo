package com.gloriane;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private int Id;
    private double totalPrice;
    private List<OrderItem> products = new ArrayList<>();

    int getId() {
        return Id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Order(int id, double totalPrice) {
        this.Id = generateId();
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

}
