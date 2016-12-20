package com.wy.listener; /**
 * Created by Administrator on 2016/12/20.
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

@WebListener()
public class LoginListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    //定义全局变量
    private ServletContext app;

    //时间戳
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH：mm：ss：sss");
    String time = sdf.format(new Date());
    // Public constructor is required by servlet spec
    public LoginListener() {
    }


    //初始化
    public void contextInitialized(ServletContextEvent sce) {
        //初始化时，给app初始化！！！获取上下文
        this.app = sce.getServletContext();
        this.app.setAttribute("online", new TreeSet());

        //控制台输出信息
        System.out.println("LoginListener初始化启动！" + " " + time);
    }

    //销毁
    public void contextDestroyed(ServletContextEvent sce) {
        //控制台输出信息
        System.out.println("LoginListener销毁！" + " " + time);
    }


    public void sessionCreated(HttpSessionEvent se) {

    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
    }


    public void attributeAdded(HttpSessionBindingEvent sbe) {
        //当有用户登录时,session增加时，而不是创建时
        Set all = (Set) this.app.getAttribute("online");
        all.add(sbe.getValue());
        this.app.setAttribute("online", all);

        //控制台输出信息
        System.out.println(sbe.getValue()+"用户已登录" + " " + time);
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        //当用户退出
        Set all = (Set) this.app.getAttribute("online");
        if (all.size() > 0) {
            all.remove(sbe.getValue());
        }
        this.app.setAttribute("online", all);

        //控制台输出信息
        System.out.println(sbe.getValue()+"用户已退出" + " " + time);
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        //当回话超时，session失效
        Set all = (Set) this.app.getAttribute("online");
        if (all.size() > 0) {
            all.remove(sbe.getValue());
        }
        this.app.setAttribute("online", all);

        //控制台输出信息
        System.out.println(sbe.getValue()+"用户的回话已经超时" + " " + time);
    }
}
