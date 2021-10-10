package com.wisefinch.java;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base class for all the pages.
 *
 */
public class SearchAppItemPage extends DriverScript {

	protected static WebDriver browser;
	static String dateGatheredToGiveNam;
	private static String dynamicValue;
	String valueToSet;
	String newJournalName;

	static ReusableComponents reusableComponents = new ReusableComponents();

	protected SearchAppItemPage(WebDriver browser) {
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

	@FindBy(xpath = "(.//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Reports')])[5]")
	static WebElement selectValueFromAppAndItemDropdown;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Accounting Home')]")
	static WebElement selectValueAsAccountingHomeFromAppAndItemDropdown;

	@FindBy(xpath = "(.//a/*[contains(text(),'New Report')])[1]")
	static WebElement newReportButton;

	@FindBy(xpath = ".//*[@class=\"slds-modal__container report-type-picker-container\"]//*[@id='modal-search-input']")
	static WebElement searchReportTypeTextBox;

	@FindBy(xpath = ".//*[@aria-describedby='_report_type_message' and contains(text(),'Transactions with GL Account')]")
	static WebElement chooseReport;

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

	@FindBy(xpath = ".//*[contains(text(),'Ledger')]")
	static WebElement selectValueLedger;

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
	static WebElement arrorMarkNextToReportAmount;

	@FindBy(xpath = ".//ul//*[contains(text(),'Summarize')]")
	static WebElement selectSummarizeOption;

	@FindBy(xpath = ".//*[@role='menuitemcheckbox']//*[@title='Sum']")
	static WebElement sumOptionFromSummarize;

	@FindBy(xpath = ".//*[@class='panel-heading' and contains(text(),'Reporting')]//following::img[@alt=' Financial Reports']")
	static WebElement FinancialReport_AccountHome;

	@FindBy(xpath = ".//*[@class='panel-heading' and contains(text(),'Reporting')]")
	static WebElement reportingSection_AccountHome;

	@FindBy(xpath = ".//*[@class='slds-box box-shadow']/h2[contains(text(),'Profit & Loss')]")
	static WebElement profitAndLoss_FinancialReport;

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

	@FindBy(xpath = ".//*[@class='panel-heading' and contains(text(),'Cash In')]//following::img[@alt='Recurring Billings']")
	static WebElement recurringBilling_AccountingHome;

	@FindBy(xpath = "(.//*[@class='slds-form-element']//*[@type='checkbox'])[3]")
	static WebElement suppressZeroAmountCheckbox_FinancialReport;

	@FindBy(xpath = "(.//*[@class='slds-form-element']//*[@type='checkbox'])[1]")
	static WebElement includeSubTypeoneCheckbox_FinancialReport;

	@FindBy(xpath = ".//button[contains(text(),'Run')]")
	static WebElement runButton_FinancialReport;

	@FindBy(xpath = "(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]")
	static WebElement firstReport_FinancialReport;

	@FindBy(xpath = "(.//*[@scope='row']//*[@class='slds-truncate']//a)[1]")
	static WebElement firstReport_PandLVsBudgetFinancialReport;

	@FindBy(xpath = "(.//slot//button)[4]")
	static WebElement export_FinancialReport_Openpage;

	@FindBy(xpath = ".//*[contains(text(),'Excel')]")
	static WebElement exporttoExcel_FinancialReport_Openpage;

//"//table//tbody//tr[1]//th//div[1]//a/parent::*")
	@FindBy(xpath = "(//table//tbody//tr[1]//th//div[1]//a)[1]")
	static WebElement reportname;

	@FindBy(xpath = "(.//*[@class='fields-panel full']//button)[1]")
	static WebElement clear_Fields_Searchbox;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Ledgers')]")
	static WebElement selectLedgerFromApp;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Opportunities')]")
	static WebElement opportunitiesFromApp;

	@FindBy(xpath = ".//li//*[contains(text(),'New')]")
	static WebElement newLink_LedgerPage;

	@FindBy(xpath = ".//*[@name='Name']")
	static WebElement ledgerName_LedgerPage;

	@FindBy(xpath = "(.//*[@class='slds-form__row']//*[@role='combobox'])[1]")
	static WebElement ledgerType_LedgerPage;

	@FindBy(xpath = "(.//lightning-button//button[contains(text(),'Save')])[2]")
	static WebElement saveButton_LedgerPage;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Financial Cubes')]")
	static WebElement financialCubesFromApp;

	@FindBy(xpath = ".//a/*[contains(text(),'New')]")
	static WebElement newLink_FinancialCubes;

	@FindBy(xpath = ".//*[@placeholder='Search Ledgers...']")
	static WebElement ledger_FinancialCubes;

	@FindBy(xpath = ".//*[@name='AcctSeed__Amount__c']")
	static WebElement amountInputBox_FinancialCubes;

	@FindBy(xpath = ".//*[@placeholder='Search GL Accounts...']")
	static WebElement glAccount_FinancialCubes;

	@FindBy(xpath = "//lightning-base-combobox-formatted-text[@title='7020-Office Expense']")
	static WebElement glAccount_Select_FinancialCubes;

	@FindBy(xpath = ".//*[@name='AcctSeed__Year__c']")
	static WebElement year_FinancialCubes;

	@FindBy(xpath = ".//*[@placeholder='Search Accounting Periods...']")
	static WebElement acccountingPeriod_FinancialCubes;

	@FindBy(xpath = ".//lightning-base-combobox-formatted-text[@title='10/1/2020']") // change it dynamic
	static WebElement acccountingPeriod_Select_FinancialCubes;

	@FindBy(xpath = "//lightning-base-combobox-formatted-text[@title='20210901_040820_Budget']") // change it dynamic
	static WebElement budgetName_Select_FinancialCubes;

	@FindBy(xpath = ".//*[@name='SaveEdit']")
	static WebElement saveButton_FinancialCubes;

	@FindBy(xpath = "(.//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Financial Reports')])[1]")
	static WebElement financialReportsFromApp;

	@FindBy(xpath = ".//button[contains(text(),'Select Standard Report')]")
	static WebElement selectStandartReport_FinancialReport;

	@FindBy(xpath = ".//span[normalize-space()='P & L vs. Budget']")
	static WebElement PLvsBudget_selectStandartReport_FinancialReport;

	@FindBy(xpath = "(.//*[@aria-haspopup='listbox']//input)[3]")
	static WebElement startingAccountingPeriod_FinancialReport;

	@FindBy(xpath = "//span[@class='slds-listbox__option-meta slds-listbox__option-meta_entity']")
	static WebElement accountingPeriodSelect_FinancialReport;

	@FindBy(xpath = "(.//*[@aria-haspopup='listbox']//input)[4]")
	static WebElement endingAccountingPeriod_FinancialReport;

	@FindBy(xpath = "(.//button[@title='Remove selected option'])[2]")
	static WebElement clearBudgetLedgerValue_FinancialReport;

	@FindBy(xpath = "(.//button[@title='Remove selected option'])[3]")
	static WebElement clearStartingDate_FinancialReport;

	@FindBy(xpath = "(.//button[@title='Remove selected option'])[4]")
	static WebElement clearEndingDate_FinancialReport;

	@FindBy(xpath = "(.//*[@aria-haspopup='listbox']//input)[2]")
	static WebElement budgetLedgerValue_FinancialReport;

	@FindBy(xpath = ".//*[@role='menuitem']/*[contains(text(),'greater or equal')]")
	static WebElement greaterOrEqualOption;

	@FindBy(xpath = ".//*[@role='menuitem']/*[contains(text(),'less or equal')]")
	static WebElement lessOrEqualOption;

	@FindBy(xpath = ".//button[normalize-space()='Run']")
	static WebElement runButtonReportTab;

	@FindBy(xpath = ".//records-lwc-detail-panel//input[@name='Name']")
	static WebElement name_NewOpportunity;

	@FindBy(xpath = ".//records-lwc-detail-panel//input[@name='CloseDate']")
	static WebElement closeDate_NewOpportunity;

	@FindBy(xpath = "(.//records-lwc-detail-panel//lightning-base-combobox//input[@role='combobox'])[4]")
	static WebElement stage_NewOpportunity;

	@FindBy(xpath = ".//*[@class='actionBody']")
	static WebElement popupof_NewOpportunity;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Bank Deposits')]")
	static WebElement bankDepositsFromApp;

	@FindBy(xpath = "(//select)[1]")
	static WebElement ledger_NewDeposite;

	@FindBy(xpath = "(//select)[2]")
	static WebElement bankAccount_NewDeposite;

	@FindBy(xpath = "(.//*[@class='detailList']//input)[15]")
	static WebElement depositeDate_NewDeposite;

	@FindBy(xpath = "(//select)[3]")
	static WebElement currency_NewDeposite;

	@FindBy(xpath = ".//*[@class='pbBottomButtons']//input[@value='Save']")
	static WebElement saveButton_NewDeposite;

	@FindBy(xpath = "(.//*[@slot='primaryField']//lightning-formatted-text)[3]")
	static WebElement newlyCreatedDepositeName_NewDeposite;

	@FindBy(xpath = "(.//*[@class='actionBody'])[2]")
	static WebElement financialCubesPopup;

	// Modification after giving code to Sub 07/09/2021

	@FindBy(xpath = ".//*[contains(text(),'Show All Periods')]")
	static WebElement showAllPeriodCheckBox_FinancialReports;

	@FindBy(xpath = "(.//*[@name='inputField']//input)[2]")
	static WebElement clickType_NewLedger;

	@FindBy(xpath = "//span[@title='Budget']")
	static WebElement selectTypeBudget_NewLedger;

	@FindBy(xpath = ".//*[@class='slds-page-header__name-meta' and contains(text(),'Financial Reports')]")
	static WebElement financialReport_PageTitle;

	@FindBy(xpath = ".//*[@aria-label='Breadcrumbs']//*[contains(text(),'Ledgers')]")
	static WebElement ledger_PageTitle;

	@FindBy(xpath = ".//*[@aria-label='Breadcrumbs']//*[contains(text(),'Journal Entries')]")
	static WebElement journalEntries_PageTitle;

	@FindBy(xpath = "(.//*[@class='slds-checkbox_faux'])[3]")
	static WebElement suppressZeroAmountRowCheckBox_FinancialReport;

	@FindBy(xpath = ".//*[@class='panel-content scrollable']//*[@class='slds-truncate']/*[contains(text(),'Journal Entries')]")
	static WebElement journalEntries;

	@FindBy(xpath = ".//*[@class='slds-modal__header']/h2[contains(text(),'New Journal Entry')]")
	static WebElement newJournalEntry_Popup;

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

	@FindBy(xpath = "(.//*[@class='slds-form']//input[@role='combobox'])[4]")
	static WebElement postingStatus_newJournalEntryPopup;

	@FindBy(xpath = "(.//*[@class='slds-form']//input[@role='combobox'])[5]")
	static WebElement ledger_newJournalEntryPopup;

	@FindBy(xpath = ".//button[contains(text(),'Cancel')]")
	static WebElement cancelButton_newJournalEntryPopup;

	@FindBy(xpath = ".//button[contains(text(),'Save & New')]")
	static WebElement saveAndNewButton_newJournalEntryPopup;

	@FindBy(xpath = "(.//button[contains(text(),'Save')])[2]")
	static WebElement saveButton_newJournalEntryPopup;

	@FindBy(xpath = "(.//*[@apiname='Edit']//button[@name='Edit'])[2]")
	static WebElement edit_newlyCreatedJournal;

	@FindBy(xpath = ".//button[contains(text(),'New')]")
	static WebElement newJournalEntryLine;

	// Dynamic xpath declaration
	String xpath_glAccount_Select_FinancialCubes = "//lightning-base-combobox-formatted-text[@title='"
			+ (String) reusableComponents.props.get("Testcase2713_FinancialCubes_GLACcountType") + "']";

//Xpath from Lakshman

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

	String account_name = null;
	String account_namefull = null;

	ArrayList<String> startdate_arr = new ArrayList<String>();
	ArrayList<String> enddate_arr = new ArrayList<String>();

	Boolean supressrows = false;
	String ignore_supressrows = null, ignore_subtype1 = null, startdate_G = null, enddate_G = null, acc_period_G = null;

	/***
	 * Test case Method Name : [P&L] [P&L] Verify amounts shown for the Expense GL
	 * accounts match with those on the SF version of this report : Menaka
	 ***/
	public synchronized SearchAppItemPage input_2682searchAppAndTest_excel(int threadID, List<String> tempList,
			String pathLoc) throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			String startdate = null, enddate = null, equalsvalueof = null;
			Boolean isselected = false;

			// the excel input value should be supplied to start date and end date

			try {

				String filename = reusableComponents.getPropValues("Financialreportsinput");
				String sheetname = reusableComponents.getPropValues("TC7");

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
				System.out.println("Row count is " + rowCount + " Column count is " + columnCount);

				// read rows and columns

				Iterator<Row> itr = workbooksheet.iterator();

				while (itr.hasNext()) {
					Row row = itr.next();
					if (row.getRowNum() == 0) {
						continue; // just skip the rows if row number is 0 or 1
					}

					if (row.getRowNum() == 1) {
						continue;
					}

					if (row.getRowNum() == 2) {

						Iterator<Cell> celliterator = row.cellIterator();

						while (celliterator.hasNext()) {

							Cell cell = celliterator.next();
							final DataFormatter formatter = new DataFormatter();

							startdate_arr.add(formatter.formatCellValue(cell)); // throw new

						}

					}

				}

			} catch (NoSuchElementException e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			}

			try {
				for (int i = 0; i < startdate_arr.size(); i++) {

					System.out.println(startdate_arr.get(i));
				}

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Reading Excel input sheet, successful", browser, pathLoc + "/" + testcasemethod, false);
				startdate = startdate_arr.get(2);
				enddate = startdate_arr.get(3);
				equalsvalueof = startdate_arr.get(4);
				if (equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
					supressrows = Boolean.valueOf(equalsvalueof);
					ignore_supressrows = "false";
				} else if (equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ")
						|| equalsvalueof.equalsIgnoreCase("")) {
					ignore_supressrows = "true";
				}

				else {

					ignore_supressrows = "true";
				}

				ReusableComponents.wait(5200);

				System.out.println("start date " + startdate + " and end date " + enddate
						+ " equals true or false value is " + equalsvalueof);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"printing excel elements are incomplete", browser, pathLoc + "/" + testcasemethod, true);
			}

			startdate_G = startdate;
			enddate_G = enddate;

			try {
				test_2682searchAppAndTest(threadID, tempList, pathLoc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Method Name : [P&L] The Total Net Income for the year is the amount
	 * of Revenue - Expenses for the whole year. Author : Menaka
	 ***/
	public synchronized SearchAppItemPage test_2682searchAppAndTest(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			try {
				ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Verifying info", browser, pass_login,
						false);

				LoginToWebpage();

				ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Search app and item icon pressed",
						browser, " ", false);
				ReusableComponents.sendKey(SearchAppAndItemInputbox, "Reports", "Search app and Item inputbox");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Search for reports", browser, " ",
						false);
				ReusableComponents.clickElement(selectValueFromAppAndItemDropdown,
						"Select value from App and Item dropdown");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Reports page opened", browser, " ",
						false);
				ReusableComponents.clickElement(newReportButton, "New Report Button");
				ReusableComponents.wait(10000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New report dialog box opened",
						browser, " ", false);

				ReusableComponents.switchToFrame(browser, 0);
				ReusableComponents.wait(5000);

