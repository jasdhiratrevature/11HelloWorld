package com.jasdhir.javalin.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.jasdhir.javalin.daos.StudentCollectionDAO;
import com.jasdhir.javalin.daos.StudentDAO;
import com.jasdhir.javalin.daos.StudentPostgressDAO;
import com.jasdhir.javalin.model.Student;
import com.jasdhir.javalin.service.StudentPostgresService;
import com.jasdhir.javalin.service.StudentService;
import com.jasdhir.javalin.utils.ConnectionUtil;

import io.javalin.http.Handler;

public class StudentController {

//static StudentDAO dao= new StudentPostgressDAO();
	//static StudentDAO dao= new StudentCollectionDAO();
	static StudentService service=new StudentPostgresService();
	public static Handler getAllStudents = ctx -> {
		
		List<Student> stuList=service.getAllStudents();
		ctx.json(stuList);

	};

	public static Handler addStudent = ctx -> {
		Student student = ctx.bodyAsClass(Student.class);
		Connection conn = ConnectionUtil.createConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into students values(?,?)");
		pstmt.setInt(1, student.getId());
		pstmt.setString(2, student.getName());
		pstmt.execute();
		ctx.status(201);
	};

	public static Handler updateStudent = ctx -> {
		int id = Integer.parseInt(ctx.pathParam("id"));
		Connection conn = ConnectionUtil.createConnection();
		PreparedStatement pstmt = conn.prepareStatement("update students set name=? where id=?");
		Student student = ctx.bodyAsClass(Student.class);
		pstmt.setString(1, student.getName());
		pstmt.setInt(2, id);
		pstmt.execute();
		ctx.status(200);

	};

	public static Handler deleteStudent = ctx -> {
		int id = Integer.parseInt(ctx.pathParam("id"));
		Connection conn = ConnectionUtil.createConnection();
		PreparedStatement pstmt = conn.prepareStatement("delete from students where id=?");
		pstmt.setInt(1, id);
		pstmt.execute();
		ctx.status(200);

	};

	public static Handler getStudentById = ctx -> {
		int inputId = Integer.parseInt(ctx.pathParam("id"));

		Connection conn = ConnectionUtil.createConnection();

		PreparedStatement pstmt = conn.prepareStatement("Select * from students where id=?");
		pstmt.setInt(1, inputId);
		ResultSet rs = pstmt.executeQuery();

		Student s;
		ArrayList<Student> stuList = new ArrayList<Student>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString("name");
			s = new Student(id, name);
			stuList.add(s);
		}
		if (stuList.size() == 0)
			ctx.status(404);

		ctx.json(stuList);

	};
}
