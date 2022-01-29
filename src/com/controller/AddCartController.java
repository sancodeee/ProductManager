package com.controller;

import com.entity.Cart;
import com.entity.CartItem;
import com.entity.Product;
import com.service.ProductService;
import com.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/cart/addCart")
public class AddCartController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1. 收参  获取商品id
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        //2.将商品添加的购物车中
        //首先获取购物车，分两种情况:1，第一次使用购物车  2.第二次使用购物车
        HttpSession session = request.getSession();
        Cart cart = ((Cart) session.getAttribute("cart"));
        if(cart==null){
             cart = new Cart();
             session.setAttribute("cart",cart);
        }
        //从购物车中获取到真正保存数据到map集合（添加商品：本质是上向集合中添加数据）
        Map<Integer, CartItem> items = cart.getItems();
        //添加商品分两种情况:1，第一次添加商品  2.第二次添加商品

        if(!items.containsKey(id)){//如果第一次添加，向Map中添加键值对
            CartItem cartItem = new CartItem();
            cartItem.setSize(1);
            ProductService productService = new ProductServiceImpl();
            Product product = productService.getProductById(id);
            cartItem.setProduct(product);
            items.put(id,cartItem);

        }else {  //如果第二次添加 ，更新之前添加的购物车信息的数量
            CartItem cartItem = items.get(id);
            cartItem.setSize(cartItem.getSize()+1);
        }
        //3.跳转到jsp
        response.sendRedirect(request.getContextPath()+"/cart/cartList.jsp");


   }
}
