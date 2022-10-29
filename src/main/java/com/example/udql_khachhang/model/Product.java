package com.example.udql_khachhang.model;

public class Product {
    private int id;
    private String name;
    private Customer customerID;

    public Product() {
    }

    public Product(int id, String name, Customer customerID) {
        this.id = id;
        this.name = name;
        this.customerID = customerID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customer customerID) {
        this.customerID = customerID;
    }
}
