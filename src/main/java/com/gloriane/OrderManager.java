package com.gloriane;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Order> orders = new ArrayList<>();

    // Add a new order to the collection
    public void addOrder(Order order) {
        orders.add(order);
    }

    // Remove an order by ID
    public void removeOrder(int orderId) {
        orders.removeIf(order -> order.getId() == orderId);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orders;
    }

    // Calculate total of all orders
    public double calculateAllOrdersTotal() {
        double total = 0;
        for (Order order : orders) {
            total += order.getTotalAmount();
        }
        return total;
    }

    public double calculateTotal() {
        return calculateAllOrdersTotal();
    }

    // Get number of orders
    public int getOrderCount() {
        return orders.size();
    }

    @Override
    public String toString() {
        return "Orders{" + orders.size() + " orders, total value: $" + calculateAllOrdersTotal() + "}";
    }
}
