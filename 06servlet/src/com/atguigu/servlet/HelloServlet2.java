package com.atguigu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {//HttpServlet是一个抽象类

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(config.getClass());//class org.apache.catalina.core.StandardWrapperFacade---标准包装外观---设计模式
        System.out.println(this.getClass());//class com.atguigu.servlet.HelloServlet2
        System.out.println(super.getClass());//class com.atguigu.servlet.HelloServlet2
        //核心细节：super并不表示当前类的父类的一个实例
        super.init(config);//因为你重写了GenericServlet类的init方法，所以必须在这里显示的调用一下父类中被重写的init方法来初始化config属性，否则getServletConfig方法返回值就是null
        System.out.println("重写了init初始化方法,做了一些工作");
    }

    /**
     * doGet（）在get请求的时候调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        int i =  12 / 0;

        System.out.println("HelloServlet2 的doGet方法");
        // 也可以使用.
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);

        //        2、获取初始化参数init-param
        System.out.println("初始化参数username的值是:" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是:" + servletConfig.getInitParameter("url"));


    }
    /**
     * doPost（）在post请求的时候调用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet2 的doPost方法");
    }
}
