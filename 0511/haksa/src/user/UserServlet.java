package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class StrudentsServlet
 */
@WebServlet(value= {"/user/login","/user/logout"})
public class UserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();			
			switch(request.getServletPath()) {
			case "/user/logout" :
				HttpSession session=request.getSession();
				session.invalidate();
				response.sendRedirect("login.jsp");
				break;
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		UserDAO udao= new UserDAO();
		switch(request.getServletPath()) {
		case "/user/login" :
			System.out.println("login");
			UserVO vo = udao.login(id);
			int check=0; // id 없는경우
			if(vo.getId()!=null) {
				if(vo.getPass().equals(pass)) {
					check=2; //pass가 일치하는 경우
					HttpSession session=request.getSession();
					session.setAttribute("id", vo.getId());
					session.setAttribute("name", vo.getName());
				}else {
					check=1; //pass가 일치하는 경우
				}
				JSONObject jObject=new JSONObject();
				jObject.put("check",check);
				out.println(jObject);
				System.out.println("check:" + check);
			}
			break;
		}				
	}
}
