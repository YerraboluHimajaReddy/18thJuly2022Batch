package TestNg_Assertions;

import java.time.Duration;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import TestNg.DriverExtensions;

public class HardAssertions_Example2 {

	public WebDriver driver;
	
	@BeforeSuite
	public void launchBrowser() {
		
		System.out.println("In before Suite");
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Downloads\\18thJuly2022_Selenium\\chromedriver_win32 (1)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void launchURL() {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test(priority = 1)
	public void validate() {
		
		String actualTitle = driver.getTitle();

		String expectedTitle= "OrangeHRM";

		Assert.assertEquals(actualTitle, expectedTitle);

		System.out.println("Both strings are same");
	}
	
	@Test(priority = 2)
	public void assertTrue() {		

		Assert.assertTrue(true);

		Assert.assertTrue(true,"But the value is false");

		System.out.println("Both strings are same");
		
		Assert.assertTrue(false);

		Assert.assertTrue(false,"But the value is false");
	}
	
	
	@Test(priority = 3)
	public void assertFlase() {		

		Assert.assertFalse(false);

		Assert.assertFalse(false,"But the value is true");
		
		Assert.assertFalse(true);

		Assert.assertFalse(true,"But the value is false");
	}
	
	@Test(priority = 0)
	public void enterUsername() {
		
		String actualTitle = driver.getTitle();

		String expectedTitle = "Google";

		Assert.assertEquals(actualTitle, expectedTitle,"Both strings are same");

		System.out.println(actualTitle);
		
		System.out.println(expectedTitle);

	}
	
	@AfterSuite
	public void closeBrowser() {
		
		System.out.println("In After Suite");

		driver.quit();
	}

}
