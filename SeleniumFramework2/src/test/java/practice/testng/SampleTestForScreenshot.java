package practice.testng;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.Test;

//import com.comcast.crm.generic.fileutility.FileUtility;

public class SampleTestForScreenshot {
	
	@Test
	public void amazonTest()
	{
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
		
		
		//Step 1: create an object to EventFiring WebDriver
//		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		
		//step 2: use getScreenshotAs method to get file type of 
//		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
		//step 3 : store screen on local driver
//		FileUtility.copyFile(srcFile, new File("./screenshot/test.png"));
		
	}

}
