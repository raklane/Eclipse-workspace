package com.rakesh.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.rakesh.pages.HomePage;
import com.rakesh.pages.LoginPage;
import com.rakesh.pages.ZohoAppPage;

public class roughTest {
	
	public static void main(String args[]) {
		
				
		HomePage homePage = new HomePage();
		homePage.goToLogin();
		
		LoginPage loginPage = new LoginPage();
		loginPage.doLogin("rakesh.xyzz@gmail.com", "selenium@123");
		
		ZohoAppPage zohoAppPage = new ZohoAppPage();
		zohoAppPage.goToCRM();
		
	}
	
}
