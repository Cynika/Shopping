<%@ page import="com.tianmao.entity.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>天猫首页</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="images/shortcut.png" rel="shortcut icon" type="image/x-icon"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>


<div class="container">

    <div class="top">
        <div class="top_left"><img src="images/tmall.png" alt="天猫logo"></div>
        <div class="top_right"><h1>欢迎来到天猫，理想生活上天猫......</h1></div>
    </div>
    <%
        Object login = session.getAttribute("isLogin");
        Object info = session.getAttribute("user");
        User uer = (User) info;

        if (null != login) {
    %>
    <a href="#" class="info"><%=uer.getName()%>
    </a>
    <a href="los" class="logout">退出登录</a>
    <%
    } else {
    %>
    <a href="login.html" class="info">登录</a>
    <%
        }
    %>

    <hr>

    <h3>最新活动</h3>
    <br>

    <ul>
        <!--可以通过url重写追加请求参数，体现是不同的产品-->
        <li><a href="ps?pid=P001">卫龙辣条，你值得拥有</a></li>
        <li><a href="ps?pid=P002">青岛大虾，不一样的大虾</a></li>
        <li><a href="ps?pid=P003">四级真题，600包过</a></li>
        <li><a href="ps?pid=P004">快乐肥宅水，你今天快乐了吗？</a></li>
    </ul>

    <br>
    <a href="cart.jsp">查看购物车</a>

</div>
</body>
</html>
