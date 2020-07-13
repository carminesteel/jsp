package user;

import java.sql.*;
import java.util.*;

public class UserDAO {
	public Connection con() throws Exception{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "haksa";
		String password = "pass";
		   
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, user, password);
		
		return con;
	}
	
	//����� ������
	public ArrayList<UserVO> list() throws Exception{
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		String sql = "select * from tbl_user";
		PreparedStatement ps = con().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			UserVO vo = new UserVO();
			vo.setId(rs.getString("id"));
			vo.setPass(rs.getString("pass"));
			vo.setUname(rs.getString("uname"));
			list.add(vo);
		}
		return list;		
	}
	
	//����� �Է�
	
	public void insert(UserVO vo)throws Exception{
		String sql = "insert into tbl_user(id, pass, uname) values (?,?,?)";
		PreparedStatement ps = con().prepareStatement(sql);
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPass());
		ps.setString(3, vo.getUname());
		ps.execute();
	}
	
	//����ڻ���
	public void delete(String id)throws Exception{
		String sql="delete from tbl_user where id = ?";
		PreparedStatement ps = con().prepareStatement(sql);
		ps.setString(1, id);
		ps.execute();
	}
	
	//����ڼ���
	public void update(String uname, String id)throws Exception{
		String sql="update tbl_user set uname=? where id=?";
		PreparedStatement ps = con().prepareStatement(sql);
		ps.setString(1, uname);
		ps.setString(2, id);
		ps.execute();
	}
}