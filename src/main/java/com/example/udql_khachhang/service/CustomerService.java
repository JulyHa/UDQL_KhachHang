package com.example.udql_khachhang.service;

import com.example.udql_khachhang.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements IService<Customer> {
    List<Customer> customers = new ArrayList<>();

    {
        customers.add(new Customer(1, "Nguyễn Thị Ngũ", 21, "Hà Nội", "0123456789"));
        customers.add(new Customer(2, "Nguyễn Thị Ngũ", 21, "Hà Nội", "0123456789"));
        customers.add(new Customer(3, "Nguyễn Thị Ngũ", 21, "Hà Nội", "0123456789"));
    }

    @Override
    public List<Customer> showAll() {
        return customers;
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer: customers) {
            if(customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        int index = findIndexById(id);
        if(index == -1){
            return false;
        }
        customers.remove(index);
        return true;
    }

    @Override
    public boolean editById(int id, Customer customer) {
        int index = findIndexById(id);
        if(index == -1){
            return false;
        }
        customers.set(index, customer);
        return false;
    }

    @Override
    public void create(Customer customer) {
        customers.add(customer);
    }

    public int findIndexById(int id){
        for (int i = 0; i< customers.size(); i++){
            if(customers.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}
