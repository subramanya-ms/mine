package com.wisefinch.java;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetElementAttribute;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base class for all the pages.
 *
 */
public class BankingLedgerPage extends DriverScript {

	protected static WebDriver browser;

	static String valueToSet, dateGatheredToGiveNam, cdbName, newGLName, newGLAccountName, reportName, reportUniqueName,
			startingAccountPeriod, accountingPeriodToClose, nSFReportURL, financialReportURL, accountingPeriod,
			cashDisbursementName, per_stat, DB_Name = null, testCaseNumber, currentAccountingPeriodForTheTestCase,
			newLedgerName;
	int previousYearClose, Nextyear;

	static String newAccountname, testDataNewBillingName = null, testDataNewPayableName = null;
	static String CDB_Name;
	static boolean accountCreatedStatus = false, testDataNewBillingCreated = false, testDataNewDisbursement = false,
			newPayableStatus = false, newLedgerCreatedStatus = false, newGLAccountCreationStatus = false;

	static ReusableComponents reusableComponents = new ReusableComponents();

	protected BankingLedgerPage(WebDriver browser) {
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

	// Webelement declaration

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

	@FindBy(xpath = "(.//lightning-button//button[contains(text(),'Save')])[2]")
	static WebElement saveButton_LedgerPage;

	@FindBy(xpath = ".//*[@name='Name']")
	static WebElement ledgerName_LedgerPage;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Ledgers')]")
	static WebElement selectLedgerFromApp;

	@FindBy(xpath = ".//li//*[contains(text(),'New')]")
	static WebElement newLink_LedgerPage;

	@FindBy(xpath = ".//*[@class='actionBody']//button[@name='SaveEdit']")
	static WebElement saveButton_EditAccountingPeriod;

	@FindBy(xpath = ".//*[@class='actionBody']//*[contains(text(),'Closed')]")
	static WebElement selectStatusAsClosed_EditAccountingPeriod;

	@FindBy(xpath = ".//*[@class='actionBody']//*[contains(text(),'Open')]")
	static WebElement selectStatusAsOpen_EditAccountingPeriod;

	@FindBy(xpath = ".//*[@class='actionBody']//input[@role='combobox']")
	static WebElement statusDropDown_EditAccountingPeriod;

	@FindBy(xpath = ".//button[@name='Edit']")
	static WebElement edit_AccountingPeriod;

	@FindBy(xpath = ".//*[@class='slds-text-heading_small']")
	static WebElement trialBalanceErrorMessageHeading;

	@FindBy(xpath = ".//*[@class='inline-error-msg']//li")
	static WebElement trialBalanceErrorMessage;

	@FindBy(xpath = ".//*[@data-jest='suppressZeroAmountRows']//*[contains(text(),'Suppress Zero Amount')]")
	static WebElement supressZeroAmountCheckBox;

	@FindBy(xpath = "(.//*[@class='slds-form-element__control']//input)[1]")
	static WebElement ledgerTypeInputBox_TrailBalance;

	@FindBy(xpath = "//span[@class='slds-listbox__option-meta slds-listbox__option-meta_entity']")
	static WebElement selectLedgerType_TrailBalance;

	@FindBy(xpath = ".//button[@title='Clear Selection']")
	static WebElement clearSectionOfLedger_TrailBalance;

	@FindBy(xpath = "((.//*[@class='slds-form-element'])[2]//input)[1]")
	static WebElement startingAccoutPeriodTrailBalance;

	@FindBy(xpath = ".//*[@class='actionBody']//*[contains(text(),'New Payable')]")
	static WebElement newPayablePopUp;

	@FindBy(xpath = ".//*[@slot='primaryField']/lightning-formatted-text")
	static WebElement nameOfCreatedBilling;

	@FindBy(xpath = ".//*[@slot='secondaryFields']/*[@role='listitem']//*[contains(text(),'Posted')]")
	static WebElement checkStatus;

	@FindBy(xpath = "//img[@title='Accounts']")
	WebElement Accounts;

	@FindBy(xpath = "//force-record-layout-base-input//div[@class='slds-form-element__control slds-grow']/input[@name='Name']")
	WebElement Account_Name;

	@FindBy(xpath = "//force-record-layout-item[1]//lightning-combobox[1]//lightning-base-combobox[1]/div[1]/div[1]/input[1]")
	WebElement Account_type;

	@FindBy(xpath = "//span[@class='slds-checkbox slds-checkbox_standalone']/input[@name='AcctSeed__Accounting_Active__c']")
	WebElement Accounting_Active;

	@FindBy(xpath = ".//*[@data-aura-class='uiOutputText']")
	static WebElement listViewe_AccoutingPeriod;
	// payables

	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounting Periods...')]")
	static WebElement Period_input;

	@FindBy(xpath = "//img[@title='Cash Receipts']")
	WebElement Cash_Receipts_tab;

	@FindBy(xpath = "//span[@class='uiImage']/img[@src='/img/icon/t4v35/custom/custom14_120.png']")
	WebElement Payee_tab;

	@FindBy(xpath = "//div[@class='slds-form']//force-record-layout-row[3]//force-record-layout-item//lightning-combobox//input[@class='slds-input slds-combobox__input']")
	WebElement Posting_status_payables;

	@FindBy(xpath = "//span[@title='Approved']")
	WebElement Status_payables;

	@FindBy(xpath = "//input[@name='AcctSeed__Payee_Reference__c']")
	static WebElement Payee_Reference;

	@FindBy(xpath = "//force-record-layout-row[1]/slot[1]/force-record-layout-item[1]//force-record-layout-lookup[1]//input[1]")
	static WebElement Vendor;

	// @FindBy(xpath = "//button[@name='New']")
	@FindBy(xpath = "//button[contains(text(),'New')]")
	static WebElement New_PLine;

	@FindBy(xpath = "//input[@name='AcctSeed__Unit_Cost__c']")
	static WebElement Unit_cost;

	@FindBy(xpath = "//force-record-layout-row[1]//force-record-layout-item[1]//force-record-layout-lookup[1]//lightning-grouped-combobox[1]//lightning-base-combobox[1]//input[1]")
	static WebElement Expense_GL_Account;

	@FindBy(xpath = "//div[@class='pbHeader']//tbody//input[@value='Post']")
	WebElement Post_final_Payable;

	// payables end

//Cash receipt

	@FindBy(xpath = "//img[@src='/img/icon/t4v35/custom/custom17_120.png']")
	WebElement Cash_Receipt_tab;

	@FindBy(xpath = "//div/slot/force-record-layout-row[2]/slot//input[contains(@placeholder,'Search Accounts..')]")
	WebElement Customer_CashReceipt;

	@FindBy(xpath = "//div[@class='slds-form']//force-record-layout-row[3]//force-record-layout-item//lightning-combobox//input[@class='slds-input slds-combobox__input']")
	WebElement Type;

	@FindBy(xpath = "//input[@name='AcctSeed__Amount__c']")
	WebElement Amount;

	@FindBy(xpath = "//input[@name='AcctSeed__Payment_Reference__c']")
	WebElement Reference;

	@FindBy(xpath = "//div[@class='pbHeader']//tbody//input[@value='Post']")
	WebElement Post_final_CashReceipt;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounts...')]")
	WebElement Customer_CR;

	// Cash receipt end

	// Billing page

	@FindBy(xpath = ".//*[@placeholder='Search Accounting Periods...']")
	static WebElement accountingPeriod_Billing;

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;

	@FindBy(xpath = "//img[@src='/img/icon/t4v35/custom/custom42_120.png']")
	static WebElement Billing_tab;

	@FindBy(xpath = "//force-record-layout-section[1]//force-record-layout-row[4]//input[1]")
	static WebElement Posting_status;

	@FindBy(xpath = "//force-record-layout-section[3]//force-record-layout-row[1]//force-record-layout-item[1]//input[1]")
	static WebElement Customer;

	// @FindBy(xpath =
	// "//div[4]//div[2]//div[4]//flexipage-component2[1]//flexipage-component2[2]//ul[1]/li[1]//button[1]")
	@FindBy(xpath = "//button[normalize-space()='New']")
	static WebElement New_Bline;

	@FindBy(xpath = "//input[@name='AcctSeed__Date__c']")
	static WebElement Date;

	@FindBy(xpath = "//div/input[@name='AcctSeed__Rate__c']")
	static WebElement Unit_price;

	@FindBy(xpath = "//div/input[@name='AcctSeed__Hours_Units__c']")
	static WebElement Quantity;

	@FindBy(xpath = "//div[@class='pbHeader']//tbody//input[@value='Post']")
	static WebElement Post_final_Billing;

	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();

	// Billing page end

	@FindBy(xpath = ".//*[@class='actionBody']")
	static WebElement cashDisbursementPopup;

	@FindBy(xpath = "//span[@title='Assets']")
	static WebElement subType1_Value_As_Assets_newGLAccountPopUp;

	@FindBy(xpath = "(.//*[@class='actionBody']//input[@role='combobox'])[1]")
	static WebElement type_newGLAccountPopUp;

	@FindBy(xpath = "(.//*[@class='actionBody']//input[@role='combobox'])[2]")
	static WebElement subType1_newGLAccountPopUp;

	@FindBy(xpath = ".//*[@data-aura-class='forceInlineEditCell']//a[@data-refid='recordId' and contains(text(),'CD')]")
	static WebElement newCashDisbursementID;

	@FindBy(xpath = ".//*[@class='slds-form-element']//*[@type='search']")
	static WebElement searchTextBox_AccountPeriod;

	@FindBy(xpath = ".//button[contains(text(),'Run')]")
	static WebElement runButton_FinancialReport;

	@FindBy(xpath = "(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]")
	static WebElement firstReport_FinancialReport;

	@FindBy(xpath = "(.//*[@title='Remove selected option'])[1]")
	static WebElement startingAccoutPeriod_FinancialReport_Clear;

	@FindBy(xpath = "(.//*[@title='Remove selected option'])[2]")
	static WebElement endingAccoutPeriod_FinancialReport_Clear;

	@FindBy(xpath = "((.//*[@class='slds-form-element'])[3]//input)[1]")
	static WebElement startingAccoutPeriod_FinancialReport;

	@FindBy(xpath = "((.//*[@class='slds-form-element'])[4]//input)[1]")
	static WebElement endingAccoutPeriod_FinancialReport;

	@FindBy(xpath = "//span[@class='slds-listbox__option-meta slds-listbox__option-meta_entity']")
	static WebElement selectAccountingPeriod_FinancialReport;

	@FindBy(xpath = ".//span[normalize-space()='Balance Sheet']")
	static WebElement balanceSheet_selectStandartReport_FinancialReport;

	@FindBy(xpath = ".//span[normalize-space()='P & L vs. Budget']")
	static WebElement pandlvsBudger_selectStandartReport_FinancialReport;

	@FindBy(xpath = ".//span[normalize-space()='Trial Balance']")
	static WebElement trialBalance_selectStandartReport_FinancialReport;

	@FindBy(xpath = ".//button[contains(text(),'Select Standard Report')]")
	static WebElement selectStandartReport_FinancialReport;

	@FindBy(xpath = ".//*[@class='slds-grid']//input")
	static WebElement search_NSFR;

	@FindBy(xpath = ".//*[@class='slds-form-element']//*[@type='search']")
	static WebElement search_CashReceipt;

	@FindBy(xpath = ".//button[contains(text(),'Save & Run')]")
	static WebElement saveAndRun_NSFR;

	@FindBy(xpath = ".//*[@class='slds-modal__container']//*[contains(text(),'Save Report')]")
	static WebElement saveAndRunpopUp_NSFR;

	@FindBy(xpath = ".//*[@class='slds-modal__container']//input[@id='reportName']")
	static WebElement reportName_SaveAndRunPopup_NSFR;

	@FindBy(xpath = ".//*[@class='slds-modal__container']//input[@id='reportUniqueName']")
	static WebElement reportUniqueName_SaveAndRunPopup_NSFR;

	@FindBy(xpath = ".//*[@class='slds-modal__container']//button[contains(text(),'Save')]")
	static WebElement saveButton_SaveAndRunPopup_NSFR;

	@FindBy(xpath = "(.//*[@class='fields-panel-search hideTypeFilter']//button)[4]")
	static WebElement closeFieldPanelSearch;

	@FindBy(xpath = "(.//*[@data-tooltip='GL Account: GL Account Name']//following::button)[1]")
	static WebElement arrowMarkNextToGLAcountGLAccountName;

	@FindBy(xpath = ".//*[@class='dropdown__list']//li[@class='slds-dropdown__item addAsGroupDown']")
	static WebElement groupByThisField_NSFR_PreviewColumnOption;

	@FindBy(xpath = "//button[contains(@class,'slds-button slds-button_icon-border-filled ignore-click-table')]")
	static WebElement previewSectionColoumActionButton_NSFR;

	@FindBy(xpath = ".//*[@role='menuitem']/*[contains(text(),'Remove Column')]")
	static WebElement removeColumnButton_Under_previewSectionColoumActionButton_NSFR;

	@FindBy(xpath = ".//button[@id='undefined-list']")
	static WebElement filterOptionOperatorValueDropdown;

	@FindBy(xpath = ".//*[@class='slds-modal__container report-type-picker-container']//*[@id='modal-search-input']")
	static WebElement searchReportTypeTextBox;

	@FindBy(xpath = ".//*[@aria-describedby='_report_type_message' and contains(text(),'Transactions with GL Account')]")
	static WebElement chooseReport;

	@FindBy(xpath = ".//*[@aria-describedby='_report_type_message' and contains(text(),'Financial Cubes withorwithout Financial Cube Trans')]")
	static WebElement chooseReport_FinancialCubeswithorwithoutFinancialCubeTrans;

	@FindBy(xpath = ".//button[contains(text(),'Continue')]")
	static WebElement continueButton_ChooseReportTypePopup;

	@FindBy(xpath = ".//*[@role='tablist']//*[contains(text(),'Filters')]")
	static WebElement filtersOption;

	@FindBy(xpath = ".//input[@placeholder='Add filter...']")
	static WebElement addFilterTextBox;

	@FindBy(xpath = ".//*[contains(text(),'Accounting Period')]")
	static WebElement select_AccountingPeiod_Value;

	@FindBy(xpath = "(.//*[@class='slds-popover__body']//button)[1]")
	static WebElement operatorButton;

	@FindBy(xpath = ".//*[@role='menuitem']/*[contains(text(),'equals')]")
	static WebElement equalOption;

	@FindBy(xpath = ".//*[@class='slds-popover__body']//input[@class='slds-input']")
	static WebElement operatorValue;

	@FindBy(xpath = ".//*[@class='slds-popover__body']//button[contains(text(),'Apply')]")
	static WebElement applyButton;

	@FindBy(xpath = ".//*[contains(text(),'GL Account Type')]")
	static WebElement selectValueGLAccountType;

	@FindBy(xpath = ".//*[@class='fields-panel trigger']//*[contains(text(),'Fields')]/button")
	static WebElement fieldsPanelTrigger;

	@FindBy(xpath = ".//*[@class='slds-input']")
	static WebElement fieldSearchInput;

	@FindBy(xpath = ".//*[@title='Report Amount']")
	static WebElement selectResultFromFieldSearch;

	@FindBy(xpath = ".//*[@title='GL Account Type']")
	static WebElement selectResult_GLAccount_Type_FieldSearch;

	@FindBy(xpath = ".//*[@class='slds-button header-warning-refresh']")
	static WebElement refreshButton;

	@FindBy(xpath = "(.//*[@data-tooltip='Report Amount']//following::button)[1]")
	static WebElement arrowMarkNextToReportAmount;

	@FindBy(xpath = "(.//*[@data-tooltip='Opening Balance']//following::button)[1]")
	static WebElement arrowMarkNextToOpeningBalance;

	@FindBy(xpath = "(.//*[@data-tooltip='Current Period']//following::button)[1]")
	static WebElement arrowMarkNextToCurrentPeriod;

	@FindBy(xpath = "(.//*[@data-tooltip='Year To Date']//following::button)[1]")
	static WebElement arrowMarkNextToYearToDate;

	@FindBy(xpath = "(.//*[@data-tooltip='GL Account']//following::button)[1]")
	static WebElement arrowMarkGLAccount;

	@FindBy(xpath = ".//ul//*[contains(text(),'Summarize')]")
	static WebElement selectSummarizeOption;

	@FindBy(xpath = ".//*[@role='menuitemcheckbox']//*[@title='Sum']")
	static WebElement sumOptionFromSummarize;

	@FindBy(xpath = ".//*[contains(text(),'Choose Report Type')]")
	static WebElement chooseReportTypePopupDisplayed;

	@FindBy(xpath = "(.//a/*[contains(text(),'New Report')])[1]")
	static WebElement newReportButton;

	@FindBy(xpath = ".//*[@class='slds-media__body']//*[contains(text(),'Reports')]")
	static WebElement reportsPage;

	@FindBy(xpath = "//button[@name='Edit']")
	WebElement Edit;

	@FindBy(xpath = "(.//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Reports')])[5]")
	static WebElement selectReports;

	@FindBy(xpath = "//label[contains(text(),'Status')]")
	WebElement Status;

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

	@FindBy(xpath = ".//slot[@slot='primaryField']//lightning-formatted-text[contains(text(),'1000-Cash')]")
	static WebElement cash1000_Page;

	@FindBy(xpath = ".//button[contains(text(),'Clone')]")
	static WebElement cloneButton_cash1000;

	@FindBy(xpath = ".//*[@class='actionBody']//*[contains(text(),'New GL Account')]")
	static WebElement newGLAccountPopup;

	@FindBy(xpath = ".//*[@name='Name']")
	static WebElement name_NewGLAccount;

	@FindBy(xpath = "(.//*[@name='AcctSeed__Bank__c'])[3]")
	WebElement bankCreditCardAccount_CheckBox_NewGLAccount;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	static WebElement saveButton_NewGLAccount;

	@FindBy(xpath = "//a[@id='AcctSeed__GL_Account__c']//b[contains(text(),'GL Accounts')]")
	static WebElement SelectGLAccount;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Accounting Periods')]")
	static WebElement SelectAccountingPeriods;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Cash Receipts')]")
	static WebElement SelectCashReceipts;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Payables')]")
	static WebElement SelectPayables;

	@FindBy(xpath = "//input[@name='AcctSeed__Starting_Check_Number__c']")
	static WebElement CDB_checkno;

	@FindBy(xpath = "//input[contains(@name,'Name')]")
	static WebElement CDB_name;

	@FindBy(xpath = "//img[@title='Cash Disbursement Batches']")
	static WebElement CDBatches;

	@FindBy(xpath = "//input[@id='username']")
	static WebElement login_user_field;

	@FindBy(xpath = "//input[@id='password']")
	static WebElement login_pass_field;

	@FindBy(xpath = "//input[@id='Login']")
	static WebElement login_btn;

	@FindBy(xpath = ".//*[@class='slds-icon-waffle']")
	static WebElement SearchAppAndItemIcon;

	@FindBy(xpath = ".//*[@class='slds-size_medium']//*[@class='slds-input']")
	static WebElement SearchAppAndItemInputbox;

	@FindBy(xpath = "//div[@title='New']")
	static WebElement New;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	static WebElement Save;

	@FindBy(xpath = "//img[@title='Cash Disbursements']")
	static WebElement Cash_disbursements;

	@FindBy(xpath = "//input[@placeholder='Search Cash Disbursement Batches...']")
	static WebElement CDB_select;

	@FindBy(xpath = "//force-record-layout-row[1]//force-record-layout-item[2]//lightning-combobox[1]//input[1]")
	static WebElement CD_type;

	@FindBy(xpath = "//input[@name='AcctSeed__Amount__c']")
	static WebElement CD_amount;

	@FindBy(xpath = "//input[contains(@placeholder,'Search Accounts...')]")
	static WebElement CD_vendor;

	@FindBy(xpath = "((.//force-record-layout-section)[3]//input)[5]")
	static WebElement CFCategory;

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

	@FindBy(xpath = "(//input[@placeholder='Search GL Accounts...'])[1]")
	static WebElement CD_Bankaccount;

	@FindBy(xpath = ".//*[@placeholder='Search Accounting Periods...']")
	static WebElement accountingPeriod_FinancialReport;

	@FindBy(xpath = ".//*[@role='listitem']//*[contains(text(),'Posted')]")
	static WebElement newCashDisbursementName_StatusConfirmation_Posted;

	@FindBy(xpath = ".//*[@slot='primaryField']/lightning-formatted-text")
	static WebElement newCashDisbursementName;

	@FindBy(xpath = ".//*[@title='Remove selected option']")
	static WebElement removeSelectedAccountingPeriod_CashFlow_FinancialReport;

	@FindBy(xpath = ".//*[@data-jest='startingAccountingPeriod']//input")
	static WebElement AccountingPeriod_CashFlow_FinancialReport;

	@FindBy(xpath = "//span[@class='slds-listbox__option-meta slds-listbox__option-meta_entity']")
	static WebElement selectAccountingPeriod_CashFlow_FinancialReport;

	@FindBy(xpath = "//button[.='Post']")
	static WebElement Post;

	@FindBy(xpath = ".//input[@value='Post']")
	static WebElement Post_final;

	static String refreshButtonXpath = ".//*[@class='slds-button header-warning-refresh']";

	static String saveAndRun_NSFRxpath = ".//button[contains(text(),'Save & Run')]";

	static String saveAndRunpopUp_NSFRxpath = ".//*[@class='slds-modal__container']//*[contains(text(),'Save Report')]";

	static String reportName_SaveAndRunPopup_NSFRxpath = ".//*[@class='slds-modal__container']//input[@id='reportName']";

	static String reportUniqueName_SaveAndRunPopup_NSFRxpath = ".//*[@class='slds-modal__container']//input[@id='reportUniqueName']";

	static String saveButton_SaveAndRunPopup_NSFRxpath = ".//*[@class='slds-modal__container']//button[contains(text(),'Save')]";

	/**
	 * @author Wisefinch Menaka
	 * @see This is to perform login action
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @return
	 * @throws Exception
	 */
	public static BankingLedgerPage LoginToWebpage(int threadID, List<String> tempList, String pathLocation)
			throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		System.out.println("********** LoginToWebpage");
		String username = null, pass_login = null;
		username = reusableComponents.getPropValues("username");
		pass_login = reusableComponents.getPropValues("password");
		try {
			ReusableComponents.sendKey(login_user_field, username, "User Name");
			ReusableComponents.sendKey(login_pass_field, pass_login, "Password");
			ReusableComponents.clickElement(login_btn, "Login Button");
			ReusableComponents.wait(10000);
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to login. " + e.getMessage(), browser, pathLocation + "\\" + testcasemethod,
					true);
		}
		return new BankingLedgerPage(browser);
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
			String pathLocation, String appNameToSearch, WebElement selectAppXpath) throws Exception {
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

	/***
	 * @author Wisefinch Created By : Lakshman
	 * @see To create new payables and post
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 * 
	 ***/
	public synchronized static BankingLedgerPage createPayables(int threadID, List<String> tempList,
			String pathLocation) throws IOException, AWTException, throwNewException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			String status_p = reusableComponents.getPropValues(testCaseNumber + "_postingstatus");
			String pref = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_ReferanceValue";
			String period = currentAccountingPeriodForTheTestCase;
			String account_name = newAccountname;

			ReusableComponents.wait(3200);
			navigateToAccountingHomePage();

			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Payables", SelectPayables);
			ReusableComponents.wait(5000);

			ReusableComponents.clickElement(New, "Click New Button");
			ReusableComponents.wait(5000);
			ReusableComponents.scrollInToElementJavaScript(browser, Payee_Reference);
			ReusableComponents.sendKey(Payee_Reference, pref, "Payee Reference");
			ReusableComponents.sendKey(Vendor, account_name, "Pass value to vendor");
			ReusableComponents.wait(5500);
			WebElement Vendor_click = browser
					.findElement(By.xpath("//lightning-base-combobox-formatted-text[@title='" + account_name + "']"));
			ReusableComponents.clickElement(Vendor_click, "Select vendor type");
			ReusableComponents.selectAccountingPeriod(Period_input, period, browser);

			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"Necessary details are provided to create payables", browser, pathLocation + "\\" + testcasemethod,
					false);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
					pathLocation + "\\" + testcasemethod, true);

			ReusableComponents.clickElement(Save, "Click on save button");
			ReusableComponents.wait(5500);
			browser.switchTo().defaultContent();

			// --> Create line in payables and post

		} catch (throwNewException e) {

			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception during payables creation" + e.getMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

		try {
			payablesCreation_LineCreationAndPost(threadID, tempList, pathLocation);

		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception during payables line creation" + e.getMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

		navigateToAccountingHomePage();

		return new BankingLedgerPage(browser);
	}

	/***
	 * Created By : Lakshman
	 * 
	 * @see After creating a payable , create line inside payable and post
	 * 
	 * @throws IOExceptionl
	 * @throws AWTException
	 * 
	 ***/
	public synchronized static BankingLedgerPage payablesCreation_LineCreationAndPost(int threadID,
			List<String> tempList, String pathLocation) throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			String Amount = reusableComponents.getPropValues(testCaseNumber + "_PayablesLine_Amount");
			String expense_acc_name = reusableComponents.getPropValues(testCaseNumber + "_bank");

			/*
			 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
			 * "screen grab of created payable page", browser, pathLocation + "\\" +
			 * testcasemethod, true);
			 */
			ReusableComponents.wait(5500);

			ReusableComponents.scrollDownUsingPageDown(browser);
			ReusableComponents.scrollDownUsingPageDown(browser);

			ReusableComponents.wait(5500);

			if (ReusableComponents.isElementPresent(New_PLine)) {

				ReusableComponents.wait(4200);

				New_PLine.click();
				/*
				 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
				 * "New Payable Line button is present", browser, pathLocation + "\\" +
				 * testcasemethod, false);
				 */
				ReusableComponents.wait(6500);

				if (ReusableComponents.isElementPresent(Unit_cost)) {

					ReusableComponents.wait(5200);
					Unit_cost.sendKeys(Amount);
					/*
					 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					 * "Unit cost field is present", browser, pathLocation + "\\" + testcasemethod,
					 * false);
					 */
					ReusableComponents.wait(5500);

					if (ReusableComponents.isElementPresent(Expense_GL_Account)) {
						JavascriptExecutor js = (JavascriptExecutor) browser;
						js.executeScript("arguments[0].scrollIntoView();", Expense_GL_Account);

						ReusableComponents.wait(3200);
						Expense_GL_Account.sendKeys(expense_acc_name);
						/*
						 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						 * "Expense GL Account searchbox is present", browser, pathLocation + "\\" +
						 * testcasemethod, false);
						 */
						ReusableComponents.wait(5500);

						WebElement Exp_gla_click = browser
								.findElement(By.xpath("//lightning-base-combobox-formatted-text[contains(@title,'"
										+ expense_acc_name + "')]"));
//						List<WebElement> dropdownelement_gl = browser.findElements(By.xpath("//lightning-base-combobox-formatted-text[contains(@title,'" + expense_acc_name + "')]"));
//						int j = dropdownelement_gl.size();

//						System.out.println(j + " is the element count");

						System.out.println("Expense gl account selected");
						ReusableComponents.wait(5200);
						Exp_gla_click.click();
//						dropdownelement_gl.get(j-1).click();
						ReusableComponents.wait(3200);
						System.out.println("action called");
						ReusableComponents.wait(5200);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Amount and Expence GL account details provided", browser,
								pathLocation + "\\" + testcasemethod, false);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

						if (ReusableComponents.isElementPresent(Save)) {

							/*
							 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
							 * "screen grab of New Payable line creation page", browser, pathLocation + "\\"
							 * + testcasemethod, true);
							 */
							ReusableComponents.wait(5200);
							Save.click();
							/*
							 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							 * "Save button is present", browser, pathLocation + "\\" + testcasemethod,
							 * false);
							 */
							ReusableComponents.wait(5500);

							if (ReusableComponents.isElementPresent(Post)) {

								ReusableComponents.wait(3200);
								Post.click();
								/*
								 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								 * "Post tab is present", browser, pathLocation + "\\" + testcasemethod, false);
								 */
								ReusableComponents.wait(6500);

								browser.switchTo().frame(0);

								if (ReusableComponents.isElementPresent(Post_final)) {

									/*
									 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
									 * "screen grab of Payable post page", browser, pathLocation + "\\" +
									 * testcasemethod, true);
									 */
									ReusableComponents.wait(4200);
									Post_final.click();
									/*
									 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
									 * "Post final button is present", browser, pathLocation + "\\" +
									 * testcasemethod, false);
									 */
									ReusableComponents.wait(5500);
									testDataNewPayableName = ReusableComponents.getText(nameOfCreatedBilling,
											"Get new payables name");

									newPayableStatus = ReusableComponents.isDisplayed(checkStatus,
											"Verify new payable displayed after performing post");
									if (newPayableStatus) {

										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"New payable " + testDataNewPayableName + " status changed to posted",
												browser, pathLocation + "\\" + testcasemethod, false);

										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);
									} else {
										newPayableStatus = false;
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"New payable " + testDataNewPayableName
														+ " status is not changed to posted",
												browser, pathLocation + "\\" + testcasemethod, true);
									}

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Post final button is NOT present", browser,
											pathLocation + "\\" + testcasemethod, true);
								}

								browser.switchTo().defaultContent();

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"Post tab is NOT present", browser, pathLocation + "\\" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"Save button is NOT present", browser, pathLocation + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Expense GL Account searchbox is NOT present", browser,
								pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Unit cost field is NOT present",
							browser, pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"New Payable Line button is NOT present", browser, pathLocation + "\\" + testcasemethod, true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exceptions when trying to create payables" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

		navigateToAccountingHomePage();

		return new BankingLedgerPage(browser);
	}

	/***
	 * @author Wisefinch Created By : Lakshman
	 * @see Create new billing
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 * 
	 ***/
	public synchronized static BankingLedgerPage createNewBilling(int threadID, List<String> tempList,
			String pathLocation) throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			navigateToAccountingHomePage();

			String account_name = newAccountname;
			String post_status = reusableComponents.getPropValues(testCaseNumber + "_" + "postingstatus");
			String accountingPeriod = currentAccountingPeriodForTheTestCase;

			List<WebElement> f = browser.findElements(By.tagName("frame"));
			int i = f.size();
			System.out.println(i + " is the frame count");

			browser.switchTo().frame(0);

			ReusableComponents.wait(8200);

			if (ReusableComponents.isElementPresent(Billing_tab)) {

				ReusableComponents.wait(3200);
				Billing_tab.click();
				/*
				 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
				 * "Billing tab is present", browser, pathLocation + "\\" + testcasemethod,
				 * false);
				 */
				ReusableComponents.wait(5500);
				/*
				 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
				 * "screen grab of Billing page", browser, pathLocation + "\\" + testcasemethod,
				 * true);
				 */

				if (ReusableComponents.isElementPresent(New)) {

					ReusableComponents.wait(3200);
					New.click();
					/*
					 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					 * "Billing New button is present", browser, pathLocation + "\\" +
					 * testcasemethod, false);
					 */
					ReusableComponents.wait(5500);

					if (ReusableComponents.isElementPresent(Posting_status)) {

						ReusableComponents.wait(3200);
						Posting_status.click();
						/*
						 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						 * "Billing Posting status selectbox is present", browser, pathLocation + "\\" +
						 * testcasemethod, false);
						 */
						ReusableComponents.wait(5500);

						String P_stat = "//span[@title='" + post_status + "']";

						WebElement selecttype = browser.findElement(By.xpath(P_stat));
						new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(selecttype))
								.click();
						ReusableComponents.wait(5500);

						if (ReusableComponents.isElementPresent(Customer)) {

							ReusableComponents.wait(3200);
							Customer.sendKeys(account_name);
							/*
							 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							 * "Billing Customer searchbox is present", browser, pathLocation + "\\" +
							 * testcasemethod, false);
							 */
							ReusableComponents.wait(10000);

							String xpath = "//lightning-base-combobox-formatted-text[@title='" + account_name + "']";
							System.out.println("********* xpath value " + xpath);
							WebElement Vendor_click = browser.findElement(By.xpath(xpath));
							List<WebElement> dropdownelement = browser.findElements(By.xpath(xpath));
							int j = dropdownelement.size();

							System.out.println(j + " is the element count");

							if (ReusableComponents.isElementPresent(Vendor_click)) {

								System.out.println("Customer selected");
								ReusableComponents.wait(5200);
								Vendor_click.click();
								ReusableComponents.wait(5200);
								System.out.println("action called");
								ReusableComponents.wait(5200);

							}

							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
									"New Account values are given", browser, pathLocation + "\\" + testcasemethod,
									true);

							ReusableComponents.scrollInToElementJavaScript(browser, accountingPeriod_Billing);
							ReusableComponents.selectAccountingPeriod(accountingPeriod_Billing, accountingPeriod,
									browser);

							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
									"Accounting period details are given to create new billing", browser,
									pathLocation + "\\" + testcasemethod, true);

							if (ReusableComponents.isElementPresent(Save)) {

								ReusableComponents.wait(3200);
								Save.click();
								/*
								 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								 * "Save button is present", browser, pathLocation + "\\" + testcasemethod,
								 * false);
								 */
								ReusableComponents.wait(5500);

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"Save button is NOT present", browser, pathLocation + "\\" + testcasemethod,
										true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"Billing Customer searchbox is NOT present", browser,
									pathLocation + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Billing Posting status selectbox is NOT present", browser,
								pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Billing New button is NOT present", browser, pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing tab is NOT present", browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			browser.switchTo().defaultContent();

			// Add billing line and post the billing

			createBillingLineAndPost(threadID, tempList, pathLocation);

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception during billing creation" + e.getMessage(), browser, pathLocation + "\\" + testcasemethod,
					true);

		}

		navigateToAccountingHomePage();

		return new BankingLedgerPage(browser);

	}

	/***
	 * 
	 * @author Wisefinch Created By : Lakshman
	 * @see Create line inside billing and post
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 * 
	 ***/
	public synchronized static BankingLedgerPage createBillingLineAndPost(int threadID, List<String> tempList,
			String pathLocation) throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			String price = reusableComponents.getPropValues(testCaseNumber + "_unitprice");
			String quantity = reusableComponents.getPropValues(testCaseNumber + "_quantity");

			/*
			 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
			 * "screen grab of created billing page", browser, pathLocation + "\\" +
			 * testcasemethod, true);
			 */
			ReusableComponents.wait(4200);

			ReusableComponents.scrollDownUsingPageDown(browser);
			ReusableComponents.wait(2000);
			ReusableComponents.scrollDownUsingPageDown(browser);
			ReusableComponents.wait(2000);
			ReusableComponents.scrollDownUsingPageDown(browser);
			ReusableComponents.wait(2000);

			if (ReusableComponents.isElementPresent(New_Bline)) {

				ReusableComponents.wait(3200);
				New_Bline.click();
				/*
				 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
				 * "Billing line New button is present", browser, pathLocation + "\\" +
				 * testcasemethod, false);
				 */
				ReusableComponents.wait(5500);

				if (ReusableComponents.isElementPresent(Date)) {

					ReusableComponents.wait(3200);
					/*
					 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					 * "Billing line Date field is present", browser, pathLocation + "\\" +
					 * testcasemethod, false);
					 */
					ReusableComponents.wait(5500);

					if (ReusableComponents.isElementPresent(Quantity)) {

						ReusableComponents.wait(3200);
						Quantity.clear();
						Quantity.sendKeys(quantity);
						/*
						 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						 * "Billing line Quantity field is present", browser, pathLocation + "\\" +
						 * testcasemethod, false);
						 */
						ReusableComponents.wait(5500);

						if (ReusableComponents.isElementPresent(Unit_price)) {

							ReusableComponents.wait(3200);
							Unit_price.clear();
							Unit_price.sendKeys(price);
							/*
							 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							 * "Billing line Quantity field is present", browser, pathLocation + "\\" +
							 * testcasemethod, false);
							 */
							ReusableComponents.wait(5500);

							ReusableComponents.reportPass(threadID, tempList, testcasemethod,
									"Billing line Details provided", browser, pathLocation + "\\" + testcasemethod,
									false);
							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
									pathLocation + "\\" + testcasemethod, true);

							if (ReusableComponents.isElementPresent(Save)) {

								ReusableComponents.wait(3200);
								Save.click();
								/*
								 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								 * "Billing line save button is present", browser, pathLocation + "\\" +
								 * testcasemethod, false);
								 */
								ReusableComponents.wait(5500);

								if (ReusableComponents.isElementPresent(Post)) {

									ReusableComponents.wait(3200);
									Post.click();
									/*
									 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
									 * "Billing line Post tab is present", browser, pathLocation + "\\" +
									 * testcasemethod, false);
									 */
									ReusableComponents.wait(10000);

									browser.switchTo().frame(0);

									if (ReusableComponents.isElementPresent(Post_final_Billing)) {

										ReusableComponents.wait(3200);
										Post_final.click();
										/*
										 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										 * "Billing line Post button is present", browser, pathLocation + "\\" +
										 * testcasemethod, false);
										 */

										ReusableComponents.wait(5500);
										testDataNewBillingName = ReusableComponents.getText(nameOfCreatedBilling,
												"Get new billing name");

										Boolean newBillingStatus = ReusableComponents.isDisplayed(checkStatus,
												"Verify new billing status displayed after performing post");
										if (newBillingStatus) {
											testDataNewBillingCreated = true;

											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"New Billing " + testDataNewBillingName
															+ " status changed to posted",
													browser, pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"New Billing " + testDataNewBillingName
															+ " status is not changed to posted",
													browser, pathLocation + "\\" + testcasemethod, true);
										}

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Billing line Post button is NOT present", browser,
												pathLocation + "\\" + testcasemethod, true);
									}

									browser.switchTo().defaultContent();

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Billing line Post tab is NOT present", browser,
											pathLocation + "\\" + testcasemethod, true);
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"Billing line save button is NOT present", browser,
										pathLocation + "\\" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"Billing line Quantity field is NOT present", browser,
									pathLocation + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Billing line Quantity field is NOT present", browser,
								pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Billing line Date field is NOT present", browser, pathLocation + "\\" + testcasemethod,
							true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Billing line New button is NOT present", browser, pathLocation + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when creating billing line and post" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}

		return new BankingLedgerPage(browser);

	}

	/**
	 * @author Wisefinch Lakshman
	 * @see Create test data Cash receipt
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 */
	public synchronized BankingLedgerPage createCashReceipt(int threadID, List<String> tempList, String pathLocation)
			throws IOException, AWTException, throwNewException {

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
										ReusableComponents.wait(10500);

										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"New Cash Receipt created", browser,
												pathLocation + "\\" + testcasemethod, false);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);

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

			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception during cash receipt creation" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}

		navigateToAccountingHomePage();

		return new BankingLedgerPage(browser);

	}

	/***
	 * @author Wisefinch Lakshman
	 * @see To create cash disbursement batch
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * @throws throwNewException
	 * 
	 ***/
	public synchronized static BankingLedgerPage cashDisbursementBatch(int threadID, List<String> tempList,
			String pathLocation) throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			navigateToAccountingHomePage();

			String cdbname = reusableComponents.getPropValues(testCaseNumber + "_cdbname");
			String cdbcheckno = reusableComponents.getPropValues(testCaseNumber + "_cdbcheckno");
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

					/*
					 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					 * "screen grab of Cash Disbursement Batches page", browser, pathLocation + "\\"
					 * + testcasemethod, true);
					 */
					ReusableComponents.wait(5200);
					New.click();
					ReusableComponents.wait(5200);
					/*
					 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					 * "Cash Disbursement Batches New button is present", browser, pathLocation +
					 * "\\" + testcasemethod, false);
					 */

					if (ReusableComponents.isElementPresent(CDB_name)) {

						cdbName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_CDB";
						ReusableComponents.wait(5200);
						CDB_name.sendKeys(cdbName);
						ReusableComponents.wait(5200);
						/*
						 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						 * "Cash Disbursement Batches Name field is present", browser, pathLocation +
						 * "\\" + testcasemethod, false);
						 */

						if (ReusableComponents.isElementPresent(CDB_checkno)) {

							/*
							 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							 * "Cash Disbursement Batches Check no field is present", browser, pathLocation
							 * + "\\" + testcasemethod, false);
							 */
							ReusableComponents.wait(5200);
							CDB_checkno.sendKeys(cdbcheckno);
							ReusableComponents.wait(5200);

							/*
							 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
							 * "screen grab of Cash Disbursement creation page", browser, pathLocation +
							 * "\\" + testcasemethod, true);
							 */
							ReusableComponents.wait(5200);

							if (ReusableComponents.isElementPresent(Save)) {

								/*
								 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								 * "Save button is present", browser, pathLocation + "\\" + testcasemethod,
								 * false);
								 */
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
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {

			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception during cash disbursement batch creation" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}

		navigateToAccountingHomePage();

		return new BankingLedgerPage(browser);

	}

	/**
	 * @author Wisefinch Menaka
	 * @see Find 1000-Cash GL type under GL Accounts section and clone it. Then post
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param appNameToSearch
	 * @param selectAppXpath
	 * @throws Exception
	 */
	public static BankingLedgerPage cloneGLAccount(int threadID, List<String> tempList, String pathLocation)
			throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			navigateToAccountingHomePage();

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

			if (newGLAccountPopup.isDisplayed() == true) {
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
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"New GL Account " + newGLName + " is displayed", browser,
							pathLocation + "\\" + testcasemethod, true);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
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

			navigateToAccountingHomePage();

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Unable to select app from select search app section" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

		navigateToAccountingHomePage();

		return new BankingLedgerPage(browser);
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
	 * @author Wisefinch Created By : Lakshman
	 * @see Create cash disbursement
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public synchronized static BankingLedgerPage CashDisbursement(int threadID, List<String> tempList,
			String pathLocation) throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			// ==>Case cash disbursement batch creation method

			navigateToAccountingHomePage();

			cashDisbursementBatch(threadID, tempList, pathLocation);
			cloneGLAccount(threadID, tempList, pathLocation);

			navigateToAccountingHomePage();

			String CDtype = reusableComponents.getPropValues(testCaseNumber + "_cdtype");
			String CD_Amount = reusableComponents.getPropValues(testCaseNumber + "_amount");
			String account_namefull;
			if (newAccountname == null) {

				account_namefull = reusableComponents.getPropValues(testCaseNumber + "_accname");
			} else {
				account_namefull = newAccountname;
			}
			accountingPeriod = currentAccountingPeriodForTheTestCase;

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
				/*
				 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
				 * "screen grab of Cash Disbursement page", browser, pathLocation + "\\" +
				 * testcasemethod, true);
				 */
				ReusableComponents.wait(5200);

				if (ReusableComponents.isElementPresent(New)) {

					/*
					 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					 * "Cash Disbursement New button is present", browser, pathLocation + "\\" +
					 * testcasemethod, false);
					 */
					ReusableComponents.wait(3200);
					New.click();
					ReusableComponents.wait(5200);

					if (ReusableComponents.isElementPresent(CDB_select)) {
						// cdbName = "20210918_171654_CDB";
						/*
						 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						 * "Cash Disbursement Batch searchbox is present", browser, pathLocation + "\\"
						 * + testcasemethod, false);
						 */
						ReusableComponents.wait(3200);
						CDB_select.sendKeys(cdbName);
						ReusableComponents.wait(5200);

						WebElement CDB_click = browser.findElement(
								By.xpath("//lightning-base-combobox-formatted-text[@title='" + cdbName + "']"));
						ReusableComponents.wait(5200);
						CDB_click.click();
						System.out.println("Cash disbursement batch selected");
						ReusableComponents.wait(5200);
						/*
						 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
						 * "Cash disbursement batch selected", browser, pathLocation + "\\" +
						 * testcasemethod, true);
						 */

						ReusableComponents.selectAccountingPeriod(accountingPeriod_FinancialReport, accountingPeriod,
								browser);
						/*
						 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
						 * "Accounting Period Selected", browser, pathLocation + "\\" + testcasemethod,
						 * true);
						 */

						if (ReusableComponents.isElementPresent(CD_type)) {

							/*
							 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							 * "Cash Disbursement Type selectbox is present", browser, pathLocation + "\\" +
							 * testcasemethod, false);
							 */
							ReusableComponents.wait(3200);
							CD_type.click();
							ReusableComponents.wait(5200);

							WebElement CD_Type = browser.findElement(By.xpath("//span[@title='" + CDtype + "']"));
							ReusableComponents.wait(5200);
							CD_Type.click();
							System.out.println("Cash disbursement type selected");
							ReusableComponents.wait(5200);

							if (ReusableComponents.isElementPresent(CD_amount)) {

								/*
								 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								 * "Cash Disbursement Amount field is present", browser, pathLocation + "\\" +
								 * testcasemethod, false);
								 */
								ReusableComponents.wait(3200);
								CD_amount.sendKeys(CD_Amount);
								ReusableComponents.wait(5200);

								WebElement element = browser
										.findElement(By.xpath("//span[normalize-space()='Payee Information']"));
								((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);",
										element);

								if (ReusableComponents.isElementPresent(CD_vendor)) {

									/*
									 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
									 * "Cash Disbursement Vendor searchbox is present", browser, pathLocation + "\\"
									 * + testcasemethod, false);
									 */
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

									// ReusableComponents.scrollDown_insidepopup_ByPGDN(browser,
									// cashDisbursementPopup);

									if (ReusableComponents.isElementPresent(CD_Bankaccount)) {
										// newGLName = "20210918_171601_GLAccount";
										/*
										 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										 * "Cash Disbursement Bank searchbox is present", browser, pathLocation + "\\" +
										 * testcasemethod, false);
										 */
										ReusableComponents.wait(3200);
										CD_Bankaccount.sendKeys(newGLName);
										ReusableComponents.wait(10000);

										WebElement CD_Bank = browser.findElement(
												By.xpath("//lightning-base-combobox-formatted-text[@title='" + newGLName
														+ "']"));
										ReusableComponents.wait(5200);
										CD_Bank.click();
										System.out.println("Cash disbursement bank selected");
										/*
										 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
										 * "Cash disbursement bank selected", browser, pathLocation + "\\" +
										 * testcasemethod, true);
										 */
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
											/*
											 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
											 * "Cash Flow Category Selected to have other than default value", browser,
											 * pathLocation + "\\" + testcasemethod, true);
											 */
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Unable to select Cash Flow Category", browser,
													pathLocation + "\\" + testcasemethod, true);
										}

										if (ReusableComponents.isElementPresent(Save)) {

											/*
											 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											 * "Cash Disbursement save button is present", browser, pathLocation + "\\"
											 * + testcasemethod, false);
											 */
											ReusableComponents.wait(3200);
											Save.click();
											ReusableComponents.wait(8200);
											cashDisbursementName = ReusableComponents.getText(newCashDisbursementName,
													"Get Cash disbursement Name");
											/*
											 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
											 * "New cash disbursement name : " + cashDisbursementName, browser,
											 * pathLocation + "\\" + testcasemethod, true);
											 */
											if (ReusableComponents.isElementPresent(Post)) {

												/*
												 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												 * "Cash Disbursement Post button is present", browser, pathLocation +
												 * "\\" + testcasemethod, false);
												 */
												ReusableComponents.wait(3200);
												Post.click();
												ReusableComponents.wait(10000);

												browser.switchTo().frame(0);

												if (ReusableComponents.isElementPresent(Post_final)) {

													/*
													 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													 * "Cash Disbursement Post finalise button is present", browser,
													 * pathLocation + "\\" + testcasemethod, false);
													 */
													ReusableComponents.wait(3200);
													Post_final.click();
													ReusableComponents.wait(10000);

													String cashDisbursementPage = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'"
															+ cashDisbursementName + "')]";
													if (browser.findElement(By.xpath(cashDisbursementPage))
															.isDisplayed() == true) {
														if (newCashDisbursementName_StatusConfirmation_Posted
																.isDisplayed()) {
															testDataNewDisbursement = true;
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

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {

			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception during cash disbursement creation " + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

		navigateToAccountingHomePage();

		return new BankingLedgerPage(browser);
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
	public synchronized CashFlowStatementPage closeAccountingPeriod(int threadID, List<String> tempList,
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
	 * @author Wisefinch Lakshman
	 * @see Close all the accounting period under given year
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public synchronized CashFlowStatementPage closeAccountingPeriodBasedOnYear(int threadID, List<String> tempList,
			String pathLocation) throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			String per_stat = reusableComponents.getPropValues(testCaseNumber + "_pstat");
			String last_period = null;
			ReusableComponents.wait(5200);

			navigateToAccountingHomePage();
			/*
			 * ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
			 * "screen grab of Accounting Home page", browser, pathLocation + "\\" +
			 * testcasemethod, true);
			 */
			ReusableComponents.wait(3200);

			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Accounting Periods",
					SelectAccountingPeriods);

			ReusableComponents.sendKey(searchTextBox_AccountPeriod, Integer.toString(previousYearClose),
					"Previous year accounting periods");
			ReusableComponents.sendkey_InputKey(searchTextBox_AccountPeriod, Keys.ENTER, "Pass Enter");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(3000);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"Before (Previous year close ) : screen grab of Accounting period year " + previousYearClose,
					browser, pathLocation + "\\" + testcasemethod, true);

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

												/*
												 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												 * "Save button is present", browser, pathLocation + "\\" +
												 * testcasemethod, false);
												 */
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

			browser.navigate().to(
					"https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");
			ReusableComponents.wait(5500);
			ReusableComponents.sendKey(searchTextBox_AccountPeriod, Integer.toString(previousYearClose),
					"Previous year accounting periods");
			ReusableComponents.sendkey_InputKey(searchTextBox_AccountPeriod, Keys.ENTER, "Pass Enter");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(3000);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"After (Previous year close ) : Screen grab of Accounting period year " + previousYearClose
							+ " after performing close",
					browser, pathLocation + "\\" + testcasemethod, true);
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);

		} catch (Exception e) {

			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception in closeAccountingPeriodBasedOnYear" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}

		return new CashFlowStatementPage(browser);

	}

	/**
	 * @author Wisefinch Menaka
	 * @see To create new native sales force balance sheet.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param reportName     --> Provide the native sales force report name to open
	 * @return
	 * @throws Exception
	 */
	public static BankingLedgerPage openNewNativeSalesForceBalanceSheet(int threadID, List<String> tempList,
			String pathLocation, String reportType) throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			// --> Select reports from search app
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Reports", selectReports);

			if (ReusableComponents.isDisplayed(reportsPage, "Report Page") == false) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Sales force balance sheet report page is not displayed", browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			// --> Click on new report button
			ReusableComponents.clickElement(newReportButton, "New Report Button");
			ReusableComponents.wait(7000);

			// --> Switching frame since the new report popup is inside frame
			try {
				ReusableComponents.switchToFrame(browser, 0);
				ReusableComponents.wait(5000);
			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception : Unable to perform switch frame, Page Choose report type popup", browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			// --> Search by passing report type name and choose it
			ReusableComponents.clickElement(searchReportTypeTextBox, "Click on Search report type text box");
			ReusableComponents.sendKey(searchReportTypeTextBox, reportType, "Search Report type text box");

			String xpath = ".//*[@aria-describedby='_report_type_message' and contains(text(),'" + reportType + "')]";
			WebElement reportToSelect = browser.findElement(By.xpath(xpath));

			ReusableComponents.clickElement(reportToSelect, reportType);
			ReusableComponents.clickElement(continueButton_ChooseReportTypePopup,
					"Continue button from Choose report type popup");

			ReusableComponents.wait(10000);

			// --> Verify new report page opened or not
			try {
				String newReportPageCheck = ".//*[@class='slds-badge dash-tag' and contains(text(),'" + reportType
						+ "')]";
				WebElement newReportPageCheck_element = browser.findElement(By.xpath(newReportPageCheck));

				if (ReusableComponents.isDisplayed(newReportPageCheck_element, "New Report Page") == false) {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"New report page is not displayed for the type " + reportType, browser,
							pathLocation + "\\" + testcasemethod, true);
				} else {

					ReusableComponents.reportPass(threadID, tempList, testcasemethod, reportType + " Report opened",
							browser, pathLocation + "\\" + testcasemethod, false);

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
							pathLocation + "\\" + testcasemethod, true);

				}

			} catch (Exception e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception : Error while trying to identify new report page ", browser,
						pathLocation + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception : Error During creation of new " + reportType + " sheet" + e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);

		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception : There is a error while lauching new report " + reportType + ". " + e.getMessage(),
					browser, pathLocation + "\\" + testcasemethod, true);

		}
		return new BankingLedgerPage(browser);

	}

	/**
	 * @author Wisefinch : Menaka
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param filterName     --> Name of the filter to select under New NSF report
	 * @param operator       --> operator value as text [code added to make it lower
	 *                       case inside method]
	 * @param filterValue    --> Corresponding value for filter
	 * @return
	 * @throws Exception
	 */
	public static BankingLedgerPage nsfr_selectFilter(int threadID, List<String> tempList, String pathLocation,
			String filterName, String operator, String filterValue) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			// --> Clicking filter text box
			ReusableComponents.clickElement(filtersOption, "Filters option");

			try {
				// --> Searching based on filterName variable value
				ReusableComponents.sendKey(addFilterTextBox, filterName, "Adding filter value as " + filterName);
				ReusableComponents.wait(1000);
				String filterNameXpath = "//span[@class='slds-text-title_bold' and contains(text(),'" + filterName
						+ "')]";
				// "//span[@class='slds-text-title_bold']";
				// ".//*[contains(text(),'" + filterName + "')]";
				System.out.println("************** cpath :" + filterNameXpath);
				WebElement filterName_element = browser.findElement(By.xpath(filterNameXpath));
				System.out.println("*********** is displayed : "
						+ ReusableComponents.isDisplayed(filterName_element, "Selected value"));

				if (ReusableComponents.isDisplayed(filterName_element, "Selected value") == true) {
					ReusableComponents.clickElement(filterName_element, "Click filtered option");
				} else {
					ReusableComponents.sendKey(addFilterTextBox, filterName, "Adding filter value as " + filterName);
					ReusableComponents.clickElement(addFilterTextBox, "Click filtered option");
					ReusableComponents.clickElement(filterName_element, "Click filtered option");

				}

			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception During selection of filters" + e.getMessage(), browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			try {

				// --> Selecting operator based on user input
				ReusableComponents.clickElement(filterOptionOperatorValueDropdown, "Click Operator Dropdown");

				String operatorXpath = ".//*[@class='picklistLabel' and contains(text(),'" + operator.toLowerCase()
						+ "')]";
				WebElement operator_element = browser.findElement(By.xpath(operatorXpath));

				if (ReusableComponents.isDisplayed(operator_element, "Operator element") == true) {
					ReusableComponents.clickElement(operator_element, "Click operator element");
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Operator drop down is not displayed", browser, pathLocation + "\\" + testcasemethod, true);
				}

			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception During selection of operator" + e.getMessage(), browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			try {
				// --> Passing corresponding value for operator
				ReusableComponents.sendKey(operatorValue, filterValue, "Adding values to the operator");

				List<WebElement> elementName = browser.findElements(By.tagName("iframe"));
				System.out.println("************ Number of elements " + elementName.size());
				// ReusableComponents.switchToFrame(browser,0);
				System.out.println("************ Switched frame");

				if (filterName.equalsIgnoreCase("Cube Type")) {
					String xpathToSelectForValue = ".//*[@class='slds-truncate']//*[contains(text(),'" + filterValue
							+ "')]";
					System.out.println("********** " + xpathToSelectForValue);
					WebElement valueElement = browser.findElement(By.xpath(xpathToSelectForValue));
					System.out.println(
							"********** is displayed " + ReusableComponents.isDisplayed(valueElement, "Value Element"));
					if (ReusableComponents.isDisplayed(valueElement, "Value Element") == true) {
						ReusableComponents.clickElement(valueElement, "Click on Value");
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Value of Cube Tupy filter is not displayed", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				}

				ReusableComponents.clickElement(applyButton, "Apply Button");
				ReusableComponents.wait(1000);

				// --> Code to check that filter added or not
				String addedFilterCheckXpath = ".//*[@class='sectionable-table-section']//*[@type='button']/*[contains(text(),'"
						+ filterName + "')]";

				// ".//*[@class='sectionable-table-section']//*[contains(text(),'"+ filterName +
				// "')]";
				System.out.println("*********** addedFilterCheckXpath : " + addedFilterCheckXpath);
				WebElement addedFilterCheckXpath_element = browser.findElement(By.xpath(addedFilterCheckXpath));
				System.out.println("*********** is displayed " + addedFilterCheckXpath_element.isDisplayed());
				if (ReusableComponents.isDisplayed(addedFilterCheckXpath_element,
						"Cross checking added filter " + filterName) == true) {

					System.out.println("************ addedFilterCheckXpath_element.getText() : "
							+ addedFilterCheckXpath_element.getText());
					System.out.println("************                              filterName : " + filterName);
					if (addedFilterCheckXpath_element.getText().equalsIgnoreCase(filterName)) {

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								filterName + " is added successfully", browser, pathLocation + "\\" + testcasemethod,
								false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, filterName + " is not added",
								browser, pathLocation + "\\" + testcasemethod, true);
					}
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, filterName + " is not added",
							browser, pathLocation + "\\" + testcasemethod, true);
				}

			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception while cross checking added filter" + e.getMessage(), browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
			if (refreshButtonElement.size() != 0) {
				WebElement refreshButton = refreshButtonElement.get(0);
				if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
					ReusableComponents.clickElement(refreshButton, "refresh button");
					ReusableComponents.wait(3000);
				}
			}

		} catch (

		throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception : Error During filter selection under new SF report" + e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);

		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception : Error During filter selection under new SF report" + e.getMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}
		return new BankingLedgerPage(browser);

	}

	/**
	 * @author Wisefinch Menaka
	 * @see After opening NSFR , There might be some colums present under preview
	 *      section. Call this method to remove all those columns.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @return
	 * @throws Exception
	 */
	public static BankingLedgerPage nsfr_removeAlltheColumnPresentUnderPreviewSection(int threadID,
			List<String> tempList, String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		List<WebElement> removeColumn;
		int removeColumnSize;
		try {

			removeColumn = browser.findElements(By.xpath(
					"//button[contains(@class,'slds-button slds-button_icon-border-filled ignore-click-table')]"));
			removeColumnSize = removeColumn.size();
			System.out.println("********* removeColumnSize " + removeColumnSize);
			if (removeColumnSize != 0) {
				for (int i = 0; i <= removeColumnSize; i++) {
					ReusableComponents.clickElement(removeColumn.get(0), "Action Button Of Preview Section Unser NSFR");
					ReusableComponents.wait(2000);
					ReusableComponents.clickElement(removeColumnButton_Under_previewSectionColoumActionButton_NSFR,
							"Click Remove Column");
					ReusableComponents.wait(2000);

					List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
					if (refreshButtonElement.size() != 0) {
						WebElement refreshButton = refreshButtonElement.get(0);
						if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
							ReusableComponents.clickElement(refreshButton, "refresh button");
							ReusableComponents.wait(3000);
						}
					}

					removeColumn.clear();
					removeColumn = browser.findElements(By.xpath(
							"//button[contains(@class,'slds-button slds-button_icon-border-filled ignore-click-table')]"));
					removeColumnSize = removeColumn.size();
					System.out.println("********* removeColumnSize " + removeColumnSize);

					if (removeColumnSize == 0) {
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
								"All the columns are removed from preview", browser,
								pathLocation + "\\" + testcasemethod, true);
						break;
					}

				}
			}

		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception : Unable to remove all columns from preview section" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * @author Wisefinch : Menaka
	 * @see To add columns to preview section.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @param fieldValueToSearch --> Pass the field name that should get added to
	 *                           the preview section.
	 * @return
	 * @throws Exception
	 */

	public static BankingLedgerPage nsfr_addValuesFromFieldSearchToPreviewSection(int threadID, List<String> tempList,
			String pathLocation, String fieldValueToSearch) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		String searchFieldsXpath = ".//*[contains(@title,'" + fieldValueToSearch + "')]";
		try {

			ReusableComponents.clickElement(fieldsPanelTrigger, "Field Panel Trigger");
			ReusableComponents.sendKey(fieldSearchInput, fieldValueToSearch, "Adding values as Report Amount");
			ReusableComponents.wait(3000);

			try {

				// String GLAccountGLAccountName = ".//*[contains(@title,'GL Account: GL Account
				// Name')]";
				// String GLAccountGLAccountName =
				// ".//*[contains(@title,'"+fieldValueToSearch+"')]";
				System.out.println("********** containsTitleXpath : " + searchFieldsXpath);
				List<WebElement> containsTitleXpathDirect1 = browser.findElements(By.xpath(searchFieldsXpath));
				System.out.println("************ Number of elements containsTitleXpathDirect1 "
						+ containsTitleXpathDirect1.size());
				// ReusableComponents.switchToFrame(browser,0);
				// System.out.println("************ Switched frame");

				/*
				 * String GLAccountGLAccountName =
				 * "(.//*[@class='draggable']//*[contains(@title,'GL Account: GL Account Name')]/preceding::button[@tabindex='-1'])[3]"
				 * ; System.out.println("********** draggableXpath : "+GLAccountGLAccountName);
				 * List<WebElement> draggableXpathDirect1 =
				 * browser.findElements(By.xpath(GLAccountGLAccountName));
				 * System.out.println("************ Number of elements draggableXpathDirect "
				 * +draggableXpathDirect1.size());
				 * //ReusableComponents.switchToFrame(browser,0);
				 * //System.out.println("************ Switched frame");
				 */

				if (containsTitleXpathDirect1.size() != 0) {

					WebElement dragableElement = containsTitleXpathDirect1.get(0);
					System.out.println("********** dragableElement "
							+ ReusableComponents.isDisplayed(dragableElement, "Just check"));

					ReusableComponents.clickElement(dragableElement, "Click on result");

					// String insideLoopGLAccountGLAccountName = ".//*[contains(@title,'GL Account:
					// GL Account Name')]";
					// String insideLoopGLAccountGLAccountName =
					// ".//*[contains(@title,'"+fieldValueToSearch+"')]";

					WebElement insideLoopdragableElement = browser.findElement(By.xpath(searchFieldsXpath));
					System.out.println("********** is displayed : " + insideLoopdragableElement.isDisplayed());
					System.out.println("********** is enabled : " + insideLoopdragableElement.isEnabled());

					ReusableComponents.doubleClickElement(browser, insideLoopdragableElement,
							"Select " + fieldValueToSearch + " from filter");
					ReusableComponents.wait(5000);

					try {
						List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
						if (refreshButtonElement.size() != 0) {
							WebElement refreshButton = refreshButtonElement.get(0);
							if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
								ReusableComponents.clickElement(refreshButton, "refresh button");
								ReusableComponents.wait(3000);
							}
						}
					} catch (Exception e) {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Exception when trying click on refresh button after adding field value to preview panel"
										+ fieldValueToSearch,
								browser, pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Unable to identify filtered field" + fieldValueToSearch, browser,
							pathLocation + "\\" + testcasemethod, true);
				}

				ReusableComponents.wait(5000);
			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception : Unable to double click the field value " + fieldValueToSearch
								+ ". Following error occured " + e.getStackTrace(),
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			try {
				String selectedFieldValueinPreviewSection = "(.//*[@data-tooltip='" + fieldValueToSearch + "'])[1]";
				WebElement selectedFieldValueinPreviewSection_Element = browser
						.findElement(By.xpath(selectedFieldValueinPreviewSection));

				if (ReusableComponents.isDisplayed(selectedFieldValueinPreviewSection_Element,
						"Check selected field in preview section") == true) {

					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Field " + fieldValueToSearch + " is added to preview section", browser,
							pathLocation + "\\" + testcasemethod, false);

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
							pathLocation + "\\" + testcasemethod, true);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Field " + fieldValueToSearch + " is not added to preview section", browser,
							pathLocation + "\\" + testcasemethod, true);
				}

			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception while adding " + fieldValueToSearch
								+ " field to preview section. Following error occured " + e.getStackTrace(),
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			try {
				WebElement closeFieldSearch = browser
						.findElement(By.xpath("(.//*[@class='fields-panel-search hideTypeFilter']//button)[4]"));
				System.out.println("********* closeFieldSearch " + closeFieldSearch.isEnabled());
				ReusableComponents.clickElement(closeFieldSearch, "Close Field Panel Search");
			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception : Unable close field search panel. Following error occured " + e.getStackTrace(),
						browser, pathLocation + "\\" + testcasemethod, true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(
					threadID, tempList, testcasemethod, "Exception while trying to add " + fieldValueToSearch
							+ " field to preview section" + e.getStackTrace(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * @author Wisefinch Lakshman
	 * @see Open the accounting period that passed in accountPeriodToOpen parameter
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @param accountPeriodToOpen --> Pass the accounting period to open . Example
	 *                            format 2020-12
	 * @return
	 * @throws Exception
	 */
	public synchronized BankingLedgerPage openAccountingPeriod(int threadID, List<String> tempList, String pathLocation,
			String accountPeriodToOpen) throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			navigateToAccountingHomePage();

			System.out.println("************ Current year open : ");

			String acc_period = accountPeriodToOpen;

			System.out.println("************ Current year open : " + acc_period);
			per_stat = "Open";

			String strArray[] = acc_period.split("-");
			String yearValue = strArray[0];
			int year = Integer.parseInt(strArray[0]);
			int month = Integer.parseInt(strArray[1]);

			Nextyear = year + 1;

			Nextyearopen(threadID, tempList, pathLocation);

			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Accounting Periods",
					SelectAccountingPeriods);

			ReusableComponents.wait(5200);
			ReusableComponents.sendKey(searchTextBox_AccountPeriod, acc_period, "Nextyear Year open");
			ReusableComponents.sendkey_InputKey(searchTextBox_AccountPeriod, Keys.ENTER, "Pass Enter");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(3000);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"Before (Current period open) : Screen grab of next Accounting period year", browser,
					pathLocation + "\\" + testcasemethod, true);
			ReusableComponents.wait(3200);

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

												/*
												 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												 * "Save button is present", browser, pathLocation + "\\" +
												 * testcasemethod, false);
												 */
												ReusableComponents.wait(7200);
												Save.click();
												ReusableComponents.wait(16500);

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

			browser.navigate().to(
					"https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");
			ReusableComponents.wait(3000);
			ReusableComponents.sendKey(searchTextBox_AccountPeriod, acc_period, "Nextyear Year open");
			ReusableComponents.sendkey_InputKey(searchTextBox_AccountPeriod, Keys.ENTER, "Pass Enter");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(3000);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"After (Current period open) : Screen grab of next Accounting period year", browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {

			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when openAccountingPeriod" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}

		return new BankingLedgerPage(browser);

	}

	/**
	 * @author Wisefinch Lakshman
	 * @see This basically open all the accounting period present in mentioned year
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public synchronized BankingLedgerPage Nextyearopen(int threadID, List<String> tempList, String pathLocation)
			throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			System.out.println("********** Next year open : " + Nextyear);
			String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			pathLocation = reusableComponents.pathBuilder(path);

			per_stat = "Open";

			ReusableComponents.wait(5200);

			navigateToAccountingHomePage();

			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Accounting Periods",
					SelectAccountingPeriods);
			ReusableComponents.wait(5500);
			listview.click();
			ReusableComponents.wait(5500);
			all_list.click();
			ReusableComponents.wait(5500);

			ReusableComponents.sendKey(searchTextBox_AccountPeriod, Integer.toString(Nextyear), "Nextyear Year open");
			ReusableComponents.sendkey_InputKey(searchTextBox_AccountPeriod, Keys.ENTER, "Pass Enter");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(listViewe_AccoutingPeriod, "Click Sort");
			ReusableComponents.wait(3000);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"Before (Next Year Open) : Screen grab of next Accounting period year", browser,
					pathLocation + "\\" + testcasemethod, true);

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

												/*
												 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												 * "Save button is present", browser, pathLocation + "\\" +
												 * testcasemethod, false);
												 */
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

			browser.navigate().to(
					"https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/o/AcctSeed__Accounting_Period__c/list?filterName=00B4W00000EQvefUAD");
			ReusableComponents.wait(5500);
			ReusableComponents.sendKey(searchTextBox_AccountPeriod, Integer.toString(Nextyear), "Nextyear Year open");
			ReusableComponents.sendkey_InputKey(searchTextBox_AccountPeriod, Keys.ENTER, "Pass Enter");
			ReusableComponents.wait(3000);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"After (Next Year Open) : Screen grab of next Accounting period year", browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {

			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when next year open" + e.getStackTrace(), browser, pathLocation + "\\" + testcasemethod,
					true);

		}

		return new BankingLedgerPage(browser);

	}

	/**
	 * @see Title: [BL] Verify that the Balance Sheet shows correct amounts for all
	 *      the Asset GL Accounts on period closing (not year-end)
	 * @author Wisefinch Menaka
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param appNameToSearch
	 * @param selectAppXpath
	 * @throws Exception
	 */
	public BankingLedgerPage test2703_BalanceSheetAmountGLAccountsPeriodClose(int threadID, List<String> tempList,
			String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLocation = reusableComponents.pathBuilder(path);

		testCaseNumber = "Testcase2703";
		currentAccountingPeriodForTheTestCase = reusableComponents
				.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");
		try {

			LoginToWebpage(threadID, tempList, pathLocation);

			// --> Test data creation
			testDataCreation(threadID, tempList, pathLocation);

			navigateToAccountingHomePage();

			// --> Close accounting period
			try {
				String accountingPeriodToClose = reusableComponents
						.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");
				closeAccountingPeriod(threadID, tempList, pathLocation, accountingPeriodToClose);
			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception when calling closeAccountingPeriod", browser, pathLocation + "\\" + testcasemethod,
						true);
			}

			// --> Previous end accounting period open

			try {
				String accountingPeriodToClose1 = reusableComponents
						.getPropValues(testCaseNumber + "_PreviousYear_YearEnd");
				openAccountingPeriod(threadID, tempList, pathLocation, accountingPeriodToClose1);
			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception when calling Currentperiodopen", browser, pathLocation + "\\" + testcasemethod,
						true);
			}

			// --> Launch new NSF report
			openNewNativeSalesForceBalanceSheet(threadID, tempList, pathLocation,
					"Financial Cubes withorwithout Financial Cube Trans");

			// --> Added filter values
			String endingAccountPeriod = reusableComponents.getPropValues(testCaseNumber + "_PreviousYear_YearEnd");

			nsfr_selectFilter(threadID, tempList, pathLocation, "Accounting Period: Accounting Period Name", "equal",
					endingAccountPeriod);
			nsfr_selectFilter(threadID, tempList, pathLocation, "GL Account Type", "equal", "Balance Sheet");
			nsfr_selectFilter(threadID, tempList, pathLocation, "Ledger Type", "equal", "Transactional");

			// -->Remove all the column present under NSF report preview section

			nsfr_removeAlltheColumnPresentUnderPreviewSection(threadID, tempList, pathLocation);

			// --> Add GL Account: GL Account Name from field to preview section
			nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation,
					"GL Account: GL Account Name");

			// --> Select group by for GL Account: GL Account Name
			ReusableComponents.clickElement(arrowMarkNextToGLAcountGLAccountName,
					"Click on arrow mark next to GL Account: GL account Name");
			ReusableComponents.wait(1000);
			ReusableComponents.clickElement(groupByThisField_NSFR_PreviewColumnOption, "Group by this field option");
			ReusableComponents.wait(2000);
			try {
				List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
				if (refreshButtonElement.size() != 0) {
					WebElement refreshButton = refreshButtonElement.get(0);
					if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
						ReusableComponents.clickElement(refreshButton, "refresh button");
						ReusableComponents.wait(3000);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"groupBy GL Account: GL Account Name column done", browser,
								pathLocation + "\\" + testcasemethod, false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Unable to click on refresh button after performing group", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception : Unable to click on refresh button after performing group" + e.toString(), browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			// --> Add Opening Balance from field to preview section
			nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation, "Opening Balance");

			// --> Select sum from summarize option
			ReusableComponents.clickElement(arrowMarkNextToOpeningBalance,
					"Click on arrow mark next to Opening balance");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(selectSummarizeOption, "Select summarize option");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(sumOptionFromSummarize, "Select sum option from Summarize option");
			ReusableComponents.wait(2000);

			try {
				List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
				if (refreshButtonElement.size() != 0) {
					WebElement refreshButton = refreshButtonElement.get(0);
					if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
						ReusableComponents.clickElement(refreshButton, "refresh button");
						ReusableComponents.wait(3000);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Sum option selected for Opening Balance", browser,
								pathLocation + "\\" + testcasemethod, false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Unable to click on refresh button after performing sum for opening balance", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception : Unable to click on refresh button after performing sum for opening balance "
								+ e.toString(),
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			// --> Add current period from field to preview section
			nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation, "Current Period");

			try {
				List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
				if (refreshButtonElement.size() != 0) {
					WebElement refreshButton = refreshButtonElement.get(0);
					if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
						ReusableComponents.clickElement(refreshButton, "refresh button");
						ReusableComponents.wait(3000);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Current Period added to preview section", browser,
								pathLocation + "\\" + testcasemethod, false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception when clicking on refresh button after adding current period to preview section "
								+ e.getMessage(),
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			// --> Add Opening Balance from field to preview section
			nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation, "Year To Date");

			try {
				List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
				if (refreshButtonElement.size() != 0) {
					WebElement refreshButton = refreshButtonElement.get(0);
					if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
						ReusableComponents.clickElement(refreshButton, "refresh button");
						ReusableComponents.wait(3000);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Year To Date added to preview section", browser, pathLocation + "\\" + testcasemethod,
								false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception when trying to click on refresh button after adding Year To Date to preview section "
								+ e.toString(),
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			// --> Save the report with new name
			ReusableComponents.clickElement(saveAndRun_NSFR, "Click Save and run");
			ReusableComponents.wait(5000);
			reportName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_ReportName";
			reportUniqueName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_ReportUniqueName";

			// --> Pass control A and delete input box value
			ReusableComponents.sendKey(reportName_SaveAndRunPopup_NSFR, Keys.CONTROL + "A" + Keys.DELETE, "Select All");
			ReusableComponents.sendKey(reportName_SaveAndRunPopup_NSFR, reportName, "Provide Report Name");
			/*
			 * ReusableComponents.sendKey(reportUniqueName_SaveAndRunPopup_NSFR,
			 * Keys.CONTROL+"A"+Keys.DELETE, "Select All");
			 * ReusableComponents.sendKey(reportUniqueName_SaveAndRunPopup_NSFR,
			 * reportUniqueName, "Provide Report Unique Name");
			 */
			ReusableComponents.clickElement(saveButton_SaveAndRunPopup_NSFR, "Click Save Button");
			ReusableComponents.wait(10000);
			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"New NSFR with type Financial Cubes withorwithout Financial Cube Trans is created", browser,
					pathLocation + "\\" + testcasemethod, false);

			// --> Verify created report listed under report page, and add the URL to the
			// extend report
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Reports", selectReports);
			ReusableComponents.sendKey(search_NSFR, reportName, "Search Report Name");
			ReusableComponents.wait(2000);
			String reportList = ".//a[@title='" + reportName + "']/parent::*";
			System.out.println("********** report List " + reportList);
			List<WebElement> newReports = browser.findElements(By.xpath(reportList));
			System.out.println("********** newReports " + newReports.size());
			if (newReports.size() != 0) {
				String report = ".//a[@title='" + reportName + "']/parent::*";
				System.out.println("********** report List " + report);
				WebElement newReport = browser.findElement(By.xpath(report));
				ReusableComponents.clickUsingJavaScript(browser, newReport, "report");
				ReusableComponents.wait(5000);
				nSFReportURL = browser.getCurrentUrl();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"New NSFR with type Financial Cubes withorwithout Financial Cube Trans is created. And the link as follows : "
								+ nSFReportURL,
						browser, pathLocation + "\\" + testcasemethod, false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLocation + "\\" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "No New report created", browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			// Run Financial Report
			String financialReportsURL = reusableComponents.getPropValues("FinancialReports");
			browser.get(financialReportsURL);
			// Browser.get is used here since there are issue in launching financial report
			// from search app. Once the issue resolved we can comment it and unccomment
			// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
			// Reports",
			ReusableComponents.wait(5000);

			ReusableComponents.wait(5000);
			ReusableComponents.clickElement(selectStandartReport_FinancialReport, "Click Select standard reportd");
			ReusableComponents.wait(5000);
			ReusableComponents.clickElement(balanceSheet_selectStandartReport_FinancialReport,
					"Click Select Balance Sheet");
			ReusableComponents.wait(5000);

			// As per test case we have to user previous accounting period, so we are taking
			startingAccountPeriod = reusableComponents
					.getPropValues(testCaseNumber + "_PreviousYear_StartingAccountPeriod");
			endingAccountPeriod = reusableComponents
					.getPropValues(testCaseNumber + "_PreviousYear_EndingAccountPeriod");

			ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
					"Clear button of starting account period");
			ReusableComponents.sendKey(startingAccoutPeriod_FinancialReport, startingAccountPeriod,
					"Starting Account period");
			ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport, "Starting account period input box");
			ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select Starting account period");

			ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport_Clear,
					"Clear button of ending account period");
			ReusableComponents.sendKey(endingAccoutPeriod_FinancialReport, endingAccountPeriod,
					"Ending Account period");
			ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport, "ending account period input box");
			ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select ending account period");
			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"Accounting period start and ending period given", browser, " ", false);

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"With the assumption Suppress Zero Amount Rows check box will be always selected", browser,
					pathLocation + "\\" + testcasemethod, true);

			ReusableComponents.scrollDown(browser, 500);
			// --> Click on run button and get new record URL

			List<WebElement> recordsList = browser
					.findElements(By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
			System.out.println("************ Number of elements " + recordsList.size());

			if (recordsList.size() != 0) {
				String oldRecordName = firstReport_FinancialReport.getText();

				ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser, " ",
						false);

				ReusableComponents.wait(20000);

				String newRecord = firstReport_FinancialReport.getText();
				if (!newRecord.contains("FRR")) {
					ReusableComponents.wait(20000);

					newRecord = firstReport_FinancialReport.getText();
				}

				if (newRecord.contains("FRR") && !oldRecordName.equalsIgnoreCase(newRecord)) {
					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					financialReportURL = hreflink;
					ReusableComponents.reportPass(
							threadID, tempList, testcasemethod, "Created Financial report Name : " + newRecord
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
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser,
						pathLocation + "\\" + testcasemethod, false);

				ReusableComponents.wait(20000);

				List<WebElement> newRecordsList = browser
						.findElements(By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
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
					financialReportURL = hreflink;
					if (newRecord.contains("FRR")) {
						ReusableComponents.reportPass(
								threadID, tempList, testcasemethod, "Created Financial report Name : " + newRecord
										+ ". Link of created financial report : " + hreflink,
								browser, pathLocation + "\\" + testcasemethod, false);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser, hreflink,
								true);
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There are no new records created , please verify the input values", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				}
			}

			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"New NSFR name : " + reportName + " and its URL : " + nSFReportURL, browser,
					pathLocation + "\\" + testcasemethod, false);
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception while executing this test case" + e.getMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}
		return new BankingLedgerPage(browser);

	}

	/**
	 * @see Title: [BL] Verify that the Balance Sheet shows correct amounts for all
	 *      the Liability GL Accounts on period closing (not year-end)
	 * @author Wisefinch Menaka
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param appNameToSearch
	 * @param selectAppXpath
	 * @throws Exception
	 */
	public BankingLedgerPage test2704_BalanceSheetAmountLiabilityGLAccountsPeriodClose(int threadID,
			List<String> tempList, String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLocation = reusableComponents.pathBuilder(path);

		testCaseNumber = "Testcase2704";
		currentAccountingPeriodForTheTestCase = reusableComponents
				.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");
		try {

			LoginToWebpage(threadID, tempList, pathLocation);

			// --> Test data creation

			try {
				testDataCreation(threadID, tempList, pathLocation);
			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Exception when creating test deta",
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			// --> Close accounting period

			try {
				String accountingPeriodToClose = reusableComponents
						.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");
				closeAccountingPeriod(threadID, tempList, pathLocation, accountingPeriodToClose);
			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception when closing accpunting period", browser, pathLocation + "\\" + testcasemethod,
						true);
			}

			// --> Previous end accounting period open

			try {
				String accountingPeriodToOpen = reusableComponents
						.getPropValues(testCaseNumber + "_PreviousYear_YearEnd");
				openAccountingPeriod(threadID, tempList, pathLocation, accountingPeriodToOpen);
			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Exception when current period open",
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			// --> Launch new NSF report
			openNewNativeSalesForceBalanceSheet(threadID, tempList, pathLocation,
					"Financial Cubes withorwithout Financial Cube Trans");

			// --> Added filter values
			String endingAccountPeriod2 = reusableComponents.getPropValues(testCaseNumber + "_PreviousYear_YearEnd");

			nsfr_selectFilter(threadID, tempList, pathLocation, "Accounting Period: Accounting Period Name", "equal",
					endingAccountPeriod2);
			nsfr_selectFilter(threadID, tempList, pathLocation, "GL Account Type", "equal", "Balance Sheet");
			nsfr_selectFilter(threadID, tempList, pathLocation, "Ledger Type", "equal", "Transactional");

			// -->Remove all the column present under NSF report preview section

			nsfr_removeAlltheColumnPresentUnderPreviewSection(threadID, tempList, pathLocation);

			// --> Add GL Account: GL Account Name from field to preview section
			nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation,
					"GL Account: GL Account Name");

			// --> Select group by for GL Account: GL Account Name
			ReusableComponents.clickElement(arrowMarkNextToGLAcountGLAccountName,
					"Click on arrow mark next to GL Account: GL account Name");
			ReusableComponents.wait(1000);
			ReusableComponents.clickElement(groupByThisField_NSFR_PreviewColumnOption, "Group by this field option");
			ReusableComponents.wait(2000);
			try {
				List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
				if (refreshButtonElement.size() != 0) {
					WebElement refreshButton = refreshButtonElement.get(0);
					if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
						ReusableComponents.clickElement(refreshButton, "refresh button");
						ReusableComponents.wait(3000);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"groupBy GL Account: GL Account Name column done", browser,
								pathLocation + "\\" + testcasemethod, false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Unable to click on refresh button after performing group", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception : Unable to click on refresh button after performing group" + e.toString(), browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			// --> Add Opening Balance from field to preview section
			nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation, "Opening Balance");

			// --> Select sum from summarize option
			ReusableComponents.clickElement(arrowMarkNextToOpeningBalance,
					"Click on arrow mark next to Opening balance");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(selectSummarizeOption, "Select summarize option");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(sumOptionFromSummarize, "Select sum option from Summarize option");
			ReusableComponents.wait(2000);

			try {
				List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
				if (refreshButtonElement.size() != 0) {
					WebElement refreshButton = refreshButtonElement.get(0);
					if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
						ReusableComponents.clickElement(refreshButton, "refresh button");
						ReusableComponents.wait(3000);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Sum option selected for Opening Balance", browser,
								pathLocation + "\\" + testcasemethod, false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Unable to click on refresh button after performing sum for opening balance", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception : Unable to click on refresh button after performing sum for opening balance "
								+ e.toString(),
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			// --> Add current period from field to preview section
			nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation, "Current Period");

			try {
				List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
				if (refreshButtonElement.size() != 0) {
					WebElement refreshButton = refreshButtonElement.get(0);
					if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
						ReusableComponents.clickElement(refreshButton, "refresh button");
						ReusableComponents.wait(3000);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Current Period added to preview section", browser,
								pathLocation + "\\" + testcasemethod, false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception when clicking on refresh button after adding current period to preview section "
								+ e.getMessage(),
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			// --> Add Opening Balance from field to preview section
			nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation, "Year To Date");

			try {
				List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
				if (refreshButtonElement.size() != 0) {
					WebElement refreshButton = refreshButtonElement.get(0);
					if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
						ReusableComponents.clickElement(refreshButton, "refresh button");
						ReusableComponents.wait(3000);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Year To Date added to preview section", browser, pathLocation + "\\" + testcasemethod,
								false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception when trying to click on refresh button after adding Year To Date to preview section "
								+ e.toString(),
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			// --> Save the report with new name
			ReusableComponents.clickElement(saveAndRun_NSFR, "Click Save and run");
			ReusableComponents.wait(5000);
			reportName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_ReportName";
			reportUniqueName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_ReportUniqueName";

			// --> Pass control A and delete input box value
			ReusableComponents.sendKey(reportName_SaveAndRunPopup_NSFR, Keys.CONTROL + "A" + Keys.DELETE, "Select All");
			ReusableComponents.sendKey(reportName_SaveAndRunPopup_NSFR, reportName, "Provide Report Name");
			/*
			 * ReusableComponents.sendKey(reportUniqueName_SaveAndRunPopup_NSFR,
			 * Keys.CONTROL+"A"+Keys.DELETE, "Select All");
			 * ReusableComponents.sendKey(reportUniqueName_SaveAndRunPopup_NSFR,
			 * reportUniqueName, "Provide Report Unique Name");
			 */
			ReusableComponents.clickElement(saveButton_SaveAndRunPopup_NSFR, "Click Save Button");
			ReusableComponents.wait(10000);
			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"New NSFR with type Financial Cubes withorwithout Financial Cube Trans is created", browser,
					pathLocation + "\\" + testcasemethod, false);

			// --> Verify created report listed under report page, and add the URL to the
			// extend report
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Reports", selectReports);
			ReusableComponents.sendKey(search_NSFR, reportName, "Search Report Name");
			ReusableComponents.wait(2000);
			String reportList = ".//a[@title='" + reportName + "']/parent::*";
			System.out.println("********** report List " + reportList);
			List<WebElement> newReports = browser.findElements(By.xpath(reportList));
			System.out.println("********** newReports " + newReports.size());
			if (newReports.size() != 0) {
				String report = ".//a[@title='" + reportName + "']/parent::*";
				System.out.println("********** report List " + report);
				WebElement newReport = browser.findElement(By.xpath(report));
				ReusableComponents.clickUsingJavaScript(browser, newReport, "report");
				ReusableComponents.wait(5000);
				nSFReportURL = browser.getCurrentUrl();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"New NSFR with type Financial Cubes withorwithout Financial Cube Trans is created. And the link as follows : "
								+ nSFReportURL,
						browser, pathLocation + "\\" + testcasemethod, false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLocation + "\\" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "No New report created", browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			// Run Financial Report
			String financialReportsURL = reusableComponents.getPropValues("FinancialReports");
			browser.get(financialReportsURL);
			// Browser.get is used here since there are issue in launching financial report
			// from search app. Once the issue resolved we can comment it and unccomment
			// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
			// Reports",
			ReusableComponents.wait(5000);

			ReusableComponents.wait(5000);
			ReusableComponents.clickElement(selectStandartReport_FinancialReport, "Click Select standard reportd");
			ReusableComponents.wait(5000);
			ReusableComponents.clickElement(balanceSheet_selectStandartReport_FinancialReport,
					"Click Select Balance Sheet");
			ReusableComponents.wait(5000);

			// As per test case we have to user previous accounting period, so we are taking
			// pervious year from code

			startingAccountPeriod = reusableComponents
					.getPropValues(testCaseNumber + "_PreviousYear_StartingAccountPeriod");
			String endingAccountPeriod = reusableComponents
					.getPropValues(testCaseNumber + "_PreviousYear_EndingAccountPeriod");

			ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
					"Clear button of starting account period");
			ReusableComponents.sendKey(startingAccoutPeriod_FinancialReport, startingAccountPeriod,
					"Starting Account period");
			ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport, "Starting account period input box");
			ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select Starting account period");

			ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport_Clear,
					"Clear button of ending account period");
			ReusableComponents.sendKey(endingAccoutPeriod_FinancialReport, endingAccountPeriod,
					"Ending Account period");
			ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport, "ending account period input box");
			ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select ending account period");
			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"Accounting period start and ending period given", browser, " ", false);

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"With the assumption Suppress Zero Amount Rows check box will be always selected", browser,
					pathLocation + "\\" + testcasemethod, true);

			ReusableComponents.scrollDown(browser, 500);
			// --> Click on run button and get new record URL

			List<WebElement> recordsList = browser
					.findElements(By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
			System.out.println("************ Number of elements " + recordsList.size());

			if (recordsList.size() != 0) {
				String oldRecordName = firstReport_FinancialReport.getText();

				ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser, " ",
						false);

				ReusableComponents.wait(20000);

				String newRecord = firstReport_FinancialReport.getText();
				if (!newRecord.contains("FRR")) {
					ReusableComponents.wait(20000);

					newRecord = firstReport_FinancialReport.getText();
				}

				if (newRecord.contains("FRR") && !oldRecordName.equalsIgnoreCase(newRecord)) {
					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					financialReportURL = hreflink;
					ReusableComponents.reportPass(
							threadID, tempList, testcasemethod, "Created Financial report Name : " + newRecord
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
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser,
						pathLocation + "\\" + testcasemethod, false);

				ReusableComponents.wait(20000);

				List<WebElement> newRecordsList = browser
						.findElements(By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
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
					if (newRecord.contains("FRR")) {
						String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
						financialReportURL = hreflink;

						ReusableComponents.reportPass(
								threadID, tempList, testcasemethod, "Created Financial report Name : " + newRecord
										+ ". Link of created financial report : " + hreflink,
								browser, pathLocation + "\\" + testcasemethod, false);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser, hreflink,
								true);
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There are no new records created , please verify the input values", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				}
			}

			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"New NSFR name : " + reportName + " and its URL : " + nSFReportURL, browser,
					pathLocation + "\\" + testcasemethod, false);
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception while executing this test case" + e.getMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}
		return new BankingLedgerPage(browser);

	}

	/**
	 * @see Title: [BL] Verify that the Balance Sheet shows correct amounts for all
	 *      the Owners Equity GL Accounts on period closing (not year-end)
	 * @author Wisefinch Menaka
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param appNameToSearch
	 * @param selectAppXpath
	 * @throws Exception
	 */
	public BankingLedgerPage test2705_BalanceSheetAmountOwnerEquityGLAccountsPeriodClose(int threadID,
			List<String> tempList, String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLocation = reusableComponents.pathBuilder(path);

		testCaseNumber = "Testcase2705";
		currentAccountingPeriodForTheTestCase = reusableComponents
				.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");
		try {

			LoginToWebpage(threadID, tempList, pathLocation);

			// --> Test data creation
			try {
				testDataCreation(threadID, tempList, pathLocation);
			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception when calling test data creation", browser, pathLocation + "\\" + testcasemethod,
						true);
			}

			// --> Financial Report PL Report

			/// Run Financial Report
			String financialReportsURL = reusableComponents.getPropValues("FinancialReports");
			browser.get(financialReportsURL);
			// Browser.get is used here since there are issue in launching financial report
			// from search app. Once the issue resolved we can comment it and unccomment
			// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
			// Reports",
			ReusableComponents.wait(5000);

			// As per test case we have to user previous accounting period, so we are taking
			startingAccountPeriod = reusableComponents
					.getPropValues(testCaseNumber + "_PreviousYear_StartingAccountPeriod");
			String endingAccountPeriod = reusableComponents
					.getPropValues(testCaseNumber + "_PreviousYear_EndingAccountPeriod");

			ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
					"Clear button of starting account period");
			ReusableComponents.sendKey(startingAccoutPeriod_FinancialReport, startingAccountPeriod,
					"Starting Account period");
			ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport, "Starting account period input box");
			ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select Starting account period");

			ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport_Clear,
					"Clear button of ending account period");
			ReusableComponents.sendKey(endingAccoutPeriod_FinancialReport, endingAccountPeriod,
					"Ending Account period");
			ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport, "ending account period input box");
			ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select ending account period");
			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"Accounting period start and ending period given", browser, " ", false);

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"With the assumption Suppress Zero Amount Rows check box will be always selected", browser,
					pathLocation + "\\" + testcasemethod, true);

			ReusableComponents.scrollDown(browser, 500);

			// --> Click on run button and get new record URL
			String reportOpen = null;
			List<WebElement> recordsList = browser
					.findElements(By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
			System.out.println("************ Number of elements " + recordsList.size());

			if (recordsList.size() != 0) {
				String oldRecordName = firstReport_FinancialReport.getText();

				ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser, " ",
						false);

				ReusableComponents.wait(20000);

				String newRecord = firstReport_FinancialReport.getText();

				if (!newRecord.contains("FRR")) {
					ReusableComponents.wait(20000);

					newRecord = firstReport_FinancialReport.getText();
				}

				if (newRecord.contains("FRR") && !oldRecordName.equalsIgnoreCase(newRecord)) {
					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					reportOpen = hreflink;
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Created PL Financial report Name : " + newRecord
									+ ". Link of created PL financial report : " + hreflink,
							browser, pathLocation + "\\" + testcasemethod, false);
				} else {

					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There are no new records created, provide valid inputs ", browser,
							pathLocation + "\\" + testcasemethod, true);
				}
			} else {

				ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser,
						pathLocation + "\\" + testcasemethod, false);

				ReusableComponents.wait(20000);

				List<WebElement> newRecordsList = browser
						.findElements(By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
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
					if (newRecord.contains("FRR")) {

						String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
						reportOpen = hreflink;

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Created PL Financial report Name : " + newRecord
										+ ". Link of created PL financial report : " + hreflink,
								browser, pathLocation + "\\" + testcasemethod, false);
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There are no new records created , please verify the input values", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				}
			}

			// --> Take net income account and check weather it is loss or profit
			browser.get(reportOpen);
			ReusableComponents.wait(10000);

			List<WebElement> netincome = browser
					.findElements(By.xpath("//th[@data-label='Net Income']//following::td"));

			if (netincome.size() != 0) {
				int size = netincome.size();
				String netIncomeValue = netincome.get(size - 1).getText().replaceAll("\\s", "");
				;
				char[] charArray = netIncomeValue.toCharArray();

				char firstChar = charArray[0];
				int result = Character.compare(firstChar, '(');
				if (result == 0) {
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Net income value is in negative , It is a loss " + netIncomeValue, browser,
							pathLocation + "\\" + testcasemethod, false);

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
							pathLocation + "\\" + testcasemethod, true);
				} else {
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Net income value is in positive , It is a profit " + netIncomeValue, browser,
							pathLocation + "\\" + testcasemethod, false);

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
							pathLocation + "\\" + testcasemethod, true);
				}
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"There are no net income value present", browser, pathLocation + "\\" + testcasemethod, true);
			}

			// --> Close accounting period
			try {
				String accountingPeriodToClose = reusableComponents
						.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");
				closeAccountingPeriod(threadID, tempList, pathLocation, accountingPeriodToClose);
			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception when calling close accounting period", browser, pathLocation + "\\" + testcasemethod,
						true);
			}

			// --> Previous end accounting period open
			try {
				String endAccountingPeriodToOpen = reusableComponents
						.getPropValues(testCaseNumber + "_PreviousYear_YearEnd");
				openAccountingPeriod(threadID, tempList, pathLocation, endAccountingPeriodToOpen);
			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception when calling end accounting period open", browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			// --> Launch new NSF report
			openNewNativeSalesForceBalanceSheet(threadID, tempList, pathLocation,
					"Financial Cubes withorwithout Financial Cube Trans");

			// --> Added filter values
			endingAccountPeriod = reusableComponents.getPropValues(testCaseNumber + "_PreviousYear_YearEnd");

			nsfr_selectFilter(threadID, tempList, pathLocation, "Accounting Period: Accounting Period Name", "equal",
					endingAccountPeriod);
			nsfr_selectFilter(threadID, tempList, pathLocation, "GL Account Type", "equal", "Balance Sheet");
			nsfr_selectFilter(threadID, tempList, pathLocation, "Ledger Type", "equal", "Transactional");

			// -->Remove all the column present under NSF report preview section

			nsfr_removeAlltheColumnPresentUnderPreviewSection(threadID, tempList, pathLocation);

			// --> Add GL Account: GL Account Name from field to preview section
			nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation,
					"GL Account: GL Account Name");

			// --> Select group by for GL Account: GL Account Name
			ReusableComponents.clickElement(arrowMarkNextToGLAcountGLAccountName,
					"Click on arrow mark next to GL Account: GL account Name");
			ReusableComponents.wait(1000);
			ReusableComponents.clickElement(groupByThisField_NSFR_PreviewColumnOption, "Group by this field option");
			ReusableComponents.wait(2000);
			try {
				List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
				if (refreshButtonElement.size() != 0) {
					WebElement refreshButton = refreshButtonElement.get(0);
					if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
						ReusableComponents.clickElement(refreshButton, "refresh button");
						ReusableComponents.wait(3000);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"groupBy GL Account: GL Account Name column done", browser,
								pathLocation + "\\" + testcasemethod, false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Unable to click on refresh button after performing group", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception : Unable to click on refresh button after performing group" + e.toString(), browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			// --> Add Opening Balance from field to preview section
			nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation, "Opening Balance");

			// --> Select sum from summarize option
			ReusableComponents.clickElement(arrowMarkNextToOpeningBalance,
					"Click on arrow mark next to Opening balance");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(selectSummarizeOption, "Select summarize option");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(sumOptionFromSummarize, "Select sum option from Summarize option");
			ReusableComponents.wait(2000);

			try {
				List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
				if (refreshButtonElement.size() != 0) {
					WebElement refreshButton = refreshButtonElement.get(0);
					if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
						ReusableComponents.clickElement(refreshButton, "refresh button");
						ReusableComponents.wait(3000);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Sum option selected for Opening Balance", browser,
								pathLocation + "\\" + testcasemethod, false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Unable to click on refresh button after performing sum for opening balance", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception : Unable to click on refresh button after performing sum for opening balance "
								+ e.toString(),
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			// --> Add current period from field to preview section
			nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation, "Current Period");

			try {
				List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
				if (refreshButtonElement.size() != 0) {
					WebElement refreshButton = refreshButtonElement.get(0);
					if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
						ReusableComponents.clickElement(refreshButton, "refresh button");
						ReusableComponents.wait(3000);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Current Period added to preview section", browser,
								pathLocation + "\\" + testcasemethod, false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception when clicking on refresh button after adding current period to preview section "
								+ e.getMessage(),
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			// --> Add Opening Balance from field to preview section
			nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation, "Year To Date");

			try {
				List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
				if (refreshButtonElement.size() != 0) {
					WebElement refreshButton = refreshButtonElement.get(0);
					if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
						ReusableComponents.clickElement(refreshButton, "refresh button");
						ReusableComponents.wait(3000);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Year To Date added to preview section", browser, pathLocation + "\\" + testcasemethod,
								false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception when trying to click on refresh button after adding Year To Date to preview section "
								+ e.toString(),
						browser, pathLocation + "\\" + testcasemethod, true);
			}

			// --> Save the report with new name
			ReusableComponents.clickElement(saveAndRun_NSFR, "Click Save and run");
			ReusableComponents.wait(5000);
			reportName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_ReportName";
			reportUniqueName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_ReportUniqueName";

			// --> Pass control A and delete input box value
			ReusableComponents.sendKey(reportName_SaveAndRunPopup_NSFR, Keys.CONTROL + "A" + Keys.DELETE, "Select All");
			ReusableComponents.sendKey(reportName_SaveAndRunPopup_NSFR, reportName, "Provide Report Name");
			/*
			 * ReusableComponents.sendKey(reportUniqueName_SaveAndRunPopup_NSFR,
			 * Keys.CONTROL+"A"+Keys.DELETE, "Select All");
			 * ReusableComponents.sendKey(reportUniqueName_SaveAndRunPopup_NSFR,
			 * reportUniqueName, "Provide Report Unique Name");
			 */
			ReusableComponents.clickElement(saveButton_SaveAndRunPopup_NSFR, "Click Save Button");
			ReusableComponents.wait(10000);
			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"New NSFR with type Financial Cubes withorwithout Financial Cube Trans is created", browser,
					pathLocation + "\\" + testcasemethod, false);

			// --> Verify created report listed under report page, and add the URL to the
			// extend report
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Reports", selectReports);
			ReusableComponents.sendKey(search_NSFR, reportName, "Search Report Name");
			ReusableComponents.wait(2000);
			String reportList = ".//a[@title='" + reportName + "']/parent::*";
			System.out.println("********** report List " + reportList);
			List<WebElement> newReports = browser.findElements(By.xpath(reportList));
			System.out.println("********** newReports " + newReports.size());
			if (newReports.size() != 0) {
				String report = ".//a[@title='" + reportName + "']/parent::*";
				System.out.println("********** report List " + report);
				WebElement newReport = browser.findElement(By.xpath(report));
				ReusableComponents.clickUsingJavaScript(browser, newReport, "report");
				ReusableComponents.wait(5000);
				nSFReportURL = browser.getCurrentUrl();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"New NSFR with type Financial Cubes withorwithout Financial Cube Trans is created. And the link as follows : "
								+ nSFReportURL,
						browser, pathLocation + "\\" + testcasemethod, false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLocation + "\\" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "No New report created", browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			// Run Financial Report
			financialReportsURL = reusableComponents.getPropValues("FinancialReports");
			browser.get(financialReportsURL);
			// Browser.get is used here since there are issue in launching financial report
			// from search app. Once the issue resolved we can comment it and unccomment
			// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
			// Reports",
			ReusableComponents.wait(5000);

			ReusableComponents.wait(5000);
			ReusableComponents.clickElement(selectStandartReport_FinancialReport, "Click Select standard reportd");
			ReusableComponents.wait(5000);
			ReusableComponents.clickElement(balanceSheet_selectStandartReport_FinancialReport,
					"Click Select Balance Sheet");
			ReusableComponents.wait(5000);

			// As per test case we have to user previous accounting period, so we are taking
			startingAccountPeriod = reusableComponents
					.getPropValues(testCaseNumber + "_PreviousYear_StartingAccountPeriod");
			endingAccountPeriod = reusableComponents
					.getPropValues(testCaseNumber + "_PreviousYear_EndingAccountPeriod");

			ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
					"Clear button of starting account period");
			ReusableComponents.sendKey(startingAccoutPeriod_FinancialReport, startingAccountPeriod,
					"Starting Account period");
			ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport, "Starting account period input box");
			ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select Starting account period");

			ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport_Clear,
					"Clear button of ending account period");
			ReusableComponents.sendKey(endingAccoutPeriod_FinancialReport, endingAccountPeriod,
					"Ending Account period");
			ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport, "ending account period input box");
			ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select ending account period");
			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"Accounting period start and ending period given", browser, " ", false);

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"With the assumption Suppress Zero Amount Rows check box will be always selected", browser,
					pathLocation + "\\" + testcasemethod, true);

			ReusableComponents.scrollDown(browser, 500);
			// --> Click on run button and get new record URL

			List<WebElement> recordsList1 = browser
					.findElements(By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
			System.out.println("************ Number of elements " + recordsList1.size());

			if (recordsList1.size() != 0) {
				String oldRecordName = firstReport_FinancialReport.getText();

				ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser, " ",
						false);

				ReusableComponents.wait(20000);

				String newRecord = firstReport_FinancialReport.getText();
				if (!newRecord.contains("FRR")) {
					ReusableComponents.wait(20000);

					newRecord = firstReport_FinancialReport.getText();
				}

				if (newRecord.contains("FRR") && !oldRecordName.equalsIgnoreCase(newRecord)) {
					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					financialReportURL = hreflink;
					ReusableComponents.reportPass(
							threadID, tempList, testcasemethod, "Created Financial report Name : " + newRecord
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
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser,
						pathLocation + "\\" + testcasemethod, false);

				ReusableComponents.wait(20000);

				List<WebElement> newRecordsList = browser
						.findElements(By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
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

					if (newRecord.contains("FRR")) {
						String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
						financialReportURL = hreflink;

						ReusableComponents.reportPass(
								threadID, tempList, testcasemethod, "Created Financial report Name : " + newRecord
										+ ". Link of created financial report : " + hreflink,
								browser, pathLocation + "\\" + testcasemethod, false);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser, hreflink,
								true);
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There are no new records created , please verify the input values", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				}
			}

			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"New NSFR name : " + reportName + " and its URL : " + nSFReportURL, browser,
					pathLocation + "\\" + testcasemethod, false);
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception while executing this test case" + e.getMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}
		return new BankingLedgerPage(browser);

	}

	/**
	 * @author Wisefinch Menaka
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param appNameToSearch
	 * @param selectAppXpath
	 * @throws Exception
	 */
	public BankingLedgerPage testDataCreation(int threadID, List<String> tempList, String pathLocation)
			throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		// LoginToWebpage(threadID, tempList, pathLocation);

		try {
			createAccount(threadID, tempList, pathLocation);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception while creating test data" + e.getMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

		try {
			CashDisbursement(threadID, tempList, pathLocation);

		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to create new cash disbursement" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

		try {
			createNewBilling(threadID, tempList, pathLocation);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to create new billing" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

		try {
			createCashReceipt(threadID, tempList, pathLocation);

		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to create cash receipt" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}

		try {
			createPayables(threadID, tempList, pathLocation);

		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to create payables" + e.getStackTrace(), browser,
					pathLocation + "\\" + testcasemethod, true);
		}
		return new BankingLedgerPage(browser);

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
	public synchronized BankingLedgerPage createAccount(int threadID, List<String> tempList, String pathLocation)
			throws IOException, AWTException, throwNewException {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			navigateToAccountingHomePage();

			newAccountname = "Accounts_" + testCaseNumber + "_"
					+ ReusableComponents.getCurrentDateAndTime("YYMMDDhhmmss");
			String acc_type = "Customer and Vendor";

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
			String xpathToCheckNewAccount = ".//*[@data-aura-class='uiOutputText' and contains(text(),'"
					+ newAccountname + "')]";

			List<WebElement> accountName = browser.findElements(By.xpath(xpathToCheckNewAccount));

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
					"Exception in create account" + e.getStackTrace(), browser, pathLocation + "\\" + testcasemethod,
					true);

		}

		return new BankingLedgerPage(browser);

	}

	/**
	 * @author Wisefinch Menaka
	 * @see This method can be used only inside of NSFR. This method will help to
	 *      perform save and run, give unique name to the report and add the URL to
	 *      the extend report
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @param reportTypeName --> Provide report type name here to add proper results
	 *                       in extend report. Ex : Financial Cubes withorwithout
	 *                       Financial Cube Trans
	 * @return
	 * @throws Exception
	 */
	public static BankingLedgerPage nsfr_ClickSaveAndRun(int threadID, List<String> tempList, String pathLocation,
			String reportTypeName) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			// --> Save the report with new name
			ReusableComponents.clickElement(saveAndRun_NSFR, "Click Save and run");
			ReusableComponents.wait(5000);
			reportName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_ReportName";
			reportUniqueName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_ReportUniqueName";

			// --> Pass control A and delete input box value
			ReusableComponents.sendKey(reportName_SaveAndRunPopup_NSFR, Keys.CONTROL + "A" + Keys.DELETE, "Select All");
			ReusableComponents.sendKey(reportName_SaveAndRunPopup_NSFR, reportName, "Provide Report Name");
			/*
			 * ReusableComponents.sendKey(reportUniqueName_SaveAndRunPopup_NSFR,
			 * Keys.CONTROL+"A"+Keys.DELETE, "Select All");
			 * ReusableComponents.sendKey(reportUniqueName_SaveAndRunPopup_NSFR,
			 * reportUniqueName, "Provide Report Unique Name");
			 */
			ReusableComponents.clickElement(saveButton_SaveAndRunPopup_NSFR, "Click Save Button");
			ReusableComponents.wait(10000);
			ReusableComponents.reportPass(threadID, tempList, testcasemethod,
					"New NSFR with type " + reportTypeName + " is created", browser,
					pathLocation + "\\" + testcasemethod, false);

			// --> Verify created report listed under report page, and add the URL to the
			// extend report
			navigateToAccountingHomePage();
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Reports", selectReports);
			ReusableComponents.sendKey(search_NSFR, reportName, "Search Report Name");
			ReusableComponents.wait(2000);
			String reportList = ".//a[@title='" + reportName + "']/parent::*";
			System.out.println("********** report List " + reportList);
			List<WebElement> newReports = browser.findElements(By.xpath(reportList));
			System.out.println("********** newReports " + newReports.size());
			if (newReports.size() != 0) {
				String report = ".//a[@title='" + reportName + "']/parent::*";
				System.out.println("********** report List " + report);
				WebElement newReport = browser.findElement(By.xpath(report));
				ReusableComponents.clickUsingJavaScript(browser, newReport, "report");
				ReusableComponents.wait(5000);
				nSFReportURL = browser.getCurrentUrl();
				ReusableComponents.reportPass(
						threadID, tempList, testcasemethod, "New NSFR with type " + reportTypeName
								+ " is created. And the link as follows : " + nSFReportURL,
						browser, pathLocation + "\\" + testcasemethod, false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
						pathLocation + "\\" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "No New report created", browser,
						pathLocation + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception trying to save " + reportTypeName + " report" + e.getMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * * @author Wisefinch Menaka
	 * 
	 * @see This method can be called only after adding field to preview section of
	 *      NSFR. This will click on arrow next to added field and sum it up.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @param filedWebElementToSumUp --> Pass the arrow mark xpath of fields present
	 *                               in preview section. example
	 *                               "arrowMarkNextToYearToDate" and it's xpath for
	 *                               Reference @FindBy(xpath =
	 *                               "(.//*[@data-tooltip='Year To
	 *                               Date']//following::button)[1]") static
	 *                               WebElement arrowMarkNextToYearToDatse;
	 * @return
	 * @throws Exception
	 */
	public static BankingLedgerPage nsfr_PreviewSectionClickArrowmarkSummarizeOptionSum(int threadID,
			List<String> tempList, String pathLocation, WebElement filedWebElementToSumUp) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			// --> Select sum from summarize option
			ReusableComponents.clickElement(filedWebElementToSumUp, "Click on arrow mark next to the given field");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(selectSummarizeOption, "Select summarize option");
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(sumOptionFromSummarize, "Select sum option from Summarize option");
			ReusableComponents.wait(2000);

			try {
				List<WebElement> refreshButtonElement = browser.findElements(By.xpath(refreshButtonXpath));
				if (refreshButtonElement.size() != 0) {
					WebElement refreshButton = refreshButtonElement.get(0);
					if (ReusableComponents.isDisplayed(refreshButton, "refresh button") == true) {
						ReusableComponents.clickElement(refreshButton, "refresh button");
						ReusableComponents.wait(3000);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Sum option selected for Opening Balance", browser,
								pathLocation + "\\" + testcasemethod, false);

						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Unable to click on refresh button after performing sum for opening balance", browser,
								pathLocation + "\\" + testcasemethod, true);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception : Unable to click on refresh button after performing sum for opening balance "
								+ e.toString(),
						browser, pathLocation + "\\" + testcasemethod, true);

			}
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception trying to perform NSFR summaraize and sum" + e.getMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * @see Title: [TB] Verify that the Period column shows the correct amounts for
	 *      a non year end period.
	 * @author Wisefinch Menaka
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param appNameToSearch
	 * @param selectAppXpath
	 * @throws Exception
	 */
	public BankingLedgerPage test2690_PeriodCorrectAmountNonYearEndPeriod(int threadID, List<String> tempList,
			String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLocation = reusableComponents.pathBuilder(path);
		String currentAccoutingPeriod, closePreviousAccountingPeriod = "NA", currentAccountPeriodExpectedStatus = null,
				previousAccountPeriodExpectedStatus = null;
		boolean accountPeriodStatusCheck = false, previousAccountingPeriodActualStatus = false,
				currentAccountingPeriodActualStatus = false;

		testCaseNumber = "Testcase2690";
		String ledgerValue = reusableComponents.getPropValues(testCaseNumber + "_LedgerValue");

		try {
			// --> Login to the webpage
			LoginToWebpage(threadID, tempList, pathLocation);

			// --> assign test case number to get data from config properties
			System.out.println("*********** testCaseNumber " + testCaseNumber);

			// --> Identify correct accounting year for this test case based on test data
			currentAccoutingPeriod = reusableComponents
					.getPropValues(testCaseNumber + "_" + "AccountingPeriodForTestCase");
			System.out.println("*********** currentAccoutingPeriod " + currentAccoutingPeriod);

			String strArray[] = currentAccoutingPeriod.split("-");
			String yearValue = strArray[0];
			int month = Integer.parseInt(strArray[1]);

			// If the Current Accounting Period is the year end: go to Accounting Periods,
			// and open the previous period and use it for this testcase. Ensure the period
			// before that is closed. If Current Accounting Period is not the year end, then
			// use it for this testcase. Ensure previous period is closed.
			if (month == 12) {
				currentAccountingPeriodForTheTestCase = yearValue.concat("-11");
				System.out.println("*********** value of Testcase2690_AccountingPeriod : "
						+ currentAccountingPeriodForTheTestCase);
				closePreviousAccountingPeriod = yearValue.concat("-10");
				System.out.println(
						"*********** value of closePreviousAccountingPeriod : " + closePreviousAccountingPeriod);

				try {
					closeAccountingPeriod(threadID, tempList, pathLocation, closePreviousAccountingPeriod);
					openAccountingPeriod(threadID, tempList, pathLocation, currentAccountingPeriodForTheTestCase);
				} catch (Exception e) {
					e.printStackTrace();
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Exception when trying to access account closer or open function" + e.getMessage(), browser,
							pathLocation + "\\" + testcasemethod, true);
				}

				// --> Check accounting period status
				previousAccountPeriodExpectedStatus = "Closed";
				previousAccountingPeriodActualStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
						closePreviousAccountingPeriod, previousAccountPeriodExpectedStatus);
				currentAccountPeriodExpectedStatus = "Open";
				currentAccountingPeriodActualStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
						currentAccountingPeriodForTheTestCase, currentAccountPeriodExpectedStatus);

				// If both the accounting period status are displayed as expected set
				// accountPeriodStatusCheck to have true
				if (previousAccountingPeriodActualStatus && currentAccountingPeriodActualStatus) {
					accountPeriodStatusCheck = true;
				} else {
					accountPeriodStatusCheck = false;
				}

			} else {
				currentAccountingPeriodForTheTestCase = currentAccoutingPeriod;
				System.out.println("*********** value of Testcase2690_AccountingPeriod : "
						+ currentAccountingPeriodForTheTestCase);

				// --> Check accounting period status
				currentAccountPeriodExpectedStatus = "Open";
				currentAccountingPeriodActualStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
						currentAccountingPeriodForTheTestCase, currentAccountPeriodExpectedStatus);

				// if accounting period status displayed as expected set
				// accountPeriodStatusCheck to have true
				if (currentAccountingPeriodActualStatus) {
					accountPeriodStatusCheck = true;
				} else {
					accountPeriodStatusCheck = false;
				}
			}

			// If accountPeriodStatusCheck is true continue with test case else drop the
			// test
			if (accountPeriodStatusCheck) {
				System.out.println("********** Good to continue with test cases");

				// --> Test data creation create account --> Create new account
				try {
					createAccount(threadID, tempList, pathLocation);
				} catch (Exception e) {
					e.printStackTrace();
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There is a exception while creating test data" + e.getMessage(), browser,
							pathLocation + "\\" + testcasemethod, true);
				}

				// If new account creation is successful continue with test case else drop the
				// test
				if (accountCreatedStatus) {

					// --> Test data creation create account --> Create new billing
					try {
						createNewBilling(threadID, tempList, pathLocation);
					} catch (Exception e) {
						e.printStackTrace();
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There is a exception while creating new billing test data" + e.getMessage(), browser,
								pathLocation + "\\" + testcasemethod, true);
					}

					// --> Test data creation create account --> Create new payable
					if (testDataNewBillingCreated) {
						try {
							createPayables(threadID, tempList, pathLocation);
						} catch (Exception e) {
							e.printStackTrace();
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"There is a exception while creating payables test data" + e.getMessage(), browser,
									pathLocation + "\\" + testcasemethod, true);
						}

						// --> If both the test data's are created continue with the test case else drop
						// the test

						if (testDataNewBillingName != null && testDataNewPayableName != null) {
							System.out.println(
									"********** All necessory test datas are created. Good to go with test case");

							// --> Select reports from search app
							selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Reports", selectReports);

							// --> Launch new NSF report
							openNewNativeSalesForceBalanceSheet(threadID, tempList, pathLocation,
									"Financial Cubes withorwithout Financial Cube Trans");

							// --> Added filter values

							nsfr_selectFilter(threadID, tempList, pathLocation,
									"Accounting Period: Accounting Period Name", "equal",
									currentAccountingPeriodForTheTestCase);
							nsfr_selectFilter(threadID, tempList, pathLocation, "Cube Type", "equal", "Period");
							nsfr_selectFilter(threadID, tempList, pathLocation, "Cube Type", "equal",
									"Retained Earnings");
							nsfr_selectFilter(threadID, tempList, pathLocation, "Ledger: Ledger Name", "equal",
									ledgerValue);
							nsfr_selectFilter(threadID, tempList, pathLocation, "Ledger Type", "equal",
									"Transactional");

							// -->Remove all the column present under NSF report preview section

							nsfr_removeAlltheColumnPresentUnderPreviewSection(threadID, tempList, pathLocation);

							// --> Add Opening Balance from field to preview section
							nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation,
									"Opening Balance");
							nsfr_PreviewSectionClickArrowmarkSummarizeOptionSum(threadID, tempList, pathLocation,
									arrowMarkNextToOpeningBalance);

							// --> Add Current Period from field to preview section
							nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation,
									"Current Period");
							nsfr_PreviewSectionClickArrowmarkSummarizeOptionSum(threadID, tempList, pathLocation,
									arrowMarkNextToCurrentPeriod);

							// --> Add Year To Date from field to preview section
							nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation,
									"Year To Date");
							nsfr_PreviewSectionClickArrowmarkSummarizeOptionSum(threadID, tempList, pathLocation,
									arrowMarkNextToYearToDate);

							// --> Add GL Account: GL Account Name from field to preview section
							nsfr_addValuesFromFieldSearchToPreviewSection(threadID, tempList, pathLocation,
									"GL Account: GL Account Name");

							// --> Click on save and run. Add the saved report url to extend report
							nsfr_ClickSaveAndRun(threadID, tempList, pathLocation,
									"Financial Cubes withorwithout Financial Cube Trans");

							// Run Financial Report
							String financialReportsURL = reusableComponents.getPropValues("FinancialReports");
							browser.get(financialReportsURL);
							// Browser.get is used here since there are issue in launching financial report
							// from search app. Once the issue resolved we can comment it and unccomment
							// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
							// Reports",
							ReusableComponents.wait(5000);

							ReusableComponents.clickElement(selectStandartReport_FinancialReport,
									"Click Select standard reportd");
							ReusableComponents.wait(5000);
							ReusableComponents.clickElement(trialBalance_selectStandartReport_FinancialReport,
									"Click Select Trial Balance");
							ReusableComponents.wait(5000);

							ReusableComponents.clickElement(clearSectionOfLedger_TrailBalance,
									"Clear button of Ledger input box period");
							ReusableComponents.sendKey(ledgerTypeInputBox_TrailBalance, ledgerValue,
									"Accounting period");
							String selcectLedgerValueXpath = "//lightning-base-combobox-formatted-text[@title='"
									+ ledgerValue + "']";
							WebElement selectValueElement = browser.findElement(By.xpath(selcectLedgerValueXpath));
							ReusableComponents.clickElement(selectValueElement, "Select Ledger Type");

							ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
									"Clear button of starting account period");
							ReusableComponents.sendKey(startingAccoutPeriodTrailBalance,
									currentAccountingPeriodForTheTestCase, "Accounting period");
							ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
									"Select Starting account period");

							ReusableComponents.reportPass(threadID, tempList, testcasemethod,
									"Ledger and Accounting period values are given to run report", browser,
									pathLocation + "\\" + testcasemethod, false);
							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
									pathLocation + "\\" + testcasemethod, true);

							ReusableComponents.scrollDown(browser, 500);
							// --> Click on run button and get new record URL

							List<WebElement> recordsList = browser.findElements(
									By.xpath(".//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')]"));
							System.out.println("************ Number of Report " + recordsList.size());

							if (recordsList.size() != 0) {
								String oldRecordName = firstReport_FinancialReport.getText();
								System.out.println("*********** oldRecordName : " + oldRecordName);
								ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked",
										browser, " ", false);

								ReusableComponents.wait(20000);

								String newRecord = firstReport_FinancialReport.getText();

								if (!newRecord.contains("FRR")) {
									ReusableComponents.wait(20000);

									newRecord = firstReport_FinancialReport.getText();
								}

								System.out.println("*********** newRecord : " + newRecord);
								if (newRecord.contains("FRR") && !oldRecordName.equalsIgnoreCase(newRecord)) {
									String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport,
											"href");
									financialReportURL = hreflink;
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
											"There are no new records created , please verify the input values",
											browser, pathLocation + "\\" + testcasemethod, true);
								} else {

									String newRecord = firstReport_FinancialReport.getText();

									if (!newRecord.contains("FRR")) {
										ReusableComponents.wait(20000);

										newRecord = firstReport_FinancialReport.getText();
									}

									if (newRecord.contains("FRR")) {
										String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport,
												"href");
										financialReportURL = hreflink;

										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"Created Financial report Name : " + newRecord
														+ ". Link of created financial report : " + hreflink,
												browser, pathLocation + "\\" + testcasemethod, false);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);
									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"There are no new records created , please verify the input values",
												browser, pathLocation + "\\" + testcasemethod, true);
									}
								}
							}

							ReusableComponents.reportPass(threadID, tempList, testcasemethod,
									"New NSFR name : " + reportName + " and its URL : " + nSFReportURL, browser,
									pathLocation + "\\" + testcasemethod, false);

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"As part of test data creation ,there are no new billing or payables are created. Hence can not continue with the test case",
									browser, pathLocation + "\\" + testcasemethod, true);
						}
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"As part of test data creation no new billing created. Hence can not continue with the test case",
								browser, pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"As part of test data creation ,there are no new account created, Hence can not create billing and payables",
							browser, pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Accounting period status are differed to continue with this test case ", browser,
						pathLocation + "\\" + testcasemethod, false);

				if (currentAccountPeriodExpectedStatus != null && !currentAccountingPeriodActualStatus) {
					ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
							currentAccountingPeriodForTheTestCase + " Status is not displayed as "
									+ currentAccountPeriodExpectedStatus,
							browser, pathLocation + "\\" + testcasemethod, false);
				}

				if (previousAccountPeriodExpectedStatus != null && !previousAccountingPeriodActualStatus)
					ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
							closePreviousAccountingPeriod + " Status is not displayed as "
									+ previousAccountPeriodExpectedStatus,
							browser, pathLocation + "\\" + testcasemethod, false);
			}
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception while executing this test case" + e.getMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}
		return new BankingLedgerPage(browser);
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
	private static BankingLedgerPage close_a_AccountingPeriod(int threadID, List<String> tempList, String pathLocation,
			String accountingPeriod) {
		// TODO Auto-generated method stub
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			// --> Navigate to home page
			navigateToAccountingHomePage();

			// --> Move to accounting periods page
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Accounting Periods",
					SelectAccountingPeriods);

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

			// Verify accouting period is displayed
			if (openAccountingPeriod.size() != 0) {
				WebElement openAccountingPeriodElement = browser.findElement(By.xpath(xpathToOpenAccountingPeriod));
				ReusableComponents.clickElement(openAccountingPeriodElement, "Open accounting period");
				ReusableComponents.wait(8000);

				String xpathToCheckAccountingPeriod = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'"
						+ accountingPeriod + "')]";
				System.out.println("*********** xpathToCheckNewAccount : " + xpathToCheckAccountingPeriod);

				List<WebElement> accountingPeriodName = browser.findElements(By.xpath(xpathToCheckAccountingPeriod));
				System.out.println("*********** accountName size : " + accountingPeriodName.size());

				// Verify accounting period page is displayed
				if (accountingPeriodName.size() != 0) {
					ReusableComponents.clickElement(edit_AccountingPeriod,
							"Click on edit buttion of accounting period");
					ReusableComponents.wait(8000);
					String xpathToCheckEditAccountingPeriodPopup = ".//*[@class='actionBody']//*[contains(text(),'Edit "
							+ accountingPeriod + "')]";
					List<WebElement> editPopup = browser.findElements(By.xpath(xpathToCheckEditAccountingPeriodPopup));
					System.out.println("*********** editPopup size : " + editPopup.size());

					// Verify accounting period edit popup displaye
					if (editPopup.size() != 0) {

						// change the status
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

						// Save the status
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
		return new BankingLedgerPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see This method will change the provided accounting period status to have
	 *      Open.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @param accountingPeriod -- Pass the accounting period in correct format [Ex :
	 *                         2020-01]
	 */
	private static BankingLedgerPage open_a_AccountingPeriod(int threadID, List<String> tempList, String pathLocation,
			String accountingPeriod) {
		// TODO Auto-generated method stub
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			// --> Navigate to home page
			navigateToAccountingHomePage();

			// --> Move to accounting periods page
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Accounting Periods",
					SelectAccountingPeriods);

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

			// Verify accounting period displayed
			if (openAccountingPeriod.size() != 0) {
				WebElement openAccountingPeriodElement = browser.findElement(By.xpath(xpathToOpenAccountingPeriod));
				ReusableComponents.clickElement(openAccountingPeriodElement, "Open accounting period");
				ReusableComponents.wait(8000);

				String xpathToCheckAccountingPeriod = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'"
						+ accountingPeriod + "')]";
				System.out.println("*********** xpathToCheckNewAccount : " + xpathToCheckAccountingPeriod);

				List<WebElement> accountingPeriodName = browser.findElements(By.xpath(xpathToCheckAccountingPeriod));
				System.out.println("*********** accountName size : " + accountingPeriodName.size());

				// Verify accounting period page displayed
				if (accountingPeriodName.size() != 0) {
					ReusableComponents.clickElement(edit_AccountingPeriod,
							"Click on edit buttion of accounting period");
					ReusableComponents.wait(8000);
					String xpathToCheckEditAccountingPeriodPopup = ".//*[@class='actionBody']//*[contains(text(),'Edit "
							+ accountingPeriod + "')]";
					List<WebElement> editPopup = browser.findElements(By.xpath(xpathToCheckEditAccountingPeriodPopup));
					System.out.println("*********** editPopup size : " + editPopup.size());

					// Verify edit accounting period popup displayed
					if (editPopup.size() != 0) {
						// Change the status
						ReusableComponents.clickElement(statusDropDown_EditAccountingPeriod,
								"Click on status dropdown");
						ReusableComponents.wait(2000);

						if (!ReusableComponents.isDisplayed(selectStatusAsOpen_EditAccountingPeriod,
								"Check open is displayed")) {
							ReusableComponents.clickElement(statusDropDown_EditAccountingPeriod,
									"Click on status dropdown");
							ReusableComponents.wait(2000);
						}
						ReusableComponents.clickElement(selectStatusAsOpen_EditAccountingPeriod,
								"Select Open From the drop down");

						// Save the changes
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
		return new BankingLedgerPage(browser);
	}

	/**
	 * @see Title: [TB] On year end closing, Balance Sheet GL Accounts should have
	 *      Opening Balances populated.
	 * @author Wisefinch Menaka
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param appNameToSearch
	 * @param selectAppXpath
	 * @throws Exception
	 */
	public BankingLedgerPage test2691_YearEndClosingGLAccountOpeningBlancesPopulated(int threadID,
			List<String> tempList, String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLocation = reusableComponents.pathBuilder(path);
		String currentAccoutingPeriod;

		testCaseNumber = "Testcase2691";
		String ledgerValue = reusableComponents.getPropValues(testCaseNumber + "_LedgerValue");
		currentAccoutingPeriod = reusableComponents.getPropValues(testCaseNumber + "_" + "AccountingPeriodForTestCase");

		try {
			// --> Login to the webpage
			LoginToWebpage(threadID, tempList, pathLocation);

			// --> assign test case number to get data from config properties
			System.out.println("*********** testCaseNumber " + testCaseNumber);

			// --> Identify correct accounting year for this test case based on test data
			System.out.println("*********** currentAccoutingPeriod " + currentAccoutingPeriod);

			System.out.println("********** Accounting period test data for this test case : " + currentAccoutingPeriod);
			String strArray[] = currentAccoutingPeriod.split("-");
			String yearValue = strArray[0];
			String monthValue = strArray[1];
			int year = Integer.parseInt(strArray[0]);
			int month = Integer.parseInt(strArray[1]);

			// Accounting period for this testcase:
			// Ensure the previous year has some billings, payables or other records
			// posted to it. Then close the year end period (ex., 2016-12 or December). []
			// Keep the subsequent year beginning (ex., 2017-01 or January) open. **Use
			// this accounting period for the testcase.**

			if (monthValue.equalsIgnoreCase("01")) {
				System.out.println(
						"*********** Accounting period test data given as expected. Good to go with test case");

				ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
						"Accounting period input for this test testcase " + currentAccoutingPeriod, browser,
						pathLocation + "\\" + testcasemethod, false);
				// --> As part of test case creation planing to create test data with two
				// differnt accounting period of previous accounting year.

				year = year - 1;
				yearValue = Integer.toString(year);

				String openAccountingPeriodForTestDataCreation = yearValue.concat("-10");
				System.out.println(
						"*********** value of open accounting period : " + openAccountingPeriodForTestDataCreation);
				ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
						"Open accounting period " + openAccountingPeriodForTestDataCreation, browser,
						pathLocation + "\\" + testcasemethod, false);
				try {
					openAccountingPeriod(threadID, tempList, pathLocation, openAccountingPeriodForTestDataCreation);
				} catch (Exception e) {
					e.printStackTrace();
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Exception when trying to access account closer or open function" + e.getMessage(), browser,
							pathLocation + "\\" + testcasemethod, true);
				}

				// --> Check accounting period status
				String expectedAccountingPeriodStatus = "Open";
				Boolean actualAccountingPeriodStatus = false;
				actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
						openAccountingPeriodForTestDataCreation, expectedAccountingPeriodStatus);

				if (actualAccountingPeriodStatus) {
					System.out.println(
							"*********** Accounting period status displayed as expected to create test data. Accounting period : "
									+ openAccountingPeriodForTestDataCreation + ". Accounting period status "
									+ actualAccountingPeriodStatus);

					// --> Setting current accouting period value for test data creation. Note :
					// After successful test data creation I will change the
					// "currentAccountingPeriodForTheTestCase" value to the actual test data
					// provided for this test case
					currentAccountingPeriodForTheTestCase = openAccountingPeriodForTestDataCreation;

					System.out.println("********** Good to continue with test cases");

					// --> Test data creation create account --> Create new account
					try {
						createAccount(threadID, tempList, pathLocation);
					} catch (Exception e) {
						e.printStackTrace();
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There is a exception while creating test data" + e.getMessage(), browser,
								pathLocation + "\\" + testcasemethod, true);
					}

					// If new account creation is successful continue with test case else drop the
					// test
					if (accountCreatedStatus) {

						// --> Test data creation create account --> Create new billing
						try {
							createNewBilling(threadID, tempList, pathLocation);
						} catch (Exception e) {
							e.printStackTrace();
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"There is a exception while creating new billing test data" + e.getMessage(),
									browser, pathLocation + "\\" + testcasemethod, true);
						}

						// --> Test data creation create account --> Create new payable
						if (testDataNewBillingCreated) {
							try {
								createPayables(threadID, tempList, pathLocation);
							} catch (Exception e) {
								e.printStackTrace();
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"There is a exception while creating payables test data" + e.getMessage(),
										browser, pathLocation + "\\" + testcasemethod, true);
							}

							try {
								createPayables(threadID, tempList, pathLocation);
							} catch (Exception e) {
								e.printStackTrace();
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"There is a exception while creating payables test data" + e.getMessage(),
										browser, pathLocation + "\\" + testcasemethod, true);
							}

							// --> If both the test data's are created continue with the test case else drop
							// the test

							if (testDataNewBillingName != null && testDataNewPayableName != null) {
								System.out.println("********** Test data created with the accounting year "
										+ currentAccountingPeriodForTheTestCase);

								openAccountingPeriodForTestDataCreation = yearValue.concat("-11");
								System.out.println("*********** value of closePreviousAccountingPeriod : "
										+ openAccountingPeriodForTestDataCreation);

								ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
										"Open accounting period " + openAccountingPeriodForTestDataCreation, browser,
										pathLocation + "\\" + testcasemethod, false);

								try {
									openAccountingPeriod(threadID, tempList, pathLocation,
											openAccountingPeriodForTestDataCreation);
								} catch (Exception e) {
									e.printStackTrace();
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Exception when trying to access account closer or open function"
													+ e.getMessage(),
											browser, pathLocation + "\\" + testcasemethod, true);
								}

								// --> Check accounting period status
								expectedAccountingPeriodStatus = "Open";
								actualAccountingPeriodStatus = false;
								actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList,
										pathLocation, openAccountingPeriodForTestDataCreation,
										expectedAccountingPeriodStatus);

								if (actualAccountingPeriodStatus) {
									System.out.println(
											"*********** Accounting period status displayed as expected to create test data. Accounting period : "
													+ openAccountingPeriodForTestDataCreation
													+ ". Accounting period status " + actualAccountingPeriodStatus);
									// --> Setting current accouting period value for test data creation. Note :
									// After successful test data creation I will change the
									// "currentAccountingPeriodForTheTestCase" value to the actual test data
									// provided for this test case
									currentAccountingPeriodForTheTestCase = openAccountingPeriodForTestDataCreation;

									System.out.println("********** Good to continue with test cases");

									try {
										CashDisbursement(threadID, tempList, pathLocation);

									} catch (Exception e) {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Exception when trying to create new cash disbursement"
														+ e.getStackTrace(),
												browser, pathLocation + "\\" + testcasemethod, true);
									}

									if (testDataNewDisbursement) {
										System.out.println(
												" ********** As part of test data creation for the accounting year "
														+ currentAccountingPeriodForTheTestCase
														+ " new cash disbursement created, Good to go with test case");

										openAccountingPeriodForTestDataCreation = yearValue.concat("-11");
										System.out.println("*********** value of closePreviousAccountingPeriod : "
												+ openAccountingPeriodForTestDataCreation);

										ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
												"Open accounting period " + openAccountingPeriodForTestDataCreation,
												browser, pathLocation + "\\" + testcasemethod, false);

										try {
											openAccountingPeriod(threadID, tempList, pathLocation,
													openAccountingPeriodForTestDataCreation);
										} catch (Exception e) {
											e.printStackTrace();
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Exception when trying to access account closer or open function"
															+ e.getMessage(),
													browser, pathLocation + "\\" + testcasemethod, true);
										}

										// --> Check accounting period status
										expectedAccountingPeriodStatus = "Open";
										actualAccountingPeriodStatus = false;
										actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList,
												pathLocation, openAccountingPeriodForTestDataCreation,
												expectedAccountingPeriodStatus);

										if (actualAccountingPeriodStatus) {
											System.out.println(
													"*********** Accounting period status displayed as expected to create test data. Accounting period : "
															+ openAccountingPeriodForTestDataCreation
															+ ". Accounting period status "
															+ actualAccountingPeriodStatus);
											// --> Setting current accouting period value for test data creation.
											// Note :
											// After successful test data creation I will change the
											// "currentAccountingPeriodForTheTestCase" value to the actual test data
											// provided for this test case
											currentAccountingPeriodForTheTestCase = openAccountingPeriodForTestDataCreation;

											System.out.println("********** Good to continue with test cases");

											try {
												createCashReceipt(threadID, tempList, pathLocation);

											} catch (Exception e) {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Exception when trying to create cash receipt"
																+ e.getStackTrace(),
														browser, pathLocation + "\\" + testcasemethod, true);
											}

											// Test data created
											// Now close following accounting periods year-10, year-11, year-12.

											// First close year-10
											String previousAccountingPeriod = yearValue.concat("-10");
											System.out.println("********** previousAccountingPeriod to close : "
													+ previousAccountingPeriod);
											closeAccountingPeriod(threadID, tempList, pathLocation,
													previousAccountingPeriod);

											// --> Check accounting period status for year-10. It should be closed
											expectedAccountingPeriodStatus = "Closed";
											actualAccountingPeriodStatus = false;
											actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList,
													pathLocation, previousAccountingPeriod,
													expectedAccountingPeriodStatus);

											if (actualAccountingPeriodStatus) {
												System.out.println(
														"*********** Accounting period status displayed as expected Accounting period : "
																+ previousAccountingPeriod
																+ ". Accounting period status "
																+ actualAccountingPeriodStatus);

												System.out.println("********** Good to close next accounting year");

												// Next close year-11
												previousAccountingPeriod = yearValue.concat("-11");
												System.out.println("********** previousAccountingPeriod to close : "
														+ previousAccountingPeriod);
												closeAccountingPeriod(threadID, tempList, pathLocation,
														previousAccountingPeriod);

												// --> Check accounting period status for year-11. It should be
												// closed
												expectedAccountingPeriodStatus = "Closed";
												actualAccountingPeriodStatus = false;
												actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID,
														tempList, pathLocation, previousAccountingPeriod,
														expectedAccountingPeriodStatus);

												if (actualAccountingPeriodStatus) {
													System.out.println(
															"*********** Accounting period status displayed as expected . Accounting period : "
																	+ previousAccountingPeriod
																	+ ". Accounting period status "
																	+ actualAccountingPeriodStatus);

													System.out.println("********** Good to close next accounting year");

													// Next close year-12
													previousAccountingPeriod = yearValue.concat("-12");
													System.out.println("********** previousAccountingPeriod to close : "
															+ previousAccountingPeriod);
													closeAccountingPeriod(threadID, tempList, pathLocation,
															previousAccountingPeriod);

													// --> Check accounting period status for year-12. It should be
													// closed
													expectedAccountingPeriodStatus = "Closed";
													actualAccountingPeriodStatus = false;
													actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID,
															tempList, pathLocation, previousAccountingPeriod,
															expectedAccountingPeriodStatus);

													if (actualAccountingPeriodStatus) {
														System.out.println(
																"*********** Accounting period status displayed as expected to create test data. Accounting period : "
																		+ previousAccountingPeriod
																		+ ". Accounting period status "
																		+ actualAccountingPeriodStatus);

														currentAccountingPeriodForTheTestCase = currentAccoutingPeriod;

														System.out.println(
																"********** Good to open/check current test data year status");

														// --> check test data accounting period status. It should
														// be
														// open
														expectedAccountingPeriodStatus = "Open";
														actualAccountingPeriodStatus = false;
														actualAccountingPeriodStatus = checkAccountPeriodStatus(
																threadID, tempList, pathLocation,
																currentAccountingPeriodForTheTestCase,
																expectedAccountingPeriodStatus);

														if (actualAccountingPeriodStatus) {
															System.out.println(
																	"*********** Accounting period status displayed as expected. Accounting period : "
																			+ currentAccountingPeriodForTheTestCase
																			+ ". Accounting period status "
																			+ expectedAccountingPeriodStatus);

															/// Lauch NSFR
															// --> Select reports from search app
															selectAppFromSearchAppAndItem(threadID, tempList,
																	pathLocation, "Reports", selectReports);

															// --> Launch new NSF report
															openNewNativeSalesForceBalanceSheet(threadID, tempList,
																	pathLocation,
																	"Financial Cubes withorwithout Financial Cube Trans");

															// --> Added filter values

															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Accounting Period: Accounting Period Name",
																	"equal", currentAccountingPeriodForTheTestCase);
															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Cube Type", "equal", "Period");
															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Cube Type", "equal", "Retained Earnings");
															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Ledger: Ledger Name", "equal", ledgerValue);
															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Ledger Type", "equal", "Transactional");

															// -->Remove all the column present under NSF report preview
															// section

															nsfr_removeAlltheColumnPresentUnderPreviewSection(threadID,
																	tempList, pathLocation);

															// --> Add Opening Balance from field to preview section
															nsfr_addValuesFromFieldSearchToPreviewSection(threadID,
																	tempList, pathLocation, "Opening Balance");
															nsfr_PreviewSectionClickArrowmarkSummarizeOptionSum(
																	threadID, tempList, pathLocation,
																	arrowMarkNextToOpeningBalance);

															// --> Add Current Period from field to preview section
															nsfr_addValuesFromFieldSearchToPreviewSection(threadID,
																	tempList, pathLocation, "Current Period");
															nsfr_PreviewSectionClickArrowmarkSummarizeOptionSum(
																	threadID, tempList, pathLocation,
																	arrowMarkNextToCurrentPeriod);

															// --> Add Year To Date from field to preview section
															nsfr_addValuesFromFieldSearchToPreviewSection(threadID,
																	tempList, pathLocation, "Year To Date");
															nsfr_PreviewSectionClickArrowmarkSummarizeOptionSum(
																	threadID, tempList, pathLocation,
																	arrowMarkNextToYearToDate);

															// --> Add GL Account: GL Account Name from field to preview
															// section
															nsfr_addValuesFromFieldSearchToPreviewSection(threadID,
																	tempList, pathLocation,
																	"GL Account: GL Account Name");

															// --> Click on save and run. Add the saved report url to
															// extend report
															nsfr_ClickSaveAndRun(threadID, tempList, pathLocation,
																	"Financial Cubes withorwithout Financial Cube Trans");

															// Run Financial Report
															String financialReportsURL = reusableComponents
																	.getPropValues("FinancialReports");
															browser.get(financialReportsURL);
															// Browser.get is used here since there are issue in
															// launching financial report
															// from search app. Once the issue resolved we can comment
															// it and unccomment
															// selectAppFromSearchAppAndItem(threadID, tempList,
															// testcasemethod, "Financial
															// Reports",
															ReusableComponents.wait(5000);

															ReusableComponents.clickElement(
																	selectStandartReport_FinancialReport,
																	"Click Select standard reportd");
															ReusableComponents.wait(5000);
															ReusableComponents.clickElement(
																	trialBalance_selectStandartReport_FinancialReport,
																	"Click Select Trial Balance");
															ReusableComponents.wait(5000);

															ReusableComponents.clickElement(
																	clearSectionOfLedger_TrailBalance,
																	"Clear button of Ledger input box period");
															ReusableComponents.sendKey(ledgerTypeInputBox_TrailBalance,
																	ledgerValue, "Accounting period");
															String selcectLedgerValueXpath = "//lightning-base-combobox-formatted-text[@title='"
																	+ ledgerValue + "']";
															WebElement selectValueElement = browser
																	.findElement(By.xpath(selcectLedgerValueXpath));
															ReusableComponents.clickElement(selectValueElement,
																	"Select Ledger Type");

															ReusableComponents.clickElement(
																	startingAccoutPeriod_FinancialReport_Clear,
																	"Clear button of starting account period");
															ReusableComponents.sendKey(startingAccoutPeriodTrailBalance,
																	currentAccountingPeriodForTheTestCase,
																	"Accounting period");
															ReusableComponents.clickElement(
																	selectAccountingPeriod_FinancialReport,
																	"Select Starting account period");

															ReusableComponents.reportPass(threadID, tempList,
																	testcasemethod,
																	"Ledger and Accounting period values are given to run report",
																	browser, pathLocation + "\\" + testcasemethod,
																	false);
															ReusableComponents.reportSpecific(threadID, tempList,
																	testcasemethod, " ", browser,
																	pathLocation + "\\" + testcasemethod, true);

															ReusableComponents.scrollDown(browser, 500);
															// --> Click on run button and get new record URL

															List<WebElement> recordsList = browser.findElements(By
																	.xpath(".//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')]"));
															System.out.println("************ Number of elements "
																	+ recordsList.size());

															if (recordsList.size() != 0) {
																String oldRecordName = firstReport_FinancialReport
																		.getText();
																System.out.println(
																		"********* oldRecordName :" + oldRecordName);
																ReusableComponents.clickElement(
																		runButton_FinancialReport,
																		"Clicked on run button");
																ReusableComponents.reportPass(threadID, tempList,
																		testcasemethod, "Run button clicked", browser,
																		" ", false);

																ReusableComponents.wait(20000);

																String newRecord = firstReport_FinancialReport
																		.getText();

																if (!newRecord.contains("FRR")) {
																	ReusableComponents.wait(20000);

																	newRecord = firstReport_FinancialReport.getText();
																}

																System.out.println(
																		"*********** newRecord : " + newRecord);
																if (newRecord.contains("FRR")
																		&& !oldRecordName.equalsIgnoreCase(newRecord)) {
																	String hreflink = reusableComponents.getAttribute(
																			firstReport_FinancialReport, "href");
																	financialReportURL = hreflink;
																	ReusableComponents.reportPass(threadID, tempList,
																			testcasemethod,
																			"Created Financial report Name : "
																					+ newRecord
																					+ ". Link of created financial report : "
																					+ hreflink,
																			browser,
																			pathLocation + "\\" + testcasemethod,
																			false);
																	ReusableComponents.reportSpecific(threadID,
																			tempList, testcasemethod, " ", browser,
																			pathLocation + "\\" + testcasemethod, true);
																} else {

																	ReusableComponents.reportFail(threadID, tempList,
																			testcasemethod,
																			"There are no new records created, provide valid inputs ",
																			browser,
																			pathLocation + "\\" + testcasemethod, true);
																}
															} else {

																ReusableComponents.clickElement(
																		runButton_FinancialReport,
																		"Clicked on run button");
																ReusableComponents.reportPass(threadID, tempList,
																		testcasemethod, "Run button clicked", browser,
																		pathLocation + "\\" + testcasemethod, false);

																ReusableComponents.wait(20000);

																List<WebElement> newRecordsList = browser
																		.findElements(By.xpath(
																				"(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
																System.out.println("************ Number of elements "
																		+ newRecordsList.size());

																if (newRecordsList.size() == 0) {
																	ReusableComponents.reportFail(threadID, tempList,
																			testcasemethod,
																			"There are no new records created , please verify the input values",
																			browser,
																			pathLocation + "\\" + testcasemethod, true);
																} else {

																	String newRecord = firstReport_FinancialReport
																			.getText();

																	if (!newRecord.contains("FRR")) {
																		ReusableComponents.wait(20000);

																		newRecord = firstReport_FinancialReport
																				.getText();
																	}

																	if (newRecord.contains("FRR")) {
																		String hreflink = reusableComponents
																				.getAttribute(
																						firstReport_FinancialReport,
																						"href");
																		financialReportURL = hreflink;

																		ReusableComponents.reportPass(threadID,
																				tempList, testcasemethod,
																				"Created Financial report Name : "
																						+ newRecord
																						+ ". Link of created financial report : "
																						+ hreflink,
																				browser,
																				pathLocation + "\\" + testcasemethod,
																				false);
																		ReusableComponents.reportSpecific(threadID,
																				tempList, testcasemethod, " ", browser,
																				pathLocation + "\\" + testcasemethod,
																				true);
																	} else {
																		ReusableComponents.reportFail(threadID,
																				tempList, testcasemethod,
																				"There are no new records created , please verify the input values",
																				browser,
																				pathLocation + "\\" + testcasemethod,
																				true);
																	}
																}
															}

															ReusableComponents.reportPass(threadID, tempList,
																	testcasemethod,
																	"New NSFR name : " + reportName + " and its URL : "
																			+ nSFReportURL,
																	browser, pathLocation + "\\" + testcasemethod,
																	false);

														} else {
															ReusableComponents.reportFail(threadID, tempList,
																	testcasemethod,
																	"Accounting period "
																			+ currentAccountingPeriodForTheTestCase
																			+ " Status should be Open. However it is not true ",
																	browser, pathLocation + "\\" + testcasemethod,
																	true);
														}

													} else {
														ReusableComponents.reportFail(threadID, tempList,
																testcasemethod,
																"Accounting period " + previousAccountingPeriod
																		+ " Status should be closed. However it is not true ",
																browser, pathLocation + "\\" + testcasemethod, true);
													}

												} else {
													ReusableComponents.reportFail(threadID, tempList, testcasemethod,
															"Accounting period " + previousAccountingPeriod
																	+ " Status should be closed. Howeverit is not true",
															browser, pathLocation + "\\" + testcasemethod, true);
												}

											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Accounting period " + previousAccountingPeriod
																+ " Status should be closed. However it is not true",
														browser, pathLocation + "\\" + testcasemethod, true);
											}
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Accounting period status "
															+ openAccountingPeriodForTestDataCreation
															+ " should be open. However it is not true to continue with the test case.",
													browser, pathLocation + "\\" + testcasemethod, true);
										}

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"As part of test data creation for the accounting year "
														+ currentAccountingPeriodForTheTestCase
														+ " there are no new cash disbursement created, Hence can not continue with the test case",
												browser, pathLocation + "\\" + testcasemethod, true);
									}

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Accounting period status " + openAccountingPeriodForTestDataCreation
													+ " should be open. However it is not true to continue with the test case.",
											browser, pathLocation + "\\" + testcasemethod, true);
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"Billing / payables test data is not created with the accounting year "
												+ currentAccountingPeriodForTheTestCase,
										browser, pathLocation + "\\" + testcasemethod, true);
							}
						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"As part of test data creation no new billing created. Hence can not continue with the test case",
									browser, pathLocation + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"As part of test data creation ,there are no new account created, Hence can not create billing and payables",
								browser, pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Accounting period status is not displayed as expected to create test data. Accounting period : "
									+ openAccountingPeriodForTestDataCreation,
							browser, pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Accounting year for this test case should be year begining. Example 2020-01", browser,
						pathLocation + "\\" + testcasemethod, true);

			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception while executing this test case" + e.getMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * @see Title: [TB] On year end closing, Retained Earnings GL Accounts should
	 *      have Opening Balances populated if there were transactions
	 * @author Wisefinch Menaka
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param appNameToSearch
	 * @param selectAppXpath
	 * @throws Exception
	 */
	public BankingLedgerPage test2692_YearEndClosingRetainedEarningGLAccountOpeningBlancesPopulated(int threadID,
			List<String> tempList, String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLocation = reusableComponents.pathBuilder(path);
		String currentAccoutingPeriod;

		testCaseNumber = "Testcase2692";
		String ledgerValue = reusableComponents.getPropValues(testCaseNumber + "_LedgerValue");
		currentAccoutingPeriod = reusableComponents.getPropValues(testCaseNumber + "_" + "AccountingPeriodForTestCase");

		try {
			// --> Login to the webpage
			LoginToWebpage(threadID, tempList, pathLocation);

			// --> assign test case number to get data from config properties
			System.out.println("*********** testCaseNumber " + testCaseNumber);

			// --> Identify correct accounting year for this test case based on test data
			System.out.println("*********** currentAccoutingPeriod " + currentAccoutingPeriod);

			System.out.println("********** Accounting period test data for this test case : " + currentAccoutingPeriod);
			String strArray[] = currentAccoutingPeriod.split("-");
			String yearValue = strArray[0];
			String monthValue = strArray[1];
			int year = Integer.parseInt(strArray[0]);
			int month = Integer.parseInt(strArray[1]);

			// Accounting period for this testcase:
			// Ensure the previous year has some billings, payables or other records
			// posted to it. Then close the year end period (ex., 2016-12 or December). []
			// Keep the subsequent year beginning (ex., 2017-01 or January) open. **Use
			// this accounting period for the testcase.**

			if (monthValue.equalsIgnoreCase("01")) {
				System.out.println(
						"*********** Accounting period test data given as expected. Good to go with test case");

				ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
						"Accounting period input for this test testcase " + currentAccoutingPeriod, browser,
						pathLocation + "\\" + testcasemethod, false);
				// --> As part of test case creation planing to create test data with two
				// differnt accounting period of previous accounting year.

				year = year - 1;
				yearValue = Integer.toString(year);

				String openAccountingPeriodForTestDataCreation = yearValue.concat("-10");
				System.out.println(
						"*********** value of open accounting period : " + openAccountingPeriodForTestDataCreation);
				ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
						"Open accounting period " + openAccountingPeriodForTestDataCreation, browser,
						pathLocation + "\\" + testcasemethod, false);
				try {
					openAccountingPeriod(threadID, tempList, pathLocation, openAccountingPeriodForTestDataCreation);
				} catch (Exception e) {
					e.printStackTrace();
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Exception when trying to access account closer or open function" + e.getMessage(), browser,
							pathLocation + "\\" + testcasemethod, true);
				}

				// --> Check accounting period status
				String expectedAccountingPeriodStatus = "Open";
				Boolean actualAccountingPeriodStatus = false;
				actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
						openAccountingPeriodForTestDataCreation, expectedAccountingPeriodStatus);

				if (actualAccountingPeriodStatus) {
					System.out.println(
							"*********** Accounting period status displayed as expected to create test data. Accounting period : "
									+ openAccountingPeriodForTestDataCreation + ". Accounting period status "
									+ actualAccountingPeriodStatus);

					// --> Setting current accouting period value for test data creation. Note :
					// After successful test data creation I will change the
					// "currentAccountingPeriodForTheTestCase" value to the actual test data
					// provided for this test case
					currentAccountingPeriodForTheTestCase = openAccountingPeriodForTestDataCreation;

					System.out.println("********** Good to continue with test cases");

					// --> Test data creation create account --> Create new account
					try {
						createAccount(threadID, tempList, pathLocation);
					} catch (Exception e) {
						e.printStackTrace();
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There is a exception while creating test data" + e.getMessage(), browser,
								pathLocation + "\\" + testcasemethod, true);
					}

					// If new account creation is successful continue with test case else drop the
					// test
					if (accountCreatedStatus) {

						// --> Test data creation create account --> Create new billing
						try {
							createNewBilling(threadID, tempList, pathLocation);
						} catch (Exception e) {
							e.printStackTrace();
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"There is a exception while creating new billing test data" + e.getMessage(),
									browser, pathLocation + "\\" + testcasemethod, true);
						}

						// --> Test data creation create account --> Create new payable
						if (testDataNewBillingCreated) {
							try {
								createPayables(threadID, tempList, pathLocation);
							} catch (Exception e) {
								e.printStackTrace();
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"There is a exception while creating payables test data" + e.getMessage(),
										browser, pathLocation + "\\" + testcasemethod, true);
							}

							try {
								createPayables(threadID, tempList, pathLocation);
							} catch (Exception e) {
								e.printStackTrace();
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"There is a exception while creating payables test data" + e.getMessage(),
										browser, pathLocation + "\\" + testcasemethod, true);
							}

							// --> If both the test data's are created continue with the test case else drop
							// the test

							if (testDataNewBillingName != null && testDataNewPayableName != null) {
								System.out.println("********** Test data created with the accounting year "
										+ currentAccountingPeriodForTheTestCase);

								openAccountingPeriodForTestDataCreation = yearValue.concat("-11");
								System.out.println("*********** value of closePreviousAccountingPeriod : "
										+ openAccountingPeriodForTestDataCreation);

								ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
										"Open accounting period " + openAccountingPeriodForTestDataCreation, browser,
										pathLocation + "\\" + testcasemethod, false);

								try {
									openAccountingPeriod(threadID, tempList, pathLocation,
											openAccountingPeriodForTestDataCreation);
								} catch (Exception e) {
									e.printStackTrace();
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Exception when trying to access account closer or open function"
													+ e.getMessage(),
											browser, pathLocation + "\\" + testcasemethod, true);
								}

								// --> Check accounting period status
								expectedAccountingPeriodStatus = "Open";
								actualAccountingPeriodStatus = false;
								actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList,
										pathLocation, openAccountingPeriodForTestDataCreation,
										expectedAccountingPeriodStatus);

								if (actualAccountingPeriodStatus) {
									System.out.println(
											"*********** Accounting period status displayed as expected to create test data. Accounting period : "
													+ openAccountingPeriodForTestDataCreation
													+ ". Accounting period status " + actualAccountingPeriodStatus);
									// --> Setting current accouting period value for test data creation. Note :
									// After successful test data creation I will change the
									// "currentAccountingPeriodForTheTestCase" value to the actual test data
									// provided for this test case
									currentAccountingPeriodForTheTestCase = openAccountingPeriodForTestDataCreation;

									System.out.println("********** Good to continue with test cases");

									try {
										CashDisbursement(threadID, tempList, pathLocation);

									} catch (Exception e) {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Exception when trying to create new cash disbursement"
														+ e.getStackTrace(),
												browser, pathLocation + "\\" + testcasemethod, true);
									}

									if (testDataNewDisbursement) {
										System.out.println(
												" ********** As part of test data creation for the accounting year "
														+ currentAccountingPeriodForTheTestCase
														+ " new cash disbursement created, Good to go with test case");

										openAccountingPeriodForTestDataCreation = yearValue.concat("-11");
										System.out.println("*********** value of closePreviousAccountingPeriod : "
												+ openAccountingPeriodForTestDataCreation);

										ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
												"Open accounting period " + openAccountingPeriodForTestDataCreation,
												browser, pathLocation + "\\" + testcasemethod, false);

										try {
											openAccountingPeriod(threadID, tempList, pathLocation,
													openAccountingPeriodForTestDataCreation);
										} catch (Exception e) {
											e.printStackTrace();
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Exception when trying to access account closer or open function"
															+ e.getMessage(),
													browser, pathLocation + "\\" + testcasemethod, true);
										}

										// --> Check accounting period status
										expectedAccountingPeriodStatus = "Open";
										actualAccountingPeriodStatus = false;
										actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList,
												pathLocation, openAccountingPeriodForTestDataCreation,
												expectedAccountingPeriodStatus);

										if (actualAccountingPeriodStatus) {
											System.out.println(
													"*********** Accounting period status displayed as expected to create test data. Accounting period : "
															+ openAccountingPeriodForTestDataCreation
															+ ". Accounting period status "
															+ actualAccountingPeriodStatus);
											// --> Setting current accouting period value for test data creation.
											// Note :
											// After successful test data creation I will change the
											// "currentAccountingPeriodForTheTestCase" value to the actual test data
											// provided for this test case
											currentAccountingPeriodForTheTestCase = openAccountingPeriodForTestDataCreation;

											System.out.println("********** Good to continue with test cases");

											try {
												createCashReceipt(threadID, tempList, pathLocation);

											} catch (Exception e) {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Exception when trying to create cash receipt"
																+ e.getStackTrace(),
														browser, pathLocation + "\\" + testcasemethod, true);
											}

											// Test data created
											// Now close following accounting periods year-10, year-11, year-12.

											// First close year-10
											String previousAccountingPeriod = yearValue.concat("-10");
											System.out.println("********** previousAccountingPeriod to close : "
													+ previousAccountingPeriod);
											closeAccountingPeriod(threadID, tempList, pathLocation,
													previousAccountingPeriod);

											// --> Check accounting period status for year-10. It should be closed
											expectedAccountingPeriodStatus = "Closed";
											actualAccountingPeriodStatus = false;
											actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList,
													pathLocation, previousAccountingPeriod,
													expectedAccountingPeriodStatus);

											if (actualAccountingPeriodStatus) {
												System.out.println(
														"*********** Accounting period status displayed as expected Accounting period : "
																+ previousAccountingPeriod
																+ ". Accounting period status "
																+ actualAccountingPeriodStatus);

												System.out.println("********** Good to close next accounting year");

												// Next close year-11
												previousAccountingPeriod = yearValue.concat("-11");
												System.out.println("********** previousAccountingPeriod to close : "
														+ previousAccountingPeriod);
												closeAccountingPeriod(threadID, tempList, pathLocation,
														previousAccountingPeriod);

												// --> Check accounting period status for year-11. It should be
												// closed
												expectedAccountingPeriodStatus = "Closed";
												actualAccountingPeriodStatus = false;
												actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID,
														tempList, pathLocation, previousAccountingPeriod,
														expectedAccountingPeriodStatus);

												if (actualAccountingPeriodStatus) {
													System.out.println(
															"*********** Accounting period status displayed as expected . Accounting period : "
																	+ previousAccountingPeriod
																	+ ". Accounting period status "
																	+ actualAccountingPeriodStatus);

													System.out.println("********** Good to close next accounting year");

													// Next close year-12
													previousAccountingPeriod = yearValue.concat("-12");
													System.out.println("********** previousAccountingPeriod to close : "
															+ previousAccountingPeriod);
													closeAccountingPeriod(threadID, tempList, pathLocation,
															previousAccountingPeriod);

													// --> Check accounting period status for year-12. It should be
													// closed
													expectedAccountingPeriodStatus = "Closed";
													actualAccountingPeriodStatus = false;
													actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID,
															tempList, pathLocation, previousAccountingPeriod,
															expectedAccountingPeriodStatus);

													if (actualAccountingPeriodStatus) {
														System.out.println(
																"*********** Accounting period status displayed as expected to create test data. Accounting period : "
																		+ previousAccountingPeriod
																		+ ". Accounting period status "
																		+ actualAccountingPeriodStatus);

														currentAccountingPeriodForTheTestCase = currentAccoutingPeriod;

														System.out.println(
																"********** Good to open/check current test data year status");

														// --> check test data accounting period status. It should
														// be
														// open
														expectedAccountingPeriodStatus = "Open";
														actualAccountingPeriodStatus = false;
														actualAccountingPeriodStatus = checkAccountPeriodStatus(
																threadID, tempList, pathLocation,
																currentAccountingPeriodForTheTestCase,
																expectedAccountingPeriodStatus);

														if (actualAccountingPeriodStatus) {
															System.out.println(
																	"*********** Accounting period status displayed as expected. Accounting period : "
																			+ currentAccountingPeriodForTheTestCase
																			+ ". Accounting period status "
																			+ expectedAccountingPeriodStatus);

															/// Lauch NSFR
															// --> Select reports from search app
															selectAppFromSearchAppAndItem(threadID, tempList,
																	pathLocation, "Reports", selectReports);

															// --> Launch new NSF report
															openNewNativeSalesForceBalanceSheet(threadID, tempList,
																	pathLocation,
																	"Financial Cubes withorwithout Financial Cube Trans");

															// --> Added filter values

															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Accounting Period: Accounting Period Name",
																	"equal", currentAccountingPeriodForTheTestCase);
															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Cube Type", "equal", "Period");
															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Cube Type", "equal", "Retained Earnings");
															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Ledger: Ledger Name", "equal", ledgerValue);
															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Ledger Type", "equal", "Transactional");

															// -->Remove all the column present under NSF report preview
															// section

															nsfr_removeAlltheColumnPresentUnderPreviewSection(threadID,
																	tempList, pathLocation);

															// --> Add Opening Balance from field to preview section
															nsfr_addValuesFromFieldSearchToPreviewSection(threadID,
																	tempList, pathLocation, "Opening Balance");
															nsfr_PreviewSectionClickArrowmarkSummarizeOptionSum(
																	threadID, tempList, pathLocation,
																	arrowMarkNextToOpeningBalance);

															// --> Add Current Period from field to preview section
															nsfr_addValuesFromFieldSearchToPreviewSection(threadID,
																	tempList, pathLocation, "Current Period");
															nsfr_PreviewSectionClickArrowmarkSummarizeOptionSum(
																	threadID, tempList, pathLocation,
																	arrowMarkNextToCurrentPeriod);

															// --> Add Year To Date from field to preview section
															nsfr_addValuesFromFieldSearchToPreviewSection(threadID,
																	tempList, pathLocation, "Year To Date");
															nsfr_PreviewSectionClickArrowmarkSummarizeOptionSum(
																	threadID, tempList, pathLocation,
																	arrowMarkNextToYearToDate);

															// --> Add GL Account: GL Account Name from field to preview
															// section
															nsfr_addValuesFromFieldSearchToPreviewSection(threadID,
																	tempList, pathLocation,
																	"GL Account: GL Account Name");

															// --> Click on save and run. Add the saved report url to
															// extend report
															nsfr_ClickSaveAndRun(threadID, tempList, pathLocation,
																	"Financial Cubes withorwithout Financial Cube Trans");

															// Run Financial Report
															String financialReportsURL = reusableComponents
																	.getPropValues("FinancialReports");
															browser.get(financialReportsURL);
															// Browser.get is used here since there are issue in
															// launching financial report
															// from search app. Once the issue resolved we can comment
															// it and unccomment
															// selectAppFromSearchAppAndItem(threadID, tempList,
															// testcasemethod, "Financial
															// Reports",
															ReusableComponents.wait(5000);

															ReusableComponents.clickElement(
																	selectStandartReport_FinancialReport,
																	"Click Select standard reportd");
															ReusableComponents.wait(5000);
															ReusableComponents.clickElement(
																	trialBalance_selectStandartReport_FinancialReport,
																	"Click Select Trial Balance");
															ReusableComponents.wait(5000);

															ReusableComponents.clickElement(
																	clearSectionOfLedger_TrailBalance,
																	"Clear button of Ledger input box period");
															ReusableComponents.sendKey(ledgerTypeInputBox_TrailBalance,
																	ledgerValue, "Accounting period");
															String selcectLedgerValueXpath = "//lightning-base-combobox-formatted-text[@title='"
																	+ ledgerValue + "']";
															WebElement selectValueElement = browser
																	.findElement(By.xpath(selcectLedgerValueXpath));
															ReusableComponents.clickElement(selectValueElement,
																	"Select Ledger Type");

															ReusableComponents.clickElement(
																	startingAccoutPeriod_FinancialReport_Clear,
																	"Clear button of starting account period");
															ReusableComponents.sendKey(startingAccoutPeriodTrailBalance,
																	currentAccountingPeriodForTheTestCase,
																	"Accounting period");
															ReusableComponents.clickElement(
																	selectAccountingPeriod_FinancialReport,
																	"Select Starting account period");

															ReusableComponents.reportPass(threadID, tempList,
																	testcasemethod,
																	"Ledger and Accounting period values are given to run report",
																	browser, pathLocation + "\\" + testcasemethod,
																	false);
															ReusableComponents.reportSpecific(threadID, tempList,
																	testcasemethod, " ", browser,
																	pathLocation + "\\" + testcasemethod, true);

															ReusableComponents.scrollDown(browser, 500);
															// --> Click on run button and get new record URL

															List<WebElement> recordsList = browser.findElements(By
																	.xpath(".//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')]"));
															System.out.println("************ Number of elements "
																	+ recordsList.size());

															if (recordsList.size() != 0) {
																String oldRecordName = firstReport_FinancialReport
																		.getText();
																System.out.println(
																		"*********** oldRecordName : " + oldRecordName);
																ReusableComponents.clickElement(
																		runButton_FinancialReport,
																		"Clicked on run button");
																ReusableComponents.reportPass(threadID, tempList,
																		testcasemethod, "Run button clicked", browser,
																		" ", false);

																ReusableComponents.wait(20000);

																String newRecord = firstReport_FinancialReport
																		.getText();

																if (!newRecord.contains("FRR")) {
																	ReusableComponents.wait(20000);

																	newRecord = firstReport_FinancialReport.getText();
																}

																System.out.println(
																		"*********** newRecord : " + newRecord);
																if (newRecord.contains("FRR")
																		&& !oldRecordName.equalsIgnoreCase(newRecord)) {
																	String hreflink = reusableComponents.getAttribute(
																			firstReport_FinancialReport, "href");
																	financialReportURL = hreflink;
																	ReusableComponents.reportPass(threadID, tempList,
																			testcasemethod,
																			"Created Financial report Name : "
																					+ newRecord
																					+ ". Link of created financial report : "
																					+ hreflink,
																			browser,
																			pathLocation + "\\" + testcasemethod,
																			false);
																	ReusableComponents.reportSpecific(threadID,
																			tempList, testcasemethod, " ", browser,
																			pathLocation + "\\" + testcasemethod, true);
																} else {

																	ReusableComponents.reportFail(threadID, tempList,
																			testcasemethod,
																			"There are no new records created, provide valid inputs ",
																			browser,
																			pathLocation + "\\" + testcasemethod, true);
																}
															} else {

																ReusableComponents.clickElement(
																		runButton_FinancialReport,
																		"Clicked on run button");
																ReusableComponents.reportPass(threadID, tempList,
																		testcasemethod, "Run button clicked", browser,
																		pathLocation + "\\" + testcasemethod, false);

																ReusableComponents.wait(20000);

																List<WebElement> newRecordsList = browser
																		.findElements(By.xpath(
																				"(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
																System.out.println("************ Number of elements "
																		+ newRecordsList.size());

																if (newRecordsList.size() == 0) {
																	ReusableComponents.reportFail(threadID, tempList,
																			testcasemethod,
																			"There are no new records created , please verify the input values",
																			browser,
																			pathLocation + "\\" + testcasemethod, true);
																} else {

																	String newRecord = firstReport_FinancialReport
																			.getText();

																	if (!newRecord.contains("FRR")) {
																		ReusableComponents.wait(20000);

																		newRecord = firstReport_FinancialReport
																				.getText();
																	}

																	if (newRecord.contains("FRR")) {
																		String hreflink = reusableComponents
																				.getAttribute(
																						firstReport_FinancialReport,
																						"href");
																		financialReportURL = hreflink;

																		ReusableComponents.reportPass(threadID,
																				tempList, testcasemethod,
																				"Created Financial report Name : "
																						+ newRecord
																						+ ". Link of created financial report : "
																						+ hreflink,
																				browser,
																				pathLocation + "\\" + testcasemethod,
																				false);
																		ReusableComponents.reportSpecific(threadID,
																				tempList, testcasemethod, " ", browser,
																				pathLocation + "\\" + testcasemethod,
																				true);
																	} else {
																		ReusableComponents.reportFail(threadID,
																				tempList, testcasemethod,
																				"There are no new records created , please verify the input values",
																				browser,
																				pathLocation + "\\" + testcasemethod,
																				true);
																	}
																}
															}

															ReusableComponents.reportPass(threadID, tempList,
																	testcasemethod,
																	"New NSFR name : " + reportName + " and its URL : "
																			+ nSFReportURL,
																	browser, pathLocation + "\\" + testcasemethod,
																	false);

														} else {
															ReusableComponents.reportFail(threadID, tempList,
																	testcasemethod,
																	"Accounting period "
																			+ currentAccountingPeriodForTheTestCase
																			+ " Status should be Open. However it is not true ",
																	browser, pathLocation + "\\" + testcasemethod,
																	true);
														}

													} else {
														ReusableComponents.reportFail(threadID, tempList,
																testcasemethod,
																"Accounting period " + previousAccountingPeriod
																		+ " Status should be closed. However it is not true ",
																browser, pathLocation + "\\" + testcasemethod, true);
													}

												} else {
													ReusableComponents.reportFail(threadID, tempList, testcasemethod,
															"Accounting period " + previousAccountingPeriod
																	+ " Status should be closed. Howeverit is not true",
															browser, pathLocation + "\\" + testcasemethod, true);
												}

											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Accounting period " + previousAccountingPeriod
																+ " Status should be closed. However it is not true",
														browser, pathLocation + "\\" + testcasemethod, true);
											}
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Accounting period status "
															+ openAccountingPeriodForTestDataCreation
															+ " should be open. However it is not true to continue with the test case.",
													browser, pathLocation + "\\" + testcasemethod, true);
										}

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"As part of test data creation for the accounting year "
														+ currentAccountingPeriodForTheTestCase
														+ " there are no new cash disbursement created, Hence can not continue with the test case",
												browser, pathLocation + "\\" + testcasemethod, true);
									}

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Accounting period status " + openAccountingPeriodForTestDataCreation
													+ " should be open. However it is not true to continue with the test case.",
											browser, pathLocation + "\\" + testcasemethod, true);
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"Billing / payables test data is not created with the accounting year "
												+ currentAccountingPeriodForTheTestCase,
										browser, pathLocation + "\\" + testcasemethod, true);
							}
						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"As part of test data creation no new billing created. Hence can not continue with the test case",
									browser, pathLocation + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"As part of test data creation ,there are no new account created, Hence can not create billing and payables",
								browser, pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Accounting period status is not displayed as expected to create test data. Accounting period : "
									+ openAccountingPeriodForTestDataCreation,
							browser, pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Accounting year for this test case should be year begining. Example 2020-01", browser,
						pathLocation + "\\" + testcasemethod, true);

			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception while executing this test case" + e.getMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * @see [TB] On year end closing, Revenue and Expense GL Accounts show 0.00
	 *      Opening Balances
	 * @author Wisefinch Menaka
	 * 
	 * @param threadID
	 * @param tempList
	 * @param testcasemethod
	 * @param appNameToSearch
	 * @param selectAppXpath
	 * @throws Exception
	 */
	public BankingLedgerPage test2693_YearEndClosingExpenseGLAccountsShownZeroOnOpeningBalance(int threadID,
			List<String> tempList, String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLocation = reusableComponents.pathBuilder(path);
		String currentAccoutingPeriod;

		testCaseNumber = "Testcase2693";
		String ledgerValue = reusableComponents.getPropValues(testCaseNumber + "_LedgerValue");
		currentAccoutingPeriod = reusableComponents.getPropValues(testCaseNumber + "_" + "AccountingPeriodForTestCase");

		try {
			// --> Login to the webpage
			LoginToWebpage(threadID, tempList, pathLocation);

			// --> assign test case number to get data from config properties
			System.out.println("*********** testCaseNumber " + testCaseNumber);

			// --> Identify correct accounting year for this test case based on test data
			System.out.println("*********** currentAccoutingPeriod " + currentAccoutingPeriod);

			System.out.println("********** Accounting period test data for this test case : " + currentAccoutingPeriod);
			String strArray[] = currentAccoutingPeriod.split("-");
			String yearValue = strArray[0];
			String monthValue = strArray[1];
			int year = Integer.parseInt(strArray[0]);
			int month = Integer.parseInt(strArray[1]);

			// Accounting period for this testcase:
			// Ensure the previous year has some billings, payables or other records
			// posted to it. Then close the year end period (ex., 2016-12 or December). []
			// Keep the subsequent year beginning (ex., 2017-01 or January) open. **Use
			// this accounting period for the testcase.**

			if (monthValue.equalsIgnoreCase("01")) {
				System.out.println(
						"*********** Accounting period test data given as expected. Good to go with test case");

				ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
						"Accounting period input for this test testcase " + currentAccoutingPeriod, browser,
						pathLocation + "\\" + testcasemethod, false);
				// --> As part of test case creation planing to create test data with two
				// differnt accounting period of previous accounting year.

				year = year - 1;
				yearValue = Integer.toString(year);

				String openAccountingPeriodForTestDataCreation = yearValue.concat("-10");
				System.out.println(
						"*********** value of open accounting period : " + openAccountingPeriodForTestDataCreation);
				ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
						"Open accounting period " + openAccountingPeriodForTestDataCreation, browser,
						pathLocation + "\\" + testcasemethod, false);
				try {
					openAccountingPeriod(threadID, tempList, pathLocation, openAccountingPeriodForTestDataCreation);
				} catch (Exception e) {
					e.printStackTrace();
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Exception when trying to access account closer or open function" + e.getMessage(), browser,
							pathLocation + "\\" + testcasemethod, true);
				}

				// --> Check accounting period status
				String expectedAccountingPeriodStatus = "Open";
				Boolean actualAccountingPeriodStatus = false;
				actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
						openAccountingPeriodForTestDataCreation, expectedAccountingPeriodStatus);

				if (actualAccountingPeriodStatus) {
					System.out.println(
							"*********** Accounting period status displayed as expected to create test data. Accounting period : "
									+ openAccountingPeriodForTestDataCreation + ". Accounting period status "
									+ actualAccountingPeriodStatus);

					// --> Setting current accouting period value for test data creation. Note :
					// After successful test data creation I will change the
					// "currentAccountingPeriodForTheTestCase" value to the actual test data
					// provided for this test case
					currentAccountingPeriodForTheTestCase = openAccountingPeriodForTestDataCreation;

					System.out.println("********** Good to continue with test cases");

					// --> Test data creation create account --> Create new account
					try {
						createAccount(threadID, tempList, pathLocation);
					} catch (Exception e) {
						e.printStackTrace();
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There is a exception while creating test data" + e.getMessage(), browser,
								pathLocation + "\\" + testcasemethod, true);
					}

					// If new account creation is successful continue with test case else drop the
					// test
					if (accountCreatedStatus) {

						// --> Test data creation create account --> Create new billing
						try {
							createNewBilling(threadID, tempList, pathLocation);
						} catch (Exception e) {
							e.printStackTrace();
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"There is a exception while creating new billing test data" + e.getMessage(),
									browser, pathLocation + "\\" + testcasemethod, true);
						}

						// --> Test data creation create account --> Create new payable
						if (testDataNewBillingCreated) {
							try {
								createPayables(threadID, tempList, pathLocation);
							} catch (Exception e) {
								e.printStackTrace();
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"There is a exception while creating payables test data" + e.getMessage(),
										browser, pathLocation + "\\" + testcasemethod, true);
							}

							// --> If both the test data's are created continue with the test case else drop
							// the test

							if (testDataNewBillingName != null && testDataNewPayableName != null) {
								System.out.println("********** Test data created with the accounting year "
										+ currentAccountingPeriodForTheTestCase);

								openAccountingPeriodForTestDataCreation = yearValue.concat("-11");
								System.out.println("*********** value of closePreviousAccountingPeriod : "
										+ openAccountingPeriodForTestDataCreation);

								ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
										"Open accounting period " + openAccountingPeriodForTestDataCreation, browser,
										pathLocation + "\\" + testcasemethod, false);

								try {
									openAccountingPeriod(threadID, tempList, pathLocation,
											openAccountingPeriodForTestDataCreation);
								} catch (Exception e) {
									e.printStackTrace();
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Exception when trying to access account closer or open function"
													+ e.getMessage(),
											browser, pathLocation + "\\" + testcasemethod, true);
								}

								// --> Check accounting period status
								expectedAccountingPeriodStatus = "Open";
								actualAccountingPeriodStatus = false;
								actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList,
										pathLocation, openAccountingPeriodForTestDataCreation,
										expectedAccountingPeriodStatus);

								if (actualAccountingPeriodStatus) {
									System.out.println(
											"*********** Accounting period status displayed as expected to create test data. Accounting period : "
													+ openAccountingPeriodForTestDataCreation
													+ ". Accounting period status " + actualAccountingPeriodStatus);
									// --> Setting current accouting period value for test data creation. Note :
									// After successful test data creation I will change the
									// "currentAccountingPeriodForTheTestCase" value to the actual test data
									// provided for this test case
									currentAccountingPeriodForTheTestCase = openAccountingPeriodForTestDataCreation;

									System.out.println("********** Good to continue with test cases");

									try {
										CashDisbursement(threadID, tempList, pathLocation);

									} catch (Exception e) {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Exception when trying to create new cash disbursement"
														+ e.getStackTrace(),
												browser, pathLocation + "\\" + testcasemethod, true);
									}

									if (testDataNewDisbursement) {
										System.out.println(
												" ********** As part of test data creation for the accounting year "
														+ currentAccountingPeriodForTheTestCase
														+ " new cash disbursement created, Good to go with test case");

										openAccountingPeriodForTestDataCreation = yearValue.concat("-11");
										System.out.println("*********** value of closePreviousAccountingPeriod : "
												+ openAccountingPeriodForTestDataCreation);

										ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
												"Open accounting period " + openAccountingPeriodForTestDataCreation,
												browser, pathLocation + "\\" + testcasemethod, false);

										try {
											openAccountingPeriod(threadID, tempList, pathLocation,
													openAccountingPeriodForTestDataCreation);
										} catch (Exception e) {
											e.printStackTrace();
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Exception when trying to access account closer or open function"
															+ e.getMessage(),
													browser, pathLocation + "\\" + testcasemethod, true);
										}

										// --> Check accounting period status
										expectedAccountingPeriodStatus = "Open";
										actualAccountingPeriodStatus = false;
										actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList,
												pathLocation, openAccountingPeriodForTestDataCreation,
												expectedAccountingPeriodStatus);

										if (actualAccountingPeriodStatus) {
											System.out.println(
													"*********** Accounting period status displayed as expected to create test data. Accounting period : "
															+ openAccountingPeriodForTestDataCreation
															+ ". Accounting period status "
															+ actualAccountingPeriodStatus);
											// --> Setting current accouting period value for test data creation.
											// Note :
											// After successful test data creation I will change the
											// "currentAccountingPeriodForTheTestCase" value to the actual test data
											// provided for this test case
											currentAccountingPeriodForTheTestCase = openAccountingPeriodForTestDataCreation;

											System.out.println("********** Good to continue with test cases");

											try {
												createCashReceipt(threadID, tempList, pathLocation);

											} catch (Exception e) {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Exception when trying to create cash receipt"
																+ e.getStackTrace(),
														browser, pathLocation + "\\" + testcasemethod, true);
											}

											// Test data created
											// Now close following accounting periods year-10, year-11, year-12.

											// First close year-10
											String previousAccountingPeriod = yearValue.concat("-10");
											System.out.println("********** previousAccountingPeriod to close : "
													+ previousAccountingPeriod);
											closeAccountingPeriod(threadID, tempList, pathLocation,
													previousAccountingPeriod);

											// --> Check accounting period status for year-10. It should be closed
											expectedAccountingPeriodStatus = "Closed";
											actualAccountingPeriodStatus = false;
											actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList,
													pathLocation, previousAccountingPeriod,
													expectedAccountingPeriodStatus);

											if (actualAccountingPeriodStatus) {
												System.out.println(
														"*********** Accounting period status displayed as expected Accounting period : "
																+ previousAccountingPeriod
																+ ". Accounting period status "
																+ actualAccountingPeriodStatus);

												System.out.println("********** Good to close next accounting year");

												// Next close year-11
												previousAccountingPeriod = yearValue.concat("-11");
												System.out.println("********** previousAccountingPeriod to close : "
														+ previousAccountingPeriod);
												closeAccountingPeriod(threadID, tempList, pathLocation,
														previousAccountingPeriod);

												// --> Check accounting period status for year-11. It should be
												// closed
												expectedAccountingPeriodStatus = "Closed";
												actualAccountingPeriodStatus = false;
												actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID,
														tempList, pathLocation, previousAccountingPeriod,
														expectedAccountingPeriodStatus);

												if (actualAccountingPeriodStatus) {
													System.out.println(
															"*********** Accounting period status displayed as expected . Accounting period : "
																	+ previousAccountingPeriod
																	+ ". Accounting period status "
																	+ actualAccountingPeriodStatus);

													System.out.println("********** Good to close next accounting year");

													// Next close year-12
													previousAccountingPeriod = yearValue.concat("-12");
													System.out.println("********** previousAccountingPeriod to close : "
															+ previousAccountingPeriod);
													closeAccountingPeriod(threadID, tempList, pathLocation,
															previousAccountingPeriod);

													// --> Check accounting period status for year-12. It should be
													// closed
													expectedAccountingPeriodStatus = "Closed";
													actualAccountingPeriodStatus = false;
													actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID,
															tempList, pathLocation, previousAccountingPeriod,
															expectedAccountingPeriodStatus);

													if (actualAccountingPeriodStatus) {
														System.out.println(
																"*********** Accounting period status displayed as expected to create test data. Accounting period : "
																		+ previousAccountingPeriod
																		+ ". Accounting period status "
																		+ actualAccountingPeriodStatus);

														currentAccountingPeriodForTheTestCase = currentAccoutingPeriod;

														System.out.println(
																"********** Good to open/check current test data year status");

														// --> check test data accounting period status. It should
														// be
														// open
														expectedAccountingPeriodStatus = "Open";
														actualAccountingPeriodStatus = false;
														actualAccountingPeriodStatus = checkAccountPeriodStatus(
																threadID, tempList, pathLocation,
																currentAccountingPeriodForTheTestCase,
																expectedAccountingPeriodStatus);

														if (actualAccountingPeriodStatus) {
															System.out.println(
																	"*********** Accounting period status displayed as expected. Accounting period : "
																			+ currentAccountingPeriodForTheTestCase
																			+ ". Accounting period status "
																			+ expectedAccountingPeriodStatus);

															/// Lauch NSFR
															// --> Select reports from search app
															selectAppFromSearchAppAndItem(threadID, tempList,
																	pathLocation, "Reports", selectReports);

															// --> Launch new NSF report
															openNewNativeSalesForceBalanceSheet(threadID, tempList,
																	pathLocation, "Financial Cubes with Ledger");

															// --> Added filter values

															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Accounting Period", "equal",
																	currentAccountingPeriodForTheTestCase);
															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Cube Type", "equal", "Period");
															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Cube Type", "equal", "Retained Earnings");
															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Ledger: Ledger Name", "equal", ledgerValue);
															nsfr_selectFilter(threadID, tempList, pathLocation,
																	"Ledger Type", "equal", "Transactional");

															// -->Remove all the column present under NSF report preview
															// section

															nsfr_removeAlltheColumnPresentUnderPreviewSection(threadID,
																	tempList, pathLocation);

															// --> Add Opening Balance from field to preview section
															nsfr_addValuesFromFieldSearchToPreviewSection(threadID,
																	tempList, pathLocation, "Opening Balance");
															nsfr_PreviewSectionClickArrowmarkSummarizeOptionSum(
																	threadID, tempList, pathLocation,
																	arrowMarkNextToOpeningBalance);

															// --> Add Current Period from field to preview section
															nsfr_addValuesFromFieldSearchToPreviewSection(threadID,
																	tempList, pathLocation, "Current Period");
															nsfr_PreviewSectionClickArrowmarkSummarizeOptionSum(
																	threadID, tempList, pathLocation,
																	arrowMarkNextToCurrentPeriod);

															// --> Add Year To Date from field to preview section
															nsfr_addValuesFromFieldSearchToPreviewSection(threadID,
																	tempList, pathLocation, "Year To Date");
															nsfr_PreviewSectionClickArrowmarkSummarizeOptionSum(
																	threadID, tempList, pathLocation,
																	arrowMarkNextToYearToDate);

															// --> Add GL Account from field to preview section
															nsfr_addValuesFromFieldSearchToPreviewSection(threadID,
																	tempList, pathLocation, "GL Account");
															nsfr_PreviewSectionClickArrowmarkSummarizeOptionSum(
																	threadID, tempList, pathLocation,
																	arrowMarkGLAccount);

															// --> Click on save and run. Add the saved report url to
															// extend report
															nsfr_ClickSaveAndRun(threadID, tempList, pathLocation,
																	"Financial Cubes withorwithout Financial Cube Trans");

															// Run Financial Report
															String financialReportsURL = reusableComponents
																	.getPropValues("FinancialReports");
															browser.get(financialReportsURL);
															// Browser.get is used here since there are issue in
															// launching financial report
															// from search app. Once the issue resolved we can comment
															// it and unccomment
															// selectAppFromSearchAppAndItem(threadID, tempList,
															// testcasemethod, "Financial
															// Reports",
															ReusableComponents.wait(5000);

															ReusableComponents.clickElement(
																	selectStandartReport_FinancialReport,
																	"Click Select standard reportd");
															ReusableComponents.wait(5000);
															ReusableComponents.clickElement(
																	trialBalance_selectStandartReport_FinancialReport,
																	"Click Select Trial Balance");
															ReusableComponents.wait(5000);

															ReusableComponents.clickElement(
																	clearSectionOfLedger_TrailBalance,
																	"Clear button of Ledger input box period");
															ReusableComponents.sendKey(ledgerTypeInputBox_TrailBalance,
																	ledgerValue, "Accounting period");
															String selcectLedgerValueXpath = "//lightning-base-combobox-formatted-text[@title='"
																	+ ledgerValue + "']";
															WebElement selectValueElement = browser
																	.findElement(By.xpath(selcectLedgerValueXpath));
															ReusableComponents.clickElement(selectValueElement,
																	"Select Ledger Type");

															ReusableComponents.clickElement(
																	startingAccoutPeriod_FinancialReport_Clear,
																	"Clear button of starting account period");
															ReusableComponents.sendKey(startingAccoutPeriodTrailBalance,
																	currentAccountingPeriodForTheTestCase,
																	"Accounting period");
															ReusableComponents.clickElement(
																	selectAccountingPeriod_FinancialReport,
																	"Select Starting account period");

															ReusableComponents.reportPass(threadID, tempList,
																	testcasemethod,
																	"Ledger and Accounting period values are given to run report",
																	browser, pathLocation + "\\" + testcasemethod,
																	false);
															ReusableComponents.reportSpecific(threadID, tempList,
																	testcasemethod, " ", browser,
																	pathLocation + "\\" + testcasemethod, true);

															ReusableComponents.scrollDown(browser, 500);
															// --> Click on run button and get new record URL

															List<WebElement> recordsList = browser.findElements(By
																	.xpath(".//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')]"));
															System.out.println("************ Number of elements "
																	+ recordsList.size());

															if (recordsList.size() != 0) {
																String oldRecordName = firstReport_FinancialReport
																		.getText();
																System.out.println(
																		"*********** oldRecordName : " + oldRecordName);
																ReusableComponents.clickElement(
																		runButton_FinancialReport,
																		"Clicked on run button");
																ReusableComponents.reportPass(threadID, tempList,
																		testcasemethod, "Run button clicked", browser,
																		" ", false);

																ReusableComponents.wait(20000);

																String newRecord = firstReport_FinancialReport
																		.getText();

																if (!newRecord.contains("FRR")) {
																	ReusableComponents.wait(20000);

																	newRecord = firstReport_FinancialReport.getText();
																}

																System.out.println(
																		"*********** newRecord : " + newRecord);
																if (newRecord.contains("FRR")
																		&& !oldRecordName.equalsIgnoreCase(newRecord)) {
																	String hreflink = reusableComponents.getAttribute(
																			firstReport_FinancialReport, "href");
																	financialReportURL = hreflink;
																	ReusableComponents.reportPass(threadID, tempList,
																			testcasemethod,
																			"Created Financial report Name : "
																					+ newRecord
																					+ ". Link of created financial report : "
																					+ hreflink,
																			browser,
																			pathLocation + "\\" + testcasemethod,
																			false);
																	ReusableComponents.reportSpecific(threadID,
																			tempList, testcasemethod, " ", browser,
																			pathLocation + "\\" + testcasemethod, true);
																} else {

																	ReusableComponents.reportFail(threadID, tempList,
																			testcasemethod,
																			"There are no new records created, provide valid inputs ",
																			browser,
																			pathLocation + "\\" + testcasemethod, true);
																}
															} else {

																ReusableComponents.clickElement(
																		runButton_FinancialReport,
																		"Clicked on run button");
																ReusableComponents.reportPass(threadID, tempList,
																		testcasemethod, "Run button clicked", browser,
																		pathLocation + "\\" + testcasemethod, false);

																ReusableComponents.wait(20000);

																List<WebElement> newRecordsList = browser
																		.findElements(By.xpath(
																				"(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
																System.out.println("************ Number of elements "
																		+ newRecordsList.size());

																if (newRecordsList.size() == 0) {
																	ReusableComponents.reportFail(threadID, tempList,
																			testcasemethod,
																			"There are no new records created , please verify the input values",
																			browser,
																			pathLocation + "\\" + testcasemethod, true);
																} else {

																	String newRecord = firstReport_FinancialReport
																			.getText();

																	if (!newRecord.contains("FRR")) {
																		ReusableComponents.wait(20000);

																		newRecord = firstReport_FinancialReport
																				.getText();
																	}

																	if (newRecord.contains("FRR")) {
																		String hreflink = reusableComponents
																				.getAttribute(
																						firstReport_FinancialReport,
																						"href");
																		financialReportURL = hreflink;

																		ReusableComponents.reportPass(threadID,
																				tempList, testcasemethod,
																				"Created Financial report Name : "
																						+ newRecord
																						+ ". Link of created financial report : "
																						+ hreflink,
																				browser,
																				pathLocation + "\\" + testcasemethod,
																				false);
																		ReusableComponents.reportSpecific(threadID,
																				tempList, testcasemethod, " ", browser,
																				pathLocation + "\\" + testcasemethod,
																				true);
																	} else {
																		ReusableComponents.reportFail(threadID,
																				tempList, testcasemethod,
																				"There are no new records created , please verify the input values",
																				browser,
																				pathLocation + "\\" + testcasemethod,
																				true);
																	}
																}
															}

															ReusableComponents.reportPass(threadID, tempList,
																	testcasemethod,
																	"New NSFR name : " + reportName + " and its URL : "
																			+ nSFReportURL,
																	browser, pathLocation + "\\" + testcasemethod,
																	false);

														} else {
															ReusableComponents.reportFail(threadID, tempList,
																	testcasemethod,
																	"Accounting period "
																			+ currentAccountingPeriodForTheTestCase
																			+ " Status should be Open. However it is not true ",
																	browser, pathLocation + "\\" + testcasemethod,
																	true);
														}

													} else {
														ReusableComponents.reportFail(threadID, tempList,
																testcasemethod,
																"Accounting period " + previousAccountingPeriod
																		+ " Status should be closed. However it is not true ",
																browser, pathLocation + "\\" + testcasemethod, true);
													}

												} else {
													ReusableComponents.reportFail(threadID, tempList, testcasemethod,
															"Accounting period " + previousAccountingPeriod
																	+ " Status should be closed. Howeverit is not true",
															browser, pathLocation + "\\" + testcasemethod, true);
												}

											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod,
														"Accounting period " + previousAccountingPeriod
																+ " Status should be closed. However it is not true",
														browser, pathLocation + "\\" + testcasemethod, true);
											}
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"Accounting period status "
															+ openAccountingPeriodForTestDataCreation
															+ " should be open. However it is not true to continue with the test case.",
													browser, pathLocation + "\\" + testcasemethod, true);
										}

									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"As part of test data creation for the accounting year "
														+ currentAccountingPeriodForTheTestCase
														+ " there are no new cash disbursement created, Hence can not continue with the test case",
												browser, pathLocation + "\\" + testcasemethod, true);
									}

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Accounting period status " + openAccountingPeriodForTestDataCreation
													+ " should be open. However it is not true to continue with the test case.",
											browser, pathLocation + "\\" + testcasemethod, true);
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"Billing / payables test data is not created with the accounting year "
												+ currentAccountingPeriodForTheTestCase,
										browser, pathLocation + "\\" + testcasemethod, true);
							}
						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"As part of test data creation no new billing created. Hence can not continue with the test case",
									browser, pathLocation + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"As part of test data creation ,there are no new account created, Hence can not create billing and payables",
								browser, pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Accounting period status is not displayed as expected to create test data. Accounting period : "
									+ openAccountingPeriodForTestDataCreation,
							browser, pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Accounting year for this test case should be year begining. Example 2020-01", browser,
						pathLocation + "\\" + testcasemethod, true);

			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception while executing this test case" + e.getMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);

		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see Test case title : [TB] Verify formatting of negative and positive
	 *      amounts on the report.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public BankingLedgerPage test2622_TBVerifyFormettingOfNegativeAndPositive(int threadID, List<String> tempList,
			String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLocation = reusableComponents.pathBuilder(path);
		testCaseNumber = "Testcase2622";
		currentAccountingPeriodForTheTestCase = reusableComponents
				.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");
		String currentAccoutingPeriod = currentAccountingPeriodForTheTestCase;
		String ledgerValue = reusableComponents.getPropValues(testCaseNumber + "_LedgerValue");
		try {
			LoginToWebpage(threadID, tempList, pathLocation);

			System.out.println("********** Accounting period test data for this test case : " + currentAccoutingPeriod);

			// Verify current accounting period is open else cannot continue with the test
			// case
			String expectedAccountingPeriodStatus = "Open";
			Boolean actualAccountingPeriodStatus = false;
			actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
					currentAccoutingPeriod, expectedAccountingPeriodStatus);

			if (actualAccountingPeriodStatus) {

				String strArray[] = currentAccoutingPeriod.split("-");
				String yearValue = strArray[0];
				String monthValue = strArray[1];
				int year = Integer.parseInt(strArray[0]);
				int month = Integer.parseInt(strArray[1]);
				// check previous accounting year status is closed
				String previousAccountingPeriod;
				if (month == 1) {
					year = year - 1;
					month = 12;
					previousAccountingPeriod = Integer.toString(year) + "-" + (Integer.toString(month));
					System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
				} else {
					month = month - 1;

					if (month == 11 || month == 12 || month == 10) {
						previousAccountingPeriod = yearValue + "-" + Integer.toString(month);
						System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
					} else {
						previousAccountingPeriod = yearValue + "-0" + Integer.toString(month);
						System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
					}

				}

				// Previous accounting period should be closed.
				expectedAccountingPeriodStatus = "Closed";
				boolean previousAccountingPeriodStatus = false;
				previousAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
						previousAccountingPeriod, expectedAccountingPeriodStatus);

				if (previousAccountingPeriodStatus) {

					// --> Test data creation create account --> Create new account
					try {
						createAccount(threadID, tempList, pathLocation);
					} catch (Exception e) {
						e.printStackTrace();
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There is a exception while creating test data" + e.getMessage(), browser,
								pathLocation + "\\" + testcasemethod, true);
					}

					// If new account creation is successful continue with test case else drop the
					// test
					if (accountCreatedStatus) {

						// --> Test data creation create account --> Create new billing
						try {
							createNewBilling(threadID, tempList, pathLocation);
						} catch (Exception e) {
							e.printStackTrace();
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"There is a exception while creating new billing test data" + e.getMessage(),
									browser, pathLocation + "\\" + testcasemethod, true);
						}

						// --> Test data creation create account --> Create new payable
						if (testDataNewBillingCreated) {
							try {
								createPayables(threadID, tempList, pathLocation);
							} catch (Exception e) {
								e.printStackTrace();
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"There is a exception while creating payables test data" + e.getMessage(),
										browser, pathLocation + "\\" + testcasemethod, true);
							}

							if (newPayableStatus) {

								try {
									createCashReceipt(threadID, tempList, pathLocation);

								} catch (Exception e) {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Exception when trying to create cash receipt" + e.getStackTrace(), browser,
											pathLocation + "\\" + testcasemethod, true);
								}

								// Run Financial Report
								String financialReportsURL = reusableComponents.getPropValues("FinancialReports");
								browser.get(financialReportsURL);
								// Browser.get is used here since there are issue in launching financial report
								// from search app. Once the issue resolved we can comment it and unccomment
								// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
								// Reports",
								ReusableComponents.wait(5000);

								ReusableComponents.clickElement(selectStandartReport_FinancialReport,
										"Click Select standard reportd");
								ReusableComponents.wait(5000);
								ReusableComponents.clickElement(trialBalance_selectStandartReport_FinancialReport,
										"Click Select Trial Balance");
								ReusableComponents.wait(5000);

								ReusableComponents.clickElement(clearSectionOfLedger_TrailBalance,
										"Clear button of Ledger input box period");
								ReusableComponents.sendKey(ledgerTypeInputBox_TrailBalance, ledgerValue,
										"Accounting period");
								String selcectLedgerValueXpath = "//lightning-base-combobox-formatted-text[@title='"
										+ ledgerValue + "']";
								WebElement selectValueElement = browser.findElement(By.xpath(selcectLedgerValueXpath));
								ReusableComponents.clickElement(selectValueElement, "Select Ledger Type");

								ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
										"Clear button of starting account period");
								ReusableComponents.sendKey(startingAccoutPeriodTrailBalance,
										currentAccountingPeriodForTheTestCase, "Accounting period");
								ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
										"Select Starting account period");

								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Ledger and Accounting period values are given to run report", browser,
										pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								ReusableComponents.scrollDown(browser, 500);
								// --> Click on run button and get new record URL

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

									String newRecord = firstReport_FinancialReport.getText();

									if (!newRecord.contains("FRR")) {
										ReusableComponents.wait(20000);

										newRecord = firstReport_FinancialReport.getText();
									}

									System.out.println("*********** newRecord " + newRecord);
									if (newRecord.contains("FRR") && !oldRecordName.equalsIgnoreCase(newRecord)) {
										String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport,
												"href");
										financialReportURL = hreflink;
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"Created Financial report Name : " + newRecord
														+ ". Link of created financial report : " + hreflink,
												browser, pathLocation + "\\" + testcasemethod, false);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);
									} else {

										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"There are no new records created, provide valid inputs ", browser,
												pathLocation + "\\" + testcasemethod, true);
									}
								} else {

									ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Run button clicked", browser, pathLocation + "\\" + testcasemethod, false);

									ReusableComponents.wait(20000);

									List<WebElement> newRecordsList = browser.findElements(By
											.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
									System.out.println("************ Number of elements " + newRecordsList.size());

									if (newRecordsList.size() == 0) {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"There are no new records created , please verify the input values",
												browser, pathLocation + "\\" + testcasemethod, true);
									} else {

										String newRecord = firstReport_FinancialReport.getText();

										if (!newRecord.contains("FRR")) {
											ReusableComponents.wait(20000);

											newRecord = firstReport_FinancialReport.getText();
										}

										if (newRecord.contains("FRR")) {
											String hreflink = reusableComponents
													.getAttribute(firstReport_FinancialReport, "href");
											financialReportURL = hreflink;

											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Created Financial report Name : " + newRecord
															+ ". Link of created financial report : " + hreflink,
													browser, pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"There are no new records created , please verify the input values",
													browser, pathLocation + "\\" + testcasemethod, true);
										}
									}
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"As part of test data creation, there are no new payables created. Hence can not continue with the test case.",
										browser, pathLocation + "\\" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"As part of test data creation, there are no new billing created. Hence can not continue with the test case.",
									browser, pathLocation + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"As part of test data creation, there are no new accounts created. Hence can not continue with the test case.",
								browser, pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Previous Accounting period " + previousAccountingPeriod
									+ " status is not closed. Hence can not continue with the test case",
							browser, pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Accounting period " + currentAccoutingPeriod
								+ " status is not open. Hence can not continue with the test case",
						browser, pathLocation + "\\" + testcasemethod, true);
			}

		} catch (

		throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception during execution of test2622_TBVerifyFormettingOfNegativeAndPositive "
							+ e.getErrorMessage(),
					browser, pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {

			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception while executing test case test2622_TBVerifyFormettingOfNegativeAndPositive"
							+ e.getMessage(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see Test case title : [TB] If the 'Suppress Zero Amount Rows' checkbox is
	 *      unchecked the GL Accounts that don't have transactions posted have
	 *      '0.00'. .
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public BankingLedgerPage test2623_SupressZeroUncheckedGLAccountNoTransactionZero(int threadID,
			List<String> tempList, String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		/*
		 * String path = workingDir +
		 * reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		 * pathLocation = reusableComponents.pathBuilder(path);
		 */

		testCaseNumber = "Testcase2623";
		currentAccountingPeriodForTheTestCase = reusableComponents
				.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");
		String currentAccoutingPeriod = currentAccountingPeriodForTheTestCase;
		String ledgerValue = reusableComponents.getPropValues(testCaseNumber + "_LedgerValue");

		try {
			LoginToWebpage(threadID, tempList, pathLocation);

			System.out.println("********** Accounting period test data for this test case : " + currentAccoutingPeriod);

			// Verify current accounting period is open else cannot continue with the test
			// case
			String expectedAccountingPeriodStatus = "Open";
			Boolean actualAccountingPeriodStatus = false;
			actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
					currentAccoutingPeriod, expectedAccountingPeriodStatus);

			if (actualAccountingPeriodStatus) {

				String strArray[] = currentAccoutingPeriod.split("-");
				String yearValue = strArray[0];
				String monthValue = strArray[1];
				int year = Integer.parseInt(strArray[0]);
				int month = Integer.parseInt(strArray[1]);
				// check previous accounting year status is closed
				String previousAccountingPeriod;
				if (month == 1) {
					year = year - 1;
					month = 12;
					previousAccountingPeriod = Integer.toString(year) + "-" + (Integer.toString(month));
					System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
				} else {
					month = month - 1;

					if (month == 11 || month == 12 || month == 10) {
						previousAccountingPeriod = yearValue + "-" + Integer.toString(month);
						System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
					} else {
						previousAccountingPeriod = yearValue + "-0" + Integer.toString(month);
						System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
					}

				}

				// Previous accounting period should be closed.
				expectedAccountingPeriodStatus = "Closed";
				boolean previousAccountingPeriodStatus = false;
				previousAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
						previousAccountingPeriod, expectedAccountingPeriodStatus);

				if (previousAccountingPeriodStatus) {

					// --> Test data creation create account --> Create new account
					try {
						createAccount(threadID, tempList, pathLocation);
					} catch (Exception e) {
						e.printStackTrace();
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There is a exception while creating test data" + e.getMessage(), browser,
								pathLocation + "\\" + testcasemethod, true);
					}

					// If new account creation is successful continue with test case else drop the
					// test
					if (accountCreatedStatus) {

						// --> Test data creation create account --> Create new billing
						try {
							createNewBilling(threadID, tempList, pathLocation);
						} catch (Exception e) {
							e.printStackTrace();
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"There is a exception while creating new billing test data" + e.getMessage(),
									browser, pathLocation + "\\" + testcasemethod, true);
						}

						// --> Test data creation create account --> Create new payable
						if (testDataNewBillingCreated) {
							try {
								createPayables(threadID, tempList, pathLocation);
							} catch (Exception e) {
								e.printStackTrace();
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"There is a exception while creating payables test data" + e.getMessage(),
										browser, pathLocation + "\\" + testcasemethod, true);
							}

							if (newPayableStatus) {

								try {
									createGLAccount(threadID, tempList, pathLocation);

								} catch (Exception e) {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Exception when trying to create new GL account" + e.getStackTrace(),
											browser, pathLocation + "\\" + testcasemethod, true);
								}

								// Run Financial Report
								String financialReportsURL = reusableComponents.getPropValues("FinancialReports");
								browser.get(financialReportsURL);
								// Browser.get is used here since there are issue in launching financial report
								// from search app. Once the issue resolved we can comment it and unccomment
								// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
								// Reports",
								ReusableComponents.wait(5000);

								ReusableComponents.clickElement(selectStandartReport_FinancialReport,
										"Click Select standard reportd");
								ReusableComponents.wait(5000);
								ReusableComponents.clickElement(trialBalance_selectStandartReport_FinancialReport,
										"Click Select Trial Balance");
								ReusableComponents.wait(5000);

								ReusableComponents.clickElement(clearSectionOfLedger_TrailBalance,
										"Clear button of Ledger input box period");
								ReusableComponents.sendKey(ledgerTypeInputBox_TrailBalance, ledgerValue,
										"Accounting period");
								String selcectLedgerValueXpath = "//lightning-base-combobox-formatted-text[@title='"
										+ ledgerValue + "']";
								WebElement selectValueElement = browser.findElement(By.xpath(selcectLedgerValueXpath));
								ReusableComponents.clickElement(selectValueElement, "Select Ledger Type");

								ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
										"Clear button of starting account period");
								ReusableComponents.sendKey(startingAccoutPeriodTrailBalance,
										currentAccountingPeriodForTheTestCase, "Accounting period");
								ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
										"Select Starting account period");

								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Ledger and Accounting period values are given to run report", browser,
										pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								// Uncheck supress zero amount check box
								ReusableComponents.clickElement(supressZeroAmountCheckBox,
										"Click Supress zero amount check box");
								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"By default, Supress Zero amount check box will be checked. We did click once, so the assumption will be the check box is unchecked",
										browser, pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								ReusableComponents.scrollDown(browser, 500);
								// --> Click on run button and get new record URL

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

									String newRecord = firstReport_FinancialReport.getText();

									if (!newRecord.contains("FRR")) {
										ReusableComponents.wait(20000);

										newRecord = firstReport_FinancialReport.getText();
									}

									System.out.println("*********** newRecord " + newRecord);
									if (newRecord.contains("FRR") && !oldRecordName.equalsIgnoreCase(newRecord)) {
										String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport,
												"href");
										financialReportURL = hreflink;
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"Created Financial report Name : " + newRecord
														+ ". Link of created financial report : " + hreflink,
												browser, pathLocation + "\\" + testcasemethod, false);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);
									} else {

										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"There are no new records created, provide valid inputs ", browser,
												pathLocation + "\\" + testcasemethod, true);
									}
								} else {

									ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Run button clicked", browser, pathLocation + "\\" + testcasemethod, false);

									ReusableComponents.wait(20000);

									List<WebElement> newRecordsList = browser.findElements(By
											.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
									System.out.println("************ Number of elements " + newRecordsList.size());

									if (newRecordsList.size() == 0) {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"There are no new records created , please verify the input values",
												browser, pathLocation + "\\" + testcasemethod, true);
									} else {

										String newRecord = firstReport_FinancialReport.getText();

										if (!newRecord.contains("FRR")) {
											ReusableComponents.wait(20000);

											newRecord = firstReport_FinancialReport.getText();
										}

										if (newRecord.contains("FRR")) {
											String hreflink = reusableComponents
													.getAttribute(firstReport_FinancialReport, "href");
											financialReportURL = hreflink;

											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Created Financial report Name : " + newRecord
															+ ". Link of created financial report : " + hreflink,
													browser, pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"There are no new records created , please verify the input values",
													browser, pathLocation + "\\" + testcasemethod, true);
										}
									}
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"As part of test data creation, there are no new payables created. Hence can not continue with the test case.",
										browser, pathLocation + "\\" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"As part of test data creation, there are no new billing created. Hence can not continue with the test case.",
									browser, pathLocation + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"As part of test data creation, there are no new accounts created. Hence can not continue with the test case.",
								browser, pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Previous Accounting period " + previousAccountingPeriod
									+ " status is not closed. Hence can not continue with the test case",
							browser, pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Accounting period " + currentAccoutingPeriod
								+ " status is not open. Hence can not continue with the test case",
						browser, pathLocation + "\\" + testcasemethod, true);
			}

		} catch (

		throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception during execution of test2622_TBVerifyFormettingOfNegativeAndPositive "
							+ e.getErrorMessage(),
					browser, pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {

			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception while executing test case test2622_TBVerifyFormettingOfNegativeAndPositive"
							+ e.getMessage(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see Test case title : [TB] If the 'Suppress Zero Amount Rows' checkbox is
	 *      checked before running the report only GL accounts that have
	 *      transactions posted to them are shown.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public BankingLedgerPage test2624_SupressZeroCheckGLAccount(int threadID, List<String> tempList,
			String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		/*
		 * String path = workingDir +
		 * reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		 * pathLocation = reusableComponents.pathBuilder(path);
		 */

		System.out.println("********** pathLocation Inside Test 2624 : " + pathLocation);

		testCaseNumber = "Testcase2624";
		currentAccountingPeriodForTheTestCase = reusableComponents
				.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");

		String currentAccoutingPeriod = currentAccountingPeriodForTheTestCase;
		String ledgerValue = reusableComponents.getPropValues(testCaseNumber + "_LedgerValue");
		try {
			LoginToWebpage(threadID, tempList, pathLocation);

			System.out.println("********** Accounting period test data for this test case : " + currentAccoutingPeriod);

			// Verify current accounting period is open else cannot continue with the test
			// case
			String expectedAccountingPeriodStatus = "Open";
			Boolean actualAccountingPeriodStatus = false;
			actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
					currentAccoutingPeriod, expectedAccountingPeriodStatus);

			if (actualAccountingPeriodStatus) {

				String strArray[] = currentAccoutingPeriod.split("-");
				String yearValue = strArray[0];
				String monthValue = strArray[1];
				int year = Integer.parseInt(strArray[0]);
				int month = Integer.parseInt(strArray[1]);
				// check previous accounting year status is closed
				String previousAccountingPeriod;
				if (month == 1) {
					year = year - 1;
					month = 12;
					previousAccountingPeriod = Integer.toString(year) + "-" + (Integer.toString(month));
					System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
				} else {
					month = month - 1;

					if (month == 11 || month == 12 || month == 10) {
						previousAccountingPeriod = yearValue + "-" + Integer.toString(month);
						System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
					} else {
						previousAccountingPeriod = yearValue + "-0" + Integer.toString(month);
						System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
					}

				}

				// Previous accounting period should be closed.
				expectedAccountingPeriodStatus = "Closed";
				boolean previousAccountingPeriodStatus = false;
				previousAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
						previousAccountingPeriod, expectedAccountingPeriodStatus);

				if (previousAccountingPeriodStatus) {

					// --> Test data creation create account --> Create new account
					try {
						createAccount(threadID, tempList, pathLocation);
					} catch (Exception e) {
						e.printStackTrace();
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There is a exception while creating test data" + e.getMessage(), browser,
								pathLocation + "\\" + testcasemethod, true);
					}

					// If new account creation is successful continue with test case else drop the
					// test
					if (accountCreatedStatus) {

						// --> Test data creation create account --> Create new billing
						try {
							createNewBilling(threadID, tempList, pathLocation);
						} catch (Exception e) {
							e.printStackTrace();
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"There is a exception while creating new billing test data" + e.getMessage(),
									browser, pathLocation + "\\" + testcasemethod, true);
						}

						// --> Test data creation create account --> Create new payable
						if (testDataNewBillingCreated) {
							try {
								createPayables(threadID, tempList, pathLocation);
							} catch (Exception e) {
								e.printStackTrace();
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"There is a exception while creating payables test data" + e.getMessage(),
										browser, pathLocation + "\\" + testcasemethod, true);
							}

							if (newPayableStatus) {

								try {
									createGLAccount(threadID, tempList, pathLocation);

								} catch (Exception e) {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"Exception when trying to create new GL account" + e.getStackTrace(),
											browser, pathLocation + "\\" + testcasemethod, true);
								}

								// Run Financial Report
								String financialReportsURL = reusableComponents.getPropValues("FinancialReports");
								browser.get(financialReportsURL);
								// Browser.get is used here since there are issue in launching financial report
								// from search app. Once the issue resolved we can comment it and unccomment
								// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
								// Reports",
								ReusableComponents.wait(5000);

								ReusableComponents.clickElement(selectStandartReport_FinancialReport,
										"Click Select standard reportd");
								ReusableComponents.wait(5000);
								ReusableComponents.clickElement(trialBalance_selectStandartReport_FinancialReport,
										"Click Select Trial Balance");
								ReusableComponents.wait(5000);

								ReusableComponents.clickElement(clearSectionOfLedger_TrailBalance,
										"Clear button of Ledger input box period");
								ReusableComponents.sendKey(ledgerTypeInputBox_TrailBalance, ledgerValue,
										"Accounting period");
								String selcectLedgerValueXpath = "//lightning-base-combobox-formatted-text[@title='"
										+ ledgerValue + "']";
								WebElement selectValueElement = browser.findElement(By.xpath(selcectLedgerValueXpath));
								ReusableComponents.clickElement(selectValueElement, "Select Ledger Type");

								ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
										"Clear button of starting account period");
								ReusableComponents.sendKey(startingAccoutPeriodTrailBalance,
										currentAccountingPeriodForTheTestCase, "Accounting period");
								ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
										"Select Starting account period");

								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Ledger and Accounting period values are given to run report", browser,
										pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								// check supress zero amount check box

								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"By default, Supress Zero amount check box will be checked. So the assumption will be the check box is checked",
										browser, pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								ReusableComponents.scrollDown(browser, 500);
								// --> Click on run button and get new record URL

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

									String newRecord = firstReport_FinancialReport.getText();

									if (!newRecord.contains("FRR")) {
										ReusableComponents.wait(20000);

										newRecord = firstReport_FinancialReport.getText();
									}

									System.out.println("*********** newRecord " + newRecord);
									if (newRecord.contains("FRR") && !oldRecordName.equalsIgnoreCase(newRecord)) {
										String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport,
												"href");
										financialReportURL = hreflink;
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"Created Financial report Name : " + newRecord
														+ ". Link of created financial report : " + hreflink,
												browser, pathLocation + "\\" + testcasemethod, false);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);
									} else {

										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"There are no new records created, provide valid inputs ", browser,
												pathLocation + "\\" + testcasemethod, true);
									}
								} else {

									ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Run button clicked", browser, pathLocation + "\\" + testcasemethod, false);

									ReusableComponents.wait(20000);

									List<WebElement> newRecordsList = browser.findElements(By
											.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
									System.out.println("************ Number of elements " + newRecordsList.size());

									if (newRecordsList.size() == 0) {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"There are no new records created , please verify the input values",
												browser, pathLocation + "\\" + testcasemethod, true);
									} else {

										String newRecord = firstReport_FinancialReport.getText();

										if (!newRecord.contains("FRR")) {
											ReusableComponents.wait(20000);

											newRecord = firstReport_FinancialReport.getText();
										}

										if (newRecord.contains("FRR")) {
											String hreflink = reusableComponents
													.getAttribute(firstReport_FinancialReport, "href");
											financialReportURL = hreflink;

											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Created Financial report Name : " + newRecord
															+ ". Link of created financial report : " + hreflink,
													browser, pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"There are no new records created , please verify the input values",
													browser, pathLocation + "\\" + testcasemethod, true);
										}
									}
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"As part of test data creation, there are no new payables created. Hence can not continue with the test case.",
										browser, pathLocation + "\\" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"As part of test data creation, there are no new billing created. Hence can not continue with the test case.",
									browser, pathLocation + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"As part of test data creation, there are no new accounts created. Hence can not continue with the test case.",
								browser, pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Previous Accounting period " + previousAccountingPeriod
									+ " status is not closed. Hence can not continue with the test case",
							browser, pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Accounting period " + currentAccoutingPeriod
								+ " status is not open. Hence can not continue with the test case",
						browser, pathLocation + "\\" + testcasemethod, true);
			}

		} catch (

		throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception during execution of test2622_TBVerifyFormettingOfNegativeAndPositive "
							+ e.getErrorMessage(),
					browser, pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {

			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception while executing test case test2622_TBVerifyFormettingOfNegativeAndPositive"
							+ e.getMessage(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see [TB] Verify that the Trial Balance report can be run for the current
	 *      (first open) period.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public BankingLedgerPage test2625_SupressZeroUncheckedGLAccountNoTransactionZero(int threadID,
			List<String> tempList, String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		/*
		 * String path = workingDir +
		 * reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		 * pathLocation = reusableComponents.pathBuilder(path);
		 */

		testCaseNumber = "Testcase2625";
		currentAccountingPeriodForTheTestCase = reusableComponents
				.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");
		String currentAccoutingPeriod = currentAccountingPeriodForTheTestCase;
		String ledgerValue = reusableComponents.getPropValues(testCaseNumber + "_LedgerValue");

		try {
			LoginToWebpage(threadID, tempList, pathLocation);

			System.out.println("********** Accounting period test data for this test case : " + currentAccoutingPeriod);

			// Verify current accounting period is open else cannot continue with the test
			// case
			String expectedAccountingPeriodStatus = "Open";
			Boolean actualAccountingPeriodStatus = false;
			actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
					currentAccoutingPeriod, expectedAccountingPeriodStatus);

			if (actualAccountingPeriodStatus) {

				String strArray[] = currentAccoutingPeriod.split("-");
				String yearValue = strArray[0];
				String monthValue = strArray[1];
				int year = Integer.parseInt(strArray[0]);
				int month = Integer.parseInt(strArray[1]);
				// check previous accounting year status is closed
				String previousAccountingPeriod;
				if (month == 1) {
					year = year - 1;
					month = 12;
					previousAccountingPeriod = Integer.toString(year) + "-" + (Integer.toString(month));
					System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
				} else {
					month = month - 1;

					if (month == 11 || month == 12 || month == 10) {
						previousAccountingPeriod = yearValue + "-" + Integer.toString(month);
						System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
					} else {
						previousAccountingPeriod = yearValue + "-0" + Integer.toString(month);
						System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
					}

				}

				// Previous accounting period should be closed.
				expectedAccountingPeriodStatus = "Closed";
				boolean previousAccountingPeriodStatus = false;
				previousAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
						previousAccountingPeriod, expectedAccountingPeriodStatus);

				if (previousAccountingPeriodStatus) {

					// --> Test data creation create account --> Create new account
					try {
						createAccount(threadID, tempList, pathLocation);
					} catch (Exception e) {
						e.printStackTrace();
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There is a exception while creating test data" + e.getMessage(), browser,
								pathLocation + "\\" + testcasemethod, true);
					}

					// If new account creation is successful continue with test case else drop the
					// test
					if (accountCreatedStatus) {

						// --> Test data creation create account --> Create new billing
						try {
							createNewBilling(threadID, tempList, pathLocation);
						} catch (Exception e) {
							e.printStackTrace();
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"There is a exception while creating new billing test data" + e.getMessage(),
									browser, pathLocation + "\\" + testcasemethod, true);
						}

						// --> Test data creation create account --> Create new payable
						if (testDataNewBillingCreated) {
							try {
								createPayables(threadID, tempList, pathLocation);
							} catch (Exception e) {
								e.printStackTrace();
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"There is a exception while creating payables test data" + e.getMessage(),
										browser, pathLocation + "\\" + testcasemethod, true);
							}

							if (newPayableStatus) {

								// Run Financial Report
								String financialReportsURL = reusableComponents.getPropValues("FinancialReports");
								browser.get(financialReportsURL);
								// Browser.get is used here since there are issue in launching financial report
								// from search app. Once the issue resolved we can comment it and unccomment
								// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
								// Reports",
								ReusableComponents.wait(5000);

								ReusableComponents.clickElement(selectStandartReport_FinancialReport,
										"Click Select standard reportd");
								ReusableComponents.wait(5000);
								ReusableComponents.clickElement(trialBalance_selectStandartReport_FinancialReport,
										"Click Select Trial Balance");
								ReusableComponents.wait(5000);

								ReusableComponents.clickElement(clearSectionOfLedger_TrailBalance,
										"Clear button of Ledger input box period");
								ReusableComponents.sendKey(ledgerTypeInputBox_TrailBalance, ledgerValue,
										"Accounting period");
								String selcectLedgerValueXpath = "//lightning-base-combobox-formatted-text[@title='"
										+ ledgerValue + "']";
								WebElement selectValueElement = browser.findElement(By.xpath(selcectLedgerValueXpath));
								ReusableComponents.clickElement(selectValueElement, "Select Ledger Type");

								ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
										"Clear button of starting account period");
								ReusableComponents.sendKey(startingAccoutPeriodTrailBalance,
										currentAccountingPeriodForTheTestCase, "Accounting period");
								ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
										"Select Starting account period");

								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Ledger and Accounting period values are given to run report", browser,
										pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								// Uncheck supress zero amount check box
								ReusableComponents.clickElement(supressZeroAmountCheckBox,
										"Click Supress zero amount check box");
								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"By default, Supress Zero amount check box will be checked. We did click once, so the assumption will be the check box is unchecked",
										browser, pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								ReusableComponents.scrollDown(browser, 500);
								// --> Click on run button and get new record URL

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

									String newRecord = firstReport_FinancialReport.getText();

									if (!newRecord.contains("FRR")) {
										ReusableComponents.wait(20000);

										newRecord = firstReport_FinancialReport.getText();
									}

									System.out.println("*********** newRecord " + newRecord);
									if (newRecord.contains("FRR") && !oldRecordName.equalsIgnoreCase(newRecord)) {
										String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport,
												"href");
										financialReportURL = hreflink;
										ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												"Created Financial report Name : " + newRecord
														+ ". Link of created financial report : " + hreflink,
												browser, pathLocation + "\\" + testcasemethod, false);
										ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
												browser, pathLocation + "\\" + testcasemethod, true);
									} else {

										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"There are no new records created, provide valid inputs ", browser,
												pathLocation + "\\" + testcasemethod, true);
									}
								} else {

									ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Run button clicked", browser, pathLocation + "\\" + testcasemethod, false);

									ReusableComponents.wait(20000);

									List<WebElement> newRecordsList = browser.findElements(By
											.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
									System.out.println("************ Number of elements " + newRecordsList.size());

									if (newRecordsList.size() == 0) {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"There are no new records created , please verify the input values",
												browser, pathLocation + "\\" + testcasemethod, true);
									} else {

										String newRecord = firstReport_FinancialReport.getText();

										if (!newRecord.contains("FRR")) {
											ReusableComponents.wait(20000);

											newRecord = firstReport_FinancialReport.getText();
										}

										if (newRecord.contains("FRR")) {
											String hreflink = reusableComponents
													.getAttribute(firstReport_FinancialReport, "href");
											financialReportURL = hreflink;

											ReusableComponents.reportPass(threadID, tempList, testcasemethod,
													"Created Financial report Name : " + newRecord
															+ ". Link of created financial report : " + hreflink,
													browser, pathLocation + "\\" + testcasemethod, false);
											ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ",
													browser, pathLocation + "\\" + testcasemethod, true);
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod,
													"There are no new records created , please verify the input values",
													browser, pathLocation + "\\" + testcasemethod, true);
										}
									}
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"As part of test data creation, there are no new payables created. Hence can not continue with the test case.",
										browser, pathLocation + "\\" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"As part of test data creation, there are no new billing created. Hence can not continue with the test case.",
									browser, pathLocation + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"As part of test data creation, there are no new accounts created. Hence can not continue with the test case.",
								browser, pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Previous Accounting period " + previousAccountingPeriod
									+ " status is not closed. Hence can not continue with the test case",
							browser, pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Accounting period " + currentAccoutingPeriod
								+ " status is not open. Hence can not continue with the test case",
						browser, pathLocation + "\\" + testcasemethod, true);
			}

		} catch (

		throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception during execution of test2622_TBVerifyFormettingOfNegativeAndPositive "
							+ e.getErrorMessage(),
					browser, pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {

			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception while executing test case test2622_TBVerifyFormettingOfNegativeAndPositive"
							+ e.getMessage(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see [TB] Verify that the Trial Balance report cannot be run for a period
	 *      that is preceeded by an open period.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public BankingLedgerPage test2626_NoTBWhenPreviousAccountingPeriodOpen(int threadID, List<String> tempList,
			String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		/*
		 * String path = workingDir +
		 * reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		 * pathLocation = reusableComponents.pathBuilder(path);
		 */

		testCaseNumber = "Testcase2626";
		currentAccountingPeriodForTheTestCase = reusableComponents
				.getPropValues(testCaseNumber + "_AccountingPeriodForTestCase");
		String currentAccoutingPeriod = currentAccountingPeriodForTheTestCase;
		String ledgerValue = reusableComponents.getPropValues(testCaseNumber + "_LedgerValue");
		String expectedErrorMessageHeading = reusableComponents.getPropValues(testCaseNumber + "_ErrorTextHeading");
		String expectedErrorMessage = reusableComponents.getPropValues(testCaseNumber + "_ErrorMessage");

		try {
			LoginToWebpage(threadID, tempList, pathLocation);

			System.out.println("********** Accounting period test data for this test case : " + currentAccoutingPeriod);

			// Verify current accounting period is open else cannot continue with the test
			// case
			String expectedAccountingPeriodStatus = "Open";
			Boolean actualAccountingPeriodStatus = false;
			actualAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
					currentAccoutingPeriod, expectedAccountingPeriodStatus);

			if (actualAccountingPeriodStatus) {

				String strArray[] = currentAccoutingPeriod.split("-");
				String yearValue = strArray[0];
				String monthValue = strArray[1];
				int year = Integer.parseInt(strArray[0]);
				int month = Integer.parseInt(strArray[1]);
				// check previous accounting year status is closed
				String previousAccountingPeriod;
				if (month == 1) {
					year = year - 1;
					month = 12;
					previousAccountingPeriod = Integer.toString(year) + "-" + (Integer.toString(month));
					System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
				} else {
					month = month - 1;

					if (month == 11 || month == 12 || month == 10) {
						previousAccountingPeriod = yearValue + "-" + Integer.toString(month);
						System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
					} else {
						previousAccountingPeriod = yearValue + "-0" + Integer.toString(month);
						System.out.println("*********** previousAccountingPeriod :" + previousAccountingPeriod);
					}

				}

				// Previous accounting period should be also be open
				expectedAccountingPeriodStatus = "Open";
				boolean previousAccountingPeriodStatus = false;
				previousAccountingPeriodStatus = checkAccountPeriodStatus(threadID, tempList, pathLocation,
						previousAccountingPeriod, expectedAccountingPeriodStatus);

				if (previousAccountingPeriodStatus) {

					// --> Test data creation create account --> Create new account
					try {
						createAccount(threadID, tempList, pathLocation);
					} catch (Exception e) {
						e.printStackTrace();
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There is a exception while creating test data" + e.getMessage(), browser,
								pathLocation + "\\" + testcasemethod, true);
					}

					// If new account creation is successful continue with test case else drop the
					// test
					if (accountCreatedStatus) {

						// --> Test data creation create account --> Create new billing
						try {
							createNewBilling(threadID, tempList, pathLocation);
						} catch (Exception e) {
							e.printStackTrace();
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"There is a exception while creating new billing test data" + e.getMessage(),
									browser, pathLocation + "\\" + testcasemethod, true);
						}

						// --> Test data creation create account --> Create new payable
						if (testDataNewBillingCreated) {
							try {
								createPayables(threadID, tempList, pathLocation);
							} catch (Exception e) {
								e.printStackTrace();
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"There is a exception while creating payables test data" + e.getMessage(),
										browser, pathLocation + "\\" + testcasemethod, true);
							}

							if (newPayableStatus) {

								// Run Financial Report
								String financialReportsURL = reusableComponents.getPropValues("FinancialReports");
								browser.get(financialReportsURL);
								// Browser.get is used here since there are issue in launching financial report
								// from search app. Once the issue resolved we can comment it and unccomment
								// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
								// Reports",
								ReusableComponents.wait(5000);

								ReusableComponents.clickElement(selectStandartReport_FinancialReport,
										"Click Select standard reportd");
								ReusableComponents.wait(5000);
								ReusableComponents.clickElement(trialBalance_selectStandartReport_FinancialReport,
										"Click Select Trial Balance");
								ReusableComponents.wait(5000);

								ReusableComponents.clickElement(clearSectionOfLedger_TrailBalance,
										"Clear button of Ledger input box period");
								ReusableComponents.sendKey(ledgerTypeInputBox_TrailBalance, ledgerValue,
										"Accounting period");
								String selcectLedgerValueXpath = "//lightning-base-combobox-formatted-text[@title='"
										+ ledgerValue + "']";
								WebElement selectValueElement = browser.findElement(By.xpath(selcectLedgerValueXpath));
								ReusableComponents.clickElement(selectValueElement, "Select Ledger Type");

								ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
										"Clear button of starting account period");
								ReusableComponents.sendKey(startingAccoutPeriodTrailBalance,
										currentAccountingPeriodForTheTestCase, "Accounting period");
								ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
										"Select Starting account period");

								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"Ledger and Accounting period values are given to run report", browser,
										pathLocation + "\\" + testcasemethod, false);
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
										pathLocation + "\\" + testcasemethod, true);

								// Uncheck supress zero amount check box
								ReusableComponents.clickElement(supressZeroAmountCheckBox,
										"Click Supress zero amount check box");
								ReusableComponents.reportPass(threadID, tempList, testcasemethod,
										"By default, Supress Zero amount check box will be checked. We did click once, so the assumption will be the check box is unchecked",
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
													"Error Message is not displayed as expected", browser,
													pathLocation + "\\" + testcasemethod, true);
										}

									} catch (NoSuchElementException e) {
										e.printStackTrace();
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Error Message is not displayed as expected", browser,
												pathLocation + "\\" + testcasemethod, true);
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
													"Error Message is not displayed as expected", browser,
													pathLocation + "\\" + testcasemethod, true);
										}

									} catch (NoSuchElementException e) {
										e.printStackTrace();
										ReusableComponents.reportFail(threadID, tempList, testcasemethod,
												"Error Message is not displayed as expected", browser,
												pathLocation + "\\" + testcasemethod, true);
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

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod,
										"As part of test data creation, there are no new payables created. Hence can not continue with the test case.",
										browser, pathLocation + "\\" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod,
									"As part of test data creation, there are no new billing created. Hence can not continue with the test case.",
									browser, pathLocation + "\\" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"As part of test data creation, there are no new accounts created. Hence can not continue with the test case.",
								browser, pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Previous Accounting period " + previousAccountingPeriod
									+ " status is not Open. Hence can not continue with the test case",
							browser, pathLocation + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Accounting period " + currentAccoutingPeriod
								+ " status is not open. Hence can not continue with the test case",
						browser, pathLocation + "\\" + testcasemethod, true);
			}

		} catch (

		throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception during execution of test2622_TBVerifyFormettingOfNegativeAndPositive "
							+ e.getErrorMessage(),
					browser, pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {

			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception while executing test case test2622_TBVerifyFormettingOfNegativeAndPositive"
							+ e.getMessage(),
					browser, pathLocation + "\\" + testcasemethod, true);
		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * @author Wisefinch Menaka
	 * @see This method is to create new ledger with the type "Budget"
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public static BankingLedgerPage createLedger(int threadID, List<String> tempList, String pathLocation)
			throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		newLedgerName = "Ledger_" + testCaseNumber + "_" + ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss");

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
						pathLocation + "\\" + testcasemethod, true);
				ReusableComponents.clickElement(saveButton_LedgerPage, "Save Button Of Ledgerpage");
				ReusableComponents.wait(10000);

				String newLedgerPage = ".//*[@slot='primaryField']/lightning-formatted-text[contains(text(),'"
						+ newLedgerName + "')]";
				if (browser.findElement(By.xpath(newLedgerPage)).isDisplayed() == true) {
					newLedgerCreatedStatus = true;
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, newLedgerName + " is created",
							browser, pathLocation + "\\" + testcasemethod, false);

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
							pathLocation + "\\" + testcasemethod, true);

				} else {
					newLedgerCreatedStatus = false;
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"New Ledger" + newLedgerName + " is not created", browser,
							pathLocation + "\\" + testcasemethod, true);
				}
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "New ledger popup is not displayed. ",
						browser, pathLocation + "\\" + testcasemethod, true);
			}
		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to login. " + e.getMessage(), browser, pathLocation + "\\" + testcasemethod,
					true);
		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * @author WisefinchMenaka
	 * @see [P&LvB] If the 'Suppress Zero Amount Rows?' checkbox is checked before
	 *      running the report only GL accounts that have transactions posted to
	 *      them are shown.
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public static BankingLedgerPage test2642_BudgetLedgerReport(int threadID, List<String> tempList,
			String pathLocation) throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		testCaseNumber = "Testcase2642";

		try {
			LoginToWebpage(threadID, tempList, pathLocation);
			try {
				createLedger(threadID, tempList, pathLocation);
			} catch (Exception e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception when creating new Ledger" + e.getMessage(), browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			if (newLedgerCreatedStatus) {
				try {
					createGLAccount(threadID, tempList, pathLocation);
				} catch (Exception e) {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Exception when creating new GL Account" + e.getMessage(), browser,
							pathLocation + "\\" + testcasemethod, true);
				}
				if (newGLAccountCreationStatus) {

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
					ReusableComponents.clickElement(pandlvsBudger_selectStandartReport_FinancialReport,
							"Click P & L vs. Budget");
					ReusableComponents.wait(5000);

					ReusableComponents.clickElement(removeBudgetLedger_PandLVsBudget, "Remove Budget value");
					ReusableComponents.sendKey(budgetLedget_PandLVsBudget, newLedgerName, "Provide Ledger Name");
					ReusableComponents.wait(2000);
					String selectLedger = ".//*[normalize-space()='" + newLedgerName + "']";

					List<WebElement> newBudgetList = browser.findElements(By.xpath(selectLedger));
					System.out.println("************ Number of elements " + newBudgetList.size());

					if (newBudgetList.size() != 0) {
						ReusableComponents.clickElement(browser.findElement(By.xpath(selectLedger)),
								"Select Ledger Value");

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"New Ledger : " + newLedgerName + " selected under budget lendger section", browser,
								pathLocation + "\\" + testcasemethod, false);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"By default, Supress Zero amount check box will be checked. so the assumption will be the check box is checked",
								browser, pathLocation + "\\" + testcasemethod, false);
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
								financialReportURL = hreflink;
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
								financialReportURL = hreflink;
								if (newRecord.contains("FRR")) {
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Created Financial report Name : " + newRecord
													+ ". Link of created financial report : " + hreflink,
											browser, pathLocation + "\\" + testcasemethod, false);
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
											hreflink, true);
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"There are no new records created , please verify the input values",
											browser, pathLocation + "\\" + testcasemethod, true);
								}
							}
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Newly created ledger is not displayed under P & L vs Budget , Ledger dropdown, Hence can not continue with the test case",
								browser, pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There is a issue when new GL Account test data creation as part of test case "
									+ testCaseNumber + " hence can not continue with the test case",
							browser, pathLocation + "\\" + testcasemethod, true);
				}
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"There is a issue when new ledger test data creation as part of test case " + testCaseNumber
								+ " hence can not continue with the test case",
						browser, pathLocation + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to login. " + e.getMessage(), browser, pathLocation + "\\" + testcasemethod,
					true);
		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * @author WisefinchMenaka
	 * @see [P&LvB] If the 'Suppress Zero Amount Rows?' checkbox is unchecked before
	 *      running the report all GL accounts are shown whether or not they have
	 *      transactions posted to them
	 * 
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public static BankingLedgerPage test2643_BudgetLedgerReport(int threadID, List<String> tempList,
			String pathLocation) throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		testCaseNumber = "Testcase2643";

		try {
			LoginToWebpage(threadID, tempList, pathLocation);
			try {
				createLedger(threadID, tempList, pathLocation);
			} catch (Exception e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Exception when creating new Ledger" + e.getMessage(), browser,
						pathLocation + "\\" + testcasemethod, true);
			}

			if (newLedgerCreatedStatus) {
				try {
					createGLAccount(threadID, tempList, pathLocation);
				} catch (Exception e) {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Exception when creating new GL Account" + e.getMessage(), browser,
							pathLocation + "\\" + testcasemethod, true);
				}
				if (newGLAccountCreationStatus) {

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
					ReusableComponents.clickElement(pandlvsBudger_selectStandartReport_FinancialReport,
							"Click P & L vs. Budget");
					ReusableComponents.wait(5000);

					ReusableComponents.clickElement(removeBudgetLedger_PandLVsBudget, "Remove Budget value");
					ReusableComponents.sendKey(budgetLedget_PandLVsBudget, newLedgerName, "Provide Ledger Name");
					ReusableComponents.wait(2000);
					String selectLedger = ".//*[normalize-space()='" + newLedgerName + "']";

					List<WebElement> newBudgetList = browser.findElements(By.xpath(selectLedger));
					System.out.println("************ Number of elements " + newBudgetList.size());

					if (newBudgetList.size() != 0) {
						ReusableComponents.clickElement(browser.findElement(By.xpath(selectLedger)),
								"Select Ledger Value");

						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"New Ledger : " + newLedgerName + " selected under budget lendger section", browser,
								pathLocation + "\\" + testcasemethod, false);
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
								pathLocation + "\\" + testcasemethod, true);

						// Uncheck supress zero amount check box
						ReusableComponents.clickElement(supressZeroAmountCheckBox,
								"Click Supress zero amount check box");
						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"By default, Supress Zero amount check box will be checked. We did click once, so the assumption will be the check box is unchecked",
								browser, pathLocation + "\\" + testcasemethod, false);
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
								ReusableComponents.wait(40000);

								newRecord = firstReport_FinancialReport.getText();
							}

							if (newRecord.contains("FRR") && !oldRecordName.equalsIgnoreCase(newRecord)) {
								String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
								financialReportURL = hreflink;
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
									ReusableComponents.wait(40000);

									newRecord = firstReport_FinancialReport.getText();
								}

								String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
								financialReportURL = hreflink;
								if (newRecord.contains("FRR")) {
									ReusableComponents.reportPass(threadID, tempList, testcasemethod,
											"Created Financial report Name : " + newRecord
													+ ". Link of created financial report : " + hreflink,
											browser, pathLocation + "\\" + testcasemethod, false);
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, " ", browser,
											hreflink, true);
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod,
											"There are no new records created , please verify the input values",
											browser, pathLocation + "\\" + testcasemethod, true);
								}
							}
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"Newly created ledger is not displayed under P & L vs Budget , Ledger dropdown, Hence can not continue with the test case",
								browser, pathLocation + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There is a issue when new GL Account test data creation as part of test case "
									+ testCaseNumber + " hence can not continue with the test case",
							browser, pathLocation + "\\" + testcasemethod, true);
				}
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"There is a issue when new ledger test data creation as part of test case " + testCaseNumber
								+ " hence can not continue with the test case",
						browser, pathLocation + "\\" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "\\" + testcasemethod, true);
		} catch (Exception e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Exception when trying to login. " + e.getMessage(), browser, pathLocation + "\\" + testcasemethod,
					true);
		}
		return new BankingLedgerPage(browser);
	}

	/**
	 * test
	 * 
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 */
	public BankingLedgerPage testHere(int threadID, List<String> tempList, String pathLocation) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String currentAccoutingPeriod, openAccountingPeriodForTestDataCreation = "NA",
				currentAccountPeriodExpectedStatus = null, expectedAccountingPeriodStatus = null;
		boolean accountPeriodStatusCheck = false, actualAccountingPeriodStatus = false,
				currentAccountingPeriodActualStatus = false;

		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
		pathLocation = reusableComponents.pathBuilder(path);

		testCaseNumber = "Testcase2655";
		String ledgerValue = reusableComponents.getPropValues(testCaseNumber + "_LedgerValue");
		currentAccoutingPeriod = reusableComponents.getPropValues(testCaseNumber + "_" + "AccountingPeriodForTestCase");
		currentAccountingPeriodForTheTestCase = "2021-01";
		newLedgerName = "Ledger_Testcase2623_20211012_131139";
		try {
			Page page = new Page(browser);
			page.accountingSeedReusableFunction(threadID, tempList, pathLocation);
			AccountingSeedReusableFunctionalities.LoginToWebpage(threadID, tempList, pathLocation, browser);
			
			try {
				AccountingSeedReusableFunctionalities.closeAccountingPeriod(threadID, tempList, pathLocation, browser,
						"2020-05");
			} catch (Exception e) {
				System.out.println("*********** Exception when trying to open 2020-05");
			}

			try {
				AccountingSeedReusableFunctionalities.openAccountingPeriod(threadID, tempList, pathLocation, browser,
						"2022-05");
			} catch (Exception e) {
				System.out.println("*********** Exception when trying to open 2020-05");
			}		


		} catch (Exception e) {

			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"There is a exception while teting" + e.getMessage(), browser, pathLocation + "\\" + testcasemethod,
					true);
		}
		return new BankingLedgerPage(browser);
	}

}