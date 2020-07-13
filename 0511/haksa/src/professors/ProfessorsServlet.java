package professors;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

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
@WebServlet(value= {"/professors/cslist","/professors/update","/professors/delete","/professors/list","/professors/ck","/professors/insert","/professors/read"})
public class ProfessorsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			ProfessorsDAO pdao=new ProfessorsDAO();
			sqlVO sqlVO=new sqlVO();
			
			String key=request.getParameter("key")==null?"pcode":request.getParameter("key");
			String word=request.getParameter("word")==null?"":request.getParameter("word");
			String order=request.getParameter("order")==null?"pcode":request.getParameter("order");
			String desc=request.getParameter("desc")==null?"":request.getParameter("desc");
			String page=request.getParameter("page")==null?"1":request.getParameter("page");
			String perPage=request.getParameter("perpage")==null?"5":request.getParameter("perpage");
			JSONObject jObject = new JSONObject();
			switch(request.getServletPath()) {
				case "/professors/cslist":
					out.println(pdao.cslist(request.getParameter("pcode")));
					System.out.println(pdao.cslist(request.getParameter("pcode")));
				break;
			
				case "/professors/read":
					request.setAttribute("vo", pdao.read(request.getParameter("pcode")));
					RequestDispatcher dis = request.getRequestDispatcher("read.jsp");
					dis.forward(request, response);
				break;
			
				case "/professors/ck":
					int count = pdao.checkCode(request.getParameter("pcode"));
					jObject.put("count", count);
					out.println(jObject);
					break;
			
				case "/professors/list":				
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
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		ProfessorsVO vo = new ProfessorsVO();
		
		
		ProfessorsDAO pdao=new ProfessorsDAO();
		switch(request.getServletPath()) {
		case "/professors/insert":
			vo.setPcode(request.getParameter("pcode"));
			vo.setPname(request.getParameter("pname"));
			vo.setTitle(request.getParameter("title"));
			vo.setDept(request.getParameter("dept"));
			vo.setSalary(Integer.parseInt(request.getParameter("salary")));
			String yy=(request.getParameter("yy"));
			String MM=(request.getParameter("MM"));
			String dd=(request.getParameter("dd"));
			String strHiredate=yy+"-"+MM+"-"+dd;
			try {
				java.sql.Date hiredate=java.sql.Date .valueOf(strHiredate);
				vo.setHiredate(hiredate);
			}catch(Exception e) {}
			System.out.println(vo.toString());
			pdao.insert(vo);
			response.sendRedirect("list.jsp");
		break;
		
		case "/professors/delete":
			out.println(pdao.delete(request.getParameter("pcode")));
			break;
		
		case "/professors/update":
			vo.setPcode(request.getParameter("pcode"));
			vo.setPname(request.getParameter("pname"));
			vo.setTitle(request.getParameter("title"));
			vo.setDept(request.getParameter("dept"));
			vo.setSalary(Integer.parseInt(request.getParameter("salary")));
			yy=(request.getParameter("yy"));
			MM=(request.getParameter("MM"));
			dd=(request.getParameter("dd"));
			strHiredate=yy+"-"+MM+"-"+dd;
			try {
				java.sql.Date hiredate=java.sql.Date .valueOf(strHiredate);
				vo.setHiredate(hiredate);
			}catch(Exception e) {}
			System.out.println(vo.toString());
			pdao.update(vo);
			response.sendRedirect("list.jsp");
		break;
		}
	}

}
