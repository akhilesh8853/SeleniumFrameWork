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
	private WebElement createdCust22;
	
	@FindBy(xpath = "//span[@class='highlightToken']/../..//div[@class='editButton available']")
	private WebElement customerEditBtn;
	
	@FindBy(xpath = "//div[@id='cpTreeBlock']//input[@placeholder='Start typing name ...']")
	private WebElement searchTbx;
	
	@FindBy(className = "highlightToken")
	private WebElement createdUser;
	
	@FindBy(xpath = "//div[contains(@class, 'edit_customer')]//div[@class='actions']")
	private WebElement actionBtn;
	
	@FindBy(xpath = "//div[contains(@class, 'edit_customer')]//div[text()='Delete']")
	private WebElement deleteBtn;
	
	@FindBy(id = "customerPanel_deleteConfirm_submitBtn")
	private WebElement deleteConfirmationBtn;
	
	@FindBy(xpath = "//div[text()='There are no customers or projects']")
	private WebElement noResultMsg;
	

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

	public WebElement getEditCustomerBtn() {
		return customerEditBtn;
	}
	
	public WebElement getSearchTbx() {
		return searchTbx;
	}
	
	public WebElement getCreatedUser() {
		return createdUser;
	}
	
	public WebElement getActionBtn() {
		return actionBtn;
	}
	
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	public WebElement getDeleteConfirmationBtn() {
		return deleteConfirmationBtn;
	}
	
	public WebElement getNoResultMsg() {
		return noResultMsg;
	}
	
}
