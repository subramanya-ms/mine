package com.wisefinch.java;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base class for all the pages.
 *
 */
public class CashFlowStatementPage extends DriverScript {

	protected static WebDriver browser;
	static String dateGatheredToGiveNam;
	String valueToSet, cdbName, CDB_Name = null, accountingPeriod, cashDisbursementName;
	static String newGLName, newJournalName, testCaseNumber, newAccountname, currentAccountingPeriodForTheTestCase,
			newAccountingVariableName, clonedNewGLName;
	static int previousYearClose;
	static Boolean testDataNewJournalEntryCreated = false, accountCreatedStatus = false, pageOpened = false,
			newAccountingVariableCreated = false, newCashReceiptCreated = false, clonedGLAccountCreated = false,
			newGLAccountCreationStatus = false;

	static ReusableComponents reusableComponents = new ReusableComponents();

	protected CashFlowStatementPage(WebDriver browser) {
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
	@FindBy(xpath = ".//button[@title='Pin this list view']")
	static WebElement pinThisListViewButtion_AccountingPeriod;

	@FindBy(xpath = ".//*[@data-aura-class='forceListViewPicker']//button")
	static WebElement trigger_ForceListViewPicker_AccountingPeriod;

	@FindBy(xpath = ".//*[@class='listContent']//*[contains(text(),'All')]")
	static WebElement selectAll_ForceListViewPicker_AccountingPeriod;

	@FindBy(xpath = ".//*[@data-jest='showAllPeriods']//*[contains(text(),'Show All Periods')]")
	static WebElement showAllPeriodsCheckBox_CashFlowPage;

	@FindBy(xpath = ".//*[@class='slds-text-heading_small']")
	static WebElement trialBalanceErrorMessageHeading;

	@FindBy(xpath = ".//*[@class='inline-error-msg']//li")
	static WebElement trialBalanceErrorMessage;

	@FindBy(xpath = ".//*[@data-jest='suppressZeroAmountRows']//*[contains(text(),'Suppress Zero Amount')]")
	static WebElement supressZeroAmountCheckBox;

	@FindBy(xpath = "(.//*[@class='slds-box box-shadow']//input)[2]")
	static WebElement startingAccoutPeriodCashFlow;

	@FindBy(xpath = "((.//*[@class='slds-form-element'])[2]//input)[1]")
	static WebElement startingAccoutPeriodTrailBalance;

	@FindBy(xpath = "(.//*[@class='slds-form-element__control']//input)[1]")
	static WebElement ledgerTypeInputBox_TrailBalance;

	@FindBy(xpath = "//span[@class='slds-listbox__option-meta slds-listbox__option-meta_entity']")
	static WebElement selectLedgerType_TrailBalance;

	@FindBy(xpath = ".//button[@title='Clear Selection']")
	static WebElement clearSectionOfLedger_TrailBalance;

	@FindBy(xpath = ".//*[@class='actionBody']//*[contains(text(),'New GL Account')]")
	static WebElement newGLAccountPopup;

	@FindBy(xpath = "//span[@title='Assets']")
	static WebElement subType1_Value_As_Assets_newGLAccountPopUp;

	@FindBy(xpath = "(.//*[@class='actionBody']//input[@role='combobox'])[1]")
	static WebElement type_newGLAccountPopUp;

	@FindBy(xpath = "(.//*[@class='actionBody']//input[@role='combobox'])[2]")
	static WebElement subType1_newGLAccountPopUp;

	@FindBy(xpath = "((.//*[@class='slds-form'])[3]//input[@role='combobox'])[5]")
	static WebElement cashFlowInputBox_caseReceipt;

	@FindBy(xpath = ".//button[@title='Edit Cash Flow Category']")
	static WebElement editCashFlow_caseReceipt;

	@FindBy(xpath = ".//*[@slot='secondaryFields']//lightning-formatted-text[contains(text(),'Posted')]")
	static WebElement caseReceipt_Status_Posted;

	@FindBy(xpath = "//span[@class='slds-listbox__option-meta slds-listbox__option-meta_entity']")
	static WebElement selectAccountingPeriod_FinancialReport;

	@FindBy(xpath = ".//*[@class='actionBody']//button[@name='SaveEdit']")
	static WebElement saveButton_EditAccountingPeriod;

	@FindBy(xpath = ".//*[@class='actionBody']//*[contains(text(),'Closed')]")
	static WebElement selectStatusAsClosed_EditAccountingPeriod;

	@FindBy(xpath = ".//*[@class='actionBody']//input[@role='combobox']")
	static WebElement statusDropDown_EditAccountingPeriod;

	@FindBy(xpath = ".//button[@name='Edit']")
	static WebElement edit_AccountingPeriod;

	@FindBy(xpath = "(.//input[@type='text'])[2]")
	static WebElement accountingPeriod_CashFlowReport;

	@FindBy(xpath = "(.//*[@title='Remove selected option'])[1]")
	static WebElement startingAccoutPeriod_FinancialReport_Clear;

	@FindBy(xpath = "(.//*[@class='actionBody']//input[@role='combobox'])[2]")
	static WebElement subType_CF_GlAccounts;

	@FindBy(xpath = "(.//*[@class='actionBody']//input[@role='combobox'])[1]")
	static WebElement type_CF_GlAccounts;

	@FindBy(xpath = ".//*[@data-aura-class='forceInlineEditCell']//*[contains(text(),'Cash Flow')]//preceding::*[@data-aura-class='forceInlineEditCell']//a")
	static WebElement selectFirstElement_CF_GlAccounts;

	@FindBy(xpath = ".//*[@data-aura-class='forceListViewPicker']")
	static WebElement recentListView_GlAccounts;

	@FindBy(xpath = "//span[normalize-space()='Cash Flow Categories']")
	static WebElement selectCashFlowCategories_recentListView_GlAccounts;

	@FindBy(xpath = ".//*[@class='actionBody']//*[contains(text(),'New GL Account')]")
	static WebElement newGLAccount_PopUp;

	@FindBy(xpath = "((.//*[@class='actionBody']//*[@class='slds-form'])[3]//input[@role='combobox'])[5]")
	static WebElement cashFlowCategory_CashReceipt;

	@FindBy(xpath = ".//*[@class='slds-form-element']//*[@type='search']")
	static WebElement searchTextBox_AccountPeriod;

	@FindBy(xpath = ".//*[@data-aura-class='uiOutputText']")
	static WebElement listViewe_AccoutingPeriod;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Accounting Periods')]")
	static WebElement SelectAccountingPeriods;

	@FindBy(xpath = ".//span[normalize-space()='Cash Flow']")
	static WebElement selectCashFlowReport_FinancialReport;

	////////////////////////////

	@FindBy(xpath = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'CR-')]")
	static WebElement createdCashReceiptName;

	@FindBy(xpath = "((.//*[@class='actionBody']//*[@class='slds-form'])[3]//input[@role='combobox'])[7]")
	static WebElement glVariable1Value_CashReceipt;

	@FindBy(xpath = "(.//*[@data-aura-class='forceInlineEditCell']//a[contains(@title,'FC-')])[1]")
	static WebElement getFirstCFCubesName_FinancialCubes;

	@FindBy(xpath = ".//input[@role='combobox']")
	static WebElement inputBox_recentListViewe_FinancialCubes;

	@FindBy(xpath = ".//*[@data-aura-class='forceListViewPicker']//*[contains(text(),'Recently Viewed')]")
	static WebElement recentListView_FinancialCubes;

	@FindBy(xpath = ".//*[@class='actionBody']//button[@name='SaveEdit']")
	static WebElement saveButton_AccountingVariables;

	@FindBy(xpath = ".//*[@class='actionBody']//input[@name='Name']")
	static WebElement name_AccountingVariables;

	@FindBy(xpath = ".//*[@class='actionBody']//input[@role='combobox']")
	static WebElement typeDropDown_AccountingVariables;

	@FindBy(xpath = ".//*[@class='actionBody']//*[contains(text(),'New Accounting Variable')]")
	static WebElement newAccountingVariables_CreationPopUpcheck;

	@FindBy(xpath = ".//*[@class='actionBody']//*[contains(text(),'New Cash Receipt')]")
	static WebElement newCashReceipt_CreationPopUpcheck;

	@FindBy(xpath = "//div[@title='New']")
	static WebElement newbutton_AccountingVariables;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Financial Cubes')]")
	static WebElement SelectFinancialCubes;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Cash Receipts')]")
	static WebElement selectCashReceipts;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Accounting Variables')]")
	static WebElement SelectAccountingVariables;

	@FindBy(xpath = "//img[@title='Accounts']")
	static WebElement Accounts;

	@FindBy(xpath = "//force-record-layout-base-input//div[@class='slds-form-element__control slds-grow']/input[@name='Name']")
	static WebElement Account_Name;

	@FindBy(xpath = "((.//*[@class='actionBody']//force-record-layout-section)[2]//input[@role='combobox'])[2]")
	static WebElement Account_type;

	@FindBy(xpath = "//span[@class='slds-checkbox slds-checkbox_standalone']/input[@name='AcctSeed__Accounting_Active__c']")
	static WebElement Accounting_Active;

	@FindBy(xpath = ".//*[@placeholder='Search Accounting Periods...']")
	static WebElement accountingPeriod_Billing;

	@FindBy(xpath = "//img[@src='/img/icon/t4v35/custom/custom17_120.png']")
	WebElement Cash_Receipt_tab;

	@FindBy(xpath = "//div/slot/force-record-layout-row[2]/slot//input[contains(@placeholder,'Search Accounts..')]")
	WebElement Customer_CashReceipt;

	@FindBy(xpath = "//div[@class='slds-form']//force-record-layout-row[3]//force-record-layout-item//lightning-combobox//input[@class='slds-input slds-combobox__input']")
	static WebElement Type;

	@FindBy(xpath = "//input[@name='AcctSeed__Amount__c']")
	static WebElement Amount;

	@FindBy(xpath = "//input[@name='AcctSeed__Payment_Reference__c']")
	static WebElement Reference;

	@FindBy(xpath = "//div[@class='pbHeader']//tbody//input[@value='Post']")
	WebElement Post_final_CashReceipt;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounts...')]")
	static WebElement Customer_CR;

	@FindBy(xpath = "//img[@title='Cash Receipts']")
	static WebElement Cash_Receipts_tab;

	@FindBy(xpath = ".//*[@role='dialog']//*[@class='slds-popover__body']//li")
	static WebElement errorAfterClickingSave;

	@FindBy(xpath = ".//button[contains(text(),'Save')]")
	static WebElement saveButtonOfEdit_JournalEntryLine;

	@FindBy(xpath = "((.//force-record-layout-section)[4]//input)[4]/following::*[@title='Clear Selection']")
	static WebElement clearValueButton_CashFlowCategory_Transactions;

	@FindBy(xpath = "((.//force-record-layout-section)[4]//input)[4]")
	static WebElement currentValueOf_CashFlowCategory_Transactions;

	@FindBy(xpath = ".//button[@title='Edit Cash Flow Category']")
	static WebElement editCashFlowCategoryButton;

	@FindBy(xpath = "(.//*[contains(text(),'TRN-')])[1]")
	static WebElement transactionUnder_JournalEntryLine;

	@FindBy(xpath = ".//*[@class='slds-grid']//input")
	static WebElement search_NSFR;

	@FindBy(xpath = ".//*[@class='slds-grid ']//*[@type='search']")
	static WebElement search_JournalEntry;

	@FindBy(xpath = ".//*[@slot='primaryField']/lightning-formatted-text")
	static WebElement nameOfCreatedJournal;

	@FindBy(xpath = ".//*[@slot='secondaryFields']/*[@role='listitem']//*[contains(text(),'Posted')]")
	static WebElement checkStatus;

	@FindBy(xpath = ".//*[@class='slds-button-group-list']//button[@name='New']")
	static WebElement newJournalEntryLine;

	@FindBy(xpath = "(.//button[contains(text(),'Save')])[2]")
	static WebElement saveButton_newJournalEntryPopup;

	@FindBy(xpath = ".//*[@class=\"slds-form\"]//input[@name='AcctSeed__Journal_Date__c']")
	static WebElement journalDate_newJournalEntryPopup;

	@FindBy(xpath = ".//*[@class=\"slds-form\"]//input[@name='Name']")
	static WebElement journalName_newJournalEntryPopup;

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

	@FindBy(xpath = ".//input[@type='button' and @value='Post']")
	static WebElement postButton_UnderPostJournalEntry;

	@FindBy(xpath = ".//*[@class='mainTitle' and contains(text(),'Post')]")
	static WebElement verifyPostPageDisplay_JournalEntry;

	@FindBy(xpath = "(.//*[@class='slds-form']//input[@role='combobox'])[3]")
	static WebElement accountingPeriod_newJournalEntryPopup;

	@FindBy(xpath = "(.//*[@class='slds-form']//input[@role='combobox'])[1]")
	static WebElement recurringJournalEntry_newJournalEntryPopup;

	@FindBy(xpath = ".//*[@class=\"slds-form\"]//input[@placeholder='Search Ledgers...']")
	static WebElement searchLedgers_newJournalEntryPopup;

	@FindBy(xpath = "(.//*[@class='slds-form']//input[@role='combobox'])[2]")
	static WebElement currency_newJournalEntryPopup;

	@FindBy(xpath = ".//*[@class='slds-modal__header']/h2[contains(text(),'New Journal Entry')]")
	static WebElement newJournalEntry_Popup;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Journal Entries')]")
	static WebElement journalEntries;

	@FindBy(xpath = ".//*[@role='listitem']//*[contains(text(),'Posted')]")
	WebElement newCashDisbursementName_StatusConfirmation_Posted;

	@FindBy(xpath = ".//*[@slot='primaryField']/lightning-formatted-text")
	WebElement newCashDisbursementName;

	@FindBy(xpath = ".//*[@title='Remove selected option']")
	WebElement removeSelectedAccountingPeriod_CashFlow_FinancialReport;

	@FindBy(xpath = ".//*[@data-jest='startingAccountingPeriod']//input")
	WebElement AccountingPeriod_CashFlow_FinancialReport;

	@FindBy(xpath = "//span[@class='slds-listbox__option-meta slds-listbox__option-meta_entity']")
	WebElement selectAccountingPeriod_CashFlow_FinancialReport;

	@FindBy(xpath = "//button[@name='Edit']")
	static
	// @FindBy(xpath =
	// ".//*[@class='slds-button-group-list']//button[@name='Edit']")
	WebElement Edit;

	@FindBy(xpath = "//label[contains(text(),'Status')]")
	static WebElement Status;

	@FindBy(xpath = "//slot[@slot='secondaryFields']//lightning-formatted-text[.='Open']")
	static WebElement Open_Status;

	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	static WebElement Home;

	@FindBy(xpath = "//input[@placeholder='Search apps and items...']")
	static WebElement Input;

	@FindBy(xpath = ".//*[@class='slds-truncate']//*[contains(text(),'Accounting Periods')]")
	static WebElement click_ap;

	@FindBy(xpath = "//button[.='Select List View']")
	static WebElement listview;

	@FindBy(xpath = "//span[contains(.,'All')][contains(@class,'virtualAutocompleteOptionText')]")
	static WebElement all_list;

	@FindBy(xpath = ".//*[@placeholder='Search Accounting Periods...']")
	static WebElement accountingPeriod_FinancialReport;

	@FindBy(xpath = ".//button[contains(text(),'Run')]")
	static WebElement runButton_FinancialReport;

	@FindBy(xpath = "(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]")
	static WebElement firstReport_FinancialReport;

	@FindBy(xpath = ".//button[contains(text(),'Select Standard Report')]")
	static WebElement selectStandartReport_FinancialReport;

	@FindBy(xpath = "//img[@title='Accounting Settings']")
	static WebElement Accounting_Settings;

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

	@FindBy(xpath = "//div/h3[contains(.,'Cash Flow Statement Settings')]")
	static WebElement CFS_Setting;

	@FindBy(xpath = "//img[@title='Cash Disbursement Batches']")
	WebElement CDBatches;

	@FindBy(xpath = "//img[@title='Cash Disbursement']")
	WebElement cashDiscursementPage;

	@FindBy(xpath = "//input[contains(@name,'Name')]")
	WebElement CDB_name;

	@FindBy(xpath = "//input[@name='AcctSeed__Starting_Check_Number__c']")
	WebElement CDB_checkno;

	@FindBy(xpath = "//img[@title='Cash Disbursements']")
	WebElement Cash_disbursements;

	@FindBy(xpath = "//input[@placeholder='Search Cash Disbursement Batches...']")
	WebElement CDB_select;

	@FindBy(xpath = "//force-record-layout-row[1]//force-record-layout-item[2]//lightning-combobox[1]//input[1]")
	WebElement CD_type;

	@FindBy(xpath = "//input[@name='AcctSeed__Amount__c']")
	WebElement CD_amount;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounts...')]")
	WebElement CD_vendor;

	@FindBy(xpath = "(//input[@placeholder='Search GL Accounts...'])[1]")
	WebElement CD_Bankaccount;

	@FindBy(xpath = "//button[.='Post']")
	WebElement Post;

	@FindBy(xpath = ".//input[@value='Post']")
	WebElement Post_final;

	@FindBy(xpath = "//a[@id='AcctSeed__GL_Account__c']//b[contains(text(),'GL Accounts')]")
	static WebElement SelectGLAccount;

	@FindBy(xpath = ".//slot[@slot='primaryField']//lightning-formatted-text[contains(text(),'1000-Cash')]")
	static WebElement cash1000_Page;

	@FindBy(xpath = ".//button[contains(text(),'Clone')]")
	static WebElement cloneButton_cash1000;

	@FindBy(xpath = ".//*[@class='actionBody']//*[contains(text(),'New GL Account')]")
	static WebElement clonePopup_cash1000;

	@FindBy(xpath = ".//*[@name='Name']")
	static WebElement name_NewGLAccount;

	@FindBy(xpath = "(.//*[@name='AcctSeed__Bank__c'])[3]")
	WebElement bankCreditCardAccount_CheckBox_NewGLAccount;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	static WebElement saveButton_NewGLAccount;

	@FindBy(xpath = "//div[@title='New']")
	static WebElement New;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	static WebElement Save;

	@FindBy(xpath = "((.//force-record-layout-section)[3]//input)[5]")
	WebElement CFCategory;

	@FindBy(xpath = ".//span[normalize-space()='Cash Flow']")
	static WebElement CashFlow_selectStandartReport_FinancialReport;

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

