package com.controller;

import com.entity.Cart;
import com.entity.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/cart/increaseCart")
public class IncreaseCartController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 收参  获取商品id
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        //2.根据商品id  自增购物车中商品数量
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Map<Integer, CartItem> items = cart.getItems();
        CartItem cartItem = items.get(id);
        cartItem.setSize(cartItem.getSize()+1);
        //3.跳转到jsp
        response.sendRedirect(request.getContextPath()+"/cart/cartList.jsp");


    }
}
