package testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTest extends BaseTest{
	
	@Test
	public void skipTest() {
		if(true) {
			throw new SkipException("Skipping the test case" + this.getClass().getName());
		}
	}

}