	/*
	 * From Accounting Home, click on Accounts (under Master Data Setup) and
	 * create/edit one so it has: Accounting Type = Customer & Vendor and Accounting
	 * Active checked Author : Lakshman
	 */
	public static void checkDefaultValueOfCashFlowStatement(int threadID, List<String> tempList, String pathLocation)
			throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println("********** checkDefaultValueOfCustomerVendorandAccounting");

		navigateToAccountingHomePage();

		try {
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
				ReusableComponents.wait(5200);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Accounting Settings tab is present",
						browser, pathLocation + "\\" + testcasemethod, false);

				browser.switchTo().frame(0);

				WebElement element = browser
						.findElement(By.xpath("//div/h3[contains(.,'Cash Flow Statement Settings')]"));
				((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
				ReusableComponents.wait(3200);

				if (ReusableComponents.isElementPresent(CFS_Setting)) {

					ReusableComponents.wait(5200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Cash Flow Statement Settings tab is present", browser,
							pathLocation + "\\" + testcasemethod, false);
					ReusableComponents.wait(5200);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
							"screen grab of Cash Flow Statement Settings section, this is a non editable section",
							browser, pathLocation + "\\" + testcasemethod, true);

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Cash Flow Statement Settings tab not present", browser,
							pathLocation + "\\" + testcasemethod, true);
				}
				browser.switchTo().defaultContent();
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Accounting Settings tab not present",
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			browser.switchTo().defaultContent();
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Unable to select app from select search app section" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}
	}

	/**
	 * @author Wisefinch Menaka
	 * @see Just navigate to home page. This only work after successfull login to
	 *      the page. Else will keep navigate to login page.
	 * @throws IOException
	 */
	public static void navigateToAccountingHomePage() throws IOException {
		String url = reusableComponents.getPropValues("PLURL");
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
	public static BankingLedgerPage selectAppFromSearchAppAndItem(int threadID, List<String> tempList,
			String pathLocation,

			String appNameToSearch, WebElement selectAppXpath) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		navigateToAccountingHomePage();

		try {
			ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
			ReusableComponents.wait(5000);
			ReusableComponents.sendKey(SearchAppAndItemInputbox, appNameToSearch, "Search app and Item inputbox");
			ReusableComponents.clickElement(selectAppXpath, "Select value from App and Item dropdown");
			ReusableComponents.wait(8000);

			String pageCheckXpath = ".//*[@aria-label='Breadcrumbs']//span[contains(text(),'" + appNameToSearch + "')]";
			System.out.println("*********** pageCheckXpath : " + pageCheckXpath);

			List<WebElement> pageCheckElement = browser.findElements(By.xpath(pageCheckXpath));
			System.out.println("*********** pageCheckElement size : " + pageCheckElement.size());

			if (pageCheckElement.size() != 0) {
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						appNameToSearch + " page opened successfully", browser, pathLocation + "\\" + testcasemethod,
						false);

				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLocation + "\\" + testcasemethod, true);
			} else {
				throw new throwNewException(appNameToSearch, "Page is not opened");
			}

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
		return new BankingLedgerPage(browser);

	}

	/**
	 * Author Menaka
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param appNameToSearch
	 * @param selectAppXpath
	 * @throws Exception
	 */
	public static void cloneGLAccount(int threadID, List<String> tempList, String pathLocation) throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "GL Accounts", SelectGLAccount);
			ReusableComponents.wait(10000);

			// --> Click on 1000-Cash under GL account page
			try {
				List<WebElement> glAccountNameList = browser
						.findElements(By.xpath(".//*[contains(text(),'1000-Cash')]"));
				int numberGLAccountFould = glAccountNameList.size();
				boolean GLAccountSelected = false;
				for (int j = 0; j <= numberGLAccountFould; j++) {
					String name = glAccountNameList.get(j).getText();
					System.out.println("********** GL Account Name " + name);

					if (name.equals("1000-Cash")) {
						glAccountNameList.get(j).click();
						ReusableComponents.wait(10000);
						if (cash1000_Page.isDisplayed()) {
							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
									"1000-Cash page opened", browser, pathLocation + "\\" + testcasemethod, true);
							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
									"1000-Cash page opened", browser, pathLocation + "\\" + testcasemethod, true);
						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"1000-cash page is not opened", browser, pathLocation + "\\" + testcasemethod,
									true);
						}
						GLAccountSelected = true;
						break;
					}
				}

				if (GLAccountSelected == false) {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Unable to find the GL account name 1000-cash", browser,
							pathLocation + "\\" + testcasemethod, true);
				}

			} catch (Exception e) {
				throw new throwNewException("Select GL account name ",
						"Unable to select 1000-Cash from GL Account page" + e.getMessage());
			}

			// --> Click on 1000-Cash clone button

			ReusableComponents.clickElement(cloneButton_cash1000, "Clone Button");
			ReusableComponents.wait(5000);

			// --> Provide values on 1000-Cash clone button

			if (clonePopup_cash1000.isDisplayed() == true) {
				newGLName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_GLAccount";
				ReusableComponents.sendKey(name_NewGLAccount, newGLName, "Cloned GL Account Name");
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
						"With the assumption Bank/Credit Card Account check box will be always selected", browser,
						pathLocation + "\\" + testcasemethod, true);
				ReusableComponents.clickElement(saveButton_NewGLAccount, "Click on Save");
				ReusableComponents.wait(5000);

				String clonedGLAccount = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'"
						+ newGLName + "')]";
				if (browser.findElement(By.xpath(clonedGLAccount)).isDisplayed() == true) {
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
							"New GL Account " + newGLName + " is displayed", browser,
							pathLocation + "\\" + testcasemethod, true);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"New GL Account " + newGLName + " is not displayed", browser,
							pathLocation + "\\" + testcasemethod, true);
				}
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"New GL Account popup is not displayed", browser, pathLocation + "\\" + testcasemethod, true);
			}
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Unable to select app from select search app section" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

	}

	/***
	 * Test case Method Name : validateTestD Functionality : validate T2722 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 * 
	 ***/
	public synchronized CashFlowStatementPage cashDisbursementBatch(int threadID, List<String> tempList,
			String pathLocation) throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			browser.navigate()
					.to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(5200);

			String cdbname = reusableComponents.getPropValues("cdbname");
			String cdbcheckno = reusableComponents.getPropValues("cdbcheckno");
			CDB_Name = cdbname;

			ReusableComponents.wait(6200);

			List<WebElement> f = browser.findElements(By.tagName("frame"));
			int i = f.size();
			System.out.println(i + " is the frame count");

			browser.switchTo().frame(0);

			ReusableComponents.wait(6200);

			if (ReusableComponents.isElementPresent(CDBatches)) {

				ReusableComponents.wait(5200);
				CDBatches.click();
				ReusableComponents.wait(5200);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Cash Disbursement Batches tab is present", browser, pathLocation + "\\" + testcasemethod,
						false);

				if (ReusableComponents.isElementPresent(New)) {

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
							"screen grab of Cash Disbursement Batches page", browser,
							pathLocation + "\\" + testcasemethod, true);
					ReusableComponents.wait(5200);
					New.click();
					ReusableComponents.wait(5200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Cash Disbursement Batches New button is present", browser,
							pathLocation + "\\" + testcasemethod, false);

					if (ReusableComponents.isElementPresent(CDB_name)) {

						cdbName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_CDB";
						ReusableComponents.wait(5200);
						CDB_name.sendKeys(cdbName);
						ReusableComponents.wait(5200);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Cash Disbursement Batches Name field is present", browser,
								pathLocation + "\\" + testcasemethod, false);

						if (ReusableComponents.isElementPresent(CDB_checkno)) {

							ReusableComponents.reportPass(threadID, tempList, testcasemethod,
									"Cash Disbursement Batches Check no field is present", browser,
									pathLocation + "\\" + testcasemethod, false);
							ReusableComponents.wait(5200);
							CDB_checkno.sendKeys(cdbcheckno);
							ReusableComponents.wait(5200);

							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
									"screen grab of Cash Disbursement creation page", browser,
									pathLocation + "\\" + testcasemethod, true);
							ReusableComponents.wait(5200);

							if (ReusableComponents.isElementPresent(Save)) {

								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Save button is present", browser, pathLocation + "\\" + testcasemethod, false);
								Save.click();
								ReusableComponents.wait(10000);
								String cashDisbursementPage = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'"
										+ cdbName + "')]";
								if (browser.findElement(By.xpath(cashDisbursementPage)).isDisplayed() == true) {
									if (newCashDisbursementName_StatusConfirmation_Posted.isDisplayed()) {
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
												"New cash disbursement batch " + cdbName + " is created", browser,
												pathLocation + "\\" + testcasemethod, true);
									}
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"New cash disbursement batch " + cdbName + " is not created", browser,
											pathLocation + "\\" + testcasemethod, true);
								}
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"Cash Disbursement Batches Check no field is not present", browser,
									pathLocation + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Cash Disbursement Batches Name field is not present", browser,
								pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Cash Disbursement Batches New button is not present", browser,
							pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Cash Disbursement Batches tab is not present", browser, pathLocation + "\\" + testcasemethod,
						true);
			}

			browser.switchTo().defaultContent();

		} catch (NoSuchElementException e) {

			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Object is NOT present" + e.getStackTrace(), browser, pathLocation + "\\" + testcasemethod, false);

		}

		return new CashFlowStatementPage(browser);

	}

	/***
	 * Test case Method Name : validateTestD Functionality : validate T2722 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws throwNewException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized CashFlowStatementPage CashDisbursement(int threadID, List<String> tempList, String pathLocation)
			throws IOException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			browser.navigate()
					.to("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Accounting_Home1");
			ReusableComponents.wait(5200);

			String CDtype = reusableComponents.getPropValues("cdtype");
			String CD_Amount = reusableComponents.getPropValues("amount");
			String CDBank = reusableComponents.getPropValues("cdbank");
			String account_namefull = reusableComponents.getPropValues("accname");
			accountingPeriod = reusableComponents.getPropValues("accounting_Period");

			ReusableComponents.wait(6200);

			List<WebElement> f = browser.findElements(By.tagName("frame"));
			int i = f.size();
			System.out.println(i + " is the frame count");

			browser.switchTo().frame(0);

			ReusableComponents.wait(6200);

			if (ReusableComponents.isElementPresent(Cash_disbursements)) {

				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement tab is present",
						browser, pathLocation + "\\" + testcasemethod, false);
				ReusableComponents.wait(3200);
				Cash_disbursements.click();
				ReusableComponents.wait(5200);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
						"screen grab of Cash Disbursement page", browser, pathLocation + "\\" + testcasemethod, true);
				ReusableComponents.wait(5200);

				if (ReusableComponents.isElementPresent(New)) {

					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Cash Disbursement New button is present", browser, pathLocation + "\\" + testcasemethod,
							false);
					ReusableComponents.wait(3200);
					New.click();
					ReusableComponents.wait(5200);

					if (ReusableComponents.isElementPresent(CDB_select)) {
						// cdbName = "20210918_171654_CDB";
						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Cash Disbursement Batch searchbox is present", browser,
								pathLocation + "\\" + testcasemethod, false);
						ReusableComponents.wait(3200);
						CDB_select.sendKeys(cdbName);
						ReusableComponents.wait(5200);

						WebElement CDB_click = browser.findElement(
								By.xpath("//lightning-base-combobox-formatted-text[@title='" + cdbName + "']"));
						ReusableComponents.wait(5200);
						CDB_click.click();
						System.out.println("Cash disbursement batch selected");
						ReusableComponents.wait(5200);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
								"Cash disbursement batch selected", browser, pathLocation + "\\" + testcasemethod,
								true);

						ReusableComponents.selectAccountingPeriod(accountingPeriod_FinancialReport, accountingPeriod,
								browser);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
								"Accounting Period Selected", browser, pathLocation + "\\" + testcasemethod, true);

						if (ReusableComponents.isElementPresent(CD_type)) {

							ReusableComponents.reportPass(threadID, tempList, testcasemethod,
									"Cash Disbursement Type selectbox is present", browser,
									pathLocation + "\\" + testcasemethod, false);
							ReusableComponents.wait(3200);
							CD_type.click();
							ReusableComponents.wait(5200);

							WebElement CD_Type = browser.findElement(By.xpath("//span[@title='" + CDtype + "']"));
							ReusableComponents.wait(5200);
							CD_Type.click();
							System.out.println("Cash disbursement type selected");
							ReusableComponents.wait(5200);

							if (ReusableComponents.isElementPresent(CD_amount)) {

								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Cash Disbursement Amount field is present", browser,
										pathLocation + "\\" + testcasemethod, false);
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
											pathLocation + "\\" + testcasemethod, false);
									ReusableComponents.wait(3200);
									CD_vendor.sendKeys(account_namefull);
									ReusableComponents.wait(5200);

									WebElement CD_Vendor = browser
											.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='"
													+ account_namefull + "']"));
									ReusableComponents.wait(5200);
									CD_Vendor.click();
									System.out.println("Cash disbursement vendor selected");
									ReusableComponents.wait(5200);

									WebElement elements = browser.findElement(
											By.xpath("//span[normalize-space()='Accounting Information']"));
									((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);",
											elements);

									if (ReusableComponents.isElementPresent(CD_Bankaccount)) {
										// newGLName = "20210918_171601_GLAccount";
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"Cash Disbursement Bank searchbox is present", browser,
												pathLocation + "\\" + testcasemethod, false);
										ReusableComponents.wait(3200);
										CD_Bankaccount.sendKeys(newGLName);
										ReusableComponents.wait(10000);

										WebElement CD_Bank = browser.findElement(
												By.xpath("//lightning-base-combobox-formatted-text[@title='" + newGLName
														+ "']"));
										ReusableComponents.wait(5200);
										CD_Bank.click();
										System.out.println("Cash disbursement bank selected");
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
												"Cash disbursement bank selected", browser,
												pathLocation + "\\" + testcasemethod, true);
										ReusableComponents.wait(5200);

										ReusableComponents.sendKey(CFCategory, "Balance", "Cash Flow Category");
										ReusableComponents.wait(5200);
										// lightning-base-combobox-item[@id='input-1292-1-1292']//span[@class='slds-listbox__option-text
										// slds-listbox__option-text_entity']
										String cashFlowSelect = "(.//*[contains(text(),'Balance')])[2]";
										List<WebElement> cashFlowCategorySelect = browser
												.findElements(By.xpath(cashFlowSelect));

										if (cashFlowCategorySelect.size() != 0) {
											cashFlowCategorySelect.get(0).click();
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
													"Cash Flow Category Selected to have other than default value",
													browser, pathLocation + "\\" + testcasemethod, true);
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Unable to select Cash Flow Category", browser,
													pathLocation + "\\" + testcasemethod, true);
										}

										if (ReusableComponents.isElementPresent(Save)) {

											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Cash Disbursement save button is present", browser,
													pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.wait(3200);
											Save.click();
											ReusableComponents.wait(8200);
											cashDisbursementName = ReusableComponents.getText(newCashDisbursementName,
													"Get Cash disbursement Name");
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
													"New cash disbursement name : " + cashDisbursementName, browser,
													pathLocation + "\\" + testcasemethod, true);
											if (ReusableComponents.isElementPresent(Post)) {

												ReusableComponents.reportPass(threadID, tempList, testcasemethod,
														"Cash Disbursement Post button is present", browser,
														pathLocation + "\\" + testcasemethod, false);
												ReusableComponents.wait(3200);
												Post.click();
												ReusableComponents.wait(10000);

												browser.switchTo().frame(0);

												if (ReusableComponents.isElementPresent(Post_final)) {

													ReusableComponents.reportPass(threadID, tempList, testcasemethod,
															"Cash Disbursement Post finalise button is present",
															browser, pathLocation + "\\" + testcasemethod, false);
													ReusableComponents.wait(3200);
													Post_final.click();
													ReusableComponents.wait(10000);

													String cashDisbursementPage = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'"
															+ cashDisbursementName + "')]";
													if (browser.findElement(By.xpath(cashDisbursementPage))
															.isDisplayed() == true) {
														if (newCashDisbursementName_StatusConfirmation_Posted
																.isDisplayed()) {
															ReusableComponents.reportSpecific(threadID, tempList,
																	testcasemethod,
																	"New cash disbursement " + cashDisbursementName
																			+ " Status changed to have posted",
																	browser, pathLocation + "\\" + testcasemethod,
																	true);
														}
													} else {
														ReusableComponents.reportFail(threadID, tempList,
																testcasemethod,
																"New cash disbursement " + cashDisbursementName
																		+ " page is not displayed",
																browser, pathLocation + "\\" + testcasemethod, true);
													}

												} else {
													ReusableComponents.reportFail(threadID, tempList, testcasemethod,
															"Cash Disbursement Post button is not present", browser,
															pathLocation + "\\" + testcasemethod, true);
												}

												browser.switchTo().defaultContent();

											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Cash Disbursement Post button is not present", browser,
														pathLocation + "\\" + testcasemethod, true);
											}

										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Cash Disbursement save button is not present", browser,
													pathLocation + "\\" + testcasemethod, true);
										}

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Cash Disbursement Bank searchbox is not present", browser,
												pathLocation + "\\" + testcasemethod, true);
									}

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Cash Disbursement Vendor searchbox is not present", browser,
											pathLocation + "\\" + testcasemethod, true);
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"Cash Disbursement  Amount field is not present", browser,
										pathLocation + "\\" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"Cash Disbursement Type selectbox is not present", browser,
									pathLocation + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Cash Disbursement Batch searchbox is not present", browser,
								pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Cash Disbursement New button is not present", browser,
							pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Cash Disbursement tab is not present", browser, pathLocation + "\\" + testcasemethod, true);
			}

			browser.switchTo().defaultContent();

		} catch (NoSuchElementException e) {

			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Object is NOT present" + e.getStackTrace(), browser, pathLocation + "\\" + testcasemethod, false);
		}

		return new CashFlowStatementPage(browser);
	}

	/***
	 * Test case Test case Name : create new journal functionality Author : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized CashFlowStatementPage financialReportCashFlowStatement(int threadID, List<String> tempList,
			String pathLocation) throws Exception, throwNewException {
		System.out.println("********** test_Journal_Entries");
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {
			// Run Financial Report
			String financialReportsURL = reusableComponents.getPropValues("FinancialReports");
			browser.get(financialReportsURL);
			// Browser.get is used here since there are issue in launching financial report
			// from search app. Once the issue resolved we can comment it and unccomment
			// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
			// Reports",
			ReusableComponents.wait(5000);

			wait(5000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, "Financial Reports page opened",
					browser, pathLocation + "\\" + testcasemethod, true);
			ReusableComponents.clickElement(selectStandartReport_FinancialReport, "Click Select standard reportd");
			wait(5000);
			ReusableComponents.clickElement(CashFlow_selectStandartReport_FinancialReport, "Click Select Cash flow");
			wait(5000);

			ReusableComponents.clickElement(removeSelectedAccountingPeriod_CashFlow_FinancialReport,
					"Clear FinancialYear");
			ReusableComponents.wait(2000);
			ReusableComponents.sendKey(AccountingPeriod_CashFlow_FinancialReport, accountingPeriod,
					"Send value to the accounting period");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(selectAccountingPeriod_CashFlow_FinancialReport,
					"Select Accounting Period");

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Accounting Period Selected", browser,
					pathLocation + "\\" + testcasemethod, true);
			ReusableComponents.scrollDown(browser, 300);

			List<WebElement> recordsList = browser
					.findElements(By.xpath("(.//*[@scope='row']//*[@class='slds-truncate']//a)[1]"));
			System.out.println("************ Number of elements " + recordsList.size());
			if (recordsList.size() != 0) {
				String oldRecordName = firstReport_FinancialReport.getText();

				ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser, " ",
						false);
				wait(10000);

				String newRecord = firstReport_FinancialReport.getText();

				if (!newRecord.contains("FRR")) {
					ReusableComponents.wait(20000);

					newRecord = firstReport_FinancialReport.getText();
				}

				if (newRecord.contains("FRR") && !oldRecordName.equalsIgnoreCase(newRecord)) {
					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Link of " + newRecord + " financial report : " + hreflink, browser,
							pathLocation + "\\" + testcasemethod, false);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
							pathLocation + "\\" + testcasemethod, true);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There are no new records created, provide valid inputs ", browser,
							pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser, " ",
						false);
				wait(10000);

				List<WebElement> newRecordsList = browser
						.findElements(By.xpath("(.//*[@scope='row']//*[@class='slds-truncate']//a)[1]"));
				System.out.println("************ Number of new records" + newRecordsList.size());
				if (newRecordsList.size() == 0) {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There are no new records created , please verify the input values", browser,
							pathLocation + "\\" + testcasemethod, true);
				} else {

					String newRecord = firstReport_FinancialReport.getText();

					if (!newRecord.contains("FRR")) {
						ReusableComponents.wait(20000);

						newRecord = firstReport_FinancialReport.getText();
					}

					if (newRecord.contains("FRR")) {
						String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Link of " + newRecord + "financial report : " + hreflink, browser,
								pathLocation + "\\" + testcasemethod, false);
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There are no new records created , please verify the input values", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				}

			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
	}

	/**
	 * @author Wisefinch : Lakshman
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws IOException
	 * @throws AWTException
	 */
	public synchronized CashFlowStatementPage closeAccountingPeriod(int threadID, List<String> tempList,
			String pathLocation) throws IOException, AWTException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			navigateToAccountingHomePage();
			String acc_period = reusableComponents.getPropValues("accounting_Period");
			String per_stat = reusableComponents.getPropValues("pstat");
			String last_period = null;
			String strArray[] = acc_period.split("-");
			String yearValue = strArray[0];
			int year = Integer.parseInt(strArray[0]);
			int month = Integer.parseInt(strArray[1]);

			previousYearClose = year - 1; // call previous year account period close method

			closeAccountingPeriodBasedOnYear(threadID, tempList, pathLocation);

			ReusableComponents.wait(5200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page",
					browser, pathLocation + "\\" + testcasemethod, true);
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
					"screen grab of Accounting period page", browser, pathLocation + "\\" + testcasemethod, true);

			int j = 1;
			String acct_period = null;

			for (j = 1; j <= month; j++) {

				String monthValue = null;

				if (j <= 9) {
					monthValue = "0" + j;
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
												"Edit button is present", browser, pathLocation + "\\" + testcasemethod,
												false);

										if (ReusableComponents.isElementPresent(Status)) {

											ReusableComponents.wait(3200);
											Status.click();
											ReusableComponents.wait(5500);
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Status selectbox is present", browser,
													pathLocation + "\\" + testcasemethod, false);

											String P_stat = "//span[@title='" + per_stat + "']";

											WebElement selecttype = browser.findElement(By.xpath(P_stat));
											ReusableComponents.wait(5500);
											selecttype.click();
											System.out.println("Accounting period status present");
											ReusableComponents.wait(5500);

											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
													"screen grab of Editing Accounting period", browser,
													pathLocation + "\\" + testcasemethod, true);

											if (ReusableComponents.isElementPresent(Save)) {

												ReusableComponents.reportPass(threadID, tempList, testcasemethod,
														"Save button is present", browser,
														pathLocation + "\\" + testcasemethod, false);
												ReusableComponents.wait(7200);
												Save.click();
												ReusableComponents.wait(6500);

											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Save button is NOT present ", browser,
														pathLocation + "\\" + testcasemethod, true);
											}

										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Status selectbox is NOT present ", browser,
													pathLocation + "\\" + testcasemethod, true);
										}

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Edit button is NOT present ", browser,
												pathLocation + "\\" + testcasemethod, true);
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

			System.out.println(last_period + " is th ending period of year " + acc_period);

		} catch (NoSuchElementException e) {

			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Object is NOT present" + e.getStackTrace(), browser, pathLocation + "\\" + testcasemethod, false);

		}

		return new CashFlowStatementPage(browser);

	}

	/***
	 * Test case Method Name : validateTestC Functionality : validate PreBL Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized static CashFlowStatementPage closeAccountingPeriodBasedOnYear(int threadID,
			List<String> tempList, String pathLocation) throws IOException, AWTException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			navigateToAccountingHomePage();
			String per_stat = reusableComponents.getPropValues("pstat");
			String last_period = null;
			ReusableComponents.wait(5200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page",
					browser, pathLocation + "\\" + testcasemethod, true);
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
					"screen grab of Accounting period page", browser, pathLocation + "\\" + testcasemethod, true);

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
												"Edit button is present", browser, pathLocation + "\\" + testcasemethod,
												false);

										if (ReusableComponents.isElementPresent(Status)) {

											ReusableComponents.wait(3200);
											Status.click();
											ReusableComponents.wait(5500);
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Status selectbox is present", browser,
													pathLocation + "\\" + testcasemethod, false);

											String P_stat = "//span[@title='" + per_stat + "']";

											WebElement selecttype = browser.findElement(By.xpath(P_stat));
											ReusableComponents.wait(5500);
											selecttype.click();
											System.out.println("Accounting period status present");
											ReusableComponents.wait(5500);

											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
													"screen grab of Editing Accounting period", browser,
													pathLocation + "\\" + testcasemethod, true);

											if (ReusableComponents.isElementPresent(Save)) {

												ReusableComponents.reportPass(threadID, tempList, testcasemethod,
														"Save button is present", browser,
														pathLocation + "\\" + testcasemethod, false);
												ReusableComponents.wait(7200);
												Save.click();
												ReusableComponents.wait(6500);

											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Save button is NOT present ", browser,
														pathLocation + "\\" + testcasemethod, true);
											}

										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Status selectbox is NOT present ", browser,
													pathLocation + "\\" + testcasemethod, true);
										}

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Edit button is NOT present ", browser,
												pathLocation + "\\" + testcasemethod, true);
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

		} catch (NoSuchElementException e) {

			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Object is NOT present" + e.getStackTrace(), browser, pathLocation + "\\" + testcasemethod, false);

		}

		return new CashFlowStatementPage(browser);

	}

	/**
	 * Test case Test case Name : [CF] Verify newly added Bank account and
	 * transactions to this are shown on the report
	 * 
	 * @author Menaka M
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 * @throws throwNewException
	 */
	public synchronized CashFlowStatementPage test2732_CFReportAmountValidation(int threadID, List<String> tempList,
			String pathLocation) throws Exception, throwNewException {
		System.out.println("********** test_Journal_Entries");
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLocation = reusableComponents.pathBuilder(path);

		try {
			LoginToWebpage();
			// check Cash flow statement. it should be true
			developerConsole_QueryRun_CashFlowTrueOrFalse(threadID, tempList, pathLocation, true);
			String url = reusableComponents.getPropValues("PLURL");
			browser.get(url);
			ReusableComponents.wait(5000);
			// -->Clone GL account
			cloneGLAccount(threadID, tempList, pathLocation);

			// --> Create cash disbursement batch
			cashDisbursementBatch(threadID, tempList, pathLocation);

			// --> Create cash disbursement and post
			CashDisbursement(threadID, tempList, pathLocation);

			// --> Close accounting period
			closeAccountingPeriod(threadID, tempList, pathLocation);

			// --> Run Financial report for cash flow statement
			financialReportCashFlowStatement(threadID, tempList, pathLocation);

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
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
	public static synchronized CashFlowStatementPage developerConsole_QueryRun_CashFlowTrueOrFalse(int threadID,
			List<String> tempList, String pathLoc, boolean cashFlowEnableValue) throws Exception, throwNewException {
		System.out.println("********** test_Journal_Entries");
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLoc = reusableComponents.pathBuilder(path);

		boolean cashFlowEnable = cashFlowEnableValue;
		System.out.println("********** Expected condition cashFlowEnable : " + cashFlowEnable);
		try {
			try {
				LoginToWebpage();
				ReusableComponents.wait(5000);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("########## Login is not applicable");
			}

			checkDefaultValueOfCashFlowStatement(threadID, tempList, pathLoc);

			navigateToAccountingHomePage();
			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"Cash flow value : set it to have " + cashFlowEnable, browser, pathLoc + "\\" + testcasemethod,
					false);
			ReusableComponents.wait(5000);
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

			checkDefaultValueOfCashFlowStatement(threadID, tempList, pathLoc);

			ReusableComponents.wait(5000);

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "\\" + testcasemethod, true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
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
	 * @Test Description : Test case Test case Name : create new journal
	 *       functionality
	 * @author Wisefinch : Menaka
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public synchronized static CashFlowStatementPage createNewJournalEntries(int threadID, List<String> tempList,
			String pathLocation) throws Exception {
		System.out.println("********** test_Journal_Entries");
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		newJournalName = "NewJournal_" + testCaseNumber + "_"
				+ ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss");
		String currencyvalue = reusableComponents.getPropValues(testCaseNumber + "_currencyForJournalEntry");
		String accountingPeriod = reusableComponents.getPropValues(testCaseNumber + "_AccountingPeriodForJournalEntry");

		try {

			// Create new journal
			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Journal Entries", journalEntries);

			if (ReusableComponents.isElementPresent(journalEntries_PageTitle) == true) {
				/*
				 * ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
				 * "Journal Entries page opened", browser, pathLocation + "\\" + testcasemethod,
				 * true);
				 */
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
				/*
				 * ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
				 * "New Journal Entries popup opened", browser, pathLocation + "\\" +
				 * testcasemethod, true);
				 */
			} else {
				throw new throwNewException("New Journal Entry page is not opened", "");
			}

			ReusableComponents.sendKey(journalName_newJournalEntryPopup, newJournalName, "New Journal Entry Name");
			ReusableComponents.clickUsingJavaScript(browser, currency_newJournalEntryPopup, "Click Currency Value");
			String currencyXpath = ".//*[contains(text(),'" + currencyvalue + "')]";
			ReusableComponents.clickElement_byDynamicXpath(browser, currencyXpath,
					"Selected currency value as " + currencyvalue);
			ReusableComponents.selectAccountingPeriod(accountingPeriod_newJournalEntryPopup, accountingPeriod, browser);
			ReusableComponents.wait(5000);

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"Provided all mandatory values to create new journal", browser,
					pathLocation + "\\" + testcasemethod, true);
			ReusableComponents.clickElement(saveButton_newJournalEntryPopup, "Click on save button");
			ReusableComponents.wait(5000);

			// Verify new journal is created
			String checkNewJournalEntry = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'"
					+ newJournalName + "')] ";
			System.out.println("********** Print xpath " + checkNewJournalEntry);
			boolean journalEntryCreated = browser.findElement(By.xpath(checkNewJournalEntry)).isDisplayed();
			// System.out.println("********************** Element visibility" +
			// checkCreatedOpportunity);
			if (journalEntryCreated == true) {
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Newly created Journal " + newJournalName + " is displayed", browser,
						pathLocation + "\\" + testcasemethod, false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
						pathLocation + "\\" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"New Journal " + newJournalName + " is not created", browser,
						pathLocation + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when creating new journal entry" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see Use this method to open a journal entry from journal entry page
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @param journalEntryName --> In this parameter we should pass a journal entry
	 *                         name to open
	 * @return
	 * @throws Exception
	 */
	public static CashFlowStatementPage openJournalEntry(int threadID, List<String> tempList, String pathLocation,
			String journalEntryName) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Journal Entries", journalEntries);
			ReusableComponents.sendKey(search_JournalEntry, journalEntryName, "Search Journal entry Name");
			ReusableComponents.sendkey_InputKey(search_JournalEntry, Keys.ENTER, "Pass Enter");
			ReusableComponents.wait(2000);
			String journalEnterList = ".//*[@data-aura-class='forceInlineEditCell']//a[@title='" + journalEntryName
					+ "']";
			System.out.println("********** Journal List " + journalEnterList);
			List<WebElement> newJournalEntry = browser.findElements(By.xpath(journalEnterList));
			System.out.println("********** journalEntrySize " + newJournalEntry.size());
			if (newJournalEntry.size() != 0) {
				String journalEntryElementXpath = ".//*[@data-aura-class='forceInlineEditCell']//a[@title='"
						+ journalEntryName + "']";
				System.out.println("********** Journal List " + journalEntryElementXpath);
				WebElement openJournal = browser.findElement(By.xpath(journalEntryElementXpath));
				ReusableComponents.clickUsingJavaScript(browser, openJournal, "Journal");
				ReusableComponents.wait(5000);

				// Verify new journal is created
				String checkNewJournalEntry = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'"
						+ journalEntryName + "')] ";
				System.out.println("********** Print xpath " + checkNewJournalEntry);
				boolean journalEntryCreated = browser.findElement(By.xpath(checkNewJournalEntry)).isDisplayed();
				// System.out.println("********************** Element visibility" +
				// checkCreatedOpportunity);
				if (!journalEntryCreated) {
					throw new throwNewException("New Journal " + newJournalName + " is not opened",
							"unable to find " + journalEntryName + " .");
				}
			} else {
				throw new throwNewException("Find newly created journal entry",
						"unable to find " + journalEntryName + " .");
			}
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when adding new journal entry line with credit" + e.getStackTrace(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see This method is to add new journal entry line with credit value. This
	 *      method should be called after creating new journal entry only, and
	 *      current page should show newly created journal entry.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public static CashFlowStatementPage addNewJournalEntryLineWithCredit(int threadID, List<String> tempList,
			String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String creditValue = reusableComponents.getPropValues(testCaseNumber + "_Credit");
		String glAccountType = reusableComponents.getPropValues(testCaseNumber + "_GLAccountType_For_Credit");
		try {
			openJournalEntry(threadID, tempList, pathLocation, newJournalName);
			ReusableComponents.wait(10000);
			browser.navigate().refresh();
			ReusableComponents.wait(4000);
			browser.navigate().refresh();
			ReusableComponents.wait(10000);
			ReusableComponents.scrollDown(browser, 500);
			ReusableComponents.wait(4000);
			ReusableComponents.clickElement(newJournalEntryLine, "Click on new journal entry line");
			ReusableComponents.wait(10000);
			ReusableComponents.scrollInToElementJavaScript(browser, credit_NewJournalEntryLine);
			ReusableComponents.sendKey(credit_NewJournalEntryLine, creditValue, "Provide credit value");
			ReusableComponents.scrollInToElementJavaScript(browser, glAccount_NewJournalEntryLine);
			ReusableComponents.sendKey(glAccount_NewJournalEntryLine, glAccountType, "Provide GL account value");
			ReusableComponents.wait(4000);
			String xpathToSelectGlAccontType = "//lightning-base-combobox-formatted-text[@title='" + glAccountType
					+ "']";
			System.out.println("********** X path" + xpathToSelectGlAccontType);
			ReusableComponents.clickElement_byDynamicXpath(browser, xpathToSelectGlAccontType,
					"Select correct value for Gl Account Type");
			ReusableComponents.scrollUp_insidepopup_ByPGUP(browser, popupof_NewOpportunity);
			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"New journal entry with credit values are given", browser, pathLocation + "\\" + testcasemethod,
					false);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
					pathLocation + "\\" + testcasemethod, true);
			ReusableComponents.clickElement(saveButton_newJournalEntryPopup, "Click on save button");
			ReusableComponents.wait(5000);
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when adding new journal entry line with credit" + e.getStackTrace(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see This method is to add new journal entry line with debit value. This
	 *      method should be called after creating new journal entry only, and
	 *      current page should show newly created journal entry.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public static CashFlowStatementPage addNewJournalEntryLineWithDebit(int threadID, List<String> tempList,
			String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String debitValue = reusableComponents.getPropValues(testCaseNumber + "_Debit");
		String glAccountType = reusableComponents.getPropValues(testCaseNumber + "_GLAccountType_For_Debit");
		try {
			// ReusableComponents.scrollInToElementJavaScript(browser, newJournalEntryLine);
			openJournalEntry(threadID, tempList, pathLocation, newJournalName);
			ReusableComponents.wait(10000);
			browser.navigate().refresh();
			ReusableComponents.wait(4000);
			browser.navigate().refresh();
			ReusableComponents.wait(10000);
			ReusableComponents.scrollDown(browser, 500);
			ReusableComponents.wait(4000);
			// ReusableComponents.scrollInToElementJavaScript(browser, newJournalEntryLine);
			ReusableComponents.clickElement(newJournalEntryLine, "Click on new journal entry line");
			ReusableComponents.wait(10000);
			ReusableComponents.sendKey(debit_NewJournalEntryLine, debitValue, "Provide Debit value");
			ReusableComponents.scrollInToElementJavaScript(browser, glAccount_NewJournalEntryLine);
			ReusableComponents.sendKey(glAccount_NewJournalEntryLine, glAccountType, "Provide GL account value");
			ReusableComponents.wait(4000);
			String xpathToSelectGlAccontType = "//lightning-base-combobox-formatted-text[@title='" + glAccountType
					+ "']";
			System.out.println("********** xpath" + xpathToSelectGlAccontType);
			ReusableComponents.clickElement_byDynamicXpath(browser, xpathToSelectGlAccontType,
					"Select correct value for Gl Account Type");
			ReusableComponents.scrollUp_insidepopup_ByPGUP(browser, popupof_NewOpportunity);
			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"New journal entry with Debit values are given", browser, pathLocation + "\\" + testcasemethod,
					false);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
					pathLocation + "\\" + testcasemethod, true);
			ReusableComponents.clickElement(saveButton_newJournalEntryPopup, "Click on save button");
			ReusableComponents.wait(5000);
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when adding new journal entry line with debit" + e.getStackTrace(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see This method is to post the journal entry. This should be called inside
	 *      the journal entry page.
	 * 
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public static CashFlowStatementPage postTheJournalEntry(int threadID, List<String> tempList, String pathLocation)
			throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			openJournalEntry(threadID, tempList, pathLocation, newJournalName);

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
				/*
				 * ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
				 * "Post page displayed", browser, pathLocation + "\\" + testcasemethod, true);
				 */
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Journal entry Post page is not displayed", browser, pathLocation + "\\" + testcasemethod,
						true);
			}

			ReusableComponents.clickElement(postButton_UnderPostJournalEntry, "Click on post button");
			ReusableComponents.wait(10000);

			browser.switchTo().defaultContent();
			ReusableComponents.wait(20000);

			ReusableComponents.wait(5500);
			String newJournalEntryNameFromWebpage = ReusableComponents.getText(nameOfCreatedJournal,
					"Get new billing name");

			if (newJournalEntryNameFromWebpage.equalsIgnoreCase(newJournalName)) {

				Boolean newJournalStatus = ReusableComponents.isDisplayed(checkStatus,
						"Verify new billing status displayed after performing post");
				if (newJournalStatus) {
					testDataNewJournalEntryCreated = true;
					ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
							"New Journal " + newJournalName + " status changed to posted", browser,
							pathLocation + "\\" + testcasemethod, true);

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
							pathLocation + "\\" + testcasemethod, true);
				} else {
					testDataNewJournalEntryCreated = false;
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"New Journal " + newJournalName + " status is not changed to posted", browser,
							pathLocation + "\\" + testcasemethod, true);
				}
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Newly created journal entry name should be " + newJournalName
								+ ", However it says newJournalEntryNameFromWebpage",
						browser, pathLocation + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when trying to post the journal entry" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see This is belongs to test case number 2730
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @throws Exception
	 */
	public static void editJournalEntryLineWithCashModifyTransactionsCFS(int threadID, List<String> tempList,
			String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String newValueOfCashFlowCategory = reusableComponents.getPropValues(testCaseNumber + "_ModifyCashFlowValue");
		String expectedErrorText = reusableComponents.getPropValues(testCaseNumber + "_ErrorText");
		try {

			openJournalEntry(threadID, tempList, pathLocation, newJournalName);
			ReusableComponents.wait(10000);
			browser.navigate().refresh();
			ReusableComponents.wait(5000);
			ReusableComponents.scrollDown(browser, 100);
			ReusableComponents.wait(5000);

			// -->Open first transaction
			ReusableComponents.scrollDown(browser, 500);
			ReusableComponents.wait(5000);
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
			ReusableComponents.scrollDown(browser, 500);
			ReusableComponents.wait(5000);
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
						browser, pathLocation + "\\" + testcasemethod, true);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
						"Before changing cash flow category", browser, pathLocation + "\\" + testcasemethod, true);
			} else {
				ReusableComponents
						.reportFail(threadID, tempList, testcasemethod,
								"Before performing edit cash flow category value identified as "
										+ currentValueOfCashFlowCategory,
								browser, pathLocation + "\\" + testcasemethod, true);
			}

			// ReusableComponents.scrollDown(browser, 100);
			ReusableComponents.wait(5000);

			ReusableComponents.clickUsingJavaScript(browser, clearValueButton_CashFlowCategory_Transactions,
					"Click on clear button of cash flow category");

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
						pathLocation + "\\" + testcasemethod, true);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
						"Current value of cashflow category", browser, pathLocation + "\\" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Cash flow category value not changed. It still says " + currentValueOfCashFlowCategory,
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			ReusableComponents.clickElement(saveButtonOfEdit_JournalEntryLine,
					"Click on save button after editing cash flow category value");
			ReusableComponents.wait(2000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, "Click on save button", browser,
					pathLocation + "\\" + testcasemethod, true);

			// -->Check the error text
			String errorText = ReusableComponents.getText(errorAfterClickingSave,
					"Verify the error after clicking on save");
			System.out.println("********** Actual error " + errorText);

			if (!errorText.equalsIgnoreCase(expectedErrorText)) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"Error text displayed as expected " + expectedErrorText, browser,
						pathLocation + "\\" + testcasemethod, true);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Find the Error text below",
						browser, pathLocation + "\\" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Error text is not displayed as expected " + errorText, browser,
						pathLocation + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Unable to select app from select search app section" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

	}

	/**
	 * @author Wisefinch Menaka
	 * @see [CF] Verify that the Cash Flow Category value cannot be cannot be
	 *      changed on a posted Journal Entry line's transactions.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @throws Exception
	 */
	public static CashFlowStatementPage test2730_CashFlowCategoryValueCanNotBeChanged(int threadID,
			List<String> tempList, String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		testCaseNumber = "Testcase2730";
		try {

			// check Cash flow statement it should be true
			developerConsole_QueryRun_CashFlowTrueOrFalse(threadID, tempList, pathLocation, true);

			// Navigate to home page
			navigateToAccountingHomePage();

			// Create new journalEntry
			createNewJournalEntries(threadID, tempList, pathLocation);

			// Add new journal entry line with debit
			addNewJournalEntryLineWithDebit(threadID, tempList, pathLocation);

			// Add new journal entry line with credit
			addNewJournalEntryLineWithCredit(threadID, tempList, pathLocation);

			// Post the journal entry
			postTheJournalEntry(threadID, tempList, pathLocation);

			// Modify transaction and verify error message
			editJournalEntryLineWithCashModifyTransactionsCFS(threadID, tempList, pathLocation);

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when executing test case test2730_CashFlowCategoryValueCanNotBeChanged"
							+ e.getStackTrace(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
	}

	/**
	 * @author Wisefinch Lakshman
	 * @see Create test data Cash receipt. Adviceable to call
	 *      createAccount(threadID, tempList, pathLocation); method before this. Or
	 *      else given valid account name as a input
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 */
	public static synchronized CashFlowStatementPage createCashReceipt(int threadID, List<String> tempList,
			String pathLocation) throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			navigateToAccountingHomePage();

			String account_namefull;
			if (newAccountname == null) {
				account_namefull = reusableComponents.getPropValues(testCaseNumber + "_accname");
			} else {
				account_namefull = newAccountname;
			}
			String cramount = reusableComponents.getPropValues(testCaseNumber + "_amount");
			String crref = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_Reference";
			String receipt_type = reusableComponents.getPropValues(testCaseNumber + "_receipttype");
			String accounting_Period = currentAccountingPeriodForTheTestCase;

			ReusableComponents.wait(6200);

			List<WebElement> f = browser.findElements(By.tagName("frame"));
			int i = f.size();
			System.out.println(i + " is the frame count");

			browser.switchTo().frame(0);

			ReusableComponents.wait(6200);

			if (ReusableComponents.isElementPresent(Cash_Receipts_tab)) {

				ReusableComponents.wait(3200);
				Cash_Receipts_tab.click();
				/*
				 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
				 * "Cash Receipt tab is present", browser, pathLocation + "\\" + testcasemethod,
				 * false);
				 */
				ReusableComponents.wait(5500);

				if (ReusableComponents.isElementPresent(New)) {

					/*
					 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					 * "screen grab of Cash Reciept page", browser, pathLocation + "\\" +
					 * testcasemethod, true);
					 */
					ReusableComponents.wait(3200);
					New.click();
					/*
					 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					 * "Cash Receipt New button is present", browser, pathLocation + "\\" +
					 * testcasemethod, false);
					 */
					ReusableComponents.wait(5500);

					ReusableComponents.selectAccountingPeriod(accountingPeriod_Billing, accounting_Period, browser);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
							"Accounting period values given", browser, pathLocation + "\\" + testcasemethod, true);

					if (ReusableComponents.isElementPresent(Customer_CR)) {

						ReusableComponents.wait(3200);
						Customer_CR.sendKeys(account_namefull);
						/*
						 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						 * "Customer searchbox is present", browser, pathLocation + "\\" +
						 * testcasemethod, false);
						 */
						ReusableComponents.wait(8500);

						WebElement Customer_click = browser.findElement(By
								.xpath("//lightning-base-combobox-formatted-text[@title='" + account_namefull + "']"));
						ReusableComponents.wait(5200);
						Customer_click.click();
						System.out.println("customer selected");
						ReusableComponents.wait(5200);

						if (ReusableComponents.isElementPresent(Type)) {

							ReusableComponents.wait(3200);
							Type.click();
							/*
							 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							 * "Cash Receipt Type selectbox is present", browser, pathLocation + "\\" +
							 * testcasemethod, false);
							 */
							ReusableComponents.wait(8500);

							String Receipt_type = "//lightning-base-combobox-item/span[@class='slds-media__body']/span[contains(text(),'"
									+ receipt_type + "')]";

							WebElement selecttype = browser.findElement(By.xpath(Receipt_type));
							ReusableComponents.wait(5500);
							selecttype.click();

							if (ReusableComponents.isElementPresent(Amount)) {

								ReusableComponents.wait(3200);
								Amount.sendKeys(cramount);
								/*
								 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								 * "Cash Receipt Amount field is present", browser, pathLocation + "\\" +
								 * testcasemethod, false);
								 */
								ReusableComponents.wait(5500);

								if (ReusableComponents.isElementPresent(Reference)) {

									ReusableComponents.wait(3200);
									Reference.sendKeys(crref);
									/*
									 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
									 * "Cash Receipt Reference field is present", browser, pathLocation + "\\" +
									 * testcasemethod, false);
									 */
									ReusableComponents.wait(5500);

									if (ReusableComponents.isElementPresent(Save)) {

										/*
										 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
										 * "screen grab of Cash Reciept creation page", browser, pathLocation + "\\" +
										 * testcasemethod, true);
										 */
										ReusableComponents.wait(3200);
										Save.click();
										/*
										 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										 * "Save button is present", browser, pathLocation + "\\" + testcasemethod,
										 * false);
										 */
										ReusableComponents.wait(10000);
										newCashReceiptCreated = false;
										String xpathToCheckNewCashReceipt = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'CR-')]";
										System.out.println("********** xpathToCheckNewCashReceipt : "
												+ xpathToCheckNewCashReceipt);

										List<WebElement> cashReceiptNameList = browser
												.findElements(By.xpath(xpathToCheckNewCashReceipt));
										System.out.println(
												"*********** cashReceiptNameList size : " + cashReceiptNameList.size());

										if (cashReceiptNameList.size() != 0) {
											newCashReceiptCreated = true;
											if (ReusableComponents.isDisplayed(caseReceipt_Status_Posted,
													"Cash receipt posted")) {
												ReusableComponents.reportPass(threadID, tempList, testcasemethod,
														"New cash receipt " + createdCashReceiptName.getText()
																+ " is created successfully and posted",
														browser, pathLocation + "\\" + testcasemethod, false);

												ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
														" ", browser, pathLocation + "\\" + testcasemethod, true);
											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Cash Receipt is created , however the status is not Posted",
														browser, pathLocation + "\\" + testcasemethod, true);
											}
										} else {
											newCashReceiptCreated = false;
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"New new cash receipt created", browser,
													pathLocation + "\\" + testcasemethod, true);
										}

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Save button is NOT present", browser,
												pathLocation + "\\" + testcasemethod, true);
									}

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Cash Receipt Reference field is NOT present", browser,
											pathLocation + "\\" + testcasemethod, true);
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"Cash Receipt Amount field is NOT present", browser,
										pathLocation + "\\" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"Cash Receipt Type selectbox is NOT present", browser,
									pathLocation + "\\" + testcasemethod, true);
						}
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Customer searchbox is NOT present", browser, pathLocation + "\\" + testcasemethod,
								true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Cash Receipt New button is NOT present", browser, pathLocation + "\\" + testcasemethod,
							true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt tab is NOT present",
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			browser.switchTo().defaultContent();
			browser.switchTo().defaultContent();

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception during cash receipt creation" + e, browser, pathLocation + "\\" + testcasemethod, true);

		}

		return new CashFlowStatementPage(browser);

	}

	/***
	 * Test case Method Name : Account_creation Functionality : validate T2688 Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 * 
	 ***/
	public synchronized static CashFlowStatementPage createAccount(int threadID, List<String> tempList,
			String pathLocation) throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			navigateToAccountingHomePage();

			newAccountname = "Accounts_" + testCaseNumber + "_"
					+ ReusableComponents.getCurrentDateAndTime("YYMMDDhhmmss");
			String acc_type;
			if (reusableComponents.getPropValues(testCaseNumber + "_accountType_ForAccounts") != null) {
				acc_type = reusableComponents.getPropValues(testCaseNumber + "_accountType_ForAccounts");
			} else {
				acc_type = "Customer and Vendor";
			}

			ReusableComponents.wait(3200);
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(3200);
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(3200);

			List<WebElement> f = browser.findElements(By.tagName("frame"));
			int i = f.size();
			System.out.println(i + "is the frame count");

			browser.switchTo().frame(0);

			ReusableComponents.wait(8200);

			if (ReusableComponents.isElementPresent(Accounts)) {

				/*
				 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
				 * "Accounts is present", browser, pathLocation + "\\" + testcasemethod, false);
				 */
				ReusableComponents.wait(5200);
				Accounts.click();
				ReusableComponents.wait(5200);/*
												 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
												 * "screen grab of Accounts page", browser, pathLocation + "\\" +
												 * testcasemethod, true);
												 */

				if (ReusableComponents.isElementPresent(New)) {

					/*
					 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					 * "Account New button is present", browser, pathLocation + "\\" +
					 * testcasemethod, false);
					 */
					ReusableComponents.wait(5200);
					New.click();
					ReusableComponents.wait(5200);

					if (ReusableComponents.isElementPresent(Account_Name)) {

						/*
						 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						 * "Account Name field is present", browser, pathLocation + "\\" +
						 * testcasemethod, false);
						 */
						ReusableComponents.wait(5200);
						Account_Name.sendKeys(newAccountname);
						ReusableComponents.wait(5200);

						WebElement element = browser
								.findElement(By.xpath("//span[contains(text(),'Accounting Information')]"));
						((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);

						if (ReusableComponents.isElementPresent(Account_type)) {

							ReusableComponents.wait(5200);
							Account_type.click();

							/*
							 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							 * "Account Type selectbox is present", browser, pathLocation + "\\" +
							 * testcasemethod, false);
							 */
							ReusableComponents.wait(5200);
							String Acc_type = ".//span[@title='" + acc_type + "']";
							System.out.println(Acc_type);
							List<WebElement> listOfAvailableType = browser.findElements(By.xpath(Acc_type));

							if (listOfAvailableType.size() == 0) {
								Account_type.click();
							}

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
								/*
								 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								 * "Account Active checkbox is present", browser, pathLocation + "\\" +
								 * testcasemethod, false);
								 */

								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Details filled to create accounts", browser,
										pathLocation + "\\" + testcasemethod, false);

								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								if (ReusableComponents.isElementPresent(Save)) {

									ReusableComponents.wait(5200);
									Save.click();
									ReusableComponents.wait(5200);
									/*
									 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
									 * "Save button is present", browser, pathLocation + "\\" + testcasemethod,
									 * false);
									 */
									ReusableComponents.wait(5200);
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Save button not present", browser, pathLocation + "\\" + testcasemethod,
											true);
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"Account Active checkbox not present", browser,
										pathLocation + "\\" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"Account Type selectbox not present", browser, pathLocation + "\\" + testcasemethod,
									true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Account Name field  not present", browser, pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account New button not present",
							browser, pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Account tab not present", browser,
						pathLocation + "\\" + testcasemethod, true);
			}
			String xpathToCheckNewAccount = ".//*[@data-aura-class=\"uiOutputText\" and contains(text(),'"
					+ newAccountname + "')]";
			System.out.println("*********** xpathToCheckNewAccount : " + xpathToCheckNewAccount);

			List<WebElement> accountName = browser.findElements(By.xpath(xpathToCheckNewAccount));
			System.out.println("*********** accountName size : " + accountName.size());

			accountCreatedStatus = false;
			if (accountName.size() != 0) {
				accountCreatedStatus = true;
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"New account " + newAccountname + " created successfully", browser,
						pathLocation + "\\" + testcasemethod, false);

				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLocation + "\\" + testcasemethod, true);
			} else {
				accountCreatedStatus = false;
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"New account " + newAccountname + " is not created", browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			browser.switchTo().defaultContent();
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception in create account" + e.getMessage(), browser, pathLocation + "\\" + testcasemethod,
					true);

		}

		return new CashFlowStatementPage(browser);

	}

	/**
	 * @author Wisefinch Menaka
	 * @see This method is not create new accounting variable.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws throwNewException
	 */
	private static boolean createAccountingVariable(int threadID, List<String> tempList, String pathLocation)
			throws throwNewException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			newAccountingVariableName = "NewAccountingVariable_" + testCaseNumber + "_"
					+ ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss");
			String accountingVariableType = reusableComponents
					.getPropValues(testCaseNumber + "_accountingVariableType");

			// navigate to home page
			navigateToAccountingHomePage();

			// Open accounting variable page
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Accounting Variables",
					SelectAccountingVariables);
			ReusableComponents.wait(5000);
			// Create New accounting variable
			ReusableComponents.clickElement(newbutton_AccountingVariables, "New button of accounint variable page");
			ReusableComponents.wait(5000);

			if (ReusableComponents.isDisplayed(newAccountingVariables_CreationPopUpcheck,
					"New accounting variable creation popup")) {
				ReusableComponents.sendKey(name_AccountingVariables, newAccountingVariableName,
						"Provide accounting variable name");
				ReusableComponents.clickElement(typeDropDown_AccountingVariables, "Click Type drop Down");
				ReusableComponents.wait(2000);
				String xpathOfTypeValue = ".//*[@class='actionBody']//*[contains(text(),'" + accountingVariableType
						+ "')]";
				WebElement typeElementToSelect = browser.findElement(By.xpath(xpathOfTypeValue));
				ReusableComponents.clickElement(typeElementToSelect, "Click Type drop Down");
				ReusableComponents.clickElement(saveButton_AccountingVariables, "Click On Save Button");
				ReusableComponents.wait(8000);

				String xpathToCheckNewAccountingVariable = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'"
						+ newAccountingVariableName + "')]";
				System.out
						.println("********** xpathToCheckNewAccountingVariable : " + xpathToCheckNewAccountingVariable);

				List<WebElement> accountingVariableNameList = browser
						.findElements(By.xpath(xpathToCheckNewAccountingVariable));
				System.out
						.println("*********** accountingVariableNameList size : " + accountingVariableNameList.size());

				newAccountingVariableCreated = false;
				if (accountingVariableNameList.size() != 0) {
					newAccountingVariableCreated = true;
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"New accounting variable " + newAccountingVariableName + " created successfully", browser,
							pathLocation + "\\" + testcasemethod, false);

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
							pathLocation + "\\" + testcasemethod, true);
				} else {
					newAccountingVariableCreated = false;
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"New accounting variable " + newAccountingVariableName + " is not created", browser,
							pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				newAccountingVariableCreated = false;
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"New accounting variable popup is not displayed, hence cannot create accounting variable",
						browser, pathLocation + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when creating createAccountingVariable" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

		return newAccountingVariableCreated;
		// TODO Auto-generated method stub

	}

	/**
	 * @author Wisefinch Menaka
	 * @see This method is to take recently created CF cubes name from financial
	 *      cube page
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 */
	private static String returnFirstCFCubesName(int threadID, List<String> tempList, String pathLocation) {
		// TODO Auto-generated method stub
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String firstCFCubesName = null;

		try {
			// Open financial cubes page
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Financial Cubes", SelectFinancialCubes);

			ReusableComponents.clickElement(recentListView_FinancialCubes, "Click on recently viewed drop drom");
			ReusableComponents.wait(2000);
			ReusableComponents.sendKey(inputBox_recentListViewe_FinancialCubes, "CF Cubes",
					"Recent list view input box");
			String selectRecentListViewValueXpath = ".//*[@class=' virtualAutocompleteOptionText']//*[contains(text(),'CF Cubes')]";
			System.out.println("*********** selectRecentListViewValueXpath : " + selectRecentListViewValueXpath);

			List<WebElement> selectRecentListViewValueXpathElements = browser
					.findElements(By.xpath(selectRecentListViewValueXpath));
			System.out.println("*********** selectRecentListViewValueXpathElements : "
					+ selectRecentListViewValueXpathElements.size());

			if (selectRecentListViewValueXpathElements.size() != 0) {
				WebElement selectRecentListViewValueXpathElement = browser
						.findElement(By.xpath(selectRecentListViewValueXpath));
				ReusableComponents.clickElement(selectRecentListViewValueXpathElement,
						"Click recent list view option as CF Cubes");
				ReusableComponents.wait(5000);

				firstCFCubesName = ReusableComponents.getText(getFirstCFCubesName_FinancialCubes,
						"Get first CF Cubes name from Financial Cubes page");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"First CF Cubes name for referance" + firstCFCubesName, browser,
						pathLocation + "\\" + testcasemethod, false);

				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLocation + "\\" + testcasemethod, true);

			} else {
				throw new throwNewException("CF Cubes", "Issue in selecting CF Cubes from Recent view list drop down");
			}
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when creating returnFirstCFCubesName" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

		return firstCFCubesName;

	}

	private static void createCashReceiptWithNewGLVariable1Value(int threadID, List<String> tempList,
			String pathLocation) {
		// TODO Auto-generated method stub
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			String account_namefull;
			if (newAccountname == null) {
				account_namefull = reusableComponents.getPropValues(testCaseNumber + "_accname");
			} else {
				account_namefull = newAccountname;
			}
			String cashReceiptAmount = reusableComponents.getPropValues(testCaseNumber + "_amount");
			String cashReceiptReference = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_Reference";
			String receipt_type = reusableComponents.getPropValues(testCaseNumber + "_receipttype");
			String accounting_Period = currentAccountingPeriodForTheTestCase;

			// Open financial cubes page
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Cash Receipts", selectCashReceipts);
			ReusableComponents.clickElement(New, "Click on new button");
			ReusableComponents.wait(5000);

			if (ReusableComponents.isDisplayed(newCashReceipt_CreationPopUpcheck, "New Cash Receipt creation popup")) {

				ReusableComponents.selectAccountingPeriod(accountingPeriod_Billing, accounting_Period, browser);
				ReusableComponents.sendKey(Customer_CR, account_namefull, "Provide Customer Name");
				ReusableComponents.wait(8000);
				WebElement Customer_click = browser.findElement(
						By.xpath("//lightning-base-combobox-formatted-text[@title='" + account_namefull + "']"));
				ReusableComponents.clickElement(Customer_click, "Click on specific Customer");

				ReusableComponents.clickElement(Type, "Click on Type");
				ReusableComponents.wait(5000);
				String Receipt_type = "//lightning-base-combobox-item/span[@class='slds-media__body']/span[contains(text(),'"
						+ receipt_type + "')]";

				WebElement selecttype = browser.findElement(By.xpath(Receipt_type));
				ReusableComponents.clickElement(selecttype, "Select Type");

				ReusableComponents.sendKey(Amount, cashReceiptAmount, "Provide Amount value");

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Filling values to create cash receipt", browser, pathLocation + "\\" + testcasemethod, false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLocation + "\\" + testcasemethod, true);

				ReusableComponents.scrollInToElementJavaScript(browser, Reference);
				ReusableComponents.sendKey(Reference, cashReceiptReference, "Provide Reference value");

				ReusableComponents.scrollInToElementJavaScript(browser, glVariable1Value_CashReceipt);
				ReusableComponents.sendKey(glVariable1Value_CashReceipt, newAccountingVariableName,
						"Provide accounting variable name");
				ReusableComponents.wait(8000);
				WebElement selectAccountingVariableValue = browser.findElement(By
						.xpath("//lightning-base-combobox-formatted-text[@title='" + newAccountingVariableName + "']"));
				ReusableComponents.clickElement(selectAccountingVariableValue, "Click on GL Variable 1 type");

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Newly created GL Variable 1 value is selected", browser, pathLocation + "\\" + testcasemethod,
						false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLocation + "\\" + testcasemethod, true);

				ReusableComponents.clickElement(Save, "Click on save button");
				ReusableComponents.wait(10000);

				newCashReceiptCreated = false;
				String xpathToCheckNewCashReceipt = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'CR-')]";
				System.out.println("********** xpathToCheckNewCashReceipt : " + xpathToCheckNewCashReceipt);

				List<WebElement> cashReceiptNameList = browser.findElements(By.xpath(xpathToCheckNewCashReceipt));
				System.out.println("*********** cashReceiptNameList size : " + cashReceiptNameList.size());

				if (cashReceiptNameList.size() != 0) {
					newCashReceiptCreated = true;
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"New cash receipt " + createdCashReceiptName.getText() + " is created successfully",
							browser, pathLocation + "\\" + testcasemethod, false);

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
							pathLocation + "\\" + testcasemethod, true);
				} else {
					newCashReceiptCreated = false;
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "New new cash receipt created",
							browser, pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"New Cash Receipt popup is not displayed, hence cannot create it", browser,
						pathLocation + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when creating returnFirstCFCubesName" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

	}

	/**
	 * @author Wisefinch Menaka
	 * @see [CF] Verify that Cash Flow Period financial cubes are not created when
	 *      the setting is not enabled
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @throws Exception
	 */
	public static CashFlowStatementPage test2744_FinancialCubesNotCreatedWhenCFFalse(int threadID,
			List<String> tempList, String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		testCaseNumber = "Testcase2744";
		String CFCubesName_One_ForComparision;
		String CFCubesName_Two_ForComparision;
		String CFCubesName_Three_ForComparision;

		currentAccountingPeriodForTheTestCase = reusableComponents
				.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");

		try {
			// LoginToWebpage();
			// check Cash flow statement it should be true
			developerConsole_QueryRun_CashFlowTrueOrFalse(threadID, tempList, pathLocation, true);

			// Navigate to home page
			navigateToAccountingHomePage();

			// Create Accounts
			createAccount(threadID, tempList, pathLocation);

			// Before cash receipt creation : get First CF Cubes name from financial cubes
			// page to cross check
			CFCubesName_One_ForComparision = returnFirstCFCubesName(threadID, tempList, pathLocation);
			System.out.println("********** CFCubesName_One_ForComparision : " + CFCubesName_One_ForComparision);

			// Create Cash Receipt
			createCashReceipt(threadID, tempList, pathLocation);

			if (newCashReceiptCreated) {

				// Create Accounting Variable
				createAccountingVariable(threadID, tempList, pathLocation);

				// After cash receipt creation : get First CF Cubes name from financial cubes
				// page to cross check
				CFCubesName_Two_ForComparision = returnFirstCFCubesName(threadID, tempList, pathLocation);

				System.out.println("********** CFCubesName_Two_ForComparision : " + CFCubesName_Two_ForComparision);
				// Compare both the values to make sure new CF is creation when CF is True
				System.out.println("************ CFCubesName_One_ForComparision " + CFCubesName_One_ForComparision);
				System.out.println("************ CFCubesName_Two_ForComparision " + CFCubesName_Two_ForComparision);
				if (!CFCubesName_One_ForComparision.equalsIgnoreCase(CFCubesName_Two_ForComparision)) {
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"New Financial Cube is created when Cash Flow Statement is true. Functionality working fine",
							browser, pathLocation + "\\" + testcasemethod, false);

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
							pathLocation + "\\" + testcasemethod, true);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There are no new Financial Cube is created when Cash Flow Statement is true.", browser,
							pathLocation + "\\" + testcasemethod, true);
				}

				// Now set cash flow statement to have false
				developerConsole_QueryRun_CashFlowTrueOrFalse(threadID, tempList, pathLocation, false);

				// Create cash receipt by passing new GL variable 1 value
				createCashReceiptWithNewGLVariable1Value(threadID, tempList, pathLocation);

				if (newCashReceiptCreated) {
					// After cash receipt creation : get First CF Cubes name from financial cubes
					// page to cross check
					CFCubesName_Three_ForComparision = returnFirstCFCubesName(threadID, tempList, pathLocation);

					System.out.println(
							"********** CFCubesName_Three_ForComparision : " + CFCubesName_Three_ForComparision);
					// Compare both the values to make sure new CF is creation when CF is True

					System.out.println("************ CFCubesName_Two_ForComparision " + CFCubesName_Two_ForComparision);
					System.out.println(
							"************ CFCubesName_Three_ForComparision " + CFCubesName_Three_ForComparision);
					if (CFCubesName_Two_ForComparision.equalsIgnoreCase(CFCubesName_Three_ForComparision)) {
						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"No new Financial Cube is created when Cash Flow Statement is false. Functionality working fine",
								browser, pathLocation + "\\" + testcasemethod, false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There is a new Financial Cube created when Cash Flow Statement is false.", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There is no new cash receipt is created to verify when select cash flow statement is false. Hence can not continue with the test case",
							browser, pathLocation + "\\" + testcasemethod, true);
				}
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"There is no new cash receipt is created to verify when select cash flow statement is true Hence can not continue with the test case",
						browser, pathLocation + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when executing test case test2730_CashFlowCategoryValueCanNotBeChanged"
							+ e.getStackTrace(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see This method is to clone GL account with the type cash flow
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param appNameToSearch
	 * @param selectAppXpath
	 * @throws Exception
	 */
	public static BankingLedgerPage cloneCashFlowGLAccountChangeCFCategory(int threadID, List<String> tempList,
			String pathLocation) throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			clonedNewGLName = "ClonedGLCF_" + testCaseNumber + "_"
					+ ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss");
			newGLName = clonedNewGLName;
			String glAccountType = reusableComponents.getPropValues(testCaseNumber + "_GLAccountType");
			String glAccountSubType = reusableComponents.getPropValues(testCaseNumber + "_GLAccountSubType");

			navigateToAccountingHomePage();

			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "GL Accounts", SelectGLAccount);
			ReusableComponents.wait(10000);

			ReusableComponents.clickElement(recentListView_GlAccounts, "Click on Recent");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(selectCashFlowCategories_recentListView_GlAccounts,
					"Click on Cash Flow Categories");
			ReusableComponents.wait(5000);

			String selectFirst_CF_GlAccounts = ".//*[@data-aura-class='forceInlineEditCell']//*[contains(text(),'Cash Flow')]//preceding::*[@data-aura-class='forceInlineEditCell']//a";
			System.out.println("*********** selectFirst_CF_GlAccounts : " + selectFirst_CF_GlAccounts);
			List<WebElement> listOfCashFlowGLAccount = browser.findElements(By.xpath(selectFirst_CF_GlAccounts));
			System.out.println("*********** listOfCashFlowGLAccount : " + listOfCashFlowGLAccount.size());

			if (listOfCashFlowGLAccount.size() != 0) {
				ReusableComponents.clickElement(selectFirstElement_CF_GlAccounts,
						"Click on First GL account with Cash Flow type");
				ReusableComponents.wait(5000);

				// --> Click clone button of fist cash flow GL account

				ReusableComponents.clickElement(cloneButton_cash1000, "Clone Button");
				ReusableComponents.wait(5000);

				// --> Provide values in popup

				if (ReusableComponents.isDisplayed(newGLAccount_PopUp, "Verify New GL account popup Is Displayed")) {

					ReusableComponents.sendKey(name_NewGLAccount, clonedNewGLName, "Cloned GL Account Name");

					ReusableComponents.wait(2000);

					ReusableComponents.clickElement(subType_CF_GlAccounts, "Click CF sub type account type");
					ReusableComponents.wait(2000);
					String xpathToSelectSubType = ".//*[@class='actionBody']//*[contains(text(),'" + glAccountSubType
							+ "')]";
					System.out.println("*********** xpathToSelectSubType : " + xpathToSelectSubType);
					List<WebElement> elementSubList = browser.findElements(By.xpath(xpathToSelectSubType));
					System.out.println("*********** elementList : " + elementSubList.size());

					if (elementSubList.size() == 0) {
						ReusableComponents.clickElement(subType_CF_GlAccounts, "Click CF account type");
						ReusableComponents.wait(2000);
					}
					WebElement subTypeElement = browser.findElement(By.xpath(xpathToSelectSubType));
					ReusableComponents.clickElement(subTypeElement, "Change GL account Sub type");

					/*
					 * ReusableComponents.clickElement(type_CF_GlAccounts, "Click CF account type");
					 * ReusableComponents.wait(2000); String xpathToSelectType =
					 * ".//*[@class='actionBody']//*[contains(text(),'" + glAccountType + "')]";
					 * System.out.println("*********** xpathToSelectType : " + xpathToSelectType);
					 * List<WebElement> elementList =
					 * browser.findElements(By.xpath(xpathToSelectType));
					 * System.out.println("*********** elementList : " + elementList.size());
					 * 
					 * if (elementList.size() == 0) {
					 * ReusableComponents.clickElement(type_CF_GlAccounts,
					 * "Select CF account type"); ReusableComponents.wait(2000); } WebElement
					 * typeElement = browser.findElement(By.xpath(xpathToSelectType));
					 * ReusableComponents.clickElement(typeElement, "Change GL account type");
					 * 
					 * ReusableComponents.wait(2000);
					 * 
					 * ReusableComponents.clickElement(subType_CF_GlAccounts,
					 * "Click CF sub type account type"); ReusableComponents.wait(2000); String
					 * xpathToSelectSubType = ".//*[@class='actionBody']//*[contains(text(),'" +
					 * glAccountSubType + "')]";
					 * System.out.println("*********** xpathToSelectSubType : " +
					 * xpathToSelectSubType); List<WebElement> elementSubList =
					 * browser.findElements(By.xpath(xpathToSelectSubType));
					 * System.out.println("*********** elementList : " + elementList.size());
					 * 
					 * if (elementSubList.size() == 0) {
					 * ReusableComponents.clickElement(subType_CF_GlAccounts,
					 * "Click CF account type"); ReusableComponents.wait(2000); } WebElement
					 * subTypeElement = browser.findElement(By.xpath(xpathToSelectSubType));
					 * ReusableComponents.clickElement(subTypeElement,
					 * "Change GL account Sub type");
					 */
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New name provided ", browser,
							pathLocation + "\\" + testcasemethod, false);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
							pathLocation + "\\" + testcasemethod, true);

					ReusableComponents.clickElement(saveButton_NewGLAccount, "Click on Save");
					ReusableComponents.wait(5000);

					String clonedGLAccount = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'"
							+ clonedNewGLName + "')]";
					if (browser.findElement(By.xpath(clonedGLAccount)).isDisplayed() == true) {
						clonedGLAccountCreated = true;
						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Cloned GL Account " + clonedNewGLName + " is successfully created", browser,
								pathLocation + "\\" + testcasemethod, false);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);
					} else {
						clonedGLAccountCreated = false;
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Cloned GL Account " + clonedNewGLName + " is not displayed", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"New GL Account popup is not displayed", browser, pathLocation + "\\" + testcasemethod,
							true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"There are no GL account with Cash Flow Category identified", browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			navigateToAccountingHomePage();

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to perform GL clone" + e, browser, pathLocation + "\\" + testcasemethod,
					true);
		}

		return new BankingLedgerPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see Create cash receipt with GL account selection
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 */
	public static synchronized CashFlowStatementPage createCashReceiptWithCFCategory(int threadID,
			List<String> tempList, String pathLocation) throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			navigateToAccountingHomePage();

			String account_namefull;
			if (newAccountname == null) {
				account_namefull = reusableComponents.getPropValues(testCaseNumber + "_accname");
			} else {
				account_namefull = newAccountname;
			}
			String cramount = reusableComponents.getPropValues(testCaseNumber + "_amount");
			String crref = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_Reference";
			String receipt_type = reusableComponents.getPropValues(testCaseNumber + "_receipttype");
			String accounting_Period = currentAccountingPeriodForTheTestCase;

			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Cash Receipts", selectCashReceipts);
			ReusableComponents.wait(5000);

			ReusableComponents.clickElement(New, "Click on new button");
			ReusableComponents.wait(5000);

			if (ReusableComponents.isDisplayed(newCashReceipt_CreationPopUpcheck,
					"Verify New Cash Receipt popup Is Displayed")) {

				ReusableComponents.selectAccountingPeriod(accountingPeriod_Billing, accounting_Period, browser);

				ReusableComponents.sendKey(Customer_CR, account_namefull, "Account name provided");
				ReusableComponents.wait(8500);
				WebElement Customer_click = browser.findElement(
						By.xpath("//lightning-base-combobox-formatted-text[@title='" + account_namefull + "']"));
				ReusableComponents.clickElement(Customer_click, "Customer Details Selected");

				ReusableComponents.clickElement(Type, "Customer on type");
				ReusableComponents.wait(2000);
				String Receipt_type = "//lightning-base-combobox-item/span[@class='slds-media__body']/span[contains(text(),'"
						+ receipt_type + "')]";
				List<WebElement> elementList = browser.findElements(By.xpath(Receipt_type));
				System.out.println("*********** elementList : " + elementList.size());
				if (elementList.size() == 0) {
					ReusableComponents.clickElement(Type, "Click type");
					ReusableComponents.wait(2000);
				}
				WebElement selecttype = browser.findElement(By.xpath(Receipt_type));
				ReusableComponents.clickElement(selecttype, "Select customer type");

				ReusableComponents.sendKey(Amount, cramount, "Provide amount value");

				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New cash receipt details provided",
						browser, pathLocation + "\\" + testcasemethod, false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLocation + "\\" + testcasemethod, true);

				ReusableComponents.scrollInToElementJavaScript(browser, Reference);
				ReusableComponents.wait(2000);
				ReusableComponents.sendKey(Reference, crref, "Provide Reference value");

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"New cash receipt Reference details provided", browser, pathLocation + "\\" + testcasemethod,
						false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLocation + "\\" + testcasemethod, true);

				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
						"Cloned GL account name : " + clonedNewGLName, browser, pathLocation + "\\" + testcasemethod,
						true);
				ReusableComponents.scrollInToElementJavaScript(browser, cashFlowCategory_CashReceipt);
				ReusableComponents.wait(2000);
				ReusableComponents.sendKey(cashFlowCategory_CashReceipt, newGLName, "Provide GL Name");
				ReusableComponents.wait(8000);
				String glType = ".//*[@class='actionBody']//lightning-base-combobox-formatted-text[@title='" + newGLName
						+ "']";
				WebElement clickGLAccountType = browser.findElement(By.xpath(glType));
				ReusableComponents.clickElement(clickGLAccountType, "Select GL Accout Type");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cloned GL Account Selected", browser,
						pathLocation + "\\" + testcasemethod, false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLocation + "\\" + testcasemethod, true);

				ReusableComponents.clickElement(Save, "Click on save button");
				ReusableComponents.wait(10000);
				newCashReceiptCreated = false;
				String xpathToCheckNewCashReceipt = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'CR-')]";
				System.out.println("********** xpathToCheckNewCashReceipt : " + xpathToCheckNewCashReceipt);

				List<WebElement> cashReceiptNameList = browser.findElements(By.xpath(xpathToCheckNewCashReceipt));
				System.out.println("*********** cashReceiptNameList size : " + cashReceiptNameList.size());

				if (cashReceiptNameList.size() != 0) {
					newCashReceiptCreated = true;
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"New cash receipt " + createdCashReceiptName.getText() + " is created successfully",
							browser, pathLocation + "\\" + testcasemethod, false);

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
							pathLocation + "\\" + testcasemethod, true);
				} else {
					newCashReceiptCreated = false;
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "New new cash receipt created",
							browser, pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"New Cash Receipt pop up is not displayed", browser, pathLocation + "\\" + testcasemethod,
						true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {

			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception during cash receipt creation with gl account" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}

		return new CashFlowStatementPage(browser);

	}

	/**
	 * @author Wisefinch Lakshman
	 * @see Close accounting period that passed in the parameter
	 *      closeAccountingPeriod
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @param closeAccountingPeriod --> This holds the accounting period name to
	 *                              close . Example format will be 2020-01
	 * @return
	 * @throws Exception
	 */
	public synchronized static CashFlowStatementPage closeAccountingPeriod(int threadID, List<String> tempList,
			String pathLocation, String closeAccountingPeriod) throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			navigateToAccountingHomePage();

			String acc_period = closeAccountingPeriod;
			String per_stat = "Closed";
			String last_period = null;
			String strArray[] = acc_period.split("-");
			String yearValue = strArray[0];
			int year = Integer.parseInt(strArray[0]);
			int month = Integer.parseInt(strArray[1]);

			previousYearClose = year - 1; // call previous year account period close method

			closeAccountingPeriodBasedOnYear(threadID, tempList, pathLocation);

			ReusableComponents.wait(5200);
			/*
			 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
			 * "screen grab of Accounting Home page", browser, pathLocation + "\\" +
			 * testcasemethod, true);
			 */
			ReusableComponents.wait(3200);

			navigateToAccountingHomePage();

			ReusableComponents.wait(5000);
			Input.sendKeys("Accounting Periods");
			ReusableComponents.wait(5500);
			click_ap.click();
			ReusableComponents.wait(5500);
			listview.click();
			ReusableComponents.wait(5500);
			all_list.click();
			ReusableComponents.wait(5500);

			ReusableComponents.wait(5500);
			ReusableComponents.sendKey(searchTextBox_AccountPeriod, acc_period, "Year close");
			ReusableComponents.sendkey_InputKey(searchTextBox_AccountPeriod, Keys.ENTER, "Pass Enter");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(3000);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"Before (Close accounting period): Screen grab of Accounting period year with the filtered values of ",
					browser, pathLocation + "\\" + testcasemethod, true);

			int j = 1;
			String acct_period = null;

			for (j = 1; j <= month; j++) {

				String monthValue = null;

				if (j <= 9) {
					monthValue = "0" + j;
				}

				acct_period = yearValue + "-" + monthValue;

				// you can use the above value , to identify dynamic xpath , open the accounting
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
										/*
										 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										 * "Edit button is present", browser, pathLocation + "\\" + testcasemethod,
										 * false);
										 */

										if (ReusableComponents.isElementPresent(Status)) {

											ReusableComponents.wait(3200);
											Status.click();
											ReusableComponents.wait(5500);
											/*
											 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											 * "Status selectbox is present", browser, pathLocation + "\\" +
											 * testcasemethod, false);
											 */

											String P_stat = "//span[@title='" + per_stat + "']";

											WebElement selecttype = browser.findElement(By.xpath(P_stat));
											ReusableComponents.wait(5500);
											selecttype.click();
											System.out.println("Accounting period status present");
											ReusableComponents.wait(5500);

											/*
											 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
											 * "screen grab of Editing Accounting period", browser, pathLocation + "\\"
											 * + testcasemethod, true);
											 */

											if (ReusableComponents.isElementPresent(Save)) {

												ReusableComponents.reportPass(threadID, tempList, testcasemethod,
														"Save button is present", browser,
														pathLocation + "\\" + testcasemethod, false);
												ReusableComponents.wait(7200);
												Save.click();
												ReusableComponents.wait(6500);

											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Save button is NOT present ", browser,
														pathLocation + "\\" + testcasemethod, true);
											}

										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Status selectbox is NOT present ", browser,
													pathLocation + "\\" + testcasemethod, true);
										}

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Edit button is NOT present ", browser,
												pathLocation + "\\" + testcasemethod, true);
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

			System.out.println(last_period + " is th ending period of year " + acc_period);

			browser.navigate().to(
					"https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");
			ReusableComponents.wait(5500);
			ReusableComponents.sendKey(searchTextBox_AccountPeriod, acc_period, "Year close");
			ReusableComponents.sendkey_InputKey(searchTextBox_AccountPeriod, Keys.ENTER, "Pass Enter");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(3000);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"After (Close accounting period) : Screen grab of Accounting period year with the filtered values of ",
					browser, pathLocation + "\\" + testcasemethod, true);
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {

			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception during accounting period close" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}

		return new CashFlowStatementPage(browser);

	}

	/**
	 * @author Wisefinch Menaka
	 * @see To check a specific accounting period current status.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @param accountingPeriod --> Pass the accounting period name. Ex 2020-11
	 * @param expectedStatus   --> Pass the accounting period status. Ex Closed,
	 *                         Open, Archived
	 * @return
	 * @throws Exception
	 */
	public static boolean checkAccountPeriodStatus(int threadID, List<String> tempList, String pathLocation,
			String accountingPeriod, String expectedStatus) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		boolean statusCheck = false;
		try {
			// --> Navigate to home page
			navigateToAccountingHomePage();

			// --> Move to accounting periods page
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Accounting Periods",
					SelectAccountingPeriods);
			// --> Select all from list view filter
			ReusableComponents.clickElement(trigger_ForceListViewPicker_AccountingPeriod, "Click on list viewer");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(selectAll_ForceListViewPicker_AccountingPeriod, "Click on All");
			ReusableComponents.wait(5000);
			// --> Pin All list view
			String pintThisListViewButtonXpath = ".//button[@title='Pin this list view']";
			List<WebElement> pinThisListViewButtonElements = browser
					.findElements(By.xpath(pintThisListViewButtonXpath));
			if (pinThisListViewButtonElements.size() == 1) {
				ReusableComponents.clickElement(pinThisListViewButtion_AccountingPeriod,
						"Click on pin this list view buttion");
			}

			// --> Perform search action
			ReusableComponents.sendKey(searchTextBox_AccountPeriod, accountingPeriod, "Year close");
			ReusableComponents.sendkey_InputKey(searchTextBox_AccountPeriod, Keys.ENTER, "Pass Enter");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(3000);

			// --> Verify the status
			String xpathToCheckStatus = "((.//*[@scope='row']//a[contains(text(),'" + accountingPeriod
					+ "')]//following::td)[3]//span)[2]";
			System.out.println("********** xpathToCheckStatus " + xpathToCheckStatus);

			WebElement statusElement = browser.findElement(By.xpath(xpathToCheckStatus));

			String statusOfTheAccountingPeriod = statusElement.getText();

			if (statusOfTheAccountingPeriod.equalsIgnoreCase(expectedStatus)) {
				statusCheck = true;
				ReusableComponents.reportPass(
						threadID, tempList, testcasemethod, "Accounting period " + accountingPeriod
								+ " status displayed as expected " + statusOfTheAccountingPeriod,
						browser, pathLocation + "\\" + testcasemethod, false);

				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLocation + "\\" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Accounting period " + accountingPeriod
								+ " status is not displayed as expected. Expedted Status " + expectedStatus
								+ ". Current status " + statusOfTheAccountingPeriod,
						browser, pathLocation + "\\" + testcasemethod, true);
			}

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
		return statusCheck;
	}

	/**
	 * @author Wisefinch Menaka
	 * @see This method will change the provided accounting period status to have
	 *      closed.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @param accountingPeriod -- Pass the accounting period in correct format [Ex :
	 *                         2020-01]
	 */
	private static CashFlowStatementPage close_a_AccountingPeriod(int threadID, List<String> tempList,
			String pathLocation, String accountingPeriod) {
		// TODO Auto-generated method stub
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			// --> Navigate to home page
			navigateToAccountingHomePage();

			// --> Move to accounting periods page
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Accounting Periods",
					SelectAccountingPeriods);
			// --> Select all from list view filter
			ReusableComponents.clickElement(trigger_ForceListViewPicker_AccountingPeriod, "Click on list viewer");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(selectAll_ForceListViewPicker_AccountingPeriod, "Click on All");
			ReusableComponents.wait(5000);
			// --> Pin All list view
			String pintThisListViewButtonXpath = ".//button[@title='Pin this list view']";
			List<WebElement> pinThisListViewButtonElements = browser
					.findElements(By.xpath(pintThisListViewButtonXpath));
			if (pinThisListViewButtonElements.size() == 1) {
				ReusableComponents.clickElement(pinThisListViewButtion_AccountingPeriod,
						"Click on pin this list view buttion");
			}

			// --> Perform search action
			ReusableComponents.sendKey(searchTextBox_AccountPeriod, accountingPeriod, "Year close");
			ReusableComponents.sendkey_InputKey(searchTextBox_AccountPeriod, Keys.ENTER, "Pass Enter");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(3000);

			// --> Verify the status
			String xpathToOpenAccountingPeriod = ".//*[@scope='row']//a[contains(text(),'" + accountingPeriod + "')]";
			System.out.println("********** xpathToCheckStatus " + xpathToOpenAccountingPeriod);

			List<WebElement> openAccountingPeriod = browser.findElements(By.xpath(xpathToOpenAccountingPeriod));
			System.out.println("*********** openAccountingPeriod size : " + openAccountingPeriod.size());

			if (openAccountingPeriod.size() != 0) {
				WebElement openAccountingPeriodElement = browser.findElement(By.xpath(xpathToOpenAccountingPeriod));
				ReusableComponents.clickElement(openAccountingPeriodElement, "Open accounting period");
				ReusableComponents.wait(8000);

				String xpathToCheckAccountingPeriod = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'"
						+ accountingPeriod + "')]";
				System.out.println("*********** xpathToCheckNewAccount : " + xpathToCheckAccountingPeriod);

				List<WebElement> accountingPeriodName = browser.findElements(By.xpath(xpathToCheckAccountingPeriod));
				System.out.println("*********** accountName size : " + accountingPeriodName.size());

				if (accountingPeriodName.size() != 0) {
					ReusableComponents.clickElement(edit_AccountingPeriod,
							"Click on edit buttion of accounting period");
					ReusableComponents.wait(8000);
					String xpathToCheckEditAccountingPeriodPopup = ".//*[@class='actionBody']//*[contains(text(),'Edit "
							+ accountingPeriod + "')]";
					List<WebElement> editPopup = browser.findElements(By.xpath(xpathToCheckEditAccountingPeriodPopup));
					System.out.println("*********** editPopup size : " + editPopup.size());

					if (editPopup.size() != 0) {
						ReusableComponents.clickElement(statusDropDown_EditAccountingPeriod,
								"Click on status dropdown");
						ReusableComponents.wait(2000);

						if (!ReusableComponents.isDisplayed(selectStatusAsClosed_EditAccountingPeriod,
								"Check close open is displayed")) {
							ReusableComponents.clickElement(statusDropDown_EditAccountingPeriod,
									"Click on status dropdown");
							ReusableComponents.wait(2000);
						}
						ReusableComponents.clickElement(selectStatusAsClosed_EditAccountingPeriod,
								"Select Close From the drop down");

						ReusableComponents.clickElement(saveButton_EditAccountingPeriod, "Click on save button");
						ReusableComponents.wait(5000);

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Edit Accounting period " + accountingPeriod + " pop up is not displayed", browser,
								pathLocation + "\\" + testcasemethod, true);
					}

				} else {

					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Accounting period " + accountingPeriod + " is not opened", browser,
							pathLocation + "\\" + testcasemethod, true);
				}
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"No such Accounting period present " + accountingPeriod, browser,
						pathLocation + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to open a period closeOneAccountingPeriod" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see [CF] Verify that the user can add their own CF categories or change the
	 *      names of the categories
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @throws Exception
	 */
	public static CashFlowStatementPage test2741_OwnCashFlowCategoryOrChangeCF(int threadID, List<String> tempList,
			String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		testCaseNumber = "Testcase2742";

		currentAccountingPeriodForTheTestCase = reusableComponents
				.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");
		String accountingPeriodForTheTestCase = currentAccountingPeriodForTheTestCase;
		String previousAccountingPeriod;

		try {
			// LoginToWebpage();

			// check Cash flow statement it should be true
			developerConsole_QueryRun_CashFlowTrueOrFalse(threadID, tempList, pathLocation, true);

			// Navigate to home page
			navigateToAccountingHomePage();

			// Clone GL account with the type Cash Flow
			cloneCashFlowGLAccountChangeCFCategory(threadID, tempList, pathLocation);

			// Changing currentAccountingPeriodForTheTestCase value here to create test data
			// cash receipt. Later I will
			// change it to have user input
			previousAccountingPeriod = AccountingSeedReusableFunctionalities
					.identifyPreviousAccountingPeriod(currentAccountingPeriodForTheTestCase);
			currentAccountingPeriodForTheTestCase = previousAccountingPeriod;

			if (clonedGLAccountCreated) {
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
						"Previous accounting period identified as " + previousAccountingPeriod, browser,
						pathLocation + "\\" + testcasemethod, true);

				// Create new accounts
				createAccount(threadID, tempList, pathLocation);

				// Create cash receipt
				createCashReceiptWithCFCategory(threadID, tempList, pathLocation);

				if (newCashReceiptCreated) {

					// Close accounting period
					close_a_AccountingPeriod(threadID, tempList, pathLocation, previousAccountingPeriod);
					ReusableComponents.wait(60000);

					// Previous accounting period status should be closed
					String expectedAccountingPeriodStatus = "Closed";
					boolean previousAccountingPeriodStatus = false;
					previousAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
							previousAccountingPeriod, expectedAccountingPeriodStatus);

					if (previousAccountingPeriodStatus) {
						System.out.println("*********** Status displayed as expected. Good to go with the test case");

						// Run Financial Report
						String financialReportsURL = reusableComponents.getPropValues("FinancialReports");
						browser.get(financialReportsURL);
						// Browser.get is used here since there are issue in launching financial report
						// from search app. Once the issue resolved we can comment it and unccomment
						// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
						// Reports",
						ReusableComponents.wait(5000);

						ReusableComponents.wait(5000);
						ReusableComponents.clickElement(selectStandartReport_FinancialReport,
								"Select standard reportd");
						ReusableComponents.wait(5000);
						ReusableComponents.clickElement(selectCashFlowReport_FinancialReport,
								"Select cash flow report");
						ReusableComponents.wait(5000);

						ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
								"Clear button of starting account period");
						ReusableComponents.sendKey(accountingPeriod_CashFlowReport, accountingPeriodForTheTestCase,
								"Provide accounting period");
						ReusableComponents.clickElement(accountingPeriod_CashFlowReport,
								"Starting account period input box");
						ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
								"Select Starting account period");

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Accounting period details provided", browser, " ", false);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

						ReusableComponents.scrollDown(browser, 500);
						// --> Click on run button and get new record URL

						List<WebElement> recordsList = browser.findElements(
								By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
						System.out.println("************ Number of elements " + recordsList.size());

						if (recordsList.size() != 0) {
							String oldRecordName = firstReport_FinancialReport.getText();

							ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked",
									browser, " ", false);

							ReusableComponents.wait(20000);

							String newRecord = firstReport_FinancialReport.getText();
							if (!newRecord.contains("FRR")) {
								ReusableComponents.wait(20000);

								newRecord = firstReport_FinancialReport.getText();
							}

							if (newRecord.contains("FRR") && !oldRecordName.equalsIgnoreCase(newRecord)) {
								String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
								String financialReportURL = hreflink;
								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Created Financial report Name : " + newRecord
												+ ". Link of created financial report : " + hreflink,
										browser, pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);
							} else {

								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"There are no new records created, provide valid inputs ", browser,
										pathLocation + "\\" + testcasemethod, true);
							}
						} else {

							ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked",
									browser, pathLocation + "\\" + testcasemethod, false);

							ReusableComponents.wait(20000);

							List<WebElement> newRecordsList = browser.findElements(
									By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
							System.out.println("************ Number of elements " + newRecordsList.size());

							if (newRecordsList.size() == 0) {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"There are no new records created , please verify the input values", browser,
										pathLocation + "\\" + testcasemethod, true);
							} else {

								String newRecord = firstReport_FinancialReport.getText();

								if (!newRecord.contains("FRR")) {
									ReusableComponents.wait(20000);

									newRecord = firstReport_FinancialReport.getText();
								}

								String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
								String financialReportURL = hreflink;
								if (newRecord.contains("FRR")) {
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Created Financial report Name : " + newRecord
													+ ". Link of created financial report : " + hreflink,
											browser, pathLocation + "\\" + testcasemethod, false);
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
											pathLocation + "\\" + testcasemethod, true);
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
											pathLocation + "\\" + testcasemethod, true);
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"There are no new records created , please verify the input values",
											browser, pathLocation + "\\" + testcasemethod, true);
								}
							}
						}

					} else {
						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Previous accounting period status is not displayed as expected. Previous accounting period "
										+ previousAccountingPeriod + ". Expected status "
										+ expectedAccountingPeriodStatus,
								browser, pathLocation + "\\" + testcasemethod, true);

					}
				} else {
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"As part of test data creation there are no new cash receipt created. Hence can not continue with the test case",
							browser, pathLocation + "\\" + testcasemethod, true);
				}
			} else {
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"As part test data creation GL account clone with type cash flow is not performed. Hence can not continue with the test case",
						browser, pathLocation + "\\" + testcasemethod, true);
			}
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when executing test case test2730_CashFlowCategoryValueCanNotBeChanged"
							+ e.getStackTrace(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see [CF] Verify that the report shows the custom CF categories with amounts
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @throws Exception
	 */
	public static CashFlowStatementPage test2742_OwnCashFlowCategoryOrChangeCF(int threadID, List<String> tempList,
			String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		testCaseNumber = "Testcase2741";

		currentAccountingPeriodForTheTestCase = reusableComponents
				.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");
		String accountingPeriodForTheTestCase = currentAccountingPeriodForTheTestCase;
		String previousAccountingPeriod;

		try {
			// LoginToWebpage();

			// check Cash flow statement it should be true
			developerConsole_QueryRun_CashFlowTrueOrFalse(threadID, tempList, pathLocation, true);

			// Navigate to home page
			navigateToAccountingHomePage();

			// Clone GL account with the type Cash Flow
			cloneCashFlowGLAccountChangeCFCategory(threadID, tempList, pathLocation);

			// Changing currentAccountingPeriodForTheTestCase value here to create test data
			// cash receipt. Later I will
			// change it to have user input
			previousAccountingPeriod = AccountingSeedReusableFunctionalities
					.identifyPreviousAccountingPeriod(currentAccountingPeriodForTheTestCase);
			currentAccountingPeriodForTheTestCase = previousAccountingPeriod;

			if (clonedGLAccountCreated) {
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
						"Previous accounting period identified as " + previousAccountingPeriod, browser,
						pathLocation + "\\" + testcasemethod, true);

				// Create new accounts
				createAccount(threadID, tempList, pathLocation);

				// Create cash receipt
				createCashReceiptWithCFCategory(threadID, tempList, pathLocation);

				if (newCashReceiptCreated) {

					// Close accounting period
					close_a_AccountingPeriod(threadID, tempList, pathLocation, previousAccountingPeriod);
					ReusableComponents.wait(60000);

					// Previous accounting period status should be closed
					String expectedAccountingPeriodStatus = "Closed";
					boolean previousAccountingPeriodStatus = false;
					previousAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
							previousAccountingPeriod, expectedAccountingPeriodStatus);

					if (previousAccountingPeriodStatus) {
						System.out.println("*********** Status displayed as expected. Good to go with the test case");

						// Run Financial Report
						String financialReportsURL = reusableComponents.getPropValues("FinancialReports");
						browser.get(financialReportsURL);
						// Browser.get is used here since there are issue in launching financial report
						// from search app. Once the issue resolved we can comment it and unccomment
						// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
						// Reports",
						ReusableComponents.wait(5000);

						ReusableComponents.wait(5000);
						ReusableComponents.clickElement(selectStandartReport_FinancialReport,
								"Click Select standard reportd");
						ReusableComponents.wait(5000);
						ReusableComponents.clickElement(selectCashFlowReport_FinancialReport,
								"Click Select cash flow report");
						ReusableComponents.wait(5000);

						ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
								"Clear button of starting account period");
						ReusableComponents.sendKey(accountingPeriod_CashFlowReport, accountingPeriodForTheTestCase,
								"Provide accounting period");
						ReusableComponents.clickElement(accountingPeriod_CashFlowReport,
								"Starting account period input box");
						ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
								"Select Starting account period");

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Accounting period details provided", browser, " ", false);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

						ReusableComponents.scrollDown(browser, 500);
						// --> Click on run button and get new record URL

						List<WebElement> recordsList = browser.findElements(
								By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
						System.out.println("************ Number of elements " + recordsList.size());

						if (recordsList.size() != 0) {
							String oldRecordName = firstReport_FinancialReport.getText();

							ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked",
									browser, " ", false);

							ReusableComponents.wait(20000);

							String newRecord = firstReport_FinancialReport.getText();
							if (!newRecord.contains("FRR")) {
								ReusableComponents.wait(20000);

								newRecord = firstReport_FinancialReport.getText();
							}

							if (newRecord.contains("FRR") && !oldRecordName.equalsIgnoreCase(newRecord)) {
								String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
								String financialReportURL = hreflink;
								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Created Financial report Name : " + newRecord
												+ ". Link of created financial report : " + hreflink,
										browser, pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);
							} else {

								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"There are no new records created, provide valid inputs ", browser,
										pathLocation + "\\" + testcasemethod, true);
							}
						} else {

							ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked",
									browser, pathLocation + "\\" + testcasemethod, false);

							ReusableComponents.wait(20000);

							List<WebElement> newRecordsList = browser.findElements(
									By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
							System.out.println("************ Number of elements " + newRecordsList.size());

							if (newRecordsList.size() == 0) {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"There are no new records created , please verify the input values", browser,
										pathLocation + "\\" + testcasemethod, true);
							} else {

								String newRecord = firstReport_FinancialReport.getText();

								if (!newRecord.contains("FRR")) {
									ReusableComponents.wait(20000);

									newRecord = firstReport_FinancialReport.getText();
								}

								String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
								String financialReportURL = hreflink;
								if (newRecord.contains("FRR")) {
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Created Financial report Name : " + newRecord
													+ ". Link of created financial report : " + hreflink,
											browser, pathLocation + "\\" + testcasemethod, false);
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
											pathLocation + "\\" + testcasemethod, true);
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
											pathLocation + "\\" + testcasemethod, true);
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"There are no new records created , please verify the input values",
											browser, pathLocation + "\\" + testcasemethod, true);
								}
							}
						}

					} else {
						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Previous accounting period status is not displayed as expected. Previous accounting period "
										+ previousAccountingPeriod + ". Expected status "
										+ expectedAccountingPeriodStatus,
								browser, pathLocation + "\\" + testcasemethod, true);

					}
				} else {
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"As part of test data creation there are no new cash receipt created. Hence can not continue with the test case",
							browser, pathLocation + "\\" + testcasemethod, true);
				}
			} else {
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"As part test data creation GL account clone with type cash flow is not performed. Hence can not continue with the test case",
						browser, pathLocation + "\\" + testcasemethod, true);
			}
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when executing test case test2730_CashFlowCategoryValueCanNotBeChanged"
							+ e.getStackTrace(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see [CF] Verify that if the CF statement is disabled after being enabled,
	 *      the CF category is not required for posting.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @throws Exception
	 */
	public static CashFlowStatementPage test2661_CashFlowTrueFalseCashReceipt(int threadID, List<String> tempList,
			String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		testCaseNumber = "Testcase2661";
		currentAccountingPeriodForTheTestCase = reusableComponents
				.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");

		try {
			// LoginToWebpage();

			// check Cash flow statement it should be true
			developerConsole_QueryRun_CashFlowTrueOrFalse(threadID, tempList, pathLocation, true);

			// check Cash flow statement it should be false
			developerConsole_QueryRun_CashFlowTrueOrFalse(threadID, tempList, pathLocation, false);

			// Create account
			createAccount(threadID, tempList, pathLocation);

			// create Cash Receipt
			createCashReceipt(threadID, tempList, pathLocation);

			ReusableComponents.scrollDownUsingPageDown(browser);
			ReusableComponents.wait(5000);

			ReusableComponents.clickElement(editCashFlowCategoryButton, "Click on edit cash flow button");
			ReusableComponents.wait(5000);
			ReusableComponents.getText(cashFlowInputBox_caseReceipt, "Cash Flow Category");

			String defaultTextCashFlow = ReusableComponents.getText(cashFlowInputBox_caseReceipt,
					"Cash Flow Category Default value");
			System.out.println("*********** defaultTextCashFlow : " + defaultTextCashFlow);
			if (defaultTextCashFlow.equalsIgnoreCase("")) {
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Cash flow category value is empty. There are no default values are selected", browser,
						pathLocation + "\\" + testcasemethod, false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLocation + "\\" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Cash flow category value is not empty. It says " + defaultTextCashFlow, browser,
						pathLocation + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when executing test case test2730_CashFlowCategoryValueCanNotBeChanged"
							+ e.getStackTrace(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see This is to create GL account
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param appNameToSearch
	 * @param selectAppXpath
	 * @throws Exception
	 */
	public static BankingLedgerPage createGLAccount(int threadID, List<String> tempList, String pathLocation)
			throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		if (reusableComponents.getPropValues(testCaseNumber + "_GLName") == null) {
			newGLName = "GLAccount_" + testCaseNumber + "_"
					+ ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss");
		} else {
			newGLName = reusableComponents.getPropValues(testCaseNumber + "_GLName");
		}
		String glAccountTypeValue = reusableComponents.getPropValues(testCaseNumber + "_" + "GLAccountTypeValue");
		String glAccountSubTypeValue = reusableComponents.getPropValues(testCaseNumber + "_" + "GLAccountSubTypeValue");

		try {
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "GL Accounts", SelectGLAccount);

			// --> Click on new button

			ReusableComponents.clickElement(New, "New Button");
			ReusableComponents.wait(5000);

			// --> Provide values for new GL account

			if (newGLAccountPopup.isDisplayed() == true) {
				ReusableComponents.sendKey(name_NewGLAccount, newGLName, "Provide GL Account Name");
				/*
				 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
				 * "With the assumption Bank/Credit Card Account check box will be always selected"
				 * , browser, pathLocation + "\\" + testcasemethod, true);
				 */
				ReusableComponents.clickElement(type_newGLAccountPopUp, "Click type ");
				String typeValueXpath = ".//span[@title='" + glAccountTypeValue + "']";
				WebElement typeValueElement = browser.findElement(By.xpath(typeValueXpath));
				ReusableComponents.clickUsingJavaScript(browser, typeValueElement, "Select type value");

				ReusableComponents.clickElement(subType1_newGLAccountPopUp, "Click sub type 1");
				String sybTypeValueXpath = ".//span[@title='" + glAccountSubTypeValue + "']";
				WebElement subTypeValueElement = browser.findElement(By.xpath(sybTypeValueXpath));
				ReusableComponents.clickUsingJavaScript(browser, subTypeValueElement, "Select subtype 1 value");

				ReusableComponents.clickElement(saveButton_NewGLAccount, "Click on Save");
				ReusableComponents.wait(10000);

				// Verify new GL Account created
				String newGLAccount = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'"
						+ newGLName + "')]";
				if (browser.findElement(By.xpath(newGLAccount)).isDisplayed() == true) {
					newGLAccountCreationStatus = true;
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"New GL Account " + newGLName + " is displayed", browser,
							pathLocation + "\\" + testcasemethod, false);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
							pathLocation + "\\" + testcasemethod, true);
				} else {
					newGLAccountCreationStatus = false;
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"New GL Account " + newGLName + " is not displayed", browser,
							pathLocation + "\\" + testcasemethod, true);
				}
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"New GL Account popup is not displayed", browser, pathLocation + "\\" + testcasemethod, true);
			}
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception During new GL account creation" + e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to Create GL account" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

		return new BankingLedgerPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see [CF] Verify that a CF category cannot be deleted once there are records
	 *      associated to it
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @throws Exception
	 */
	public static CashFlowStatementPage test2662_CashFlowCanNotDeleteWithRecords(int threadID, List<String> tempList,
			String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		testCaseNumber = "Testcase2662";
		currentAccountingPeriodForTheTestCase = reusableComponents
				.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");

		try {
			LoginToWebpage();

			// check Cash flow statement it should be true
			developerConsole_QueryRun_CashFlowTrueOrFalse(threadID, tempList, pathLocation, true);

			// Create GL account with cash flow
			createGLAccount(threadID, tempList, pathLocation);

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when executing test case test2730_CashFlowCategoryValueCanNotBeChanged"
							+ e.getStackTrace(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see [CF] Verify message shown when CF is enabled but records are
	 *      uncategorized and Show All Periods is checked
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @throws Exception
	 */
	public static CashFlowStatementPage test2731_CFEnabledRecordUnCategoricedShowAllChecked(int threadID,
			List<String> tempList, String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		Page page = new Page(browser);
		page.accountingSeedReusableFunction(threadID, tempList, pathLocation);
		testCaseNumber = "Testcase2731";
		runTimeTestData.put("testCaseNumber", testCaseNumber);

		currentAccountingPeriodForTheTestCase = reusableComponents
				.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");
		System.out.println(
				"*********** currentAccountingPeriodForTheTestCase : " + currentAccountingPeriodForTheTestCase);
		runTimeTestData.put(testCaseNumber + "_AccountingPeriodForTestCase", currentAccountingPeriodForTheTestCase);

		String previousAccountingPeriod = AccountingSeedReusableFunctionalities
				.identifyPreviousAccountingPeriod(currentAccountingPeriodForTheTestCase);
		System.out.println("********** previousAccountingPeriod : " + previousAccountingPeriod);
		runTimeTestData.put(testCaseNumber + "_AccountingPeriodForTestDataCreation", previousAccountingPeriod);

		String expectedErrorMessageHeading = reusableComponents.getPropValues(testCaseNumber + "_ErrorTextHeading");
		String expectedErrorMessage = reusableComponents.getPropValues(testCaseNumber + "_ErrorMessage");
		String ledgerValue = reusableComponents.getPropValues(testCaseNumber + "_LedgerValue");

		try {

			// --> Login to webpage
			AccountingSeedReusableFunctionalities.LoginToWebpage(threadID, tempList, pathLocation, browser);

			// --> check Cash flow statement it should be false
			AccountingSeedReusableFunctionalities.developerConsole_QueryRun_CashFlowTrueOrFalse(threadID, tempList,
					pathLocation, browser, false);

			// --> Open the previous accounting period
			AccountingSeedReusableFunctionalities.openAccountingPeriod(threadID, tempList, pathLocation, browser,
					previousAccountingPeriod);

			String expectedAccountingPeriodStatus = "Open";
			Boolean actualAccountingPeriodStatus = false;
			actualAccountingPeriodStatus = AccountingSeedReusableFunctionalities.checkAccountPeriodStatus(threadID,
					tempList, pathLocation, browser, previousAccountingPeriod, expectedAccountingPeriodStatus);

			if (actualAccountingPeriodStatus) {
				// --> Create Test data New account
				AccountingSeedReusableFunctionalities.createAccount(threadID, tempList, pathLocation, browser);

				if (runTimeTestData.get(testCaseNumber + "_accountCreatedStatus").equalsIgnoreCase("true")) {

					// --> Create new GL account
					AccountingSeedReusableFunctionalities.createGLAccount(threadID, tempList, pathLocation, browser);

					if (runTimeTestData.get(testCaseNumber + "_newGLAccountCreationStatus").equalsIgnoreCase("true")) {

						// --> create new cash receipt
						AccountingSeedReusableFunctionalities.createCashReceiptWithCFCategory(threadID, tempList,
								pathLocation, browser);

						if (runTimeTestData.get(testCaseNumber + "_newCashReceiptCreated").equalsIgnoreCase("true")) {
							System.out.println("********** Good to continue with the test case ");

							// --> Close the previous accounting period
							AccountingSeedReusableFunctionalities.closeAccountingPeriod(threadID, tempList,
									pathLocation, browser, previousAccountingPeriod);

							// --> Previous accounting period status should be closed
							expectedAccountingPeriodStatus = "Closed";
							boolean previousAccountingPeriodStatus = false;
							previousAccountingPeriodStatus = AccountingSeedReusableFunctionalities
									.checkAccountPeriodStatus(threadID, tempList, pathLocation, browser,
											previousAccountingPeriod, expectedAccountingPeriodStatus);

							if (previousAccountingPeriodStatus) {

								// --> check Cash flow statement it should be true
								AccountingSeedReusableFunctionalities.developerConsole_QueryRun_CashFlowTrueOrFalse(
										threadID, tempList, pathLocation, browser, true);

								System.out.println(
										"*********** Status displayed as expected. Good to go with the test case");

								// --> Run Financial Report
								String financialReportsURL = reusableComponents.getPropValues("FinancialReports");
								browser.get(financialReportsURL);
								// Browser.get is used here since there are issue in launching financial report
								// from search app. Once the issue resolved we can comment it and unccomment
								// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
								// Reports",
								ReusableComponents.wait(5000);

								ReusableComponents.wait(5000);
								ReusableComponents.clickElement(selectStandartReport_FinancialReport,
										"Select standard reportd");
								ReusableComponents.wait(5000);
								ReusableComponents.clickElement(selectCashFlowReport_FinancialReport,
										"Select cash flow report");
								ReusableComponents.wait(5000);

								/*
								 * ReusableComponents.clickElement(clearSectionOfLedger_TrailBalance,
								 * "Clear button of Ledger input box period");
								 * ReusableComponents.sendKey(ledgerTypeInputBox_TrailBalance, ledgerValue,
								 * "Accounting period"); String selcectLedgerValueXpath =
								 * "//lightning-base-combobox-formatted-text[@title='" + ledgerValue + "']";
								 * WebElement selectValueElement =
								 * browser.findElement(By.xpath(selcectLedgerValueXpath));
								 * ReusableComponents.clickElement(selectValueElement, "Select Ledger Type");
								 */

								ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
										"Clear button of starting account period");
								ReusableComponents.sendKey(startingAccoutPeriodCashFlow, previousAccountingPeriod,
										"Accounting period");
								ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
										"Select Starting account period");

								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Ledger and Accounting period values are given to run report", browser,
										pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								// --> check suppress zero amount check box
								ReusableComponents.scrollJavaScriptDown(browser, supressZeroAmountCheckBox);
								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"By default, Supress Zero amount check box will be checked.  so the assumption will be the check box is checked",
										browser, pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								// --> Click on show all period check box
								ReusableComponents.clickElement(showAllPeriodsCheckBox_CashFlowPage,
										"Click Show all periods Check box");
								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"By default, Show all periods check box will be unchecked.  so the assumption will be clicking it once will make check box is checked",
										browser, pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								List<WebElement> recordsList = browser.findElements(
										By.xpath(".//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')]"));
								System.out.println("************ Number of reports " + recordsList.size());

								if (recordsList.size() != 0) {
									String oldRecordName = firstReport_FinancialReport.getText();
									System.out.println("*********** oldRecordName " + oldRecordName);
									ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Run button clicked", browser, " ", false);

									ReusableComponents.wait(20000);

									try {
										String errorMessageHeading = trialBalanceErrorMessageHeading.getText();
										String errorMessage = trialBalanceErrorMessage.getText();

										if (errorMessageHeading.equalsIgnoreCase(expectedErrorMessageHeading)) {
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Error Message Heading displayed as expected", browser,
													pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Error Message Heading is not displayed as expected. Expected heading : "
															+ expectedErrorMessageHeading + ". Actual heading : "
															+ errorMessageHeading,
													browser, pathLocation + "\\" + testcasemethod, true);
										}

										if (errorMessage.equalsIgnoreCase(expectedErrorMessage)) {
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Error Message displayed as expected", browser,
													pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Error Message is not displayed as expected. Expected error message :"
															+ expectedErrorMessage + ". Actual error message : "
															+ errorMessage,
													browser, pathLocation + "\\" + testcasemethod, true);
										}

									} catch (NoSuchElementException e) {
										e.printStackTrace();
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Exception when reading error text. Error Message is not displayed as expected. "
														+ e,
												browser, pathLocation + "\\" + testcasemethod, true);
									} catch (Exception e) {
										e.printStackTrace();
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Exception when trying to read the error message. " + e.getMessage(),
												browser, pathLocation + "\\" + testcasemethod, true);
									}

									ReusableComponents.scrollDown(browser, 500);

									ReusableComponents.wait(20000);

									String newRecord = firstReport_FinancialReport.getText();

									if (!newRecord.contains("FRR")) {
										ReusableComponents.wait(20000);

										newRecord = firstReport_FinancialReport.getText();
									}

									System.out.println("*********** newRecord " + newRecord);
									if (newRecord.contains("FRR") && oldRecordName.equalsIgnoreCase(newRecord)) {
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"As per the functionality there should not be any new report created when current and previous accounting periods are in open status. Functionality working fine",
												browser, pathLocation + "\\" + testcasemethod, false);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);
									} else {
										String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport,
												"href");
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"As per the functionality there should not be any new report created when current and previous accounting periods are in open status. However new Financial report created. Name : "
														+ newRecord + ". Link of created financial report : "
														+ hreflink,
												browser, pathLocation + "\\" + testcasemethod, true);
									}
								} else {

									ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Run button clicked", browser, pathLocation + "\\" + testcasemethod, false);

									ReusableComponents.wait(20000);

									try {
										String errorMessageHeading = trialBalanceErrorMessageHeading.getText();
										String errorMessage = trialBalanceErrorMessage.getText();

										if (errorMessageHeading.equalsIgnoreCase(expectedErrorMessageHeading)) {
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Error Message Heading displayed as expected", browser,
													pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Error Message Heading is not displayed as expected", browser,
													pathLocation + "\\" + testcasemethod, true);
										}

										if (errorMessage.equalsIgnoreCase(expectedErrorMessage)) {
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Error Message displayed as expected", browser,
													pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Error Message is not displayed as expected. Expected error message :"
															+ expectedErrorMessage + ". Actual error message : "
															+ errorMessage,
													browser, pathLocation + "\\" + testcasemethod, true);
										}

									} catch (NoSuchElementException e) {
										e.printStackTrace();
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Exception when reading error message. Error Message is not displayed as expected"
														+ e,
												browser, pathLocation + "\\" + testcasemethod, true);
									} catch (Exception e) {
										e.printStackTrace();
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Exception when trying to read the error message. " + e.getMessage(),
												browser, pathLocation + "\\" + testcasemethod, true);
									}
									ReusableComponents.scrollDown(browser, 500);

									ReusableComponents.wait(20000);

									List<WebElement> newRecordsList = browser.findElements(By
											.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
									System.out.println("************ Number of elements " + newRecordsList.size());

									if (newRecordsList.size() == 0) {
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"As per the functionality there should not be any new report created when current and previous accounting periods are open. Functionality working fine",
												browser, pathLocation + "\\" + testcasemethod, false);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);
									} else {
										String newRecord = firstReport_FinancialReport.getText();
										String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport,
												"href");
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"As per the functionality there should not be any new report created when current and previous accounting periods are open. However new Financial report created. Name : "
														+ newRecord + ". Link of created financial report : "
														+ hreflink,
												browser, pathLocation + "\\" + testcasemethod, true);
									}
								}

								// ------------------------------------------------------------------------------------
								// --> Uncheck show all periods check box and verify the results
								// --> Run Financial Report
								financialReportsURL = reusableComponents.getPropValues("FinancialReports");
								browser.get(financialReportsURL);
								// Browser.get is used here since there are issue in launching financial report
								// from search app. Once the issue resolved we can comment it and unccomment
								// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
								// Reports",
								ReusableComponents.wait(5000);

								ReusableComponents.wait(5000);
								ReusableComponents.clickElement(selectStandartReport_FinancialReport,
										"Select standard reportd");
								ReusableComponents.wait(5000);
								ReusableComponents.clickElement(selectCashFlowReport_FinancialReport,
										"Select cash flow report");
								ReusableComponents.wait(5000);

								/*
								 * ReusableComponents.clickElement(clearSectionOfLedger_TrailBalance,
								 * "Clear button of Ledger input box period");
								 * ReusableComponents.sendKey(ledgerTypeInputBox_TrailBalance, ledgerValue,
								 * "Accounting period"); String selcectLedgerValueXpath =
								 * "//lightning-base-combobox-formatted-text[@title='" + ledgerValue + "']";
								 * WebElement selectValueElement =
								 * browser.findElement(By.xpath(selcectLedgerValueXpath));
								 * ReusableComponents.clickElement(selectValueElement, "Select Ledger Type");
								 */

								ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
										"Clear button of starting account period");
								ReusableComponents.sendKey(startingAccoutPeriodCashFlow, previousAccountingPeriod,
										"Accounting period");
								ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
										"Select Starting account period");

								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Ledger and Accounting period values are given to run report", browser,
										pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);
								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"By default show all periods check box will not be selected. so the assumption will be check box unchecked",
										browser, pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								recordsList.clear();
								recordsList = browser.findElements(
										By.xpath(".//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')]"));
								System.out.println("************ Number of reports " + recordsList.size());

								if (recordsList.size() != 0) {
									String oldRecordName = firstReport_FinancialReport.getText();
									System.out.println("*********** oldRecordName " + oldRecordName);
									ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Run button clicked", browser, " ", false);

									ReusableComponents.wait(20000);

									try {
										String errorMessageHeading = trialBalanceErrorMessageHeading.getText();
										String errorMessage = trialBalanceErrorMessage.getText();

										if (errorMessageHeading.equalsIgnoreCase(expectedErrorMessageHeading)) {
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Error Message Heading displayed as expected", browser,
													pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Error Message Heading is not displayed as expected. Expected heading : "
															+ expectedErrorMessageHeading + ". Actual heading : "
															+ errorMessageHeading,
													browser, pathLocation + "\\" + testcasemethod, true);
										}

										if (errorMessage.equalsIgnoreCase(expectedErrorMessage)) {
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Error Message displayed as expected", browser,
													pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Error Message is not displayed as expected. Expected error message :"
															+ expectedErrorMessage + ". Actual error message : "
															+ errorMessage,
													browser, pathLocation + "\\" + testcasemethod, true);
										}

									} catch (NoSuchElementException e) {
										e.printStackTrace();
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Exception when reading error message. Error Message is not displayed as expected"
														+ e,
												browser, pathLocation + "\\" + testcasemethod, true);
									} catch (Exception e) {
										e.printStackTrace();
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Exception when trying to read the error message. " + e.getMessage(),
												browser, pathLocation + "\\" + testcasemethod, true);
									}

									ReusableComponents.scrollDown(browser, 500);

									ReusableComponents.wait(20000);

									String newRecord = firstReport_FinancialReport.getText();

									if (!newRecord.contains("FRR")) {
										ReusableComponents.wait(20000);

										newRecord = firstReport_FinancialReport.getText();
									}

									System.out.println("*********** newRecord " + newRecord);
									if (newRecord.contains("FRR") && oldRecordName.equalsIgnoreCase(newRecord)) {
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"As per the functionality there should not be any new report created when current and previous accounting periods are in open status. Functionality working fine",
												browser, pathLocation + "\\" + testcasemethod, false);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);
									} else {
										String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport,
												"href");
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"As per the functionality there should not be any new report created when current and previous accounting periods are in open status. However new Financial report created. Name : "
														+ newRecord + ". Link of created financial report : "
														+ hreflink,
												browser, pathLocation + "\\" + testcasemethod, true);
									}
								} else {

									ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Run button clicked", browser, pathLocation + "\\" + testcasemethod, false);

									ReusableComponents.wait(20000);

									try {
										String errorMessageHeading = trialBalanceErrorMessageHeading.getText();
										String errorMessage = trialBalanceErrorMessage.getText();

										if (errorMessageHeading.equalsIgnoreCase(expectedErrorMessageHeading)) {
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Error Message Heading displayed as expected", browser,
													pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Error Message Heading is not displayed as expected. Expected heading : "
															+ expectedErrorMessageHeading + ". Actual heading : "
															+ errorMessageHeading,
													browser, pathLocation + "\\" + testcasemethod, true);
										}

										if (errorMessage.equalsIgnoreCase(expectedErrorMessage)) {
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Error Message displayed as expected", browser,
													pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Error Message is not displayed as expected. Expected error message :"
															+ expectedErrorMessage + ". Actual error message : "
															+ errorMessage,
													browser, pathLocation + "\\" + testcasemethod, true);
										}

									} catch (NoSuchElementException e) {
										e.printStackTrace();
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Exception when reading error message. Error Message is not displayed as expected"
														+ e,
												browser, pathLocation + "\\" + testcasemethod, true);
									} catch (Exception e) {
										e.printStackTrace();
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Exception when trying to read the error message. " + e.getMessage(),
												browser, pathLocation + "\\" + testcasemethod, true);
									}
									ReusableComponents.scrollDown(browser, 500);

									ReusableComponents.wait(20000);

									List<WebElement> newRecordsList = browser.findElements(By
											.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
									System.out.println("************ Number of elements " + newRecordsList.size());

									if (newRecordsList.size() == 0) {
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"As per the functionality there should not be any new report created when current and previous accounting periods are open. Functionality working fine",
												browser, pathLocation + "\\" + testcasemethod, false);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);
									} else {
										String newRecord = firstReport_FinancialReport.getText();
										String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport,
												"href");
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"As per the functionality there should not be any new report created when current and previous accounting periods are open. However new Financial report created. Name : "
														+ newRecord + ". Link of created financial report : "
														+ hreflink,
												browser, pathLocation + "\\" + testcasemethod, true);
									}
								}

								// --------------------------------------------------------------------
								// --> Provide current accounting period and verify the results.
								financialReportsURL = reusableComponents.getPropValues("FinancialReports");
								browser.get(financialReportsURL);
								// Browser.get is used here since there are issue in launching financial report
								// from search app. Once the issue resolved we can comment it and unccomment
								// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
								// Reports",
								ReusableComponents.wait(5000);

								ReusableComponents.wait(5000);
								ReusableComponents.clickElement(selectStandartReport_FinancialReport,
										"Select standard reportd");
								ReusableComponents.wait(5000);
								ReusableComponents.clickElement(selectCashFlowReport_FinancialReport,
										"Select cash flow report");
								ReusableComponents.wait(5000);
								
								ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
										"Clear button of starting account period");
								ReusableComponents.sendKey(startingAccoutPeriodCashFlow,
										currentAccountingPeriodForTheTestCase, "Accounting period");
								ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
										"Select Starting account period");

								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Ledger and Accounting period values are given to run report", browser,
										pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								// --> check supress zero amount check box
								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"By default, Supress Zero amount check box will be checked.  so the assumption will be the check box is checked",
										browser, pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								// --> Click on show all period check box
								ReusableComponents.clickElement(showAllPeriodsCheckBox_CashFlowPage,
										"Click Show all periods Check box");
								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"By default, Show all periods check box will be unchecked.  so the assumption will be clicking it once will make check box is checked",
										browser, pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								recordsList.clear();
								recordsList = browser.findElements(
										By.xpath(".//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')]"));
								System.out.println("************ Number of reports " + recordsList.size());

								if (recordsList.size() != 0) {
									String oldRecordName = firstReport_FinancialReport.getText();
									System.out.println("*********** oldRecordName " + oldRecordName);
									ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Run button clicked", browser, " ", false);

									ReusableComponents.wait(20000);

									try {
										String errorMessageHeading = trialBalanceErrorMessageHeading.getText();
										String errorMessage = trialBalanceErrorMessage.getText();

										if (ReusableComponents.isDisplayed(trialBalanceErrorMessageHeading,
												"Error Message heading")) {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Error Message Heading is displayed", browser,
													pathLocation + "\\" + testcasemethod, true);

										} else {
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Error Message Heading is not displayed", browser,
													pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										}

										if (ReusableComponents.isDisplayed(trialBalanceErrorMessage, "Error Message")) {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Error Message is displayed", browser,
													pathLocation + "\\" + testcasemethod, false);
										} else {
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Error Message is not displayed", browser,
													pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										}

									} catch (NoSuchElementException e) {
										e.printStackTrace();
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Error Message is not displayed", browser,
												pathLocation + "\\" + testcasemethod, true);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);
									} catch (Exception e) {
										e.printStackTrace();
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Exception when trying to read the error message. " + e.getMessage(),
												browser, pathLocation + "\\" + testcasemethod, true);
									}

									ReusableComponents.scrollDown(browser, 500);

									ReusableComponents.wait(20000);

									String newRecord = firstReport_FinancialReport.getText();

									if (!newRecord.contains("FRR")) {
										ReusableComponents.wait(20000);

										newRecord = firstReport_FinancialReport.getText();
									}

									System.out.println("*********** newRecord " + newRecord);
									if (newRecord.contains("FRR") && !oldRecordName.equalsIgnoreCase(newRecord)) {
										String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport,
												"href");
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"New report created when providing first open period. Name : "
														+ newRecord + ". Link of created financial report : "
														+ hreflink,
												browser, pathLocation + "\\" + testcasemethod, false);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"There are no new report created", browser,
												pathLocation + "\\" + testcasemethod, true);
									}
								} else {

									ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Run button clicked", browser, pathLocation + "\\" + testcasemethod, false);

									ReusableComponents.wait(20000);

									try {
										String errorMessageHeading = trialBalanceErrorMessageHeading.getText();
										String errorMessage = trialBalanceErrorMessage.getText();

										if (ReusableComponents.isDisplayed(trialBalanceErrorMessageHeading,
												"Error Message heading")) {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Error Message Heading is displayed", browser,
													pathLocation + "\\" + testcasemethod, true);

										} else {
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Error Message Heading is not displayed", browser,
													pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										}

										if (ReusableComponents.isDisplayed(trialBalanceErrorMessage, "Error message")) {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Error Message displayed", browser,
													pathLocation + "\\" + testcasemethod, true);

										} else {
											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Error Message is not displayed", browser,
													pathLocation + "\\" + testcasemethod, true);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										}

									} catch (NoSuchElementException e) {
										e.printStackTrace();
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"There are no Error Message displayed ", browser,
												pathLocation + "\\" + testcasemethod, false);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);
									} catch (Exception e) {
										e.printStackTrace();
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Exception when trying to read the error message. " + e.getMessage(),
												browser, pathLocation + "\\" + testcasemethod, true);
									}
									ReusableComponents.scrollDown(browser, 500);

									ReusableComponents.wait(20000);

									List<WebElement> newRecordsList = browser.findElements(By
											.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
									System.out.println("************ Number of elements " + newRecordsList.size());

									if (newRecordsList.size() == 0) {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"There are no new record created", browser,
												pathLocation + "\\" + testcasemethod, false);
									} else {
										String newRecord = firstReport_FinancialReport.getText();
										String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport,
												"href");
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"New Financial report created. Name : " + newRecord
														+ ". Link of created financial report : " + hreflink,
												browser, pathLocation + "\\" + testcasemethod, false);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);
									}
								}

							} else {
								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Previous accounting period status is not displayed as expected. Previous accounting period "
												+ previousAccountingPeriod + ". Expected status "
												+ expectedAccountingPeriodStatus,
										browser, pathLocation + "\\" + testcasemethod, true);

							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"There are no new GL account created as part of test data creation , hence can not continue with the test case",
									browser, pathLocation + "\\" + testcasemethod, true);
						}
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There are no new account created as part of test data creation , hence can not continue with the test case",
								browser, pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There are no new account created as part of test data creation , hence can not continue with the test case",
							browser, pathLocation + "\\" + testcasemethod, true);
				}
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Previous accounting period status is not open , Hence can not continue with the test case. Previous accounting period "
								+ previousAccountingPeriod,
						browser, pathLocation + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Following exception occured when executing test case test2730_CashFlowCategoryValueCanNotBeChanged"
							+ e,
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new CashFlowStatementPage(browser);
	}

}
