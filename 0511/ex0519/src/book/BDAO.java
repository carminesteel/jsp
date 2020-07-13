package book;

import java.sql.*;
import java.util.*;

public class BDAO {
	//������� ���
	public ArrayList<BVO> list(String key, String word, int page){
		ArrayList<BVO> array = new ArrayList<BVO>();
		try {
			String sql = "select*from goodsinfo where " + key + " like ? limit ?,5";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, "%"+word+"%");
			ps.setInt(2, (page-1)*5);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BVO vo = new BVO();
				vo.setCode(rs.getString("code"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setPrice(rs.getInt("price"));
				array.add(vo);
			}	
		}catch(Exception e) {
			System.out.println("�Խ��Ǹ�� : " + e.toString());			
		}
		return array;
	}
	
	//������ ���� ���
	public int count(String key, String word) {
		int count=0;
		try {
			String sql="select count(code) total from goodsinfo where " + key + " like ?";
			PreparedStatement ps=Database.CON.prepareStatement(sql);
			ps.setString(1, "%"+word+"%");
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				count=rs.getInt("total");
			}
		}catch(Exception e) {
			System.out.println("������ ���� ���" + e.toString());
		}
		return count;
	}
}