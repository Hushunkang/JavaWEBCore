package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月20日 06时09分52秒
 */
public class Filter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter1为：" + request.getParameter("username"));
        request.setAttribute("key1","value1");

        System.out.println("filter1的前置代码");
        System.out.println("Filter1 线程名：" + Thread.currentThread().getName());
        chain.doFilter(request,response);
        System.out.println("Filter1 线程名：" + Thread.currentThread().getName());
        System.out.println("filter1的后置代码");
    }

    @Override
    public void destroy() {

    }

}
