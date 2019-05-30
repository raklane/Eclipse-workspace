package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestFailure extends BaseTest{
	
	@Test
	public void doLogin() {
		
		System.out.println("Failing the test case as the login failed");
		Assert.fail("Failing the test case as the login failed");
		
	}

}
