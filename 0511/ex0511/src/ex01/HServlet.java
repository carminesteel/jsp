package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hap")
public class HServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1~100까지의 합
		int sum = 0;
		for(int i=0;i<=100;i++) {
			sum = sum+i;
		}
		
		//1~100까지의 합
			int esum = 0;
			for(int i=1;i<=100;i+=2) {
				esum = esum+i;
			}
				
		response.setContentType("text/html;charset=UTF-8"); //한글 깨짐 방지
		PrintWriter out=response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>1~100까지의 합계 = " + sum + "</h1>");
		out.print("<h1>1~100홀수의 합계 = " + esum + "</h1>");
		out.print("</body>");
		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
