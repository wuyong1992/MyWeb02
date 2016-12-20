<%--
  Created by IntelliJ IDEA.
  User: wuyong
  Date: 2016/12/18
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="Demo01JS.js"></script>
<html>
<head>
    <title>indexDemo01</title>
    <link rel="stylesheet" href="Demo01CSS.css">
</head>
<body>

<div class="cont">
    <div class="head">
        <button type="button" id="loginBtn" class="loginButton"><span>Login</span></button>
    </div>
    <div class="main">
        <div class="left"><p>Left</p></div>
        <div class="right"><p>right</p></div>
    </div>
    <div class="foot">
        <p>foot</p>
        <div class="userNum">
            <a href="userNumber.jsp">在线人数</a>
        </div>
    </div>
</div>

<%--遮罩层--%>
<%--<div id="mask">--%>

<%--登陆框--%>
<%--</div>
<div id="loginBox">
    <form action="#">
        <p>Login</p>

        <input type="text" name="name" class="name padding" placeholder="name">

        <input type="password" name="password" class="password padding" placeholder="password">

        <div class="SandR">
        <input type="submit" value="登陆" class="sub">

        <input type="reset" value="重置" class="res">
        </div>
    </form>
    <button type="button" id="closeBtn">关闭</button>
</div>--%>
</body>
</html>
