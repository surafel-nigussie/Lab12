<%--
  Created by IntelliJ IDEA.
  User: SurafelNigussie
  Date: 3/12/2019
  Time: 8:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="productList" type="java.util.List"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%!
    private void addToCart() {

    }
%>
<html>
<head>
    <title>Home</title>
    <script src="../resources/js/jquery.js"></script>
</head>
<body>

<div style="float: right;">
    <a href="#">Logout</a>
</div>

<table border="1" width="500" align="center">
    <tr bgcolor="00FF7F">
        <th><b>Name</b></th>
        <th><b>Price</b></th>
        <th><b>Cart</b></th>
    </tr>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                <input type="button">
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
