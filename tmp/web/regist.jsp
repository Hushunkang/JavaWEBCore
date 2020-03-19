<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/10
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>注册</title>
    <script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
      window.onload = function () {
        // 给验证码的图片，绑定单击事件
        $("#code_img").click(function () {
          // 在事件响应的function函数中有一个this对象。这个this对象，是当前正在响应事件的dom对象
          // src属性表示验证码img标签的 图片路径。它可读，可写
          // alert(this.src);
          this.src = "${basePath}kaptcha.jpg?date=" + new Date();
        });
      }
    </script>
  </head>
  <body>
  <form action="http://localhost:8098/tmp/registServlet" method="get">
    用户名：<input type="text" name="username" > <br>
    验证码：<input type="text" style="width: 60px;" name="code">
    <img id="code_img" src="http://localhost:8098/tmp/kaptcha.jpg" alt="" style="width: 100px; height: 28px;"> <br>
    <input type="submit" value="登录">
  </form>
  </body>
</html>
