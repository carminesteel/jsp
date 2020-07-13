package database;

import courses.CoursesDAO;
import students.StudentsDAO;

public class Main {

	public static void main(String[] args) {
		System.out.println(database.Database.CON);
		sqlVO vo=new sqlVO();
		vo.setKey("lcode");
		vo.setWord("");
		vo.setOrder("lcode");
		vo.setDesc("");
		vo.setPage(1);
		vo.setPerPage(10);
		
		StudentsDAO pdao=new StudentsDAO();
		System.out.println(pdao.list(vo));
		
		CoursesDAO pdao1=new CoursesDAO();
		System.out.println(pdao1.list(vo));
	}
}
