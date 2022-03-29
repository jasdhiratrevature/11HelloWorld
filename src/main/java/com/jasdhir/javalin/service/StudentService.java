package com.jasdhir.javalin.service;

import java.util.List;

import com.jasdhir.javalin.model.Student;

public interface StudentService {
// Will provide service to access the DAO Layer
	// read
		List<Student >getAllStudents();
}
