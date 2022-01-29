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

@WebServlet(urlPatterns = "/product/ShowProducts")
public class ShowProductController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //收参  pageNum和pageSize
        String pageNumStr = request.getParameter("pageNum");
        String pageSizeStr = request.getParameter("pageSize");
        String productName = request.getParameter("productName");
        if(productName==null){
            productName="";
        }
        String operation = request.getParameter("operation");
        if(operation==null||operation.equals("0")){
            operation=">";

        }
        String priceStr = request.getParameter("price");
        double price=0.0;
        if(priceStr!=null&&priceStr.length()>0){
           price = Double.parseDouble(priceStr);

        }

        int pageNum=1;
        int pageSize=5;
        if(pageNumStr!=null&&!pageNumStr.isEmpty()){
            pageNum=Integer.parseInt(pageNumStr);
        }
        if(pageSizeStr!=null&&!pageSizeStr.isEmpty()){
            pageSize = Integer.parseInt(pageSizeStr);
        }



        //调用业务层方法
        ProductServiceImpl productService = new ProductServiceImpl();
        List<Product> products = productService.listProducts(productName,operation,price,pageNum,pageSize);//查询分页的数据
        //根据查询总条数，计算总页数
        int totalRows=productService.totalRows(productName,operation,price);
        int totalPage=totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;



        //跳转到展示的jsp
        request.setAttribute("products",products);
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("pageSize",pageSize);

        //将请求中的条件保存到作用域中，目的是为了构造具有相同查询条件的超链接页码
        request.setAttribute("productName",productName);
        request.setAttribute("operation",operation);
        request.setAttribute("price",price);

        request.getRequestDispatcher("/product/productList.jsp").forward(request,response);



    }
}
