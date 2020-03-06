package com.atguigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println( resp.getCharacterEncoding() );//服务器端的字符集，默认ISO-8859-1

        //解决中文乱码的方式一：
//        // 设置服务器字符集为UTF-8---字符集就是字符的编码解码方式的意思
//        resp.setCharacterEncoding("UTF-8");
//        // 通过响应头，设置浏览器也使用UTF-8字符集 也可以手动的更改浏览器的字符集，但是不可能让用户去改这个设置，因此在程序里面操作
//        resp.setHeader("Content-Type", "text/html; charset=UTF-8");

        //解决中文乱码的方式二：
        // 它会同时设置服务器和客户端都使用UTF-8字符集，还设置了响应头
        // 此方法一定要在获取流对象之前调用才有效
        resp.setContentType("text/html;charset=UTF-8");

        System.out.println( resp.getCharacterEncoding() );//输出服务器端的字符集

//        要求 ： 往客户端回传 字符串 数据。 使用字符流。。。
        PrintWriter writer = resp.getWriter();
        writer.write("response's content，国哥很帅！");
    }
}
