package org.listeners;

import org.commonutils.WebDriverUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener {

	public void onTestFailure(ITestResult result) {

		Reporter.log("Test Failed :" + result.getName());

		WebDriverUtils.takeScreenShot(result.getName());
	}

}
