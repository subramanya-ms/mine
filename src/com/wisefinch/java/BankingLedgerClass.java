package com.wisefinch.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

//import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.*;

public class BankingLedgerClass extends DriverScript {
	// ExcelOperations excelOperations = new ExcelOperations();
	static ReusableComponents reusableComponents = new ReusableComponents();

	WebDriver browser;

	public static String browserType;
	public static String OSType;
	public static String nodeUrl;
	DesiredCapabilities capability;
	ChromeOptions options;
	int failcounter = 0;

	static {
		try {
			reusableComponents.getPropValues("OS");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeMethod
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void setup(@Optional("opt platform") String platform,
			@Optional("opt browser name") String browserName, @Optional("opt remoteurl") String remoteurl)
			throws IOException {

		browserType = browserName.toLowerCase();
		String strBrowser = browserName.toLowerCase();
		OSType = reusableComponents.getPropValues("OS");

		String workingDir = System.getProperty("user.dir");
		System.out.println(workingDir);

		options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		Map<String, Object> prefs = new HashMap<String, Object>();

		// add key and value to map as follow to switch off browser notification
		// Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("browser.download.dir", "C:\\Users\\Wisefinch\\git\\Automation_repo\\Reports\\");

		options.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver", workingDir + "/seleniumjars/chromedriver.exe");

		browser = new ChromeDriver(options);

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void test2703_BalanceSheetAmountPeriodClosing(@Optional("opt platform") String platform,
			@Optional("opt browser name") String browserName, @Optional("opt remoteurl") String remoteurl)
			throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		
		String testMethod = strClassName + "_" + TESTCASENAME;
		
		String workingDir = System.getProperty("user.dir");
		

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}
		System.out.println("******************** PathLoc " + pathLoc);
		String pathLoction = reusableComponents.pathBuilder(path);
		System.out.println("******************** PathLoc " + pathLoction);
		

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2703", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"Test case title : [BL] Verify that the Balance Sheet shows correct amounts for all  the Asset GL Accounts on period closing (not year-end)",
				browser, pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.bankingLedgerTest(threadID, tempResultList, pathLoction)
				.test2703_BalanceSheetAmountGLAccountsPeriodClose(threadID, tempResultList, pathLoction);

		// page.bankingLedgerTest(threadID, tempResultList,
		// pathLoction).testDataCreation(threadID, tempResultList, pathLoction);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

		

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void test2704_BalanceSheetAmountLiabilityPeriodClosing(
			@Optional("opt platform") String platform, @Optional("opt browser name") String browserName,
			@Optional("opt remoteurl") String remoteurl) throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		String testMethod = strClassName + "_" + TESTCASENAME;
		String workingDir = System.getProperty("user.dir");

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}
		System.out.println("******************** PathLoc " + pathLoc);
		String pathLoction = reusableComponents.pathBuilder(path);
		System.out.println("******************** PathLoc " + pathLoction);

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2704", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"Test case title: [BL] Verify that the Balance Sheet shows correct amounts for all the Liability GL Accounts on period closing (not year-end)",
				browser, pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.bankingLedgerTest(threadID, tempResultList, pathLoction)
				.test2704_BalanceSheetAmountLiabilityGLAccountsPeriodClose(threadID, tempResultList, pathLoction);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void test2705_BalanceSheetAmountOwnerEqualityPeriodClosing(
			@Optional("opt platform") String platform, @Optional("opt browser name") String browserName,
			@Optional("opt remoteurl") String remoteurl) throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		String testMethod = strClassName + "_" + TESTCASENAME;
		String workingDir = System.getProperty("user.dir");

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}
		System.out.println("******************** PathLoc " + pathLoc);
		String pathLoction = reusableComponents.pathBuilder(path);
		System.out.println("******************** PathLoc " + pathLoction);

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2705", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"Test case Title: [BL] Verify that the Balance Sheet shows correct amounts for all the Owners Equity GL Accounts on period closing (not year-end)",
				browser, pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.bankingLedgerTest(threadID, tempResultList, pathLoction)
				.test2705_BalanceSheetAmountOwnerEquityGLAccountsPeriodClose(threadID, tempResultList, pathLoction);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void test2690_PeriodCorrectAmountNonYearEndPeriod(@Optional("opt platform") String platform,
			@Optional("opt browser name") String browserName, @Optional("opt remoteurl") String remoteurl)
			throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		String testMethod = strClassName + "_" + TESTCASENAME;
		String workingDir = System.getProperty("user.dir");

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}
		System.out.println("******************** PathLoc " + pathLoc);
		String pathLocation = reusableComponents.pathBuilder(path);
		System.out.println("******************** PathLoc " + pathLocation);

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2690", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"Title: [TB] Verify that the Period column shows the correct amounts for a non year end period.",
				browser, pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.bankingLedgerTest(threadID, tempResultList, pathLocation)
				.test2690_PeriodCorrectAmountNonYearEndPeriod(threadID, tempResultList, pathLocation);

		// page.bankingLedgerTest(threadID, tempResultList,
		// pathLocation).testHere(threadID, tempResultList, pathLocation);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void test2691_YearEndClosingGLAccountOpeningBlancesPopulated(
			@Optional("opt platform") String platform, @Optional("opt browser name") String browserName,
			@Optional("opt remoteurl") String remoteurl) throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		String testMethod = strClassName + "_" + TESTCASENAME;
		String workingDir = System.getProperty("user.dir");

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}
		System.out.println("******************** PathLoc " + pathLoc);
		String pathLocation = reusableComponents.pathBuilder(path);
		System.out.println("******************** PathLoc " + pathLocation);

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2691", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"[TB] On year end closing, Balance Sheet GL Accounts should have Opening Balances populated", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.bankingLedgerTest(threadID, tempResultList, pathLocation)
				.test2691_YearEndClosingGLAccountOpeningBlancesPopulated(threadID, tempResultList, pathLocation);

		// page.bankingLedgerTest(threadID, tempResultList,
		// pathLocation).testHere(threadID, tempResultList, pathLocation);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void test2692_YearEndClosingRetainedEarningGLAccountOpeningBlancesPopulated(
			@Optional("opt platform") String platform, @Optional("opt browser name") String browserName,
			@Optional("opt remoteurl") String remoteurl) throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		String testMethod = strClassName + "_" + TESTCASENAME;
		String workingDir = System.getProperty("user.dir");

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}
		System.out.println("******************** PathLoc " + pathLoc);
		String pathLocation = reusableComponents.pathBuilder(path);
		System.out.println("******************** PathLoc " + pathLocation);

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2692", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"[TB] On year end closing, Retained Earnings GL Accounts should have Opening Balances populated if there were transactions",
				browser, pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.bankingLedgerTest(threadID, tempResultList, pathLocation)
				.test2692_YearEndClosingRetainedEarningGLAccountOpeningBlancesPopulated(threadID, tempResultList,
						pathLocation);

		// page.bankingLedgerTest(threadID, tempResultList,
		// pathLocation).testHere(threadID, tempResultList, pathLocation);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void test2693_YearEndClosingExpenseGLAccountsShownZeroOnOpeningBalance(
			@Optional("opt platform") String platform, @Optional("opt browser name") String browserName,
			@Optional("opt remoteurl") String remoteurl) throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		String testMethod = strClassName + "_" + TESTCASENAME;
		String workingDir = System.getProperty("user.dir");

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}
		System.out.println("******************** PathLoc " + pathLoc);
		String pathLocation = reusableComponents.pathBuilder(path);
		System.out.println("******************** PathLoc " + pathLocation);

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2693", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"[TB] On year end closing, Revenue and Expense GL Accounts show 0.00 Opening Balances", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		// page.bankingLedgerTest(threadID, tempResultList, pathLocation)
		// .test2693_YearEndClosingExpenseGLAccountsShownZeroOnOpeningBalance(threadID,
		// tempResultList,
		// pathLocation);

		page.bankingLedgerTest(threadID, tempResultList, pathLocation).testHere(threadID, tempResultList, pathLocation);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void test2622_TBVerifyFormettingOfNegativeAndPositive(@Optional("opt platform") String platform,
			@Optional("opt browser name") String browserName, @Optional("opt remoteurl") String remoteurl)
			throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		String testMethod = strClassName + "_" + TESTCASENAME;
		String workingDir = System.getProperty("user.dir");

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}
		System.out.println("******************** PathLoc " + pathLoc);
		String pathLoction = reusableComponents.pathBuilder(path);
		System.out.println("******************** PathLoc " + pathLoction);

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2622", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"Test case title : [TB] Verify formatting of negative and positive amounts on the report.", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.bankingLedgerTest(threadID, tempResultList, pathLoction)
				.test2622_TBVerifyFormettingOfNegativeAndPositive(threadID, tempResultList, pathLoction);

		// page.bankingLedgerTest(threadID, tempResultList,
		// pathLoction).testDataCreation(threadID, tempResultList, pathLoction);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void test2623_SupressZeroUnCheGLNoTransZero(@Optional("opt platform") String platform,
			@Optional("opt browser name") String browserName, @Optional("opt remoteurl") String remoteurl)
			throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		String testMethod = strClassName + "_" + TESTCASENAME;
		String workingDir = System.getProperty("user.dir");

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}
		System.out.println("******************** PathLoc " + pathLoc);
		String pathLoction = reusableComponents.pathBuilder(path);
		System.out.println("******************** PathLoc " + pathLoction);

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2623", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"Test case title :[TB] If the 'Suppress Zero Amount Rows' checkbox is unchecked the GL Accounts that don't have transactions posted have '0.00'.",
				browser, pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.bankingLedgerTest(threadID, tempResultList, pathLoction)
				.test2623_SupressZeroUncheckedGLAccountNoTransactionZero(threadID, tempResultList, pathLoction);

		// page.bankingLedgerTest(threadID, tempResultList,
		// pathLoction).testHere(threadID, tempResultList,
		// pathLoction);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void test2624_SupressGLAccTrans(@Optional("opt platform") String platform,
			@Optional("opt browser name") String browserName, @Optional("opt remoteurl") String remoteurl)
			throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		String testMethod = strClassName + "_" + TESTCASENAME;
		String workingDir = System.getProperty("user.dir");

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}

		String pathLocation = reusableComponents.pathBuilder(path);
		System.out.println("******************** pathLoction " + pathLocation);

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2624", browser,
				pathLocation + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"Test case title :[TB] If the 'Suppress Zero Amount Rows' checkbox is checked before running the report only GL accounts that have transactions posted to them are shown.",
				browser, pathLocation + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.bankingLedgerTest(threadID, tempResultList, pathLocation).test2624_SupressZeroCheckGLAccount(threadID,
				tempResultList, pathLocation);

		// page.bankingLedgerTest(threadID, tempResultList,
		// pathLoction).testHere(threadID, tempResultList,
		// pathLoction);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void test2625_SupressZeroUncheckedGLAccountNoTransactionZero(
			@Optional("opt platform") String platform, @Optional("opt browser name") String browserName,
			@Optional("opt remoteurl") String remoteurl) throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		String testMethod = strClassName + "_" + TESTCASENAME;
		String workingDir = System.getProperty("user.dir");

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}

		String pathLocation = reusableComponents.pathBuilder(path);
		System.out.println("******************** pathLoction " + pathLocation);

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2625", browser,
				pathLocation + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"[TB] Verify that the Trial Balance report can be run for the current (first open) period.", browser,
				pathLocation + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.bankingLedgerTest(threadID, tempResultList, pathLocation)
				.test2625_SupressZeroUncheckedGLAccountNoTransactionZero(threadID, tempResultList, pathLocation);

		// page.bankingLedgerTest(threadID, tempResultList,
		// pathLoction).testHere(threadID, tempResultList,
		// pathLoction);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void test2626_NoTBWhenPreviousAccountingPeriodOpen(@Optional("opt platform") String platform,
			@Optional("opt browser name") String browserName, @Optional("opt remoteurl") String remoteurl)
			throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		String testMethod = strClassName + "_" + TESTCASENAME;
		String workingDir = System.getProperty("user.dir");

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}

		String pathLocation = reusableComponents.pathBuilder(path);
		System.out.println("******************** pathLoction " + pathLocation);

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2626", browser,
				pathLocation + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"[TB] Verify that the Trial Balance report cannot be run for a period that is preceeded by an open period.",
				browser, pathLocation + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.bankingLedgerTest(threadID, tempResultList, pathLocation)
				.test2626_NoTBWhenPreviousAccountingPeriodOpen(threadID, tempResultList, pathLocation);

		// page.bankingLedgerTest(threadID, tempResultList,
		// pathLoction).testHere(threadID, tempResultList,
		// pathLoction);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void testHere(@Optional("opt platform") String platform,
			@Optional("opt browser name") String browserName, @Optional("opt remoteurl") String remoteurl)
			throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		
		String testMethod = strClassName + "_" + TESTCASENAME;
		
		String workingDir = System.getProperty("user.dir");
		

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}
		System.out.println("******************** PathLoc " + pathLoc);
		String pathLoction = reusableComponents.pathBuilder(path);
		System.out.println("******************** PathLoc " + pathLoction);
		

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2703", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"Test case title : [BL] Verify that the Balance Sheet shows correct amounts for all  the Asset GL Accounts on period closing (not year-end)",
				browser, pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");
		page.bankingLedgerTest(threadID, tempResultList, pathLoction).testHere(threadID, tempResultList, pathLoction);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void test2642_BudgetLedgerReport(@Optional("opt platform") String platform,
			@Optional("opt browser name") String browserName, @Optional("opt remoteurl") String remoteurl)
			throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		String testMethod = strClassName + "_" + TESTCASENAME;
		String workingDir = System.getProperty("user.dir");

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}
		System.out.println("******************** PathLoc " + pathLoc);
		String pathLoction = reusableComponents.pathBuilder(path);
		System.out.println("******************** PathLoc " + pathLoction);
		System.out.println("@@@@@@@@@@ pathLoction " + pathLoction);

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2642", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"[P&LvB] If the 'Suppress Zero Amount Rows?' checkbox is checked before running the report only GL accounts that have transactions posted to them are shown.",
				browser, pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");
		page.bankingLedgerTest(threadID, tempResultList, pathLoction).test2642_BudgetLedgerReport(threadID,
				tempResultList, pathLoction);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@Test
	@Parameters({ "platform", "browserName", "remoteurl" })
	public synchronized void test2643_BudgetLedgerReport(@Optional("opt platform") String platform,
			@Optional("opt browser name") String browserName, @Optional("opt remoteurl") String remoteurl)
			throws Exception {

		TESTCASENAME = new Object() {
		}.getClass().getEnclosingMethod().getName();

		String strClassName = new Object() {
		}.getClass().getName();
		String testMethod = strClassName + "_" + TESTCASENAME;
		String workingDir = System.getProperty("user.dir");

		// int threadID = (int) (long) Thread.currentThread().getId();
		int threadID = 0;
		List<String> tempResultList = new ArrayList<String>();

		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		browser.get(url);

		browser.manage().window().maximize();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Test Case with Thread Id:- " + threadID, browser, pathLoc + "\\" +
		 * TESTCASENAME, false);
		 */

		Page page = new Page(browser);

		String path;
		switch (browserName) {

		case "Firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir + reusableComponents.getPropValues("IEResultspath") + "\\" + TESTCASENAME;
			break;
		case "firefox":
			path = workingDir + reusableComponents.getPropValues("FirefoxResultspath") + "\\" + TESTCASENAME;
			break;
		case "chrome":
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		default:
			path = workingDir + reusableComponents.getPropValues("ChromeResultspath") + "\\" + TESTCASENAME;
			break;
		}
		System.out.println("******************** PathLoc " + pathLoc);
		String pathLoction = reusableComponents.pathBuilder(path);
		System.out.println("******************** PathLoc " + pathLoction);
		System.out.println("@@@@@@@@@@ pathLoction " + pathLoction);

		resultList = new ArrayList<String>();

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : 2643", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"[P&LvB] If the 'Suppress Zero Amount Rows?' checkbox is unchecked before running the report all GL accounts are shown whether or not they have transactions posted to them",
				browser, pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");
		page.bankingLedgerTest(threadID, tempResultList, pathLoction).test2643_BudgetLedgerReport(threadID,
				tempResultList, pathLoction);

		logger = report.startTest(testMethod);
		List<String> testList = hmap.get(0);

		for (int i = 0; i < testList.size(); i++) {
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step " + (i + 1) + " :- " + eachElement);
			String[] testResult = eachElement.split("&");

			String stepStatus = testResult[0].toLowerCase();

			String testMethodName = testResult[1].toLowerCase();

			// String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];

			String filePath = "";

			if (testResult.length > 3) {
				filePath = testResult[3].toLowerCase();
			}

			switch (stepStatus) {
			case "info":
				logger.log(LogStatus.INFO, testDesc);
				break;
			case "pass":
				logger.log(LogStatus.PASS, testDesc);
				break;
			case "unknown": // updated the logger to handle specific type of logger, which was unused
				logger.log(LogStatus.UNKNOWN, testDesc + logger.addScreenCapture(filePath));
				break;
			case "fail":
				logger.log(LogStatus.FAIL, testDesc + logger.addScreenCapture(filePath));
				failcounter++;
				break;
			}

		}

	}

	@AfterClass
	public void wrapUp() {

		report.endTest(logger);
		report.flush();
		ReusableComponents.wait(1000);

		System.out.println("failure count " + failcounter);
		System.out.println("Wrap Up : Closing browser Session");
		browser.manage().deleteAllCookies();

		if (failcounter != 0) {

		} else {

		}
		browser.close();
		browser.quit();

	}

}
