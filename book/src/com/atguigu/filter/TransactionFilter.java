package com.atguigu.filter;

import com.atguigu.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author hskBeginner Email：2752962035@qq.com
 * @version 1.0
 * @description
 * @create 2020年03月20日
 */
public class TransactionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 使用Filter来统一给所有的Service方法都加上try-catch来管理事务
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request,response);//放行，执行本次请求的下一个filter，
            // 承接上文。。。若没有则请求目标资源，若请求的是Servlet，
            // 承接上文。。。此处则是根据请求类型调用了BaseServlet类中的doGet或者doPost方法
            JdbcUtils.commitAndClose();// 提交事务
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();//回滚事务
            e.printStackTrace();
            throw new RuntimeException(e);//把异常抛给Tomcat服务器，
            // 承接上文。。。并且设置了error-page那么出现错误了tomcat服务器就会帮我们自动跳到相应的错误页面
        }
    }

    @Override
    public void destroy() {

    }

}
