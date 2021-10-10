package com.wisefinch.java;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
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

public class PLAllClass extends DriverScript{
	//ExcelOperations excelOperations = new ExcelOperations();
	static ReusableComponents reusableComponents = new ReusableComponents();
	
    WebDriver browser;
	
	public static String browserType;
	public static String OSType;
	public static String nodeUrl;
	DesiredCapabilities capability ;
	ChromeOptions options;
	int failcounter = 0;
	ArrayList<String> basic_input= new ArrayList<String>();
	public static String urlfromexcel, user_name, password_login;
PLAllPage p = new PLAllPage(browser);
SendEmail s = new SendEmail();

	
	@BeforeClass
	public void init() throws Exception {
		
		//System.out.println("This goes to the console");
		PrintStream console = System.out;

		String workingDir = System.getProperty("user.dir");
		String filenameval = workingDir+"/logs/"+filename+".txt";
		File file1 = new File(filenameval);
		FileOutputStream fos = new FileOutputStream(file1);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		//System.out.println("This goes to out.txt");
		
		// add initial details here

		//p.excelread_initial(failcounter, basic_input, filenameval);
		
		
//		try {
//
//			String filename = reusableComponents.getPropValues("Financialreportsinput");
//			String sheetname = reusableComponents.getPropValues("primarysheet");
//			System.out.println(filename);
//			System.out.println(sheetname);
//
//
//			File file = new File(workingDir + "/input/" + filename);
//			FileInputStream istream = new FileInputStream(file);
//
//			Workbook myworkbook = null;
//
//			String fileExtensionName = filename.substring(filename.indexOf("."));
//
//			if (fileExtensionName.equals(".xlsx")) {
//				// If it is xlsx file then create object of XSSFWorkbook class
//				myworkbook = new XSSFWorkbook(istream);
//			}
//			// Check condition if the file is xls file
//			else if (fileExtensionName.equals(".xls")) {
//				// If it is xls file then create object of HSSFWorkbook class
//				myworkbook = new HSSFWorkbook(istream);
//			}
//
//			Sheet workbooksheet = myworkbook.getSheet(sheetname);
//			int rowCount = workbooksheet.getLastRowNum() - workbooksheet.getFirstRowNum();
//			int columnCount = workbooksheet.getRow(0).getLastCellNum();
//			System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);
//
//			// read rows and columns
//			
//			Iterator<Row> itr = workbooksheet.iterator();
//			
//			while(itr.hasNext()) {
//				Row row = itr.next();
//				 if(row.getRowNum()==0 ){
//				       continue; //just skip the rows if row number is 0 or 1
//				      }
//
//			//	 if(row.getRowNum() == 1) {
//					 
//					 Iterator<Cell> celliterator = row.cellIterator();
//						
//						while(celliterator.hasNext()) {
//		  
//							  Cell cell = celliterator.next(); 
//							  final DataFormatter formatter = new DataFormatter(); 
//							  
//							  basic_input.add(formatter.formatCellValue(cell)); //throw new
//							   
//						}
//					 
//				// }
//				 
//				 
//				
//			}
//			
//			
//			try {
//				for(int i =0; i<basic_input.size();i++) {
//					
//					System.out.println(basic_input.get(i));
//				}
//				
//				urlfromexcel = basic_input.get(1);
//				user_name = basic_input.get(3);
//				password_login = basic_input.get(5);
//				s.url = basic_input.get(7);
//				
//				
//				
//				
//			} catch (Exception e) {
//
//				e.printStackTrace();
//				
//			}
//		
//
//			
//
//		
//
//		} catch (NoSuchElementException e) {
//			System.out.println("excel read error"+e.getStackTrace());
//		}
		
		
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
		
		System.setProperty("webdriver.chrome.driver",workingDir+"/seleniumjars/chromedriver.exe");
		
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
			// from the config file
		//String url = reusableComponents.getPropValues("PLURL");
		String url = urlfromexcel;
		browser.manage().deleteAllCookies();
		//browser.get(url);
	//	browser.navigate().to(url);

	ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Chrome Browser started", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Launch : Launching of Browser with Application "+url+" is Successful", browser ,pathLoc+"/"+TESTCASENAME , false );
//		System.out.println("Launch : Launching of Browser with Application "+url+" is Successful");
//		browser.manage().window().maximize();
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
	
			
		page.navigateToPLAllPage(threadID,tempResultList ,pathLoc)
		.excelread_initial(threadID, tempResultList, pathLoc)
	//	.Salesforce_login(threadID, tempResultList, pathLoc) //this is login page
	//	.validateTestC(threadID, tempResultList, pathLoc)  // excel read and multiple options
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
	
	
	// test case 2683
	
