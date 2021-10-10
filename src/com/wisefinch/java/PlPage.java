package com.wisefinch.java;


import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
public class PlPage extends DriverScript{
	protected WebDriver browser;
		
	ReusableComponents reusableComponents = new  ReusableComponents();
	/**
	 * Constructor for Page class 
	 * @param browser
	 * @param report
	 */
	protected PlPage(WebDriver browser) {
		this.browser=browser;		
		PageFactory.initElements(browser, this);
	
	}


public PlPage() {
		// TODO Auto-generated constructor stub
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

@FindBy(xpath = "//img[@title=' Financial Reports']")
WebElement Reports;

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

@FindBy(xpath = "//button[contains(text(),'Run')]")
WebElement new_click_btn_run;

@FindBy(xpath = "//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='2020-07']/span[2]/span")
WebElement dropdown;

@FindBy(xpath = "//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='2021-06']/span[2]/span")
WebElement dropdown1;

//@FindBy(xpath = "//table//tbody//tr[1]//th//div[1]//a")
@FindBy(xpath = "(.//tr//*[@class='slds-truncate']//a[contains(text(),'FRR')])[1]")
WebElement reportname;

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
ArrayList<String> outarray= new ArrayList<String>();

Boolean supressrows = false;
String ignore_supressrows = null, ignore_subtype1 = null;




	/*** Test case Method Name : validateTestA
	 * 	 Functionality         : validate login to Accounting seed salesforce - Login_Salesforce
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage Salesforce_login(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		//testcasemethod = "Login Method Salesforce";
		testcasemethod = testcasemethod + " - functionality";
		
	try{
		String username = null, pass_login = null;
		
		//browser.switchTo().defaultContent();
		
		username = reusableComponents.getPropValues("username");
		pass_login = reusableComponents.getPropValues("password");
		
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
					
					browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
					ReusableComponents.wait(9200);
					
					browser.switchTo().frame(0);
					ReusableComponents.wait(3200);
					
					if(ReusableComponents.isElementPresent(Reports)){
						
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Login Button is identified", browser ,pathLoc+"/"+testcasemethod , false );
						ReusableComponents.wait(1200);
						Reports.click();
						ReusableComponents.wait(15500);
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "salesforce login button is clicked", browser ,pathLoc+"/"+testcasemethod , false );
						
					}else{
						ReusableComponents.reportFail( threadID , tempList , testcasemethod , "reports tag is NOT present", browser ,pathLoc+"/"+testcasemethod , true );
					}
					
					
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
		
		return new PlPage(browser);
	}

	
	/*** Test case Method Name : validateTestA
	 * 	 Functionality         : validate login to Accounting seed salesforce - Login_Salesforce
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage Navigation_page(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
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
		
		return new PlPage(browser);
	}

	
	
	/*** Test case Method Name : validateTestOpp
	 * 	 Functionality         : validate opportunity creation
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage validateTestOpp(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
	try{
		String opportunity_name = null;
		int counter=0, i=0;
		
		counter = Integer.parseInt(reusableComponents.getPropValues("opportunity_counter")) ;
		
		for(i=0;i<counter;i++) {
		
		browser.switchTo().defaultContent();
		
		//ReusableComponents.wait(2300);
		
		opportunity_name = reusableComponents.getPropValues("opp_name");
		
		
		  WebElement ele =browser.findElement(By.xpath("//a[@title='Opportunities']"));
		  
		  JavascriptExecutor executor = (JavascriptExecutor)browser;
		  executor.executeScript("arguments[0].click();", ele);
		  
		  ReusableComponents.wait(1200);
		 
		  browser.switchTo().defaultContent();
		  
		  ReusableComponents.wait(1200);
		
		if(ReusableComponents.isElementPresent(New_opp_btn)){
			ReusableComponents.wait(1200);
			
			New_opp_btn.click();
			
			ReusableComponents.wait(1200);
			
			browser.switchTo().defaultContent();
			
			
			
		}else{
			ReusableComponents.reportFail( threadID , tempList , testcasemethod , "New_opp_btn is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
		}
		
		try {
			ReusableComponents.wait(1200);
			
			  WebElement ele1 =browser.findElement(By.xpath("//a[contains(@class,'datePicker-openIcon display')]"));
			  
			  JavascriptExecutor executor1 = (JavascriptExecutor)browser;
			  executor1.executeScript("arguments[0].click();", ele1);
			  
			  ReusableComponents.wait(1200);
			  
			  WebElement ele2 =browser.findElement(By.xpath("//button[normalize-space()='Today']"));
			  
			  JavascriptExecutor executor2 = (JavascriptExecutor)browser;
			  executor2.executeScript("arguments[0].click();", ele2);
			 
			  ReusableComponents.wait(1200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("exception in date field");
		}
			
		
		if(ReusableComponents.isElementPresent(opportunity_enter)){
			ReusableComponents.wait(1200);
			
			String dt_pattern = "yymmddhhmmss";
			DateTimeFormatter cdt = DateTimeFormatter.ofPattern(dt_pattern);
			LocalDateTime now = LocalDateTime.now();
			
			
			
			opportunity_enter.sendKeys(opportunity_name+"_"+cdt.format(now));
			ReusableComponents.wait(1200);
			
			if(ReusableComponents.isElementPresent(stage_enter)){
				ReusableComponents.wait(1200);
				
				stage_enter.click();
				ReusableComponents.wait(1200);
				
				if(ReusableComponents.isElementPresent(select_stage)){
					ReusableComponents.wait(2200);
					
					new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(select_stage)).click();
					//select_stage.click();
					ReusableComponents.wait(1200);
					
					if(ReusableComponents.isElementPresent(save_btn)){
						ReusableComponents.wait(1200);
						
						save_btn.click();
						ReusableComponents.wait(1200);
						
					}else{
						ReusableComponents.reportFail( threadID , tempList , testcasemethod , "save btn is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
					}
					
				}else{
					ReusableComponents.reportFail( threadID , tempList , testcasemethod , "select stage is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
				}
				
			}else{
				ReusableComponents.reportFail( threadID , tempList , testcasemethod , "stage enter is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
			}
			
		}else{
			ReusableComponents.reportFail( threadID , tempList , testcasemethod , "opportunity enter is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
		}
		
		//return back to opportunity page
		ReusableComponents.wait(2200);
		 
		}//for loop end
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PlPage(browser);
	}

	
	/*** Test case Method Name : validateTestb
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page old
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage validateTestB(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
	try{
		/*
		 * boolean test=false;
		 * 
		 * 
		 * try { test = browser.getPageSource().contains("iframe");
		 * 
		 * if(test == true) {
		 * 
		 * browser.switchTo().frame(0); System.out.println("inside an iframe");
		 * 
		 * if(ReusableComponents.isElementPresent(btn_img)){
		 * ReusableComponents.wait(1200);
		 * 
		 * btn_img.click(); ReusableComponents.wait(1200);
		 * 
		 * }else{ ReusableComponents.reportFail( threadID , tempList , testcasemethod ,
		 * "btn is NOT present successfully", browser ,pathLoc+"/"+testcasemethod ,
		 * true ); }
		 * 
		 * } } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); System.out.println("my bad"); }
		 */
		/*
		 * 
		 * try { System.out.println("no validation");
		 * 
		 * browser.switchTo().frame(0);
		 * 
		 * if(ReusableComponents.isElementPresent(btn_img)){
		 * ReusableComponents.wait(1200);
		 * 
		 * btn_img.click(); ReusableComponents.wait(1200);
		 * 
		 * }else{ ReusableComponents.reportFail( threadID , tempList , testcasemethod ,
		 * "btn is NOT present successfully", browser ,pathLoc+"/"+testcasemethod ,
		 * true ); } } catch (Exception e) { // TODO Auto-generated catch block
		 * System.out.println("not sure"); }
		 * 
		 * 
		 */
		
		
		
		
		  boolean test=false;
		  
		  
		  try { 
			  
			  test = browser.getPageSource().contains("iframe");
		  
		  if(test == true) {
		  
		  browser.switchTo().frame(0); 
		  System.out.println("inside an iframe");
		  ReusableComponents.wait(3200);
//		  
//		  try {
//			if(ReusableComponents.isElementPresent(btn_img)){
//				  ReusableComponents.wait(1200);
//				  
//				  btn_img.click();
//				  ReusableComponents.wait(1200);
//				  
//				  //new window
//				  String main_win = browser.getWindowHandle();
//				  Set<String> s1 = browser.getWindowHandles();
//				  
//				  Iterator<String> i1 = s1.iterator();
//			        
//			        while (i1.hasNext()) {
//			            String ChildWindow = i1.next();
//			                if (!main_win.equalsIgnoreCase(ChildWindow)) {
//			                browser.switchTo().window(ChildWindow);
//			                
//			                ReusableComponents.wait(1200);
//			                
//			                browser.switchTo().frame(0);
//			                
//			                frame_search.clear();
//			                frame_search.sendKeys("2020-06");
//			                
//			                ReusableComponents.wait(1200);
//			                
//			                frame_go.click();
//			                
//			                ReusableComponents.wait(4200);
//			                
//			               try {
//							// frame_select.click();
//							    WebElement frame = browser.findElement(By.linkText("2020-06"));
//							    
//							    
//							    frame.click();
//							    
//							    ReusableComponents.wait(2200);
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//			               
//			               try {
//								// frame_select.click();
//								    WebElement frame = browser.findElement(By.xpath("//a[@href='#']"));
//								    
//								    frame.click();
//								    
//								    ReusableComponents.wait(2200);
//							} catch (Exception e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
//			               
//			                browser.close();
//			                System.out.println("Child window closed");
//			            }
//			        }    
//			  
//			        //  Switch back to the main window which is the parent window.
//			        browser.switchTo().window(main_win);
//			        ReusableComponents.wait(12200);
//				  
//				  
//				  }
//				  else
//				  { 
//					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"first is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true ); 
//				  }
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println("frame checker");
//		}
//		  
//		  
//		  browser.switchTo().defaultContent();
//		  browser.switchTo().frame(0);
//		  
//		  
		  try {
			if(ReusableComponents.isElementPresent(first_input)){
			  ReusableComponents.wait(1200);
			  
			  
			  System.out.println("in first");
			  first_input.clear();
			  first_input.sendKeys("2020-06");
			  ReusableComponents.wait(1200);
			  
			  }
			  else
			  { 
				  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"first is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true ); 
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("first btn");
		}
		  
		  try {
			if(ReusableComponents.isElementPresent(second_input)){
				  ReusableComponents.wait(1200);
				  
				  System.out.println("in second");
				  second_input.clear();
				  second_input.sendKeys("2021-05");
				  ReusableComponents.wait(1200);
				  
				  }
				  else
				  { 
					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"second is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true ); 
				  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("second btn");
		}
		  
		  try {
			if(ReusableComponents.isElementPresent(btn_run_click)){
				  ReusableComponents.wait(1200);
				  
				  System.out.println("run button");
				  
				  btn_run_click.click();
				  
				  System.out.println("btn clicker");
				  ReusableComponents.wait(3200);
				  
				  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
				  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
				  }
				  else
				  { 
					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"btn is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true ); 
				  }
			
			ReusableComponents.wait(15200);
			((JavascriptExecutor) browser)
			.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			
			//ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
			 ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "processing", browser, pathLoc+"/"+testcasemethod, true);
			
			 ReusableComponents.wait(13200);
			  
			 
			  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report generated", browser, pathLoc+"/"+testcasemethod, true); 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("run btn");
		}
		  
		  
		  browser.switchTo().defaultContent();
		  
		  } 
		  } catch (Exception e) { // TODO Auto-generated catch block
		  e.printStackTrace(); 
		  System.out.println("my bad"); 
		  }
		 
		
		
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PlPage(browser);
	}


	/*** Test case Method Name : validateTestC
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage validateTestC(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		
		String startdate = null, enddate = null, equalsvalueof = null;
		Boolean isselected = false;
		
		//the excel input value should be supplied to start date and end date
		
		try {

			String filename = reusableComponents.getPropValues("Financialreportsinput");
			String sheetname = reusableComponents.getPropValues("TC1");
			
			outarray.add(filename);
			outarray.add(sheetname);
			//String outfilename = reusableComponents.getPropValues("outputfilename");
			//String outsheetname = reusableComponents.getPropValues("outputsheetname");

			File file = new File(workingDir + "/input/" + filename);
			System.out.println(" file location "+file);
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
			
			outarray.add("File name NA");
			outarray.add("Sheet name NA");
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}
		
		
		
		try {
			for(int i =0; i<startdate_arr.size();i++) {
				
				System.out.println(startdate_arr.get(i));
			}
			
			ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Reading Excel input sheet, successful", browser ,pathLoc+"/"+testcasemethod , false );
			startdate = startdate_arr.get(2);
			outarray.add(startdate);
			enddate = startdate_arr.get(3);
			outarray.add(enddate);
			equalsvalueof = startdate_arr.get(4);
			outarray.add(equalsvalueof);
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
			
			outarray.add("Start date NA");
			outarray.add("End date NA");
			outarray.add("suppress rows NA");
			// TODO Auto-generated catch block
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
												// TODO Auto-generated catch block
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
												// TODO Auto-generated catch block
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
														  outarray.add(reportname.getText());
														  outarray.add(reportname.getAttribute("href"));
														 // validateTestD(threadID, tempList, pathLoc);
														  
														  
														  
													  }else {
														  outarray.add("Report name - NA");
														  outarray.add("Report Link - NA");
														  //System.out.println("report not present");
														  ReusableComponents.reportFail( threadID , tempList , testcasemethod ," report name is NOT detected", browser ,pathLoc+"/"+testcasemethod , true );
													  }
											} catch (Exception e) {
												// TODO Auto-generated catch block
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
								// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
			
		}
		
		
		
		
		
		
		// ouput excel
		ValidateExcelOutput(threadID, tempList, pathLoc);
		

		  
		   
		
		
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PlPage(browser);
	}

	

	/*** Test case Method Name : validateTest2677
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage validateTest2677(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
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
			// TODO Auto-generated catch block
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
												// TODO Auto-generated catch block
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
												// TODO Auto-generated catch block
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
												// TODO Auto-generated catch block
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
								// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
			
		}
		
		
		
		
		
		
		
		
		

		  
		   
		
		
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PlPage(browser);
	}

	/*** Test case Method Name : validateTest2678
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage validateTest2678(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		testcasemethod = "PL flow";
	try{
		
		String startdate = null, enddate = null, equalsvalueof = null;
		Boolean isselected = false;
		
		//the excel input value should be supplied to start date and end date
		
		try {

			String filename = reusableComponents.getPropValues("Financialreportsinput");
			String sheetname = reusableComponents.getPropValues("TC3");
			
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
			// TODO Auto-generated catch block
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
												// TODO Auto-generated catch block
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
												// TODO Auto-generated catch block
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
												// TODO Auto-generated catch block
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
								// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"Start button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
			
		}
		
		
		
		
		
		
		
		
		

		  
		   
		
		
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PlPage(browser);
	}
	
	
	

	/*** Test case Method Name : validateAssignerCode
	 * 	 Functionality         : validate login to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage ValidateAssignerCode(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
	try{
		
		String startdate = null, enddate = null;
		Boolean isselected = false;
		
		//the excel input value should be supplied to start date and end date
		
		try {

			String filename = reusableComponents.getPropValues("inputfilename");
			String sheetname = reusableComponents.getPropValues("sheetname");
			
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
				 if(row.getRowNum()==0 && row.getRowNum() == 1 ){
				       continue; //just skip the rows if row number is 0 or 1
				      }
				
				Iterator<Cell> celliterator = row.cellIterator();
				
				while(celliterator.hasNext()) {
  
					  Cell cell = celliterator.next(); 
					  final DataFormatter formatter = new DataFormatter(); 
					  
					  startdate_arr.add(formatter.formatCellValue(cell)); //throw new
					   
				}
			}
		

			

		

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}
		
		
		
		for(int i =0; i<startdate_arr.size();i++) {
			
			System.out.println(startdate_arr.get(i));
		}
		
		ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Reading Excel input sheet, successful", browser ,pathLoc+"/"+testcasemethod , false );
		startdate = startdate_arr.get(0);
		enddate = startdate_arr.get(1);
		
		if(startdate_arr.get(2).equalsIgnoreCase("true") || startdate_arr.get(2).equalsIgnoreCase("false")) {
			supressrows = Boolean.valueOf(startdate_arr.get(2));
		}else if(startdate_arr.get(2) == null || startdate_arr.get(2).equalsIgnoreCase(" ") || startdate_arr.get(2).equalsIgnoreCase("")) {
			ignore_supressrows = "true";
		}
		
		else {
			
			ignore_supressrows = "true";
		}
		
		
		
		System.out.println("start date "+startdate+" and end date "+enddate);
		
		
		
		
		//till here
		
//		startdate = reusableComponents.getPropValues("startvalue","plconfig");
//		enddate = reusableComponents.getPropValues("endvalue", "plconfig");
		
		ReusableComponents.wait(5200);
	
		if(ReusableComponents.isElementPresent(new_start_time_btn)){
			  ReusableComponents.wait(1200);
			  
			  System.out.println(" clear selection");
			  
			  
			  new_start_time_btn.click();
			  
			  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time btn is present and clearing selected start range", browser ,pathLoc+"/"+testcasemethod , false );
			  
			  System.out.println("btn clear");
			  ReusableComponents.wait(3200);
			  
			  if(ReusableComponents.isElementPresent(new_start_time_input)){
				  ReusableComponents.wait(1200);
				  
				  System.out.println(" input selection");
				  
				  new_start_time_input.click();
				  
				  System.out.println("btn clear");
				  ReusableComponents.wait(3200);
				  
				  new_start_time_input.sendKeys(startdate);

				  System.out.println("aft date");
				  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Start time btn is entered", browser ,pathLoc+"/"+testcasemethod , false );
				  
				  ReusableComponents.wait(3200);
				  
				  WebElement dyn_dropdown = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+startdate+"']/span[2]/span"));
				  
if(ReusableComponents.isElementPresent(dyn_dropdown)) { //dropdown
					  
					  ReusableComponents.wait(1200);
					  dyn_dropdown.click();
					  
					  
				  }else {
					  
					  System.out.println("dropdown not present");
				  }
				 		  
				  System.out.println("aft drop click");
				  
			
				  
				  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
				 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
				  }
				  else
				  { 
					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"btn is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true ); 
				  }
			  
			  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
			 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
			  }
			  else
			  { 
				  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"btn is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true ); 
			  }
		
		
		if(ReusableComponents.isElementPresent(new_end_time_btn)){
			  ReusableComponents.wait(1200);
			  
			  System.out.println(" clear selection end");
			  
			  new_end_time_btn.click();
			  
			  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "End time btn is present and clearing selected end range", browser ,pathLoc+"/"+testcasemethod , false );
			  
			  System.out.println("btn clear end");
			  ReusableComponents.wait(3200);
			  
			  if(ReusableComponents.isElementPresent(new_end_time_input)){
				  ReusableComponents.wait(1200);
				  
				  System.out.println(" input selection end");
				  
				  new_end_time_input.click();
				  
				  System.out.println("btn clear end");
				  ReusableComponents.wait(3200);
				  
				  new_end_time_input.sendKeys(enddate);
				  
				  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "End time entered", browser ,pathLoc+"/"+testcasemethod , false );

				  System.out.println("aft date");
				  
				  ReusableComponents.wait(3200);
				  
				  WebElement dyn_dropdown1 = browser.findElement(By.xpath("//div[@role='listbox']//ul[@role='presentation']//li[@role='presentation']//span[@data-recordname='"+enddate+"']/span[2]/span"));
				  
if(ReusableComponents.isElementPresent(dyn_dropdown1)) { //dropdown1
					  
					  ReusableComponents.wait(1200);
					  dyn_dropdown1.click();
					  
					  
				  }else {
					  
					  System.out.println("dropdown not present");
				  }
				 
//				  
				 
				  
				  System.out.println("aft drop click");
				  
				  
				  
				  /* after clicking the end date, need to check if the check box is already selected or not
				   * if not then based on the test case we need to select it
				   * else need to unselect it
				   * 
				   * add a case for NA
				   */
				  
				  
				  
				  if(ignore_supressrows.equalsIgnoreCase("true")) {
					  
					  ReusableComponents.reportPass( threadID , tempList , testcasemethod , "supress zero amount rows not applicable", browser ,pathLoc+"/"+testcasemethod , false );
				  }else {
					  
					  // supress rows selection
					  
					  if(ReusableComponents.isElementPresent(check_suppressZeroAmountRows)) {
						  
							isselected = check_suppressZeroAmountRows.isSelected();
							
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
				  
				  
				  
				  
				  
				  
				  
			//	  Select dropdown1 = new Select(dropdown);
//				  
//				  dropdown1.selectByVisibleText("2020-06");
				  
				  ReusableComponents.wait(3200);
				  
				  if(ReusableComponents.isElementPresent(new_click_btn_run)) {
					  
					  ReusableComponents.wait(1200);
					  new_click_btn_run.click();
					  ReusableComponents.wait(2200);
					  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report generation", browser, pathLoc+"/"+testcasemethod, true);
					  
					  
				  }else {
					  
					  System.out.println("run btn not present");
				  }
				  
				//  ReusableComponents.wait(5200);
				  
				  ReusableComponents.wait(4200);
				  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report generation", browser, pathLoc+"/"+testcasemethod, true);
				  
				  
				  ReusableComponents.wait(15200);
//					((JavascriptExecutor) browser)
//					.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//					
//					 ReusableComponents.wait(5200);
//					
//					JavascriptExecutor js = (JavascriptExecutor) browser;
//					   js.executeScript("window.scrollBy(document.body.scrollHeight,0)");
					
					
				  
				  // this test is to see the generated report and click it, validate and return back
				  // which is not feasible in environments used by all as the records will be more
				  // and the time taken by the reports will need too much wait
				  
				  
				 // commenting the report click alone just reading the report name
				  
					if(ReusableComponents.isElementPresent(reportname)) {
						  
						  ReusableComponents.wait(1200);
						  
						 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report name is "+reportname.getText().toUpperCase()+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
						  ReusableComponents.wait(1200);
						  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report name is " +reportname.getText().toUpperCase() +" and link for report "+reportname.getAttribute("href")+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
						  
						 // validateTestD(threadID, tempList, pathLoc);
						  
						  
						  
					  }else {
						  
						  System.out.println("report not present");
					  }
					
					
					
				  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
				 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
				  }
				  else
				  { 
					  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"btn is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true ); 
				  }
			  
			  //ReusableComponents.reportPass(threadID, tempList, testcasemethod, "test", browser, pathLoc+"/"+testcasemethod, false);
			 // ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "before report generation", browser, pathLoc+"/"+testcasemethod, true);
			  }
			  else
			  { 
				  ReusableComponents.reportFail( threadID , tempList , testcasemethod ,"btn is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true ); 
			  }
		 
		
		
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PlPage(browser);
	}

	
	
	/*** Test case Method Name : validateTestD
	 * 	 Functionality         : validate navigation to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage validateTestD(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
	try{
		
		ReusableComponents.wait(4200);

		if(ReusableComponents.isElementPresent(new_click_btn_run)) {
			  
			  ReusableComponents.wait(1200);

		        JavascriptExecutor js1 = (JavascriptExecutor) browser;
		       
		        try {
					
					//This will scroll the page Horizontally till the element is found		
					js1.executeScript("arguments[0].scrollIntoView();", new_click_btn_run);
					
					ReusableComponents.wait(1200);
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report name is "+reportname.getText().toUpperCase()+" is generated in this iteration", browser, pathLoc+"/"+testcasemethod, true);
					
					String hrefvalue = reportname.getAttribute("href");
					

					try {
						
							ReusableComponents.wait(1200);
							
							((JavascriptExecutor) browser).executeScript("window.open()");
							
							ArrayList<String> tabs2 = new ArrayList<String> (browser.getWindowHandles());
							  browser.switchTo().window(tabs2.get(1));
							  
							  browser.get(hrefvalue);
							  
							  ReusableComponents.wait(5200);
							  
							  ReusableComponents.reportSpecific(threadID, tempList, testcasemethod,  "report page", browser, pathLoc+"/"+testcasemethod, true);
							    
							  ReusableComponents.wait(1200);
							  
							  browser.close();
							  browser.switchTo().window(tabs2.get(0));

						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("unable to click");
					}
					
														
					ReusableComponents.wait(4200);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		  
			  
		  }else {
			  
			  System.out.println("report not present");
		  }
		
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PlPage(browser);
	}

	
	/*** Test case Method Name : ValidateExcelOutput
	 * 	 Functionality         : validate navigation to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage ValidateExcelOutput(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
	try{
		
		try {

			ReusableComponents.wait(5500);
			String sheetname = reusableComponents.getPropValues("outputSheet2676");
			String filepath = reusableComponents.getPropValues("PNLReports");
			String outfilename = reusableComponents.getPropValues("ReportName");
			String filedetails = workingDir + "/" + filepath + "/" + outfilename + ".xls";
			
			FileInputStream inputStream = new FileInputStream(new File(filedetails));
			//Workbook workbook = WorkbookFactory.create(inputStream);
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);


			Sheet sheet = workbook.getSheet(sheetname);

			//HSSFSheet sheet = workbook.createSheet("outputSheet2676");// creating a blank sheet
			int rownum;
			 //int rowCount = sheet.getLastRowNum();

			if( sheet.getLastRowNum() == 0) {
				rownum = 1;
				System.out.println("in if");
			}else if (sheet.getLastRowNum() > 0) {
				rownum = sheet.getLastRowNum();
				rownum++;
				System.out.println("in else if");
			}else {
				rownum = 0;
				System.out.println("in else");
			}

			
//			for (String name : outarray) {
//				Row row = sheet.createRow(rownum++);
//				
//				int columncount = 0;
//				Cell cell = row.createCell(columncount);
//				cell.setCellValue(name);
//
//			}
			Row row = sheet.createRow(rownum++);
			for(int i=0; i<outarray.size();i++) {
				
				
				Cell cell = row.createCell(i);
				cell.setCellValue(outarray.get(i));
			}


			File file = new File(workingDir + "/" + filepath + "/" + outfilename + ".xls");
			System.out.println(file);

			inputStream.close();
			
			FileOutputStream out = new FileOutputStream(file); // file name with path
			workbook.write(out);
			out.close();

			outarray.clear();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PlPage(browser);
	}
	
	/*** Test case Method Name : Validatexpathreader
	 * 	 Functionality         : validate navigation to Accounting seed salesforce financial reports page Lightning
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  PlPage Hashmaper(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
	try{
		
		try {
			
			try {

				String filename = reusableComponents.getPropValues("inputfile");
				String sheetname = reusableComponents.getPropValues("PLSheet");
				
				//xpather.put("Financialreportsinput", filename);
				//xpather.put("TC1", sheetname);
				//String outfilename = reusableComponents.getPropValues("outputfilename");
				//String outsheetname = reusableComponents.getPropValues("outputsheetname");

				File file = new File(workingDir + "/xpath/" + filename);
				System.out.println(" file location "+file);
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

					
					
					 else {
						 
						 Iterator<Cell> celliterator = row.cellIterator();
							
							while(celliterator.hasNext()) {
			  
								  Cell cell = celliterator.next(); 
								  

								  final DataFormatter formatter = new DataFormatter(); 
						
								  
								  //startdate_arr.add(formatter.formatCellValue(cell)); //throw new
								  xpather.put(formatter.formatCellValue(row.getCell(0)), formatter.formatCellValue(row.getCell(1)));
								   
							}
						 
					 }
					 
					 
					
				}
			
				String s = "New";
				//System.out.println(Arrays.asList(xpather));
				
//				for (Entry<String, String> valcheck : xpather.entrySet()) {
//					
//					System.out.println(valcheck.getKey()+" : "+valcheck.getValue());
//				}
				
				for (Entry<String, String> valcheck : xpather.entrySet()) {
					
					if(valcheck.getKey().equals(s)) {
						
						System.out.println("printing the value "+valcheck.getValue());
					}
					
					//System.out.println(valcheck.getKey()+" : "+valcheck.getValue());
				}

				
				// write the action type as well so that when we perform actions
				// we can call the specific method directly
				// like new button is to click then action should be click
				// if the field is text box like login , mark it as send
				// if its checkbox mark the method as check
				//if its radio button, mark it as radio
				

			

			} catch (NoSuchElementException e) {
				
				outarray.add("File name NA");
				outarray.add("Sheet name NA");
				ReusableComponents.reportFail(threadID, tempList, testcasemethod,
						" Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new PlPage(browser);
	}

	
	

}


