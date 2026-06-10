package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility {

	WebDriver driver;

	// Constructor
	public OrganizationsPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// WebElements

	@FindBy(name = "search_text")
	private WebElement searchEdit;

	@FindBy(name = "search_field")
	private WebElement searchDD;

	@FindBy(xpath = "//input[@value=' Search Now ']")
	private WebElement searchNowBtn;

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createNewOrgButton;

	@FindBy(className = "hdrLink")
	private WebElement headerMsg;

	// Getter Methods

	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getCreateNewOrgButton() {
		return createNewOrgButton;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	// Business Library

	// Click on Create Organization Button
	public void clickOnCreateOrgBtn() {

		createNewOrgButton.click();
	}
}