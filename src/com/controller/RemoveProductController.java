package com.controller;

import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/product/removeProduct")
public class RemoveProductController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();
        //接受客户端请求参数
        String idstr = request.getParameter("id");
        int id = Integer.parseInt(idstr);
        //调用业务层方法
        ProductService productService = new ProductServiceImpl();
        //根据结果跳转
        try {
            productService.removeProduct(id);
            response.sendRedirect(contextPath+"/product/ShowProducts");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("删除失败");
            response.sendRedirect(contextPath+"/product/ShowProducts");
        }

    }
}
