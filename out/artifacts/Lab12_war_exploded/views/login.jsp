<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SurafelNigussie
  Date: 3/12/2019
  Time: 6:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    private String getUserName(HttpServletRequest request) {
        String _username = "";
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("username")) {
                    _username = cookie.getValue();
                }
            }
        }
        return _username;
    }

    private String isRememberMe(HttpServletRequest request) {
        String _remember_me = "";
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("remember_me")) {
                    if (cookie.getValue().equals("true"))
                        _remember_me = "checked=\"checked\"";
                }
            }
        }
        return _remember_me;
    }
%>

<html>
<head>
    <title>Login Form</title>
    <link href="../resources/css/login.css" rel="stylesheet">
</head>
<body>
<div>
    <h2>Login</h2>
    <form method="post" action="<c:url value="login"/>">
        <input name="username" type="text" placeholder="username" value="<%=getUserName(request)%>"/>
        <input name="password" type="password" placeholder="password"/>
        <label><input name="remember_me" type="checkbox"  <%=isRememberMe(request)%>> Remember me</label>
        <button type="submit">Login</button>
        <p>
            <%= request.getAttribute("message")%>
        </p>
    </form>
</div>
</body>
</html>
