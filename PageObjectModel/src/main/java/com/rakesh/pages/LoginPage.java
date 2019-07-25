package com.rakesh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.rakesh.base.Page;

public class LoginPage extends Page {
	
	
	public void doLogin(String username, String password) {
		
		driver.findElement(By.cssSelector("#lid")).sendKeys(username);
		driver.findElement(By.cssSelector("#pwd")).sendKeys(password);
		
		driver.findElement(By.cssSelector("#signin_submit")).click();
		
	}

}
