<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>

<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>教务系统学生端功能界面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
        }
        h1 {
            text-align: center;
        }
        a {
            display: block;
            margin: 10px 0;
            text-decoration: none;
            color: #333;
            background-color: #d3cfcf;
            padding: 10px;
            border-radius: 5px;
        }
        a:hover {
            background-color: #a5ce2b;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>线上选课系统学生端功能界面</h1>
    <a href="${pageContext.request.contextPath}/ShowCourseServlet">选课申请</a>

</div>
</body>
</html>
