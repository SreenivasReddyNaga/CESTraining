package org.maven;

import java.util.Map;

import org.commonutils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MercuryRegistrationTest extends BaseClass {

	@Test(dataProvider = "excel-data")
	public void registrationTest(Map<String, String> data) {

		driver.findElement(By.linkText("REGISTER")).click();
		WebElement contactInfoElement = driver.findElement(By.xpath("//font[contains(text(),'Contact')]"));
		if (contactInfoElement.isDisplayed()) {
			driver.findElement(By.name("firstName")).sendKeys(data.get("FirstName"));
			driver.findElement(By.name("lastName")).sendKeys(data.get("LastName"));
			driver.findElement(By.name("phone")).sendKeys(data.get("PhoneNumber"));
			driver.findElement(By.name("userName")).sendKeys(data.get("UserName"));
			driver.findElement(By.name("address1")).sendKeys(data.get("Address"));
			driver.findElement(By.name("city")).sendKeys(data.get("City"));
			driver.findElement(By.name("state")).sendKeys(data.get("State"));
			driver.findElement(By.name("postalCode")).sendKeys(data.get("PostalCode"));
			WebElement countryDropdownElement = driver.findElement(By.name("country"));
			webDriverUtils.selectOption(countryDropdownElement, data.get("Country"));
			driver.findElement(By.name("email")).sendKeys(data.get("Email"));
			driver.findElement(By.name("ydhdhyfh")).sendKeys(data.get("Password"));
			driver.findElement(By.name("confirmPassword")).sendKeys(data.get("CfPassword"));
			driver.findElement(By.name("submit")).click();
		}
	}
}
