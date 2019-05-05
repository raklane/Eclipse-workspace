package Package1;


import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddTest {

	@Test
	public void test() throws InterruptedException {
		JunitClass junit = new JunitClass();
		int result = junit.add(5, 4);
		assertEquals(9, result);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Rakesh\\Applications\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		Thread.sleep(10000);
		System.out.println("Browser launched");
		driver.close();
	}

}
