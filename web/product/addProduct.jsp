<%@ page import="com.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/12/13
  Time: 0:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>添加商品</title>
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
                添加商品:
            </h1>
            <form action="${pageContext.request.contextPath}/product/addProduct" method="post">

                <table cellpadding="0" cellspacing="0" border="0" class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            商品名:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="productName"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            价格:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="price"/>(￥)
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            库存:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="inventory"/>(个)
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            商品描述:
                        </td>
                        <td valign="middle" align="left">
                            <textarea rows="4" cols="30" class="inputgri" name="description" tabindex="0"></textarea>
                        </td>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="确认" />
                </p>
            </form>
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
