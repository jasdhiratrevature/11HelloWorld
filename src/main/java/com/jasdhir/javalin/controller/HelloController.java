package com.jasdhir.javalin.controller;

import com.jasdhir.javalin.model.Student;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class HelloController {

	public static Handler sayHello=ctx->{
		ctx.result("Hello From Handler");
	};
	
	public static Handler getJSON=ctx->{
		ctx.json("Hello World");
	};
	public static Handler getStudent=ctx->{
		Student s=new Student(1,"Jasdhir");
		ctx.json(s);
	};

}
