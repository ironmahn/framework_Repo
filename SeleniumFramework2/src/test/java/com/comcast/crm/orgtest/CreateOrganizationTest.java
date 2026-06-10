package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseTest;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryUtility.CreateNewOrganizationTestPage;
import com.comcast.crm.objectrepositoryUtility.HomeTestPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;
@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class CreateOrganizationTest extends BaseTest {

	@Test(groups = "smokeTest")
	public void createOrganizationTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "Read Data from excel");
		// Read Data From Excel
		String orgName = eLib.GetDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		// Navigate To Organization Module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Org Page");

		HomeTestPage hp = new HomeTestPage(driver);

		hp.getOrgLink().click();

		// Click Create Organization Button
		UtilityClassObject.getTest().log(Status.INFO, "Navigate To Create Org Page");

		OrganizationsPage op = new OrganizationsPage(driver);

		op.clickOnCreateOrgBtn();

		// Create New Organization
		UtilityClassObject.getTest().log(Status.INFO, "Create NEW Org Page");

		CreateNewOrganizationTestPage cnop = new CreateNewOrganizationTestPage(driver);

		cnop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName + " Created NEW Org Page");

		// Verify Header Message

		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		String actOrgName = oip.getHeaderMsg().getText();

		if (actOrgName.contains(orgName)) {

			System.out.println(orgName + " is verified == PASS");

		} else {

			System.out.println(orgName + " is not verified == FAIL");
		}

	}

	@Test(groups = "RegressionTest")
	public void CreateOrganizationWithIndustriesTestt() throws Throwable {
		// Read TestScript data from Excel File
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from excel");
		String orgName = eLib.GetDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.GetDataFromExcel("org", 4, 3);
		String type = eLib.GetDataFromExcel("org", 4, 4);

		driver.findElement(By.linkText("Organizations")).click();

		// Step 6: Click on Create Organization button
		UtilityClassObject.getTest().log(Status.INFO, "Clickin on Create Org button");

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Step 7: Enter details and create organization

		driver.findElement(By.name("accountname")).sendKeys(orgName);

		WebElement wbsel = driver.findElement(By.name("indstry"));
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

	@Test(groups = "RegressionTest")
	public void CreateOrganizationWithPhoneNumberTestt() throws Throwable {
		// Read TestScript data from Excel File
		UtilityClassObject.getTest().log(Status.INFO, "Read Data from excel");
		String orgName = eLib.GetDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.GetDataFromExcel("org", 7, 3);

		// Step 5: Navigate to Organization module
		driver.findElement(By.linkText("Organizations")).click();

		// Step 6: Click on Create Organization button
		UtilityClassObject.getTest().log(Status.INFO, "Clickin on Create Org button");

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