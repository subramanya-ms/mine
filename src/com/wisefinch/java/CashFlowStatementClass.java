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

public class CashFlowStatementClass extends DriverScript {
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
	public synchronized void cashFlowReport_2732(@Optional("opt platform") String platform,
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
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case with Thread Id:- " + threadID,
				browser, pathLoc + "\\" + TESTCASENAME, false);

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
		String pathLoc = reusableComponents.pathBuilder(path);

		resultList = new ArrayList<String>();
		/*
		 * ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
		 * "Validation Step --  Step Status", browser, pathLoc + "\\" + TESTCASENAME,
		 * false);
		 */

		reusableComponents.props.get("key");

		page.cashFlowStatementTest(threadID, tempResultList, pathLoc).test2732_CFReportAmountValidation(threadID,
				tempResultList, pathLoc);

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
	public synchronized void test2730_CashFlowCategoryValueCanNotBeChanged(@Optional("opt platform") String platform,
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
		String pathLoc = reusableComponents.pathBuilder(path);

		resultList = new ArrayList<String>();
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : TEST-2730", browser,
				pathLoc + "\\" + TESTCASENAME, false);
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"Test Case Title : [CF] Verify that the Cash Flow Category value cannot be cannot be changed on a posted Journal Entry line's transactions.",
				browser, pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.cashFlowStatementTest(threadID, tempResultList, pathLoc)
				.test2730_CashFlowCategoryValueCanNotBeChanged(threadID, tempResultList, pathLoc);

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
	public synchronized void test2744_FinancialCubesNotCreatedWhenCFFalse(@Optional("opt platform") String platform,
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
		String pathLoc = reusableComponents.pathBuilder(path);

		resultList = new ArrayList<String>();
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : TEST-2744", browser,
				pathLoc + "\\" + TESTCASENAME, false);
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"[CF] Verify that Cash Flow Period financial cubes are not created when the setting is not enabled.",
				browser, pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.cashFlowStatementTest(threadID, tempResultList, pathLoc)
				.test2744_FinancialCubesNotCreatedWhenCFFalse(threadID, tempResultList, pathLoc);

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
	public synchronized void test2741_OwnCashFlowCategoryOrChangeCF(@Optional("opt platform") String platform,
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
		String pathLoc = reusableComponents.pathBuilder(path);

		resultList = new ArrayList<String>();
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : TEST-2741", browser,
				pathLoc + "\\" + TESTCASENAME, false);
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"[CF] Verify that the user can add their own CF categories or change the names of the categories",
				browser, pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.cashFlowStatementTest(threadID, tempResultList, pathLoc).test2741_OwnCashFlowCategoryOrChangeCF(threadID,
				tempResultList, pathLoc);

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
	public synchronized void test2742_OwnCashFlowCategoryOrChangeCF(@Optional("opt platform") String platform,
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
		String pathLoc = reusableComponents.pathBuilder(path);

		resultList = new ArrayList<String>();
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : TEST-2742", browser,
				pathLoc + "\\" + TESTCASENAME, false);
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"[CF] Verify that the report shows the custom CF categories with amounts", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.cashFlowStatementTest(threadID, tempResultList, pathLoc).test2742_OwnCashFlowCategoryOrChangeCF(threadID,
				tempResultList, pathLoc);

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
	public synchronized void test2661_CashFlowTrueFalseCashReceipt(@Optional("opt platform") String platform,
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
		String pathLoc = reusableComponents.pathBuilder(path);

		resultList = new ArrayList<String>();
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : TEST-2661", browser,
				pathLoc + "\\" + TESTCASENAME, false);
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"[CF] Verify that if the CF statement is disabled after being enabled, the CF category is not required for posting.",
				browser, pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.cashFlowStatementTest(threadID, tempResultList, pathLoc).test2661_CashFlowTrueFalseCashReceipt(threadID,
				tempResultList, pathLoc);

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
	public synchronized void test2662_CashFlowCanNotDeleteWithRecords(@Optional("opt platform") String platform,
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
		String pathLoc = reusableComponents.pathBuilder(path);

		resultList = new ArrayList<String>();
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : TEST-2662", browser,
				pathLoc + "\\" + TESTCASENAME, false);
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"[CF] Verify that a CF category cannot be deleted once there are records associated to it", browser,
				pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.cashFlowStatementTest(threadID, tempResultList, pathLoc).test2662_CashFlowCanNotDeleteWithRecords(threadID,
				tempResultList, pathLoc);

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
	public synchronized void test2731_CFEnabledRecordUnCategoricedShowAllChecked(
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
		String pathLoc = reusableComponents.pathBuilder(path);

		resultList = new ArrayList<String>();
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod, "Test Case Number : TEST-2731", browser,
				pathLoc + "\\" + TESTCASENAME, false);
		ReusableComponents.reportInfo(threadID, tempResultList, testMethod,
				"[CF] Verify message shown when CF is enabled but records are uncategorized and Show All Periods is checked",
				browser, pathLoc + "\\" + TESTCASENAME, false);

		reusableComponents.props.get("key");

		page.cashFlowStatementTest(threadID, tempResultList, pathLoc).test2731_CFEnabledRecordUnCategoricedShowAllChecked(threadID,
				tempResultList, pathLoc);

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
