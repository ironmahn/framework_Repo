package com.comcast.crm.orgtest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseTest;

public class CreateOrganizationWithIndustriesTest extends BaseTest {

	@Test(enabled=false)
	public void CreateOrganizationWithIndustriesTestt() throws Throwable {

		// Read TestScript data from Excel File

		String orgName = eLib.GetDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.GetDataFromExcel("org", 4, 3);
		String type = eLib.GetDataFromExcel("org", 4, 4);


		driver.findElement(By.linkText("Organizations")).click();

		// Step 6: Click on Create Organization button

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Step 7: Enter details and create organization

		driver.findElement(By.name("accountname")).sendKeys(orgName);

		WebElement wbsel = driver.findElement(By.name("industry"));
		Select sel = new Select(wbsel);
		sel.selectByVisibleText(industry);

		WebElement wbsel2 = driver.findElement(By.name("accounttype"));
		Select sel2 = new Select(wbsel2);
		sel2.selectByVisibleText(type);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify industries and type info

		String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustries.equals(industry)) {
			System.out.println(industry + " information is Verified==PASS");
		} else {
			System.out.println(industry + " information is Not Verified==FAIL");
		}

		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.equals(type)) {
			System.out.println(type + " information is Verified==PASS");
		} else {
			System.out.println(type + " information is Not Verified==FAIL");
		}
	}
}