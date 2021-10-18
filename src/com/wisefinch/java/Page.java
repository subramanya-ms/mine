package com.wisefinch.java;

import static org.testng.AssertJUnit.assertTrue;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
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
public class Page extends DriverScript {
	protected WebDriver browser;

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected Page(WebDriver browser) {

		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public static String testcasemethod;

	/***
	 * Test case Method Name : navigateToAseedPage Functionality : validate
	 * Accounting seed Page Created By : Subramanya MS
	 * 
	 ***/
	public synchronized AseedPage navigateToAseedPage(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation Accounting Seed Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new AseedPage(browser);
	}

	/***
	 * Test case Method Name : navigateTocustomPage Functionality : validate Custom
	 * Test Page Created By : Subramanya MS
	 * 
	 ***/
	public synchronized Custprojpage navigateToCustpage(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation Custom Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new Custprojpage(browser);
	}

	/***
	 * Test case Method Name : navigateToPLPage Functionality : validate PL Page
	 * Created By : Subramanya MS
	 * 
	 ***/
	public synchronized PlPage navigateToPlPage(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		testcasemethod = "Calling P and L reports WebElements";
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
				"Validation of Financial reports - P and L reports", browser, pathLoc + "/" + testcasemethod, false);
		return new PlPage(browser);
	}

