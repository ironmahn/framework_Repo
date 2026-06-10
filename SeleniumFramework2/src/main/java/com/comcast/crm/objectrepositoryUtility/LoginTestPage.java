package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Sadiq
 *
 * contains LoginPage webelement and business lib like login()
 */
public class LoginTestPage extends WebDriverUtility {

	WebDriver driver;

	// Constructor
	public LoginTestPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// Identify WebElements

	@FindBy(name = "user_name")
	private WebElement userTextField;

	@FindBy(name = "user_password")
	private WebElement passwordTextField;

	@FindBy(id = "submitButton")
	private WebElement submitButton;

	// Getter Methods

	public WebElement getUserTextField() {
		return userTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	// Business Library Methods

	// Login only
	public void loginToApp(String username, String password) {

		userTextField.sendKeys(username);

		passwordTextField.sendKeys(password);

		submitButton.click();
	}

	// Open URL + Login
	public void loginToApp(String url, String username, String password) {

		driver.get(url);

		driver.manage().window().maximize();

		waitForPageToLoad(driver);

		userTextField.sendKeys(username);

		passwordTextField.sendKeys(password);

		submitButton.click();
	}
}