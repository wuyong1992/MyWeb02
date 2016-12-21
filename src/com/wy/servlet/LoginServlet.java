package com.wy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuyong on 2016/12/18.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //输出
        PrintWriter out = response.getWriter();
        //编码
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        //获取参数
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        //声明一个map
        Map userInfo = new HashMap();

        //将获取的姓名，密码放入map中
        userInfo.put(name, password);
        if ("吴勇".equals(name) && "123".equals(password)) {
            //将map设置入session范围
            request.getSession().setAttribute("name",name);
            request.getSession().setAttribute("user", userInfo);
            //服务器范围
            /*request.getServletContext().setAttribute("user",userInfo);*/
            response.sendRedirect("loginSucceed.jsp");
        } else {
            out.println("<script language='JavaScript'>alert('Please enter the correct user name and password!!');window.location.href='index.jsp';</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
