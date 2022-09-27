package TestNg_Assertions;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import TestNg.DriverExtensions;

public class HardAssertions_Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Downloads\\18thJuly2022_Selenium\\chromedriver_win32 (1)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		String actualTitle = driver.getTitle();

		String expectedTitle = "Google";

		Assert.assertEquals(actualTitle, expectedTitle);

		System.out.println("Both strings are same");

		expectedTitle = "OrangeHRM";

		Assert.assertEquals(actualTitle, expectedTitle);

		System.out.println("Both strings are same");
		
		driver.quit();
	}

}
