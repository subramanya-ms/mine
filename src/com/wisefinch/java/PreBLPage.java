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

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;

/**
 * Base class for all the pages.
 *
 */
public class PreBLPage extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected PreBLPage(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public PreBLPage() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;

	@FindBy(xpath = "//img[@title='Accounting Periods']")
	WebElement Accounting_period;
	
	@FindBy(xpath = "//a[normalize-space()='2020-07']")
	WebElement Account_period;
	
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
	
	@FindBy(xpath = "//span[.='Start Date']")
	WebElement sd_filter;
	
	
	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();

	/***
	 * Test case Method Name : validateTestA 
	 * Functionality : validate PreBL Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized PreBLPage validateTestA(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String username = null, pass_login = null;

			// browser.switchTo().defaultContent();

			username = reusableComponents.getPropValues("usernamesf");
			pass_login = reusableComponents.getPropValues("passwordsf");

			ReusableComponents.wait(2300);

			if (ReusableComponents.isElementPresent(Username_field)) {

				ReusableComponents.wait(3200);
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login username field is present", browser ,pathLoc+"/"+testcasemethod , false);

				Username_field.sendKeys(username);

				if (ReusableComponents.isElementPresent(Password_field)) {

					Password_field.sendKeys(pass_login);
					ReusableComponents.wait(3200);
					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login password field is present", browser ,pathLoc+"/"+testcasemethod , false);

					if (ReusableComponents.isElementPresent(Login_button)) {
						
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Login page", browser, pathLoc+"/"+testcasemethod, true);
						ReusableComponents.wait(3200);
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
		
		return new PreBLPage(browser);
		
	}
		
	/***
	 * Test case Method Name : validateTestB
	 * Functionality : validate PreBL Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized PreBLPage validateTestB(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			
			String acc_period = reusableComponents.getPropValues("paccperiod");
			String per_stat = reusableComponents.getPropValues("pstat");
			String last_period = null;
			ReusableComponents.wait(5200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"/"+testcasemethod, true);
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
			
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting period page", browser, pathLoc+"/"+testcasemethod, true);
			
			int j=1; String acct_period=null;
			
			for(j=1;j<=12;j++) {
					
				if(j==10 || j==11 || j==12) {
					
					acct_period = acc_period+"-"+j;
					
				} else {
					
					acct_period = acc_period+"-"+"0"+j;
					
				}
				
				last_period = acct_period;
				String Period = "//a[@title='"+acct_period+"']";
				
				try {
					ReusableComponents.wait(5500);
					System.out.println("main try");
					
					try {
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
//
//							Actions q = new Actions(browser);
//							q.moveToElement(Edit).build().perform();
//							q.click().perform();
//							JavascriptExecutor executor = (JavascriptExecutor) browser;
//							executor.executeScript("arguments[0].click();", Edit);
//							new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(Edit)).click();
								Edit.click();
								ReusableComponents.wait(5500);
								ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Edit button is present", browser ,pathLoc+"/"+testcasemethod , false);

								if (ReusableComponents.isElementPresent(Status)) {
									
									ReusableComponents.wait(3200);
									Status.click();
									ReusableComponents.wait(5500);
									ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Status selectbox is present", browser ,pathLoc+"/"+testcasemethod , false);

									String P_stat = "//span[@title='"+per_stat+"']";
									
									WebElement selecttype = browser.findElement(By.xpath(P_stat));
									ReusableComponents.wait(5500);
									selecttype.click();
									System.out.println("Accounting period status present");
									ReusableComponents.wait(5500);
									
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Editing Accounting period", browser, pathLoc+"/"+testcasemethod, true);
									
									if (ReusableComponents.isElementPresent(Save)) {
										
										ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Save button is present", browser ,pathLoc+"/"+testcasemethod , false);
										ReusableComponents.wait(7200);
										Save.click();
										ReusableComponents.wait(6500);
										

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present ", browser, pathLoc + "/" + testcasemethod, true);
									}
									
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Status selectbox is NOT present ", browser, pathLoc + "/" + testcasemethod, true);
								}
								
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Edit button is NOT present ", browser, pathLoc + "/" + testcasemethod, true);
							}
							
						} catch (Exception c) {
							
							System.out.println("period not edited first "+c.getMessage());
						}
						
						System.out.println("Closing period in progress");
						ReusableComponents.wait(66500);

//						try {
//							
//							if (ReusableComponents.isElementPresent(Edit)) {
//								
//								ReusableComponents.wait(3200);
////							Actions q = new Actions(browser);
////							q.moveToElement(Edit).build().perform();
////							q.click().perform();
////							JavascriptExecutor executor = (JavascriptExecutor) browser;
////							executor.executeScript("arguments[0].click();", Ed_it);
////							new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(Edit)).click();
//								Edit.click();
//								ReusableComponents.wait(5500);
//								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting period edit page", browser, pathLoc+"/"+testcasemethod, true);
//								ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Edit button is present", browser ,pathLoc+"/"+testcasemethod , false);
//
//								if (ReusableComponents.isElementPresent(Status)) {
//									
//									ReusableComponents.wait(3200);
//									Status.click();
//									ReusableComponents.wait(5500);
//									ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Status selectbox is present", browser ,pathLoc+"/"+testcasemethod , false);
//
//									String P_stat = "//span[@title='"+per_stat+"']";
//									
//									WebElement selecttype = browser.findElement(By.xpath(P_stat));
//									ReusableComponents.wait(5500);
//									new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(selecttype)).click();
//									System.out.println("Accounting period status present");
//									ReusableComponents.wait(5500);
//									
//									if (ReusableComponents.isElementPresent(Save)) {
//										
//										ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Save button is present", browser ,pathLoc+"/"+testcasemethod , false);
//										ReusableComponents.wait(7200);
//										Save.click();
//										ReusableComponents.wait(65500);
//										
//
//									} else {
//										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present ", browser, pathLoc + "/" + testcasemethod, true);
//									}
//									
//								} else {
//									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Status selectbox is NOT present ", browser, pathLoc + "/" + testcasemethod, true);
//								}
//								
//							} else {
//								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Edit button is NOT present ", browser, pathLoc + "/" + testcasemethod, true);
//							}
//							
//						} catch (Exception d) {
//							
//							System.out.println("period not edited second "+d.getMessage());
//						}
						
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
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			
		}

	return new PreBLPage(browser);

}
		
	/***
	 * Test case Method Name : validateTestC
	 * Functionality : validate PreBL Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized PreBLPage validateTestC(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			
			String acc_period = reusableComponents.getPropValues("naccperiod");
			String per_stat = reusableComponents.getPropValues("nstat");
			String start_period = null;
			ReusableComponents.wait(5200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"/"+testcasemethod, true);
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
			
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting period page", browser, pathLoc+"/"+testcasemethod, true);
			
			int j=12; String acct_period=null;
			
			for(j=12;j>=1;j--) {
					
				if(j==10 || j==11 || j==12) {
					
					acct_period = acc_period+"-"+j;
					
				} else {
					
					acct_period = acc_period+"-"+"0"+j;
					
				}
				
				start_period = acct_period;
				String Period = "//a[@title='"+acct_period+"']";
				
				try {
					ReusableComponents.wait(5500);
					System.out.println("main try");
					
					try {
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
							
							System.out.println("Closed to be opened");
						
						try {
							
							if (ReusableComponents.isElementPresent(Edit)) {
								
								ReusableComponents.wait(10200);
								Edit.click();
								ReusableComponents.wait(5500);
								ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Edit button is present", browser ,pathLoc+"/"+testcasemethod , false);

								if (ReusableComponents.isElementPresent(Status)) {
									
									ReusableComponents.wait(3200);
									Status.click();
									ReusableComponents.wait(5500);
									ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Status selectbox is present", browser ,pathLoc+"/"+testcasemethod , false);

									String P_stat = "//span[@title='"+per_stat+"']";
									
									WebElement selecttype = browser.findElement(By.xpath(P_stat));
									ReusableComponents.wait(5500);
									selecttype.click();
									System.out.println("Accounting period status present");
									ReusableComponents.wait(5500);
									
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Editing Accounting period", browser, pathLoc+"/"+testcasemethod, true);
									
									if (ReusableComponents.isElementPresent(Save)) {
										
										ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Save button is present", browser ,pathLoc+"/"+testcasemethod , false);
										ReusableComponents.wait(7200);
										Save.click();
										ReusableComponents.wait(6500);
										

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present ", browser, pathLoc + "/" + testcasemethod, true);
									}
									
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Status selectbox is NOT present ", browser, pathLoc + "/" + testcasemethod, true);
								}
								
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Edit button is NOT present ", browser, pathLoc + "/" + testcasemethod, true);
							}
							
						} catch (Exception c) {
							
							System.out.println("period not edited "+c.getMessage());
						}
						
						System.out.println("Opening period in progress");
						ReusableComponents.wait(66500);
						
						}else {
							
							System.out.println("period is opened or archived");
							
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
			
		System.out.println(start_period+" is th starting period of year "+acc_period);
			
		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			
		}

	return new PreBLPage(browser);

}
	
}
