<%--
  Created by IntelliJ IDEA.
  User: wuyong
  Date: 2016/12/21
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>颜色渐变</title>
    <link rel="stylesheet" href="../style/Normalize.css">
    <link rel="stylesheet" href="page01style.css">
    <style>
        #block {
            width: 400px;
            height: 400px;
            background-color: #6699cc;
            margin: 0 auto;
            -webkit-transition: background-color 3s;
        }

        /*伪类*/
        #block:hover {
            background-color: red;
        }
    </style>
</head>
<body>
<div id="block">

</div>
</body>
</html>
