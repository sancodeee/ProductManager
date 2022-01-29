package com.controller;



import com.entity.Product;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/product/addProduct")
public class AddProductController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();
        String productName = request.getParameter("productName");
        String priceStr = request.getParameter("price");
        String inventoryStr = request.getParameter("inventory");
        String description = request.getParameter("description");
        double price = Double.parseDouble(priceStr);
        int inventory = Integer.parseInt(inventoryStr);
        //调用业务层方法   根据异常处理成功还是失败
        ProductService productService = new ProductServiceImpl();
        try {
            productService.saveProduct(new Product(null,productName,price,inventory,description));
            //System.out.println("添加成功");
            response.sendRedirect(contextPath+"/product/ShowProducts");

        }catch (Exception e){
            e.printStackTrace();
            //System.out.println("添加失败");
            response.sendRedirect(contextPath+"/product/ShowProducts");
        }
    }
}
