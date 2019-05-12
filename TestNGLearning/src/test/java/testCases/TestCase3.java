package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 {
	
	@Test(groups="smoke")
	public void doRegistration() {
		System.out.println("Executing registration");
		Assert.fail("Registration failed");
	}
	
	@Test(dependsOnMethods="doRegistration", groups="smoke")
	public void doLogin() {
		System.out.println("Executing login");
	}
	
	@Test(dependsOnMethods= {"doRegistration","doLogin",}, alwaysRun=true, groups="bvt")
	public void thirdTest() {
		System.out.println("Executing third test");
	}
	
}
