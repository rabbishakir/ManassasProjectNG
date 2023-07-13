package com.agile.testNgTutorial;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class sauceDemoFunctionAllFinal {

	WebDriver driver;

	@BeforeTest
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}

	@AfterTest
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

	@AfterClass
	void logout() {
		driver.findElement(By.xpath("//button[contains(text(), 'Open Menu')]")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();

	}

	@Test(priority = 1)
	void dashBoard() throws InterruptedException {
		WebElement pageNameElement = driver
				.findElement(By.xpath("//div[text() = 'Products' and @class='product_label']"));
		String pageName = pageNameElement.getText();
		String givenName = "Products";
		Assert.assertEquals(pageName, givenName); // testNG assertion
	}

	@Test(priority = 2)
	void productAlpabeticsort() throws InterruptedException {
		WebElement selectelemnt = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select sc = new Select(selectelemnt);
		sc.selectByValue("za");
		Thread.sleep(3000);
		sc.selectByValue("az");
	}

	@Test(priority = 3)
	void productPriceSort() throws InterruptedException {
		WebElement selectelemnt = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		Select sc = new Select(selectelemnt);
		sc.selectByVisibleText("Price (low to high)");
		Thread.sleep(3000);
		sc.selectByVisibleText("Price (high to low)");
	}

	@Test(priority = 4)
	void pageValidation() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button")).click();
		driver.findElement(By.xpath("//a[@id='about_sidebar_link']")).click();
		String expectedUrl = "https://saucelabs.com/";
		String actualUrl = driver.getCurrentUrl();

		SoftAssert sft = new SoftAssert(); // created the object
		sft.assertEquals(actualUrl, expectedUrl);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Close Menu']")).click();
		sft.assertAll();

	}

	@Test(priority = 5)
	void productCountTest() {
		WebElement parentProduct = driver.findElement(By.className("inventory_list"));
		List<WebElement> childDIv = parentProduct.findElements(By.className("inventory_item"));
		int numberOfDiv = childDIv.size();
		int expectedNumber = 6;
		Assert.assertEquals(numberOfDiv, expectedNumber);
	}

	// we will take this to a different test called product check functionality

	@Test(priority = 6)
	void singleProductCheck() throws InterruptedException {

		WebElement parentProduct = driver.findElement(By.className("inventory_list"));
		List<WebElement> childDIv = parentProduct.findElements(By.className("inventory_item"));
		int numberOfDiv = childDIv.size();

		for (int i = 0; i < numberOfDiv; i++) {
			driver.findElement(By.xpath("//div[@class='inventory_item_label']/a[contains(@href, 'id=" + i + "')]"))
					.click();
			Thread.sleep(3000);
			driver.navigate().back();
			Thread.sleep(3000);
		}

		/*
		 * driver.findElement(By.
		 * xpath("//div[@class='inventory_item_label']/a[contains(@href, 'id=4')]")).
		 * click(); Thread.sleep(3000); driver.navigate().back(); Thread.sleep(3000);
		 * 
		 */

	}

	// we will take this to a different test called cart functionality

	@Test(priority = 7)
	void addToCart() {
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[6]")).click();
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[5]")).click();
	}

	@Test(priority = 8, dependsOnMethods = "addToCart")
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
