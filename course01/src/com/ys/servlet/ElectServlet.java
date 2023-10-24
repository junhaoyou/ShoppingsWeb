package com.ys.servlet;

import com.ys.DAO.Impl.CopyCourseDAOImpl;
import com.ys.DAO.JDBCUtils;
import com.ys.bean.CopyCourse;
import com.ys.bean.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.print.Book;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ElectServlet")
public class ElectServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        //获取课程信息
        String course_id = request.getParameter("course_id");
        String course_name = request.getParameter("course_name");
        String teacher = request.getParameter("teacher");

        String point1 = request.getParameter("point");
        int point = Integer.parseInt(point1);

        String time_1 = request.getParameter("time_1");
        String time_2 = request.getParameter("time_2");
        String location = request.getParameter("location");

        String limited1 = request.getParameter("limited");
        int limited = Integer.parseInt(limited1);


        //存储数据
        HttpSession session = request.getSession();
        CopyCourse copyCourse = new CopyCourse(course_id,course_name,teacher,point,time_1,time_2,location,limited);//接收选课信息

        System.out.println(copyCourse.getCourse_name()+"llllllllllllllll"+copyCourse.getCourse_id());
        //接收数据库信息
        List<CopyCourse> copyCourse1 = new ArrayList<CopyCourse>();
        List<CopyCourse> copyCourse2 = new ArrayList<CopyCourse>();
        //获取数据库连接
        Connection conn = null;
        try {


            //查询数据库

            conn = JDBCUtils.getConnection();
            CopyCourseDAOImpl copyCourseDAOImpl = new CopyCourseDAOImpl();

            copyCourse1=copyCourseDAOImpl.getAll(conn);


            if(copyCourse1.isEmpty())
            {

                copyCourseDAOImpl.insert(conn,copyCourse);
                copyCourseDAOImpl.updateSum(conn,course_id);
                //
                copyCourse2=copyCourseDAOImpl.getAll(conn);
                session.setAttribute("copyCourse2",copyCourse2);
                int pointSum =0;
                if(!copyCourse2.isEmpty())
                {
                    for (int i = 0;i<copyCourse2.size();i++)
                    {
                        pointSum = pointSum + copyCourse2.get(i).getPoint();
                    }
                }else pointSum =0;
                session.setAttribute("pointSum",pointSum);
                request.getRequestDispatcher("static/jsp/showElectCourse.jsp").forward(request,response);
                System.out.println("来错啦！！！！！");
            }
            else if (copyCourseDAOImpl.getOne(conn,course_id)==null)
            {

                copyCourseDAOImpl.insert(conn,copyCourse);
                copyCourseDAOImpl.updateSum(conn,course_id);
                //
                copyCourse2=copyCourseDAOImpl.getAll(conn);
                session.setAttribute("copyCourse2",copyCourse2);
                int pointSum =0;
                if(!copyCourse2.isEmpty())
                {
                for (int i = 0;i<copyCourse2.size();i++)
                    {
                        pointSum = pointSum + copyCourse2.get(i).getPoint();
                     }
                }else pointSum =0;
                session.setAttribute("pointSum",pointSum);
                System.out.println("来错啦！！！！！"+pointSum);
                request.getRequestDispatcher("static/jsp/showElectCourse.jsp").forward(request,response);
            }
            else
            {
                request.getRequestDispatcher("static/jsp/errorElect.jsp").forward(request,response);
            }


        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
