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
public class CashreceiptPage extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected CashreceiptPage(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public CashreceiptPage() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;
	
	@FindBy(xpath = "//img[@src='/img/icon/t4v35/custom/custom17_120.png']")
	WebElement Cash_Receipt_tab;
	
	@FindBy(xpath = "//div[@title='New']")
	WebElement New;
	
	@FindBy(xpath = "//div/slot/force-record-layout-row[2]/slot//input[contains(@placeholder,'Search Accounts..')]")
	WebElement Customer;
	
	@FindBy(xpath = "//div[@class='slds-form']//force-record-layout-row[3]//force-record-layout-item//lightning-combobox//input[@class='slds-input slds-combobox__input']")
	WebElement Type;
	
	@FindBy(xpath = "//input[@name='AcctSeed__Amount__c']")
	WebElement Amount;
	
	@FindBy(xpath = "//input[@name='AcctSeed__Payment_Reference__c']")
	WebElement Reference;
	
	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Save;
	
	@FindBy(xpath = "//button[.='Post']")
	WebElement Post;
	
	@FindBy(xpath = "//div[@class='pbHeader']//tbody//input[@value='Post']")
	WebElement Post_final;

	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();

	/***
	 * Test case Method Name : validateTestA Functionality : validate Secondday Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized CashreceiptPage validateTestA(int threadID, List<String> tempList, String pathLoc)
			
			throws IOException, AWTException {
		
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

		return new CashreceiptPage(browser);
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
	public synchronized CashreceiptPage validateTestB(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
		String testcasemethod = new Object() {}.getClass().getEnclosingMethod().getName();
		
		try {
			
			String account_name = reusableComponents.getPropValues("accname");
			String cramount = reusableComponents.getPropValues("amount");
			String crref = reusableComponents.getPropValues("ref");
			String receipt_type = reusableComponents.getPropValues("receipttype");
			
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"/"+testcasemethod, true);
			ReusableComponents.wait(6200);
			
		    List<WebElement> f = browser.findElements(By.tagName("frame"));
		    int i = f.size();
		    System.out.println(i +" is the frame count");

			browser.switchTo().frame(0);
			
			ReusableComponents.wait(6200);
			
			if (ReusableComponents.isElementPresent(Cash_Receipt_tab)) {

				ReusableComponents.wait(3200);
				Cash_Receipt_tab.click();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt tab is present", browser, pathLoc + "/" + testcasemethod, false);
				ReusableComponents.wait(5500);
				
				if (ReusableComponents.isElementPresent(New)) {

					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Reciept page", browser, pathLoc+"/"+testcasemethod, true);
					ReusableComponents.wait(3200);
					New.click();
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt New button is present", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.wait(5500);
					
					if (ReusableComponents.isElementPresent(Customer)) {

						ReusableComponents.wait(3200);
						Customer.sendKeys(account_name);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Customer searchbox is present", browser, pathLoc + "/" + testcasemethod, false);
						ReusableComponents.wait(8500);
						
						WebElement Customer_click = browser.findElement(By.xpath(".//*[contains(text(),'"+account_name+"')]"));
						List<WebElement> dropdownelement = browser.findElements(By.xpath(".//*[contains(text(),'"+account_name+"')]"));
						int j = dropdownelement.size();
						System.out.println(j +" is the element cont");
						
						if (ReusableComponents.isElementPresent(Customer_click)) {
							
							System.out.println("customer selected");
							ReusableComponents.wait(5200);
							dropdownelement.get(j-1).click();
							ReusableComponents.wait(5200);
							System.out.println("action called");
							ReusableComponents.wait(5200);
							
						}
							
							if (ReusableComponents.isElementPresent(Type)) {

								ReusableComponents.wait(3200);
								Type.click();
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt Type selectbox is present", browser, pathLoc + "/" + testcasemethod, false);
								ReusableComponents.wait(8500);
								
								String Receipt_type = "//lightning-base-combobox-item/span[@class='slds-media__body']/span[contains(text(),'"+receipt_type+"')]";
							
								WebElement selecttype = browser.findElement(By.xpath(Receipt_type));
								ReusableComponents.wait(5500);
								selecttype.click();
								
								/*
								 * WebElement testDropDown = browser.findElement(By.xpath(
								 * "//div[@class='slds-form-element__control']/lightning-base-combobox/div/div")
								 * ); Select dropdown = new Select(testDropDown);
								 * dropdown.selectByVisibleText("Customer Receipt");
								 */
									
									if (ReusableComponents.isElementPresent(Amount)) {

										ReusableComponents.wait(3200);
										Amount.sendKeys(cramount);
										ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt Amount field is present", browser, pathLoc + "/" + testcasemethod, false);
										ReusableComponents.wait(5500);
										
										if (ReusableComponents.isElementPresent(Reference)) {

											ReusableComponents.wait(3200);
											Reference.sendKeys(crref);
											ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Cash Receipt Reference field is present", browser, pathLoc + "/" + testcasemethod, false);
											ReusableComponents.wait(5500);
											
											if (ReusableComponents.isElementPresent(Save)) {

												ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Cash Reciept creation page", browser, pathLoc+"/"+testcasemethod, true);
												ReusableComponents.wait(3200);
												Save.click();
												ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "/" + testcasemethod, false);
												ReusableComponents.wait(10500);
												/*
												 * if (ReusableComponents.isElementPresent(Post)) {
												 * 
												 * ReusableComponents.wait(3200); Post.click();
												 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												 * "Post tab is present", browser, pathLoc + "/" + testcasemethod,
												 * false); ReusableComponents.wait(5500);
												 * 
												 * browser.switchTo().frame(0);
												 * 
												 * if (ReusableComponents.isElementPresent(Post_final)) {
												 * 
												 * ReusableComponents.wait(3200); Post_final.click();
												 * ReusableComponents.reportPass(threadID, tempList, testcasemethod,
												 * "Post final button is present", browser, pathLoc + "/" +
												 * testcasemethod, false); ReusableComponents.wait(5500);
												 * 
												 * 
												 * } else { ReusableComponents.reportFail(threadID, tempList,
												 * testcasemethod, "Post final button is NOT present", browser, pathLoc
												 * + "/" + testcasemethod, true); }
												 * 
												 * 
												 * browser.switchTo().defaultContent();
												 * 
												 * } else { ReusableComponents.reportFail(threadID, tempList,
												 * testcasemethod, "Post button is NOT present", browser, pathLoc + "/"
												 * + testcasemethod, true); }
												 */
												
											} else {
												ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save is button NOT present", browser, pathLoc + "/" + testcasemethod, true);
											}
											
										} else {
											ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt Reference field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
										}	
										
									} else {
										ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt Amount field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
									}
									
							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt Type selectbox is NOT present", browser, pathLoc + "/" + testcasemethod, true);
							}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Customer searchbox is NOT present", browser, pathLoc + "/" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt New button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Cash Receipt tab is NOT present", browser, pathLoc + "/" + testcasemethod, true);
			}
			
			browser.switchTo().defaultContent();
			
			}
		
		catch (NoSuchElementException e) {
			
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
			
			}
		
		return new CashreceiptPage(browser);
		
	}
	
}
