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
public class T2614Page extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected T2614Page(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public T2614Page() {
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
	
	@FindBy(xpath = "//label[contains(.,'Suppress Zero Amount Rows')]/span[@class='slds-checkbox_faux']")
	WebElement Suppress_Zero_Amount_Report;
	
	@FindBy(xpath = "//label[contains(.,'Include Sub Type 1')]/span[@class='slds-checkbox_faux']")
	WebElement Include_Subtype1;
	
	@FindBy(xpath = "//label[.='Include Sub Type 2']/span[@class='slds-checkbox_faux']")
	WebElement Include_Subtype2;
	
	@FindBy(xpath = "//button[@title='Run Report']")
	WebElement Run_report;

	@FindBy(xpath = "(//tr[1]//div[@class='slds-truncate']//a)[1]")
	WebElement Gen_report;
	
	@FindBy(xpath = "//div[@class='col-xs-4 header__left']")
	WebElement Homepagelogo;
	
	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();

	/***
	 * Test case Method Name : Login 
	 * Functionality : validate T2614 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException 
	 * 
	 ***/
	public synchronized T2614Page Login(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException, throwNewException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String username = null, pass_login = null;

			// browser.switchTo().defaultContent();

			username = reusableComponents.getPropValues("usernamesf");
			pass_login = reusableComponents.getPropValues("passwordsf");

			ReusableComponents.wait(2300);
			ReusableComponents.sendKey(Username_field, username, "Username field");
			ReusableComponents.sendKey(Password_field, pass_login, "password field");
			ReusableComponents.clickElement(Login_button, "pass login");
			
			ReusableComponents.wait(25200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"\\"+testcasemethod, true);
			ReusableComponents.wait(3200);
			 

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
			
		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Exception in Login" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, true);
		
			}
		
		return new T2614Page(browser);
		
	}

	/***
	 * Test case Method Name : PnLreport
	 * Functionality : validate T2614 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException 
	 * 
	 ***/
	public synchronized T2614Page PnLreport(int threadID, List<String> tempList, String pathLoc, String Startingperiod, String Endperiod) throws IOException, AWTException, throwNewException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			ReusableComponents.wait(5000);
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(5000);
			
			String starting_period = Startingperiod;
			String end_period = Endperiod;
		
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

			ReusableComponents.clickElement(Reports, "Financial Reports");
			ReusableComponents.wait(8200);
				
			browser.navigate().refresh();
			ReusableComponents.wait(4200);
			browser.navigate().refresh();
			ReusableComponents.wait(9200);
					
			ReusableComponents.clickElement(deselect_eperiod, "Deselect the Starting period selected");
			ReusableComponents.wait(3200);
			ReusableComponents.clickElement(deselect_speriod, "Deselect the Ending period selected");
			ReusableComponents.wait(3200);
										
			ReusableComponents.sendKey(Starting_period, starting_period, "Enter the Starting Period in the field");
			ReusableComponents.wait(5200);
							
			WebElement start_click = browser.findElement(By.xpath("//span[contains(text(),'"+starting_period+"')]"));
			ReusableComponents.clickElement(start_click, "Select the Starting period");					
			ReusableComponents.wait(5200);
		
			ReusableComponents.sendKey(End_period, Endperiod, "Enter the Ending Period in the field");
			ReusableComponents.wait(6200);
								
			WebElement end_click = browser.findElement(By.xpath("//span[contains(text(),'"+end_period+"')]"));
			ReusableComponents.clickElement(end_click, "Select the Ending period");
			ReusableComponents.wait(5200);
				
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of balance sheet report page", browser, pathLoc+"\\"+testcasemethod, true);
			
			ReusableComponents.wait(5200);
			ReusableComponents.clickElement(Run_report, "Report run button");
			ReusableComponents.wait(35200);
								
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(15200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of generated report page", browser, pathLoc+"\\"+testcasemethod, true);
			ReusableComponents.wait(5200);
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "report link is "+Gen_report.getAttribute("href")+" and report name is "+Gen_report.getText(), browser ,pathLoc+"\\"+testcasemethod , false);
			
			browser.switchTo().defaultContent();

		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Exception in PnLreport" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);
		
			}
		
	return new T2614Page(browser);
		
	}
	
	/***
	 * Test case Method Name : Testcase2614
	 * Functionality : validate T2608 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException 
	 * 
	 ***/
	public synchronized T2614Page Testcase2614(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException, throwNewException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			String Startingperiod = reusableComponents.getPropValues("period12614");
			String Endingperiod = reusableComponents.getPropValues("period22614");
			
			
			Login(threadID, tempList, pathLoc);
			
			PnLreport(threadID, tempList, pathLoc, Startingperiod, Endingperiod);
			

		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Exception in Testcase2608" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);
		
			}
		
	return new T2614Page(browser);
		
	}
	
}
