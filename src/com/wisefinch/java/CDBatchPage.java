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
public class CDBatchPage extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected CDBatchPage(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public CDBatchPage() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;
	
	@FindBy(xpath = "//img[@title='Cash Disbursement Batches']")
	WebElement CDBatches;

	@FindBy(xpath = "//div[@title='New']")
	WebElement CDB_New;
	
	@FindBy(xpath = "//input[contains(@name,'Name')]")
	WebElement CDB_name;
	
	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Save;

	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();

	/***
	 * Test case Method Name : validateTestA 
	 * Functionality : validate CDBatch Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized CDBatchPage validateTestA(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String username = null, pass_login = null;

			// browser.switchTo().defaultContent();

			username = reusableComponents.getPropValues("usernamesf");
			pass_login = reusableComponents.getPropValues("passwordsf");

			ReusableComponents.wait(2300);

			if (ReusableComponents.isElementPresent(Username_field)) {

				ReusableComponents.wait(1200);
				ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login username field is present", browser ,pathLoc+"/"+testcasemethod , false);

				Username_field.sendKeys(username);

				if (ReusableComponents.isElementPresent(Password_field)) {

					Password_field.sendKeys(pass_login);
					ReusableComponents.wait(1200);
					ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login password field is present", browser ,pathLoc+"/"+testcasemethod , false);

					if (ReusableComponents.isElementPresent(Login_button)) {
						
						ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Login page", browser, pathLoc+"/"+testcasemethod, true);
						ReusableComponents.wait(1200);
						Login_button.click();
						ReusableComponents.wait(15500);
						ReusableComponents.reportPass( threadID , tempList , testcasemethod , "login button is present", browser ,pathLoc+"/"+testcasemethod , false);

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login button is NOT present ", browser, pathLoc + "/" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login password field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "login username field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is NOT present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}

		return new CDBatchPage(browser);
	}

	/***
	 * Test case Method Name : validateTestB 
	 * Functionality : validate GLAccount Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized CDBatchPage validateTestB(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String account_name = reusableComponents.getPropValues("cdbname");

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"/"+testcasemethod, true);
			ReusableComponents.wait(3200);
			
		    List<WebElement> f = browser.findElements(By.tagName("frame"));
		    int i = f.size();
		    System.out.println(i +"is the frame count");

			browser.switchTo().frame(0);
			
			ReusableComponents.wait(6200);
			
			if (ReusableComponents.isElementPresent(CDBatches)) {
				
				ReusableComponents.wait(5200);
				CDBatches.click();
				ReusableComponents.wait(5200);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement Batches tab is present", browser, pathLoc + "/" + testcasemethod, false);
				
				if (ReusableComponents.isElementPresent(CDB_New)) {
					
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Disbursement Batches page", browser, pathLoc+"/"+testcasemethod, true);
					ReusableComponents.wait(5200);
					CDB_New.click();
					ReusableComponents.wait(5200);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement Batches New button is present", browser, pathLoc + "/" + testcasemethod, false);
					
					if (ReusableComponents.isElementPresent(CDB_name)) {
						
						ReusableComponents.wait(5200);
						CDB_name.sendKeys(account_name);
						ReusableComponents.wait(5200);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Disbursement Batches Name field is present", browser, pathLoc + "/" + testcasemethod, false);
						
						if (ReusableComponents.isElementPresent(Save)) {
							
							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Disbursement creation page", browser, pathLoc+"/"+testcasemethod, true);	
							ReusableComponents.wait(5200);
							Save.click();
							ReusableComponents.wait(5200);
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "/" + testcasemethod, false);
								
							}
						else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is not present", browser, pathLoc + "/" +testcasemethod, true);
							}
						}
					
					else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement Batches Name field is not present", browser, pathLoc + "/" +testcasemethod, true);
						}
					
					}
				else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement Batches New button is not present", browser, pathLoc + "/" +testcasemethod, true);
					}
				
				}
			else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Disbursement Batches tab is not present", browser, pathLoc + "/" +testcasemethod, true);
				}
			
			browser.switchTo().defaultContent();
			
			}
		
		catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			
		}
		
		return new CDBatchPage(browser);
		
	}
	
}
