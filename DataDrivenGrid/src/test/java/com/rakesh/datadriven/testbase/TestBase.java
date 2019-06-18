package com.rakesh.datadriven.testbase;

import static org.testng.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.apache.log4j.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.rakesh.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	/*
	 * WebDriver logs properties excel db mail extent reports
	 * 
	 */

	public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
	public RemoteWebDriver driver = null;
	public Properties config = new Properties();
	public Properties OR = new Properties();
	public FileInputStream fis;
	public Logger log = Logger.getLogger("devpinoyLogger");
	public WebDriverWait wait;
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test = null;
	public String browser;

	public static ThreadLocal<WebDriverWait> thWait = new ThreadLocal<WebDriverWait>();
	public static ThreadLocal<ExtentTest> exTest = new ThreadLocal<ExtentTest>();

	public void setUp() {
		
		if (driver == null) {

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void setWebDriver(RemoteWebDriver driver) {

		dr.set(driver);

	}

	public WebDriver getDriver() {

		return dr.get();
	}

	public void setExTest(ExtentTest test) {
		exTest.set(test);
	}

	public ExtentTest getExTest() {
		return exTest.get();
	}

	public static WebDriverWait getThWait() {
		return thWait.get();
	}

	public static void setThWait(WebDriverWait wait) {
		thWait.set(wait);
	}
	
	public String getThreadLocal(Object thread) {
		String threadName = thread.toString();
		String text1 = threadName.split(" ")[threadName.split(" ").length-1];
		String text2 = text1.split("-")[text1.split("-").length-1];
		String text3 = text2.substring(0, text2.length()-1);
		return text3;
	}
	
	public void addLog(String msg) {
		log.debug(getThreadLocal(dr.get()) + " : Browser " + browser + " " + msg);
	}

	public void openBrowser(String browser) throws MalformedURLException {
		this.browser = browser;
		if (browser.equals("firefox")) {

			FirefoxOptions opt = new FirefoxOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), opt);

		} else if (browser.equals("chrome")) {

			ChromeOptions opt = new ChromeOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), opt);

		} else if (browser.equals("ie")) {

			InternetExplorerOptions opt = new InternetExplorerOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), opt);
		}

		setWebDriver(driver);
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.timeout")),
				TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		getExTest().log(LogStatus.INFO, "Browser opened successfully");

		wait = new WebDriverWait(getDriver(), 0);

	}

	public void navigate(String url) {
		getDriver().get(config.getProperty(url));
		getExTest().log(LogStatus.INFO, "Navigated to URL: " + config.getProperty(url));
	}

	@AfterSuite
	public void tearDown() {

		getDriver().quit();
	}

	public void click(String locator) {
		try {
			if (locator.endsWith("_CSS")) {
				getDriver().findElement(By.cssSelector(OR.getProperty(locator))).click();
			} else if (locator.endsWith("_XPATH")) {
				getDriver().findElement(By.xpath(OR.getProperty(locator))).click();
			} else if (locator.endsWith("_ID")) {
				getDriver().findElement(By.id(OR.getProperty(locator))).click();
			}
		} catch (Exception e) {
			reportFail(locator + "Not found");
		}

		getExTest().log(LogStatus.INFO, "Clicked on: " + locator);
		addLog("Clicked on object: " +  locator);
	}

	public void type(String locator, String value) {
		try {
			if (locator.endsWith("_CSS")) {
				getDriver().findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_XPATH")) {
				getDriver().findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_ID")) {
				getDriver().findElement(By.id(OR.getProperty(locator))).sendKeys(value);
			}
		} catch (Exception e) {
			reportFail(locator + "Not found");
		}

		getExTest().log(LogStatus.INFO, "Entered " + value + " in " + locator);
	}

	public boolean isElementPresent(By by) {

		try {

			getDriver().findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	public void select(String locator, String value) {

		WebElement dropdown = null;
		if (locator.endsWith("_CSS")) {
			dropdown = getDriver().findElement(By.cssSelector(OR.getProperty(locator)));
		} else if (locator.endsWith("_XPATH")) {
			dropdown = getDriver().findElement(By.xpath(OR.getProperty(locator)));
		} else if (locator.endsWith("_ID")) {
			dropdown = getDriver().findElement(By.id(OR.getProperty(locator)));
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		getExTest().log(LogStatus.INFO, "Selected value " + value + " in " + dropdown);
	}

	public void clickAlert() {

		Alert alert = getThWait().until(ExpectedConditions.alertIsPresent());
		String alertMsg = alert.getText();
		reportInfo("Alert text: " + alertMsg);
		alert.accept();
	}

	public void reportInfo(String msg) {
		getExTest().log(LogStatus.INFO, msg);
	}

	public void reportPass(String msg) {
		getExTest().log(LogStatus.PASS, msg);
	}

	public void reportFail(String msg) {
		getExTest().log(LogStatus.FAIL, msg);
		captureScreenshot();
		Assert.fail(msg);
	}

	public static String screenshotPath;
	public static String screenshotName;

	public void captureScreenshot() {

		Date d = new Date();
		screenshotName = d.toString().replaceAll(" ", "_").replaceAll(":", "_");
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile,
					new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getExTest().log(LogStatus.INFO, "Screenshot -> " + getExTest().addScreenCapture(
				System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}

}
