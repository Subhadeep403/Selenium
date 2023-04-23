package Product;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import POM.HomePage;
import POM.ProductPage;

public class CreateProductTest extends BaseClass {
	//@Test(groups="smoketest")
	@Test(retryAnalyzer = Generic_Utility.RetryExample.class) 
	public void CreateProduct() throws EncryptedDocumentException, IOException {
		
		// click on Product module
		HomePage h = new HomePage(driver);
		h.clickProductLink();
		//Intentionally failed test method for ItestListeners
		Assert.fail();
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
		// verify Product is created or not
		pro.verifyProductName(Product_Name);
		
	}
}
