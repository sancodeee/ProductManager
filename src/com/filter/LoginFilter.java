package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        //ServletRequest是HttpServletRequest的父型类
        //父接口引用强转为子接口引用
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //进行登录判断
        HttpSession session = request.getSession();
        Object login = session.getAttribute("login");
        if(login==null){
            //说明之前没有登录
            response.sendRedirect( request.getContextPath()+"/managerLogin.jsp");
            return;
        }
        //满足条件：之前登录过，要放行请求到Servlet
        filterChain.doFilter(servletRequest, servletResponse);



    }

    @Override
    public void destroy() {

    }
}
