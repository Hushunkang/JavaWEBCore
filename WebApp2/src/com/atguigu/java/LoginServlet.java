package com.atguigu.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @description
 * @author hskBeginner 2752962035@qq.com
 * @version
 * @date 2020年2月28日下午10:48:21
 * 
 */
public class LoginServlet implements Servlet{

	public LoginServlet() {
		System.out.println("LoginServlet's constructor...");
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("LoginServlet destroy...");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#getServletConfig()
	 */
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("LoginServlet getServletConfig...");
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#getServletInfo()
	 */
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("LoginServlet getServletInfo...");
		return null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("LoginServlet init...");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Servlet#service(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// 设置请求体的字符集为UTF-8，从而解决post请求的中文乱码问题
		// 也要在获取请求参数之前调用才有效
		request.setCharacterEncoding("UTF-8");
		System.out.println("LoginServlet service...");
		System.out.println("请求来喽...");
		
		System.out.println(request);//org.apache.catalina.connector.RequestFacade@5ba12d2c
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		String interest = request.getParameter("interesting");
		String[] interests = request.getParameterValues("interesting");
		System.out.println(interest);
		for (String interest2 : interests) {
			System.out.println(interest2);
		}
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String parameterName = parameterNames.nextElement();
			System.out.println(parameterName);
			System.out.println(request.getParameter(parameterName));
		}
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<String> keySet = parameterMap.keySet();
		for (String key : keySet) {
			System.out.println("key:" + key + ",value:" + Arrays.asList(parameterMap.get(key)));
		}
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;//向下转型
		String requestURI = httpServletRequest.getRequestURI();
		StringBuffer requestURL = httpServletRequest.getRequestURL();
		String method = httpServletRequest.getMethod();
		String queryString = httpServletRequest.getQueryString();
		String serverName = httpServletRequest.getServerName();
		int serverPort = httpServletRequest.getServerPort();
		String servletPath = httpServletRequest.getServletPath();
		System.out.println(requestURI);
		System.out.println(requestURL);
		System.out.println(method);
		System.out.println(queryString);//get请求才有值，post请求为null
		System.out.println(serverName);
		System.out.println(serverPort);
		System.out.println(servletPath);
		
		//设置响应内容的类型
//		response.setContentType("application/msword;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String str = "Hello world...";
		//将print方法的实参直接输出到客户端浏览器上面
		out.print(str);
	}

}
