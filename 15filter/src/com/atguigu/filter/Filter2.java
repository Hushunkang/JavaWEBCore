package com.atguigu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月20日
 */
public class Filter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter2为：" + request.getParameter("username"));
        System.out.println("Filter2中取出Filter1中保存的数据为：" + request.getAttribute("key1"));

        System.out.println("filter2的前置代码");
        System.out.println("Filter2 线程名：" + Thread.currentThread().getName());
        chain.doFilter(request,response);
        System.out.println("Filter2 线程名：" + Thread.currentThread().getName());
        System.out.println("filter2的后置代码");
    }

    @Override
    public void destroy() {

    }

}
