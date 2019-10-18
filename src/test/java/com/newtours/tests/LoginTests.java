package com.newtours.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginTests extends Basetests{

	@Test(priority=0)
	public void verifyTitleOfThePage() throws Exception{
		
//		extentTest = extentReporter
		
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = cmnDriver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test(priority=1000)
	public void verifyLoginToNewTours() throws Exception {
		String sUsername = "mercury";
		String sPassword = "mercury";
		loginPage.login(sUsername, sPassword);
		
		String expectedTitle = "Find a Flight: Mercury Tours:";
		String actualTitle = cmnDriver.getTitle();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle, expectedTitle);
		
        softAssert.assertTrue(homepage.verifySignOffLinkIsPresent());
		
		softAssert.assertAll();
		
		
	}
	
	
}
