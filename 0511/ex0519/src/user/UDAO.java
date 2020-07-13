package user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import book.Database;


public class UDAO {
	//회원 목록
	public ArrayList<UVO> list(String key, String word, int page, int perpagenum){
		ArrayList<UVO> list = new ArrayList<UVO>();
		try {
			String sql = "select*from userinfo where " + key + " like ? limit ?,?";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, "%"+word+"%");
			ps.setInt(2, (page-1)*perpagenum);
			ps.setInt(3, perpagenum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				UVO vo = new UVO();
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setJob(rs.getString("job"));
				vo.setTel(rs.getString("tel"));
				list.add(vo);
			}	
		}catch(Exception e) {
			System.out.println("게시판목록 : " + e.toString());			
		}
		return list;
	}
	
	//회원수
	public int count(String key, String word) {
		int count=0;
		try {
			String sql="select count(*) total from userinfo where " + key + " like ?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, "%"+word+"%");
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				count=rs.getInt("total");
			}
		}catch(Exception e) {
			System.out.println("데이터 개수 출력" + e.toString());
		}
		return count;
	}
}
