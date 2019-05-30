package parallelTest;

import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestBrowsers {
	
	@Parameters({"browser"})
	@Test
	public void displayBrowsers(String b) throws InterruptedException {
		Date d = new Date();
		System.out.println(b + "--" + d);
		Thread.sleep(2000);
	}
	
}
