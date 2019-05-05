package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {
	
	@Test
	public void doRegistration() {
		System.out.println("Executing registration");
		Assert.fail("Registration failed");
	}
	
	@Test(dependsOnMethods="doRegistration")
	public void doLogin() {
		System.out.println("Executing login");
	}
	
	@Test(dependsOnMethods= {"doRegistration","doLogin",}, alwaysRun=true)
	public void thirdTest() {
		System.out.println("Executing third test");
	}
	
}
