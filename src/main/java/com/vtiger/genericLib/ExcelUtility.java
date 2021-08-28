package com.vtiger.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author karth
 *
 */

public class ExcelUtility {
	
	/**
	 * 
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */

	public String getDataFromExcel(String sheet, int rowNum, int cellNum) throws Throwable {
	FileInputStream fin = new FileInputStream("C:\\Users\\karth\\OneDrive\\Desktop\\testing.xlsx");
	Workbook wb = WorkbookFactory.create(fin);
	Sheet sh = wb.getSheet(sheet);
	Row row = sh.getRow(rowNum);
	String data = row.getCell(cellNum).getStringCellValue();
	wb.close();
	return data;
	}
	public int getDataFromExcelUniqueLeadNo(String sheet, int rowNum, int cellNum) throws Throwable {
	FileInputStream fin = new FileInputStream("C:\\Users\\karth\\OneDrive\\Desktop\\testing.xlsx");
	Workbook wb = WorkbookFactory.create(fin);
	Sheet sh = wb.getSheet(sheet);
	Row row = sh.getRow(rowNum);
	int data = (int) row.getCell(cellNum).getNumericCellValue();
	wb.close();
	return data;
	}
	
	
	
	/**
	 * 
	 * @param sheet
	 * @return
	 * @throws Throwable
	 */
	
	public int getRowNum(String sheet) throws Throwable {
		FileInputStream fin = new FileInputStream("‪C:\\Users\\karth\\OneDrive\\Desktop\\testing.xlsx");
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sh = wb.getSheet(sheet);
		wb.close();
		return sh.getLastRowNum();
	}
	
	/**
	 * 
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	
	public void setDataToExcel(String sheet, int rowNum, int cellNum, String data) throws Throwable {
		FileInputStream fin = new FileInputStream("C:\\Users\\karth\\OneDrive\\Desktop\\testing.xlsx");
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fis = new FileOutputStream("C:\\Users\\karth\\OneDrive\\Desktop\\testing.xlsx");
		wb.write(fis);
		
		wb.close();
	}
	public void setDataToExcelUniqueLeadNo(String sheet, int rowNum, int cellNum, int data) throws Throwable {
		FileInputStream fin = new FileInputStream("C:\\Users\\karth\\OneDrive\\Desktop\\testing.xlsx");
		Workbook wb = WorkbookFactory.create(fin);
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fis = new FileOutputStream("C:\\Users\\karth\\OneDrive\\Desktop\\testing.xlsx");
		wb.write(fis);
		
		wb.close();
	}

}
