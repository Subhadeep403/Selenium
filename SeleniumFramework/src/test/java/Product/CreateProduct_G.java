package Product;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.Property_Utility;
import Generic_Utility.Webdriver_utility;
import POM.HomePage;
import POM.LoginPage;
import POM.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct_G {
	public static void main(String[] args) throws IOException {
		// setup driver executable path
		WebDriverManager.chromedriver().setup();
		// open chrome browser
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
		//Random number
		Java_Utility j = new Java_Utility();
		int randomNum = j.getRandomNum();

		// taking Product_Name from excel file
		Excel_Utility ex = new Excel_Utility();
		String Product_Name = ex.getExcelData("Product", 0, 1)+ randomNum;

		// enter Product_Name as per excel sheet
		pro.ProductNameTextField(Product_Name);
		pro.saveButton();

		// verify Product is created or not
		pro.verifyProductName(Product_Name);
		/*String text = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if (text.contains(Product_Name))
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
