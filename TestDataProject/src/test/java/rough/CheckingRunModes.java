package rough;

import com.rakesh.utilities.ExcelReader;
import com.rakesh.utilities.DataUtil;

public class CheckingRunModes {

	public static void main(String[] args) {
		
		//Checking run mode for the suite
		
		
		String suiteName = "CustomerSuite";
		
		boolean suiteRunMode = DataUtil.isSuiteRunnable(suiteName);
		
		System.out.println(suiteRunMode);
		
		
		//Checking run mode for the test case
		
		String testCaseName = "AddCustomerTest";
		
		boolean testRunMode = DataUtil.isTestRunnable(testCaseName, 
				new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\BankManagerSuite.xlsx"));
		
		System.out.println(testRunMode);

	}

}
