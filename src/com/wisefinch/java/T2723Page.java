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
public class T2723Page extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected T2723Page(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public T2723Page() {
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
	//@FindBy(xpath = "(//input[@class='slds-input slds-combobox__input'])[5]")
	//@FindBy(xpath = "//label[contains(text(),'Accounting Type')]")
	WebElement Account_type;

	@FindBy(xpath = "//span[@class='slds-checkbox slds-checkbox_standalone']/input[@name='AcctSeed__Accounting_Active__c']")
	WebElement Accounting_Active;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Save;
	
	@FindBy(xpath = "//img[@title='Cash Receipts']")
	WebElement Cash_Receipts_tab;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounts...')]")
	WebElement Customer;
	
	@FindBy(xpath = "//div[@class='slds-form']//force-record-layout-row[3]//force-record-layout-item//lightning-combobox//input[@class='slds-input slds-combobox__input']")
	WebElement Type;
	
	@FindBy(xpath = "//input[@name='AcctSeed__Amount__c']")
	WebElement Amount;
	
	@FindBy(xpath = "//input[@name='AcctSeed__Payment_Reference__c']")
	WebElement Reference;
	
	@FindBy(xpath = "//button[@title='Edit Cash Flow Category']")
	WebElement CF_edit;
	
	@FindBy(xpath = "(//button[@title='Clear Selection'])[6]")
	WebElement CF_removesel;
	
	@FindBy(xpath = "//input[@placeholder='Search GL Accounts...']")
	WebElement CF_selectnew;

	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();
	
	String account_name = null; String account_namefull = null;

	/***
	 * Test case Method Name : validateTestA 
	 * Functionality : validate T2723 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2723Page validateTestA(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
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
		
		return new T2723Page(browser);
		
	}
	
	/***
	 * Test case Method Name : validateTestB
	 * Functionality : validate T2723 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2723Page validateTestB(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
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

	return new T2723Page(browser);

	}
		
		/***
		 * Test case Method Name : validateTestC
		 * Functionality : validate T2723 Page
		 * Created By : Lakshman
		 * 
		 * @throws IOException
		 * @throws AWTException
		 * 
		 ***/
		public synchronized T2723Page validateTestC(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
			String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
			try {
				
				browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
				ReusableComponents.wait(5200);
				
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

										ReusableComponents.wait(5200);
										Save.click();
										ReusableComponents.wait(5200);
										ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "/" + testcasemethod, false);
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

		return new T2723Page(browser);
	
	}
		
		/***
		 * Test case Method Name : validateTestD
		 * Functionality : validate T2723 Page
		 * Created By : Lakshman
		 * 
		 * @throws IOException
		 * @throws AWTException
		 * 
		 ***/
		public synchronized T2723Page validateTestD(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
			String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
			try {
				
				browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
				ReusableComponents.wait(5200);
				
				System.out.println(account_namefull);
				String cramount = reusableComponents.getPropValues("amount");
				String crref = reusableComponents.getPropValues("ref");
				String receipt_type = reusableComponents.getPropValues("receipttype");
				
				
				ReusableComponents.wait(6200);
				
			    List<WebElement> f = browser.findElements(By.tagName("frame"));
			    int i = f.size();
			    System.out.println(i +" is the frame count");

				browser.switchTo().frame(0);
				
				ReusableComponents.wait(6200);
				
				if (ReusableComponents.isElementPresent(Cash_Receipts_tab)) {

					ReusableComponents.wait(3200);
					Cash_Receipts_tab.click();
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt tab is present", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.wait(5500);
					
					if (ReusableComponents.isElementPresent(New)) {

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Reciept page", browser, pathLoc+"/"+testcasemethod, true);
						ReusableComponents.wait(3200);
						New.click();
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt New button is present", browser, pathLoc + "/" + testcasemethod, false);
						ReusableComponents.wait(5500);
						
						if (ReusableComponents.isElementPresent(Customer)) {

							ReusableComponents.wait(3200);
							Customer.sendKeys(account_namefull);
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Customer searchbox is present", browser, pathLoc + "/" + testcasemethod, false);
							ReusableComponents.wait(8500);
							
							WebElement Customer_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+account_namefull+"']"));
							ReusableComponents.wait(5200);
							Customer_click.click();
							System.out.println("customer selected");
							ReusableComponents.wait(5200);
								
								if (ReusableComponents.isElementPresent(Type)) {

									ReusableComponents.wait(3200);
									Type.click();
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt Type selectbox is present", browser, pathLoc + "/" + testcasemethod, false);
									ReusableComponents.wait(8500);
									
									String Receipt_type = "//lightning-base-combobox-item/span[@class='slds-media__body']/span[contains(text(),'"+receipt_type+"')]";
								
									WebElement selecttype = browser.findElement(By.xpath(Receipt_type));
									ReusableComponents.wait(5500);
									selecttype.click();
									
									if (ReusableComponents.isElementPresent(Amount)) {

										ReusableComponents.wait(3200);
										Amount.sendKeys(cramount);
										ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt Amount field is present", browser, pathLoc + "/" + testcasemethod, false);
										ReusableComponents.wait(5500);
											
										if (ReusableComponents.isElementPresent(Reference)) {

											ReusableComponents.wait(3200);
											Reference.sendKeys(crref);
											ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt Reference field is present", browser, pathLoc + "/" + testcasemethod, false);
											ReusableComponents.wait(5500);
												
											if (ReusableComponents.isElementPresent(Save)) {

												ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Reciept creation page", browser, pathLoc+"/"+testcasemethod, true);
												ReusableComponents.wait(3200);
												Save.click();
												ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "/" + testcasemethod, false);
												ReusableComponents.wait(10500);
													
											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
											}
												
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt Reference field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
										}	
											
									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt Amount field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
									}
										
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt Type selectbox is NOT present", browser, pathLoc + "/" + testcasemethod, true);
							}
						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Customer searchbox is NOT present", browser, pathLoc + "/" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt New button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt tab is NOT present", browser, pathLoc + "/" + testcasemethod, true);
				}
				
				browser.switchTo().defaultContent();
				
			} catch (NoSuchElementException e) {
				
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
				
			}

		return new T2723Page(browser);
	
	}
		
		/***
		 * Test case Method Name : validateTestCashFlowError
		 * Functionality : validate T2723 Page
		 * Created By : Lakshman
		 * 
		 * @throws IOException
		 * @throws AWTException
		 * 
		 ***/
		public synchronized T2723Page validateTestCashFlowError(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
			String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
			try {
				
				
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
				ReusableComponents.wait(1200);
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
				ReusableComponents.wait(3200);
				
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Flow Catogory present", browser, pathLoc+"/"+testcasemethod, true);
				ReusableComponents.wait(5200);
				
				if (ReusableComponents.isElementPresent(CF_edit)) {
				
					ReusableComponents.wait(3200);
					CF_edit.click();
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Flow Category edit button is present", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.wait(3500);
					
					if (ReusableComponents.isElementPresent(CF_removesel)) {
						
						ReusableComponents.wait(3200);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash flow catogory selection remove button is present", browser, pathLoc + "/" + testcasemethod, false);
						CF_removesel.click();
						ReusableComponents.wait(5500);
						
						if (ReusableComponents.isElementPresent(CF_selectnew)) {
							
							ReusableComponents.wait(3200);
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash flow catogory feild is present", browser, pathLoc + "/" + testcasemethod, false);
							CF_selectnew.click();
							ReusableComponents.wait(5500);
							
							WebElement Cashflow_new = browser.findElement(By.xpath("//span[@title='Other Financing']"));
							ReusableComponents.wait(5200);
							Cashflow_new.click();
							System.out.println("cash flow type new selected");
							ReusableComponents.wait(5200);
							
							
							if (ReusableComponents.isElementPresent(Save)) {
								
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "/" + testcasemethod, false);
								ReusableComponents.wait(3200);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash flow catogory edit page", browser, pathLoc+"/"+testcasemethod, true);
								ReusableComponents.wait(3200);
								Save.click();
								ReusableComponents.wait(6500);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash flow catogory edit error message", browser, pathLoc+"/"+testcasemethod, true);
								ReusableComponents.wait(5200);
								
									
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
							}
								
						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash flow catogory field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
						}
							
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash flow catogory selection remove button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
					}
					
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Flow Category edit button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
				}
				
				
			} catch (NoSuchElementException e) {
				
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
				
			}

		return new T2723Page(browser);
	
	}
		/***
		 * Test case Method Name : callingmethod 
		 * Functionality : validate T2723 Page
		 * Created By : Lakshman
		 * 
		 * @throws IOException
		 * @throws AWTException
		 * 
		 ***/
		public synchronized T2723Page callingmethod(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
			String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
			try {
				
				validateTestA(threadID, tempList, pathLoc);
				validateTestB(threadID, tempList, pathLoc);
				validateTestC(threadID, tempList, pathLoc);
				validateTestD(threadID, tempList, pathLoc);
				validateTestCashFlowError(threadID, tempList, pathLoc);
				
				
			} catch (NoSuchElementException e) {
				
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			
			}
			
			return new T2723Page(browser);
			
		}

}
