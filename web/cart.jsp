<%@page import="java.util.List"%>
<%@page import="com.tianmao.entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="images/shortcut.png" rel="shortcut icon" type="image/x-icon"/>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
        <title>购物车信息</title>
    </head>
    <body>

        <div class="container">

            <h1 class="text-center text-danger">购物车信息</h1>
            <br>
            <br>

            <a href="#" class="info"><%="当前登录："+session.getAttribute("name")%></a>
            <a href="los" class="logout">退出登录</a>

            <!--这里给出了购物车中一个产品的显示格式-->
            <%
                List<Product> clist = (List<Product>) session.getAttribute("cartList");
                if (null == clist) { //如果购物车是空的，说明还没有添加过产品到购物车
                    out.println("<br><h1>尚未添加任何产品到购物车！</h1>");
                    return;  //如果还没添加产品到购物车，直接return即可，无需执行后续代码
                }
                //如果购物车不为null，才会执行循环
                float total = 0; //定义一个变量，用于存储总计金额
                for (Product p : clist) { //遍历集合clist中的每个产品对象p
                    total += p.getProductPrice() * p.getProductQty(); //每次总计金额在原来的基础上加上本次小计金额
            %>
            <div class="cartProduct"> <!--每个div显示购物车中一个产品的信息-->
                <img src="images/<%=p.getProductId()%>.jpg" width="120" height="120"> 
                <hr>
                产品名称：<%=p.getProductName()%>
                <br>产品单价：<%=p.getProductPrice()%> 
                <br>包装单位：<%=p.getProductUnit()%>
                <br>购买数量：<%=p.getProductQty()%>
                <br><b class="text-primary">小计金额：<%=p.getProductPrice() * p.getProductQty()%></b>
            </div>
            <% }%>
            <hr>
            <h3 class="text-danger">总计金额：<%=total%></h3>

        </div>
    </body>
</html>
