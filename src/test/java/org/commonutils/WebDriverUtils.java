package org.commonutils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import static org.commonutils.HelperUtils.*;


import com.google.common.io.Files;

public class WebDriverUtils {

	public static WebDriver driver;
	
	public WebDriverUtils(WebDriver driver) {
		WebDriverUtils.driver = driver;
	}

	public static void selectOption(WebElement dropDownElement, String optionToSelect) {

		Select countryElement = new Select(dropDownElement);
		List<WebElement> listOfOptions = countryElement.getOptions();
		int listSize = listOfOptions.size();
		Reporter.log("Total countries available in dropdown " + listSize, true);
		if (listSize > 0) {
			boolean isOptionAvailable = false;
			for (WebElement optionElement : listOfOptions) {
				String option = optionElement.getText();
				Reporter.log(option);

				if (option.equals(optionToSelect)) {
					countryElement.selectByVisibleText(optionToSelect);
					Reporter.log("Expected option " + optionToSelect + " available in dropdown and selected", true);
					isOptionAvailable = true;
					break;
				}
			}
			if (!isOptionAvailable) {
				Reporter.log("Expected option " + optionToSelect + " is not available in dropdown", true);
			}

		} else {
			Reporter.log("There were no options available in dropdown", true);
		}

	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public void acceptAlert() {
		if (isAlertPresent()) {
			Reporter.log("Alert were present and script executing ...");
			Alert alert = driver.switchTo().alert();
			String alertMessage = alert.getText();
			Reporter.log(alertMessage, true);
			alert.accept();
			Reporter.log("Alert was accepted successfully");
		} else {
			Reporter.log("Alert not present");
		}
	}

	public void dismissAlert() {
		if (isAlertPresent()) {
			Reporter.log("Alert were present and script executing ...");
			Alert alert = driver.switchTo().alert();
			String alertMessage = alert.getText();
			Reporter.log(alertMessage, true);
			alert.dismiss();
			Reporter.log("Alert was accepted successfully");
		} else {
			Reporter.log("Alert not present");
		}
	}

	public boolean isTextPresent(String textToVerify) {

		String bodyText = driver.findElement(By.tagName("body")).getText();

		if (bodyText.contains(textToVerify)) {
			return true;
		} else {
			return false;
		}
	}

	public void switchToWindow(String expWndTitle) {

		Set<String> wndHandles = driver.getWindowHandles();
		int wndCount = wndHandles.size();
		Reporter.log("Windows Count " + wndCount);

		if (wndCount > 0) {
			boolean isWindowSelected = false;
			for (String wndHandle : wndHandles) {
				Reporter.log("WIndow Handle " + wndHandle);
				String actualWndTitle = driver.switchTo().window(wndHandle).getTitle();
				Reporter.log("WIndow Title " + actualWndTitle);
				if (actualWndTitle.equalsIgnoreCase(expWndTitle)) {
					driver.switchTo().window(wndHandle);
					Reporter.log("Window title matched and switched to expected window");
					isWindowSelected = true;
					break;
				}
			}

			if (!isWindowSelected) {
				Reporter.log("Window title not matched and unable to switch to expected window");

			}
		}

	}

	public void highlight(WebElement element, JavascriptExecutor jse) {
		jse.executeScript("arguments[0].style.border='8px solid Red'", element);
	}

	public void scrollIntoView(WebElement element, JavascriptExecutor jse) {
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}

	public static void takeScreenShot(String testName) {		
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenShotLoacation = System.getProperty("user.dir") + "/ExecutionScreenShots";
		try {
			Files.copy(screenShotFile, new File(screenShotLoacation + "/"+testName+"_ScreenShot_"+getTimeStamp()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
