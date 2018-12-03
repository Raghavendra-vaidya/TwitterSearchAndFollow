package com.twitter.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetData 
{
	
	public static String fromProperties(String filename, String key)
	{
		String data = null;
		File propFile = new File("./config/"+filename+".properties");
		
		try{
		FileInputStream fis = new FileInputStream(propFile);
		Properties prop = new Properties();
		prop.load(fis);
		data = (String) prop.get(key);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(Exception e2){
			e2.printStackTrace();
		}
		
		return data;
	}
	
	public static String fromExcel(String fileName, String sheetName, int rIndex, int cIndex){
		String data = null;
		File f = new File("./test-data/"+fileName+".xlsx");
		try
		{
		 FileInputStream fis = new FileInputStream(f);
		 Workbook wb=WorkbookFactory.create(fis);
		 Sheet sht=wb.getSheet(sheetName);
		 Row rw = sht.getRow(rIndex);
		 Cell c = rw.getCell(cIndex);
		 DataFormatter dataformat = new DataFormatter();
		data = dataformat.formatCellValue(c);	 

		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("unable to fetch data");
		}
		
		
		
		return data;
	}
}
