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
public class T2694Page extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected T2694Page(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public T2694Page() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;
	
	@FindBy(xpath = "//button[@name='Edit']")
	//@FindBy(xpath = ".//*[@class='slds-button-group-list']//button[@name='Edit']")
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
	
	@FindBy(xpath = "//button[.='Select List View']")
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

	int previousYearClose, Nextyear; String per_stat;

	/***
	 * Test case Method Name : validateTestA 
	 * Functionality : validate T2694 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2694Page validateTestA(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
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
		
		return new T2694Page(browser);
		
	}
	
	/***
	 * Test case Method Name : previousperiodclose
	 * Functionality : validate T2694 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2694Page previousperiodclose(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String acc_period = reusableComponents.getPropValues("accpymC");
			per_stat = reusableComponents.getPropValues("pstat");
			String last_period = null;
			String strArray[] = acc_period.split("-");
	        String yearValue = strArray[0];
	        int year =  Integer. parseInt(strArray[0]);
	        int month =  Integer. parseInt(strArray[1]);
	           
	        previousYearClose = year-1; // call previous year account period close method
	        
	        previousyearclose(threadID, tempList, pathLoc);
			
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
			
			for(j=1;j<=month;j++) {
					
				String monthValue = null;
				
                if(j<=9) {
                    monthValue="0"+j;
                } else {
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
			
		System.out.println(last_period+" is th ending period of year "+acc_period);

		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);
		
			}
		
		return new T2694Page(browser);
		
	}
	
	/***
	 * Test case Method Name : previousyearclose
	 * Functionality : validate T2694 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2694Page previousyearclose(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String last_period = null;
			ReusableComponents.wait(5200);
			//ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"\\"+testcasemethod, true);
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
		
		return new T2694Page(browser);
		
	}
	
	/***
	 * Test case Method Name : currentperiodopen
	 * Functionality : validate T2694 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2694Page currentperiodopen(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String acc_period = reusableComponents.getPropValues("accpymO");
			per_stat = reusableComponents.getPropValues("nstat");
			String last_period = null;
			String strArray[] = acc_period.split("-");
	        String yearValue = strArray[0];
	        int year =  Integer. parseInt(strArray[0]);
	        int month =  Integer. parseInt(strArray[1]);
	           	
	        ReusableComponents.wait(5200);
			//ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"\\"+testcasemethod, true);
			ReusableComponents.wait(3200);
			
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
		
		return new T2694Page(browser);
		
	}

	/***
	 * Test case Method Name : Nextyearopen
	 * Functionality : validate T2694 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2694Page Nextyearopen(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
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
		
		return new T2694Page(browser);
		
	}
	
	/***
	 * Test case Method Name : RunreportTB
	 * Functionality : validate T2694 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2694Page RunreportTB(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(10200);
			
			String s_report = reusableComponents.getPropValues("selectreport1");
			String ledger = reusableComponents.getPropValues("ledg");
			String a_period = reusableComponents.getPropValues("accpymO");
			
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
							
							ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Ledger searchbox is present", browser ,pathLoc+"\\"+testcasemethod , false);
							ReusableComponents.wait(4200);
							Ledger.sendKeys(ledger);
							ReusableComponents.wait(6200);
						
							WebElement ledger_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+ledger+"']"));
							ReusableComponents.wait(6200);
							ledger_click.click();
						
							ReusableComponents.wait(3200);
							deselect_period.click();
						
											
							if (ReusableComponents.isElementPresent(Accounting_period)) {

								ReusableComponents.reportPass( threadID , tempList , testcasemethod , "accounting period searchbox is present", browser ,pathLoc+"\\"+testcasemethod , false);
								ReusableComponents.wait(5200);
								Accounting_period.sendKeys(a_period);
								ReusableComponents.wait(5200);
							
								WebElement start_click = browser.findElement(By.xpath("//span[contains(text(),'"+a_period+"')]"));
								start_click.click();						
								System.out.println("start selected");
								ReusableComponents.wait(5200);
								
								if (S_Z_A_R.isSelected() == false) {
									
									ReusableComponents.wait(4200);
									S_Z_A_R.click();
									ReusableComponents.wait(4200);
									System.out.println("Suppress zero amount checkbox is unchecked");
									
								} else {
								
									System.out.println("Suppress zero amount is already selected");
								}
							
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of balance sheet report page", browser, pathLoc+"\\"+testcasemethod, true);
								ReusableComponents.wait(5200);
							
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

		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);
		
			}
		
		return new T2694Page(browser);
		
	}
	
}
