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
public class T2687Page extends DriverScript {
	protected static WebDriver browser;

	static ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected T2687Page(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public T2687Page() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;
	
	@FindBy(xpath = "//span[@class='home']")
	static WebElement account_home;

	@FindBy(xpath = ".//*[@class='slds-size_medium']//*[@class='slds-input']")
	static WebElement SearchAppAndItemInputbox;
	
	@FindBy(xpath = ".//*[@class='slds-icon-waffle']")
	static WebElement SearchAppAndItemIcon;

	@FindBy(xpath = "//input[@name='AcctSeed__Accounting_Period__c-search-input']")
	static WebElement searchTextBox_AccountPeriod;
	
	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Accounting Periods')]")
	static WebElement SelectAccountingPeriods;
	
	@FindBy(xpath = "//img[@title='Accounting Settings']")
	WebElement Accounting_Settings;
	
	@FindBy(xpath = "//div/h3[contains(.,'Cash Flow Statement Settings')]")
	WebElement CFS_Setting;
	
	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	WebElement Home;
	
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
	
	@FindBy(xpath = "//img[@title='Billings']")
	WebElement Billing_tab;
	
	@FindBy(xpath = "//force-record-layout-section[1]//force-record-layout-row[4]//input[1]")
	WebElement Posting_status_billing;
	
	@FindBy(xpath = "//force-record-layout-section[3]//force-record-layout-row[1]//force-record-layout-item[1]//input[1]")
	WebElement Customer_billing;
	
	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Bline;
	
	@FindBy(xpath = "//div/input[@name='AcctSeed__Rate__c']")
	WebElement Unit_price_Bline;

	@FindBy(xpath = "//div/input[@name='AcctSeed__Hours_Units__c']")
	WebElement Quantity_Bline;
	
	@FindBy(xpath = "//button[.='Post']")
	WebElement Post;
	
	@FindBy(xpath = "//div[@class='pbHeader']//tbody//input[@value='Post']")
	WebElement Post_final;
	
	@FindBy(xpath = "//div[@class='slds-form']//force-record-layout-row[3]//force-record-layout-item//lightning-combobox//input[@class='slds-input slds-combobox__input']")
	WebElement Posting_status;
	
	@FindBy(xpath = "//span[@class='uiImage']/img[@src='/img/icon/t4v35/custom/custom14_120.png']")
	WebElement Payee_tab;

	@FindBy(xpath = "//input[@name='AcctSeed__Payee_Reference__c']")
	WebElement Payee_Reference;

	@FindBy(xpath = "//force-record-layout-row[1]/slot[1]/force-record-layout-item[1]//force-record-layout-lookup[1]//input[1]")
	WebElement Vendor;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounting Periods...')]")
	WebElement Period_input;

	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement New_PLine;

	@FindBy(xpath = "//input[@name='AcctSeed__Unit_Cost__c']")
	WebElement Unit_cost;

	@FindBy(xpath = "//force-record-layout-row[1]//force-record-layout-item[1]//force-record-layout-lookup[1]//lightning-grouped-combobox[1]//lightning-base-combobox[1]//input[1]")
	WebElement Expense_GL_Account;
	
	@FindBy(xpath = "//*[@class='panel-heading' and contains(text(),'General Ledger Setup')]//following::img[@alt='GL Accounts']")
	WebElement GL_Account;

	@FindBy(xpath = "//div[@class='slds-form-element__control slds-grow']/input[@name='Name']")
	WebElement GL_Account_name;

	@FindBy(xpath = "//force-record-layout-row[1]//lightning-combobox[1]//input[1]")
	WebElement GL_Account_type_selection;

	@FindBy(xpath = "//span[@title='Expense']")
	WebElement GL_Account_type;

	@FindBy(xpath = "//img[@title=' Financial Reports']")
	WebElement Reports;

	@FindBy(xpath = "//button[contains(text(),'Select Standard Report')]")
	WebElement Select_report_type;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search Ledgers...')]")
	WebElement Ledger;
	
	@FindBy(xpath = "//button[contains(@title,'Clear Selection')]/lightning-primitive-icon")
	WebElement Ledger_close;
	
	@FindBy(xpath = "//c-lookup[contains(.,'*Accounting Period')]//input[@role='textbox']")
	static
	WebElement Accounting_period_report;
	
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
	
	int previousYearClose,Nextyear; String per_stat,account_name = null, Previous_Accounting_period, AccountingPeriod;

	/***
	 * Test case Method Name : validateTestA 
	 * Functionality : validate Account Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2687Page validateTestA(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
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

					Password_field.sendKeys(pass_login);
					ReusableComponents.wait(1200);
					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login password field is present", browser ,pathLoc+"\\"+testcasemethod , false);

					if (ReusableComponents.isElementPresent(Login_button)) {
						
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Login page", browser, pathLoc+"\\"+testcasemethod, true);
						ReusableComponents.wait(1200);
						Login_button.click();
						ReusableComponents.wait(10500);
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login button is present", browser ,pathLoc+"\\"+testcasemethod , false);
						
						ReusableComponents.wait(3200);
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
		
		return new T2687Page(browser);
		
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
	public static T2687Page selectAppFromSearchAppAndItem(int threadID, List<String> tempList, String pathLoc,

			String appNameToSearch, WebElement selectAppXpath) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLoc = reusableComponents.pathBuilder(path);

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
					pathLoc + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to select app from select search app section" + e.getStackTrace(), browser,
					pathLoc + "\\" + testcasemethod, true);
		}
		return new T2687Page(browser);

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
	 * Test case Method Name : PeriodClose 
	 * Functionality : validate T2687 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2687Page PeriodClose(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			per_stat = "Closed";
			String strArray[] = Previous_Accounting_period.split("-");
	        String yearValue = strArray[0];
	        int year =  Integer. parseInt(strArray[0]);
	        int month =  Integer. parseInt(strArray[1]);
	           
	        previousYearClose = year-1; // call previous year account period close method
	        
	        prev_periodclose(threadID, tempList, pathLoc);
			
	        ReusableComponents.wait(4200);
	        
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
					"Error During execution of Periodclose" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
		
		return new T2687Page(browser);
		
	}
	
	/***
	 * Test case Method Name : prev_periodclose 
	 * Functionality : validate T2687 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2687Page prev_periodclose(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
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
							ReusableComponents.wait(4200);
							
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
					"Error During execution of Previousyear close" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
		
		return new T2687Page(browser);
		
	}
		
	/***
	 * Test case Method Name : Currentperiodopen
	 * Functionality : validate T2687 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2687Page Currentperiodopen(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			
			per_stat = "Open";
			String strArray[] = AccountingPeriod.split("-");
	        String yearValue = strArray[0];
	        int year =  Integer. parseInt(strArray[0]);
	        int month =  Integer. parseInt(strArray[1]);
	         
	        Nextyear = year+1;
	        
	        Nextyearopen(threadID, tempList, pathLoc);
	        
	       
			ReusableComponents.wait(4500);
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
			
			for(j=12;j>=month;j--) {
					
				String monthValue = null;
				
                if(j<=9) {
                    monthValue="0"+j;
                }else {
                	monthValue=""+j+"";
                }
               
                acct_period = yearValue+"-"+monthValue;
               
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
							browser.navigate().refresh();
							ReusableComponents.wait(4500);
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
			
		
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Current period open" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

	return new T2687Page(browser);

}
	
	/***
	 * Test case Method Name : Nextyearopen
	 * Functionality : validate T2687 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2687Page Nextyearopen(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
		
			per_stat = reusableComponents.getPropValues("nstat");
			
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
							browser.navigate().refresh();
							ReusableComponents.wait(4500);
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
					"Error During execution of Nextyearopen" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

	return new T2687Page(browser);

}
	
		/***
		 * Test case Method Name : Account_creation
		 * Functionality : validate T2687 Page
		 * Created By : Lakshman
		 * 
		 * @throws IOException
		 * @throws AWTException
		 * 
		 ***/
		public synchronized T2687Page Account_creation(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
			String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
			try {
				
				browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
				
				ReusableComponents.wait(6200);
				
				String dt_pattern = "YYMMDDhhmmss";
				DateTimeFormatter cdt = DateTimeFormatter.ofPattern(dt_pattern);
				LocalDateTime now = LocalDateTime.now();
				account_name = reusableComponents.getPropValues("accountname");
				account_name = account_name + cdt.format(now);
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

										ReusableComponents.wait(5200);
										Save.click();
										ReusableComponents.wait(5200);
										ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "\\" + testcasemethod, false);
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

		return new T2687Page(browser);
	
	}
		
	/***
	 * Test case Method Name : Billing_creation 
	 * Functionality : validate T2687 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2687Page Billing_creation(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
		try {
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			
			ReusableComponents.wait(6200);
			
			String period = reusableComponents.getPropValues("crperiod");
			String post_status = reusableComponents.getPropValues("postingstatus");
				
			List<WebElement> f = browser.findElements(By.tagName("frame"));
		    int i = f.size();
		    System.out.println(i +" is the frame count");

			browser.switchTo().frame(0);
			
			ReusableComponents.wait(8200);
			
			if (ReusableComponents.isElementPresent(Billing_tab)) {

				ReusableComponents.wait(3200);
				Billing_tab.click();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing tab is present", browser, pathLoc + "\\" + testcasemethod, false);
				ReusableComponents.wait(5500);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Billing page", browser, pathLoc+"\\"+testcasemethod, true);
				
				if (ReusableComponents.isElementPresent(New)) {

					ReusableComponents.wait(3200);
					New.click();
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing New button is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(5500);
					
					if (ReusableComponents.isElementPresent(Posting_status_billing)) {

						ReusableComponents.wait(3200);
						Posting_status_billing.click();
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing Posting status selectbox is present", browser, pathLoc + "\\" + testcasemethod, false);
						ReusableComponents.wait(5500);
						
						String P_stat = "//span[@title='"+post_status+"']";
						
						WebElement selecttype = browser.findElement(By.xpath(P_stat));
						ReusableComponents.wait(5500);
						new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(selecttype)).click();
						ReusableComponents.wait(5500);
						
						WebElement element = browser.findElement(By.xpath("//span[contains(text(),'Customer Information')]"));
						((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
						
						if (ReusableComponents.isElementPresent(Customer_billing)) {

							ReusableComponents.wait(3200);
							Customer_billing.sendKeys(account_name);
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing Customer searchbox is present", browser, pathLoc + "\\" + testcasemethod, false);
							ReusableComponents.wait(5500);
							
							WebElement Vendor_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='" + account_name + "']"));
							
							ReusableComponents.wait(5200);
							Vendor_click.click();
							System.out.println("Customer selected");
							ReusableComponents.wait(5200);
							
							if (ReusableComponents.isElementPresent(Period_input)) {
								
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Period field is present", browser, pathLoc + "\\" + testcasemethod, false);
								ReusableComponents.wait(3200);
								Period_input.sendKeys(period);
								ReusableComponents.wait(5500);
								
								WebElement Period_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+period+"']"));

								ReusableComponents.wait(5200);
								Period_click.click();
								ReusableComponents.wait(5200);
								System.out.println("period selected");
								ReusableComponents.wait(5200);

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Period field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
							}
							
							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Billing creation page", browser, pathLoc+"\\"+testcasemethod, true);
							
							if (ReusableComponents.isElementPresent(Save)) {

								ReusableComponents.wait(3200);
								Save.click();
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "\\" + testcasemethod, false);
								ReusableComponents.wait(8500);
						
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
									}
							
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing Customer searchbox is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
								}
						

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing Posting status selectbox is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
							}
					

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing New button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
						}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing tab is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}
				
				Bline_creation(threadID, tempList, pathLoc);
				
				browser.switchTo().defaultContent();
				
		
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Billing creation" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
			
		return new T2687Page(browser);
			
	}
	
	/***
	 * Test case Method Name : Bline_creation 
	 * Functionality : validate T2687 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2687Page Bline_creation(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
		try {
			ReusableComponents.wait(6500);
			String price = reusableComponents.getPropValues("unitprice");
			String quantity = reusableComponents.getPropValues("quantity");
			
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of created billing page", browser, pathLoc+"\\"+testcasemethod, true);
			ReusableComponents.wait(4200);
			
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(4200);
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(4200);
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(4200);

			ReusableComponents.wait(8200);
			
			if (ReusableComponents.isElementPresent(New_Bline)) {

				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing line New button is present", browser, pathLoc + "\\" + testcasemethod, false);
				ReusableComponents.wait(3200);
				New_Bline.click();
				ReusableComponents.wait(5500);
				
				if (ReusableComponents.isElementPresent(Quantity_Bline)) {

					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing line Quantity field is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(3200);
					Quantity_Bline.clear();
					Quantity_Bline.sendKeys(quantity);
					ReusableComponents.wait(5500);
					
					if (ReusableComponents.isElementPresent(Unit_price_Bline)) {

						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing line Unit price field is present", browser, pathLoc + "\\" + testcasemethod, false);
						ReusableComponents.wait(3200);
						Unit_price_Bline.clear();
						Unit_price_Bline.sendKeys(price);
						ReusableComponents.wait(5500);
						
						if (ReusableComponents.isElementPresent(Save)) {

							ReusableComponents.wait(3200);
							Save.click();
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing line save button is present", browser, pathLoc + "\\" + testcasemethod, false);
							ReusableComponents.wait(5500);
							
							if (ReusableComponents.isElementPresent(Post)) {

								ReusableComponents.wait(3200);
								Post.click();
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing line Post tab is present", browser, pathLoc + "\\" + testcasemethod, false);
								ReusableComponents.wait(5500);
								
								browser.switchTo().frame(0);
								
								if (ReusableComponents.isElementPresent(Post_final)) {

									ReusableComponents.wait(3200);
									Post_final.click();
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing line Post button is present", browser, pathLoc + "\\" + testcasemethod, false);
									ReusableComponents.wait(5500);
									
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing line Post button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
								}
								
								browser.switchTo().defaultContent();
						
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing line Post tab is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
								}
					
						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing line save button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
							}
				
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing line Unit price field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
						}
			
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing line Quantity field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}
		
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing line New button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
				}
				
		
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Billing line" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
			
		return new T2687Page(browser);
			
	}
	
	/***
	 * Test case Method Name : Payable
	 * Functionality : validate T2687 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2687Page Payable(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			
			ReusableComponents.wait(6200);
	
			String status_p = reusableComponents.getPropValues("postingstatus");
			String pref = reusableComponents.getPropValues("ref");
			String period = reusableComponents.getPropValues("crperiod");

			
			ReusableComponents.wait(3200);

			List<WebElement> f = browser.findElements(By.tagName("frame"));
			int i = f.size();
			System.out.println(i + "is the frame count");

			browser.switchTo().frame(0);

			ReusableComponents.wait(6200);

			if (ReusableComponents.isElementPresent(Payee_tab)) {

				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Payable tab is present", browser, pathLoc + "\\" + testcasemethod, false);
				ReusableComponents.wait(3200);
				Payee_tab.click();
				ReusableComponents.wait(5500);

				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Payables page", browser, pathLoc+"\\"+testcasemethod, true);
				ReusableComponents.wait(3200);
				
				if (ReusableComponents.isElementPresent(New)) {
					
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New Payable button is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(3200);
					New.click();
					ReusableComponents.wait(6500);

					if (ReusableComponents.isElementPresent(Posting_status)) {

						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Payable Posting status selectbox is present", browser, pathLoc + "\\" + testcasemethod, false);
						ReusableComponents.wait(5200);
						Posting_status.click();
						ReusableComponents.wait(5500);

						String Status_type = "//span[@title='" + status_p + "']";
						WebElement statustype = browser.findElement(By.xpath(Status_type));
						ReusableComponents.wait(5500);
						statustype.click();
						System.out.println("payable posting status is selected");
						ReusableComponents.wait(5500);

						WebElement element = browser.findElement(By.xpath("//span[normalize-space()='Payee Information']"));
						((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
						
						if (ReusableComponents.isElementPresent(Payee_Reference)) {

							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Payee Reference field is present", browser, pathLoc + "\\" + testcasemethod, false);
							ReusableComponents.wait(4200);
							Payee_Reference.sendKeys(pref);
							ReusableComponents.wait(5500);

							if (ReusableComponents.isElementPresent(Vendor)) {

								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Vendor searchbox is present", browser, pathLoc + "\\" + testcasemethod, false);
								ReusableComponents.wait(4200);
								Vendor.sendKeys(account_name);
								ReusableComponents.wait(5500);

								WebElement Vendor_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='" + account_name + "']"));

								ReusableComponents.wait(5200);
								Vendor_click.click();
								ReusableComponents.wait(5200);
								System.out.println("Vendor selected");
								ReusableComponents.wait(5200);
								
								if (ReusableComponents.isElementPresent(Period_input)) {
									
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Period field is present", browser, pathLoc + "\\" + testcasemethod, false);
									ReusableComponents.wait(3200);
									Period_input.sendKeys(period);
									ReusableComponents.wait(5500);
									
									WebElement Period_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+period+"']"));

									ReusableComponents.wait(5200);
									Period_click.click();
									ReusableComponents.wait(5200);
									System.out.println("period selected");
									ReusableComponents.wait(5200);

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Period field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
								}
								
								if (ReusableComponents.isElementPresent(Save)) {
									
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Payable creation page", browser, pathLoc+"\\"+testcasemethod, true);
									ReusableComponents.wait(3200);
									Save.click();
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "\\" + testcasemethod, false);
									ReusableComponents.wait(5500);

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Vendor searchbox is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Payee Reference field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Payble Posting status selectbox is NOT present", browser, pathLoc + "\\" + testcasemethod,
								true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Payable New button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Payable tab is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
			}

			Pline_posting(threadID, tempList, pathLoc);
			
			browser.switchTo().defaultContent();
	
		
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Payable creation" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

return new T2687Page(browser);

}

	/***
	 * Test case Method Name : Pline_posting
	 * Functionality : validate T2687 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2687Page Pline_posting(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			ReusableComponents.wait(8500);
			String Amount = reusableComponents.getPropValues("amount");
			String expense_acc_name = reusableComponents.getPropValues("bank");
			

			for (int i = 0; i < 27; i++) {

				browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);

			}

			ReusableComponents.wait(5500);

			if (ReusableComponents.isElementPresent(New_PLine)) {

				ReusableComponents.wait(4200);

				New_PLine.click();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New Payable Line button is present", browser, pathLoc + "\\" + testcasemethod, false);
				ReusableComponents.wait(6500);

				if (ReusableComponents.isElementPresent(Unit_cost)) {

					ReusableComponents.wait(5200);
					Unit_cost.sendKeys(Amount);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Unit cost field is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(5500);

					if (ReusableComponents.isElementPresent(Expense_GL_Account)) {

						JavascriptExecutor js = (JavascriptExecutor) browser;
						js.executeScript("arguments[0].scrollIntoView();", Expense_GL_Account);

						ReusableComponents.wait(3200);
						Expense_GL_Account.sendKeys(expense_acc_name);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Expense GL Account searchbox is present", browser, pathLoc + "\\" + testcasemethod, false);
						ReusableComponents.wait(5500);

						WebElement Exp_gla_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[contains(@title,'" + expense_acc_name + "')]"));
	
						System.out.println("Expense gl account selected");
						ReusableComponents.wait(5200);
						Exp_gla_click.click();
						ReusableComponents.wait(3200);
						System.out.println("action called");
						ReusableComponents.wait(5200);

						

						if (ReusableComponents.isElementPresent(Save)) {

							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of New Payable line creation page", browser, pathLoc+"\\"+testcasemethod, true);
							ReusableComponents.wait(5200);
							Save.click();
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "\\" + testcasemethod, false);
							ReusableComponents.wait(5500);

							if (ReusableComponents.isElementPresent(Post)) {

								ReusableComponents.wait(3200);
								Post.click();
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Post tab is present", browser, pathLoc + "\\" + testcasemethod, false);
								ReusableComponents.wait(6500);

								browser.switchTo().frame(0);

								if (ReusableComponents.isElementPresent(Post_final)) {
									
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Payable post page", browser, pathLoc+"\\"+testcasemethod, true);
									ReusableComponents.wait(4200);
									Post_final.click();
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Post final button is present", browser, pathLoc + "\\" + testcasemethod, false);
									ReusableComponents.wait(5500);

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Post final button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
								}

								browser.switchTo().defaultContent();

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Post tab is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Expense GL Account searchbox is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Unit cost field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "New Payable Line button is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
			}

	
	
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Payable line" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

return new T2687Page(browser);

}
	
	/***
	 * Test case Method Name : Gl_Account_creation 
	 * Functionality : validate T2687 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2687Page Gl_Account_creation(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
		try {
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			
			ReusableComponents.wait(6200);
				
			String GLaccount_name = reusableComponents.getPropValues("glaccname");
			String GLacc_type = reusableComponents.getPropValues("glacctype");
			System.out.println(GLacc_type);

			
			ReusableComponents.wait(6200);
			JavascriptExecutor js = (JavascriptExecutor) browser;
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

			// browser.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
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

				if (ReusableComponents.isElementPresent(New)) {

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of GL Account page", browser, pathLoc + "\\" + testcasemethod, true);
					ReusableComponents.wait(5200);
					New.click();
					ReusableComponents.wait(5200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "GL Account New button is present", browser, pathLoc + "\\" + testcasemethod, false);

					if (ReusableComponents.isElementPresent(GL_Account_name)) {

						ReusableComponents.wait(5200);
						GL_Account_name.sendKeys(GLaccount_name);
						ReusableComponents.wait(5200);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "GL Account name field is present", browser, pathLoc + "\\" + testcasemethod, false);

						if (ReusableComponents.isElementPresent(GL_Account_type_selection)) {

							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "GL Account type selectbox is present", browser, pathLoc + "\\" + testcasemethod, false);
							ReusableComponents.wait(5200);
							GL_Account_type_selection.click();
							ReusableComponents.wait(8200);
							
							String GLAcctype = "//span[@title='"+GLacc_type+"']";
							System.out.println(GLAcctype);
						 
							WebElement selecttype = browser.findElement(By.xpath(GLAcctype));
			
							ReusableComponents.wait(5500);
							new WebDriverWait(browser,20).until(ExpectedConditions.elementToBeClickable(selecttype)).click();
							ReusableComponents.wait(5500);
							
							 
							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of GL Account creation page", browser, pathLoc + "\\" + testcasemethod, true);

								if (ReusableComponents.isElementPresent(Save)) {

									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "\\" + testcasemethod, false);
									ReusableComponents.wait(5200);
									Save.click();
									ReusableComponents.wait(5200);
								
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is not present", browser, pathLoc + "\\" + testcasemethod, true);
								}

							
						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "GL Account type selectbox is not present", browser, pathLoc + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "GL Account name field is not present", browser, pathLoc + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "GL Account New button is not present", browser, pathLoc + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "GL Account tab is not present", browser, pathLoc + "\\" + testcasemethod, true);
			}

			browser.switchTo().defaultContent();
				
				
		
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of GL Account creation" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
			
		return new T2687Page(browser);
			
	}
	
	/***
	 * Test case Method Name : TB_report 
	 * Functionality : validate T2687 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2687Page TB_report(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
		try {
				
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			
			ReusableComponents.wait(10200);
			
			String s_report = reusableComponents.getPropValues("selectreport1");
			String ledger = reusableComponents.getPropValues("ledg");
			String a_period = reusableComponents.getPropValues("crperiod");
			
			ReusableComponents.wait(5200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"\\"+testcasemethod, true);
			ReusableComponents.wait(3200);
		
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
						
											
						if (ReusableComponents.isElementPresent(Accounting_period_report)) {

							ReusableComponents.wait(5200);
							Accounting_period_report.sendKeys(a_period);
							
							ReusableComponents.reportPass( threadID , tempList , testcasemethod , "accounting period searchbox is present", browser ,pathLoc+"\\"+testcasemethod , false);
							ReusableComponents.wait(5200);
							
							WebElement start_click = browser.findElement(By.xpath("//span[contains(text(),'"+a_period+"')]"));
							start_click.click();						
							System.out.println("start selected");
							ReusableComponents.wait(5200);
							
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
					"Error During execution of Trial balance report" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
			
		return new T2687Page(browser);
			
	}
	
	/***
	 * Test case Method Name : callingmethod 
	 * Functionality : validate T2687 Page
	 * Created By : Lakshman
	 * @throws Exception 
	 * 
	 ***/
	public synchronized T2687Page callingmethod(int threadID, List<String> tempList, String pathLoc) throws Exception {
			
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
		try {
			AccountingPeriod = reusableComponents.getPropValues("crperiod");
			validateTestA(threadID, tempList, pathLoc);
			
			String strArray[] = AccountingPeriod.split("-");
			String yearValue = strArray[0];
			String month = strArray[1];
			int year = Integer.parseInt(strArray[0]);
			int monthint = Integer.parseInt(strArray[1]);

			if (month.equals("01")) {

				year = year - 1;
				monthint = 12;

			} else {

				monthint = monthint - 1;
			}

			if (monthint <= 9) {

				Previous_Accounting_period = String.valueOf(year) + "-" + "0" + String.valueOf(monthint);
			} else {

				Previous_Accounting_period = String.valueOf(year) + "-" + String.valueOf(monthint);
			}
			
			System.out.println("Previous period is "+Previous_Accounting_period);
			
			PeriodClose(threadID, tempList, pathLoc);
			Currentperiodopen(threadID, tempList, pathLoc);
			
			String expectedperiodstatus = "closed";
			Boolean checkaccountingperiodstatus = checkAccountPeriodStatus(threadID, tempList, pathLoc, Previous_Accounting_period, expectedperiodstatus);
			
			if(checkaccountingperiodstatus) {
				
				String expectedAccountingPeriodStatus = "Open";

				boolean actualAccountingPeriodStatus = false;

				try {
					actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLoc, AccountingPeriod,
							expectedAccountingPeriodStatus);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				System.out.println("actual status is " + actualAccountingPeriodStatus);

				if (actualAccountingPeriodStatus) {
				
				Account_creation(threadID, tempList, pathLoc);
				Billing_creation(threadID, tempList, pathLoc);
				Payable(threadID, tempList, pathLoc);
				Gl_Account_creation(threadID, tempList, pathLoc);
				TB_report(threadID, tempList, pathLoc);
				
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Acconting period "
							+ AccountingPeriod
							+ " expected to be open but the current status is closed, cannot continue with the testcase"
							 , browser, pathLoc + "\\" + testcasemethod, false);
				}
				
			}else {
				
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Accounting period " + Previous_Accounting_period + " status is not closed. Hence can not continue with the test case"
						 , browser, pathLoc + "\\" + testcasemethod, false);
			}
			
			
				
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Testcase2687" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
			
		return new T2687Page(browser);
			
	}

}
