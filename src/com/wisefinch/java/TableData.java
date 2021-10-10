package com.wisefinch.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TableData {
	
	static String testvalue = "vaishnavi";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		int row_size = 0, column_size=0, header_size=0, i=0,j=0,k=0;
		
		String url = "https://www.tutorialspoint.com/plsql/plsql_basic_syntax.htm";
		
		String workingDir = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver",workingDir+"/chromedriver.exe");
		
		WebDriver driver  = new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		Thread.sleep(2500);
		
		try {
			WebElement findtabledata = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/table[2]/tbody"));
			
			List<WebElement>TotalRowsList = findtabledata.findElements(By.tagName("tr"));
			
			System.out.println("rows = "+TotalRowsList.size());
			
			row_size = TotalRowsList.size();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error finding row details");
		}
		
		String tesss= "subramanya";
		
		tesss.length();
		
		try {
			WebElement rowdata = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/table[2]/tbody/tr[1]"));
			
			List<WebElement>totalheaderlist = rowdata.findElements(By.tagName("th"));
			
			System.out.println("header = "+totalheaderlist.size());
			
			header_size = totalheaderlist.size();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error finding header details");
		}
		
		try {
			WebElement rowdata = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/table[2]/tbody/tr[2]"));
			
			List<WebElement>totalcolumnslist = rowdata.findElements(By.tagName("td"));
			
			System.out.println("columns = "+totalcolumnslist.size());
			
			column_size = totalcolumnslist.size();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error finding columns details");
		}
		
		for(i=1;i<=row_size;i++) {
			
			
			WebElement rowdata = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/table[2]/tbody/tr["+i+"]"));
			
			if(i==1) {
				
				List<WebElement>totalheaderlist = rowdata.findElements(By.tagName("th"));
				System.out.println("header = "+totalheaderlist.size());
				
				for(j=1;j<=totalheaderlist.size();j++) {
					
					WebElement headerdata = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/table[2]/tbody/tr["+i+"]/th["+j+"]"));
					
					System.out.println("for row = "+i+" for column = "+j+" the value is "+headerdata.getText());
					
					
					
				}
				
			}else {
				
				List<WebElement>totalcolumnlist = rowdata.findElements(By.tagName("td"));
				System.out.println("columns = "+totalcolumnlist.size());
				
				for(j=1;j<=totalcolumnlist.size();j++) {
					
					WebElement columndata = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/table[2]/tbody/tr["+i+"]/td["+j+"]"));
					
					System.out.println("for row = "+i+" for column = "+j+" the value is "+columndata.getText());
					
					
					
				}
				
			}
			
			
		}
		
		
		
		
		
		
		/*
		 * String pick_value;
		 * 
		 * if(findtabledata.isDisplayed()) {
		 * 
		 * pick_value = findtabledata.getAttribute("href");
		 * 
		 * System.out.println(pick_value);
		 * 
		 * System.out.println(findtabledata.getText());
		 * 
		 * }
		 */
		
		
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
