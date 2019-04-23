package com.tianmao.servlet;

import com.tianmao.dao.ProductDao;
import com.tianmao.entity.Product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 该Servlet处理根据产品编号查询产品的请求,然后将查询出来的产品信息交给productInfo.jsp显示
 *
 * @author Anna
 */
@WebServlet("/ps")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 获取请求参数
        String pid=req.getParameter("pid");
        
        //2. 执行业务逻辑，完成请求处理
        ProductDao dao=new ProductDao();
        Product pro=dao.findProductById(pid); //根据产品编号查询单个产品的所有信息
        
        //3. 将查询到的信息共享给productInfo.jsp页面显示
        //如果希望将一些信息共享到下个servlet或jsp，而不是通过会话共享
        //则可以考虑将信息作为属性添加到请求对象，然后转发请求
        //可以将产品对象作为一个属性放入请求对象，这里属性名是product
        req.setAttribute("product", pro);
        //将同一个请求对象和响应对象转发给productInfo.jsp
        //这样productInfo.jsp收到的请求是同一个请求，所以可以获取到共享的数据
        req.getRequestDispatcher("/productInfo.jsp").forward(req, resp);
    }
}
