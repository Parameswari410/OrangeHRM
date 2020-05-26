package com.commonfunctions;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.pageobject.PendingleaveRequest_PageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;

public class CommonFunctions {
	public static WebDriver driver;
	public static Properties property;
	public static Logger logger;

	public void getLogger(){
		logger = Logger.getLogger(CommonFunctions.class);
		PropertyConfigurator.configure("log4j.properties");
	}
	
	
	public Properties Loadproperties() throws IOException {
		FileInputStream file = new FileInputStream("config.properties");
		property = new Properties();
		property.load(file);
		return property;
	}

	public void login() {
		
		logger.info("Login to the application");
		String UN = property.getProperty("username");
		String PW = property.getProperty("password");

		PageFactory.initElements(driver, PendingleaveRequest_PageObject.class);
		PendingleaveRequest_PageObject.username.sendKeys(UN);
		PendingleaveRequest_PageObject.password.sendKeys(PW);
		PendingleaveRequest_PageObject.login.click();	
	}

	@BeforeClass
	public void beforeClass() {
		logger.info("Navigate to url");
		String url1 =property.getProperty("url");
		driver.get(url1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@BeforeSuite
	public void launchbrowser() throws IOException {
		
		logger.info("Getting logger");
		getLogger();
		Loadproperties();
		String browser1 =property.getProperty("browser");
		String path1 =property.getProperty("path");

        logger.info("Browser launch");
		if(browser1.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", path1);
			driver=new ChromeDriver();
		}
		else if(browser1.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", path1);
			driver=new FirefoxDriver();
		}

	}

	@AfterSuite
	public void teardown() {
		
		logger.info("closing the browser");
		driver.quit();
	}

}
