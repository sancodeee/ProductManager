package com.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/validateCode")
public class ValidateCodeController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //生成验证码
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(200, 100);
        //将真实的验证码保存在session中
        String code = captcha.getCode();
        System.out.println(code);
        HttpSession session = request.getSession();
        session.setAttribute("realCode",code);
        //将验证码响应给浏览器（以前是文本内容，需要字符输出流）
        ServletOutputStream outputStream = response.getOutputStream();//图片是二进制文件，字节输出流
        captcha.write(outputStream);



    }
}
