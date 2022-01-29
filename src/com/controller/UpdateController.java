package com.controller;

import com.entity.Product;
import com.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/product/updateProduct")
public class UpdateController  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productIdStr = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String priceStr = request.getParameter("price");
        String inventoryStr = request.getParameter("inventory");
        String description = request.getParameter("description");
        int productId = Integer.parseInt(productIdStr);
        //int productId = Integer.parseInt(productIdStr.trim()); String.Trim()方法会去除字符串两端，不仅仅是空格字符
        double price = Double.parseDouble(priceStr);
        int inventory = Integer.parseInt(inventoryStr);
        //调用业务层方法
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.updateProduct(new Product(productId,productName,price,inventory,description));

        //跳转到查询
        response.sendRedirect(request.getContextPath()+"/product/ShowProducts");
    }
}
