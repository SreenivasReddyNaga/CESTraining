package org.maven;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class AmazonCartTest {

	public WebDriver driver;
	public JavascriptExecutor jse=null;

	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		jse=(JavascriptExecutor)driver;
	}

	public void amazonTest() throws InterruptedException {

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement allElement = driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']/i"));
		wait.until(ExpectedConditions.elementToBeClickable(allElement));
		allElement.click();
		

		WebElement menElement = driver.findElement(By.xpath("//div[contains(text(), 'Men')]/following-sibling::i"));
		wait.until(ExpectedConditions.elementToBeClickable(menElement));
		jse.executeScript("arguments[0].click()",menElement);
		
		WebElement jeansElement = driver.findElement(By.xpath("//a[contains(text(), 'Jeans')]"));
		wait.until(ExpectedConditions.elementToBeClickable(jeansElement));
		jse.executeScript("arguments[0].click()",jeansElement);
		
		Thread.sleep(3000);
		
		WebElement wranglerElement = driver.findElement(By.xpath("//span[contains(text(), 'Wrangler')]"));
		//wait.until(ExpectedConditions.elementToBeClickable(wranglerElement));
		jse.executeScript("arguments[0].click()",wranglerElement);
		
		WebElement addToCartElement = driver.findElement(By.xpath("//span[@id='submit.add-to-cart']/span/input"));
		wait.until(ExpectedConditions.elementToBeClickable(addToCartElement));
		jse.executeScript("arguments[0].click()",addToCartElement);

		WebElement proceedToBuyElement = driver
				.findElement(By.xpath("//div[@data-feature-id='proceed-to-checkout-label']"));
		wait.until(ExpectedConditions.elementToBeClickable(proceedToBuyElement));

		String cartItems = proceedToBuyElement.getText();
		
		assertEquals(cartItems, "Proceed to Buy (1 item)");

		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String screenShotLoacation = System.getProperty("user.dir") + "/ExecutionScreenShots";

		try {
			Files.copy(screenShotFile, new File(screenShotLoacation + "/ScreenShot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void tearDown() {
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		AmazonCartTest amazonCartTest = new AmazonCartTest();
		amazonCartTest.setup();
		amazonCartTest.amazonTest();
		amazonCartTest.tearDown();
	}

}
