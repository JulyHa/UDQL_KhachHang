<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/customers?action=create">Create new customer</a>
</p>
<table border="1">
    <thead>
        <tr>
            <td>Name</td>
            <td>Age</td>
            <td>Address</td>
            <td>Phone</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
    </thead>
    <tbody>
        <c:forEach items='${customerList}' var="customer">
            <tr>
                <td><a style="text-decoration: none" href="/customers?action=showById&id=${customer.getId()}">${customer.getName()}</a></td>
                <td>${customer.getAge()}</td>
                <td>${customer.getAddress()}</td>
                <td>${customer.getPhone()}</td>
                <td><a href="/customers?action=edit&id=${customer.getId()}">edit</a></td>
                <td><a href="/customers?action=delete&id=${customer.getId()}">delete</a></td>
            </tr>
        </c:forEach>
    </tbody>


</table>
</body>
</html>