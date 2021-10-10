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
public class T2701Page extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected T2701Page(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public T2701Page() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;

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
	
	@FindBy(xpath = "//tr[1]/td[4]/lightning-primitive-cell-factory[1]/span[1]/div[1]/lightning-formatted-url[1]")
	WebElement End_periodUrl;
	
	@FindBy(xpath = "//button[@name='Edit']")
	WebElement Edit;
	
	@FindBy(xpath = "//label[contains(text(),'Status')]")
	WebElement Status;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Save;
	
	@FindBy(xpath = "//label[contains(.,'Suppress Zero Amount Rows')]/span[@class='slds-checkbox_faux']")
	WebElement S_Z_A_R;
	
	@FindBy(xpath = "//button[@title='Run Report']")
	WebElement Run_report;
	
	//@FindBy(xpath = "//div[@class='slds-card__body']//tbody/tr[1]/th//a") (//div[@class='slds-truncate']//a[contains(.,'FRR-')])[1]
	@FindBy(xpath = "(//tr[1]//div[@class='slds-truncate']//a[contains(.,'FRR-')])[1]/parent::*")
	WebElement Gen_report;
	
	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();

	String billing_line_new = null, billing_line_pass =null;

	/***
	 * Test case Method Name : validateTestA 
	 * Functionality : validate T2701 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2701Page validateTestA(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
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
		
		return new T2701Page(browser);
		
	}

	/***
	 * Test case Method Name : validateTestB
	 * Functionality : validate T2701 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2701Page validateTestB(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String s_report = reusableComponents.getPropValues("selectreport_2701");
			String ledger = reusableComponents.getPropValues("ledg_2701");
			String s_period = reusableComponents.getPropValues("stperiod_2701");
			String e_period = reusableComponents.getPropValues("endperiod_2701");
			
			ReusableComponents.wait(8200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"/"+testcasemethod, true);
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

				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Financial Reports tab is present", browser ,pathLoc+"/"+testcasemethod , false);
				ReusableComponents.wait(4200);
				Reports.click();
				ReusableComponents.wait(4200);
				browser.navigate().refresh();
				ReusableComponents.wait(4200);
				browser.navigate().refresh();
				ReusableComponents.wait(9200);

				if (ReusableComponents.isElementPresent(Select_report_type)) {
					
					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Financial Reports type selectbox is present", browser ,pathLoc+"/"+testcasemethod , false);
					ReusableComponents.wait(5200);
					Select_report_type.click();
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
						Ledger.click();
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Ledger searchbox is present", browser ,pathLoc+"/"+testcasemethod , false);
						ReusableComponents.wait(6200);
						
						WebElement ledger_click = browser.findElement(By.xpath("//span[@title='"+ledger+"']"));
						ReusableComponents.wait(3200);
						ledger_click.click();
						
						ReusableComponents.wait(3200);
						deselect_speriod.click();
						ReusableComponents.wait(3200);
						deselect_eperiod.click();
											
						if (ReusableComponents.isElementPresent(Starting_period)) {

							ReusableComponents.wait(5200);
							Starting_period.sendKeys(s_period);
							
							ReusableComponents.reportPass( threadID , tempList , testcasemethod , "start period searchbox is present", browser ,pathLoc+"/"+testcasemethod , false);
							ReusableComponents.wait(5200);
							
							WebElement start_click = browser.findElement(By.xpath("//span[contains(text(),'"+s_period+"')]"));
							start_click.click();						
							System.out.println("start selected");
							ReusableComponents.wait(5200);
							
							
					
							if (ReusableComponents.isElementPresent(End_period)) {

								ReusableComponents.wait(5200);
								
								End_period.sendKeys(e_period);
								ReusableComponents.reportPass( threadID , tempList , testcasemethod , "end period searchbox is present", browser ,pathLoc+"/"+testcasemethod , false);
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
								
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of balance sheet report page", browser, pathLoc+"/"+testcasemethod, true);
						
								if (ReusableComponents.isElementPresent(Run_report)) {

									ReusableComponents.reportPass( threadID , tempList , testcasemethod , "run report button is present", browser ,pathLoc+"/"+testcasemethod , false);
									ReusableComponents.wait(5200);
									Run_report.click();
									ReusableComponents.wait(15200);

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "run report button NOT present", browser, pathLoc + "/" + testcasemethod, true);
									}
								
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "end period searchbox NOT present", browser, pathLoc + "/" + testcasemethod, true);
								}
							
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "start period searchbox NOT present", browser, pathLoc + "/" + testcasemethod, true);
							}
						
						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "ledger searchbox NOT present", browser, pathLoc + "/" + testcasemethod, true);
						}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Financial Reports type selectbox NOT present", browser, pathLoc + "/" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Financial Reports tab NOT present", browser, pathLoc + "/" + testcasemethod, true);
			}
			
			browser.switchTo().defaultContent();

		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		
			}
		
		return new T2701Page(browser);
		
	}
	
	/***
	 * Test case Method Name : validateTestC
	 * Functionality : validate T2701 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2701Page validateTestC(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
		
			ReusableComponents.wait(5500);
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(20200);

			if (ReusableComponents.isElementPresent(Gen_report)) {
				
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Balance Sheet generated report tabledata is present", browser ,pathLoc+"/"+testcasemethod , false);
				ReusableComponents.wait(4200);
				Gen_report.click();
				ReusableComponents.wait(6200);
	
				ArrayList<String> tabs2 = new ArrayList<String> (browser.getWindowHandles());
				browser.switchTo().window(tabs2.get(1));
				ReusableComponents.wait(5200);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of generated report page", browser, pathLoc+"/"+testcasemethod, true);
				ReusableComponents.wait(6200);
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
				ReusableComponents.wait(4200);
				WebElement element = browser.findElement(By.xpath("//th//span[@title='2020-12']"));
				((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
				ReusableComponents.wait(4200);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of generated reports warning message", browser, pathLoc+"/"+testcasemethod, true);				
				ReusableComponents.wait(4200);
				browser.close();
				ReusableComponents.wait(4200);
				browser.switchTo().window(tabs2.get(0));
				
				ReusableComponents.wait(4200);
				End_periodUrl.click();
				ArrayList<String> tabs3 = new ArrayList<String> (browser.getWindowHandles());
				browser.switchTo().window(tabs3.get(1));
				ReusableComponents.wait(4200);
				periodEdit(threadID, tempList, pathLoc);
				ReusableComponents.wait(4200);
				browser.close();
				ReusableComponents.wait(4200);
				browser.switchTo().window(tabs3.get(0));
				
				ReusableComponents.wait(4200);
				Rerun(threadID, tempList, pathLoc);
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
				ReusableComponents.wait(30500);
				Gen_report.click();
				ArrayList<String> tabs4 = new ArrayList<String> (browser.getWindowHandles());
				browser.switchTo().window(tabs4.get(1));
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Balance Sheet generated report tabledata is present", browser ,pathLoc+"/"+testcasemethod , false);
				ReusableComponents.wait(8200);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of generated report page", browser, pathLoc+"/"+testcasemethod, true);
				ReusableComponents.wait(6200);
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
				ReusableComponents.wait(4200);
				WebElement elements = browser.findElement(By.xpath("//th//span[@title='2020-12']"));
				((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", elements);
				ReusableComponents.wait(4200);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of generated reports warning message", browser, pathLoc+"/"+testcasemethod, true);				
				ReusableComponents.wait(4200);
				browser.close();
				ReusableComponents.wait(4200);
				browser.switchTo().window(tabs4.get(0));
				//browser.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
				
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Balance Sheet generated report tabledata NOT present", browser, pathLoc + "/" + testcasemethod, true);
			}

		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		
		}
		
		return new T2701Page(browser);
		
	}
	
	/***
	 * Test case Method Name : periodEdit
	 * Functionality : validate T2701 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2701Page periodEdit(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
		
			String per_stat = reusableComponents.getPropValues("nstat");
			ReusableComponents.wait(8500);
			
			if (ReusableComponents.isElementPresent(Edit)) {
				
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Edit button is present", browser ,pathLoc+"/"+testcasemethod , false);
				ReusableComponents.wait(5200);
				Edit.click();
				ReusableComponents.wait(5500);

				if (ReusableComponents.isElementPresent(Status)) {

					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Status selectbox is present", browser ,pathLoc+"/"+testcasemethod , false);
					ReusableComponents.wait(3200);
					Status.click();
					ReusableComponents.wait(5500);

					String P_stat = "//span[@title='"+per_stat+"']";
					
					WebElement selecttype = browser.findElement(By.xpath(P_stat));
					ReusableComponents.wait(5500);
					selecttype.click();
					System.out.println("Accounting period status present");
					ReusableComponents.wait(5500);
					
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Editing Accounting period", browser, pathLoc+"/"+testcasemethod, true);
					
					if (ReusableComponents.isElementPresent(Save)) {
						
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Save button is present", browser ,pathLoc+"/"+testcasemethod , false);
						ReusableComponents.wait(5200);
						Save.click();
						ReusableComponents.wait(66500);
						

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present ", browser, pathLoc + "/" + testcasemethod, true);
					}
					
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Status selectbox is NOT present ", browser, pathLoc + "/" + testcasemethod, true);
				}
				
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Edit button is NOT present ", browser, pathLoc + "/" + testcasemethod, true);
			}

		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		
		}
		
		return new T2701Page(browser);
		
	}
	
	/***
	 * Test case Method Name : Rerun
	 * Functionality : validate T2701 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2701Page Rerun(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
		
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
			ReusableComponents.wait(5200);
			
			String s_report = reusableComponents.getPropValues("selectreport");
			String ledger = reusableComponents.getPropValues("ledg");
			String s_period = reusableComponents.getPropValues("stperiod");
			String e_period = reusableComponents.getPropValues("endperiod");
			ReusableComponents.wait(5200);

			ReusableComponents.wait(4200);
			browser.navigate().refresh();
			ReusableComponents.wait(4200);
			browser.navigate().refresh();
			ReusableComponents.wait(9200);

			if (ReusableComponents.isElementPresent(Select_report_type)) {
					
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Financial Reports type selectbox is present", browser ,pathLoc+"/"+testcasemethod , false);
				ReusableComponents.wait(5200);
				Select_report_type.click();
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
						Ledger.click();
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Ledger searchbox is present", browser ,pathLoc+"/"+testcasemethod , false);
						ReusableComponents.wait(6200);
					
						WebElement ledger_click = browser.findElement(By.xpath("//span[@title='"+ledger+"']"));
						ReusableComponents.wait(3200);
						ledger_click.click();
						
						ReusableComponents.wait(3200);
						deselect_speriod.click();
						ReusableComponents.wait(3200);
						deselect_eperiod.click();
											
						if (ReusableComponents.isElementPresent(Starting_period)) {

							ReusableComponents.reportPass( threadID , tempList , testcasemethod , "start period searchbox is present", browser ,pathLoc+"/"+testcasemethod , false);
							ReusableComponents.wait(5200);
							Starting_period.sendKeys(s_period);
							ReusableComponents.wait(5200);
							
							WebElement start_click = browser.findElement(By.xpath("//span[contains(text(),'"+s_period+"')]"));
							start_click.click();						
							System.out.println("start selected");
							ReusableComponents.wait(5200);
							
							if (ReusableComponents.isElementPresent(End_period)) {

								ReusableComponents.wait(5200);
								
								End_period.sendKeys(e_period);
								ReusableComponents.reportPass( threadID , tempList , testcasemethod , "end period searchbox is present", browser ,pathLoc+"/"+testcasemethod , false);
								ReusableComponents.wait(6200);
								
								WebElement end_click = browser.findElement(By.xpath("//span[contains(text(),'"+e_period+"')]"));
								end_click.click();
								System.out.println("end selected");
								ReusableComponents.wait(5200);

									if (S_Z_A_R.isSelected()) {
							
										ReusableComponents.wait(4200);
										S_Z_A_R.click();
										ReusableComponents.wait(4200);
									
									} else {
								
									System.out.println("Suppress zero amount is already selected");
									}
								
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of balance sheet report page", browser, pathLoc+"/"+testcasemethod, true);
						
										if (ReusableComponents.isElementPresent(Run_report)) {

											ReusableComponents.reportPass( threadID , tempList , testcasemethod , "run report button is present", browser ,pathLoc+"/"+testcasemethod , false);
											ReusableComponents.wait(5200);
											Run_report.click();
											ReusableComponents.wait(15200);

										} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "run report button NOT present", browser, pathLoc + "/" + testcasemethod, true);
										}
								
									} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "end period searchbox NOT present", browser, pathLoc + "/" + testcasemethod, true);
									}
							
								} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "start period searchbox NOT present", browser, pathLoc + "/" + testcasemethod, true);
								}
						
						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "ledger searchbox NOT present", browser, pathLoc + "/" + testcasemethod, true);
						}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Financial Reports type selectbox NOT present", browser, pathLoc + "/" + testcasemethod, true);
				}

		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		
		}
		
		return new T2701Page(browser);
		
	}
	
}
