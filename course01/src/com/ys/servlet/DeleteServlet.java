package com.ys.servlet;

import com.ys.DAO.Impl.CopyCourseDAOImpl;
import com.ys.DAO.JDBCUtils;
import com.ys.bean.CopyCourse;

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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        String course_id = request.getParameter("course_id");
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            CopyCourseDAOImpl  copyCourseDAO = new CopyCourseDAOImpl();
            copyCourseDAO.deleteById(conn,course_id);
            copyCourseDAO.updateSum1(conn,course_id);
            List<CopyCourse> copyCourse2 = new ArrayList<>();
            copyCourse2=copyCourseDAO.getAll(conn);
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.closeResource(conn,null);
        }


    }

}
