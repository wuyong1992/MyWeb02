<%@ page import="java.util.Set" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/20
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户在线人数</title>
</head>
<body>
<h2>当前在线用户信息：</h2>

<%
    //先从服务器取出包含用户名的set集合
    Set all = (Set) this.getServletConfig().getServletContext().getAttribute("online");
    if (all.size() > 0 || null != all) {
%>
<h3>
    用户名：
</h3>
<%
    Iterator iterator = all.iterator();
    while (iterator.hasNext()) {
%>
<%=iterator.next()%> <br>
<%
    }
} else {
%>
<h2>尚未有用户登录...</h2>
<%
    }
%>

</body>
</html>
