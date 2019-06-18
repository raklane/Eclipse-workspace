package com.rakesh.suite.bankmanager.testcases;

import java.net.MalformedURLException;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rakesh.datadriven.testbase.TestBase;
import com.rakesh.utilities.Constants;
import com.rakesh.utilities.DataUtil;
import com.rakesh.utilities.ExcelReader;
import com.relevantcodes.extentreports.LogStatus;

public class OpenAccountTest extends TestBase {

	@Test(dataProviderClass=com.rakesh.utilities.DataProviders.class ,dataProvider="BankManagerDP")
	public void openAccountTest(Hashtable<String, String> data) throws MalformedURLException {
		
		super.setUp();
		test = extent.startTest("Open Account Test");
		setExTest(test);
		ExcelReader excel = new ExcelReader(Constants.SUITE_XL_PATH_1);
		DataUtil.checkExecution("BankManagerSuite", "OpenAccountTest", data.get("Runmode"), excel);
		openBrowser(data.get("browser"));
		setThWait(wait);
		navigate("testsiteurl");
		
		click("bmlBtn_CSS");
		click("openAccount_CSS");
		select("customer_CSS", data.get("customer"));
		select("currency_CSS", data.get("currency"));
		click("process_CSS");
		clickAlert();
		
		
		getExTest().log(LogStatus.INFO, "Add Customer test case executed");
	}
	
	@AfterMethod()
	public void tearDown() {
		
		if(test!=null) {
			extent.endTest(test);
			extent.flush();
		}
		
		getDriver().quit();
	}
	
}
