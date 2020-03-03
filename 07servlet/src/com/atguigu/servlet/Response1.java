package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("曾到此一游 Response1 ");

        req.setAttribute("key1", "value1");

        //请求重定向方法一：
        // 设置响应状态码302 ，表示重定向，（已搬迁）
        resp.setStatus(302);
        // 设置响应头，说明 新的地址在哪里
        resp.setHeader("Location", "http://localhost:8089/07servlet/response2");
//        resp.setHeader("Location", "http://localhost:8089/07servlet/WEB-INF/form.html");
//        resp.setHeader("Location", "http://www.google.com");

        //请求重定向方法二：
//        resp.sendRedirect("http://www.google.com");
    }
}
