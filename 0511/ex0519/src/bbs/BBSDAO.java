package bbs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import book.Database;


public class BBSDAO {
	//�Խ��� ���
	public ArrayList<BBSVO> list(String key, String word, int page){
		ArrayList<BBSVO> list = new ArrayList<BBSVO>();
		try {
			String sql = "select*from bbs where " + key + " like ? order by seqno limit ?,5";
			PreparedStatement ps = Database.CON.prepareStatement(sql);
			ps.setString(1, "%"+word+"%");
			ps.setInt(2, (page-1)*5);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BBSVO vo = new BBSVO();
				vo.setSeqno(rs.getInt("seqno"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setWdate(rs.getString("wdate"));
				list.add(vo);
			}	
		}catch(Exception e) {
			System.out.println("�Խ��Ǹ�� : " + e.toString());			
		}
		return list;
	}
	
	//�۰���
	public int count(String key, String word) {
		int count=0;
		try {
			String sql="select count(*) total from bbs where " + key + " like ?";
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
