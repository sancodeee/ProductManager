package com.controller;


import com.service.UsersService;
import com.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();
        //接受客户端请求参数
        String username = request.getParameter("username");
        System.out.println(username);
        String pwd1 = request.getParameter("pwd1");
        System.out.println(pwd1);
        String pwd2 = request.getParameter("pwd2");
        System.out.println(pwd2);
        String validateCode = request.getParameter("validateCode");
        System.out.println(validateCode);//用户输入的验证码
        //首先进行验证码的比对
        HttpSession session1 = request.getSession();
        String realCode =(String) session1.getAttribute("realCode"); //获取真实的验证码
        if(validateCode==null|| !validateCode.equals(realCode)){
            //验证码不相同，重定向到登录页面
            response.sendRedirect(contextPath+"/managerRegist.jsp");
            return;
        }
        //再进行二次秘密的一致比对
        if(!pwd1.equals(pwd2)){
            //两次密码不相同，重定向到登录页面
            response.sendRedirect(contextPath+"/managerRegist.jsp");
            return;
        }

        //调用业务层的注册方法
        UsersService usersService = new UsersServiceImpl();
        //根据结果跳转

        try{//注册成功跳转登录页面
            usersService.register(username,pwd1,pwd2);
            response.sendRedirect(contextPath+"/managerLogin.jsp");
        }catch (Exception e){
            //注册失败跳转到注册页面
            e.printStackTrace();
            response.sendRedirect(contextPath+"/managerRegist.jsp");
        }

    }
}
