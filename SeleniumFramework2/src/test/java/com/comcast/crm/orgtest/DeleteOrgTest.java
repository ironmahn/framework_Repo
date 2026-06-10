package com.comcast.crm.orgtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.CreateNewOrganizationTestPage;
import com.comcast.crm.objectrepositoryUtility.HomeTestPage;
import com.comcast.crm.objectrepositoryUtility.LoginTestPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryUtility.OrganizationsPage;

public class DeleteOrgTest {

	public static void main(String[] args) throws Throwable {

		// Create Object

		FileUtility fLib = new FileUtility();

		ExcelUtility eLib = new ExcelUtility();

		JavaUtility jLib = new JavaUtility();
		
		WebDriverUtility wLib = new WebDriverUtility();


		// Read Common Data From Properties File

		String BROWSER =
				fLib.getDataFromPropertiesFile("browser");

		String URL =
				fLib.getDataFromPropertiesFile("url");

		String USERNAME =
				fLib.getDataFromPropertiesFile("username");

		String PASSWORD =
				fLib.getDataFromPropertiesFile("password");

		// Read Data From Excel

		String orgName =
				eLib.GetDataFromExcel("org", 10, 2)
				+ jLib.getRandomNumber();

		WebDriver driver = null;

		// Launch Browser

		if (BROWSER.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (BROWSER.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (BROWSER.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();

		} else {

			driver = new ChromeDriver();
		}

		// Browser Settings

		driver.manage().window().maximize();

		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(20));

		driver.get(URL);

		// Login To Application

		LoginTestPage lp =
				new LoginTestPage(driver);

		lp.loginToApp(USERNAME, PASSWORD);

		// Navigate To Organization Module

		HomeTestPage hp =
				new HomeTestPage(driver);

		hp.getOrgLink().click();

		// Click Create Organization Button

		OrganizationsPage op =
				new OrganizationsPage(driver);

		op.clickOnCreateOrgBtn();

		// Create New Organization

		CreateNewOrganizationTestPage cnop =
				new CreateNewOrganizationTestPage(driver);

		cnop.createOrg(orgName);

		// Verify Header Message

		OrganizationInfoPage oip =
				new OrganizationInfoPage(driver);

		String actOrgName =
				oip.getHeaderMsg().getText();

		if (actOrgName.contains(orgName)) {

			System.out.println(orgName
					+ " is verified == PASS");

		} else {

			System.out.println(orgName
					+ " is not verified == FAIL");
		}
		
		//Go back to organization Page
		hp.getOrgLink().click();
		
		//Search for organization
		op.getSearchEdit().sendKeys(orgName);
		wLib.select(op.getSearchDD(), "Organization Name");
		op.getSearchNowBtn().click();
		
		//Dynamic Xpath - this xpath getting constructed in runtime
		driver.findElement(
				By.xpath("//a[text()='"+orgName+"']/ancestor::tr//a[text()='del']")).click();
		
/*		Note: using POM technique we cannot store dynamic elements,
		if we want to handle dynamic elements, this is the only 1 way available.
		i.e we've to go for driver.findelement to identify dynamic element */
		
		//In Dynamic Webtable select and delete org

		// Logout

		hp.logOut();

		// Close Browser

		driver.quit();
	}
}