package com.wisefinch.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CountryDropdown {
	
	static String testvalue = "vaishnavi";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String url = "https://www.lambdatest.com/blog/how-to-handle-web-table-in-selenium-webdriver/";
		
		String workingDir = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver",workingDir+"/chromedriver.exe");
		
		WebDriver driver  = new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		Thread.sleep(2500);
		
		WebElement findtabledata = driver.findElement(By.xpath("//tbody/tr[2]/td[2]/center[1]/a"));
		
		String pick_value;
		
		if(findtabledata.isDisplayed()) {
			
			pick_value = findtabledata.getAttribute("href");
			
			System.out.println(pick_value);
			
			System.out.println(findtabledata.getText());
			
		}
		
		
		
		/*
		 * WebElement firstname_text =
		 * driver.findElement(By.xpath("//td//*[@name='firstName']"));
		 * 
		 * WebElement test_element =
		 * driver.findElement(By.cssSelector("#addNewRecordButton"));
		 * 
		 * if(firstname_text.isDisplayed()) {
		 * 
		 * firstname_text.clear(); firstname_text.sendKeys("subramanya"); }else {
		 * 
		 * System.out.println("element not present"); }
		 */
		
		/*
		 * try { Select find_country_select = new
		 * Select(driver.findElement(By.xpath("//td//*[@name='country']")));
		 * 
		 * Thread.sleep(2500);
		 * 
		 * find_country_select.selectByVisibleText("AAA");
		 * 
		 * Thread.sleep(2500); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block
		 * 
		 * System.out.println("select box error, please check");
		 * 
		 * }
		 */
		

		//td//*[@name='firstName']
		
		//td//*[@name='country']
		
		driver.close();
		driver.quit();
		
	
		

		
	}

}
