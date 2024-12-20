package com.actitime.testscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteCustomer {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost/login.do"); Thread.sleep(1000);

		driver.findElement(By.id("username")).sendKeys("admin"); Thread.sleep(1000);
		driver.findElement(By.name("pwd")).sendKeys("manager" + Keys.ENTER); Thread.sleep(1000);

		driver.findElement(By.linkText("TASKS")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[1]")).sendKeys("DemoCustomer");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='highlightToken']/../..//div[@class='editButton available']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//div[@class='actionButton'])[1]")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()='Delete'])[1]")).click(); Thread.sleep(1000);
		driver.findElement(By.id("customerPanel_deleteConfirm_submitBtn")).click(); Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[1]")).sendKeys("DemoCustomer");
		Thread.sleep(1000);
		WebElement res = driver.findElement(By.xpath("//div[text()='There are no customers or projects']"));
		Thread.sleep(1000);
		
		if (res.isDisplayed()) {
			System.out.println("Customer deleted");
		}
		else {
			System.out.println("Customer not deleted");
		}
		
		driver.quit();
	}
}
