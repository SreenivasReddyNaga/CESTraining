package org.maven;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DataProviderDataUseInOtherClass {

	@Test(dataProvider = "test", dataProviderClass = DataProviderDemo.class)
	public void testCaseOne(int id, String name) {
		Reporter.log(String.valueOf(id), true);
		Reporter.log(name, true);

	}

}
