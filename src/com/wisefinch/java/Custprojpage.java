package com.wisefinch.java;


import java.awt.AWTException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.seleniumhq.jetty9.server.Authentication.User;

import com.wisefinch.java.ReusableComponents;

import org.openqa.selenium.JavascriptExecutor;

/**
 * Base class for all the pages.
 *
 */
public class Custprojpage extends DriverScript{
	protected WebDriver browser;
		
	ReusableComponents reusableComponents = new  ReusableComponents();
	/**
	 * Constructor for Page class 
	 * @param browser
	 * @param report
	 */
	protected Custprojpage(WebDriver browser) {
		this.browser=browser;		
		PageFactory.initElements(browser, this);
	
	}


public Custprojpage() {
		// TODO Auto-generated constructor stub
	}


//for alrvsales site from here

@FindBy(xpath = "//button[contains(text(),'Search')]")
WebElement shop_now;

@FindBy(xpath = "//button[contains(text(),'No, Thank You')]") // to close an alert
WebElement no_thanks;

List<WebElement> outputarray;
List<WebElement> location_list;

int location_list_size = 0, i, j;

ArrayList<String> outarray= new ArrayList<String>(); 
ArrayList<String> Loc_name= new ArrayList<String>();
ArrayList<String> Loc_total= new ArrayList<String>();
ArrayList<String> Loc_url= new ArrayList<String>();
static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
static Calendar c = Calendar.getInstance();

String locnameeditor=null, locnumeditor=null;
String workingDir = System.getProperty("user.dir");
String loc_identifier = null, loc_identifier1 = null, rv_type = null, rv_type1 = null;
	
	/*** Test case Method Name : validateTestA
	 * 	 Functionality         : validate login to Accounting seed salesforce
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  Custprojpage validateTestA(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
	try{

		ReusableComponents.wait(15500);
		
		//outputarray = browser.findElements(By.xpath("//div[@class='h3 unit-title']/a"));
		outputarray = browser.findElements(By.xpath("//div[@class='unit-title-wrapper list-mode']//div[@class='h3 unit-title']/a"));
		//div[@class='unit-title-wrapper list-mode']//div[@class='h3 unit-title']/a
		System.out.println(outputarray.size());
		//outarray.add("location/Make/Model");
		
		loc_identifier1 = browser.getCurrentUrl();
		
		if(loc_identifier1.contains("lots=736")) {
			
			loc_identifier = "Columbia";
			
		}else if(loc_identifier1.contains("lots=908")) {
			
			loc_identifier = "Jackson";
			
		}else if(loc_identifier1.contains("lots=727")) {
			
			loc_identifier = "Johnson city";
			
		}else if(loc_identifier1.contains("lots=804")) {
			
			loc_identifier = "Lake park";
			
		}else if(loc_identifier1.contains("lots=734")) {
			
			loc_identifier = "Murfreesboro";
			
		}else if(loc_identifier1.contains("lots=857")) {
			
			loc_identifier = "Richmond";
			
		}else if(loc_identifier1.contains("lots=735")) {
			
			loc_identifier = "Sevierville";
			
		}
		
		rv_type1 = browser.getCurrentUrl();
		
		if(rv_type1.contains("types=3")) {
			
			rv_type = "Destination Trailer";
			
		}else if(rv_type1.contains("types=4")) {
			
			rv_type = "Expandable";
			
		}else if(rv_type1.contains("types=5")) {
			
			rv_type = "Fifth Wheel";
			
		}else if(rv_type1.contains("types=7")) {
			
			rv_type = "Folding Pop-Up Camper";
			
		}else if(rv_type1.contains("types=9")) {
			
			rv_type = "Motor Home Class A";
			
		}else if(rv_type1.contains("types=10")) {
			
			rv_type = "Motor Home Class A - Diesel";
			
		}else if(rv_type1.contains("types=13")) {
			
			rv_type = "Motor Home Class B";
			
		}else if(rv_type1.contains("types=14")) {
			
			rv_type = "Motor Home Class B+";
			
		}else if(rv_type1.contains("types=16")) {
			
			rv_type = "Motor Home Class C";
			
		}else if(rv_type1.contains("types=17")) {
			
			rv_type = "Motor Home Class C - Diesel";
			
		}else if(rv_type1.contains("types=95")) {
			
			rv_type = "Motor Home Super C - Diesel";
			
		}else if(rv_type1.contains("types=102")) {
			
			rv_type = "Teardrop Trailer";
			
		}else if(rv_type1.contains("types=26")) {
			
			rv_type = "Toy Hauler Fifth Wheel";
			
		}else if(rv_type1.contains("types=28")) {
			
			rv_type = "Toy Hauler Travel Trailer";
			
		}else if(rv_type1.contains("types=29")) {
			
			rv_type = "Travel Trailer";
			
		}
		
		outarray.add("location - "+loc_identifier+" & rv type - "+rv_type);
		
		
		ReusableComponents.wait(5500);
		
		for(int i=0;i<outputarray.size();i++) {
			
			outarray.add(outputarray.get(i).getText());
			//System.out.println(outputarray.get(i).getText());
			
		}
		

		HSSFWorkbook workbook = new HSSFWorkbook(); 
        
        HSSFSheet sheet = workbook.createSheet("vehiclenames");// creating a blank sheet
         int rownum = 0;
			
			  for (String name : outarray) { 
				  Row row = sheet.createRow(rownum++); 
				 
				  Cell cell = row.createCell(0); 

					/*
					 * Header head = sheet.getHeader(); head.setCenter("location/Make/Model");
					 */
					/*
					 * if(rownum == 1) {
					 * 
					 * 
					 * 
					 * // cell.setCellValue("location/Make/Model"); //rownum++;
					 * cell.setCellValue(name);
					 * 
					 * }else { cell.setCellValue(name); }
					 */
				  
