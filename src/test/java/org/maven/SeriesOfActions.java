package org.maven;

import org.commonutils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeriesOfActions extends BaseClass{
	
	@Test
	public void testActions() throws InterruptedException {
		
		WebElement userNameElement=driver.findElement(By.name("userName"));
		
		Thread.sleep(3000);
		
		Actions builder=new Actions(driver);	
		
		Action setOfActions=builder
				.moveToElement(userNameElement).click()
				/*
				 * .keyDown(userNameElement, Keys.SHIFT) .sendKeys(userNameElement, "mercury")
				 * .keyUp(userNameElement, Keys.SHIFT) .sendKeys(userNameElement, Keys.SPACE)
				 * .sendKeys(userNameElement, Keys.chord(Keys.CONTROL,"a"))
				 * .contextClick(userNameElement) .sendKeys(Keys.ARROW_DOWN)
				 * .sendKeys(Keys.ENTER)
				 */
				.build();
		setOfActions.perform();		
	}
}
