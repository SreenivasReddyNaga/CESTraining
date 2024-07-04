package org.maven;

import java.io.File;
import java.io.IOException;

import org.commonutils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class TakeScreenShotTest extends BaseClass {

	@Test
	public void getScreenShot() throws InterruptedException {

		WebElement searchElement = driver.findElement(By.name("uyiuyi"));

		searchElement.sendKeys("Selenium WebDriver");
		
		Thread.sleep(3000);
		
		File screenShotFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String screenShotLoacation=System.getProperty("user.dir")+"/ExecutionScreenShots";
		
		try {
			Files.copy(screenShotFile, new File(screenShotLoacation+"/ScreenShot.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
