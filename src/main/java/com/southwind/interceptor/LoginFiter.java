package com.southwind.interceptor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFiter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if(session.getAttribute("object")==null
                && request.getRequestURI().indexOf("/login") == -1){
            // 没有登录
            response.sendRedirect("login.jsp");
        }else{
            // 已经登录，继续请求下一级资源（继续访问）
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
