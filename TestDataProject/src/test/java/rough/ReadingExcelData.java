package rough;

import com.rakesh.utilities.Constants;
import com.rakesh.utilities.ExcelReader;

public class ReadingExcelData {

	public static void main(String[] args) {
		
		ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\BankManagerSuite.xlsx");
		
		int rows = excel.getRowCount(Constants.DATA_SHEET);
		
		System.out.println("Number of rows in data sheet: " +  rows);
		
		String testName = "AddCustomerTest";
		
		//Find the test case start row
		
		int testCaseRowNum = 1;
		
		for(testCaseRowNum=1; testCaseRowNum<rows; testCaseRowNum++) {
			
			String testCaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);
			if(testCaseName.equalsIgnoreCase(testName))
				break;
			
		}
		
		System.out.println("Test case starts from row num: " + testCaseRowNum);
		
		//Find total rows in the test case
		
		int dataStartRowNum = testCaseRowNum + 2;
		int testRows = 0;
		
		while(!excel.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum + testRows).equals("")) {			
			testRows++;
		}
		
		System.out.println("Total rows in test case: " + testRows);
		
		//Find total cols in the test case
		
		int colEndColNum = 0;

		while(!excel.getCellData(Constants.DATA_SHEET, colEndColNum, testCaseRowNum + 2).equals("")) {
			colEndColNum++;
		}
		
		System.out.println("Total cols in test case: " + colEndColNum);
		
		//Display all data in the test case
		for(int i= dataStartRowNum; i<dataStartRowNum+testRows; i++) {
			for(int j= 0; j<colEndColNum; j++) {
				System.out.println(excel.getCellData(Constants.DATA_SHEET, j, i));
			}
		}

	}

}
