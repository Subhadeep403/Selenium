package Generic_Utility;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM.HomePage;
import POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	@BeforeSuite(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void BS() {
		System.out.println("DatabBase connection");

	}

	@BeforeTest(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void BT() {
		System.out.println(" Parallel Execution");
	}


	@BeforeClass(groups = { "smoketest", "regressiontest", "sanitytest" })
	/*@Parameters("browser")
  public void BC(String browser) throws IOException {
		*/
		 public void BC() throws IOException { 
		 Property_Utility p = new Property_Utility(); 
		 String browser = p.getKeyValue("browser");
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		System.out.println("Lunching the Browser");
	}

	@BeforeMethod(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void BM() throws IOException {
		Property_Utility p = new Property_Utility();
		Webdriver_utility w = new Webdriver_utility();
		w.implicitlyWait(driver);
		w.maximize(driver);
		String URL = p.getKeyValue("url");
		String USERNAME = p.getKeyValue("username");
		String PASSWORD = p.getKeyValue("password");
		driver.get(URL);
		LoginPage log = new LoginPage(driver);
		log.setLogin(USERNAME, PASSWORD);
		System.out.println("Login");
	}

	@AfterMethod(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void AM() {
		HomePage h = new HomePage(driver);
		h.signoutLink(driver);
		System.out.println("Logout");
	}

	@AfterClass(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void AC() {
		driver.quit();
		System.out.println("Close the Browser");
	}

	@AfterTest(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void AT() {
		System.out.println("Parallel Execution Done");
	}

	@AfterSuite(groups = { "smoketest", "regressiontest", "sanitytest" })
	public void AS() {
		System.out.println("DatabBase connection Close");
	}
}
