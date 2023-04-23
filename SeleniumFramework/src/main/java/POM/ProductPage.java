package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	 //Declaration
		@FindBy(xpath="//img[@alt='Create Product...']")
		private WebElement ProductCreateImage;
		@FindBy(name="productname")
		private WebElement ProductNameTextField;
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveButton;
		@FindBy(name="Delete")
		private WebElement deleteButton;
		@FindBy(xpath="//a[@title='Products']")
		private List<WebElement> allProducts;
		@FindBy(xpath="//span[@class='lvtHeaderText']")
		private WebElement verifyProduct;
		//getter Methods
		
		public WebElement getSaveButton() {
			return saveButton;
		}
		public WebElement getdeleteButton() {
			return deleteButton;
		}
		public List<WebElement> getallProducts() {
			return allProducts;
		}
		public WebElement getProductNameTextField() {
			return ProductNameTextField;
		}
		
		public WebElement getProductCreateImage() {
			return ProductCreateImage;
		}
	
		//Business logic
		
		/**
		 * This Method is used for Click On '+' img
		 */
		public void clickProductCreateImage()
		{
			ProductCreateImage.click();
		}

		/**
		 * This Method is used to Pass Value to Organization TextField
		 */
		public void ProductNameTextField(String proName)
		{
			ProductNameTextField.sendKeys(proName);
		}
		/**
		 * This method is used to verify created Product
		 * @param Product_Name
		 */
		public void verifyProductName(String Product_Name) {
			String verify_Product = verifyProduct.getText();
			if (verify_Product.contains(Product_Name))
				System.out.println("CreateProduct Done ....PASS");
			else
				System.out.println("CreateProduct ....FAIL");
		}
		
		/**
		 * This Method is used to click Save Button
		 */

		public void saveButton()
		{
			saveButton.click();	
		}
		/**
		 * This Method is used to click delete Button 
		 */
		public void deleteButton()
		{
			deleteButton.click();	
		}
		
		
}
