package com.atguigu.java;

import javax.servlet.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/**
 * @author hskBeginner 2752962035@qq.com
 * @description
 * @date 2020年2月28日
 */
public class HelloServlet implements Servlet {

    /* (non-Javadoc)
     * @see javax.servlet.Servlet#destroy()
     */
    @Override
    public void destroy() {
        System.out.println("hello servlet destroy...");
    }

    /* (non-Javadoc)
     * @see javax.servlet.Servlet#getServletConfig()
     */
    @Override
    public ServletConfig getServletConfig() {
        System.out.println("hello servlet getServletConfig...");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.servlet.Servlet#getServletInfo()
     */
    @Override
    public String getServletInfo() {
        System.out.println("hello servlet getServletInfo...");
        return null;
    }

    /* (non-Javadoc)
     * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
     */
    @Override
    public void init(ServletConfig arg0) throws ServletException {
        System.out.println("hello servlet init... ");

//		String user = servletConfig.getInitParameter("user");
//		System.out.println("user： " + user);
//		
//		Enumeration<String> names = servletConfig.getInitParameterNames();
//		while(names.hasMoreElements()){
//			String name = names.nextElement();
//			String value = servletConfig.getInitParameter(name);
//			System.out.println("^^" + name + ": " + value);
//		}
//		
//		String serlvetName = servletConfig.getServletName();
//		System.out.println(serlvetName); 

        //获取arg0这个对象是哪个类造的
        System.out.println(arg0.getClass());

        String username = arg0.getInitParameter("username");
        System.out.println("username" + username);
        Enumeration<String> initParameterNames = arg0.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            String value = arg0.getInitParameter(name);
            System.out.println("name:" + name + ",value:" + value);
        }
        String servletName = arg0.getServletName();
        System.out.println(servletName);

        ServletContext servletContext = arg0.getServletContext();
        String driver = servletContext.getInitParameter("driver");
        String jdbcUrl = servletContext.getInitParameter("jdbcUrl");
        System.out.println(driver);
        System.out.println(jdbcUrl);
        Enumeration<String> names = servletContext.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println("parameter name:" + name + ",parameter value:" + servletContext.getInitParameter(name));
        }

        String realPath = servletContext.getRealPath("/hello.jsp");
        System.out.println(realPath);

        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);

        InputStream is = null;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            is = classLoader.getResourceAsStream("jdbc.properties");
            System.out.println(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        InputStream is2 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
//		InputStream is2 = servletContext.getResourceAsStream("\\WEB-INF\\classes\\jdbc.properties");
        System.out.println(is2);
    }

    /* (non-Javadoc)
     * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
     */
    @Override
    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
        System.out.println("hello servlet service...");
    }

    public HelloServlet() {
        System.out.println("HelloServlet's constructor...");
    }

}
