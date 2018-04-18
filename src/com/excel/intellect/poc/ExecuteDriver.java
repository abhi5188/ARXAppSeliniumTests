package com.excel.intellect.poc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ExecuteDriver {

	
	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("");
		
		String exePath = "C:\\Users\\abhishek2.s\\Downloads\\browserdrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
     
 
        WebDriver driver = new ChromeDriver();
		
		
		
		
		driver.get("https://cloud.myadrenalin.com/adrenalin/");
	}
}
