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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





/**
 * Base class for all the pages.
 *
 */
public class PLAllPage extends DriverScript{
	protected WebDriver browser;
		
	ReusableComponents reusableComponents = new  ReusableComponents();
	/**
	 * Constructor for Page class 
	 * @param browser
	 * @param report
	 */
	protected PLAllPage(WebDriver browser) {
		this.browser=browser;		
		PageFactory.initElements(browser, this);
	
	}


public PLAllPage() {
	
	}


@FindBy(css = "#btn-explore79[href*='weather_portfolio']")
WebElement weather_strategy;

@FindBy(css = "a[class*='customize-portfolio']")
WebElement customizeportfolio;

@FindBy(xpath = "//a[contains(.,'Customise')]")
WebElement customizebutton;

@FindBy(xpath = "//a[contains(.,'Reset')]")
WebElement reset_btn_check;

@FindBy(xpath = "//div[@id='customise-portfolio']/div/div[@class='panel panel-default row portfolio-constituents']/div[@class='col-md-12']/div[3]/div[1]/div[1]/div[4]/div[1]/a[1]")
WebElement addstock_Btn;

@FindBy(xpath = "//div[@id='modal-1']//button[@type='button'][contains(text(),'Done')]")
WebElement done_btn;

@FindBy(xpath = "//div[@class='row constituent-row vertical-align']//div[@class='col-md-4']//a[@href='#'][contains(text(),'BT Group plc')]")
WebElement stockreverifypart;

@FindBy(xpath = "//input[contains(@data-isin,'SPY')]")
WebElement slider;

@FindBy(xpath = "//a[contains(.,'Rebalance')]")
WebElement rebalancebutton;

@FindBy(xpath = "//a[contains(.,'Invest Now')]")
WebElement investbutton;

@FindBy(xpath = "//span[contains(.,'SPDR S&P500 ETF Trust')]")
WebElement spdrvaluecheck;

@FindBy(xpath = "//div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[3]/span[1]")
WebElement updatedpercentagevalue;

@FindBy(xpath = "//div[@class='col-xs-8 no-padding'][contains(.,'International Equity')]")
WebElement scrollto_value;

@FindBy(xpath = "//div[@class='row constituent-row vertical-align']//div[@class='col-md-4']//a[@href='#'][contains(text(),'HEALTH CARE SELECT SECTOR')]")
WebElement scrollto_value_another;

// for accounting seed test cases

@FindBy(xpath = "//input[@id='username']")
WebElement login_user_field;

@FindBy(xpath = "//input[@id='password']")
WebElement login_pass_field;

@FindBy(xpath = "//input[@id='Login']")
WebElement login_btn;

//span[normalize-space()='Opportunities']
@FindBy(xpath = "//a[@title='Opportunities']")
WebElement opportunities_click;

@FindBy(xpath = "//div[contains(text(),'New')]")
WebElement New_opp_btn;

//div[@class='uiInput uiInputDate uiInput--default uiInput--input uiInput--datetime']//div[@class='form-element']/input[@data-proxy-id='aura-pos-lib-4']
@FindBy(xpath = "//div[@class='form-element']/input[@type='text']")
WebElement date_field;

@FindBy(xpath = "//div[@class='slds-form-element__control']/div[1]/input[@class=' input'][@aria-required='true']")
WebElement opportunity_enter;

@FindBy(xpath = "//a[contains(@aria-required,'true')]")
WebElement stage_enter;

//@FindBy(xpath = "//a[normalize-space()='Qualification']")
@FindBy(xpath = "//a[@title='Qualification']")
WebElement select_stage;

@FindBy(xpath = "//button[contains(@title,'Save')]//span[contains(@class,'label bBody')][normalize-space()='Save']")
WebElement save_btn;
	
@FindBy(xpath = "//table[@class='detailList']//div[@class='requiredInput']//span[@class='lookupInput']/a/img")
WebElement btn_img;

@FindBy(xpath = "//table[@class='detailList']//div[@class='requiredInput']//span[@class='lookupInput']/input")//input[@maxlength='255']
//@FindBy(xpath = "//table[@class='detailList']//td[@class='dataCol first']/div/span")//input[@maxlength='255']
WebElement first_input;

//@FindBy(xpath = "//table[@class='detailList']//td[@class='dataCol']/div/span/input")
@FindBy(xpath = "//table[@class='detailList']//td[@class='dataCol ']//div[@class='requiredInput']//span[@class='lookupInput']/input")
WebElement second_input;

//@FindBy(xpath = "//div[@class='pbBottomButtons']//table//td//span/input")
//@FindBy(xpath = "//div[@class='pbBottomButtons']//span/input[@class='btn']")
@FindBy(xpath = "//form[@id='thePage:theForm1']//div//div//div//div[@class='pbHeader']//table//tbody//tr//td[2]/input")
WebElement btn_run_click;

@FindBy(xpath = "//img[@title=' Financial Reports']")
WebElement fin_reports;

@FindBy(xpath = "//c-lookup[@data-jest='startingAccountingPeriod']//div[@class='slds-form-element']//div[@class='slds-form-element__control']//button")
//@FindBy(xpath = "//c-lookup[@data-jest='startingAccountingPeriod']//div[@class='slds-form-element']//div[@class='slds-form-element__control']//input[@role='textbox']")
WebElement new_start_time_btn;

@FindBy(xpath = "//c-lookup[@data-jest='startingAccountingPeriod']//div[@class='slds-form-element']//div[@class='slds-form-element__control']//input")
WebElement new_start_time_input;

@FindBy(xpath = "//c-lookup[@data-jest='endingAccountingPeriod']//div[@class='slds-form-element']//div[@class='slds-form-element__control']//button")
//@FindBy(xpath = "//c-lookup[@data-jest='endingAccountingPeriod']//div[@class='slds-form-element']//div[@class='slds-form-element__control']//input[@role='textbox']")
WebElement new_end_time_btn;

@FindBy(xpath = "//c-lookup[@data-jest='endingAccountingPeriod']//div[@class='slds-form-element']//div[@class='slds-form-element__control']//input")
WebElement new_end_time_input;

@FindBy(xpath = "//lightning-input[@data-jest='suppressZeroAmountRows']//label[@class='slds-checkbox__label']/span[1]")
WebElement check_suppressZeroAmountRows;

@FindBy(xpath = "//lightning-input[@data-jest='includeSubType1']//label[@class='slds-checkbox__label']/span[1]")
WebElement check_subtype1;

@FindBy(xpath = "//button[contains(text(),'Run')]")
WebElement new_click_btn_run;

@FindBy(xpath = "//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='2020-07']/span[2]/span")
WebElement dropdown;

@FindBy(xpath = "//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='2021-06']/span[2]/span")
WebElement dropdown1;

@FindBy(xpath = "//table//tbody//tr[1]//th//div[1]//a")
WebElement reportname;

@FindBy(xpath = "//table//tbody//tr[1]//td[1]//span[1]//span[1]")
WebElement report_select;

@FindBy(xpath = "//button[contains(text(),'Delete Reports')]")
WebElement delete_reports;

@FindBy(xpath = "//button[contains(text(),'Yes')]")
WebElement confirm_delete;

@FindBy(xpath = "//button[contains(text(),'Delete Reports')]")
WebElement nav_clicker;

@FindBy(xpath = "//input[@id='lksrch']")
WebElement frame_search;

@FindBy(xpath = "//body/form[@id='theForm']/div[1]/div[2]/input[2]")
WebElement frame_go;

@FindBy(xpath = "//a[contains(text(),'2020-06')]")
//@FindBy(xpath = "//a[contains(text(),'2020-06')]")
WebElement frame_select;

ArrayList<String> startdate_arr= new ArrayList<String>();
ArrayList<String> enddate_arr= new ArrayList<String>();
ArrayList<String> basic_input= new ArrayList<String>();

Boolean supressrows = false;
String ignore_supressrows = null, ignore_subtype1 = null;
String username = null, pass_login = null;
String urlfromexcel=null;

SendEmail s = new SendEmail();



