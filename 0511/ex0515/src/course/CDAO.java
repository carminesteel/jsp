package course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import enroll.EVO;
import professor.PVO;

public class CDAO {
	public Connection con() throws Exception{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "haksa";
		String password = "pass";
		   
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, user, password);
		
		return con;
		
	}
	
	//강의목록 출력
	public ArrayList<CVO> list() throws Exception{
		ArrayList<CVO> list = new ArrayList<CVO>();
		String sql = "select * from courses";
		PreparedStatement ps = con().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			CVO vo = new CVO();
			vo.setLcode(rs.getString("lcode"));
			vo.setLname(rs.getString("lname"));
			vo.setHours(rs.getInt("hours"));
			vo.setRoom(rs.getString("room"));
			vo.setInstructor(rs.getString("instructor"));
			vo.setCapacity(rs.getInt("capacity"));
			vo.setPersons(rs.getInt("persons"));
			list.add(vo);
		}
		return list;
	}
	
	//강의등록
	public void insert(CVO vo) throws Exception{
		ArrayList<CVO> list = new ArrayList<CVO>();
		String sql = "insert into courses(lcode, lname, hours, room, instructor, capacity, persons)values(?,?,?,?,?,?,?)";
		PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, vo.getLcode());
			ps.setString(2, vo.getLname());
			ps.setInt(3, vo.getHours());
			ps.setString(4, vo.getRoom());
			ps.setString(5, vo.getInstructor());
			ps.setInt(6, vo.getCapacity());
			ps.setInt(7, vo.getPersons());
			ps.execute();
		
	}
	
	//강의삭제
		public void delete(String lcode) throws Exception{
			CVO vo = new CVO();
			String sql = "delete from courses where lcode=?";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, vo.getLcode());
			ps.execute();			
		}
		
		public CVO read(String lcode) throws Exception{
			CVO vo=new CVO();
			String sql="select*from courses where lcode = ?";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, lcode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setLcode(rs.getString("lcode"));
				vo.setLname(rs.getString("lname"));
				vo.setHours(rs.getInt("hours"));
				vo.setRoom(rs.getString("room"));
				vo.setInstructor(rs.getString("instructor"));
				vo.setCapacity(rs.getInt("capacity"));
				vo.setPersons(rs.getInt("persons"));
			}
			return vo;
		}
		
		
	
}

	
	

