<%@page import="com.atguigu.java.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第一个JavaWEB应用</title>
</head>
<body>

	<!-- jsp页面编写Java代码 -->
	<%
		Person person = new Person();
		person.showInfo();
	%>

</body>
</html>