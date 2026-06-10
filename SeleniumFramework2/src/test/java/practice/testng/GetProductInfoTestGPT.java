package practice.testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoTestGPT {

    @Test(dataProvider = "GetData")
    public void searchTest(String brandName, String productName) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            driver.get("https://www.amazon.com/");

            // Search product
            driver.findElement(By.id("twotabsearchtextbox"))
                    .sendKeys(brandName, Keys.ENTER);

            Thread.sleep(3000);

            List<WebElement> products = driver.findElements(
                    By.xpath("//div[@data-component-type='s-search-result']"));

            boolean found = false;

            for (WebElement product : products) {

                try {
                    String title = product.findElement(
                            By.xpath(".//h2//span")).getText();

                    if (title.contains(productName)) {

                        String price = product.findElement(
                                By.xpath(".//span[@class='a-price-whole']"))
                                .getText();

                        System.out.println("Product : " + title);
                        System.out.println("Price   : " + price);

                        found = true;
                        break;
                    }

                } catch (Exception e) {
                    // Ignore products without price
                }
            }

            if (!found) {
                System.out.println(productName + " --> Product Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @DataProvider(name = "GetData")
    public Object[][] getData() {

        return new Object[][] {
                {"iphone", "iPhone 15"},
                {"iphone", "iPhone 16 Pro"},
                {"iphone", "iPhone 17 Pro Max"}
        };
    }
}