package Listeners;

import org.testng.ITestListener;
import org.testng.annotations.Test;

public class ITestListener_Example extends TestNgListenerExample{
	
	@Test
	public void add() {
		
		onTestStart(null);
	}
	

}
