package com.jasdhir.javalin;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FirstTest {

	@BeforeAll
	public static void setUp() {
		System.out.println("Setting Up ....");
	}
	
	@Test
	public void firstTest() {
		System.out.println("First Test");
	}
	
	@Test
	public void secondTest() {
		System.out.println("Second Test");
	}
	
	@AfterAll
	public static void cleanUp() {
		System.out.println("Clean Up....");
	}
	
}
