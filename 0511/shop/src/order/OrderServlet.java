package order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import database.SqlVO;

@WebServlet(value = { "/order/list","/order/insert"})
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		SqlVO svo = new SqlVO();

		String key = request.getParameter("key") == null ? "Order_id" : request.getParameter("key");
		String word = request.getParameter("word") == null ? "" : request.getParameter("word");
		String Order = request.getParameter("Order") == null ? "Order_id" : request.getParameter("Order");
		String desc = request.getParameter("desc") == null ? "" : request.getParameter("desc");
		String page = request.getParameter("page") == null ? "1" : request.getParameter("page");
		String perPage = request.getParameter("perPage") == null ? "2" : request.getParameter("perPage");
		svo.setKey(key);
		svo.setWord(word);
		svo.setOrder(Order);
		svo.setDesc(desc);
		svo.setPage(Integer.parseInt(page));
		svo.setPerPage(Integer.parseInt(perPage));

		OrderDAO dao = new OrderDAO();
		switch (request.getServletPath()) {
		case "/order/list":
			String order_id=request.getParameter("order_id");
			ArrayList<OrderVO> list=dao.list(order_id);
			JSONArray jArray = new JSONArray();
			for (OrderVO vo:list) {
				JSONObject obj = new JSONObject();
				obj.put("prod_id", vo.getProd_id());
				obj.put("prod_name", vo.getProd_name());
				obj.put("company", vo.getCompany());
				obj.put("price", vo.getPrice());
				obj.put("quantity", vo.getQuantity());
				obj.put("sum", vo.getQuantity() * vo.getPrice());
				jArray.add(obj);
			}
			System.out.println(jArray);
			out.println(jArray);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		OrderVO vo=new OrderVO();
		OrderDAO dao = new OrderDAO();
		vo.setOrder_id(request.getParameter("order_id"));
		vo.setProd_id(request.getParameter("prod_id"));
		String quantity=request.getParameter("puantity");
		vo.setQuantity(Integer.parseInt(quantity));		
		String price=request.getParameter("price");
		vo.setPrice(Integer.parseInt(price));
		
		switch(request.getServletPath()) {
		case "/order/insert":
			dao.insert(vo);
			break;
		}
	}

}
