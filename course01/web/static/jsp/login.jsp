<%--
  Created by IntelliJ IDEA.
  User: 16141
  Date: 2023/11/20
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <!DOCTYPE html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>登录界面</title>

        </script>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
            }
            .login-container {
                background-color: white;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                width: 400px;
                padding: 2rem;
            }
            h1 {
                text-align: center;
                margin-bottom: 1rem;
            }
            input[type="text"], input[type="password"] {
                display: block;
                width: 100%;
                padding: 0.5rem;
                margin-bottom: 1rem;
                border: 1px solid #ccc;
                border-radius: 3px;
            }
            button {
                background-color: #007bff;
                color: white;
                border: none;
                border-radius: 3px;
                padding: 0.5rem 1rem;
                cursor: pointer;
                width: 100%;
            }
            button:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
<body>
<div class="login-container">
    <h1>在线选课系统登录登录</h1>
    <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
        <input type="text" placeholder="用户名" name="username" required>
        <input type="password" placeholder="密码" name="password" required>
        <input type="radio" name="identity" value="0" required>学生
        <input type="radio" name="identity" value="1" required>老师
        <button type="submit" >登录</button>
    </form>

</div>
</body>
</html>
