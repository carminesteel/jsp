package courses;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import database.Database;
import database.sqlVO;
import javafx.scene.chart.PieChart.Data;

public class CoursesDAO {
		//강좌삭제
		public int delete(String lcode) {
			int count=-1;
			try {
				String sql="select count(*) cnt from enrollments where lcode=?";
				PreparedStatement ps = Database.CON.prepareStatement(sql);
				ps.setString(1, lcode);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					count=rs.getInt("cnt");
				}
				if(count==0) {
					sql="delete from courses where lcode=?";
					ps = Database.CON.prepareStatement(sql);
					ps.setString(1, lcode);
					ps.execute();					
				}
			}catch(Exception e) {
				System.out.println("강좌삭제:"+e.toString());
			}
			return count;
		}
	
		public void update(CoursesVO vo) {
		try {
			String sql="update courses set hours=?,room=?,capacity=?,persons=? where lcode=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setInt(1, vo.getHours());
			ps.setString(2, vo.getRoom());
			ps.setInt(3, vo.getCapacity());
			ps.setInt(4, vo.getPersons());
			ps.setString(5, vo.getLcode());
			ps.execute();
		}catch(Exception e) {
			System.out.println("강좌수정"+e.toString());
		}
			
		}
	
		//강좌정보읽기
		public CoursesVO read(String lcode) {
			CoursesVO vo=new CoursesVO();
			try {
				String sql="select c.*, pname from courses c left join professors on pcode=instructor where lcode=?";
				PreparedStatement ps = Database.CON.prepareStatement(sql);
				ps.setString(1, lcode);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					vo.setLcode(rs.getString("lcode"));
					vo.setLname(rs.getString("lname"));
					vo.setRoom(rs.getString("room"));
					vo.setInstructor(rs.getString("lcode"));
					vo.setHours(rs.getInt("hours"));
					vo.setCapacity(rs.getInt("capacity"));
					vo.setPersons(rs.getInt("persons"));
					vo.setPname(rs.getString("pname"));
				}
			}catch(Exception e) {
				System.out.println("강좌정보읽기 : " + e.toString());
			}
			return vo;
		}
		//강좌등록
		public void insert(CoursesVO vo) {
			try {
				String sql="insert into courses(lcode, lname, hours, room, instructor, capacity, persons) values (?,?,?,?,?,?,?)";
				PreparedStatement ps=Database.CON.prepareStatement(sql);
				ps.setString(1, vo.getLcode());
				ps.setString(2, vo.getLname());
				ps.setInt(3, vo.getHours());
				ps.setString(4, vo.getRoom());
				ps.setString(5, vo.getInstructor());
				ps.setInt(6, vo.getCapacity());
				ps.setInt(7, vo.getPersons());
				ps.execute();
			}catch(Exception e) {
				System.out.println("강좌등록"+e.toString());
			}
				
			}
		//강좌코드체크
		public int checkCode(String lcode) {
			int count=-1;
			try {
				String sql="select count(*) cnt from courses where lcode=?";
				PreparedStatement ps=Database.CON.prepareStatement(sql);
				ps.setString(1, lcode);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					count=rs.getInt("cnt");
				}
			}catch(Exception e) {
				System.out.println("강좌코드체크 : " + e.toString());
			}
			return count;
		}
		//모든 강좌목록 출력
		public ArrayList<CoursesVO> listAll(){
			ArrayList<CoursesVO> list = new ArrayList<CoursesVO>();
			try {
				String sql="select c.*, pname from courses c left join professors p on instructor=pcode";
				PreparedStatement ps=Database.CON.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					CoursesVO vo = new CoursesVO();
					vo.setLcode(rs.getString("lcode"));
					vo.setLname(rs.getString("lname"));
					vo.setPname(rs.getString("pname"));
					list.add(vo);
				}
			}catch(Exception e) {
				
			}
			return list;			
		}
		//강좌목록 출력
		public JSONObject list(sqlVO vo) {
			JSONObject jObject=new JSONObject();
			try {
				String sql="call list(?,?,?,?,?,?,?)";
				CallableStatement cs=Database.CON.prepareCall(sql);
				String tbl="(select c.*, pname from courses c left join professors p on instructor=pcode) tbl";
				cs.setString(1, tbl);
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
					obj.put("lcode", rs.getString("lcode"));
					obj.put("lname", rs.getString("lname"));
					obj.put("pname", rs.getString("pname"));
					obj.put("room", rs.getString("room"));
					obj.put("persons", rs.getInt("persons"));
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
				System.out.println("강의목록 : " + e.toString());
			}
			return jObject;
		}
}
