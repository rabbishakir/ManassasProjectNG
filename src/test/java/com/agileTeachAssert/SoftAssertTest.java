package com.agileTeachAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	// softassert is a class of TestNG

	@Test
	void loginTest() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://agileteach.com");

		SoftAssert sft = new SoftAssert(); // created the object

		String expectedTitle = "Agile1Tech IT Training School"; // expected title
		String actualTitle = driver.getTitle(); // we will get actual title // from runtime

		sft.assertEquals(actualTitle, expectedTitle);

		// Assert.assertEquals(actualTitle, expectedTitle); //

		driver.findElement(By.className("myPortal")).click(); //

		sft.assertAll();

	}

}
