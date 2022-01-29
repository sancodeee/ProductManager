<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/12/15
  Time: 1:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>商品列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- 在web项目中 css的路径要替换为 css文件的uri
    也就是 /项目名/css/style.css
    -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">

            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">购物车管理</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                欢迎${cookie.username.value}!
            </h1>
            <table class="table">
                <tr class="table_header">
                    <td>
                        序号
                    </td>
                    <td>
                        商品名
                    </td>
                    <td>
                        单价
                    </td>

                    <td>数量</td>
                    <td>总价</td>
                    <td>
                        操作
                    </td>
                </tr>
                <c:forEach var="e" items="${sessionScope.cart.items}" varStatus="vs">
                    <%-- e:键值对对象  key:商品id  value :购物车信息对象CartItem对象
                      e.key 商品id  e.value cartItem对象（product属性和size 属性）--%>

                <tr class="row1">
                    <td>
                        ${vs.count}
                    </td>
                    <td>
                        ${e.value.product.productName}
                    </td>
                    <td>
                        ${e.value.product.price}￥
                    </td>
                    <td>${e.value.size}</td>
                    <td>${e.value.product.price * e.value.size}￥</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/cart/removeCart?id=${e.key}"><input type="button" value="删除"/></a>
                        <a href="${pageContext.request.contextPath}/cart/increaseCart?id=${e.key}"><input type="button" value="+"/></a>&nbsp;
                        <a href="${pageContext.request.contextPath}/cart/decreaseCart?id=${e.key}"><input type="button" value="-"/></a>
                    </td>
                </tr>

                </c:forEach>
            </table>

        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            www.zparkhr.com.cn
        </div>
    </div>
</div>
</body>
</html>
