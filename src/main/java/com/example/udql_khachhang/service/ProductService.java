package com.example.udql_khachhang.service;

import com.example.udql_khachhang.model.Customer;
import com.example.udql_khachhang.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IService<Product> {

    List<Product> products = new ArrayList<>();

    {
        products.add(new Product(1, "Bim bim", new Customer(1, "Nguyễn Thị Ngũ", 21, "Hà Nội", "0123456789")));
        products.add(new Product(2, "CoCa", new Customer(2, "Vũ Hồng Linh", 21, "Hà Nội", "0123456789")));
        products.add(new Product(3, "Milo", new Customer(3, "Nguyễn Anh Tuấn", 21, "Hà Nội", "0123456789")));
    }
    @Override
    public List<Product> showAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products){
            if(product.getId() == id)
                return product;
        }
        return null;
    }

    public int findIndexById(int id){
        for (int i = 0; i< products.size(); i++){
            if(products.get(i).getId() == id)
                return i;
        }
        return -1;
    }

    @Override
    public boolean deleteById(int id) {
        int index = findIndexById(id);
        if(index == -1) return false;
        products.remove(index);
        return true;
    }

    @Override
    public boolean editById(int id, Product product) {
        int index = findIndexById(id);
        if(index == -1) return false;
        products.set(index, product);
        return true;
    }

    @Override
    public void create(Product product) {
        products.add(product);

    }

    public List<Product> getProductsByIdCustomer(int id){
        List<Product> productList = new ArrayList<>();
        for(Product product : products){
            if(product.getCustomerID().getId() == id){
                productList.add(product);
            }
        }
        return productList;
    }

    public List<Product> findProductsByNameProduct(String name){
        List<Product> list = new ArrayList<>();
        for (Product product : products){
            if(product.getName().toLowerCase().contains(name.toLowerCase())){
                list.add(product);
            }
        }
        return list;
    }
}
