package org.maven;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	@DataProvider(name = "test")
	public static Object[][] getData() {

		Object[][] data = new Object[4][2];

		data[0][0] = 10;
		data[0][1] = "Aman";

		data[1][0] = 20;
		data[1][1] = "Neha";

		data[2][0] = 30;
		data[2][1] = "Lavanya";

		data[3][0] = 40;
		data[3][1] = "Saritha";

		return data;
	}

	@Test(dataProvider = "test")
	public void testCaseOne(int id, String name) {
		Reporter.log(String.valueOf(id), true);
		Reporter.log(name, true);

	}

	@Test(dataProvider = "test")
	public void testCaseTwo(int id, String name) {
		Reporter.log(String.valueOf(id), true);
		Reporter.log(name, true);

	}
}
