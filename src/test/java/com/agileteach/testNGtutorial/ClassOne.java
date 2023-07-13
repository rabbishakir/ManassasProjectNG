package com.agileteach.testNGtutorial;

import org.testng.annotations.Test;

public class ClassOne {

	
	@Test
	void testOne() throws InterruptedException {
		
		System.out.println("I am fist statement from class One");
		Thread.sleep(3000);
		System.out.println("I am second Statement from Class One");
		
	}
}
