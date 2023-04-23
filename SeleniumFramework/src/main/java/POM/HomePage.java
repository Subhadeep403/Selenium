package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Webdriver_utility;


	public class HomePage {

		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//declaration
			@FindBy(linkText="Products")
			private WebElement productLinkText;
			
			@FindBy(linkText="More")
			private WebElement morelink;
			
			@FindBy(linkText="Campaigns")
			private WebElement campaignsLinkText;
			
			@FindBy(linkText="Organizations")
			private WebElement organizationLinkText;
			
		
			@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
			private WebElement signoutImg;
			
			@FindBy(linkText="Sign Out")
			private WebElement signoutLinkText;
			
	//getter Methods
			
			//getters methods
			public WebElement getOrganizationLinkText() {
				return organizationLinkText;
			}
			public WebElement getSignoutImg() {
				return signoutImg;
			}
	       public WebElement getSignoutLinkText() {
				return signoutLinkText;
			}
		    public WebElement getMorelink() {
				return morelink;
			}
	        public WebElement getCampaignsLinkText() {
				return campaignsLinkText;
			}
	         public WebElement getProductLinkText() 
			{
				return productLinkText;
			}
	         
	         //Business Logic for Product
	         public void clickProductLink()
			{
				productLinkText.click();
			}
			
	         //Business Logic for More
			public void moreLink(WebDriver driver)
			{
				Webdriver_utility wlib = new  Webdriver_utility();
				 wlib.mouseOverOnElement(driver, morelink);
			}
			//Campaign link
	        public void campaignLinkText(WebDriver driver)
			{
	        	Webdriver_utility wlib = new  Webdriver_utility();
				 wlib.mouseOverOnElement(driver, morelink);
	        	campaignsLinkText.click();
			}
	        //Organization link
	        public void clickOrganizationsLinkText()
			{
				organizationLinkText.click();
			}
	        //Sign out
			public void signoutLink(WebDriver driver)
			{
			/*	WebElement Administrator = driver.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
				Actions a = new Actions(driver);
				a.moveToElement(Administrator).perform();
				driver.findElement(By.linkText("Sign Out")).click();
				*/
			      Actions act=new Actions(driver);
			          act.moveToElement(signoutImg).perform();
			        signoutLinkText.click();
			        
			}
		
		
	}

