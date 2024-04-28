package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class consists of generic methods related to property file
 */
public class propertyFileUtility {

	/**
	 * This method will give value from property file
	 * 
	 * @throws Exception
	 */

	public String toReadDataFromPropertyFile(String key) throws Exception {
		FileInputStream f = new FileInputStream(iConstantUtility.propertyPath);
		Properties p = new Properties();
		p.load(f);
		String value = p.getProperty(key);
		return value;
	}
}