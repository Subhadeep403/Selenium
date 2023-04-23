package Campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCampaign {
	public static void main(String[] args) throws IOException, InterruptedException {
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
		// enter the user name
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
		WebElement more = driver.findElement(By.linkText("More"));
		// mouse hover to more option
		Actions a = new Actions(driver);
		a.moveToElement(more).perform();
		// click on campaign
		driver.findElement(By.name("Campaigns")).click();
		// click on new campaign button
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		String campaignname = wb.getSheet("Campaign").getRow(0).getCell(1).getStringCellValue() + randomNum;
		// write campaign name
		driver.findElement(By.name("campaignname")).sendKeys(campaignname);
		// Click on add product button
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		// address of all open window
		String parrent_window = driver.getWindowHandle();
		Set<String> all_windows = driver.getWindowHandles();
		// move courser from parent window to child window
		for (String wh : all_windows) {
			if (!parrent_window.equals(all_windows))
				driver.switchTo().window(wh);

		}
		driver.findElement(By.id("search_txt")).sendKeys(Product_Name);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(Product_Name)).click();
		// move courser from child window to parent window
		driver.switchTo().window(parrent_window);
		// click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		// click on campaign module
		driver.findElement(By.linkText("Campaigns")).click();
		Thread.sleep(4000);
		// type casting
		JavascriptExecutor j = (JavascriptExecutor) driver;
		//scroll down to bottom
		j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(3000);
		// find CampaignName_Checkbox
		WebElement CampaignName_Checkbox = driver.findElement(By.xpath("(//a[@title='Campaigns'])[last()]/../..//input[@name='selected_id']"));
		// click on checkbox
		CampaignName_Checkbox.click();
		driver.findElement(By.xpath("(//input[@type='button' and @value='Delete'])[1]")).click();
		// handle delete alert pop up
		Alert alert = driver.switchTo().alert();
		alert.accept();
		List<WebElement> campaignList = driver.findElements(By.xpath("(//a[@title='Campaigns'])"));
		// validation
		for (int i = 0; i < campaignList.size(); i++) {
			String cname = campaignList.get(i).getText();
			if (campaignname.contains(cname)) {
				System.out.println("Test case fail....campaign is not deleted");
				break;
			} else {
				System.out.println("Test case Pass....campaign is deleted");
				break;
			}
		}

		WebElement Administrator = driver.findElement(By.xpath("(//td[@valign='bottom'])[2]"));
		// sign_out by using mouse hover
		a.moveToElement(Administrator).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

	}
}
