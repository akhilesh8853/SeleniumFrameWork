package com.actitime.testscript;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.pom.HomePage;
import com.actitime.pom.UserListPage;


@Listeners(com.actitime.generic.ListenersImplementation.class)
public class UserModule extends BaseClass{
	
	UserListPage u = new UserListPage(driver); // creating object of the Users page
	HomePage h = new HomePage(driver);// creating object of the Homepage
	
	
	@Test(priority = 0)
	public void createUser() throws InterruptedException {
		h.setUsers(); // clicking on the Users tab
		Thread.sleep(1000);
		u.getAddUserBtn().click(); // clicking on add user button
		Thread.sleep(1000);

		WebElement popup = u.getUserPopup(); // checking if the user popup is displayed
		Thread.sleep(1000);

		Assert.assertTrue(popup.isDisplayed());  // checking if the popup is displayed or not

		u.getFirstNameTbx().sendKeys("Virat"); 		Thread.sleep(1000);
		u.getLastNameTbx().sendKeys("Kohli"); Thread.sleep(1000);
		u.getEmailTbx().sendKeys("kohli@gmail.com"); Thread.sleep(1000);
		u.getCreatedUser().sendKeys("VIRAT@123"); Thread.sleep(1000);
		u.getPasswordTbx().sendKeys("virat@123"); Thread.sleep(1000);
		u.getPasswordCopyTbx().sendKeys("virat@123"); Thread.sleep(1000);
		u.getAddUserBtn().click();	Thread.sleep(1000);	// user is created 

		u.getSearchTbx().sendKeys("Virat"); Thread.sleep(1000);// searching for the user
		WebElement res = u.getCreatedUser();Thread.sleep(1000);
		Assert.assertTrue(res.isDisplayed()); Thread.sleep(1000);// verifying if the user is created or not
	}


	@Test(priority=1)
	public void modifyUser() {
		Reporter.log("modifying User", true);
	}


	@Test(priority=2)
	public void deleteUser() throws InterruptedException {
		
		h.setUsers(); // clicking on the Users tab
		u.getSearchTbx().sendKeys("Virat"); // searching for the user
		WebElement res = u.getNoUserMsg();
		if (res.isDisplayed())  //checking if the user is pressent in the lsit or not
			Reporter.log("User is present");
		else 
			Reporter.log("User is not present");
		
		res.click();
		
		if (u.getUserPopup().isDisplayed()) // verifyig if the popup is displayed or not
			System.out.println("Popup is displayed");
		else
			System.out.println("Popup is not displayed");
		
		u.getDeleteUserBtn().click();
		driver.switchTo().alert().accept(); Thread.sleep(1000);

		u.getSearchTbx().sendKeys("Virat"); Thread.sleep(2000);
		WebElement res2 = u.getNoUserMsg();
		
		if (res2.getText().equals("There are no users found")) 
			System.out.println("Passed");
		else
			System.out.println("Failed");
	}
}
