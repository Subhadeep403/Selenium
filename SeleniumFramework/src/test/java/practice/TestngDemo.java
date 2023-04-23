package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

@Test
public class TestngDemo {

	public void createCustomer() {
		Reporter.log("CreateCustomer");
	}

	public void editCustomer() {
		Reporter.log("EditCustomer");
	}

	public void deleteCustomer() {
		Reporter.log("DeleteCustomer");
	}
}
