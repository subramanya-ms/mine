package com.wisefinch.java;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class ReusableComponents extends DriverScript {

	Map<Object, Object> props = new HashMap<Object, Object>();

	public static void searchByVisibleText(WebElement webby, String identifier, String searchValue) {
		WebElement dropdown_lst = webby.findElement(By.cssSelector(identifier));
		Select objSel = new Select(dropdown_lst);
		objSel.selectByVisibleText(searchValue);
	}

	public static void searchByVisibleText(WebElement webby, By by, String searchValue) {
		WebElement dropdown_lst = webby.findElement(by);
		Select objSel = new Select(dropdown_lst);
		objSel.selectByVisibleText(searchValue);
	}

	public static void searchByVisibleText(WebElement webby, String searchValue) {
		Select objSel = new Select(webby);
		objSel.selectByVisibleText(searchValue);
	}

	public static void searchByValue(WebElement webby, By by, String searchValue) {
		WebElement dropdown_lst = webby.findElement(by);
		Select objSel = new Select(dropdown_lst);
		objSel.selectByValue(searchValue);
	}

	public static void searchByValue(WebElement webby, String searchValue) {

		Select objSel = new Select(webby);
		objSel.selectByValue(searchValue);
	}

	public static void searchByIndex(WebElement webby, By by, int searchIndex) {
		WebElement dropdown_lst = webby.findElement(by);
		Select objSel = new Select(dropdown_lst);
		objSel.selectByIndex(searchIndex);
	}

	public static void searchByIndex(WebElement webby, int searchIndex) {
		Select objSel = new Select(webby);
		objSel.selectByIndex(searchIndex);
	}

	public static boolean isElementPresent(WebElement webby) {
		try {
			webby.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementPresent(List<WebElement> webby) {
		try {
			((WebElement) webby).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementNotPresent(WebElement webby) {
		try {
			webby.isDisplayed();
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	public static boolean isElementTextNotPresent(String strwebby) {
		try {
			strwebby.isEmpty();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isElementTextresent(String strwebby) {
		try {
			strwebby.isEmpty();
			return false;
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	public static void wait(int waittime) {
		try {
			Thread.sleep(waittime);
		} catch (InterruptedException e) {
			System.out.println("wait : Interruption Exception ");
		}
	}

	public String getPropValues(String field, String fileName) throws IOException {

		Properties prop = new Properties();
		/* String propFileName = "config.properties"; */
		String propFileName = fileName + ".properties";

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}

		props.putAll(prop);
		String expectedfield = prop.getProperty(field);

		System.out.println("Expected field :" + expectedfield);
		return expectedfield;
	}

	public String getPropValues(String field) throws IOException {

		Properties prop = new Properties();
		String propFileName = "config.properties";

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}

		props.putAll(prop);
		String expectedfield = prop.getProperty(field);

		System.out.println("Expected field :" + expectedfield);
		return expectedfield;
	}

	public void syncWait(int time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Exception Handling" + e.getStackTrace());

		}

	}

	public Object getObjectPropValues(String field) throws IOException {

		Properties prop = new Properties();
		String propFileName = "config.properties";

		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}

		props.putAll(prop);
		Object expectedfield = prop.get(field);

		System.out.println("Expected field :" + expectedfield);
		return expectedfield;
	}

	public static void takeScreenShot(WebDriver browser, String resultPath) {

		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));

			File scrFile = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			FileUtils.copyFile(scrFile, new File(resultPath + dateFormat.format(date) + ".png"));
		} catch (IOException e) {
			System.out.println("Exception Handling" + e.getStackTrace());

		}

	}

	public static String takeScreenShotReturnFilePath(WebDriver browser, String resultPath) {

		String filePath = null;

		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));

			File scrFile = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			filePath = resultPath + dateFormat.format(date) + ".png";
			FileUtils.copyFile(scrFile, new File(filePath));

		} catch (IOException e) {
			System.out.println("Exception Handling" + e.getStackTrace());

		}

		return filePath;

	}

	public String pathBuilder(String path) {

		String scrFolder = path
				+ new SimpleDateFormat("yyyy_MM_dd_HHmmss").format(Calendar.getInstance().getTime()).toString();
		new File(scrFolder).mkdir();
		return scrFolder;

	}

	public static boolean actionMouserHover(WebDriver browser, WebElement webby) {
		try {
			Actions houseHoverAction = new Actions(browser);
			houseHoverAction.moveToElement(webby).perform();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean scrollDown(WebDriver browser, int steps) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) browser;
			String strExecution = "window.scrollBy(0," + steps + ")";
			/* js.executeScript("window.scrollBy(0,500)",""); */
			js.executeScript(strExecution, "");
			ReusableComponents.wait(2000);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean scrollUp(WebDriver browser, int steps) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) browser;
			String strExecution = "window.scrollBy(0,-" + steps + ")";
			/* js.executeScript("window.scrollBy(0,500)",""); */
			js.executeScript(strExecution, "");
			ReusableComponents.wait(2000);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean scrollOffsetDown(WebDriver browser, WebElement parentElement, int pixels) {
		try {
			Actions dragger = new Actions(browser);

			dragger.moveToElement(parentElement).clickAndHold().moveByOffset(0, pixels).release().perform();

			ReusableComponents.wait(2000);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean scrollRobotPageDown() throws AWTException {
		try {
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

			ReusableComponents.wait(2000);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean scrollJavaScriptDown(WebDriver browser, WebElement mouseElement) {
		try {
			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) browser).executeScript(mouseOverScript, mouseElement);

			ReusableComponents.wait(2000);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean actionMouseClick(WebDriver browser, WebElement webby) {
		try {
			Actions builder = new Actions(browser);
			builder.moveToElement(webby).click(webby);
			builder.perform();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean javaScriptClickByID(WebDriver browser, String webby) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) browser;
			js.executeScript("window.document.getElementById('" + webby + "').click()");
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void implicitWait(WebDriver browser, int waittime) {
		browser.manage().timeouts().implicitlyWait(waittime, TimeUnit.SECONDS);
	}

	public String folderBuilder(String path) {

		String scrFolder = path;

		new File(scrFolder).mkdir();
		return scrFolder;

	}

	public static WebElement explicitWait(WebDriver browser, By webby, int waittime) {
		WebDriverWait wait = new WebDriverWait(browser, waittime);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webby));
		wait(2000);
		return element;
	}

	public static WebElement fluentExplicitWait(WebDriver browser, WebElement webby, int waittime)
			throws throwNewException {
		WebDriverWait wait = new WebDriverWait(browser, waittime);

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webby));
		wait(2000);

		explicitWait(browser, webby, waittime);

		return element;
	}

	/**
	 * @author Wisefinch Menaka
	 * 
	 * @param element
	 * @param fieldName
	 * @throws throwNewException
	 */
	public static void clickElement(WebElement element, String fieldName) throws throwNewException {
		System.out.println("***Inside click element************** of " + fieldName);
		try {
			wait(5000);
			boolean value = element.isEnabled();
			System.out.println("*********** It's enabled value " + value);
			element.click();
			System.out.println("*********** Click done");
		} catch (Exception e) {
			System.out.println("*************** " + e.getMessage());
			throw new throwNewException(fieldName, "Unable to click element : " + e.getMessage());
		}
	}

	/*
	 * // This is to click a element and send keyboard keys Author : Menaka
	 * Arguments: element : pass webelement field Name : User understandable name
	 * for webelement
	 */
	public static void clickElementAnd_SendKey(WebElement element, Keys tab, String fieldName)
			throws throwNewException {
		// System.out.println("Inside click element");
		try {
			wait(5000);
			boolean value = element.isEnabled();
			System.out.println("***Inside click element************** " + value);
			element.click();
			element.sendKeys(tab);
		} catch (Exception e) {
			System.out.println("*************** " + e.getMessage());
			throw new throwNewException(fieldName, "Unable to click element : " + e.getMessage());
		}
	}

	/*
	 * // click element using action Author : Menaka Arguments: element : pass
	 * webelement field Name : User understandable name for webelement
	 */
	public static void actionMoveToElementAndClick(WebDriver browser, WebElement element, String fieldName)
			throws throwNewException {
		System.out.println("*************** Inside action class");
		try {
			Actions mouseHoverAction = new Actions(browser);
			mouseHoverAction.moveToElement(element).perform();
			mouseHoverAction.moveToElement(element).click().perform();
			System.out.println("*************** move performed");
			wait(5000);
		} catch (NoSuchElementException e) {
			System.out.println("*************** the exception " + e.getMessage());
			throw new throwNewException(fieldName,
					"Unable to perform move to element and click action: " + e.getMessage());
		}
	}

	/*
	 * // This is to click a element by passing dynamic xpath Author : Menaka
	 * Arguments List browser : current webdriver reference dynamicXpath : string
	 * which contain dynamic xpath value
	 */
	public static void clickElement_byDynamicXpath(WebDriver browser, String dynamicXpath, String fieldName)
			throws throwNewException {
		WebElement findElement;
		try {
			findElement = browser.findElement(By.xpath(dynamicXpath));
			if (findElement.isEnabled()) {
				findElement.click();
			}
		} catch (Exception e) {
			throw new throwNewException(fieldName, "Unable to click element : " + e.getMessage());
		}
	}

	public static void isSelectedCheckbox(WebElement element, String fieldName) throws throwNewException {
		// System.out.println("Inside click element");
		try {
			// System.out.println("*********************8 is
			// selected"+element.isSelected());
			if (!element.isSelected()) {
				element.click();
			}

		} catch (Exception e) {
			throw new throwNewException(fieldName, "Unable to perform isSelect action : " + e.getMessage());
		}
	}

	/*
	 * // This is to double click a element Author : Menaka
	 */
	public static void doubleClickElement(WebDriver driver, WebElement element, String fieldName)
			throws throwNewException {
		try {
			wait(5000);
			System.out.println("********* Inside double click element displayed " + element.isDisplayed());
			System.out.println("********* Inside double click element enabled " + element.isEnabled());

			Actions act = new Actions(driver);
			act.doubleClick(element).perform();
			System.out.println("Double click performed");
		} catch (Exception e) {
			e.printStackTrace();
			throw new throwNewException(fieldName, "Unable to perform double click action : " + e.getMessage());
		}
	}

	// Modified Sections After 9/9/2021
	/*
	 * // This is to perform send key action Author : Menaka
	 */
	public static void switchToFrame(WebDriver driver, int i) throws throwNewException {
		try {
			wait(5000);
			driver.switchTo().frame(i);
		} catch (Exception e) {
			throw new throwNewException(null, "Unable to switch frame : " + e.getMessage());
		}
	}

	/*
	 * This method is to get current date and time based on argument passed
	 */
	public static String getCurrentDateAndTime(String dateAndTimeFormet) throws throwNewException {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateAndTimeFormet);
			LocalDateTime now = LocalDateTime.now();
			System.out.println(dtf.format(now));
			dateAndTimeFormet = dtf.format(now);
		} catch (Exception e) {
			throw new throwNewException(null, "Error when trying to get the current date value : " + e.getMessage());
		}
		return dateAndTimeFormet;
	}

	public static boolean actionMoveToElement(WebDriver browser, WebElement element) {
		try {
			System.out.println("****************************** Move performed");
			Actions mouseHoverAction = new Actions(browser);
			mouseHoverAction.moveToElement(element).perform();
			System.out.println("****************************** Move performed");
			wait(5000);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// Modified Sections After 9/9/2021
	/*
	 * // This is to click a element using java script Author : Menaka
	 */
	public static void clickUsingJavaScript(WebDriver browser, WebElement element, String actionDetails)
			throws throwNewException {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) browser;
			executor.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			throw new throwNewException(actionDetails, "Unable to perform click using javascript : " + e.getMessage());
		}
	}

	/*
	 * // This is to click a element Author : Menaka
	 */
	public static boolean isDisplayed(WebElement element, String elementName) throws throwNewException {
		boolean elementDisplayed = false;
		try {
			elementDisplayed = element.isDisplayed();
			return elementDisplayed;
		} catch (Exception e) {
			throw new throwNewException(elementName, "Unable to switch frame : " + e.getMessage());
		}
	}

	/*
	 * // This is to perform send key action Author : Menaka
	 */
	public static void scrollDownUsingKeys(WebDriver browser) throws throwNewException {
		try {
			System.out.println("****************************Scrolled down function");
			wait(6000);
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
			wait(6000);
			System.out.println("****************************Scrolled down");
		} catch (NoSuchElementException e) {
			throw new throwNewException(null, "Unable to perform scroll down : " + e.getMessage());
		}
	}

	// Modified Sections After 29/9/2021
	/**
	 * @author Wisefinch Menaka
	 * 
	 * @param element
	 * @param inputString
	 * @param fieldName
	 * @throws throwNewException
	 */
	public static void sendKey(WebElement element, String inputString, String fieldName) throws throwNewException {
		try {
			System.out.println("************************* Send key function called");
			boolean elementPresent = element.isDisplayed();
			System.out.println("********** element present " + elementPresent);
			elementPresent = element.isEnabled();
			System.out.println("********** element present " + elementPresent);

			if (elementPresent == true) {
				System.out.println("************************* Element present");
				element.click();
				element.clear();

				String elementText = element.getText();
				System.out.println("*********** input box text before giving value : " + elementText);
				if (!elementText.equalsIgnoreCase("")) {
					System.out.println("************ Clear text using control A delete");
					element.sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
				}

				element.sendKeys(inputString);
				wait(2000);
			} else {
				throw new throwNewException(fieldName,
						"Unable to perform send key action. " + fieldName + " is not enable / visible");
			}
		} catch (Exception e) {
			throw new throwNewException(fieldName, "Unable to perform send key action : " + e.getMessage());
		}

	}

	/*
	 * // This is to perform send key action Author : Menaka
	 */
	public static void sendkey_InputKey(WebElement element, Keys tab, String elementName) throws throwNewException {
		try {
			System.out.println("************************* Send key function called");
			boolean elementPresent = element.isDisplayed();
			System.out.println("********** element present " + elementPresent);
			elementPresent = element.isEnabled();
			System.out.println("********** element present " + elementPresent);

			if (elementPresent == true) {
				System.out.println("************************* Element present");
				element.click();
				element.sendKeys(tab);
				wait(2000);
			}
		} catch (Exception e) {
			throw new throwNewException("",
					"Unable to pass key action : " + tab + " to the element " + elementName + e.getMessage());
		}

	}

	/*
	 * To get attribute values. Author : Menaka
	 */
	public String getAttribute(WebElement firstReport_FinancialReport, String attributeName) throws throwNewException {
		String hyperlink;
		try {
			hyperlink = firstReport_FinancialReport.getAttribute(attributeName);
		} catch (Exception e) {
			throw new throwNewException(attributeName, "Unable to get attribute of : " + e.getMessage());
		}
		return hyperlink;
	}

	public static void switchToTab(WebDriver browser) throws throwNewException {

		try {
			Actions switchTabAction = new Actions(browser);
			switchTabAction.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			throw new throwNewException(null, "Unable to perform switch tab : " + e.getMessage());
		}
	}

	/*
	 * Select value from combo box. Argument : webelement : element of xpath
	 * comboBoxSelectValue : value to select from xpath
	 */
	public static void selectValueFromComboBox(WebElement selectElement, String comboBoxSelectValue)
			throws throwNewException {
		System.out.println("***Inside Select***************** Verify select displayed" + selectElement.isDisplayed());
		try {
			if (selectElement.isDisplayed()) {
				Select comboBox = new Select(selectElement);
				comboBox.selectByValue(comboBoxSelectValue);
			}

		} catch (Exception e) {
			throw new throwNewException(comboBoxSelectValue,
					"Unable to select value from combobox : " + e.getMessage());
		}
	}

	/*
	 * Author : Menaka
	 */
	public static void scrollDownUsingPageDown(WebDriver browser) throws throwNewException {
		// TODO Auto-generated method stub
		try {
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(3200);
		} catch (Exception e) {
			throw new throwNewException(null, "Unable to perform scroll down : " + e.getMessage());
		}
	}

	/**
	 * Author : Menaka
	 * 
	 * @param browser
	 * @param popupXpath
	 * @throws throwNewException
	 */
	public static void scrollDown_insidepopup_ByPGDN(WebDriver browser, WebElement popupXpath)
			throws throwNewException {
		// TODO Auto-generated method stub
		try {
			System.out.println("************************ element presemt : " + popupXpath.isEnabled());
			popupXpath.sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(3200);
			popupXpath.sendKeys(Keys.PAGE_DOWN);
			ReusableComponents.wait(3200);
		} catch (Exception e) {
			throw new throwNewException(null, "Unable to perform scroll down : " + e.getMessage());
		}
	}

	/***
	 * Test case Method Name : reportPass Functionality : Reporting Pass using all
	 * types Created By : Subramanya MS Parameters : testMethod - Test case Method
	 * description - Description of Step browser - Webdriver object screenShotPath-
	 * Screen Shot Path flag - true for Screen shot Addition - false for Not adding
	 * Screen shot
	 ***/

	public static void reportPass(int threadID, List<String> tempList, String testMethod, String description,
			WebDriver browser, String screenShotPath, boolean flag) {
		System.out.println(testMethod + " : " + description + " PASS");
		resultList.add(testMethod + " : " + description + " -- PASS");
//		System.out.println("----------------> reportPass <----------------");
//		System.out.println("----------------> threadID " + threadID);
//		System.out.println("----------------> tempList " + tempList);
//		System.out.println("----------------> testMethod " + testMethod);
//		System.out.println("----------------> description " + description);
//		System.out.println("----------------> browser " + browser);
//		System.out.println("----------------> screenShotPath " + screenShotPath);

		if (flag == true) {

			String filePath = ReusableComponents.takeScreenShotReturnFilePath(browser, screenShotPath);

			tempList.add(LogStatus.FAIL + "&" + testMethod + "&" + description + "&" + filePath);
		} else {

			tempList.add(LogStatus.PASS + "&" + testMethod + "&" + description);
		}

		hmap.put(threadID, tempList);

	}

	/***
	 * Test case Method Name : reportSpecific Functionality : Reporting selected
	 * information custom Created By : Subramanya MS Parameters : testMethod - Test
	 * case Method description - Description of Step browser - Webdriver object
	 * screenShotPath- Screen Shot Path flag - true for Screen shot Addition - false
	 * for Not adding Screen shot
	 ***/

	public static void reportSpecific(int threadID, List<String> tempList, String testMethod, String description,
			WebDriver browser, String screenShotPath, boolean flag) {
//		System.out.println("----------------> reportSpecific <----------------");
//		System.out.println("----------------> threadID " + threadID);
//		System.out.println("----------------> tempList " + tempList);
//		System.out.println("----------------> testMethod " + testMethod);
//		System.out.println("----------------> description " + description);
//		System.out.println("----------------> browser " + browser);
//		System.out.println("----------------> screenShotPath " + screenShotPath);

		if (flag == true) {

			String filePath = ReusableComponents.takeScreenShotReturnFilePath(browser, screenShotPath);

			tempList.add(LogStatus.UNKNOWN + "&" + testMethod + "&" + description + "&" + filePath);
		} else {

			tempList.add(LogStatus.UNKNOWN + "&" + testMethod + "&" + description);
		}

		hmap.put(threadID, tempList);

	}

	/***
	 * Test case Method Name : reportFail Functionality : Reporting Fail using all
	 * types Created By : Subramanya MS Parameters : testMethod - Test case Method
	 * description - Description of Step browser - Webdriver object screenShotPath-
	 * Screen Shot Path flag - true for Screen shot Addition - false for Not adding
	 * Screen shot
	 ***/

	public static void reportFail(int threadID, List<String> tempList, String testMethod, String description,
			WebDriver browser, String screenShotPath, boolean flag) {
		System.out.println(testMethod + " : " + description + " FAIL");
		resultList.add(testMethod + " : " + description + " -- FAIL");

//		System.out.println("----------------> reportFail <----------------");
//		System.out.println("----------------> threadID " + threadID);
//		System.out.println("----------------> tempList " + tempList);
//		System.out.println("----------------> testMethod " + testMethod);
//		System.out.println("----------------> description " + description);
//		System.out.println("----------------> browser " + browser);
//		System.out.println("----------------> screenShotPath " + screenShotPath);

		if (flag == true) {

			String filePath = ReusableComponents.takeScreenShotReturnFilePath(browser, screenShotPath);
			tempList.add(LogStatus.FAIL + "&" + testMethod + "&" + description + "&" + filePath);

		} else {

			tempList.add(LogStatus.FAIL + "&" + testMethod + "&" + description);
		}

		hmap.put(threadID, tempList);

	}

	/***
	 * Test case Method Name : reportInfo Functionality : Reporting Done/Info using
	 * all types Created By : Subramanya MS Parameters : testMethod - Test case
	 * Method description - Description of Step browser - Webdriver object
	 * screenShotPath- Screen Shot Path flag - true for Screen shot Addition - false
	 * for Not adding Screen shot
	 ***/
	public static void reportInfo(int threadID, List<String> tempList, String testMethod, String description,
			WebDriver browser, String screenShotPath, boolean flag) {
		System.out.println(testMethod + " : " + description + " DONE");
		resultList.add(testMethod + " : " + description + " -- DONE");
//
//		System.out.println("----------------> reportInfo <----------------");
//		System.out.println("----------------> threadID " + threadID);
//		System.out.println("----------------> tempList " + tempList);
//		System.out.println("----------------> testMethod " + testMethod);
//		System.out.println("----------------> description " + description);
//		System.out.println("----------------> browser " + browser);
//		System.out.println("----------------> screenShotPath " + screenShotPath);

		if (flag == true) {

			String filePath = ReusableComponents.takeScreenShotReturnFilePath(browser, screenShotPath);
			tempList.add(LogStatus.FAIL + "&" + testMethod + "&" + description + "&" + filePath);
		} else {

			tempList.add(LogStatus.INFO + "&" + testMethod + "&" + description);
		}

		hmap.put(threadID, tempList);

	}

	/***
	 * Test case Method Name : reportPass functionality Functionality : Reporting
	 * Pass using all types Created By : Menaka Parameters : testMethod - Test case
	 * Method description - Description of Step browser - Webdriver object
	 * screenShotPath- Screen Shot Path flag - true for Screen shot Addition - false
	 * for Not adding Screen shot
	 ***/

	public static void reportPassFunction(int threadID, List<String> tempList, String testMethod, String description,
			WebDriver browser, String screenShotPath, boolean flag) {
		System.out.println(testMethod + " : " + description + " PASS");
		resultList.add(testMethod + " : " + description + " -- PASS");

//		System.out.println("----------------> reportPassFunction <----------------");
//		System.out.println("----------------> threadID " + threadID);
//		System.out.println("----------------> tempList " + tempList);
//		System.out.println("----------------> testMethod " + testMethod);
//		System.out.println("----------------> description " + description);
//		System.out.println("----------------> browser " + browser);
//		System.out.println("----------------> screenShotPath " + screenShotPath);

		if (flag == true) {

			String filePath = ReusableComponents.takeScreenShotReturnFilePath(browser, screenShotPath);

			tempList.add(LogStatus.PASS + "&" + testMethod + "&" + description + "&" + filePath);
		} else {

			tempList.add(LogStatus.PASS + "&" + testMethod + "&" + description);
		}

		hmap.put(threadID, tempList);

	}

	// Modified Sections After 9/9/2021
	/*
	 * Author Menaka
	 */

	public static String getText(WebElement element, String fieldName) throws throwNewException {
		String textValue;
		try {
			wait(5000);
			boolean value = element.isEnabled();
			System.out.println("******** element Visibiliy : " + value);
			textValue = element.getText();
		} catch (Exception e) {
			System.out.println("*************** " + e.getMessage());
			throw new throwNewException(fieldName, "Unable to click element : " + e.getMessage());
		}
		return textValue;
	}

	// Modified Sections After 9/9/2021
	/*
	 * Author : Menaka
	 */
	public static void scrollUp_insidepopup_ByPGUP(WebDriver browser, WebElement popupXpath) throws throwNewException {
		// TODO Auto-generated method stub
		WebElement element;
		try {
			System.out.println("************************ element presemt : " + popupXpath.isEnabled());
			popupXpath.sendKeys(Keys.PAGE_UP);
			ReusableComponents.wait(3200);
		} catch (Exception e) {
			throw new throwNewException(null, "Unable to perform scroll down : " + e.getMessage());
		}
	}

	// Modified Sections After 9/9/2021
	/*
	 * Author : Menaka
	 */
	public static void scrollUp_ByKey(WebDriver browser) throws throwNewException {
		// TODO Auto-generated method stub
		WebElement element;
		try {
			browser.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
			ReusableComponents.wait(3200);
		} catch (Exception e) {
			throw new throwNewException(null, "Unable to perform scroll down : " + e.getMessage());
		}
	}

	// Modified Sections After 9/9/2021
	/*
	 * Author : Menaka
	 */
	public static void scrollInToElementJavaScript(WebDriver browser, WebElement element) throws throwNewException {
		try {
			((JavascriptExecutor) browser).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(1000);
		} catch (Exception e) {
			throw new throwNewException(null, "Unable to perform scroll down : " + e.getMessage());

		}
	}

	// Modified Sections After 9/9/2021
	/*
	 * Author : Menaka
	 */
	public static void explicitWait(WebDriver browser, WebElement webby, int waittime) throws throwNewException {
		try {
			WebDriverWait wait = new WebDriverWait(browser, waittime);
			wait.until(ExpectedConditions.visibilityOf(webby));
			wait(2000);
		} catch (Exception e) {
			throw new throwNewException(webby.toString(), "Unable verify element visibility : " + e.getMessage());
		}

	}

	// Modified Sections After 9/9/2021
	/*
	 * Author : Menaka
	 */
	public static String elementGetAttribute(WebElement webby, String attributeName) throws throwNewException {
		try {
			String gatheredValue = webby.getAttribute(attributeName);
			wait(2000);
			return gatheredValue;
		} catch (Exception e) {
			throw new throwNewException(webby.toString(), "Unable get attribute value : " + e.getMessage());
		}

	}

	// Modified Sections After 20/9/2021
	/**
	 * @author Wisefinch Menaka
	 * @param accountingPeriodInputBox
	 * @param accountingPeriod
	 * @param browser
	 * @throws throwNewException
	 */
	public static void selectAccountingPeriod(WebElement accountingPeriodInputBox, String accountingPeriod,
			WebDriver browser) throws throwNewException {
		try {
			ReusableComponents.sendKey(accountingPeriodInputBox, accountingPeriod, "Enter Accounting Period");
			String[] arrOfStr = accountingPeriod.split("-");
			String monthValue = arrOfStr[1];
			String monthInString;
			if (monthValue.equalsIgnoreCase("10") || monthValue.equalsIgnoreCase("11")
					|| monthValue.equalsIgnoreCase("12")) {
				monthInString = monthValue;
			} else {
				monthInString = monthValue.substring(1);
			}

			String accountingPeriodInMDYFormat = monthInString + "/1/" + arrOfStr[0];
			String xpath_acccountingPeriod_Select_newJournal = ".//lightning-base-combobox-formatted-text[@title='"
					+ accountingPeriodInMDYFormat + "']";
			ReusableComponents.wait(5000);
			ReusableComponents.clickElement_byDynamicXpath(browser, xpath_acccountingPeriod_Select_newJournal,
					"Selected Accounting Period");
		} catch (Exception e) {
			throw new throwNewException(accountingPeriodInputBox.toString(),
					"Unable select accounting period : " + e.getMessage());
		}

	}

	/**
	 * @author Wisefinch Menaka
	 * @see This method will return previous accounting period value
	 * @param accountingPeriod - Valid Accounting period value should be given -
	 *                         [example 2021-01]
	 * @param browser
	 * @return
	 * @throws throwNewException
	 */
	public static String identifyPreviousAccountingPeriod(String accountingPeriod) throws throwNewException {
		String previousAccountingPeriod = null;
		try {
			System.out.println("********** Accounting period test data for this test case : " + accountingPeriod);
			String strArray[] = accountingPeriod.split("-");
			String yearValue = strArray[0];
			String monthValue = strArray[1];
			int year = Integer.parseInt(strArray[0]);
			int month = Integer.parseInt(strArray[1]);

			// Identifying the previous accounting period to
			if (monthValue.equalsIgnoreCase("01")) {
				System.out.println("----------> First month");

				year = year - 1;
				yearValue = Integer.toString(year);
				System.out.println("----------> Year Value changed to : " + yearValue);

				previousAccountingPeriod = yearValue.concat("-12");
				System.out.println("----------> previousAccountingPeriod identified as : " + previousAccountingPeriod);

			} else {
				if (month == 11 || month == 12 || month == 10) {
					previousAccountingPeriod = yearValue + "-" + Integer.toString(month);
					System.out
							.println("----------> previousAccountingPeriod identified as :" + previousAccountingPeriod);
				} else {
					month = month - 1;
					previousAccountingPeriod = yearValue + "-0" + Integer.toString(month);
					System.out
							.println("----------> previousAccountingPeriod identified as :" + previousAccountingPeriod);
				}

			}
		} catch (Exception e) {
			System.out.println("----------> Exception when trying to identify the previous accounting period " + e);
			previousAccountingPeriod = null;
		}

		return previousAccountingPeriod;
	}

}
