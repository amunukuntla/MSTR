package com.mstr.scripts;

import org.testng.annotations.Test;

import com.mtaf.accelerators.TestEngine;
import com.mtaf.support.ExcelReader;
import com.mtaf.support.HtmlReportSupport;
import com.mtaf.utilities.Reporter;
import com.mstr.businessLogic.BusinessFunctions;

public class MSTR_WebLinks extends BusinessFunctions{
	
	/*
	 * Test method to Verify Primary Login Functionality
	 */

	@Test(groups={""})
	public static void MSTRlandingPage() throws Throwable {
		try{
		TestEngine.testDescription.put(HtmlReportSupport.tc_name,  "User should be able to nivate MSTR Landing Page");
		BusinessFunctions.MSTRwebLinks();		
		}catch(Exception e){				
			Reporter.failureReport("Validation of MSTR Landing Page", "Failed");
			e.printStackTrace();
			}		
		finally {
			//signOut();
		}
	}

}
