package com.saucedemo.assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertionTest {
	
	
	WebDriver driver;
	
	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		driver.get("https://agileteach.com");
	}
	
	@Test
	void logoTest() {
	
	WebElement	logo = driver.findElement(By.className("img-logo"));
	Assert.assertFalse(logo.isDisplayed(), "Logo Found");
		
	}
	
	@Test
	void titleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Agile1Tech", "Title Does not Match");
	}
	
	@AfterClass
	void exitTest() {
		driver.close();
	}
	
	

}
