package database;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import order.OrderDAO;
import order.OrderVO;
import product.ProductDAO;

public class Main {

	public static void main(String[] args) {
		System.out.println(Database.CON);
		SqlVO vo = new SqlVO();
		vo.setKey("prod_id");
		vo.setWord("");
		vo.setOrder("prod_id");
		vo.setDesc("desc");
		vo.setPage(1);
		vo.setPerPage(2);
		
		ProductDAO dao = new ProductDAO();
		JSONObject jObject=dao.list(vo);
		System.out.println(jObject);
	}

}
