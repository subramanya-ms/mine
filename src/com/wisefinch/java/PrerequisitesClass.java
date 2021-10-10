package com.wisefinch.java;

import java.awt.AWTException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

//import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.*;

public class PrerequisitesClass extends DriverScript{
	//ExcelOperations excelOperations = new ExcelOperations();
	static ReusableComponents reusableComponents = new ReusableComponents();
	
    WebDriver browser;
	
	public static String browserType;
	public static String OSType;
	public static String nodeUrl;
	DesiredCapabilities capability ;
	ChromeOptions options;
	int failcounter = 0;
	
	
	@BeforeMethod
	@Parameters({"platform" , "browserName" , "remoteurl"}) 
	public synchronized void setup(@Optional("opt platform") String platform ,@Optional("opt browser name") String browserName ,@Optional("opt remoteurl") String remoteurl) throws IOException{
	
		browserType = browserName.toLowerCase();
		String strBrowser = browserName.toLowerCase();
		OSType = reusableComponents.getPropValues("OS");
	
		String workingDir = System.getProperty("user.dir");
		System.out.println(workingDir);
	
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		options.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.chrome.driver",workingDir+"/seleniumjars/chromedriver.exe");
		
		browser =  new ChromeDriver(options);
		
	}
	
	
	@Test
	@Parameters({"platform" , "browserName" , "remoteurl"}) 
	public synchronized void validate_PrerequisitePage_Rev1(@Optional("opt platform") String platform ,@Optional("opt browser name") String browserName ,@Optional("opt remoteurl") String remoteurl) throws IOException, AWTException{
		
		TESTCASENAME = new Object(){}.getClass().getEnclosingMethod().getName();
		TESTCASENAME = " TEST-2676";
		
		//String strClassName = new Object(){}.getClass().getName();
		String strClassName = "Financial Reports PL";
		String testMethod = strClassName+" - "+TESTCASENAME;
		String workingDir = System.getProperty("user.dir");
    
		
		int threadID = (int) (long) Thread.currentThread().getId();
		
		List<String> tempResultList = new ArrayList<String>();
			
		String url = reusableComponents.getPropValues("salesforceurl");
		browser.manage().deleteAllCookies();
	//	browser.get(url);

	ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Chrome Browser started", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Launch : Launching of Browser with Application "+url+" is Successful", browser ,pathLoc+"/"+TESTCASENAME , false );
//		System.out.println("Launch : Launching of Browser with Application "+url+" is Successful");
		browser.manage().window().maximize();
		//browser.manage().window().fullscreen();

		//Printing Id of the thread on using which test method got executed
//		System.out.println("Test Case  with Thread Id:- "+ Thread.currentThread().getId());
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test Case with Thread Id:- ", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		Page page = new Page(browser);
		
		
		String path;
		switch (browserName) {
			
		case "Firefox":
			path = workingDir+reusableComponents.getPropValues("FirefoxResultspath")+"/"+TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir+reusableComponents.getPropValues("ChromeResultspath")+"/"+TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir+reusableComponents.getPropValues("IEResultspath")+"/"+TESTCASENAME;
			break;	
		case "firefox":
			path = workingDir+reusableComponents.getPropValues("FirefoxResultspath")+"/"+TESTCASENAME;
			break;
		case "chrome":
			path = workingDir+reusableComponents.getPropValues("ChromeResultspath")+"/"+TESTCASENAME;
			break;	
		default:
			path = workingDir+reusableComponents.getPropValues("ChromeResultspath")+"/"+TESTCASENAME;			
			break;
	    }
		String pathLoc = reusableComponents.pathBuilder(path);
	    
