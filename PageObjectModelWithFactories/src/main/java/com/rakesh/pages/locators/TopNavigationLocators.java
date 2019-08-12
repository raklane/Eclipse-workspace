package com.rakesh.pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopNavigationLocators {
	
	@FindBy(css = "#header-account-menu")
	public WebElement accountMenu;
	@FindBy(css = "#account-signin")
	public WebElement signIn;
	@FindBy(css = "#account-register")
	public WebElement createAccount;
	@FindBy(css = "#header-history")
	public WebElement myList;
	@FindBy(css = "#header-support-menu")
	public WebElement support;
	@FindBy(css = "#primary-header-flight")
	public WebElement flights;
	@FindBy(css = "#primary-header-hotel")
	public WebElement hotels;
	@FindBy(css = "#primary-header-package")
	public WebElement bundleAndSave;
	
}
