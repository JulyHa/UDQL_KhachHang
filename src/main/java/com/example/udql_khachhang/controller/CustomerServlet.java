package com.example.udql_khachhang.controller;

import com.example.udql_khachhang.model.Customer;
import com.example.udql_khachhang.service.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy action từ url
        String action = request.getParameter("action");
        if(action == null){ // Nếu action null
            action = ""; // Gán lại = rỗng
        }
        switch (action){
            case "showById":
                showById(request, response);

            case "create":
                break;
            case "edit":
                editCustomer(request,response);

                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                showAllCustomer(request, response); // Method hiển thị toàn bộ sản phẩm


        }


    }

    private void showById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);

        request.setAttribute("customer", customer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/showById.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.editById(id,new Customer(id,"phong",23,"hn","3243423423"));
        showAllCustomer(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteById(id);

        showAllCustomer(request, response);
    }

    private void showAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Vào customerService để lấy toàn bộ customer
        List<Customer> customers = customerService.showAll();
        // Gán thông tin vừa nhận vào attribute
        request.setAttribute("customerList", customers);
        // Tạo RequestDispatcher để chuyển hướng
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/show.jsp");
        // Bắt đầu chuyển hướng
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
