package com.excel.intellect.poc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	HSSFSheet sheet1;
	
	public ReadExcel(String excelPath){
		
		File file = new File(excelPath);
		try {
			FileInputStream fis = new FileInputStream(file);
			workbook = new HSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			sheet1 = workbook.getSheet("EmailId");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readData(){
		
		int rowCount = sheet.getLastRowNum();
		
		for(int i=0; i<=rowCount; i++){
			
			String data = sheet.getRow(i).getCell(0).getStringCellValue();
			
			System.out.println("The data at 0 is:"+ data);
		}
		
		for(int i=0; i<=rowCount; i++){
			
			String data = sheet.getRow(i).getCell(1).getStringCellValue();
			
			System.out.println("The data at 0 is:"+ data);
		}
		
		int emailRowCount = sheet1.getLastRowNum();
		
		for(int i=0; i<=emailRowCount; i++){
			
			String data = sheet1.getRow(i).getCell(0).getStringCellValue();
			
			System.out.println("The data at 0 is:"+ data);
		}
		
		
	}
}
