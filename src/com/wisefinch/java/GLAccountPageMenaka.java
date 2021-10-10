package com.wisefinch.java;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Base class for all the pages.
 *
 */
public class GLAccountPageMenaka extends DriverScript {

	protected static WebDriver browser;
	static String dateGatheredToGiveNam;
	String valueToSet, cdbName, CDB_Name = null, accountingPeriod, cashDisbursementName;
	static String newGLName, newGLAccountName;

	static ReusableComponents reusableComponents = new ReusableComponents();

	protected GLAccountPageMenaka(WebDriver browser) {
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

	// Modified Sections After 20/9/2021

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

	@FindBy(xpath = "(.//*[@class='slds-truncate']//*[contains(text(),'GL Accounts')])[2]")
	static WebElement glAccount_SearchAppAndSelect;

	@FindBy(xpath = ".//*[@class='actionBody']//*[@class='slds-modal__header']/*[contains(text(),'New GL Account')]")
	static WebElement newGLAccountPopup;

	@FindBy(xpath = "//h2[contains(text(),'New GL Account')]")
	static WebElement newGLAccountPopup_OpenedFromCashDisbursement;

	@FindBy(xpath = ".//input[@name='Name']")
	static WebElement name_newGLAccountPopup;

	@FindBy(xpath = "(.//*[@class='actionBody']//input[@role='combobox'])[1]")
	static WebElement type_newGLAccountPopup;

	@FindBy(xpath = "//*[@title='Cash Flow']")
	static WebElement selectCashFlowtype_newGLAccountPopup;

	@FindBy(xpath = "(.//*[@class='actionBody']//input[@role='combobox'])[2]")
	static WebElement subType_newGLAccountPopup;

	@FindBy(xpath = "//*[@title='Operating']")
	static WebElement selectOperatingStype_newGLAccountPopup;

	@FindBy(xpath = ".//*[@name='SaveEdit']")
	static WebElement saveButton_newGLAccountPopup;

	@FindBy(xpath = ".//*[@class='slds-truncate']//*[contains(text(),'Cash Disbursements')]")
	static WebElement cashDisbursements_SearchAppAndSelect;

	@FindBy(xpath = "//div[@title='New']")
	WebElement newButton_cashDisbursements;

	@FindBy(xpath = ".//*[@class='slds-grid']//*[@aria-label='Breadcrumbs']//*[contains(text(),'Cash Disbursements')]")
	WebElement cashDisbursements_PageCheck;

	@FindBy(xpath = ".//*[@class='actionBody']//*[@class='slds-modal__header']/*[contains(text(),'New Cash Disbursement')]")
	WebElement newCashDisbursements_Popup;

	@FindBy(xpath = "((.//*[@class='actionBody']//force-record-layout-section)[3]//input[@role='combobox'])[5]")
	WebElement cashFlowCategory_NewCashDisbursements;

	@FindBy(xpath = ".//*[@class='actionBody']")
	WebElement popup_NewCashDisbursements;

	@FindBy(xpath = "//*[@title='New GL Account']")
	WebElement newGLAccount_ByClickingCashFlowInputBox_NewCashDisbursements;

	@FindBy(xpath = "((.//*[@class='modal-container slds-modal__container'])[2]//input)[1]")
	WebElement gLAccountName_NewGLAccountPopupFrom_CashFlowOption;

	@FindBy(xpath = "((.//*[@class='modal-container slds-modal__container'])[2]//a[@class='select'])[1]")
	WebElement gLAccounType_NewGLAccountPopupFrom_CashFlowOption;

	@FindBy(xpath = "//a[normalize-space()='Cash Flow']")
	WebElement gLAccounType_SelectCashFlow_NewGLAccountPopupFrom_CashFlowOption;

	@FindBy(xpath = "((.//*[@class='modal-container slds-modal__container'])[2]//a[@class='select'])[2]")
	WebElement gLAccounSubType_NewGLAccountPopupFrom_CashFlowOption;

	@FindBy(xpath = "//a[normalize-space()='Operating']")
	WebElement gLAccounSubType_SelectOperating_NewGLAccountPopupFrom_CashFlowOption;

	@FindBy(xpath = "(.//*[@class='modal-container slds-modal__container'])[2]//button[@title='Save']")
	WebElement saveButton_NewGLAccountPopupFrom_CashFlowOption;

	@FindBy(xpath = ".//button[@name = 'CancelEdit']")
	WebElement cancelButtonNewCashDisbursement;

	@FindBy(xpath = ".//*[@class='slds-grid']//*[@aria-label='Breadcrumbs']//*[contains(text(),'GL Accounts')]")
	WebElement glAccountsPageCheck;

	@FindBy(xpath = ".//*[@class='slds-button-group-list']//button[@name='Delete']")
	WebElement deleteButton_NewGLAccount;

	@FindBy(xpath = ".//*[@class=' label bBody' and contains(text(),'Delete')]")
	WebElement deleteButton_DeleteConfirmationPopup;

	@FindBy(xpath = ".//*[@class='modal-container slds-modal__container']//*[contains(text(),'Delete GL Account')]")
	WebElement deleteGLAccount_Popup;

	@FindBy(xpath = ".//*[@class='modal-container slds-modal__container']//button//*[contains(text(),'Delete')]")
	WebElement deleteButton;

	@FindBy(xpath = ".//*[@class='slds-grid ']//input[@type='search']")
	WebElement searchTheGLList;

	// Modified Sections After 20/9/2021
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

	// Modified Sections After 20/9/2021
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
	public static GLAccountPageMenaka selectAppFromSearchAppAndItem(int threadID, List<String> tempList, String pathLocation,

			String appNameToSearch, WebElement selectAppXpath) throws Exception {

		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {
			ReusableComponents.clickElement(SearchAppAndItemIcon, "Search App and Item Icon");
			ReusableComponents.wait(5000);
			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					"Search app and item icon pressed", browser, pathLocation + "/" + testcasemethod, false);
			ReusableComponents.sendKey(SearchAppAndItemInputbox, appNameToSearch, "Search app and Item inputbox");

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Searching for " + appNameToSearch,
					browser, pathLocation + "/" + testcasemethod, true);
			ReusableComponents.clickElement(selectAppXpath, "Select value from App and Item dropdown");
			ReusableComponents.wait(5000);
		} catch (Exception e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Unable to select app from select search app section" + e.getStackTrace(), browser,
					pathLocation + "/" + testcasemethod, true);
		}
		return new GLAccountPageMenaka(browser);

	}

	// Modified Sections After 20/9/2021
	/**
	 * Test case [CF] Verify that a CF category can be deleted if there are no
	 * records associated to it.
	 * 
	 * @author Menaka M
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 * @throws throwNewException
	 */
	public synchronized GLAccountPageMenaka test2743_CreateGLAccountFromCashFlowAndDelete(int threadID,
			List<String> tempList, String pathLocation) throws Exception, throwNewException {
		System.out.println("********** test_Journal_Entries");
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		
		String path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "/" + TESTCASENAME;
		pathLocation = reusableComponents.pathBuilder(path);
		
		try {
			LoginToWebpage();

			// --> Open Cash disbursement
			selectAppFromSearchAppAndItem(threadID, tempList, pathLocation, "Cash Disbursements",
					cashDisbursements_SearchAppAndSelect);
			ReusableComponents.wait(5000);

			if (ReusableComponents.isDisplayed(cashDisbursements_PageCheck, "Cash disbursements page check") == true) {
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash disbursements page opened",
						browser, pathLocation + "/" + testcasemethod, false);
			} else {
				throw new throwNewException("Cash disbursement page", "Cash disbursement page is not displayed");
			}

			// --> Click on new button under cash disbursement
			ReusableComponents.clickElement(newButton_cashDisbursements, "New button from cash disbursement page");
			ReusableComponents.wait(5000);

			if (ReusableComponents.isDisplayed(newCashDisbursements_Popup, "new Cash disbursements popup") == true) {
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New Cash disbursements popup opened",
						browser, pathLocation + "/" + testcasemethod, false);
			} else {
				throw new throwNewException("new Cash disbursement pop up",
						"new Cash disbursement popup is not displayed");
			}

			// --> Scroll down to the cash flow category option present under the new cash
			// disbursement popup
			ReusableComponents.scrollInToElementJavaScript(browser, cashFlowCategory_NewCashDisbursements);
			ReusableComponents.wait(2000);
			ReusableComponents.clickElement(cashFlowCategory_NewCashDisbursements,
					"Cash Flow Category Input Box under_New Cash Disbursements popup");
			ReusableComponents.wait(5000);

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,
					"Create new GL account from cash flow catefory popup", browser, pathLocation + "/" + testcasemethod,
					true);

			// --> Click on + New GL account option
			ReusableComponents.clickElement(newGLAccount_ByClickingCashFlowInputBox_NewCashDisbursements,
					"New GL Account under cash flow input box");
			ReusableComponents.wait(5000);

			if (ReusableComponents.isDisplayed(newGLAccountPopup_OpenedFromCashDisbursement,
					"New GL account popup") == true) {
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New GL Account popup opened",
						browser, pathLocation + "/" + testcasemethod, false);
			} else {
				throw new throwNewException("New GL Account pop up", "New GL account popup is not displayed");
			}

			newGLAccountName = ReusableComponents.getCurrentDateAndTime("yyyyMMdd_HHmmss") + "_GLAccount";
			ReusableComponents.sendKey(gLAccountName_NewGLAccountPopupFrom_CashFlowOption, newGLAccountName,
					"Provide GL account name");

			ReusableComponents.clickElement(gLAccounType_NewGLAccountPopupFrom_CashFlowOption, "Type drop down");
			ReusableComponents.wait(1000);
			ReusableComponents.clickElement(gLAccounType_SelectCashFlow_NewGLAccountPopupFrom_CashFlowOption,
					"Select Cash Flow ");

			ReusableComponents.clickElement(gLAccounSubType_NewGLAccountPopupFrom_CashFlowOption, "Sub Type drop down");
			ReusableComponents.wait(1000);
			ReusableComponents.clickElement(gLAccounSubType_SelectOperating_NewGLAccountPopupFrom_CashFlowOption,
					"Select Operating");

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					"Type Selected as Cash flow and Sub type selected as Operating", browser,
					pathLocation + "/" + testcasemethod, false);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Screenshot", browser,
					pathLocation + "/" + testcasemethod, true);

			ReusableComponents.clickElement(saveButton_NewGLAccountPopupFrom_CashFlowOption, "Save button");
			ReusableComponents.wait(5000);

			// --> To make sure created GL account added to the cash flow category input box
			String selectedCashFlowValue = ReusableComponents.elementGetAttribute(cashFlowCategory_NewCashDisbursements,
					"placeholder");

			if (selectedCashFlowValue.equalsIgnoreCase(newGLAccountName)) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"New GL account created and added for Cash flow option", browser,
						pathLocation + "/" + testcasemethod, false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
						pathLocation + "/" + testcasemethod, true);
			} else {
				throw new throwNewException("New GL Account creation", "New GL account is not created");
			}

			ReusableComponents.clickElement(cancelButtonNewCashDisbursement, "Cancel button of new Cash Disbursement");

			ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
					"Cancelled new cash disbursement popup to make sure that " + newGLAccountName
							+ " is not getting linked under Cash Disbursement",
					browser, pathLocation + "/" + testcasemethod, false);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
					pathLocation + "/" + testcasemethod, true);

			// --> Open GL accounts
			selectAppFromSearchAppAndItem(threadID, tempList, testcasemethod, "GL Accounts",
					glAccount_SearchAppAndSelect);

			if (ReusableComponents.isDisplayed(glAccountsPageCheck, "GL Accounts Page") == true) {
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "GL Accounts page opened", browser,
						pathLocation + "/" + testcasemethod, false);
			} else {
				throw new throwNewException("GL Account page", "GL account page is not displayed");
			}

			ReusableComponents.sendKey(searchTheGLList, newGLAccountName, "Provide GL account Name in search box");
			ReusableComponents.sendkey_InputKey(searchTheGLList, Keys.ENTER, "Search GL account Name");
			ReusableComponents.wait(5000);

			String glAccountXpath = ".//a[@title='" + newGLAccountName + "']";

			List<WebElement> glAccountName = browser.findElements(By.xpath(glAccountXpath));

			if (glAccountName.size() != 0) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"New GL Accounts " + newGLAccountName + " is displayed", browser,
						pathLocation + "/" + testcasemethod, false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
						pathLocation + "/" + testcasemethod, true);
			} else {
				throw new throwNewException("New GL Account", "New GL account is not displayed");
			}

			glAccountName.get(0).click();

			ReusableComponents.clickElement(deleteButton_NewGLAccount, "Click on delete button");
			ReusableComponents.wait(2000);

			if (ReusableComponents.isDisplayed(deleteButton_DeleteConfirmationPopup,
					"Delete confirmation popup") == true) {

				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "Delete new GL account", browser,
						pathLocation + "/" + testcasemethod, true);
			} else {
				throw new throwNewException("Delete confirmation popup", "Delete confirmation popup is not displayed");
			}

			ReusableComponents.clickElement(deleteButton_DeleteConfirmationPopup,
					"Click on delete button in confirmation popup");
			ReusableComponents.wait(5000);

			ReusableComponents.sendKey(searchTheGLList, newGLAccountName, "Provide GL account Name in search box");
			ReusableComponents.sendkey_InputKey(searchTheGLList, Keys.ENTER, "Search GL account Name");
			ReusableComponents.wait(5000);

			glAccountName.clear();
			glAccountName = browser.findElements(By.xpath(glAccountXpath));

			if (glAccountName.size() == 0) {
				ReusableComponents.reportPassFunction(threadID, tempList, testcasemethod,
						"New GL Accounts " + newGLAccountName + " is deleted and not displayed under GL Accounts page",
						browser, pathLocation + "/" + testcasemethod, false);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "", browser,
						pathLocation + "/" + testcasemethod, true);
			} else {
				throw new throwNewException("New GL Account", "New GL account is displayed and not deleted");
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "/" + testcasemethod, true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLocation + "/" + testcasemethod, true);
		}
		return new GLAccountPageMenaka(browser);
	}

//Modified Sections After 20/9/2021
	/**
	 * @author Wisefinch : Menaka
	 * @param threadID
	 * @param tempList
	 * @param pathLocation
	 * @return
	 * @throws Exception
	 * @throws throwNewException
	 */
	public synchronized GLAccountPageMenaka fillValuesUnderNewGLAccountpopup(int threadID, List<String> tempList,
			String pathLocation) throws Exception, throwNewException {
		System.out.println("********** test_Journal_Entries");
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		try {

			if (ReusableComponents.isDisplayed(newGLAccountPopup, "New GL account popup") == true) {
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New GL account popup displayed",
						browser, pathLocation + "/" + testcasemethod, false);
			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						"New GL account popup is not displayed", browser, pathLocation + "/" + testcasemethod, true);
			}

		} catch (throwNewException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, e.getErrorMessage(), browser,
					pathLocation + "/" + testcasemethod, true);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLocation + "/" + testcasemethod, true);
		}
		return new GLAccountPageMenaka(browser);
	}

}
