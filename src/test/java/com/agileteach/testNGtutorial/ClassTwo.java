package com.agileteach.testNGtutorial;

import org.testng.annotations.Test;

public class ClassTwo {

	@Test(groups = "Smoke")
	void testTwo() throws InterruptedException {

		System.out.println("I am fist statement from Class Two");
		Thread.sleep(3000);
		System.out.println("I am second Statement from Class two");

	}

	@Test(groups = "Regression")
	void groupTest() {
		System.out.println("This is Regression test");
	}

	@Test(groups = "Smoke")
	void groupTwo() {
		System.out.println("This is Smoke");
	}

}
