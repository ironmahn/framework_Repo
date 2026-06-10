package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

    public ContactInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "dtlview_Last Name")
    private WebElement lastNameInfo;

    public String getLastName() {
        return lastNameInfo.getText();
    }
}