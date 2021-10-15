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
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
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
import org.openqa.selenium.support.ui.*;

/**
 * Base class for all the pages.
 *
 */
public class T2599Page extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected T2599Page(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public T2599Page() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;

	@FindBy(xpath = "//img[@title=' Financial Reports']")
	WebElement Reports;

	@FindBy(xpath = "//button[contains(text(),'Select Standard Report')]")
	WebElement Select_report_type;
	
	@FindBy(xpath = "//span[normalize-space()='Profit & Loss']")
	WebElement Profit_Loss;
	
	@FindBy(xpath = "//c-lookup[contains(.,'*Starting Accounting Period')]//input[@role='textbox']")
	WebElement Starting_period;
	
	@FindBy(xpath = "//span[@class='slds-listbox__option-text slds-listbox__option-text_entity']")
	WebElement Starting_period1;
	
	@FindBy(xpath = "(.//*[@title='Remove selected option'])[1]")
	WebElement deselect_speriod;
	
	@FindBy(xpath = "//c-lookup[@data-jest='endingAccountingPeriod']//input[@role='textbox']")
	WebElement End_period;
	
	@FindBy(xpath = "(.//*[@title='Remove selected option'])[2]")
	WebElement deselect_eperiod;	
	
	@FindBy(xpath = "//button[@title='Run Report']")
	WebElement Run_report;
	
	//@FindBy(xpath = "//label[@for='primitive-cell-checkbox-id-212']//span[@class='slds-checkbox_faux']")
	//WebElement select_checkbox;	
	
	@FindBy(xpath = "//*[@id=\"tab-1\"]/slot/c-fin-reporter-std-reports/div[2]/div[2]/c-fin-reporter-table/lightning-card/article/div[2]/slot/div/c-applicable-items/c-applicable-items-custom-datatable/div[2]/div/div/table/tbody/tr[1]/td[1]/lightning-primitive-cell-checkbox/span/label/span[1]")
	WebElement select_checkbox;	
	
	@FindBy(xpath = "//button[normalize-space()='Delete Reports']")
	WebElement Delete_report;
	
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement delete_yes;	
	
	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();

	String billing_line_new = null, billing_line_pass =null;

	/***
	 * Test case Method Name : validateTestA 
	 * Functionality : validate T2599 Page
	 * Created By : Anitha
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2599Page validateTestA(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String username = null, pass_login = null;

			// browser.switchTo().defaultContent();

			username = reusableComponents.getPropValues("usernamesf");
			pass_login = reusableComponents.getPropValues("passwordsf");

			ReusableComponents.wait(2300);

			if (ReusableComponents.isElementPresent(Username_field)) {

				ReusableComponents.wait(1200);
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login username field is present", browser ,pathLoc+"\\"+testcasemethod , false);

				Username_field.sendKeys(username);

				if (ReusableComponents.isElementPresent(Password_field)) {

					Password_field.sendKeys(pass_login);
					ReusableComponents.wait(1200);
					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login password field is present", browser ,pathLoc+"\\"+testcasemethod , false);

					if (ReusableComponents.isElementPresent(Login_button)) {
						
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Login page", browser, pathLoc+"\\"+testcasemethod, true);
						ReusableComponents.wait(1200);
						Login_button.click();
						ReusableComponents.wait(15500);
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login button is present", browser ,pathLoc+"\\"+testcasemethod , false);

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login button is NOT present ", browser, pathLoc + "\\" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login password field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login username field is NOT present", browser, pathLoc + "\\" + testcasemethod, true);
			}

		} catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);
		
			}
		
		return new T2599Page(browser);
		
	}

	/***
	 * Test case Method Name : validateTestB
	 * Functionality : validate T2599 Page
	 * Created By : Anitha
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized T2599Page validateTestB(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			//String s_report = reusableComponents.getPropValues("selectreport_2599");
			//String ledger = reusableComponents.getPropValues("ledg_2697");
			String s_period = reusableComponents.getPropValues("Starting_AccountingPeriod");
			String e_period = reusableComponents.getPropValues("Ending_AccountingPeriod");
			
			ReusableComponents.wait(5200);
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"\\"+testcasemethod, true);
			ReusableComponents.wait(3200);
		
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(3200);
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
			ReusableComponents.wait(3200);
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
			ReusableComponents.wait(3200);

			List<WebElement> f = browser.findElements(By.tagName("frame"));
			int i = f.size();
			System.out.println(i + "is the frame count");

			browser.switchTo().frame(0);

			ReusableComponents.wait(5200);

			if (ReusableComponents.isElementPresent(Reports)) {

				ReusableComponents.wait(4200);
				Reports.click();
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Financial Reports tab is present", browser ,pathLoc+"\\"+testcasemethod , false);
				ReusableComponents.wait(6200);
				
				browser.navigate().refresh();				
				browser.navigate().refresh();
				ReusableComponents.wait(10000);

				if (ReusableComponents.isElementPresent(Select_report_type)) {

					ReusableComponents.wait(4200);
					Select_report_type.click();
					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Select Standard Report dropdown is present", browser ,pathLoc+"\\"+testcasemethod , false);
					//ReusableComponents.wait(6200);				
					
					if (ReusableComponents.isElementPresent(Profit_Loss)) {

						ReusableComponents.wait(4200);
						Profit_Loss.click();
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Profit & Loss option is present in the dropdown", browser ,pathLoc+"\\"+testcasemethod , false);		
					
											
						if (ReusableComponents.isElementPresent(Starting_period)) {

							ReusableComponents.wait(4200);
							deselect_speriod.click();																		
							ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Starting Accounting Period searchbox is present", browser ,pathLoc+"\\"+testcasemethod , false);
							ReusableComponents.wait(5200);
							Starting_period.sendKeys(s_period);
							ReusableComponents.wait(4200);
							
							Starting_period1.click();
							ReusableComponents.wait(6200);
							//WebElement start_click = browser.findElement(By.xpath("//span[contains(text(),'"+s_period+"')]"));
							//start_click.click();						
							//System.out.println("start selected");
							//ReusableComponents.wait(5200);
							
							
					
							if (ReusableComponents.isElementPresent(End_period)) {

								ReusableComponents.wait(4200);
								//End_period.clear();
								//ReusableComponents.wait(4200);
								ReusableComponents.wait(4200);							
								deselect_eperiod.click();
								End_period.sendKeys(e_period);
								ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Ending Accounting Period searchbox is present", browser ,pathLoc+"\\"+testcasemethod , false);
								ReusableComponents.wait(6200);
								Starting_period1.click();
								ReusableComponents.wait(6200);
								//WebElement end_click = browser.findElement(By.xpath("//span[contains(text(),'"+e_period+"')]"));
								//end_click.click();
								//System.out.println("end selected");
								//ReusableComponents.wait(5200);

								
								ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Profit & Loss Report page", browser, pathLoc+"\\"+testcasemethod, true);
						
								if (ReusableComponents.isElementPresent(Run_report)) {

									ReusableComponents.reportPass( threadID , tempList , testcasemethod , "run report button is present", browser ,pathLoc+"\\"+testcasemethod , false);
									ReusableComponents.wait(4200);
									Run_report.click();
									System.out.println("screenshot next");
									ReusableComponents.wait(4200);
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of expected error message from page", browser, pathLoc+"\\"+testcasemethod, true);
									ReusableComponents.wait(9200);

									}
								if (ReusableComponents.isElementPresent(Delete_report)) {

									ReusableComponents.reportPass( threadID , tempList , testcasemethod , "Delete Reports button is present", browser ,pathLoc+"\\"+testcasemethod , false);
									ReusableComponents.wait(4200);
									
									select_checkbox.click();
									ReusableComponents.wait(5200);
									Delete_report.click();						
									ReusableComponents.wait(5200);
									delete_yes.click();
									ReusableComponents.wait(9200);
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of expected error message from page", browser, pathLoc+"\\"+testcasemethod, true);
									ReusableComponents.wait(5200);
									
									boolean deletesuccess =  select_checkbox.isDisplayed();
									if(deletesuccess != true)
									{
                                        System.out.println("The report is deleted successfully from the page ");
									}
									else
									{
										System.out.println("The report is still displayed in the page");
									}
								}
								//else {
									//ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Delete Report button NOT present", browser, pathLoc + "\\" + testcasemethod, true);
								//}
								
							
								else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "run report button NOT present", browser, pathLoc + "\\" + testcasemethod, true);
									}
								
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "end period searchbox NOT present", browser, pathLoc + "\\" + testcasemethod, true);
								}
							
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "start period searchbox NOT present", browser, pathLoc + "\\" + testcasemethod, true);
							}
						
						} 

					else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Profit & Loss is NOT present in the dropdown", browser, pathLoc + "\\" + testcasemethod, true);
					}} 
				else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Select Standard Report dropdown NOT present", browser, pathLoc + "\\" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Financial Reports tab NOT present", browser, pathLoc + "\\" + testcasemethod, true);
			}
			
			browser.switchTo().defaultContent();
		
		} 
		catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "\\" + testcasemethod, false);
		
			}
		
		return new T2599Page(browser);
		
	}
	
}
