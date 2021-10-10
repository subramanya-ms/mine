package com.wisefinch.java;

import java.awt.AWTException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

//import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.*;

public class PlClass extends DriverScript{
	//ExcelOperations excelOperations = new ExcelOperations();
	static ReusableComponents reusableComponents = new ReusableComponents();
	
    WebDriver browser;
	
	public static String browserType;
	public static String OSType;
	public static String nodeUrl;
	DesiredCapabilities capability ;
	ChromeOptions options;
	int failcounter = 0;

	@BeforeClass
	public void init() throws FileNotFoundException {
		
		//System.out.println("This goes to the console");
		PrintStream console = System.out;

		String workingDir = System.getProperty("user.dir");
		String filenameval = workingDir+"/logs/"+filename+".txt";
		File file = new File(filenameval);
		FileOutputStream fos = new FileOutputStream(file);
		//PrintStream ps = new PrintStream(fos);
		//System.setOut(ps);
		//System.out.println("This goes to out.txt");
		
		// add initial details here
		
		
	}
	
	@BeforeMethod
	@Parameters({"platform" , "browserName" , "remoteurl"}) 
	public synchronized void setup(@Optional("opt platform") String platform ,@Optional("opt browser name") String browserName ,@Optional("opt remoteurl") String remoteurl) throws IOException{

		browserType = browserName.toLowerCase();
		String strBrowser = browserName.toLowerCase();
		OSType = reusableComponents.getPropValues("OS");
	
		//String workingDir = System.getProperty("user.dir");
		System.out.println(workingDir);
	
		options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		options.setExperimentalOption("prefs", prefs);
		
		System.setProperty("webdriver.chrome.driver",workingDir+"/seleniumjars/chrome/chromedriver.exe");
		
		browser =  new ChromeDriver(options);
		
	}
	
	
	@Test
	@Parameters({"platform" , "browserName" , "remoteurl"}) 
	public synchronized void validate_Test_2676(@Optional("opt platform") String platform ,@Optional("opt browser name") String browserName ,@Optional("opt remoteurl") String remoteurl) throws IOException, AWTException{
		

		
		
		TESTCASENAME = new Object(){}.getClass().getEnclosingMethod().getName();
		
		TESTCASENAME = "Test-2676";
		String strClassName = new Object(){}.getClass().getName();
		
		strClassName = "Financial Reports PL";
		String testMethod = strClassName+" - "+TESTCASENAME;
		String workingDir = System.getProperty("user.dir");
    
		
		int threadID = (int) (long) Thread.currentThread().getId();
		
		List<String> tempResultList = new ArrayList<String>();
			
		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		//browser.get(url);
		browser.navigate().to(url);

	ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Chrome Browser started", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Launch : Launching of Browser with Application "+url+" is Successful", browser ,pathLoc+"/"+TESTCASENAME , false );
//		System.out.println("Launch : Launching of Browser with Application "+url+" is Successful");
		browser.manage().window().maximize();
		//browser.manage().window().fullscreen();

		//Printing Id of the thread on using which test method got executed
//		System.out.println("Test Case  with Thread Id:- "+ Thread.currentThread().getId());
//		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test Case with Thread Id:- "+ threadID, browser ,pathLoc+"/"+TESTCASENAME , false );
		
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
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Validation Steps --  Step Status starts here", browser ,pathLoc+"/"+TESTCASENAME , false );
	
			
		page.navigateToPlPage(threadID,tempResultList ,pathLoc)
		.Salesforce_login(threadID, tempResultList, pathLoc) //this is login page
		.validateTestC(threadID, tempResultList, pathLoc)  // excel read and multiple options
		//.validateTestD(threadID, tempResultList, pathLoc)
		//.validateTestB(threadID, tempResultList, pathLoc)
		//.validateTestOpp(threadID, tempResultList, pathLoc)

		
			;
		
	
				
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test case : Validating the Aseed Page test case", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		logger = report.startTest(testMethod);
		List<String > testList = hmap.get(threadID);		
		for(int i=0 ; i<testList.size();i++){
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step "+(i+1)+" :- "+eachElement);
			String[] testResult = eachElement.split("&");
			
			String stepStatus = testResult[0].toLowerCase();
			
			String testMethodName = testResult[1].toLowerCase();
			
			//String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];
			
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
					logger.log(LogStatus.UNKNOWN, testMethodName , testDesc +logger.addScreenCapture(filePath));
					break;	
				case "fail":
					logger.log(LogStatus.FAIL, testMethodName , testDesc +logger.addScreenCapture(filePath));
					failcounter++;
					break;	
			}
			
		}
		
		// out here
		

	}		
	
	@Test
	@Parameters({"platform" , "browserName" , "remoteurl"}) 
	public synchronized void validate_Hashmap(@Optional("opt platform") String platform ,@Optional("opt browser name") String browserName ,@Optional("opt remoteurl") String remoteurl) throws IOException, AWTException{
		

		
		
		TESTCASENAME = new Object(){}.getClass().getEnclosingMethod().getName();
		
		TESTCASENAME = "Test-2676";
		String strClassName = new Object(){}.getClass().getName();
		
		strClassName = "Financial Reports PL";
		String testMethod = strClassName+" - "+TESTCASENAME;
		String workingDir = System.getProperty("user.dir");
    
		
		int threadID = (int) (long) Thread.currentThread().getId();
		
		List<String> tempResultList = new ArrayList<String>();
			
		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		//browser.get(url);
		//browser.navigate().to(url);

	ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Chrome Browser started", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Launch : Launching of Browser with Application "+url+" is Successful", browser ,pathLoc+"/"+TESTCASENAME , false );
