package testCases;

import org.testng.annotations.Test;

import parameterization.TestParameterizationMultipleProviders;

public class DataParameterizationTestCase {
	
	@Test(dataProviderClass=TestParameterizationMultipleProviders.class, dataProvider="dp1")
	public void loginTest(String username, String password) {
		System.out.println(username + "--" + password);
	}
	
	@Test(dataProviderClass=TestParameterizationMultipleProviders.class, dataProvider="dp1")
	public void registrationTest(String username, String password, String name) {
		System.out.println(username + "--" + password + "--" + name);
	}

}
