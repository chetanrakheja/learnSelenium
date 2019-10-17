package designPattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonPageFactory {
	
	//can improve performance if element is fixed 
	@CacheLookup
	@FindBy(id = "searchDropdownBox")
	private WebElement searchCategory;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(xpath="//input[@value='Go']")
	private WebElement searchButton;
	
	DropdownControl dropdownControl;
	ElementControl elementControl;
	
	public AmazonPageFactory(WebDriver driver) {
//		searchCategory = driver.findElement(By.id("searchDropdownBox"));		
//		searchBox = driver.findElement(By.id("twotabsearchtextbox"));		
//		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
		
		PageFactory.initElements(driver, this);
		dropdownControl= new DropdownControl();
		elementControl = new ElementControl();
	
	}

	public void searchProduct(String product,String category) throws Exception {
		
		elementControl.setText(searchBox, product);
		dropdownControl.selectViaVisibleText(searchCategory, category);
		elementControl.clickElement(searchButton);
		
		
		
	}
}
