package com.rakesh.suite.customer.testcases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rakesh.utilities.Constants;
import com.rakesh.utilities.DataUtil;
import com.rakesh.utilities.ExcelReader;

public class OpenAccountTest {
	
	@Test(dataProviderClass=com.rakesh.utilities.DataProviders.class, dataProvider = "CustomerDP")
	public void openAccountTest(Hashtable<String, String> data) {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE_XL_PATH_2);
		
		DataUtil.checkExecution("CustomerSuite", "OpenAccountTest", data.get("Runmode"), excel);
		
	}
	

}
