package com.example.udql_khachhang.service;

import java.util.List;

public interface IService<T> {
    List<T> showAll();

    T findById(int id);

    boolean deleteById(int id);

    boolean editById(int id, T t);

    void create(T t);

}
