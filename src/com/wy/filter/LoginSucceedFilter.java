package com.wy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wuyong on 2016/12/18.
 */
@WebFilter(filterName = "LoginSucceedFilter",urlPatterns = {"/loginSucceed.jsp"})
public class LoginSucceedFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String name= (String) request.getAttribute("name");
        String password= (String)request.getAttribute("password");
        HttpServletResponse resp = (HttpServletResponse) response;
        if ("wuyong".equals(name) && "123".equals(password)) {
            resp.sendRedirect("loginSucceed.jsp");
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
