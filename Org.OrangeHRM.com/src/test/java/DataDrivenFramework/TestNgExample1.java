package DataDrivenFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNgExample1 {
	
	public WebDriver driver;
	
	public HSSFWorkbook workbook;
	
	public HSSFSheet sheet;
	
	public HSSFRow row;
	
	public HSSFCell column;
	
	@BeforeSuite
	public void verifyFile() throws IOException {
		
		File file=new File("C:\\Users\\himaj\\eclipse-workspace\\18thJuly2022Batch\\Org.OrangeHRM.com\\src\\test\\java\\Testdata\\LoginData.xls"); 
	
		FileInputStream fs=new FileInputStream(file);
		
		workbook=new HSSFWorkbook(fs);
		
		sheet=workbook.getSheet("LoginData");
				
		
	}
	@BeforeClass
	public void launchBrowser() {
				
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Downloads\\18thJuly2022_Selenium\\chromedriver_win32 (1)\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void launchURL() {
		
		System.out.println("In before Class");

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		System.out.println(driver.getTitle());

	}
	
	@BeforeMethod
	public void getTitle() {
		
		System.out.println("In before method");
				
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	@Test(priority = 1)
	public void enterUsername() {
		
		String username=sheet.getRow(1).getCell(0).toString();

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
	}
	
	@Test(priority = 2)
	public void enterPassword() {
		
		String password=sheet.getRow(1).getCell(1).toString();

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}
	
	@Test(priority = 3)
	public void clickLogin() {
		
		System.out.println("In Test method");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@AfterMethod
	public void waitForSometime() {
		
		System.out.println("In after method");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	@AfterSuite
	public void closeBrowser() {
		
		System.out.println("In After Suite");

		driver.quit();
	}

}
