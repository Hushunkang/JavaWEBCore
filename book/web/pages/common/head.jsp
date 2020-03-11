<%--
  Created by IntelliJ IDEA.
  User: Hushunkang
  Date: 2020/3/12
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 写base标签，永远固定相对路径的跳转结果 -->
<!-- web阶段 base标签+相对路径获取资源 -->
<!-- JavaEE框架阶段 绝对路径获取资源
我认为，两种获取资源的方式，
实际项目开发中用相对路径，
部署web工程做一个虚拟路径和真实资源的一个映射即可 -->
<base href="http://localhost:8091/book/"/>
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
