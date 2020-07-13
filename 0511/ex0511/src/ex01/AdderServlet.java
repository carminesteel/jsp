package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adder")
public class AdderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNum1=request.getParameter("num1");
		String strNum2=request.getParameter("num2");
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int hap = num1+num2;
		
		response.setContentType("text/html;charset=UTF-8"); //ÇÑ±Û ±úÁü ¹æÁö
		PrintWriter out=response.getWriter();
				
		out.print("<html>");
		out.print("<body>");
		out.print("<h1>" + num1 + "+" + num2 + "=" + hap + "</h1>");
		out.print("</body>");
		out.print("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
