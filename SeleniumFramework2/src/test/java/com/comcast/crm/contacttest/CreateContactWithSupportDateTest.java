package com.comcast.crm.contacttest;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseTest;

public class CreateContactWithSupportDateTest extends BaseTest {

	@Test(enabled=false)
	public void createContactWithSupportDateTest() throws Throwable{
		// TODO Auto-generated method stub
		
		// Create Object
//		FileUtility fLib = new FileUtility();
//		ExcelUtility eLib = new ExcelUtility();
//	    JavaUtility jLib = new JavaUtility();

					
		 // Step 1: Read common data from properties file
//			String BROWSER = fLib.getDataFromPropertiesFile("browser");
//			String URL = fLib.getDataFromPropertiesFile("url");
//			String USERNAME = fLib.getDataFromPropertiesFile("username");
//			String PASSWORD = fLib.getDataFromPropertiesFile("password");   
//			        
//			Random random = new Random();
//			int randomInt = random.nextInt(1000);
			        
			//Read TestScript data from Excel File
			String lastName = eLib.GetDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
//			String lastName = eLib.GetDataFromExcel("contact", 1, 2) + randomInt;        
			// Step 3: Launch Browser
        

//        WebDriver driver = null;
//
//        if (BROWSER.equals("chrome")) {
//            driver = new ChromeDriver();
//
//        } else if (BROWSER.equals("firefox")) {
//            driver = new FirefoxDriver();
//
//        } else if (BROWSER.equals("edge")) {
//            driver = new EdgeDriver();
//        }

        
        // Step 4: Login to application
        
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        driver.manage().window().maximize();
//
//        driver.get(URL);
//
//        driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//        driver.findElement(By.id("submitButton")).click();

        
        // Step 5: Navigate to Contact module        
        driver.findElement(By.linkText("Contacts")).click();

        // Step 6: Click on Create Contact button
        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

        String startDate = jLib.getSystemDateYYYYDDMM();
        String endDate = jLib.getRequiredDateYYYYDDMM(30);		


        // Step 7: Enter details and create contact

        driver.findElement(By.name("lastname")).sendKeys(lastName);  
        
        driver.findElement(By.name("support_start_date")).clear();
        driver.findElement(By.name("support_start_date")).sendKeys(startDate);        
        
        driver.findElement(By.name("support_end_date")).clear();
        driver.findElement(By.name("support_end_date")).sendKeys(endDate);
        
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
        
        //verify Header Messsage Expected Result
        
        String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
        if(actStartDate.equals(startDate)) {
        	System.out.println(startDate + " START_DATE information is Verified==PASS");
        }else { 	
        	System.out.println(startDate + " START_DATE information is Not Verified==FAIL");
        }
          
        String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
        if(actEndDate.equals(endDate)) {
        	System.out.println(endDate + " END_DATE information is Verified==PASS");
        }else { 	
        	System.out.println(endDate + " END_DATE information is Not Verified==FAIL");
        }
        
        
        // Step 8: Logout
        

//        Actions act = new Actions(driver);
//
//        WebElement adminImg = driver.findElement(
//                By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//
//        act.moveToElement(adminImg).perform();
//
//        driver.findElement(By.linkText("Sign Out")).click();

        // Step 9: Close browser

 //       driver.quit();
    }
}




