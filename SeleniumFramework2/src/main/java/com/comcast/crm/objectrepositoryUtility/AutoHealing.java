package com.comcast.crm.objectrepositoryUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AutoHealing {

	WebDriver driver;

	// Default Constructor
	public AutoHealing() {

	}

	// Parameterized Constructor
	public AutoHealing(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// WebElements

	@FindBy(name = "user_name")
	private WebElement userTextField;

	@FindBy(name = "user_password")
	private WebElement passwordTextField;

	@FindAll({ @FindBy(id = "sub"), @FindBy(xpath = "//input[@value='Login']") })
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

	@Test
	public void sampleTest() {

		WebDriver driver = new EdgeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.manage().window().maximize();

		driver.get("http://localhost:8888/");

		// Create object again using parameterized constructor
		AutoHealing s = new AutoHealing(driver);

		s.getUserTextField().sendKeys("admin");

		s.getPasswordTextField().sendKeys("admin");

		s.getSubmitButton().click();
	}
}