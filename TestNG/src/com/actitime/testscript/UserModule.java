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
	
	@Test(priority = 0)
	public void createUser() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.setUsers(); // clicking on the Users tab
		
		UserListPage u = new UserListPage(driver); 
		u.getAddUserBtn().click(); // clicking on add user button
		Thread.sleep(1000);
		
		Assert.assertTrue(u.getUserPopup().isDisplayed());  // checking if the popup is displayed or not

		u.getFirstNameTbx().sendKeys("Virat"); 		
		u.getLastNameTbx().sendKeys("Kohli"); 
		u.getEmailTbx().sendKeys("kohli@gmail.com");
		u.getUsernameTbx().sendKeys("ViratKohli");
		u.getPasswordTbx().sendKeys("virat@123"); 
		u.getPasswordCopyTbx().sendKeys("virat@123");
		u.getCreateUserBtn().click();   // user is created 

		u.getSearchTbx().sendKeys("Virat"); Thread.sleep(1000);// searching for the user
		WebElement res = u.getCreatedUser();Thread.sleep(1000);
		Assert.assertTrue(res.isDisplayed()); Thread.sleep(1000);// verifying if the user is created or not
	}


	@Test(priority=1)
	public void modifyUser() {
		Reporter.log("modifying User", true);
	}


	@Test(priority=2, enabled = true)
	public void deleteUser() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.setUsers(); // clicking on the Users tab
		
		UserListPage u = new UserListPage(driver); 
		u.getSearchTbx().sendKeys("Virat Kohli"); // searching for the user
		u.getCreatedUser().click();Thread.sleep(1000);
		
		u.getDeleteUserBtn().click();
		driver.switchTo().alert().accept(); Thread.sleep(1000);
		
		u.getSearchTbx().clear();
		u.getSearchTbx().sendKeys("Virat"); Thread.sleep(2000);
		WebElement res2 = u.getNoUserMsg();
		
		if (res2.getText().equals("There are no users found")) 
			System.out.println("Passed");
		else
			System.out.println("Failed");
	}
}
