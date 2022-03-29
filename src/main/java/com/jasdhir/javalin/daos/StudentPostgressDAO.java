package com.jasdhir.javalin.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jasdhir.javalin.model.Student;
import com.jasdhir.javalin.utils.ConnectionUtil;

public class StudentPostgressDAO implements StudentDAO{

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		// write logic to access DB here
		Connection conn = ConnectionUtil.createConnection();
		Student s;
		ArrayList<Student> stuList = new ArrayList<Student>();
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("Select * from students");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString("name");
				s = new Student(id, name);
				stuList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return stuList;
	}
	// this class will have methods that will perform CRUD operation on Student 
		// using the Psdtgres or any other DB
	
	// CREATE
	
	// READ
	
	// UPDATE
	
	// DELETE
	
	
	
	
}
