package org.maven;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotationsDemo {

	@BeforeMethod
	public void bMethod() {
		Reporter.log("Before Method",true);
	}

	@AfterMethod
	public void aMethod() {
		Reporter.log("After Method", true);
	}

	@BeforeTest
	public void bTest() {
		Reporter.log("Before Test", true);
	}

	@BeforeSuite
	public void bSuite() {
		Reporter.log("Before Suite", true);
	}

	@BeforeClass
	public void bClass() {
		Reporter.log("Before Class", true);
	}

	@AfterClass
	public void aClass() {
		Reporter.log("After Class", true);
	}

	@Test(priority=1)
	public void firstTest() {
		Reporter.log("First Test", true);
	}

	@Test(priority=0)
	public void secondTest() {
		Reporter.log("Second Test", true);
	}

	@AfterTest
	public void aTest() {
		Reporter.log("After Test", true);
	}

	@AfterSuite
	public void aSuite() {
		Reporter.log("After Suite", true);
	}

}