				ReusableComponents.clickElement(searchReportTypeTextBox, "Click on Search report type text box");
				ReusableComponents.sendKey(searchReportTypeTextBox, "Transactions with GL Account",
						"Search Report type text box"); // Should know where to store input values

				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Looking for Transactions with GL Account", browser,
						pathLoc + "/" + testcasemethod, true);

				ReusableComponents.clickElement(chooseReport, "Transactions with GL Account");
				ReusableComponents.clickElement(continueButton_ChooseReportTypePopup,
						"Continue button from Choose report type popup");

				ReusableComponents.wait(10000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Transactions with GL Account Opened", browser, pathLoc + "/" + testcasemethod,
						true);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Ledger", "Adding values as Ledger");
				if (ReusableComponents.isDisplayed(selectValueLedger, "Selected value")) {

					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue, reusableComponents.getPropValues("Testcase2682_LedgerValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Ledger and Operator values are selected and added", browser,
						pathLoc + "/" + testcasemethod, true);

				/*
				 * List<WebElement> elementName = browser.findElements(By.tagName("iframe"));
				 * System.out.println("************ Number of elements "+elementName.size());
				 * //ReusableComponents.switchToFrame(browser,0);
				 * System.out.println("************ Switched frame");
				 */

				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Accounting Period", "Adding values as Accounting period");
				wait(1000);
				if (ReusableComponents.isDisplayed(select_AccountingPeiod_Value, "Selected value")) {
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					wait(1000);
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_AccountingPeriodValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "GL Account Type", "Adding values as Accounting period");
				if (ReusableComponents.isDisplayed(selectValueGLAccountType, "Selected value")) {
					ReusableComponents.clickElement(selectValueGLAccountType, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(selectValueGLAccountType, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_GLAccountTypeValue"),
						"Adding values to the operator");
				ReusableComponents.clickElement(applyButton, "Apply Button");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "GL account type and Operator values are selected and added", browser,
						pathLoc + "/" + testcasemethod, true);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(fieldsPanelTrigger, "Field Panel Trigger");
				ReusableComponents.sendKey(fieldSearchInput, "Report Amount", "Adding values as Report Amount");
				ReusableComponents.wait(3000);
				ReusableComponents.clickElement(selectResultFromFieldSearch, "Click on result");
				ReusableComponents.doubleClickElement(browser, selectResultFromFieldSearch,
						"Select Fields from filter");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(refreshButton, "Refresh Link");
				ReusableComponents.wait(5000);

				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Report amount selected from field panel and added", browser,
						pathLoc + "/" + testcasemethod, false);

				ReusableComponents.clickElement(arrorMarkNextToReportAmount,
						"Click on arrow mark next to report amount");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(selectSummarizeOption, "Select summarize option");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(sumOptionFromSummarize, "Select sum option from Summarize option");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Sum from summarize option selected for report amount", browser,
						pathLoc + "/" + testcasemethod, false);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(clear_Fields_Searchbox, "Field search box cleared");
				ReusableComponents.sendKey(fieldSearchInput, "GL Account Type", "Adding values as Report Amount");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(selectResult_GLAccount_Type_FieldSearch, "Click on result");
				ReusableComponents.doubleClickElement(browser, selectResult_GLAccount_Type_FieldSearch,
						"Select Fields from filter");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(refreshButton, "Refresh Link");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"GL Account Type selected from field panel and added", browser, " ", false);

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Validation 1 : Values gathered from reports page", browser, " ", false);

				// Launch Financial report

				browser.get("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
				ReusableComponents.wait(2000);
				browser.switchTo().alert().accept();
				// Browser.get is used here since there are issue in launching financial report
				// from search app. Once the issue resolved we can comment it and unccomment
				// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
				// Reports",

				// Checking for profit and loss section
				ReusableComponents.wait(10000);

//				ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
//				ReusableComponents.wait(5000);
//				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
//						testcasemethod+"Search app and item icon pressed", browser, pathLoc + "/" + testcasemethod, true);
//
//				ReusableComponents.sendKey(SearchAppAndItemInputbox, "Accounting Home", "Search app and Item inputbox");
//				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, testcasemethod+"Search for reports", browser,
//						pathLoc + "/" + testcasemethod, true);
//
//				ReusableComponents.clickElement(selectValueAsAccountingHomeFromAppAndItemDropdown,
//						"Select value from App and Item dropdown");
//				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Accounting home page opened",
//						browser, " ", true);
//				wait(10000);
//				ReusableComponents.scrollDownByDownArrow(browser);
//				ReusableComponents.actionMoveToElement(browser, FinancialReport_AccountHome);
//				wait(10000);
//				ReusableComponents.clickElement(FinancialReport_AccountHome, "Recurring	Billing");
//				ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Click on	Financial report hyperlink",
//						browser, pass_login, false);

				// Checking for profit and loss section
				if (ReusableComponents.isElementPresent(profitAndLoss_FinancialReport)) {
					ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Profit and Loss Section present",
							browser, pass_login, false);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Profit and loss section is not there", browser, pathLoc + "/" + testcasemethod, true);
				}

				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
						"Clear button of starting account period");
				ReusableComponents.sendKey(startingAccoutPeriod_FinancialReport,
						reusableComponents.getPropValues("Testcase2682_StartingAccountPeriodValue"),
						"Starting Account period");
				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport,
						"Starting account period input box");
				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
						"Select Starting account period");

				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport_Clear,
						"Clear button of ending account period");
				ReusableComponents.sendKey(endingAccoutPeriod_FinancialReport,
						reusableComponents.getPropValues("Testcase2682_EndingAccountPeriodValue"),
						"Ending Account period");
				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport, "ending account period input box");
				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select ending account period");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Accounting period start and ending period given", browser, " ", false);

				ReusableComponents.isSelectedCheckbox(includeSubTypeoneCheckbox_FinancialReport,
						"Select Include Sub type One check box");
				ReusableComponents.isSelectedCheckbox(suppressZeroAmountCheckbox_FinancialReport,
						"Select Suppress zero amount rows check box");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Include sub type one and Suppress zero amount check boxs are selected ",
						browser, pathLoc + "/" + testcasemethod, true);

				String oldRecordName = firstReport_FinancialReport.getText();

				ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Run button clicked ", browser, pathLoc + "/" + testcasemethod, true);

				wait(10000);

				String newRecord = firstReport_FinancialReport.getText();

				if (!oldRecordName.equalsIgnoreCase(newRecord)) {
					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Link of created financial report : " + hreflink, browser, pathLoc + "\\" + testcasemethod, false);
				} else {

					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There are no new records created, provide valid inputs ", browser,
							pathLoc + "/" + testcasemethod, true);
				}

				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Validation 1 : Values gathered from reports page ", browser,
						pathLoc + "/" + testcasemethod, true);

				// Perform Prerequisites again

				ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Search app and item icon pressed", browser, pathLoc + "/" + testcasemethod,
						true);
				ReusableComponents.sendKey(SearchAppAndItemInputbox, "Reports", "Search app and Item inputbox");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Search for reports", browser, " ",
						false);
				ReusableComponents.clickElement(selectValueFromAppAndItemDropdown,
						"Select value from App and Item dropdown");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Reports page opened", browser, " ",
						false);
				ReusableComponents.clickElement(newReportButton, "New Report Button");
				ReusableComponents.wait(10000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New report dialog box opened",
						browser, " ", false);

				ReusableComponents.switchToFrame(browser, 0);
				ReusableComponents.wait(5000);

				ReusableComponents.clickElement(searchReportTypeTextBox, "Click on Search report type text box");
				ReusableComponents.sendKey(searchReportTypeTextBox, "Transactions with GL Account",
						"Search Report type text box"); // Should know where to store input values

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Looking for Transactions with GL Account", browser, " ", false);
				ReusableComponents.clickElement(chooseReport, "Transactions with GL Account");
				ReusableComponents.clickElement(continueButton_ChooseReportTypePopup,
						"Continue button from Choose report type popup");

				ReusableComponents.wait(10000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Transactions with GL Account Opened",
						browser, " ", false);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Ledger", "Adding values as Ledger");
				if (ReusableComponents.isDisplayed(selectValueLedger, "Selected value")) {
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue, reusableComponents.getPropValues("Testcase2682_LedgerValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Ledger and Operator values are selected and added", browser, " ", false);

				/*
				 * List<WebElement> elementName = browser.findElements(By.tagName("iframe"));
				 * System.out.println("************ Number of elements "+elementName.size());
				 * //ReusableComponents.switchToFrame(browser,0);
				 * System.out.println("************ Switched frame");
				 */

				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Accounting Period", "Adding values as Accounting period");
				if (ReusableComponents.isDisplayed(select_AccountingPeiod_Value, "Selected value")) {
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				}
				ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				wait(3000);
				ReusableComponents.clickElement(lessOrEqualOption, "Greater or Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_StartingAccountPeriodValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Accounting Period", "Adding values as Accounting period");
				if (ReusableComponents.isDisplayed(select_AccountingPeiod_Value, "Selected value")) {
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				}
				ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				wait(3000);
				ReusableComponents.clickElement(greaterOrEqualOption, "Greater or Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_EndingAccountPeriodValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");
				wait(4000);

				ReusableComponents.clickElement(runButtonReportTab, "Run Button");
				wait(4000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Run clicked and report catured", browser, pathLoc + "/" + testcasemethod,
						true);
			} catch (throwNewException e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
						pathLoc + "/" + testcasemethod, true);
			} catch (Exception e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Error During execution of test case" + e.toString(), browser, pathLoc + "/" + testcasemethod,
						true);
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Method Name : [P&L] [P&L] Verify amounts shown for the Expense GL
	 * accounts match with those on the SF version of this report : Menaka
	 ***/
	public synchronized SearchAppItemPage input_2679searchAppAndTest_excel(int threadID, List<String> tempList,
			String pathLoc) throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			String startdate = null, enddate = null, equalsvalueof = null;
			Boolean isselected = false;

			// the excel input value should be supplied to start date and end date

			try {

				String filename = reusableComponents.getPropValues("Financialreportsinput");
				String sheetname = reusableComponents.getPropValues("TC4");

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
				System.out.println("Row count is " + rowCount + " Column count is " + columnCount);

				// read rows and columns

				Iterator<Row> itr = workbooksheet.iterator();

				while (itr.hasNext()) {
					Row row = itr.next();
					if (row.getRowNum() == 0) {
						continue; // just skip the rows if row number is 0 or 1
					}

					if (row.getRowNum() == 1) {
						continue;
					}

					if (row.getRowNum() == 2) {

						Iterator<Cell> celliterator = row.cellIterator();

						while (celliterator.hasNext()) {

							Cell cell = celliterator.next();
							final DataFormatter formatter = new DataFormatter();

							startdate_arr.add(formatter.formatCellValue(cell)); // throw new

						}

					}

				}

			} catch (NoSuchElementException e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			}

			try {
				for (int i = 0; i < startdate_arr.size(); i++) {

					System.out.println(startdate_arr.get(i));
				}

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Reading Excel input sheet, successful", browser, pathLoc + "/" + testcasemethod, false);
				startdate = startdate_arr.get(2);
				enddate = startdate_arr.get(3);
				equalsvalueof = startdate_arr.get(4);
				if (equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
					supressrows = Boolean.valueOf(equalsvalueof);
					ignore_supressrows = "false";
				} else if (equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ")
						|| equalsvalueof.equalsIgnoreCase("")) {
					ignore_supressrows = "true";
				}

				else {

					ignore_supressrows = "true";
				}

				ReusableComponents.wait(5200);

				System.out.println("start date " + startdate + " and end date " + enddate
						+ " equals true or false value is " + equalsvalueof);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"printing excel elements are incomplete", browser, pathLoc + "/" + testcasemethod, true);
			}

			startdate_G = startdate;
			enddate_G = enddate;

			try {
				test_2679serachAppAndTest(threadID, tempList, pathLoc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Method Name : [P&L] [P&L] Verify amounts shown for the Expense GL
	 * accounts match with those on the SF version of this report : Menaka
	 ***/
	public synchronized SearchAppItemPage test_2679serachAppAndTest(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			try {
				ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Verifying info", browser, pass_login,
						false);

				LoginToWebpage();

				ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Search app and item icon pressed",
						browser, " ", false);
				ReusableComponents.sendKey(SearchAppAndItemInputbox, "Reports", "Search app and Item inputbox");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Search for reports", browser, " ",
						false);
				ReusableComponents.clickElement(selectValueFromAppAndItemDropdown,
						"Select value from App and Item dropdown");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Reports page opened", browser, " ",
						false);
				ReusableComponents.wait(10000);
				ReusableComponents.clickElement(newReportButton, "New Report Button");
				ReusableComponents.wait(15000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New report dialog box opened",
						browser, " ", false);

				ReusableComponents.switchToFrame(browser, 0);
				ReusableComponents.wait(5000);

				ReusableComponents.clickElement(searchReportTypeTextBox, "Click on Search report type text box");
				ReusableComponents.sendKey(searchReportTypeTextBox, "Transactions with GL Account",
						"Search Report type text box"); // Should know where to store input values

				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Looking for Transactions with GL Account", browser,
						pathLoc + "/" + testcasemethod, true);

				ReusableComponents.clickElement(chooseReport, "Transactions with GL Account");
				ReusableComponents.clickElement(continueButton_ChooseReportTypePopup,
						"Continue button from Choose report type popup");

				ReusableComponents.wait(10000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Transactions with GL Account Opened", browser, pathLoc + "/" + testcasemethod,
						true);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Ledger", "Adding values as Ledger");
				if (ReusableComponents.isDisplayed(selectValueLedger, "Selected value")) {
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue, reusableComponents.getPropValues("Testcase2682_LedgerValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Ledger and Operator values are selected and added", browser,
						pathLoc + "/" + testcasemethod, true);

				/*
				 * List<WebElement> elementName = browser.findElements(By.tagName("iframe"));
				 * System.out.println("************ Number of elements "+elementName.size());
				 * //ReusableComponents.switchToFrame(browser,0);
				 * System.out.println("************ Switched frame");
				 */

				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Accounting Period", "Adding values as Accounting period");
				wait(1000);
				if (ReusableComponents.isDisplayed(select_AccountingPeiod_Value, "Selected value")) {
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					wait(1000);
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_AccountingPeriodValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "GL Account Type", "Adding values as Accounting period");
				if (ReusableComponents.isDisplayed(selectValueGLAccountType, "Selected value")) {
					ReusableComponents.clickElement(selectValueGLAccountType, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(selectValueGLAccountType, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_GLAccountTypeValue"),
						"Adding values to the operator");
				ReusableComponents.clickElement(applyButton, "Apply Button");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "GL account type and Operator values are selected and added", browser,
						pathLoc + "/" + testcasemethod, true);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(fieldsPanelTrigger, "Field Panel Trigger");
				ReusableComponents.sendKey(fieldSearchInput, "Report Amount", "Adding values as Report Amount");
				ReusableComponents.wait(3000);
				ReusableComponents.clickElement(selectResultFromFieldSearch, "Click on result");
				ReusableComponents.doubleClickElement(browser, selectResultFromFieldSearch,
						"Select Fields from filter");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(refreshButton, "Refresh Link");
				ReusableComponents.wait(5000);

				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Report amount selected from field panel and added", browser,
						pathLoc + "/" + testcasemethod, false);

				ReusableComponents.clickElement(arrorMarkNextToReportAmount,
						"Click on arrow mark next to report amount");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(selectSummarizeOption, "Select summarize option");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(sumOptionFromSummarize, "Select sum option from Summarize option");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Sum from summarize option selected for report amount", browser,
						pathLoc + "/" + testcasemethod, false);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(clear_Fields_Searchbox, "Field search box cleared");
				ReusableComponents.sendKey(fieldSearchInput, "GL Account Type", "Adding values as Report Amount");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(selectResult_GLAccount_Type_FieldSearch, "Click on result");
				ReusableComponents.doubleClickElement(browser, selectResult_GLAccount_Type_FieldSearch,
						"Select Fields from filter");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(refreshButton, "Refresh Link");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"GL Account Type selected from field panel and added", browser, " ", false);

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Validation 1 : Values gathered from reports page", browser, " ", false);

				// Launch Financial report

				browser.get("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
				ReusableComponents.wait(2000);
				browser.switchTo().alert().accept();
				// Browser.get is used here since there are issue in launching financial report
				// from search app. Once the issue resolved we can comment it and unccomment
				// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
				// Reports",

				// Checking for profit and loss section
				ReusableComponents.wait(10000);

//				ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
//				ReusableComponents.wait(5000);
//				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
//						testcasemethod+"Search app and item icon pressed", browser, pathLoc + "/" + testcasemethod, true);
//
//				ReusableComponents.sendKey(SearchAppAndItemInputbox, "Accounting Home", "Search app and Item inputbox");
//				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, testcasemethod+"Search for reports", browser,
//						pathLoc + "/" + testcasemethod, true);
//
//				ReusableComponents.clickElement(selectValueAsAccountingHomeFromAppAndItemDropdown,
//						"Select value from App and Item dropdown");
//				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Accounting home page opened",
//						browser, " ", true);
//				wait(10000);
//				ReusableComponents.scrollDownByDownArrow(browser);
//				ReusableComponents.actionMoveToElement(browser, FinancialReport_AccountHome);
//				wait(10000);
//				ReusableComponents.clickElement(FinancialReport_AccountHome, "Recurring	Billing");
//				ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Click on	Financial report hyperlink",
//						browser, pass_login, false);

				// Checking for profit and loss section
				if (ReusableComponents.isElementPresent(profitAndLoss_FinancialReport)) {
					ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Profit and Loss Section present",
							browser, pass_login, false);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Profit and loss section is not there", browser, pathLoc + "/" + testcasemethod, true);
				}

				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
						"Clear button of starting account period");
//				ReusableComponents.sendKey(startingAccoutPeriod_FinancialReport,
//						reusableComponents.getPropValues("Testcase2682_StartingAccountPeriodValue"),
//						"Starting Account period");

				ReusableComponents.sendKey(startingAccoutPeriod_FinancialReport, startdate_G,
						"Starting Account period");
				System.out.println("date is " + startdate_G);
				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport,
						"Starting account period input box");
				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
						"Select Starting account period");

				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport_Clear,
						"Clear button of ending account period");
