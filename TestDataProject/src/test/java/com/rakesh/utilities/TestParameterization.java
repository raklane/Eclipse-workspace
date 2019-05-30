package com.rakesh.utilities;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {
	
	@Test(dataProvider="getData")
	public void displayData(Hashtable<String, String> table) {
		
		System.out.println(table.get("Runmode") + "--" + table.get("firstname") + "--" + table.get("lastname") + "--" + table.get("postcode"));
		
	}

	@DataProvider
	public Object[][] getData() {
		ExcelReader excel = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\BankManagerSuite.xlsx");

		int rows = excel.getRowCount(Constants.DATA_SHEET);

		System.out.println("Number of rows in data sheet: " + rows);

		String testName = "AddCustomerTest";

		// Find the test case start row

		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum < rows; testCaseRowNum++) {

			String testCaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);
			if (testCaseName.equalsIgnoreCase(testName))
				break;

		}

		System.out.println("Test case starts from row num: " + testCaseRowNum);

		// Find total rows in the test case

		int dataStartRowNum = testCaseRowNum + 2;
		int testRows = 0;

		while (!excel.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum + testRows).equals("")) {
			testRows++;
		}

		System.out.println("Total rows in test case: " + testRows);

		// Find total cols in the test case

		int colEndColNum = 0;

		while (!excel.getCellData(Constants.DATA_SHEET, colEndColNum, testCaseRowNum + 2).equals("")) {
			colEndColNum++;
		}

		System.out.println("Total cols in test case: " + colEndColNum);

		// Store all data in the test case
		Object[][] data = new Object[testRows][1];

		for (int i = dataStartRowNum; i < dataStartRowNum + testRows; i++) {

			Hashtable<String, String> table = new Hashtable<String, String>();

			for (int j = 0; j < colEndColNum; j++) {
				
				String dataKey = excel.getCellData(Constants.DATA_SHEET, j, testCaseRowNum + 1);
				String dataValue = excel.getCellData(Constants.DATA_SHEET, j, i);

				table.put(dataKey, dataValue);
			}
			
			data[i-dataStartRowNum][0] = table;
		}
		
		return data;
	}

}
