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
            background-color: #f5f5f5;
            padding: 10px;
            border-radius: 5px;
        }
        a:hover {
            background-color: #e5e5e5;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>线上选课系统教师端功能界面</h1>
    <a href="${pageContext.request.contextPath}/TeacherCourseShowServlet">课程信息</a>
    <a href="static/jsp/addCourse.jsp">添加课程信息</a>
</div>
</body>
</html>
