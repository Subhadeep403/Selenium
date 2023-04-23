package Organization;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_utility;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization_G {
	public static void main(String[] args) throws IOException {
		// setup driver executable path
		WebDriverManager.chromedriver().setup();
		// open chrome driver
		WebDriver driver = new ChromeDriver();
		// taking (URL,USERNAME,PASSWORD) from Property file
		Property_Utility p = new Property_Utility();
		String URL = p.getKeyValue("url");
		String USERNAME = p.getKeyValue("username");
		String PASSWORD = p.getKeyValue("password");
		// enter the url
		driver.get(URL);
		Webdriver_utility w = new Webdriver_utility();
		w.implicitlyWait(driver);
		// maximizing the web page
		w.maximize(driver);
		// Login
		LoginPage log = new LoginPage(driver);
		log.setLogin(USERNAME, PASSWORD);
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
		/*
		  String text = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (text.contains(Organization_Name))
			System.out.println("PASS");
		else
			System.out.println("FAIL");
			*/
		// sign_out
		h.signoutLink(driver);
		// close the browser
		driver.close();
	}
}
