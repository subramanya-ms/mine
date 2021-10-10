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
public class T2735Page extends DriverScript {
	static WebDriver browser;

	static ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected T2735Page(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public T2735Page() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	static WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	static WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	static WebElement Login_button;

	@FindBy(xpath = "//span[@class='home']")
	static WebElement account_home;

	@FindBy(xpath = ".//*[@class='slds-size_medium']//*[@class='slds-input']")
	static WebElement SearchAppAndItemInputbox;

	@FindBy(xpath = "//input[@name='AcctSeed__Accounting_Period__c-search-input']")
	static WebElement searchTextBox_AccountPeriod;

	@FindBy(xpath = "//img[@title='Accounting Settings']")
	static WebElement Accounting_Settings;

	@FindBy(xpath = "//div/h3[contains(.,'Cash Flow Statement Settings')]")
	static WebElement CFS_Setting;

	@FindBy(xpath = "//div[@title='New']")
	static WebElement New;

	@FindBy(xpath = "//img[@title='Cash Disbursements']")
	static WebElement Cash_disbursements;

	@FindBy(xpath = "//input[@placeholder='Search Cash Disbursement Batches...']")
	static WebElement CDB_select;

	@FindBy(xpath = "//force-record-layout-row[1]//force-record-layout-item[2]//lightning-combobox[1]//input[1]")
	static WebElement CD_type;

	@FindBy(xpath = "//input[@name='AcctSeed__Amount__c']")
	static WebElement CD_amount;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounting Periods...')]")
	static
	WebElement Period_input;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounts...')]")
	static WebElement CD_vendor;

	@FindBy(xpath = "(//input[@placeholder='Search GL Accounts...'])[1]")
	static WebElement CD_Bankaccount;

	@FindBy(xpath = "//button[.='Post']")
	static WebElement Post;
	
	@FindBy(xpath = "//div[@class='secondaryFields']//force-highlights-details-item[4]//lightning-formatted-text")
	static WebElement CDstatus;

	@FindBy(xpath = "//div[@class='pbHeader']//input[@value='Post']")
	static WebElement Post_final;

	@FindBy(xpath = ".//*[@class='slds-global-actions']//*[@data-aura-class='uiTooltip']//*[@data-key='setup']")
	static WebElement setupJasperHome;

	@FindBy(xpath = ".//span[contains(text(),'Developer Console')]")
	static WebElement developerConsole;

	@FindBy(xpath = ".//*[@name='queryEditorText-inputEl']")
	static WebElement queryEditor_DeveloperConsole;

	@FindBy(xpath = ".//*[@id='queryExecuteButton-btnInnerEl']")
	static WebElement executeButton_DeveloperConsole;

	@FindBy(xpath = ".//*[contains(@id,'ext-comp-')]//*[contains(@id,'inputRow')]")
	static WebElement checkbox_SetTrueORFalse_DeveloperConsole;

	@FindBy(xpath = ".//*[@role='presentation']//*[contains(text(),'Save Rows')]")
	static WebElement saveRowButton_DeveloperConsole;

	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	static WebElement Home;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Accounting Periods')]")
	static WebElement SelectAccountingPeriods;

	@FindBy(xpath = "//input[@placeholder='Search apps and items...']")
	static WebElement Input;

	@FindBy(xpath = ".//*[@class='slds-truncate']//*[contains(text(),'Accounting Periods')]")
	static WebElement click_ap;

	@FindBy(xpath = "//button[.='Select List View']")
	static WebElement listview;

	@FindBy(xpath = "//span[contains(.,'All')][contains(@class,'virtualAutocompleteOptionText')]")
	static WebElement all_list;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	static WebElement Save;

	@FindBy(xpath = "//button[@name='Edit']")
	WebElement Edit;

	@FindBy(xpath = "//slot[@slot='secondaryFields']//lightning-formatted-text[.='Closed']")
	WebElement Closed_Status;

	@FindBy(xpath = "//slot[@slot='secondaryFields']//lightning-formatted-text[.='Open']")
	WebElement Open_Status;

	@FindBy(xpath = "//label[contains(text(),'Status')]")
	WebElement Status;

	@FindBy(xpath = "//span[.='Cash Flow Category']")
	WebElement CF_Category;

	@FindBy(xpath = "//span[.='Receipts from customers']")
	WebElement Defaultsetting;
	
	@FindBy(xpath = "//img[@title=' Financial Reports']")
	WebElement Reports;

	@FindBy(xpath = "//button[contains(text(),'Select Standard Report')]")
	WebElement Select_report_type;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search Ledgers...')]")
	WebElement Ledger;
	
	@FindBy(xpath = "//button[contains(@title,'Clear Selection')]/lightning-primitive-icon")
	WebElement Ledger_close;
	
	@FindBy(xpath = "//c-lookup[contains(.,'*Accounting Period')]//input[@role='textbox']")
	WebElement Accounting_period_report;
	
	@FindBy(xpath = "(.//*[@title='Remove selected option'])[1]")
	WebElement deselect_period;
	
	@FindBy(xpath = "//label[contains(.,'Suppress Zero Amount Rows')]/span[@class='slds-checkbox_faux']")
	WebElement S_Z_A_R;
	
	@FindBy(xpath = "//button[@title='Run Report']")
	WebElement Run_report;

	@FindBy(xpath = "(//tr[1]//div[@class='slds-truncate']//a)[1]")
	WebElement Gen_report;

	@FindBy(xpath = ".//*[@class='slds-icon-waffle']")
	static WebElement SearchAppAndItemIcon;

	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();

	int previousYearClose, Nextyear;
	String per_stat; static boolean cashDisbursementstatus = false;

	static String Accounting_period;

	/***
	 * Test case Method Name : Loginsf Functionality : validate T2735 Page Created
	 * By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 * 
	 ***/
	public synchronized static T2735Page Loginsf(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			String username = null, pass_login = null;

			// login page
			username = reusableComponents.getPropValues("usernamesf");
			pass_login = reusableComponents.getPropValues("passwordsf");

			ReusableComponents.wait(2300);
			ReusableComponents.sendKey(Username_field, username, "username input");

			ReusableComponents.sendKey(Password_field, pass_login, "password input");

			ReusableComponents.clickElement(Login_button, "Login passed");

			if (ReusableComponents.isElementPresent(account_home)) {

				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home",
						browser, pass_login, false);

			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Loginsf" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
		return new T2735Page(browser);

	}

	/*
	 * From Accounting Home, click on Accounts (under Master Data Setup) and
	 * create/edit one so it has: Accounting Type = Customer & Vendor and Accounting
	 * Active checked Author : Lakshman
	 */
	public static void checkDefaultValueOfCustomerVendorandAccounting(int threadID, List<String> tempList,
			String pathLoc) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println("********** checkDefaultValueOfCustomerVendorandAccounting");

		String url = reusableComponents.getPropValues("salesforceurl");
		browser.get(url);
		ReusableComponents.wait(2000);
		try {
			browser.switchTo().alert().accept();
		} catch (Exception e1) {
			System.out.println("There are no alert displayed");
		}

		try {
			ReusableComponents.wait(3200);

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page",
					browser, pathLoc + "\\" + testcasemethod, true);
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
				Accounting_Settings.click();
				;
				ReusableComponents.wait(5200);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Accounting Settings tab is present",
						browser, pathLoc + "\\" + testcasemethod, false);

