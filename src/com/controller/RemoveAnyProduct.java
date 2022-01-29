package com.controller;



import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/product/removeAnyProduct")
public class RemoveAnyProduct extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取所有的id
        String[] ids = request.getParameterValues("id");
        //循环调用业务层方法
        ProductService productService = new ProductServiceImpl();
        for (String s : ids) {
            int id = Integer.parseInt(s);
            productService.removeProduct(id);
        }
        //跳转到查询所有
        response.sendRedirect(request.getContextPath()+"/product/ShowProducts");


    }
}
