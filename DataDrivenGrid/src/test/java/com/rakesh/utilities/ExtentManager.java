package com.rakesh.utilities;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		
		if(extent == null) {
			
			Date d = new Date();
			String fileName = d.toString().replaceAll(":", "_").replaceAll(" ", "_") + ".html";
			extent = new ExtentReports(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + fileName, true, DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\extentconfig\\ReportsConfig.xml"));
		}
		return extent;
	}
	
	
}
