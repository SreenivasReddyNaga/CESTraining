package org.commonutils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public WebDriverUtils webDriverUtils;
	public WebDriverWaitUtils webDriverWaitUtils;
	public String excelFilePath = null;
	public String sheetName = null;
	public DataUtils dataUtils=new DataUtils();
	public JavascriptExecutor jse=null;

	@BeforeClass
	@Parameters({ "url", "browserName" })
	public void setUp(String url, String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			Reporter.log("Script execting on " + browserName + "browser", true);
		} else if (browserName.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			Reporter.log("Script execting on " + browserName + "browser", true);
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			Reporter.log("Script execting on " + browserName + "browser", true);
		} else {
			Reporter.log("Browser name not available. Please verify browser name and valid browser names are:"
					+ " Chrome, Edge and Firefox");
		}
		driver.get(url);
		driver.manage().window().maximize();
		Reporter.log("Browser opened and application url entered", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		webDriverUtils = new WebDriverUtils(driver);
		webDriverWaitUtils = new WebDriverWaitUtils(driver);
		jse=(JavascriptExecutor)driver;

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("Test execution complete and browser session closed", true);
	}
	
	
    @BeforeTest
	@Parameters({ "excelFilePath", "sheetName" })
	public void excelPaths(String excelFilePath, String sheetName) {
		this.excelFilePath = excelFilePath;
		this.sheetName = sheetName;
	}
    
    @DataProvider(name="excel-data")
    public Object[][] createExcelData(){
    	Reporter.log("Creating row based data", true);
    	
    	return dataUtils.getExcelData(excelFilePath, sheetName);
    	
    	/*Object[][] testData=dataUtils.getExcelData(excelFilePath, sheetName);
    	return testData;*/
    }  
    

}