//		System.out.println("Launch : Launching of Browser with Application "+url+" is Successful");
		browser.manage().window().maximize();
		//browser.manage().window().fullscreen();

		//Printing Id of the thread on using which test method got executed
//		System.out.println("Test Case  with Thread Id:- "+ Thread.currentThread().getId());
//		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test Case with Thread Id:- "+ threadID, browser ,pathLoc+"/"+TESTCASENAME , false );
		
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
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Validation Steps --  Step Status starts here", browser ,pathLoc+"/"+TESTCASENAME , false );
	
			
		page.navigateToPlPage(threadID,tempResultList ,pathLoc)
		//.Salesforce_login(threadID, tempResultList, pathLoc) //this is login page
		//.validateTestC(threadID, tempResultList, pathLoc)  // excel read and multiple options
		//.validateTestD(threadID, tempResultList, pathLoc)
		//.validateTestB(threadID, tempResultList, pathLoc)
		//.validateTestOpp(threadID, tempResultList, pathLoc)
		.Hashmaper(threadID, tempResultList, pathLoc)

		
			;
		
	
				
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test case : Validating the Aseed Page test case", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		logger = report.startTest(testMethod);
		List<String > testList = hmap.get(threadID);		
		for(int i=0 ; i<testList.size();i++){
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step "+(i+1)+" :- "+eachElement);
			String[] testResult = eachElement.split("&");
			
			String stepStatus = testResult[0].toLowerCase();
			
			String testMethodName = testResult[1].toLowerCase();
			
			//String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];
			
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
					logger.log(LogStatus.UNKNOWN, testMethodName , testDesc +logger.addScreenCapture(filePath));
					break;	
				case "fail":
					logger.log(LogStatus.FAIL, testMethodName , testDesc +logger.addScreenCapture(filePath));
					failcounter++;
					break;	
			}
			
		}
		
		// out here
		

	}		
	
	

	@Test
	@Parameters({"platform" , "browserName" , "remoteurl"}) 
	public synchronized void validate_Test_2677(@Optional("opt platform") String platform ,@Optional("opt browser name") String browserName ,@Optional("opt remoteurl") String remoteurl) throws IOException, AWTException{
		
		TESTCASENAME = new Object(){}.getClass().getEnclosingMethod().getName();
		
		TESTCASENAME = "Test-2677";
		String strClassName = new Object(){}.getClass().getName();
		
		strClassName = "Financial Reports PL";
		String testMethod = strClassName+" - "+TESTCASENAME;
		String workingDir = System.getProperty("user.dir");
    
		
		int threadID = (int) (long) Thread.currentThread().getId();
		
		List<String> tempResultList = new ArrayList<String>();
			
		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		//browser.get(url);
		browser.navigate().to(url);

	ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Chrome Browser started", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Launch : Launching of Browser with Application "+url+" is Successful", browser ,pathLoc+"/"+TESTCASENAME , false );
//		System.out.println("Launch : Launching of Browser with Application "+url+" is Successful");
		browser.manage().window().maximize();
		//browser.manage().window().fullscreen();

		//Printing Id of the thread on using which test method got executed
