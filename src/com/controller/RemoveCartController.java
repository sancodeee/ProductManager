package com.controller;

import com.entity.Cart;
import com.entity.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/cart/removeCart")
public class RemoveCartController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.收参  获取商品id
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        //2.从购物车中移除以当前商品id为key的键值对数据
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Map<Integer, CartItem> items = cart.getItems();
        items.remove(id);
        //3.跳转到购物车
        response.sendRedirect(request.getContextPath()+"/cart/cartList.jsp");


    }
}
