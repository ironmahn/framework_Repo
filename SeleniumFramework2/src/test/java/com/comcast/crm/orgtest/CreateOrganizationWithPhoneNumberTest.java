package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseTest;

public class CreateOrganizationWithPhoneNumberTest extends BaseTest {

	@Test(enabled=false)
	public void CreateOrganizationWithPhoneNumberTestt() throws Throwable {
		// Read TestScript data from Excel File
		String orgName = eLib.GetDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.GetDataFromExcel("org", 7, 3);

		// Step 5: Navigate to Organization module
		driver.findElement(By.linkText("Organizations")).click();

		// Step 6: Click on Create Organization button

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Step 7: Enter details and create organization

		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.id("phone")).sendKeys(phoneNumber);

		// verify industries and type info

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify Header Messsage Expected Result

		String actPhone = driver.findElement(By.id("dtlview_Phone")).getText();
		if (actPhone.equals(phoneNumber)) {
			System.out.println(phoneNumber + " Phone information is Verified==PASS");
		} else {
			System.out.println(phoneNumber + " Phone information is Not Verified==FAIL");
		}

		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " Organization Information is Visible==PASS");
		} else {
			System.out.println(orgName + " Organization Information is NOT Visible==FAIL");
		}

		// verify Header Orgname info Expected Result
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + " is created==PASS");
		} else {
			System.out.println(orgName + " is created==FAIL");
		}
	}
}
