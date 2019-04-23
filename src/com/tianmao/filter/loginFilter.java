package com.tianmao.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "loginFilter",urlPatterns={"/cart.jsp","/cs"})
public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req=(HttpServletRequest)request;
        //sendRedirect()方法是HttpServletResponse接口的，所以响应对象也要转换类型
        HttpServletResponse resp=(HttpServletResponse)response;
        //如果还没有会话对象，说明没登录，我们也不希望在过滤器中创建对象
        //所以调用getSession(false)表示有会话返回会话对象，没有返回null
        HttpSession session=req.getSession(false);
        //如果会话不为null，并且会话中有isLogin这个属性（该属性不为null说明有该属性）d
        if(null!=session&&null!=session.getAttribute("isLogin")){
            chain.doFilter(request, response); //放行请求去访问资源
        }else{
            //else说明没有登录，则不调用FilterChain的doFilter()方法
            //但是这里不能使用相对路径，所以需要获取程序的上下文路径，再追加上warning.html，使用该页面的完整路径
            //该程序的上下文路径是http://localhost:8084/C02_D16_UseFilter2
            String ctxPath=req.getContextPath()+"/"; //获取程序的上下文路径
            //ctxPath+"warning.html形成的路径是http://localhost:8084/C02_D16_UseFilter2/warning.html
            resp.sendRedirect(ctxPath+"warning.html"); //这里使用warning.html的完整路径
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
