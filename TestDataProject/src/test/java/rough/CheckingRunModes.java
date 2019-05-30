package rough;

import com.rakesh.utilities.ExcelReader;
import com.rakesh.utilities.TestUtil;

public class CheckingRunModes {

	public static void main(String[] args) {
		
		//Checking run mode for the suite
		
		ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\suite.xlsx");
		
		String suiteName = "CustomerSuite";
		
		boolean suiteRunMode = TestUtil.isSuiteRunnable(suiteName, excel);
		
		System.out.println(suiteRunMode);
		
		
		//Checking run mode for the test case
		
		String testCaseName = "AddCustomerTest";
		
		boolean testRunMode = TestUtil.isTestRunnable(testCaseName, 
				new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\BankManagerSuite.xlsx"));
		
		System.out.println(testRunMode);

	}

}
