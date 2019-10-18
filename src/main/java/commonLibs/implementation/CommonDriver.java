package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import commonLibs.contracts.IDriver;

public class CommonDriver implements IDriver{

	private WebDriver driver;
	private int pageloadTimeout;
	private int elementDetectionTimeout;
	
	
	public CommonDriver(String browserType) throws Exception {
		browserType = browserType.trim();
		if (browserType.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\eclipse-workspace\\ArtifatcId_CR\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
//		else if(browserType.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver","");
//		}
		else if(browserType.equalsIgnoreCase("edge")) {
			//don't require belo line if version of edge is more that 18
			System.setProperty("webdriver.edge.driver","C:\\Users\\Administrator\\eclipse-workspace\\ArtifatcId_CR\\driverMicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		} else {
			throw new Exception("Invalide Browser Type:" +browserType);
		} 
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
	
	@Override
	public void navigateToFirstUrl(String url) throws Exception {
		url = url.trim();
		
		driver.manage().timeouts().pageLoadTimeout(pageloadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
		
		driver.get(url);
		
	}

	@Override
	public String getTitle() throws Exception {
		return driver.getTitle();
	}

	@Override
	public String getCurrentUrl() throws Exception {
		return driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() throws Exception {
		return driver.getPageSource();
	}

	@Override
	public void navigateToUrl(String url) throws Exception {
		url = url.trim();
		driver.get(url);
		
	}

	@Override
	public void navigateForward() throws Exception {
		driver.navigate().forward();
		
	}

	@Override
	public void navigateBackward() throws Exception {
		driver.navigate().forward();
		
	}

	@Override
	public void refresh() throws Exception {
		driver.navigate().refresh();		
	}

	@Override
	public void closeBrowser() throws Exception {
		if(driver !=null) {
		driver.close();
		}
	}

	@Override
	public void closeAllBrowsers() throws Exception {
		if(driver !=null) {
			driver.quit();
			}
		
	}

	public WebDriver getDriver() {
		return driver;
		
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public int getPageloadTimeout() {
		return pageloadTimeout;
	}

	public void setPageloadTimeout(int pageloadTimeout) {
		this.pageloadTimeout = pageloadTimeout;
	}

	public int getElementDetectionTimeout() {
		return elementDetectionTimeout;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}
	

}
