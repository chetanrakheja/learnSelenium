package com.newtours.tests;


import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.newtours.pages.HomePage;
import com.newtours.pages.LoginPage;
import com.newtours.pages.RegisterPage;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;
import commonLibs.utils.ConfigReadUtils;


public class Basetests {

	String url = "http://newtours.demoaut.com";
	
	HomePage homepage;
	LoginPage loginPage;
	RegisterPage registerPage;
	WebDriver driver;
	
	CommonDriver cmnDriver;
	
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extentReporter;
	static ExtentTest extentTest;
	static ScreenshotControl screenControl;
	
	static String htmlReportFilename;
	static String currentWorkingDirectory;
	static String testExecutionStartTime;
	
	static String ScreenshotFilename;
	static String configFilename;
	static Properties configProperties;
	
	
	static {
		
		Date date = new Date();
		
		currentWorkingDirectory = System.getProperty("user.dir");
		testExecutionStartTime=String.valueOf(date.getTime());
		
		htmlReportFilename = String.format("%s/reports/newtoursTestReport_%s.html",
				currentWorkingDirectory,
				testExecutionStartTime);
		
		htmlReporter = new ExtentHtmlReporter(htmlReportFilename);
		extentReporter = new ExtentReports();
		
		extentReporter.attachReporter(htmlReporter);
		
//		ScreenshotFilename = String.format("%s/screenshots/%s_%s.jpeg",
//				currentWorkingDirectory,
//				testExecutionStartTime);
		
		
//		TODO setup config Properties properly
		configFilename = String.format("%s/config.properties", currentWorkingDirectory);
		
	
		}
	
	@BeforeSuite
	public void preSetup() throws Exception {
		configProperties = ConfigReadUtils.readProperties(configFilename);
		
	}
	
	@BeforeClass(alwaysRun = true)
	public void setup() throws Exception {
		
		extentTest = extentReporter.createTest("Test Setup - Setting the Enviroment");
		invokeBrowser();
		
		pageinitialisation();
	
	}

	private void pageinitialisation() {
		loginPage = new LoginPage(driver);
		homepage = new HomePage(driver);
		registerPage = new RegisterPage(driver);
		screenControl = new ScreenshotControl(driver);
		
	}

	private void invokeBrowser() throws Exception {
		
		String browserType = "chrome";
		
		extentTest.log(Status.INFO,"Invoking Browser = "+ browserType);
		cmnDriver = new CommonDriver(browserType);
		
		int pageLoadTimeOut=60;
		extentTest.log(Status.INFO,"PageLoad TimeOut set as  = "+ pageLoadTimeOut);
		cmnDriver.setPageloadTimeout(pageLoadTimeOut);
		
		int elementDetectionTimeOut=60;
		extentTest.log(Status.INFO,"Element Detection TimeOut set as  = "+ elementDetectionTimeOut);
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeOut);
		cmnDriver.navigateToFirstUrl(url);
		driver = cmnDriver.getDriver();
	}

	@AfterMethod(alwaysRun = true)
	public void afterEveryTestCase(ITestResult testResult) throws Exception {
		String testcasename= testResult.getName();
		
		ScreenshotFilename = String.format("%s/screenshots/%s_%s.jpeg",
				currentWorkingDirectory,
				testcasename,
				testExecutionStartTime);
		
		if (testResult.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS,testcasename);
			
		}else if (testResult.getStatus() == ITestResult.FAILURE) {
			screenControl.captureAndSaveScreenshot(ScreenshotFilename);
			extentTest.log(Status.FAIL,testcasename);
			extentTest.addScreenCaptureFromPath(ScreenshotFilename);
		}
		else  {
			extentTest.log(Status.SKIP,testcasename);
		}
			
	}
	
	@AfterClass(alwaysRun = true)
	public void cleanUp() throws Exception {
		cmnDriver.closeAllBrowsers();
	}
	
	@AfterSuite
	public void postCleanup() {
		extentReporter.flush();
	
	}
	
	
	
}
