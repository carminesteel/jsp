package user;

import java.sql.*;

import database.Database;

public class UserDAO {
	//로그인 체크
	public UserVO login(String id) {
		UserVO vo=new UserVO();
		try {
			String sql="select*from users where id=?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				System.out.println("userDAOlogin");
			}
		}catch(Exception e) {
			System.out.println("로그인체크"+e.toString());
		}
		return vo;
	}
}
