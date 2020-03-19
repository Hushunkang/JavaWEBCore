package com.atguigu.servlet;

import com.google.code.kaptcha.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //谷歌的生成图片验证码的Servlet，KaptchaServlet，生成图片验证码的同时还将验证码文本的数据放到了session域中
        //获取Session中的验证码
        String token = (String) req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        req.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);


        String code = req.getParameter("code");
        //获取用户名
        String username = req.getParameter("username");

        if (token != null && token.equalsIgnoreCase(code)) {
            System.out.println("保存到数据库：" + username);
            resp.sendRedirect(req.getContextPath() + "/ok.jsp");
        } else {
            System.out.println("请不要重复提交表单");
        }
    }

}
