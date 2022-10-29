<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/29/2022
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product</h1>
<%--<p>--%>
<%--    <a href="/customers?action=create">Create new customer</a>--%>
<%--</p>--%>

<form action="/products" method="post">
    <span>Nhập thông tin: </span>
    <input type="text" name = "search">
</form>

<table border="1">
    <thead>
    <tr>
        <td>Name</td>
        <td>IdCustomer</td>
        <td>Name</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${products}' var="product">
        <tr>
            <td><a style="text-decoration: none" href="">${product.getName()}</a></td>
            <td>${product.getCustomerID().getId()}</td>
            <td>${product.getCustomerID().getName()}</td>
            <td><a href="/customers?action=edit&id=${customer.getId()}">edit</a></td>
            <td><a href="/customers?action=delete&id=${customer.getId()}">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>


</table>

</body>
</html>
