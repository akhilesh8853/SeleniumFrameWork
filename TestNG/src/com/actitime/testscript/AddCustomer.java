package com.actitime.testscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AddCustomer {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost/login.do"); Thread.sleep(1000);

		driver.findElement(By.id("username")).sendKeys("admin"); Thread.sleep(1000);
		driver.findElement(By.name("pwd")).sendKeys("manager" + Keys.ENTER); Thread.sleep(1000);
 
		driver.findElement(By.linkText("TASKS")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//div[text()='Add New']")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'createNewCustomer')]")).click(); Thread.sleep(1000);

		WebElement popup = driver.findElement(By.id("customerLightBox_content")); Thread.sleep(1000);
		if (popup.isDisplayed()) {
			System.out.println("Popup is displayed");
		}
		else {
			System.out.println("Popup is not displayed");
			Assert.fail();
		}

		driver.findElement(By.id("customerLightBox_nameField")).sendKeys("DemoCustomer"); Thread.sleep(1000);
		driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys("Demo description"); Thread.sleep(1000);
		driver.findElement(By.id("customerLightBox_commitBtn")).click(); Thread.sleep(1000);

		driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[1]")).sendKeys("DemoCustomer");
		Thread.sleep(1000);
		WebElement res = driver.findElement(By.xpath("//span[text()='DemoCustomer']"));
		Thread.sleep(1000);

		if (res.isDisplayed()) {
			System.out.println("Customer created");
		}
		else {
			System.out.println("Customer not created");
		}
		driver.quit();
	}
}
