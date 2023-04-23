package Generic_Utility;

import java.sql.Date;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_utility {
	/**
	 * This method is used for maximizing the web page
	 * 
	 * @param driver
	 */
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method wait for page to wait in Gui
	 * 
	 * @author subhadeep
	 * @param driver
	 */
	public void implicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * used to wait for element to be clickable in GUI and check for specific
	 * element for every 500 milliseconds
	 * 
	 * @author subhadeep
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement Element, int pollingTime) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}

	/**
	 * After every action it will for next action to perform
	 * 
	 * @author subhadeep
	 */
	public void scriptTimeOut(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}

	/**
	 * This method is use to switch to windows
	 * 
	 * @param driver
	 * @param PartialWindowTitle
	 * @author subhadeep
	 */
	public void switchWindow(WebDriver driver, String PartialWindowTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> id = allWindows.iterator();
		while (id.hasNext()) {
			String wid = id.next();
			driver.switchTo().window(wid);
			String title = driver.getTitle();
			if (title.contains(PartialWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * used to switch to AlertWindow and Accept(click on ok Button)
	 * 
	 * @param driver
	 * @author subhadeep
	 */
	public void switchToAlertAndAccpect(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * used to switch to AlertWindow and dismiss(click on Cancel Button)
	 * 
	 * @param driver
	 * @author subhadeep
	 */
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * used to switch to frame window based on Index
	 * 
	 * @param driver
	 * @param index
	 * @author subhadeep
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * 
	 * used to switch to frame window based on id or name attribute
	 * 
	 * @param driver
	 * @param id_name_attribute
	 * @author subhadeep
	 */
	public void switchToFrame(WebDriver driver, String id_name_Attribute) {
		driver.switchTo().frame(id_name_Attribute);
	}

	/**
	 * used to select the value from the dropDown based on index
	 * 
	 * @param element
	 * @param index
	 * @author subhadeep
	 */
	public void select(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * used to select the value from the dropDown based on text
	 * 
	 * @param element
	 * @param text
	 * @author subhadeep
	 */
	public void select(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * used to place mouse cursor on specified element
	 * 
	 * @param driver
	 * @param element
	 * @author subhadeep
	 * 
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();

	}

	/**
	 * used to right click on specific element
	 * 
	 * @param driver
	 * @param element
	 * @author subhadeep
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	/**
	 * used to move in x,y axis on specific element
	 * 
	 * @author subhadeep
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void moveByOffest(WebDriver driver, int x, int y) {
		Actions a = new Actions(driver);
		a.moveByOffset(x, y).click().perform();
	}

	/**
	 * used to take screen shot with time
	 * 
	 * @param sDriver
	 * @param methodName
	 * @return
	 */
	public String takeScreenshot(WebDriver sDriver, String methodName) {

		Date date = new Date(0);
		date.toString().replace(" ", " ").replace(":", "-");
		// TakesScreenshot ts=(TakesScreenshot)driver;
		return null;
	}

	/**
	 * This method is use to switch window
	 * 
	 * @param driver
	 * @param text
	 */
	public void switchToWindow(WebDriver driver, String text) {
		// String parrent_window = driver.getWindowHandle();
		Set<String> all_windows = driver.getWindowHandles();
		for (String wh : all_windows) {
			driver.switchTo().window(wh);
			String title = driver.getTitle();
			if (title.contains(text))
				break;

		}
	}
}
