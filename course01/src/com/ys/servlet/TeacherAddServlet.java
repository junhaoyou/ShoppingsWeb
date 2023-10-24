package com.ys.servlet;

import com.ys.DAO.Impl.CopyCourseDAOImpl;
import com.ys.DAO.Impl.CourseDAOImpl;
import com.ys.DAO.JDBCUtils;
import com.ys.bean.CopyCourse;
import com.ys.bean.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/TeacherAddServlet")
public class TeacherAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        //获取课程信息
        String course_id = request.getParameter("course_id");
        String course_name = request.getParameter("course_name");
        String teacher = request.getParameter("teacher");

        String point1 = request.getParameter("point");
        int point = Integer.parseInt(point1);

        String week = request.getParameter("week_01");
        String time = request.getParameter("time_01");
        String time_1 = week+" "+time;

        String week1 = request.getParameter("week_02");
        String time1 = request.getParameter("time_02");
        String time_2 = week1+" "+time1;

        String location = request.getParameter("location");

        String limited1 = request.getParameter("limited");
        int limited = Integer.parseInt(limited1);

        Course course = new Course(course_id,course_name,teacher,point,time_1,time_2,location,limited,0);
        System.out.println( course.toString());
        Connection conn = null;
        try {
            conn=JDBCUtils.getConnection();
            CourseDAOImpl courseDAO = new CourseDAOImpl();
            if (courseDAO.getOne(conn,course_id)==null)
            {
                courseDAO.insert(conn,course);
                request.getRequestDispatcher("static/jsp/AddSucceed.jsp").forward(request,response);
            }
            else
            {
                request.getRequestDispatcher("static/jsp/error2.jsp").forward(request,response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
