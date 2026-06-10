package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	WebDriver driver;

	// Constructor

	public OrganizationInfoPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// Header Message

	@FindBy(className = "dvHeaderText")				
	private WebElement headerMsg;

	// Getter

	public WebElement getHeaderMsg() {

		return headerMsg;
	}
}