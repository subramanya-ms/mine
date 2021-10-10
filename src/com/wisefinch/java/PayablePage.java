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
import org.openqa.selenium.remote.server.handler.SendKeys;
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
public class PayablePage extends DriverScript {
	protected WebDriver browser;

	ReusableComponents reusableComponents = new ReusableComponents();

	/**
	 * Constructor for Page class
	 * 
	 * @param browser
	 * @param report
	 */
	protected PayablePage(WebDriver browser) {
		this.browser = browser;
		PageFactory.initElements(browser, this);

	}

	public PayablePage() {
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement Username_field;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password_field;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement Login_button;

	@FindBy(xpath = "//span[@class='uiImage']/img[@src='/img/icon/t4v35/custom/custom14_120.png']")
	WebElement Payee_tab;

	@FindBy(xpath = "//div[@title='New']")
	WebElement New;

	@FindBy(xpath = "//div[@class='slds-form']//force-record-layout-row[3]//force-record-layout-item//lightning-combobox//input[@class='slds-input slds-combobox__input']")
	WebElement Posting_status;

	@FindBy(xpath = "//span[@title='Approved']")
	WebElement Status;

	@FindBy(xpath = "//input[@name='AcctSeed__Payee_Reference__c']")
	WebElement Payee_Reference;

	@FindBy(xpath = "//force-record-layout-row[1]/slot[1]/force-record-layout-item[1]//force-record-layout-lookup[1]//input[1]")
	WebElement Vendor;

	// @FindBy(xpath = "//button[@name='New']")
	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement New_PLine;

	@FindBy(xpath = "//input[@name='AcctSeed__Unit_Cost__c']")
	WebElement Unit_cost;

	@FindBy(xpath = "//force-record-layout-row[1]//force-record-layout-item[1]//force-record-layout-lookup[1]//lightning-grouped-combobox[1]//lightning-base-combobox[1]//input[1]")
	WebElement Expense_GL_Account;

	@FindBy(xpath = "//button[@name='SaveEdit']")
	WebElement Save;

	@FindBy(xpath = "//button[.='Post']")
	WebElement Post;

	@FindBy(xpath = "//div[@class='pbHeader']//tbody//input[@value='Post']")
	WebElement Post_final;

	String[] startdate_arr;
	ArrayList<String> enddate_arr = new ArrayList<String>();

	/***
	 * Test case Method Name : validateTestA Functionality : validate Payable Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
public synchronized PayablePage validateTestA(int threadID, List<String> tempList, String pathLoc) throws IOException, AWTException {
		
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

		return new PayablePage(browser);
	}

	/***
	 * Test case Method Name : validateTestB
	 * Functionality : validate Payable Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized PayablePage validateTestB(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			String status_p = reusableComponents.getPropValues("postingstatus");
			String account_name = reusableComponents.getPropValues("accname");
			String pref = reusableComponents.getPropValues("ref");

			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Accounting Home page", browser, pathLoc+"/"+testcasemethod, true);
			ReusableComponents.wait(3200);

			List<WebElement> f = browser.findElements(By.tagName("frame"));
			int i = f.size();
			System.out.println(i + "is the frame count");

			browser.switchTo().frame(0);

			ReusableComponents.wait(6200);

			if (ReusableComponents.isElementPresent(Payee_tab)) {

				ReusableComponents.wait(3200);
				Payee_tab.click();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Payable tab is present", browser, pathLoc + "/" + testcasemethod, false);
				ReusableComponents.wait(5500);

				if (ReusableComponents.isElementPresent(New)) {
					
					ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Payables page", browser, pathLoc+"/"+testcasemethod, true);
					ReusableComponents.wait(3200);
					New.click();
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New Payable button is present", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.wait(6500);

					if (ReusableComponents.isElementPresent(Posting_status)) {

						ReusableComponents.wait(5200);
						Posting_status.click();
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Payable Posting status selectbox is present", browser, pathLoc + "/" + testcasemethod, false);
						ReusableComponents.wait(5500);

						String Status_type = "//span[@title='" + status_p + "']";
						WebElement statustype = browser.findElement(By.xpath(Status_type));
						ReusableComponents.wait(5500);
						statustype.click();
						System.out.println("payable posting status is selected");
						ReusableComponents.wait(5500);

						if (ReusableComponents.isElementPresent(Payee_Reference)) {

							ReusableComponents.wait(4200);
							Payee_Reference.sendKeys(pref);
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Payee Reference field is present", browser, pathLoc + "/" + testcasemethod, false);
							ReusableComponents.wait(5500);

							if (ReusableComponents.isElementPresent(Vendor)) {

								ReusableComponents.wait(4200);
								Vendor.sendKeys(account_name);
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Vendor searchbox is present", browser, pathLoc + "/" + testcasemethod, false);
								ReusableComponents.wait(5500);

								WebElement Vendor_click = browser.findElement(By.xpath(".//*[contains(text(),'" + account_name + "')]"));
								List<WebElement> dropdownelement = browser.findElements(By.xpath(".//*[contains(text(),'" + account_name + "')]"));
								int j = dropdownelement.size();

								System.out.println(j + " is the element count");

								if (ReusableComponents.isElementPresent(Vendor_click)) {

									System.out.println("Vendor selected");
									ReusableComponents.wait(5200);
									dropdownelement.get(j - 1).click();
									ReusableComponents.wait(5200);
									System.out.println("action called");
									ReusableComponents.wait(5200);

								}

								if (ReusableComponents.isElementPresent(Save)) {
									
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Payable creation page", browser, pathLoc+"/"+testcasemethod, true);
									ReusableComponents.wait(3200);
									Save.click();
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "/" + testcasemethod, false);
									ReusableComponents.wait(5500);

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
								}

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Vendor searchbox is NOT present", browser, pathLoc + "/" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Payee Reference field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Payble Posting status selectbox is NOT present", browser, pathLoc + "/" + testcasemethod,
								true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Payable New button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Payable tab is NOT present", browser, pathLoc + "/" + testcasemethod, true);
			}

			browser.switchTo().defaultContent();

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod,
					"Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}
		return new PayablePage(browser);
	}

	/***
	 * Test case Method Name : validateTestC
	 * Functionality : validate Payable Page
	 * Created By : Lakshman
	 * 
	 * @throws IOException
	 * @throws AWTException
	 * 
	 ***/
	public synchronized PayablePage validateTestC(int threadID, List<String> tempList, String pathLoc)
			throws IOException, AWTException {
		String testcasemethod = new Object() {
		}.getClass().getEnclosingMethod().getName();

		try {

			String unit_price = reusableComponents.getPropValues("unitprice");
			String expense_acc_name = reusableComponents.getPropValues("glaccname");
			
			ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of created payable page", browser, pathLoc+"/"+testcasemethod, true);
			ReusableComponents.wait(5500);

			for (int i = 0; i < 27; i++) {

				browser.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);

			}

			ReusableComponents.wait(5500);

			if (ReusableComponents.isElementPresent(New_PLine)) {

				ReusableComponents.wait(4200);

				New_PLine.click();
				ReusableComponents.reportPass(threadID, tempList, testcasemethod, "New Payable Line button is present", browser, pathLoc + "/" + testcasemethod, false);
				ReusableComponents.wait(6500);

				if (ReusableComponents.isElementPresent(Unit_cost)) {

					ReusableComponents.wait(5200);
					Unit_cost.sendKeys(unit_price);
					ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Unit cost field is present", browser, pathLoc + "/" + testcasemethod, false);
					ReusableComponents.wait(5500);

					if (ReusableComponents.isElementPresent(Expense_GL_Account)) {

						JavascriptExecutor js = (JavascriptExecutor) browser;
						js.executeScript("arguments[0].scrollIntoView();", Expense_GL_Account);

						ReusableComponents.wait(3200);
						Expense_GL_Account.sendKeys(expense_acc_name);
						ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Expense GL Account searchbox is present", browser, pathLoc + "/" + testcasemethod, false);
						ReusableComponents.wait(5500);

						// WebElement Exp_gla_click = browser.findElement(By.xpath("//*[contains(@title,'\"+expense_acc_name+\"')]"));
						List<WebElement> dropdownelement_gl = browser.findElements(By.xpath("//*[contains(@title,'" + expense_acc_name + "')]"));
						int j = dropdownelement_gl.size();

						System.out.println(j + " is the element count");

						// if (ReusableComponents.isElementPresent(Exp_gla_click)) {

						System.out.println("Expense gl account selected");
						ReusableComponents.wait(5200);
						// Exp_gla_click.click();
						dropdownelement_gl.get(j-1).click();
						ReusableComponents.wait(3200);
						System.out.println("action called");
						ReusableComponents.wait(5200);

						// }

						if (ReusableComponents.isElementPresent(Save)) {

							ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of New Payable line creation page", browser, pathLoc+"/"+testcasemethod, true);
							ReusableComponents.wait(5200);
							Save.click();
							ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Save button is present", browser, pathLoc + "/" + testcasemethod, false);
							ReusableComponents.wait(5500);

							if (ReusableComponents.isElementPresent(Post)) {

								ReusableComponents.wait(3200);
								Post.click();
								ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Post tab is present", browser, pathLoc + "/" + testcasemethod, false);
								ReusableComponents.wait(6500);

								List<WebElement> f = browser.findElements(By.tagName("frame"));
								int i = f.size();
								System.out.println(i +" is the frame count");

								browser.switchTo().frame(0);

								if (ReusableComponents.isElementPresent(Post_final)) {
									
									ReusableComponents.reportSpecific(threadID, tempList, testcasemethod, "screen grab of Payable post page", browser, pathLoc+"/"+testcasemethod, true);
									ReusableComponents.wait(4200);
									Post_final.click();
									ReusableComponents.reportPass(threadID, tempList, testcasemethod, "Post final button is present", browser, pathLoc + "/" + testcasemethod, false);
									ReusableComponents.wait(5500);

								} else {
									ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Post final button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
								}

								browser.switchTo().defaultContent();

							} else {
								ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Post tab is NOT present", browser, pathLoc + "/" + testcasemethod, true);
							}

						} else {
							ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Save button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
						}

					} else {
						ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Expense GL Account searchbox is NOT present", browser, pathLoc + "/" + testcasemethod, true);
					}

				} else {
					ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Unit cost field is NOT present", browser, pathLoc + "/" + testcasemethod, true);
				}

			} else {
				ReusableComponents.reportFail(threadID, tempList, testcasemethod, "New Payable Line button is NOT present", browser, pathLoc + "/" + testcasemethod, true);
			}

		} catch (NoSuchElementException e) {
			ReusableComponents.reportFail(threadID, tempList, testcasemethod, "Object is not present" + e.getStackTrace(), browser, pathLoc + "/" + testcasemethod, false);
		}
		return new PayablePage(browser);
	}
}
