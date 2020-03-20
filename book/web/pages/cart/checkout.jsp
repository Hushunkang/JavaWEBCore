<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>结算页面</title>
    <%-- 静态包含，base标签，css文件，jQuery文件库 --%>
    <%@include file="/pages/common/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">结算</span>

    <%-- 静态包含，登录成功之后的菜单页面 --%>
    <%@ include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">

    <c:if test="${not empty sessionScope.orderId}">
        <h1>您的订单已结算，订单号为：${sessionScope.orderId}</h1>
    </c:if>
    <c:if test="${empty sessionScope.orderId}">
        <h1>您的订单结账失败，请稍后再试</h1>
    </c:if>

</div>

<%-- 静态包含页脚信息 --%>
<%@include file="/pages/common/foot.jsp" %>
</body>
</html>