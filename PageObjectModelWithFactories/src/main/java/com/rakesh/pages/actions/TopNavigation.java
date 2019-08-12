package com.rakesh.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.rakesh.base.Page;
import com.rakesh.pages.locators.TopNavigationLocators;

public class TopNavigation {
	
	public TopNavigationLocators topMenu;
	
	public TopNavigation(WebDriver driver) {
		
		 this.topMenu = new TopNavigationLocators();
		 AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		 PageFactory.initElements(factory, this.topMenu);
		
	}
	
	public SignInPage goToSignIn() {
		Page.click(topMenu.accountMenu);
		Page.click(topMenu.signIn);
		return new SignInPage();
	}
	
	public void goToCreateAccount() {
		Page.click(topMenu.accountMenu);
		Page.click(topMenu.createAccount);
	}
	
	public void goToMyList() {
		Page.click(topMenu.myList);
	}
	
	public void goToSupport() {
		Page.click(topMenu.support);
	}
	
	public void goToFlights() {
		Page.click(topMenu.flights);
	}

}
