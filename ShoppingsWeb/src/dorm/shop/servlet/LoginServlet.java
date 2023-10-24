package dorm.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dorm.shop.javabean.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private List<User> userList;

    public LoginServlet() {
        super();
        userList = new ArrayList<>();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("login")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String rememberMe = request.getParameter("remember");

                boolean loginUserExists = false;

                for (User user : userList) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        loginUserExists = true;
                        break;
                    }
                }

                if (loginUserExists) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);

                    if (rememberMe != null && rememberMe.equals("1")) {
                    	session.setAttribute("remember",password);
                    }else {
                    	session.removeAttribute("remember");
                    }

                    response.sendRedirect("ListBookServlet");//������ת���������
                } else {
                    response.sendRedirect("Login.jsp?error=1");//������û��ע������ص���¼ҳ��
                }
            } else if (action.equals("register")) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                User newUser = new User(username, password);
                userList.add(newUser);
                
                response.sendRedirect("Login.jsp?registered=1");//�����ʾע��ɹ�����ת�ص�¼����
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