				  cell.setCellValue(name);
			  
			  
			  }
			 
				/*
				 * for(int i=0;i<outarray.size();i++) {
				 * 
				 * Row row = sheet.createRow(rownum++); Cell cell = row.createCell(0);
				 * System.out.println(outarray.get(i)); cell.setCellValue(outarray.get(i)); }
				 */
       
         String filepath = reusableComponents.getPropValues("outputfolder");
			
			String outfilename = reusableComponents.getPropValues("outputfile");

			File file = new File(workingDir +"/" +  filepath +"/"+dateFormat.format(c.getTime())+ outfilename);
			System.out.println(file);
         
            FileOutputStream out = new FileOutputStream(file); // file name with path
            workbook.write(out);
            out.close();
		
	
		
		
		
	}catch(NoSuchElementException e){
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new Custprojpage(browser);
	}

	
	
	/*** Test case Method Name : validateTestOpp
	 * 	 Functionality         : validate opportunity creation
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  Custprojpage validateTestOpp(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		try {/*
				 * 
				 * HSSFWorkbook workbook = new HSSFWorkbook();
				 * 
				 * HSSFSheet sheet = workbook.createSheet("vehiclenames");// creating a blank
				 * sheet int rownum = 0;
				 * 
				 * for (String name : outarray) { Row row = sheet.createRow(rownum++); Cell cell
				 * = row.createCell(0); cell.setCellValue(name);
				 * 
				 * 
				 * }
				 * 
				 * 
				 * for(int i=0;i<outarray.size();i++) {
				 * 
				 * Row row = sheet.createRow(rownum++); Cell cell = row.createCell(0);
				 * System.out.println(outarray.get(i)); cell.setCellValue(outarray.get(i)); }
				 * 
				 * String filepath = reusableComponents.getPropValues("outputfolder");
				 * 
				 * String outfilename = reusableComponents.getPropValues("outputfile");
				 * 
				 * File file = new File(workingDir +"/" +  filepath +"/"+ outfilename);
				 * System.out.println(file);
				 * 
				 * FileOutputStream out = new FileOutputStream(file); // file name with path
				 * workbook.write(out); out.close();
				 * 
				 */
	}catch(NoSuchElementException e){
		
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new Custprojpage(browser);
	}

	

	/*** Test case Method Name : validateTestOpp
	 * 	 Functionality         : validate opportunity creation
	 * 	 Created By			   : Subramanya MS
	 * @throws IOException 
	 * @throws AWTException 
	 * 
	***/
	public synchronized  Custprojpage validateNewTest_rv(int threadID , List<String> tempList , String pathLoc ) throws IOException, AWTException {
		String testcasemethod = new Object(){}.getClass().getEnclosingMethod().getName();
		try {
			
			ReusableComponents.wait(5500);
			
			if(ReusableComponents.isElementPresent(shop_now)){
				
				ReusableComponents.wait(5500);
				shop_now.click();
				
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"shop_now clicked successfully ", browser, pathLoc + "/" + testcasemethod, false);
				
				((JavascriptExecutor) browser)
				.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
				
				ReusableComponents.wait(15500);
				//if the alert drops in, click no thanks link
				if(ReusableComponents.isElementPresent(no_thanks)){
					
					
					no_thanks.click();
					ReusableComponents.wait(5500);
					

				}else{
					//ReusableComponents.reportFail( threadID , tempList , testcasemethod , "no_thanks link is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
				}
				
				
				
			try {
				location_list = browser.findElements(By.xpath("//div[@class='CheckBoxList lots']/div")); 	
					
				location_list_size = location_list.size();
				System.out.println(location_list_size);
				ReusableComponents.reportPass(threadID, tempList, testcasemethod,
						"location_list_size generated successfully "+location_list_size, browser, pathLoc + "/" + testcasemethod, false);
				
				for(i=0;i<location_list_size;i++) {
					
					j=i+1;
					
					WebElement identifier = browser.findElement(By.xpath("//div[@class='CheckBoxList lots']/div["+j+"]/label/input"));
					WebElement name = browser.findElement(By.xpath("//div[@class='CheckBoxList lots']/div["+j+"]/label"));
					WebElement total_items = browser.findElement(By.xpath("//div[@class='CheckBoxList lots']/div["+j+"]/label/span/span"));
					
					
					if(ReusableComponents.isElementPresent(identifier)){
						
						ReusableComponents.wait(3500);
						identifier.click(); // checkbox tick
						
						ReusableComponents.wait(3500);
						//write the logic here to pick the items
						
						if(ReusableComponents.isElementPresent(name)) {
							
							locnameeditor = name.getText();
							
							System.out.println("the name "+name.getText());
							Loc_name.add(locnameeditor);
						}else {
							
							System.out.println("name not present");
							Loc_name.add("na");
						}
						
						if(ReusableComponents.isElementPresent(total_items)) {
							
							System.out.println("total items "+total_items.getText());
							locnumeditor = total_items.getText();
							
							Loc_total.add(locnumeditor);
						}else {
							
							System.out.println("total_items not present");
							Loc_total.add("NA");
						}
						
						
						
						
						ReusableComponents.wait(3500);
						System.out.println(browser.getCurrentUrl());
						Loc_url.add(browser.getCurrentUrl()+"&pagesize="+Loc_total.get(i));
//						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
//								"urls generated successfully "+browser.getCurrentUrl()+"&pagesize="+Loc_total.get(i), browser, pathLoc + "/" + testcasemethod, false);
//						
						
						
						if(j==2) {
							
							ReusableComponents.wait(15500);
						
							//if the alert drops in, click no thanks link
							if(ReusableComponents.isElementPresent(no_thanks)){
								no_thanks.click();
								ReusableComponents.wait(5500);
							
							}else{
								//ReusableComponents.reportFail( threadID , tempList , testcasemethod , "no_thanks link is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
							}
							
							
						}
						
						ReusableComponents.wait(3500);
						identifier.click(); // checkbox untick

					}else{
						ReusableComponents.reportFail( threadID , tempList , testcasemethod , "identifier checkbox is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
					}
					
					
					
					
					
				}
				
				try {
					// write the other method in here
					for (i=0;i<Loc_url.size();i++) {
						
						System.out.println(Loc_url.get(i));
						
						browser.get(Loc_url.get(i));
						
						ReusableComponents.wait(13500);
//						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
//								"identifying the vehicles in specific location ", browser, pathLoc + "/" + testcasemethod, false);
//						
						
						outputarray = browser.findElements(By.xpath("//div[@class='unit-title-wrapper list-mode']//div[@class='h3 unit-title']/a"));
						System.out.println(outputarray.size());
//						ReusableComponents.reportPass(threadID, tempList, testcasemethod,
//								"number of vehicles in specific location "+outputarray.size(), browser, pathLoc + "/" + testcasemethod, false);
//						
						ReusableComponents.wait(5500);
						
						for(int i=0;i<outputarray.size();i++) {
							
							outarray.add(outputarray.get(i).getText());

						}
						ReusableComponents.wait(5500);

						HSSFWorkbook workbook = new HSSFWorkbook(); 
					    
					    HSSFSheet sheet = workbook.createSheet("vehiclenames");// creating a blank sheet
					     int rownum = 0;
							
							  for (String name : outarray) { 
								  Row row = sheet.createRow(rownum++); 
								  Cell cell = row.createCell(0); cell.setCellValue(name);
							  
							  
							  }
							 
							
					   
					     String filepath = reusableComponents.getPropValues("outputfolder");
							
							String outfilename = Loc_name.get(i);

							File file = new File(workingDir +"/" +  filepath +"/"+ outfilename + ".xls");
							System.out.println(file);
					     
					        FileOutputStream out = new FileOutputStream(file); // file name with path
					        workbook.write(out);
					        out.close();
						
					outarray.clear();
						
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
				
			}else{
				ReusableComponents.reportFail( threadID , tempList , testcasemethod , "shop_now button is NOT present successfully", browser ,pathLoc+"/"+testcasemethod , true );
			}
			
			
	}catch(NoSuchElementException e){
		
		ReusableComponents.reportFail( threadID , tempList , testcasemethod , " Object is not present"+e.getStackTrace() , browser ,pathLoc+"/"+testcasemethod , false );
	}
		
		return new Custprojpage(browser);
	}

	
	

}


