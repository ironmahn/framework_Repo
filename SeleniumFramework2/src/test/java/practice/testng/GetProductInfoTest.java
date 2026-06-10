package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoTest {
	
	WebDriver driver;

	@Test(dataProvider = "GetData")
	public void SearchTest(String brandName, String productName) {

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.com/");

		// Search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);

		// Product xpath
		String x = "//span[contains(text(),'" + productName + "')]";
		String product = driver.findElement(By.xpath(x)).getText();

		System.out.println(product);

		driver.quit();
	}

	@DataProvider
	public Object[][] GetData() {

		Object[][] data = new Object[3][2];

		data[0][0] = "iphone";
		data[0][1] = "iPhone 12 Mini";

		data[1][0] = "iphone";
		data[1][1] = "iPhone 12 Pro";

		data[2][0] = "iphone";
		data[2][1] = "Apple iPhone 17 Pro Max";

		return data;
	}     
}