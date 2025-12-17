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


    public Order(int id, double totalPrice, Customer customer) {
        this.Id = generateId();
        this.totalPrice = totalPrice;
        this.customer = customer;
    }

    private int generateId() {
        return UUID.randomUUID().toString().substring(0, 8).hashCode();
    }

    int getId() {
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

    /*Hey, give me an array (a collection) of OrderItems, and I'll call it items.Think of items as a shopping bag full of products
    For each individual product (item) inside that shopping bag (items).... This is like reaching into the bag and pulling out one item at a time
    ...add that single product to my permanent shopping list (products).
    products is the class field (the list that belongs to this Order object)
    item is the current product you're holding from the bag
     */

    // Add multiple items at once
    public void addItems(OrderItem[] items) {
        for (OrderItem item : items) {  // It Loops through 'items' parameter, not 'products'
            products.add(item);          //  and Add each item to the products list
        }
    }

    /* Remove a single item from the order
   Take the specific OrderItem that the customer wants to remove (the 'item' parameter)
   Search through the products list to find that exact item
   Remove it from the products list using ArrayList's built-in remove() method
   This is like taking one product off your kitchen shelf and putting it back in the store
   The item parameter is the specific product you want to remove
   products is the class field (the shopping list that belongs to this Order object)
*/

    // Remove a single item from order
    public void removeItem(OrderItem item) {
        products.remove(item);
    }

    // Get customer name will connect customer to order
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

