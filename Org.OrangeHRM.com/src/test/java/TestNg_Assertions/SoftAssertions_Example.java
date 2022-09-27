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
import org.testng.asserts.SoftAssert;

import TestNg.DriverExtensions;

public class SoftAssertions_Example {

	public WebDriver driver;

	SoftAssert softAssertion;

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

		softAssertion = new SoftAssert();

		String actualTitle = driver.getTitle();

		String expectedTitle = "OrangeHRM";

		softAssertion.assertEquals(actualTitle, expectedTitle);

		System.out.println("Both strings are same");

		softAssertion.assertAll();
	}

	@Test(priority = 2)
	public void assertTrue() {

		softAssertion = new SoftAssert();

		softAssertion.assertTrue(true);

		softAssertion.assertTrue(true, "But the value is false");

		System.out.println("Both strings are same");

		softAssertion.assertTrue(false);

		softAssertion.assertTrue(false, "But the value is false");

		softAssertion.assertAll();

	}

	@Test(priority = 3)
	public void assertFlase() {

		softAssertion = new SoftAssert();

		softAssertion.assertFalse(false);

		softAssertion.assertFalse(false, "But the value is true");

		softAssertion.assertFalse(true);

		softAssertion.assertFalse(true, "But the value is false");

		softAssertion.assertAll();
	}

	@Test(priority = 0)
	public void enterUsername() {

		softAssertion = new SoftAssert();

		String actualTitle = driver.getTitle();

		String expectedTitle = "Google";

		softAssertion.assertEquals(actualTitle, expectedTitle, "Both strings are same");

		System.out.println(actualTitle);

		System.out.println(expectedTitle);

		softAssertion.assertAll();
	}

	@AfterSuite
	public void closeBrowser() {

		System.out.println("In After Suite");

		driver.quit();
	}

}
