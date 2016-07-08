/**
 * com.mtaf is a group of Selenium accelerators
 * mtaf means - microstrategy test automation framework
 */
package com.mtaf.accelerators;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mtaf.utilities.Reporter;
import com.thoughtworks.selenium.SeleniumException;

/**
 * ActionEngine is a wrapper class of Selenium actions
 */
public class ActionEngine extends TestEngine {

	public static WebDriverWait wait;

	static String bool = configProps.getProperty("OnSuccessReports");

	static boolean b = true; // /Boolean.parseBoolean(bool);

	// #############################################################################
	// Function Name : click
	// Description : Function to click a button or link
	// Input Parameters :identifyBy, locator
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void click(String identifyBy, String locator)
			throws Throwable {
		try {

			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {
					driver.findElement(By.xpath(locator)).click();
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {
					driver.findElement(By.id(locator)).click();
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {
					driver.findElement(By.name(locator)).click();
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {
					driver.findElement(By.cssSelector(locator)).click();
				}
			} else if (identifyBy.equalsIgnoreCase("className")) {
				if (isElementPresent("className", locator)) {
					driver.findElement(By.className(locator)).click();
				}
			} else if (identifyBy.equalsIgnoreCase("linkText")) {
				if (isElementPresent("linkText", locator)) {
					driver.findElement(By.linkText(locator)).click();
				}
			} else if (identifyBy.equalsIgnoreCase("partialLinkText")) {
				if (isElementPresent("partialLinkText", locator)) {
					driver.findElement(By.partialLinkText(locator)).click();
				}
			}
		} catch (Exception e) {
			Reporter.failureReport("Click Exception Info :",
					"Unable to click the element with locator : " + locator);
		}
	}
	// #############################################################################
	// Function Name : isElementPresent
	// Description : Function to validate the existence of an element
	// Input Parameters :identifier, locator
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static boolean isElementPresent(String identifyBy, String locator)
			throws Throwable {
		boolean isPresent = false;
		try {
			int timeout = 3;

			if (identifyBy.equalsIgnoreCase("xpath")) {
				try {
					int x = 0;
					do {
						if (driver.findElement(By.xpath(locator)).isDisplayed()) {
							highlight(driver.findElement(By.xpath(locator)));
							isPresent = true;

						} else {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {
					Reporter.failureReport("Element Identification Exception Info :",
							"Unable to identify the element with locator :" + locator);
					return isPresent;

				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				try {
					int x = 0;
					do {
						if (driver.findElement(By.id(locator)).isDisplayed()) {
							highlight(driver.findElement(By.id(locator)));
							isPresent = true;

						} else {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {
					Reporter.failureReport("Element Identification Exception Info :",
							"Unable to identify the element with locator :" + locator);
					return isPresent;

				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				try {
					int x = 0;
					do {
						if (driver.findElement(By.name(locator)).isDisplayed()) {
							highlight(driver.findElement(By.name(locator)));
							isPresent = true;

						} else {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {
					Reporter.failureReport("Element Identification Exception Info :",
							"Unable to identify the element with locator :" + locator);
					return isPresent;

				}
			} else if (identifyBy.equalsIgnoreCase("linkText")) {
				try {
					int x = 0;
					do {
						if (driver.findElement(By.linkText(locator))
								.isDisplayed()) {
							highlight(driver.findElement(By.linkText(locator)));
							isPresent = true;

						} else {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {
					Reporter.failureReport("Element Identification Exception Info :",
							"Unable to identify the element with locator :" + locator);
					return isPresent;

				}
			} else if (identifyBy.equalsIgnoreCase("partialLinkText")) {
				try {
					int x = 0;
					do {
						if (driver.findElement(By.partialLinkText(locator))
								.isDisplayed()) {
							highlight(driver.findElement(By
									.partialLinkText(locator)));
							isPresent = true;

						} else {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {
					Reporter.failureReport("Element Identification Exception Info :",
							"Unable to identify the element with locator :" + locator);
					return isPresent;

				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				try {
					int x = 0;
					do {
						if (driver.findElement(By.cssSelector(locator))
								.isDisplayed()) {
							highlight(driver.findElement(By
									.cssSelector(locator)));
							isPresent = true;

						} else {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {
					Reporter.failureReport("Element Identification Exception Info :",
							"Unable to identify the element with locator :" + locator);
					return isPresent;

				}
			} else if (identifyBy.equalsIgnoreCase("className")) {
				try {
					int x = 0;
					do {
						if (driver.findElement(By.className(locator))
								.isDisplayed()) {
							highlight(driver.findElement(By.className(locator)));
							isPresent = true;

						} else {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {
					Reporter.failureReport("Element Identification Exception Info :",
							"Unable to identify the element with locator :" + locator);
					return isPresent;

				}
			}
			return isPresent;
		} catch (Exception e) {
			Reporter.failureReport("Element Identification Exception Info :",
					"Unable to identify the element with locator :" + locator);
			return isPresent;
		}

	}
	// #############################################################################
	// Function Name : verifyElementPresent
	// Description : Function to validate the absence of an element
	// Input Parameters :identifier, locator
	// Return Value : None
	// Author : Archana Munukuntla
	// ############################################################################# 
	public static boolean verifyElementPresent(String identifyBy, String locator)
	    {

	        Boolean isPresent = false;
	        try
	        {

	            if (identifyBy.equalsIgnoreCase("xpath"))
	            {
	                if (driver.findElement(By.xpath(locator)).isDisplayed())
	                {
	                    isPresent = true;                   
	                    
	                }
	            }
	            else if (identifyBy.equalsIgnoreCase("id"))
	            {
	                if (driver.findElement(By.id(locator)).isDisplayed())
	                {
	                    isPresent = true;                   
	                    
	                }
	            }

	            else if (identifyBy.equalsIgnoreCase("name"))
	            {
	                if (driver.findElement(By.name(locator)).isDisplayed())
	                {
	                    isPresent = true;                   
	                    
	                }
	            }
	            else if (identifyBy.equalsIgnoreCase("className"))
	            {
	                if (driver.findElement(By.className(locator)).isDisplayed())
	                {
	                    isPresent = true;                   
	                    
	                }
	            }

	            else if (identifyBy.equalsIgnoreCase("linkText"))
	            {
	                if (driver.findElement(By.linkText(locator)).isDisplayed())
	                {
	                    isPresent = true;                   
	                    
	                }
	            }
	            else if (identifyBy.equalsIgnoreCase("partialLinkText"))
	            {
	                if (driver.findElement(By.partialLinkText(locator)).isDisplayed())
	                {
	                    isPresent = true;                   
	                    
	                }
	            }
	            else if (identifyBy.equalsIgnoreCase("cssSelector"))
	            {
	                if (driver.findElement(By.cssSelector(locator)).isDisplayed())
	                {
	                    isPresent = true;                   
	                    
	                }
	            }
                   

	            return isPresent;
	        }
	        catch (Exception e)
	        {
	           return false;
	        }
	    }
	// #############################################################################
	// Function Name : isAlertPresent
	// Description : Function to validate the existence of a popup
	// Input Parameters :None
	// Return Value : boolean
	// Author : Archana Munukuntla
	// #############################################################################
	public static boolean isAlertPresent() throws Throwable {

		try {
			driver.switchTo().alert();
			return true;

		}

		catch (NoAlertPresentException e) {

			return false;
		}

	}
	// #############################################################################
	// Function Name : acceptAlert
	// Description : Function to accept the popup
	// Input Parameters : None
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void acceptAlert() throws Throwable {
		try {

			if (isAlertPresent()) {
				driver.switchTo().alert().accept();
			}

		} catch (Exception e) {

			return;
		}

	}
	// #############################################################################
	// Function Name : dismissAlert
	// Description : Function to dismiss the popup
	// Input Parameters : None
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void dismissAlert() throws Throwable {
		try {

			if (isAlertPresent()) {
				driver.switchTo().alert().dismiss();
			}

		} catch (Exception e) {

			return;
		}

	}

	// #############################################################################
	// Function Name : type
	// Description : Function to type in text box
	// Input Parameters :identifier, locator and value to be typed
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void type(String identifyBy, String locator,
			String valuetoType) throws Throwable {
		try {

			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {
					driver.findElement(By.xpath(locator)).clear();
					driver.findElement(By.xpath(locator)).sendKeys(valuetoType);
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {
					driver.findElement(By.id(locator)).clear();
					driver.findElement(By.id(locator)).sendKeys(valuetoType);
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {
					driver.findElement(By.name(locator)).clear();
					driver.findElement(By.name(locator)).sendKeys(valuetoType);
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {

					driver.findElement(By.cssSelector(locator)).clear();
					driver.findElement(By.cssSelector(locator)).sendKeys(
							valuetoType);
				}
			} else if (identifyBy.equalsIgnoreCase("className")) {
				if (isElementPresent("className", locator)) {

					driver.findElement(By.className(locator)).clear();
					driver.findElement(By.className(locator)).sendKeys(
							valuetoType);
				}
			}
		} catch (Exception e) {
			Reporter.failureReport(
					"Entering Data Exception Info :",
					"Unable to enter the data "
							+ valuetoType
							+ " into an element with locator :"
							+ locator);
		}

	}

	// #############################################################################
	// Function Name : sendKeys
	// Description : Function to append the text in text box
	// Input Parameters :identifier, locator and value to be typed
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void sendKeys(String identifyBy, String locator,
			String valuetoType) throws Throwable {
		try {

			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {
					driver.findElement(By.xpath(locator)).sendKeys(valuetoType);
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {
					driver.findElement(By.id(locator)).sendKeys(valuetoType);
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {
					driver.findElement(By.name(locator)).sendKeys(valuetoType);
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {
					driver.findElement(By.cssSelector(locator)).sendKeys(
							valuetoType);
				}
			} else if (identifyBy.equalsIgnoreCase("className")) {
				if (isElementPresent("className", locator)) {
					driver.findElement(By.className(locator)).sendKeys(
							valuetoType);
				}
			}
		} catch (Exception e) {
			Reporter.failureReport(
					"Entering Data Exception Info :",
					"Unable to enter the data "
							+ valuetoType
							+ " into an element with locator :"
							+ locator);
		}

	}

	// #############################################################################
	// Function Name : mouseOver
	// Description : Function to move the mouse on to specific element
	// Input Parameters :identifier, locator
	// Return Value : boolean
	// Author : Archana Munukuntla
	// #############################################################################
	public static void mouseOver(String identifyBy, String locator)
			throws Throwable {
		try {

			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {

					Actions action = new Actions(driver);
					WebElement Element = driver.findElement(By.xpath(locator));
					action.moveToElement(Element).build().perform();
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {

					Actions action = new Actions(driver);
					WebElement Element = driver.findElement(By.id(locator));
					action.moveToElement(Element).build().perform();
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {

					Actions action = new Actions(driver);
					WebElement Element = driver.findElement(By.name(locator));
					action.moveToElement(Element).build().perform();
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {

					Actions action = new Actions(driver);
					WebElement Element = driver.findElement(By
							.cssSelector(locator));
					action.moveToElement(Element).build().perform();
				}
			}
		} catch (Exception e) {
			Reporter.failureReport("Mouse Over To Exception Info :",
					"Unable to moveover on element with locator :" + locator);
		}

	}

	// #############################################################################
	// Function Name : draggable
	// Description : Function to drag the mouse
	// Input Parameters :identifier, locator,XOffset,YOffset
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void draggable(String identifyBy, String locator, int x, int y)
			throws Throwable {
		try {
			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {

					Actions action = new Actions(driver);
					WebElement Element = driver.findElement(By.xpath(locator));
					action.dragAndDropBy(Element, x, y).build().perform();
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {

					Actions action = new Actions(driver);
					WebElement Element = driver.findElement(By.id(locator));
					action.dragAndDropBy(Element, x, y).build().perform();
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {

					Actions action = new Actions(driver);
					WebElement Element = driver.findElement(By.name(locator));
					action.dragAndDropBy(Element, x, y).build().perform();
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {

					Actions action = new Actions(driver);
					WebElement Element = driver.findElement(By
							.cssSelector(locator));
					action.dragAndDropBy(Element, x, y).build().perform();
				}
			} else if (identifyBy.equalsIgnoreCase("linkText")) {
				if (isElementPresent("linkText", locator)) {

					Actions action = new Actions(driver);
					WebElement Element = driver.findElement(By
							.linkText(locator));
					action.dragAndDropBy(Element, x, y).build().perform();
				}
			} else if (identifyBy.equalsIgnoreCase("className")) {
				if (isElementPresent("className", locator)) {

					Actions action = new Actions(driver);
					WebElement Element = driver.findElement(By
							.className(locator));
					action.dragAndDropBy(Element, x, y).build().perform();
				}
			}
		} catch (Exception e) {
			Reporter.failureReport("draggable Exception Info :",
					"Unable to drag the element with locator :" + locator);
		}

	}

	// #############################################################################
	// // Function Name : draganddrop
	// // Description : Function to drag the mouse
	// // Input Parameters : driver, identifier, locator
	// // Return Value : None
	// // Author : Archana Munukuntla
	// //
	// #############################################################################
	public static void draganddrop(String srcIdentify, String srcLocation,
			String dstIdentify, String dstLocation) throws Throwable {
		try {
			WebElement from = null;
			WebElement to = null;
			if (srcIdentify.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", srcLocation)) {

					from = driver.findElement(By.xpath(srcLocation));

				}
			} else if (srcIdentify.equalsIgnoreCase("id")) {
				if (isElementPresent("id", srcLocation)) {

					from = driver.findElement(By.id(srcLocation));
				}
			} else if (srcIdentify.equalsIgnoreCase("name")) {
				if (isElementPresent("name", srcLocation)) {

					from = driver.findElement(By.name(srcLocation));
				}
			} else if (srcIdentify.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", srcLocation)) {

					from = driver.findElement(By.id(srcLocation));
				}
			} else if (srcIdentify.equalsIgnoreCase("linkText")) {
				if (isElementPresent("linkText", srcLocation)) {

					from = driver.findElement(By.id(srcLocation));
				}
			} else if (srcIdentify.equalsIgnoreCase("className")) {
				if (isElementPresent("className", srcLocation)) {

					from = driver.findElement(By.id(srcLocation));
				}
			}
			if (dstIdentify.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", dstLocation)) {

					to = driver.findElement(By.xpath(dstLocation));

				}
			} else if (dstIdentify.equalsIgnoreCase("id")) {
				if (isElementPresent("id", dstLocation)) {

					to = driver.findElement(By.id(dstLocation));
				}
			} else if (dstIdentify.equalsIgnoreCase("name")) {
				if (isElementPresent("name", dstLocation)) {

					to = driver.findElement(By.name(dstLocation));
				}
			} else if (dstIdentify.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", dstLocation)) {

					to = driver.findElement(By.id(dstLocation));
				}
			} else if (dstIdentify.equalsIgnoreCase("linkText")) {
				if (isElementPresent("linkText", dstLocation)) {

					to = driver.findElement(By.id(dstLocation));
				}
			} else if (dstIdentify.equalsIgnoreCase("className")) {
				if (isElementPresent("className", dstLocation)) {

					to = driver.findElement(By.id(dstLocation));
				}
			}
			Actions action = new Actions(driver);
			action.dragAndDrop(from, to).build().perform();
		} catch (Exception e) {
			Reporter.failureReport("draggable Exception Info :",
					"Unable to drag the element with locator :" + srcLocation);
		}

	}
	// #############################################################################
	// Function Name :selectBySendkeys
	// Description : Function to Select a value from the DropDown using
	// visibleText
	// Input Parameters :identifier, locator,visibleText
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static boolean selectBySendkeys(String identifyBy, String locator,
			String visibleText) throws Throwable {
		boolean isPresent = false;
		try {

			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {

					Select s = new Select(driver.findElement(By.xpath(locator)));
					s.selectByVisibleText(visibleText);
					isPresent = true;
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {
					Select s = new Select(driver.findElement(By.id(locator)));
					s.selectByVisibleText(visibleText);
					isPresent = true;
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {
					Select s = new Select(driver.findElement(By.name(locator)));
					s.selectByVisibleText(visibleText);
					isPresent = true;

				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {
					Select s = new Select(driver.findElement(By
							.cssSelector(locator)));
					s.selectByVisibleText(visibleText);
					isPresent = true;
				}
			}
			return isPresent;
		} catch (Exception e) {
			Reporter.failureReport("Select Value Exception Info :",
					"Unable to select the value with text " + visibleText + " for element with locator " + locator);
			return isPresent;
		}
	}

	// #############################################################################
	// Function Name :selectByIndex
	// Description : Function to Select a value from the DropDown using index
	// Input Parameters :identifier, locator,index
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void selectByIndex(String identifyBy, String locator,
			int index) throws Throwable {
		try {
			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {

					Select s = new Select(driver.findElement(By.xpath(locator)));
					s.selectByIndex(index);

				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {
					Select s = new Select(driver.findElement(By.id(locator)));
					s.selectByIndex(index);

				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {
					Select s = new Select(driver.findElement(By.name(locator)));
					s.selectByIndex(index);

				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {
					Select s = new Select(driver.findElement(By
							.cssSelector(locator)));
					s.selectByIndex(index);

				}
			}
		} catch (Exception e) {
			Reporter.failureReport("Select Value Exception Info :",
					"Unable to select the value with index " + index + " for element with locator " + locator);

		}

	}

	// #############################################################################
	// Function Name :selectByValue
	// Description : Function to Select a value from the DropDown using value
	// Input Parameters :identifier, locator,value
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void selectByValue(String identifyBy, String locator,
			String value) throws Throwable {
		try {
			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {

					Select s = new Select(driver.findElement(By.xpath(locator)));
					s.selectByValue(value);

				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {
					Select s = new Select(driver.findElement(By.id(locator)));
					s.selectByValue(value);

				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {
					Select s = new Select(driver.findElement(By.name(locator)));
					s.selectByValue(value);

				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {
					Select s = new Select(driver.findElement(By
							.cssSelector(locator)));
					s.selectByValue(value);

				}
			}
		} catch (Exception e) {
			Reporter.failureReport("Select Value Exception Info :",
					"Unable to select the value with value " + value + " for element with locator " + locator);
			
		}

	}

	// #############################################################################
	// Function Name :switchWindowByTitle
	// Description : Function to switch to a specific window
	// Input Parameters : windowTitle
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void switchWindowByTitle(WebDriver driver, String windowTitle)
			throws Throwable {

		try {
			Set<String> windowList = driver.getWindowHandles();
			System.out.println(windowList.size());
			for (String window : windowList) {
				System.out.println(windowTitle);
				driver.switchTo().window(window);
				if (driver.getTitle().contains(windowTitle))
					System.out.println("iM HERE");
					break;
			}

		} catch (Exception e) {
			Reporter.failureReport("Window Selection Exception:",
					"Unable to select the window with the title :"
							+ windowTitle);

		}

	}

	// #############################################################################
	// Function Name :switchToLastWindow
	// Description : Function to switch to a specific window
	// Input Parameters : windowTitle
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void switchToLastWindow() throws Throwable {

		try {
			Set<String> windowList = driver.getWindowHandles();
			for (String window : windowList) {
				driver.switchTo().window(window);
			}

		} catch (Exception e) {
			Reporter.failureReport("Window Selection Exception:",
					"Unable to select the window");

		}
	}

	// #############################################################################
	// Function Name :getTableColumncount
	// Description : Function to Find the Number of columns in a table
	// Input Parameters : identifier,locator
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################

	public static int getTableColumncount(String identifyBy, String locator)
			throws Throwable {

		int count = 0;
		try {
			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {
					WebElement tr = driver.findElement(By.xpath(locator));
					List<WebElement> columns = tr
							.findElements(By.tagName("td"));
					count = columns.size();
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {
					WebElement tr = driver.findElement(By.id(locator));
					List<WebElement> columns = tr
							.findElements(By.tagName("td"));
					count = columns.size();
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {
					WebElement tr = driver.findElement(By.name(locator));
					List<WebElement> columns = tr
							.findElements(By.tagName("td"));
					count = columns.size();
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {
					WebElement tr = driver.findElement(By.cssSelector(locator));
					List<WebElement> columns = tr
							.findElements(By.tagName("td"));
					count = columns.size();
				}
			} else if (identifyBy.equalsIgnoreCase("className")) {
				if (isElementPresent("className", locator)) {
					WebElement tr = driver.findElement(By.className(locator));
					List<WebElement> columns = tr
							.findElements(By.tagName("td"));
					count = columns.size();
				}
			}

			return count;
		} catch (Exception e) {
			Reporter.failureReport("Table Column Count Exception Info :",
					"Unable to get the Column count in a table with locator :" + locator);
			return count;
		}
	}

	// #############################################################################
	// Function Name :getTableRowCount
	// Description : Function to Find the Number of rows in a table
	// Input Parameters : identifier,locator
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################

	public static int getTableRowCount(String identifyBy, String locator)
			throws Throwable {
		int count = 0;
		try {

			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {
					WebElement table = driver.findElement(By.xpath(locator));
					List<WebElement> rows = table
							.findElements(By.tagName("tr"));
					count = rows.size();
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {
					WebElement table = driver.findElement(By.id(locator));
					List<WebElement> rows = table
							.findElements(By.tagName("tr"));
					count = rows.size();
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {
					WebElement table = driver.findElement(By.name(locator));
					List<WebElement> rows = table
							.findElements(By.tagName("tr"));
					count = rows.size();
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {
					WebElement table = driver.findElement(By
							.cssSelector(locator));
					List<WebElement> rows = table
							.findElements(By.tagName("tr"));
					count = rows.size();
				}
			} else if (identifyBy.equalsIgnoreCase("className")) {
				if (isElementPresent("className", locator)) {
					WebElement table = driver
							.findElement(By.className(locator));
					List<WebElement> rows = table
							.findElements(By.tagName("tr"));
					count = rows.size();
				}
			}

			return count;
		} catch (Exception e) {
			Reporter.failureReport("Table Row Count Exception Info :",
					"Unable to get the Row count in a table with locator :" + locator);
			return count;
		}
	}

	// #############################################################################
	// Function Name : isChecked
	// Description : Function to Verify Weather The Checkbox is Selected or Not
	// Input Parameters :identifier, locator
	// Return Value : boolean
	// Author : Archana Munukuntla
	// #############################################################################
	public static boolean isChecked(String identifyBy, String locator)
			throws Throwable {
		try {
			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {

					if (driver.findElement(By.xpath(locator)).isSelected()) {
						return true;

					}
				}

			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {

					if (driver.findElement(By.id(locator)).isSelected()) {
						return true;

					}
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {

					if (driver.findElement(By.name(locator)).isSelected()) {
						return true;

					}
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {

					if (driver.findElement(By.cssSelector(locator))
							.isSelected()) {
						return true;

					}
				}
			}

			else if (identifyBy.equalsIgnoreCase("className")) {
				if (isElementPresent("className", locator)) {

					if (driver.findElement(By.className(locator)).isSelected()) {
						return true;

					}
				}
			}
			return false;
		} catch (Exception e) {
			
			return false;
		}

	}
	// #############################################################################
		// Function Name : selectRadiobutton
		// Description : Function to Select a radio button
		// Input Parameters :identifier, locator
		// Return Value : None
		// Author : Archana Munukuntla
		// #############################################################################
	
    public static void selectRadiobutton( String identifyBy,String locator)throws Throwable
            {
        try
        {
                if (identifyBy.equalsIgnoreCase("xpath"))
                {
                    if (isElementPresent( "xpath", locator))
                    {
                        //	System.out.println("clicking radio button" +locator);
                        driver.findElement(By.xpath(locator)).click();
                    }
                }
                else if (identifyBy.equalsIgnoreCase("id"))
                {
                    if (isElementPresent( "id", locator))
                    {
                        //	System.out.println("clicking radio button" +locator);
                        driver.findElement(By.id(locator)).click();
                    }
                }
                else if (identifyBy.equalsIgnoreCase("name"))
                {
                    if (isElementPresent("name", locator))
                    {
                        //	System.out.println("clicking radio button" +locator);
                        driver.findElement(By.name(locator)).click();
                    }
                }
                else if (identifyBy.equalsIgnoreCase("cssSelector"))
                {
                    if (isElementPresent( "cssSelector", locator))
                    {
                        //	System.out.println("clicking radio button" +locator);
                        driver.findElement(By.cssSelector(locator)).click();
                    }
                }
               
        }
        catch (Exception e)
        {
        	Reporter.failureReport("Radio button Exception Info :",
					"Unable to select the element with locator : " + locator);
        }

            }
 // #############################################################################
 		// Function Name : SelectCheckbox
 		// Description : Function to Select a radio button
 		// Input Parameters :identifier, locator,and check flag to be switched on/off
 		// Return Value : None
 		// Author : Archana Munukuntla
 		// #############################################################################
 	

    public static void SelectCheckbox(String identifyBy, String locator, String checkFlag)throws Throwable
            {

        try
        {

                if (identifyBy.equalsIgnoreCase("xpath"))
                {
                    if (isElementPresent("xpath", locator))
                    {
                        if ((checkFlag).equalsIgnoreCase("ON"))
                        {
                            if (!(driver.findElement(By.xpath(locator)).isSelected()))
                            {
                                driver.findElement(By.xpath(locator)).click();
                            }
                        }
                        else if ((checkFlag).equalsIgnoreCase("OFF"))
                        {
                            if ((driver.findElement(By.xpath(locator)).isSelected()))
                                driver.findElement(By.xpath(locator)).click();
                        }
                    }
                }
                else  if (identifyBy.equalsIgnoreCase("id"))
                {
                    if (isElementPresent("id", locator))
                    {
                        if ((checkFlag).equalsIgnoreCase("ON"))
                        {
                            if (!(driver.findElement(By.id(locator)).isSelected()))
                            {
                                driver.findElement(By.id(locator)).click();
                            }
                        }
                        else if ((checkFlag).equalsIgnoreCase("OFF"))
                        {
                            if ((driver.findElement(By.id(locator)).isSelected()))
                                driver.findElement(By.id(locator)).click();
                        }
                    }
                }
                else  if (identifyBy.equalsIgnoreCase("name"))
                {
                    if (isElementPresent("name", locator))
                    {
                        if ((checkFlag).equalsIgnoreCase("ON"))
                        {
                            if (!(driver.findElement(By.name(locator)).isSelected()))
                            {
                                driver.findElement(By.name(locator)).click();
                            }
                        }
                        else if ((checkFlag).equalsIgnoreCase("OFF"))
                        {
                            if ((driver.findElement(By.name(locator)).isSelected()))
                                driver.findElement(By.name(locator)).click();
                        }
                    }
                }
                else  if (identifyBy.equalsIgnoreCase("cssSelector"))
                {
                    if (isElementPresent("cssSelector", locator))
                    {
                        if ((checkFlag).equalsIgnoreCase("ON"))
                        {
                            if (!(driver.findElement(By.cssSelector(locator)).isSelected()))
                            {
                                driver.findElement(By.cssSelector(locator)).click();
                            }
                        }
                        else if ((checkFlag).equalsIgnoreCase("OFF"))
                        {
                            if ((driver.findElement(By.cssSelector(locator)).isSelected()))
                                driver.findElement(By.cssSelector(locator)).click();
                        }
                    }
                }
        }
        catch (Exception e)
        {
        	Reporter.failureReport("Checkbox Exception Info :",
					"Unable to check the element with locator :" + locator); 
        }
            }
	// #############################################################################
	// Function Name : getCssValue
	// Description : Function to get the Css value
	// Input Parameters :identifier, locator and cssattribute
	// Return Value : String
	// Author : Archana Munukuntla
	// #############################################################################

	public static String getCssValue(String identifyBy, String locator,
			String cssattribute) throws Throwable {
		String value = "";
		try {

			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {
					value = driver.findElement(By.xpath(locator)).getCssValue(
							cssattribute);
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {
					value = driver.findElement(By.id(locator)).getCssValue(
							cssattribute);
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {
					value = driver.findElement(By.name(locator)).getCssValue(
							cssattribute);
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {
					value = driver.findElement(By.cssSelector(locator))
							.getCssValue(cssattribute);
				}
			} else if (identifyBy.equalsIgnoreCase("className")) {
				if (isElementPresent("className", locator)) {
					value = driver.findElement(By.className(locator))
							.getCssValue(cssattribute);
				}
			} else if (identifyBy.equalsIgnoreCase("linkText")) {
				if (isElementPresent("linkText", locator)) {
					value = driver.findElement(By.linkText(locator))
							.getCssValue(cssattribute);
				}
			} else if (identifyBy.equalsIgnoreCase("partialLinkText")) {
				if (isElementPresent("partialLinkText", locator)) {
					value = driver.findElement(By.partialLinkText(locator))
							.getCssValue(cssattribute);
				}
			}
			return value;
		} catch (Exception e) {
			
			return value;
		}

	}

	// #############################################################################
	// Function Name : getText
	// Description : Function to get the text from the webpage
	// Input Parameters :identifier, locator
	// Return Value : String
	// Author : Archana Munukuntla
	// #############################################################################

	public static String getText(String identifyBy, String locator)
			throws Throwable {
		String value = "";

		try {

			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {
					value = driver.findElement(By.xpath(locator)).getText();
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {
					value = driver.findElement(By.id(locator)).getText();
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {
					value = driver.findElement(By.name(locator)).getText();
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {
					value = driver.findElement(By.cssSelector(locator))
							.getText();
				}
			} else if (identifyBy.equalsIgnoreCase("className")) {
				if (isElementPresent("className", locator)) {
					value = driver.findElement(By.className(locator)).getText();
				}
			} else if (identifyBy.equalsIgnoreCase("linkText")) {
				if (isElementPresent("linkText", locator)) {
					value = driver.findElement(By.linkText(locator)).getText();
				}
			} else if (identifyBy.equalsIgnoreCase("partialLinkText")) {
				if (isElementPresent("partialLinkText", locator)) {
					value = driver.findElement(By.partialLinkText(locator))
							.getText();
				}
			}
			return value;
		} catch (Exception e) {
			
			return value;
		}
	}

	// #############################################################################
		// Function Name : screenShot
		// Description : Function to take screenShot
		// Input Parameters :fileName
		// Return Value : None
		// Author : Archana Munukuntla
		// #############################################################################
	public static void screenShot(String fileName) {
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			// Now you can do whatever you need to do with it, for example copy
			// somewhere
			FileUtils.copyFile(scrFile, new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// #############################################################################
	// Function Name : mouseHoverByJavaScript
	// Description : Function to move the mouse on to specific element
	// Input Parameters :identifier, locator 
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void mouseHoverByJavaScript(String identifyBy, String locator)
			throws Throwable {

		try {
			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {
					WebElement mo = driver.findElement(By.xpath(locator));
					String javaScript = "var evObj = document.createEvent('MouseEvents');"
							+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
							+ "arguments[0].dispatchEvent(evObj);";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(javaScript, mo);
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {
					WebElement mo = driver.findElement(By.id(locator));
					String javaScript = "var evObj = document.createEvent('MouseEvents');"
							+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
							+ "arguments[0].dispatchEvent(evObj);";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(javaScript, mo);
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {
					WebElement mo = driver.findElement(By.name(locator));
					String javaScript = "var evObj = document.createEvent('MouseEvents');"
							+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
							+ "arguments[0].dispatchEvent(evObj);";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(javaScript, mo);
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {
					WebElement mo = driver.findElement(By.cssSelector(locator));
					String javaScript = "var evObj = document.createEvent('MouseEvents');"
							+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
							+ "arguments[0].dispatchEvent(evObj);";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(javaScript, mo);
				}
			} else if (identifyBy.equalsIgnoreCase("className")) {
				if (isElementPresent("className", locator)) {
					WebElement mo = driver.findElement(By.className(locator));
					String javaScript = "var evObj = document.createEvent('MouseEvents');"
							+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
							+ "arguments[0].dispatchEvent(evObj);";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(javaScript, mo);
				}
			} else if (identifyBy.equalsIgnoreCase("linkText")) {
				if (isElementPresent("linkText", locator)) {
					WebElement mo = driver.findElement(By.linkText(locator));
					String javaScript = "var evObj = document.createEvent('MouseEvents');"
							+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
							+ "arguments[0].dispatchEvent(evObj);";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(javaScript, mo);
				}
			} else if (identifyBy.equalsIgnoreCase("partialLinkText")) {
				if (isElementPresent("partialLinkText", locator)) {
					WebElement mo = driver.findElement(By
							.partialLinkText(locator));
					String javaScript = "var evObj = document.createEvent('MouseEvents');"
							+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
							+ "arguments[0].dispatchEvent(evObj);";
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript(javaScript, mo);
				}
			}

		}

		catch (Exception e) {
			Reporter.failureReport("Mouse Over To Exception Info :",
					"Unable to moveover on element with locator :" + locator);
		}
	}

	// #############################################################################
	// Function Name : JSClick
	// Description : Function to click a button or link
	// Input Parameters :identifier, locator 
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void JSClick(String identifyBy, String locator)
			throws Throwable {

		try {
			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {
					WebElement element = driver.findElement(By.xpath(locator));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {
					WebElement element = driver.findElement(By.id(locator));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {
					WebElement element = driver.findElement(By.name(locator));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {
					WebElement element = driver.findElement(By
							.cssSelector(locator));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
				}
			} else if (identifyBy.equalsIgnoreCase("className")) {
				if (isElementPresent("className", locator)) {
					WebElement element = driver.findElement(By
							.className(locator));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
				}
			} else if (identifyBy.equalsIgnoreCase("linkText")) {
				if (isElementPresent("linkText", locator)) {
					WebElement element = driver.findElement(By
							.linkText(locator));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
				}
			} else if (identifyBy.equalsIgnoreCase("partialLinkText")) {
				if (isElementPresent("partialLinkText", locator)) {
					WebElement element = driver.findElement(By
							.partialLinkText(locator));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
				}
			}

		}

		catch (Exception e) {
			Reporter.failureReport("Click Exception Info :",
					"Unable to click the element with locator :" + locator);

		}
	}

	// #############################################################################
	// Function Name : switchToFrameByIndex
	// Description : Function to switch to a frame
	// Input Parameters :index
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void switchToFrameByIndex(int index) throws Throwable {

		try {

			driver.switchTo().frame(index);
		}

		catch (Exception e) {
			Reporter.failureReport("Frame Selection Exception Info :",
					"Unable to select the frame with index :" + index);

		}
	}

	// #############################################################################
	// Function Name : switchToFrameByName
	// Description : Function to switch to a frame
	// Input Parameters :name
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void switchToFrameByName(String name) throws Throwable {

		try {

			driver.switchTo().frame(name);
		}

		catch (Exception e) {
			Reporter.failureReport("Frame Selection Exception Info :",
					"Unable to select the frame with name :" + name);

		}
	}

	// #############################################################################
	// Function Name : switchToDefaultFrame
	// Description : Function to switch to a default frame
	// Input Parameters :None
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void switchToDefaultFrame() throws Throwable {

		try {

			driver.switchTo().defaultContent();
		}

		catch (Exception e) {
			Reporter.failureReport("Frame Selection Exception Info :",
					"Unable to select the Defaultframe");

		}
	}

	// #############################################################################
	// Function Name : switchToFrameByLocator
	// Description : Function to switch to a frame
	// Input Parameters :identifier, locator
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void switchToFrameByLocator(String identifyBy, String locator)
			throws Throwable {

		try {
			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent("xpath", locator)) {
					driver.switchTo().frame(
							driver.findElement(By.xpath(locator)));
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent("id", locator)) {
					driver.switchTo().frame(driver.findElement(By.id(locator)));
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent("name", locator)) {
					driver.switchTo().frame(
							driver.findElement(By.name(locator)));
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent("cssSelector", locator)) {
					driver.switchTo().frame(
							driver.findElement(By.cssSelector(locator)));
				}
			} else if (identifyBy.equalsIgnoreCase("className")) {
				if (isElementPresent("className", locator)) {
					driver.switchTo().frame(
							driver.findElement(By.className(locator)));
				}
			}

		} catch (Exception e) {
			Reporter.failureReport("Frame Selection Exception Info :",
					"Unable to select the frame with locator :" + locator);

		}
	}

	// #############################################################################
	// Function Name : ImplicitWait
	// Description : Function to wait selenium until element present on web page
	// Input Parameters :None
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################

	public static void ImplicitWait() {

		driver.manage()
				.timeouts()
				.implicitlyWait(
						Long.parseLong(configProps.getProperty("ImplicitWait")),
						TimeUnit.SECONDS);
	}
	// #############################################################################
		// Function Name : ImplicitWait
		// Description : Function to wait selenium until element present on web page
		// Input Parameters :None
		// Return Value : None
		// Author : Archana Munukuntla
		// #############################################################################

		public static void waitForElementPresent(String identifyBy, String locator) throws Throwable {
			int timeout = Integer.parseInt(configProps.getProperty("ImplicitWait"));
			boolean isPresent = false;
			if (identifyBy.equalsIgnoreCase("xpath")) {
				try {
					int x = 0;
					do {
						if (driver.findElement(By.xpath(locator)).isDisplayed()) {
							isPresent = true;
						} else {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {

				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				try {
					int x = 0;
					do {
						if (driver.findElement(By.id(locator)).isDisplayed()) {
							isPresent = true;
						} else {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {

				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				try {
					int x = 0;
					do {
						if (driver.findElement(By.name(locator)).isDisplayed()) {
							isPresent = true;
						} else {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {

				}
			} else if (identifyBy.equalsIgnoreCase("linkText")) {
				try {
					int x = 0;
					do {
						if (driver.findElement(By.linkText(locator)).isDisplayed()) {
							isPresent = true;
						} else {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (SeleniumException e) {
					System.out.println("exception: " + e);

				}
			} else if (identifyBy.equalsIgnoreCase("partialLinkText")) {
				try {
					int x = 0;
					do {
						if (driver.findElement(By.partialLinkText(locator))
								.isDisplayed()) {
							isPresent = true;
						} else {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {

				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				try {
					int x = 0;
					do {
						if (driver.findElement(By.cssSelector(locator))
								.isDisplayed()) {
							isPresent = true;
						} else {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {

				}
			} else if (identifyBy.equalsIgnoreCase("className")) {
				try {
					int x = 0;
					do {
						if (driver.findElement(By.className(locator)).isDisplayed()) {
							isPresent = true;
						} else {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {

				}
			}
			
		}

	// #############################################################################
	// Function Name : highlight
	// Description : Function to highlight the element
	// Input Parameters : driver, identifier, locator
	// Return Value : None
	// Author : Archana Munukuntla
	// #############################################################################
	public static void highlight(WebElement element) {

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].style.border='2px solid yellow'", element);

		}
	}
	// #############################################################################
		// Function Name : switchToFrameByLocator
		// Description : Function to switch to a frame
		// Input Parameters :identifier, locator
		// Return Value : None
		// Author : Archana Munukuntla
		// #############################################################################
		public static void getListCount(String identifyBy, String locator)
				throws Throwable {
			int count=0;

			try {
				if (identifyBy.equalsIgnoreCase("xpath")) {
					if (isElementPresent("xpath", locator)) {
						count=driver.findElements(By.xpath(locator)).size();
					}
				} else if (identifyBy.equalsIgnoreCase("id")) {
					if (isElementPresent("id", locator)) {
						count=driver.findElements(By.id(locator)).size();
					}
				} else if (identifyBy.equalsIgnoreCase("name")) {
					if (isElementPresent("name", locator)) {
						count=driver.findElements(By.name(locator)).size();
					}
				} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
					if (isElementPresent("cssSelector", locator)) {
						count=driver.findElements(By.cssSelector(locator)).size();
					}
				} else if (identifyBy.equalsIgnoreCase("className")) {
					if (isElementPresent("className", locator)) {
						count=driver.findElements(By.className(locator)).size();
					}
				}
				else if (identifyBy.equalsIgnoreCase("tagName")) {
					if (isElementPresent("tagName", locator)) {
						count=driver.findElements(By.tagName(locator)).size();
					}
				}
				else if (identifyBy.equalsIgnoreCase("linkText")) {
					if (isElementPresent("linkText", locator)) {
						count=driver.findElements(By.linkText(locator)).size();
					}
				}
				else if (identifyBy.equalsIgnoreCase("partialLinkText")) {
					if (isElementPresent("partialLinkText", locator)) {
						count=driver.findElements(By.partialLinkText(locator)).size();
					}
				}

			} catch (Exception e) {
				Reporter.failureReport("Frame Selection Exception Info :",
						"Unable to select the frame with locator :" + locator);

			}
		}

}
