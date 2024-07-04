package org.maven;

import org.commonutils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class StaleElementReferenceExceptionTest extends BaseClass{
	
	@Test
	public void staleElementTest() throws InterruptedException {
		
		String companyLocator="//td[text()='%s']/following-sibling::td[2]";
		WebElement companyElement=driver.findElement(By.xpath(String.format(companyLocator, "Ernst Handel")));
		
		Reporter.log(companyElement.getText());
		
		driver.findElement(By.linkText("Table Sizes")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("HTML Tables")).click();
		
		WebElement companyElement1=driver.findElement(By.xpath(String.format(companyLocator, "Island Trading")));
		
		Reporter.log(companyElement1.getText());
	}

}
