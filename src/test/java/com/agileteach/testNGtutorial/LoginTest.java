package com.agileteach.testNGtutorial;

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

public class LoginTest {

	WebDriver driver;

	@BeforeClass
	void driverInitialize() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterClass(enabled = false)
	void quitDriver() {
		driver.quit();
	}

	@BeforeMethod
	void login() {
		driver.get("https://www.saucedemo.com/v1/");
		driver.findElement(By.xpath("//*[@class='form_input' and @id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@class='form_input' and @id='password']")).sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginButton.click();
	}

	@AfterMethod
	void logout() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Open Menu']")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
	}

	@Test(priority = 1, alwaysRun = true)
	void addtocart() {
		driver.findElement(By.xpath("//*[@class='form_input' and @id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@class='form_input' and @id='password']")).sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginButton.click();
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[6]")).click();
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[5]")).click();
	}

	@Test(enabled = false)
	void checkout() {
		driver.findElement(By.xpath("//a[contains(text(),'cart.html')]")).click();
	}

}
