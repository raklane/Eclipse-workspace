package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class TestCase2 {
	
	@Test(groups= {"functional", "smoke"})
	public void doVerification() {
		
		SoftAssert softAssert = new SoftAssert();
		
		System.out.println("first assert condition");
		softAssert.assertEquals(true, false);
		
		System.out.println("second assert condition");
		softAssert.assertTrue(false);
		
		System.out.println("third assert condition");
		softAssert.assertFalse(true);
		
		softAssert.assertAll();
	}
	
}
