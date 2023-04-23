package practice;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;

@Test(dataProvider = "getData")
public class DataProviderUsingExcel {
	public void readData(String from, String to) {
		System.out.println(from + "---->" + to);

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		Excel_Utility elib = new Excel_Utility();
		Object[][] value = elib.readMultipleData("DataProvider");
		return value;
	}
}
