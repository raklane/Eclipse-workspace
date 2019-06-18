package com.rakesh.utilities;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;

public class DataUtil {
	
		public static void checkExecution(String testSuiteName, String testCaseName, String runMode, ExcelReader excel) {
			
			if(!isSuiteRunnable(testSuiteName)) {
				throw new SkipException("Skipping the test case " + testCaseName + ", as the run mode for the test suite "
						+ testSuiteName +" is NO");
			}
			
			if(!isTestRunnable(testCaseName, excel)) {
				throw new SkipException("Skipping the test case " + testCaseName + ", as the run mode for the test case is NO");
			}
			
			if(runMode.equalsIgnoreCase(Constants.RUNMODE_N)) {
				throw new SkipException("Skipping the test case " + testCaseName + ", as the run mode for the data set is NO");
			}
			
		}

		public static boolean isSuiteRunnable(String suite) {
			
			ExcelReader excel = new ExcelReader(Constants.SUITE_XL_PATH);
			int rows = excel.getRowCount(Constants.SUITE_SHEET);
			for(int i=2; i<rows; i++) {
				String suiteName = excel.getCellData(Constants.SUITE_SHEET, 0, i);
				
				if(suiteName.equalsIgnoreCase(suite)) {
					
					String runMode = excel.getCellData(Constants.SUITE_SHEET, 1, i);
					if(runMode.equalsIgnoreCase(Constants.RUNMODE_Y))
						return true;
					else
						return false;
				}
			}
			
			return false;
		}
		
		
		public static boolean isTestRunnable(String test, ExcelReader excel) {
			
			int rows = excel.getRowCount(Constants.TEST_SHEET);
			
			for(int i=2; i<=rows; i++) {
				
				String testName = excel.getCellData(Constants.TEST_SHEET, Constants.TESTCASENAME_COL, i);
				
				if(testName.equalsIgnoreCase(test)) {

					String runMode = excel.getCellData(Constants.TEST_SHEET, Constants.TEST_RUNMODE_COL, i);
					
					if(runMode.equalsIgnoreCase(Constants.RUNMODE_Y))
						return true;
					else
						return false;
				}
				
			}
			
			return false;
		}
		
		
		@DataProvider
		public static Object[][] getData(String testName, ExcelReader excel) {

			int rows = excel.getRowCount(Constants.DATA_SHEET);

			System.out.println("Number of rows in data sheet: " + rows);

			

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
