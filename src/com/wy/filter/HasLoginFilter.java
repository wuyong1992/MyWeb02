package com.wy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 判断是否已经登录
 * Created by Administrator on 2016/12/19.
 */
@WebFilter(filterName = "HasLoginFilter",urlPatterns = {"/loginSucceed.jsp"})
public class HasLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("HasLoginFilter执行中...");

        PrintWriter out = resp.getWriter();
        //向下转型
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        HttpServletResponse response = (HttpServletResponse) resp;

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //从session中取值
        Map userInfo = (Map) session.getAttribute("user");
        //只要Map的key大于0，则认为已经登录；日后完善，过滤权限

        if (userInfo==null) {
            //如果判断没有登录过，则返回登录界面
            out.println("<script language='JavaScript'>alert('Please enter the correct user name and password!!');window.location.href='index.jsp';</script>");
            /*response.sendRedirect("index.jsp");*/
        }else if (userInfo.keySet().size() > 0) {
            request.getRequestDispatcher("loginSucceed.jsp").forward(request, response);
        } else {
            //现在只有这一个过滤，不需要向下传
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

        System.out.println("HasLoginFilter初始化");
    }

}
