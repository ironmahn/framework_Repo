package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseTest;
import com.comcast.crm.objectrepositoryUtility.ContactPage;
import com.comcast.crm.objectrepositoryUtility.HomeTestPage;

public class CreateContactTest extends BaseTest {

	@Test(groups = "smokeTest")
	public void CreateContactTestt() throws Throwable {

		// Read TestScript data from Excel File

		String lastName = eLib.GetDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// Step 5: Navigate to Contact module
		HomeTestPage hp = new HomeTestPage(driver);
		hp.getContactLink().click();

		// Step 6: Click on Create Contact button

		ContactPage cp = new ContactPage(driver);
		cp.clickCreateContact();

		// Step 7: Enter details and create contact

		driver.findElement(By.name("lastname")).sendKeys(lastName);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String actHeader = cp.getHeaderMsg().getText();
		Assert.assertTrue(actHeader.contains(lastName), "Contact creation failed");

		String actLastName = cp.getGetLastName().getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, lastName, "Last name verification failed");
		soft.assertAll();

	}

	@Test(groups = "smokeTest")
	public void CreateContactWithSupportDateTest() throws Throwable {
		String lastName = eLib.GetDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// Step 5: Navigate to Contact module
		HomeTestPage hp = new HomeTestPage(driver);
		hp.getContactLink().click();

		// Step 6: Click on Create Contact button
		ContactPage cp = new ContactPage(driver);
		cp.clickCreateContact();

		// Step 7: Enter details and create contact

		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(30);

//    CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
//    ccp.createContactWithSupportDate(lastName, startDate, endDate);
		driver.findElement(By.name("lastname")).sendKeys(lastName);

		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);

		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify Header Messsage Expected Result

		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.equals(startDate)) {
			System.out.println(startDate + " START_DATE information is Verified==PASS");
		} else {
			System.out.println(startDate + " START_DATE information is Not Verified==FAIL");
		}

		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.equals(endDate)) {
			System.out.println(endDate + " END_DATE information is Verified==PASS");
		} else {
			System.out.println(endDate + " END_DATE information is Not Verified==FAIL");
		}

	}

	@Test(groups = "RegressionTest")
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
