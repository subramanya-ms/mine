package com.wisefinch.java;

import java.awt.AWTException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base class for all the pages.
 *
 */
public class JournalEntryPage extends DriverScript {

	protected static WebDriver browser;
	static String dateGatheredToGiveNam;
	private static String dynamicValue;
	String valueToSet;
	static String newJournalName;

	static ReusableComponents reusableComponents = new ReusableComponents();

	protected JournalEntryPage(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	static {
		try {
			reusableComponents.getPropValues("OS");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FindBy(xpath = ".//*[@class='slds-icon-waffle']")
	static WebElement SearchAppAndItemIcon;

	@FindBy(xpath = ".//*[@class='slds-size_medium']//*[@class='slds-input']")
	static WebElement SearchAppAndItemInputbox;

	@FindBy(xpath = "//input[@id='username']")
	static WebElement login_user_field;

	@FindBy(xpath = "//input[@id='password']")
	static WebElement login_pass_field;

	@FindBy(xpath = "//input[@id='Login']")
	static WebElement login_btn;

	@FindBy(xpath = "(.//button[contains(text(),'Save')])[2]")
	static WebElement saveButton_newJournalEntryPopup;

	@FindBy(xpath = ".//*[@class='slds-button-group-list']//button[@name='New']")
	static WebElement newJournalEntryLine;

	@FindBy(xpath = ".//*[@class=\"slds-form\"]//input[@name='Name']")
	static WebElement journalName_newJournalEntryPopup;

	@FindBy(xpath = ".//*[@class=\"slds-form\"]//input[@name='AcctSeed__Journal_Date__c']")
	static WebElement journalDate_newJournalEntryPopup;

	@FindBy(xpath = "(.//*[@class='slds-form']//input[@role='combobox'])[3]")
	static WebElement accountingPeriod_newJournalEntryPopup;

	@FindBy(xpath = "(.//*[@class='slds-form']//input[@role='combobox'])[1]")
	static WebElement recurringJournalEntry_newJournalEntryPopup;

	@FindBy(xpath = ".//*[@class=\"slds-form\"]//input[@placeholder='Search Ledgers...']")
	static WebElement searchLedgers_newJournalEntryPopup;

	@FindBy(xpath = "(.//*[@class='slds-form']//input[@role='combobox'])[2]")
	static WebElement currency_newJournalEntryPopup;

	@FindBy(xpath = ".//li//*[contains(text(),'New')]")
	static WebElement newLink_LedgerPage;

	@FindBy(xpath = ".//*[@name='Name']")
	static WebElement ledgerName_LedgerPage;

	@FindBy(xpath = "(.//*[@class='slds-form__row']//*[@role='combobox'])[1]")
	static WebElement ledgerType_LedgerPage;

	@FindBy(xpath = "(.//lightning-button//button[contains(text(),'Save')])[2]")
	static WebElement saveButton_LedgerPage;

	@FindBy(xpath = ".//*[@class='slds-modal__header']/h2[contains(text(),'New Journal Entry')]")
	static WebElement newJournalEntry_Popup;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Journal Entries')]")
	static WebElement journalEntries;

	@FindBy(xpath = "//img[@title='Accounting Settings']")
	static WebElement Accounting_Settings;

	@FindBy(xpath = "//div/h3[contains(.,'Cash Flow Statement Settings')]")
	static WebElement CFS_Setting;

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

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Accounting Home')]")
	static WebElement accountingHome;

	@FindBy(xpath = ".//*[@aria-label='Breadcrumbs']//*[contains(text(),'Journal Entries')]")
	static WebElement journalEntries_PageTitle;

	@FindBy(xpath = ".//*[@title='New']")
	static WebElement new_journalEntries;

	@FindBy(xpath = ".//th//*[contains(text(),'20210908_110238_Journal')]")
	static WebElement openNewJournal_journalEntries;

	@FindBy(xpath = ".//*[@name='AcctSeed__Debit__c']")
	static WebElement debit_NewJournalEntryLine;

	@FindBy(xpath = ".//*[@name='AcctSeed__Credit__c']")
	static WebElement credit_NewJournalEntryLine;

	@FindBy(xpath = "((.//*[@data-aura-class='oneRecordActionWrapper']//*[@class='slds-form'])[2]//input)[1]")
	static WebElement glAccount_NewJournalEntryLine;

	@FindBy(xpath = ".//button[contains(text(),'Save & New')]")
	static WebElement saveAndNewButton_newJournalEntryPopup;

	@FindBy(xpath = "(.//*[@apiname='Edit']//button[@name='Edit'])[2]")
	static WebElement edit_newlyCreatedJournal;

	@FindBy(xpath = "(.//a//*[contains(text(),'JEL-')])[1]")
	static WebElement newJournalEntry;

	@FindBy(xpath = ".//*[@class='flex-wrap-ie11']//*[@id='window']")
	static WebElement defaultValueOfCashFlowCategory_newJournalEntry;

	@FindBy(xpath = ".//*[@class='actionBody']")
	static WebElement popupof_NewOpportunity;

	@FindBy(xpath = "(.//*[@slot='outputField']//*[@class='slds-grid']//a//*[contains(text(),'Payments to suppliers')])[1]")
	static WebElement clickPaymentToSuppliers_newJournalEntry;

	@FindBy(xpath = ".//button[contains(text(),'Post')]")
	static WebElement post_NewJournalEntry;

	@FindBy(xpath = "(.//input[@type='button' and @value='Post'])[1]")
	static WebElement postButton_UnderPostJournalEntry;

	@FindBy(xpath = ".//*[@class='mainTitle' and contains(text(),'Post')]")
	static WebElement verifyPostPageDisplay_JournalEntry;

	@FindBy(xpath = ".//button[@title='Edit Cash Flow Category']")
	static WebElement editCashFlowCategoryButton;

	@FindBy(xpath = "((.//force-record-layout-section)[2]//input)[3]")
	static WebElement currentValueOf_CashFlowCategory;

	@FindBy(xpath = "((.//force-record-layout-section)[2]//input)[3]/following::*[@title='Clear Selection']")
	static WebElement clearValueOf_CashFlowCategoryButton;

	@FindBy(xpath = ".//button[contains(text(),'Save')]")
	static WebElement saveButtonOfEdit_JournalEntryLine;

	@FindBy(xpath = ".//*[@role='dialog']//*[@class='slds-popover__body']//li")
	static WebElement errorAfterClickingSave;

	@FindBy(xpath = "(.//*[contains(text(),'TRN-')])[1]")
	static WebElement transactionUnder_JournalEntryLine;

	@FindBy(xpath = "((.//force-record-layout-section)[4]//input)[4]")
	static WebElement currentValueOf_CashFlowCategory_Transactions;

	@FindBy(xpath = "((.//force-record-layout-section)[4]//input)[4]/following::*[@title='Clear Selection']")
	static WebElement clearValueButton_CashFlowCategory_Transactions;

	String account_name = null;
	String account_namefull = null;

	ArrayList<String> startdate_arr = new ArrayList<String>();
	ArrayList<String> enddate_arr = new ArrayList<String>();

	/***
	 * Test case Test case Name : create new journal functionality Author : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized static JournalEntryPage test_Journal_Entries(int threadID, List<String> tempList,
			String pathLoc) throws Exception {
		System.out.println("********** test_Journal_Entries");
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			/*
			 * ReusableComponents.wait(2300); String username = null, pass_login = null;
			 * username = reusableComponents.getPropValues("username"); pass_login =
			 * reusableComponents.getPropValues("password");
			 * 
			 * LoginToWebpage();
			 */

			// Create new journal
			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Journal Entries", journalEntries);
			if (ReusableComponents.isElementPresent(journalEntries_PageTitle) == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, "Journal Entries page opened",
						browser, pathLoc + "/" + testcasemethod, true);
			} else {
				throw new throwNewException("Journal Entry page is not opened", "");
			}
			
			browser.navigate().refresh();
			ReusableComponents.wait(10000);
			browser.navigate().refresh();
			ReusableComponents.wait(10000);
			ReusableComponents.clickElement(new_journalEntries, "Click on new Journal Entries");
			ReusableComponents.wait(5000);

			if (ReusableComponents.isElementPresent(newJournalEntry_Popup) == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"New Journal Entries popup opened", browser, pathLoc + "/" + testcasemethod, true);
			} else {
				throw new throwNewException("New Journal Entry page is not opened", "");
			}

			newJournalName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_Journal";
			ReusableComponents.sendKey(journalName_newJournalEntryPopup, newJournalName, "New Ledger Name");
			ReusableComponents.sendKey(journalDate_newJournalEntryPopup,
					reusableComponents.getPropValues("JournalDate_Journal"), "Enter Journal Date");

			String currencyvalue = reusableComponents.getPropValues("currency_Journal");
			ReusableComponents.clickUsingJavaScript(browser, currency_newJournalEntryPopup, "Click Currency Value");
			String currencyXpath = ".//*[contains(text(),'" + currencyvalue + "')]";
			ReusableComponents.clickElement_byDynamicXpath(browser, currencyXpath,
					"Selected currency value as " + currencyvalue);

			String accountingPeriod = reusableComponents.getPropValues("AccountingPeriod_Journal");
			ReusableComponents.sendKey(accountingPeriod_newJournalEntryPopup, accountingPeriod,
					"Enter Accounting Period");
			String[] arrOfStr = accountingPeriod.split("-");
			String monthValue = arrOfStr[1];
			String monthInString;
			if (monthValue.equalsIgnoreCase("10") || monthValue.equalsIgnoreCase("11")
					|| monthValue.equalsIgnoreCase("12")) {
				monthInString = monthValue;
			} else {
				monthInString = monthValue.substring(1);
			}

			String accountingPeriodInMDYFormat = monthInString + "/1/" + arrOfStr[0];
			String xpath_acccountingPeriod_Select_newJournal = ".//lightning-base-combobox-formatted-text[@title='"
					+ accountingPeriodInMDYFormat + "']";
			ReusableComponents.wait(5000);
			ReusableComponents.clickElement_byDynamicXpath(browser, xpath_acccountingPeriod_Select_newJournal,
					"Selected Accounting Period");

			// ****************Ledger selection under Journal Page***************//
			/*
			 * String postingStatusValue =
			 * reusableComponents.getPropValues("postingStatus_Journal");
			 * ReusableComponents.clickUsingJavaScript(browser,
			 * postingStatus_newJournalEntryPopup, "Click posting status"); WebElement
			 * postingStatus = browser .findElement(By.xpath(".//*[contains(text(),'" +
			 * postingStatusValue + "')]"));
			 * ReusableComponents.clickUsingJavaScript(browser, postingStatus,
			 * "Select postomg value"); String ledgerValue =
			 * reusableComponents.getPropValues("ledger_Journal");
			 * ReusableComponents.sendKey(ledger_newJournalEntryPopup, ledgerValue,
			 * "Search for newly created ledger value"); wait(5000); String
			 * selectBudgetLedger = "//strong[normalize-space()='" + ledgerValue + "']";
			 * System.out.println("****************************** Print xpath " +
			 * selectBudgetLedger); ReusableComponents.clickElement_byDynamicXpath(browser,
			 * selectBudgetLedger, "Select newly careted Ludger ");
			 */
			// ****************End Ledger selection under Journal Page***************//

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					"Provided all mandatory values to create new journal", browser, pathLoc + "/" + testcasemethod,
					true);
			ReusableComponents.clickElement(saveButton_newJournalEntryPopup, "Click on save button");
			ReusableComponents.wait(5000);

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, "Navigated to new Journal page",
					browser, pathLoc + "/" + testcasemethod, true);
			String checkCreatedOpportunity = ".//lightning-formatted-text[contains(text(),'" + newJournalName + "')]";

			System.out.println("Print xpath " + checkCreatedOpportunity);
			boolean opportunityCreated = browser.findElement(By.xpath(checkCreatedOpportunity)).isDisplayed();
			// System.out.println("********************** Element visibility" +
			// checkCreatedOpportunity);
			if (opportunityCreated == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"Newly created Journal " + newJournalName + " is displayed", browser,
						pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Opportunity " + newJournalName + " is not created", browser, pathLoc + "/" + testcasemethod,
						true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "/" + testcasemethod, true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, true);
		}
		return new JournalEntryPage(browser);
	}

	/*
	 * Login to Webpage Author Menaka
	 */
	public static void LoginToWebpage() throws Exception

	{
		System.out.println("********** LoginToWebpage");
		String username = null, pass_login = null;
		username = reusableComponents.getPropValues("username");
		pass_login = reusableComponents.getPropValues("password");
		try {
			ReusableComponents.sendKey(login_user_field, username, "User Name");
			ReusableComponents.sendKey(login_pass_field, pass_login, "Password");
			ReusableComponents.clickElement(login_btn, "Login Button");
			ReusableComponents.wait(10000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * From Accounting Home, click on Accounts (under Master Data Setup) and
	 * create/edit one so it has: Accounting Type = Customer & Vendor and Accounting
	 * Active checked Author : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized JournalEntryPage editMasterDataSetupAccountData(int threadID, List<String> tempList,
			String pathLoc) throws Exception, throwNewException {
		System.out.println("********** editMasterDataSetupAccountData");
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			browser.navigate()
					.to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(5200);

			String dt_pattern = "YYMMDDhhmmss";
			DateTimeFormatter cdt = DateTimeFormatter.ofPattern(dt_pattern);
			LocalDateTime now = LocalDateTime.now();
			account_name = reusableComponents.getPropValues("Testcase2728_accountname");
			account_name = account_name + cdt.format(now);
			account_namefull = account_name;
			String acc_type = reusableComponents.getPropValues("Testcase2728_actype");

			ReusableComponents.wait(3200);
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(3200);
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(3200);

			List<WebElement> f = browser.findElements(By.tagName("frame"));
			int i = f.size();
			System.out.println(i + "is the frame count");

			browser.switchTo().frame(0);

			ReusableComponents.wait(10200);

			if (ReusableComponents.isElementPresent(Accounts)) {

				ReusableComponents.wait(5200);
				Accounts.click();
				ReusableComponents.wait(5200);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Accounts is present", browser,
						pathLoc + "/" + testcasemethod, false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounts page",
						browser, pathLoc + "/" + testcasemethod, true);

				if (ReusableComponents.isElementPresent(New)) {

					ReusableComponents.wait(5200);
					New.click();
					ReusableComponents.wait(5200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Account New button is present",
							browser, pathLoc + "/" + testcasemethod, false);

					WebElement element = browser
							.findElement(By.xpath("//span[contains(text(),'Accounting Information')]"));
					((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);

					if (ReusableComponents.isElementPresent(Account_Name)) {

						ReusableComponents.wait(5200);
						Account_Name.sendKeys(account_name);
						ReusableComponents.wait(5200);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Account Name field is present", browser, pathLoc + "/" + testcasemethod, false);

						if (ReusableComponents.isElementPresent(Account_type)) {

							ReusableComponents.wait(5200);
							Account_type.click();
							ReusableComponents.wait(5200);
							Account_type.click();
							ReusableComponents.wait(8200);
							ReusableComponents.reportPass(threadID, tempList, testcasemethod,
									"Account Type selectbox is present", browser, pathLoc + "/" + testcasemethod,
									false);

							String Acc_type = "//span[@title='" + acc_type + "']";
							System.out.println(Acc_type);

							WebElement selecttype = browser.findElement(By.xpath(Acc_type));
							ReusableComponents.wait(5500);
							// selecttype.click();
							new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(selecttype))
									.click();
							ReusableComponents.wait(5500);

							if (ReusableComponents.isElementPresent(Accounting_Active)) {

								ReusableComponents.wait(5200);
								Accounting_Active.click();
								ReusableComponents.wait(5200);
								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Account Active checkbox is present", browser, pathLoc + "/" + testcasemethod,
										false);

								if (ReusableComponents.isElementPresent(Save)) {

									ReusableComponents.wait(5200);
									Save.click();
									ReusableComponents.wait(5200);
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Save button is present", browser, pathLoc + "/" + testcasemethod, false);
									ReusableComponents.wait(5200);
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Save button not present", browser, pathLoc + "/" + testcasemethod, true);
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"Account Active checkbox not present", browser, pathLoc + "/" + testcasemethod,
										true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"Account Type selectbox not present", browser, pathLoc + "/" + testcasemethod,
									true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Account Name field  not present", browser, pathLoc + "/" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account New button not present",
							browser, pathLoc + "/" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account tab not present", browser,
						pathLoc + "/" + testcasemethod, true);
			}

			browser.switchTo().defaultContent();

		} catch (NoSuchElementException e) {

			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);

		}

		return new JournalEntryPage(browser);
	}

	/*
	 * From Accounting Home, click on Accounts (under Master Data Setup) and
	 * create/edit one so it has: Accounting Type = Customer & Vendor and Accounting
	 * Active checked Author : Lakshman
	 */
	public static void checkDefaultValueOfCustomerVendorandAccounting(int threadID, List<String> tempList,
			String testcasemethod) throws Exception {
		System.out.println("********** checkDefaultValueOfCustomerVendorandAccounting");
		try {
			ReusableComponents.wait(3200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page",
					browser, pathLoc + "/" + testcasemethod, true);
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
						browser, pathLoc + "/" + testcasemethod, false);

				browser.switchTo().frame(0);

				WebElement element = browser
						.findElement(By.xpath("//div/h3[contains(.,'Cash Flow Statement Settings')]"));
				((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
				ReusableComponents.wait(3200);

				if (ReusableComponents.isElementPresent(CFS_Setting)) {

					ReusableComponents.wait(5200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Cash Flow Statement Settings tab is present", browser, pathLoc + "/" + testcasemethod,
							false);
					ReusableComponents.wait(5200);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
							"screen grab of Cash Flow Statement Settings section, this is a non editable section",
							browser, pathLoc + "/" + testcasemethod, true);

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Cash Flow Statement Settings tab not present", browser, pathLoc + "/" + testcasemethod,
							true);
				}
				browser.switchTo().defaultContent();
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Accounting Settings tab not present",
						browser, pathLoc + "/" + testcasemethod, true);
			}

			browser.switchTo().defaultContent();
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Unable to select app from select search app section" + e.getStackTrace(), browser,
					pathLoc + "/" + testcasemethod, true);
		}

	}

	public static void selectAppFromSearchAppAndItem(int threadID, List<String> tempList, String testcasemethod,
			String appNameToSearch, WebElement selectAppXpath) throws Exception {

		try {
			ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
			ReusableComponents.wait(5000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					"Search app and item icon pressed", browser, pathLoc + "/" + testcasemethod, false);
			ReusableComponents.sendKey(SearchAppAndItemInputbox, appNameToSearch, "Search app and Item inputbox");
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, "Search for reports", browser,
					pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(selectAppXpath, "Select value from App and Item dropdown");
			ReusableComponents.wait(5000);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Unable to select app from select search app section" + e.getStackTrace(), browser,
					pathLoc + "/" + testcasemethod, true);
		}

	}

	/***
	 * Test case Test case Name : [CF] Verify that a Journal Entry line has the
	 * default Cash Flow Category of 'Payments to suppliers' functionality Author :
	 * Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized JournalEntryPage test2728_CheckCashFlowCategory(int threadID, List<String> tempList,
			String pathLoc) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			LoginToWebpage();
			checkDefaultValueOfCustomerVendorandAccounting(threadID, tempList, testcasemethod);
			editMasterDataSetupAccountData(threadID, tempList, testcasemethod);
			test_Journal_Entries(threadID, tempList, testcasemethod);

			// Add new journal entry line with debit

			// ReusableComponents.scrollInToElementJavaScript(browser, newJournalEntryLine);
			browser.navigate().refresh();
			ReusableComponents.wait(4000);
			browser.navigate().refresh();
			ReusableComponents.wait(4000);
			ReusableComponents.clickElement(newJournalEntryLine, "Click on new journal entry line");
			ReusableComponents.wait(10000);
			ReusableComponents.sendKey(debit_NewJournalEntryLine,
					reusableComponents.getPropValues("Testcase2728_Debit"), "Provide Debit value");
			ReusableComponents.scrollInToElementJavaScript(browser, glAccount_NewJournalEntryLine);
			String glAccountType = reusableComponents.getPropValues("Testcase2728_GLAccountType_Entry1");
			ReusableComponents.sendKey(glAccount_NewJournalEntryLine, glAccountType, "Provide GL account value");
			ReusableComponents.wait(4000);
			String xpathToSelectGlAccontType = "//lightning-base-combobox-formatted-text[@title='" + glAccountType
					+ "']";

			System.out.println("********** X path" + xpathToSelectGlAccontType);
			ReusableComponents.clickElement_byDynamicXpath(browser, xpathToSelectGlAccontType,
					"Select correct value for Gl Account Type");
			ReusableComponents.scrollUp_insidepopup_ByPGUP(browser, popupof_NewOpportunity);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					"Filled debit and GL account type values for first journal entry", browser,
					pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(saveButton_newJournalEntryPopup, "Click on save button");
			ReusableComponents.wait(5000);

			// Add new journal entry line with credit
			ReusableComponents.clickElement(newJournalEntryLine, "Click on new journal entry line");
			ReusableComponents.wait(10000);
			ReusableComponents.sendKey(credit_NewJournalEntryLine,
					reusableComponents.getPropValues("Testcase2728_Credit"), "Provide credit value");
			ReusableComponents.scrollInToElementJavaScript(browser, glAccount_NewJournalEntryLine);
			glAccountType = reusableComponents.getPropValues("Testcase2728_GLAccountType_Entry2");
			ReusableComponents.sendKey(glAccount_NewJournalEntryLine, glAccountType, "Provide GL account value");
			ReusableComponents.wait(4000);
			xpathToSelectGlAccontType = "//lightning-base-combobox-formatted-text[@title='" + glAccountType + "']";
			System.out.println("********** X path" + xpathToSelectGlAccontType);
			ReusableComponents.clickElement_byDynamicXpath(browser, xpathToSelectGlAccontType,
					"Select correct value for Gl Account Type");
			ReusableComponents.scrollUp_insidepopup_ByPGUP(browser, popupof_NewOpportunity);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					"Filled credit and GL account type values for first journal entry", browser,
					pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(saveButton_newJournalEntryPopup, "Click on save button");
			ReusableComponents.wait(5000);

			// Click first journal entry and verify the default values.
			ReusableComponents.clickElement(newJournalEntry, "Open new journal entry");
			ReusableComponents.wait(5000);

			ReusableComponents.clickElement(clickPaymentToSuppliers_newJournalEntry, "Clicking to activate the xpath");
			ReusableComponents.wait(5000);
			browser.navigate().back();
			ReusableComponents.wait(5000);
			String defaultValueVisibility = ReusableComponents.getText(defaultValueOfCashFlowCategory_newJournalEntry,
					"Get text of element");
			System.out.println("************** defaultValueVisibility " + defaultValueVisibility);
			if (defaultValueVisibility.equalsIgnoreCase("Payments to suppliers")) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"Cash flow category default value displayed as " + defaultValueVisibility, browser,
						pathLoc + "/" + testcasemethod, true);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Default Value", browser,
						pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Cash flow category default value is not displayed as " + defaultValueVisibility, browser,
						pathLoc + "/" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "/" + testcasemethod, true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, true);
		}
		return new JournalEntryPage(browser);
	}

	/***
	 * Test case Test case Name : [CF] Verify that a Journal Entry line has the
	 * default Cash Flow Category of 'Payments to suppliers' functionality Author :
	 * Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized JournalEntryPage test2729_ChangeCashFlowCategory_CheckErrorMessage(int threadID,
			List<String> tempList, String pathLoc) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			LoginToWebpage();

			checkDefaultValueOfCustomerVendorandAccounting(threadID, tempList, testcasemethod);
			editMasterDataSetupAccountData(threadID, tempList, testcasemethod);
			test_Journal_Entries(threadID, tempList, testcasemethod);

			// -->Add new journal entry line with debit
			// ReusableComponents.scrollInToElementJavaScript(browser, newJournalEntryLine);
			browser.navigate().refresh();
			ReusableComponents.wait(4000);
			browser.navigate().refresh();
			ReusableComponents.wait(4000);
			ReusableComponents.clickElement(newJournalEntryLine, "Click on new journal entry line");
			ReusableComponents.wait(10000);
			ReusableComponents.sendKey(debit_NewJournalEntryLine,
					reusableComponents.getPropValues("Testcase2728_Debit"), "Provide Debit value");
			ReusableComponents.scrollInToElementJavaScript(browser, glAccount_NewJournalEntryLine);
			String glAccountType = reusableComponents.getPropValues("Testcase2728_GLAccountType_Entry1");
			ReusableComponents.sendKey(glAccount_NewJournalEntryLine, glAccountType, "Provide GL account value");
			ReusableComponents.wait(4000);
			String xpathToSelectGlAccontType = "//lightning-base-combobox-formatted-text[@title='" + glAccountType
					+ "']";

			System.out.println("********** X path" + xpathToSelectGlAccontType);
			ReusableComponents.clickElement_byDynamicXpath(browser, xpathToSelectGlAccontType,
					"Select correct value for Gl Account Type");
			ReusableComponents.scrollUp_insidepopup_ByPGUP(browser, popupof_NewOpportunity);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					"Filled debit and GL account type values for first journal entry", browser,
					pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(saveButton_newJournalEntryPopup, "Click on save button");
			ReusableComponents.wait(5000);

			// -->Add new journal entry line with credit
			ReusableComponents.clickElement(newJournalEntryLine, "Click on new journal entry line");
			ReusableComponents.wait(10000);
			ReusableComponents.sendKey(credit_NewJournalEntryLine,
					reusableComponents.getPropValues("Testcase2728_Credit"), "Provide credit value");
			ReusableComponents.scrollInToElementJavaScript(browser, glAccount_NewJournalEntryLine);
			glAccountType = reusableComponents.getPropValues("Testcase2728_GLAccountType_Entry2");
			ReusableComponents.sendKey(glAccount_NewJournalEntryLine, glAccountType, "Provide GL account value");
			ReusableComponents.wait(4000);
			xpathToSelectGlAccontType = "//lightning-base-combobox-formatted-text[@title='" + glAccountType + "']";
			System.out.println("********** X path" + xpathToSelectGlAccontType);
			ReusableComponents.clickElement_byDynamicXpath(browser, xpathToSelectGlAccontType,
					"Select correct value for Gl Account Type");
			ReusableComponents.scrollUp_insidepopup_ByPGUP(browser, popupof_NewOpportunity);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					"Filled credit and GL account type values for first journal entry", browser,
					pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(saveButton_newJournalEntryPopup, "Click on save button");
			ReusableComponents.wait(5000);

			// -->Click first journal entry and verify the default values.
			ReusableComponents.clickElement(newJournalEntry, "Open new journal entry");
			ReusableComponents.wait(5000);

			ReusableComponents.clickElement(clickPaymentToSuppliers_newJournalEntry, "Clicking to activate the xpath");
			ReusableComponents.wait(5000);
			browser.navigate().back();
			ReusableComponents.wait(5000);
			String defaultValueVisibility = ReusableComponents.getText(defaultValueOfCashFlowCategory_newJournalEntry,
					"Get text of element");
			System.out.println("************** defaultValueVisibility " + defaultValueVisibility);
			if (defaultValueVisibility.equalsIgnoreCase("Payments to suppliers")) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"Cash flow category default value displayed as " + defaultValueVisibility, browser,
						pathLoc + "/" + testcasemethod, true);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Default value", browser,
						pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Cash flow category default value is not displayed as " + defaultValueVisibility, browser,
						pathLoc + "/" + testcasemethod, true);
			}

			browser.navigate().back();
			ReusableComponents.wait(5000);
			ReusableComponents.scrollUp_ByKey(browser);
			ReusableComponents.wait(10000);
			// --> Perform post action
			ReusableComponents.clickElement(post_NewJournalEntry, "Click on post button");
			ReusableComponents.wait(10000);

			List<WebElement> iframeelementName = browser.findElements(By.tagName("iframe"));
			System.out.println("########## Number of elements " + iframeelementName.size());

			List<WebElement> frameelementName = browser.findElements(By.tagName("frame"));
			System.out.println("########## Number of elements " + frameelementName.size());

			browser.switchTo().frame(0);
			ReusableComponents.wait(10000);
			Boolean postPageDispaly = ReusableComponents.isDisplayed(postButton_UnderPostJournalEntry,
					"Verify Post Page Is Displayed");
			if (postPageDispaly == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, "Post page displayed",
						browser, pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Post page is not displayed", browser,
						pathLoc + "/" + testcasemethod, true);
			}

			ReusableComponents.clickElement(postButton_UnderPostJournalEntry, "Click on post button");
			ReusableComponents.wait(10000);

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, "Clicked on post button", browser,
					pathLoc + "/" + testcasemethod, true);

			browser.switchTo().defaultContent();
			ReusableComponents.wait(20000);
			String newJournalEntryPage = ".//*[@slot=\"primaryField\"]/*[contains(text(),'" + newJournalName + "')]";
			System.out.println("********** New journal entry xpath " + newJournalEntryPage);
			WebElement postedJournalEntry;

			try {
				postedJournalEntry = browser.findElement(By.xpath(newJournalEntryPage));

				Boolean newJournalEntryAfterPosting = ReusableComponents.isDisplayed(postedJournalEntry,
						"Verify new journal entry displayed after performing post");
				if (newJournalEntryAfterPosting == true) {
					ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
							"New journal entry page is displayed after performing post", browser,
							pathLoc + "/" + testcasemethod, true);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"New journal entry page is not displayed", browser, pathLoc + "/" + testcasemethod, true);
				}
			} catch (throwNewException e) {
				throw new throwNewException("looing for journal entry page after performing post",
						"Error while performing find element: " + e.getMessage());
			}

			browser.navigate().refresh();
			ReusableComponents.wait(20000);

			String newJournalEntryPostingStatus = ".//*[@slot='secondaryFields']/*[@role='listitem']//*[contains(text(),'Posted')]";
			System.out.println("********** New journal entry xpath " + newJournalEntryPostingStatus);

			WebElement newJournalEntryPostingStatus_element = browser
					.findElement(By.xpath(newJournalEntryPostingStatus));

			Boolean newJournalEntryAfterPosting_elementVisibility = ReusableComponents.isDisplayed(
					newJournalEntryPostingStatus_element, "Verify new journal entry displayed after performing post");
			if (newJournalEntryAfterPosting_elementVisibility == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"New journal entry status changed to posted", browser, pathLoc + "/" + testcasemethod, true);

				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Posted Journal Entry", browser,
						pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"New journal entry status is not changed to posted", browser, pathLoc + "/" + testcasemethod,
						true);
			}

			// -->Click first journal entry and try to modify CF category value
			ReusableComponents.clickElement(newJournalEntry, "Open new cash flow journal entry ");
			ReusableComponents.wait(5000);

			browser.navigate().refresh();
			ReusableComponents.wait(5000);
			ReusableComponents.scrollDown(browser, 100);
			ReusableComponents.wait(5000);
			ReusableComponents.clickUsingJavaScript(browser, editCashFlowCategoryButton,
					"Click on edit cash flow category button");
			ReusableComponents.wait(5000);
			String currentValueOfCashFlowCategory = ReusableComponents
					.elementGetAttribute(currentValueOf_CashFlowCategory, "placeholder");

			if (currentValueOfCashFlowCategory.equalsIgnoreCase("Payments to suppliers")) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"Before performing edit cash flow category value is identified as Payments to suppliers",
						browser, pathLoc + "/" + testcasemethod, true);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
						"Before changing cash flow category", browser, pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents
						.reportFail(threadID, tempList, testcasemethod,
								"Before performing edit cash flow category value identified as "
										+ currentValueOfCashFlowCategory,
								browser, pathLoc + "/" + testcasemethod, true);
			}

			// ReusableComponents.scrollDown(browser, 100);
			ReusableComponents.wait(5000);

			ReusableComponents.clickUsingJavaScript(browser, clearValueOf_CashFlowCategoryButton,
					"Click on clear button of cash flow category");
			String newValueOfCashFlowCategory = reusableComponents.getPropValues("Testcase2729_ModifyCashFlowValue");
			ReusableComponents.sendKey(currentValueOf_CashFlowCategory, newValueOfCashFlowCategory,
					"Provide value to the cash flow category");
			ReusableComponents.wait(2000);

			String selectionOfCashFlowCategory = "//lightning-base-combobox-formatted-text[@title='"
					+ newValueOfCashFlowCategory + "']//strong[contains(text(),'" + newValueOfCashFlowCategory + "')]";
			System.out.println("********** selectionOfCashFlowCategory xpath " + selectionOfCashFlowCategory);

			WebElement selectValueOfCashFlowCategory = browser.findElement(By.xpath(selectionOfCashFlowCategory));

			ReusableComponents.clickUsingJavaScript(browser, selectValueOfCashFlowCategory,
					"Select value of cash flow category");

			// -->Check the current value of cash flow before clicking on save button
			currentValueOfCashFlowCategory = ReusableComponents.elementGetAttribute(currentValueOf_CashFlowCategory,
					"placeholder");

			if (!currentValueOfCashFlowCategory.equalsIgnoreCase("Payments to suppliers")) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"Cash flow category value changed to have " + currentValueOfCashFlowCategory, browser,
						pathLoc + "/" + testcasemethod, true);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
						"Current value of cashflow category", browser, pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Cash flow category value not changed. It still says " + currentValueOfCashFlowCategory,
						browser, pathLoc + "/" + testcasemethod, true);
			}

			ReusableComponents.clickElement(saveButtonOfEdit_JournalEntryLine,
					"Click on save button after editing cash flow category value");
			ReusableComponents.wait(2000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					"Click on save button", browser,
					pathLoc + "/" + testcasemethod, true);

			// -->Check the error text
			String errorText = ReusableComponents.getText(errorAfterClickingSave,
					"Verify the error after clicking on save");
			String expectedErrorText = reusableComponents.getPropValues("Testcase2729_ErrorText");

			if (!errorText.equalsIgnoreCase(expectedErrorText)) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"Error text displayed as expected " + expectedErrorText, browser,
						pathLoc + "/" + testcasemethod, true);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Find the Error text below", browser,
						pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Error text is not displayed as expected " + errorText, browser,
						pathLoc + "/" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "/" + testcasemethod, true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, true);
		}
		return new JournalEntryPage(browser);
	}

	/***
	 * Test case Test case Name : [CF] Verify that a Journal Entry line has the
	 * default Cash Flow Category of 'Payments to suppliers' functionality Author :
	 * Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized JournalEntryPage test2730_ChangeTransactionCashFlowCategory_CheckErrorMessage(int threadID,
			List<String> tempList, String pathLoc) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			LoginToWebpage();
			checkDefaultValueOfCustomerVendorandAccounting(threadID, tempList, testcasemethod);
			editMasterDataSetupAccountData(threadID, tempList, testcasemethod);
			test_Journal_Entries(threadID, tempList, testcasemethod);

			// -->Add new journal entry line with debit
			// ReusableComponents.scrollInToElementJavaScript(browser, newJournalEntryLine);
			browser.navigate().refresh();
			ReusableComponents.wait(4000);
			browser.navigate().refresh();
			ReusableComponents.wait(4000);
			ReusableComponents.clickElement(newJournalEntryLine, "Click on new journal entry line");
			ReusableComponents.wait(10000);
			ReusableComponents.sendKey(debit_NewJournalEntryLine,
					reusableComponents.getPropValues("Testcase2728_Debit"), "Provide Debit value");
			ReusableComponents.scrollInToElementJavaScript(browser, glAccount_NewJournalEntryLine);
			String glAccountType = reusableComponents.getPropValues("Testcase2728_GLAccountType_Entry1");
			ReusableComponents.sendKey(glAccount_NewJournalEntryLine, glAccountType, "Provide GL account value");
			ReusableComponents.wait(4000);
			String xpathToSelectGlAccontType = "//lightning-base-combobox-formatted-text[@title='" + glAccountType
					+ "']";

			System.out.println("********** X path" + xpathToSelectGlAccontType);
			ReusableComponents.clickElement_byDynamicXpath(browser, xpathToSelectGlAccontType,
					"Select correct value for Gl Account Type");
			ReusableComponents.scrollUp_insidepopup_ByPGUP(browser, popupof_NewOpportunity);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					"Filled debit and GL account type values for first journal entry", browser,
					pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(saveButton_newJournalEntryPopup, "Click on save button");
			ReusableComponents.wait(5000);

			// -->Add new journal entry line with credit
			ReusableComponents.clickElement(newJournalEntryLine, "Click on new journal entry line");
			ReusableComponents.wait(10000);
			ReusableComponents.sendKey(credit_NewJournalEntryLine,
					reusableComponents.getPropValues("Testcase2728_Credit"), "Provide credit value");
			ReusableComponents.scrollInToElementJavaScript(browser, glAccount_NewJournalEntryLine);
			glAccountType = reusableComponents.getPropValues("Testcase2728_GLAccountType_Entry2");
			ReusableComponents.sendKey(glAccount_NewJournalEntryLine, glAccountType, "Provide GL account value");
			ReusableComponents.wait(4000);
			xpathToSelectGlAccontType = "//lightning-base-combobox-formatted-text[@title='" + glAccountType + "']";
			System.out.println("********** X path" + xpathToSelectGlAccontType);
			ReusableComponents.clickElement_byDynamicXpath(browser, xpathToSelectGlAccontType,
					"Select correct value for Gl Account Type");
			ReusableComponents.scrollUp_insidepopup_ByPGUP(browser, popupof_NewOpportunity);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					"Filled credit and GL account type values for first journal entry", browser,
					pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(saveButton_newJournalEntryPopup, "Click on save button");
			ReusableComponents.wait(5000);

			// -->Click first journal entry and verify the default values.
			ReusableComponents.clickElement(newJournalEntry, "Open new journal entry");
			ReusableComponents.wait(5000);

			ReusableComponents.clickElement(clickPaymentToSuppliers_newJournalEntry, "Clicking to activate the xpath");
			ReusableComponents.wait(5000);
			browser.navigate().back();
			ReusableComponents.wait(5000);
			String defaultValueVisibility = ReusableComponents.getText(defaultValueOfCashFlowCategory_newJournalEntry,
					"Get text of element");
			System.out.println("************** defaultValueVisibility " + defaultValueVisibility);
			if (defaultValueVisibility.equalsIgnoreCase("Payments to suppliers")) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"Cash flow category default value displayed as " + defaultValueVisibility, browser,
						pathLoc + "/" + testcasemethod, true);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Default value", browser,
						pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Cash flow category default value is not displayed as " + defaultValueVisibility, browser,
						pathLoc + "/" + testcasemethod, true);
			}

			browser.navigate().back();
			ReusableComponents.wait(5000);
			ReusableComponents.scrollUp_ByKey(browser);
			ReusableComponents.wait(10000);

			// --> Perform post action
			ReusableComponents.clickElement(post_NewJournalEntry, "Click on post button");
			ReusableComponents.wait(10000);

			List<WebElement> iframeelementName = browser.findElements(By.tagName("iframe"));
			System.out.println("########## Number of elements " + iframeelementName.size());

			List<WebElement> frameelementName = browser.findElements(By.tagName("frame"));
			System.out.println("########## Number of elements " + frameelementName.size());

			browser.switchTo().frame(0);
			ReusableComponents.wait(10000);
			Boolean postPageDispaly = ReusableComponents.isDisplayed(postButton_UnderPostJournalEntry,
					"Verify Post Page Is Displayed");
			if (postPageDispaly == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, "Post page displayed",
						browser, pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Post page is not displayed", browser,
						pathLoc + "/" + testcasemethod, true);
			}

			ReusableComponents.clickElement(postButton_UnderPostJournalEntry, "Click on post button");
			ReusableComponents.wait(10000);

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, "Clicked on post button", browser,
					pathLoc + "/" + testcasemethod, true);

			browser.switchTo().defaultContent();
			ReusableComponents.wait(20000);
			String newJournalEntryPage = ".//*[@slot=\"primaryField\"]/*[contains(text(),'" + newJournalName + "')]";
			System.out.println("********** New journal entry xpath " + newJournalEntryPage);
			WebElement postedJournalEntry;

			try {
				postedJournalEntry = browser.findElement(By.xpath(newJournalEntryPage));

				Boolean newJournalEntryAfterPosting = ReusableComponents.isDisplayed(postedJournalEntry,
						"Verify new journal entry displayed after performing post");
				if (newJournalEntryAfterPosting == true) {
					ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
							"New journal entry page is displayed after performing post", browser,
							pathLoc + "/" + testcasemethod, true);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"New journal entry page is not displayed", browser, pathLoc + "/" + testcasemethod, true);
				}
			} catch (throwNewException e) {
				throw new throwNewException("looing for journal entry page after performing post",
						"Error while performing find element: " + e.getMessage());
			}

			browser.navigate().refresh();
			ReusableComponents.wait(20000);

			String newJournalEntryPostingStatus = ".//*[@slot='secondaryFields']/*[@role='listitem']//*[contains(text(),'Posted')]";
			System.out.println("********** New journal entry xpath " + newJournalEntryPostingStatus);

			WebElement newJournalEntryPostingStatus_element = browser
					.findElement(By.xpath(newJournalEntryPostingStatus));

			Boolean newJournalEntryAfterPosting_elementVisibility = ReusableComponents.isDisplayed(
					newJournalEntryPostingStatus_element, "Verify new journal entry displayed after performing post");
			if (newJournalEntryAfterPosting_elementVisibility == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"New journal entry status changed to posted", browser, pathLoc + "/" + testcasemethod, true);

				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Posted Journal Entry", browser,
						pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"New journal entry status is not changed to posted", browser, pathLoc + "/" + testcasemethod,
						true);
			}

			ReusableComponents.wait(10000);
			// -->Open first journal entry
			ReusableComponents.clickElement(newJournalEntry, "Open new cash flow journal entry ");
			ReusableComponents.wait(5000);

			browser.navigate().refresh();
			ReusableComponents.wait(5000);
			ReusableComponents.scrollDown(browser, 100);
			ReusableComponents.wait(5000);

			// -->Open first transaction
			ReusableComponents.scrollDown(browser, 500);
			ReusableComponents.wait(5000);

			List<WebElement> recordsList = browser.findElements(By.xpath("(.//*[contains(text(),'TRN-')])[1]"));
			System.out.println("************ Number of transactions " + recordsList.size());

			ReusableComponents.clickElement(transactionUnder_JournalEntryLine,
					"Open transaction under new cash flow journal entry");
			ReusableComponents.wait(5000);

			// --> Change cash flow category value
			browser.navigate().refresh();
			ReusableComponents.wait(5000);
			ReusableComponents.scrollDown(browser, 100);
			ReusableComponents.wait(5000);
			ReusableComponents.clickUsingJavaScript(browser, editCashFlowCategoryButton,
					"Click on edit cash flow category button");
			ReusableComponents.wait(5000);
			String currentValueOfCashFlowCategory = ReusableComponents
					.elementGetAttribute(currentValueOf_CashFlowCategory_Transactions, "placeholder");

			if (currentValueOfCashFlowCategory.equalsIgnoreCase("Payments to suppliers")) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"Before performing edit cash flow category value is identified as Payments to suppliers",
						browser, pathLoc + "/" + testcasemethod, true);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
						"Before changing cash flow category", browser, pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents
						.reportFail(threadID, tempList, testcasemethod,
								"Before performing edit cash flow category value identified as "
										+ currentValueOfCashFlowCategory,
								browser, pathLoc + "/" + testcasemethod, true);
			}

			// ReusableComponents.scrollDown(browser, 100);
			ReusableComponents.wait(5000);

			ReusableComponents.clickUsingJavaScript(browser, clearValueButton_CashFlowCategory_Transactions,
					"Click on clear button of cash flow category");
			String newValueOfCashFlowCategory = reusableComponents.getPropValues("Testcase2730_ModifyCashFlowValue");
			ReusableComponents.sendKey(currentValueOf_CashFlowCategory_Transactions, newValueOfCashFlowCategory,
					"Provide value to the cash flow category");
			ReusableComponents.wait(2000);

			String selectionOfCashFlowCategory = "//lightning-base-combobox-formatted-text[@title='"
					+ newValueOfCashFlowCategory + "']//strong[contains(text(),'" + newValueOfCashFlowCategory + "')]";
			System.out.println("********** selectionOfCashFlowCategory xpath " + selectionOfCashFlowCategory);

			WebElement selectValueOfCashFlowCategory = browser.findElement(By.xpath(selectionOfCashFlowCategory));

			ReusableComponents.clickUsingJavaScript(browser, selectValueOfCashFlowCategory,
					"Select value of cash flow category");

			// -->Check the current value of cash flow before clicking on save button
			currentValueOfCashFlowCategory = ReusableComponents
					.elementGetAttribute(currentValueOf_CashFlowCategory_Transactions, "placeholder");

			if (!currentValueOfCashFlowCategory.equalsIgnoreCase("Payments to suppliers")) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"Cash flow category value changed to have " + currentValueOfCashFlowCategory, browser,
						pathLoc + "/" + testcasemethod, true);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
						"Current value of cashflow category", browser, pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Cash flow category value not changed. It still says " + currentValueOfCashFlowCategory,
						browser, pathLoc + "/" + testcasemethod, true);
			}

			ReusableComponents.clickElement(saveButtonOfEdit_JournalEntryLine,
					"Click on save button after editing cash flow category value");
			ReusableComponents.wait(2000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					"Click on save button", browser,
					pathLoc + "/" + testcasemethod, true);

			// -->Check the error text
			String errorText = ReusableComponents.getText(errorAfterClickingSave,
					"Verify the error after clicking on save");
			System.out.println("********** Actual error "+errorText);
			String expectedErrorText = reusableComponents.getPropValues("Testcase2730_ErrorText");

			if (!errorText.equalsIgnoreCase(expectedErrorText)) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"Error text displayed as expected " + expectedErrorText, browser,
						pathLoc + "/" + testcasemethod, true);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Find the Error text below", browser,
						pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Error text is not displayed as expected " + errorText, browser,
						pathLoc + "/" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "/" + testcasemethod, true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, true);
		}
		return new JournalEntryPage(browser);
	}

}