		resultList = new ArrayList<String>();
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Validation Step --  Step Status", browser ,pathLoc+"/"+TESTCASENAME , false );
	
			
		page.navigateToPrerequisitesPage(threadID,tempResultList ,pathLoc)
	//	.validateTestA(threadID, tempResultList, pathLoc)
	//	.validateTestB(threadID, tempResultList, pathLoc)
	//	.validateTestC(threadID, tempResultList, pathLoc)
	//	.validateTestD(threadID, tempResultList, pathLoc)
		.excelread_initial(threadID, tempResultList, pathLoc)
	//	.validateTestA(threadID, tempResultList, pathLoc)
	//	.validateTestB(threadID, tempResultList, pathLoc)
	//	.validateTestC(threadID, tempResultList, pathLoc)
	//	.validateTestD(threadID, tempResultList, pathLoc)
	//	.validateTestExcelWrite(threadID, tempResultList, pathLoc)
		

		
			;
		
		ReusableComponents.wait(5500);
		
//		page.navigateToPlPage(threadID,tempResultList ,pathLoc)
//		.Navigation_page(threadID, tempResultList, pathLoc)
//		.validateTestC(threadID, tempResultList, pathLoc)  // excel read and multiple options
//		
//
//		
//			;
//		
//
//		
//		
		
	
				
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test case : Validating the pre-requisites Page test case", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		logger = report.startTest(testMethod);
		List<String > testList = hmap.get(threadID);		
		for(int i=0 ; i<testList.size();i++){
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step "+(i+1)+" :- "+eachElement);
			String[] testResult = eachElement.split("&");
			
			String stepStatus = testResult[0].toLowerCase();
			
			String testMethodName = testResult[1].toLowerCase();
			
			String testDesc = testResult[2].toLowerCase();
			
			String filePath = "";
			
			if(testResult.length>3){
				filePath =  testResult[3].toLowerCase();
			}
			
			switch (stepStatus){
				case "info":
					logger.log(LogStatus.INFO, testMethodName , testDesc);
					break;
				case "pass":
					logger.log(LogStatus.PASS, testMethodName , testDesc);
					break;
				case "unknown": // updated the logger to handle specific type of logger, which was unused
					logger.log(LogStatus.UNKNOWN, testMethodName , testDesc+logger.addScreenCapture(filePath));
					break;	
				case "fail":
					logger.log(LogStatus.FAIL, testMethodName , testDesc+logger.addScreenCapture(filePath));
					failcounter++;
					break;	
			}
			
		}
		
		
	}		

	
	// to call 2677 code
	
	@Test
	@Parameters({"platform" , "browserName" , "remoteurl"}) 
	public synchronized void validate_PrerequisitePage_Rev2(@Optional("opt platform") String platform ,@Optional("opt browser name") String browserName ,@Optional("opt remoteurl") String remoteurl) throws IOException, AWTException{
		
		TESTCASENAME = new Object(){}.getClass().getEnclosingMethod().getName();
		TESTCASENAME = " TEST-2677";
		
		//String strClassName = new Object(){}.getClass().getName();
		String strClassName = "Financial Reports";
		String testMethod = strClassName+" - "+TESTCASENAME;
		String workingDir = System.getProperty("user.dir");
    
		
		int threadID = (int) (long) Thread.currentThread().getId();
		
		List<String> tempResultList = new ArrayList<String>();
			
		String url = reusableComponents.getPropValues("salesforceurl");
		browser.manage().deleteAllCookies();
		browser.get(url);

	ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Browser started", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Launch : Launching of Browser with Application "+url+" is Successful", browser ,pathLoc+"/"+TESTCASENAME , false );
//		System.out.println("Launch : Launching of Browser with Application "+url+" is Successful");
		browser.manage().window().maximize();
		//browser.manage().window().fullscreen();

		//Printing Id of the thread on using which test method got executed
