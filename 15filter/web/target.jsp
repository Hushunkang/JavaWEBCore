<%--
  Created by IntelliJ IDEA.
  User: Hushunkang
  Date: 2020/3/20
  Time: 6:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>目标jsp</title>
</head>
<body>
    <%
        System.out.println("target.jsp 线程名：" + Thread.currentThread().getName());
        System.out.println("经过过滤器链，target.jsp最终被访问到了。。。");
    %>
</body>
</html>
