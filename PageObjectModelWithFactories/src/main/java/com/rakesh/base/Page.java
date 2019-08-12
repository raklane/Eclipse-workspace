package com.rakesh.base;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rakesh.pages.actions.TopNavigation;
import com.rakesh.utilities.ExcelReader;
import com.rakesh.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Page {
	
	/*
	 * WebDriver
	 * ExcelReader
	 * logs
	 * WebDriverWait
	 * ExtentReports
	 */
	
	public static WebDriver driver;
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testData.xlsx");
	public static WebDriverWait wait;
	
	public static ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	
	public static TopNavigation topNav;
	
	public static void initConfiguration() {
		
		if(Constants.browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			log.debug("Launching firefox");
			
		}else if(Constants.browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-popup-blocking");
			driver = new ChromeDriver(options);
			log.debug("Launching Chrome");
			
		}else if(Constants.browser.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
			log.debug("Launching internet explorer");
		}
		
		driver.get(Constants.testsiteurl);
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Constants.implicitwait, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, Constants.implicitwait);
		
		topNav = new TopNavigation(driver);
		
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
	
	public static void click(WebElement element) {
		
		element.click();
		test.log(LogStatus.INFO, "Clicking on: " + element);
	}
	
	public static void type(WebElement element, String value) {
		
		element.sendKeys(value);
		test.log(LogStatus.INFO, "Entering in: " + element + ", Entered value: " + value);
	}
	
	

}
