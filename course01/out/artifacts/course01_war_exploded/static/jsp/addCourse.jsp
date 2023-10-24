<%--
  Created by IntelliJ IDEA.
  User: 16141
  Date: 2023/11/25
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>课程信息添加</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            background-color: #f8f9fa;
        }

        h3 {
            color: #4492e5;
        }

        form {
            width: 50%;
            max-width: 800px;
            background-color: #af9090;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 18px;
            border-radius: 8px;
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #cf3a3a;
        }

        input, select {
            width: calc(100% - 26px);
            padding: 8px;
            margin: 5px 0;
            border: 1px solid #9a1e1e;
            box-sizing: border-box;
        }

        label {
            font-weight: bold;
            margin-right: 10px;
        }

        button {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<form action="${pageContext.request.contextPath}/TeacherAddServlet" method="post">
    <table>
        <th>
            <h3>请输入需要添加的课程信息:</h3></th>
        <tr>
            <td><label for="course_id">课程编号:</label></td>
            <td><input type="text" id="course_id" name="course_id" placeholder="请输入课程编号" required></td>
        </tr>
        <tr>
            <td><label for="course_name">课程名称:</label></td>
            <td><input type="text" id="course_name" name="course_name" placeholder="请输入课程名称" required></td>
        </tr>
        <tr>
            <td><label for="teacher">教师姓名:</label></td>
            <td><input type="text" id="teacher" name="teacher" placeholder="请输入教师姓名" required></td>
        </tr>
        <tr>
            <td><label for="point">学分:</label></td>
            <td><input type="text" id="point" name="point" placeholder="请输入学分" required></td>
        </tr>
        <tr>
            <td><label>上课时间:</label></td>
            <td>
                <div>
                    <label for="weekday01">第一次:</label>
                    <select id="weekday01" name="week_01">
                        <option value="星期一">星期一</option>
                        <option value="星期二">星期二</option>
                        <option value="星期三">星期三</option>
                        <option value="星期四">星期四</option>
                        <option value="星期五">星期五</option>
                        <option value="星期六">星期六</option>
                        <option value="星期日">星期日</option>
                    </select>
                    <select id="time01" name="time_01">
                        <option value="8:30~10:05">8:30~10:05</option>
                        <option value="10:25~12:00">10:25~12:00</option>
                        <option value="14:40~16:15">14:40~16:15</option>
                        <option value="16:30~18:05">16:30~18:05</option>
                        <option value="19:30~21:05">19:30~21:05</option>
                    </select>
                </div>
                <div>
                    <label for="weekday02">第二次:</label>
                    <select id="weekday02" name="week_02">
                        <option value="星期一">星期一</option>
                        <option value="星期二">星期二</option>
                        <option value="星期三">星期三</option>
                        <option value="星期四">星期四</option>
                        <option value="星期五">星期五</option>
                        <option value="星期六">星期六</option>
                        <option value="星期日">星期日</option>
                    </select>
                    <select id="time02" name="time_02">
                        <option value="8:30~10:05">8:30~10:05</option>
                        <option value="10:25~12:00">10:25~12:00</option>
                        <option value="14:40~16:15">14:40~16:15</option>
                        <option value="16:30~18:05">16:30~18:05</option>
                        <option value="19:30~21:05">19:30~21:05</option>
                    </select>
                </div>
            </td>
        </tr>
        <tr>
            <td><label for="location">上课地点:</label></td>
            <td><input type="text" id="location" name="location" placeholder="请输入上课地点" required></td>
        </tr>
        <tr>
            <td><label for="limited">限制人数:</label></td>
            <td><input type="text" id="limited" name="limited" placeholder="请输入限制人数" required></td>
        </tr>
    </table>
    <button type="submit">添加</button>
    <button type="button"><a href="${pageContext.request.contextPath}/TeacherCourseShowServlet">课程信息</a></button>
</form>

</body>
</html>
