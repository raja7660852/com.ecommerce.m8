package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Exception {
		//step 1:open the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step 2:create object of properties for java.util package
		Properties p=new Properties();
		
		//step 3:Load the file input stream into properties
		p.load(fis);
		
		//step 4:provide the key and read the value
		String value=p.getProperty("browser");
		System.out.println(value);
		



	}

}
