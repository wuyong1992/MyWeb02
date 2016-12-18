package com.wy.filter;

import sun.font.Script;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wuyong on 2016/12/18.
 */
@WebFilter(filterName = "NameFilter",urlPatterns = {"/LoginServlet"/*,"/loginSucceed.jsp"*/})
public class NameFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        /*HttpServletRequest res = (HttpServletRequest) request;
        if (res.getRequestURI().indexOf("index.jsp") != -1) {
            chain.doFilter(request, response);
            return;
        }
*/
        if (null == name || "".equals(name)||!"wuyong".equals(name)) {
            out.println("<script language='JavaScript'>alert('UserName Wrong!!');window.location.href='index.jsp';</script>");
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
