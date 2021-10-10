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
public class PrerequisitesPage extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected PrerequisitesPage(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public PrerequisitesPage() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;

	@FindBy(xpath = "//a[@title='Accounts']/span")
	WebElement Accounts;

//@FindBy(xpath = "//div[contains(text(),'New')]")
//@FindBy(xpath = "//div[2]/ul[1]/li[1]/a[1]/div[@title='New']")
	@FindBy(xpath = "//ul[@class='branding-actions slds-button-group slds-m-left--xx-small oneActionsRibbon forceActionsContainer']//div[contains(text(),'New')]")
	WebElement New;

	@FindBy(xpath = "//force-record-layout-base-input//div[@class='slds-form-element__control slds-grow']/input[@name='Name']")
	WebElement Account_Name;

	@FindBy(xpath = "//force-record-layout-item[1]//lightning-combobox[1]//lightning-base-combobox[1]/div[1]/div[1]/input[1]")
	WebElement Account_type;

	@FindBy(xpath = "//span[@title='Customer and Vendor']")
	WebElement Account_type_select;

	@FindBy(xpath = "//span[@class='slds-checkbox slds-checkbox_standalone']/input[@name='AcctSeed__Accounting_Active__c']")
	WebElement Accounting_Active;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Save;

	@FindBy(xpath = "//li[@class='slds-tabs_default__item']/a[contains(text(),'Accounting')]")
	WebElement Accounting;

	//@FindBy(xpath = "//flexipage-component2[3]//button[@name='New']")
	@FindBy(xpath = "(//flexipage-component2[2]//button[@name='New'])[2]")
	WebElement New_Billing;
	
	@FindBy(xpath = "//force-record-layout-section[1]//force-record-layout-row[4]//input[1]")
    WebElement Posting_status;
	
	@FindBy(xpath = "//input[@name='AcctSeed__Date__c']")
	WebElement bill_date_enter;

//@FindBy(xpath = "//span[@id='window']")
//@FindBy(xpath = "//span[@data-proxy-id='aura-pos-lib-1']")
	@FindBy(xpath = "//force-lookup[@data-navigation='enable']//span[@id='window']")
	WebElement Existing_billing;

//@FindBy(xpath = "//flexipage-component2[@data-component-id='force_relatedListSingleContainer']//div//button[@name='New'][normalize-space()='New']")
//@FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/one-record-home-flexipage2[1]/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-acct-seed__-billing_-record_-home___-acct-seed__-billing__c___-v-i-e-w[1]/forcegenerated-flexipage_billing_record_home_acctseed__billing__c__view_js[1]/record_flexipage-record-page-decorator[1]/div[1]/records-record-layout-event-broker[1]/slot[1]/slot[1]/flexipage-record-home-simple-view-template2[1]/div[1]/div[2]/div[1]/slot[1]/slot[1]/flexipage-component2[1]/slot[1]/flexipage-tabset2[1]/div[1]/lightning-tabset[1]/div[1]/slot[1]/slot[1]/slot[1]/flexipage-tab2[1]/slot[1]/flexipage-component2[2]/slot[1]/lst-related-list-single-container[1]/laf-progressive-container[1]/slot[1]/lst-related-list-single-app-builder-mapper[1]/article[1]/lst-related-list-view-manager[1]/lst-common-list[1]/lst-list-view-manager-header[1]/div[1]/div[1]/div[3]/div[1]/runtime_platform_actions-actions-ribbon[1]/ul[1]/li[1]/runtime_platform_actions-action-renderer[1]/runtime_platform_actions-executor-aura-legacy[1]/slot[1]/slot[1]/lightning-button[1]/button[1]")
//html[1]/body[1]/div[4]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]/div[1]
//@FindBy(xpath = "//button[contains(text(),'New')]")
	@FindBy(xpath = "//html[1]/body[1]/div[4]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]/div[1]")
	WebElement New_Billing_line;

	@FindBy(xpath = "//body/div[4]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/one-record-home-flexipage2[1]/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___-acct-seed__-billing_-record_-home___-acct-seed__-billing__c___-v-i-e-w[1]/forcegenerated-flexipage_billing_record_home_acctseed__billing__c__view_js[1]/record_flexipage-record-page-decorator[1]/div[1]/records-record-layout-event-broker[1]/slot[1]/slot[1]/flexipage-record-home-simple-view-template2[1]/div[1]/div[2]/div[1]/slot[1]/slot[1]/flexipage-component2[1]/slot[1]/flexipage-tabset2[1]/div[1]/lightning-tabset[1]/div[1]/slot[1]/slot[1]/slot[1]/flexipage-tab2[1]/slot[1]/flexipage-component2[1]/slot[1]/records-lwc-detail-panel[1]/records-base-record-form[1]/div[1]/div[1]/div[1]/div[1]/records-lwc-record-layout[1]/forcegenerated-detailpanel_acctseed__billing__c___012000000000000aaa___full___view___recordlayout2[1]/force-record-layout-block[1]/slot[1]/force-record-layout-section[7]/div[1]/h3[1]/button[1]/span[2]")
	WebElement alternate_scroll;

	@FindBy(xpath = "//span[contains(text(),'Billing Lines')]")
	WebElement Billing_line_click;

	@FindBy(xpath = "//div/input[@name='AcctSeed__Rate__c']")
	WebElement Unit_price;

	@FindBy(xpath = "//div/input[@name='AcctSeed__Hours_Units__c']")
	WebElement Quantity;

	//@FindBy(xpath = "//button[contains(text(),'Post')]")
	//WebElement Post_tab;
	
	@FindBy(xpath = "//div[@class='highlights slds-clearfix slds-page-header slds-page-header_record-home fixed-position']//div[@class='slds-grid primaryFieldRow']//div[@class='slds-col slds-no-flex slds-grid slds-grid_vertical-align-center horizontal actionsContainer']//div//button[@type='button'][normalize-space()='Post']")
	WebElement Post_tab;
	
	//@FindBy(xpath = "//tbody/tr/td[2]//input[@class='btn'][@value='Post'][@name='j_id0:theForm:j_id10:j_id37:bottom:j_id38']")
	@FindBy(xpath = "//div[@class='apexp']/div/div/div/div/table/tbody/tr/td[2]//input[@class='btn'][@name='j_id0:theForm:j_id10:j_id37:j_id38']")
	WebElement Post_final;

	//@FindBy(xpath = "//div[@class='slds-grid']//h1[contains(text(),'Billing Lines')]")
	@FindBy(xpath = "//body//div[@class='fullheight center oneCenterStage mainContentMark']//div[@class='slds-grid']/div[2]/ul[@class='branding-actions slds-button-group slds-m-left--xx-small small oneActionsRibbon forceActionsContainer']/li[1]/a")
	WebElement billing_line_text;
	
	@FindBy(xpath = "//article[@class='slds-card slds-card_boundary']//div[@class='slds-page-header slds-page-header_joined slds-page-header_bleed slds-shrink-none test-headerRegion slds-is-relative slds-page-header-no-border']/div[@class='slds-grid slds-media slds-media--center slds-has-flexi-truncate']/div[3]/div[1]//ul[@class='slds-button-group-list']/li[1]//button[@name='New']")
	WebElement billing_line_item_new;
	
	//payables
	
	@FindBy(xpath = "//span[@class='uiImage']/img[@src='/img/icon/t4v35/custom/custom14_120.png']")
	WebElement Payee_tab;

	@FindBy(xpath = "//div[@title='New']")
	WebElement New_p;

	@FindBy(xpath = "//div[@class='slds-form']//force-record-layout-row[3]//force-record-layout-item//lightning-combobox//input[@class='slds-input slds-combobox__input']")
	WebElement Posting_status_p;

	@FindBy(xpath = "//span[@title='Approved']")
	WebElement Status;

	@FindBy(xpath = "//input[@name='AcctSeed__Payee_Reference__c']")
	WebElement Payee_Reference;

	@FindBy(xpath = "//force-record-layout-row[1]/slot[1]/force-record-layout-item[1]//force-record-layout-lookup[1]//input[1]")
	WebElement Vendor;

	// @FindBy(xpath = "//button[@name='New']")
	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement New_PLine;

	@FindBy(xpath = "//input[@name='AcctSeed__Unit_Cost__c']")
	WebElement Unit_cost;

	@FindBy(xpath = "//force-record-layout-row[1]//force-record-layout-item[1]//force-record-layout-lookup[1]//lightning-grouped-combobox[1]//lightning-base-combobox[1]//input[1]")
	WebElement Expense_GL_Account;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Save_p;

	@FindBy(xpath = "//button[.='Post']")
	WebElement Post;

	@FindBy(xpath = "//div[@class='pbHeader']//tbody//input[@value='Post']")
	WebElement Post_final_p;

	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();
	ArrayList<String> input_arr = new ArrayList<String>();
	
	// arrays for prerequisites
	ArrayList<String> financial_reports = new ArrayList<String>();
	ArrayList<String> Account_info = new ArrayList<String>();
	ArrayList<String> Billing_info = new ArrayList<String>();
	ArrayList<String> Billing_line_info = new ArrayList<String>();
	ArrayList<String> Payables_info = new ArrayList<String>();
	ArrayList<String> GL_Account_info = new ArrayList<String>();
	ArrayList<String> Payable_lines_info = new ArrayList<String>();
	ArrayList<String> Cash_disb_batch = new ArrayList<String>();
	ArrayList<String> Cash_disb_info = new ArrayList<String>();
	ArrayList<String> Cash_receipts_info = new ArrayList<String>();
	
	
	//basic input
	ArrayList<String> basic_input= new ArrayList<String>();
	
	String username = null, pass_login = null;
	String urlfromexcel=null;

	SendEmail s = new SendEmail();
	
	// variables for financial reports
	String Budget_Ledger=null,Ledger=null,Start_date=null,End_date=null,supress_zero_amount_rows=null,supress_subtype1=null,supress_subtype2=null;
	String Show_all_periods=null,Report_roundin=null,Accounting_Period_FR=null,GL_Account=null,Source=null,Aggregated_By=null;
	
	// variables for account
	String Parent_Account=null,Account_Name1=null,Account_type1=null,Account_active=null;
	
	//billing variables
	String Customer_billing=null,Posting_Status=null,Billing_Date=null,Accounting_period_billing=null;

	//billing line variables
	String Billing_line_date=null,Billing_BL=null,Quantity_billing=null,UnitPrice=null;

	//payable variables
	String Posting_Status_P=null,Payee_reference=null,Vendor_P=null,contact_P=null,employee_P=null,Accounting_period_P=null,issue_date_P=null;

	//gl account variables
	String GL_Account_name=null,Type_GL=null,Sub_type_1_GL=null,Bank_account_GL=null;

	//payable lines
	String Payable_PL=null,Date_PL=null,Unit_cost_PL=null,Expense_GL_Account_PL=null;

	//cash disb batch variables
	String batch_name_CDB=null;

	//cash disb variables
	String Batch_name_CD=null,type_CD=null,source_CD=null,disbursement_date_CD=null,Posting_Status_CD=null,Accounting_period_CD=null,payment_status_CD=null,amount_CD=null,Bank_account_CD=null;

	//cash receipt variables
	String Receipt_date_CR=null,type_CR=null,Accounting_period_CR=null,Amount_CR=null,Posting_Status_CR=null,Reference_CR=null;

	String billing_line_new = null, billing_line_pass =null,account_name = null, account_type=null, Accountname_final=null, billing_line_item_name=null,account_active=null;

	/***
	 * Test case Method Name : validateTestA 
	 * Functionality : validate Secondday Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized PrerequisitesPage validateTestA(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		testcasemethod = "Salesforce login";
		try {
			//String username = null, pass_login = null;

			// browser.switchTo().defaultContent();

			//username = reusableComponents.getPropValues("usernamesf");
			//pass_login = reusableComponents.getPropValues("passwordsf");

			ReusableComponents.wait(2300);

			if (ReusableComponents.isElementPresent(Username_field)) {
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "salesforce login field is identified, inserting username dynamically", browser ,pathLoc+"/"+testcasemethod , false );
				ReusableComponents.wait(1200);
				// ReusableComponents.reportPass( threadID , tempList , testcasemethod ,
				// "login_user_field is present", browser ,pathLoc+"/"+testcasemethod , false
				// );

				Username_field.sendKeys(username);
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "salesforce login username entered successfully", browser ,pathLoc+"/"+testcasemethod , false );

				if (ReusableComponents.isElementPresent(Password_field)) {

					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "salesforce password is identified, inserting password dynamically", browser ,pathLoc+"/"+testcasemethod , false );
					Password_field.sendKeys(pass_login);
					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "salesforce password is entered successfully", browser ,pathLoc+"/"+testcasemethod , false );
					ReusableComponents.wait(1200);

					if (ReusableComponents.isElementPresent(Login_button)) {

						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "salesforce login btn is identified, inserting password dynamically", browser ,pathLoc+"/"+testcasemethod , false );
						ReusableComponents.wait(1200);
						Login_button.click();
						ReusableComponents.wait(15500);
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "salesforce login btn is clicked successfully", browser ,pathLoc+"/"+testcasemethod , false );

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"login button is NOT present successfully", browser, pathLoc + "/" + testcasemethod,
								true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"password field is NOT present successfully", browser, pathLoc + "/" + testcasemethod,
							true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"login_user_field is NOT present successfully", browser, pathLoc + "/" + testcasemethod, true);
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new PrerequisitesPage(browser);
	}

	/***
	 * Test case Method Name : validateTestB 
	 * Functionality : validate Secondday Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized PrerequisitesPage validateTestB(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		testcasemethod = "Accounts page";
		
		//String acc_name = null, acc_type = null, acc_active =null;
		
		try {
			
			
			
			String dt_pattern = "YYMMddhhmmss";
			DateTimeFormatter cdt = DateTimeFormatter.ofPattern(dt_pattern);
			LocalDateTime now = LocalDateTime.now();

			// browser.switchTo().defaultContent();

			//account_name = input_arr.get(0);
			account_type = Account_type1;
			account_active = Account_active;
			//account_name = reusableComponents.getPropValues("accountname");
			account_name = Account_Name1;
			account_name = account_name + cdt.format(now);
			
			Accountname_final = account_name;

			ReusableComponents.wait(5300);

			if (ReusableComponents.isElementPresent(Accounts)) {
				
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, testcasemethod+"Account page validation", browser, pathLoc + "/" + testcasemethod, true);
				ReusableComponents.wait(5200);
				// Accounts.click();

				JavascriptExecutor executor = (JavascriptExecutor) browser;
				executor.executeScript("arguments[0].click();", Accounts);
				ReusableComponents.wait(5200);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "inside the Accounts module", browser,
						pathLoc + "/" + testcasemethod, false);

				if (ReusableComponents.isElementPresent(New)) {

					ReusableComponents.wait(5200);
					New.click();
					ReusableComponents.wait(8200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New is present, select to create new Account", browser,
							pathLoc + "/" + testcasemethod, false);
					
					//implementng scroll into view
					System.out.println("before");
					WebElement element = browser.findElement(By.xpath("//span[contains(text(),'Accounting Information')]"));
					((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
					ReusableComponents.wait(5200);
					System.out.println("after");

					if (ReusableComponents.isElementPresent(Account_Name)) {
						
						ReusableComponents.wait(6200);
						Account_Name.sendKeys(Accountname_final);
						ReusableComponents.wait(8200);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Account Name field is present and the value posted is "+Accountname_final,
								browser, pathLoc + "/" + testcasemethod, false);
						
						
						if (ReusableComponents.isElementPresent(Account_type)) {

							ReusableComponents.wait(5200);
							Account_type.click();
							ReusableComponents.wait(8200);
							Account_type.click();
							ReusableComponents.wait(8200);
							
							//"//span[@title='"+account_type+"']"
							WebElement accounttype = browser.findElement(By.xpath("//span[contains(text(),'"+account_type+"')]"));
							String account_type_value = "//span[@title='"+account_type+"']";

							if (ReusableComponents.isElementPresent(accounttype)) {

								ReusableComponents.wait(4200);
								new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(accounttype)).click();
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Account type selection is detected dynamically and the value is"+account_type, browser, pathLoc + "/" + testcasemethod,	false);

								if (ReusableComponents.isElementPresent(Accounting_Active)) {

									
									if(account_active.equalsIgnoreCase("YES")) {
										
										ReusableComponents.wait(5200);
										Accounting_Active.click();
										ReusableComponents.wait(8200);
									}
									
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Accounting Active is present and the selection is "+account_active, browser, pathLoc + "/" + testcasemethod, false);


								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Accounting Active selection is not present", browser,
											pathLoc + "/" + testcasemethod, true);
								}
								
								
								// making account active as independent identifier
								
								if (ReusableComponents.isElementPresent(Save)) {

									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, testcasemethod+"Account page final validation check", browser, pathLoc + "/" + testcasemethod, true);
									ReusableComponents.wait(8200);
									Save.click();
									ReusableComponents.wait(8200);
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Save button is present and the account will be saved", browser, pathLoc + "/" + testcasemethod, false);
									ReusableComponents.wait(8200);
								//	enddate_arr.add(Accountname_final);
								//	enddate_arr.add(account_type);
								//	enddate_arr.add(account_active);

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Save selection is not present", browser,
											pathLoc + "/" + testcasemethod, true);
								}
								

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"Account type selection is not present", browser,
										pathLoc + "/" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"Account type is not present", browser, pathLoc + "/" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account name is not present",
								browser, pathLoc + "/" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "New is not present", browser,
							pathLoc + "/" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account tab not present", browser,
						pathLoc + "/" + testcasemethod, true);
			}
			
			
		//	validateTestExcelWrite(threadID, tempList, pathLoc);

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			e.printStackTrace();
		}

		return new PrerequisitesPage(browser);
	}

	/***
	 * Test case Method Name : validateTestC 
	 * Functionality : validate Secondday Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized PrerequisitesPage validateTestC(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		testcasemethod = "Billing page";
		try {

			String post_status = Posting_Status;
			String billing_date = Billing_Date;
			ReusableComponents.wait(2300);
//
//			if (ReusableComponents.isElementPresent(Accounting)) {
//
//				ReusableComponents.wait(7200);
//				Accounting.click();
//				ReusableComponents.wait(8200);
//				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Navigating to Accounting Tab for Billing page", browser,
//						pathLoc + "/" + testcasemethod, false);

				if (ReusableComponents.isElementPresent(New_Billing)) {
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Accounting page validation", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.wait(4200);
					New_Billing.click();
					ReusableComponents.wait(8200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New Billing is identified and clicked to create billing under the account", browser,
							pathLoc + "/" + testcasemethod, false);
					
					
					// to select the status
					
					if (ReusableComponents.isElementPresent(Posting_status)) {
						//ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Billing page validation before saving the details", browser, pathLoc + "/" + testcasemethod, false);
						ReusableComponents.wait(2200);
						Posting_status.click();
						ReusableComponents.wait(2200);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Posting status is selected to create new billing", browser,
								pathLoc + "/" + testcasemethod, false);
						
						// dynamically enter the billing status here from the excel
						
						WebElement billing_status = browser.findElement(By.xpath("//span[@title='"+post_status+"']"));
						
						if (ReusableComponents.isElementPresent(billing_status)) {
							
							ReusableComponents.wait(2200);
							billing_status.click();
							ReusableComponents.wait(2200);
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "billing status is selected and the current status is"+post_status, browser,
									pathLoc + "/" + testcasemethod, false);

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"Save selection is not present", browser, pathLoc + "/" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Save selection is not present", browser, pathLoc + "/" + testcasemethod, true);
					}
					
					
					//bill_date_enter
					
					if (ReusableComponents.isElementPresent(bill_date_enter)) {
						
						ReusableComponents.wait(2200);
						
						bill_date_enter.clear();
						ReusableComponents.wait(2200);
						bill_date_enter.sendKeys(billing_date);
						
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "billing date is updated before saving", browser,
								pathLoc + "/" + testcasemethod, false);

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Save selection is not present", browser, pathLoc + "/" + testcasemethod, true);
					}
					

					if (ReusableComponents.isElementPresent(Save)) {
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Billing page validation before saving the details", browser, pathLoc + "/" + testcasemethod, false);
						ReusableComponents.wait(12200);
						Save.click();
						ReusableComponents.wait(5200);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save is selected to create new billing", browser,
								pathLoc + "/" + testcasemethod, false);
						
						browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
						ReusableComponents.wait(3200);
						browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
						ReusableComponents.wait(3200);

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Save selection is not present", browser, pathLoc + "/" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"New Billing selection is not present", browser, pathLoc + "/" + testcasemethod, true);
				}

//			} else {
//				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Accounting selection is not present",
//						browser, pathLoc + "/" + testcasemethod, true);
//			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new PrerequisitesPage(browser);
	}

	/***
	 * Test case Method Name : validateTestD 
	 * Functionality : validate Secondday Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized PrerequisitesPage validateTestD(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		testcasemethod = "-";
		try {

			int count = 0, check = 0, lineitem_counter=0;

			//String price = reusableComponents.getPropValues("unitprice");
			//String quantity = reusableComponents.getPropValues("quantity");
			String price = UnitPrice;
			String quantity = Quantity_billing;
		//	String xpather = "//html[1]/body[1]/div[4]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]/div[1]";

			ReusableComponents.wait(7300);

			browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
			ReusableComponents.wait(3200);
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
			ReusableComponents.wait(3200);
//
//			List<WebElement> billing_rows = browser.findElements(By.xpath(
//					"//table[@class='slds-table slds-table_header-fixed slds-table_bordered slds-table_edit slds-table_resizable-cols']/tbody[1]/tr"));
			System.out.println("before dyn xpath");
			List<WebElement> billing_rows = browser.findElements(By.xpath(
					"//table[@class='slds-table slds-table_header-fixed slds-table_bordered slds-table_edit']/tbody[1]/tr"));
System.out.println(count);
			count = billing_rows.size();
			//count = count-2;
count = 1;
			// This is a dynamic xpath
			WebElement billing_click = browser.findElement(By.xpath(
					"//table[@class='slds-table slds-table_header-fixed slds-table_bordered slds-table_edit']/tbody[1]/tr["
							+ count + "]/th[1]//span/div"));

			if (ReusableComponents.isElementPresent(billing_click)) {

				billing_line_new = billing_click.getText();
				
				System.out.println("billing line new "+billing_line_new);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "billing click is present and clicking on "+billing_line_new, browser,
						pathLoc + "/" + testcasemethod, false);
				//enddate_arr.add(billing_line_new);
				ReusableComponents.wait(5200);
				billing_click.click();

				// ReusableComponents.reportPass( threadID , tempList , testcasemethod ,
				// "billing_click is present "+billing_line_new, browser
				// ,pathLoc+"/"+testcasemethod , false );
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "billing clicked for the specific billing", browser,
						pathLoc + "/" + testcasemethod, false);
				ReusableComponents.wait(12200);

				JavascriptExecutor js = (JavascriptExecutor) browser;
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

				browser.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

				ReusableComponents.wait(8200);

				browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_UP);
				ReusableComponents.wait(3200);
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_UP);
				ReusableComponents.wait(3200);
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_UP);
				ReusableComponents.wait(3200);
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_UP);
				ReusableComponents.wait(3200);
				browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_UP);
				ReusableComponents.wait(3200);


				// click on billing line link instead of billing new btn

				
				  if (ReusableComponents.isElementPresent(Billing_line_click)) {
				  
					  ReusableComponents.reportPass(threadID, tempList, testcasemethod, "billing line click is identified, to create new billing line item ", browser, pathLoc + "/" + testcasemethod, false);
					  Billing_line_click.click(); 
					  ReusableComponents.wait(8200);
				  
				  if (ReusableComponents.isElementPresent(billing_line_text)) {
				  
				  System.out.println("here in billing " + billing_line_text.getText());
				  ReusableComponents.reportPass(threadID, tempList, testcasemethod, "billing line text is identified, to create new billing line item "+billing_line_text.getText(), browser, pathLoc + "/" + testcasemethod, false);
				  ReusableComponents.wait(3200); 
				  billing_line_text.click(); 
				  check++;
				  
				  ReusableComponents.wait(13200);
				  
				  } else { ReusableComponents.reportFail(threadID, tempList, testcasemethod,
				  "billing line text selection is not present", browser, pathLoc + "/" +
				  testcasemethod, true); }
				  
				  
				  
				  try { if (check != 0) {
				  
				  ReusableComponents.wait(20200);
				  if(ReusableComponents.isElementPresent(Unit_price)) {
					  
					  ReusableComponents.wait(10200); Unit_price.sendKeys(price);
					  ReusableComponents.wait(5200);
					  ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Unit price is identified and passed with "+price, browser, pathLoc + "/" + testcasemethod, false);
				  
				  if (ReusableComponents.isElementPresent(Quantity)) {
				  
				  ReusableComponents.wait(5200); Quantity.clear(); Quantity.sendKeys(quantity);
				  ReusableComponents.wait(3200); ReusableComponents.reportPass(threadID,
				  tempList, testcasemethod, "Quantity is identified and passed with value "+quantity, browser, pathLoc + "/" + testcasemethod, false);
				  
				  if (ReusableComponents.isElementPresent(Save)) {
					  
					  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Billing line item page validation", browser, pathLoc + "/" + testcasemethod, false);
				  
				  ReusableComponents.wait(5200); Save.click(); ReusableComponents.wait(8200);
				  ReusableComponents.reportPass(threadID, tempList, testcasemethod,
				  "Save is identified, creating new billing line item", browser, pathLoc + "/" + testcasemethod, false);
				  
				  //dynamic element to go back to billing page
				  
				  startdate_arr = billing_line_new.split(" ");
				  startdate_arr[0] = startdate_arr[0].replaceAll("[^0-9]", "");
				  startdate_arr[0] = startdate_arr[0].replaceAll("/s", "");
				  
				  ReusableComponents.wait(5200);
				  
				  billing_line_pass = startdate_arr[0];
				  System.out.println("post update "+billing_line_pass);
				  //enddate_arr.add(billing_line_pass);
  
				  WebElement billing_return_back = browser.findElement(By.xpath("//a[@title='" + startdate_arr[0] + "']/parent::*"));
				  
				  if (ReusableComponents.isElementPresent(billing_return_back)) {
				  
					  ReusableComponents.wait(3200); 
					  billing_return_back.click();
					  ReusableComponents.wait(5200);
				  
					  ReusableComponents.wait(3200); 
					  ReusableComponents.reportPass(threadID, tempList, testcasemethod, "return back is identified and clicked to navigate to - billing page, where we post the billing", browser, pathLoc + "/" +  testcasemethod, false);
				  
				  //post method if (ReusableComponents.isElementPresent(Post_tab)) {
				  
					  ReusableComponents.wait(7200); 
					  Post_tab.click();
					  ReusableComponents.wait(12200); 
					  ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Post tab is validated and cliced to post the billing", browser, pathLoc + "/" + testcasemethod, false);
				  
					  browser.switchTo().frame(0);
					  ReusableComponents.wait(7200); 
					  
					  if (ReusableComponents.isElementPresent(Post_final)) {
						  
						  ReusableComponents.wait(9200); 

							JavascriptExecutor executor = (JavascriptExecutor) browser;
							executor.executeScript("arguments[0].click();", Post_final);
						 //new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(Post_final)).click();
						 // Post_final.click();
						  ReusableComponents.wait(12200); 
						  ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Post is identified inside frame and clicking it", browser, pathLoc + "/" + testcasemethod, false);
				  
						  
					  	}
					  else {
						  ReusableComponents.reportFail(threadID, tempList, testcasemethod, "post final selection is not present", browser, pathLoc + "/" +testcasemethod, true);
					  			}
					  
					  browser.switchTo().defaultContent();
					  
				  	}
				  else {
					  ReusableComponents.reportFail(threadID, tempList, testcasemethod, "billing return selection is not present", browser, pathLoc + "/" +testcasemethod, true);
				  			}
				  
				  }
				  else {
					  ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Post_tab selection is not present", browser, pathLoc + "/" +testcasemethod, true);
				  		}
				  
				  }
				  else {
					  ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save selection is not present", browser, pathLoc + "/" + testcasemethod, true);
				  }
				  
				  }
				  else {
					  ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Quantity selection is not present", browser, pathLoc + "/" + testcasemethod, true);
					  }
				  
				  }
				  else {
					  ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Unit_price selection is not present", browser, pathLoc + "/" + testcasemethod, true);
					  }
				  }
				  catch (Exception e) {
					  // TODO Auto-generated catch block
					  e.printStackTrace();
					  }
				  
				  }
				  else {
					  ReusableComponents.reportFail(threadID, tempList, testcasemethod, "billing line select selection is not present", browser, pathLoc + "/" + testcasemethod, true);
				  }

			}
			else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "billing selection is not present",	browser, pathLoc + "/" + testcasemethod, true);
				}

		}
		catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, " Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			}

		return new PrerequisitesPage(browser);
	}
	
	
	//this method is to read and write excel
	
	/***
	 * Test case Method Name : validateTestExcelRead 
	 * Functionality : validate Secondday Page
	 * Created By : Subramanya MS
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized PrerequisitesPage validateTestExcelRead(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		String testcasemethod = new Object() {
		
		}.getClass().getEnclosingMethod().getName();
		
		
		try {

			String filename = reusableComponents.getPropValues("Financialreportsinput");
			String sheetname = reusableComponents.getPropValues("Financialreportsinputsheet");
			
			//String outfilename = reusableComponents.getPropValues("outputfilename");
			//String outsheetname = reusableComponents.getPropValues("outputsheetname");

			File file = new File(workingDir + "/input/" + filename);
			FileInputStream istream = new FileInputStream(file);

			Workbook myworkbook = null;

			String fileExtensionName = filename.substring(filename.indexOf("."));

			if (fileExtensionName.equals(".xlsx")) {
				// If it is xlsx file then create object of XSSFWorkbook class
				myworkbook = new XSSFWorkbook(istream);
			}
			// Check condition if the file is xls file
			else if (fileExtensionName.equals(".xls")) {
				// If it is xls file then create object of HSSFWorkbook class
				myworkbook = new HSSFWorkbook(istream);
			}

			Sheet workbooksheet = myworkbook.getSheet(sheetname);
			int rowCount = workbooksheet.getLastRowNum() - workbooksheet.getFirstRowNum();
			int columnCount = workbooksheet.getRow(0).getLastCellNum();
			System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);

			/*
			 * // read rows and columns
			 * 
			 * for(int i=0; i<rowCount+1; i++) {
			 * 
			 * XSSFRow row = (XSSFRow) workbooksheet.getRow(i);
			 * 
			 * 
			 * for(int j=0;j<columnCount; j++) { System.out.println("Row is " +i +
			 * " column is " +j ); System.out.println(); if(i==0 && j==0) { continue; }
			 * if(i==0 && j==1) { continue; } if(i==0 && j==2) { continue; } XSSFCell cell =
			 * row.getCell(j); String data = cell.getStringCellValue();
			 * System.out.print(data); System.out.print(" "); } System.out.println(); }
			 * 
			 */
			
			/*
			for(int i=0;i<rowCount+1;i++) {
				
				HSSFRow row = (HSSFRow) workbooksheet.getRow(i);
				
				for(int j=0;j<columnCount+1;j++) {
					
					System.out.println("Row is " +i + " column is " +j ); 
					System.out.println();
					
										
					HSSFCell cell = row.getCell(j);
					final DataFormatter formatter = new DataFormatter(); 
					String data = formatter.formatCellValue(cell);
					System.out.print(data); 
					System.out.print(" "); 
					
					
				}
				
				System.out.println();
				
				
			}*/
			
			  Iterator<Row> itr = workbooksheet.iterator();
			  
			  while(itr.hasNext()) { 
				  Row row = itr.next();
				 
				  
				  if(row.getRowNum()==0){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum()==1){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum() == 2) {
						  
						  Iterator<Cell> celliterator = row.cellIterator();
						  
						  while(celliterator.hasNext()) {
						  						  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter();
						  
						  financial_reports.add(formatter.formatCellValue(cell)); //throw new
						  
						  
						  } 
						  }
						 
							
							  if(row.getRowNum()==3){ continue; 
							   } if(row.getRowNum()==4){ continue; 
							   }
							 
				  if(row.getRowNum() == 5) {
						  
						  Iterator<Cell> celliterator = row.cellIterator();
						  
						  while(celliterator.hasNext()) {
						  						  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter();
						  
						  Account_info.add(formatter.formatCellValue(cell)); //throw new
						  
						  
						  
						  } 
						  }
				  
				  

							
							  if(row.getRowNum()==6){ continue; 
							   } if(row.getRowNum()==7){ continue; 
							  }
							 
				  if(row.getRowNum() == 8) {
						  
						  Iterator<Cell> celliterator = row.cellIterator();
						  
						  while(celliterator.hasNext()) {
						  						  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter();
						  
						  Billing_info.add(formatter.formatCellValue(cell)); //throw new
						  
						  
						  
						  } 
						  }
				  

				  
				  
				  if(row.getRowNum()==9){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum()==10){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum() == 11) {
						  
						  Iterator<Cell> celliterator = row.cellIterator();
						  
						  while(celliterator.hasNext()) {
						  						  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter();
						  
						  Billing_line_info.add(formatter.formatCellValue(cell)); //throw new
						 
						  
						  
						  } 
						  }
				  
				  
				  if(row.getRowNum()==12){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum()==13){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum() == 14) {
						  
						  Iterator<Cell> celliterator = row.cellIterator();
						  
						  while(celliterator.hasNext()) {
						  						  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter();
						  
						  Payables_info.add(formatter.formatCellValue(cell)); //throw new
						  
						  
						  } 
						  }
				  if(row.getRowNum()==15){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum()==16){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum() == 17) {
						  
						  Iterator<Cell> celliterator = row.cellIterator();
						  
						  while(celliterator.hasNext()) {
						  						  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter();
						  
						  GL_Account_info.add(formatter.formatCellValue(cell)); //throw new
						  
						  
						  } 
						  }
				  if(row.getRowNum()==18){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum()==19){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum() == 20) {
						  
						  Iterator<Cell> celliterator = row.cellIterator();
						  
						  while(celliterator.hasNext()) {
						  						  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter();
						  
						  Payable_lines_info.add(formatter.formatCellValue(cell)); //throw new
						  
						  
						  } 
						  }
				  if(row.getRowNum()==21){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum()==22){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum() == 23) {
						  
						  Iterator<Cell> celliterator = row.cellIterator();
						  
						  while(celliterator.hasNext()) {
						  						  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter();
						  
						  Cash_disb_batch.add(formatter.formatCellValue(cell)); //throw new
						  
						  
						  } 
						  }
				  if(row.getRowNum()==24){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum()==25){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum() == 26) {
						  
						  Iterator<Cell> celliterator = row.cellIterator();
						  
						  while(celliterator.hasNext()) {
						  						  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter();
						  
						  Cash_disb_info.add(formatter.formatCellValue(cell)); //throw new
						  
						  
						  } 
						  }
				  if(row.getRowNum()==27){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum()==28){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				  if(row.getRowNum() == 29) {
						  
						  Iterator<Cell> celliterator = row.cellIterator();
						  
						  while(celliterator.hasNext()) {
						  						  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter();
						  
						  Cash_receipts_info.add(formatter.formatCellValue(cell)); //throw new
						  
						  
						  } 
						  }
				  
			  
			  
					
						/*
						 * Iterator<Cell> celliterator = row.cellIterator();
						 * 
						 * while(celliterator.hasNext()) {
						 * 
						 * 
						 * Cell cell = celliterator.next(); 
						 * final DataFormatter formatter = new DataFormatter();
						 * 
						 * financial_reports.add(formatter.formatCellValue(cell)); //throw new
						 * 
						 * 
						 * }
						 */
					 
				  
			  }
			 
		
			// lets print the array elements
			
			for (int i=0; i< financial_reports.size();i++) {
				/*
				 * if(i==0) { continue; }if(i==1) { continue; } else {
				 * System.out.println("printing values "+input_arr.get(i)); }
				 */
				
				if(financial_reports.get(i) == null || financial_reports.get(i) == "" || financial_reports.get(i) == " ") {
					
					System.out.println("printing values blank only");
				}else {
					System.out.println("printing values in fin reports "+financial_reports.get(i)+" i is "+i);
				}
				
				
				
			}
			
			
			for (int i=0; i< Account_info.size();i++) {
				/*
				 * if(i==0) { continue; }if(i==1) { continue; } else {
				 * System.out.println("printing values "+input_arr.get(i)); }
				 */
				
				if(Account_info.get(i) == null || Account_info.get(i) == "" || Account_info.get(i) == " ") {
					
					System.out.println("printing values blank only");
				}else {
					System.out.println("printing values acc info "+Account_info.get(i)+ " i "+i);
				}
				
				
				
			}
			
			  Account_Name1=Account_info.get(1);
			  Account_type1=Account_info.get(2);
			  Account_active=Account_info.get(3);
			
			for (int i=0; i< Billing_info.size();i++) {
				/*
				 * if(i==0) { continue; }if(i==1) { continue; } else {
				 * System.out.println("printing values "+input_arr.get(i)); }
				 */
				
				if(Billing_info.get(i) == null || Billing_info.get(i) == "" || Billing_info.get(i) == " ") {
					
					System.out.println("printing values blank only");
				}else {
					System.out.println("printing values billing info "+Billing_info.get(i)+ " i "+i);
				}
				
				
				
			}
			
			  Posting_Status=Billing_info.get(1);
			  Billing_Date=Billing_info.get(2);
			  
			  Quantity_billing=Billing_line_info.get(2);
			  UnitPrice=Billing_line_info.get(3);
			  
			  
			  Posting_Status_P = Payable_lines_info.get(0);
			  Payee_reference = Payable_lines_info.get(1);
			  // enter excel details of the url read

			  Unit_cost_PL = Payable_lines_info.get(2);
			  Expense_GL_Account_PL = Payable_lines_info.get(3);
			
			//validateTestA(threadID, tempList, pathLoc);
			  
		
			validateTestB(threadID, tempList, pathLoc);
			validateTestC(threadID, tempList, pathLoc);
			validateTestD(threadID, tempList, pathLoc);
			
			//navigate back to accounting home
			
			browser.navigate().to(urlfromexcel);
			
			payables(threadID, tempList, pathLoc);
			validateTestC_payables(threadID, tempList, pathLoc);
			
			
			
			

		} catch (NoSuchElementException e) {
		
		}
		
		

		return new PrerequisitesPage(browser);
	}
	
	
	/*** Test case Method Name : payables
	 * 	 Functionality         : validate payables page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PrerequisitesPage payables(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "payables flow";
	try{ 
		


		String status_p = Posting_Status_P;
		String account_name = Accountname_final;
		String pref = Payee_reference;

		ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"/"+testcasemethod, true);
		ReusableComponents.wait(3200);

		List<WebElement> f = browser.findElements(By.tagName("frame"));
		int i = f.size();
		System.out.println(i + "is the frame count");

		browser.switchTo().frame(0);

		ReusableComponents.wait(6200);

		if (ReusableComponents.isElementPresent(Payee_tab)) {

			ReusableComponents.wait(3200);
			Payee_tab.click();
			ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Payable tab is present", browser, pathLoc + "/" + testcasemethod, false);
			ReusableComponents.wait(5500);

			if (ReusableComponents.isElementPresent(New_p)) {
				
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Payables page", browser, pathLoc+"/"+testcasemethod, true);
				ReusableComponents.wait(3200);
				New_p.click();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New Payable button is present", browser, pathLoc + "/" + testcasemethod, false);
				ReusableComponents.wait(6500);

				if (ReusableComponents.isElementPresent(Posting_status_p)) {

					ReusableComponents.wait(5200);
					Posting_status_p.click();
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Payable Posting status selectbox is present", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.wait(5500);

					String Status_type = "//span[@title='" + status_p + "']";
					WebElement statustype = browser.findElement(By.xpath(Status_type));
					ReusableComponents.wait(5500);
					statustype.click();
					System.out.println("payable posting status is selected");
					ReusableComponents.wait(5500);

					if (ReusableComponents.isElementPresent(Payee_Reference)) {

						ReusableComponents.wait(4200);
						Payee_Reference.sendKeys(pref);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Payee Reference field is present", browser, pathLoc + "/" + testcasemethod, false);
						ReusableComponents.wait(5500);

						if (ReusableComponents.isElementPresent(Vendor)) {

							ReusableComponents.wait(4200);
							Vendor.sendKeys(account_name);
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Vendor searchbox is present", browser, pathLoc + "/" + testcasemethod, false);
							ReusableComponents.wait(5500);

							WebElement Vendor_click = browser.findElement(By.xpath(".//*[contains(text(),'" + account_name + "')]"));
							List<WebElement> dropdownelement = browser.findElements(By.xpath(".//*[contains(text(),'" + account_name + "')]"));
							int j = dropdownelement.size();

							System.out.println(j + " is the element count");

							if (ReusableComponents.isElementPresent(Vendor_click)) {

								System.out.println("Vendor selected");
								ReusableComponents.wait(5200);
								dropdownelement.get(j - 1).click();
								ReusableComponents.wait(5200);
								System.out.println("action called");
								ReusableComponents.wait(5200);

							}

							if (ReusableComponents.isElementPresent(Save_p)) {
								
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Payable creation page", browser, pathLoc+"/"+testcasemethod, true);
								ReusableComponents.wait(3200);
								Save.click();
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "/" + testcasemethod, false);
								ReusableComponents.wait(5500);

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Vendor searchbox is NOT present", browser, pathLoc + "/" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Payee Reference field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Payble Posting status selectbox is NOT present", browser, pathLoc + "/" + testcasemethod,
							true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Payable New button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
			}

		} else {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Payable tab is NOT present", browser, pathLoc + "/" + testcasemethod, true);
		}

		browser.switchTo().defaultContent();

	
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PrerequisitesPage(browser);
	}
	
	
	/***
	 * Test case Method Name : validateTestC
	 * Functionality : validate Payable Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized PrerequisitesPage validateTestC_payables(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			String unit_price = Unit_cost_PL;
			String expense_acc_name = Expense_GL_Account_PL;
			
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of created payable page", browser, pathLoc+"/"+testcasemethod, true);
			ReusableComponents.wait(5500);

			for (int i = 0; i < 27; i++) {

				browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);

			}

			ReusableComponents.wait(5500);

			if (ReusableComponents.isElementPresent(New_PLine)) {

				ReusableComponents.wait(4200);

				New_PLine.click();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New Payable Line button is present", browser, pathLoc + "/" + testcasemethod, false);
				ReusableComponents.wait(6500);

				if (ReusableComponents.isElementPresent(Unit_cost)) {

					ReusableComponents.wait(5200);
					Unit_cost.sendKeys(unit_price);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Unit cost field is present", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.wait(5500);

					if (ReusableComponents.isElementPresent(Expense_GL_Account)) {

						JavascriptExecutor js = (JavascriptExecutor) browser;
						js.executeScript("arguments[0].scrollIntoView();", Expense_GL_Account);

						ReusableComponents.wait(3200);
						Expense_GL_Account.sendKeys(expense_acc_name);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Expense GL Account searchbox is present", browser, pathLoc + "/" + testcasemethod, false);
						ReusableComponents.wait(5500);

						// WebElement Exp_gla_click = browser.findElement(By.xpath("//*[contains(@title,'\"+expense_acc_name+\"')]"));
						List<WebElement> dropdownelement_gl = browser.findElements(By.xpath("//*[contains(@title,'" + expense_acc_name + "')]"));
						int j = dropdownelement_gl.size();

						System.out.println(j + " is the element count");

						// if (ReusableComponents.isElementPresent(Exp_gla_click)) {

						System.out.println("Expense gl account selected");
						ReusableComponents.wait(5200);
						// Exp_gla_click.click();
						dropdownelement_gl.get(j-1).click();
						ReusableComponents.wait(3200);
						System.out.println("action called");
						ReusableComponents.wait(5200);

						// }

						if (ReusableComponents.isElementPresent(Save_p)) {

							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of New Payable line creation page", browser, pathLoc+"/"+testcasemethod, true);
							ReusableComponents.wait(5200);
							Save_p.click();
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "/" + testcasemethod, false);
							ReusableComponents.wait(5500);

							if (ReusableComponents.isElementPresent(Post)) {

								ReusableComponents.wait(3200);
								Post.click();
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Post tab is present", browser, pathLoc + "/" + testcasemethod, false);
								ReusableComponents.wait(6500);

								List<WebElement> f = browser.findElements(By.tagName("frame"));
								int i = f.size();
								System.out.println(i +" is the frame count");

								browser.switchTo().frame(0);

								if (ReusableComponents.isElementPresent(Post_final_p)) {
									
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Payable post page", browser, pathLoc+"/"+testcasemethod, true);
									ReusableComponents.wait(4200);
									Post_final_p.click();
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Post final button is present", browser, pathLoc + "/" + testcasemethod, false);
									ReusableComponents.wait(5500);

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Post final button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
								}

								browser.switchTo().defaultContent();

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Post tab is NOT present", browser, pathLoc + "/" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Expense GL Account searchbox is NOT present", browser, pathLoc + "/" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Unit cost field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "New Payable Line button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}
		return new PrerequisitesPage(browser);
	}
	
	
	
	/*** Test case Method Name : excelread_initial
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PrerequisitesPage excelread_initial(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		


		String filename = reusableComponents.getPropValues("Financialreportsinput");
		String sheetname = reusableComponents.getPropValues("primarysheet");
		System.out.println(filename);
		System.out.println(sheetname);


		File file = new File(workingDir + "/input/" + filename);
		FileInputStream istream = new FileInputStream(file);

		Workbook myworkbook = null;

		String fileExtensionName = filename.substring(filename.indexOf("."));

		if (fileExtensionName.equals(".xlsx")) {
			// If it is xlsx file then create object of XSSFWorkbook class
			myworkbook = new XSSFWorkbook(istream);
		}
		// Check condition if the file is xls file
		else if (fileExtensionName.equals(".xls")) {
			// If it is xls file then create object of HSSFWorkbook class
			myworkbook = new HSSFWorkbook(istream);
		}

		Sheet workbooksheet = myworkbook.getSheet(sheetname);
		int rowCount = workbooksheet.getLastRowNum() - workbooksheet.getFirstRowNum();
		int columnCount = workbooksheet.getRow(0).getLastCellNum();
		System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);

		// read rows and columns
		
		Iterator<Row> itr = workbooksheet.iterator();
		
		while(itr.hasNext()) {
			Row row = itr.next();
			 if(row.getRowNum()==0 ){
			       continue; //just skip the rows if row number is 0 or 1
			      }

			// if(row.getRowNum() == 1) {
				 
				 Iterator<Cell> celliterator = row.cellIterator();
					
					while(celliterator.hasNext()) {
	  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter(); 
						  
						  basic_input.add(formatter.formatCellValue(cell)); //throw new
						   
					}
				 
			// }
			 
			 
			
		}
		
		
		try {
			for(int i =0; i<basic_input.size();i++) {
				
				System.out.println(basic_input.get(i));
			}
			
			urlfromexcel = basic_input.get(1);
			username = basic_input.get(3);
			pass_login = basic_input.get(5);
			s.url = basic_input.get(7);
			
			try {
				browser.get(urlfromexcel);
				ReusableComponents.wait(2500);
				
				browser.manage().window().maximize();
				
				// all methods here
				validateTestA(threadID, tempList, pathLoc);
				validateTestExcelRead(threadID, tempList, pathLoc);
				
//				validateTestA(threadID, tempList, pathLoc);
//				validateTestB(threadID, tempList, pathLoc);
//				validateTestC(threadID, tempList, pathLoc);
//				validateTestD(threadID, tempList, pathLoc);

				
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
	

		

	

	
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PrerequisitesPage(browser);
	}
	
	
	
	
	
	/***
	 * Test case Method Name : validateTestExcelWrite
	 * Functionality : validate Secondday Page
	 * Created By : Subramanya MS
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized PrerequisitesPage validateTestExcelWrite(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		String testcasemethod = new Object() {
		
		}.getClass().getEnclosingMethod().getName();
		
		
		try {
			
			for (int i=0; i< enddate_arr.size();i++) {
				/*
				 * if(i==0) { continue; }if(i==1) { continue; } else {
				 * System.out.println("printing values "+input_arr.get(i)); }
				 */
				
				System.out.println("printing values "+enddate_arr.get(i));
				
			}
			
			String outfilename = reusableComponents.getPropValues("Financialreportsoutput");
			String outsheetname = reusableComponents.getPropValues("Financialreportsoutputsheet");
			
			File file = new File(workingDir + "/output/" + outfilename);
			FileInputStream istream = new FileInputStream(file);
			
			
			Workbook workbook = new HSSFWorkbook(istream);
			
			Sheet workbooksheet = workbook.getSheet(outsheetname);
			int rowCount = workbooksheet.getLastRowNum() - workbooksheet.getFirstRowNum();
			
			
			
			
			
			
			
			
		} catch (NoSuchElementException e) {
		
			
			
		
		}
		
		

		return new PrerequisitesPage(browser);
	}
	

}
