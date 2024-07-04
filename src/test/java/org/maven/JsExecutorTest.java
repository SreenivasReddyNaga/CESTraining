package org.maven;

import org.commonutils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class JsExecutorTest extends BaseClass{
	
	
	
	@Test
	public void testJsExecutor() throws InterruptedException {
		
		Thread.sleep(5000);
		
		String pageTitle=jse.executeScript("return document.title;").toString();
		
		Reporter.log(pageTitle);
		
		WebElement searchElement=driver.findElement(By.name("hfdfh"));
		
		//searchElement.sendKeys("Selenium WebDriver");
		
		webDriverUtils.scrollIntoView(searchElement, jse);
		
		webDriverUtils.highlight(searchElement, jse);
		
		Thread.sleep(3000);
		
		jse.executeScript("arguments[0].value='Selenium WebDriver'", searchElement);
		
		WebElement searchButtonElement=driver.findElement(By.name("btnK"));
		
		//searchButtonElement.click();
		
		webDriverUtils.highlight(searchButtonElement, jse);
		
		Thread.sleep(2000);
		
		jse.executeScript("arguments[0].click()",searchButtonElement);
		
		//jse.executeScript("document.getElementById('id').click()");
		
		
		String searchTitle=jse.executeScript("return document.title;").toString();
		
		Reporter.log(searchTitle);
	}

}