//				ReusableComponents.sendKey(endingAccoutPeriod_FinancialReport,
//						reusableComponents.getPropValues("Testcase2682_EndingAccountPeriodValue"),
//						"Ending Account period"); // instead of get prop values, need to pass start date
				System.out.println("date is " + enddate_G);
				ReusableComponents.sendKey(endingAccoutPeriod_FinancialReport, enddate_G, "Ending Account period");
				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport, "ending account period input box");
				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select ending account period");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Accounting period start and ending period given", browser, " ", false);

				ReusableComponents.isSelectedCheckbox(includeSubTypeoneCheckbox_FinancialReport,
						"Select Include Sub type One check box");
				ReusableComponents.isSelectedCheckbox(suppressZeroAmountCheckbox_FinancialReport,
						"Select Suppress zero amount rows check box");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Include sub type one and Suppress zero amount check boxs are selected ",
						browser, pathLoc + "/" + testcasemethod, true);

				String oldRecordName = firstReport_FinancialReport.getText();

				ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Run button clicked ", browser, pathLoc + "/" + testcasemethod, true);

				wait(10000);

				String newRecord = firstReport_FinancialReport.getText();

				if (!oldRecordName.equalsIgnoreCase(newRecord)) {
					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Link of created financial report : " + hreflink, browser, pathLoc + "\\" + testcasemethod, false);
				} else {

					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There are no new records created, provide valid inputs ", browser,
							pathLoc + "/" + testcasemethod, true);
				}

				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Validation 1 : Values gathered from reports page ", browser,
						pathLoc + "/" + testcasemethod, true);

				// Perform Prerequisites again

				ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Search app and item icon pressed", browser, pathLoc + "/" + testcasemethod,
						true);
				ReusableComponents.sendKey(SearchAppAndItemInputbox, "Reports", "Search app and Item inputbox");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Search for reports", browser, " ",
						false);
				ReusableComponents.clickElement(selectValueFromAppAndItemDropdown,
						"Select value from App and Item dropdown");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Reports page opened", browser, " ",
						false);
				ReusableComponents.clickElement(newReportButton, "New Report Button");
				ReusableComponents.wait(10000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New report dialog box opened",
						browser, " ", false);

				ReusableComponents.switchToFrame(browser, 0);
				ReusableComponents.wait(5000);

				ReusableComponents.clickElement(searchReportTypeTextBox, "Click on Search report type text box");
				ReusableComponents.sendKey(searchReportTypeTextBox, "Transactions with GL Account",
						"Search Report type text box"); // Should know where to store input values

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Looking for Transactions with GL Account", browser, " ", false);
				ReusableComponents.clickElement(chooseReport, "Transactions with GL Account");
				ReusableComponents.clickElement(continueButton_ChooseReportTypePopup,
						"Continue button from Choose report type popup");

				ReusableComponents.wait(10000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Transactions with GL Account Opened",
						browser, " ", false);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Ledger", "Adding values as Ledger");
				if (ReusableComponents.isDisplayed(selectValueLedger, "Selected value")) {
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue, reusableComponents.getPropValues("Testcase2682_LedgerValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Ledger and Operator values are selected and added", browser, " ", false);

				/*
				 * List<WebElement> elementName = browser.findElements(By.tagName("iframe"));
				 * System.out.println("************ Number of elements "+elementName.size());
				 * //ReusableComponents.switchToFrame(browser,0);
				 * System.out.println("************ Switched frame");
				 */

				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Accounting Period", "Adding values as Accounting period");
				if (ReusableComponents.isDisplayed(select_AccountingPeiod_Value, "Selected value")) {
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				}
				ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				wait(3000);
				ReusableComponents.clickElement(lessOrEqualOption, "Greater or Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_StartingAccountPeriodValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Accounting Period", "Adding values as Accounting period");
				if (ReusableComponents.isDisplayed(select_AccountingPeiod_Value, "Selected value")) {
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				}
				ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				wait(3000);
				ReusableComponents.clickElement(greaterOrEqualOption, "Greater or Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_EndingAccountPeriodValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");
				wait(4000);

				ReusableComponents.clickElement(runButtonReportTab, "Run Button");
				wait(4000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Run clicked and report catured", browser, pathLoc + "/" + testcasemethod,
						true);
			} catch (throwNewException e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
						pathLoc + "/" + testcasemethod, true);
			} catch (Exception e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Error During execution of test case" + e.toString(), browser, pathLoc + "/" + testcasemethod,
						true);
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Method Name : [P&L] [P&L] Verify amounts shown for the Expense GL
	 * accounts match with those on the SF version of this report : Menaka
	 ***/
	public synchronized SearchAppItemPage input_2680searchAppAndTest_excel(int threadID, List<String> tempList,
			String pathLoc) throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			String startdate = null, enddate = null, equalsvalueof = null;
			Boolean isselected = false;

			// the excel input value should be supplied to start date and end date

			try {

				String filename = reusableComponents.getPropValues("Financialreportsinput");
				String sheetname = reusableComponents.getPropValues("TC5");

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
				System.out.println("Row count is " + rowCount + " Column count is " + columnCount);

				// read rows and columns

				Iterator<Row> itr = workbooksheet.iterator();

				while (itr.hasNext()) {
					Row row = itr.next();
					if (row.getRowNum() == 0) {
						continue; // just skip the rows if row number is 0 or 1
					}

					if (row.getRowNum() == 1) {
						continue;
					}

					if (row.getRowNum() == 2) {

						Iterator<Cell> celliterator = row.cellIterator();

						while (celliterator.hasNext()) {

							Cell cell = celliterator.next();
							final DataFormatter formatter = new DataFormatter();

							startdate_arr.add(formatter.formatCellValue(cell)); // throw new

						}

					}

				}

			} catch (NoSuchElementException e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			}

			try {
				for (int i = 0; i < startdate_arr.size(); i++) {

					System.out.println(startdate_arr.get(i));
				}

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Reading Excel input sheet, successful", browser, pathLoc + "/" + testcasemethod, false);
				startdate = startdate_arr.get(2);
				enddate = startdate_arr.get(3);
				equalsvalueof = startdate_arr.get(4);
				if (equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
					supressrows = Boolean.valueOf(equalsvalueof);
					ignore_supressrows = "false";
				} else if (equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ")
						|| equalsvalueof.equalsIgnoreCase("")) {
					ignore_supressrows = "true";
				}

				else {

					ignore_supressrows = "true";
				}

				ReusableComponents.wait(5200);

				System.out.println("start date " + startdate + " and end date " + enddate
						+ " equals true or false value is " + equalsvalueof);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"printing excel elements are incomplete", browser, pathLoc + "/" + testcasemethod, true);
			}

			startdate_G = startdate;
			enddate_G = enddate;

			try {
				test_2680serachAppAndTest(threadID, tempList, pathLoc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Method Name : [P&L] The Net Income row shows the Total Revenue
	 * minus Total Expenses
	 * 
	 * : Menaka
	 ***/
	public synchronized SearchAppItemPage test_2680serachAppAndTest(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			try {
				ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Verifying info", browser, pass_login,
						false);

				LoginToWebpage();

				ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Search app and item icon pressed",
						browser, " ", false);
				ReusableComponents.sendKey(SearchAppAndItemInputbox, "Reports", "Search app and Item inputbox");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Search for reports", browser, " ",
						false);
				ReusableComponents.clickElement(selectValueFromAppAndItemDropdown,
						"Select value from App and Item dropdown");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Reports page opened", browser, " ",
						false);
				ReusableComponents.clickElement(newReportButton, "New Report Button");
				ReusableComponents.wait(10000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New report dialog box opened",
						browser, " ", false);

				ReusableComponents.switchToFrame(browser, 0);
				ReusableComponents.wait(5000);

				ReusableComponents.clickElement(searchReportTypeTextBox, "Click on Search report type text box");
				ReusableComponents.sendKey(searchReportTypeTextBox, "Transactions with GL Account",
						"Search Report type text box"); // Should know where to store input values

				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Looking for Transactions with GL Account", browser,
						pathLoc + "/" + testcasemethod, true);

				ReusableComponents.clickElement(chooseReport, "Transactions with GL Account");
				ReusableComponents.clickElement(continueButton_ChooseReportTypePopup,
						"Continue button from Choose report type popup");

				ReusableComponents.wait(10000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Transactions with GL Account Opened", browser, pathLoc + "/" + testcasemethod,
						true);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Ledger", "Adding values as Ledger");
				if (ReusableComponents.isDisplayed(selectValueLedger, "Selected value")) {
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue, reusableComponents.getPropValues("Testcase2682_LedgerValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Ledger and Operator values are selected and added", browser,
						pathLoc + "/" + testcasemethod, true);

				/*
				 * List<WebElement> elementName = browser.findElements(By.tagName("iframe"));
				 * System.out.println("************ Number of elements "+elementName.size());
				 * //ReusableComponents.switchToFrame(browser,0);
				 * System.out.println("************ Switched frame");
				 */

				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Accounting Period", "Adding values as Accounting period");
				wait(1000);
				if (ReusableComponents.isDisplayed(select_AccountingPeiod_Value, "Selected value")) {
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					wait(1000);
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_AccountingPeriodValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "GL Account Type", "Adding values as Accounting period");
				if (ReusableComponents.isDisplayed(selectValueGLAccountType, "Selected value")) {
					ReusableComponents.clickElement(selectValueGLAccountType, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(selectValueGLAccountType, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_GLAccountTypeValue"),
						"Adding values to the operator");
				ReusableComponents.clickElement(applyButton, "Apply Button");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "GL account type and Operator values are selected and added", browser,
						pathLoc + "/" + testcasemethod, true);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(fieldsPanelTrigger, "Field Panel Trigger");
				ReusableComponents.sendKey(fieldSearchInput, "Report Amount", "Adding values as Report Amount");
				ReusableComponents.wait(3000);
				ReusableComponents.clickElement(selectResultFromFieldSearch, "Click on result");
				ReusableComponents.doubleClickElement(browser, selectResultFromFieldSearch,
						"Select Fields from filter");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(refreshButton, "Refresh Link");
				ReusableComponents.wait(5000);

				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Report amount selected from field panel and added", browser,
						pathLoc + "/" + testcasemethod, false);

				ReusableComponents.clickElement(arrorMarkNextToReportAmount,
						"Click on arrow mark next to report amount");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(selectSummarizeOption, "Select summarize option");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(sumOptionFromSummarize, "Select sum option from Summarize option");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Sum from summarize option selected for report amount", browser,
						pathLoc + "/" + testcasemethod, false);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(clear_Fields_Searchbox, "Field search box cleared");
				ReusableComponents.sendKey(fieldSearchInput, "GL Account Type", "Adding values as Report Amount");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(selectResult_GLAccount_Type_FieldSearch, "Click on result");
				ReusableComponents.doubleClickElement(browser, selectResult_GLAccount_Type_FieldSearch,
						"Select Fields from filter");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(refreshButton, "Refresh Link");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"GL Account Type selected from field panel and added", browser, " ", false);

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Validation 1 : Values gathered from reports page", browser, " ", false);

				// Launch Financial report

				browser.get("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
				ReusableComponents.wait(2000);
				browser.switchTo().alert().accept();
				// Browser.get is used here since there are issue in launching financial report
				// from search app. Once the issue resolved we can comment it and unccomment
				// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
				// Reports",

				// Checking for profit and loss section
				ReusableComponents.wait(10000);

//				ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
//				ReusableComponents.wait(5000);
//				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
//						testcasemethod+"Search app and item icon pressed", browser, pathLoc + "/" + testcasemethod, true);
//
//				ReusableComponents.sendKey(SearchAppAndItemInputbox, "Accounting Home", "Search app and Item inputbox");
//				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, testcasemethod+"Search for reports", browser,
//						pathLoc + "/" + testcasemethod, true);
//
//				ReusableComponents.clickElement(selectValueAsAccountingHomeFromAppAndItemDropdown,
//						"Select value from App and Item dropdown");
//				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Accounting home page opened",
//						browser, " ", true);
//				wait(10000);
//				ReusableComponents.scrollDownByDownArrow(browser);
//				ReusableComponents.actionMoveToElement(browser, FinancialReport_AccountHome);
//				wait(10000);
//				ReusableComponents.clickElement(FinancialReport_AccountHome, "Recurring	Billing");
//				ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Click on	Financial report hyperlink",
//						browser, pass_login, false);

				// Checking for profit and loss section
				if (ReusableComponents.isElementPresent(profitAndLoss_FinancialReport)) {
					ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Profit and Loss Section present",
							browser, pass_login, false);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Profit and loss section is not there", browser, pathLoc + "/" + testcasemethod, true);
				}

				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
						"Clear button of starting account period");
				ReusableComponents.sendKey(startingAccoutPeriod_FinancialReport,
						reusableComponents.getPropValues("Testcase2682_StartingAccountPeriodValue"),
						"Starting Account period");
				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport,
						"Starting account period input box");
				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
						"Select Starting account period");

				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport_Clear,
						"Clear button of ending account period");
				ReusableComponents.sendKey(endingAccoutPeriod_FinancialReport,
						reusableComponents.getPropValues("Testcase2682_EndingAccountPeriodValue"),
						"Ending Account period");
				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport, "ending account period input box");
				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select ending account period");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Accounting period start and ending period given", browser, " ", false);

				ReusableComponents.isSelectedCheckbox(includeSubTypeoneCheckbox_FinancialReport,
						"Select Include Sub type One check box");
				ReusableComponents.isSelectedCheckbox(suppressZeroAmountCheckbox_FinancialReport,
						"Select Suppress zero amount rows check box");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Include sub type one and Suppress zero amount check boxs are selected ",
						browser, pathLoc + "/" + testcasemethod, true);

				String oldRecordName = firstReport_FinancialReport.getText();

				ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Run button clicked ", browser, pathLoc + "/" + testcasemethod, true);

				wait(10000);

				String newRecord = firstReport_FinancialReport.getText();

				if (!oldRecordName.equalsIgnoreCase(newRecord)) {
					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Link of created financial report : " + hreflink, browser, pathLoc + "\\" + testcasemethod, false);
				} else {

					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There are no new records created, provide valid inputs ", browser,
							pathLoc + "/" + testcasemethod, true);
				}

				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Validation 1 : Values gathered from reports page ", browser,
						pathLoc + "/" + testcasemethod, true);

				// Perform Prerequisites again

				ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Search app and item icon pressed", browser, pathLoc + "/" + testcasemethod,
						true);
				ReusableComponents.sendKey(SearchAppAndItemInputbox, "Reports", "Search app and Item inputbox");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Search for reports", browser, " ",
						false);
				ReusableComponents.clickElement(selectValueFromAppAndItemDropdown,
						"Select value from App and Item dropdown");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Reports page opened", browser, " ",
						false);
				ReusableComponents.clickElement(newReportButton, "New Report Button");
				ReusableComponents.wait(10000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New report dialog box opened",
						browser, " ", false);

				ReusableComponents.switchToFrame(browser, 0);
				ReusableComponents.wait(5000);

				ReusableComponents.clickElement(searchReportTypeTextBox, "Click on Search report type text box");
				ReusableComponents.sendKey(searchReportTypeTextBox, "Transactions with GL Account",
						"Search Report type text box"); // Should know where to store input values

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Looking for Transactions with GL Account", browser, " ", false);
				ReusableComponents.clickElement(chooseReport, "Transactions with GL Account");
				ReusableComponents.clickElement(continueButton_ChooseReportTypePopup,
						"Continue button from Choose report type popup");

				ReusableComponents.wait(10000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Transactions with GL Account Opened",
						browser, " ", false);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Ledger", "Adding values as Ledger");
				if (ReusableComponents.isDisplayed(selectValueLedger, "Selected value")) {
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue, reusableComponents.getPropValues("Testcase2682_LedgerValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Ledger and Operator values are selected and added", browser, " ", false);

				/*
				 * List<WebElement> elementName = browser.findElements(By.tagName("iframe"));
				 * System.out.println("************ Number of elements "+elementName.size());
				 * //ReusableComponents.switchToFrame(browser,0);
				 * System.out.println("************ Switched frame");
				 */

				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Accounting Period", "Adding values as Accounting period");
				if (ReusableComponents.isDisplayed(select_AccountingPeiod_Value, "Selected value")) {
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				}
				ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				wait(3000);
				ReusableComponents.clickElement(lessOrEqualOption, "Greater or Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_StartingAccountPeriodValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Accounting Period", "Adding values as Accounting period");
				if (ReusableComponents.isDisplayed(select_AccountingPeiod_Value, "Selected value")) {
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				}
				ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				wait(3000);
				ReusableComponents.clickElement(greaterOrEqualOption, "Greater or Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_EndingAccountPeriodValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");
				wait(4000);

				ReusableComponents.clickElement(runButtonReportTab, "Run Button");
				wait(4000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Run clicked and report catured", browser, pathLoc + "/" + testcasemethod,
						true);
			} catch (throwNewException e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
						pathLoc + "/" + testcasemethod, true);
			} catch (Exception e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Error During execution of test case" + e.toString(), browser, pathLoc + "/" + testcasemethod,
						true);
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Method Name : [P&L] [P&L] Verify amounts shown for the Expense GL
	 * accounts match with those on the SF version of this report : Menaka
	 ***/
	public synchronized SearchAppItemPage input_2681searchAppAndTest_excel(int threadID, List<String> tempList,
			String pathLoc) throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			String startdate = null, enddate = null, equalsvalueof = null;
			Boolean isselected = false;

			// the excel input value should be supplied to start date and end date

			try {

				String filename = reusableComponents.getPropValues("Financialreportsinput");
				String sheetname = reusableComponents.getPropValues("TC6");

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
				System.out.println("Row count is " + rowCount + " Column count is " + columnCount);

				// read rows and columns

				Iterator<Row> itr = workbooksheet.iterator();

				while (itr.hasNext()) {
					Row row = itr.next();
					if (row.getRowNum() == 0) {
						continue; // just skip the rows if row number is 0 or 1
					}

					if (row.getRowNum() == 1) {
						continue;
					}

					if (row.getRowNum() == 2) {

						Iterator<Cell> celliterator = row.cellIterator();

						while (celliterator.hasNext()) {

							Cell cell = celliterator.next();
							final DataFormatter formatter = new DataFormatter();

							startdate_arr.add(formatter.formatCellValue(cell)); // throw new

						}

					}

				}

			} catch (NoSuchElementException e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			}

			try {
				for (int i = 0; i < startdate_arr.size(); i++) {

					System.out.println(startdate_arr.get(i));
				}

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Reading Excel input sheet, successful", browser, pathLoc + "/" + testcasemethod, false);
				startdate = startdate_arr.get(2);
				enddate = startdate_arr.get(3);
				equalsvalueof = startdate_arr.get(4);
				if (equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
					supressrows = Boolean.valueOf(equalsvalueof);
					ignore_supressrows = "false";
				} else if (equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ")
						|| equalsvalueof.equalsIgnoreCase("")) {
					ignore_supressrows = "true";
				}

				else {

					ignore_supressrows = "true";
				}

				ReusableComponents.wait(5200);

				System.out.println("start date " + startdate + " and end date " + enddate
						+ " equals true or false value is " + equalsvalueof);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"printing excel elements are incomplete", browser, pathLoc + "/" + testcasemethod, true);
			}

			startdate_G = startdate;
			enddate_G = enddate;

			try {
				test_2681serachAppAndTest(threadID, tempList, pathLoc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Method Name : [P&L] The Total column on the right is the summation
	 * of the amounts for the GL Account row
	 * 
	 * 
	 * : Menaka
	 ***/
	public synchronized SearchAppItemPage test_2681serachAppAndTest(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			try {
				ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Verifying info", browser, pass_login,
						false);

				LoginToWebpage();

				ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Search app and item icon pressed",
						browser, " ", false);
				ReusableComponents.sendKey(SearchAppAndItemInputbox, "Reports", "Search app and Item inputbox");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Search for reports", browser, " ",
						false);
				ReusableComponents.clickElement(selectValueFromAppAndItemDropdown,
						"Select value from App and Item dropdown");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Reports page opened", browser, " ",
						false);
				ReusableComponents.clickElement(newReportButton, "New Report Button");
				ReusableComponents.wait(10000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New report dialog box opened",
						browser, " ", false);

				ReusableComponents.switchToFrame(browser, 0);
				ReusableComponents.wait(5000);

				ReusableComponents.clickElement(searchReportTypeTextBox, "Click on Search report type text box");
				ReusableComponents.sendKey(searchReportTypeTextBox, "Transactions with GL Account",
						"Search Report type text box"); // Should know where to store input values

				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Looking for Transactions with GL Account", browser,
						pathLoc + "/" + testcasemethod, true);

				ReusableComponents.clickElement(chooseReport, "Transactions with GL Account");
				ReusableComponents.clickElement(continueButton_ChooseReportTypePopup,
						"Continue button from Choose report type popup");

				ReusableComponents.wait(10000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Transactions with GL Account Opened", browser, pathLoc + "/" + testcasemethod,
						true);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Ledger", "Adding values as Ledger");
				if (ReusableComponents.isDisplayed(selectValueLedger, "Selected value")) {
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue, reusableComponents.getPropValues("Testcase2682_LedgerValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Ledger and Operator values are selected and added", browser,
						pathLoc + "/" + testcasemethod, true);

				/*
				 * List<WebElement> elementName = browser.findElements(By.tagName("iframe"));
				 * System.out.println("************ Number of elements "+elementName.size());
				 * //ReusableComponents.switchToFrame(browser,0);
				 * System.out.println("************ Switched frame");
				 */

				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Accounting Period", "Adding values as Accounting period");
				wait(1000);
				if (ReusableComponents.isDisplayed(select_AccountingPeiod_Value, "Selected value")) {
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					wait(1000);
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_AccountingPeriodValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "GL Account Type", "Adding values as Accounting period");
				if (ReusableComponents.isDisplayed(selectValueGLAccountType, "Selected value")) {
					ReusableComponents.clickElement(selectValueGLAccountType, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(selectValueGLAccountType, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_GLAccountTypeValue"),
						"Adding values to the operator");
				ReusableComponents.clickElement(applyButton, "Apply Button");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "GL account type and Operator values are selected and added", browser,
						pathLoc + "/" + testcasemethod, true);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(fieldsPanelTrigger, "Field Panel Trigger");
				ReusableComponents.sendKey(fieldSearchInput, "Report Amount", "Adding values as Report Amount");
				ReusableComponents.wait(3000);
				ReusableComponents.clickElement(selectResultFromFieldSearch, "Click on result");
				ReusableComponents.doubleClickElement(browser, selectResultFromFieldSearch,
						"Select Fields from filter");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(refreshButton, "Refresh Link");
				ReusableComponents.wait(5000);

				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Report amount selected from field panel and added", browser,
						pathLoc + "/" + testcasemethod, false);

				ReusableComponents.clickElement(arrorMarkNextToReportAmount,
						"Click on arrow mark next to report amount");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(selectSummarizeOption, "Select summarize option");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(sumOptionFromSummarize, "Select sum option from Summarize option");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Sum from summarize option selected for report amount", browser,
						pathLoc + "/" + testcasemethod, false);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(clear_Fields_Searchbox, "Field search box cleared");
				ReusableComponents.sendKey(fieldSearchInput, "GL Account Type", "Adding values as Report Amount");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(selectResult_GLAccount_Type_FieldSearch, "Click on result");
				ReusableComponents.doubleClickElement(browser, selectResult_GLAccount_Type_FieldSearch,
						"Select Fields from filter");
				ReusableComponents.wait(5000);
				ReusableComponents.clickElement(refreshButton, "Refresh Link");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"GL Account Type selected from field panel and added", browser, " ", false);

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Validation 1 : Values gathered from reports page", browser, " ", false);

				// Launch Financial report

				browser.get("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
				ReusableComponents.wait(2000);
				browser.switchTo().alert().accept();
				// Browser.get is used here since there are issue in launching financial report
				// from search app. Once the issue resolved we can comment it and unccomment
				// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
				// Reports",

				// Checking for profit and loss section
				ReusableComponents.wait(10000);

//				ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
//				ReusableComponents.wait(5000);
//				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
//						testcasemethod+"Search app and item icon pressed", browser, pathLoc + "/" + testcasemethod, true);
//
//				ReusableComponents.sendKey(SearchAppAndItemInputbox, "Accounting Home", "Search app and Item inputbox");
//				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, testcasemethod+"Search for reports", browser,
//						pathLoc + "/" + testcasemethod, true);
//
//				ReusableComponents.clickElement(selectValueAsAccountingHomeFromAppAndItemDropdown,
//						"Select value from App and Item dropdown");
//				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Accounting home page opened",
//						browser, " ", true);
//				wait(10000);
//				ReusableComponents.scrollDownByDownArrow(browser);
//				ReusableComponents.actionMoveToElement(browser, FinancialReport_AccountHome);
//				wait(10000);
//				ReusableComponents.clickElement(FinancialReport_AccountHome, "Recurring	Billing");
//				ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Click on	Financial report hyperlink",
//						browser, pass_login, false);

				// Checking for profit and loss section
				if (ReusableComponents.isElementPresent(profitAndLoss_FinancialReport)) {
					ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Profit and Loss Section present",
							browser, pass_login, false);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Profit and loss section is not there", browser, pathLoc + "/" + testcasemethod, true);
				}

				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
						"Clear button of starting account period");
				ReusableComponents.sendKey(startingAccoutPeriod_FinancialReport,
						reusableComponents.getPropValues("Testcase2682_StartingAccountPeriodValue"),
						"Starting Account period");
				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport,
						"Starting account period input box");
				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
						"Select Starting account period");

				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport_Clear,
						"Clear button of ending account period");
				ReusableComponents.sendKey(endingAccoutPeriod_FinancialReport,
						reusableComponents.getPropValues("Testcase2682_EndingAccountPeriodValue"),
						"Ending Account period");
				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport, "ending account period input box");
				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select ending account period");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Accounting period start and ending period given", browser, " ", false);

				ReusableComponents.isSelectedCheckbox(includeSubTypeoneCheckbox_FinancialReport,
						"Select Include Sub type One check box");
				ReusableComponents.isSelectedCheckbox(suppressZeroAmountCheckbox_FinancialReport,
						"Select Suppress zero amount rows check box");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Include sub type one and Suppress zero amount check boxs are selected ",
						browser, pathLoc + "/" + testcasemethod, true);

				String oldRecordName = firstReport_FinancialReport.getText();

				ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Run button clicked ", browser, pathLoc + "/" + testcasemethod, true);

				wait(10000);

				String newRecord = firstReport_FinancialReport.getText();

				if (!oldRecordName.equalsIgnoreCase(newRecord)) {
					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Link of created financial report : " + hreflink, browser, pathLoc + "\\" + testcasemethod, false);
				} else {

					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There are no new records created, provide valid inputs ", browser,
							pathLoc + "/" + testcasemethod, true);
				}

				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Validation 1 : Values gathered from reports page ", browser,
						pathLoc + "/" + testcasemethod, true);

				// Perform Prerequisites again

				ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
				ReusableComponents.wait(5000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Search app and item icon pressed", browser, pathLoc + "/" + testcasemethod,
						true);
				ReusableComponents.sendKey(SearchAppAndItemInputbox, "Reports", "Search app and Item inputbox");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Search for reports", browser, " ",
						false);
				ReusableComponents.clickElement(selectValueFromAppAndItemDropdown,
						"Select value from App and Item dropdown");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Reports page opened", browser, " ",
						false);
				ReusableComponents.clickElement(newReportButton, "New Report Button");
				ReusableComponents.wait(10000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New report dialog box opened",
						browser, " ", false);

				ReusableComponents.switchToFrame(browser, 0);
				ReusableComponents.wait(5000);

				ReusableComponents.clickElement(searchReportTypeTextBox, "Click on Search report type text box");
				ReusableComponents.sendKey(searchReportTypeTextBox, "Transactions with GL Account",
						"Search Report type text box"); // Should know where to store input values

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Looking for Transactions with GL Account", browser, " ", false);
				ReusableComponents.clickElement(chooseReport, "Transactions with GL Account");
				ReusableComponents.clickElement(continueButton_ChooseReportTypePopup,
						"Continue button from Choose report type popup");

				ReusableComponents.wait(10000);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Transactions with GL Account Opened",
						browser, " ", false);

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Ledger", "Adding values as Ledger");
				if (ReusableComponents.isDisplayed(selectValueLedger, "Selected value")) {
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(selectValueLedger, "Select filter value");
				}
				// ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				// ReusableComponents.clickElement(equalOption, "Equal option");
				ReusableComponents.sendKey(operatorValue, reusableComponents.getPropValues("Testcase2682_LedgerValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Ledger and Operator values are selected and added", browser, " ", false);

				/*
				 * List<WebElement> elementName = browser.findElements(By.tagName("iframe"));
				 * System.out.println("************ Number of elements "+elementName.size());
				 * //ReusableComponents.switchToFrame(browser,0);
				 * System.out.println("************ Switched frame");
				 */

				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Accounting Period", "Adding values as Accounting period");
				if (ReusableComponents.isDisplayed(select_AccountingPeiod_Value, "Selected value")) {
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				}
				ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				wait(3000);
				ReusableComponents.clickElement(lessOrEqualOption, "Greater or Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_StartingAccountPeriodValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");

				ReusableComponents.wait(7000);
				ReusableComponents.clickElement(filtersOption, "Filters option");
				ReusableComponents.sendKey(addFilterTextBox, "Accounting Period", "Adding values as Accounting period");
				if (ReusableComponents.isDisplayed(select_AccountingPeiod_Value, "Selected value")) {
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				} else {
					ReusableComponents.clickElement(addFilterTextBox, "Filters option");
					ReusableComponents.clickElement(select_AccountingPeiod_Value, "Select filter value");
				}
				ReusableComponents.clickElement(operatorButton, "Select Operator drop down");
				wait(3000);
				ReusableComponents.clickElement(greaterOrEqualOption, "Greater or Equal option");
				ReusableComponents.sendKey(operatorValue,
						reusableComponents.getPropValues("Testcase2682_EndingAccountPeriodValue"),
						"Adding values to the operator");// Should be
				ReusableComponents.clickElement(applyButton, "Apply Button");
				wait(4000);

				ReusableComponents.clickElement(runButtonReportTab, "Run Button");
				wait(4000);
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Run clicked and report catured", browser, pathLoc + "/" + testcasemethod,
						true);
			} catch (throwNewException e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
						pathLoc + "/" + testcasemethod, true);
			} catch (Exception e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Error During execution of test case" + e.toString(), browser, pathLoc + "/" + testcasemethod,
						true);
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/*
	 * Login to Webpage Author Menaka
	 */
	public static void LoginToWebpage() throws Exception

	{
		String username = null, pass_login = null;
		username = reusableComponents.getPropValues("username");
		pass_login = reusableComponents.getPropValues("password");
		try {
			ReusableComponents.sendKey(login_user_field, username, "User Name");
			ReusableComponents.sendKey(login_pass_field, pass_login, "Password");
			ReusableComponents.clickElement(login_btn, "Login Button");
			ReusableComponents.wait(10000);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/***
	 * Test case Method Name : [P&L] [P&L] Verify amounts shown for the Expense GL
	 * accounts match with those on the SF version of this report : Menaka
	 * 
	 * @throws throwNewException
	 ***/
	public synchronized SearchAppItemPage input_test_2685exportExcel(int threadID, List<String> tempList,
			String pathLoc) throws IOException, AWTException, throwNewException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			String startdate = null, enddate = null, equalsvalueof = null;
			Boolean isselected = false;

			// the excel input value should be supplied to start date and end date

			try {

				String filename = reusableComponents.getPropValues("Financialreportsinput");
				String sheetname = reusableComponents.getPropValues("TC10");

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
				System.out.println("Row count is " + rowCount + " Column count is " + columnCount);

				// read rows and columns

				Iterator<Row> itr = workbooksheet.iterator();

				while (itr.hasNext()) {
					Row row = itr.next();
					if (row.getRowNum() == 0) {
						continue; // just skip the rows if row number is 0 or 1
					}

					if (row.getRowNum() == 1) {
						continue;
					}

					if (row.getRowNum() == 2) {

						Iterator<Cell> celliterator = row.cellIterator();

						while (celliterator.hasNext()) {

							Cell cell = celliterator.next();
							final DataFormatter formatter = new DataFormatter();

							startdate_arr.add(formatter.formatCellValue(cell)); // throw new

						}

					}

				}

			} catch (NoSuchElementException e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			}

			try {
				for (int i = 0; i < startdate_arr.size(); i++) {

					System.out.println(startdate_arr.get(i));
				}

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Reading Excel input sheet, successful", browser, pathLoc + "/" + testcasemethod, false);
				startdate = startdate_arr.get(2);
				enddate = startdate_arr.get(3);
				equalsvalueof = startdate_arr.get(4);
				if (equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
					supressrows = Boolean.valueOf(equalsvalueof);
					ignore_supressrows = "false";
				} else if (equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ")
						|| equalsvalueof.equalsIgnoreCase("")) {
					ignore_supressrows = "true";
				}

				else {

					ignore_supressrows = "true";
				}

				ReusableComponents.wait(5200);

				System.out.println("start date " + startdate + " and end date " + enddate
						+ " equals true or false value is " + equalsvalueof);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"printing excel elements are incomplete", browser, pathLoc + "/" + testcasemethod, true);
			}

			startdate_G = startdate;
			enddate_G = enddate;

			try {
				test_2685exportExcel(threadID, tempList, pathLoc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * [P&L] Verify the user can save the report to MS Excel Author : Menaka
	 ***/
	public synchronized SearchAppItemPage test_2685exportExcel(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			try {

				LoginToWebpage();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Login to webpage", browser, " ",
						false);

				// Open Financial Reports page
				browser.get("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
				// Browser.get is used here since there are issue in launching financial report
				// from search app. Once the issue resolved we can comment it and unccomment
				// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
				// Reports",

				// Checking for profit and loss section
				wait(10000);

				// Checking for profit and loss section
				if (ReusableComponents.isElementPresent(profitAndLoss_FinancialReport)) {
					ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Profit and Loss Section present",
							browser, pass_login, false);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Profit and loss section is not there", browser, pathLoc + "/" + testcasemethod, true);
				}

				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
						"Clear button of starting account period");
				ReusableComponents.sendKey(startingAccoutPeriod_FinancialReport, startdate_G,
						"Starting Account period");
				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport,
						"Starting account period input box");
				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
						"Select Starting account period");

				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport_Clear,
						"Clear button of ending account period");
				ReusableComponents.sendKey(endingAccoutPeriod_FinancialReport, enddate_G, "Ending Account period");
				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport, "ending account period input box");
				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select ending account period");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Accounting period start and ending period given", browser, " ", false);

				ReusableComponents.isSelectedCheckbox(includeSubTypeoneCheckbox_FinancialReport,
						"Select Include Sub type One check box");
				ReusableComponents.isSelectedCheckbox(suppressZeroAmountCheckbox_FinancialReport,
						"Select Suppress zero amount rows check box");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Include sub type one and Suppress zero amount check boxs are selected ", browser, " ", false);

				List<WebElement> elementName = browser
						.findElements(By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
				String oldRecordName = null;
				if (elementName.size() != 0) {
					oldRecordName = firstReport_FinancialReport.getText();
				}

				ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser, " ",
						false);

				wait(30000);

				String newRecord = firstReport_FinancialReport.getText();

				if (!newRecord.contains("FRR")) {
					ReusableComponents.wait(20000);

					newRecord = firstReport_FinancialReport.getText();
				}

				String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
				if (!oldRecordName.equalsIgnoreCase(newRecord)) {

					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Link of created financial report : " + newRecord + " as follows " + hreflink, browser,
							pathLoc + "\\" + testcasemethod, false);
					ReusableComponents.scrollDownUsingPageDown(browser);

					browser.get(hreflink);

					wait(5000);
					ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
							testcasemethod + "New report opened", browser, pathLoc + "/" + testcasemethod, true);

					ReusableComponents.clickElement(export_FinancialReport_Openpage, "Press Export button");

					/*
					 * wait(1000); \
					 * 
					 * wait(10000); ReusableComponents.reportPassFunction(threadID, tempList,
					 * testcasemethod,
					 * testcasemethod+"Please check the report present under Reports folder",
					 * browser, " ", true);
					 */
				} else {

					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There are no new records created, provide valid inputs ", browser,
							pathLoc + "/" + testcasemethod, true);
				}

			} catch (throwNewException e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
						pathLoc + "/" + testcasemethod, true);
			} catch (Exception e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Error During execution of test case" + e.toString(), browser, pathLoc + "/" + testcasemethod,
						true);
			}

		} catch (

		NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Method Name : [P&L] [P&L] Verify amounts shown for the Expense GL
	 * accounts match with those on the SF version of this report : Menaka
	 * 
	 * @throws throwNewException
	 ***/
	public synchronized SearchAppItemPage input_test_2684PLReportDelete_excel(int threadID, List<String> tempList,
			String pathLoc) throws IOException, AWTException, throwNewException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			String startdate = null, enddate = null, equalsvalueof = null;
			Boolean isselected = false;

			// the excel input value should be supplied to start date and end date

			try {

				String filename = reusableComponents.getPropValues("Financialreportsinput");
				String sheetname = reusableComponents.getPropValues("TC9");

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
				System.out.println("Row count is " + rowCount + " Column count is " + columnCount);

				// read rows and columns

				Iterator<Row> itr = workbooksheet.iterator();

				while (itr.hasNext()) {
					Row row = itr.next();
					if (row.getRowNum() == 0) {
						continue; // just skip the rows if row number is 0 or 1
					}

					if (row.getRowNum() == 1) {
						continue;
					}

					if (row.getRowNum() == 2) {

						Iterator<Cell> celliterator = row.cellIterator();

						while (celliterator.hasNext()) {

							Cell cell = celliterator.next();
							final DataFormatter formatter = new DataFormatter();

							startdate_arr.add(formatter.formatCellValue(cell)); // throw new

						}

					}

				}

			} catch (NoSuchElementException e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			}

			try {
				for (int i = 0; i < startdate_arr.size(); i++) {

					System.out.println(startdate_arr.get(i));
				}

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Reading Excel input sheet, successful", browser, pathLoc + "/" + testcasemethod, false);
				startdate = startdate_arr.get(2);
				enddate = startdate_arr.get(3);
				equalsvalueof = startdate_arr.get(4);
				if (equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
					supressrows = Boolean.valueOf(equalsvalueof);
					ignore_supressrows = "false";
				} else if (equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ")
						|| equalsvalueof.equalsIgnoreCase("")) {
					ignore_supressrows = "true";
				}

				else {

					ignore_supressrows = "true";
				}

				ReusableComponents.wait(5200);

				System.out.println("start date " + startdate + " and end date " + enddate
						+ " equals true or false value is " + equalsvalueof);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"printing excel elements are incomplete", browser, pathLoc + "/" + testcasemethod, true);
			}

			startdate_G = startdate;
			enddate_G = enddate;

			try {
				test_2684PLReportDelete(threadID, tempList, pathLoc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Test case Name : [P&L] Verify that a Profit & Loss report can be
	 * deleted. Author : Menaka
	 ***/
	public synchronized SearchAppItemPage test_2684PLReportDelete(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			try {

				LoginToWebpage();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Login to webpage", browser, " ",
						false);

				// Open Financial Reports page
				browser.get("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
				// Browser.get is used here since there are issue in launching financial report
				// from search app. Once the issue resolved we can comment it and unccomment
				// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
				// Reports",
				wait(5000);

				// Checking for profit and loss section
				if (ReusableComponents.isElementPresent(profitAndLoss_FinancialReport)) {
					ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Profit and Loss Section present",
							browser, pass_login, false);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Profit and loss section is not there", browser, pathLoc + "/" + testcasemethod, true);
				}

				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
						"Clear button of starting account period");
				ReusableComponents.sendKey(startingAccoutPeriod_FinancialReport, startdate_G,
						"Starting Account period");
				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport,
						"Starting account period input box");
				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
						"Select Starting account period");

				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport_Clear,
						"Clear button of ending account period");
				ReusableComponents.sendKey(endingAccoutPeriod_FinancialReport, enddate_G, "Ending Account period");
				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport, "ending account period input box");
				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select ending account period");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Accounting period start and ending period given", browser, " ", false);

				ReusableComponents.isSelectedCheckbox(includeSubTypeoneCheckbox_FinancialReport,
						"Select Include Sub type One check box");
				ReusableComponents.isSelectedCheckbox(suppressZeroAmountCheckbox_FinancialReport,
						"Select Suppress zero amount rows check box");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Include sub type one and Suppress zero amount check boxs are selected ", browser, " ", false);

				String oldRecordName = firstReport_FinancialReport.getText();

				ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser, " ",
						false);

				wait(10000);

				String newRecord = firstReport_FinancialReport.getText();

				if (!oldRecordName.equalsIgnoreCase(newRecord)) {
					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Link of created financial report : " + hreflink, browser, pathLoc + "\\" + testcasemethod, false);
				} else {

					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There are no new records created, provide valid inputs ", browser,
							pathLoc + "/" + testcasemethod, true);
				}
			} catch (throwNewException e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
						pathLoc + "/" + testcasemethod, true);
			} catch (Exception e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Error During execution of test case" + e.toString(), browser, pathLoc + "/" + testcasemethod,
						true);
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Method Name : [P&L] [P&L] Verify amounts shown for the Expense GL
	 * accounts match with those on the SF version of this report : Menaka
	 * 
	 * @throws throwNewException
	 ***/
	public synchronized SearchAppItemPage input_test_2683PLReportCreate_excel(int threadID, List<String> tempList,
			String pathLoc) throws IOException, AWTException, throwNewException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			String startdate = null, enddate = null, equalsvalueof = null;
			Boolean isselected = false;

			// the excel input value should be supplied to start date and end date

			try {

				String filename = reusableComponents.getPropValues("Financialreportsinput");
				String sheetname = reusableComponents.getPropValues("TC8");

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
				System.out.println("Row count is " + rowCount + " Column count is " + columnCount);

				// read rows and columns

				Iterator<Row> itr = workbooksheet.iterator();

				while (itr.hasNext()) {
					Row row = itr.next();
					if (row.getRowNum() == 0) {
						continue; // just skip the rows if row number is 0 or 1
					}

					if (row.getRowNum() == 1) {
						continue;
					}

					if (row.getRowNum() == 2) {

						Iterator<Cell> celliterator = row.cellIterator();

						while (celliterator.hasNext()) {

							Cell cell = celliterator.next();
							final DataFormatter formatter = new DataFormatter();

							startdate_arr.add(formatter.formatCellValue(cell)); // throw new

						}

					}

				}

			} catch (NoSuchElementException e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			}

			try {
				for (int i = 0; i < startdate_arr.size(); i++) {

					System.out.println(startdate_arr.get(i));
				}

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Reading Excel input sheet, successful", browser, pathLoc + "/" + testcasemethod, false);
				startdate = startdate_arr.get(2);
				enddate = startdate_arr.get(3);
				equalsvalueof = startdate_arr.get(4);
				if (equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
					supressrows = Boolean.valueOf(equalsvalueof);
					ignore_supressrows = "false";
				} else if (equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ")
						|| equalsvalueof.equalsIgnoreCase("")) {
					ignore_supressrows = "true";
				}

				else {

					ignore_supressrows = "true";
				}

				ReusableComponents.wait(5200);

				System.out.println("start date " + startdate + " and end date " + enddate
						+ " equals true or false value is " + equalsvalueof);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"printing excel elements are incomplete", browser, pathLoc + "/" + testcasemethod, true);
			}

			startdate_G = startdate;
			enddate_G = enddate;

			try {
				test_2683PLReportCreate(threadID, tempList, pathLoc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Test case Name : [P&L] Verify that the P&L report results can be
	 * grouped by Sub type 1. deleted. Author : Menaka
	 ***/
	public synchronized SearchAppItemPage test_2683PLReportCreate(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException, throwNewException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			try {

				LoginToWebpage();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Login to webpage", browser, " ",
						false);

				// Open Financial Reports page
				browser.get("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
				// Browser.get is used here since there are issue in launching financial report
				// from search app. Once the issue resolved we can comment it and unccomment
				// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
				// Reports",

				// Checking for profit and loss section
				wait(5000);
				if (ReusableComponents.isElementPresent(profitAndLoss_FinancialReport)) {
					ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Profit and Loss Section present",
							browser, pass_login, false);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"Profit and loss section is not there", browser, pathLoc + "/" + testcasemethod, true);
				}

				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
						"Clear button of starting account period");
				ReusableComponents.sendKey(startingAccoutPeriod_FinancialReport, startdate_G,
						"Starting Account period");
				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport,
						"Starting account period input box");
				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
						"Select Starting account period");

				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport_Clear,
						"Clear button of ending account period");
				ReusableComponents.sendKey(endingAccoutPeriod_FinancialReport, enddate_G, "Ending Account period");
				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport, "ending account period input box");
				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select ending account period");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Accounting period start and ending period given", browser, " ", false);

				ReusableComponents.isSelectedCheckbox(includeSubTypeoneCheckbox_FinancialReport,
						"Select Include Sub type One check box");
				ReusableComponents.isSelectedCheckbox(suppressZeroAmountCheckbox_FinancialReport,
						"Select Suppress zero amount rows check box");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Include sub type one and Suppress zero amount check boxs are selected ", browser, " ", false);

				List<WebElement> recordsList = browser
						.findElements(By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
				System.out.println("************ Number of elements " + recordsList.size());

				if (recordsList.size() != 0) {
					String oldRecordName = firstReport_FinancialReport.getText();

					ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser,
							" ", false);

					wait(10000);

					String newRecord = firstReport_FinancialReport.getText();

					if (!newRecord.contains("FRR")) {
						ReusableComponents.wait(20000);

						newRecord = firstReport_FinancialReport.getText();
					}

					if (!oldRecordName.equalsIgnoreCase(newRecord)) {
						String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Link of created financial report : " + hreflink, browser, pathLoc + "\\" + testcasemethod, false);
					} else {

						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There are no new records created, provide valid inputs ", browser,
								pathLoc + "/" + testcasemethod, true);
					}
				} else {

					ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser,
							" ", false);

					wait(10000);

					List<WebElement> newRecordsList = browser
							.findElements(By.xpath("(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]"));
					System.out.println("************ Number of elements " + newRecordsList.size());

					if (newRecordsList.size() == 0) {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod,
								"There are no new records created , please verify the input values", browser,
								pathLoc + "/" + testcasemethod, true);
					} else {
						String newRecord = firstReport_FinancialReport.getText();
						if (!newRecord.contains("FRR")) {
							ReusableComponents.wait(20000);



							newRecord = firstReport_FinancialReport.getText();
							}

						String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
								"Link of created financial report : " + hreflink, browser, pathLoc + "\\" + testcasemethod, false);
					}
				}

			} catch (throwNewException e) {
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
						pathLoc + "/" + testcasemethod, true);
			} catch (Exception e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Error During execution of test case" + e.toString(), browser, pathLoc + "/" + testcasemethod,
						true);
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

