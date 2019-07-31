package com.rakesh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.rakesh.base.Page;

public class LoginPage extends Page {
	
	
	public ZohoAppPage doLogin(String username, String password) {
		
		type("username_ID", username);
		type("password_ID", password);
		click("loginButton_ID");
		return new ZohoAppPage();
	}

}
