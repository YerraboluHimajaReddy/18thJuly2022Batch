package TestNg;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

public class TestNgExample_DependsOnMethods2  extends DriverExtensions{
		
	@BeforeSuite
	public void launchBrowser() {
		
		System.out.println("In before Suite");
		
		launchBrowser("chrome");
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
	
	@Test
	public void enterUsername() {
		
		System.out.println("In Test method");

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	}
	
	@Test(dependsOnMethods = "enterUsername")
	public void enterPassword() {
		
		System.out.println("In Test method");

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	}
	
	@Test(dependsOnMethods  = "enterPassword")
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
