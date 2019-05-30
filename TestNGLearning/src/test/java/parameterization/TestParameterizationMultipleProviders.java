package parameterization;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import testCases.DataParameterizationTestCase;

public class TestParameterizationMultipleProviders {
	
	@DataProvider(name="dp1")
	public Object[][] getData1(Method m){
		
		Object[][] data = null;
		
		if(m.getName() == "loginTest") {
			data = new Object[3][2];
			
			data[0][0] = "rakesh@gmail.com";
			data[0][1] = "fsdfds";
			
			data[1][0] = "sudesh@gmail.com";
			data[1][1] = "fsdfds";
			
			data[2][0] = "manish@gmail.com";
			data[2][1] = "fsdfds";
			
		}else if(m.getName() == "registrationTest") {
			data = new Object[3][3];
			
			data[0][0] = "rakesh@gmail.com";
			data[0][1] = "fsdfds";
			data[0][2] = "rakesh";
			
			data[1][0] = "sudesh@gmail.com";
			data[1][1] = "fsdfds";
			data[1][2] = "sudesh";
			
			data[2][0] = "manish@gmail.com";
			data[2][1] = "fsdfds";
			data[2][2] = "manish";
		}
		
		return data;
	}

}
