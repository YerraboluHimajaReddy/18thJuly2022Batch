package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Methods.LoginPageMethods;
import Pages.HomePage;
import Pages.SignoutPage;

public class LoginAndLogout {

	public WebDriver driver;
	
	LoginPageMethods lpm;	
	
	HomePage hp;
	
	SignoutPage sp;

	@BeforeSuite
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Downloads\\18thJuly2022_Selenium\\chromedriver_win32 (1)\\chromedriver.exe");

		driver = new ChromeDriver();
		
		lpm=new LoginPageMethods(driver);
		
		hp=PageFactory.initElements(driver, HomePage.class);
		
		sp=PageFactory.initElements(driver, SignoutPage.class);
		
		driver.manage().window().maximize();
	}

	@BeforeClass
	public void launchURL() {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		System.out.println(driver.getCurrentUrl());

	}

	@BeforeMethod
	public void getTitle() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Test(priority = 0)
	public void loginToOrangeHRM() {
		
		lpm.enterUsername();
		lpm.enterPassword("admin123");
		lpm.clickLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.getTitle());

	}
	
	@Test(priority = 1)
	public void clickPaulsam() {
		
		hp.clickPaulsam();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@Test(priority = 2)
	public void clickLogout() {
		
		sp.clickLogout();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.getTitle());
	}
	
	@AfterSuite
	public void closeBrowser() {
		
		driver.quit();
	}

}
