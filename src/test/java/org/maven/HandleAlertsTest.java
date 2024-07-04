package org.maven;

import org.commonutils.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleAlertsTest extends BaseClass {

	@Test
	public void testAlerts() {

		// driver.findElement(By.xpath("//a[text()[normalize-space()='Login']]")).click();
		if (webDriverUtils.isTextPresent("Login")) {
			driver.findElement(By.id("Login")).click();
			webDriverUtils.acceptAlert();
			driver.findElement(By.id("UserId")).sendKeys("UserName");
			driver.findElement(By.id("passwd")).sendKeys("Password");
		}
	}

}
