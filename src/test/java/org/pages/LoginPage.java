package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;

	@FindBy(name = "userName")
	private WebElement userNameElement;

	@FindBy(name = "password")
	private WebElement passwordElement;

	@FindBy(name = "submit")
	private WebElement signInElement;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String userName, String password) {
		userNameElement.sendKeys(userName);
		passwordElement.sendKeys(password);
		signInElement.click();
	}

}
