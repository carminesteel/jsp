package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value={"/user/list"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UDAO dao = new UDAO();
		RequestDispatcher dis = null;
		switch(request.getServletPath()) {
		case "/user/list":
			String key=request.getParameter("key")==null?"id":request.getParameter("key");
			String word=request.getParameter("word")==null?"":request.getParameter("word");
			String strPage=request.getParameter("page")==null?"1":request.getParameter("page");
			int page=Integer.parseInt(strPage);
			
			System.out.println("key="+ key + "word=" + word + "page=" +page);		
			int perpagenum=3;
			int count=dao.count(key, word);
			int totPage=(count%perpagenum==0?count/perpagenum:(count/perpagenum)+1);
			request.setAttribute("totPage", totPage);
			request.setAttribute("count", count);
			request.setAttribute("page", page);
			request.setAttribute("key", key);
			request.setAttribute("word", word);
			request.setAttribute("list", dao.list(key, word, page, perpagenum));
			dis=request.getRequestDispatcher("list.jsp");
			dis.forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
