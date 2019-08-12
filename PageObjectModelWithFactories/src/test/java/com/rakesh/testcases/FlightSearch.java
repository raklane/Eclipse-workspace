package com.rakesh.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rakesh.base.Page;
import com.rakesh.errorcollectors.ErrorCollector;
import com.rakesh.pages.actions.Homepage;


public class FlightSearch {
	
	@BeforeTest
	public void setUP() {
		Page.initConfiguration();
	}
	
	@Test
	public void searchFlight() {
		
		
		Homepage homepage = new Homepage();
		ErrorCollector.verifyEquals(homepage.findTabCount(), 8);
		homepage.goToFlights().bookFlight("Delhi, India (DEL-Indira Gandhi Intl.)", "Mexico City, Distrito Federal, Mexico (MEX-Mexico City Intl.)"
				, "09/03/2019", "09/18/2019");
		
		
	}
	
	@AfterTest
	public void tearDown() {
		Page.quitBrowser();
	}

}
