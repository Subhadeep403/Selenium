package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

	@Test(dataProvider="dataProvider")
	public void bookTickets(String src,String des) {
		System.out.println("book ticket from " +src+" to "+des );
	}
	@DataProvider
	public Object[][] dataProvider() {
		Object[][] obj= new Object[3][2];
		obj[0][0]="Bangalore";
		obj[0][1]="Goa";
		
		obj[1][0]="Bangalore";
		obj[1][1]="Mysure";
		
		obj[2][0]="Bangalore";
		obj[2][1]="Kolkata";
		return obj;
	}
}
