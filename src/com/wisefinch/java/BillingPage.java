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

//import jdk.internal.misc.FileSystemOption;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.*;

/**
 * Base class for all the pages.
 *
 */
public class BillingPage extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected BillingPage(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public BillingPage() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;
	
	@FindBy(xpath = "//img[@src='/img/icon/t4v35/custom/custom42_120.png']")
	WebElement Billing_tab;
	
	@FindBy(xpath = "//div[@title='New']")
	WebElement New;
	
	@FindBy(xpath = "//force-record-layout-section[1]//force-record-layout-row[4]//input[1]")
	WebElement Posting_status;
	
	@FindBy(xpath = "//force-record-layout-section[3]//force-record-layout-row[1]//force-record-layout-item[1]//input[1]")
	WebElement Customer;
	
	//@FindBy(xpath = "//div[4]//div[2]//div[4]//flexipage-component2[1]//flexipage-component2[2]//ul[1]/li[1]//button[1]")
	@FindBy(xpath = "//button[normalize-space()='New']")
	WebElement New_Bline;
	
	@FindBy(xpath = "//input[@name='AcctSeed__Date__c']")
	WebElement Date;
	
	@FindBy(xpath = "//div/input[@name='AcctSeed__Rate__c']")
	WebElement Unit_price;

	@FindBy(xpath = "//div/input[@name='AcctSeed__Hours_Units__c']")
	WebElement Quantity;
	
	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Save;
	
	@FindBy(xpath = "//button[.='Post']")
	WebElement Post;
	
	@FindBy(xpath = "//div[@class='pbHeader']//tbody//input[@value='Post']")
	WebElement Post_final;

	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();

	/***
	 * Test case Method Name : validateTestA
	 * Functionality : validate Billing Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized BillingPage validateTestA(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
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

		return new BillingPage(browser);
	}

	/***
	 * Test case Method Name : validateTestB 
	 * Functionality : validate Billing Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized BillingPage validateTestB(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String account_name = reusableComponents.getPropValues("accname");
			String post_status = reusableComponents.getPropValues("postingstatus");
	
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"/"+testcasemethod, true);
			ReusableComponents.wait(6200);
			
		    List<WebElement> f = browser.findElements(By.tagName("frame"));
		    int i = f.size();
		    System.out.println(i +" is the frame count");

			browser.switchTo().frame(0);
			
			ReusableComponents.wait(8200);
			
			if (ReusableComponents.isElementPresent(Billing_tab)) {

				ReusableComponents.wait(3200);
				Billing_tab.click();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing tab is present", browser, pathLoc + "/" + testcasemethod, false);
				ReusableComponents.wait(5500);
				ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Billing page", browser, pathLoc+"/"+testcasemethod, true);
				
				if (ReusableComponents.isElementPresent(New)) {

					ReusableComponents.wait(3200);
					New.click();
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing New button is present", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.wait(5500);
					
					if (ReusableComponents.isElementPresent(Posting_status)) {

						ReusableComponents.wait(3200);
						Posting_status.click();
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing Posting status selectbox is present", browser, pathLoc + "/" + testcasemethod, false);
						ReusableComponents.wait(5500);
						
						String P_stat = "//span[@title='"+post_status+"']";
						
						WebElement selecttype = browser.findElement(By.xpath(P_stat));
						ReusableComponents.wait(5500);
						new WebDriverWait(browser, 20).until(ExpectedConditions.elementToBeClickable(selecttype)).click();
						ReusableComponents.wait(5500);
						
						if (ReusableComponents.isElementPresent(Customer)) {

							ReusableComponents.wait(3200);
							Customer.sendKeys(account_name);
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing Customer searchbox is present", browser, pathLoc + "/" + testcasemethod, false);
							ReusableComponents.wait(5500);
							
							WebElement Vendor_click = browser.findElement(By.xpath(".//*[contains(text(),'" + account_name + "')]"));
							List<WebElement> dropdownelement = browser.findElements(By.xpath(".//*[contains(text(),'" + account_name + "')]"));
							int j = dropdownelement.size();

							System.out.println(j + " is the element count");

							if (ReusableComponents.isElementPresent(Vendor_click)) {

								System.out.println("Customer selected");
								ReusableComponents.wait(5200);
								dropdownelement.get(j - 1).click();
								ReusableComponents.wait(5200);
								System.out.println("action called");
								ReusableComponents.wait(5200);

							}
							
							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Billing creation page", browser, pathLoc+"/"+testcasemethod, true);
							
							if (ReusableComponents.isElementPresent(Save)) {

								ReusableComponents.wait(3200);
								Save.click();
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "/" + testcasemethod, false);
								ReusableComponents.wait(5500);
						
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
									}
							
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing Customer searchbox is NOT present", browser, pathLoc + "/" + testcasemethod, true);
								}
						

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing Posting status selectbox is NOT present", browser, pathLoc + "/" + testcasemethod, true);
							}
					

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing New button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
						}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing tab is NOT present", browser, pathLoc + "/" + testcasemethod, true);
					}
			
				browser.switchTo().defaultContent();
			
			}
		catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			
		}
		
		return new BillingPage(browser);
		
	}
	/***
	 * Test case Method Name : validateTestC 
	 * Functionality : validate Billing Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized BillingPage validateTestC(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String price = reusableComponents.getPropValues("unitprice");
			String quantity = reusableComponents.getPropValues("quantity");
			String DOBL = reusableComponents.getPropValues("date");
			
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of created billing page", browser, pathLoc+"/"+testcasemethod, true);
			ReusableComponents.wait(4200);
			
			for (int i = 0; i < 26; i++) {

				browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);

			}
			
			ReusableComponents.wait(8200);
			
			if (ReusableComponents.isElementPresent(New_Bline)) {

				ReusableComponents.wait(3200);
				New_Bline.click();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing line New button is present", browser, pathLoc + "/" + testcasemethod, false);
				ReusableComponents.wait(5500);
				
				if (ReusableComponents.isElementPresent(Date)) {

					ReusableComponents.wait(3200);
					Date.clear();
					Date.sendKeys(DOBL);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing line Date field is present", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.wait(5500);
				
				if (ReusableComponents.isElementPresent(Quantity)) {

					ReusableComponents.wait(3200);
					Quantity.clear();
					Quantity.sendKeys(quantity);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing line Quantity field is present", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.wait(5500);
					
					if (ReusableComponents.isElementPresent(Unit_price)) {

						ReusableComponents.wait(3200);
						Unit_price.clear();
						Unit_price.sendKeys(price);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing line Quantity field is present", browser, pathLoc + "/" + testcasemethod, false);
						ReusableComponents.wait(5500);
						
						if (ReusableComponents.isElementPresent(Save)) {

							ReusableComponents.wait(3200);
							Save.click();
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing line save button is present", browser, pathLoc + "/" + testcasemethod, false);
							ReusableComponents.wait(5500);
							
							if (ReusableComponents.isElementPresent(Post)) {

								ReusableComponents.wait(3200);
								Post.click();
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing line Post tab is present", browser, pathLoc + "/" + testcasemethod, false);
								ReusableComponents.wait(5500);
								
								browser.switchTo().frame(0);
								
								if (ReusableComponents.isElementPresent(Post_final)) {

									ReusableComponents.wait(3200);
									Post_final.click();
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Billing line Post button is present", browser, pathLoc + "/" + testcasemethod, false);
									ReusableComponents.wait(5500);
									
									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing line Post button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
										}
								
								browser.switchTo().defaultContent();
						
								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing line Post tab is NOT present", browser, pathLoc + "/" + testcasemethod, true);
									}
					
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing line save button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
								}
				
						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing line Quantity field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
							}
			
					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing line Quantity field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
						}
				
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing line Date field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
					}
		
				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Billing line New button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
					}
			
			}
		catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			
		}
		
		return new BillingPage(browser);
		
	}
	
}
