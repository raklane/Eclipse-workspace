package com.rakesh.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.rakesh.base.Page;
import com.rakesh.pages.actions.SignInPage;

public class SignInTest {
	
	@BeforeTest
	public void setUP() {
		Page.initConfiguration();
	}
	
	
	@Test
	public void signInTest() throws InterruptedException {
		
		SignInPage signin = Page.topNav.goToSignIn();
		signin.signIn("rakesh.xyzz@gmail.com", "mainhoondon");
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void tearDown() {
		Page.quitBrowser();
	}

}
