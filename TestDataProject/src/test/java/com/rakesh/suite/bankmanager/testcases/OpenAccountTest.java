package com.rakesh.suite.bankmanager.testcases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rakesh.utilities.Constants;
import com.rakesh.utilities.DataUtil;
import com.rakesh.utilities.ExcelReader;

public class OpenAccountTest {
	
	@Test(dataProviderClass=com.rakesh.utilities.DataProviders.class, dataProvider = "BankManagerDP")
	public void openAccountTest(Hashtable<String, String> data) {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE_XL_PATH_1);
		
		DataUtil.checkExecution("BankManagerSuite", "OpenAccountTest", data.get("Runmode"), excel);
		
	}
	

}
