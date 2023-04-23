package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This method is used for lunching the application by taking the data from Property file 
 * @author subhadeep
 *
 */
public class Property_Utility {
	public  String getKeyValue(String key) throws IOException 
	{
		 FileInputStream fis=new FileInputStream("./src/test/resources/vtiger_common.property");
	        Properties p=new Properties();
	        p.load(fis);
	        String Value = p.getProperty(key);
	        return Value;
	        
	}
}

