package com.jasdhir.javalin.service;

import java.util.List;

import com.jasdhir.javalin.daos.StudentDAO;
import com.jasdhir.javalin.daos.StudentPostgressDAO;
import com.jasdhir.javalin.model.Student;

public class StudentPostgresService implements StudentService{
	StudentDAO dao= new StudentPostgressDAO();
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return dao.getAllStudents();
	}

}
