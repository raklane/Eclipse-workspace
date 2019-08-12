package com.rakesh.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class SignInPageLocators {
	
	@FindBy(css = "#gss-signin-email")
	public WebElement username;
	@FindBy(css = "#gss-signin-password")
	public WebElement password;
	@FindAll({
		@FindBy(css = "#gss-signin-submit"),
		@FindBy(css = "#gss-signin-submit111")
	})
	public WebElement signInButton;

}
