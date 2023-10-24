package com.ys.servlet;


import com.ys.DAO.Impl.CopyCourseDAOImpl;
import com.ys.DAO.Impl.UserDAOImpl;
import com.ys.DAO.JDBCUtils;
import com.ys.bean.CopyCourse;
import com.ys.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();

        //获取登录信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("identity");

        //匹配信息
        Connection conn = null;
        UserDAOImpl userDAOImpl = new UserDAOImpl();
        List<User> user = new ArrayList<User>();
        List<CopyCourse> copyCourse2 = new ArrayList<CopyCourse>();
        try
        {
            conn = JDBCUtils.getConnection();
            user=userDAOImpl.getAll(conn,username);

            if (!user.isEmpty() && user.get(0).getUsername().equals(username) && user.get(0).getPassword().equals(password)
            &&role.equals("0")&& user.get(0).getRole().equals(role))
            {
                HttpSession session = request.getSession() ;
                CopyCourseDAOImpl copyCourseDAOImpl = new CopyCourseDAOImpl();
                copyCourse2=copyCourseDAOImpl.getAll(conn);
                session.setAttribute("copyCourse2",copyCourse2);
                //登陆后查询信息并保存
                int pointSum =0;
                if(!copyCourse2.isEmpty())
                {
                    for (int i = 0;i<copyCourse2.size();i++)
                    {
                        pointSum = pointSum + copyCourse2.get(i).getPoint();
                    }
                }else pointSum =0;
                session.setAttribute("pointSum",pointSum);

                session.setAttribute("username",username);
                session.setAttribute("password",password);
                request.getRequestDispatcher("static/jsp/studentUI.jsp").forward(request, response);

            }

            else if (!user.isEmpty() && user.get(0).getUsername().equals(username) && user.get(0).getPassword().equals(password)
                    &&role.equals("1")&& user.get(0).getRole().equals(role))
            {
                HttpSession session = request.getSession() ;
                session.setAttribute("username",username);
                session.setAttribute("password",password);
                request.getRequestDispatcher("static/jsp/teacherUI.jsp").forward(request, response);
            }

            else
            {
                    request.getRequestDispatcher("static/jsp/error.jsp").forward(request, response);
            }

        } catch (Exception e)
        {
          e.printStackTrace();
        }finally
        {
            JDBCUtils.closeResource(conn,null);
        }


    }
}