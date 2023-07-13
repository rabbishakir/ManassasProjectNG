package com.agileTeachAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class AssertTest {

	// assertion // assertTrue(); assertFalse(), AsserEqual(); // done
	// Passing Parameters // // done
	// DataProvider // done
	// SoftAssert // done
	// multiDimentional Array // done

	// in our portal we will test the logo and the title

	// we need seleium

	WebDriver driver;

	@BeforeClass
	@Parameters({ "Browser", "url" })
	void setupDriver(String browser, String url) {
		// if else condition to check the browser

		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} else {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}

		driver.get(url);
	}

	@AfterClass
	void exit() {
		driver.quit();
	}

	@Test
	void logoTest() {
		WebElement logo = driver.findElement(By.xpath("//img[@class='img-logo']"));
		Assert.assertTrue(logo.isDisplayed());
	}

	@Test
	void titleTest() {
		// check if the title matches the expected with actual
		String expectedTitle = "Agile1Tech IT Training School"; // expected title
		String actualTitle = driver.getTitle(); // we will get actual title // from runtime
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
