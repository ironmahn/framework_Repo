package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganizationTestPage extends WebDriverUtility {

	// Constructor
	public CreateNewOrganizationTestPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// Identify WebElements

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name = "industry")
	private WebElement industryDB;

	// Getter Methods

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDB() {
		return industryDB;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	// Business Library

	// Create Organization only
	public void createOrg(String orgName) {

		orgNameEdt.sendKeys(orgName);

		saveBtn.click();
	}

	// Create Organization with Industry
	public void createOrg(String orgName, String industry) {

		orgNameEdt.sendKeys(orgName);

		select(industryDB, industry);

		saveBtn.click();
	}
}