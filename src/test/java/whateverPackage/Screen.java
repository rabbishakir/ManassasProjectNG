package whateverPackage;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screen {
	
	public static void main(String[] args) {
		
		
		
		System.out.println("Test");
		
		WebDriver driver;
		
		
		driver.manage().window().fullscreen(); // Optional: maximize the window for a full-page screenshot

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);



        // Save the screenshot to a file

        try {

        	FileUtils.copyFile(screenshot, new File("screen.png"));

            FileUtils.copyFile(screenshotFile, new File("screenshot.png"));

            System.out.println("Screenshot saved successfully.");

        } catch (IOException e) {

            e.printStackTrace();

        }
		
	}

}
