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
		out.printf("�̸� : %s <br>", name);
		out.printf("���̵� : %s <br>", id);
		out.printf("��� : %s <br>", password);
		
		if(gender.contentEquals("m")) {
			out.print("����: �� <br>");
		}else {
			out.print("���� : �� <br>");
		}
		if(iNotice == null) {
			out.print("��������: �������� <br>");
		}else {
			out.print("��������: ���� <br>");

		}
		
		if(cNotice == null) {
			out.print("�������: �������� <br>");
		}else {
			out.print("�������: ���� <br>");

		}
		
		if(dNotice == null) {
			out.print("���Ȯ�θ���: �������� <br>");
		}else {
			out.print("���Ȯ�θ���: ���� <br>");

		}
		out.printf("����: %s <br>",job);
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
