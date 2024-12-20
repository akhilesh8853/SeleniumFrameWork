package com.actitime.testscript;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DeleteProject {
 public static void main(String[] args) throws InterruptedException {
	 WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost/login.do"); Thread.sleep(1000);
		
		driver.findElement(By.id("username")).sendKeys("admin"); Thread.sleep(1000);
		driver.findElement(By.name("pwd")).sendKeys("manager" + Keys.ENTER); Thread.sleep(1000);
		
		driver.findElement(By.linkText("TASKS")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[1]")).sendKeys("DemoProject"); Thread.sleep(1000);
		WebElement ele = driver.findElement(By.className("highlightToken")); Thread.sleep(1000);
		
		
		if (ele.getText().equals("DemoProject")) 
			System.out.println("Project is present");
		else {
			System.out.println("Project is not present");
			Assert.fail();	
		}
		
		driver.findElement(By.xpath("(//div[contains(@class,'itemsContainer')]/div[3]/div[3])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"taskListBlock\"]/div[4]/div[1]/div[2]/div[3]/div/div")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='Delete'])[3]")).click(); Thread.sleep(1000);
		driver.findElement(By.id("projectPanel_deleteConfirm_submitTitle")).click(); Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[1]")).sendKeys("DemoProject"); 
		Thread.sleep(1000);
		WebElement message = driver.findElement(By.xpath("//div[text()='There are no customers or projects']"));
		Thread.sleep(1000);
		
		if (message.isDisplayed())
			System.out.println("Project has been deleted");
		else
			System.out.println("Project still exists");
		
		driver.quit();
}
}
