package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    public ContactPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(className="dvHeaderText")
    private WebElement headerMsg;

    public WebElement getHeaderMsg() {
		return headerMsg;
	}
    
    @FindBy(id="dtlview_Last Name")
    private WebElement getLastName;
    
	public WebElement getGetLastName() {
		return getLastName;
	}

	@FindBy(xpath = "//img[@title='Create Contact...']")
    private WebElement createContactBtn;

    public void clickCreateContact() {
        createContactBtn.click();
    }
}