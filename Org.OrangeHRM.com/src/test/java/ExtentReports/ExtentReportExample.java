package ExtentReports;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Methods.LoginPageMethods;
import Pages.ForgotYourPasswordPage;
import Pages.HomePage;
import Pages.SignoutPage;

public class ExtentReportExample {

	public WebDriver driver;

	LoginPageMethods lpm;

	HomePage hp;

	SignoutPage sp;

	public static ExtentTest test;

	public ExtentReports report;

	@BeforeSuite
	public void startTest() {

		report = new ExtentReports(System.getProperty("user.dir") + "\\Saag.html");
		test = report.startTest("OrangeHRM");

	}

	@BeforeClass
	public void launchBrowser() {

		System.out.println("In before Suite");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Downloads\\18thJuly2022_Selenium\\chromedriver_win32 (1)\\chromedriver.exe");

		driver = new ChromeDriver();

		lpm = new LoginPageMethods(driver);

		hp = PageFactory.initElements(driver, HomePage.class);

		sp = PageFactory.initElements(driver, SignoutPage.class);

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		System.out.println(driver.getTitle());
	}

	@BeforeMethod
	public void getTitle() {

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void loginToOrangeHRM() {

		lpm.enterUsername();
		lpm.enterPassword("admin123");
		lpm.clickLogin();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("OrangeHRM")) {			
			test.log(LogStatus.PASS, "Title is same");
			
		}else {
			
			test.log(LogStatus.FAIL, "Title is not same");

		}
		

	}

	@Test(priority = 1)
	public void clickPaulsam() {

		hp.clickPaulsam();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test(priority = 2)
	public void clickLogout() {

		sp.clickLogout();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		String expected="SAAG";
		String actual=driver.getTitle();
		if(actual.equalsIgnoreCase(expected)) {			
			test.log(LogStatus.PASS, "Title is same : " +actual);
			
		}else {
			
			test.log(LogStatus.FAIL, "Title is not same" + expected + " and " + actual);

		}
	}
	@AfterClass
	public void endTest() {
		
		report.endTest(test);
		report.flush();
	}

	@AfterSuite
	public void closeBrowser() {

		driver.quit();
	}

}
