package com.agile.testNgTutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartFunctionality {
	
	WebDriver driver;

	@BeforeTest
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}

	@AfterTest(enabled = true)
	void close() {
		driver.close();
	}

	@BeforeClass
	void login() { 
		driver.get("https://www.saucedemo.com/v1/");
		driver.findElement(By.xpath("//*[@class='form_input' and @id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@class='form_input' and @id='password']")).sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginButton.click();
	}

	@AfterClass(enabled = true)
	void logout() {
		driver.findElement(By.xpath("//button[contains(text(), 'Open Menu')]")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();

	}
	
	@Test(priority = 1)
	void addToCart() {
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[6]")).click();
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[5]")).click();
	}

	@Test(priority = 2, dependsOnMethods = "addToCart")
	void checkout() throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(@href, 'cart.html')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'CHECKOUT')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.id("first-name")).sendKeys("Rabbi");
		driver.findElement(By.id("last-name")).sendKeys("Shakir Ali");
		driver.findElement(By.id("postal-code")).sendKeys("22030");
		driver.findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(text(), 'FINISH')]")).click();

	}


}
