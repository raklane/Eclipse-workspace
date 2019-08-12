package com.rakesh.pages.actions;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rakesh.base.Page;
import com.rakesh.pages.locators.HomePageLocators;

public class Homepage extends Page {
	
	
	public HomePageLocators home;
	WebDriverWait wait = new WebDriverWait(driver, 30);
	
	public Homepage() {
		this.home = new HomePageLocators();
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this.home);
	}
	
	public Homepage goToFlights() {
		
		click(home.flights);
		return this;
		
	}
	
	public void goToHotels() {
		
	}
	
	public void goToBundleAndSave() {
		
	}
	
	public void bookFlight(String from, String to, String depDate, String retDate) {
		type(home.origin, from);
		type(home.destination, to);
		type(home.departing, depDate);
		type(home.returning, retDate);
		click(home.search);
		
	}
	
	public int findTabCount() {
		return home.hometabs.size();
	}

}
