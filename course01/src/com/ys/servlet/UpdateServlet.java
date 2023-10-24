package com.ys.servlet;

import com.ys.DAO.Impl.CourseDAOImpl;
import com.ys.DAO.JDBCUtils;;
import com.ys.bean.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //获取课程信息
        String course_id = request.getParameter("course_id");
        System.out.println("==++==++"+course_id);
        String course_name = request.getParameter("course_name");
        String teacher = request.getParameter("teacher");
        System.out.println("6666"+teacher);

        String time_1 = request.getParameter("time_1");
        String time_2 = request.getParameter("time_2");
        String location = request.getParameter("location");

        String limited1 = request.getParameter("limited");
        int limited = Integer.parseInt(limited1);

        String sum = request.getParameter("sum_person");
        int sum_person = Integer.parseInt(sum);

        String point1 = request.getParameter("point");
        System.out.println("==++==++"+point1);
        int point = Integer.parseInt(point1);

        Course course = new Course(course_id,course_name,teacher,point,time_1,time_2,location,limited,sum_person);//接收更改信息
        System.out.println(course.toString());
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            CourseDAOImpl courseDAO = new CourseDAOImpl();
            courseDAO.update(conn,course);
            List<Course> copyCourse2 = new ArrayList<Course>();
            HttpSession session = request.getSession();
            copyCourse2= courseDAO.getAll(conn);
            session.setAttribute("copyCourse2",copyCourse2);
            request.getRequestDispatcher("/TeacherCourseShowServlet").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
