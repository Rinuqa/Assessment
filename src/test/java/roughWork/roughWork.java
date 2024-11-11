package roughWork;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class roughWork {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		Properties ObjectRepository= new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\ObjectRepository.properties");
		ObjectRepository.load(fis);
		
		
		System.out.println(ObjectRepository.getProperty("createtable"));
		
		
		Properties Configuration= new Properties();
		 fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Configuration.properties");
		Configuration.load(fis);
		
		System.out.println(Configuration.getProperty("browser"));
		
		
	}

}
