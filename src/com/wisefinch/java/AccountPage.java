package com.wisefinch.java;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.time.format.*;
import java.time.LocalDateTime;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;

/**
 * Base class for all the pages.
 *
 */
public class AccountPage extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected AccountPage(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public AccountPage() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;

	@FindBy(xpath = "//img[@title='Accounts']")
	WebElement Accounts;

	@FindBy(xpath = "//div[@title='New']")
	WebElement New;

	@FindBy(xpath = "//force-record-layout-base-input//div[@class='slds-form-element__control slds-grow']/input[@name='Name']")
	WebElement Account_Name;

	@FindBy(xpath = "//force-record-layout-item[1]//lightning-combobox[1]//lightning-base-combobox[1]/div[1]/div[1]/input[1]")
	WebElement Account_type;

	@FindBy(xpath = "//span[@title='Customer and Vendor']")
	WebElement Account_type_select;

	@FindBy(xpath = "//span[@class='slds-checkbox slds-checkbox_standalone']/input[@name='AcctSeed__Accounting_Active__c']")
	WebElement Accounting_Active;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Save;
	
	@FindBy(xpath = "//span[@class='custom-truncate uiOutputText']")
	WebElement acc_name_finder;

	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();

	String billing_line_new = null, billing_line_pass =null;

	/***
	 * Test case Method Name : validateTestA 
	 * Functionality : validate Account Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized AccountPage validateTestA(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String username = null, pass_login = null;

			// browser.switchTo().defaultContent();

			username = reusableComponents.getPropValues("usernamesf");
			pass_login = reusableComponents.getPropValues("passwordsf");

			ReusableComponents.wait(2300);

			if (ReusableComponents.isElementPresent(Username_field)) {

				ReusableComponents.wait(1200);
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login username field is present", browser ,pathLoc+"/"+testcasemethod , false);

				Username_field.sendKeys(username);

				if (ReusableComponents.isElementPresent(Password_field)) {

					Password_field.sendKeys(pass_login);
					ReusableComponents.wait(1200);
					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login password field is present", browser ,pathLoc+"/"+testcasemethod , false);

					if (ReusableComponents.isElementPresent(Login_button)) {
						
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Login page", browser, pathLoc+"/"+testcasemethod, true);
						ReusableComponents.wait(1200);
						Login_button.click();
						ReusableComponents.wait(15500);
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login button is present", browser ,pathLoc+"/"+testcasemethod , false);

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login button is NOT present ", browser, pathLoc + "/" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login password field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login username field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
			}

		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		
			}
		
		return new AccountPage(browser);
		
	}
		
		/***
		 * Test case Method Name : validateTestB
		 * Functionality : validate Account Page
		 * Created By : Lakshman
		 * 
		 * @throws IOException
		 * @throws AWTException
		 * 
		 ***/
		public synchronized AccountPage validateTestB(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
			String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
			try {
				
				String account_name = null;
				String dt_pattern = "YYMMDDhhmmss";
				DateTimeFormatter cdt = DateTimeFormatter.ofPattern(dt_pattern);
				LocalDateTime now = LocalDateTime.now();
				account_name = reusableComponents.getPropValues("accountname");
				account_name = account_name + cdt.format(now);
				String acc_type = reusableComponents.getPropValues("actype");

				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"/"+testcasemethod, true);
				ReusableComponents.wait(3200);
				
				//JavascriptExecutor js = (JavascriptExecutor) browser;
				//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

				List<WebElement> f = browser.findElements(By.tagName("frame"));
				int i = f.size();
				System.out.println(i + "is the frame count");

				browser.switchTo().frame(0);

				ReusableComponents.wait(10200);
				
				if (ReusableComponents.isElementPresent(Accounts)) {

					ReusableComponents.wait(5200);
					Accounts.click();
					ReusableComponents.wait(5200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Accounts is present", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounts page", browser, pathLoc+"/"+testcasemethod, true);
					
					if (ReusableComponents.isElementPresent(New)) {

						ReusableComponents.wait(5200);
						New.click();
						ReusableComponents.wait(5200);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Account New button is present", browser, pathLoc + "/" + testcasemethod, false);
						
						if (ReusableComponents.isElementPresent(Account_Name)) {

							ReusableComponents.wait(5200);
							Account_Name.sendKeys(account_name);
							ReusableComponents.wait(5200);
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Account Name field is present", browser, pathLoc + "/" + testcasemethod, false);
							
							if (ReusableComponents.isElementPresent(Account_type)) {

								ReusableComponents.wait(5200);
								Account_type.click();
								ReusableComponents.wait(8200);
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Account Type selectbox is present", browser, pathLoc + "/" + testcasemethod, false);
								
								String Acc_type = "//span[@title='"+acc_type+"']";
								
								WebElement selecttype = browser.findElement(By.xpath(Acc_type));
								ReusableComponents.wait(5500);
								//selecttype.click();
								new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(selecttype)).click();
								ReusableComponents.wait(5500);
								
								if (ReusableComponents.isElementPresent(Accounting_Active)) {

									ReusableComponents.wait(5200);
									Accounting_Active.click();
									ReusableComponents.wait(5200);
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Account Active checkbox is present", browser, pathLoc + "/" + testcasemethod, false);
									
									if (ReusableComponents.isElementPresent(Save)) {

										ReusableComponents.wait(5200);
										Save.click();
										ReusableComponents.wait(5200);
										ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "/" + testcasemethod, false);
										
										if (ReusableComponents.isElementPresent(acc_name_finder)) {

											
											ReusableComponents.wait(5200);
											ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Account name is "+acc_name_finder.getText(), browser, pathLoc + "/" + testcasemethod, false);

											
										} 
										else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Unable to pick", browser, pathLoc + "/" + testcasemethod, true);
										}
										
									} 
									else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button not present", browser, pathLoc + "/" + testcasemethod, true);
									}
									
								} 
								else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account Active checkbox not present", browser, pathLoc + "/" + testcasemethod, true);
								}
								
							} 
							else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account Type selectbox not present", browser, pathLoc + "/" + testcasemethod, true);
							}
							
						} 
						else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account Name field  not present", browser, pathLoc + "/" + testcasemethod, true);
						}
						
					} 
					else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account New button not present", browser, pathLoc + "/" + testcasemethod, true);
					}
					
				} 
				else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account tab not present", browser, pathLoc + "/" + testcasemethod, true);
				}
				
				browser.switchTo().defaultContent();
				
			} catch (NoSuchElementException e) {
				
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
				
			}

		return new AccountPage(browser);
	
	}

}
