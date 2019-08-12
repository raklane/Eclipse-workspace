package com.rakesh.pages.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.rakesh.base.Page;
import com.rakesh.pages.locators.SignInPageLocators;

public class SignInPage extends Page {
	
	SignInPageLocators signin;
	
	public SignInPage() {
		signin = new SignInPageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(factory, this.signin);
	}
	
	public void signIn(String username, String password) throws InterruptedException {
		Thread.sleep(5000);
		type(signin.username, username);
		type(signin.password,password);
		click(signin.signInButton);
	}

}
