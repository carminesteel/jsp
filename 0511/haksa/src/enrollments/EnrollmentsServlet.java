package enrollments;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class ec
 */
@WebServlet(value= {"/enroll/update","/es","/ec","/ec/insert","/ec/delete"})
public class EnrollmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		JSONObject jObject=new JSONObject();
		EnrollmentsDAO edao=new EnrollmentsDAO();
		
		switch(request.getServletPath()) {
		case "/es":
			jObject=edao.es(request.getParameter("lcode"));
			out.println(jObject);
		break;
		
		
		case "/ec":
			jObject=edao.ec(request.getParameter("scode"));
			out.println(jObject);
		break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		EnrollmentsDAO edao=new EnrollmentsDAO();
		String scode=request.getParameter("scode");
		String lcode=request.getParameter("lcode");
		int grade = Integer.parseInt(request.getParameter("grade"));
		
		switch(request.getServletPath()) {
		
		case "/enroll/update":
			edao.update(lcode, scode, grade);
			break;
		
		case "/ec/insert":
			int count = edao.insert(scode, lcode);
			JSONObject jObject=new JSONObject();
			jObject.put("count", count);
			out.println(jObject);
			break;		
			
		case "/ec/delete":
			edao.delete(scode, lcode);
			break;	
		}
	}
}


