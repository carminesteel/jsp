package professors;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import database.Database;
import database.sqlVO;

public class ProfessorsDAO {
	//특정교수가 담당하는 과목과 학생들
	public JSONObject cslist(String pcode) {
		JSONObject jObject=new JSONObject();
		try {
			String sql="call list_courses_students(?)";
			CallableStatement cs = Database.CON.prepareCall(sql);
			cs.setString(1, pcode);
			cs.execute();
			
			ResultSet rs = cs.getResultSet();
			JSONArray cArray=new JSONArray();
			while(rs.next()) {
				JSONObject obj=new JSONObject();
				obj.put("lcode", rs.getString("lcode"));
				obj.put("lname", rs.getString("lname"));
				obj.put("room", rs.getString("room"));
				obj.put("capacity", rs.getInt("capacity"));
				obj.put("hours", rs.getInt("hours"));
				obj.put("persons", rs.getInt("persons"));
				cArray.add(obj);				
			}
			jObject.put("cArray",cArray);
			
			cs.getMoreResults();
			rs=cs.getResultSet();
			
			JSONArray sArray=new JSONArray();
			while(rs.next()) {
				
				JSONObject obj=new JSONObject();
				obj.put("scode", rs.getString("scode"));
				obj.put("sname", rs.getString("sname"));
				obj.put("dept", rs.getString("dept"));
				obj.put("year", rs.getString("year"));
				obj.put("birthday", rs.getString("birthday"));
				sArray.add(obj);				
			}
			jObject.put("sArray",sArray);
			
		}catch(Exception e) {
			System.out.println("특정교수의 과목 및 학생목록:" + e.toString());
		}
		return jObject;
	}
	
	public void update (ProfessorsVO vo) {
		try {
			String sql="update professors set pname=?,dept=?,title=?,salary=?,hiredate=? where pcode=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, vo.getPname());
			ps.setString(2, vo.getDept());
			ps.setString(3, vo.getTitle());
			ps.setInt(4, vo.getSalary());
			ps.setDate(5, vo.getHiredate());
			ps.setString(6, vo.getPcode());
			ps.execute();
		}catch(Exception e) {
			System.out.println("교수수정"+e.toString());
		}
	}
	
	//교수삭제
	public JSONObject delete(String pcode) {
		JSONObject jObject=new JSONObject();
		try {
			String sql="call del_professors(?,?,?)";
			CallableStatement cs=Database.CON.prepareCall(sql);
			cs.setString(1, pcode);
			cs.registerOutParameter(2, java.sql.Types.INTEGER);
			cs.registerOutParameter(3, java.sql.Types.INTEGER);
			cs.execute();
			jObject.put("scount",cs.getInt(2));
			jObject.put("ccount",cs.getInt(3));
		}catch(Exception e) {
			System.out.println("교수삭제:" + e.toString());
		}
		return jObject;
	}
	
	//교수정보읽기
	public ProfessorsVO read(String pcode) {
		ProfessorsVO vo = new ProfessorsVO();
		try {
			String sql="select * from professors where pcode=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, pcode);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				vo.setPcode(rs.getString("pcode"));
				vo.setPname(rs.getString("pname"));
				vo.setDept(rs.getString("dept"));
				vo.setTitle(rs.getString("title"));
				vo.setSalary(rs.getInt("Salary"));
				vo.setHiredate(rs.getDate("hiredate"));
			}
		}catch(Exception e) {
			
		}
		return vo;
	}
	
	//교수등록
	public void insert(ProfessorsVO vo) {
		try {
			String sql="insert into professors(pcode, pname, dept, title, salary, hiredate) values (?,?,?,?,?,?)";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, vo.getPcode());
			ps.setString(2, vo.getPname());
			ps.setString(3, vo.getDept());
			ps.setString(4, vo.getTitle());
			ps.setInt(5, vo.getSalary());
			ps.setDate(6, vo.getHiredate());
			ps.execute();
		}catch(Exception e) {
			System.out.println("교수등록:" + e.toString());
		}		
	}
	//교수코드 중복체크
	public int checkCode(String pcode) {
		int count=-1;
		try {
			String sql="select count(*) cnt from professors where pcode=?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, pcode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count=rs.getInt("cnt");				
			}
			
			
		}catch(Exception e) {
			System.out.println("코드 중복체크: " + e.toString());
		}
		return count;
	}
	
	//교수목록 출력
	public JSONObject list(sqlVO vo) {
		JSONObject jObject=new JSONObject();
		try {
			String sql="call list(?,?,?,?,?,?,?)";
			CallableStatement cs=Database.CON.prepareCall(sql);
			cs.setString(1, "professors");
			cs.setString(2, vo.getKey());
			cs.setString(3, vo.getWord());
			cs.setString(4, vo.getOrder());
			cs.setString(5, vo.getDesc());
			cs.setInt(6, vo.getPage());
			cs.setInt(7, vo.getPerPage());
			cs.execute();
			//검색 목록
			ResultSet rs=cs.getResultSet();
			JSONArray jArray=new JSONArray();
			while(rs.next()) {
				JSONObject obj=new JSONObject();
				obj.put("pcode", rs.getString("pcode"));
				obj.put("pname", rs.getString("pname"));
				obj.put("dept", rs.getString("dept"));
				obj.put("title", rs.getString("title"));
				DecimalFormat df=new DecimalFormat("#,###");
				String strSalary=df.format(rs.getInt("salary"));
				obj.put("salary",strSalary);
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String strHiredate=sdf.format(rs.getDate("hiredate"));
				obj.put("hiredate", strHiredate);
				jArray.add(obj);
			}
			jObject.put("array",jArray);
			
			//검색 데이터 개수
			cs.getMoreResults();
			rs=cs.getResultSet();
			int count=0;
			if(rs.next()) { count=rs.getInt("total");}
				int perPage = vo.getPerPage();
				int totPage = count%perPage==0?count/perPage:count/perPage+1;
				jObject.put("count",count);
				jObject.put("page",vo.getPage());
				jObject.put("perPage",perPage);
				jObject.put("totPage",totPage);
		
		}catch(Exception e) {
			System.out.println("교수목록 : " + e.toString());
		}
		return jObject;
	}
}
