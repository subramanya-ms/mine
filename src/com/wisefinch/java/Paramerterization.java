package com.wisefinch.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class Paramerterization {

	public static void main(String[] args) throws IOException {
		Workbook myworkbook = null;
		myworkbook = new XSSFWorkbook();
		File file = new File("D:/users/subramanya/workspace/Wisefinch/master_framework/input/training_old.xlsx");
		FileInputStream istream = new FileInputStream(file);
		
		myworkbook = new XSSFWorkbook(istream);
	//	XSSFWorkbook file = new XSSFWorkbook("D:/users/subramanya/workspace/Wisefinch/master_framework/input/training_old.xlsx"); 

	//	XSSFSheet excelsheet = file.getSheetAt(0);
		Sheet excelsheet = myworkbook.getSheet("testing");
		
		int rowCount = excelsheet.getLastRowNum();
		int columnCount = excelsheet.getRow(0).getLastCellNum();
		System.out.println("Row count is" +rowCount+ "Column count is " +columnCount);

		for(int i=0; i<rowCount+1; i++) {
			
			XSSFRow row = (XSSFRow) excelsheet.getRow(i);
		
	
			  for(int j=0;j<columnCount; j++) 
			  { 
				  System.out.println("Row is " +i + " column is " +j );
				  System.out.println();
				  if(i==0 && j==0)
				  {
					  continue;
				  }
				 if(i==0 && j==1)
				 {
					 continue;
				 }
				 if(i==0 && j==2)
				 {
					 continue;
				 }
			  XSSFCell cell = row.getCell(j);
			  String data = cell.getStringCellValue();
			  System.out.print(data);
			  System.out.print(" ");
			  }
			 System.out.println();
		}

}

}
