package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
	/*static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedrive.exe");
	}*/
public static void main(String []args) {

	String key = "webdriver.chrome.driver";
	String value = "./src/main/resources/chromedriver.exe";
	System.setProperty(key,value);
	
	WebDriver driver =new ChromeDriver();
	driver.get("https://www.google.com/");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	driver.close();
}
}
