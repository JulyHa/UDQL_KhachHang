<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/28/2022
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thông tin chi tiết</h1>
<p>Tên: <span>${customer.getName()}</span></p>
<p>Tuổi: <span>${customer.getAge()}</span></p>
<p>Địa chỉ: <span>${customer.getAddress()}</span></p>
<p>SDT: <span>${customer.getPhone()}</span></p>

</body>
</html>
