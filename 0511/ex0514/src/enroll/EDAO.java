package enroll;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import course.CVO;

public class EDAO {
	public Connection con() throws Exception{
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "haksa";
		String password = "pass";
		   
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url, user, password);
		
		return con;
	}
	
	public void update(EVO vo) throws Exception{
		String sql="update enrollments set grade=? where scode=? and lcode=?";
		PreparedStatement ps = con().prepareStatement(sql);
		ps.setInt(1, vo.getGrade());
		ps.setString(2, vo.getScode());
		ps.setString(3, vo.getLcode());
		ps.execute();
	}
	
	//특정학생이 수강신청한 수강신청 목록
	public ArrayList<EVO> slist(String scode) throws Exception{
		ArrayList<EVO> list=new ArrayList<EVO>();
		String sql="select e.*, c.lname from enrollments e, courses c where scode=? and e.lcode=c.lcode";
		PreparedStatement ps = con().prepareStatement(sql);
		ps.setString(1, scode);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			EVO vo = new EVO();
			vo.setLcode(rs.getString("lcode"));
			vo.setEdate(rs.getString("edate"));
			vo.setGrade(rs.getInt("grade"));
			vo.setLname(rs.getString("lname"));
			list.add(vo);
		}		
		return list;		
	}
	
	//수강신청
	public int insert(String scode, String lcode) throws Exception{
		int cnt=0;
		String sql="{call add_enroll(?,?,?)}";
		CallableStatement cs=con().prepareCall(sql);
		cs.setString(1, scode);
		cs.setString(2, lcode);
		cs.registerOutParameter(3, oracle.jdbc.OracleTypes.NUMBER);
		cs.execute();
		cnt=cs.getInt(3);
		return cnt;
	}
	
	//수강취소
		public void delete(String scode, String lcode) throws Exception{
			String sql="delete from enrollments where scode=? and lcode=?";
			PreparedStatement ps=con().prepareStatement(sql);			
			ps.setString(1, scode);
			ps.setString(2, lcode);
			ps.execute();
			
		}
		
	
		
		//특정교수가 담당하는 강좌 목록
		public ArrayList<EVO> Clist(String pcode) throws Exception{
			ArrayList<EVO> list=new ArrayList<EVO>();
			String sql="select e.*, c.lname from enrollments e, courses c where pcode=? and e.lcode=c.lcode";
			PreparedStatement ps = con().prepareStatement(sql);
			ps.setString(1, pcode);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				EVO vo = new EVO();
				vo.setLcode(rs.getString("lcode"));
				vo.setEdate(rs.getString("edate"));
				vo.setGrade(rs.getInt("grade"));
				vo.setLname(rs.getString("lname"));
				list.add(vo);
			}		
			return list;		
		}
		
		//특정교수가 담당하는 강좌 목록
				public ArrayList<EVO> clist(String lcode) throws Exception{
					ArrayList<EVO> list=new ArrayList<EVO>();
					String sql="select *from enrollments where lcode=?";
					PreparedStatement ps = con().prepareStatement(sql);
					ps.setString(1, lcode);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						EVO vo = new EVO();
						vo.setLcode(rs.getString("lcode"));
						vo.setEdate(rs.getString("edate"));
						vo.setGrade(rs.getInt("grade"));
						vo.setLname(rs.getString("lname"));
						list.add(vo);
					}		
					return list;		
				}
}
