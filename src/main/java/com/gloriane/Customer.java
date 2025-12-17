package com.gloriane;

import java.util.UUID;

public class Customer {
    private int id;
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.id = generateId();
        setName(name);
        setEmail(email);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private int generateId() {
        return UUID.randomUUID().toString().substring(0, 8).hashCode();
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if(email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Customer: " + name + ", + Email: " + email;
    }

    public String getCustomer() {
            return toString();
        }
    }

