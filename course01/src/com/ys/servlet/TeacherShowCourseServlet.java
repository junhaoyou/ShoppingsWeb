package com.ys.servlet;

import com.ys.DAO.Impl.CourseDAOImpl;
import com.ys.StringUtil.StringUtil;
import com.ys.bean.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/TeacherCourseShowServlet")
public class TeacherShowCourseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //设置字符编码
        request.setCharacterEncoding("UTF-8");

        //设置初始数据
        Integer pageNo = 1 ;
        String pageNoStr = request.getParameter("pageNo");
        if(StringUtil.isNotEmpty(pageNoStr))
        {
            pageNo = Integer.parseInt(pageNoStr);
        }

        HttpSession session = request.getSession() ;
        session.setAttribute("pageNo",pageNo);



            List<Course> course = new ArrayList<Course>();
            CourseDAOImpl courseDAOImpl = new CourseDAOImpl();
            course = courseDAOImpl.getAll(pageNo);
            //记录总条数
            int courseCount = courseDAOImpl.getCount().intValue();
            //总页数
            int pageCount = (courseCount+5-1)/5 ;
            session.setAttribute("pageCount",pageCount);
           //System.out.println(course.get(0).getCourse_name());
            //System.out.println(course.get(0).getLimited()==course.get(0).getSum_person());
            session.setAttribute("course",course);
            request.getRequestDispatcher("static/jsp/TeacherCourseShow.jsp").forward(request, response);

    }

}
