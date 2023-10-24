<%--
  Created by IntelliJ IDEA.
  User: 16141
  Date: 2023/11/20
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>选课信息</title>
    <style>
        span {
            color: red;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;

        }

        th {
            background-color: #f2f2f2;
            align: center;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .select-button {
            padding: 5px 10px;
            background-color: #4caf50;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
    </style>

</head>
<body>
<div>
<h2>欢迎你<span>${username}!</span></h2>
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
            <th>限制人数</th>
            <th>已选人数</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${course}" var="course">
            <form action="${pageContext.request.contextPath}/UpdateServlet" method="get">
                <tr>
                    <td><input type="text" name="course_id" value="${ course.course_id}"></td>
                <td><input type="text" name="course_name" value="${ course.course_name}"> </td>
                <td><input type="text" name="teacher" value="${ course.teacher}"></td>
                <td><input type="text" name="point" value="${ course.point}"></td>
                <td><input type="text" name="time_1" value="${ course.time_1}"><br><input type="text" name="time_2" value="${ course.time_2}"></td>
                <td><input type="text" name="location" value="${ course.location}"></td>
                <td><input type="text" name="limited" value="${ course.limited}"></td>
                <td><input type="text" name="sum_person" value="${ course.sum_person}"></td>
                <td>
                  <input type="submit" value="修改">
                </td>
                </tr>
            </form>

        </c:forEach>

        </tbody>
    </table>
</div>
<div style="width:60%;margin-left:20%;border:0px solid red;padding-top:4px;" align="center">

    <c:choose>

        <c:when test="${pageNo==1}">
            <input type="button" value="首  页" class="btn" onclick="page(1)"/>
            <input type="button" value="上一页" disabled="disabled" />
            <input type="button" value="下一页" class="btn" onclick="page(${pageNo+1})"/>
            <input type="button" value="尾  页" class="btn" onclick="page(${pageCount})"/>
        </c:when>
        <c:when test="${pageNo==pageCount}">
            <input type="button" value="首  页" class="btn" onclick="page(1)"/>
            <input type="button" value="上一页" class="btn" onclick="page(${pageNo-1})"/>
            <input type="button" value="下一页" disabled="disabled"/>
            <input type="button" value="尾  页"  disabled="disabled"/>
        </c:when>
        <c:otherwise>
            <input type="button" value="首  页" class="btn" onclick="page(1)"/>
            <input type="button" value="上一页" class="btn" onclick="page(${pageNo-1})"/>
            <input type="button" value="下一页" class="btn" onclick="page(${pageNo+1})"/>
            <input type="button" value="尾  页" class="btn" onclick="page(${pageCount})"/>
        </c:otherwise>
    </c:choose>
    <a href="javascript:history.back()"><input type="button" class="select-button" value="返回上页"></a>

        <script>
            function page(pageNo){
                window.location.href="${pageContext.request.contextPath}/TeacherCourseShowServlet?pageNo="+pageNo;
            }
        </script>
</body>
</html>