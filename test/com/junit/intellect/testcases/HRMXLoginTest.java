package com.junit.intellect.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.junit.intellect.poc.CommonConstants;

public class HRMXLoginTest {
	
	@BeforeClass
	public static void beforeClassMeth(){
		
		System.out.println("Executing test cases for Login To HRMX");
		
	}
	
	@Before
	public void beforeTestMeth(){
		
		System.out.println("Before Test Case");
	}
	
	//Login To HRMX Test Case
	@Test
	public void loginToHRMX(){
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("test-type");
        
		String exePath = "C:\\Users\\abhishek2.s\\Downloads\\browserdrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		
		WebDriver driver = new ChromeDriver();
		
		File file = new File(CommonConstants.FILEPATH);
		FileInputStream fis;
		HSSFWorkbook workbook;
		HSSFSheet sheet;
		int rowCount;
		try {
			fis = new FileInputStream(file);
			workbook = new HSSFWorkbook(fis);
			sheet = workbook.getSheet(CommonConstants.SHEETNAME);
			rowCount = sheet.getLastRowNum();
			
			for(int i=0; i<=rowCount; i++){
				
		        driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.get("https://cloud.myadrenalin.com/adrenalin/");
				driver.findElement(By.id("txtID")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
				driver.findElement(By.id("txtPwd")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
				driver.findElement(By.id("txtCompName")).sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
				driver.findElement(By.id("LocalizedButton1")).click();
				Thread.sleep(5000);
				Assert.assertTrue(driver.getTitle().contains("ZOLOG"));
			}		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void afterClassMeth(){
		
		System.out.println("After Test Case");
	}
	
	@AfterClass
	public static void afterTestMeth(){
		
		System.out.println("Execution for Login To HRMX completed");
	}

}
