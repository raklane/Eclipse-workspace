package parameterization;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {
	
	@Test(dataProvider="getData")
	public void doLogin(String user, String password) {
		System.out.println("Username is: " +  user);
		System.out.println("Password is: " +  password);
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[3][2];
		
		data[0][0] = "rakesh@gmail.com";
		data[0][1] = "fsdfds";
		
		data[1][0] = "sudesh@gmail.com";
		data[1][1] = "fsdfds";
		
		data[2][0] = "manish@gmail.com";
		data[2][1] = "fsdfds";
		
		return data;
		
	}

}
