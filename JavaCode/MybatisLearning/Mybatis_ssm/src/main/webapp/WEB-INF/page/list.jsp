<%--
  Created by IntelliJ IDEA.
  User: wwww
  Date: 2022/11/13
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工列表</title>
</head>
<body>
    <table>
        <th>
            <td>id</td>
            <td>lastName</td>
            <td>email</td>
            <td>gender</td>
        </th>
        <c:forEach items="${employees}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.gender}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
