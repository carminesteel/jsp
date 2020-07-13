package courses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import database.sqlVO;

/**
 * Servlet implementation class ProfessorServlet
 */
@WebServlet(value= {"/courses/list","/courses/ck","/courses/insert","/courses/read","/courses/update","/courses/delete"})
public class CoursesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			CoursesDAO pdao=new CoursesDAO();
			JSONObject jObject=new JSONObject();
			switch(request.getServletPath()) {
				case "/courses/delete":
					int count=pdao.delete(request.getParameter("lcode"));
					jObject.put("count", count);
					out.println(jObject);
					break;
			
				case "/courses/read":
					request.setAttribute("vo", pdao.read(request.getParameter("lcode")));
					RequestDispatcher dis = request.getRequestDispatcher("read.jsp");
					dis.forward(request, response);
					break;
					
				case "/courses/ck":
					jObject.put("count", pdao.checkCode(request.getParameter("lcode")));
					out.println(jObject);
					break;
				case "/courses/list":
					sqlVO sqlVO=new sqlVO();
					
					String key=request.getParameter("key")==null?"lcode":request.getParameter("key");
					String word=request.getParameter("word")==null?"":request.getParameter("word");
					String order=request.getParameter("order")==null?"lcode":request.getParameter("order");
					String desc=request.getParameter("desc")==null?"":request.getParameter("desc");
					String page=request.getParameter("page")==null?"1":request.getParameter("page");
					String perPage=request.getParameter("perpage")==null?"5":request.getParameter("perpage");
					
					sqlVO.setKey(key);
					sqlVO.setWord(word);
					sqlVO.setOrder(order);
					sqlVO.setDesc(desc);
					sqlVO.setPage(Integer.parseInt(page));
					sqlVO.setPerPage(Integer.parseInt(perPage));
					out.println(pdao.list(sqlVO));
				break;
}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();	
		CoursesDAO pdao=new CoursesDAO();		
		JSONObject jObject=new JSONObject();
		CoursesVO vo = new CoursesVO();
		
		vo.setPname(request.getParameter("pname"));
		vo.setLcode(request.getParameter("lcode"));
		vo.setLname(request.getParameter("lname"));
		vo.setRoom(request.getParameter("room"));
		vo.setInstructor(request.getParameter("pcode"));
		String strHours=request.getParameter("hours");
		vo.setHours(Integer.parseInt(strHours));
		String strCapacity=request.getParameter("capacity");
		vo.setCapacity(Integer.parseInt(strCapacity));
		String strPersons=request.getParameter("persons");
		int persons=Integer.parseInt(strPersons);
		vo.setPersons(persons);
		
		System.out.println(vo.toString()+vo.getInstructor());
		
		switch(request.getServletPath()) {
			case "/courses/insert":				
				pdao.insert(vo);
				response.sendRedirect("/courses/list.jsp");
				break;
				
			case "/courses/update":
				pdao.update(vo);
				response.sendRedirect("/courses/list.jsp");
				break;
				
	}

	}
}
