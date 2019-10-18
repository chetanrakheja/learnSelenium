package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	@FindBy(linkText="SIGN-OFF")
	public WebElement signOffLink;
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean verifySignOffLinkIsPresent() throws Exception {
		// TODO Auto-generated method stub
		return elementControl.isElementVisible(signOffLink);
	}
	

}
