package Campaign;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Webdriver_utility;
import POM.CampaignPage;
import POM.HomePage;
import POM.ProductPage;

public class CreateCampaignTest extends BaseClass {
	@Test(groups={"smoketest","regressiontest"})
	public  void CreateCampaign() throws IOException, InterruptedException {
	
		Webdriver_utility w = new Webdriver_utility();
		w.implicitlyWait(driver);
		// maximizing the web page
		w.maximize(driver);
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
	

	}
}
