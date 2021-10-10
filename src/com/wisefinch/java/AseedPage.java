package com.wisefinch.java;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.time.format.*;
import java.time.LocalDateTime;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;






/**
 * Base class for all the pages.
 *
 */
public class AseedPage extends DriverScript{
	protected WebDriver browser;
		
	ReusableComponents reusableComponents = new  ReusableComponents();
	/**
	 * Constructor for Page class 
	 * @param browser
	 * @param report
	 */
	protected AseedPage(WebDriver browser) {
		this.browser=browser;		
		PageFactory.initElements(browser, this);
	
	}


public AseedPage() {
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
	
	/*** Test case Method Name : validateTestA
	 * 	 Functionality         : validate login to Accounting seed salesforce
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  AseedPage validateTestA(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
	try{
		String username = null, pass_login = null;
		
		//browser.switchTo().defaultContent();
		
		username = reusableComponents.getPropValues("Aseeduserid");
		pass_login = reusableComponents.getPropValues("Aseedpass");
		
		
		ReusableComponents.wait(2300);
		
		if(ReusableComponents.isElementPresent(login_user_field)){
			
			ReusableComponents.wait(1200);
		//	ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login_user_field is present", browser ,pathLoc+"/"+testcasemethod , false );
			
			login_user_field.sendKeys(username);
			
			if(ReusableComponents.isElementPresent(login_pass_field)){
				
				login_pass_field.sendKeys(pass_login);				
				ReusableComponents.wait(1200);
				
				if(ReusableComponents.isElementPresent(login_btn)){
					
					ReusableComponents.wait(1200);
					login_btn.click();
					ReusableComponents.wait(15500);
					
				}else{
					ReusableComponents.reportFail( threadID , tempList , testcasemethod , "login button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
				}
				
			}else{
				ReusableComponents.reportFail( threadID , tempList , testcasemethod , "password field is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
			}
						
		}else{
			ReusableComponents.reportFail( threadID , tempList , testcasemethod , "login_user_field is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
		}
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new AseedPage(browser);
	}

	
	
	/*** Test case Method Name : validateTestOpp
	 * 	 Functionality         : validate opportunity creation
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  AseedPage validateTestOpp(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
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
		
		return new AseedPage(browser);
	}

	
	

}


