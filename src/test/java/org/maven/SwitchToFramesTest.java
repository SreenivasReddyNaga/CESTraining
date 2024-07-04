package org.maven;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.commonutils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SwitchToFramesTest extends BaseClass {

	@Test
	public void framesTest() {
		assertTrue(webDriverUtils.isTextPresent("Frames Practice"), "Expected text not present");

		driver.switchTo().frame("frm1");
		WebElement courseElement = driver.findElement(By.id("selectnav1"));
		webDriverUtils.selectOption(courseElement, "-- Selenium");
		driver.switchTo().defaultContent();

		driver.switchTo().frame("frm2");
		String actText = driver.findElement(By.id("registerbtn")).getText();
		assertEquals(actText, "Register", "Expected and Actual Matched");
		driver.switchTo().defaultContent();

		driver.findElement(By.id("name")).sendKeys("Frames Test");

	}

}
