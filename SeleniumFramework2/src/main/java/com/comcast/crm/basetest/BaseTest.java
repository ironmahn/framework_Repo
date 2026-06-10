package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.HomeTestPage;
import com.comcast.crm.objectrepositoryUtility.LoginTestPage;

public class BaseTest {
	// Create Object

	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();

	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "smokeTest", "RegressionTest" })
	public void configBS() throws Throwable {
		System.out.println("====connect to DB , Report config====");
		dbLib.getDBConnection();
	}

	@Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "RegressionTest" })
	public void configBC(@Optional("chrome") String browser) throws Throwable {
		System.out.println("===Launch the Browser===");
		String BROWSER = fLib.getDataFromPropertiesFile("browser"); 

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "smokeTest", "RegressionTest" })
	public void configBM() throws Throwable {
		System.out.println("===Login===");
		LoginTestPage lp = new LoginTestPage(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smokeTest", "RegressionTest" })
	public void configAM() {
		System.out.println("===Logout===");
		HomeTestPage hp = new HomeTestPage(driver);
		hp.logOut();

	}

	@AfterClass(groups = { "smokeTest", "RegressionTest" })
	public void configAc() {
		System.out.println("===close the Browser===");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "RegressionTest" })
	public void configAS() {
		System.out.println("====Close DB , Report backUp====");
		dbLib.closeDBConnection();

	}

}
