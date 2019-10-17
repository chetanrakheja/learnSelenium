package designPattern;

import org.openqa.selenium.WebElement;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonPOMStyle {
	
	private WebElement searchCategory;
	private WebElement searchBox;
	private WebElement searchButton;
	
	DropdownControl dropdownControl;
	ElementControl elementControl;
	
	public AmazonPOMStyle(WebDriver driver) {
		searchCategory = driver.findElement(By.id("searchDropdownBox"));		
		searchBox = driver.findElement(By.id("twotabsearchtextbox"));		
		searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
		
		dropdownControl= new DropdownControl();
		elementControl = new ElementControl();
	
	}

	public void searchProduct(String product,String category) throws Exception {
		
		elementControl.setText(searchBox, product);
		dropdownControl.selectViaVisibleText(searchCategory, category);
		elementControl.clickElement(searchButton);
		
		
		
	}
}
