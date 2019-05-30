package parameterization;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestParameterizationXML {
	
	@Parameters({"browser", "env"})
	@Test
	public void testParameterizationTest(String browserr, String envv) {
		
		System.out.println(browserr + "--" + envv);
		
	}
	
}
