package com.junit.intellect.testcases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OctopusUnmailTest {
	
	@Test
	public void unmailLogin() {
		
		try {
			
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("incognito");
	        options.addArguments("test-type");
	        
			String exePath = "C:\\Users\\abhishek2.s\\Downloads\\browserdrivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			
			WebDriver driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver, 60);
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//Launch Unmail
			driver.get("https://octopuscws.intellectdesign.com/launcher.html");
			
			//Login Steps
			driver.findElement(By.id("j_username")).sendKeys("abhishek2.s");
			driver.findElement(By.id("j_password")).sendKeys("Abhishek@5189");
			driver.findElement(By.id("login")).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("A9")));
			
			//Click on My Conversations
			driver.findElement(By.id("A9")).click();
			
			//wait.until(ExpectedConditions.elementToBeClickable(By.id("lotusFormButtonId")));
			
			//Click on Start Conversation
			
			
			/*driver.switchTo().frame(driver.findElement(By.id("detailsFrame")));
			
			By byCss = By.cssSelector("#lotusFormButtonId']");
			
			WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(byCss));
			
			myDynamicElement.click();*/
			
			driver.switchTo().frame(driver.findElement(By.id("detailsFrame")));
			JavascriptExecutor js = (JavascriptExecutor) driver;  
			//js.executeScript("alert('Hello')");
			
			js.executeScript("javascript:openPrivateConversation(this, 'ConversationSave.jsp?applicationType=Conversation&appName=Private Conversations&appInstanceType=PrivateConversations&requestFrom=Private')");
			
			//driver.findElement(By.id("lotusFormButtonId")).isDisplayed();
			//driver.findElement(By.id("lotusFormButtonId")).isEnabled();
			//driver.findElement(By.xpath("//*[@id=\"conversationSearchDivId\"]/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]")).click();
			
			
			//driver.findElement(By.id("showReplyText_7d30f32c-af39-4afc-93eb-f39f52b1d78e")).click();
			
			/*driver.switchTo().defaultContent();
			
			System.out.println(By.id("conversationSearchDivId"));
			
			driver.findElement(By.id("conversationSearchDivId")).click();*/
			
			//*[@id="conversationSearchDivId"]/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]
			
			//*[@id="conversationSearchDivId"]/table/tbody/tr[1]/td/table/tbody/tr[1]/td[1]
			
			//Enter the mail title
			//driver.findElement(By.id("title")).sendKeys("Automated Message From Selenium");
			
			//Enter the reciptents mailId
			//driver.findElement(By.id("associateNtId")).sendKeys("rajesh pahilajrai motwani");
			
			//Click on id
			//driver.findElement(By.xpath("//*[@id=\"userlisting\"]/li/span/span[2]/span[1]/a")).click();
			
			//Enter mail body
			//driver.findElement(By.id("cke_contents_postReplyTextArea_7d30f32c-af39-4afc-93eb-f39f52b1d78e")).sendKeys("Hi I am sending the automated mail to you");
			
			//Send the mail
			//driver.findElement(By.id("postReplyLink_7d30f32c-af39-4afc-93eb-f39f52b1d78e")).click();
			
			Thread.sleep(5000);
			Assert.assertTrue(driver.getTitle().contains("My Workspace"));
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
