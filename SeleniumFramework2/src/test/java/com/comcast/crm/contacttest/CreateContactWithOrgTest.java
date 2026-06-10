package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseTest;


public class CreateContactWithOrgTest extends BaseTest {

	@Test(enabled=false)
	public void CreateContactWithOrgTestt() throws Throwable {
		
		// Read TestScript data from Excel File
		String orgName = eLib.GetDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String ContactLastName = eLib.GetDataFromExcel("contact", 7, 3);

		
		// Step 5: Navigate to Organization module

		driver.findElement(By.linkText("Organizations")).click();

		// Step 6: Click on Create Organization button

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Step 7: Enter details and create organization

		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify Header Messsage Expected Result

		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " Organization Information is Visible==PASS");
		} else {
			System.out.println(orgName + " Organization Information is NOT Visible==FAIL");
		}

		// Navigate to Contacts module
		driver.findElement(By.linkText("Contacts")).click();

		// Click on Create Contact button

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Enter details and create contact

		driver.findElement(By.name("lastname")).sendKeys(ContactLastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// switch to child window
		wLib.switchToTabOnURL(driver, "module=Accounts");

		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		wLib.switchToTabOnURL(driver, "Contacts&action");

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify Header Messsage Expected Result

		headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(ContactLastName)) {
			System.out.println(ContactLastName + " Organization Information is Visible==PASS");
		} else {
			System.out.println(ContactLastName + " Organization Information is NOT Visible==FAIL");
		}

		// Verify Header Orgname info Expected Result

		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + " is created==PASS");
		} else {
			System.out.println(orgName + " is created==FAIL");
		}

	}
}
