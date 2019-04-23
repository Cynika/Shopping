package com.tianmao.servlet;

import com.tianmao.entity.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 点击“加入购物车”按钮，添加产品到购物车，该Servlet负责处理添加到购物车的请求
 *
 * @author Anna
 */
@WebServlet("/cs")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 获取请求参数
        String pid = req.getParameter("pid");
        String pname = req.getParameter("pname");
        //单价是float类型，所以可以调用Float类的静态方法将获取的字符串单价转换成float类型
        float pprice = Float.parseFloat(req.getParameter("pprice"));
        String punit = req.getParameter("punit");
        //将提交的字符串数量转成整数类型
        int qty = Integer.parseInt(req.getParameter("qty"));

        //最好是将一个产品的5项信息封装成一个产品对象，然后加入购物车
        //Product类有一个构造函数接受5个参数，用于给产品的五项信息赋值
        //只不过这次数量不表示库存量，而是表示加入购物车的数量
        Product p = new Product(pid, pname, pprice, punit, qty);

        List<Product> list = null; //定义一个购物车列表，一开始为null
        HttpSession session = req.getSession(); //获取会话对象

        //维护一个产品列表，列表中都是产品对象，列表中每个产品表示购物车中的一个产品
        //每次添加一个产品，将产品对象添加到该列表即可

        //如果会话中已经有个属性叫做cartList，也就是该属性的值不为null
        //则表示不是第一次添加购物车
        if (null != session.getAttribute("cartList")) {
            //如果不是第一次添加产品到购物车，说明列表已经有了，则直接从会话获取列表
            //继续添加产品即可
            list = (List<Product>) session.getAttribute("cartList");
            list.add(p); //将新产品添加到购物车列表
        } else { //是第一次添加购物车
            list = new ArrayList(); //创建购物车列表
            list.add(p); //添加第一个产品
            //可考虑在会话期间维护购物车列表,这里将购物车列表添加到会话中
            session.setAttribute("cartList", list);
        }
        //因为数据是放到了会话中，而不是请求中，没必要转发请求
        //所以通过重定向跳转页面即可
        resp.sendRedirect("cart.jsp");
    }
}
