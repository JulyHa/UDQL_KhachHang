package com.example.udql_khachhang.controller;

import com.example.udql_khachhang.model.Product;
import com.example.udql_khachhang.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.showAll();

        request.setAttribute("products", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/show.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");

        List<Product> productList = productService.findProductsByNameProduct(name);

        request.setAttribute("products", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/product/show.jsp");
        requestDispatcher.forward(request, response);


    }
}
