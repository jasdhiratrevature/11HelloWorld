package com.jasdhir.javalin.daos;

import java.util.List;

import com.jasdhir.javalin.model.Student;

public interface StudentDAO {
// this interface will act as a contract for all the DAO's implementation Classes
	// CollectionDAO, FILEDAO,PostgresDAO
	
	
	// read
	List<Student >getAllStudents();
	
	// create
	
	// update 
	
	// delete
	
}
