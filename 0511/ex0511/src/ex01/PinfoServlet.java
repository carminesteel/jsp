package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/pinfo-result")
public class PinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String iNotice = request.getParameter("iNotice");
		String cNotice = request.getParameter("cNotice");
		String dNotice = request.getParameter("dNotice");
		String job = request.getParameter("job");
		
		out.println("<html>");
		out.println("<body>");
		out.printf("이름 : %s <br>", name);
		out.printf("아이디 : %s <br>", id);
		out.printf("비번 : %s <br>", password);
		
		if(gender.contentEquals("m")) {
			out.print("성별: 남 <br>");
		}else {
			out.print("성별 : 여 <br>");
		}
		if(iNotice == null) {
			out.print("공지메일: 받지않음 <br>");
		}else {
			out.print("공지메일: 받음 <br>");

		}
		
		if(cNotice == null) {
			out.print("광고메일: 받지않음 <br>");
		}else {
			out.print("광고메일: 받음 <br>");

		}
		
		if(dNotice == null) {
			out.print("배송확인메일: 받지않음 <br>");
		}else {
			out.print("배송확인메일: 받음 <br>");

		}
		out.printf("직업: %s <br>",job);
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
