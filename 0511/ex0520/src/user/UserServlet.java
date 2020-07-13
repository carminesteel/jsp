package user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

@WebServlet(value= {"/user/list","/user/insert","/user/login", "/user/list.json","/user/logout"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		UDAO dao=new UDAO();
		
		RequestDispatcher dis = null;
		switch(request.getServletPath()) {
		case "/user/insert":
			dis=request.getRequestDispatcher("/insert.jsp");
			dis.forward(request, response);
			break;
				
		case "/user/logout":
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("/index.jsp");
			break;
	
		case "/user/login" :
			
			dis=request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
			break;
	
		case "/user/list.json" : 
			
			String key=request.getParameter("key")==null?"code":request.getParameter("key");
			String word=request.getParameter("word")==null?"":request.getParameter("word");
			String order=request.getParameter("order")==null?"":request.getParameter("order");
			String desc=request.getParameter("desc")==null?"desc":request.getParameter("desc");
			String strPage=request.getParameter("page")==null?"1":request.getParameter("page");
			int page=Integer.parseInt(strPage);
			
			String strPerPage=request.getParameter("perPage")==null?"10":request.getParameter("perPage");
			int perPage=Integer.parseInt(strPerPage);
			
			System.out.println(dao.list(key,word,order,desc,page,perPage));
			out.println(dao.list(key,word,order,desc,page,perPage));
			break;
		case "/user/list":
			response.sendRedirect("list.jsp");
			break;
	}
	
	
	
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter out=response.getWriter();
		switch(request.getServletPath()) {
		case "/user/login":
			String id=request.getParameter("id");
			String password=request.getParameter("password");
			
			UDAO dao = new UDAO();
			UVO vo=dao.loginCheck(id, password);
			
			JSONObject jObject=new JSONObject();
			jObject.put("id", vo.getId());
			out.print(jObject);
			
			HttpSession session=request.getSession();
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			break;
			
		case "/user/insert":
			dao = new UDAO();
			vo=new UVO();
			vo.setId(request.getParameter("id"));
			vo.setPassword(request.getParameter("pass"));
			vo.setName(request.getParameter("name"));
			jObject=dao.insert(vo);
			System.out.println(jObject);
			out.println(jObject);
			break;
			
		}
		
	}
	
}
