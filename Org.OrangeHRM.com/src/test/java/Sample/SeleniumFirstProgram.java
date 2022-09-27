package Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumFirstProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\himaj\\Downloads\\18thJuly2022_Selenium\\chromedriver_win32 (1)\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://testautomationpractice.blogspot.com/");
		
		Actions act=new Actions(driver);
				
		WebElement wikipedia=driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));		
				
		act.contextClick(wikipedia).build().perform();
		
		act.clickAndHold(wikipedia).build().perform();
		
		driver.close();
	}

}
