package com.wisefinch.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TableData_another {
	
	static String testvalue = "vaishnavi";

	public static void main(String[] args) throws InterruptedException {
		
		int row_size = 0, column_size=0, header_size=0, i=0,j=0,k=0, rowsize_body = 0, rowsize_foot = 0;
	

String url="https://www.techlistic.com/p/demo-selenium-practice.html";

String workingDir = System.getProperty("user.dir");

System.setProperty("webdriver.chrome.driver",workingDir+"/chromedriver.exe");

WebDriver driver  = new ChromeDriver();

driver.get(url);

driver.manage().window().maximize();

Thread.sleep(2500);

try {
WebElement findtabledata = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]"));

List<WebElement>TotalRowsList = findtabledata.findElements(By.xpath("table[1]/thead/tr"));

System.out.println("rows header = "+TotalRowsList.size());

row_size = TotalRowsList.size();

} catch (Exception e) {
// TODO Auto-generated catch block
System.out.println("error finding row details of header");


}

try {
WebElement findtabledata = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]"));

List<WebElement>TotalRowsList_body = findtabledata.findElements(By.xpath("table[1]/tbody/tr"));

System.out.println("rows body = "+TotalRowsList_body.size());

rowsize_body = TotalRowsList_body.size();

} catch (Exception e) {
// TODO Auto-generated catch block
System.out.println("error finding row details of tbody");


}

try {
WebElement findtabledata = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]"));

List<WebElement>TotalRowsList_foot = findtabledata.findElements(By.xpath("table[1]/tfoot/tr"));

System.out.println("rows footer = "+TotalRowsList_foot.size());

rowsize_foot = TotalRowsList_foot.size();

} catch (Exception e) {
// TODO Auto-generated catch block
System.out.println("error finding row details of tbody");


}


for(i=1;i<=row_size;i++) {
	
	
	WebElement rowdata = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/thead/tr["+i+"]"));
	

		
		List<WebElement>totalheaderlist = rowdata.findElements(By.tagName("th"));
		System.out.println("header = "+totalheaderlist.size());
		
		for(j=1;j<=totalheaderlist.size();j++) {
			
			WebElement headerdata = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/thead/tr["+i+"]/th["+j+"]"));
			
			System.out.println("for thead row = "+i+" for column = "+j+" the value is "+headerdata.getText());
			
			
			
		}
		

	
	
}


for(i=1;i<=rowsize_body;i++) {
	
	
	WebElement rowdata = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody/tr["+i+"]"));
	
	List<WebElement>totalheaderlist = rowdata.findElements(By.tagName("th"));
	System.out.println("header = "+totalheaderlist.size());
	
	List<WebElement>totalcolumnlist = rowdata.findElements(By.tagName("td"));
	System.out.println("column = "+totalcolumnlist.size());
	
	for(j=1;j<=totalheaderlist.size();j++) {
		
			WebElement headerdata = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody/tr["+i+"]/th["+j+"]"));
			
			System.out.println("for tbody row = "+i+" for column = "+j+" the value is "+headerdata.getText());
			
	}
	
	
	for(j=1;j<=totalcolumnlist.size();j++) {
		
		WebElement headerdata = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody/tr["+i+"]/td["+j+"]"));
		
		System.out.println("for tbody row = "+i+" for column = "+j+" the value is "+headerdata.getText());
		
		
	}
	

		
}

for(i=1;i<=rowsize_foot;i++) {
	
	
	WebElement rowdata = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tfoot/tr["+i+"]"));
	

		
		List<WebElement>totalheaderlist = rowdata.findElements(By.tagName("th"));
		System.out.println("header = "+totalheaderlist.size());
		
		for(j=1;j<=totalheaderlist.size();j++) {
			
			WebElement headerdata = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/div[2]/main[1]/div[1]/div[1]/div[1]/article[1]/div[1]/div[1]/div[3]/div[1]/div[1]/table[1]/tfoot/tr["+i+"]/th["+j+"]"));
			
			System.out.println("for tfoot row = "+i+" for column = "+j+" the value is "+headerdata.getText());
			
			
			
		}
		

	
	
}


driver.close();
driver.quit();


}
}
