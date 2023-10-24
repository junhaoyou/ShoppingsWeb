<%--
  Created by IntelliJ IDEA.
  User: 16141
  Date: 2023/11/23
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>选课信息</title>
    <style>
        span {
            color: #4424d3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #1ddabe;
            padding: 8px;
            text-align: center;

        }

        th {
            background-color: #13da63;
            align: center;
        }

        tr:hover {
            background-color: #e55e5e;
        }

        .select-button {
            padding: 5px 10px;
            background-color: #4caf50;
            color: #812222;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>选课信息</h1>
<div>
<table>
    <thead>
    <tr>
        <th>课程编号</th>
        <th>课程名称</th>
        <th>授课老师</th>
        <th>学分</th>
        <th>上课时间</th>
        <th>上课地点</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${copyCourse2}" var="course1">
        <tr>
            <td>${ course1.course_id}</td>
            <td>${ course1.course_name}</td>
            <td>${ course1.teacher}</td>
            <td>${ course1.point}</td>
            <td>${ course1.time_1}<br>${ course1.time_2}</td>
            <td>${ course1.location}</td>
            <td>
                <button class="select-button"><a href="${pageContext.request.contextPath}/DeleteServlet?course_id=${ course1.course_id}">退选</a></button>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>当前总学分为:<span><b>${pointSum}</b></span></td>
    </tr>

    </tbody>
</table>
</div>
<div>
    <a href="javascript:history.back()">返回上一页</a>
</div>
</body>
</html>