//		System.out.println("Test Case  with Thread Id:- "+ Thread.currentThread().getId());
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test Case with Thread Id:- ", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		Page page = new Page(browser);
		
		
		String path;
		switch (browserName) {
			
		case "Firefox":
			path = workingDir+reusableComponents.getPropValues("FirefoxResultspath")+"/"+TESTCASENAME;
			break;
		case "Chrome":
			path = workingDir+reusableComponents.getPropValues("ChromeResultspath")+"/"+TESTCASENAME;
			break;
		case "internet explorer":
			path = workingDir+reusableComponents.getPropValues("IEResultspath")+"/"+TESTCASENAME;
			break;	
		case "firefox":
			path = workingDir+reusableComponents.getPropValues("FirefoxResultspath")+"/"+TESTCASENAME;
			break;
		case "chrome":
			path = workingDir+reusableComponents.getPropValues("ChromeResultspath")+"/"+TESTCASENAME;
			break;	
		default:
			path = workingDir+reusableComponents.getPropValues("ChromeResultspath")+"/"+TESTCASENAME;			
			break;
	    }
		String pathLoc = reusableComponents.pathBuilder(path);
	    
		resultList = new ArrayList<String>();
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Validation Step --  Step Status", browser ,pathLoc+"/"+TESTCASENAME , false );
	
			
		page.navigateToPrerequisitesPage(threadID,tempResultList ,pathLoc)
	//	.validateTestA(threadID, tempResultList, pathLoc)
	//	.validateTestB(threadID, tempResultList, pathLoc)
	//	.validateTestC(threadID, tempResultList, pathLoc)
	//	.validateTestD(threadID, tempResultList, pathLoc)
		.validateTestExcelRead(threadID, tempResultList, pathLoc)
	//	.validateTestA(threadID, tempResultList, pathLoc)
	//	.validateTestB(threadID, tempResultList, pathLoc)
	//	.validateTestC(threadID, tempResultList, pathLoc)
	//	.validateTestD(threadID, tempResultList, pathLoc)
	//	.validateTestExcelWrite(threadID, tempResultList, pathLoc)
		

		
			;
		
		ReusableComponents.wait(5500);
		
		page.navigateToTest2677Page(threadID,tempResultList ,pathLoc)
		.Navigation_page(threadID, tempResultList, pathLoc)
		.validateTestC(threadID, tempResultList, pathLoc)  // excel read and multiple options
		

		
			;
		

		
		
		
	
				
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test case : Validating the pre-requisites Page test case", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		logger = report.startTest(testMethod);
		List<String > testList = hmap.get(threadID);		
		for(int i=0 ; i<testList.size();i++){
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step "+(i+1)+" :- "+eachElement);
			String[] testResult = eachElement.split("&");
			
			String stepStatus = testResult[0].toLowerCase();
			
			String testMethodName = testResult[1].toLowerCase();
			
			String testDesc = testResult[2].toLowerCase();
			
			String filePath = "";
			
			if(testResult.length>3){
				filePath =  testResult[3].toLowerCase();
			}
			
			switch (stepStatus){
				case "info":
					logger.log(LogStatus.INFO, testMethodName , testDesc);
					break;
				case "pass":
					logger.log(LogStatus.PASS, testMethodName , testDesc);
					break;
				case "unknown": // updated the logger to handle specific type of logger, which was unused
					logger.log(LogStatus.UNKNOWN, testMethodName , testDesc+logger.addScreenCapture(filePath));
					break;	
				case "fail":
					logger.log(LogStatus.FAIL, testMethodName , testDesc+logger.addScreenCapture(filePath));
					failcounter++;
					break;	
			}
			
		}
		
		
	}		

				
	@AfterMethod
	public void wrapUp() throws UnsupportedEncodingException, IOException{
		
		
		
		report.endTest(logger);
		report.flush();
		ReusableComponents.wait(1000);
		
		System.out.println("failure count "+failcounter);	
		System.out.println("Wrap Up : Closing browser Session");
		browser.manage().deleteAllCookies();
		testclassname = new Object(){}.getClass().getName();
		//SendEmail.main(null);
		
if (failcounter != 0){
			
	
			
		}else{
			

		}
		browser.close();
		browser.quit();
		

		
	}
	

}
