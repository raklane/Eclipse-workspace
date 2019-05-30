package org.rakesh.GridTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridTest {
	
	public WebDriver driver = null;
	
	@Parameters("browser")
	@Test
	public void googleTest(String b) throws MalformedURLException, InterruptedException {
		
		System.out.println("Browser name: " + b);
		
		
		if(b.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		}else if(b.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		}else if(b.equals("ie")) {
			InternetExplorerOptions options = new InternetExplorerOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		}
		
		driver.get("http://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Hello google");
		Thread.sleep(1000);
		driver.quit();
		
	}

}
