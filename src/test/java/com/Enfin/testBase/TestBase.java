package com.Enfin.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;
	public static Properties ObjectRepository = new Properties();
	public static Properties Configuration = new Properties();
	public static FileInputStream fis;
	public static Date d;

	public static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public void setUp() {
		if (driver == null) {

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\properties\\ObjectRepository.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ObjectRepository.load(fis);
				log.debug("ObjectRepository File Loaded--!!");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\properties\\Configuration.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Configuration.load(fis);
				log.debug("Configuration File Loaded--!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (Configuration.getProperty("browser").equals("firefox")) {

				driver = new FirefoxDriver();

			} else if (Configuration.getProperty("browser").equals("chrome")) {

				driver = new ChromeDriver();
				log.debug("Chrome Loaded and Launched--!!");
			}

			else if (Configuration.getProperty("browser").equals("IE")) {

				driver = new InternetExplorerDriver();
			}

			driver.get(Configuration.getProperty("url"));

			log.debug("Navigated To--!!" + "Configuration.getProperty('url')");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
			driver.manage().deleteAllCookies();

		}

	}

	public static void CaptureScreenShot() throws IOException {

		d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//ScreenShots//" + fileName));

	}

	@AfterSuite
	public void tearDown() {
//
//		if(driver!=null) {
//			driver.quit();	
//		}
//		
		log.debug("Test Execution Finishes here");
	}

}
