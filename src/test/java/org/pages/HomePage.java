package org.pages;

import static org.commonutils.WebDriverWaitUtils.waitForElementToBeClickable;
import static org.commonutils.WebDriverWaitUtils.waitForVisible;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	@FindBy(linkText = "SIGN-OFF")
	private WebElement signOffElement;
	
	@FindBy(linkText = "Flights")
	private WebElement flightsElement;	
	
	public void logOut() {
		waitForVisible(signOffElement, 30).click();
	}
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnFlights() {
		waitForElementToBeClickable(flightsElement, 30).click();
	}	
}
