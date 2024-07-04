package org.commonutils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitUtils {

	private static WebDriver driver;

	WebDriverWaitUtils(WebDriver driver) {
		WebDriverWaitUtils.driver = driver;
	}

	public static WebElement waitForVisible(WebElement element, int timeInSecounds) {

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecounds));

		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static WebElement waitForElementToBeClickable(WebElement element, int timeInSecounds) {

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecounds));

		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
