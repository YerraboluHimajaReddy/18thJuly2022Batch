package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methods.LoginPageMethods;

public class LoginTest {

	public WebDriver driver;
	
	LoginPageMethods lpm;	

	@BeforeSuite
	public void launchBrowser() {

		System.out.println("In before Suite");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Downloads\\18thJuly2022_Selenium\\chromedriver_win32 (1)\\chromedriver.exe");

		driver = new ChromeDriver();
		
		lpm=new LoginPageMethods(driver);
		
		driver.manage().window().maximize();
	}

	@BeforeClass
	public void launchURL() {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		System.out.println(driver.getTitle());

	}

	@BeforeMethod
	public void getTitle() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test
	public void loginToOrangeHRM() {
		
		lpm.enterUsername();
		lpm.enterPassword("admin123");
		lpm.clickLogin();
	}
	
	@AfterSuite
	public void closeBrowser() {
		
		driver.quit();
	}

}
