
<%@page import="com.tianmao.entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="images/shortcut.png" rel="shortcut icon" type="image/x-icon"/>
        <title>产品信息</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>

        <h1 class="text-center text-primary">产品信息</h1>
        <br>
        <br>
        <hr>
        <br>

        <a href="cart.jsp" class="viewcart">查看购物车</a>
        <a href="los" class="logout">退出登录</a>

        <!--在此div中显示从数据库查询到的一个产品的所有信息-->

        <%
            //因为ps这个servlet转发了请求给productInfo.jsp
            //所以productInfo.jsp收到的请求就是ps收到的请求，两个处理的是同一个请求
            Product p = (Product) request.getAttribute("product");
        %>

        <div class="content">
            <br>
            <!--显示产品图片，图片在images文件夹中给出了，以产品的编号命名的图片-->
            <img src="images/<%=p.getProductId()%>.jpg" class="pic">  

            <h3>产品名称： <%=p.getProductName()%>  </h3>
            <p>产品单价： <%=p.getProductPrice()%>   </p>
            <p>包装单位： <%=p.getProductUnit()%>   </p>
            <p>剩余库存： <%=p.getProductQty()%>   </p>

            <!--这里提交表单，请求发送给cs这个servlet，处理将产品加入购物车的请求-->
            <form action="cs" class="form-inline">
                <b>购买数量：</b>
                <input type="number" min="1" name="qty" value="1" class="form-control">
                <br><br>
                <!--因为不想让用户看见的方式提交一些数据，可以使用隐藏字段-->
                <input type="hidden" name="pid" value="<%=p.getProductId()%>">
                <!--为了简化程序，后续不再次查数据库，这里将产品其他信息也提交-->
                <input type="hidden" name="pname" value="<%=p.getProductName()%>">
                <input type="hidden" name="pprice" value="<%=p.getProductPrice()%>">
                <input type="hidden" name="punit" value="<%=p.getProductUnit()%>">
                <input type="submit" value="加入购物车" class="btn btn-sm btn-danger"> &nbsp;
                <input type="submit" value="立刻购买" class="btn btn-sm btn-warning">
            </form>
        </div>

        <br>

    </body>
</html>
