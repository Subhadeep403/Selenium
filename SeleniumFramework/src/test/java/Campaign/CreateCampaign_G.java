package Campaign;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_utility;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaign_G {
	public static void main(String[] args) throws IOException, InterruptedException {
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
		// click on Product module
		HomePage h = new HomePage(driver);
		h.clickProductLink();
		// click on new Product button
		ProductPage pro = new ProductPage(driver);
		pro.clickProductCreateImage();
		// Random number
		Java_Utility j = new Java_Utility();
		int randomNum = j.getRandomNum();
		// taking Product_Name from excel file
		Excel_Utility ex = new Excel_Utility();
		String Product_Name = ex.getExcelData("Product", 0, 1) + randomNum;
		// enter Product_Name as per excel sheet
		pro.ProductNameTextField(Product_Name);
		pro.saveButton();
		// click on campaign module
		h.campaignLinkText(driver);
		// click on new campaign button
		CampaignPage camp = new CampaignPage(driver);
		camp.clickCampaignCreateImage();
		// taking Organization_Name from excel file
		String campaign_Name = ex.getExcelData("campaign", 0, 1) + randomNum;
		// enter campaign_Name as per excel sheet
		camp.campaignNameTextField(campaign_Name);
		// click on Product Add button
		camp.clickAddProductButton();
		// child window handle
		w.switchToWindow(driver, "Products&action");
		// search Product
		camp.productNameSearchTextField(Product_Name);
		camp.clickProductNameSearchButton();
		// dynamic thats why we can't use it in pom class
		driver.findElement(By.linkText(Product_Name)).click();
		w.switchToWindow(driver, "Campaigns&action");
		// click save button
		camp.clickSaveButton();
		
		// validating campaign name
		camp.verifyCampaignName(campaign_Name);
		/*
		String text = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (text.contains(campaign_Name))
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