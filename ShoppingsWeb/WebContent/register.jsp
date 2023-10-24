<%@ page language="java" contentType="text/html; charset=UTF-8" import="src.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
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
  .div_03{
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
</style>
</head>
<body>
<div class="div_03" align="center">
<form action="LoginServlet" method="post">
        用户名：<input type="text" name="username"/><br>
        密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"/><br>
        重复密码：<input type="password" name="repassword"/><br>
        <input type="hidden" name="action" value="register"/>
        <input type="submit" value="注册">
</form>
</div>
</body>
</html>