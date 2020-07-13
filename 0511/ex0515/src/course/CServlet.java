package course;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.*;

import course.CDAO;
import enroll.EDAO;
import enroll.EVO;
import professor.PVO;


@WebServlet(value= {"/cou/list","/cou/insert","/cou/delete","/cou/read","/cou/update","/cou/enroll"})
public class CServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dis=null;
		CDAO dao = new CDAO();
		EDAO edao= new EDAO();
		switch(request.getServletPath()) {		
			
			case "/cou/enroll":
				String lcode= request.getParameter("lcode");
				System.out.println(lcode);
				try {
				ArrayList<EVO> clist=edao.clist(lcode);
				JSONArray jArray= new JSONArray();
				for(EVO vo:clist) {
					JSONObject obj=new JSONObject();
					obj.put("scode", vo.getScode());
					obj.put("sname", vo.getSname());
					obj.put("grade", vo.getGrade());
					obj.put("edate", vo.getEdate());
					jArray.add(obj);					
				}
				PrintWriter out=response.getWriter();
				System.out.println(jArray);
				out.println(jArray);
				}catch(Exception e) {
					System.out.println(e.toString());
				}
				break;				
		
			case "/cou/list":
				System.out.println("get /cou/list");
				try {
					request.setAttribute("array", dao.list());
				}catch(Exception e) {
					System.out.println(e.toString());
				}
				dis=request.getRequestDispatcher("list.jsp");
				dis.forward(request, response);
				break;
				
			case "/cou/insert":
				System.out.println("get /cou/insert");				
				try {
					ArrayList<CVO> plist=dao.list();
					request.setAttribute("plist", plist);
				} catch (Exception e) {
					System.out.println(e.toString());
				}
				dis=request.getRequestDispatcher("insert.jsp");
				dis.forward(request, response);
				break;
				
			case "/cou/delete":
				System.out.println("get /cou/delete");
				break;
				
			case "/cou/read":
				System.out.println("get /cou/read");
				lcode=request.getParameter("lcode");
				try {
					request.setAttribute("vo", dao.read(lcode));
					ArrayList<CVO> plist = dao.list();
					request.setAttribute("plist", plist);
				}catch(Exception e) {
					System.out.println(e.toString());
				}
				dis=request.getRequestDispatcher("read.jsp");
				dis.forward(request, response);
				break;
				
			case "/cou/update":
				
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CDAO dao = new CDAO();
		CVO vo = new CVO();
		request.setCharacterEncoding("UTF-8");
		switch(request.getServletPath()) {	
			case "/cou/list":
				System.out.println("Post /cou/list");
				break;
				
			case "/cou/insert":
				vo.setLcode(request.getParameter("lcode"));
				vo.setLname(request.getParameter("lname"));				
				String hours=request.getParameter("hours");
				vo.setHours(Integer.parseInt(hours));				
				vo.setRoom(request.getParameter("room"));
				vo.setInstructor(request.getParameter("instructor"));
				String capacity=request.getParameter("capacity");
				vo.setCapacity(Integer.parseInt(hours));
				String persons=request.getParameter("persons");
				vo.setPersons(Integer.parseInt(persons));
				System.out.println(vo.toString());				
				try {
						dao.insert(vo);
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				response.sendRedirect("list");
				break;
				
			case "/cou/delete":
				String lcode=request.getParameter("lcode");
				try {
					dao.delete(lcode);
				} catch (Exception e) {
					System.out.println(e.toString());
				}
				response.sendRedirect("list");			
				
				break;
				
			case "/cou/read":
				System.out.println("Post /cou/list");
				break;
				
			case "/cou/update":
				
				break;
		}

	}
}
