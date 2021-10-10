package com.wisefinch.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;


public class ExcelInput extends DriverScript {
	
	static ReusableComponents reusableComponents = new ReusableComponents();

	public static void main(String[] args) throws InterruptedException, Exception {
		
		String startdate = null, enddate = null;
		
		ArrayList<String> startdate_arr= new ArrayList<String>();
		
		try {

			String filename = reusableComponents.getPropValues("trainingfilename");
			String sheetname = reusableComponents.getPropValues("trainingsheetname");
			
			//String outfilename = reusableComponents.getPropValues("outputfilename");
			//String outsheetname = reusableComponents.getPropValues("outputsheetname");

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
			System.out.println("Row count is" +rowCount+ "Column count is " +columnCount);

			/*
			 * // read rows and columns
			 * 
			 * for(int i=0; i<rowCount+1; i++) {
			 * 
			 * XSSFRow row = (XSSFRow) workbooksheet.getRow(i);
			 * 
			 * 
			 * for(int j=0;j<columnCount; j++) { System.out.println("Row is " +i +
			 * " column is " +j ); System.out.println(); if(i==0 && j==0) { continue; }
			 * if(i==0 && j==1) { continue; } if(i==0 && j==2) { continue; } XSSFCell cell =
			 * row.getCell(j); String data = cell.getStringCellValue();
			 * System.out.print(data); System.out.print(" "); } System.out.println(); }
			 * 
			 */
			
			  Iterator<Row> itr = workbooksheet.iterator();
			  
			  while(itr.hasNext()) { Row row = itr.next();
			  
			  Iterator<Cell> celliterator = row.cellIterator();
			  
			  while(celliterator.hasNext()) {
			  
			  Cell cell = celliterator.next(); 
			  final DataFormatter formatter = new DataFormatter(); 
			  
			  startdate_arr.add(formatter.formatCellValue(cell)); //throw new
			 
			  
			  } }
			 
		
			// lets print the array elements
			
			for (int i=0; i< startdate_arr.size();i++) {
				
				if(i==0) {
					continue;
				}if(i==1) {
					continue;
				}
				else {
					System.out.println("printing values "+startdate_arr.get(i));
				}
					
				
				
			}

		} catch (NoSuchElementException e) {
		
		}
		
	}


}
