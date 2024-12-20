package com.actitime.testscript;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.generic.BaseClass;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;


@Listeners(com.actitime.generic.ListenersImplementation.class)
public class CustomerModule extends BaseClass{
	
	
	@Test(priority=0, invocationCount = 1)
	public void AddCustomer() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.setTasks();
		TaskListPage t = new TaskListPage(driver);
		t.getAddNewbtn().click();
		t.getNewCustBtn().click();

		boolean popup = t.getNewCustPopup().isDisplayed();
		Assert.assertTrue(popup); // To check if the popup is displayed or not
		
		t.getCustTbx().sendKeys("DemoCustomer"); 
		t.getCustDesc().sendKeys("Demo description");
		t.getCustDropdown().click();
		t.getOurCompOpt().click();
		t.getCreateCustBtn().click();  // customer is created.
		
		t.getSearchTbx().sendKeys("DemoCustomer"); Thread.sleep(1000);
		WebElement createdUser = t.getCreatedUser(); Thread.sleep(1000);

		if (createdUser.isDisplayed() && createdUser.getText().equals("DemoCustomer")) {
			Reporter.log("Customer created, test passed", true); }
		else {
			Reporter.log("Customer not created, test Failed", true);
			Assert.fail(); }
	}
	
	
	@Test(priority=1, dependsOnMethods = {"AddCustomer"})
	public void deleteCustomer() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.setTasks();  // switching to task list page
		
		TaskListPage t = new TaskListPage(driver);
		t.getSearchTbx().clear();
		t.getSearchTbx().sendKeys("DemoCustomer");
		t.getEditCustomerBtn().click(); Thread.sleep(1000);
		t.getActionBtn().click(); Thread.sleep(1000);
		t.getDeleteBtn().click(); Thread.sleep(1000);
		t.getDeleteConfirmationBtn().click(); Thread.sleep(1000); // customer is deleted		
		
		t.getSearchTbx().clear();
		t.getSearchTbx().sendKeys("DemoCustomer"); // searching for the deleted customer
		Thread.sleep(1000);
		WebElement res = t.getNoResultMsg();
		Assert.assertTrue(res.isDisplayed());
		Reporter.log("Customer deleted successfully, test passed", true);
	}	
}
