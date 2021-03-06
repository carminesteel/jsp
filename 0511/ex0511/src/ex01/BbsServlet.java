package ex01;

import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/bbs-post")
public class BbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8"); //request값 한글
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		request.setAttribute("n", name);
		request.setAttribute("t", title);
		request.setAttribute("c", content);

		System.out.println("name............." + name);
		Date date = new Date();
		Long time = date.getTime();
		String fileName=time + ".txt";
		String filePath="c:/temp/" + fileName;
		PrintWriter writer=null;
		try {
			writer = new PrintWriter(filePath);
			writer.printf("이름 : %s %n", name);
			writer.printf("제목 : %s %n", title);
			writer.printf("---------------------------- %n");
			writer.print(content);
			writer.close();
			
			//response.sendRedirect("writeResult.jsp");
			RequestDispatcher dis = request.getRequestDispatcher("writeResult.jsp");
			dis.forward(request, response);
		}catch(Exception e){
			System.out.println(e.toString());			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
