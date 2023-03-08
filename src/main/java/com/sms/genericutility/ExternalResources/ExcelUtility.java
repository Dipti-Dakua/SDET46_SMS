package com.sms.genericutility.ExternalResources;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class is used to operate with exel file
 * @author MY PC
 *
 */
public class ExcelUtility {
	FileInputStream excelFis;
	 Workbook book;
	 DataFormatter format;
	  String value;
	public ExcelUtility()
	{
		
	}
	/**
	 * This constructor is used to initialize the excel
	 * @param filepath
	 */
	public ExcelUtility(String filepath)
	{
		initializeExcel(filepath);
	}
	
	/**
	 * this function is used to initialize the excelFile
	 * @param excelpath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	
	public void initializeExcel(String filepath)
	{
		 format= new DataFormatter();
		
		try {
			excelFis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {

		}
		try {
			 book=WorkbookFactory.create(excelFis);
		} catch (EncryptedDocumentException e) {
			
		} catch (IOException e) {
			
		}
	}
	
	
	/**
	 * This function is used to get all the value  from excel file based on key
	 * @param sheetname
	 * @param testcaseNAme
	 * @return 
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public Map<String, String> getData(String sheetname,String testcaseNAme) 
	{
		
		Sheet sheet=book.getSheet(sheetname);
		int rowCount=sheet.getLastRowNum();
		
		Map<String,String> map= new HashedMap<>();
			for(int i=1;i<=rowCount;i++)
			{
				String testScriptName=format.formatCellValue(sheet.getRow(i).getCell(0));
		
				if(testScriptName .equals(testcaseNAme))
				{
					for(int j=1;j<sheet.getRow(i).getLastCellNum();j++)
					{
					   String key=	format.formatCellValue(sheet.getRow(i).getCell(j));
					  String  value=format.formatCellValue(sheet.getRow(i+1).getCell(j));
					   map.put(key, value);
					}
					break;
				}
				
			}
	
			return map;
	}
	
	/**
	 * This method is used to get data from excel file by validating key value
	 * @param sheetname
	 * @param testcaseNAme
	 * @param expKey
	 * @return
	 */
	public String getExcelData(String sheetname,String testcaseNAme,String expKey)
	{
		
		Sheet sheet=book.getSheet(sheetname);
		int rowCount=sheet.getLastRowNum();
	//	String testcaseNAme="AddAndVerifyimetable";
		
		//Map<String,String> map= new HashedMap<>();
			for(int i=1;i<=rowCount;i++)
			{
				String testScriptName=format.formatCellValue(sheet.getRow(i).getCell(0));
		
				if(testScriptName .equals(testcaseNAme))
				{
					for(int j=1;j<sheet.getRow(i).getLastCellNum();j++)
					{
					   String key=	format.formatCellValue(sheet.getRow(i).getCell(j));
					   if(key .equals(expKey))
					   {
						   
					    value=format.formatCellValue(sheet.getRow(i+1).getCell(j));
					    break;
					   }
					}
					break;
				}
				
			}
			return value;
	}
	
	/**
	 * This method is used to get multiple data from excel file 
	 * @param sheetname
	 * @param testcaseName
	 * @param expKey
	 * @return
	 */
	
	
	public List<String> getData(String sheetname,String testcaseName,String expKey)
	{
		Sheet sheet=book.getSheet(sheetname);
		int rowCount=sheet.getLastRowNum();
		List<String> datalist=new ArrayList<>();
			for(int i=1;i<=rowCount;i++)
			{
				String testScriptName=format.formatCellValue(sheet.getRow(i).getCell(0));
		
				if(testScriptName .equals(testcaseName))
				{
					for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
					{
					   String key=	format.formatCellValue(sheet.getRow(i).getCell(j));
					   if(key .equals(expKey))
						{
							for(int k=i+1; ;k++)
							{
							   String data=	format.formatCellValue(sheet.getRow(k).getCell(j));
							   if (data .equals(""))
							   {
								   break;
							   }
							   else
							   {
								   datalist.add(data);
					  
							   }
							}
					break;
						}
					}
					break;
				}
			}
			return datalist;
	}	
	
	/**
	 * This method is used to fetch multiple data from excel 
	 * This method is used to excecute single test case with multiple data
	 * @param sheetname
	 * @return
	 */
	
	
	public String[][] getMultipleData(String sheetname)
	{
		Sheet sheet=book.getSheet(sheetname);
		int rowCount=sheet.getLastRowNum();
		String[][] arr=new String[rowCount][sheet.getRow(0).getLastCellNum()];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
			{
				arr[i-1][j]=format.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}

	return arr;	
	}
	
	
	/**
	 * This method is used to get Data from excel file based on given index
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public String getData(String sheetname,int rowNum,int cellNum)
	{
		Sheet sheet=book.getSheet(sheetname);
		String value=format.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
		return value;
		
	}
	/**
	 * This method is used to write Data in excel file based on given index
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 */
	public void setData(String sheetName,int rowNum,int cellNum)
	{
		book.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
	}
	
		
		
	/**
	 * This method is used to close the FileInputstream of excel sheet
	 */
public void close()
{
	try {
		excelFis.close();
	} catch (IOException e) {
		
	}
}
}	
	
	


