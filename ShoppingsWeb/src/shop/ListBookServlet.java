package shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ListBookServlet")
public class ListBookServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	
	public ListBookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		out.println("本站有如下书籍：<br/>");
		Map<String,Book>map=Db.getAll();
		for(Map.Entry<String, Book>entry:map.entrySet()) {
			Book book=entry.getValue();
			out.print(book.getName()+"<a href='BuyServlet?id="+book.getId()+"'target='_blank'>购买</a><br/>");
		}
		out.println("<a href='ListCarServlet'>查看购物车</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
}
