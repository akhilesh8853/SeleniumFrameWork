package com.actitime.testscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateProject {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost/login.do"); Thread.sleep(1000);
		
		driver.findElement(By.id("username")).sendKeys("admin"); Thread.sleep(1000);
		driver.findElement(By.name("pwd")).sendKeys("manager" + Keys.ENTER); Thread.sleep(1000);
		
		driver.findElement(By.linkText("TASKS")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Add New']")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'createNewProject')]")).click(); Thread.sleep(1000);
		
		driver.findElement(By.id("projectPopup_projectNameField")).sendKeys("DemoProject"); Thread.sleep(1000);
		driver.findElement(By.id("projectPopup_customerSelectorPlaceholder")).click();  Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='x-menu-list']/li[2]")).click(); Thread.sleep(1000);
		driver.findElement(By.id("projectPopup_newCustomerNameField")).sendKeys("Virat"); Thread.sleep(1000);
		driver.findElement(By.id("projectPopup_commitBtn")).click(); Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[1]")).sendKeys("DemoProject"); 
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("(//div[@class='itemsContainer']/div[3]/div/span[1])[2]"));
		Thread.sleep(1000);
		
		if (ele.getText().contains("Demo"))
			System.out.println("PASSED");
		else
			System.out.println("FAILED");
		
		
		driver.quit();
	}

}
