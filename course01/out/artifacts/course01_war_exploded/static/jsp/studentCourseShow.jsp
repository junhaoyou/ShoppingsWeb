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
            color: #d9e347;
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
            background-color: #27d335;
            align: center;
        }

        tr:hover {
            background-color: #487739;
        }

        .select-button {
            padding: 5px 10px;
            background-color: #4caf50;
            color: #2b4eda;
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
            <th>操作</th>
            <th>限制人数</th>
            <th>已选人数</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${course}" var="course">
            <tr>
                <td>${ course.course_id}</td>
                <td>${ course.course_name}</td>
                <td>${ course.teacher}</td>
                <td>${ course.point}</td>
                <td>${ course.time_1}<br>${ course.time_2}</td>
                <td>${ course.location}</td>
                <td>
                <c:choose>
                    <c:when test="${course.limited==course.sum_person}">
                        <button  disabled>选课</button>
                    </c:when>

                    <c:otherwise>
                       <button class="select-button" ><a href="${pageContext.request.contextPath}/ElectServlet?course_id=${ course.course_id}&&course_name=${ course.course_name}&&teacher=${course.teacher}&&point=${course.point}&&time_1=${course.time_1}&&time_2=${course.time_2}&&location=${course.location}&&limited=${course.limited}">选课</a></button>
                    </c:otherwise>
                </c:choose>
                </td>
                <td>${ course.limited}</td>
                <td>${ course.sum_person}</td>
            </tr>
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
    <a href="${pageContext.request.contextPath}/static/jsp/showElectCourse.jsp"><input type="button" class="select-button" value="查看选课情况"></a>
    <a href="javascript:history.back()"><input type="button" class="select-button" value="返回上页"></a>
</div>

</div>
<script>
    function page(pageNo){
        window.location.href="${pageContext.request.contextPath}/ShowCourseServlet?pageNo="+pageNo;
    }

    function selectCourse() {
        // 这里可以执行你的选课操作，比如弹出提示框或者跳转到另一个页面
        alert('选课成功');
    }
    function unselectCourse() {
        // 这里可以执行你的选课操作，比如弹出提示框或者跳转到另一个页面
        alert('选课失败,当前课程人数已满');
    }
</script>
</body>
</html>