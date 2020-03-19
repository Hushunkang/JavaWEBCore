package com.atguigu.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * 使用过滤器来拦截请求---检查用户是否有登录，也就是权限检查
 *
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月20日 04时19分18秒
 */
public class AdminFilter implements Filter {

    public AdminFilter() {
        System.out.println("1AdminFilter's constructor...");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2AdminFilter's init...");

        //1.获取Filter的名称
        System.out.println("filter-name为：" + filterConfig.getFilterName());
        //2.获取在web.xml中配置的init-param初始化参数
        System.out.println("初始化参数username为：" + filterConfig.getInitParameter("username"));
        System.out.println("初始化参数password为：" + filterConfig.getInitParameter("password"));
        //3.获取ServletContext对象
        System.out.println(filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("3AdminFilter's doFilter...");
        HttpServletRequest req = (HttpServletRequest) request;//强制类型转换，向下转型

        HttpSession session = req.getSession();
        Object user = session.getAttribute("username");
        //如果为null，表明用户还没有登录
        if (user == null) {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return ;//请求转发后就不需要执行代码了，这里return一哈
        }else{
            //让程序继续往下访问用户的目标资源，相当于放行，这行代码很重要千万不要省略
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("4AdminFilter's destroy...");
    }

}
