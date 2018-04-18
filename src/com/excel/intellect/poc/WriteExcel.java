package com.excel.intellect.poc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteExcel {
	
	HSSFWorkbook hssfWorkbook;
	HSSFSheet hssfSheet;
	String filePath = null; 
	
		public WriteExcel(String excelPath){
			
			filePath = excelPath;
			
			File file = new File(excelPath);
			try {
				FileInputStream fis = new FileInputStream(file);
				hssfWorkbook = new HSSFWorkbook(fis);
				hssfSheet = hssfWorkbook.getSheetAt(0);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		public void writeData(){
			
			int rowCount = hssfSheet.getLastRowNum();
			
			for(int i=0; i<=rowCount; i++){
				
				//hssfSheet.getRow(i).createCell(2).setCellValue("Pass");
				
				try {
					FileOutputStream fos = new FileOutputStream(filePath);
					
					hssfWorkbook.write(fos);
					hssfWorkbook.close();
					
					System.out.println("Success");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			
			
		}
}
