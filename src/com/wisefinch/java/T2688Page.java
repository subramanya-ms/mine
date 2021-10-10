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
import org.apache.poi.util.SystemOutLogger;
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
public class T2688Page extends DriverScript {
	protected static WebDriver browser;

	static ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected T2688Page(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public T2688Page() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;
	
	@FindBy(xpath = ".//*[@class='slds-icon-waffle']")
	static WebElement SearchAppAndItemIcon;
	
	@FindBy(xpath = ".//*[@class='slds-size_medium']//*[@class='slds-input']")
	static WebElement SearchAppAndItemInputbox;

	@FindBy(xpath = "//input[@name='AcctSeed__Accounting_Period__c-search-input']")
	static WebElement searchTextBox_AccountPeriod;
	
	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	WebElement Home;
	
	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Accounting Periods')]")
	static WebElement SelectAccountingPeriods;
	
	@FindBy(xpath = "//input[@placeholder='Search apps and items...']")
	WebElement Input;
	
	@FindBy(xpath = ".//*[@class='slds-truncate']//*[contains(text(),'Accounting Periods')]")
	WebElement click_ap;
	
	@FindBy(xpath = "//button[.='Select List View']")
	WebElement listview;
	
	@FindBy(xpath = "//span[contains(.,'All')][contains(@class,'virtualAutocompleteOptionText')]")
	WebElement all_list;
	
	@FindBy(xpath = "//button[@name='Edit']")
	WebElement Edit;
	
	@FindBy(xpath = "//label[contains(text(),'Status')]")
	WebElement Status;
	
	@FindBy(xpath = "//slot[@slot='secondaryFields']//lightning-formatted-text[.='Closed']")
	WebElement Closed_Status;
	
	@FindBy(xpath = "//slot[@slot='secondaryFields']//lightning-formatted-text[.='Open']")
	WebElement Open_Status;

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
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounting Periods...')]")
	WebElement Period_input;
	
	@FindBy(xpath = "//*[@class='panel-heading' and contains(text(),'General Ledger Setup')]//following::img[@alt='GL Accounts']")
	WebElement GL_Account;
	
	@FindBy(xpath = "//input[contains(@name,'AcctSeed__GL_Account__c-search-input')]")
	WebElement GL_AccountSearch;
	
	@FindBy(xpath = "//button[@name='Clone']")
	WebElement Clone;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']/input[@name='Name']")
	WebElement GL_Account_name;
	
	@FindBy(xpath = "//img[@title='Cash Receipts']")
	WebElement Cash_Receipts_tab;
	
	@FindBy(xpath = "//input[contains(@name,'AcctSeed__GL_Account__c-search-input')]")
	WebElement CR_Search;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounts...')]")
	WebElement Customer_CR;
	
	@FindBy(xpath = "//div[@class='slds-form']//force-record-layout-row[3]//force-record-layout-item//lightning-combobox//input[@class='slds-input slds-combobox__input']")
	WebElement Type_CR;
	
	@FindBy(xpath = "//input[@name='AcctSeed__Amount__c']")
	WebElement Amount_CR;
	
	@FindBy(xpath = "//input[@name='AcctSeed__Payment_Reference__c']")
	WebElement Reference_CR;
	
	@FindBy(xpath = "(//force-record-layout-row[1]//force-record-layout-item[1]//lightning-grouped-combobox//input)[1]")
	WebElement Bank_CR;
	
	@FindBy(xpath = "//slot[@slot='primaryField']//lightning-formatted-text")
	WebElement CR_getname;

	@FindBy(xpath = "//img[@title=' Financial Reports']")
	WebElement Reports;

	@FindBy(xpath = "//button[contains(text(),'Select Standard Report')]")
	WebElement Select_report_type;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search Ledgers...')]")
	WebElement Ledger;
	
	@FindBy(xpath = "//button[contains(@title,'Clear Selection')]/lightning-primitive-icon")
	WebElement Ledger_close;
	
	@FindBy(xpath = "//c-lookup[contains(.,'*Accounting Period')]//input[@role='textbox']")
	WebElement Accounting_period;
	
	@FindBy(xpath = "(.//*[@title='Remove selected option'])[1]")
	WebElement deselect_period;
	
	@FindBy(xpath = "//label[contains(.,'Suppress Zero Amount Rows')]/span[@class='slds-checkbox_faux']")
	WebElement S_Z_A_R;
	
	@FindBy(xpath = "//button[@title='Run Report']")
	WebElement Run_report;

	@FindBy(xpath = "(//tr[1]//div[@class='slds-truncate']//a)[1]")
	WebElement Gen_report;
	
	
	
	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();
	
	int Nextyear, previousYearClose; String per_stat, account_name = null, CRname, CRname2, Period1, Period2, Period3;

	/***
	 * Test case Method Name : validateTestA 
	 * Functionality : validate T2688 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2688Page validateTestA(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String username = null, pass_login = null;

			// browser.switchTo().defaultContent();

			username = reusableComponents.getPropValues("usernamesf");
			pass_login = reusableComponents.getPropValues("passwordsf");

			ReusableComponents.wait(2300);

			if (ReusableComponents.isElementPresent(Username_field)) {

				ReusableComponents.wait(1200);
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login username field is present", browser ,pathLoc+"\\"+testcasemethod , false);
				Username_field.sendKeys(username);

				if (ReusableComponents.isElementPresent(Password_field)) {

					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login password field is present", browser ,pathLoc+"\\"+testcasemethod , false);
					Password_field.sendKeys(pass_login);
					ReusableComponents.wait(1200);

					if (ReusableComponents.isElementPresent(Login_button)) {
						
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Login page", browser, pathLoc+"\\"+testcasemethod, true);
						ReusableComponents.wait(1200);
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login button is present", browser ,pathLoc+"\\"+testcasemethod , false);
						ReusableComponents.wait(1200);
						Login_button.click();
						ReusableComponents.wait(15500);

						ReusableComponents.wait(5200);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"\\"+testcasemethod, true);
						ReusableComponents.wait(3200);
							
						
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login button is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login password field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login username field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
			}


		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Login" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
		
		return new T2688Page(browser);
		
	}
		
	/***
	 * Test case Method Name : Currentperiodopen
	 * Functionality : validate T2688 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2688Page Currentperiodopen(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
		
			String acc_period = Period1;
			per_stat = "Open";
			String last_period = null;
			String strArray[] = acc_period.split("-");
	        String yearValue = strArray[0];
	        int year =  Integer. parseInt(strArray[0]);
	        int month =  Integer. parseInt(strArray[1]);
	         
	        Nextyear = year+1;
	        
	        Nextyearopen(threadID, tempList, pathLoc);
	        
			Home.click();
			ReusableComponents.wait(5500);
			Input.sendKeys("Accounting Periods");
			ReusableComponents.wait(5500);
			click_ap.click();
			ReusableComponents.wait(5500);
			listview.click();
			ReusableComponents.wait(5500);
			all_list.click();
			ReusableComponents.wait(5500);
			
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting period page", browser, pathLoc+"\\"+testcasemethod, true);
			
			int j=12; String acct_period=null;
			
			for(j=12;j>=month;j--) {
					
				String monthValue = null;
				
                if(j<=9) {
                    monthValue="0"+j;
                }else {
                	monthValue=""+j+"";
                }
               
                acct_period = yearValue+"-"+monthValue;
               
                //you can use the above value , form dynamic xpath , open the accounting period. check the status and close.
          
				
				last_period = acct_period;
				String Period = "//a[@title='"+acct_period+"']";
				
				try {
					ReusableComponents.wait(5500);
					System.out.println("main try");
					
					try {
						browser.findElement(By.xpath("//div[@data-aura-class='uiScroller']")).sendKeys(Keys.PAGE_DOWN);
						ReusableComponents.wait(5500);
						WebElement element = browser.findElement(By.xpath("//a[@title='"+acct_period+"']"));
						((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
						ReusableComponents.wait(5500);
					} catch (Exception e) {
						
						System.out.println(acct_period+" period not present");
					}
							
					if(ReusableComponents.isElementPresent(browser.findElement(By.xpath(Period)))) {
					
					System.out.println("period to be opened "+acct_period);
					System.out.println("period to be opened xpath "+Period);
					
					ReusableComponents.wait(5500);
					WebElement selectpe = browser.findElement(By.xpath(Period));

					ReusableComponents.wait(8500);
					selectpe.click();
					System.out.println("Accounting period tabledata present");
					ReusableComponents.wait(5500);
					
					try {
						if(ReusableComponents.isElementPresent(Closed_Status)) {
							
							System.out.println("closed to be opened");
						
						try {
							
							if (ReusableComponents.isElementPresent(Edit)) {
								
								ReusableComponents.wait(10200);
								Edit.click();
								ReusableComponents.wait(5500);
								ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Edit button is present", browser ,pathLoc+"\\"+testcasemethod , false);

								if (ReusableComponents.isElementPresent(Status)) {
									
									ReusableComponents.wait(3200);
									Status.click();
									ReusableComponents.wait(5500);
									ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Status selectbox is present", browser ,pathLoc+"\\"+testcasemethod , false);

									String P_stat = "//span[@title='"+per_stat+"']";
									
									WebElement selecttype = browser.findElement(By.xpath(P_stat));
									ReusableComponents.wait(5500);
									selecttype.click();
									System.out.println("Accounting period status present");
									ReusableComponents.wait(5500);
									
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Editing Accounting period", browser, pathLoc+"\\"+testcasemethod, true);
									
									if (ReusableComponents.isElementPresent(Save)) {
										
										ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Save button is present", browser ,pathLoc+"\\"+testcasemethod , false);
										ReusableComponents.wait(7200);
										Save.click();
										ReusableComponents.wait(16500);
										

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
									}
									
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Status selectbox is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
								}
								
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Edit button is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
							}
							
						} catch (Exception c) {
							
							System.out.println("period not edited first "+c.getMessage());
						}
						
						System.out.println("opening period in progress");
						ReusableComponents.wait(66500);
						
						}else {
							
							System.out.println("period is open or archived");
							
							}
					} catch (Exception eq) {
						// TODO Auto-generated catch block
						eq.printStackTrace();
					}
					
					} else {
						
						if(ReusableComponents.isElementNotPresent(browser.findElement(By.xpath(Period)))) {
							
						System.out.println(Period+" period is not present");
						ReusableComponents.wait(5500);
						browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");
					
					}else {
						System.out.println(Period+" period loop else error");
					}
					}
				} catch (Exception h) {
		
					System.out.println("element exception : "+h.getMessage());
	
				}
	
			ReusableComponents.wait(5500);
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");
			
				}				
			
		System.out.println(last_period+" is the ending period of year "+acc_period);
			

		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Currentperiod open" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

	return new T2688Page(browser);

}
	
	/***
	 * Test case Method Name : Nextyearopen
	 * Functionality : validate T2688 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2688Page Nextyearopen(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
		
			per_stat = "Open";
			
	        ReusableComponents.wait(5200);
			
			Home.click();
			ReusableComponents.wait(5500);
			Input.sendKeys("Accounting Periods");
			ReusableComponents.wait(5500);
			click_ap.click();
			ReusableComponents.wait(5500);
			listview.click();
			ReusableComponents.wait(5500);
			all_list.click();
			ReusableComponents.wait(5500);
			
			int j=12; String acct_period=null;
			
			for(j=12;j>=1;j--) {
					
				String monthValue = null;
				
                if(j<=9) {
                    monthValue="0"+j;
                }else {
                	monthValue=""+j+"";
                }
               
                acct_period = Nextyear+"-"+monthValue;
               
                //you can use the above value , form dynamic xpath , open the accounting period. check the status and close.
          
				String Period = "//a[@title='"+acct_period+"']";
				
				try {
					ReusableComponents.wait(5500);
					System.out.println("main try");
					
					try {
						browser.findElement(By.xpath("//div[@data-aura-class='uiScroller']")).sendKeys(Keys.PAGE_DOWN);
						ReusableComponents.wait(5500);
						WebElement element = browser.findElement(By.xpath("//a[@title='"+acct_period+"']"));
						((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
						ReusableComponents.wait(5500);
					} catch (Exception e) {
						
						System.out.println(acct_period+" period not present");
					}
							
					if(ReusableComponents.isElementPresent(browser.findElement(By.xpath(Period)))) {
					
					System.out.println("period to be opened "+acct_period);
					System.out.println("period to be opened xpath "+Period);
					
					ReusableComponents.wait(5500);
					WebElement selectpe = browser.findElement(By.xpath(Period));

					ReusableComponents.wait(8500);
					selectpe.click();
					System.out.println("Accounting period tabledata present");
					ReusableComponents.wait(5500);
					
					try {
						if(ReusableComponents.isElementPresent(Closed_Status)) {
							
							System.out.println("closed to be opened");
						
						try {
							
							if (ReusableComponents.isElementPresent(Edit)) {
								
								ReusableComponents.wait(10200);
								Edit.click();
								ReusableComponents.wait(5500);
								ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Edit button is present", browser ,pathLoc+"\\"+testcasemethod , false);

								if (ReusableComponents.isElementPresent(Status)) {
									
									ReusableComponents.wait(3200);
									Status.click();
									ReusableComponents.wait(5500);
									ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Status selectbox is present", browser ,pathLoc+"\\"+testcasemethod , false);

									String P_stat = "//span[@title='"+per_stat+"']";
									
									WebElement selecttype = browser.findElement(By.xpath(P_stat));
									ReusableComponents.wait(5500);
									selecttype.click();
									System.out.println("Accounting period status present");
									ReusableComponents.wait(5500);
									
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Editing Accounting period", browser, pathLoc+"\\"+testcasemethod, true);
									
									if (ReusableComponents.isElementPresent(Save)) {
										
										ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Save button is present", browser ,pathLoc+"\\"+testcasemethod , false);
										ReusableComponents.wait(7200);
										Save.click();
										ReusableComponents.wait(6500);
										

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
									}
									
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Status selectbox is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
								}
								
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Edit button is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
							}
							
						} catch (Exception c) {
							
							System.out.println("period not edited first "+c.getMessage());
						}
						
						System.out.println("opening period in progress");
						ReusableComponents.wait(66500);
						
						}else {
							
							System.out.println("period is open or archived");
							
							}
					} catch (Exception eq) {

						eq.printStackTrace();
					}
					
					} else {
						
						if(ReusableComponents.isElementNotPresent(browser.findElement(By.xpath(Period)))) {
							
						System.out.println(Period+" period is not present");
						ReusableComponents.wait(5500);
						browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");
					
					}else {
						System.out.println(Period+" period loop else error");
					}
					}
				} catch (Exception h) {
		
					System.out.println("element exception : "+h.getMessage());
	
				}
	
			ReusableComponents.wait(5500);
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");
			
				}				
			

		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Nextyear open" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

	return new T2688Page(browser);

}
	
		/***
		 * Test case Method Name : Account_creation
		 * Functionality : validate T2688 Page
		 * Created By : Lakshman
		 * 
		 * @throws IOException
		 * @throws AWTException
		 * 
		 ***/
		public synchronized T2688Page Account_creation(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
			String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
			try {
				
				browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
				ReusableComponents.wait(5200);
				
				String dt_pattern = "YYMMDDhhmmss";
				DateTimeFormatter cdt = DateTimeFormatter.ofPattern(dt_pattern);
				LocalDateTime now = LocalDateTime.now();
				account_name = reusableComponents.getPropValues("accountname");
				account_name = account_name + cdt.format(now);
				String acc_type = reusableComponents.getPropValues("actype1");
				
				ReusableComponents.wait(3200);
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
				ReusableComponents.wait(3200);
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
				ReusableComponents.wait(3200);

				List<WebElement> f = browser.findElements(By.tagName("frame"));
				int i = f.size();
				System.out.println(i + "is the frame count");

				browser.switchTo().frame(0);

				ReusableComponents.wait(8200);
				
				if (ReusableComponents.isElementPresent(Accounts)) {

					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Accounts is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(5200);
					Accounts.click();
					ReusableComponents.wait(5200);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounts page", browser, pathLoc+"\\"+testcasemethod, true);
					
					if (ReusableComponents.isElementPresent(New)) {

						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Account New button is present", browser, pathLoc + "\\" + testcasemethod, false);
						ReusableComponents.wait(5200);
						New.click();
						ReusableComponents.wait(5200);
						
						if (ReusableComponents.isElementPresent(Account_Name)) {

							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Account Name field is present", browser, pathLoc + "\\" + testcasemethod, false);
							ReusableComponents.wait(5200);
							Account_Name.sendKeys(account_name);
							ReusableComponents.wait(5200);
							
							WebElement element = browser.findElement(By.xpath("//span[contains(text(),'Accounting Information')]"));
							((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
							
							if (ReusableComponents.isElementPresent(Account_type)) {

								ReusableComponents.wait(5200);
								Account_type.click();
								ReusableComponents.wait(5200);
								Account_type.click();
								ReusableComponents.wait(8200);
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Account Type selectbox is present", browser, pathLoc + "\\" + testcasemethod, false);
								
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
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Account Active checkbox is present", browser, pathLoc + "\\" + testcasemethod, false);
									
									if (ReusableComponents.isElementPresent(Save)) {

										ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "\\" + testcasemethod, false);
										ReusableComponents.wait(5200);
										Save.click();
										ReusableComponents.wait(5200);
										
									} 
									else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button not present", browser, pathLoc + "\\" + testcasemethod, true);
									}
									
								} 
								else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account Active checkbox not present", browser, pathLoc + "\\" + testcasemethod, true);
								}
								
							} 
							else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account Type selectbox not present", browser, pathLoc + "\\" + testcasemethod, true);
							}
							
						} 
						else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account Name field  not present", browser, pathLoc + "\\" + testcasemethod, true);
						}
						
					} 
					else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account New button not present", browser, pathLoc + "\\" + testcasemethod, true);
					}
					
				} 
				else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account tab not present", browser, pathLoc + "\\" + testcasemethod, true);
				}
				
				browser.switchTo().defaultContent();
				

			} catch (Exception e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Error During execution of Account creation" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
						true);
			}

		return new T2688Page(browser);
	
	}
	
	/***
	 * Test case Method Name : Gl_Account_clone 
	 * Functionality : validate T2688 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2688Page Gl_Account_clone(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
		try {
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(6200);
				
			String GLaccount_name = reusableComponents.getPropValues("glacc");
			String GLaccount_namenew1 = reusableComponents.getPropValues("glnew1");
			String GLaccount_namenew2 = reusableComponents.getPropValues("glnew2");
			String GLacc_type = reusableComponents.getPropValues("glacctype");
			System.out.println(GLacc_type);

			
			ReusableComponents.wait(6200);
			JavascriptExecutor js = (JavascriptExecutor) browser;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			ReusableComponents.wait(10200);

			List<WebElement> f = browser.findElements(By.tagName("frame"));
			int i = f.size();
			System.out.println(i + "is the frame count");

			browser.switchTo().frame(0);

			ReusableComponents.wait(6200);

			if (ReusableComponents.isElementPresent(GL_Account)) {

				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "GL Account tab is present", browser, pathLoc + "\\" + testcasemethod, false);
				ReusableComponents.wait(5200);
				GL_Account.click();
				ReusableComponents.wait(5200);

				GL_AccountSearch.sendKeys(GLaccount_name);
				ReusableComponents.wait(5200);
				GL_AccountSearch.sendKeys(Keys.ENTER);
				ReusableComponents.wait(5200);
				System.out.println("Searching gl account");
				
				WebElement Gl = browser.findElement(By.xpath("//tr/th//a[contains(@title, '"+GLaccount_name+"')]"));
				ReusableComponents.wait(5200);
				Gl.click();
				ReusableComponents.wait(5000);
				Clone.click();
				ReusableComponents.wait(5200);
				System.out.println("Clone gl account clicked");
				GL_Account_name.clear();
				ReusableComponents.wait(4200);
				GL_Account_name.sendKeys(GLaccount_namenew1);
				ReusableComponents.wait(3200);
				Save.click();
				ReusableComponents.wait(4200);
				System.out.println("GL account new saved");
				
				browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__GL_Account__c/list?filterName=Recent");
				ReusableComponents.wait(5200);
				
				GL_AccountSearch.sendKeys(GLaccount_name);
				ReusableComponents.wait(5200);
				GL_AccountSearch.sendKeys(Keys.ENTER);
				ReusableComponents.wait(5200);
				System.out.println("Searching gl account");
				
				WebElement G2 = browser.findElement(By.xpath("//tr/th//a[contains(@title, '"+GLaccount_name+"')]"));
				ReusableComponents.wait(5200);
				G2.click();
				ReusableComponents.wait(5000);
				Clone.click();
				ReusableComponents.wait(5200);
				System.out.println("Clone gl account clicked");
				GL_Account_name.clear();
				ReusableComponents.wait(4200);
				GL_Account_name.sendKeys(GLaccount_namenew2);
				ReusableComponents.wait(3200);
				Save.click();
				ReusableComponents.wait(4200);
				System.out.println("GL account new2 saved");

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "GL Account tab is not present", browser, pathLoc + "\\" + testcasemethod, true);
			}

			browser.switchTo().defaultContent();
				
				
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of GL Account clone" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
			
		return new T2688Page(browser);
			
	}
	
	/**
	 * @author Wisefinch Menaka
	 * @see Just navigate to home page. This only work after successfull login to
	 *      the page. Else will keep navigate to login page.
	 * @throws IOException
	 */
	public static void navigateToAccountingHomePage() throws IOException {
		String url = reusableComponents.getPropValues("salesforceurl");
		browser.get(url);
		ReusableComponents.wait(5000);
		try {
			browser.switchTo().alert().accept();
		} catch (Exception e1) {
			System.out.println("There are no alert displayed");
		}
	}
	
	/**
	 * Author Menaka
	 *
	 * @see Click on search icon present in Jasper webpage, in search input box
	 *      provide appNameToSearch to search and click the webelemet with the help
	 *      of selectAppXpath
	 *
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param appNameToSearch --> App name to pass inside search app and items
	 *                        section input box
	 * @param selectAppXpath  --> xpath to click after providing value to search app
	 *                        input box
	 * @throws Exception
	 */
	public static T2735Page selectAppFromSearchAppAndItem(int threadID, List<String> tempList, String pathLocation,

			String appNameToSearch, WebElement selectAppXpath) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLocation = reusableComponents.pathBuilder(path);

		navigateToAccountingHomePage();

		try {
			ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
			ReusableComponents.wait(5000);
			ReusableComponents.sendKey(SearchAppAndItemInputbox, appNameToSearch, "Search app and Item inputbox");
			ReusableComponents.clickElement(selectAppXpath, "Select value from App and Item dropdown");
			ReusableComponents.wait(5000);
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to select app from select search app section" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}
		return new T2735Page(browser);

	}

	/**
	 * @author Wisefinch Menaka
	 * @see To check a specific accounting period current status.
	 *
	 * @param threadID
	 * @param tempList
	 * @param pathLoc
	 * @param accountingPeriod --> Pass the accounting period name. Ex 2020-11
	 * @param expectedStatus   --> Pass the accounting period status. Ex Closed,
	 *                         Open, Archived
	 * @return
	 * @throws Exception
	 */
	public static boolean checkAccountPeriodStatus(int threadID, List<String> tempList, String pathLoc,
			String accountingPeriod, String expectedStatus) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLoc = reusableComponents.pathBuilder(path);
		boolean statusCheck = false;
		try {
			// --> Navigate to home page
			navigateToAccountingHomePage();
			ReusableComponents.wait(5200);

			// --> Move to accounting periods page
			selectAppFromSearchAppAndItem(threadID, tempList, pathLoc, "Accounting Periods", SelectAccountingPeriods);

			// --> Perform search action
			ReusableComponents.sendKey(searchTextBox_AccountPeriod, accountingPeriod, "Year close");
			ReusableComponents.sendkey_InputKey(searchTextBox_AccountPeriod, Keys.ENTER, "Pass Enter");
			ReusableComponents.wait(2000);

			// --> Verify the status
			String xpathToCheckStatus = "((.//*[@scope='row']//a[contains(text(),'" + accountingPeriod
					+ "')]//following::td)[3]//span)[2]";
			System.out.println("********** xpathToCheckStatus " + xpathToCheckStatus);

			WebElement statusElement = browser.findElement(By.xpath(xpathToCheckStatus));

			String statusOfTheAccountingPeriod = statusElement.getText();

			if (statusOfTheAccountingPeriod.equalsIgnoreCase(expectedStatus)) {
				statusCheck = true;
				ReusableComponents.reportPass(
						threadID, tempList, testcasemethod, "Accounting period " + accountingPeriod
								+ " status displayed as expected " + statusOfTheAccountingPeriod,
						browser, pathLoc + "\\" + testcasemethod, false);

				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
						pathLoc + "\\" + testcasemethod, true);

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Accounting period " + accountingPeriod
								+ " status is not displayed as expected. Expedted Status " + expectedStatus
								+ ". Current status " + statusOfTheAccountingPeriod,
						browser, pathLoc + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);

		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to select app from select search app section" + e.getStackTrace(), browser,
					pathLoc + "\\" + testcasemethod, true);
		}
		return statusCheck;
	}
	
	/***
	 * Test case Method Name : Cashreciept1 
	 * Functionality : validate T2688 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2688Page Cashreciept1(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
		try {
				
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(10200);
			
			System.out.println(account_name);
			String cramount = reusableComponents.getPropValues("amount");
			String crref = reusableComponents.getPropValues("ref");
			Period2 = reusableComponents.getPropValues("period2");
			String crperiod = Period2;
			String crbank = reusableComponents.getPropValues("glnew1");
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
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt tab is present", browser, pathLoc + "\\" + testcasemethod, false);
				ReusableComponents.wait(5500);
				
				if (ReusableComponents.isElementPresent(New)) {

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Reciept page", browser, pathLoc+"\\"+testcasemethod, true);
					ReusableComponents.wait(3200);
					New.click();
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt New button is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(5500);
					
					if (ReusableComponents.isElementPresent(Customer_CR)) {

						ReusableComponents.wait(3200);
						Customer_CR.sendKeys(account_name);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Customer searchbox is present", browser, pathLoc + "\\" + testcasemethod, false);
						ReusableComponents.wait(8500);
						
						WebElement Customer_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+account_name+"']"));
						ReusableComponents.wait(5200);
						Customer_click.click();
						System.out.println("customer selected");
						ReusableComponents.wait(5200);
							
							if (ReusableComponents.isElementPresent(Type_CR)) {

								ReusableComponents.wait(3200);
								Type_CR.click();
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt Type selectbox is present", browser, pathLoc + "\\" + testcasemethod, false);
								ReusableComponents.wait(8500);
								
								String Receipt_type = "//lightning-base-combobox-item/span[@class='slds-media__body']/span[contains(text(),'"+receipt_type+"')]";
							
								WebElement selecttype = browser.findElement(By.xpath(Receipt_type));
								ReusableComponents.wait(5500);
								selecttype.click();
								
								if (ReusableComponents.isElementPresent(Period_input)) {
									
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Period field is present", browser, pathLoc + "\\" + testcasemethod, false);
									ReusableComponents.wait(3200);
									Period_input.sendKeys(crperiod);
									ReusableComponents.wait(5500);
									
									WebElement Period_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+crperiod+"']"));

									ReusableComponents.wait(5200);
									Period_click.click();
									ReusableComponents.wait(5200);
									System.out.println("period selected");
									ReusableComponents.wait(5200);

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Period field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
								}
								
								if (ReusableComponents.isElementPresent(Amount_CR)) {

									ReusableComponents.wait(3200);
									Amount_CR.sendKeys(cramount);
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt Amount field is present", browser, pathLoc + "\\" + testcasemethod, false);
									ReusableComponents.wait(5500);
									
									WebElement element = browser.findElement(By.xpath("//span[contains(text(),'Description and Reference Information')]"));
									((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
										
									if (ReusableComponents.isElementPresent(Reference_CR)) {

										ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt Reference field is present", browser, pathLoc + "\\" + testcasemethod, false);
										ReusableComponents.wait(3200);
										Reference_CR.sendKeys(crref);
										ReusableComponents.wait(5500);
										
										if(ReusableComponents.isElementPresent(Bank_CR)) {
											
											ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt Bank searchbox is present", browser, pathLoc + "\\" + testcasemethod, false);
											ReusableComponents.wait(3200);
											Bank_CR.sendKeys(crbank);
											ReusableComponents.wait(5500);
											
											WebElement bank_select = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title'"+crbank+"']"));
											
											ReusableComponents.wait(5200);
											bank_select.click();
											ReusableComponents.wait(5200);
											System.out.println("bank selected");
											ReusableComponents.wait(5200);
											
										} else {
											
											ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt Bank searchbox is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
										}
											
										if (ReusableComponents.isElementPresent(Save)) {

											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Reciept creation page", browser, pathLoc+"\\"+testcasemethod, true);
											ReusableComponents.wait(4200);
											ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "\\" + testcasemethod, false);
											ReusableComponents.wait(3200);
											Save.click();
											ReusableComponents.wait(10500);
											
											CRname = CR_getname.getText();
											ReusableComponents.wait(3200);
												
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
										}
											
									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt Reference field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
									}	
										
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt Amount field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
								}
									
						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt Type selectbox is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
						}
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Customer searchbox is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt New button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt tab is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
			}
			
			browser.switchTo().defaultContent();
				
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Cashreceipt1" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
			
		return new T2688Page(browser);
			
	}
	
	/***
	 * Test case Method Name : Cashreciept2
	 * Functionality : validate T2688 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2688Page Cashreciept2(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
		try {
				
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(10200);
			
			System.out.println(account_name);
			Period3 = reusableComponents.getPropValues("period3");
			String crperiod = Period3;
			String crbank = reusableComponents.getPropValues("glnew1");

			browser.switchTo().frame(0);
			
			ReusableComponents.wait(6200);
			
			if (ReusableComponents.isElementPresent(Cash_Receipts_tab)) {

				ReusableComponents.wait(3200);
				Cash_Receipts_tab.click();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt tab is present", browser, pathLoc + "\\" + testcasemethod, false);
				ReusableComponents.wait(5500);
					
				CR_Search.sendKeys(CRname);
				ReusableComponents.wait(1400);
				CR_Search.sendKeys(Keys.ENTER);
				ReusableComponents.wait(4500);
				
				WebElement CR1 = browser.findElement(By.xpath("//a[contains(.,'"+CRname+"')]"));
				
				ReusableComponents.wait(3200);
				CR1.click();
				ReusableComponents.wait(6200);
				System.out.println("cash reciept opened");
				
				Clone.click();
				ReusableComponents.wait(4200);
				
				WebElement Period_deselect = browser.findElement(By.xpath("(//button[@title='Clear Selection'])[2]"));
				
				ReusableComponents.wait(3200);
				Period_deselect.click();
				ReusableComponents.wait(6200);
				System.out.println("period deselected");
				
							
				if (ReusableComponents.isElementPresent(Period_input)) {
									
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Period field is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(3200);
					Period_input.sendKeys(crperiod);
					ReusableComponents.wait(5500);
								
					WebElement Period_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+crperiod+"']"));

					ReusableComponents.wait(5200);
					Period_click.click();
					ReusableComponents.wait(5200);
					System.out.println("period selected");
					ReusableComponents.wait(5200);

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Period field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}
								
				WebElement element = browser.findElement(By.xpath("//span[contains(text(),'Description and Reference Information')]"));
				((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
				
				WebElement Bank_deselect = browser.findElement(By.xpath("(//button[@title='Clear Selection'])[2]"));
				
				ReusableComponents.wait(3200);
				Bank_deselect.click();
				ReusableComponents.wait(6200);
				System.out.println("bank deselected");
										
				if(ReusableComponents.isElementPresent(Bank_CR)) {
										
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt Bank searchbox is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(3200);
					Bank_CR.sendKeys(crbank);
					ReusableComponents.wait(5500);
					
					WebElement bank_select = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title'"+crbank+"']"));
					
					ReusableComponents.wait(5200);
					bank_select.click();
					ReusableComponents.wait(5200);
					System.out.println("bank selected");
					ReusableComponents.wait(5200);
											
				} else {		
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt Bank searchbox is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}
											
				if (ReusableComponents.isElementPresent(Save)) {

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Reciept creation page", browser, pathLoc+"\\"+testcasemethod, true);
					ReusableComponents.wait(4200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(3200);
					Save.click();
					ReusableComponents.wait(10500);
												
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}
				
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt tab is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
			}
			
			browser.switchTo().defaultContent();
				
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Cashreceipt2" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
			
		return new T2688Page(browser);
			
	}
	
	/***
	 * Test case Method Name : Cashreciept3
	 * Functionality : validate T2688 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2688Page Cashreciept3(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
		try {
				
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(10200);

			String crperiod = Period1;
			String crbank = reusableComponents.getPropValues("glnew2");
			String cramountnew = reusableComponents.getPropValues("amount2");
		    List<WebElement> f = browser.findElements(By.tagName("frame"));
		    int i = f.size();
		    System.out.println(i +" is the frame count");

			browser.switchTo().frame(0);
			
			ReusableComponents.wait(6200);
			
			if (ReusableComponents.isElementPresent(Cash_Receipts_tab)) {

				ReusableComponents.wait(3200);
				Cash_Receipts_tab.click();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt tab is present", browser, pathLoc + "\\" + testcasemethod, false);
				ReusableComponents.wait(5500);
					
				CR_Search.sendKeys(CRname);
				ReusableComponents.wait(1400);
				CR_Search.sendKeys(Keys.ENTER);
				ReusableComponents.wait(4500);
				
				WebElement CR1 = browser.findElement(By.xpath("//a[contains(.,'"+CRname+"')]"));
				
				ReusableComponents.wait(3200);
				CR1.click();
				ReusableComponents.wait(6200);
				System.out.println("cash reciept opened");
				
				Clone.click();
				ReusableComponents.wait(4200);
				
				WebElement Period_deselect = browser.findElement(By.xpath("(//button[@title='Clear Selection'])[2]"));
				
				ReusableComponents.wait(3200);
				Period_deselect.click();
				ReusableComponents.wait(6200);
				System.out.println("period deselected");
				
							
				if (ReusableComponents.isElementPresent(Period_input)) {
									
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Period field is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(3200);
					Period_input.sendKeys(crperiod);
					ReusableComponents.wait(5500);
								
					WebElement Period_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+crperiod+"']"));

					ReusableComponents.wait(5200);
					Period_click.click();
					ReusableComponents.wait(5200);
					System.out.println("period selected");
					ReusableComponents.wait(5200);

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Period field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}
								
				Amount_CR.clear();
				ReusableComponents.wait(4000);
				Amount_CR.sendKeys(cramountnew);
				ReusableComponents.wait(4200);
				
				WebElement element = browser.findElement(By.xpath("//span[contains(text(),'Description and Reference Information')]"));
				((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
				
				WebElement Bank_deselect = browser.findElement(By.xpath("(//button[@title='Clear Selection'])[2]"));
				
				ReusableComponents.wait(3200);
				Bank_deselect.click();
				ReusableComponents.wait(6200);
				System.out.println("bank deselected");
										
				if(ReusableComponents.isElementPresent(Bank_CR)) {
										
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt Bank searchbox is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(3200);
					Bank_CR.sendKeys(crbank);
					ReusableComponents.wait(5500);
					
					WebElement bank_select = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title'"+crbank+"']"));
					
					ReusableComponents.wait(5200);
					bank_select.click();
					ReusableComponents.wait(5200);
					System.out.println("bank selected");
					ReusableComponents.wait(5200);
											
				} else {		
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt Bank searchbox is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}
											
				if (ReusableComponents.isElementPresent(Save)) {

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Reciept creation page", browser, pathLoc+"\\"+testcasemethod, true);
					ReusableComponents.wait(4200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(3200);
					Save.click();
					ReusableComponents.wait(10500);
					
					CRname2 = CR_getname.getText();
												
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}
				
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt tab is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
			}
			
			browser.switchTo().defaultContent();
				
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Cashreceipt3" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
			
		return new T2688Page(browser);
			
	}
	
	/***
	 * Test case Method Name : Cashreciept4
	 * Functionality : validate T2688 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2688Page Cashreciept4(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
		try {
				
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(10200);
			
			String crperiod = Period3;
			String crbank = reusableComponents.getPropValues("glnew2");
			
		    List<WebElement> f = browser.findElements(By.tagName("frame"));
		    int i = f.size();
		    System.out.println(i +" is the frame count");

			browser.switchTo().frame(0);
			
			ReusableComponents.wait(6200);
			
			if (ReusableComponents.isElementPresent(Cash_Receipts_tab)) {

				ReusableComponents.wait(3200);
				Cash_Receipts_tab.click();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt tab is present", browser, pathLoc + "\\" + testcasemethod, false);
				ReusableComponents.wait(5500);
					
				CR_Search.sendKeys(CRname2);
				ReusableComponents.wait(1400);
				CR_Search.sendKeys(Keys.ENTER);
				ReusableComponents.wait(4500);
				
				WebElement CR1 = browser.findElement(By.xpath("//a[contains(.,'"+CRname2+"')]"));
				
				ReusableComponents.wait(3200);
				CR1.click();
				ReusableComponents.wait(6200);
				System.out.println("cash reciept opened");
				
				Clone.click();
				ReusableComponents.wait(4200);
				
				WebElement Period_deselect = browser.findElement(By.xpath("(//button[@title='Clear Selection'])[2]"));
				
				ReusableComponents.wait(3200);
				Period_deselect.click();
				ReusableComponents.wait(6200);
				System.out.println("period deselected");
				
							
				if (ReusableComponents.isElementPresent(Period_input)) {
									
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Period field is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(3200);
					Period_input.sendKeys(crperiod);
					ReusableComponents.wait(5500);
								
					WebElement Period_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+crperiod+"']"));

					ReusableComponents.wait(5200);
					Period_click.click();
					ReusableComponents.wait(5200);
					System.out.println("period selected");
					ReusableComponents.wait(5200);

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Period field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}
								
				WebElement element = browser.findElement(By.xpath("//span[contains(text(),'Description and Reference Information')]"));
				((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
				
				WebElement Bank_deselect = browser.findElement(By.xpath("(//button[@title='Clear Selection'])[2]"));
				
				ReusableComponents.wait(3200);
				Bank_deselect.click();
				ReusableComponents.wait(6200);
				System.out.println("bank deselected");
										
				if(ReusableComponents.isElementPresent(Bank_CR)) {
										
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt Bank searchbox is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(3200);
					Bank_CR.sendKeys(crbank);
					ReusableComponents.wait(5500);
					
					WebElement bank_select = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title'"+crbank+"']"));
					
					ReusableComponents.wait(5200);
					bank_select.click();
					ReusableComponents.wait(5200);
					System.out.println("bank selected");
					ReusableComponents.wait(5200);
											
				} else {		
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt Bank searchbox is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}
											
				if (ReusableComponents.isElementPresent(Save)) {

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Reciept creation page", browser, pathLoc+"\\"+testcasemethod, true);
					ReusableComponents.wait(4200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(3200);
					Save.click();
					ReusableComponents.wait(10500);
												
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}
				
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt tab is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
			}
			
			browser.switchTo().defaultContent();
				
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Cashreceipt4" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
			
		return new T2688Page(browser);
			
	}
	
	/***
	 * Test case Method Name : PeriodClose 
	 * Functionality : validate T2688 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2688Page PeriodClose(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String acc_period = reusableComponents.getPropValues("period3");
			per_stat = "Closed";
			String strArray[] = acc_period.split("-");
	        String yearValue = strArray[0];
	        int year =  Integer. parseInt(strArray[0]);
	        int month =  Integer. parseInt(strArray[1]);
	           
	        previousYearClose = year-1; // call previous year account period close method
	        
	        prev_periodclose(threadID, tempList, pathLoc);
	        
	        ReusableComponents.wait(5200);
			
			Home.click();
			ReusableComponents.wait(5500);
			Input.sendKeys("Accounting Periods");
			ReusableComponents.wait(5500);
			click_ap.click();
			ReusableComponents.wait(5500);
			listview.click();
			ReusableComponents.wait(5500);
			all_list.click();
			ReusableComponents.wait(5500);
			
			int j=1; String acct_period=null;
			
			for(j=1;j<=month;j++) {
					
				String monthValue = null;
				
                if(j<=9) {
                    monthValue="0"+j;
                } else {
                	monthValue=""+j+"";
                }
               
                acct_period = yearValue+"-"+monthValue;
 
				String Period = "//a[@title='"+acct_period+"']";
				
				try {
					ReusableComponents.wait(5500);
					System.out.println("main try");
					
					try {
						browser.findElement(By.xpath("//div[@data-aura-class='uiScroller']")).sendKeys(Keys.PAGE_DOWN);
						ReusableComponents.wait(5500);
						WebElement element = browser.findElement(By.xpath("//a[@title='"+acct_period+"']"));
						((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
						ReusableComponents.wait(5500);
					} catch (Exception e) {
						
						System.out.println(acct_period+" period not present");
					}
							
					if(ReusableComponents.isElementPresent(browser.findElement(By.xpath(Period)))) {
					
					System.out.println("period to be closed "+acct_period);
					System.out.println("period to be closed xpath "+Period);
					
					ReusableComponents.wait(5500);
					WebElement selectpe = browser.findElement(By.xpath(Period));

					ReusableComponents.wait(6500);
					selectpe.click();
					System.out.println("Accounting period tabledata present");
					ReusableComponents.wait(5500);
					
					try {
						if(ReusableComponents.isElementPresent(Open_Status)) {
							
							System.out.println("opened to be closed");
						
						try {
							
							if (ReusableComponents.isElementPresent(Edit)) {
								
								ReusableComponents.wait(8200);
								Edit.click();
								ReusableComponents.wait(5500);
								ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Edit button is present", browser ,pathLoc+"\\"+testcasemethod , false);

								if (ReusableComponents.isElementPresent(Status)) {
									
									ReusableComponents.wait(3200);
									Status.click();
									ReusableComponents.wait(5500);
									ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Status selectbox is present", browser ,pathLoc+"\\"+testcasemethod , false);

									String P_stat = "//span[@title='"+per_stat+"']";
									
									WebElement selecttype = browser.findElement(By.xpath(P_stat));
									ReusableComponents.wait(5500);
									selecttype.click();
									System.out.println("Accounting period status present");
									ReusableComponents.wait(5500);
									
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Editing Accounting period", browser, pathLoc+"\\"+testcasemethod, true);
									
									if (ReusableComponents.isElementPresent(Save)) {
										
										ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Save button is present", browser ,pathLoc+"\\"+testcasemethod , false);
										ReusableComponents.wait(7200);
										Save.click();
										ReusableComponents.wait(16500);
										

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
									}
									
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Status selectbox is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
								}
								
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Edit button is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
							}
							
						} catch (Exception c) {
							
							System.out.println("period not edited first "+c.getMessage());
						}
						
						System.out.println("Closing period in progress");
						ReusableComponents.wait(66500);
						
						}else {
							
							System.out.println("period is closed or archived");
							
							}
					} catch (Exception eq) {
						// TODO Auto-generated catch block
						eq.printStackTrace();
					}
					
					} else {
						
						if(ReusableComponents.isElementNotPresent(browser.findElement(By.xpath(Period)))) {
							
						System.out.println(Period+" period is not present");
						ReusableComponents.wait(5500);
						browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");
					
					}else {
						System.out.println(Period+" period loop else error");
					}
					}
				} catch (Exception h) {
		
					System.out.println("element exception : "+h.getMessage());
	
				}
	
			ReusableComponents.wait(5500);
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");
			
				}				

		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Period close" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
		
		return new T2688Page(browser);
		
	}
	
	/***
	 * Test case Method Name : prev_periodclose 
	 * Functionality : validate T2688 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2688Page prev_periodclose(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String last_period = null;			
			
			ReusableComponents.wait(5200);
			
			Home.click();
			ReusableComponents.wait(5500);
			Input.sendKeys("Accounting Periods");
			ReusableComponents.wait(5500);
			click_ap.click();
			ReusableComponents.wait(5500);
			listview.click();
			ReusableComponents.wait(5500);
			all_list.click();
			ReusableComponents.wait(5500);
			
			int j=1; String acct_period=null;
			
			for(j=1;j<=12;j++) {
					
				if(j==10 || j==11 || j==12) {
					
					acct_period = previousYearClose+"-"+j;
					
				} else {
					
					acct_period = previousYearClose+"-"+"0"+j;
					
				}
				
				last_period = acct_period;
				String Period = "//a[@title='"+acct_period+"']";
				
				try {
					ReusableComponents.wait(5500);
					System.out.println("main try");
					
					try {
						browser.findElement(By.xpath("//div[@data-aura-class='uiScroller']")).sendKeys(Keys.PAGE_DOWN);
						ReusableComponents.wait(5500);
						WebElement element = browser.findElement(By.xpath("//a[@title='"+acct_period+"']"));
						((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
						ReusableComponents.wait(5500);
					} catch (Exception e) {
						
						System.out.println(acct_period+" period not present");
					}
							
					if(ReusableComponents.isElementPresent(browser.findElement(By.xpath(Period)))) {
					
					System.out.println("period to be closed "+acct_period);
					System.out.println("period to be closed xpath "+Period);
					
					ReusableComponents.wait(5500);
					WebElement selectpe = browser.findElement(By.xpath(Period));

					ReusableComponents.wait(8500);
					selectpe.click();
					System.out.println("Accounting period tabledata present");
					ReusableComponents.wait(5500);
					
					try {
						if(ReusableComponents.isElementPresent(Open_Status)) {
							
							System.out.println("opened to be closed");
						
						try {
							browser.navigate().refresh();
							ReusableComponents.wait(5200);
							if (ReusableComponents.isElementPresent(Edit)) {
								
								ReusableComponents.wait(10200);
								Edit.click();
								ReusableComponents.wait(5500);
								ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Edit button is present", browser ,pathLoc+"\\"+testcasemethod , false);

								if (ReusableComponents.isElementPresent(Status)) {
									
									ReusableComponents.wait(3200);
									Status.click();
									ReusableComponents.wait(5500);
									ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Status selectbox is present", browser ,pathLoc+"\\"+testcasemethod , false);

									String P_stat = "//span[@title='"+per_stat+"']";
									
									WebElement selecttype = browser.findElement(By.xpath(P_stat));
									ReusableComponents.wait(5500);
									selecttype.click();
									System.out.println("Accounting period status present");
									ReusableComponents.wait(5500);
									
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Editing Accounting period", browser, pathLoc+"\\"+testcasemethod, true);
									
									if (ReusableComponents.isElementPresent(Save)) {
										
										ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Save button is present", browser ,pathLoc+"\\"+testcasemethod , false);
										ReusableComponents.wait(7200);
										Save.click();
										ReusableComponents.wait(16500);
										

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
									}
									
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Status selectbox is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
								}
								
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Edit button is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
							}
							
						} catch (Exception c) {
							
							System.out.println("period not edited first "+c.getMessage());
						}
						
						System.out.println("Closing period in progress");
						ReusableComponents.wait(66500);
						
						}else {
							
							System.out.println("period is closed or archived");
							
							}
					} catch (Exception eq) {
						// TODO Auto-generated catch block
						eq.printStackTrace();
					}
					
					} else {
						
						if(ReusableComponents.isElementNotPresent(browser.findElement(By.xpath(Period)))) {
							
						System.out.println(Period+" period is not present");
						ReusableComponents.wait(5500);
						browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");
					
					}else {
						System.out.println(Period+" period loop else error");
					}
					}
				} catch (Exception h) {
		
					System.out.println("element exception : "+h.getMessage());
	
				}
	
			ReusableComponents.wait(5500);
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");
			
				}
			
			System.out.println(last_period+" is th ending period of year "+previousYearClose);		

		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Previos period close" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
		
		return new T2688Page(browser);
		
	}
	
	/***
	 * Test case Method Name : TB_report 
	 * Functionality : validate T2688 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2688Page TB_report(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
		try {
				
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(10200);
			
			String s_report = reusableComponents.getPropValues("selectreport1");
			String ledger = reusableComponents.getPropValues("ledg");
		
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(2200);
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
			ReusableComponents.wait(2200);
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
			ReusableComponents.wait(3200);

			List<WebElement> f = browser.findElements(By.tagName("frame"));
			int i = f.size();
			System.out.println(i + "is the frame count");

			browser.switchTo().frame(0);

			ReusableComponents.wait(5200);

			if (ReusableComponents.isElementPresent(Reports)) {

				ReusableComponents.wait(4200);
				Reports.click();
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Financial Reports tab is present", browser ,pathLoc+"\\"+testcasemethod , false);
				ReusableComponents.wait(8200);
				
				browser.navigate().refresh();
				ReusableComponents.wait(4200);
				browser.navigate().refresh();
				ReusableComponents.wait(9200);

				if (ReusableComponents.isElementPresent(Select_report_type)) {

					ReusableComponents.wait(5200);
					Select_report_type.click();
					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Financial Reports type selectbox is present", browser ,pathLoc+"\\"+testcasemethod , false);
					ReusableComponents.wait(6200);
					
					String report_type = "//span[.='"+s_report+"']";
					
					WebElement selecttype = browser.findElement(By.xpath(report_type));
					ReusableComponents.wait(6500);
					new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(selecttype)).click();
					ReusableComponents.wait(5500);
					
					if (ReusableComponents.isElementNotPresent(Ledger)) {
						
						ReusableComponents.wait(4200);
						Ledger_close.click();
						ReusableComponents.wait(4200);
						
					}
						
						if (ReusableComponents.isElementPresent(Ledger)) {
							
						ReusableComponents.wait(4200);
						Ledger.sendKeys(ledger);
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Ledger searchbox is present", browser ,pathLoc+"\\"+testcasemethod , false);
						ReusableComponents.wait(6200);
						
						WebElement ledger_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+ledger+"']"));
						ReusableComponents.wait(6200);
						ledger_click.click();
						
						ReusableComponents.wait(3200);
						deselect_period.click();
						
											
						if (ReusableComponents.isElementPresent(Accounting_period)) {

							ReusableComponents.wait(5200);
							Accounting_period.sendKeys(Period3);
							
							ReusableComponents.reportPass( threadID , tempList , testcasemethod , "accounting period searchbox is present", browser ,pathLoc+"\\"+testcasemethod , false);
							ReusableComponents.wait(5200);
							
							WebElement start_click = browser.findElement(By.xpath("//span[contains(text(),'"+Period3+"')]"));
							start_click.click();						
							System.out.println("start selected");
							ReusableComponents.wait(5200);
							
//								if (S_Z_A_R.isSelected() == false) {
//									
//									ReusableComponents.wait(4200);
//									S_Z_A_R.click();
//									ReusableComponents.wait(4200);
//									System.out.println("Suppress zero amount checkbox is unchecked");
//									
//								} else {
//								
//									System.out.println("Suppress zero amount is already selected");
//								}
								
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of balance sheet report page", browser, pathLoc+"\\"+testcasemethod, true);
						
								if (ReusableComponents.isElementPresent(Run_report)) {

									ReusableComponents.reportPass( threadID , tempList , testcasemethod , "run report button is present", browser ,pathLoc+"\\"+testcasemethod , false);
									ReusableComponents.wait(5200);
									Run_report.click();
									ReusableComponents.wait(35200);
									
									browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
									ReusableComponents.wait(15200);
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of generated report page", browser, pathLoc+"\\"+testcasemethod, true);
									ReusableComponents.wait(5200);
									ReusableComponents.reportPass( threadID , tempList , testcasemethod , "report link is "+Gen_report.getAttribute("href")+" and report name is "+Gen_report.getText(), browser ,pathLoc+"\\"+testcasemethod , false);
									

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "run report button NOT present", browser, pathLoc + "\\" + testcasemethod, true);
								}
							
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "accounting period searchbox NOT present", browser, pathLoc + "\\" + testcasemethod, true);
							}
						
						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "ledger searchbox NOT present", browser, pathLoc + "\\" + testcasemethod, true);
						}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Financial Reports type selectbox NOT present", browser, pathLoc + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Financial Reports tab NOT present", browser, pathLoc + "\\" + testcasemethod, true);
			}
			
			browser.switchTo().defaultContent();
				
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Trial Balance report" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
			
		return new T2688Page(browser);
			
	}
	
	/***
	 * Test case Method Name : callingmethod 
	 * Functionality : validate T2687 Page
	 * Created By : Lakshman
	 * @throws Exception 
	 * 
	 ***/
	public synchronized T2688Page callingmethod(int threadID, List<String> tempList, String pathLoc) throws Exception {
			
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
		try {
			Period1 = reusableComponents.getPropValues("period1");
			Period3 = reusableComponents.getPropValues("period3");
			
			
			validateTestA(threadID, tempList, pathLoc);
			Currentperiodopen(threadID, tempList, pathLoc);
			
			String expectedAccountingPeriodStatus = "Open";

			boolean actualAccountingPeriodStatus = false;

			try {
				actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLoc, Period1,
						expectedAccountingPeriodStatus);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("actual status is " + actualAccountingPeriodStatus);

			if (actualAccountingPeriodStatus) {
			
			Account_creation(threadID, tempList, pathLoc);
			Gl_Account_clone(threadID, tempList, pathLoc);
			Cashreciept1(threadID, tempList, pathLoc);
			Cashreciept2(threadID, tempList, pathLoc);
			Cashreciept3(threadID, tempList, pathLoc);
			Cashreciept4(threadID, tempList, pathLoc);
			PeriodClose(threadID, tempList, pathLoc);
			
			String expectedperiodstatus = "closed";
			Boolean checkaccountingperiodstatus = checkAccountPeriodStatus(threadID, tempList, pathLoc, Period3, expectedperiodstatus);
			
			if(checkaccountingperiodstatus) {
			
			TB_report(threadID, tempList, pathLoc);
			
			}else {
				
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Accounting period " + Period3 + " status is not closed. Hence can not continue with the test case"
						 , browser, pathLoc + "\\" + testcasemethod, false);
			}
			
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Acconting period "
						+ Period1
						+ " expected to be open but the current status is closed, cannot continue with the testcase"
						 , browser, pathLoc + "\\" + testcasemethod, false);
			}
		
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
			
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of test case 2688" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
			
		return new T2688Page(browser);
			
	}

}
