package shop;

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

@WebServlet("/ListCarServlet")
public class ListCarServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	public ListCarServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession(false);
		if(session==null){
			out.write("您没有购买任何商品！！！");
			return;
		}
		
		out.write("您购买的商品如下：<br/>");
		List<Book>list=(List)session.getAttribute("listBook");
		for(Book book:list) {
			out.write(book.getName()+"<br/>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
}
