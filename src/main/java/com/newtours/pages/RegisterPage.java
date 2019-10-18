package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{

	@FindBy(name="firstName")
	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(name="phone")
	WebElement phone;
	
	@FindBy(name="userName")
	WebElement email;
	
	@FindBy(name="address1")
	WebElement addressLine1;
		
	@FindBy(name="address2")
	WebElement addressLine2;	
		
	@FindBy(name="city")
	WebElement city;
		
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="postalCode")
	WebElement postalCode;
	
	@FindBy(name="country")
	WebElement countryDropdown;
	
	@FindBy(name="email")
	WebElement emailUserName;

	@FindBy(name="password")
	WebElement password;

	@FindBy(name="confirmPassword")
	WebElement confirmPassword;

	@FindBy(name="register")
	WebElement registerBtn;
	
	
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
		
		
	}
	
	public void registerForm(String sFirstName,String sLastName, String sPhone, String sEmail,String sAddressLine1, String sAddressLine2, String sCity, String sPostalCode, String sState,String sPassword) throws Exception {
		elementControl.setText(firstName, sFirstName);
		elementControl.setText(lastName, sLastName);
		elementControl.setText(phone, sPhone);
		elementControl.setText(email, sEmail);
		elementControl.setText(addressLine1, sAddressLine1);
		elementControl.setText(addressLine2, sAddressLine2);
		elementControl.setText(city, sCity);
		elementControl.setText(state, sState);
		elementControl.setText(postalCode, sPostalCode);
		

//		TODO handle countryDropdown
//		dropdownControl.
//		elementControl.setText(countryDropdown, sLastName);
		
		
		elementControl.setText(emailUserName, sEmail);
		elementControl.setText(password, sPassword);
		elementControl.setText(confirmPassword, sPassword);
		
		
		
		elementControl.clickElement(registerBtn);	
		
	}
	

}
