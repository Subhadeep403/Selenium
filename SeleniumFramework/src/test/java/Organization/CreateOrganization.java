package Organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {
	
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
		// click on Organizations module
		driver.findElement(By.linkText("Organizations")).click();
		// click on new Organizations button
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		// taking Organization_Name from excel file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String Organization_Name = wb.getSheet("Organization").getRow(0).getCell(1).getStringCellValue();
		// enter Organization_Name as per excel sheet
		driver.findElement(By.name("accountname")).sendKeys(Organization_Name);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String text = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		// verify Organization is created as the name we passed
		if (text.contains(Organization_Name))
			System.out.println("PASS");
		else
			System.out.println("FAIL");
		WebElement Administrator = driver.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
		// sign_out by using mouse hover
		Actions a = new Actions(driver);
		a.moveToElement(Administrator).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}
}