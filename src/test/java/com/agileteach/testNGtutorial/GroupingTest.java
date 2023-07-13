package com.agileteach.testNGtutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupingTest {

	WebDriver driver;

	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		driver.get("https://www.saucedemo.com/v1/");
	}

	@AfterClass
	void teardown() {
		driver.quit();
	}

	@BeforeMethod
	void login() {
		driver.findElement(By.xpath("//*[@class='form_input' and @id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@class='form_input' and @id='password']")).sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginButton.click();
		Assert.fail();
	}

	@Test
	void addtoCart() {
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[6]")).click();
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[5]")).click();
	}

	@Test(dependsOnMethods = { "login", "addtoCart" })
	void checkout() {

	}

	@AfterMethod
	void logout() {
		driver.findElement(By.xpath("//*[text()='Open Menu']")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();

	}

}
