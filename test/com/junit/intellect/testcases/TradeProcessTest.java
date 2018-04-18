package com.junit.intellect.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class TradeProcessTest {
	
	HSSFWorkbook workbook = null;
	HSSFSheet sheet = null;
	WebDriver driver = null;
	Properties p = new Properties();
	String originalWindowHandle=null;
	
	public TradeProcessTest() {
		try {
			FileReader reader = new FileReader(
					"selenium.properties");
			p.load(reader);
			
			File file = new File(p.getProperty("excel_path"));
			System.out.println("Excel Path >>> "+file);
			FileInputStream fis = new FileInputStream(file);
			workbook = new HSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
   
	@Before
	public void beforeTest() {
    	String browser= "chrome";
		System.out.println("This is from Browser");

		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", p.getProperty("gecoDriverPath"));

				System.setProperty("webdriver.firefox.bin", p.getProperty("fireFoxExe"));
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				driver = new FirefoxDriver();
				System.out.println("This is from firefox");
			}

			else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();

				System.out.println("This is from Chrome");
			}

			else if (browser.equalsIgnoreCase("IE")) {
				String service = p.getProperty("ieDriverPath");
				System.setProperty("webdriver.ie.driver", service);
			   driver = new InternetExplorerDriver();
				

			}
			driver.get(p.getProperty("portal_url"));
			System.out.println("portal url"+p.getProperty("portal_url"));

			 originalWindowHandle = driver.getWindowHandle();
			System.out.println("original Window handles are: " + originalWindowHandle);
			System.out.println("Title of original Page:" + driver.getTitle());  
			
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

/*	@Test
	public void login() throws InterruptedException {
		System.out.println("Raiffeisen Web portal");

		Thread.sleep(10000);
		
		java.util.Set<java.lang.String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		int count = windowHandles.size();
		
		String windowTitle="Intellect Suite - Enterprise Platform for Boundaryless Banking from Intellect Design Arena";
		for (String window: windowHandles) {
		        driver.switchTo().window(window);
		          
		        if(driver.getTitle().equals(windowTitle)){
		        String url = driver.getCurrentUrl();
		        System.out.println("current url is: " + url);  
		        break;
		        }
		        
		}   
		
		Thread.sleep(10000);
		WebElement divBox = driver.findElement(By.id("body_01_in_woCap"));
		WebElement usernameBox = driver.findElement(By.name("txtUserId"));
		usernameBox.sendKeys(p.getProperty("username"));
		WebElement passwordBox = driver.findElement(By.name("txtUserPassword"));
		passwordBox.sendKeys(p.getProperty("password"));
	    WebElement loginButton = driver.findElement(By.id("submitbtn"));
		loginButton.click();
		Thread.sleep(10000);
		
		for (WebElement e :driver.findElements(By.tagName("frame")))
	    {
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(e);
	 
	        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
	 
			System.out.println("links"+links.size());
			 
			for (int i = 0; i<links.size(); i=i+1)
			{
			 
			if(links.get(i).getText().equals("TRADE"))
			{
			WebElement tradeLink = driver.findElement(By.linkText("TRADE"));
			tradeLink.click();
			break;
				}
				 
			}
	    }
		
	    Thread.sleep(5000);
	    
	    System.out.println("Login to Raiffeisen Web portal test completed");
	}
	
	@Test
	public void registrationFlow() throws InterruptedException {

		System.out.println("Raiffeisen Web portal Registration Test");

		Thread.sleep(10000);
		
		java.util.Set<java.lang.String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		int count = windowHandles.size();
		
		String windowTitle="Intellect Suite - Enterprise Platform for Boundaryless Banking from Intellect Design Arena";
		for (String window: windowHandles) {
		        driver.switchTo().window(window);
		          
		        if(driver.getTitle().equals(windowTitle)){
		        String url = driver.getCurrentUrl();
		        System.out.println("current url is: " + url);  
		        break;
		        }
		        
		}   
		
		Thread.sleep(10000);
		WebElement divBox = driver.findElement(By.id("body_01_in_woCap"));
		WebElement usernameBox = driver.findElement(By.name("txtUserId"));
		usernameBox.sendKeys(p.getProperty("username"));
		WebElement passwordBox = driver.findElement(By.name("txtUserPassword"));
		passwordBox.sendKeys(p.getProperty("password"));
	    WebElement loginButton = driver.findElement(By.id("submitbtn"));
		loginButton.click();
		Thread.sleep(10000);
		
		for (WebElement e :driver.findElements(By.tagName("frame")))
	    {
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(e);
	 
	        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
	 
			System.out.println("links"+links.size());
			 
			for (int i = 0; i<links.size(); i=i+1)
			{
			 
			if(links.get(i).getText().equals("TRADE"))
			{
			WebElement tradeLink = driver.findElement(By.linkText("TRADE"));
			tradeLink.click();
			break;
				}
				 
			}
	    }
		
	    Thread.sleep(5000);
		
	    java.util.Set<java.lang.String> windowHandles2 = driver.getWindowHandles();
		System.out.println(windowHandles2);
		int count2 = windowHandles2.size();
		
		for (String window: windowHandles2) {
			 driver.switchTo().window(window);
		        System.out.println("current Title is: " + driver.getTitle()); 
		        
		        
		      if(driver.getTitle().length()==0){
		        String url = driver.getCurrentUrl();
		        System.out.println("current url is: " + url);  
		       
		        break;
		        }
		}
		
		for (WebElement e :driver.findElements(By.tagName("frame")))
	    {
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(e);
	        java.util.List<WebElement> links = driver.findElements(By.tagName("div"));

		
			for (int i = 0; i<links.size(); i=i+1)
			{
				
				if(links.get(i).getText().equals("Registration"))
					{
				
				links.get(i).click();
				break;
			}
			
			}
	
	    }
		
		
		 driver.switchTo().defaultContent();
		for (WebElement e :driver.findElements(By.tagName("frame")))
	    {
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(e);
	        java.util.List<WebElement> links = driver.findElements(By.tagName("td"));

			
			for (int i = 0; i<links.size(); i=i+1)
			{
				
				if(links.get(i).getText().equals("Reimbursement"))
					{
				
				links.get(i).click();
				break;
			}
			
			}
	
	    }
		
		
		
		
		 driver.switchTo().defaultContent();
		for (WebElement e :driver.findElements(By.tagName("frame")))
	    {
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(e);
	        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));

			for (int i = 0; i<links.size(); i=i+1)
			{
				
				if(links.get(i).getText().equals("RA/RU"))
					{
				
				links.get(i).click();
				break;
			}
			
			}
	
	    }
		
		Thread.sleep(5000);
		
		Select product = new Select(driver.findElement(By.name("cmbPkField2")));
		product.selectByIndex(1);
		
		Thread.sleep(5000);
		
		Select operation = new Select(driver.findElement(By.name("cmbPkField3")));
		operation.selectByIndex(3);
		
		WebElement registerButton = driver.findElement(By.name("register"));
		registerButton.click();
		
		Thread.sleep(10000);
		
		driver.switchTo().frame("IndexRegister");
		
		//Initiator CIF No
		WebElement initiatorCifNo = driver.findElement(By.name("txtBICICIFNo"));
		initiatorCifNo.sendKeys(Double.toString(sheet.getRow(0).getCell(0).getNumericCellValue()));
		
		//Documentary Credit Number
		WebElement docCreditNo = driver.findElement(By.name("txtBICIReferenceNo"));
		docCreditNo.sendKeys(Double.toString(sheet.getRow(0).getCell(1).getNumericCellValue()));
		
		//RA Amount
		WebElement raAmtCurr = driver.findElement(By.name("txtBILCDLCAmountCurrency"));
		raAmtCurr.sendKeys(sheet.getRow(0).getCell(2).getStringCellValue());
		
		WebElement raAmount = driver.findElement(By.name("txtBILCDLCAmount"));
		raAmount.sendKeys(Double.toString(sheet.getRow(0).getCell(3).getNumericCellValue()));
		
		//Initiator Name
		WebElement initiatorName = driver.findElement(By.name("txtBICICustomerName"));
		initiatorName.sendKeys(sheet.getRow(0).getCell(4).getStringCellValue());
		
		//Expiry Date
		WebElement expiryDate = driver.findElement(By.name("txtBILCNExpiryDate"));
		expiryDate.sendKeys(sheet.getRow(0).getCell(6).getStringCellValue());
		Thread.sleep(10000);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("SearchFrame");
		
		driver.switchTo().frame("RegButtons");
		
		WebElement submitButton = driver.findElement(By.className("Submit"));
		
		System.out.println("<<<<<<<<<<"+submitButton.getText());
		submitButton.click();
		
		Thread.sleep(10000);
		
		System.out.println("Raiffeisen Web portal Registration Test completed");
		
	}*/
	
	@Test
	public void authorizationFlow() throws InterruptedException {

		System.out.println("Raiffeisen Web portal authorization flow");

		Thread.sleep(10000);
		
		java.util.Set<java.lang.String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		int count = windowHandles.size();
		
		String windowTitle="Intellect Suite - Enterprise Platform for Boundaryless Banking from Intellect Design Arena";
		for (String window: windowHandles) {
		        driver.switchTo().window(window);
		          
		        if(driver.getTitle().equals(windowTitle)){
		        String url = driver.getCurrentUrl();
		        System.out.println("current url is: " + url);  
		        break;
		        }
		        
		}   
		
		Thread.sleep(10000);
		WebElement divBox = driver.findElement(By.id("body_01_in_woCap"));
		WebElement usernameBox = driver.findElement(By.name("txtUserId"));
		usernameBox.sendKeys(p.getProperty("username"));
		WebElement passwordBox = driver.findElement(By.name("txtUserPassword"));
		passwordBox.sendKeys(p.getProperty("password"));
	    WebElement loginButton = driver.findElement(By.id("submitbtn"));
		loginButton.click();
		Thread.sleep(10000);
		
		for (WebElement e :driver.findElements(By.tagName("frame")))
	    {
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(e);
	 
	        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
	 
			System.out.println("links"+links.size());
			 
			for (int i = 0; i<links.size(); i=i+1)
			{
			 
			if(links.get(i).getText().equals("TRADE"))
			{
			WebElement tradeLink = driver.findElement(By.linkText("TRADE"));
			tradeLink.click();
			break;
				}
				 
			}
	    }
		
	    Thread.sleep(5000);
	    
	    java.util.Set<java.lang.String> windowHandles2 = driver.getWindowHandles();
		System.out.println(windowHandles2);
		int count2 = windowHandles2.size();
		
		for (String window: windowHandles2) {
			 driver.switchTo().window(window);
		        System.out.println("current Title is: " + driver.getTitle()); 
		        
		        
		      if(driver.getTitle().length()==0){
		        String url = driver.getCurrentUrl();
		        System.out.println("current url is: " + url);  
		       
		        break;
		        }
		}
		
		for (WebElement e :driver.findElements(By.tagName("frame")))
	    {
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(e);
	        java.util.List<WebElement> links = driver.findElements(By.tagName("div"));

		
			for (int i = 0; i<links.size(); i=i+1)
			{
				
				if(links.get(i).getText().equals("Processing Queue"))
					{
				
				links.get(i).click();
				break;
			}
			
			}
	
	    }
		
		driver.switchTo().defaultContent();
		for (WebElement e :driver.findElements(By.tagName("frame")))
	    {
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(e);
	        java.util.List<WebElement> links = driver.findElements(By.tagName("span"));

			for (int i = 0; i<links.size(); i=i+1)
			{
				
				if(links.get(i).getText().equals("Authorization"))
					{
				
				links.get(i).click();
				break;
			}
			
			}
	
	    }
		
		driver.switchTo().defaultContent();
		for (WebElement e :driver.findElements(By.tagName("frame")))
	    {
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(e);
	        java.util.List<WebElement> links = driver.findElements(By.tagName("span"));

			for (int i = 0; i<links.size(); i=i+1)
			{
				
				if(links.get(i).getText().equals("Reimbursement"))
					{
				
				links.get(i).click();
				break;
			}
			
			}
	
	    }
		
		driver.switchTo().defaultContent();
		for (WebElement e :driver.findElements(By.tagName("frame")))
	    {
	        driver.switchTo().defaultContent();
	        driver.switchTo().frame(e);
	        java.util.List<WebElement> links = driver.findElements(By.tagName("span"));

			for (int i = 0; i<links.size(); i=i+1)
			{
				
				if(links.get(i).getText().equals("RA/RU"))
					{
				
				links.get(i).click();
				break;
			}
			
			}
	
	    }
		
	    
	    System.out.println("Raiffeisen Web portal authorization flow completed");
	
		
	}
}
