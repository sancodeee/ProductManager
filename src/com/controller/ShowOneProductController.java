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

@WebServlet(urlPatterns = "/product/showOneProduct")
public class ShowOneProductController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.收参  获取id
        String idstr = request.getParameter("id");
        int id = Integer.parseInt(idstr);
        //2.调用业务层方法   根据id查询Product的方法
        ProductService productService = new ProductServiceImpl();
        Product product = productService.getProductById(id);
        //3.跳转到view
        request.setAttribute("p",product);
        request.getRequestDispatcher("/product/updateProduct.jsp").forward(request,response);


    }
}
