package com.actitime.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static FileLib fl = new FileLib();  // to immport username and password
	
	/**
	 * To open  the browser before each class is executed
	 */
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
	/**
	 * To close the browser after execution of each testScript in a class
	 */
	@AfterTest
	public void closeBrowser() {
		driver.manage().window().minimize();
		driver.quit();
	}
	
	
	/**
	 * To login before executing each test script
	 * @throws IOException
	 */
	@BeforeMethod
	public void login() throws IOException {
		String url = fl.getPropertyData("url");
		String un = fl.getPropertyData("un");
		String pw = fl.getPropertyData("pw");
		
		driver.get(url);
		LoginPage l = new LoginPage(driver);
		l.login(un, pw);
	}
	
	
	/**
	 * To logout after each testscript is executed
	 */
	@AfterMethod
	public void logout() {
		HomePage h = new HomePage(driver);
		h.setLogout();
	}
}
