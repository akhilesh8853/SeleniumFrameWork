package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNewbtn;

	@FindBy(xpath = "//div[text()='+ New Customer']")
	private WebElement newCustBtn;

	@FindBy(id = "customerLightBox_content")
	private WebElement newCustPopup;

	@FindBy(id = "customerLightBox_nameField")
	private WebElement custTbx;

	@FindBy(id = "customerLightBox_descriptionField")
	private WebElement custDesc;

	@FindBy(id = "customerLightBox_customerSelectorPlaceholder")
	private WebElement custDropdown;

	@FindBy(linkText  = "Our Company")
	private WebElement ourCompOpt;

	@FindBy(id = "customerLightBox_commitBtn")
	private WebElement createCustBtn;

	@FindBys({@FindBy(xpath = "//a[text()='All Customers']/../../div[@class='title ellipsis']"),
		@FindBy(xpath = "//a[text()='All Customers']/following::div[@class='title ellipsis'][1]")})
	private WebElement createdCust;

	public TaskListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddNewbtn() {
		return addNewbtn;
	}

	public WebElement getNewCustBtn() {
		return newCustBtn;
	}

	public WebElement getCustTbx() {
		return custTbx;
	}
	
	public WebElement getNewCustPopup() {
		return newCustPopup;
	}

	public WebElement getCustDesc() {
		return custDesc;
	}

	public WebElement getCustDropdown() {
		return custDropdown;
	}

	public WebElement getOurCompOpt() {
		return ourCompOpt;
	}

	public WebElement getCreateCustBtn() {
		return createCustBtn;
	}

	public WebElement getCreatedCust() {
		return createdCust;
	}
}
