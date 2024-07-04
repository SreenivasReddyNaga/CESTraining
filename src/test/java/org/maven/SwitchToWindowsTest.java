package org.maven;

import org.commonutils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SwitchToWindowsTest extends BaseClass {
	
	@Test
	public void selectWindowsTest() {

		//String parentWndHandle = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[text()[normalize-space()='Login']]")).click();

		webDriverUtils.switchToWindow("MeeSeva Department Portal Login");

		if (webDriverUtils.isTextPresent("Login")) {

			driver.findElement(By.id("UserId")).sendKeys("UserName");
			driver.findElement(By.id("passwd")).sendKeys("Password");
		}

		//driver.switchTo().window(parentWndHandle);
		
		webDriverUtils.switchToWindow("MeeSeva Official Portal - Government of Andhra Pradesh");

		WebElement loginElement = driver.findElement(By.xpath("//a[text()[normalize-space()='Login']]"));

		if (loginElement.isDisplayed()) {
			Reporter.log("Switched to parent window");
		} else {
			Reporter.log("Not able to Switch to parent window");
		}
	}

}
