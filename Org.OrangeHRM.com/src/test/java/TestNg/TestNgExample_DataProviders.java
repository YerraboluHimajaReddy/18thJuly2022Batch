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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgExample_DataProviders extends DriverExtensions {
		
	@BeforeSuite
	public void launchBrowser() {
		
		launchBrowser("edge");
	}
	
	@BeforeClass
	public void launchURL() {
		
		driver.get("https://www.facebook.com/");

		System.out.println(driver.getTitle());

	}
	
	@BeforeMethod
	public void getTitle() {
						
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	@DataProvider(name="FacebookData")
	public Object[][] data(){
		
		Object[][] dataValue=new Object[5][2];
		
		dataValue[0][0]="Yamini";
		dataValue[0][1]="YaminiTesting";
		
		dataValue[1][0]="Sridhar";
		dataValue[1][1]="SridharTesting";
		
		dataValue[2][0]="Ankur";
		dataValue[2][1]="AnkurTesting";
		
		dataValue[3][0]="Satish";
		dataValue[3][1]="SatishTesting";
		
		dataValue[4][0]="Ramya";
		dataValue[4][1]="RamyaTesting";		
		
		return dataValue;
			
	}
	
	@Test(dataProvider = "FacebookData")
	public void enterUsername(String userName, String password) {
		
		driver.findElement(By.id("email")).clear();
		
		driver.findElement(By.id("email")).sendKeys(userName);
		
		driver.findElement(By.id("pass")).clear();
		
		driver.findElement(By.id("pass")).sendKeys(password);
	}
	
	@AfterMethod
	public void waitForSometime() {
				
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}
	
	@AfterSuite
	public void closeBrowser() {
		
		driver.quit();
	}

}
