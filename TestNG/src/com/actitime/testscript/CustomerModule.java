package com.actitime.testscript;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.generic.BaseClass;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;


@Listeners(com.actitime.generic.ListenersImplementation.class)
public class CustomerModule extends BaseClass{
	
	@Test(priority=0, invocationCount = 1, groups = {"SmokeTest", "RegressionTest"})
	public void AddCustomer() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.setTasks();
		TaskListPage t = new TaskListPage(driver);
		t.getAddNewbtn().click();
		t.getNewCustBtn().click();

		WebElement popup = t.getNewCustPopup();
		if (popup.isDisplayed()) {
			System.out.println("Popup is displayed");
		}
		else {
			System.out.println("Popup is not displayed");
			Assert.fail();
		}
		t.getCustTbx().sendKeys("Demo Customer");
		t.getCustDesc().sendKeys("Demo description");
		t.getCustDropdown().click();
		t.getOurCompOpt().click();
		t.getCreateCustBtn().click();
		
		// FInish the ones below
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
	}
	
	
	@Test(priority=1, dependsOnMethods = {"AddCustomer"})
	public void deleteCustomer() throws InterruptedException {
		
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
	}	
}