	/***
	 * Test case Method Name : navigateToTest2677Page Functionality : validate PL
	 * Page Created By : Subramanya MS
	 * 
	 ***/
	public synchronized Test2677Page navigateToTest2677Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		testcasemethod = "Calling P and L reports WebElements";
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod,
				"Validation of Financial reports - P and L reports", browser, pathLoc + "/" + testcasemethod, false);
		return new Test2677Page(browser);
	}

	/***
	 * Test case Method Name : navigateToSeconddayPage Functionality : validate
	 * PrerequisitesPage Page logo Created By : Subramanya -
	 * 
	 ***/
	public synchronized PrerequisitesPage navigateToPrerequisitesPage(int threadID, List<String> tempList,
			String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation Secondday Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new PrerequisitesPage(browser);
	}

	/***
	 * Test case Method Name : navigateToPLAllPage Functionality : validate
	 * PrerequisitesPage Page logo Created By : Subramanya -
	 * 
	 ***/
	public synchronized PLAllPage navigateToPLAllPage(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation PLALL Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new PLAllPage(browser);
	}

	/***
	 * Test case Method Name : navigateToPayablePage Functionality : validate
	 * Payable Page logo Created By : Subramanya MS - L
	 * 
	 ***/
	public synchronized PayablePage navigateToPayablePage(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation Payable Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new PayablePage(browser);
	}

	/***
	 * Test case Method Name : navigateToDynPrerequisitesPage Functionality :
	 * validate Payable Page logo Created By : Subramanya MS - L
	 * 
	 ***/
	public synchronized DynPrerequisitesPage navigateToDynPrerequisitesPage(int threadID, List<String> tempList,
			String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation DynPrerequisites Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new DynPrerequisitesPage(browser);
	}

	/***
	 * Test case Method Name : navigateToCashreceiptPage Functionality : validate
	 * Cashreceipt Page Created By : Lakshman
	 *
	 ***/
	public synchronized CashreceiptPage navigateToCashreceiptPage(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation Cashreceipt Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new CashreceiptPage(browser);
	}

	/***
	 * Test case Method Name : navigateToGLAccountPage Functionality : validate
	 * GLAccountPage Page Created By : Lakshman
	 *
	 ***/
	public synchronized GLAccountPage navigateToGLAccountPage(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation GLAccount Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new GLAccountPage(browser);
	}

	/***
	 * Test case Method Name : navigateToCDBatchPage Functionality : Validate
	 * CDBatch Page Created By : Lakshman
	 *
	 ***/
	public synchronized CDBatchPage navigateToCDBatchPage(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation CDBatch Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new CDBatchPage(browser);
	}

	/***
	 * Test case Method Name : navigateToAccountPage Functionality : Validate
	 * Account Page Created By : Lakshman
	 *
	 ***/
	public synchronized AccountPage navigateToAccountPage(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation Account Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new AccountPage(browser);
	}

	/***
	 * Test case Method Name : navigateToBillingPage Functionality : Validate
	 * Billing Page Created By : Lakshman
	 *
	 ***/
	public synchronized BillingPage navigateToBillingPage(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation Billing Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new BillingPage(browser);
	}

	/***
	 * Created By : Menaka
	 *
	 ***/
	public synchronized SearchAppItemPage testSearchAppItemPage(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation searchapp item Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new SearchAppItemPage(browser);
	}

	/***
	 * Test case Method Name : navigateToT2726PagePage Functionality : Validate
	 * T2726 Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2725Page navigateToT2725Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation searchapp item Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2725Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2726PagePage Functionality : Validate
	 * T2726 Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2726Page navigateToT2726Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation searchapp item Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2726Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2722PagePage Functionality : Validate
	 * T2722 Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2722Page navigateToT2722Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation searchapp item Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2722Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2723PagePage Functionality : Validate
	 * T2723 Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2723Page navigateToT2723Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation searchapp item Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2723Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2724PagePage Functionality : Validate
	 * T2724 Page Created By : Lakshman
	 * 
	 ***/
	public synchronized T2724Page navigateToT2724Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation searchapp item Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2724Page(browser);
	}

	/***
	 * Created By : Menaka
	 *
	 ***/
	public synchronized JournalEntryPage journalEntryPageTest(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation searchapp item Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new JournalEntryPage(browser);
	}

	/***
	 * Test case Method Name : navigateToPreBLPage Functionality : Validate PreBL
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized PreBLPage navigateToPreBLPage(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation PreBL Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new PreBLPage(browser);
	}

	/***
	 * Test case Method Name : navigateToT2697Page Functionality : Validate T2697
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2697Page navigateToT2697Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2697 Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2697Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2698Page Functionality : Validate T2698
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2698Page navigateToT2698Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2698 Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2698Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2699Page Functionality : Validate T2699
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2699Page navigateToT2699Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2699 Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2699Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2700Page Functionality : Validate T2700
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2700Page navigateToT2700Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2700 Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2700Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2701Page Functionality : Validate T2701
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2701Page navigateToT2701Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2701 Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2701Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2706Page Functionality : Validate T2706
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2706Page navigateToT2706Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2706 Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2706Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2707Page Functionality : Validate T2707
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2707Page navigateToT2707Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2707 Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2707Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2727PagePage Functionality : Validate
	 * T2727 Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2727Page navigateToT2727Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2727 Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2727Page(browser);
	}

	// Modified Sections After 20/9/2021
	/***
	 * Created By : Menaka
	 *
	 ***/
	public synchronized CashFlowStatementPage cashFlowStatementTest(int threadID, List<String> tempList,
			String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation searchapp item Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new CashFlowStatementPage(browser);
	}

	// Modified Sections After 20/9/2021
	/***
	 * Created By : Menaka
	 *
	 ***/
	public synchronized GLAccountPageMenaka glAccountCreationTest(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation searchapp item Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new GLAccountPageMenaka(browser);
	}

	// Modified Sections After 20/9/2021
	/***
	 * Created By : Menaka
	 *
	 ***/
	public synchronized BankingLedgerPage bankingLedgerTest(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation searchapp item Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new BankingLedgerPage(browser);
	}

	/***
	 * Test case Method Name : navigateToT2695Page Functionality : Validate T2695
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2695Page navigateToT2695Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2695 Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2695Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2696Page Functionality : Validate T2696
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2696Page navigateToT2696Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2696 Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2696Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2694Page Functionality : Validate T2694
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2694Page navigateToT2694Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2696 Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new T2694Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2608Page Functionality : Validate T2608
	 * Page Created By : Lakshman
	 * 
	 ***/
	public synchronized T2608Page navigateToT2608Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2608 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2608Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2612Page Functionality : Validate T2612
	 * Page Created By : Lakshman
	 * 
	 ***/
	public synchronized T2612Page navigateToT2612Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2612 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2612Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2613Page Functionality : Validate T2613
	 * Page Created By : Lakshman
	 * 
	 ***/
	public synchronized T2613Page navigateToT2613Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2613 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2613Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2614Page Functionality : Validate T2614
	 * Page Created By : Lakshman
	 * 
	 ***/
	public synchronized T2614Page navigateToT2614Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2614 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2614Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2688Page Functionality : Validate T2688
	 * Page Created By : Lakshman
	 * 
	 ***/
	public synchronized T2688Page navigateToT2688Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2688 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2688Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2687Page Functionality : Validate T2687
	 * Page Created By : Lakshman
	 * 
	 ***/
	public synchronized T2687Page navigateToT2687Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2687 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2687Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2702Page Functionality : Validate T2702
	 * Page Created By : Lakshman
	 * 
	 ***/
	public synchronized T2702Page navigateToT2702Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2702 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2702Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2708Page Functionality : Validate T2708
	 * Page Created By : Lakshman
	 * 
	 ***/
	public synchronized T2708Page navigateToT2708Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2708 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2708Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2709Page Functionality : Validate T2709
	 * Page Created By : Lakshman
	 * 
	 ***/
	public synchronized T2709Page navigateToT2709Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2709 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2709Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2710Page Functionality : Validate T2710
	 * Page Created By : Lakshman
	 * 
	 ***/
	public synchronized T2710Page navigateToT2710Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2710 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2710Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2711Page Functionality : Validate T2711
	 * Page Created By : Lakshman
	 * 
	 ***/
	public synchronized T2711Page navigateToT2711Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2711 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2711Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2735PagePage Functionality : Validate
	 * T2735 Page Created By : Lakshman
	 * 
	 ***/
	public synchronized T2735Page navigateToT2735Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2735 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2735Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2599Page Page Functionality : Validate
	 * T2735 Page Created By : Anitha
	 * 
	 ***/
	public synchronized T2599Page navigateToT2599Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2735 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2599Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2615Page Functionality : Validate T2615
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2615Page navigateToT2615Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2615 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2615Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2645Page Functionality : Validate T2645
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2645Page navigateToT2645Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2645 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2645Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2646Page Functionality : Validate T2646
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2646Page navigateToT2646Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2646 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2646Page(browser);
	}

	/***
	 * Test case Method Name : navigateToT2647Page Functionality : Validate T2647
	 * Page Created By : Lakshman
	 *
	 ***/
	public synchronized T2647Page navigateToT2647Page(int threadID, List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation T2647 Page", browser,
				pathLoc + "\\" + testcasemethod, false);
		return new T2647Page(browser);
	}

	/***
	 * Created By : Menaka
	 *
	 ***/
	public synchronized AccountingSeedReusableFunctionalities accountingSeedReusableFunction(int threadID,
			List<String> tempList, String pathLoc) {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();
		ReusableComponents.reportInfo(threadID, tempList, testcasemethod, "Validation searchapp item Page", browser,
				pathLoc + "/" + testcasemethod, false);
		return new AccountingSeedReusableFunctionalities(browser);
	}

}
