package com.mstr.businessLogic;

import java.awt.Robot;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.mtaf.accelerators.ActionEngine;
import com.mtaf.support.ExcelReader;
import com.mtaf.support.HtmlReportSupport;
import com.mtaf.utilities.Reporter;
import com.mstr.objects.ObjectRepository;

public class BusinessFunctions extends ActionEngine {
	public String username;
	public String password;
	public String URL;
		
	public  static void signIn(String username,String password) throws Throwable {		
		//boolean result = false;
		HtmlReportSupport.reportStep("Validating Sign In Functionality");
		
		type(ObjectRepository.getIdentify("username"),ObjectRepository.getLocation("username"), username);
		type(ObjectRepository.getIdentify("password"),ObjectRepository.getLocation("password"), password);
		
		click(ObjectRepository.getIdentify("loginButton"),ObjectRepository.getLocation("loginButton"));
		
		Thread.sleep(1000);
		if(isElementPresent(ObjectRepository.getIdentify("username"),ObjectRepository.getLocation("username"))){
			result = true;
    	}else{
			result = false;
	}
		//return result;
		System.out.println(result);
	}
	public  static void salesForcesignIn() throws Throwable {	
		//boolean result = false;
		HtmlReportSupport.reportStep("Validating Sign In Functionality");
		//System.out.println(xlsrdr.getData("SalesForceTC1", "URL"));
		//driver.get(xlsrdr.getData("SalesForceTC1", "URL"));

		type(ObjectRepository.getIdentify("SFusername"),ObjectRepository.getLocation("SFusername"), xlsrdr.getData("SalesForceTC1", "Username"));
		type(ObjectRepository.getIdentify("SFpassword"),ObjectRepository.getLocation("SFpassword"), xlsrdr.getData("SalesForceTC1", "Password"));
		
		//click(ObjectRepository.getIdentify("SFLogin"),ObjectRepository.getLocation("SFLogin"));
		
		/*Thread.sleep(1000);
		//if(isElementPresent(ObjectRepository.getIdentify("RoleType"),ObjectRepository.getLocation("RoleType"))){
			click(ObjectRepository.getIdentify("RoleType"),ObjectRepository.getLocation("RoleType"));			
    	}		
		if(isElementPresent(ObjectRepository.getIdentify("HomeNavig"),ObjectRepository.getLocation("HomeNavig"))){
			Reporter.SuccessReport("Login Functionality",xlsrdr.getData("SalesForceTC1", "Username")+"Logged successfully");
			result = true;
    	}else{
    		Reporter.failureReport("Login Functionality",xlsrdr.getData("SalesForceTC1", "Username")+"Logged is NOT successfull");
			result = false;
    	}*/
	}
	//*********************************************************************************************************
		//Method Name: MSTRwebLinks
		//Designed By: Archana Munukuntla
		//Designed Date:
		//Modified Date:
		//Last Modified By:
		//Description:
	//*********************************************************************************************************
	public static void MSTRwebLinks() throws Throwable
	{	
		if(isElementPresent(ObjectRepository.getIdentify("MSTREnterpriseSection"),ObjectRepository.getLocation("MSTREnterpriseSection"))){
			Reporter.SuccessReport("MicroStrategy Secure Enterprise","Welcome to MicroStrategy Secure Enterprise displayed successfully");
			List<WebElement> a= driver.findElements(By.tagName("button"));
			System.out.println(a.size());
			System.out.println("Links Displayed on MSTR Home page are");
			for(int i=0; i<a.size();i++){
				System.out.println(a.get(i).getText());	
			}
		result = true;
    	}else{
    		Reporter.failureReport("MicroStrategy Secure Enterprise","MicroStrategy Secure Enterprise is NOT displayed");
			result = false;
    	}

	}
	//*********************************************************************************************************
		//Method Name: MSTRwebLinks
		//Designed By: Archana Munukuntla
		//Designed Date:
		//Modified Date:
		//Last Modified By:
		//Description:
	//*********************************************************************************************************
	public static void MSTRweb() throws Throwable
		{			
			HtmlReportSupport.reportStep("Validating MSTR Web Navigation flow");
			if(isElementPresent(ObjectRepository.getIdentify("MSTRWeb"),ObjectRepository.getLocation("MSTRWeb"))){
				Reporter.SuccessReport("Verify MicroStrategy Web","MicroStrategy Web button is displayed successfully");
				click(ObjectRepository.getIdentify("MSTRWeb"),ObjectRepository.getLocation("MSTRWeb"));
				result = true;
	    	}else{
	    		Reporter.failureReport("Verify MicroStrategy Web","MicroStrategy Web button is NOT displayed");
				result = false;
	    	}
			
			if(isElementPresent(ObjectRepository.getIdentify("UserMessage"),ObjectRepository.getLocation("UserMessage"))){
				Reporter.SuccessReport("Verify QRCODE Block","QRCODE block is displayed successfully");
				String message = getText(ObjectRepository.getIdentify("UserMessage"),ObjectRepository.getLocation("UserMessage"));
				Reporter.SuccessReport("Verify Notification","Message "+message+" is displayed successfully");
				((JavascriptExecutor)driver).executeScript("scroll(0,400)");
				result = true;
	    	}else{
	    		Reporter.failureReport("Verify QRCODE Block","QRCODE block is NOT displayed");
				result = false;
	    	}
				click(ObjectRepository.getIdentify("UserCredentials"),ObjectRepository.getLocation("UserCredentials"));
				type(ObjectRepository.getIdentify("Username"),ObjectRepository.getLocation("Username"), "administrator");
				click(ObjectRepository.getIdentify("Login"),ObjectRepository.getLocation("Login"));
				click(ObjectRepository.getIdentify("Continue"),ObjectRepository.getLocation("Continue"));
				
				if(isElementPresent(ObjectRepository.getIdentify("Dashboards"),ObjectRepository.getLocation("Dashboards"))){
					Reporter.SuccessReport("Verify Tutorial Home Page","Tutorial Home Page is displayed successfully");
					click(ObjectRepository.getIdentify("Dashboards"),ObjectRepository.getLocation("Dashboards"));
					Thread.sleep(5000);
					//waitForElementPresent(ObjectRepository.getIdentify("Wirelessbill"),ObjectRepository.getLocation("Wirelessbill"));
					result = true;
		    	}else{
		    		Reporter.failureReport("Verify Tutorial Home Page","Tutorial Home Page is NOT displayed");
					result = false;
		    	}
				click(ObjectRepository.getIdentify("Wirelessbill"),ObjectRepository.getLocation("Wirelessbill"));
				Thread.sleep(5000);
				System.out.println("Hello1");
				//switchWindowByTitle(driver,"Wireless Bill");
				String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
				String subWindowHandler = null;
				Set<String> handles = driver.getWindowHandles(); // get all window handles
				Iterator<String> iterator = handles.iterator();
				while (iterator.hasNext()){
				    subWindowHandler = iterator.next();
				}
				driver.switchTo().window(subWindowHandler);
				Thread.sleep(5000);
				if(isElementPresent(ObjectRepository.getIdentify("WirelessSummary"),ObjectRepository.getLocation("WirelessSummary"))){
					Reporter.SuccessReport("Verify Wireless Bill Summary Page","Wireless Bill Summary Page is displayed successfully");
					driver.quit();
					//driver.switchTo().defaultContent();
					result = true;
		    	}else{
		    		Reporter.failureReport("Verify Wireless Bill Summary Page","Wireless Bill Summary Page is NOT displayed");
					result = false;
		    	}		
				
		}
	
	public  static void signOut() {
		HtmlReportSupport.reportStep("Closing/clearing the session");
		driver.quit();
	}
}
