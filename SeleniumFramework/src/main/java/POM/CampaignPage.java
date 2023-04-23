package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement CampaignCreateImage;
	@FindBy(name = "campaignname")
	private WebElement campaignNameTextField;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	@FindBy(name = "Delete")
	private WebElement deleteButton;
	@FindBy(xpath = "//a[@title='Campaigns']")
	private List<WebElement> allCampaigns;
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement addProductButton;
	@FindBy(id = "search_txt")
	private WebElement productNameSearchTextField;
	@FindBy(name = "search")
	private WebElement productNameSearchButton;
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement verifyCampaign;

	// getter Methods
	public WebElement getProductNameSearchTextField() {
		return productNameSearchTextField;
	}

	public WebElement getProductNameSearchButton() {

		return productNameSearchButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getAddProductButton() {
		return addProductButton;
	}

	public List<WebElement> getAllCampaigns() {
		return allCampaigns;
	}

	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getCampaignCreateImage() {
		return CampaignCreateImage;
	}

	// Business logic

	/**
	 * This Method is used for Click On '+' img
	 */
	public void clickCampaignCreateImage() {
		CampaignCreateImage.click();
	}

	/**
	 * This Method is used to Pass Value to Organization TextField
	 */
	public void campaignNameTextField(String proName) {
		campaignNameTextField.sendKeys(proName);
	}

	/**
	 * This Method is used to click "+" Button
	 */
	public void clickAddProductButton() {
		addProductButton.click();

	}

	/**
	 * This Method is used to click Search_Now Button
	 */
	public void clickProductNameSearchButton() {
		productNameSearchButton.click();

	}

	/**
	 * This Method is used to pass product name in SearchTextField 
	 * 
	 * @param text
	 */
	public void productNameSearchTextField(String text) {
		productNameSearchTextField.sendKeys(text);
	}
	/**
	 * This method is used to verify created Campaign
	 * @param CampaignName
	 */
	public void verifyCampaignName(String CampaignName) {
		String verify_Campaign = verifyCampaign.getText();
		if (verify_Campaign.contains(CampaignName))
			System.out.println("Create Campaign  ....PASS");
		else
			System.out.println("Create Campaign ....FAIL");
	}

	/**
	 * This Method is used to click Save Button
	 */

	public void clickSaveButton() {
		saveButton.click();
	}

	/**
	 * This Method is used to click delete Button
	 */
	public void clickDeleteButton() {
		deleteButton.click();
	}
}
