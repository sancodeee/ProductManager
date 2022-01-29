package com.controller;


import com.service.UsersService;
import com.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();
        //接受客户端请求参数
        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        System.out.println(password);
        String validateCode = request.getParameter("validateCode");
        System.out.println(validateCode);//用户输入的验证码
        //获取真实的验证码
        HttpSession session1 = request.getSession();
        String realCode =(String) session1.getAttribute("realCode");
        if(!(validateCode!=null&&validateCode.equals(realCode))){
            //验证码不相同，重定向到登录页面
            response.sendRedirect(contextPath+"/managerLogin.jsp");
            return;

        }

        //对比数据库:调用UserService的login方法
        UsersService usersService = new UsersServiceImpl();
        boolean login = usersService.login(username, password);
        //根据结果跳转
        if(login){//如果登录成功，跳转到查询所有的页面
            Cookie cookie = new Cookie("username", username);
            response.addCookie(cookie);
            HttpSession session = request.getSession();
            //设置登录标识
            session.setAttribute("login",true);

            response.sendRedirect(contextPath+"/product/ShowProducts");
        }else{//如果登录失败，跳转到登录页面
            response.sendRedirect(contextPath+"/managerLogin.jsp");
        }
   }

}