	@Test
	@Parameters({"platform" , "browserName" , "remoteurl"}) 
	public synchronized void validate_Test_2683(@Optional("opt platform") String platform ,@Optional("opt browser name") String browserName ,@Optional("opt remoteurl") String remoteurl) throws IOException, AWTException{
		

		
		
		TESTCASENAME = new Object(){}.getClass().getEnclosingMethod().getName();
		
		TESTCASENAME = "Test-2683";
		String strClassName = new Object(){}.getClass().getName();
		
		strClassName = "Financial Reports PL";
		String testMethod = strClassName+" - "+TESTCASENAME;
		String workingDir = System.getProperty("user.dir");
    
		
		int threadID = (int) (long) Thread.currentThread().getId();
		
		List<String> tempResultList = new ArrayList<String>();
			// from the config file
		//String url = reusableComponents.getPropValues("PLURL");
		String url = urlfromexcel;
		browser.manage().deleteAllCookies();
		//browser.get(url);
	//	browser.navigate().to(url);

	ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Chrome Browser started", browser ,pathLoc+"/"+TESTCASENAME , false );
		
		
		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Launch : Launching of Browser with Application "+url+" is Successful", browser ,pathLoc+"/"+TESTCASENAME , false );
//		System.out.println("Launch : Launching of Browser with Application "+url+" is Successful");
//		browser.manage().window().maximize();
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
	
			
		page.navigateToPLAllPage(threadID,tempResultList ,pathLoc)
		.excelread_initial_2683(threadID, tempResultList, pathLoc)
	//	.Salesforce_login(threadID, tempResultList, pathLoc) //this is login page
	//	.validateTestC(threadID, tempResultList, pathLoc)  // excel read and multiple options
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
	
	// test case 2684
	
		@Test
		@Parameters({"platform" , "browserName" , "remoteurl"}) 
		public synchronized void validate_Test_2684(@Optional("opt platform") String platform ,@Optional("opt browser name") String browserName ,@Optional("opt remoteurl") String remoteurl) throws IOException, AWTException{
			

			
			
			TESTCASENAME = new Object(){}.getClass().getEnclosingMethod().getName();
			
			TESTCASENAME = "Test-2683";
			String strClassName = new Object(){}.getClass().getName();
			
			strClassName = "Financial Reports PL";
			String testMethod = strClassName+" - "+TESTCASENAME;
			String workingDir = System.getProperty("user.dir");
	    
			
			int threadID = (int) (long) Thread.currentThread().getId();
			
			List<String> tempResultList = new ArrayList<String>();
				// from the config file
			//String url = reusableComponents.getPropValues("PLURL");
			String url = urlfromexcel;
			browser.manage().deleteAllCookies();
			//browser.get(url);
		//	browser.navigate().to(url);

		ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Chrome Browser started", browser ,pathLoc+"/"+TESTCASENAME , false );
			
			
			ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Launch : Launching of Browser with Application "+url+" is Successful", browser ,pathLoc+"/"+TESTCASENAME , false );
//			System.out.println("Launch : Launching of Browser with Application "+url+" is Successful");
//			browser.manage().window().maximize();
			//browser.manage().window().fullscreen();

			//Printing Id of the thread on using which test method got executed
//			System.out.println("Test Case  with Thread Id:- "+ Thread.currentThread().getId());
//			ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test Case with Thread Id:- "+ threadID, browser ,pathLoc+"/"+TESTCASENAME , false );
			
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
		
				
			page.navigateToPLAllPage(threadID,tempResultList ,pathLoc)
			.excelread_initial_2684(threadID, tempResultList, pathLoc)
		//	.Salesforce_login(threadID, tempResultList, pathLoc) //this is login page
		//	.validateTestC(threadID, tempResultList, pathLoc)  // excel read and multiple options
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
		
		// test case 2685
		
			@Test
			@Parameters({"platform" , "browserName" , "remoteurl"}) 
			public synchronized void validate_Test_2685(@Optional("opt platform") String platform ,@Optional("opt browser name") String browserName ,@Optional("opt remoteurl") String remoteurl) throws IOException, AWTException{
				

				
				
				TESTCASENAME = new Object(){}.getClass().getEnclosingMethod().getName();
				
				TESTCASENAME = "Test-2683";
				String strClassName = new Object(){}.getClass().getName();
				
				strClassName = "Financial Reports PL";
				String testMethod = strClassName+" - "+TESTCASENAME;
				String workingDir = System.getProperty("user.dir");
		    
				
				int threadID = (int) (long) Thread.currentThread().getId();
				
				List<String> tempResultList = new ArrayList<String>();
					// from the config file
				//String url = reusableComponents.getPropValues("PLURL");
				String url = urlfromexcel;
				browser.manage().deleteAllCookies();
				//browser.get(url);
			//	browser.navigate().to(url);

			ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Chrome Browser started", browser ,pathLoc+"/"+TESTCASENAME , false );
				
				
				ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Launch : Launching of Browser with Application "+url+" is Successful", browser ,pathLoc+"/"+TESTCASENAME , false );
//				System.out.println("Launch : Launching of Browser with Application "+url+" is Successful");
//				browser.manage().window().maximize();
				//browser.manage().window().fullscreen();

				//Printing Id of the thread on using which test method got executed
//				System.out.println("Test Case  with Thread Id:- "+ Thread.currentThread().getId());
//				ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test Case with Thread Id:- "+ threadID, browser ,pathLoc+"/"+TESTCASENAME , false );
				
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
			
					
				page.navigateToPLAllPage(threadID,tempResultList ,pathLoc)
				.excelread_initial_2685(threadID, tempResultList, pathLoc)
			//	.Salesforce_login(threadID, tempResultList, pathLoc) //this is login page
			//	.validateTestC(threadID, tempResultList, pathLoc)  // excel read and multiple options
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
	
			
			// test case 2685
			
				@Test
				@Parameters({"platform" , "browserName" , "remoteurl"}) 
				public synchronized void validate_Test_2686(@Optional("opt platform") String platform ,@Optional("opt browser name") String browserName ,@Optional("opt remoteurl") String remoteurl) throws IOException, AWTException{
					

					
					
					TESTCASENAME = new Object(){}.getClass().getEnclosingMethod().getName();
					
					TESTCASENAME = "Test-2686";
					String strClassName = new Object(){}.getClass().getName();
					
					strClassName = "Financial Reports PL";
					String testMethod = strClassName+" - "+TESTCASENAME;
					String workingDir = System.getProperty("user.dir");
			    
					
					int threadID = (int) (long) Thread.currentThread().getId();
					
					List<String> tempResultList = new ArrayList<String>();
						// from the config file
					//String url = reusableComponents.getPropValues("PLURL");
					String url = urlfromexcel;
					browser.manage().deleteAllCookies();
					//browser.get(url);
				//	browser.navigate().to(url);

				ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Chrome Browser started", browser ,pathLoc+"/"+TESTCASENAME , false );
					
					
					ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Launch : Launching of Browser with Application "+url+" is Successful", browser ,pathLoc+"/"+TESTCASENAME , false );
//					System.out.println("Launch : Launching of Browser with Application "+url+" is Successful");
//					browser.manage().window().maximize();
					//browser.manage().window().fullscreen();

					//Printing Id of the thread on using which test method got executed
//					System.out.println("Test Case  with Thread Id:- "+ Thread.currentThread().getId());
//					ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Test Case with Thread Id:- "+ threadID, browser ,pathLoc+"/"+TESTCASENAME , false );
					
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
				
						
					page.navigateToPLAllPage(threadID,tempResultList ,pathLoc)
					.excelread_initial_2686(threadID, tempResultList, pathLoc)
				//	.Salesforce_login(threadID, tempResultList, pathLoc) //this is login page
				//	.validateTestC(threadID, tempResultList, pathLoc)  // excel read and multiple options
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
		
				
	@AfterClass
	public void wrapUp() throws UnsupportedEncodingException, IOException{
		
		PrintStream console = System.out;
		

		report.endTest(logger);
		report.flush();
		ReusableComponents.wait(1000);
		
		System.out.println("failure count "+failcounter);	
		System.out.println("Wrap Up : Closing browser Session");
		browser.manage().deleteAllCookies();
		testclassname = new Object(){}.getClass().getName();
		
		System.setOut(console);
		//System.out.println("This also goes to the console");
		SendEmail.main(null);
		
if (failcounter != 0){
			
	
			
		}else{
			

		}
		browser.close();
		browser.quit();
		

		
	}
	

}
