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
import org.sikuli.script.Key;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;

/**
 * Base class for all the pages.
 *
 */
public class T2645Page extends DriverScript {
	protected static WebDriver browser;

	static ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected T2645Page(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public T2645Page() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;

	@FindBy(xpath = "(.//input[@type='text'])[2]")
	static WebElement budgetLedget_PandLVsBudget;

	@FindBy(xpath = "(.//*[@title='Remove selected option'])[2]")
	static WebElement removeBudgetLedger_PandLVsBudget;

	@FindBy(xpath = ".//*[@class='actionBody']//*[@title='Budget']")
	static WebElement selectBudget_LedgerPopup;

	@FindBy(xpath = ".//*[@class='actionBody']//*[@class='slds-modal__header']/h2[contains(text(),'New Ledger')]")
	static WebElement newLedgerPopup;

	@FindBy(xpath = "(.//*[@class='actionBody']//input[@role='combobox'])[1]")
	static WebElement type_NewLedgerPopup;

	@FindBy(xpath = ".//*[@name='Name']")
	static WebElement ledgerName_LedgerPage;

	@FindBy(xpath = "(.//lightning-button//button[contains(text(),'Save')])[2]")
	static WebElement saveButton_LedgerPage;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Ledgers')]")
	static WebElement selectLedgerFromApp;

	@FindBy(xpath = "//div[@title='New']")
	WebElement New;

	@FindBy(xpath = "//input[@name='AcctSeed__Start_Date__c']")
	WebElement Accountingperod_startdate;

	@FindBy(xpath = "//input[@name='AcctSeed__End_Date__c']")
	WebElement Accountingperod_endingdate;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Save;

	@FindBy(xpath = "//img[@title=' Financial Reports']")
	WebElement Reports;

	@FindBy(xpath = "//button[contains(text(),'Select Standard Report')]")
	WebElement Select_report_type;
	
	@FindBy(xpath = "//c-lookup[contains(.,'*Budget Ledger')]//input[@role='textbox']")
	WebElement Budget_ledget;

	@FindBy(xpath = "//c-lookup[contains(.,'*Starting Accounting Period')]//input[@role='textbox']")
	WebElement Starting_period;
	
	@FindBy(xpath = "(.//*[@title='Remove selected option'])[2]")
	WebElement deselect_Budgetledger;

	@FindBy(xpath = "(.//*[@title='Remove selected option'])[3]")
	WebElement deselect_startperiod;

	@FindBy(xpath = "(.//*[@title='Remove selected option'])[4]")
	WebElement deselect_endperiod;

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

	@FindBy(xpath = ".//*[@class='slds-icon-waffle']")
	static WebElement SearchAppAndItemIcon;

	@FindBy(xpath = ".//*[@class='slds-size_medium']//*[@class='slds-input']")
	static WebElement SearchAppAndItemInputbox;

	@FindBy(xpath = "//div[@class='secondaryFields']//force-highlights-details-item[4]//lightning-formatted-text")
	static WebElement Orginalstatus;

	@FindBy(xpath = ".//li//*[contains(text(),'New')]")
	static WebElement newLink_LedgerPage;

	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();

	static boolean newLedgerCreatedStatus;
	static String testCaseNumber;

	static String newLedgerName;

	/***
	 * Test case Method Name : Login Functionality : validate T2645 Page Created By
	 * : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 * 
	 ***/
	public synchronized T2645Page Login(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			String username = null, pass_login = null;

			// browser.switchTo().defaultContent();

			username = reusableComponents.getPropValues("usernamesf");
			pass_login = reusableComponents.getPropValues("passwordsf");

			ReusableComponents.wait(2300);
			ReusableComponents.sendKey(Username_field, username, "Username field");
			ReusableComponents.sendKey(Password_field, pass_login, "password field");
			ReusableComponents.clickElement(Login_button, "pass login");

			ReusableComponents.wait(22200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page",
					browser, pathLoc + "\\" + testcasemethod, true);
			ReusableComponents.wait(3200);

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);

		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Login" + e.toString(), browser, pathLoc + "\\" + testcasemethod, true);
		}

		return new T2645Page(browser);

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
	public static T2645Page selectAppFromSearchAppAndItem(int threadID, List<String> tempList, String pathLoc,

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
		return new T2645Page(browser);

	}

	/**
	 * @author Wisefinch Menaka
	 * @see This method is to create new ledger with the type "Budget"
	 *
	 * @param threadID
	 * @param tempList
	 * @param pathLoc
	 * @return
	 * @throws Exception
	 */
	public static T2645Page createLedger(int threadID, List<String> tempList, String pathLoc) throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();


