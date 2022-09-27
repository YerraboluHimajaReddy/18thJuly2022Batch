package Listeners;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methods.LoginPageMethods;

public class Example1 extends ListenersExample{

	private static final By By = null;
	public WebDriver driver;

	@BeforeSuite
	public void launchBrowser() throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Downloads\\18thJuly2022_Selenium\\chromedriver_win32 (1)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();

	}

	@BeforeClass
	public void launchURL() throws IOException {

		beforeNavigateTo("https://testautomationpractice.blogspot.com/",driver);
		
		driver.get("https://testautomationpractice.blogspot.com/");

		afterNavigateTo("Before navigating the page",driver);

		System.out.println(driver.getTitle());

	}

	@BeforeMethod
	public void getTitle() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void enterField2() throws IOException {

		beforeFindBy(By, null, driver);
		driver.findElement(By.id("field2")).sendKeys("Saag");
		afterFindBy(By, null, driver);

	}

	@AfterSuite
	public void closeBrowser() {

		driver.quit();
	}

}
