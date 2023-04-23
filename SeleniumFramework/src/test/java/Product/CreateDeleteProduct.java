package Product;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDeleteProduct {
	static boolean result;
	public static void main(String[] args) throws IOException {
		// setup driver executable path
		WebDriverManager.chromedriver().setup();
		// open chrome driver
		WebDriver driver = new ChromeDriver();
		// taking (URL,USERNAME,PASSWORD) from Property file
		FileInputStream fis = new FileInputStream("./src/test/resources/vtiger_common.property");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		// enter the url
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// enter the username
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		// enter the password
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		// click on submit button
		driver.findElement(By.id("submitButton")).click();
		// click on Product module
		driver.findElement(By.linkText("Products")).click();
		// click on new Product button
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		// generate random number to avoid same data
		Random ran = new Random();
		int randomNum = ran.nextInt(1000);
		// taking Product_Name from excel file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String Product_Name = wb.getSheet("Product").getRow(0).getCell(1).getStringCellValue() + randomNum;
		// enter Product_Name as per excel sheet
		driver.findElement(By.name("productname")).sendKeys(Product_Name);
		// enter save button
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		// click on delete button
		driver.findElement(By.xpath("(//input[@name='Delete'])[1]")).click();
		// handle delete alert pop up
		Alert alert = driver.switchTo().alert();
		alert.accept();
		// find all the product list
		List<WebElement> products = driver.findElements(By.xpath("//a[@title='Products']"));
	
		for (int i = 0; i < products.size(); i++) {
			String productName = products.get(i).getText();
			System.out.println(productName);
			Assert.assertNotEquals(productName, Product_Name);
			
		}
		
			/*if (productName.equals(Product_Name)) {
				 result=true;
				break;
			} 
		}
		if(result) {
			System.out.println("Test case fail....Product is not deleted");
		}
		else {
			System.out.println("Test case Pass....Product is  deleted");
		}
    */
		//System.out.println(".......");
		//System.out.println(Product_Name);
		System.out.println("Test case Pass....Product is  deleted");		
		driver.close();

		
	}
}
