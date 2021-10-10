package com.wisefinch.java;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Xml_reader_excel extends DriverScript {
	
	static ReusableComponents reusableComponents = new  ReusableComponents();
	
	static String workingDir = System.getProperty("user.dir"), running_now = null;
	static ArrayList<String> runnerlist= new ArrayList<String>();
	static ArrayList<String> testcasename= new ArrayList<String>();
	static ArrayList<String> decision= new ArrayList<String>();
	

	public static void main(String[] args) {
		
		
		//add excel input code here, once done - update with if else conditions
		

		


		try {
			String filename = reusableComponents.getPropValues("scenario_read");
			String sheetname = reusableComponents.getPropValues("scenario_sheet");
			System.out.println(filename);
			System.out.println(sheetname);


			File file = new File(workingDir + "/input/" + filename);
			FileInputStream istream = new FileInputStream(file);

			Workbook myworkbook = null;

			String fileExtensionName = filename.substring(filename.indexOf("."));

			if (fileExtensionName.equals(".xlsx")) {
				// If it is xlsx file then create object of XSSFWorkbook class
				myworkbook = new XSSFWorkbook(istream);
			}
			// Check condition if the file is xls file
			else if (fileExtensionName.equals(".xls")) {
				// If it is xls file then create object of HSSFWorkbook class
				myworkbook = new HSSFWorkbook(istream);
			}

			Sheet workbooksheet = myworkbook.getSheet(sheetname);
			int rowCount = workbooksheet.getLastRowNum() - workbooksheet.getFirstRowNum();
			int columnCount = workbooksheet.getRow(0).getLastCellNum();
			System.out.println("Row count is " +rowCount+ " Column count is " +columnCount);

			// read rows and columns
			
			Iterator<Row> itr = workbooksheet.iterator();
			
			while(itr.hasNext()) {
				Row row = itr.next();
				 if(row.getRowNum()==0 ){
				       continue; //just skip the rows if row number is 0 or 1
				      }

				// if(row.getRowNum() == 1) {
					 
					 Iterator<Cell> celliterator = row.cellIterator();
						
						while(celliterator.hasNext()) {
  
							  Cell cell = celliterator.next(); 
							  final DataFormatter formatter = new DataFormatter(); 
							  runnerlist.add(formatter.formatCellValue(cell));
							 
							   
						}
					 
				// }
				 
				 
				
			}
			
			
			for(int i=0; i<runnerlist.size();i++) {
				
				if(i % 2 == 0) {
					
					testcasename.add(runnerlist.get(i));
					
				}else
				{
					decision.add(runnerlist.get(i));
				}
				
				
				
			}
			
			
			for(int j=0; j<testcasename.size();j++) {
				
				System.out.print("testcase id "+testcasename.get(j));
				System.out.println(" decision "+decision.get(j));
				
				// run starts here
				
				// decide whether it needs to be run
				

				if(decision.get(j).equalsIgnoreCase("YES") || decision.get(j).equalsIgnoreCase("Y") ) {
					
					//add runner code here
					
					TestNG runner = new TestNG();
					List<String> suitefiles=new ArrayList<String>();
					
					running_now = workingDir+"/"+testcasename.get(j)+".xml";
					suitefiles.add(running_now);//
					System.out.println("working directory is "+workingDir);
					System.out.println("working case is "+running_now);
					runner.setTestSuites(suitefiles);
					runner.run();	
					
					
				}else
					
				{
					ReusableComponents.reportInfo(j, decision, filename, "testcase "+testcasename.get(j)+" is not opted for run", null, fileExtensionName, false);
					//ReusableComponents.reportInfo(threadID,tempResultList,testMethod , "Chrome Browser started", browser ,pathLoc+"/"+TESTCASENAME , false );
				}
				
				

				
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		

	

	
	
		
		
		
		//until here
		
//		TestNG runner = new TestNG();
//		
//		List<String> suitefiles=new ArrayList<String>();
//		
//		suitefiles.add(workingDir+"/Prerequisite.xml");
//		
//		System.out.println("working directory is "+workingDir);
//		
//		runner.setTestSuites(suitefiles);
//		
//		runner.run();	
		
	}

}
