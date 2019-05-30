package com.rakesh.utilities;

public class TestUtil {

		public static boolean isSuiteRunnable(String suite, ExcelReader excel) {
			
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
			
			for(int i=2; i<rows; i++) {
				
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

}
