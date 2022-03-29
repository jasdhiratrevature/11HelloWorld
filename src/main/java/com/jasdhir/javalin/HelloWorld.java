package com.jasdhir.javalin;

import com.jasdhir.javalin.controller.HelloController;
import com.jasdhir.javalin.controller.StudentController;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
		
		  Javalin app = Javalin.create(ctx->{ ctx.enableCorsForAllOrigins();}).start();
		 
        
        //Javalin app=Javalin.create().start();
        
        app.get("/", ctx->ctx.result("Hello World"));
        
        app.get("/hello", ctx->ctx.result("Hello World Again"));
        
        app.get("/hello/{name}", ctx->ctx.result("Hello "+ctx.pathParam("name").toUpperCase()));
        
        app.get("/helloHandler", HelloController.sayHello);
        
        app.get("/helloJSON", HelloController.getJSON);
        
        app.get("/student", HelloController.getStudent);
        
        app.get("/students", StudentController.getAllStudents);
                
        app.post("/students", StudentController.addStudent);
        
        app.put("/students/{id}", StudentController.updateStudent);
                
        app.delete("/students/{id}", StudentController.deleteStudent);
        
        app.get("/students/{id}", StudentController.getStudentById);
        
    }
}
