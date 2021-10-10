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
import org.sikuli.script.Mouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;

/**
 * Base class for all the pages.
 *
 */
public class T2725Page extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected T2725Page(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public T2725Page() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;
	
	@FindBy(xpath = "//img[@title='Accounting Settings']")
	WebElement Accounting_Settings;
	
	@FindBy(xpath = "//div/h3[contains(.,'Cash Flow Statement Settings')]")
	WebElement CFS_Setting;

	@FindBy(xpath = "//img[@title='Accounts']")
	WebElement Accounts;

	@FindBy(xpath = "//div[@title='New']")
	WebElement New;

	@FindBy(xpath = "//force-record-layout-base-input//div[@class='slds-form-element__control slds-grow']/input[@name='Name']")
	WebElement Account_Name;

	@FindBy(xpath = "//force-record-layout-item[1]//lightning-combobox[1]//lightning-base-combobox[1]/div[1]/div[1]/input[1]")
	WebElement Account_type;

	@FindBy(xpath = "//span[@class='slds-checkbox slds-checkbox_standalone']/input[@name='AcctSeed__Accounting_Active__c']")
	WebElement Accounting_Active;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Save;
	
	@FindBy(xpath = "//img[@title='Cash Disbursement Batches']")
	WebElement CDBatches;;
	
	@FindBy(xpath = "//input[contains(@name,'Name')]")
	WebElement CDB_name;
	
	@FindBy(xpath = "//input[@name='AcctSeed__Starting_Check_Number__c']")
	WebElement CDB_checkno;
	
	@FindBy(xpath = "//img[@title='Cash Disbursements']")
	WebElement Cash_disbursements;
	
	@FindBy(xpath = "//input[@placeholder='Search Cash Disbursement Batches...']")
	WebElement CDB_select;
	
	@FindBy(xpath = "//force-record-layout-row[1]//force-record-layout-item[2]//lightning-combobox[1]//input[1]")
	WebElement CD_type;
	
	@FindBy(xpath = "//input[@name='AcctSeed__Amount__c']")
	WebElement CD_amount;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounts...')]")
	WebElement CD_vendor;
	
	@FindBy(xpath = "(//input[@placeholder='Search GL Accounts...'])[1]")
	WebElement CD_Bankaccount;
	
	@FindBy(xpath = "//button[.='Post']")
	WebElement Post;
	
	@FindBy(xpath = "//div[@class='pbHeader']//input[@value='Post']")
	WebElement Post_final;
	
	@FindBy(xpath = "//span[.='Cash Flow Category']")
	WebElement CF_Category;
	
	@FindBy(xpath = "//span[.='Payments to suppliers']")
	WebElement Defaultsetting;

	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();
	
	String account_namefull = null; String CDB_Name = null;

	/***
	 * Test case Method Name : validateTestA 
	 * Functionality : validate Account Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2725Page validateTestA(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
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
		
		return new T2725Page(browser);
		
	}
	
	/***
	 * Test case Method Name : validateTestB
	 * Functionality : validate T2722 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2725Page validateTestB(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			ReusableComponents.wait(3200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"/"+testcasemethod, true);
			ReusableComponents.wait(3200);
			
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(3200);
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(3200);

			List<WebElement> f = browser.findElements(By.tagName("frame"));
			int i = f.size();
			System.out.println(i + "is the frame count");

			browser.switchTo().frame(0);
			
			if (ReusableComponents.isElementPresent(Accounting_Settings)) {

				ReusableComponents.wait(5200);
				Accounting_Settings.click();;
				ReusableComponents.wait(5200);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Accounting Settings tab is present", browser, pathLoc + "/" + testcasemethod, false);
				
				browser.switchTo().frame(0);
				WebElement element = browser.findElement(By.xpath("//div/h3[contains(.,'Cash Flow Statement Settings')]"));
				((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
				ReusableComponents.wait(3200);
			
				if (ReusableComponents.isElementPresent(CFS_Setting)) {
				
					ReusableComponents.wait(5200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Flow Statement Settings tab is present", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.wait(5200);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Flow Statement Settings section, this is a non editable section", browser, pathLoc+"/"+testcasemethod, true);
					
					
				} 
				else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Flow Statement Settings tab not present", browser, pathLoc + "/" + testcasemethod, true);
				}
				browser.switchTo().defaultContent();
			} 
			else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Accounting Settings tab not present", browser, pathLoc + "/" + testcasemethod, true);
			}
			
			browser.switchTo().defaultContent();
			
		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			
		}

	return new T2725Page(browser);

	}
		
		/***
		 * Test case Method Name : validateTestC
		 * Functionality : validate T2722 Page
		 * Created By : Lakshman
		 * 
		 * @throws IOException
		 * @throws AWTException
		 * 
		 ***/
		public synchronized T2725Page validateTestC(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
			String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
			try {
				
				browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
				ReusableComponents.wait(5200);
				
				String account_name = null; 
				String dt_pattern = "YYMMDDhhmmss";
				DateTimeFormatter cdt = DateTimeFormatter.ofPattern(dt_pattern);
				LocalDateTime now = LocalDateTime.now();
				account_name = reusableComponents.getPropValues("accountname");
				account_name = account_name + cdt.format(now);
				account_namefull = account_name;
				String acc_type = reusableComponents.getPropValues("actype");
				
				ReusableComponents.wait(3200);
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
				ReusableComponents.wait(3200);
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
				ReusableComponents.wait(3200);

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
							WebElement element = browser.findElement(By.xpath("//span[contains(text(),'Accounting Information')]"));
							((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
							
							if (ReusableComponents.isElementPresent(Account_type)) {

								ReusableComponents.wait(5200);
								Account_type.click();
								ReusableComponents.wait(5200);
								Account_type.click();
								ReusableComponents.wait(8200);
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Account Type selectbox is present", browser, pathLoc + "/" + testcasemethod, false);
								
								String Acc_type = "//span[@title='"+acc_type+"']";
								System.out.println(Acc_type);
								
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
										
										ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "/" + testcasemethod, false);
										ReusableComponents.wait(5200);
										Save.click();
										ReusableComponents.wait(5200);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Account created page", browser, pathLoc+"/"+testcasemethod, true);
										ReusableComponents.wait(5200);
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

		return new T2725Page(browser);
	
	}
		
		/***
		 * Test case Method Name : validateTestD
		 * Functionality : validate T2722 Page
		 * Created By : Lakshman
		 * 
		 * @throws IOException
		 * @throws AWTException
		 * 
		 ***/
		public synchronized T2725Page validateTestD(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
			String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
			try {
				
				browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
				ReusableComponents.wait(5200);
				
				String cdbname = reusableComponents.getPropValues("cdbname");
				String cdbcheckno = reusableComponents.getPropValues("cdbcheckno");
				CDB_Name = cdbname;
		
				ReusableComponents.wait(6200);
				
			    List<WebElement> f = browser.findElements(By.tagName("frame"));
			    int i = f.size();
			    System.out.println(i +" is the frame count");

				browser.switchTo().frame(0);
				
				ReusableComponents.wait(6200);
				
				if (ReusableComponents.isElementPresent(CDBatches)) {
					
					ReusableComponents.wait(5200);
					CDBatches.click();
					ReusableComponents.wait(5200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement Batches tab is present", browser, pathLoc + "/" + testcasemethod, false);
					
					if (ReusableComponents.isElementPresent(New)) {
						
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Disbursement Batches page", browser, pathLoc+"/"+testcasemethod, true);
						ReusableComponents.wait(5200);
						New.click();
						ReusableComponents.wait(5200);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement Batches New button is present", browser, pathLoc + "/" + testcasemethod, false);
						
						if (ReusableComponents.isElementPresent(CDB_name)) {
							
							ReusableComponents.wait(5200);
							CDB_name.sendKeys(cdbname);
							ReusableComponents.wait(5200);
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement Batches Name field is present", browser, pathLoc + "/" + testcasemethod, false);
							
							if (ReusableComponents.isElementPresent(CDB_checkno)) {
								
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement Batches Check no field is present", browser, pathLoc + "/" + testcasemethod, false);
								ReusableComponents.wait(5200);
								CDB_checkno.sendKeys(cdbcheckno);
								ReusableComponents.wait(5200);
								
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Disbursement creation page", browser, pathLoc+"/"+testcasemethod, true);	
								ReusableComponents.wait(5200);
							
							if (ReusableComponents.isElementPresent(Save)) {
								
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "/" + testcasemethod, false);
								Save.click();
								ReusableComponents.wait(5200);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Disbursement page", browser, pathLoc+"/"+testcasemethod, true);
								ReusableComponents.wait(5200);
								
								}
							else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is not present", browser, pathLoc + "/" +testcasemethod, true);
								}
							
							}
							else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement Batches Check no field is not present", browser, pathLoc + "/" +testcasemethod, true);
								}
							
							}
						else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement Batches Name field is not present", browser, pathLoc + "/" +testcasemethod, true);
							}
						
						}
					else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement Batches New button is not present", browser, pathLoc + "/" +testcasemethod, true);
						}
					
					}
				else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement Batches tab is not present", browser, pathLoc + "/" +testcasemethod, true);
					}
				
				browser.switchTo().defaultContent();
				
				} catch (NoSuchElementException e) {
				
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
				
			}

		return new T2725Page(browser);
	
	}
		
		/***
		 * Test case Method Name : validateTestD
		 * Functionality : validate T2722 Page
		 * Created By : Lakshman
		 * 
		 * @throws IOException
		 * @throws AWTException
		 * 
		 ***/
		public synchronized T2725Page validateTestE(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
			String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
			try {
				
				browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
				ReusableComponents.wait(5200);
				
				String CDtype = reusableComponents.getPropValues("cdtype");
				String CD_Amount = reusableComponents.getPropValues("amount");
				String CDBank = reusableComponents.getPropValues("cdbank");
				
		
				ReusableComponents.wait(6200);
				
			    List<WebElement> f = browser.findElements(By.tagName("frame"));
			    int i = f.size();
			    System.out.println(i +" is the frame count");

				browser.switchTo().frame(0);
				
				ReusableComponents.wait(6200);
				
				if (ReusableComponents.isElementPresent(Cash_disbursements)) {
					
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement tab is present", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.wait(3200);
					Cash_disbursements.click();
					ReusableComponents.wait(5200);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Disbursement page", browser, pathLoc+"/"+testcasemethod, true);
					ReusableComponents.wait(5200);
					
					if (ReusableComponents.isElementPresent(New)) {
						
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement New button is present", browser, pathLoc + "/" + testcasemethod, false);
						ReusableComponents.wait(3200);
						New.click();
						ReusableComponents.wait(5200);
						
						if (ReusableComponents.isElementPresent(CDB_select)) {
							
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement Batch searchbox is present", browser, pathLoc + "/" + testcasemethod, false);
							ReusableComponents.wait(3200);
							CDB_select.sendKeys(CDB_Name);
							ReusableComponents.wait(5200);
							
							WebElement CDB_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+CDB_Name+"']"));
							ReusableComponents.wait(5200);
							CDB_click.click();
							System.out.println("Cash disbursement batch selected");
							ReusableComponents.wait(5200);
							
							if (ReusableComponents.isElementPresent(CD_type)) {
								
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement Type selectbox is present", browser, pathLoc + "/" + testcasemethod, false);
								ReusableComponents.wait(3200);
								CD_type.click();
								ReusableComponents.wait(5200);
								
								WebElement CD_Type = browser.findElement(By.xpath("//span[@title='"+CDtype+"']"));
								ReusableComponents.wait(5200);
								CD_Type.click();
								System.out.println("Cash disbursement type selected");
								ReusableComponents.wait(5200);
								
								if (ReusableComponents.isElementPresent(CD_amount)) {
									
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement Amount field is present", browser, pathLoc + "/" + testcasemethod, false);
									ReusableComponents.wait(3200);
									CD_amount.sendKeys(CD_Amount);
									ReusableComponents.wait(5200);
									
									WebElement element = browser.findElement(By.xpath("//span[normalize-space()='Payee Information']"));
			                        ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
									
									if (ReusableComponents.isElementPresent(CD_vendor)) {
										
										ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement Vendor searchbox is present", browser, pathLoc + "/" + testcasemethod, false);
										ReusableComponents.wait(3200);
										CD_vendor.sendKeys(account_namefull);
										ReusableComponents.wait(5200);
										
										WebElement CD_Vendor = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+account_namefull+"']"));
										ReusableComponents.wait(5200);
										CD_Vendor.click();
										System.out.println("Cash disbursement vendor selected");
										ReusableComponents.wait(5200);
										
										WebElement elements = browser.findElement(By.xpath("//span[normalize-space()='Accounting Information']"));
				                        ((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", elements);
				                        
				                        if (ReusableComponents.isElementPresent(CD_Bankaccount)) {
											
											ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement Bank searchbox is present", browser, pathLoc + "/" + testcasemethod, false);
											ReusableComponents.wait(3200);
											CD_Bankaccount.sendKeys(CDBank);
											ReusableComponents.wait(5200);
											
											WebElement CD_Bank = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+CDBank+"']"));
											ReusableComponents.wait(5200);
											CD_Bank.click();
											System.out.println("Cash disbursement bank selected");
											ReusableComponents.wait(5200);
											
											if (ReusableComponents.isElementPresent(Save)) {
												
												ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement save button is present", browser, pathLoc + "/" + testcasemethod, false);
												ReusableComponents.wait(3200);
												Save.click();
												ReusableComponents.wait(8200);
												
												if (ReusableComponents.isElementPresent(Post)) {
													
													ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement Post button is present", browser, pathLoc + "/" + testcasemethod, false);
													ReusableComponents.wait(3200);
													Post.click();
													ReusableComponents.wait(5200);
													
													browser.switchTo().frame(0);
													
													if (ReusableComponents.isElementPresent(Post_final)) {
														
														ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement Post finalise button is present", browser, pathLoc + "/" + testcasemethod, false);
														ReusableComponents.wait(3200);
														Post_final.click();
														ReusableComponents.wait(5200);
													
													}
													else {
														ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement Post finalise button is not present", browser, pathLoc + "/" +testcasemethod, true);
													}
													
													browser.switchTo().defaultContent();
												
												}
												else {
													ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement Post button is not present", browser, pathLoc + "/" +testcasemethod, true);
												}
											
											}
											else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement save button is not present", browser, pathLoc + "/" +testcasemethod, true);
											}
					                        
										
										}
										else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement Bank searchbox is not present", browser, pathLoc + "/" +testcasemethod, true);
										}
									
									}
									else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement Vendor searchbox is not present", browser, pathLoc + "/" +testcasemethod, true);
									}
								
								}
								else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement  Amount field is not present", browser, pathLoc + "/" +testcasemethod, true);
								}
								
							}
							else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement Type selectbox is not present", browser, pathLoc + "/" +testcasemethod, true);
							}
							
						}
						else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement Batch searchbox is not present", browser, pathLoc + "/" +testcasemethod, true);
						}
						
					}
					else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement New button is not present", browser, pathLoc + "/" +testcasemethod, true);
					}
					
				}
				else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement tab is not present", browser, pathLoc + "/" +testcasemethod, true);
				}
				
				browser.switchTo().defaultContent();
				
				} catch (NoSuchElementException e) {
				
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
				
			}

		return new T2725Page(browser);
	
	}
		
		/***
		 * Test case Method Name : validateTestCashFlow
		 * Functionality : validate T2722 Page
		 * Created By : Lakshman
		 * 
		 * @throws IOException
		 * @throws AWTException
		 * 
		 ***/
		public synchronized T2725Page validateTestCashFlow(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
			String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
			try {
				
				
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
				ReusableComponents.wait(1200);
				
				if (ReusableComponents.isElementPresent(CF_Category)) {
				
					ReusableComponents.wait(3200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Flow Category field is present", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.wait(3500);
					
					if (ReusableComponents.isElementPresent(Defaultsetting)) {
						
						ReusableComponents.wait(3200);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Validation of Cash flow default setting is present", browser, pathLoc + "/" + testcasemethod, false);
						ReusableComponents.wait(3500);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Flow Catogory present", browser, pathLoc+"/"+testcasemethod, true);
						ReusableComponents.wait(5500);
							
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Validation of Cash flow default setting is NOT present", browser, pathLoc + "/" + testcasemethod, true);
					}
					
						
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Flow Category field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
				}
				
				
			} catch (NoSuchElementException e) {
				
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
				
			}

		return new T2725Page(browser);
	
	}
		/***
		 * Test case Method Name : validateTestA 
		 * Functionality : validate Account Page
		 * Created By : Lakshman
		 * 
		 * @throws IOException
		 * @throws AWTException
		 * 
		 ***/
		public synchronized T2725Page callingmethod(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
			String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
			try {
				
				validateTestA(threadID, tempList, pathLoc);
				validateTestB(threadID, tempList, pathLoc);
				validateTestC(threadID, tempList, pathLoc);
				validateTestD(threadID, tempList, pathLoc);
				validateTestE(threadID, tempList, pathLoc);
				validateTestCashFlow(threadID, tempList, pathLoc);
				
				
			} catch (NoSuchElementException e) {
				
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			
			}
			
			return new T2725Page(browser);
			
		}

}
