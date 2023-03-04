package com.casino.helpers;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.casino.Environment;


public class BaseTest {

	protected WebDriver driver;
	protected Environment testEnvironment;
	protected WebDriverWait wait;
	
	
	@BeforeMethod

	@Parameters({ "environment" })
	
	public void setUp(@Optional("qa") String environment) {	
		
		ConfigFactory.setProperty("env", environment);
		testEnvironment = ConfigFactory.create(Environment.class);
		
		// Local path to chrome driver
		System.setProperty("webdriver.chrome.driver",
				"E:\\Descargas\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("src/main/resources/captchasolver.crx"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
			this.driver = new ChromeDriver(capabilities);
			//this.driver = new ChromeDriver();
			this.wait = new WebDriverWait(driver, 20);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(testEnvironment.url());
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

}




