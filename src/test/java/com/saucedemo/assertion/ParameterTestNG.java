package com.saucedemo.assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class ParameterTestNG {

	// parameter is important in TESTING
	// we are going to use the same example to parameterize the browser and url

	WebDriver driver;

	@BeforeClass
	@Parameters({ "browser", "app" })
	void setup(String browser, String url) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		driver.get(url);
	}

	@Test
	void logoTest() {

		WebElement logo = driver.findElement(By.className("img-logo"));
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
