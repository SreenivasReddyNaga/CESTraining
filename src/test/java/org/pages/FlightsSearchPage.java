package org.pages;

import static org.commonutils.WebDriverUtils.selectOption;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsSearchPage {
	
	public WebDriver driver;

	@FindBy(name="tripType")
	private WebElement tripTypeElement;
	
	@FindBy(name="passCount")
	private WebElement passCountElement;
 
	@FindBy(name="fromPort")
	private WebElement departingFromElement;
	
	@FindBy(name="fromMonth")
	private WebElement fromMonthElement;
	
	@FindBy(name="fromDay")
	private WebElement fromDayElement;
	
	@FindBy(name="toPort")
	private WebElement toPortElement;
	
	@FindBy(name="toMonth")
	private WebElement toMonthElement;
	
	@FindBy(name="toDay")
	private WebElement toDayElement;	
			
	@FindBy(name="airline")
	private WebElement airlineElement;
	
	@FindBy(name="findFlights")
	private WebElement continueElement;
	
	String bussinessClassElement = "//input[@value='%s']";
	
	
	public FlightsSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void findFlights(String serviceClass) {
		tripTypeElement.click();
		selectOption(passCountElement, "3");
		selectOption(departingFromElement, "London");
		selectOption(fromMonthElement, "September");
		selectOption(fromDayElement, "16");
		selectOption(toPortElement, "New York");
		selectOption(toMonthElement, "London");
		selectOption(toDayElement, "September");
		selectOption(fromDayElement, "16");
		driver.findElement(By.xpath(String.format(bussinessClassElement, serviceClass))).click();
		selectOption(airlineElement, "Unified Airlines");	
	}
	
	public void clickOnContinue() {
		continueElement.click();
	}

}
