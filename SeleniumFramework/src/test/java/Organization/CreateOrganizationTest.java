package Organization;

import java.io.IOException;

import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_utility;
import POM.HomePage;
import POM.OrganizationPage;

public class CreateOrganizationTest extends BaseClass {
	@Test(groups="regressiontest")
	public static void  createOrganization() throws IOException {
		
		Webdriver_utility w = new Webdriver_utility();
		w.implicitlyWait(driver);
		// maximizing the web page
		w.maximize(driver);
		// click on Organizations module
		HomePage h = new HomePage(driver);
		h.clickOrganizationsLinkText();
		// click on new Organizations button
		OrganizationPage org = new OrganizationPage(driver);
		org.clickOrganizationCreateImage();
		// Random number
		Java_Utility j = new Java_Utility();
		int randomNum = j.getRandomNum();
		// taking Organization_Name from excel file
		Excel_Utility ex = new Excel_Utility();
		String Organization_Name = ex.getExcelData("Organization", 0, 1) + randomNum;
		// enter Organization_Name as per excel sheet
		org.organizationNamesTextField(Organization_Name);
		// click on save button
		org.saveButton();
		// verify Organization is created as the name we passed
		org.verify_OrganizationName(Organization_Name);
		
	}
	/*@Test
	public void method1() {
		System.out.println("method running");
	}
	*/
}