//		System.out.println("Test Case  with Thread Id:- "+ Thread.currentThread().getId());
//		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test Case with Thread Id:- "+ threadID, browser ,pathLoc+"/"+TESTCASENAME , false );
		
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
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Validation Steps --  Step Status starts here", browser ,pathLoc+"/"+TESTCASENAME , false );
	
			
		page.navigateToPlPage(threadID,tempResultList ,pathLoc)
		.Salesforce_login(threadID, tempResultList, pathLoc) //this is login page
		.validateTest2677(threadID, tempResultList, pathLoc)  // excel read and multiple options
		//.validateTestD(threadID, tempResultList, pathLoc)
		//.validateTestB(threadID, tempResultList, pathLoc)
		//.validateTestOpp(threadID, tempResultList, pathLoc)

		
			;
		
	
				
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test case : Validating the Aseed Page test case", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		logger = report.startTest(testMethod);
		List<String > testList = hmap.get(threadID);		
		for(int i=0 ; i<testList.size();i++){
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step "+(i+1)+" :- "+eachElement);
			String[] testResult = eachElement.split("&");
			
			String stepStatus = testResult[0].toLowerCase();
			
			String testMethodName = testResult[1].toLowerCase();
			
			//String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];
			
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
					logger.log(LogStatus.UNKNOWN, testMethodName , testDesc +logger.addScreenCapture(filePath));
					break;	
				case "fail":
					logger.log(LogStatus.FAIL, testMethodName , testDesc +logger.addScreenCapture(filePath));
					failcounter++;
					break;	
			}
			
		}
		
		
	}	
	
	@Test
	@Parameters({"platform" , "browserName" , "remoteurl"}) 
	public synchronized void validate_Test_2678(@Optional("opt platform") String platform ,@Optional("opt browser name") String browserName ,@Optional("opt remoteurl") String remoteurl) throws IOException, AWTException{
		

		
		
		TESTCASENAME = new Object(){}.getClass().getEnclosingMethod().getName();
		
		TESTCASENAME = "Test-2678";
		String strClassName = new Object(){}.getClass().getName();
		
		strClassName = "Financial Reports PL";
		String testMethod = strClassName+" - "+TESTCASENAME;
		String workingDir = System.getProperty("user.dir");
    
		
		int threadID = (int) (long) Thread.currentThread().getId();
		
		List<String> tempResultList = new ArrayList<String>();
			
		String url = reusableComponents.getPropValues("PLURL");
		browser.manage().deleteAllCookies();
		//browser.get(url);
		browser.navigate().to(url);

	ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Chrome Browser started", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Launch : Launching of Browser with Application "+url+" is Successful", browser ,pathLoc+"/"+TESTCASENAME , false );
//		System.out.println("Launch : Launching of Browser with Application "+url+" is Successful");
		browser.manage().window().maximize();
		//browser.manage().window().fullscreen();

		//Printing Id of the thread on using which test method got executed
//		System.out.println("Test Case  with Thread Id:- "+ Thread.currentThread().getId());
//		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test Case with Thread Id:- "+ threadID, browser ,pathLoc+"/"+TESTCASENAME , false );
		
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
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Validation Steps --  Step Status starts here", browser ,pathLoc+"/"+TESTCASENAME , false );
	
			
		page.navigateToPlPage(threadID,tempResultList ,pathLoc)
		.Salesforce_login(threadID, tempResultList, pathLoc) //this is login page
		.validateTest2678(threadID, tempResultList, pathLoc)  // excel read and multiple options
		//.validateTestD(threadID, tempResultList, pathLoc)
		//.validateTestB(threadID, tempResultList, pathLoc)
		//.validateTestOpp(threadID, tempResultList, pathLoc)

		
			;
		
	
				
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test case : Validating the Aseed Page test case", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		logger = report.startTest(testMethod);
		List<String > testList = hmap.get(threadID);		
		for(int i=0 ; i<testList.size();i++){
			String eachElement = testList.get(i);
			System.out.println("Test Case in Extent Reporting with Thread Id step "+(i+1)+" :- "+eachElement);
			String[] testResult = eachElement.split("&");
			
			String stepStatus = testResult[0].toLowerCase();
			
			String testMethodName = testResult[1].toLowerCase();
			
			//String testDesc = testResult[2].toLowerCase();
			String testDesc = testResult[2];
			
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
					logger.log(LogStatus.UNKNOWN, testMethodName , testDesc +logger.addScreenCapture(filePath));
					break;	
				case "fail":
					logger.log(LogStatus.FAIL, testMethodName , testDesc +logger.addScreenCapture(filePath));
					failcounter++;
					break;	
			}
			
		}
		
		// out here
		

	}		
	
	
	
	@AfterMethod
	public void wrapUpMethod() throws UnsupportedEncodingException, IOException{

		
		System.out.println("failure count "+failcounter);	
		System.out.println("Wrap Up : Closing browser Session");
		browser.manage().deleteAllCookies();
		testclassname = new Object(){}.getClass().getName();
		browser.close();
		browser.quit();
	
	}
	
				
	@AfterClass
	public void wrapUp() throws UnsupportedEncodingException, IOException{
		
		PrintStream console = System.out;
		

		report.endTest(logger);
		report.flush();
		ReusableComponents.wait(1000);
		

		testclassname = new Object(){}.getClass().getName();
		
		System.setOut(console);
		//System.out.println("This also goes to the console");
		//SendEmail.main(null);
		
if (failcounter != 0){
			
	
			
		}else{
			

		}
	//	browser.close();
		//browser.quit();
		

		
	}
	

}