	/*** Test case Method Name : validateTestA
	 * 	 Functionality         : validate login to Accounting seed salesforce - Login_Salesforce
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage Salesforce_login(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		//testcasemethod = "Login Method Salesforce";
		testcasemethod = testcasemethod + " - functionality";
		
	try{
		
		
		//browser.switchTo().defaultContent();
		// pass from class file
	//	username = reusableComponents.getPropValues("username");
	//	pass_login = reusableComponents.getPropValues("password");
		
		//username = PC.user_name;
		//pass_login = PC.password_login;
		
		ReusableComponents.wait(2300);
		
		if(ReusableComponents.isElementPresent(login_user_field)){
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "salesforce login field is identified, inserting username dynamically", browser ,pathLoc+"/"+testcasemethod , false );
			ReusableComponents.wait(1200);			
			login_user_field.sendKeys(username);
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "salesforce login username entered successfully", browser ,pathLoc+"/"+testcasemethod , false );
			
			if(ReusableComponents.isElementPresent(login_pass_field)){
				
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "salesforce password is identified, inserting password dynamically", browser ,pathLoc+"/"+testcasemethod , false );
				login_pass_field.sendKeys(pass_login);				
				ReusableComponents.wait(1200);
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "salesforce password is entered successfully", browser ,pathLoc+"/"+testcasemethod , false );
				
				if(ReusableComponents.isElementPresent(login_btn)){
					
					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Login Button is identified", browser ,pathLoc+"/"+testcasemethod , false );
					ReusableComponents.wait(1200);
					login_btn.click();
					ReusableComponents.wait(15500);
					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "salesforce login button is clicked", browser ,pathLoc+"/"+testcasemethod , false );
					
				}else{
					ReusableComponents.reportFail( threadID , tempList , testcasemethod , "salesforce login button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
				}
				
			}else{
				ReusableComponents.reportFail( threadID , tempList , testcasemethod , " salesforce password field is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
			}
						
		}else{
			ReusableComponents.reportFail( threadID , tempList , testcasemethod , "salesforce login field is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
		}
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}

	
	/*** Test case Method Name : Validate_fin_reports_page
	 * 	 Functionality         : validate navigation to financial reports page
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage Validate_fin_reports_page(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		//testcasemethod = "Login Method Salesforce";
		testcasemethod = testcasemethod + " - functionality";
		
	try{
		
		browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
		  ReusableComponents.wait(8200);
		  
		  List<WebElement> f = browser.findElements(By.tagName("frame"));
          int i = f.size();
          System.out.println(i + "is the frame count");

          browser.switchTo().frame(0);

          ReusableComponents.wait(5200);
		
		
		
		if(ReusableComponents.isElementPresent(fin_reports)){
			
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "financial reports field is identified", browser ,pathLoc+"/"+testcasemethod , false );
			ReusableComponents.wait(1200);
			fin_reports.click();
			ReusableComponents.wait(10500);
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "financial reports link is clicked", browser ,pathLoc+"/"+testcasemethod , false );
			
		}else{
			ReusableComponents.reportFail( threadID , tempList , testcasemethod , "financial reports field is NOT present", browser ,pathLoc+"/"+testcasemethod , true );
		}
		
		ReusableComponents.wait(2300);
		
		browser.switchTo().defaultContent();
		
		ReusableComponents.wait(2300);		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}

	
	/*** Test case Method Name : validateTestA
	 * 	 Functionality         : validate login to Accounting seed salesforce - Login_Salesforce
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage Navigation_page(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "Financial Reports";
		testcasemethod = testcasemethod + " - functionality";
		
	try{
		
		ReusableComponents.wait(2300);
		String url = reusableComponents.getPropValues("PLURL");
		browser.navigate().to(url);
		ReusableComponents.wait(12300);
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}

	/*** Test case Method Name : validateTestC
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage validateTestC(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		
		String startdate = null, enddate = null, equalsvalueof = null;
		Boolean isselected = false;
		
		//the excel input value should be supplied to start date and end date
		
		try {

			String filename = reusableComponents.getPropValues("Financialreportsinput");
			String sheetname = reusableComponents.getPropValues("TC1");
			
			//String outfilename = reusableComponents.getPropValues("outputfilename");
			//String outsheetname = reusableComponents.getPropValues("outputsheetname");

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
			System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);

			// read rows and columns
			
			Iterator<Row> itr = workbooksheet.iterator();
			
			while(itr.hasNext()) {
				Row row = itr.next();
				 if(row.getRowNum()==0 ){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				 
				 if(row.getRowNum() ==1) {
					 continue;
				 }
				
				
				 if(row.getRowNum() == 2) {
					 
					 Iterator<Cell> celliterator = row.cellIterator();
						
						while(celliterator.hasNext()) {
		  
							  Cell cell = celliterator.next(); 
							  final DataFormatter formatter = new DataFormatter(); 
							  
							  startdate_arr.add(formatter.formatCellValue(cell)); 
							   
						}
					 
				 }
				 
				 
				
			}
		

			

		

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}
		
		
		
		try {
			for(int i =0; i<startdate_arr.size();i++) {
				
				System.out.println(startdate_arr.get(i));
			}
			
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Reading Excel input sheet, successful", browser ,pathLoc+"/"+testcasemethod , false );
			startdate = startdate_arr.get(2);
			enddate = startdate_arr.get(3);
			equalsvalueof = startdate_arr.get(4);
			if(equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
				supressrows = Boolean.valueOf(equalsvalueof);
				ignore_supressrows = "false";
			}else if(equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ") || equalsvalueof.equalsIgnoreCase("")) {
				ignore_supressrows = "true";
			}
			
			else {
				
				ignore_supressrows = "true";
			}
			
			ReusableComponents.wait(5200);
			
			System.out.println("start date "+startdate+" and end date "+enddate+ " equals true or false value is "+equalsvalueof);
		} catch (Exception e) {

			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"printing excel elements are incomplete", browser ,pathLoc+"/"+testcasemethod , true );
		}
		
		
		
		
		//till here
		
//		startdate = reusableComponents.getPropValues("startvalue","plconfig");
//		enddate = reusableComponents.getPropValues("endvalue", "plconfig");
		
		ReusableComponents.wait(5200);
	
		try {
			if(ReusableComponents.isElementPresent(new_start_time_btn)){
				  ReusableComponents.wait(1200);
				  
				  //System.out.println(" clear selection");
				  
				  
				  new_start_time_btn.click();
				  
				  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time btn is present and clearing selected start range", browser ,pathLoc+"/"+testcasemethod , false );
				  
				//  System.out.println("btn clear");
				  ReusableComponents.wait(3200);
				  
				  if(ReusableComponents.isElementPresent(new_start_time_input)){
					  ReusableComponents.wait(1200);
					  
				//	  System.out.println(" input selection");
					  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time start range is clicked", browser ,pathLoc+"/"+testcasemethod , false );
					  new_start_time_input.click();
					  
				//	  System.out.println("btn clear");
					  ReusableComponents.wait(3200);
					  
					  new_start_time_input.sendKeys(startdate);

				//	  System.out.println("aft date");
					  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time btn is entered", browser ,pathLoc+"/"+testcasemethod , false );
					  
					  ReusableComponents.wait(3200);
					  
					  WebElement dyn_dropdown = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+startdate+"']/span[2]/span"));
					  
					  if(ReusableComponents.isElementPresent(dyn_dropdown)) { //dropdown
						  
						  ReusableComponents.wait(1200);
						  dyn_dropdown.click();
						  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "start range value selected", browser ,pathLoc+"/"+testcasemethod , false );
						  
						  
						  
					// push end date code here
						  

							try {
								if(ReusableComponents.isElementPresent(new_end_time_btn)){
									  ReusableComponents.wait(1200);
									  
									 // System.out.println(" clear selection end");
									  
									  new_end_time_btn.click();
									  
									  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "End time btn is present and clearing selected end range", browser ,pathLoc+"/"+testcasemethod , false );
									  
									//  System.out.println("btn clear end");
									  ReusableComponents.wait(3200);
									  
									  if(ReusableComponents.isElementPresent(new_end_time_input)){
										  ReusableComponents.wait(1200);
										  
										//  System.out.println(" input selection end");
										  
										  new_end_time_input.click();
										  
										//  System.out.println("btn clear end");
										  ReusableComponents.wait(3200);
										  
										  new_end_time_input.sendKeys(enddate);
										  
										  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "End time entered", browser ,pathLoc+"/"+testcasemethod , false );

										  System.out.println("aft date");
										  
										  ReusableComponents.wait(3200);
										  
										  WebElement dyn_dropdown1 = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+enddate+"']/span[2]/span[1]"));
										  
										  if(ReusableComponents.isElementPresent(dyn_dropdown1)) { //dropdown1
											  
											  ReusableComponents.wait(1200);
											  dyn_dropdown1.click();
											  
											  
											  // push other buttons here
											  
											  /* after clicking the end date, need to check if the check box is already selected or not
											   * if not then based on the test case we need to select it
											   * else need to unselect it
											   * 
											   * add a case for NA
											   */
											  
											  
											  
