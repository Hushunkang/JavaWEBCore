package com.atguigu.java;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author hskBeginner 2752962035@qq.com
 * @description
 * @date 2020年2月28日上午4:52:59
 */
public class SecondServlet implements Servlet {

    /* (non-Javadoc)
     * @see javax.servlet.Servlet#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("second servlet destroy...");
    }

    /* (non-Javadoc)
     * @see javax.servlet.Servlet#getServletConfig()
     */
    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        System.out.println("second servlet getServletConfig...");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.servlet.Servlet#getServletInfo()
     */
    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        System.out.println("second servlet getServletInfo...");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
     */
    @Override
    public void init(ServletConfig arg0) throws ServletException {
        System.out.println("second servlet init... ");
    }

    /* (non-Javadoc)
     * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
     */
    @Override
    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("second servlet service...");
    }

    public SecondServlet() {
        System.out.println("SecondServlet's constructor...");
    }

}
