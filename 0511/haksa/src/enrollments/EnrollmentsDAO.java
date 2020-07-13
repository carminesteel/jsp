package enrollments;

import java.sql.*;

import org.json.simple.*;

import database.Database;

public class EnrollmentsDAO {
	//��������
	public void update(String lcode, String scode, int grade) {
		try {
			String sql="update enrollments set grade=? where lcode=? and scode=?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setInt(1, grade);
			ps.setString(2, lcode);
			ps.setString(3, scode);
			ps.execute();
		}catch(Exception e) {
			System.out.println("���� ����:" + e.toString());
		}
	}
	
	//Ư�� ���¸� �����ϴ� �л� ���
	public JSONObject es(String lcode) {
		JSONObject jObject=new JSONObject();
		try {
			String sql="select es.*,pname from es left join professors p on advisor=pcode where lcode=?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, lcode);
			ResultSet rs = ps.executeQuery();

			JSONArray jArray=new JSONArray();
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("scode", rs.getString("scode"));
				obj.put("sname", rs.getString("sname"));
				obj.put("edate", rs.getString("edate"));
				obj.put("grade", rs.getInt("grade"));
				obj.put("dept", rs.getString("dept"));
				obj.put("year", rs.getInt("year"));
				obj.put("advisor", rs.getString("advisor"));
				obj.put("pname", rs.getString("pname"));
				jArray.add(obj);
			}
			jObject.put("array", jArray);
		}catch(Exception e) {
			System.out.println("Ư������ �л����:" + e.toString());
		}
		return jObject;
	}
	
	//�������
		public void delete(String scode, String lcode) {
			try {
				String sql="delete from enrollments where scode=? and lcode=?";
				PreparedStatement ps = Database.CON.prepareStatement(sql);
				ps.setString(1, scode);	
				ps.setString(2, lcode);	
				ps.execute();
			}catch(Exception e) {
				System.out.println("�������:" + e.toString());
			}			
		}
	
	//������û
	public int insert(String scode, String lcode) {
		int count=-1;
		try {
			String sql="call add_enroll(?,?,?)";
			CallableStatement cs=Database.CON.prepareCall(sql);
			 cs.setString(1, scode);
			 cs.setString(2, lcode);
			 cs.registerOutParameter(3, java.sql.Types.INTEGER);
			 cs.execute();
			 count = cs.getInt(3);			
		}catch(Exception e) {
			System.out.println("������û:" + e.toString());
		}
		return count;
		
	}
	
	//Ư���л��� ������û�� ���¸��
	public JSONObject ec(String scode) {
		JSONObject jObject=new JSONObject();
		try {
			String sql="select ec.*, pname from ec join professors on instructor=pcode where scode=?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, scode);
			ResultSet rs = ps.executeQuery();
			
			JSONArray jArray=new JSONArray();
			while(rs.next()) {
				JSONObject obj = new JSONObject();
				obj.put("lcode", rs.getString("lcode"));
				obj.put("lname", rs.getString("lname"));
				obj.put("edate", rs.getString("edate"));
				obj.put("pname", rs.getString("pname"));
				obj.put("hours", rs.getString("hours"));
				obj.put("room", rs.getString("room"));
				jArray.add(obj);
			}
			jObject.put("array", jArray);
		}catch(Exception e) {
			System.out.println("Ư���л� ���¸��:" + e.toString());
		}
		return jObject;
	}
}
