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
public class T2612Page extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected T2612Page(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public T2612Page() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;

	@FindBy(xpath = "//button[.='App Launcher']")
	WebElement Home;

	@FindBy(xpath = "//input[contains(@placeholder,'Search apps and items...')]")
	WebElement Input;

	@FindBy(xpath = ".//*[@class='slds-truncate']//*[contains(text(),'Accounting Variables')]")
	WebElement click_av;

	@FindBy(xpath = ".//*[@class='slds-truncate']//*[contains(text(),'Accounting Periods')]")
	WebElement click_ap;

	@FindBy(xpath = "//div[@title='New']")
	WebElement New;

	@FindBy(xpath = "//input[@name='Name']")
	WebElement Variable_name;

	@FindBy(xpath = "//force-record-layout-row[2]//input")
	WebElement Variable_Type;

	@FindBy(xpath = "//span[@title='GL Account Variable 1']")
	WebElement Variable_Gl_Variable1;

	@FindBy(xpath = "//input[@name='Name']")
	WebElement Period_name;

	@FindBy(xpath = "//input[@name='AcctSeed__Start_Date__c']")
	WebElement Accountingperod_startdate;

	@FindBy(xpath = "//input[@name='AcctSeed__End_Date__c']")
	WebElement Accountingperod_endingdate;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Save;

	@FindBy(xpath = "//img[@title='Billings']")
	WebElement Billing_tab;

	@FindBy(xpath = "//force-record-layout-section[1]//force-record-layout-row[4]//input[1]")
	WebElement Posting_status_billing;

	@FindBy(xpath = "//force-record-layout-section[3]//force-record-layout-row[1]//force-record-layout-item[1]//input[1]")
	WebElement Customer_billing;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounting Periods...')]")
	WebElement Period_input;

	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_line;

	@FindBy(xpath = "//div/input[@name='AcctSeed__Rate__c']")
	WebElement Unit_price_Bline;

	@FindBy(xpath = "//div/input[@name='AcctSeed__Hours_Units__c']")
	WebElement Quantity_Bline;

	@FindBy(xpath = "//button[.='Post']")
	WebElement Post;

	@FindBy(xpath = "//div[@class='pbHeader']//tbody//input[@value='Post']")
	WebElement Post_final;
	
	@FindBy(xpath = "//span[@class='uiImage']/img[@src='/img/icon/t4v35/custom/custom14_120.png']")
	WebElement Payee_tab;

	@FindBy(xpath = "//input[@name='AcctSeed__Payee_Reference__c']")
	WebElement Payee_Reference;

	@FindBy(xpath = "//force-record-layout-row[1]/slot[1]/force-record-layout-item[1]//force-record-layout-lookup[1]//input[1]")
	WebElement Vendor_payables;
	
	@FindBy(xpath = "//force-record-layout-row[1]//force-record-layout-item[1]//force-record-layout-lookup[1]//lightning-grouped-combobox[1]//lightning-base-combobox[1]//input[1]")
	WebElement Expense_GL_Account_payables;
	
	@FindBy(xpath = "//input[@name='AcctSeed__Unit_Cost__c']")
	WebElement Unitcost_payables;

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
	
	@FindBy(xpath = "//div[@class='secondaryFields']//force-highlights-details-item[4]//lightning-formatted-text")
	static WebElement Orginalstatus;

	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();
	
	boolean BillingactualStatus, PayableactualStatus;

	/***
	 * Test case Method Name : Login Functionality : validate T2612 Page Created By
	 * : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 * 
	 ***/
	public synchronized T2612Page Login(int threadID, List<String> tempList, String pathLoc)
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
					"Error During execution of Login" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

		return new T2612Page(browser);

	}

	/***
	 * Test case Method Name : GL_Account_variable1 Functionality : validate T2612
	 * Page Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 * 
	 ***/
	public synchronized T2612Page GL_Account_variable1(int threadID, List<String> tempList, String pathLoc,
			String Variablename, String VariableType) throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			ReusableComponents.clickElement(Home, "Home button");
			ReusableComponents.wait(3200);
			ReusableComponents.sendKey(Input, "Accounting Variables", "Input to home search");
			ReusableComponents.wait(2200);
			ReusableComponents.clickElement(click_av, "click accoutning variables");
			ReusableComponents.wait(2200);
			ReusableComponents.clickElement(New, "New button");
			ReusableComponents.wait(4200);
			ReusableComponents.sendKey(Variable_name, Variablename, "Variable name field");
			ReusableComponents.wait(2500);
			ReusableComponents.clickElement(Variable_Type, "Variable type dropdown");
			
			WebElement selecttype = browser.findElement(By.xpath("//span[@title='"+VariableType+"']"));
			
			ReusableComponents.wait(2500);
			ReusableComponents.clickElement(selecttype, "Type select");
			ReusableComponents.wait(2200);
			ReusableComponents.clickElement(Save, "save button");
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of created gl variable",
					browser, testcasemethod, true);
			ReusableComponents.wait(3200);

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of GL account variable type1 creation" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

		return new T2612Page(browser);

	}

	/***
	 * Test case Method Name : Accounting_period_creation Functionality : validate
	 * T2612 Page Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 * 
	 ***/
	public synchronized T2612Page Accounting_period_creation(int threadID, List<String> tempList, String pathLoc,
			String Accountingperiod_name, String Accountingperiod_startdate, String Accountingperiod_enddate)
			throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			ReusableComponents.clickElement(Home, "Home button");
			ReusableComponents.wait(3200);
			ReusableComponents.sendKey(Input, "Accounting Periods", "Input to home search");
			ReusableComponents.wait(2200);
			ReusableComponents.clickElement(click_ap, "click accoutning periods");
			ReusableComponents.wait(2200);
			ReusableComponents.clickElement(New, "New button");
			ReusableComponents.wait(4200);
			ReusableComponents.sendKey(Period_name, Accountingperiod_name, "Variable name field");
			ReusableComponents.sendKey(Accountingperod_startdate, Accountingperiod_startdate,
					"Accounting period Sarting date field");
			ReusableComponents.sendKey(Accountingperod_endingdate, Accountingperiod_enddate,
					"Accounting period Ending date field");
			ReusableComponents.clickElement(Save, "save button");
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"screen grab of created account period", browser, testcasemethod, true);
			ReusableComponents.wait(3200);

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Accounting period creation" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

		return new T2612Page(browser);

	}

	/***
	 * Test case Method Name : Billing_creation 
	 * Functionality : validate T2612 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2612Page Billing_creation(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
			
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
			
		try {
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(6200);
			
			String Customer = reusableComponents.getPropValues("vendor");
			String AccountingPeriod = reusableComponents.getPropValues("period12612");

			browser.switchTo().frame(0);
			
			ReusableComponents.clickElement(Billing_tab, "Billing tab");
			ReusableComponents.wait(5500);
			
			ReusableComponents.clickElement(New, "New billing");
			ReusableComponents.wait(5500);
					
//			ReusableComponents.wait(3200);
//			Posting_status_billing.click();
//			ReusableComponents.wait(5500);
//						
//			String P_stat = "//span[@title='"+post_status+"']";
//						
//			WebElement selecttype = browser.findElement(By.xpath(P_stat));
//			ReusableComponents.wait(5500);
//			new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(selecttype)).click();
//			ReusableComponents.wait(5500);
						
			WebElement element = browser.findElement(By.xpath("//span[contains(text(),'Customer Information')]"));
			ReusableComponents.scrollInToElementJavaScript(browser, element);
						
			ReusableComponents.wait(3200);
			ReusableComponents.sendKey(Customer_billing, Customer, "Customer serachbox billing");
			ReusableComponents.wait(2500);
							
			WebElement Vendor_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='" + Customer + "']"));
			
			ReusableComponents.clickElement(Vendor_click, "Customer is selected");
			ReusableComponents.wait(3200);
			ReusableComponents.sendKey(Period_input, AccountingPeriod, "Period input field");
			ReusableComponents.wait(2500);
								
			WebElement Period_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+AccountingPeriod+"']"));

			ReusableComponents.wait(2200);
			ReusableComponents.clickElement(Period_click, "Period select");
			ReusableComponents.wait(2200);

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Billing creation page", browser, pathLoc+"\\"+testcasemethod, true);
							
			ReusableComponents.wait(3200);
			ReusableComponents.clickElement(Save, "Save button");
			ReusableComponents.wait(6500);
		
			Bline_creation(threadID, tempList, pathLoc);
			
			browser.switchTo().defaultContent();
			
			
			
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Billing creation" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}
			
		return new T2612Page(browser);
			
	}

	/***
	 * Test case Method Name : Bline_creation Functionality : validate T2687 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2612Page Bline_creation(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			
			String Quantity = reusableComponents.getPropValues("quantity");
			String Unitprice = reusableComponents.getPropValues("amount");
			String AccountingVariable = reusableComponents.getPropValues("variable12612");
			String AccountingVariableType = reusableComponents.getPropValues("variabletype12612");
			
			String xpathtoAccountingVariable;
			
			switch (AccountingVariableType) {
			
			case "GL Account Variable 1":
				xpathtoAccountingVariable = "(//input[@placeholder='Search Accounting Variables...'])[1]";
				break;
			case "GL Account Variable 2":
				xpathtoAccountingVariable = "(//input[@placeholder='Search Accounting Variables...'])[2]";
				break;
			case "GL Account Variable 3":
				xpathtoAccountingVariable = "(//input[@placeholder='Search Accounting Variables...'])[3]";
				break;	
			case "GL Account Variable 4":
				xpathtoAccountingVariable = "(//input[@placeholder='Search Accounting Variables...'])[4]";
			case "Time Card Variable 1":
				xpathtoAccountingVariable = "(//input[@placeholder='Search Accounting Variables...'])[5]";
				break;
			case "Time Card Variable 2":
				xpathtoAccountingVariable = "(//input[@placeholder='Search Accounting Variables...'])[6]";
				break;	
					
			default:
				throw new throwNewException("Accounting variable", "Invalid Accounting variable type given");
		    }
			
			browser.navigate().refresh();
			ReusableComponents.wait(15200);
			ReusableComponents.scrollDownUsingPageDown(browser);
			ReusableComponents.wait(2200);
			ReusableComponents.scrollDownUsingPageDown(browser);
			ReusableComponents.wait(2200);
			ReusableComponents.scrollDownUsingPageDown(browser);
			ReusableComponents.wait(8200);

			ReusableComponents.clickElement(New_line, "New Billing Line");
			ReusableComponents.wait(5500);
			ReusableComponents.sendKey(Quantity_Bline, Quantity, "Quantity field billing line");
			ReusableComponents.sendKey(Unit_price_Bline, Unitprice, "Unitprice field billing line");
			
			WebElement Accounting_variable = browser.findElement(By.xpath(xpathtoAccountingVariable));
			
			ReusableComponents.scrollInToElementJavaScript(browser, Accounting_variable);
			
			ReusableComponents.sendKey(Accounting_variable, AccountingVariable, "Accounting variable input");
			
			WebElement GLvariable_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+AccountingVariable+"']"));

			ReusableComponents.wait(2200);
			ReusableComponents.clickElement(GLvariable_click, "Accounting variable select");
			ReusableComponents.wait(2200);
			ReusableComponents.clickElement(Save, "Save button");
			ReusableComponents.wait(5200);
			ReusableComponents.clickElement(Post, "Post button");
			ReusableComponents.wait(6200);
			
			browser.switchTo().frame(0);
			ReusableComponents.wait(4200);
			ReusableComponents.clickElement(Post_final, "Confirm post button");
			
			ReusableComponents.wait(4200);
			
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Posted Billing page", browser, pathLoc+"\\"+testcasemethod, true);
			
			ReusableComponents.wait(3200);
			
			String BillingStatus = Orginalstatus.getText();
			
			if(BillingStatus.equalsIgnoreCase("Posted")) {
				
				BillingactualStatus = true;
			} else {
				
				BillingactualStatus = false;
			}
			
			browser.switchTo().defaultContent();

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of billing line item" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

		return new T2612Page(browser);

	}
	
	/***
	 * Test case Method Name : Payable
	 * Functionality : validate T2687 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException 
	 * 
	 ***/
	public synchronized T2687Page Payable(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException, throwNewException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			browser.navigate().to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(6200);
			

			String Customer = reusableComponents.getPropValues("vendor");
			String PayeeReference = reusableComponents.getPropValues("ref2");
			String AccountingPeriod = reusableComponents.getPropValues("period22612");
			

			browser.switchTo().frame(0);

			ReusableComponents.clickElement(Payee_tab, "Payable tab");
			ReusableComponents.wait(5500);
				
			ReusableComponents.clickElement(New, "New button");
			ReusableComponents.wait(6500);

			WebElement element = browser.findElement(By.xpath("//span[normalize-space()='Payee Information']"));
			ReusableComponents.scrollInToElementJavaScript(browser, element);
						
			ReusableComponents.sendKey(Payee_Reference, PayeeReference, "Payee reference field");
			ReusableComponents.wait(2500);

			ReusableComponents.sendKey(Vendor_payables, Customer, "Vendor searchbox");
			ReusableComponents.wait(4200);

			WebElement Vendor_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='" + Customer + "']"));

			ReusableComponents.wait(2200);
			ReusableComponents.clickElement(Vendor_click, "Vendor select");
			ReusableComponents.wait(2200);
								
			ReusableComponents.sendKey(Period_input, AccountingPeriod, "Accounting Period searchbox");
			ReusableComponents.wait(3500);
									
			WebElement Period_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+AccountingPeriod+"']"));

			ReusableComponents.wait(2200);
			ReusableComponents.clickElement(Period_click, "Period select");
			ReusableComponents.wait(2200);

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Payable creation page", browser, pathLoc+"\\"+testcasemethod, true);
			
			ReusableComponents.wait(3200);
			ReusableComponents.clickElement(Save, "Save button");
			
			Pline_posting(threadID, tempList, pathLoc);
			
			browser.switchTo().defaultContent();
			
		} catch (NoSuchElementException e) {
	
	ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);

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
	 * @throws throwNewException 
	 * 
	 ***/
	public synchronized T2612Page Pline_posting(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException, throwNewException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			String Unitcost = reusableComponents.getPropValues("amount2");
			String ExpenseGLAccount = reusableComponents.getPropValues("bank");
			String AccountingVariable = reusableComponents.getPropValues("variable22612");
			String AccountingVariableType = reusableComponents.getPropValues("variabletype22612");
			
			String xpathtoAccountingVariable;
			
			switch (AccountingVariableType) {
			
			case "GL Account Variable 1":
				xpathtoAccountingVariable = "(//input[@placeholder='Search Accounting Variables...'])[1]";
				break;
			case "GL Account Variable 2":
				xpathtoAccountingVariable = "(//input[@placeholder='Search Accounting Variables...'])[2]";
				break;
			case "GL Account Variable 3":
				xpathtoAccountingVariable = "(//input[@placeholder='Search Accounting Variables...'])[3]";
				break;	
			case "GL Account Variable 4":
				xpathtoAccountingVariable = "(//input[@placeholder='Search Accounting Variables...'])[4]";
			case "Time Card Variable 1":
				xpathtoAccountingVariable = "(//input[@placeholder='Search Accounting Variables...'])[5]";
				break;
			case "Time Card Variable 2":
				xpathtoAccountingVariable = "(//input[@placeholder='Search Accounting Variables...'])[6]";
				break;	
					
			default:
				throw new throwNewException("Accounting variable", "Invalid Accounting variable type given");
		    }
			
			ReusableComponents.wait(6200);
			browser.navigate().refresh();
			ReusableComponents.wait(10500);
			ReusableComponents.scrollDownUsingPageDown(browser);
			ReusableComponents.wait(2000);
			ReusableComponents.scrollDownUsingPageDown(browser);
			ReusableComponents.wait(8500);
			
			ReusableComponents.clickElement(New_line, "New line button");
			ReusableComponents.wait(6500);

			ReusableComponents.sendKey(Unitcost_payables, Unitcost, "Unit cost field");
			ReusableComponents.wait(2500);

			ReusableComponents.scrollInToElementJavaScript(browser, Expense_GL_Account_payables);

			ReusableComponents.wait(3200);
			ReusableComponents.sendKey(Expense_GL_Account_payables, ExpenseGLAccount, "Expense gl account searchbox");
			ReusableComponents.wait(2500);

			WebElement Exp_gla_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[contains(@title,'" + ExpenseGLAccount + "')]"));
	
			ReusableComponents.wait(2200);
			ReusableComponents.clickElement(Exp_gla_click, "Select Expense gl account");
			ReusableComponents.wait(5200);
			
			WebElement Accounting_variable = browser.findElement(By.xpath(xpathtoAccountingVariable));
			
			ReusableComponents.scrollInToElementJavaScript(browser, Accounting_variable);
			
			ReusableComponents.sendKey(Accounting_variable, AccountingVariable, "Accounting variable input");
			
			WebElement GLvariable_click = browser.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"+AccountingVariable+"']"));

			ReusableComponents.wait(2200);
			ReusableComponents.clickElement(GLvariable_click, "Accounting variable select");
			ReusableComponents.wait(2200);
			
			ReusableComponents.clickElement(Save, "Save button");
			ReusableComponents.wait(5500);

			ReusableComponents.wait(3200);
			ReusableComponents.clickElement(Post, "Post button");
			ReusableComponents.wait(6500);

			browser.switchTo().frame(0);
						
			ReusableComponents.clickElement(Post_final, "Post finalise button");
			ReusableComponents.wait(5500);
			
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Posted Payable page", browser, pathLoc+"\\"+testcasemethod, true);
			ReusableComponents.wait(5200);

			String PayablesStatus = Orginalstatus.getText();
			
			if(PayablesStatus.equalsIgnoreCase("Posted")) {
				
				PayableactualStatus = true;
			} else {
				
				PayableactualStatus = false;
			}					

			browser.switchTo().defaultContent();

	
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of Payableline" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

return new T2612Page(browser);

}

	/***
	 * Test case Method Name : PnLreport Functionality : validate T2612 Page Created
	 * By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 * 
	 ***/
	public synchronized T2612Page PnLreport(int threadID, List<String> tempList, String pathLoc, String Startingperiod,
			String Endperiod) throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			browser.navigate()
					.to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
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

			ReusableComponents.clickElement(deselect_eperiod, "Deselect the Starting period selected");
			ReusableComponents.wait(3200);
			ReusableComponents.clickElement(deselect_speriod, "Deselect the Ending period selected");
			ReusableComponents.wait(3200);

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

		return new T2612Page(browser);

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
	public synchronized T2612Page Testcase2612(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			String GLAV1 = reusableComponents.getPropValues("variable12612");
			String GLAVT1 = reusableComponents.getPropValues("variabletype12612");
			String GLAV2 = reusableComponents.getPropValues("variable22612");
			String GLAVT2 = reusableComponents.getPropValues("variabletype22612");
			String Period1 = reusableComponents.getPropValues("period12612");
			String Period1_starting = reusableComponents.getPropValues("Startdate12612");
			String Period1_ending = reusableComponents.getPropValues("Enddate12612");
			String Period2 = reusableComponents.getPropValues("period22612");
			String Period2_starting = reusableComponents.getPropValues("Startdate22612");
			String Period2_ending = reusableComponents.getPropValues("Enddate22612");
			
			Login(threadID, tempList, pathLoc);

			GL_Account_variable1(threadID, tempList, pathLoc, GLAV1, GLAVT1);

			GL_Account_variable1(threadID, tempList, pathLoc, GLAV2, GLAVT2);

			Accounting_period_creation(threadID, tempList, pathLoc, Period1, Period1_starting, Period1_ending);

			Accounting_period_creation(threadID, tempList, pathLoc, Period2, Period2_starting, Period2_ending);
			
			Billing_creation(threadID, tempList, pathLoc);
			
			Payable(threadID, tempList, pathLoc);

			String strArray1[] = Period1.split("-");
			int year1 = Integer.parseInt(strArray1[0]);
			int month1 = Integer.parseInt(strArray1[1]);
			if (month1 <= 6) {
				year1 = year1 - 1;
				if (month1 == 1) {
					month1 = 12 - 5;
				}
				if (month1 == 2) {
					month1 = 12 - 4;
				}
				if (month1 == 3) {
					month1 = 12 - 3;
				}
				if (month1 == 4) {
					month1 = 12 - 2;
				}
				if (month1 == 5) {
					month1 = 12 - 1;
				}
				if (month1 == 6) {
					month1 = 12;
				}
			} else {
				month1 = month1 - 1;
			}
			String Startingperiod1;
			if (month1 <= 9) {
				Startingperiod1 = String.valueOf(year1) + "-" + "0" + String.valueOf(month1);
			} else {
				Startingperiod1 = String.valueOf(year1) + "-" + String.valueOf(month1);
			}
			
			if(BillingactualStatus==true) {
				
			PnLreport(threadID, tempList, pathLoc, Startingperiod1, Period1);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing is not posted, hence can not continue with the test case"
						 , browser, pathLoc + "\\" + testcasemethod, false);
			}

			String strArray2[] = Period2.split("-");
			int year2 = Integer.parseInt(strArray2[0]);
			int month2 = Integer.parseInt(strArray2[1]);
			if (month2 <= 6) {
				year2 = year2 - 1;
				if (month2 == 1) {
					month2 = 12 - 5;
				}
				if (month2 == 2) {
					month2 = 12 - 4;
				}
				if (month2 == 3) {
					month2 = 12 - 3;
				}
				if (month2 == 4) {
					month2 = 12 - 2;
				}
				if (month2 == 5) {
					month2 = 12 - 1;
				}
				if (month2 == 6) {
					month2 = 12;
				}
			} else {
				month2 = month2 - 1;
			}
			String Startingperiod2;
			if (month2 <= 9) {
				Startingperiod2 = String.valueOf(year2) + "-" + "0" + String.valueOf(month2);
			} else {
				Startingperiod2 = String.valueOf(year2) + "-" + String.valueOf(month2);
			}

			if(PayableactualStatus==true) {
				
			PnLreport(threadID, tempList, pathLoc, Startingperiod2, Period2);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Payable is not posted, hence can not continue with the test case"
						 , browser, pathLoc + "\\" + testcasemethod, false);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Error During execution of test case 2612" + e.toString(), browser, pathLoc + "\\" + testcasemethod,
					true);
		}

		return new T2612Page(browser);

	}

}
