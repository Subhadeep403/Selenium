package Generic_Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends BaseClass implements ITestListener{

	public void onTestFailure(ITestResult result) {
		String res=result.getName();
		//Type casting to use the getScreenshotAs() method
				TakesScreenshot t=(TakesScreenshot)driver;
				//Pressing the Print screen(prt_sc) button
				File src = t.getScreenshotAs(OutputType.FILE);
		//created or open a file with the bellow path
		File dest= new File("./Screenshort/"+res+".png");
		try {
			//copy and paste the screen short from src to dest
			FileUtils.copyFile(src,dest);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
