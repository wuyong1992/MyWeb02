package com.wy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wuyong on 2016/12/18.
 */
@WebFilter(filterName = "PasswordFilter"/*,urlPatterns = {"/LoginServlet","/loginSucceed.jsp"}*/)
public class PasswordFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String password = request.getParameter("password");
        HttpServletRequest res = (HttpServletRequest) request;
       /* if (res.getRequestURI().indexOf("index.jsp") != -1) {
            chain.doFilter(request, response);
            return;
        }*/
        if (null == password || "".equals(password)||!"123".equals(password)) {
            out.println("<script language='JavaScript'>alert('Password Wrong!!');window.location.href='index.jsp';</script>");
        }else {
            res.getSession().setAttribute("password",password);
            chain.doFilter(request, response);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
