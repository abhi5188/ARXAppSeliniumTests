package com.excel.intellect.poc;

public class ExecClass {
	
	public static void main(String[] args) {
		
		//Reading Excel File
		//ReadExcel readExcel = new ReadExcel("D:\\Documents\\TestData.xls");
		
		//readExcel.readData();
		
		//Writing Excel File
		WriteExcel writeExcel = new WriteExcel("D:\\Documents\\TestData.xls");
		
		writeExcel.writeData();
	}

}
