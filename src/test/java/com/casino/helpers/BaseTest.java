package com.casino.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
	private Properties props;
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	
	@BeforeMethod

	//@Parameters({ "environment" })
	//public void setUp(@Optional("demo") String environment) {
	
	public void setUp() {
		   props = new Properties();
	        try {
	            props.load(new FileInputStream("C:\\ParamoJava\\src\\main\\resources\\demo.properties"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }	    
		// Local path to chrome driver
	        System.setProperty("webdriver.chrome.driver",
				"E:\\Descargas\\chromedriver_win32\\chromedriver.exe");
		
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File("src/main/resources/captchasolver.crx"));
			this.driver = new ChromeDriver(options);
			//this.driver = new ChromeDriver();
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.get(testEnvironment.url());
			driver.get(props.getProperty("url"));

			//driver.manage().window().maximize();
			System.out.println("Webdriver created and added to context");	
		}
	
	
	@AfterMethod

	public void tearDown() {
		// Closing Browser and Driver
		if (driver != null) {
			driver.quit();
			System.out.println("Driver was instantiated. Quitting..");
		} else {
			System.out.println("Driver was null so nothing to do");
		}

	}

	public WebDriver getDriver() {
		return driver;

	}
	 public Properties getProps() {
	        return props;
	    }
	
}




