package demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commonLibs.implementation.CommonDriver;
import designPattern.AmazonPOMStyle;
import designPattern.AmazonPageFactory;

public class DemoAmazonPageFatory {
	
	CommonDriver cmnDriver;
	String url = "https://www.amazon.in/";
	AmazonPageFactory amazonHomepage;
	WebDriver driver;
	
	
	@BeforeClass
	public void invokeBrowser() throws Exception {
		cmnDriver = new CommonDriver("chrome");
		cmnDriver.setPageloadTimeout(15);
		cmnDriver.setElementDetectionTimeout(10);
		cmnDriver.navigateToFirstUrl(url);
		driver = cmnDriver.getDriver();
		amazonHomepage = new AmazonPageFactory(driver);
	}

	
	@Test
	public void verifySearchOnHomepage() throws Exception{
		String product = "Apple Watch";
		String category = "Electronics";
		amazonHomepage.searchProduct(product, category);	
	}
	
	
	@AfterClass
	public void closeBrowser() throws Exception {
		cmnDriver.closeAllBrowsers();
	}
}
