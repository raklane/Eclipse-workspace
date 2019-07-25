package com.rakesh.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.rakesh.base.Page;

public class HomePage extends Page {
	
	
	public void goToCustomers() {
		driver.findElement(By.xpath("//a[@class='zh-customers']")).click();
	}
	
	public void goToSupport() {
		driver.findElement(By.xpath("//a[@class='zh-support']")).click();	
	}
	
	public void goToLogin() {
		driver.findElement(By.xpath("//a[@class='zh-login']")).click();
	}
	
	public void goToSignUp() {
		driver.findElement(By.xpath("//a[@class='zh-signup']")).click();
	}
	
	public void validateFooters() {
		
		
	}

}
