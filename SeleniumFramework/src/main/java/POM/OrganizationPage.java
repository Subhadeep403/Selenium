package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrganizationPage {
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    //Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement organizationCreateImage;
	
	@FindBy(name="accountname")
	private WebElement organizationNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement verifyOrganization;
	
	@FindBy(xpath="//a[@title='Organizations']")
	private List<WebElement> allOrganizations;
	
	//getter Methods
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}
	
	public WebElement getOrganizationCreateImage() {
		return organizationCreateImage;
	}
	//Business logic
	/**
	 * This Method is used for Click On '+' img
	 */
	public void clickOrganizationCreateImage()
	{
		organizationCreateImage.click();
	}

	/**
	 * This Method is used to Pass Value to Organization TextField
	 */
	public void organizationNamesTextField(String orgName)
	{
		organizationNameTextField.sendKeys(orgName);
	}
	/**
	 * This method is used to verify created Organization
	 * @param Product_Name
	 */
	public void verify_OrganizationName(String Organization_Name) {
		
			String verify_Organization = verifyOrganization.getText();
		
		Assert.assertEquals(Organization_Name,verify_Organization);
	}
	
		/*
		 String verify_Organization = verifyOrganization.getText();
		if (verify_Organization.contains(Organization_Name))
			System.out.println("Create Organization  ....PASS");
		else
			System.out.println("Create Organization ....FAIL");
	
	*/
	/**
	 * This Method is used to Save OrgName
	 */

	public void saveButton()
	{
		saveButton.click();	
	}
	
}
