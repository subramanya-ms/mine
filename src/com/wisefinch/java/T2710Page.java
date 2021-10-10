package com.wisefinch.java;

import static org.testng.Assert.assertEquals;

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
public class T2710Page extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected T2710Page(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public T2710Page() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;

	@FindBy(xpath = "//button[@name='Edit']")
	WebElement Edit;
	
	@FindBy(xpath = "//label[contains(text(),'Status')]")
	WebElement Status;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Save;
	
	@FindBy(xpath = "//slot[@slot='secondaryFields']//lightning-formatted-text[.='Closed']")
	WebElement Closed_Status;
	
	@FindBy(xpath = "//slot[@slot='secondaryFields']//lightning-formatted-text[.='Open']")
	WebElement Open_Status;
	
	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	WebElement Home;
	
	@FindBy(xpath = "//input[@placeholder='Search apps and items...']")
	WebElement Input;
	
	@FindBy(xpath = ".//*[@class='slds-truncate']//*[contains(text(),'Accounting Periods')]")
	WebElement click_ap;
	
	@FindBy(xpath = "//button[@title='Select List View']")
	WebElement listview;
	
	@FindBy(xpath = "//span[contains(.,'All')][contains(@class,'virtualAutocompleteOptionText')]")
	WebElement all_list;
	
	@FindBy(xpath = "//img[@title=' Financial Reports']")
	WebElement Reports;

	@FindBy(xpath = "//button[contains(text(),'Select Standard Report')]")
	WebElement Select_report_type;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search Ledgers...')]")
	WebElement Ledger;
	
	@FindBy(xpath = "//button[contains(@title,'Clear Selection')]/lightning-primitive-icon")
	WebElement Ledger_close;
	
	@FindBy(xpath = "//c-lookup[contains(.,'*Starting Accounting Period')]//input[@role='textbox']")
	WebElement Starting_period;
	
	@FindBy(xpath = "(.//*[@title='Remove selected option'])[1]")
	WebElement deselect_speriod;
	
	@FindBy(xpath = "(.//*[@title='Remove selected option'])[2]")
	WebElement deselect_eperiod;
	
	@FindBy(xpath = "//c-lookup[@data-jest='endingAccountingPeriod']//input[@role='textbox']")
	WebElement End_period;
	
	@FindBy(xpath = "//label[contains(.,'Suppress Zero Amount Rows')]/span[@class='slds-checkbox_faux']")
	WebElement S_Z_A_R;
	
	@FindBy(xpath = "//button[@title='Run Report']")
	WebElement Run_report;

	@FindBy(xpath = "(//tr[1]//div[@class='slds-truncate']//a)[1]")
	WebElement Gen_report;
	
	@FindBy(xpath = "(//tr[1]//div[@class='slds-truncate']//a)[1]/parent::*")
	WebElement Cur_report;
	
	@FindBy(xpath = "//span[@class='uiImage']/img[@src='/img/icon/t4v35/custom/custom14_120.png']")
	WebElement Payee_tab;

	@FindBy(xpath = "//div[@title='New']")
	WebElement New;

	@FindBy(xpath = "//div[@class='slds-form']//force-record-layout-row[3]//force-record-layout-item//lightning-combobox//input[@class='slds-input slds-combobox__input']")
	WebElement Posting_status;

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

	@FindBy(xpath = "//button[.='Post']")
	WebElement Post;

	@FindBy(xpath = "//div[@class='pbHeader']//tbody//input[@value='Post']")
	WebElement Post_final;
	
	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();

	int Payable_amount,previousYearClose,Nextyear; String per_stat;

	/***
	 * Test case Method Name : validateTestA 
	 * Functionality : validate T2710 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2710Page validateTestA(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
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
						ReusableComponents.wait(15500);
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login button is present", browser ,pathLoc+"\\"+testcasemethod , false);

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login button is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login password field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login username field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
			}

		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);
		
			}
		
		return new T2710Page(browser);
		
	}

	/***
	 * Test case Method Name : PeriodClose 
	 * Functionality : validate T2710 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2710Page PeriodClose(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String acc_period = reusableComponents.getPropValues("forpls");
			per_stat = reusableComponents.getPropValues("pstat");
			String strArray[] = acc_period.split("-");
	        String yearValue = strArray[0];
	        int year =  Integer. parseInt(strArray[0]);
	        int month =  Integer. parseInt(strArray[1]);
	           
	        previousYearClose = year-1; // call previous year account period close method
	        
	        prev_periodclose(threadID, tempList, pathLoc);
			
	        ReusableComponents.wait(5200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"\\"+testcasemethod, true);
			ReusableComponents.wait(3200);
			
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
			
			for(j=1;j<=12;j++) {
					
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

		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);
		
			}
		
		return new T2710Page(browser);
		
	}
	
	/***
	 * Test case Method Name : prev_periodclose 
	 * Functionality : validate T2710 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2710Page prev_periodclose(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String last_period = null;
			ReusableComponents.wait(5200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"\\"+testcasemethod, true);
			ReusableComponents.wait(3200);
			
			browser.navigate().refresh();
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

		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);
		
			}
		
		return new T2710Page(browser);
		
	}
	
	/***
	 * Test case Method Name : Currentperiodopen
	 * Functionality : validate T2710 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2710Page Currentperiodopen(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			
			String acc_period = reusableComponents.getPropValues("forple");
			per_stat = reusableComponents.getPropValues("nstat");
			String last_period = null;
			String strArray[] = acc_period.split("-");
	        String yearValue = strArray[0];
	        int year =  Integer. parseInt(strArray[0]);
	        int month =  Integer. parseInt(strArray[1]);
	         
	        Nextyear = year+1;
	        
	        Nextyearopen(threadID, tempList, pathLoc);
	        
	        ReusableComponents.wait(5200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"\\"+testcasemethod, true);
			ReusableComponents.wait(3200);
			
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
			
		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);
			
		}

	return new T2710Page(browser);

}
	
	/***
	 * Test case Method Name : Nextyearopen
	 * Functionality : validate T2710 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2710Page Nextyearopen(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
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
			
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting period page", browser, pathLoc+"\\"+testcasemethod, true);
			
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
			
		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);
			
		}

	return new T2710Page(browser);

}
	
	/***
	 * Test case Method Name : PLreport
	 * Functionality : validate T2710 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2710Page PLreport(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(6200);
			
			String s_period = reusableComponents.getPropValues("stperiod");
			String e_period = reusableComponents.getPropValues("endperiod");
			
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

						ReusableComponents.wait(3200);
						deselect_speriod.click();
						ReusableComponents.wait(3200);
						deselect_eperiod.click();
											
						if (ReusableComponents.isElementPresent(Starting_period)) {

							ReusableComponents.wait(5200);
							Starting_period.sendKeys(s_period);
							
							ReusableComponents.reportPass( threadID , tempList , testcasemethod , "start period searchbox is present", browser ,pathLoc+"\\"+testcasemethod , false);
							ReusableComponents.wait(5200);
							
							WebElement start_click = browser.findElement(By.xpath("//span[contains(text(),'"+s_period+"')]"));
							start_click.click();						
							System.out.println("start selected");
							ReusableComponents.wait(5200);
							
							
					
							if (ReusableComponents.isElementPresent(End_period)) {

								ReusableComponents.wait(5200);
								
								End_period.sendKeys(e_period);
								ReusableComponents.reportPass( threadID , tempList , testcasemethod , "end period searchbox is present", browser ,pathLoc+"\\"+testcasemethod , false);
								ReusableComponents.wait(6200);
								
								WebElement end_click = browser.findElement(By.xpath("//span[contains(text(),'"+e_period+"')]"));
								end_click.click();
								System.out.println("end selected");
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
									
									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "run report button NOT present", browser, pathLoc + "\\" + testcasemethod, true);
									}
								
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "end period searchbox NOT present", browser, pathLoc + "\\" + testcasemethod, true);
								}
							
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "start period searchbox NOT present", browser, pathLoc + "\\" + testcasemethod, true);
							}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Financial Reports tab NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}
			
			browser.switchTo().defaultContent();

		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);
		
			}
		
		return new T2710Page(browser);
		
	}
	
	/***
	 * Test case Method Name : Gettotalincome
	 * Functionality : validate T2710 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2710Page Gettotalincome(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
	
	ReusableComponents.wait(5200);

	if (ReusableComponents.isElementPresent(Cur_report)) {
		
		ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Balance Sheet generated report tabledata is present", browser ,pathLoc+"\\"+testcasemethod , false);
		ReusableComponents.wait(4200);
		Cur_report.click();
		ReusableComponents.wait(6200);

		ArrayList<String> tabs = new ArrayList<String> (browser.getWindowHandles());
		browser.switchTo().window(tabs.get(1));
		ReusableComponents.wait(5200);
		ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of generated P&L report page", browser, pathLoc+"\\"+testcasemethod, true);
		ReusableComponents.wait(6200);
		WebElement element = browser.findElement(By.xpath("//th//span[@title='Total']"));
		List<WebElement> f = browser.findElements(By.xpath("//th[@data-label='Net Income']//following::td"));
		int i = f.size();
		((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
		ReusableComponents.wait(4200);
		WebElement Totalincome = browser.findElement(By.xpath("//th[@data-label='Net Income']//following::td["+i+"]//lightning-formatted-text"));
		String Str = Totalincome.getText();
		System.out.println("Net income from P&L report "+Str);
		char Ch1 = Str.charAt(0);
		System.out.println("first charector  "+Ch1);
		if(Ch1=='(') {
		Payable_amount = 5000;
		} else {
		Payable_amount = Integer.parseInt(Str)+5000;
		}
		System.out.println("Amount to be payed "+Payable_amount);
		
		ReusableComponents.wait(4200);
		browser.close();
		ReusableComponents.wait(4200);
		browser.switchTo().window(tabs.get(0));

	} else {
		ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Balance Sheet generated report tabledata NOT present", browser, pathLoc + "\\" + testcasemethod, true);
	}
	
} catch (NoSuchElementException e) {
	
	ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);

	}

return new T2710Page(browser);

}

	/***
	 * Test case Method Name : Payable
	 * Functionality : validate T2710 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2710Page Payable(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(6200);
	
			String status_p = reusableComponents.getPropValues("postingstatus");
			String account_name = reusableComponents.getPropValues("vendor");
			String pref = reusableComponents.getPropValues("ref");
			String period = reusableComponents.getPropValues("forple");

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"\\"+testcasemethod, true);
			ReusableComponents.wait(3200);

			List<WebElement> f = browser.findElements(By.tagName("frame"));
			int i = f.size();
			System.out.println(i + "is the frame count");

			browser.switchTo().frame(0);

			ReusableComponents.wait(6200);

			if (ReusableComponents.isElementPresent(Payee_tab)) {

				ReusableComponents.wait(3200);
				Payee_tab.click();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Payable tab is present", browser, pathLoc + "\\" + testcasemethod, false);
				ReusableComponents.wait(5500);

				if (ReusableComponents.isElementPresent(New)) {
					
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Payables page", browser, pathLoc+"\\"+testcasemethod, true);
					ReusableComponents.wait(3200);
					New.click();
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New Payable button is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(6500);

					if (ReusableComponents.isElementPresent(Posting_status)) {

						ReusableComponents.wait(5200);
						Posting_status.click();
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Payable Posting status selectbox is present", browser, pathLoc + "\\" + testcasemethod, false);
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

							ReusableComponents.wait(4200);
							Payee_Reference.sendKeys(pref);
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Payee Reference field is present", browser, pathLoc + "\\" + testcasemethod, false);
							ReusableComponents.wait(5500);

							if (ReusableComponents.isElementPresent(Vendor)) {

								ReusableComponents.wait(4200);
								Vendor.sendKeys(account_name);
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Vendor searchbox is present", browser, pathLoc + "\\" + testcasemethod, false);
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

			browser.switchTo().defaultContent();
	
		} catch (NoSuchElementException e) {
	
	ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);

	}

return new T2710Page(browser);

}

	/***
	 * Test case Method Name : Pline_posting
	 * Functionality : validate T2710 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2710Page Pline_posting(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String Amount = String.valueOf(Payable_amount);
			String expense_acc_name = reusableComponents.getPropValues("bank");
			
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of created payable page", browser, pathLoc+"\\"+testcasemethod, true);
			ReusableComponents.wait(5500);

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
//						List<WebElement> dropdownelement_gl = browser.findElements(By.xpath("//lightning-base-combobox-formatted-text[contains(@title,'" + expense_acc_name + "')]"));
//						int j = dropdownelement_gl.size();

//						System.out.println(j + " is the element count");

						System.out.println("Expense gl account selected");
						ReusableComponents.wait(5200);
						Exp_gla_click.click();
//						dropdownelement_gl.get(j-1).click();
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

	
} catch (NoSuchElementException e) {
	
	ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);

	}

return new T2710Page(browser);

}
	
	/***
	 * Test case Method Name : PeriodClose 
	 * Functionality : validate T2710 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2710Page EndperiodClose(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String acc_period = reusableComponents.getPropValues("forple");
			per_stat = reusableComponents.getPropValues("pstat");

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
			
			String Period = "//a[@title='"+acc_period+"']";
				
			try {
				ReusableComponents.wait(5500);
				System.out.println("main try");
				try {
					browser.findElement(By.xpath("//div[@data-aura-class='uiScroller']")).sendKeys(Keys.PAGE_DOWN);
					ReusableComponents.wait(5500);
					WebElement element = browser.findElement(By.xpath("//a[@title='"+acc_period+"']"));
					((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
					ReusableComponents.wait(5500);
					} catch (Exception e) {
						
					System.out.println(acc_period+" period not present");
					}
							
				if(ReusableComponents.isElementPresent(browser.findElement(By.xpath(Period)))) {
					
					System.out.println("period to be closed "+acc_period);
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
		
		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);
		
			}
		
		return new T2710Page(browser);
		
	}
	/***
	 * Test case Method Name : BL_Report
	 * Functionality : validate T2710 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2710Page BL_Report(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(6200);
	
			String s_report = reusableComponents.getPropValues("selectreport");
			String s_period = reusableComponents.getPropValues("forbls");
			String e_period = reusableComponents.getPropValues("forble");
			
			ReusableComponents.wait(8200);
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

				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Financial Reports tab is present", browser ,pathLoc+"\\"+testcasemethod , false);
				ReusableComponents.wait(4200);
				Reports.click();
				ReusableComponents.wait(4200);
				browser.navigate().refresh();
				ReusableComponents.wait(4200);
				browser.navigate().refresh();
				ReusableComponents.wait(9200);

				if (ReusableComponents.isElementPresent(Select_report_type)) {
					
					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Financial Reports type selectbox is present", browser ,pathLoc+"\\"+testcasemethod , false);
					ReusableComponents.wait(5200);
					Select_report_type.click();
					ReusableComponents.wait(6200);
					
					String report_type = "//span[.='"+s_report+"']";
					
					WebElement selecttype = browser.findElement(By.xpath(report_type));
					ReusableComponents.wait(6500);
					new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(selecttype)).click();
					ReusableComponents.wait(5500);
					
					ReusableComponents.wait(3200);
					deselect_speriod.click();
					ReusableComponents.wait(3200);
					deselect_eperiod.click();
											
					if (ReusableComponents.isElementPresent(Starting_period)) {

						ReusableComponents.wait(5200);
						Starting_period.sendKeys(s_period);
							
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "start period searchbox is present", browser ,pathLoc+"\\"+testcasemethod , false);
						ReusableComponents.wait(5200);
							
						WebElement start_click = browser.findElement(By.xpath("//span[contains(text(),'"+s_period+"')]"));
						start_click.click();						
						System.out.println("start selected");
						ReusableComponents.wait(5200);
					
						if (ReusableComponents.isElementPresent(End_period)) {

							ReusableComponents.wait(5200);
								
							End_period.sendKeys(e_period);
							ReusableComponents.reportPass( threadID , tempList , testcasemethod , "end period searchbox is present", browser ,pathLoc+"\\"+testcasemethod , false);
							ReusableComponents.wait(6200);
								
							WebElement end_click = browser.findElement(By.xpath("//span[contains(text(),'"+e_period+"')]"));
							end_click.click();
							System.out.println("end selected");
							ReusableComponents.wait(5200);

							if (S_Z_A_R.isSelected() == true) {
							
								ReusableComponents.wait(4200);
								S_Z_A_R.click();
								ReusableComponents.wait(4200);
									
							} else {
								
								System.out.println("Suppress zero amount is already selected");
							}
								
							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of balance sheet report page", browser, pathLoc+"\\"+testcasemethod, true);
					
							if (ReusableComponents.isElementPresent(Run_report)) {

								ReusableComponents.reportPass( threadID , tempList , testcasemethod , "run report button is present", browser ,pathLoc+"\\"+testcasemethod , false);
								ReusableComponents.wait(5200);
								Run_report.click();
								ReusableComponents.wait(15200);
								
								browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
								ReusableComponents.wait(15200);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of generated report page", browser, pathLoc+"\\"+testcasemethod, true);
								ReusableComponents.wait(5200);
								ReusableComponents.reportPass( threadID , tempList , testcasemethod , "report link is "+Gen_report.getAttribute("href")+" and report name is "+Gen_report.getText(), browser ,pathLoc+"\\"+testcasemethod , false);
								
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "run report button NOT present", browser, pathLoc + "\\" + testcasemethod, true);
								}
								
							} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "end period searchbox NOT present", browser, pathLoc + "\\" + testcasemethod, true);
							}
							
						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "start period searchbox NOT present", browser, pathLoc + "\\" + testcasemethod, true);
						}
						
				
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Financial Reports type selectbox NOT present", browser, pathLoc + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Financial Reports tab NOT present", browser, pathLoc + "\\" + testcasemethod, true);
				}
			
				browser.switchTo().defaultContent();
	
			} catch (NoSuchElementException e) {
	
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);

		}
		
		return new T2710Page(browser);

	}
	
	/***
	 * Test case Method Name : PLreportNew
	 * Functionality : validate T2710 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2710Page PLreportNew(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			//browser.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
			((JavascriptExecutor) browser).executeScript("window.open()");
			ReusableComponents.wait(6200);
			ArrayList<String> tabs = new ArrayList<String> (browser.getWindowHandles());
			browser.switchTo().window(tabs.get(1));
			
			PLreport(threadID, tempList, pathLoc);
			
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(15200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of generated report page", browser, pathLoc+"\\"+testcasemethod, true);
			ReusableComponents.wait(5200);
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "report link is "+Gen_report.getAttribute("href")+" and report name is "+Gen_report.getText(), browser ,pathLoc+"\\"+testcasemethod , false);
			
			
			browser.close();
			ReusableComponents.wait(4200);
			browser.switchTo().window(tabs.get(0));
	
			} catch (NoSuchElementException e) {
	
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);

		}
		
		return new T2710Page(browser);

	}
	
	/***
	 * Test case Method Name : Allmethodsorder
	 * Functionality : validate T2710 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2710Page Allmethodsorder(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			validateTestA(threadID, tempList, pathLoc);
			PeriodClose(threadID, tempList, pathLoc);
			Currentperiodopen(threadID, tempList, pathLoc);
			PLreport(threadID, tempList, pathLoc);
			Gettotalincome(threadID, tempList, pathLoc);
			Payable(threadID, tempList, pathLoc);
			Pline_posting(threadID, tempList, pathLoc);
			EndperiodClose(threadID, tempList, pathLoc);
			BL_Report(threadID, tempList, pathLoc);
			PLreportNew(threadID, tempList, pathLoc);
	
			} catch (NoSuchElementException e) {
	
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, true);

		}
		
		return new T2710Page(browser);

	}
	
}
