<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2021/12/12
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品后台管理员登陆页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- 在web项目中 css的路径要替换为 css文件的uri
    也就是 /项目名/css/style.css
    -->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/css/style.css" />
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
                管理员登陆
            </h1>
            <form action="${pageContext.request.contextPath}/login" method="post">
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            管理员账户:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="username" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            密码:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="password" />
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            验证码:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="validateCode" />
                            <img src="${pageContext.request.contextPath}/validateCode" height="40px"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            <a href="${pageContext.request.contextPath}/managerRegist.jsp">管理员账户注册</a>
                        </td>
                        <td valign="middle" align="left">
                            <input type="submit" class="button" value="登陆 &raquo;" />&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="reset" class="button" value="重置 &raquo;" />
                        </td>
                    </tr>
                </table>
                <p>

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