//	/***
//	 * Test case Test case Name : [P&L] Verify that the P&L report results can be
//	 * grouped by Sub type 1. deleted. Author : Menaka
//	 ***/
//	public synchronized SearchAppItemPage test_2683PLReportCreate(int threadID, List<String> tempList, String pathLoc)
//			throws IOException, AWTException, throwNewException {
//		String testcasemethod = new Object() {
//		}.getClass().getEnclosingMethod().getName();
//		try {
//
//			ReusableComponents.wait(2300);
//			String username = null, pass_login = null;
//			username = reusableComponents.getPropValues("username");
//			pass_login = reusableComponents.getPropValues("password");
//
//			try {
//
//				LoginToWebpage();
//				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Login to webpage", browser, " ",
//						false);
//
//				// Open Financial Reports page
//				browser.get("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
//				// Browser.get is used here since there are issue in launching financial report
//				// from search app. Once the issue resolved we can comment it and unccomment
//				// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
//				// Reports",
//
//				// Checking for profit and loss section
//				wait(5000);
//				if (ReusableComponents.isElementPresent(profitAndLoss_FinancialReport)) {
//					ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Profit and Loss Section present",
//							browser, pass_login, false);
//				} else {
//					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
//							"Profit and loss section is not there", browser, pathLoc + "/" + testcasemethod, true);
//				}
//
//				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport_Clear,
//						"Clear button of starting account period");
//				ReusableComponents.sendKey(startingAccoutPeriod_FinancialReport, startdate_G, "Starting Account period");
//				ReusableComponents.clickElement(startingAccoutPeriod_FinancialReport,
//						"Starting account period input box");
//				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport,
//						"Select Starting account period");
//
//				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport_Clear,
//						"Clear button of ending account period");
//				ReusableComponents.sendKey(endingAccoutPeriod_FinancialReport, enddate_G, "Ending Account period");
//				ReusableComponents.clickElement(endingAccoutPeriod_FinancialReport, "ending account period input box");
//				ReusableComponents.clickElement(selectAccountingPeriod_FinancialReport, "Select ending account period");
//				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
//						"Accounting period start and ending period given", browser, " ", false);
//
//				ReusableComponents.isSelectedCheckbox(includeSubTypeoneCheckbox_FinancialReport,
//						"Select Include Sub type One check box");
//				ReusableComponents.isSelectedCheckbox(suppressZeroAmountCheckbox_FinancialReport,
//						"Select Suppress zero amount rows check box");
//				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
//						"Include sub type one and Suppress zero amount check boxs are selected ", browser, " ", false);
//
//				String oldRecordName = firstReport_FinancialReport.getText();
//
//				ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
//				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Run button clicked", browser, " ",
//						false);
//
//				wait(10000);
//
//				String newRecord = firstReport_FinancialReport.getText();
//
//				if (!oldRecordName.equalsIgnoreCase(newRecord)) {
//					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
//					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
//							"Link of created financial report : " + hreflink, browser, pathLoc + "\\" + testcasemethod, false);
//				} else {
//
//					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
//							"There are no new records created, provide valid inputs ", browser,
//							pathLoc + "/" + testcasemethod, true);
//				}
//
//			} catch (throwNewException e) {
//				e.printStackTrace();
//				ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
//						pathLoc + "/" + testcasemethod, true);
//			} catch (Exception e) {
//				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
//						"Error During execution of test case" + e.toString(), browser, pathLoc + "/" + testcasemethod,
//						true);
//			}
//
//		} catch (NoSuchElementException e) {
//			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
//					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
//		}
//
//		return new SearchAppItemPage(browser);
//	}

	/***
	 * Test case Test case Name : [P&LvB] Verify that the user can create a Budget
	 * Ledger by specifying a name and the type. Author : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage test_2712LedgerCreateAndShow(int threadID, List<String> tempList,
			String pathLoc) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			LoginToWebpage();

			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Ledgers", selectLedgerFromApp);
			ReusableComponents.clickElement(newLink_LedgerPage, "New Link From Ledger Page");
			wait(5000);
			String ledgerName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_Budget";
			ReusableComponents.sendKey(ledgerName_LedgerPage, ledgerName, "New Ledger Name");
			/*
			 * String ledgerType =
			 * browser.findElement(By.xpath(ledgerType_LedgerPage.toString())).getText();
			 * System.out.println("****************** ledgerType"+ledgerType);
			 * 
			 * 
			 * if (ledgerType == "Budget") { ReusableComponents.reportPass(threadID,
			 * tempList, testcasemethod, "Budget selected as input value of ledger type",
			 * browser, " ", false); } else { ReusableComponents.reportFail(threadID,
			 * tempList, testcasemethod,
			 * "Budget is not selected as input value of ledger type", browser, " ", true);
			 * }
			 */

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Ledger mandatory values are selected ", browser, pathLoc + "/" + testcasemethod,
					true);
			ReusableComponents.clickElement(saveButton_LedgerPage, "Save Button Of Ledgerpage");
			wait(5000);

			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial Cubes", financialCubesFromApp);
			wait(5000);
			ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Financial Cubes page opened", browser,
					" ", false);
			ReusableComponents.clickElement(newLink_FinancialCubes, "New link clicked from financial cubes page");
			wait(5000);
			ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New Financial Cubes page opened",
					browser, " ", false);
			wait(5000);
			ReusableComponents.clickElement(ledger_FinancialCubes, "Ledger dropdown of financial cubes page clicked");
			wait(5000);
			System.out.println("*************************Xpath              .//span[@title='" + ledgerName + "']");

			WebElement newLedger = null;
			System.out.println("************ try cathc frame");
			List<WebElement> elementName = browser.findElements(By.xpath(".//span[@title='" + ledgerName + "']"));
			newLedger = browser.findElement(By.xpath(".//span[@title='" + ledgerName + "']"));

			if (newLedger.isDisplayed() == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Newly created ledger " + ledgerName + " is displayed", browser,
						pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Newly created ledger " + ledgerName + "is not displayed", browser,
						pathLoc + "/" + testcasemethod, false);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "/" + testcasemethod, true);
		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	// Modification after giving code to Sub 07/09/2021
	public static void selectAppFromSearchAppAndItem(int threadID, List<String> tempList, String testcasemethod,
			String appNameToSearch, WebElement selectAppXpath) throws Exception {

		try {
			ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
			ReusableComponents.wait(5000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Search app and item icon pressed", browser, pathLoc + "/" + testcasemethod,
					false);
			ReusableComponents.sendKey(SearchAppAndItemInputbox, appNameToSearch, "Search app and Item inputbox");
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Search for reports", browser, pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(selectAppXpath, "Select value from App and Item dropdown");
			ReusableComponents.wait(5000);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Unable to select app from select search app section" + e.getStackTrace(), browser,
					pathLoc + "/" + testcasemethod, true);
		}

	}

	/***
	 * Test case Method Name : [P&L] [P&L] Verify amounts shown for the Expense GL
	 * accounts match with those on the SF version of this report : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage input_test_2713createBudgetFinancialCube_excel(int threadID,
			List<String> tempList, String pathLoc) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			String startdate = null, enddate = null, equalsvalueof = null, acc_period = null;
			Boolean isselected = false;

			// the excel input value should be supplied to start date and end date

			try {

				String filename = reusableComponents.getPropValues("Financialreportsinput");
				String sheetname = reusableComponents.getPropValues("TC13");

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
				System.out.println("Row count is " + rowCount + " Column count is " + columnCount);

				// read rows and columns

				Iterator<Row> itr = workbooksheet.iterator();

				while (itr.hasNext()) {
					Row row = itr.next();
					if (row.getRowNum() == 0) {
						continue; // just skip the rows if row number is 0 or 1
					}

					if (row.getRowNum() == 1) {
						continue;
					}

					if (row.getRowNum() == 2) {

						Iterator<Cell> celliterator = row.cellIterator();

						while (celliterator.hasNext()) {

							Cell cell = celliterator.next();
							final DataFormatter formatter = new DataFormatter();

							startdate_arr.add(formatter.formatCellValue(cell)); // throw new

						}

					}

				}

			} catch (NoSuchElementException e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			}

			try {
				for (int i = 0; i < startdate_arr.size(); i++) {

					System.out.println(startdate_arr.get(i));
				}

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Reading Excel input sheet, successful", browser, pathLoc + "/" + testcasemethod, false);
				startdate = startdate_arr.get(2);
				enddate = startdate_arr.get(3);
				equalsvalueof = startdate_arr.get(4);
				acc_period = startdate_arr.get(9);

				if (equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
					supressrows = Boolean.valueOf(equalsvalueof);
					ignore_supressrows = "false";
				} else if (equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ")
						|| equalsvalueof.equalsIgnoreCase("")) {
					ignore_supressrows = "true";
				}

				else {

					ignore_supressrows = "true";
				}

				ReusableComponents.wait(5200);

				System.out.println("start date " + startdate + " and end date " + enddate
						+ " equals true or false value is " + equalsvalueof);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"printing excel elements are incomplete", browser, pathLoc + "/" + testcasemethod, true);
			}

			startdate_G = startdate;
			enddate_G = enddate;
			acc_period_G = acc_period;

			try {
				test_2713createBudgetFinancialCube(threadID, tempList, pathLoc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Test case Name : [P&LvB] Verify that Budget Financial cubes can be
	 * created. Author : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage test_2713createBudgetFinancialCube(int threadID, List<String> tempList,
			String pathLoc) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			LoginToWebpage();

			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Ledgers", selectLedgerFromApp);

			ReusableComponents.clickElement(newLink_LedgerPage, "New Link From Ledger Page");
			wait(10000);
			String ledgerName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_Budget";

			ReusableComponents.sendKey(ledgerName_LedgerPage, ledgerName, "New Ledger Name");

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Ledger mandatory values are selected ", browser, pathLoc + "/" + testcasemethod,
					true);
			ReusableComponents.clickElement(saveButton_LedgerPage, "Save Button Of Ledger page");
			wait(5000);

			// Open Financial Cubes page
			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial Cubes", financialCubesFromApp);
			wait(5000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Financial Cubes page opened", browser, pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(newLink_FinancialCubes, "New link clicked from financial cubes page");
			wait(20000);

			ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New Financial Cubes page opened",
					browser, " ", false);
			ReusableComponents.sendKey(year_FinancialCubes,
					reusableComponents.getPropValues("Testcase2713_FinancialCubes_Year"), "Financial Cubes year");

			dynamicValue = reusableComponents.getPropValues("Testcase2713_FinancialCubes_AccountingPeriod");
			ReusableComponents.sendKey(acccountingPeriod_FinancialCubes, dynamicValue, "Accounting Period");
			String[] arrOfStr = dynamicValue.split("-");
			dynamicValue = arrOfStr[1] + "/1/" + arrOfStr[0];
			String xpath_acccountingPeriod_Select_FinancialCubes = ".//lightning-base-combobox-formatted-text[@title='"
					+ dynamicValue + "']";
			wait(5000);
			// ReusableComponents.clickElement(acccountingPeriod_Select_FinancialCubes,"Select
			// value for Accounting Period"); // Dynamic xpath
			ReusableComponents.clickElement_byDynamicXpath(browser, xpath_acccountingPeriod_Select_FinancialCubes,
					"Select Accounting Period");

			ReusableComponents.sendKey(ledger_FinancialCubes, ledgerName, "LedgerName");
			wait(5000);
			dynamicValue = ledgerName;
			String xpath_budgetName_Select_FinancialCubes = "//lightning-base-combobox-formatted-text[@title='"
					+ dynamicValue + "']";
			// ReusableComponents.clickElement(budgetName_Select_FinancialCubes, "Select
			// value for budget name");
			ReusableComponents.clickElement_byDynamicXpath(browser, xpath_budgetName_Select_FinancialCubes,
					"Select newly created budget value");

			ReusableComponents.sendKey(amountInputBox_FinancialCubes,
					reusableComponents.getPropValues("Testcase2713_FinancialCubes_Amount"),
					"Financial Cubes Amount Value");
			ReusableComponents.sendkey_InputKey(amountInputBox_FinancialCubes, Keys.TAB,
					"Financial Cubes Amount Value");
			ReusableComponents.scrollDownUsingPageDown(browser);
			ReusableComponents.sendKey(glAccount_FinancialCubes,
					(String) reusableComponents.props.get("Testcase2713_FinancialCubes_GLACcountType"),
					"GL Account Type");
			wait(5000);

			dynamicValue = (String) reusableComponents.props.get("Testcase2713_FinancialCubes_GLACcountType");

			System.out.println("******************** Print Xpath : " + xpath_glAccount_Select_FinancialCubes);
			// ReusableComponents.clickElement(xpath_glAccount_Select_FinancialCubes,
			// "Select value for GL Account type"); // Dynamic xpath

			String xpath_glAccount_Select_FinancialCubes = "//lightning-base-combobox-formatted-text[@title='"
					+ (String) reusableComponents.props.get("Testcase2713_FinancialCubes_GLACcountType") + "']";

			ReusableComponents.clickElement_byDynamicXpath(browser, xpath_glAccount_Select_FinancialCubes,
					"Select value for GL Account type");

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "New Financial Cube values are given", browser, pathLoc + "/" + testcasemethod,
					true);
			ReusableComponents.clickElement(saveButton_FinancialCubes, "Click Save Button");
			wait(5000);

			// Open Financial Reports page
			browser.get("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
			// Browser.get is used here since there are issue in launching financial report
			// from search app. Once the issue resolved we can comment it and unccomment
			// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
			// Reports",

			wait(5000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Financial Reports page opened", browser, pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(selectStandartReport_FinancialReport, "Click Select standard reportd");
			wait(5000);
			ReusableComponents.clickElement(PLvsBudget_selectStandartReport_FinancialReport,
					"Click Select P & L versus budget");
			wait(5000);
			ReusableComponents.clickElement(clearStartingDate_FinancialReport, "Clear Starting Accounting period");
			ReusableComponents.sendKey(startingAccountingPeriod_FinancialReport, startdate_G,
					"Starting Accounting Period value");
			wait(5000);
			ReusableComponents.clickElement(accountingPeriodSelect_FinancialReport,
					"Select Starting accounting period");
			ReusableComponents.clickElement(clearEndingDate_FinancialReport, "Clear Ending Accounting period");

			ReusableComponents.sendKey(endingAccountingPeriod_FinancialReport, enddate_G,
					"Starting Accounting Period value");
			wait(5000);
			ReusableComponents.clickElement(accountingPeriodSelect_FinancialReport,
					"Select Starting accounting period");
			ReusableComponents.clickElement(clearBudgetLedgerValue_FinancialReport, "Clear Budget Ledger Value");
			ReusableComponents.sendKey(budgetLedgerValue_FinancialReport, ledgerName,
					"Newly Created Budget Ledger Value");
			wait(5000);
			String selectBudgetLedger = ".//*[@class='slds-box box-shadow']//span[contains(text(),'" + ledgerName
					+ "')]";
			System.out.println("****************************** Print xpath " + selectBudgetLedger);

			List<WebElement> elementName = browser.findElements(By.xpath(selectBudgetLedger));
			System.out.println("************ Number of elements " + elementName.size());

			ReusableComponents.clickElement_byDynamicXpath(browser, selectBudgetLedger, "Select newly careted Ludger ");

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

				if (!oldRecordName.equalsIgnoreCase(newRecord)) {
					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Link of created financial report : " + hreflink, browser, pathLoc + "\\" + testcasemethod, false);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There are no new records created, provide valid inputs ", browser,
							pathLoc + "/" + testcasemethod, true);
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
							pathLoc + "/" + testcasemethod, true);
				} else {
					String newRecord = firstReport_FinancialReport.getText();

					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Link of created financial report : " + hreflink, browser, pathLoc + "\\" + testcasemethod, false);
				}

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
		return new SearchAppItemPage(browser);
	}
	
	/***
	 * Test case Method Name : [P&L] [P&L] Verify amounts shown for the Expense GL
	 * accounts match with those on the SF version of this report : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage input_test_2719createBudgetFinancialCube_excel(int threadID,
			List<String> tempList, String pathLoc) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			String startdate = null, enddate = null, equalsvalueof = null, acc_period = null;
			Boolean isselected = false;

			// the excel input value should be supplied to start date and end date

			try {

				String filename = reusableComponents.getPropValues("Financialreportsinput");
				String sheetname = reusableComponents.getPropValues("TC13");

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
				System.out.println("Row count is " + rowCount + " Column count is " + columnCount);

				// read rows and columns

				Iterator<Row> itr = workbooksheet.iterator();

				while (itr.hasNext()) {
					Row row = itr.next();
					if (row.getRowNum() == 0) {
						continue; // just skip the rows if row number is 0 or 1
					}

					if (row.getRowNum() == 1) {
						continue;
					}

					if (row.getRowNum() == 2) {

						Iterator<Cell> celliterator = row.cellIterator();

						while (celliterator.hasNext()) {

							Cell cell = celliterator.next();
							final DataFormatter formatter = new DataFormatter();

							startdate_arr.add(formatter.formatCellValue(cell)); // throw new

						}

					}

				}

			} catch (NoSuchElementException e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			}

			try {
				for (int i = 0; i < startdate_arr.size(); i++) {

					System.out.println(startdate_arr.get(i));
				}

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Reading Excel input sheet, successful", browser, pathLoc + "/" + testcasemethod, false);
				startdate = startdate_arr.get(2);
				enddate = startdate_arr.get(3);
				equalsvalueof = startdate_arr.get(4);
				acc_period = startdate_arr.get(9);

				if (equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
					supressrows = Boolean.valueOf(equalsvalueof);
					ignore_supressrows = "false";
				} else if (equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ")
						|| equalsvalueof.equalsIgnoreCase("")) {
					ignore_supressrows = "true";
				}

				else {

					ignore_supressrows = "true";
				}

				ReusableComponents.wait(5200);

				System.out.println("start date " + startdate + " and end date " + enddate
						+ " equals true or false value is " + equalsvalueof);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"printing excel elements are incomplete", browser, pathLoc + "/" + testcasemethod, true);
			}

			startdate_G = startdate;
			enddate_G = enddate;
			acc_period_G = acc_period;

			try {
				test_2719createBudgetFinancialCube(threadID, tempList, pathLoc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Test case Name : [P&LvB] Verify that Budget Financial cubes can be
	 * created. Author : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage test_2719createBudgetFinancialCube(int threadID, List<String> tempList,
			String pathLoc) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			LoginToWebpage();

			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Ledgers", selectLedgerFromApp);

			ReusableComponents.clickElement(newLink_LedgerPage, "New Link From Ledger Page");
			wait(10000);
			String ledgerName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_Budget";

			ReusableComponents.sendKey(ledgerName_LedgerPage, ledgerName, "New Ledger Name");

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Ledger mandatory values are selected ", browser, pathLoc + "/" + testcasemethod,
					true);
			ReusableComponents.clickElement(saveButton_LedgerPage, "Save Button Of Ledger page");
			wait(5000);

			// Open Financial Cubes page
			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial Cubes", financialCubesFromApp);
			wait(5000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Financial Cubes page opened", browser, pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(newLink_FinancialCubes, "New link clicked from financial cubes page");
			wait(20000);

			ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New Financial Cubes page opened",
					browser, " ", false);
			ReusableComponents.sendKey(year_FinancialCubes,
					reusableComponents.getPropValues("Testcase2713_FinancialCubes_Year"), "Financial Cubes year");

			dynamicValue = reusableComponents.getPropValues("Testcase2713_FinancialCubes_AccountingPeriod");
			ReusableComponents.sendKey(acccountingPeriod_FinancialCubes, dynamicValue, "Accounting Period");
			String[] arrOfStr = dynamicValue.split("-");
			dynamicValue = arrOfStr[1] + "/1/" + arrOfStr[0];
			String xpath_acccountingPeriod_Select_FinancialCubes = ".//lightning-base-combobox-formatted-text[@title='"
					+ dynamicValue + "']";
			wait(5000);
			// ReusableComponents.clickElement(acccountingPeriod_Select_FinancialCubes,"Select
			// value for Accounting Period"); // Dynamic xpath
			ReusableComponents.clickElement_byDynamicXpath(browser, xpath_acccountingPeriod_Select_FinancialCubes,
					"Select Accounting Period");

			ReusableComponents.sendKey(ledger_FinancialCubes, ledgerName, "LedgerName");
			wait(5000);
			dynamicValue = ledgerName;
			String xpath_budgetName_Select_FinancialCubes = "//lightning-base-combobox-formatted-text[@title='"
					+ dynamicValue + "']";
			// ReusableComponents.clickElement(budgetName_Select_FinancialCubes, "Select
			// value for budget name");
			ReusableComponents.clickElement_byDynamicXpath(browser, xpath_budgetName_Select_FinancialCubes,
					"Select newly created budget value");

			ReusableComponents.sendKey(amountInputBox_FinancialCubes,
					reusableComponents.getPropValues("Testcase2713_FinancialCubes_Amount"),
					"Financial Cubes Amount Value");
			ReusableComponents.sendkey_InputKey(amountInputBox_FinancialCubes, Keys.TAB,
					"Financial Cubes Amount Value");
			ReusableComponents.scrollDownUsingPageDown(browser);
			ReusableComponents.sendKey(glAccount_FinancialCubes,
					(String) reusableComponents.props.get("Testcase2713_FinancialCubes_GLACcountType"),
					"GL Account Type");
			wait(5000);

			dynamicValue = (String) reusableComponents.props.get("Testcase2713_FinancialCubes_GLACcountType");

			System.out.println("******************** Print Xpath : " + xpath_glAccount_Select_FinancialCubes);
			// ReusableComponents.clickElement(xpath_glAccount_Select_FinancialCubes,
			// "Select value for GL Account type"); // Dynamic xpath

			String xpath_glAccount_Select_FinancialCubes = "//lightning-base-combobox-formatted-text[@title='"
					+ (String) reusableComponents.props.get("Testcase2713_FinancialCubes_GLACcountType") + "']";

			ReusableComponents.clickElement_byDynamicXpath(browser, xpath_glAccount_Select_FinancialCubes,
					"Select value for GL Account type");

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "New Financial Cube values are given", browser, pathLoc + "/" + testcasemethod,
					true);
			ReusableComponents.clickElement(saveButton_FinancialCubes, "Click Save Button");
			wait(5000);

			// Open Financial Reports page
			browser.get("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
			// Browser.get is used here since there are issue in launching financial report
			// from search app. Once the issue resolved we can comment it and unccomment
			// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
			// Reports",

			wait(5000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Financial Reports page opened", browser, pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(selectStandartReport_FinancialReport, "Click Select standard reportd");
			wait(5000);
			ReusableComponents.clickElement(PLvsBudget_selectStandartReport_FinancialReport,
					"Click Select P & L versus budget");
			wait(5000);
			ReusableComponents.clickElement(clearStartingDate_FinancialReport, "Clear Starting Accounting period");
			ReusableComponents.sendKey(startingAccountingPeriod_FinancialReport, startdate_G,
					"Starting Accounting Period value");
			wait(5000);
			ReusableComponents.clickElement(accountingPeriodSelect_FinancialReport,
					"Select Starting accounting period");
			ReusableComponents.clickElement(clearEndingDate_FinancialReport, "Clear Ending Accounting period");

			ReusableComponents.sendKey(endingAccountingPeriod_FinancialReport, enddate_G,
					"Starting Accounting Period value");
			wait(5000);
			ReusableComponents.clickElement(accountingPeriodSelect_FinancialReport,
					"Select Starting accounting period");
			ReusableComponents.clickElement(clearBudgetLedgerValue_FinancialReport, "Clear Budget Ledger Value");
			ReusableComponents.sendKey(budgetLedgerValue_FinancialReport, ledgerName,
					"Newly Created Budget Ledger Value");
			wait(5000);
			String selectBudgetLedger = ".//*[@class='slds-box box-shadow']//span[contains(text(),'" + ledgerName
					+ "')]";
			System.out.println("****************************** Print xpath " + selectBudgetLedger);

			List<WebElement> elementName = browser.findElements(By.xpath(selectBudgetLedger));
			System.out.println("************ Number of elements " + elementName.size());

			ReusableComponents.clickElement_byDynamicXpath(browser, selectBudgetLedger, "Select newly careted Ludger ");

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

				if (!oldRecordName.equalsIgnoreCase(newRecord)) {
					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Link of created financial report : " + hreflink, browser, pathLoc + "\\" + testcasemethod, false);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There are no new records created, provide valid inputs ", browser,
							pathLoc + "/" + testcasemethod, true);
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
							pathLoc + "/" + testcasemethod, true);
				} else {
					String newRecord = firstReport_FinancialReport.getText();

					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Link of created financial report : " + hreflink, browser, pathLoc + "\\" + testcasemethod, false);
				}

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
		return new SearchAppItemPage(browser);
	}
	
	/***
	 * Test case Method Name : [P&L] [P&L] Verify amounts shown for the Expense GL
	 * accounts match with those on the SF version of this report : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage input_test_2720createBudgetFinancialCube_excel(int threadID,
			List<String> tempList, String pathLoc) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			String startdate = null, enddate = null, equalsvalueof = null, acc_period = null;
			Boolean isselected = false;

			// the excel input value should be supplied to start date and end date

			try {

				String filename = reusableComponents.getPropValues("Financialreportsinput");
				String sheetname = reusableComponents.getPropValues("TC13");

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
				System.out.println("Row count is " + rowCount + " Column count is " + columnCount);

				// read rows and columns

				Iterator<Row> itr = workbooksheet.iterator();

				while (itr.hasNext()) {
					Row row = itr.next();
					if (row.getRowNum() == 0) {
						continue; // just skip the rows if row number is 0 or 1
					}

					if (row.getRowNum() == 1) {
						continue;
					}

					if (row.getRowNum() == 2) {

						Iterator<Cell> celliterator = row.cellIterator();

						while (celliterator.hasNext()) {

							Cell cell = celliterator.next();
							final DataFormatter formatter = new DataFormatter();

							startdate_arr.add(formatter.formatCellValue(cell)); // throw new

						}

					}

				}

			} catch (NoSuchElementException e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			}

			try {
				for (int i = 0; i < startdate_arr.size(); i++) {

					System.out.println(startdate_arr.get(i));
				}

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Reading Excel input sheet, successful", browser, pathLoc + "/" + testcasemethod, false);
				startdate = startdate_arr.get(2);
				enddate = startdate_arr.get(3);
				equalsvalueof = startdate_arr.get(4);
				acc_period = startdate_arr.get(9);

				if (equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
					supressrows = Boolean.valueOf(equalsvalueof);
					ignore_supressrows = "false";
				} else if (equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ")
						|| equalsvalueof.equalsIgnoreCase("")) {
					ignore_supressrows = "true";
				}

				else {

					ignore_supressrows = "true";
				}

				ReusableComponents.wait(5200);

				System.out.println("start date " + startdate + " and end date " + enddate
						+ " equals true or false value is " + equalsvalueof);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"printing excel elements are incomplete", browser, pathLoc + "/" + testcasemethod, true);
			}

			startdate_G = startdate;
			enddate_G = enddate;
			acc_period_G = acc_period;

			try {
				test_2720createBudgetFinancialCube(threadID, tempList, pathLoc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Test case Name : [P&LvB] Verify that Budget Financial cubes can be
	 * created. Author : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage test_2720createBudgetFinancialCube(int threadID, List<String> tempList,
			String pathLoc) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			LoginToWebpage();

			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Ledgers", selectLedgerFromApp);

			ReusableComponents.clickElement(newLink_LedgerPage, "New Link From Ledger Page");
			wait(10000);
			String ledgerName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_Budget";

			ReusableComponents.sendKey(ledgerName_LedgerPage, ledgerName, "New Ledger Name");

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Ledger mandatory values are selected ", browser, pathLoc + "/" + testcasemethod,
					true);
			ReusableComponents.clickElement(saveButton_LedgerPage, "Save Button Of Ledger page");
			wait(5000);

			// Open Financial Cubes page
			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial Cubes", financialCubesFromApp);
			wait(5000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Financial Cubes page opened", browser, pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(newLink_FinancialCubes, "New link clicked from financial cubes page");
			wait(20000);

			ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New Financial Cubes page opened",
					browser, " ", false);
			ReusableComponents.sendKey(year_FinancialCubes,
					reusableComponents.getPropValues("Testcase2713_FinancialCubes_Year"), "Financial Cubes year");

			dynamicValue = reusableComponents.getPropValues("Testcase2713_FinancialCubes_AccountingPeriod");
			ReusableComponents.sendKey(acccountingPeriod_FinancialCubes, dynamicValue, "Accounting Period");
			String[] arrOfStr = dynamicValue.split("-");
			dynamicValue = arrOfStr[1] + "/1/" + arrOfStr[0];
			String xpath_acccountingPeriod_Select_FinancialCubes = ".//lightning-base-combobox-formatted-text[@title='"
					+ dynamicValue + "']";
			wait(5000);
			// ReusableComponents.clickElement(acccountingPeriod_Select_FinancialCubes,"Select
			// value for Accounting Period"); // Dynamic xpath
			ReusableComponents.clickElement_byDynamicXpath(browser, xpath_acccountingPeriod_Select_FinancialCubes,
					"Select Accounting Period");

			ReusableComponents.sendKey(ledger_FinancialCubes, ledgerName, "LedgerName");
			wait(5000);
			dynamicValue = ledgerName;
			String xpath_budgetName_Select_FinancialCubes = "//lightning-base-combobox-formatted-text[@title='"
					+ dynamicValue + "']";
			// ReusableComponents.clickElement(budgetName_Select_FinancialCubes, "Select
			// value for budget name");
			ReusableComponents.clickElement_byDynamicXpath(browser, xpath_budgetName_Select_FinancialCubes,
					"Select newly created budget value");

			ReusableComponents.sendKey(amountInputBox_FinancialCubes,
					reusableComponents.getPropValues("Testcase2713_FinancialCubes_Amount"),
					"Financial Cubes Amount Value");
			ReusableComponents.sendkey_InputKey(amountInputBox_FinancialCubes, Keys.TAB,
					"Financial Cubes Amount Value");
			ReusableComponents.scrollDownUsingPageDown(browser);
			ReusableComponents.sendKey(glAccount_FinancialCubes,
					(String) reusableComponents.props.get("Testcase2713_FinancialCubes_GLACcountType"),
					"GL Account Type");
			wait(5000);

			dynamicValue = (String) reusableComponents.props.get("Testcase2713_FinancialCubes_GLACcountType");

			System.out.println("******************** Print Xpath : " + xpath_glAccount_Select_FinancialCubes);
			// ReusableComponents.clickElement(xpath_glAccount_Select_FinancialCubes,
			// "Select value for GL Account type"); // Dynamic xpath

			String xpath_glAccount_Select_FinancialCubes = "//lightning-base-combobox-formatted-text[@title='"
					+ (String) reusableComponents.props.get("Testcase2713_FinancialCubes_GLACcountType") + "']";

			ReusableComponents.clickElement_byDynamicXpath(browser, xpath_glAccount_Select_FinancialCubes,
					"Select value for GL Account type");

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "New Financial Cube values are given", browser, pathLoc + "/" + testcasemethod,
					true);
			ReusableComponents.clickElement(saveButton_FinancialCubes, "Click Save Button");
			wait(5000);

			// Open Financial Reports page
			browser.get("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
			// Browser.get is used here since there are issue in launching financial report
			// from search app. Once the issue resolved we can comment it and unccomment
			// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
			// Reports",

			wait(5000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Financial Reports page opened", browser, pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(selectStandartReport_FinancialReport, "Click Select standard reportd");
			wait(5000);
			ReusableComponents.clickElement(PLvsBudget_selectStandartReport_FinancialReport,
					"Click Select P & L versus budget");
			wait(5000);
			ReusableComponents.clickElement(clearStartingDate_FinancialReport, "Clear Starting Accounting period");
			ReusableComponents.sendKey(startingAccountingPeriod_FinancialReport, startdate_G,
					"Starting Accounting Period value");
			wait(5000);
			ReusableComponents.clickElement(accountingPeriodSelect_FinancialReport,
					"Select Starting accounting period");
			ReusableComponents.clickElement(clearEndingDate_FinancialReport, "Clear Ending Accounting period");

			ReusableComponents.sendKey(endingAccountingPeriod_FinancialReport, enddate_G,
					"Starting Accounting Period value");
			wait(5000);
			ReusableComponents.clickElement(accountingPeriodSelect_FinancialReport,
					"Select Starting accounting period");
			ReusableComponents.clickElement(clearBudgetLedgerValue_FinancialReport, "Clear Budget Ledger Value");
			ReusableComponents.sendKey(budgetLedgerValue_FinancialReport, ledgerName,
					"Newly Created Budget Ledger Value");
			wait(5000);
			String selectBudgetLedger = ".//*[@class='slds-box box-shadow']//span[contains(text(),'" + ledgerName
					+ "')]";
			System.out.println("****************************** Print xpath " + selectBudgetLedger);

			List<WebElement> elementName = browser.findElements(By.xpath(selectBudgetLedger));
			System.out.println("************ Number of elements " + elementName.size());

			ReusableComponents.clickElement_byDynamicXpath(browser, selectBudgetLedger, "Select newly careted Ludger ");

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

				if (!oldRecordName.equalsIgnoreCase(newRecord)) {
					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Link of created financial report : " + hreflink, browser, pathLoc + "\\" + testcasemethod, false);
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod,
							"There are no new records created, provide valid inputs ", browser,
							pathLoc + "/" + testcasemethod, true);
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
							pathLoc + "/" + testcasemethod, true);
				} else {
					String newRecord = firstReport_FinancialReport.getText();

					String hreflink = reusableComponents.getAttribute(firstReport_FinancialReport, "href");
					ReusableComponents.reportPass(threadID, tempList, testcasemethod,
							"Link of created financial report : " + hreflink, browser, pathLoc + "\\" + testcasemethod, false);
				}

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
		return new SearchAppItemPage(browser);
	}

//	/***
//	 * Test case Test case Name : [P&LvB] Verify that Budget Financial cubes can be
//	 * created. Author : Menaka
//	 * 
//	 * @throws Exception
//	 ***/
//	public synchronized SearchAppItemPage test_2713createBudgetFinancialCube(int threadID, List<String> tempList,
//			String pathLoc) throws Exception {
//		String testcasemethod = new Object() {
//		}.getClass().getEnclosingMethod().getName();
//		try {
//
//			ReusableComponents.wait(2300);
//			String username = null, pass_login = null;
//			username = reusableComponents.getPropValues("username");
//			pass_login = reusableComponents.getPropValues("password");
//
//			LoginToWebpage();
//
//			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Ledgers", selectLedgerFromApp);
//
//			ReusableComponents.clickElement(newLink_LedgerPage, "New Link From Ledger Page");
//			wait(5000);
//			String ledgerName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_Budget";
//
//			ReusableComponents.sendKey(ledgerName_LedgerPage, ledgerName, "New Ledger Name");
//
//			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
//					testcasemethod+"Ledger mandatory values are selected ", browser, pathLoc + "/" + testcasemethod, true);
//			ReusableComponents.clickElement(saveButton_LedgerPage, "Save Button Of Ledger page");
//			wait(5000);
//
//			// Open Financial Cubes page
//			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial Cubes", financialCubesFromApp);
//			wait(5000);
//			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, testcasemethod+"Financial Cubes page opened",
//					browser, pathLoc + "/" + testcasemethod, true);
//			ReusableComponents.clickElement(newLink_FinancialCubes, "New link clicked from financial cubes page");
//			wait(5000);
//			ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New Financial Cubes page opened",
//					browser, " ", false);
//			ReusableComponents.sendKey(year_FinancialCubes,
//					reusableComponents.getPropValues("Testcase2713_FinancialCubes_Year"), "Financial Cubes year");
//
//			dynamicValue = reusableComponents.getPropValues("Testcase2713_FinancialCubes_AccountingPeriod");
//			ReusableComponents.sendKey(acccountingPeriod_FinancialCubes, dynamicValue, "Accounting Period");
//			String[] arrOfStr = dynamicValue.split("-");
//			dynamicValue = arrOfStr[1] + "/1/" + arrOfStr[0];
//			String xpath_acccountingPeriod_Select_FinancialCubes = ".//lightning-base-combobox-formatted-text[@title='"
//					+ dynamicValue + "']";
//			wait(5000);
//			// ReusableComponents.clickElement(acccountingPeriod_Select_FinancialCubes,"Select
//			// value for Accounting Period"); // Dynamic xpath
//			ReusableComponents.clickElement_byDynamicXpath(browser, xpath_acccountingPeriod_Select_FinancialCubes,
//					"Select Accounting Period");
//
//			ReusableComponents.sendKey(ledger_FinancialCubes, ledgerName, "LedgerName");
//			wait(5000);
//			dynamicValue = ledgerName;
//			String xpath_budgetName_Select_FinancialCubes = "//lightning-base-combobox-formatted-text[@title='"
//					+ dynamicValue + "']";
//			// ReusableComponents.clickElement(budgetName_Select_FinancialCubes, "Select
//			// value for budget name");
//			ReusableComponents.clickElement_byDynamicXpath(browser, xpath_budgetName_Select_FinancialCubes,
//					"Select newly created budget value");
//
//			ReusableComponents.sendKey(amountInputBox_FinancialCubes,
//					reusableComponents.getPropValues("Testcase2713_FinancialCubes_Amount"),
//					"Financial Cubes Amount Value");
//			ReusableComponents.sendkey_InputKey(amountInputBox_FinancialCubes, Keys.TAB,
//					"Financial Cubes Amount Value");
//			ReusableComponents.scrollDownByDownArrow(browser);
//			ReusableComponents.sendKey(glAccount_FinancialCubes,
//					(String) reusableComponents.props.get("Testcase2713_FinancialCubes_GLACcountType"),
//					"GL Account Type");
//			wait(5000);
//
//			dynamicValue = (String) reusableComponents.props.get("Testcase2713_FinancialCubes_GLACcountType");
//
//			System.out.println("******************** Print Xpath : " + xpath_glAccount_Select_FinancialCubes);
//			// ReusableComponents.clickElement(xpath_glAccount_Select_FinancialCubes,
//			// "Select value for GL Account type"); // Dynamic xpath
//
//			String xpath_glAccount_Select_FinancialCubes = "//lightning-base-combobox-formatted-text[@title='"
//					+ (String) reusableComponents.props.get("Testcase2713_FinancialCubes_GLACcountType") + "']";
//
//			ReusableComponents.clickElement_byDynamicXpath(browser, xpath_glAccount_Select_FinancialCubes,
//					"Select value for GL Account type");
//
//			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
//					testcasemethod+"New Financial Cube values are given", browser, pathLoc + "/" + testcasemethod, true);
//			ReusableComponents.clickElement(saveButton_FinancialCubes, "Click Save Button");
//			wait(5000);
//
//			// Open Financial Reports page
//			browser.get("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
//			// Browser.get is used here since there are issue in launching financial report
//			// from search app. Once the issue resolved we can comment it and unccomment
//			// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
//			// Reports",
//
//			wait(5000);
//			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, testcasemethod+"Financial Reports page opened",
//					browser, pathLoc + "/" + testcasemethod, true);
//			ReusableComponents.clickElement(selectStandartReport_FinancialReport, "Click Select standard report");
//			wait(5000);
//			ReusableComponents.clickElement(PLvsBudget_selectStandartReport_FinancialReport,
//					"Click Select P & L versus budget");
//			wait(5000);
//			ReusableComponents.clickElement(clearStartingDate_FinancialReport, "Clear Starting Accounting period");
//			ReusableComponents.sendKey(startingAccountingPeriod_FinancialReport,startdate_G,
//					"Starting Accounting Period value");
//			wait(5000);
//			ReusableComponents.clickElement(accountingPeriodSelect_FinancialReport,
//					"Select Starting accounting period");
//			ReusableComponents.clickElement(clearEndingDate_FinancialReport, "Clear Ending Accounting period");
//
//			ReusableComponents.sendKey(endingAccountingPeriod_FinancialReport,
//					enddate_G,
//					"Starting Accounting Period value");
//			wait(5000);
//			ReusableComponents.clickElement(accountingPeriodSelect_FinancialReport,
//					"Select Starting accounting period");
//			ReusableComponents.clickElement(clearBudgetLedgerValue_FinancialReport, "Clear Budget Ledger Value");
//			ReusableComponents.sendKey(budgetLedgerValue_FinancialReport, ledgerName,
//					"Newly Created Budget Ledger Value");
//			wait(5000);
//			String selectBudgetLedger = ".//*[@class='slds-box box-shadow']//span[contains(text(),'" + ledgerName
//					+ "')]";
//			System.out.println("****************************** Print xpath " + selectBudgetLedger);
//
//			List<WebElement> elementName = browser.findElements(By.xpath(selectBudgetLedger));
//			System.out.println("************ Number of elements " + elementName.size());
//			System.out.println("************ Switched frame");
//
//			ReusableComponents.clickElement_byDynamicXpath(browser, selectBudgetLedger, "Select newly careted Ludger ");
//			String oldRecordName = firstReport_PandLVsBudgetFinancialReport.getText();
//			ReusableComponents.clickElement(runButton_FinancialReport, "Run Financial Report");
//			wait(5000);
//			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, testcasemethod+"Clicked On Run button", browser,
//					pathLoc + "/" + testcasemethod, true);
//
//			wait(5000);
//
//			ReusableComponents.clickElement(runButton_FinancialReport, "Clicked on run button");
//			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod, testcasemethod+"Run button clicked ", browser,
//					pathLoc + "/" + testcasemethod, true);
//
//			wait(10000);
//
//			String newRecord = firstReport_PandLVsBudgetFinancialReport.getText();
//
//			if (!oldRecordName.equalsIgnoreCase(newRecord)) {
//				String hreflink = reusableComponents.getAttribute(firstReport_PandLVsBudgetFinancialReport, "href");
//				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
//						"Link of created Profit & Loss Versus Budget financial report : " + hreflink, browser, hreflink,
//						false);
//			} else {
//
//				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
//						"There are no new records created, provide valid inputs ", browser,
//						pathLoc + "/" + testcasemethod, true);
//			}
//		} catch (throwNewException e) {
//			e.printStackTrace();
//			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
//					pathLoc + "/" + testcasemethod, true);
//		} catch (NoSuchElementException e) {
//			e.printStackTrace();
//			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
//					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, true);
//		}
//		return new SearchAppItemPage(browser);
//	}
//
	/***
	 * Test case Test case Name : Opportunities created. Author : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage test_opportunities(int threadID, List<String> tempList, String pathLoc)
			throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			LoginToWebpage();

			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Opportunities", opportunitiesFromApp);
			ReusableComponents.clickElement(newLink_LedgerPage, "Select new button from opportunities page ");
			wait(5000);

			/*
			 * List<WebElement> elementName = browser.findElements(By.tagName("iframe"));
			 * System.out.println("************ Number of elements " + elementName.size());
			 * // ReusableComponents.switchToFrame(browser,0);
			 * System.out.println("************ Switched frame");
			 */

			String opportunityName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_Opportunity";
			ReusableComponents.sendKey(name_NewOpportunity, opportunityName, "Opportunity Name");
			ReusableComponents.sendKey(closeDate_NewOpportunity, reusableComponents.getPropValues("opportunityDate"),
					"Opportunity Date");

			ReusableComponents.scrollDown_insidepopup_ByPGDN(browser, popupof_NewOpportunity);

			ReusableComponents.clickElement(stage_NewOpportunity, "Click on stage input box");
			wait(2000);
			String input_Of_Stage_Option = reusableComponents.getPropValues("stage_Option");
			String dynamic_xpath = ".//span[@title='" + input_Of_Stage_Option + "']";
			ReusableComponents.clickElement_byDynamicXpath(browser, dynamic_xpath,
					"Select " + input_Of_Stage_Option + " option for stage");

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Provided all manditory values to create new opportunity", browser,
					pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(saveButton_LedgerPage, "Click on save button");
			wait(5000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Navigated to new opportunity page", browser, pathLoc + "/" + testcasemethod,
					true);
			String checkCreatedOpportunity = ".//lightning-formatted-text[contains(text(),'" + opportunityName + "')]";

			System.out.println("Print xpath " + checkCreatedOpportunity);
			boolean opportunityCreated = browser.findElement(By.xpath(checkCreatedOpportunity)).isDisplayed();
			System.out.println("********************** Element visibility" + checkCreatedOpportunity);
			if (opportunityCreated == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Newly created opportunity " + opportunityName + " is displayed", browser,
						pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Opportunity " + opportunityName + " is created", browser, pathLoc + "/" + testcasemethod,
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
		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Test case Name : Bank deposite created. Author : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage test_bankDeposite(int threadID, List<String> tempList, String pathLoc)
			throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			LoginToWebpage();

			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Bank deposits", bankDepositsFromApp);
			ReusableComponents.clickElement(newLink_LedgerPage, "Select new button from opportunities page ");
			wait(10000);

			List<WebElement> elementName = browser.findElements(By.tagName("iframe"));
			System.out.println("************ Number of elements " + elementName.size());
			// ReusableComponents.switchToFrame(browser,0);
			System.out.println("************ Switched frame");

			ReusableComponents.clickElement(ledger_NewDeposite, pass_login);

			ReusableComponents.selectValueFromComboBox(ledger_NewDeposite,
					reusableComponents.getPropValues("LedgerValue"));
			ReusableComponents.selectValueFromComboBox(bankAccount_NewDeposite,
					reusableComponents.getPropValues("BankAccount"));
			ReusableComponents.sendKey(closeDate_NewOpportunity, reusableComponents.getPropValues("DepositDate"),
					"Deposite date");
			ReusableComponents.selectValueFromComboBox(currency_NewDeposite,
					reusableComponents.getPropValues("Currency"));

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Provided all manditory values to create new deposite", browser,
					pathLoc + "/" + testcasemethod, true);

			ReusableComponents.clickElement(saveButton_NewDeposite, "Click on save button");
			wait(5000);

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Newly created deposite value : " + newlyCreatedDepositeName_NewDeposite.getText(),
					browser, pathLoc + "/" + testcasemethod, true);

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "/" + testcasemethod, true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, true);
		}
		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Method Name : [P&L] [P&L] Verify amounts shown for the Expense GL
	 * accounts match with those on the SF version of this report : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage input_test_2718CalculationPart_excel(int threadID, List<String> tempList,
			String pathLoc) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			String startdate = null, enddate = null, equalsvalueof = null, acc_period = null;
			Boolean isselected = false;

			// the excel input value should be supplied to start date and end date

			try {

				String filename = reusableComponents.getPropValues("Financialreportsinput");
				String sheetname = reusableComponents.getPropValues("TC14");

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
				System.out.println("Row count is " + rowCount + " Column count is " + columnCount);

				// read rows and columns

				Iterator<Row> itr = workbooksheet.iterator();

				while (itr.hasNext()) {
					Row row = itr.next();
					if (row.getRowNum() == 0) {
						continue; // just skip the rows if row number is 0 or 1
					}

					if (row.getRowNum() == 1) {
						continue;
					}

					if (row.getRowNum() == 2) {

						Iterator<Cell> celliterator = row.cellIterator();

						while (celliterator.hasNext()) {

							Cell cell = celliterator.next();
							final DataFormatter formatter = new DataFormatter();

							startdate_arr.add(formatter.formatCellValue(cell)); // throw new

						}

					}

				}

			} catch (NoSuchElementException e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			}

			try {
				for (int i = 0; i < startdate_arr.size(); i++) {

					System.out.println(startdate_arr.get(i));
				}

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Reading Excel input sheet, successful", browser, pathLoc + "/" + testcasemethod, false);
				startdate = startdate_arr.get(2);
				enddate = startdate_arr.get(3);
				equalsvalueof = startdate_arr.get(4);
				acc_period = startdate_arr.get(9);

				if (equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
					supressrows = Boolean.valueOf(equalsvalueof);
					ignore_supressrows = "false";
				} else if (equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ")
						|| equalsvalueof.equalsIgnoreCase("")) {
					ignore_supressrows = "true";
				}

				else {

					ignore_supressrows = "true";
				}

				ReusableComponents.wait(5200);

				System.out.println("start date " + startdate + " and end date " + enddate
						+ " equals true or false value is " + equalsvalueof);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"printing excel elements are incomplete", browser, pathLoc + "/" + testcasemethod, true);
			}

			startdate_G = startdate;
			enddate_G = enddate;

			try {
				test_2718CalculationPart(threadID, tempList, pathLoc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Test case Name : [P&LvB] Verify that the Total Revenue subtotal is
	 * calculated by adding all the Revenue GL Accounts' Actual, Budget and
	 * Difference amounts. created. Author : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage test_2718CalculationPart(int threadID, List<String> tempList, String pathLoc)
			throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			LoginToWebpage();

			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Ledgers", selectLedgerFromApp);
			if (ReusableComponents.isElementPresent(ledger_PageTitle) == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Ledger page opened", browser, pathLoc + "/" + testcasemethod, true);

			} else {
				throw new throwNewException("Ledger page is not opened", "");
			}

			ReusableComponents.clickElement(newLink_LedgerPage, "New Link From Ledger Page");
			wait(5000);
			String ledgerName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_Budget";
			ReusableComponents.sendKey(ledgerName_LedgerPage, ledgerName, "New Ledger Name");
			wait(2000);
			// ReusableComponents.actionMoveToElementAndClick(browser,
			// clickType_NewLedger,"Ledger type drop down");
			// ReusableComponents.clickElement(clickType_NewLedger, "Ledger type drop
			// down");
			ReusableComponents.clickUsingJavaScript(browser, clickType_NewLedger, "Click ledger type dropdown");
			ReusableComponents.clickElement(selectTypeBudget_NewLedger, "Select Type as budget");
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Ledger mandatory values are selected ", browser, pathLoc + "/" + testcasemethod,
					true);
			ReusableComponents.clickElement(saveButton_LedgerPage, "Save Button Of Ledger page");
			wait(5000);

			// Open Financial Reports page
			browser.get("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
			// Browser.get is used here since there are issue in launching financial report
			// from search app. Once the issue resolved we can comment it and unccomment
			// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
			// Reports",

			wait(5000);

			if (ReusableComponents.isElementPresent(financialReport_PageTitle) == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Financial Reports page opened", browser, pathLoc + "/" + testcasemethod,
						true);

			} else {
				throw new throwNewException("Financial Report page is not opened", "");
			}

			ReusableComponents.clickElement(selectStandartReport_FinancialReport, "Click Select standard reportd");
			wait(5000);
			ReusableComponents.clickElement(PLvsBudget_selectStandartReport_FinancialReport,
					"Click Select P & L versus budget");
			wait(5000);
			ReusableComponents.clickElement(clearStartingDate_FinancialReport, "Clear Starting Accounting period");
			ReusableComponents.sendKey(startingAccountingPeriod_FinancialReport, startdate_G,
					"Starting Accounting Period value");
			wait(5000);
			ReusableComponents.clickElement(accountingPeriodSelect_FinancialReport,
					"Select Starting accounting period");
			ReusableComponents.clickElement(clearEndingDate_FinancialReport, "Clear Ending Accounting period");

			ReusableComponents.sendKey(endingAccountingPeriod_FinancialReport, enddate_G,
					"Starting Accounting Period value");
			wait(5000);
			ReusableComponents.clickElement(accountingPeriodSelect_FinancialReport,
					"Select Starting accounting period");
			ReusableComponents.clickElement(clearBudgetLedgerValue_FinancialReport, "Clear Budget Ledger Value");
			ReusableComponents.sendKey(budgetLedgerValue_FinancialReport, ledgerName,
					"Newly Created Budget Ledger Value");
			wait(5000);
			String selectBudgetLedger = ".//*[@class='slds-box box-shadow']//span[contains(text(),'" + ledgerName
					+ "')]";
			System.out.println("****************************** Print xpath " + selectBudgetLedger);
			ReusableComponents.clickElement_byDynamicXpath(browser, selectBudgetLedger, "Select newly careted Ludger ");

			/*
			 * if (suppressZeroAmountRowCheckBox_FinancialReport.isSelected() == false) {
			 * System.out.
			 * println("********** Suppress Zero Amount Checkbox is not selected ");
			 * ReusableComponents.clickElement(suppressZeroAmountCheckbox_FinancialReport,
			 * "Select suppress zero amount check box"); }
			 */

			String oldRecordName = firstReport_PandLVsBudgetFinancialReport.getText();

			System.out.println("old record **^*&^*^*&^* " + oldRecordName);

			ReusableComponents.clickElement(runButton_FinancialReport, "Run Financial Report");
			wait(5000);

			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(9200);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Clicked On Run button", browser, pathLoc + "/" + testcasemethod, true);

			wait(20000);

			String newRecord = firstReport_PandLVsBudgetFinancialReport.getText();
			System.out.println("new record **^*&^*^*&^* " + newRecord);

			if (!oldRecordName.equalsIgnoreCase(newRecord)) {
				String hreflink = reusableComponents.getAttribute(firstReport_PandLVsBudgetFinancialReport, "href");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Link of created Profit & Loss Versus Budget financial report : " + hreflink, browser, hreflink,
						false);
			} else {

				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"There are no new records created, provide valid inputs ", browser,
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
		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Method Name : [P&L] [P&L] Verify amounts shown for the Expense GL
	 * accounts match with those on the SF version of this report : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage input_test_2721ShowAllPeriod_excel(int threadID, List<String> tempList,
			String pathLoc) throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			String startdate = null, enddate = null, equalsvalueof = null, acc_period = null;
			Boolean isselected = false;

			// the excel input value should be supplied to start date and end date

			try {

				String filename = reusableComponents.getPropValues("Financialreportsinput");
				String sheetname = reusableComponents.getPropValues("TC14");

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
				System.out.println("Row count is " + rowCount + " Column count is " + columnCount);

				// read rows and columns

				Iterator<Row> itr = workbooksheet.iterator();

				while (itr.hasNext()) {
					Row row = itr.next();
					if (row.getRowNum() == 0) {
						continue; // just skip the rows if row number is 0 or 1
					}

					if (row.getRowNum() == 1) {
						continue;
					}

					if (row.getRowNum() == 2) {

						Iterator<Cell> celliterator = row.cellIterator();

						while (celliterator.hasNext()) {

							Cell cell = celliterator.next();
							final DataFormatter formatter = new DataFormatter();

							startdate_arr.add(formatter.formatCellValue(cell)); // throw new

						}

					}

				}

			} catch (NoSuchElementException e) {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			}

			try {
				for (int i = 0; i < startdate_arr.size(); i++) {

					System.out.println(startdate_arr.get(i));
				}

				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Reading Excel input sheet, successful", browser, pathLoc + "/" + testcasemethod, false);
				startdate = startdate_arr.get(2);
				enddate = startdate_arr.get(3);
				equalsvalueof = startdate_arr.get(4);
				acc_period = startdate_arr.get(9);

				if (equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
					supressrows = Boolean.valueOf(equalsvalueof);
					ignore_supressrows = "false";
				} else if (equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ")
						|| equalsvalueof.equalsIgnoreCase("")) {
					ignore_supressrows = "true";
				}

				else {

					ignore_supressrows = "true";
				}

				ReusableComponents.wait(5200);

				System.out.println("start date " + startdate + " and end date " + enddate
						+ " equals true or false value is " + equalsvalueof);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"printing excel elements are incomplete", browser, pathLoc + "/" + testcasemethod, true);
			}

			startdate_G = startdate;
			enddate_G = enddate;

			try {
				test_2721ShowAllPeriod(threadID, tempList, pathLoc);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Test case Name : [P&LvB] P&LvsBudget: Verify Show All Periods
	 * functionality Author : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage test_2721ShowAllPeriod(int threadID, List<String> tempList, String pathLoc)
			throws Exception {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			ReusableComponents.wait(2300);
			String username = null, pass_login = null;
			username = reusableComponents.getPropValues("username");
			pass_login = reusableComponents.getPropValues("password");

			LoginToWebpage();

			// Create new opportunities
			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Opportunities", opportunitiesFromApp);
			ReusableComponents.clickElement(newLink_LedgerPage, "Select new button from opportunities page ");
			wait(5000);

			/*
			 * List<WebElement> elementName = browser.findElements(By.tagName("iframe"));
			 * System.out.println("************ Number of elements " + elementName.size());
			 * // ReusableComponents.switchToFrame(browser,0);
			 * System.out.println("************ Switched frame");
			 */

			String opportunityName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_Opportunity";
			ReusableComponents.sendKey(name_NewOpportunity, opportunityName, "Opportunity Name");
			ReusableComponents.sendKey(closeDate_NewOpportunity, reusableComponents.getPropValues("opportunityDate"),
					"Opportunity Date");

			ReusableComponents.scrollDown_insidepopup_ByPGDN(browser, popupof_NewOpportunity);

			ReusableComponents.clickElement(stage_NewOpportunity, "Click on stage input box");
			wait(3000);
			String input_Of_Stage_Option = reusableComponents.getPropValues("stage_Option");
			String dynamic_xpath = ".//span[@title='" + input_Of_Stage_Option + "']";
			System.out.println("********** xpath " + dynamic_xpath);

			List<WebElement> perspective = browser.findElements(By.xpath(dynamic_xpath));

			if (perspective.size() == 0) {
				ReusableComponents.clickElement(stage_NewOpportunity, "Click on stage input box");
				wait(3000);
			}

			ReusableComponents.clickElement_byDynamicXpath(browser, dynamic_xpath,
					"Select " + input_Of_Stage_Option + " option for stage");

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Provided all manditory values to create new opportunity", browser,
					pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(saveButton_LedgerPage, "Click on save button");
			wait(5000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Navigated to new opportunity page", browser, pathLoc + "/" + testcasemethod,
					true);
			String checkCreatedOpportunity = ".//lightning-formatted-text[contains(text(),'" + opportunityName + "')]";

			System.out.println("Print xpath " + checkCreatedOpportunity);
			boolean opportunityCreated = browser.findElement(By.xpath(checkCreatedOpportunity)).isDisplayed();
			System.out.println("********************** Element visibility" + checkCreatedOpportunity);
			if (opportunityCreated == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Newly created opportunity " + opportunityName + " is displayed", browser,
						pathLoc + "/" + testcasemethod, true);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"Opportunity " + opportunityName + " is created", browser, pathLoc + "/" + testcasemethod,
						true);
			}

			// Open Financial Reports page
			browser.get("https://jasper-uat-mc-dev-ed.lightning.force.com/lightning/n/AcctSeed__Financial_Reports");
			// Browser.get is used here since there are issue in launching financial report
			// from search app. Once the issue resolved we can comment it and unccomment
			// selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "Financial
			// Reports",

			wait(5000);

			if (ReusableComponents.isElementPresent(financialReport_PageTitle) == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Financial Reports page opened", browser, pathLoc + "/" + testcasemethod,
						true);

			} else {
				throw new throwNewException("Financial Report page is not opened", "");
			}

			ReusableComponents.clickElement(selectStandartReport_FinancialReport, "Click Select standard reportd");
			wait(5000);
			ReusableComponents.clickElement(PLvsBudget_selectStandartReport_FinancialReport,
					"Click Select P & L versus budget");
			wait(5000);
			ReusableComponents.clickElement(clearStartingDate_FinancialReport, "Clear Starting Accounting period");
			ReusableComponents.sendKey(startingAccountingPeriod_FinancialReport, startdate_G,
					"Starting Accounting Period value");
			wait(5000);
			ReusableComponents.clickElement(accountingPeriodSelect_FinancialReport,
					"Select Starting accounting period");
			ReusableComponents.clickElement(clearEndingDate_FinancialReport, "Clear Ending Accounting period");

			ReusableComponents.sendKey(endingAccountingPeriod_FinancialReport, enddate_G,
					"Starting Accounting Period value");
			wait(5000);
			ReusableComponents.clickElement(accountingPeriodSelect_FinancialReport,
					"Select Starting accounting period");

			ReusableComponents.clickElement(showAllPeriodCheckBox_FinancialReports, "Show all period checkbox");

			/*
			 * if (suppressZeroAmountRowCheckBox_FinancialReport.isSelected() == false) {
			 * System.out.
			 * println("********** Suppress Zero Amount Checkbox is not selected ");
			 * ReusableComponents.clickElement(suppressZeroAmountCheckbox_FinancialReport,
			 * "Select suppress zero amount check box"); }
			 */

			String oldRecordName = firstReport_PandLVsBudgetFinancialReport.getText();

			ReusableComponents.clickElement(runButton_FinancialReport, "Run Financial Report");
			wait(5000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Clicked On Run button", browser, pathLoc + "/" + testcasemethod, true);

			wait(10000);

			String newRecord = firstReport_PandLVsBudgetFinancialReport.getText();

			if (!oldRecordName.equalsIgnoreCase(newRecord)) {
				String hreflink = reusableComponents.getAttribute(firstReport_PandLVsBudgetFinancialReport, "href");
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"Link of created Profit & Loss Versus Budget financial report : " + hreflink, browser, hreflink,
						false);
			} else {

				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"There are no new records created, provide valid inputs and try again", browser,
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
		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Test case Name : create new journal functionality Author : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage test_Journal_Entries(int threadID, List<String> tempList, String pathLoc)
			throws Exception {
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
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Journal Entries page opened", browser, pathLoc + "/" + testcasemethod, true);
			} else {
				throw new throwNewException("Journal Entry page is not opened", "");
			}

			ReusableComponents.clickElement(newLink_LedgerPage, "Click on new Journal Entries");
			wait(5000);

			if (ReusableComponents.isElementPresent(newJournalEntry_Popup) == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "New Journal Entries popup opened", browser, pathLoc + "/" + testcasemethod,
						true);
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
			String monthInString;
			if (arrOfStr[1] == "10" || arrOfStr[1] == "11" || arrOfStr[1] == "12") {
				monthInString = arrOfStr[1];
			} else {
				monthInString = arrOfStr[1].substring(1);
			}

			String accountingPeriodInMDYFormat = monthInString + "/1/" + arrOfStr[0];
			String xpath_acccountingPeriod_Select_newJournal = ".//lightning-base-combobox-formatted-text[@title='"
					+ accountingPeriodInMDYFormat + "']";
			wait(5000);
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
					testcasemethod + "Provided all manditory values to create new journal", browser,
					pathLoc + "/" + testcasemethod, true);
			ReusableComponents.clickElement(saveButton_newJournalEntryPopup, "Click on save button");
			wait(5000);

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					testcasemethod + "Navigated to new Journal page", browser, pathLoc + "/" + testcasemethod, true);
			String checkCreatedOpportunity = ".//lightning-formatted-text[contains(text(),'" + newJournalName + "')]";

			System.out.println("Print xpath " + checkCreatedOpportunity);
			boolean opportunityCreated = browser.findElement(By.xpath(checkCreatedOpportunity)).isDisplayed();
			// System.out.println("********************** Element visibility" +
			// checkCreatedOpportunity);
			if (opportunityCreated == true) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						testcasemethod + "Newly created Journal " + newJournalName + " is displayed", browser,
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
		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Test case Name : [CF] Verify that a Journal Entry line has the
	 * default Cash Flow Category of 'Payments to suppliers' functionality Author :
	 * Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage test2728_CheckCashFlowCategory(int threadID, List<String> tempList,
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

			ReusableComponents.clickElement(newJournalEntryLine, "Click on new Journal Entry");

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLoc + "/" + testcasemethod, true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, true);
		}
		return new SearchAppItemPage(browser);
	}

	/***
	 * From Accounting Home, click on Accounts (under Master Data Setup) and
	 * create/edit one so it has: Accounting Type = Customer & Vendor and Accounting
	 * Active checked Author : Menaka
	 * 
	 * @throws Exception
	 ***/
	public synchronized SearchAppItemPage editMasterDataSetupAccountData(int threadID, List<String> tempList,
			String pathLoc) throws Exception, throwNewException {
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

		return new SearchAppItemPage(browser);
	}

	/*
	 * From Accounting Home, click on Accounts (under Master Data Setup) and
	 * create/edit one so it has: Accounting Type = Customer & Vendor and Accounting
	 * Active checked Author : Lakshman
	 */
	public static void checkDefaultValueOfCustomerVendorandAccounting(int threadID, List<String> tempList,
			String testcasemethod) throws Exception {

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

}
