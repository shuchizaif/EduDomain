package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
    private static final String TEST_DATA_SHEET_PATH ="./src/main/resources/testdata/OpenCartTestData.xlsx";
	private static Workbook book;
	private static Sheet sheet;
	
	
	
	
	public static Object[][] getTestData(String sheetName)
	{
		System.out.println("reading the data from sheet" + sheetName );
	
	
	Object data[][]= null;
	try {
		FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
		book = WorkbookFactory.create(ip);//will pass FileInputStream class obj to interact with this excel sheet
		//As create method returns reference variable of WorkBook Class
	    sheet = book.getSheet(sheetName);
	    data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];//intializing Object array to have memory to add data
		
		for(int i=0;i<sheet.getLastRowNum();i++)//rows count done
			
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)//this will count cloumn from 0 to last cell no.
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				
			}
		}
			
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//This will make connection with excel file to read
 catch (EncryptedDocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return data;
	
	
	
	}

}
