package user;

import java.sql.*;
import java.util.concurrent.Callable;

import org.json.simple.*;

import bbs.Database;

public class UDAO {
	//회원가입
	public JSONObject insert(UVO vo) {
		JSONObject jObject=new JSONObject();
		try {
			String sql="call add_user(?,?,?,?)";
			CallableStatement cs=Database.CON.prepareCall(sql);
			cs.setString(1, vo.getId());
			cs.setString(2, vo.getPassword());
			cs.setString(3, vo.getName());
			cs.registerOutParameter(4, java.sql.Types.INTEGER);
			cs.execute();
			jObject.put("count", cs.getInt(4));			
		}catch(Exception e) {
			System.out.println("회원가입 : "+e.toString());
		}
		return jObject;
	}
	//로그인 체크
	public UVO loginCheck(String id, String password) {
		UVO vo=new UVO();
		try {
			String sql="select * from userinfo where id=? and password=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
			}
		}catch(Exception e) {
			System.out.println("로그인체크" + e.toString());
		}
		return vo;
	}
	
	//유저목록출력
	public JSONObject list(String key, String word, String order, String desc, int page, int perPage) {
		JSONObject jObject=new JSONObject();
		try {
			String sql="call list('userinfo',?,?,?,?,?,?)";
			CallableStatement cs=Database.CON.prepareCall(sql);
			cs.setString(1, key);
			cs.setString(2, word);
			cs.setString(3, order);
			cs.setString(4, desc);
			cs.setInt(5, (page-1)*perPage);
			cs.setInt(6, perPage);		
			cs.execute();
			
			ResultSet rs=cs.getResultSet();			
			
			JSONArray jArray=new JSONArray();
			while(rs.next()) {
				JSONObject obj=new JSONObject();
				obj.put("name", rs.getString("name"));
				obj.put("id", rs.getString("id"));
				obj.put("job", rs.getString("job"));
				obj.put("tel", rs.getString("tel"));
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
			System.out.println("사용자목록 : " + e.toString());
		}return jObject;
	}
}
