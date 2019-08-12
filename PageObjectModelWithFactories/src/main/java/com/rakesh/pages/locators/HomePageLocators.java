package com.rakesh.pages.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePageLocators {
	
	@FindBy(css = "#tab-flight-tab-hp")
	public WebElement flights;
	@FindBys({
		@FindBy(css="#gcw-flights-form-hp-flight"),
		@FindBy(css = "#flight-origin-hp-flight")
	})
	public WebElement origin;
	@FindBy(css = "#flight-destination-hp-flight")
	public WebElement destination;
	@FindBy(css = "#flight-departing-hp-flight")
	public WebElement departing;
	@FindBy(css = "#flight-returning-hp-flight")
	public WebElement returning;
	@FindBy(css = ".cols-nested.ab25184-submit  button")
	public WebElement search;
	@FindBy(css="li[class^='tab']")
	public List<WebElement> hometabs;
	

}
