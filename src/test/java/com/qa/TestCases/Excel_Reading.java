package com.qa.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.qa.BaseClass.BaseClass;



public class Excel_Reading extends BaseClass
{
	 public Excel_Reading() throws IOException
	{
		super();
	}

	static XSSFSheet sheet_name;
	

	public static Object[][] File_data(String sheetName) throws IOException
	{
			File filepath = new File("/home/teena/eclipse-workspace/AutomationPracticeTestCases/Automation_testData.xlsx");
			
			FileInputStream read_file = new FileInputStream(filepath);
			
		    XSSFWorkbook workbook = new XSSFWorkbook(read_file);
			
		   sheet_name = workbook.getSheetAt(0);
		    int row_count = sheet_name.getLastRowNum();
		    System.out.println(row_count);
		    
		    Object[][] data =  new Object[sheet_name.getLastRowNum()][sheet_name.getRow(0).getLastCellNum()];
		    
		    for(int i=0;i<sheet_name.getLastRowNum();i++)
		    {
		       for (int k=0;k<sheet_name.getRow(0).getLastCellNum();k++)
		       {
		    	   data[i][k] = sheet_name.getRow(i+1).getCell(k).toString();
 		       }
		    }return data;
		    
}}
