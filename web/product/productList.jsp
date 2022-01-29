<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/12/12
  Time: 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isErrorPage="false" %>
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
                    <a href="#">商品管理</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                <div style="float:left">欢迎${cookie.username.value}!</div><div style="float:right"><a href="../cart/cartList.html">我的购物车</a></div>
            </h1>
            <h5>&nbsp;</h5>
            <form action="">
                商品名:<input name="productName"/>
                价格：<select name="operation">
                <option value="0">操作</option>
                <option value=">">></option>
                <option value="<"><</option>
            </select>
                <input type="number" value="price"/>
                <input type="submit" value="搜索"/>
            </form>
            <h5 style="height: 2px;">&nbsp;</h5>
            <form action="${pageContext.request.contextPath}/product/removeAnyProduct">
            <table class="table">
                <tr class="table_header">
                    <td>
                        <input type="submit" value="删除选中" />
                    </td>
                    <td>
                        商品名
                    </td>
                    <td>
                        单价
                    </td>
                    <td>库存</td>

                    <td>
                        商品描述
                    </td>
                    <td>
                        操作
                    </td>
                </tr>
                <c:forEach var="p" items="${requestScope.products}">
                    <tr class="row1">
                        <td>
                            <input type="checkbox" name="id" id="" value="${p.productId}" />
                        </td>
                        <td>
                                ${p.productName}
                        </td>
                        <td>
                                ${p.price}￥
                        </td>
                        <td>${p.inventory}</td>

                        <td>
                                ${p.description}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/product/removeProduct?id=${p.productId} ">删除</a>
                            <a href="${pageContext.request.contextPath}/product/showOneProduct?id=${p.productId}">修改</a>
                            <a href="${pageContext.request.contextPath}/cart/addCart?id=${p.productId}">添加购物车</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            </form>
            <div>
                <p>
                    <a href="${pageContext.request.contextPath}/product/ShowProducts?productName=${requestScope.productName}&operation=${requestScope.operation}&price=${requestScope.price}&pageNum=1&pageSize=${requestScope.pageSize}" class="button">首页</a>
                    <c:forEach var="i" begin="1" end="${requestScope.totalPage}">
                        <a href="${pageContext.request.contextPath}/product/ShowProducts?productName=${requestScope.productName}&operation=${requestScope.operation}&price=${requestScope.price}&pageNum=${i}&pageSize=${requestScope.pageSize}" class="button">${i}</a>
                    </c:forEach>
                    <a href="${pageContext.request.contextPath}/product/ShowProducts?productName=${requestScope.productName}&operation=${requestScope.operation}&price=${requestScope.price}&pageNum=${requestScope.totalPage}&pageSize=${requestScope.pageSize}" class="button">尾页</a>
                </p>
            </div>
            <p>
                <a href="${pageContext.request.contextPath}/product/addProduct.jsp" class="button">添加商品</a>
            </p>
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