				browser.switchTo().frame(0);

				WebElement element = browser
						.findElement(By.xpath("//div/h3[contains(.,'Cash Flow Statement Settings')]"));
				((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
				ReusableComponents.wait(3200);

				if (ReusableComponents.isElementPresent(CFS_Setting)) {

					ReusableComponents.wait(5200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Cash Flow Statement Settings tab is present", browser, pathLoc + "\\" + testcasemethod,
							false);
					ReusableComponents.wait(5200);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
							"screen grab of Cash Flow Statement Settings section, this is a non editable section",
							browser, pathLoc + "\\" + testcasemethod, true);

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Cash Flow Statement Settings tab not present", browser, pathLoc + "\\" + testcasemethod,
							true);
				}
				browser.switchTo().defaultContent();
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Accounting Settings tab not present",
						browser, pathLoc + "\\" + testcasemethod, true);
			}

			browser.switchTo().defaultContent();
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Unable to select app from select search app section" + e.getStackTrace(), browser,
					pathLoc + "\\" + testcasemethod, true);
		}
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
	 * @author Wisefinch Menaka
	 * @see We can use this method to set Cash Flow statement value to have "True"
	 *      or "False". We do not have access in UI to directly update it. So we are
	 *      doing the same from deveoloper console
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLoc
	 * @param cashFlowEnableValue : Set it to have "True" or "False"
	 * @return
	 * @throws Exception
	 * @throws throwNewException
	 */
	public static synchronized T2735Page developerConsole_QueryRun_CashFlowTrueOrFalse(int threadID,
			List<String> tempList, String pathLoc, boolean cashFlowEnableValue) throws Exception, throwNewException {
		System.out.println("********** test_Journal_Entries");
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLoc = reusableComponents.pathBuilder(path);

		boolean cashFlowEnable = cashFlowEnableValue;
		System.out.println("********** Expected condition cashFlowEnable : " + cashFlowEnable);
		try {
			Loginsf(threadID, tempList, pathLoc);
			ReusableComponents.wait(5000);

			checkDefaultValueOfCustomerVendorandAccounting(threadID, tempList, pathLoc);

			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"Cash flow value : set it to have " + cashFlowEnable, browser, pathLoc + "\\" + testcasemethod,
					false);

			ReusableComponents.clickElement(setupJasperHome, "Setup button");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(developerConsole, "Developer Console button");

			// --> Get window handle
			String parentWindow = browser.getWindowHandle();
			System.out.println("********** Parent window name " + parentWindow);

			// --> Save parent window handle
			Set<String> setOfWindows = browser.getWindowHandles();
			System.out.println("********** size : " + setOfWindows.size());

			// Now iterate using Iterator
			Iterator<String> windowIterator = setOfWindows.iterator();

			if (setOfWindows.size() > 1) {
				while (windowIterator.hasNext()) {
					String child_window = windowIterator.next();
					child_window = windowIterator.next();
					if (!parentWindow.equals(child_window)) {
						browser.switchTo().window(child_window);
						browser.manage().window().maximize();
						System.out.println(
								"********** Second window title " + browser.switchTo().window(child_window).getTitle());
						ReusableComponents.wait(5000);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Successfully navigated to developer console", browser, pathLoc + "\\" + testcasemethod,
								false);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
								pathLoc + "\\" + testcasemethod, true);
					}
				}
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Developer console window is not opened", browser, pathLoc + "\\" + testcasemethod, false);
			}

			runQuery();

			List<WebElement> valueSetToTrue = browser
					.findElements(By.xpath(".//*[@class='x-grid-cell-inner ' and contains(text(),'true')]"));
			System.out.println("********** valueSetToTrue " + valueSetToTrue.size());
			List<WebElement> valueSetToFalse = browser
					.findElements(By.xpath(".//*[@class=\"x-grid-cell-inner \" and contains(text(),'false')]"));
			System.out.println("********** valueSetToFalse " + valueSetToFalse.size());

			if (cashFlowEnable == true) {

				if (valueSetToTrue.size() > 0) {
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Flow Enable Set To True",
							browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
							pathLoc + "\\" + testcasemethod, true);
				} else {
					WebElement falseResultRow = browser
							.findElement(By.xpath(".//*[@class='x-grid-cell-inner ' and contains(text(),'false')]"));
					ReusableComponents.doubleClickElement(browser, falseResultRow, "Double click the result");
					ReusableComponents.clickElement(checkbox_SetTrueORFalse_DeveloperConsole, "Click on check box");
					ReusableComponents.clickElement(saveRowButton_DeveloperConsole, "Click on save row button");
					ReusableComponents.clickElement(saveRowButton_DeveloperConsole, "Click on save row button");

					runQuery();

					valueSetToTrue = browser
							.findElements(By.xpath(".//*[@class='x-grid-cell-inner ' and contains(text(),'true')]"));
					System.out.println("********** valueSetToTrue " + valueSetToTrue.size());
					int size = valueSetToTrue.size();
					if (size > 0) {
						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Cash Flow Enable Set To True", browser, pathLoc + "\\" + testcasemethod, false);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
								pathLoc + "\\" + testcasemethod, true);
					} else {

						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Cash Flow Enable is not Set To True", browser, pathLoc + "\\" + testcasemethod, false);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
								pathLoc + "\\" + testcasemethod, true);

					}
				}
			}

			if (cashFlowEnable == false) {

				if (valueSetToFalse.size() > 0) {
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Flow Enable Set To False",
							browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
							pathLoc + "\\" + testcasemethod, true);
				} else {
					WebElement trueResultRow = browser
							.findElement(By.xpath(".//*[@class='x-grid-cell-inner ' and contains(text(),'true')]"));
					ReusableComponents.doubleClickElement(browser, trueResultRow, "Double click the result");
					ReusableComponents.clickElement(checkbox_SetTrueORFalse_DeveloperConsole, "Click on check box");
					ReusableComponents.clickElement(saveRowButton_DeveloperConsole, "Click on save row button");
					ReusableComponents.clickElement(saveRowButton_DeveloperConsole, "Click on save row button");

					runQuery();

					valueSetToFalse = browser
							.findElements(By.xpath(".//*[@class='x-grid-cell-inner ' and contains(text(),'false')]"));
					System.out.println("********** valueSetToFalse " + valueSetToFalse.size());
					int size = valueSetToFalse.size();
					if (size > 0) {
						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Cash Flow Enable Set To False", browser, pathLoc + "\\" + testcasemethod, false);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
								pathLoc + "\\" + testcasemethod, true);
					} else {

						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Cash Flow Enable is not Set To False", browser, pathLoc + "\\" + testcasemethod,
								false);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
								pathLoc + "\\" + testcasemethod, true);

					}
				}
			}

			browser.close();
			browser.switchTo().window(parentWindow);

			checkDefaultValueOfCustomerVendorandAccounting(threadID, tempList, pathLoc);

			ReusableComponents.wait(5000);

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, true);
		}
		return new T2735Page(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see Pass query to developer console and run. This method can be used only
	 *      when the developer console page is open
	 * 
	 * @throws IOException
	 * @throws throwNewException
	 */
	public static void runQuery() throws IOException, throwNewException {
		String developerExecuteQuery = reusableComponents.getPropValues("developerQuery_CashFlow_CheckOrUnCheck");
		ReusableComponents.sendKey(queryEditor_DeveloperConsole, developerExecuteQuery,
				"Pass Query todeveloper console");
		ReusableComponents.clickElement(executeButton_DeveloperConsole, "Execute Button");
		ReusableComponents.wait(10000);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see Test cash flow statement check or uncheck
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLoc
	 * @throws Exception
	 */
	public static void test_CashFlowStatementSetTrueOrFalse(int threadID, List<String> tempList, String pathLoc)
			throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			developerConsole_QueryRun_CashFlowTrueOrFalse(threadID, tempList, pathLoc, true);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Unable to perform Cash flow statement check or uncheck " + e.getStackTrace(), browser,
					pathLoc + "\\" + testcasemethod, true);
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
			ReusableComponents.sendKey(searchTextBox_AccountPeriod, Accounting_period, "Year close");
			ReusableComponents.sendkey_InputKey(searchTextBox_AccountPeriod, Keys.ENTER, "Pass Enter");
			ReusableComponents.wait(2000);

			// --> Verify the status
			String xpathToCheckStatus = "((.//*[@scope='row']//a[contains(text(),'" + Accounting_period
					+ "')]//following::td)[3]//span)[2]";
			System.out.println("********** xpathToCheckStatus " + xpathToCheckStatus);

			WebElement statusElement = browser.findElement(By.xpath(xpathToCheckStatus));

			String statusOfTheAccountingPeriod = statusElement.getText();

			if (statusOfTheAccountingPeriod.equalsIgnoreCase(expectedStatus)) {
				statusCheck = true;
				ReusableComponents.reportPass(
						threadID, tempList, testcasemethod, "Accounting period " + Accounting_period
								+ " status displayed as expected " + statusOfTheAccountingPeriod,
						browser, pathLoc + "\\" + testcasemethod, false);

				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
						pathLoc + "\\" + testcasemethod, true);

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Accounting period " + Accounting_period
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
	 * Test case Method Name : cash_disbursement Functionality : validate T2735 Page
	 * Created By : Lakshman
	 * 
	 * @throws Exception
	 * 
	 ***/
	public synchronized static T2735Page cash_disbursement(int threadID, List<String> tempList, String pathLoc)
			throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			browser.navigate()
					.to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(5200);

			String CDtype = reusableComponents.getPropValues("cdtype");
			String CD_Amount = reusableComponents.getPropValues("amount");
			String CDBank = reusableComponents.getPropValues("cdbank");
			String CDB_Name = reusableComponents.getPropValues("cdbatch");
			String account_name = reusableComponents.getPropValues("vendor");
			String period = Accounting_period;

			ReusableComponents.wait(6200);

			List<WebElement> f = browser.findElements(By.tagName("frame"));
			int i = f.size();
			System.out.println(i + " is the frame count");

			browser.switchTo().frame(0);

			ReusableComponents.wait(6200);

			if (ReusableComponents.isElementPresent(Cash_disbursements)) {

				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement tab is present",
						browser, pathLoc + "\\" + testcasemethod, false);
				ReusableComponents.wait(3200);
				Cash_disbursements.click();
				ReusableComponents.wait(5200);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
						"screen grab of Cash Disbursement page", browser, pathLoc + "\\" + testcasemethod, true);
				ReusableComponents.wait(5200);

				if (ReusableComponents.isElementPresent(New)) {

					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Cash Disbursement New button is present", browser, pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.wait(3200);
					New.click();
					ReusableComponents.wait(5200);

					if (ReusableComponents.isElementPresent(CDB_select)) {

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Cash Disbursement Batch searchbox is present", browser,
								pathLoc + "\\" + testcasemethod, false);
						ReusableComponents.wait(3200);
						CDB_select.sendKeys(CDB_Name);
						ReusableComponents.wait(5200);

						WebElement CDB_click = browser.findElement(
								By.xpath("//lightning-base-combobox-formatted-text[@title='" + CDB_Name + "']"));
						ReusableComponents.wait(5200);
						CDB_click.click();
						System.out.println("Cash disbursement batch selected");
						ReusableComponents.wait(5200);

						if (ReusableComponents.isElementPresent(CD_type)) {

							ReusableComponents.reportPass(threadID, tempList, testcasemethod,
									"Cash Disbursement Type selectbox is present", browser,
									pathLoc + "\\" + testcasemethod, false);
							ReusableComponents.wait(3200);
							CD_type.click();
							ReusableComponents.wait(5200);

							WebElement CD_Type = browser.findElement(By.xpath("//span[@title='" + CDtype + "']"));
							ReusableComponents.wait(5200);
							CD_Type.click();
							System.out.println("Cash disbursement type selected");
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

							if (ReusableComponents.isElementPresent(CD_amount)) {

								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Cash Disbursement Amount field is present", browser,
										pathLoc + "\\" + testcasemethod, false);
								ReusableComponents.wait(3200);
								CD_amount.sendKeys(CD_Amount);
								ReusableComponents.wait(5200);

								WebElement element = browser
										.findElement(By.xpath("//span[normalize-space()='Payee Information']"));
								((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);",
										element);

								if (ReusableComponents.isElementPresent(CD_vendor)) {

									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Cash Disbursement Vendor searchbox is present", browser,
											pathLoc + "\\" + testcasemethod, false);
									ReusableComponents.wait(3200);
									CD_vendor.sendKeys(account_name);
									ReusableComponents.wait(5200);

									WebElement CD_Vendor = browser.findElement(By.xpath(
											"//lightning-base-combobox-formatted-text[@title='" + account_name + "']"));
									ReusableComponents.wait(5200);
									CD_Vendor.click();
									System.out.println("Cash disbursement vendor selected");
									ReusableComponents.wait(5200);

									WebElement elements = browser.findElement(
											By.xpath("//span[normalize-space()='Accounting Information']"));
									((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);",
											elements);

									if (ReusableComponents.isElementPresent(CD_Bankaccount)) {

										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"Cash Disbursement Bank searchbox is present", browser,
												pathLoc + "\\" + testcasemethod, false);
										ReusableComponents.wait(3200);
										CD_Bankaccount.sendKeys(CDBank);
										ReusableComponents.wait(5200);

										WebElement CD_Bank = browser.findElement(By.xpath(
												"//lightning-base-combobox-formatted-text[@title='" + CDBank + "']"));
										ReusableComponents.wait(5200);
										CD_Bank.click();
										System.out.println("Cash disbursement bank selected");
										ReusableComponents.wait(5200);

										if (ReusableComponents.isElementPresent(Save)) {

											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Cash Disbursement save button is present", browser,
													pathLoc + "\\" + testcasemethod, false);
											ReusableComponents.wait(3200);
											Save.click();
											ReusableComponents.wait(8200);
											

											if (ReusableComponents.isElementPresent(Post)) {

												ReusableComponents.reportPass(threadID, tempList, testcasemethod,
														"Cash Disbursement Post button is present", browser,
														pathLoc + "\\" + testcasemethod, false);
												ReusableComponents.wait(3200);
												Post.click();
												ReusableComponents.wait(5200);

												browser.switchTo().frame(0);

												if (ReusableComponents.isElementPresent(Post_final)) {

													ReusableComponents.reportPass(threadID, tempList, testcasemethod,
															"Cash Disbursement Post finalise button is present",
															browser, pathLoc + "\\" + testcasemethod, false);
													ReusableComponents.wait(3200);
													Post_final.click();
													ReusableComponents.wait(5200);
													
												//Create gloabla varaiable called "cashDisbursementPosted". Default value shouldbe "False"
													//Identify xpath to check status. getText();
													
													//if(cashDisbursemntstatus.equalignorecashof("Posted")){
													// cashDisbursementPosted = true;
													//}else {
														//cashDisbursementPosted = false;
													//}
													String cashDisbursementStatus = CDstatus.getText();
													
													if(cashDisbursementStatus.equalsIgnoreCase("Posted")) {
														
														cashDisbursementstatus = true;
													} else {
														
														cashDisbursementstatus = false;
													}

												} else {
													ReusableComponents.reportFail(threadID, tempList, testcasemethod,
															"Cash Disbursement Post finalise button is not present",
															browser, pathLoc + "\\" + testcasemethod, true);
												}

												browser.switchTo().defaultContent();

											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Cash Disbursement Post button is not present", browser,
														pathLoc + "\\" + testcasemethod, true);
											}

										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Cash Disbursement save button is not present", browser,
													pathLoc + "\\" + testcasemethod, true);
										}

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Cash Disbursement Bank searchbox is not present", browser,
												pathLoc + "\\" + testcasemethod, true);
									}

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Cash Disbursement Vendor searchbox is not present", browser,
											pathLoc + "\\" + testcasemethod, true);
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"Cash Disbursement  Amount field is not present", browser,
										pathLoc + "\\" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"Cash Disbursement Type selectbox is not present", browser,
									pathLoc + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Cash Disbursement Batch searchbox is not present", browser,
								pathLoc + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Cash Disbursement New button is not present", browser, pathLoc + "\\" + testcasemethod,
							true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Cash Disbursement tab is not present", browser, pathLoc + "\\" + testcasemethod, true);
			}

			browser.switchTo().defaultContent();

		
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Casdhisbursement" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

		return new T2735Page(browser);

	}

	/***
	 * Test case Method Name : PeriodClose Functionality : validate T2735 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2735Page PeriodClose(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			String acc_period = Accounting_period;
			per_stat = reusableComponents.getPropValues("pstat");
			String strArray[] = acc_period.split("-");
			String yearValue = strArray[0];
			int year = Integer.parseInt(strArray[0]);
			int month = Integer.parseInt(strArray[1]);

			previousYearClose = year - 1; // call previous year account period close method

			prev_periodclose(threadID, tempList, pathLoc);

			ReusableComponents.wait(5200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page",
					browser, pathLoc + "\\" + testcasemethod, true);
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

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"screen grab of Accounting period page", browser, pathLoc + "\\" + testcasemethod, true);

			int j = 1;
			String acct_period = null;

			for (j = 1; j <= month; j++) {

				String monthValue = null;

				if (j <= 9) {
					monthValue = "0" + j;
				} else {
					monthValue = "" + j + "";
				}

				acct_period = yearValue + "-" + monthValue;

				String Period = "//a[@title='" + acct_period + "']";

				try {
					ReusableComponents.wait(5500);
					System.out.println("main try");

					try {
						browser.findElement(By.xpath("//div[@data-aura-class='uiScroller']")).sendKeys(Keys.PAGE_DOWN);
						ReusableComponents.wait(5500);
						WebElement element = browser.findElement(By.xpath("//a[@title='" + acct_period + "']"));
						((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
						ReusableComponents.wait(5500);
					} catch (Exception e) {

						System.out.println(acct_period + " period not present");
					}

					if (ReusableComponents.isElementPresent(browser.findElement(By.xpath(Period)))) {

						System.out.println("period to be closed " + acct_period);
						System.out.println("period to be closed xpath " + Period);

						ReusableComponents.wait(5500);
						WebElement selectpe = browser.findElement(By.xpath(Period));

						ReusableComponents.wait(6500);
						selectpe.click();
						System.out.println("Accounting period tabledata present");
						ReusableComponents.wait(5500);

						try {
							if (ReusableComponents.isElementPresent(Open_Status)) {

								System.out.println("opened to be closed");

								try {
									browser.navigate().refresh();
									ReusableComponents.wait(6000);
									
									if (ReusableComponents.isElementPresent(Edit)) {

										ReusableComponents.wait(8200);
										Edit.click();
										ReusableComponents.wait(5500);
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"Edit button is present", browser, pathLoc + "\\" + testcasemethod,
												false);

										if (ReusableComponents.isElementPresent(Status)) {

											ReusableComponents.wait(3200);
											Status.click();
											ReusableComponents.wait(5500);
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Status selectbox is present", browser,
													pathLoc + "\\" + testcasemethod, false);

											String P_stat = "//span[@title='" + per_stat + "']";

											WebElement selecttype = browser.findElement(By.xpath(P_stat));
											ReusableComponents.wait(5500);
											selecttype.click();
											System.out.println("Accounting period status present");
											ReusableComponents.wait(5500);

											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
													"screen grab of Editing Accounting period", browser,
													pathLoc + "\\" + testcasemethod, true);

											if (ReusableComponents.isElementPresent(Save)) {

												ReusableComponents.reportPass(threadID, tempList, testcasemethod,
														"Save button is present", browser,
														pathLoc + "\\" + testcasemethod, false);
												ReusableComponents.wait(7200);
												Save.click();
												ReusableComponents.wait(16500);

											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Save button is NOT present ", browser,
														pathLoc + "\\" + testcasemethod, true);
											}

										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Status selectbox is NOT present ", browser,
													pathLoc + "\\" + testcasemethod, true);
										}

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Edit button is NOT present ", browser, pathLoc + "\\" + testcasemethod,
												true);
									}

								} catch (Exception c) {

									System.out.println("period not edited first " + c.getMessage());
								}

								System.out.println("Closing period in progress");
								ReusableComponents.wait(66500);

							} else {

								System.out.println("period is closed or archived");

							}
						} catch (Exception eq) {
							// TODO Auto-generated catch block
							eq.printStackTrace();
						}

					} else {

						if (ReusableComponents.isElementNotPresent(browser.findElement(By.xpath(Period)))) {

							System.out.println(Period + " period is not present");
							ReusableComponents.wait(5500);
							browser.navigate().to(
									"https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");

						} else {
							System.out.println(Period + " period loop else error");
						}
					}
				} catch (Exception h) {

					System.out.println("element exception : " + h.getMessage());

				}

				ReusableComponents.wait(5500);
				browser.navigate().to(
						"https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");

			}

		
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Periodclose" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
		return new T2735Page(browser);

	}

	/***
	 * Test case Method Name : prev_periodclose Functionality : validate T2735 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2735Page prev_periodclose(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			String last_period = null;
			ReusableComponents.wait(5200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page",
					browser, pathLoc + "\\" + testcasemethod, true);
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

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"screen grab of Accounting period page", browser, pathLoc + "\\" + testcasemethod, true);

			int j = 1;
			String acct_period = null;

			for (j = 1; j <= 12; j++) {

				if (j == 10 || j == 11 || j == 12) {

					acct_period = previousYearClose + "-" + j;

				} else {

					acct_period = previousYearClose + "-" + "0" + j;

				}

				last_period = acct_period;
				String Period = "//a[@title='" + acct_period + "']";

				try {
					ReusableComponents.wait(5500);
					System.out.println("main try");

					try {
						browser.findElement(By.xpath("//div[@data-aura-class='uiScroller']")).sendKeys(Keys.PAGE_DOWN);
						ReusableComponents.wait(5500);
						WebElement element = browser.findElement(By.xpath("//a[@title='" + acct_period + "']"));
						((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
						ReusableComponents.wait(5500);
					} catch (Exception e) {

						System.out.println(acct_period + " period not present");
					}

					if (ReusableComponents.isElementPresent(browser.findElement(By.xpath(Period)))) {

						System.out.println("period to be closed " + acct_period);
						System.out.println("period to be closed xpath " + Period);

						ReusableComponents.wait(5500);
						WebElement selectpe = browser.findElement(By.xpath(Period));

						ReusableComponents.wait(8500);
						selectpe.click();
						System.out.println("Accounting period tabledata present");
						ReusableComponents.wait(5500);

						try {
							if (ReusableComponents.isElementPresent(Open_Status)) {

								System.out.println("opened to be closed");

								try {

									if (ReusableComponents.isElementPresent(Edit)) {

										ReusableComponents.wait(10200);
										Edit.click();
										ReusableComponents.wait(5500);
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"Edit button is present", browser, pathLoc + "\\" + testcasemethod,
												false);

										if (ReusableComponents.isElementPresent(Status)) {

											ReusableComponents.wait(3200);
											Status.click();
											ReusableComponents.wait(5500);
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Status selectbox is present", browser,
													pathLoc + "\\" + testcasemethod, false);

											String P_stat = "//span[@title='" + per_stat + "']";

											WebElement selecttype = browser.findElement(By.xpath(P_stat));
											ReusableComponents.wait(5500);
											selecttype.click();
											System.out.println("Accounting period status present");
											ReusableComponents.wait(5500);

											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
													"screen grab of Editing Accounting period", browser,
													pathLoc + "\\" + testcasemethod, true);

											if (ReusableComponents.isElementPresent(Save)) {

												ReusableComponents.reportPass(threadID, tempList, testcasemethod,
														"Save button is present", browser,
														pathLoc + "\\" + testcasemethod, false);
												ReusableComponents.wait(7200);
												Save.click();
												ReusableComponents.wait(16500);

											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Save button is NOT present ", browser,
														pathLoc + "\\" + testcasemethod, true);
											}

										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Status selectbox is NOT present ", browser,
													pathLoc + "\\" + testcasemethod, true);
										}

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Edit button is NOT present ", browser, pathLoc + "\\" + testcasemethod,
												true);
									}

								} catch (Exception c) {

									System.out.println("period not edited first " + c.getMessage());
								}

								System.out.println("Closing period in progress");
								ReusableComponents.wait(66500);

							} else {

								System.out.println("period is closed or archived");

							}
						} catch (Exception eq) {
							// TODO Auto-generated catch block
							eq.printStackTrace();
						}

					} else {

						if (ReusableComponents.isElementNotPresent(browser.findElement(By.xpath(Period)))) {

							System.out.println(Period + " period is not present");
							ReusableComponents.wait(5500);
							browser.navigate().to(
									"https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");

						} else {
							System.out.println(Period + " period loop else error");
						}
					}
				} catch (Exception h) {

					System.out.println("element exception : " + h.getMessage());

				}

				ReusableComponents.wait(5500);
				browser.navigate().to(
						"https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");

			}

			System.out.println(last_period + " is th ending period of year " + previousYearClose);

		
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Previousyearclose" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

		return new T2735Page(browser);

	}

	/***
	 * Test case Method Name : Currentperiodopen Functionality : validate T2735 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2735Page Currentperiodopen(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			String acc_period = Accounting_period;
			per_stat = reusableComponents.getPropValues("nstat");
			String last_period = null;
			String strArray[] = acc_period.split("-");
			String yearValue = strArray[0];
			int year = Integer.parseInt(strArray[0]);
			int month = Integer.parseInt(strArray[1]);

			Nextyear = year + 1;

			Nextyearopen(threadID, tempList, pathLoc);

			ReusableComponents.wait(5200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page",
					browser, pathLoc + "\\" + testcasemethod, true);
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

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"screen grab of Accounting period page", browser, pathLoc + "\\" + testcasemethod, true);

			int j = 12;
			String acct_period = null;

			for (j = 12; j >= month; j--) {

				String monthValue = null;

				if (j <= 9) {
					monthValue = "0" + j;
				} else {
					monthValue = "" + j + "";
				}

				acct_period = yearValue + "-" + monthValue;

				// you can use the above value , form dynamic xpath , open the accounting
				// period. check the status and close.

				last_period = acct_period;
				String Period = "//a[@title='" + acct_period + "']";

				try {
					ReusableComponents.wait(5500);
					System.out.println("main try");

					try {
						browser.findElement(By.xpath("//div[@data-aura-class='uiScroller']")).sendKeys(Keys.PAGE_DOWN);
						ReusableComponents.wait(5500);
						WebElement element = browser.findElement(By.xpath("//a[@title='" + acct_period + "']"));
						((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
						ReusableComponents.wait(5500);
					} catch (Exception e) {

						System.out.println(acct_period + " period not present");
					}

					if (ReusableComponents.isElementPresent(browser.findElement(By.xpath(Period)))) {

						System.out.println("period to be opened " + acct_period);
						System.out.println("period to be opened xpath " + Period);

						ReusableComponents.wait(5500);
						WebElement selectpe = browser.findElement(By.xpath(Period));

						ReusableComponents.wait(8500);
						selectpe.click();
						System.out.println("Accounting period tabledata present");
						ReusableComponents.wait(5500);

						try {
							if (ReusableComponents.isElementPresent(Closed_Status)) {

								System.out.println("closed to be opened");

								try {

									if (ReusableComponents.isElementPresent(Edit)) {

										ReusableComponents.wait(10200);
										Edit.click();
										ReusableComponents.wait(5500);
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"Edit button is present", browser, pathLoc + "\\" + testcasemethod,
												false);

										if (ReusableComponents.isElementPresent(Status)) {

											ReusableComponents.wait(3200);
											Status.click();
											ReusableComponents.wait(5500);
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Status selectbox is present", browser,
													pathLoc + "\\" + testcasemethod, false);

											String P_stat = "//span[@title='" + per_stat + "']";

											WebElement selecttype = browser.findElement(By.xpath(P_stat));
											ReusableComponents.wait(5500);
											selecttype.click();
											System.out.println("Accounting period status present");
											ReusableComponents.wait(5500);

											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
													"screen grab of Editing Accounting period", browser,
													pathLoc + "\\" + testcasemethod, true);

											if (ReusableComponents.isElementPresent(Save)) {

												ReusableComponents.reportPass(threadID, tempList, testcasemethod,
														"Save button is present", browser,
														pathLoc + "\\" + testcasemethod, false);
												ReusableComponents.wait(7200);
												Save.click();
												ReusableComponents.wait(16500);

											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Save button is NOT present ", browser,
														pathLoc + "\\" + testcasemethod, true);
											}

										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Status selectbox is NOT present ", browser,
													pathLoc + "\\" + testcasemethod, true);
										}

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Edit button is NOT present ", browser, pathLoc + "\\" + testcasemethod,
												true);
									}

								} catch (Exception c) {

									System.out.println("period not edited first " + c.getMessage());
								}

								System.out.println("opening period in progress");
								ReusableComponents.wait(66500);

							} else {

								System.out.println("period is open or archived");

							}
						} catch (Exception eq) {
							// TODO Auto-generated catch block
							eq.printStackTrace();
						}

					} else {

						if (ReusableComponents.isElementNotPresent(browser.findElement(By.xpath(Period)))) {

							System.out.println(Period + " period is not present");
							ReusableComponents.wait(5500);
							browser.navigate().to(
									"https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");

						} else {
							System.out.println(Period + " period loop else error");
						}
					}
				} catch (Exception h) {

					System.out.println("element exception : " + h.getMessage());

				}

				ReusableComponents.wait(5500);
				browser.navigate().to(
						"https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");

			}

			System.out.println(last_period + " is the ending period of year " + acc_period);

		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of currentperiodopen" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

		return new T2735Page(browser);

	}

	/***
	 * Test case Method Name : Nextyearopen Functionality : validate T2710 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2735Page Nextyearopen(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

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

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"screen grab of Accounting period page", browser, pathLoc + "\\" + testcasemethod, true);

			int j = 12;
			String acct_period = null;

			for (j = 12; j >= 1; j--) {

				String monthValue = null;

				if (j <= 9) {
					monthValue = "0" + j;
				} else {
					monthValue = "" + j + "";
				}

				acct_period = Nextyear + "-" + monthValue;

				// you can use the above value , form dynamic xpath , open the accounting
				// period. check the status and close.

				String Period = "//a[@title='" + acct_period + "']";

				try {
					ReusableComponents.wait(5500);
					System.out.println("main try");

					try {
						browser.findElement(By.xpath("//div[@data-aura-class='uiScroller']")).sendKeys(Keys.PAGE_DOWN);
						ReusableComponents.wait(5500);
						WebElement element = browser.findElement(By.xpath("//a[@title='" + acct_period + "']"));
						((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
						ReusableComponents.wait(5500);
					} catch (Exception e) {

						System.out.println(acct_period + " period not present");
					}

					if (ReusableComponents.isElementPresent(browser.findElement(By.xpath(Period)))) {

						System.out.println("period to be opened " + acct_period);
						System.out.println("period to be opened xpath " + Period);

						ReusableComponents.wait(5500);
						WebElement selectpe = browser.findElement(By.xpath(Period));

						ReusableComponents.wait(8500);
						selectpe.click();
						System.out.println("Accounting period tabledata present");
						ReusableComponents.wait(5500);

						try {
							if (ReusableComponents.isElementPresent(Closed_Status)) {

								System.out.println("closed to be opened");

								try {

									if (ReusableComponents.isElementPresent(Edit)) {

										ReusableComponents.wait(10200);
										Edit.click();
										ReusableComponents.wait(5500);
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"Edit button is present", browser, pathLoc + "\\" + testcasemethod,
												false);

										if (ReusableComponents.isElementPresent(Status)) {

											ReusableComponents.wait(3200);
											Status.click();
											ReusableComponents.wait(5500);
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Status selectbox is present", browser,
													pathLoc + "\\" + testcasemethod, false);

											String P_stat = "//span[@title='" + per_stat + "']";

											WebElement selecttype = browser.findElement(By.xpath(P_stat));
											ReusableComponents.wait(5500);
											selecttype.click();
											System.out.println("Accounting period status present");
											ReusableComponents.wait(5500);

											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
													"screen grab of Editing Accounting period", browser,
													pathLoc + "\\" + testcasemethod, true);

											if (ReusableComponents.isElementPresent(Save)) {

												ReusableComponents.reportPass(threadID, tempList, testcasemethod,
														"Save button is present", browser,
														pathLoc + "\\" + testcasemethod, false);
												ReusableComponents.wait(7200);
												Save.click();
												ReusableComponents.wait(6500);

											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Save button is NOT present ", browser,
														pathLoc + "\\" + testcasemethod, true);
											}

										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Status selectbox is NOT present ", browser,
													pathLoc + "\\" + testcasemethod, true);
										}

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Edit button is NOT present ", browser, pathLoc + "\\" + testcasemethod,
												true);
									}

								} catch (Exception c) {

									System.out.println("period not edited first " + c.getMessage());
								}

								System.out.println("opening period in progress");
								ReusableComponents.wait(66500);

							} else {

								System.out.println("period is open or archived");

							}
						} catch (Exception eq) {

							eq.printStackTrace();
						}

					} else {

						if (ReusableComponents.isElementNotPresent(browser.findElement(By.xpath(Period)))) {

							System.out.println(Period + " period is not present");
							ReusableComponents.wait(5500);
							browser.navigate().to(
									"https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");

						} else {
							System.out.println(Period + " period loop else error");
						}
					}
				} catch (Exception h) {

					System.out.println("element exception : " + h.getMessage());

				}

				ReusableComponents.wait(5500);
				browser.navigate().to(
						"https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");

			}

		
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Nextyearopen" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

		return new T2735Page(browser);

	}

	/***
	 * Test case Method Name : callingmethod Reportrun : validate T2735 Page
	 * Created By : Lakshman
	 * 
	 * @throws Exception
	 * 
	 ***/
	public synchronized T2735Page Reportrun(int threadID, List<String> tempList, String pathLoc) throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			
			
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(10200);
			
			String s_report = reusableComponents.getPropValues("selectreport2");
			String a_period = Accounting_period;
			
			ReusableComponents.wait(5200);
			
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
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Financial Reports type selectbox NOT present", browser, pathLoc + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Financial Reports tab NOT present", browser, pathLoc + "\\" + testcasemethod, true);
			}
			
			browser.switchTo().defaultContent();

		
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Reportrun" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

		return new T2735Page(browser);

	}

	/***
	 * Test case Method Name : callingmethod Functionality : validate T2735 Page
	 * Created By : Lakshman
	 * 
	 * @throws Exception
	 * 
	 ***/
	public synchronized T2735Page callingmethod(int threadID, List<String> tempList, String pathLoc) throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			developerConsole_QueryRun_CashFlowTrueOrFalse(threadID, tempList, pathLoc, true);
			
			String currentAccoutingPeriod = reusableComponents.getPropValues("Period2735");
			System.out.println("*********** currentAccoutingPeriod " + currentAccoutingPeriod);

			String strArray[] = currentAccoutingPeriod.split("-");
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

				Accounting_period = String.valueOf(year) + "-" + "0" + String.valueOf(monthint);
			} else {

				Accounting_period = String.valueOf(year) + "-"  + String.valueOf(monthint);
			}

			try {
				Currentperiodopen(threadID, tempList, pathLoc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String expectedAccountingPeriodStatus = "Open";

			boolean actualAccountingPeriodStatus = false;

			try {
				actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLoc, Accounting_period,
						expectedAccountingPeriodStatus);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("actual status is " + actualAccountingPeriodStatus);

			if (actualAccountingPeriodStatus) {
				
				cash_disbursement(threadID, tempList, pathLoc);
				
				if(cashDisbursementstatus) {
				
				PeriodClose(threadID, tempList, pathLoc);
				
				String expectedperiodstatus = "closed";
				Boolean checkaccountingperiodstatus = checkAccountPeriodStatus(threadID, tempList, pathLoc, Accounting_period, expectedperiodstatus);
				
				if(checkaccountingperiodstatus) {
					//Call financial report
					Reportrun(threadID, tempList, pathLoc);
					
				}else {
					
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Accounting period " + Accounting_period + " status is not closed. Hence can not continue with the test case"
							 , browser, pathLoc + "\\" + testcasemethod, false);
				}
				
				}else{
					
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "New cash disbursement is not created, hence can not continue with the test case"
							 , browser, pathLoc + "\\" + testcasemethod, false);
				}
				
				
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Acconting period "
						+ Accounting_period
						+ " expected to be open but the current status is closed, cannot continue with the testcase"
						 , browser, pathLoc + "\\" + testcasemethod, false);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of test case 2735" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

		return new T2735Page(browser);

	}

}