		try {
			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Ledgers", selectLedgerFromApp);
			ReusableComponents.clickElement(newLink_LedgerPage, "New Link From Ledger Page");
			ReusableComponents.wait(5000);

			if (ReusableComponents.isDisplayed(newLedgerPopup, "Verify new ledger popup displayed")) {

				ReusableComponents.sendKey(ledgerName_LedgerPage, newLedgerName, "New Ledger Name");

				ReusableComponents.clickElement(type_NewLedgerPopup, "Click type dropdown");
				ReusableComponents.clickElement(type_NewLedgerPopup, "Click type dropdown");
				ReusableComponents.wait(5000);

				try {
					Boolean budgetTypeOpen = ReusableComponents.isDisplayed(selectBudget_LedgerPopup,
							"Verify type displayed");
					System.out.println("********** budgetTypeOpen " + budgetTypeOpen);

					if (!budgetTypeOpen) {
						ReusableComponents.clickElement(type_NewLedgerPopup, "Click type dropdown");
						ReusableComponents.wait(2000);
					}

					ReusableComponents.clickElement(selectBudget_LedgerPopup, "Select budget from type drop down");
					ReusableComponents.wait(2000);
				} catch (Exception e) {
					System.out.println("****** This is just to skip the exception");
				}

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Ledger mandatory values are selected ", browser, pathLoc + "/" + testcasemethod, false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLoc + "\\" + testcasemethod, true);
				ReusableComponents.clickElement(saveButton_LedgerPage, "Save Button Of Ledgerpage");
				ReusableComponents.wait(10000);

				String newLedgerPage = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'"
						+ newLedgerName + "')]";
				if (browser.findElement(By.xpath(newLedgerPage)).isDisplayed() == true) {
					newLedgerCreatedStatus = true;
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, newLedgerName + " is created",
							browser, pathLoc + "\\" + testcasemethod, false);

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
							pathLoc + "\\" + testcasemethod, true);

				} else {
					newLedgerCreatedStatus = false;
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"New Ledger" + newLedgerName + " is not created", browser,
							pathLoc + "\\" + testcasemethod, true);
				}
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "New ledger popup is not displayed. ",
						browser, pathLoc + "\\" + testcasemethod, true);
			}
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to createledger. " + e.getMessage(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
		return new T2645Page(browser);
	}

	/***
	 * Test case Method Name : PnLvsBudgetreport Functionality : validate T2645 Page Created
	 * By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 * 
	 ***/
	public synchronized T2645Page PnLvsBudgetreport(int threadID, List<String> tempList, String pathLoc,
			String Startingperiod, String Endperiod) throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			navigateToAccountingHomePage();
			ReusableComponents.wait(6500);

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
			
			ReusableComponents.clickElement(Select_report_type, "Report type");
			ReusableComponents.wait(2300);
			
			WebElement Type = browser.findElement(By.xpath("//span[.='P & L vs. Budget']"));
			
			ReusableComponents.clickElement(Type, "Select P&L vs Budget");
		
			ReusableComponents.clickElement(deselect_Budgetledger, "Deselect the Budget ledger selected");
			ReusableComponents.wait(3200);
			ReusableComponents.clickElement(deselect_startperiod, "Deselect the Starting period selected");
			ReusableComponents.wait(3200);
			ReusableComponents.clickElement(deselect_endperiod, "Deselect the Ending period selected");
			ReusableComponents.wait(3200);
			
			ReusableComponents.sendKey(Budget_ledget, newLedgerName, "Budget Ledger input field");
			
			WebElement Budgetledger_click = browser
					.findElement(By.xpath("//span[contains(text(),'" + newLedgerName + "')]"));
			ReusableComponents.clickElement(Budgetledger_click, "Select the Budget ledger");
			ReusableComponents.wait(5200);
			
			ReusableComponents.sendKey(Starting_period, starting_period, "Enter the Starting Period in the field");
			ReusableComponents.wait(5200);

			WebElement start_click = browser
					.findElement(By.xpath("//span[contains(text(),'" + starting_period + "')]"));
			ReusableComponents.clickElement(start_click, "Select the Starting period");
			ReusableComponents.wait(5200);

			ReusableComponents.sendKey(End_period, Endperiod, "Enter the Ending Period in the field");
			ReusableComponents.wait(6200);

			WebElement end_click = browser.findElement(By.xpath("//span[contains(text(),'" + end_period + "')]"));
			ReusableComponents.clickElement(end_click, "Select the Ending period");
			ReusableComponents.wait(5200);

			if (Suppress_Zero_Amount_Report.isSelected() == true) {

				ReusableComponents.wait(4200);
				Suppress_Zero_Amount_Report.click();
				ReusableComponents.wait(4200);
				System.out.println("Suppress zero amount checkbox is unchecked");

			} else {

				System.out.println("Suppress zero amount is already selected");
			}

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"screen grab of balance sheet report page", browser, pathLoc + "\\" + testcasemethod, true);

			ReusableComponents.wait(5200);
			ReusableComponents.clickElement(Run_report, "Report Run Button");
			ReusableComponents.wait(35200);

			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(15200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"screen grab of generated report page", browser, pathLoc + "\\" + testcasemethod, true);
			ReusableComponents.wait(5200);
			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"report link is " + Gen_report.getAttribute("href") + " and report name is " + Gen_report.getText(),
					browser, pathLoc + "\\" + testcasemethod, false);

			browser.switchTo().defaultContent();

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of PnLreport" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

		return new T2645Page(browser);

	}

	/***
	 * Test case Method Name : Testcase2612 Functionality : validate T2612 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 * 
	 ***/
	public synchronized T2645Page Testcase2645(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			testCaseNumber = "Testcase2645";
			newLedgerName = "Ledger_" + testCaseNumber + "_" + ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss");
			String Starting_period = reusableComponents.getPropValues("startperiod2645");
			String Ending_period = reusableComponents.getPropValues("endperiod2645");

			Login(threadID, tempList, pathLoc);

			createLedger(threadID, tempList, pathLoc);
			
			if (newLedgerCreatedStatus) {
			
				PnLvsBudgetreport(threadID, tempList, pathLoc, Starting_period, Ending_period);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Testdata Ledger is not created, can not continue with the testcase "+testCaseNumber, browser,
						pathLoc + "\\" + testcasemethod, true);
			}
			

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of test case 2645" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

		return new T2645Page(browser);

	}

}
