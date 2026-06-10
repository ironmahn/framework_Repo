package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	// Implicit Wait
	public void waitForPageToLoad(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	// Explicit Wait
	public void waitForElementPresent(WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Switch to window based on URL
	public void switchToTabOnURL(WebDriver driver, String partialURL) {

		for (String windowID : driver.getWindowHandles()) {

			driver.switchTo().window(windowID);

			if (driver.getCurrentUrl().contains(partialURL)) {
				break;
			}
		}
	}

	// Switch to window based on Title
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {

		for (String windowID : driver.getWindowHandles()) {

			driver.switchTo().window(windowID);

			if (driver.getTitle().contains(partialTitle)) {
				break;
			}
		}
	}

	// Switch to frame by index
	public void switchToFrame(WebDriver driver, int index) {

		driver.switchTo().frame(index);
	}

	// Switch to frame by name or id
	public void switchToFrame(WebDriver driver, String nameID) {

		driver.switchTo().frame(nameID);
	}

	// Switch to frame by element
	public void switchToFrame(WebDriver driver, WebElement element) {

		driver.switchTo().frame(element);
	}

	// Accept Alert Popup
	public void switchToAlertAndAccept(WebDriver driver) {

		driver.switchTo().alert().accept();
	}

	// Dismiss Alert Popup
	public void switchToAlertAndCancel(WebDriver driver) {

		driver.switchTo().alert().dismiss();
	}

	// Select dropdown by visible text
	public void select(WebElement element, String text) {

		Select sel = new Select(element);

		sel.selectByVisibleText(text);
	}

	// Select dropdown by index
	public void select(WebElement element, int index) {

		Select sel = new Select(element);

		sel.selectByIndex(index);
	}

	// Mouse Hover Action
	public void mouseHoverOnElement(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);

		act.moveToElement(element).perform();
	}

	// Double Click Action
	public void doubleClick(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);

		act.doubleClick(element).perform();
	}

	// Generic Click Method
	public void clickOnElement(WebElement element) {

		element.click();
	}
}