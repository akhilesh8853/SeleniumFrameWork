package com.actitime.testscript;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;


@Listeners(com.actitime.generic.ListenersImplementation.class)
public class ProjectModule extends BaseClass{
	@Test(priority=0)
	public void createProject() throws InterruptedException {
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
		Reporter.log("Creating Project", true);
	}


	@Test(priority=1)
	public void modifyProject() {
		Reporter.log("modifying Project", true);
	}


	@Test(priority=2)
	public void deleteProject() throws InterruptedException {
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

		Reporter.log("deleting Project", true);
	}	
}
