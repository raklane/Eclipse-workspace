package parallelTest;

import java.util.Date;

import org.testng.annotations.Test;

public class InvocationTest extends TestBase {
	
	@Test(invocationCount=5, threadPoolSize=3)
	public void browserTest() throws InterruptedException {
		
		driver = getDriver("chrome");
		driver.get("http:://google.com");
		System.out.println(driver.getTitle());
		driver.quit();
		
	}

}
