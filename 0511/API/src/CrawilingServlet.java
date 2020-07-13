

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Servlet implementation class CrawilingServlet
 */
@WebServlet(value= {"/crawl/cgv","/daum/weather"})
public class CrawilingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		switch(request.getServletPath()) {
		case "/crawl/cgv":
			try {
				Document doc=Jsoup.connect("http://www.cgv.co.kr/movies/").get();
				Elements elements=doc.select(".sect-movie-chart");
				JSONArray jArray=new JSONArray();
				for(Element e:elements.select("li")) {
					JSONObject obj=new JSONObject();
					obj.put("rank", e.select(".rank").text());
					obj.put("title", e.select(".title").text());
					jArray.add(obj);
				}
				JSONObject jObject = new JSONObject();
				jObject.put("array",jArray);
				out.println(jObject);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			break;
			
		case "/daum/weather":
			try {
				Document doc=Jsoup.connect("https://search.daum.net/search?w=tot&DA=Z8T&q=%EC%A0%84%EA%B5%AD%20%EB%82%A0%EC%94%A8&rtmaxcoll=Z8T").get();
				Elements elements=doc.select(".map_region");
				JSONArray jArray=new JSONArray();
				for(Element e:elements.select("li")) {
					JSONObject obj=new JSONObject();
					obj.put("region", e.select(".tit_region").text());
					obj.put("temp", e.select(".num_temp").text());
					obj.put("weather", e.select(".ico_ws ico_w04").text());
					jArray.add(obj);
				}
				JSONObject jObject = new JSONObject();
				jObject.put("array",jArray);
				out.println(jObject);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
