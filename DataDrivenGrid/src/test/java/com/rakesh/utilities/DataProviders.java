package com.rakesh.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="BankManagerDP",parallel=true)
	public Object[][] getSuiteData1(Method m) {
		ExcelReader excel = new ExcelReader(Constants.SUITE_XL_PATH_1);
		String testName = m.getName();

		return DataUtil.getData(testName, excel);
	}
	
	
	@DataProvider(name="CustomerDP")
	public Object[][] getSuiteData2(Method m) {
		ExcelReader excel = new ExcelReader(Constants.SUITE_XL_PATH_2);
		String testName = m.getName();

		return DataUtil.getData(testName, excel);
	}

}
