package org.pagefactory.tests;

import static org.testng.Assert.assertTrue;

import org.commonutils.BaseClass;
import org.pages.FlightsSearchPage;
import org.pages.HomePage;
import org.pages.LoginPage;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class FindFlightsTest extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	FlightsSearchPage flightsSearchPage;
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	@Test
	public void searchFlightsTest() {

		String userHome = System.getProperty("user.dir");

		extentSparkReporter = new ExtentSparkReporter(userHome + "/ExtentReport/TestReport.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentSparkReporter.config().setDocumentTitle("Selenium Automation Learing");
		extentSparkReporter.config().setReportName("Page object pattern Test");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		extentTest = extentReports.createTest("Search Flights Test");

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		flightsSearchPage = new FlightsSearchPage(driver);

		loginPage.login("mercury", "mercury");

		extentTest.log(Status.PASS, "User able to login in to application");
		homePage.clickOnFlights();
		extentTest.log(Status.PASS, "User able to navigate to search flights page");
		flightsSearchPage.findFlights("Business");
		extentTest.log(Status.INFO, "Testing the logging");
		flightsSearchPage.clickOnContinue();
		extentTest.log(Status.PASS, "User able to enter details in search flights page");

		assertTrue(webDriverUtils.isTextPresent("After flight finder - No Seats Avaialble"),
				"Expected Text not present");
		extentTest.log(Status.FAIL, "User able to search the flight");
		//homePage.logOut();		
		extentReports.flush();
	}
}
