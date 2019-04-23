package com.tianmao.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter")
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //该方法接收三个参数
        //1. 表示拦截的请求对象
        //2. 表示拦截的响应对象
        //3. 一个FilterChain对象，表示过滤器链，可用于操作过滤器链上的过滤器
        //可以在控制台观察下面这行代码的输出判断过滤器的doFitler()方法什么时候被调用
        request.setCharacterEncoding("utf-8"); //修改请求编码
        //FilterChain接口的doFilter（）方法的调用导致过滤器链上的下一个过滤器被调用
        //如果没有下一个过滤器，则导致过滤器链上终端的实际资被调用，也就是请求到达实际资源
        //该方法需要两个参数，也就是传递给下一个过滤器或实际资源的请求对象和响应对象
        chain.doFilter(request, response);//相当于放行的意思
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
