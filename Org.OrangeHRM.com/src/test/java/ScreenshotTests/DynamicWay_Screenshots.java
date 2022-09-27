package ScreenshotTests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class DynamicWay_Screenshots {

	public WebDriver driver;
	
	public void takeScreenshot(String screenshotName) throws IOException {	

		File screenshots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshots, new File(
				"C:\\Users\\himaj\\eclipse-workspace\\18thJuly2022Batch\\Org.OrangeHRM.com\\src\\test\\java\\ScreenshotImages\\" + screenshotName));
	
	}
}
