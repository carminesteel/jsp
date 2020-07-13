package book;

import java.sql.*;

import org.json.simple.*;

import bbs.Database;

public class DAO {
	//도서 등록
	public int insert(BVO vo) {
		int count=0;
		try {
			String sql="call add_book(?,?,?,?,?)";
			CallableStatement cs=Database.CON.prepareCall(sql);
			cs.setString(1, vo.getCode());
			cs.setString(2, vo.getTitle());
			cs.setString(3, vo.getWriter());
			cs.setInt(4, vo.getPrice());
			cs.registerOutParameter(5, java.sql.Types.INTEGER);
			cs.execute();
			
			count=cs.getInt(5);
			
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return count;
	}
	
	//도서목록출력
	public JSONObject list(String key, String word, int page, int perPage) {
		JSONObject jObject=new JSONObject();
		try {
			String sql="call list('goodsinfo',?,?,'price','desc',?,?)";
			CallableStatement cs=Database.CON.prepareCall(sql);
			cs.setString(1, key);
			cs.setString(2, word);
			cs.setInt(3, (page-1)*perPage);
			cs.setInt(4, perPage);		
			cs.execute();
			
			ResultSet rs=cs.getResultSet();			
			
			JSONArray jArray=new JSONArray();
			while(rs.next()) {
				JSONObject obj=new JSONObject();
				obj.put("code", rs.getString("code"));
				obj.put("title", rs.getString("title"));
				obj.put("writer", rs.getString("writer"));
				obj.put("price", rs.getInt("price"));
				jArray.add(obj);
			}
			jObject.put("array", jArray);
			
			cs.getMoreResults();	
			
			rs=cs.getResultSet();
			int count=0;
			if(rs.next()) {
				count=rs.getInt("total");
			}
			
			jObject.put("count", count);//전체데이터개수	
			jObject.put("page", page);
			jObject.put("perPage", perPage);
			int totPage=count%perPage==0?count/perPage:(count/perPage)+1;
			jObject.put("totPage", totPage);
			
			
			
		}catch(Exception e) {
			System.out.println("도서목록 : " + e.toString());
		}
		return jObject;
	}	
}
