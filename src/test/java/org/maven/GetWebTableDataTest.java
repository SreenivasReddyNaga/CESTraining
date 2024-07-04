package org.maven;

import java.util.List;

import org.commonutils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class GetWebTableDataTest extends BaseClass {

	@Test
	public void getWebTableData() {

		WebElement tableElement = driver.findElement(By.id("customers"));
		List<WebElement> tableRows = tableElement.findElements(By.tagName("tr"));

		Reporter.log("Number  rows in this table = " + tableRows.size(), true);

		for (WebElement tableRow : tableRows) {
			List<WebElement> tableColumns = tableRow.findElements(By.tagName("td"));
			Reporter.log("Number of Columns in this Row = " + tableColumns.size(), true);

			for (WebElement tableColumn : tableColumns) {
				Reporter.log("Table Data: " + tableColumn.getText(), true);
			}
			
			Reporter.log("--------------------------------------------------------------",true);
		}
	}
}
