package com.tianmao.servlet;

import com.tianmao.dao.UserDao;
import com.tianmao.entity.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ls")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String mark = req.getParameter("username");
        String pass = req.getParameter("password");


        //2. 执行业务逻辑，完成请求处理
        UserDao dao = new UserDao();
        User user = dao.findUserByMark(mark, pass);
        if (user != null && pass.equals(user.getPaassword())) {
            HttpSession session = req.getSession();
            session.setAttribute("isLogin", true);
            session.setAttribute("user", user);
            resp.sendRedirect("index.jsp");

        } else {
            resp.sendRedirect("loginFail.html");
        }

    }
}
