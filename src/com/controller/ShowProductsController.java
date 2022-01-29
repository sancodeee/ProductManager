package com.controller;



import com.entity.Product;
import com.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(urlPatterns = "/product/ShowProducts")
public class ShowProductsController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //调用业务层方法
        ProductServiceImpl productService = new ProductServiceImpl();
        List<Product> products = productService.listProducts();


        //跳转到展示的jsp
        request.setAttribute("products",products);
        request.getRequestDispatcher("/product/productList.jsp").forward(request,response);//请求转发



    }
}
