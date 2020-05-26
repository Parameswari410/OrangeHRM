package com.Extenteport;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentEg {
	public static WebDriver driver;
	ExtentTest test;
	ExtentReports extent;

	@BeforeSuite
	public void launch() {
		
		Report();
		System.setProperty("webdriver.chrome.driver", "D:\\Softlogic\\Selenium Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void openGoogle() {

		test= extent.startTest("verify goog");
		test.log(LogStatus.INFO, "navigate to url");
		driver.get("https://www.google.com/");
		test.log(LogStatus.INFO, "getting goggle title");
		String text =driver.getTitle();
		if(text.equals("Google")) {
		
			test.log(LogStatus.PASS, "Actual title is equal to expected");
		}
		else {
		
			test.log(LogStatus.FAIL, "Actual title is not equal to expected");
		}

	}



	@Test
	public void openyahoo(){

		test= extent.startTest("verify yahoo");
		driver.get("http://yahoo.com/");
		String text1 =driver.getTitle();
		if(text1.equals("Yahoo India | News, Finance, Cricket, Lifestyle and Entertainment")) {
			test.log(LogStatus.PASS, "Actual title is equal to expected");
			
		}
		else {
			test.log(LogStatus.FAIL, "Actual title is not equal to expected");
		}

	}

	@Test
	public void openping() throws IOException {

		test= extent.startTest("verify ping");
		driver.get("http://ping.com/");                          
		String text2 =driver.getTitle();
		if(text2.equals("Home Page")) {
			test.log(LogStatus.PASS, "Actual title is equal to expected");
			
		}

		else {
			test.log(LogStatus.FAIL, test.addScreenCapture(scr ()), "Actual title is not equal to expected");
		}
		
	}

	public void Report() {
		extent = new ExtentReports("Extentpage.html");
	}
	
	public String scr () throws IOException{
		 TakesScreenshot ts = (TakesScreenshot) driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  String dest = "D:\\Softlogic\\screenshot.png";
		  FileHandler.copy(source, new File(dest));
		  
		  return dest;
	}

	@AfterSuite
	public void close() {

		extent.endTest(test);
		extent.flush();
		driver.close();
	}
}
