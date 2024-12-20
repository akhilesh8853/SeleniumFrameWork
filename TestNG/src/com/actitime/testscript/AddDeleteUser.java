package com.actitime.testscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddDeleteUser {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost/login.do"); Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager" + Keys.ENTER);
		
		driver.findElement(By.linkText("USERS")).click(); Thread.sleep(1000);
		driver.findElement(By.id("createUserDiv")).click();Thread.sleep(1000);
		
		WebElement popup = driver.findElement(By.id("userDataLightBox"));Thread.sleep(1000);
		if (popup.isDisplayed())
			System.out.println("Popup is displayed");
		else
			System.out.println("Popup is not displayed");
		
		driver.findElement(By.name("firstName")).sendKeys("Virat"); Thread.sleep(1000);
		driver.findElement(By.name("lastName")).sendKeys("Kohli"); Thread.sleep(1000);
		driver.findElement(By.name("email")).sendKeys("Kohli@gmail.com"); Thread.sleep(1000);
		driver.findElement(By.name("username")).sendKeys("virat@123"); Thread.sleep(1000);
		driver.findElement(By.name("password")).sendKeys("virat@123"); Thread.sleep(2000);
		driver.findElement(By.name("passwordCopy")).sendKeys("virat@123"); Thread.sleep(2000);
		driver.findElement(By.id("userDataLightBox_commitBtn")).click(); Thread.sleep(2000);
		
		
		WebElement searchField = driver.findElement(By.xpath("//input[contains(@class,'filterFieldInput')]"));
		searchField.sendKeys("Virat"); Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@class='userNameSpan']")).click(); Thread.sleep(2000);
		
		if (popup.isDisplayed())
			System.out.println("Popup is displayed");
		else
			System.out.println("Popup is not displayed");
		driver.findElement(By.id("userDataLightBox_deleteBtn")).click(); Thread.sleep(2000);
		driver.switchTo().alert().accept(); Thread.sleep(1000);
		driver.findElement(By.id("closeUserDataLightBoxBtn")).click(); Thread.sleep(2000);
		
		searchField.sendKeys("Virat"); Thread.sleep(2000);
		WebElement res = driver.findElement(By.id("noUsersToShowId")); Thread.sleep(2000);
		if (res.getText().equals("There are no users found")) 
			System.out.println("Passed");
		else
			System.out.println("Failed");
		
		driver.quit();
	}

}
