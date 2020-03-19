<%--
  Created by IntelliJ IDEA.
  User: Hushunkang
  Date: 2020/3/20
  Time: 4:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    This is login page.
    <form action="http://localhost:8099/15filter/loginServlet" method="get">
<%--        用户名：<input type="text" name="username" value="${cookie.username.value}"> <br>--%>
        用户名：<input type="text" name="username"> <br>
        密码：<input type="password" name="password"> <br>
        <input type="submit" value="登录">
    </form>
</body>
</html>
