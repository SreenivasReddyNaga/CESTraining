package org.maven;

import java.util.Map;

import org.commonutils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MercuryLoginTest extends BaseClass{	

	/*
	 * @Test
	 * 
	 * @Parameters({ "userName", "password" }) public void loginTest(String
	 * userName, String password) {
	 * 
	 * WebElement userNameElement =
	 * driver.findElement(By.cssSelector("input[name='userName']")); if
	 * (userNameElement.isDisplayed()) { userNameElement.sendKeys(userName);
	 * Reporter.log("User Name field is available and entered the data", true);
	 * driver.findElement(By.cssSelector("input[type='password']")).sendKeys(
	 * password);
	 * driver.findElement(By.cssSelector("input[value='Submit']")).click();
	 * Reporter.log("User able to login in to application successfully", true); }
	 * else {
	 * Reporter.log("User Name field is not available and not able enter the data",
	 * true); }
	 * 
	 * WebElement signOutElement =
	 * driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")); if
	 * (signOutElement.isDisplayed()) {
	 * Reporter.log("User is able to login into application successfully", true); if
	 * (signOutElement.isEnabled()) { signOutElement.click(); } } else {
	 * Reporter.log("User is not able to login into application", true); }
	 * 
	 * WebElement signInElement = driver.findElement(By.linkText("SIGN-ON")); if
	 * (signInElement.isDisplayed()) {
	 * Reporter.log("User is logged out from the application successfully", true);
	 * 
	 * } else { Reporter.log("User is not able to logged out from the application",
	 * true); }
	 * 
	 * }
	 */
	
	By userNameObject=By.cssSelector("input[name='userName']");
	By passwordObject=By.cssSelector("input[type='password']");
	By submitObject=By.cssSelector("input[value='Submit']");
	By signOutObject=By.xpath("//a[contains(text(),'SIGN-OFF')]");
	
	@Test(dataProvider = "excel-data")	
	public void loginTest(Map<String, String> data) {
		
		WebElement userNameElement = driver.findElement(userNameObject);
		if (userNameElement.isDisplayed()) {
			userNameElement.sendKeys(data.get("UserName"));
			Reporter.log("User Name field is available and entered the data", true);
			driver.findElement(passwordObject).sendKeys(data.get("Password"));
			driver.findElement(submitObject).click();
			Reporter.log("User able to login in to application successfully", true);
		} else {
			Reporter.log("User Name field is not available and not able enter the data", true);
		}

		WebElement signOutElement = driver.findElement(signOutObject);
		if (signOutElement.isDisplayed()) {
			Reporter.log("User is able to login into application successfully", true);
			if (signOutElement.isEnabled()) {
				signOutElement.click();
			}
		} else {
			Reporter.log("User is not able to login into application", true);
		}

		WebElement signInElement = driver.findElement(By.linkText("SIGN-ON"));
		if (signInElement.isDisplayed()) {
			Reporter.log("User is logged out from the application successfully", true);

		} else {
			Reporter.log("User is not able to logged out from the application", true);
		}

	}
}
