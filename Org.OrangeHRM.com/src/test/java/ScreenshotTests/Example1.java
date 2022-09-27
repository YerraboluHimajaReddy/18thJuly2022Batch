package ScreenshotTests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methods.LoginPageMethods;

public class Example1 {

	public WebDriver driver;

	File screenshots;

	@BeforeSuite
	public void launchBrowser() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Downloads\\18thJuly2022_Selenium\\chromedriver_win32 (1)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		screenshots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshots, new File(
				"C:\\Users\\himaj\\eclipse-workspace\\18thJuly2022Batch\\Org.OrangeHRM.com\\src\\test\\java\\ScreenshotImages\\BrowserLaunched.png"));
	}

	@BeforeClass
	public void launchURL() throws IOException {

		driver.get("https://testautomationpractice.blogspot.com/");

		System.out.println(driver.getTitle());

		FileUtils.copyFile(screenshots, new File(
				"C:\\Users\\himaj\\eclipse-workspace\\18thJuly2022Batch\\Org.OrangeHRM.com\\src\\test\\java\\ScreenshotImages\\URLLaunched.png"));

	}

	@BeforeMethod
	public void getTitle() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void enterField2() throws IOException {

		driver.findElement(By.id("field2")).sendKeys("Saag");
		
		FileUtils.copyFile(screenshots, new File("C:\\Users\\himaj\\eclipse-workspace\\18thJuly2022Batch\\Org.OrangeHRM.com\\src\\test\\java\\ScreenshotImages\\filed2.png"));

	}

	@AfterSuite
	public void closeBrowser() {

		driver.quit();
	}

}
