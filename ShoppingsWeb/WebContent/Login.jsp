<%@ page language="java" contentType="text/html; charset=UTF-8" import="enter.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<style type="text/css">
body{
 width:1100px;
 text-align:center;
 margin-left:auto;
 margin-right:auto;
/*  background-image: linear-gradient(to right top, #d16ba5, #c777b9, #ba83ca, #aa8fd8, #9a9ae1, #8aa7ec, #79b3f4, #69bff8, #52cffe, #41dfff, #46eefa, #5ffbf1);
 */ 
 height:735px;
 background-image:url('image/beijingtu.jpg');
 background-position:center center;
 background-size:cover;
 }
.div_01{
 border:2px solid #aaaaaa;
 width :1100px;
 height :100px;
 font-size :20pt;
 line-height :100%;
 padding: 10px;
 border-radius: 50px 20px;
 box-shadow: 10px 10px 5px #888888;
 /*opacity:0.6;/* 设置透明度 */
 background-color:rgba(255, 255, 255, 0.3);
 filter:alpha(opacity=60);/* 设置透明度 */
 }
 .div_02{
 border:2px solid #aaaaab;
 width :1100px;
 height :200px;
 font-size :20pt;
 line-height :100%;
 padding: 10px;
 border-radius: 50px 50px 50px 50px;
 /* opacity:0.6; */
 background-color:rgba(255, 255, 255, 0.3);
 filter:alpha(opacity=60);
 }
h1.serif{font-family:"Times New Roman",Times,serif;}
</style>
</head>
<body>
<%
String remember = (String)session.getAttribute("remember");
String user = (String)session.getAttribute("username");
%>
<div class="div_01">
	<h1 class="serif">购物登录界面，欢迎您！</h1>
</div>
<br/>
<div class="div_02" align="center">
    <form action="LoginServlet" method="post">
        用户名：<input type="text" name="username" value="<%=user==null? "":user %>"/><br>
        密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" value="<%=remember==null? "":remember %>"/><br>
        <input type="checkbox" name="remember" value="1"/>记住密码
        <input type="checkbox" name="autologin" value="1"/>自动登录<br>
        <input type="hidden" name="action" value="login"/>
        <input type="submit" value="登录">
    </form>
    <a href="register.jsp">注册</a>
</div>
</body>
</html>