											  try {
												if(ignore_supressrows.equalsIgnoreCase("true")) {
													  
													  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows not applicable", browser ,pathLoc+"/"+testcasemethod , false );
												  }else {
													  
													  // supress rows selection
													  
													  if(ReusableComponents.isElementPresent(check_suppressZeroAmountRows)) {
														  
														  String checked_call = check_suppressZeroAmountRows.getText();
														  
														  System.out.println("return value is "+checked_call);
														  
														  checked_call = checked_call.replaceAll("[^a-zA-Z]", "");  
														  
														  System.out.println("post regex value is "+checked_call);
														  
														  if(checked_call.equalsIgnoreCase("after")) {
															  isselected = true;
														  }else {
															  isselected = false;
														  }
														  
															//isselected = check_suppressZeroAmountRows.isSelected();
															
														  isselected = true; // default value is selected
															System.out.println("value of is selected"+isselected);
															
															if (supressrows == true && isselected == true) {
																// message - already as per requirement
																ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows already matching", browser ,pathLoc+"/"+testcasemethod , false );
															}
															if(supressrows == false && isselected == true) {
																
																check_suppressZeroAmountRows.click();
																ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows un checked now ", browser ,pathLoc+"/"+testcasemethod , false );
															}
															  
															if (supressrows == true && isselected == false) {
																check_suppressZeroAmountRows.click();
																ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows checked now ", browser ,pathLoc+"/"+testcasemethod , false );
															}
															if(supressrows == false && isselected == false) {
																ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows already matching", browser ,pathLoc+"/"+testcasemethod , false );
																//no action, message
															}
															  
														  }else {
															  
															  System.out.println("run btn not present");
															  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," supress rows is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
														  }
													  
													  
													  
												  }
											} catch (Exception e) {
												
												e.printStackTrace();
												ReusableComponents.reportFail( threadID , tempList , testcasemethod ," supress rows is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
											  
											  
											  
											  
											  
											  
											  
										//	  Select dropdown1 = new Select(dropdown);
//											  
//											  dropdown1.selectByVisibleText("2020-06");
											  
											  try {
												ReusableComponents.wait(3200);
												  
												  if(ReusableComponents.isElementPresent(new_click_btn_run)) {
													  
													  ReusableComponents.wait(1200);
													  new_click_btn_run.click();
													  ReusableComponents.wait(2200);
													  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+" report generation", browser, pathLoc+"/"+testcasemethod, true);
													  
													  
												  }else {
													  
													  System.out.println("run btn not present");
													  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report generation is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
												  }
												  
												//  ReusableComponents.wait(5200);
												  
												  ReusableComponents.wait(4200);
												  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+"report generation", browser, pathLoc+"/"+testcasemethod, true);
											} catch (Exception e) {
												
												e.printStackTrace();
												 ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report generation is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
											  
											  
											  try {
												ReusableComponents.wait(15200);
												  
//											  browser.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
//											  ReusableComponents.wait(3200);
									//
//												browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_UP);
//												ReusableComponents.wait(3200);
//												browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_UP);
//												ReusableComponents.wait(3200);
												  
												  browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
												  ReusableComponents.wait(13200);
													
//												((JavascriptExecutor) browser)
//												.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//												
//												 ReusableComponents.wait(5200);
//												
//												JavascriptExecutor js = (JavascriptExecutor) browser;
//												   js.executeScript("window.scrollBy(document.body.scrollHeight,0)");
													
													
												  
												  // this test is to see the generated report and click it, validate and return back
												  // which is not feasible in environments used by all as the records will be more
												  // and the time taken by the reports will need too much wait
												  
												  
												 // commenting the report click alone just reading the report name
												  
													if(ReusableComponents.isElementPresent(reportname)) {
														  
														  ReusableComponents.wait(1200);
														  
														 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report name is "+reportname.getText().toUpperCase()+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
														  ReusableComponents.wait(1200);
														  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+" report name is " +reportname.getText().toUpperCase() +" and link for report "+reportname.getAttribute("href")+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
														  
														 // validateTestD(threadID, tempList, pathLoc);
														  
														  
														  
													  }else {
														  
														  //System.out.println("report not present");
														  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report name is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
													  }
											} catch (Exception e) {
												
												e.printStackTrace();
												ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report name is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
												
												
											
											  
											  
										  }else {
											  
											//  System.out.println("dropdown not present");
											  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is selection is not present", browser ,pathLoc+"/"+testcasemethod , true );
										  }
										 
//									  
										 
										  
										//  System.out.println("aft drop click");
										  
										  
											
										  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
										 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
										  }
										  else
										  { 
											  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is not present", browser ,pathLoc+"/"+testcasemethod , true ); 
										  }
									  
									  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
									 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
									  }
									  else
									  { 
										  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is not present", browser ,pathLoc+"/"+testcasemethod , true ); 
									  }
							} catch (Exception e) {
								
								e.printStackTrace();
								ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time button is not present", browser ,pathLoc+"/"+testcasemethod , true );
							}
							
						  
						  
						  
					  }else {
						  
						  //System.out.println("dropdown not present");
						  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"dropdown value is not selected - start date", browser ,pathLoc+"/"+testcasemethod , true );
					  }
					 		  
					 // System.out.println("aft drop click");
					  
				
					  
					  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
					 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
					  }
					  else
					  { 
						  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present", browser ,pathLoc+"/"+testcasemethod , true ); 
					  }
				  
				  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
				 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
				  }
				  else
				  { 
					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true ); 
				  }
		} catch (Exception e) {
			
			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
			
		}
		
	
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}

	

	/*** Test case Method Name : validateTest2677
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage validateTest2677(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		
		String startdate = null, enddate = null, equalsvalueof = null;
		Boolean isselected = false;
		
		//the excel input value should be supplied to start date and end date
		
		try {

			String filename = reusableComponents.getPropValues("Financialreportsinput");
			String sheetname = reusableComponents.getPropValues("TC2");
			
			//String outfilename = reusableComponents.getPropValues("outputfilename");
			//String outsheetname = reusableComponents.getPropValues("outputsheetname");

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
			System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);

			// read rows and columns
			
			Iterator<Row> itr = workbooksheet.iterator();
			
			while(itr.hasNext()) {
				Row row = itr.next();
				 if(row.getRowNum()==0 ){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				 
				 if(row.getRowNum() ==1) {
					 continue;
				 }
				
				
				 if(row.getRowNum() == 2) {
					 
					 Iterator<Cell> celliterator = row.cellIterator();
						
						while(celliterator.hasNext()) {
		  
							  Cell cell = celliterator.next(); 
							  final DataFormatter formatter = new DataFormatter(); 
							  
							  startdate_arr.add(formatter.formatCellValue(cell)); //throw new
							   
						}
					 
				 }
				 
				 
				
			}
		

			

		

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}
		
		
		
		try {
			for(int i =0; i<startdate_arr.size();i++) {
				
				System.out.println(startdate_arr.get(i));
			}
			
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Reading Excel input sheet, successful", browser ,pathLoc+"/"+testcasemethod , false );
			startdate = startdate_arr.get(2);
			enddate = startdate_arr.get(3);
			equalsvalueof = startdate_arr.get(4);
			if(equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
				supressrows = Boolean.valueOf(equalsvalueof);
				ignore_supressrows = "false";
			}else if(equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ") || equalsvalueof.equalsIgnoreCase("")) {
				ignore_supressrows = "true";
			}
			
			else {
				
				ignore_supressrows = "true";
			}
			
			ReusableComponents.wait(5200);
			
			System.out.println("start date "+startdate+" and end date "+enddate+ " equals true or false value is "+equalsvalueof);
		} catch (Exception e) {
			
			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"printing excel elements are incomplete", browser ,pathLoc+"/"+testcasemethod , true );
		}
		
		
		
		
		//till here
		
//		startdate = reusableComponents.getPropValues("startvalue","plconfig");
//		enddate = reusableComponents.getPropValues("endvalue", "plconfig");
		
		ReusableComponents.wait(5200);
	
		try {
			if(ReusableComponents.isElementPresent(new_start_time_btn)){
				  ReusableComponents.wait(1200);
				  
				  //System.out.println(" clear selection");
				  
				  
				  new_start_time_btn.click();
				  
				  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time btn is present and clearing selected start range", browser ,pathLoc+"/"+testcasemethod , false );
				  
				//  System.out.println("btn clear");
				  ReusableComponents.wait(3200);
				  
				  if(ReusableComponents.isElementPresent(new_start_time_input)){
					  ReusableComponents.wait(1200);
					  
				//	  System.out.println(" input selection");
					  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time start range is clicked", browser ,pathLoc+"/"+testcasemethod , false );
					  new_start_time_input.click();
					  
				//	  System.out.println("btn clear");
					  ReusableComponents.wait(3200);
					  
					  new_start_time_input.sendKeys(startdate);

				//	  System.out.println("aft date");
					  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time btn is entered", browser ,pathLoc+"/"+testcasemethod , false );
					  
					  ReusableComponents.wait(3200);
					  
					  WebElement dyn_dropdown = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+startdate+"']/span[2]/span"));
					  
					  if(ReusableComponents.isElementPresent(dyn_dropdown)) { //dropdown
						  
						  ReusableComponents.wait(1200);
						  dyn_dropdown.click();
						  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "start range value selected", browser ,pathLoc+"/"+testcasemethod , false );
						  
						  
						  
					// push end date code here
						  

							try {
								if(ReusableComponents.isElementPresent(new_end_time_btn)){
									  ReusableComponents.wait(1200);
									  
									 // System.out.println(" clear selection end");
									  
									  new_end_time_btn.click();
									  
									  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "End time btn is present and clearing selected end range", browser ,pathLoc+"/"+testcasemethod , false );
									  
									//  System.out.println("btn clear end");
									  ReusableComponents.wait(3200);
									  
									  if(ReusableComponents.isElementPresent(new_end_time_input)){
										  ReusableComponents.wait(1200);
										  
										//  System.out.println(" input selection end");
										  
										  new_end_time_input.click();
										  
										//  System.out.println("btn clear end");
										  ReusableComponents.wait(3200);
										  
										  new_end_time_input.sendKeys(enddate);
										  
										  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "End time entered", browser ,pathLoc+"/"+testcasemethod , false );

										  System.out.println("aft date");
										  
										  ReusableComponents.wait(3200);
										  
										  WebElement dyn_dropdown1 = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+enddate+"']/span[2]/span[1]"));
										  
										  if(ReusableComponents.isElementPresent(dyn_dropdown1)) { //dropdown1
											  
											  ReusableComponents.wait(1200);
											  dyn_dropdown1.click();
											  
											  
											  // push other buttons here
											  
											  /* after clicking the end date, need to check if the check box is already selected or not
											   * if not then based on the test case we need to select it
											   * else need to unselect it
											   * 
											   * add a case for NA
											   */
											  
											  
											  
											  try {
												if(ignore_supressrows.equalsIgnoreCase("true")) {
													  
													  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows not applicable", browser ,pathLoc+"/"+testcasemethod , false );
												  }else {
													  
													  // supress rows selection
													  
													  if(ReusableComponents.isElementPresent(check_suppressZeroAmountRows)) {
														  
														  String checked_call = check_suppressZeroAmountRows.getText();
														  
														  System.out.println("return value is "+checked_call);
														  
														  checked_call = checked_call.replaceAll("[^a-zA-Z]", "");  
														  
														  System.out.println("post regex value is "+checked_call);
														  
														  if(checked_call.equalsIgnoreCase("after")) {
															  isselected = true;
														  }else {
															  isselected = false;
														  }
														  
															//isselected = check_suppressZeroAmountRows.isSelected();
															
														  isselected = true; // default value is selected
															System.out.println("value of is selected"+isselected);
															
															if (supressrows == true && isselected == true) {
																// message - already as per requirement
																ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows already matching", browser ,pathLoc+"/"+testcasemethod , false );
															}
															if(supressrows == false && isselected == true) {
																
																check_suppressZeroAmountRows.click();
																ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows un checked now ", browser ,pathLoc+"/"+testcasemethod , false );
															}
															  
															if (supressrows == true && isselected == false) {
																check_suppressZeroAmountRows.click();
																ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows checked now ", browser ,pathLoc+"/"+testcasemethod , false );
															}
															if(supressrows == false && isselected == false) {
																ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows already matching", browser ,pathLoc+"/"+testcasemethod , false );
																//no action, message
															}
															  
														  }else {
															  
															  System.out.println("run btn not present");
															  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," supress rows is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
														  }
													  
													  
													  
												  }
											} catch (Exception e) {
											
												e.printStackTrace();
												ReusableComponents.reportFail( threadID , tempList , testcasemethod ," supress rows is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
											  
											  
											  
											  
											  
											  
											  
										//	  Select dropdown1 = new Select(dropdown);
//											  
//											  dropdown1.selectByVisibleText("2020-06");
											  
											  try {
												ReusableComponents.wait(3200);
												  
												  if(ReusableComponents.isElementPresent(new_click_btn_run)) {
													  
													  ReusableComponents.wait(1200);
													  new_click_btn_run.click();
													  ReusableComponents.wait(2200);
													  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+" report generation", browser, pathLoc+"/"+testcasemethod, true);
													  
													  
												  }else {
													  
													  System.out.println("run btn not present");
													  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report generation is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
												  }
												  
												//  ReusableComponents.wait(5200);
												  
												  ReusableComponents.wait(4200);
												  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+"report generation", browser, pathLoc+"/"+testcasemethod, true);
											} catch (Exception e) {
												
												e.printStackTrace();
												 ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report generation is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
											  
											  
											  try {
												ReusableComponents.wait(15200);
												  
//											  browser.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
//											  ReusableComponents.wait(3200);
									//
//												browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_UP);
//												ReusableComponents.wait(3200);
//												browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_UP);
//												ReusableComponents.wait(3200);
												  
												  browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
												  ReusableComponents.wait(13200);
													
//												((JavascriptExecutor) browser)
//												.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//												
//												 ReusableComponents.wait(5200);
//												
//												JavascriptExecutor js = (JavascriptExecutor) browser;
//												   js.executeScript("window.scrollBy(document.body.scrollHeight,0)");
													
													
												  
												  // this test is to see the generated report and click it, validate and return back
												  // which is not feasible in environments used by all as the records will be more
												  // and the time taken by the reports will need too much wait
												  
												  
												 // commenting the report click alone just reading the report name
												  
													if(ReusableComponents.isElementPresent(reportname)) {
														  
														  ReusableComponents.wait(1200);
														  
														 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report name is "+reportname.getText().toUpperCase()+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
														  ReusableComponents.wait(1200);
														  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+" report name is " +reportname.getText().toUpperCase() +" and link for report "+reportname.getAttribute("href")+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
														  
														 // validateTestD(threadID, tempList, pathLoc);
														  
														  
														  
													  }else {
														  
														  //System.out.println("report not present");
														  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report name is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
													  }
											} catch (Exception e) {
												
												e.printStackTrace();
												ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report name is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
												
												
											
											  
											  
										  }else {
											  
											//  System.out.println("dropdown not present");
											  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is selection is not present", browser ,pathLoc+"/"+testcasemethod , true );
										  }
										 
//									  
										 
										  
										//  System.out.println("aft drop click");
										  
										  
											
										  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
										 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
										  }
										  else
										  { 
											  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is not present", browser ,pathLoc+"/"+testcasemethod , true ); 
										  }
									  
									  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
									 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
									  }
									  else
									  { 
										  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is not present", browser ,pathLoc+"/"+testcasemethod , true ); 
									  }
							} catch (Exception e) {
								
								e.printStackTrace();
								ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time button is not present", browser ,pathLoc+"/"+testcasemethod , true );
							}
							
						  
						  
						  
					  }else {
						  
						  //System.out.println("dropdown not present");
						  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"dropdown value is not selected - start date", browser ,pathLoc+"/"+testcasemethod , true );
					  }
					 		  
					 // System.out.println("aft drop click");
					  
				
					  
					  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
					 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
					  }
					  else
					  { 
						  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present", browser ,pathLoc+"/"+testcasemethod , true ); 
					  }
				  
				  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
				 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
				  }
				  else
				  { 
					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true ); 
				  }
		} catch (Exception e) {
			
			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
			
		}
	
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}
	
	/*** Test case Method Name : validateTest2683
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage validate_Test_2683(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		
		String startdate = null, enddate = null, equalsvalueof = null, equalssubtype = null;
		Boolean isselected = false;
		
		//the excel input value should be supplied to start date and end date
		
		try {

			String filename = reusableComponents.getPropValues("Financialreportsinput");
			String sheetname = reusableComponents.getPropValues("TC8");
			
			//String outfilename = reusableComponents.getPropValues("outputfilename");
			//String outsheetname = reusableComponents.getPropValues("outputsheetname");

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
			System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);

			// read rows and columns
			
			Iterator<Row> itr = workbooksheet.iterator();
			
			while(itr.hasNext()) {
				Row row = itr.next();
				 if(row.getRowNum()==0 ){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				 
				 if(row.getRowNum() ==1) {
					 continue;
				 }
				
				
				 if(row.getRowNum() == 2) {
					 
					 Iterator<Cell> celliterator = row.cellIterator();
						
						while(celliterator.hasNext()) {
		  
							  Cell cell = celliterator.next(); 
							  final DataFormatter formatter = new DataFormatter(); 
							  
							  startdate_arr.add(formatter.formatCellValue(cell)); 
							   
						}
					 
				 }
				 
				 
				
			}
		

			

		

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}
		
		
		
		try {
			for(int i =0; i<startdate_arr.size();i++) {
				
				System.out.println(startdate_arr.get(i));
			}
			
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Reading Excel input sheet, successful", browser ,pathLoc+"/"+testcasemethod , false );
			startdate = startdate_arr.get(2);
			enddate = startdate_arr.get(3);
			equalsvalueof = startdate_arr.get(4);
			equalssubtype = startdate_arr.get(5);
			
			if(equalsvalueof.equalsIgnoreCase("true") || equalsvalueof.equalsIgnoreCase("false")) {
				supressrows = Boolean.valueOf(equalsvalueof);
				ignore_supressrows = "false";
			}else if(equalsvalueof == null || equalsvalueof.equalsIgnoreCase(" ") || equalsvalueof.equalsIgnoreCase("")) {
				ignore_supressrows = "true";
			}else {
				
				ignore_supressrows = "true";
			}
			
			if(equalssubtype.equalsIgnoreCase("true") || equalssubtype.equalsIgnoreCase("false")) {
				supressrows = Boolean.valueOf(equalssubtype);
				ignore_subtype1 = "false";
			}else if(equalssubtype == null || equalssubtype.equalsIgnoreCase(" ") || equalssubtype.equalsIgnoreCase("")) {
				ignore_subtype1 = "true";
			}else {
				
				ignore_subtype1 = "true";
			}
			
			ReusableComponents.wait(5200);
			
			System.out.println("start date "+startdate+" and end date "+enddate+ " equals true or false value is "+equalsvalueof);
		} catch (Exception e) {

			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"printing excel elements are incomplete", browser ,pathLoc+"/"+testcasemethod , true );
		}
		
		
		
		
		//till here
		
//		startdate = reusableComponents.getPropValues("startvalue","plconfig");
//		enddate = reusableComponents.getPropValues("endvalue", "plconfig");
		
		ReusableComponents.wait(5200);
	
		try {
			if(ReusableComponents.isElementPresent(new_start_time_btn)){
				  ReusableComponents.wait(1200);
				  
				  //System.out.println(" clear selection");
				  
				  
				  new_start_time_btn.click();
				  
				  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time btn is present and clearing selected start range", browser ,pathLoc+"/"+testcasemethod , false );
				  
				//  System.out.println("btn clear");
				  ReusableComponents.wait(3200);
				  
				  if(ReusableComponents.isElementPresent(new_start_time_input)){
					  ReusableComponents.wait(1200);
					  
				//	  System.out.println(" input selection");
					  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time start range is clicked", browser ,pathLoc+"/"+testcasemethod , false );
					  new_start_time_input.click();
					  
				//	  System.out.println("btn clear");
					  ReusableComponents.wait(3200);
					  
					  new_start_time_input.sendKeys(startdate);

				//	  System.out.println("aft date");
					  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time btn is entered", browser ,pathLoc+"/"+testcasemethod , false );
					  
					  ReusableComponents.wait(3200);
					  
					  WebElement dyn_dropdown = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+startdate+"']/span[2]/span"));
					  
					  if(ReusableComponents.isElementPresent(dyn_dropdown)) { //dropdown
						  
						  ReusableComponents.wait(1200);
						  dyn_dropdown.click();
						  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "start range value selected", browser ,pathLoc+"/"+testcasemethod , false );
						  
						  
						  
					// push end date code here
						  

							try {
								if(ReusableComponents.isElementPresent(new_end_time_btn)){
									  ReusableComponents.wait(1200);
									  
									 // System.out.println(" clear selection end");
									  
									  new_end_time_btn.click();
									  
									  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "End time btn is present and clearing selected end range", browser ,pathLoc+"/"+testcasemethod , false );
									  
									//  System.out.println("btn clear end");
									  ReusableComponents.wait(3200);
									  
									  if(ReusableComponents.isElementPresent(new_end_time_input)){
										  ReusableComponents.wait(1200);
										  
										//  System.out.println(" input selection end");
										  
										  new_end_time_input.click();
										  
										//  System.out.println("btn clear end");
										  ReusableComponents.wait(3200);
										  
										  new_end_time_input.sendKeys(enddate);
										  
										  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "End time entered", browser ,pathLoc+"/"+testcasemethod , false );

										  System.out.println("aft date");
										  
										  ReusableComponents.wait(3200);
										  
										  WebElement dyn_dropdown1 = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+enddate+"']/span[2]/span[1]"));
										  
										  if(ReusableComponents.isElementPresent(dyn_dropdown1)) { //dropdown1
											  
											  ReusableComponents.wait(1200);
											  dyn_dropdown1.click();
											  
											  // check if sub type 1 is selected or not
											  
											  try {
													if(ignore_subtype1.equalsIgnoreCase("true")) {
														  
														  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "subtype1 not applicable", browser ,pathLoc+"/"+testcasemethod , false );
													  }else {
														  
														  // supress rows selection
														  
														  if(ReusableComponents.isElementPresent(check_subtype1)) {
															  
															 
//																isselected = check_subtype1.isSelected();
//																System.out.println("sub type 1 value is "+isselected);
																
															  isselected = true; // default value is selected
																System.out.println("value of is selected"+isselected);
																
																if (supressrows == true && isselected == true) {
																	// message - already as per requirement
																	ReusableComponents.reportPass( threadID , tempList , testcasemethod , "sub type 1 already matching", browser ,pathLoc+"/"+testcasemethod , false );
																}
																if(supressrows == false && isselected == true) {
																	
																	check_subtype1.click();
																	ReusableComponents.reportPass( threadID , tempList , testcasemethod , "sub type 1 un checked now ", browser ,pathLoc+"/"+testcasemethod , false );
																}
																  
																if (supressrows == true && isselected == false) {
																	check_subtype1.click();
																	ReusableComponents.reportPass( threadID , tempList , testcasemethod , "sub type 1 checked now ", browser ,pathLoc+"/"+testcasemethod , false );
																}
																if(supressrows == false && isselected == false) {
																	ReusableComponents.reportPass( threadID , tempList , testcasemethod , "sub type 1 already matching", browser ,pathLoc+"/"+testcasemethod , false );
																	//no action, message
																}
																  
															  }else {
																  
																  System.out.println("sub type 1 not present");
																  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," sub type 1 is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
															  }
														  
														  
														  
													  }
												} catch (Exception e) {
													
													e.printStackTrace();
													ReusableComponents.reportFail( threadID , tempList , testcasemethod ," sub type 1 is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
												}
												  
											  
											  
											  
											  
											  
											  
											  
											  
											  // push other buttons here
											  
											  /* after clicking the end date, need to check if the check box is already selected or not
											   * if not then based on the test case we need to select it
											   * else need to unselect it
											   * 
											   * add a case for NA
											   */
											  
											  
											  
											  
											  
											  
											  try {
												if(ignore_supressrows.equalsIgnoreCase("true")) {
													  
													  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows not applicable", browser ,pathLoc+"/"+testcasemethod , false );
												  }else {
													  
													  // supress rows selection
													  
													  if(ReusableComponents.isElementPresent(check_suppressZeroAmountRows)) {
														  
														  String checked_call = check_suppressZeroAmountRows.getText();
														  
														  System.out.println("return value is "+checked_call);
														  
														  checked_call = checked_call.replaceAll("[^a-zA-Z]", "");  
														  
														  System.out.println("post regex value is "+checked_call);
														  
														  if(checked_call.equalsIgnoreCase("after")) {
															  isselected = true;
														  }else {
															  isselected = false;
														  }
														  
															//isselected = check_suppressZeroAmountRows.isSelected();
															
														  isselected = true; // default value is selected
															System.out.println("value of is selected"+isselected);
															
															if (supressrows == true && isselected == true) {
																// message - already as per requirement
																ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows already matching", browser ,pathLoc+"/"+testcasemethod , false );
															}
															if(supressrows == false && isselected == true) {
																
																check_suppressZeroAmountRows.click();
																ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows un checked now ", browser ,pathLoc+"/"+testcasemethod , false );
															}
															  
															if (supressrows == true && isselected == false) {
																check_suppressZeroAmountRows.click();
																ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows checked now ", browser ,pathLoc+"/"+testcasemethod , false );
															}
															if(supressrows == false && isselected == false) {
																ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows already matching", browser ,pathLoc+"/"+testcasemethod , false );
																//no action, message
															}
															  
														  }else {
															  
															  System.out.println("run btn not present");
															  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," supress rows is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
														  }
													  
													  
													  
												  }
											} catch (Exception e) {
												
												e.printStackTrace();
												ReusableComponents.reportFail( threadID , tempList , testcasemethod ," supress rows is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
											  
											  
											  
											  
											  
											  
											  
										//	  Select dropdown1 = new Select(dropdown);
//											  
//											  dropdown1.selectByVisibleText("2020-06");
											  
											  try {
												ReusableComponents.wait(3200);
												  
												  if(ReusableComponents.isElementPresent(new_click_btn_run)) {
													  
													  ReusableComponents.wait(1200);
													  new_click_btn_run.click();
													  ReusableComponents.wait(2200);
													  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+" report generation", browser, pathLoc+"/"+testcasemethod, true);
													  
													  
												  }else {
													  
													  System.out.println("run btn not present");
													  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report generation is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
												  }
												  
												//  ReusableComponents.wait(5200);
												  
												  ReusableComponents.wait(4200);
												  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+"report generation", browser, pathLoc+"/"+testcasemethod, true);
											} catch (Exception e) {
												
												e.printStackTrace();
												 ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report generation is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
											  
											  
											  try {
												ReusableComponents.wait(15200);
												  
//											  browser.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
//											  ReusableComponents.wait(3200);
									//
//												browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_UP);
//												ReusableComponents.wait(3200);
//												browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_UP);
//												ReusableComponents.wait(3200);
												  
												  browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
												  ReusableComponents.wait(13200);
													
//												((JavascriptExecutor) browser)
//												.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//												
//												 ReusableComponents.wait(5200);
//												
//												JavascriptExecutor js = (JavascriptExecutor) browser;
//												   js.executeScript("window.scrollBy(document.body.scrollHeight,0)");
													
													
												  
												  // this test is to see the generated report and click it, validate and return back
												  // which is not feasible in environments used by all as the records will be more
												  // and the time taken by the reports will need too much wait
												  
												  
												 // commenting the report click alone just reading the report name
												  
													if(ReusableComponents.isElementPresent(reportname)) {
														  
														  ReusableComponents.wait(1200);
														  
														 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report name is "+reportname.getText().toUpperCase()+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
														  ReusableComponents.wait(1200);
														  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+" report name is " +reportname.getText().toUpperCase() +" and link for report "+reportname.getAttribute("href")+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
														  
														 // validateTestD(threadID, tempList, pathLoc);
														  
														  
														  
													  }else {
														  
														  //System.out.println("report not present");
														  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report name is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
													  }
											} catch (Exception e) {
												
												e.printStackTrace();
												ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report name is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
												
												
											
											  
											  
										  }else {
											  
											//  System.out.println("dropdown not present");
											  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is selection is not present", browser ,pathLoc+"/"+testcasemethod , true );
										  }
										 
//									  
										 
										  
										//  System.out.println("aft drop click");
										  
										  
											
										  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
										 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
										  }
										  else
										  { 
											  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is not present", browser ,pathLoc+"/"+testcasemethod , true ); 
										  }
									  
									  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
									 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
									  }
									  else
									  { 
										  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is not present", browser ,pathLoc+"/"+testcasemethod , true ); 
									  }
							} catch (Exception e) {
								
								e.printStackTrace();
								ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time button is not present", browser ,pathLoc+"/"+testcasemethod , true );
							}
							
						  
						  
						  
					  }else {
						  
						  //System.out.println("dropdown not present");
						  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"dropdown value is not selected - start date", browser ,pathLoc+"/"+testcasemethod , true );
					  }
					 		  
					 // System.out.println("aft drop click");
					  
				
					  
					  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
					 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
					  }
					  else
					  { 
						  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present", browser ,pathLoc+"/"+testcasemethod , true ); 
					  }
				  
				  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
				 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
				  }
				  else
				  { 
					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true ); 
				  }
		} catch (Exception e) {
			
			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
			
		}
		
	
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}

	
	/*** Test case Method Name : validateTest2684
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage validate_Test_2684(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		
		String startdate = null, enddate = null, equalsvalueof = null, equalssubtype = null;
		Boolean isselected = false;
		
		//the excel input value should be supplied to start date and end date
		
		try {

			String filename = reusableComponents.getPropValues("Financialreportsinput");
			String sheetname = reusableComponents.getPropValues("TC9");
			
			//String outfilename = reusableComponents.getPropValues("outputfilename");
			//String outsheetname = reusableComponents.getPropValues("outputsheetname");

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
			System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);

			// read rows and columns
			
			Iterator<Row> itr = workbooksheet.iterator();
			
			while(itr.hasNext()) {
				Row row = itr.next();
				 if(row.getRowNum()==0 ){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				 
				 if(row.getRowNum() ==1) {
					 continue;
				 }
				
				
				 if(row.getRowNum() == 2) {
					 
					 Iterator<Cell> celliterator = row.cellIterator();
						
						while(celliterator.hasNext()) {
		  
							  Cell cell = celliterator.next(); 
							  final DataFormatter formatter = new DataFormatter(); 
							  
							  startdate_arr.add(formatter.formatCellValue(cell)); 
							   
						}
					 
				 }
				 
				 
				
			}
		

			

		

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}
		
		
		
		try {
			for(int i =0; i<startdate_arr.size();i++) {
				
				System.out.println(startdate_arr.get(i));
			}
			
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Reading Excel input sheet, successful", browser ,pathLoc+"/"+testcasemethod , false );
			startdate = startdate_arr.get(2);
			enddate = startdate_arr.get(3);
			
			ReusableComponents.wait(5200);
			
			System.out.println("start date "+startdate+" and end date "+enddate+ " equals true or false value is "+equalsvalueof);
		} catch (Exception e) {

			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"printing excel elements are incomplete", browser ,pathLoc+"/"+testcasemethod , true );
		}
		
		

		ReusableComponents.wait(5200);
	
		try {
			if(ReusableComponents.isElementPresent(new_start_time_btn)){
				  ReusableComponents.wait(1200);
				  
				  //System.out.println(" clear selection");
				  
				  
				  new_start_time_btn.click();
				  
				  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time btn is present and clearing selected start range", browser ,pathLoc+"/"+testcasemethod , false );
				  
				//  System.out.println("btn clear");
				  ReusableComponents.wait(3200);
				  
				  if(ReusableComponents.isElementPresent(new_start_time_input)){
					  ReusableComponents.wait(1200);
					  
				//	  System.out.println(" input selection");
					  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time start range is clicked", browser ,pathLoc+"/"+testcasemethod , false );
					  new_start_time_input.click();
					  
				//	  System.out.println("btn clear");
					  ReusableComponents.wait(3200);
					  
					  new_start_time_input.sendKeys(startdate);

				//	  System.out.println("aft date");
					  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time btn is entered", browser ,pathLoc+"/"+testcasemethod , false );
					  
					  ReusableComponents.wait(3200);
					  
					  WebElement dyn_dropdown = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+startdate+"']/span[2]/span"));
					  
					  if(ReusableComponents.isElementPresent(dyn_dropdown)) { //dropdown
						  
						  ReusableComponents.wait(1200);
						  dyn_dropdown.click();
						  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "start range value selected", browser ,pathLoc+"/"+testcasemethod , false );
						  
						  
						  
					// push end date code here
						  

							try {
								if(ReusableComponents.isElementPresent(new_end_time_btn)){
									  ReusableComponents.wait(1200);
									  
									 // System.out.println(" clear selection end");
									  
									  new_end_time_btn.click();
									  
									  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "End time btn is present and clearing selected end range", browser ,pathLoc+"/"+testcasemethod , false );
									  
									//  System.out.println("btn clear end");
									  ReusableComponents.wait(3200);
									  
									  if(ReusableComponents.isElementPresent(new_end_time_input)){
										  ReusableComponents.wait(1200);
										  
										//  System.out.println(" input selection end");
										  
										  new_end_time_input.click();
										  
										//  System.out.println("btn clear end");
										  ReusableComponents.wait(3200);
										  
										  new_end_time_input.sendKeys(enddate);
										  
										  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "End time entered", browser ,pathLoc+"/"+testcasemethod , false );

										  System.out.println("aft date");
										  
										  ReusableComponents.wait(3200);
										  
										  WebElement dyn_dropdown1 = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+enddate+"']/span[2]/span[1]"));
										  
										  if(ReusableComponents.isElementPresent(dyn_dropdown1)) { //dropdown1
											  
											  ReusableComponents.wait(1200);
											  dyn_dropdown1.click();
  

											  try {
												ReusableComponents.wait(3200);
												  
												  if(ReusableComponents.isElementPresent(new_click_btn_run)) {
													  
													  ReusableComponents.wait(1200);
													  new_click_btn_run.click();
													  ReusableComponents.wait(2200);
													  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+" report generation", browser, pathLoc+"/"+testcasemethod, true);
													  
													  
												  }else {
													  
													  System.out.println("run btn not present");
													  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report generation is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
												  }
												  
												//  ReusableComponents.wait(5200);
												  
												  ReusableComponents.wait(4200);
												  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+"report generation", browser, pathLoc+"/"+testcasemethod, true);
											} catch (Exception e) {
												
												e.printStackTrace();
												 ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report generation is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
											  
											  
											  try {
												ReusableComponents.wait(15200);
												  
												  
												  browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
												  ReusableComponents.wait(13200);
													
												  
												  // this test is to see the generated report and click it, validate and return back
												  // which is not feasible in environments used by all as the records will be more
												  // and the time taken by the reports will need too much wait
												  
												  
												 // commenting the report click alone just reading the report name
												  
													if(ReusableComponents.isElementPresent(reportname)) {
														  
														  ReusableComponents.wait(1200);
														  
														 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report name is "+reportname.getText().toUpperCase()+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
														  ReusableComponents.wait(1200);
														  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+" report name is " +reportname.getText().toUpperCase() +" and link for report "+reportname.getAttribute("href")+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
														  
														 // validateTestD(threadID, tempList, pathLoc);
														  
														  
														  
													  }else {
														  
														  //System.out.println("report not present");
														  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report name is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
													  }
											} catch (Exception e) {
												
												e.printStackTrace();
												ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report name is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
												
												
											
											  
											  
										  }else {
											  
											//  System.out.println("dropdown not present");
											  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is selection is not present", browser ,pathLoc+"/"+testcasemethod , true );
										  }
										 
//									  
										 
										  
										//  System.out.println("aft drop click");
										  
										  
											
										  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
										 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
										  }
										  else
										  { 
											  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is not present", browser ,pathLoc+"/"+testcasemethod , true ); 
										  }
									  
									  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
									 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
									  }
									  else
									  { 
										  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is not present", browser ,pathLoc+"/"+testcasemethod , true ); 
									  }
							} catch (Exception e) {
								
								e.printStackTrace();
								ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time button is not present", browser ,pathLoc+"/"+testcasemethod , true );
							}
							
						  
						  
						  
					  }else {
						  
						  //System.out.println("dropdown not present");
						  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"dropdown value is not selected - start date", browser ,pathLoc+"/"+testcasemethod , true );
					  }
					 		  
					 // System.out.println("aft drop click");
					  
				
					  
					  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
					 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
					  }
					  else
					  { 
						  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present", browser ,pathLoc+"/"+testcasemethod , true ); 
					  }
				  
				  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
				 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
				  }
				  else
				  { 
					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true ); 
				  }
		} catch (Exception e) {
			
			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
			
		}
		
	
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}

	/*** Test case Method Name : validateTest2685
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage validate_Test_2685(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		
		String startdate = null, enddate = null, equalsvalueof = null, equalssubtype = null;
		Boolean isselected = false;
		
		//the excel input value should be supplied to start date and end date
		
		try {

			String filename = reusableComponents.getPropValues("Financialreportsinput");
			String sheetname = reusableComponents.getPropValues("TC10");
			
			//String outfilename = reusableComponents.getPropValues("outputfilename");
			//String outsheetname = reusableComponents.getPropValues("outputsheetname");

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
			System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);

			// read rows and columns
			
			Iterator<Row> itr = workbooksheet.iterator();
			
			while(itr.hasNext()) {
				Row row = itr.next();
				 if(row.getRowNum()==0 ){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				 
				 if(row.getRowNum() ==1) {
					 continue;
				 }
				
				
				 if(row.getRowNum() == 2) {
					 
					 Iterator<Cell> celliterator = row.cellIterator();
						
						while(celliterator.hasNext()) {
		  
							  Cell cell = celliterator.next(); 
							  final DataFormatter formatter = new DataFormatter(); 
							  
							  startdate_arr.add(formatter.formatCellValue(cell)); 
							   
						}
					 
				 }
				 
				 
				
			}
		

			

		

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}
		
		
		
		try {
			for(int i =0; i<startdate_arr.size();i++) {
				
				System.out.println(startdate_arr.get(i));
			}
			
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Reading Excel input sheet, successful", browser ,pathLoc+"/"+testcasemethod , false );
			startdate = startdate_arr.get(2);
			enddate = startdate_arr.get(3);
			
			ReusableComponents.wait(5200);
			
			System.out.println("start date "+startdate+" and end date "+enddate+ " equals true or false value is "+equalsvalueof);
		} catch (Exception e) {

			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"printing excel elements are incomplete", browser ,pathLoc+"/"+testcasemethod , true );
		}
		
		

		ReusableComponents.wait(5200);
	
		try {
			if(ReusableComponents.isElementPresent(new_start_time_btn)){
				  ReusableComponents.wait(1200);
				  
				  //System.out.println(" clear selection");
				  
				  
				  new_start_time_btn.click();
				  
				  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time btn is present and clearing selected start range", browser ,pathLoc+"/"+testcasemethod , false );
				  
				//  System.out.println("btn clear");
				  ReusableComponents.wait(3200);
				  
				  if(ReusableComponents.isElementPresent(new_start_time_input)){
					  ReusableComponents.wait(1200);
					  
				//	  System.out.println(" input selection");
					  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time start range is clicked", browser ,pathLoc+"/"+testcasemethod , false );
					  new_start_time_input.click();
					  
				//	  System.out.println("btn clear");
					  ReusableComponents.wait(3200);
					  
					  new_start_time_input.sendKeys(startdate);

				//	  System.out.println("aft date");
					  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time btn is entered", browser ,pathLoc+"/"+testcasemethod , false );
					  
					  ReusableComponents.wait(3200);
					  
					  WebElement dyn_dropdown = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+startdate+"']/span[2]/span"));
					  
					  if(ReusableComponents.isElementPresent(dyn_dropdown)) { //dropdown
						  
						  ReusableComponents.wait(1200);
						  dyn_dropdown.click();
						  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "start range value selected", browser ,pathLoc+"/"+testcasemethod , false );
						  
						  
						  
					// push end date code here
						  

							try {
								if(ReusableComponents.isElementPresent(new_end_time_btn)){
									  ReusableComponents.wait(1200);
									  
									 // System.out.println(" clear selection end");
									  
									  new_end_time_btn.click();
									  
									  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "End time btn is present and clearing selected end range", browser ,pathLoc+"/"+testcasemethod , false );
									  
									//  System.out.println("btn clear end");
									  ReusableComponents.wait(3200);
									  
									  if(ReusableComponents.isElementPresent(new_end_time_input)){
										  ReusableComponents.wait(1200);
										  
										//  System.out.println(" input selection end");
										  
										  new_end_time_input.click();
										  
										//  System.out.println("btn clear end");
										  ReusableComponents.wait(3200);
										  
										  new_end_time_input.sendKeys(enddate);
										  
										  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "End time entered", browser ,pathLoc+"/"+testcasemethod , false );

										  System.out.println("aft date");
										  
										  ReusableComponents.wait(3200);
										  
										  WebElement dyn_dropdown1 = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+enddate+"']/span[2]/span[1]"));
										  
										  if(ReusableComponents.isElementPresent(dyn_dropdown1)) { //dropdown1
											  
											  ReusableComponents.wait(1200);
											  dyn_dropdown1.click();
  

											  try {
												ReusableComponents.wait(3200);
												  
												  if(ReusableComponents.isElementPresent(new_click_btn_run)) {
													  
													  ReusableComponents.wait(1200);
													  new_click_btn_run.click();
													  ReusableComponents.wait(2200);
													  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+" report generation", browser, pathLoc+"/"+testcasemethod, true);
													  
													  
												  }else {
													  
													  System.out.println("run btn not present");
													  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report generation is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
												  }
												  
												//  ReusableComponents.wait(5200);
												  
												  ReusableComponents.wait(4200);
												  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+"report generation", browser, pathLoc+"/"+testcasemethod, true);
											} catch (Exception e) {
												
												e.printStackTrace();
												 ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report generation is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
											  
											  
											  try {
												ReusableComponents.wait(15200);
												  
												  
												  browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
												  ReusableComponents.wait(13200);
													
												  
												  // this test is to see the generated report and click it, validate and return back
												  // which is not feasible in environments used by all as the records will be more
												  // and the time taken by the reports will need too much wait
												  
												  
												 // commenting the report click alone just reading the report name
												  
													if(ReusableComponents.isElementPresent(reportname)) {
														  
														  ReusableComponents.wait(1200);
														  
														 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report name is "+reportname.getText().toUpperCase()+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
														  ReusableComponents.wait(1200);
														  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+" report name is " +reportname.getText().toUpperCase() +" and link for report "+reportname.getAttribute("href")+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
														  
														 // validateTestD(threadID, tempList, pathLoc);
														  
														  
														  
													  }else {
														  
														  //System.out.println("report not present");
														  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report name is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
													  }
											} catch (Exception e) {
												
												e.printStackTrace();
												ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report name is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
												
												
											
											  
											  
										  }else {
											  
											//  System.out.println("dropdown not present");
											  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is selection is not present", browser ,pathLoc+"/"+testcasemethod , true );
										  }
										 
//									  
										 
										  
										//  System.out.println("aft drop click");
										  
										  
											
										  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
										 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
										  }
										  else
										  { 
											  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is not present", browser ,pathLoc+"/"+testcasemethod , true ); 
										  }
									  
									  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
									 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
									  }
									  else
									  { 
										  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is not present", browser ,pathLoc+"/"+testcasemethod , true ); 
									  }
							} catch (Exception e) {
								
								e.printStackTrace();
								ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time button is not present", browser ,pathLoc+"/"+testcasemethod , true );
							}
							
						  
						  
						  
					  }else {
						  
						  //System.out.println("dropdown not present");
						  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"dropdown value is not selected - start date", browser ,pathLoc+"/"+testcasemethod , true );
					  }
					 		  
					 // System.out.println("aft drop click");
					  
				
					  
					  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
					 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
					  }
					  else
					  { 
						  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present", browser ,pathLoc+"/"+testcasemethod , true ); 
					  }
				  
				  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
				 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
				  }
				  else
				  { 
					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true ); 
				  }
		} catch (Exception e) {
			
			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
			
		}
		
	
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}

	
	/*** Test case Method Name : validateTest2686
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage validate_Test_2686(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		
		String startdate = null, enddate = null, equalsvalueof = null, equalssubtype = null;
		Boolean isselected = false;
		
		//the excel input value should be supplied to start date and end date
		
		try {

			String filename = reusableComponents.getPropValues("Financialreportsinput");
			String sheetname = reusableComponents.getPropValues("TC11");
			
			//String outfilename = reusableComponents.getPropValues("outputfilename");
			//String outsheetname = reusableComponents.getPropValues("outputsheetname");

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
			System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);

			// read rows and columns
			
			Iterator<Row> itr = workbooksheet.iterator();
			
			while(itr.hasNext()) {
				Row row = itr.next();
				 if(row.getRowNum()==0 ){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				 
				 if(row.getRowNum() ==1) {
					 continue;
				 }
				
				
				 if(row.getRowNum() == 2) {
					 
					 Iterator<Cell> celliterator = row.cellIterator();
						
						while(celliterator.hasNext()) {
		  
							  Cell cell = celliterator.next(); 
							  final DataFormatter formatter = new DataFormatter(); 
							  
							  startdate_arr.add(formatter.formatCellValue(cell)); 
							   
						}
					 
				 }
				 
				 
				
			}
		

			

		

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}
		
		
		
		try {
			for(int i =0; i<startdate_arr.size();i++) {
				
				System.out.println(startdate_arr.get(i));
			}
			
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Reading Excel input sheet, successful", browser ,pathLoc+"/"+testcasemethod , false );
			startdate = startdate_arr.get(2);
			enddate = startdate_arr.get(3);
			
			ReusableComponents.wait(5200);
			
			System.out.println("start date "+startdate+" and end date "+enddate+ " equals true or false value is "+equalsvalueof);
		} catch (Exception e) {

			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"printing excel elements are incomplete", browser ,pathLoc+"/"+testcasemethod , true );
		}
		
		

		ReusableComponents.wait(5200);
	
		try {
			if(ReusableComponents.isElementPresent(new_start_time_btn)){
				  ReusableComponents.wait(1200);
				  
				  //System.out.println(" clear selection");
				  
				  
				  new_start_time_btn.click();
				  
				  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time btn is present and clearing selected start range", browser ,pathLoc+"/"+testcasemethod , false );
				  
				//  System.out.println("btn clear");
				  ReusableComponents.wait(3200);
				  
				  if(ReusableComponents.isElementPresent(new_start_time_input)){
					  ReusableComponents.wait(1200);
					  
				//	  System.out.println(" input selection");
					  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time start range is clicked", browser ,pathLoc+"/"+testcasemethod , false );
					  new_start_time_input.click();
					  
				//	  System.out.println("btn clear");
					  ReusableComponents.wait(3200);
					  
					  new_start_time_input.sendKeys(startdate);

				//	  System.out.println("aft date");
					  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time btn is entered", browser ,pathLoc+"/"+testcasemethod , false );
					  
					  ReusableComponents.wait(3200);
					  
					  WebElement dyn_dropdown = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+startdate+"']/span[2]/span"));
					  
					  if(ReusableComponents.isElementPresent(dyn_dropdown)) { //dropdown
						  
						  ReusableComponents.wait(1200);
						  dyn_dropdown.click();
						  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "start range value selected", browser ,pathLoc+"/"+testcasemethod , false );
						  
						  
						  
					// push end date code here
						  

							try {
								if(ReusableComponents.isElementPresent(new_end_time_btn)){
									  ReusableComponents.wait(1200);
									  
									 // System.out.println(" clear selection end");
									  
									  new_end_time_btn.click();
									  
									  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "End time btn is present and clearing selected end range", browser ,pathLoc+"/"+testcasemethod , false );
									  
									//  System.out.println("btn clear end");
									  ReusableComponents.wait(3200);
									  
									  if(ReusableComponents.isElementPresent(new_end_time_input)){
										  ReusableComponents.wait(1200);
										  
										//  System.out.println(" input selection end");
										  
										  new_end_time_input.click();
										  
										//  System.out.println("btn clear end");
										  ReusableComponents.wait(3200);
										  
										  new_end_time_input.sendKeys(enddate);
										  
										  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "End time entered", browser ,pathLoc+"/"+testcasemethod , false );

										  System.out.println("aft date");
										  
										  ReusableComponents.wait(3200);
										  
										  WebElement dyn_dropdown1 = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+enddate+"']/span[2]/span[1]"));
										  
										  if(ReusableComponents.isElementPresent(dyn_dropdown1)) { //dropdown1
											  
											  ReusableComponents.wait(1200);
											  dyn_dropdown1.click();
  

											  try {
												ReusableComponents.wait(3200);
												  
												  if(ReusableComponents.isElementPresent(new_click_btn_run)) {
													  
													  ReusableComponents.wait(1200);
													  new_click_btn_run.click();
													  ReusableComponents.wait(2200);
													  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+" report generation", browser, pathLoc+"/"+testcasemethod, true);
													  
													  
												  }else {
													  
													  System.out.println("run btn not present");
													  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report generation is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
												  }
												  
												//  ReusableComponents.wait(5200);
												  
												  ReusableComponents.wait(4200);
												  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+"report generation", browser, pathLoc+"/"+testcasemethod, true);
											} catch (Exception e) {
												
												e.printStackTrace();
												 ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report generation is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
											  
											  
											  try {
												ReusableComponents.wait(15200);
												  
												  
												  browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
												  ReusableComponents.wait(13200);
													
												  
												  // this test is to see the generated report and click it, validate and return back
												  // which is not feasible in environments used by all as the records will be more
												  // and the time taken by the reports will need too much wait
												  
												  
												 // commenting the report click alone just reading the report name
												  
													if(ReusableComponents.isElementPresent(reportname)) {
														  
														  ReusableComponents.wait(1200);
														  
														 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report name is "+reportname.getText().toUpperCase()+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
														  ReusableComponents.wait(1200);
														  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  testcasemethod+" report name is " +reportname.getText().toUpperCase() +" and link for report "+reportname.getAttribute("href")+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
														  
														 // validateTestD(threadID, tempList, pathLoc);
														  
														  
														  
													  }else {
														  
														  //System.out.println("report not present");
														  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report name is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
													  }
											} catch (Exception e) {
												
												e.printStackTrace();
												ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report name is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
											}
												
												
											
											  
											  
										  }else {
											  
											//  System.out.println("dropdown not present");
											  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is selection is not present", browser ,pathLoc+"/"+testcasemethod , true );
										  }
										 
//									  
										 
										  
										//  System.out.println("aft drop click");
										  
										  
											
										  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
										 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
										  }
										  else
										  { 
											  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is not present", browser ,pathLoc+"/"+testcasemethod , true ); 
										  }
									  
									  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
									 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
									  }
									  else
									  { 
										  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time range is not present", browser ,pathLoc+"/"+testcasemethod , true ); 
									  }
							} catch (Exception e) {
								
								e.printStackTrace();
								ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"end time button is not present", browser ,pathLoc+"/"+testcasemethod , true );
							}
							
						  
						  
						  
					  }else {
						  
						  //System.out.println("dropdown not present");
						  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"dropdown value is not selected - start date", browser ,pathLoc+"/"+testcasemethod , true );
					  }
					 		  
					 // System.out.println("aft drop click");
					  
				
					  
					  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
					 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
					  }
					  else
					  { 
						  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present", browser ,pathLoc+"/"+testcasemethod , true ); 
					  }
				  
				  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
				 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
				  }
				  else
				  { 
					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true ); 
				  }
		} catch (Exception e) {
			
			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
			
		}
		
	
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}

	
	
	/*** Test case Method Name : excelread_initial
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage excelread_initial(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		


		String filename = reusableComponents.getPropValues("Financialreportsinput");
		String sheetname = reusableComponents.getPropValues("primarysheet");
		System.out.println(filename);
		System.out.println(sheetname);


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
		System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);

		// read rows and columns
		
		Iterator<Row> itr = workbooksheet.iterator();
		
		while(itr.hasNext()) {
			Row row = itr.next();
			 if(row.getRowNum()==0 ){
			       continue; //just skip the rows if row number is 0 or 1
			      }

			// if(row.getRowNum() == 1) {
				 
				 Iterator<Cell> celliterator = row.cellIterator();
					
					while(celliterator.hasNext()) {
	  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter(); 
						  
						  basic_input.add(formatter.formatCellValue(cell)); //throw new
						   
					}
				 
			// }
			 
			 
			
		}
		
		
		try {
			for(int i =0; i<basic_input.size();i++) {
				
				System.out.println(basic_input.get(i));
			}
			
			urlfromexcel = basic_input.get(1);
			username = basic_input.get(3);
			pass_login = basic_input.get(5);
			s.url = basic_input.get(7);
			
			try {
				browser.get(urlfromexcel);
				ReusableComponents.wait(2500);
				
				browser.manage().window().maximize();
				
				Salesforce_login(threadID, tempList, pathLoc);
				Validate_fin_reports_page(threadID, tempList, pathLoc);
				validateTestC(threadID, tempList, pathLoc);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
	

		

	

	
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}
	
	
	
	/*** Test case Method Name : excelread_initial_2683
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage excelread_initial_2683(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		


		String filename = reusableComponents.getPropValues("Financialreportsinput");
		String sheetname = reusableComponents.getPropValues("primarysheet");
		System.out.println(filename);
		System.out.println(sheetname);


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
		System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);

		// read rows and columns
		
		Iterator<Row> itr = workbooksheet.iterator();
		
		while(itr.hasNext()) {
			Row row = itr.next();
			 if(row.getRowNum()==0 ){
			       continue; //just skip the rows if row number is 0 or 1
			      }

			// if(row.getRowNum() == 1) {
				 
				 Iterator<Cell> celliterator = row.cellIterator();
					
					while(celliterator.hasNext()) {
	  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter(); 
						  
						  basic_input.add(formatter.formatCellValue(cell)); //throw new
						   
					}
				 
			// }
			 
			 
			
		}
		
		
		try {
			for(int i =0; i<basic_input.size();i++) {
				
				System.out.println(basic_input.get(i));
			}
			
			urlfromexcel = basic_input.get(1);
			username = basic_input.get(3);
			pass_login = basic_input.get(5);
			s.url = basic_input.get(7);
			
			try {
				browser.get(urlfromexcel);
				ReusableComponents.wait(2500);
				
				browser.manage().window().maximize();
				
				Salesforce_login(threadID, tempList, pathLoc);
				Validate_fin_reports_page(threadID, tempList, pathLoc);
				validate_Test_2683(threadID, tempList, pathLoc);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
	

		

	

	
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}
	
	/*** Test case Method Name : excelread_initial_2684
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage excelread_initial_2684(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		


		String filename = reusableComponents.getPropValues("Financialreportsinput");
		String sheetname = reusableComponents.getPropValues("primarysheet");
		System.out.println(filename);
		System.out.println(sheetname);


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
		System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);

		// read rows and columns
		
		Iterator<Row> itr = workbooksheet.iterator();
		
		while(itr.hasNext()) {
			Row row = itr.next();
			 if(row.getRowNum()==0 ){
			       continue; //just skip the rows if row number is 0 or 1
			      }

			// if(row.getRowNum() == 1) {
				 
				 Iterator<Cell> celliterator = row.cellIterator();
					
					while(celliterator.hasNext()) {
	  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter(); 
						  
						  basic_input.add(formatter.formatCellValue(cell)); //throw new
						   
					}
				 
			// }
			 
			 
			
		}
		
		
		try {
			for(int i =0; i<basic_input.size();i++) {
				
				System.out.println(basic_input.get(i));
			}
			
			urlfromexcel = basic_input.get(1);
			username = basic_input.get(3);
			pass_login = basic_input.get(5);
			s.url = basic_input.get(7);
			
			try {
				browser.get(urlfromexcel);
				ReusableComponents.wait(2500);
				
				browser.manage().window().maximize();
				
				Salesforce_login(threadID, tempList, pathLoc);
				Validate_fin_reports_page(threadID, tempList, pathLoc);
				validate_Test_2684(threadID, tempList, pathLoc);
				delete_reports_select(threadID, tempList, pathLoc);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
	

		

	

	
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}
	
	
	/*** Test case Method Name : excelread_initial_2685
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage excelread_initial_2685(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		


		String filename = reusableComponents.getPropValues("Financialreportsinput");
		String sheetname = reusableComponents.getPropValues("primarysheet");
		System.out.println(filename);
		System.out.println(sheetname);


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
		System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);

		// read rows and columns
		
		Iterator<Row> itr = workbooksheet.iterator();
		
		while(itr.hasNext()) {
			Row row = itr.next();
			 if(row.getRowNum()==0 ){
			       continue; //just skip the rows if row number is 0 or 1
			      }

			// if(row.getRowNum() == 1) {
				 
				 Iterator<Cell> celliterator = row.cellIterator();
					
					while(celliterator.hasNext()) {
	  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter(); 
						  
						  basic_input.add(formatter.formatCellValue(cell)); //throw new
						   
					}
				 
			// }
			 
			 
			
		}
		
		
		try {
			for(int i =0; i<basic_input.size();i++) {
				
				System.out.println(basic_input.get(i));
			}
			
			urlfromexcel = basic_input.get(1);
			username = basic_input.get(3);
			pass_login = basic_input.get(5);
			s.url = basic_input.get(7);
			
			try {
				browser.get(urlfromexcel);
				ReusableComponents.wait(2500);
				
				browser.manage().window().maximize();
				
				Salesforce_login(threadID, tempList, pathLoc);
				Validate_fin_reports_page(threadID, tempList, pathLoc);
				validate_Test_2685(threadID, tempList, pathLoc);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
	

		

	

	
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}
	
	
	/*** Test case Method Name : excelread_initial_2686
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage excelread_initial_2686(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		


		String filename = reusableComponents.getPropValues("Financialreportsinput");
		String sheetname = reusableComponents.getPropValues("primarysheet");
		System.out.println(filename);
		System.out.println(sheetname);


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
		System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);

		// read rows and columns
		
		Iterator<Row> itr = workbooksheet.iterator();
		
		while(itr.hasNext()) {
			Row row = itr.next();
			 if(row.getRowNum()==0 ){
			       continue; //just skip the rows if row number is 0 or 1
			      }

			// if(row.getRowNum() == 1) {
				 
				 Iterator<Cell> celliterator = row.cellIterator();
					
					while(celliterator.hasNext()) {
	  
						  Cell cell = celliterator.next(); 
						  final DataFormatter formatter = new DataFormatter(); 
						  
						  basic_input.add(formatter.formatCellValue(cell)); //throw new
						   
					}
				 
			// }
			 
			 
			
		}
		
		
		try {
			for(int i =0; i<basic_input.size();i++) {
				
				System.out.println(basic_input.get(i));
			}
			
			urlfromexcel = basic_input.get(1);
			username = basic_input.get(3);
			pass_login = basic_input.get(5);
			s.url = basic_input.get(7);
			
			try {
				browser.get(urlfromexcel);
				ReusableComponents.wait(2500);
				
				browser.manage().window().maximize();
				
				Salesforce_login(threadID, tempList, pathLoc);
				Validate_fin_reports_page(threadID, tempList, pathLoc);
				validate_Test_2686(threadID, tempList, pathLoc);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
	

		

	

	
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}
	
	
	
	
	/*** Test case Method Name : delete_reports
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PLAllPage delete_reports_select(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		
		if(ReusableComponents.isElementPresent(report_select)){
			
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "report selector is identified", browser ,pathLoc+"/"+testcasemethod , false );
			ReusableComponents.wait(1200);
			report_select.click();
			ReusableComponents.wait(5500);
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "report selector is clicked", browser ,pathLoc+"/"+testcasemethod , false );
			
			if(ReusableComponents.isElementPresent(delete_reports)){
				
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "delete reports is identified", browser ,pathLoc+"/"+testcasemethod , false );
				ReusableComponents.wait(1200);
				delete_reports.click();
				ReusableComponents.wait(5500);
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "delete reports is clicked", browser ,pathLoc+"/"+testcasemethod , false );
				
				
				if(ReusableComponents.isElementPresent(confirm_delete)){
					
					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "confirm delete is identified", browser ,pathLoc+"/"+testcasemethod , false );
					ReusableComponents.wait(1200);
					confirm_delete.click();
					ReusableComponents.wait(5500);
					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "confirm delete is clicked", browser ,pathLoc+"/"+testcasemethod , false );
						
					
				}else{
					ReusableComponents.reportFail( threadID , tempList , testcasemethod , "confirm delete is NOT present", browser ,pathLoc+"/"+testcasemethod , true );
				}
				
				
				
			}else{
				ReusableComponents.reportFail( threadID , tempList , testcasemethod , "delete reports is NOT present", browser ,pathLoc+"/"+testcasemethod , true );
			}
			
			
			
			
		}else{
			ReusableComponents.reportFail( threadID , tempList , testcasemethod , "report selector is NOT present", browser ,pathLoc+"/"+testcasemethod , true );
		}
		
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PLAllPage(browser);
	}
	
	

}


