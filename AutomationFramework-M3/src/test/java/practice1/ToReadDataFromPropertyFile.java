package practice1;

import java.io.FileInputStream;
import java.util.Properties;

public class ToReadDataFromPropertyFile {

	public static void main(String[] args) throws Exception {

		//Step 1: create object for file input stream
		FileInputStream f=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		//Step 2: create file type object
		Properties p=new Properties();
		
		//call the method
		p.load(f);
		String url=p.getProperty("url");
		System.out.println(url);
	}

}
