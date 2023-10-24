package dorm.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dorm.shop.DAO.Db;
import dorm.shop.javabean.Book;

@WebServlet("/BuyServlet")
public class BuyServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	
	public BuyServlet(){
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		Book book=(Book)Db.getAll().get(id);
		
		HttpSession session=request.getSession();
		
		List<Book>list=(List)session.getAttribute("listBook");
		if(list==null){
			list=new ArrayList();
			session.setAttribute("listBook",list);
		}
		list.add(book);
		response.sendRedirect(request.getContextPath()+"/ListCarServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
}
