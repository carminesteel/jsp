package cart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import order.OrderVO;
import product.ProductDAO;
import product.ProductVO;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(value = { "/cart/insert", "/cart/delete","/cart/update" })
public class CartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getServletPath()) {
		case "/cart/insert":
			HttpSession session = request.getSession();
			ArrayList<OrderVO> listCart = (ArrayList<OrderVO>) session.getAttribute("listCart");

			ProductDAO pdao = new ProductDAO();
			ProductVO productVO = pdao.read(request.getParameter("prod_id"));
			OrderVO cartVO = new OrderVO();
			cartVO.setProd_id(productVO.getProd_id());
			cartVO.setProd_name(productVO.getProd_name());
			cartVO.setPrice(productVO.getPrice1());
			cartVO.setQuantity(1);
			boolean isFind = false;
			if (listCart == null) {
				listCart = new ArrayList<OrderVO>();
			} else {
				for (OrderVO oldVO : listCart) {
					if (oldVO.getProd_id().equals(request.getParameter("prod_id"))) {
						oldVO.setQuantity(oldVO.getQuantity() + 1);
						isFind = true;
					}
				}
			}
			if (!isFind)
				listCart.add(cartVO);
			session.setAttribute("listCart", listCart);
			break;

		case "/cart/delete":
			session = request.getSession();
			listCart = (ArrayList<OrderVO>) session.getAttribute("listCart");
			for (OrderVO oldVO : listCart) {
				if (oldVO.getProd_id().equals(request.getParameter("prod_id"))) {
					listCart.remove(oldVO);
					break;
				}
			}
		case "/cart/update":
			session = request.getSession();
			listCart = (ArrayList<OrderVO>) session.getAttribute("listCart");
			for (OrderVO oldVO : listCart) {
				if (oldVO.getProd_id().equals(request.getParameter("prod_id"))) {
					oldVO.setQuantity(Integer.parseInt(request.getParameter("quantity")));
					break;
				}
			}
		}
	}

}
