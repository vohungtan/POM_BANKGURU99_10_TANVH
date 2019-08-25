package com.bankguru.commons;

import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.DepositPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;

public class Common_01_RegisterToSystem extends AbstractTest{

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		email = "pom" + randomDataTest() + "@gmail.com";
		
		log.info("REGISTER - STEP 01: Verify Login Page is displayed");
		verifyTrue(loginPage.isLoginPageDisplayed());
		
		log.info("REGISTER - STEP 02: Click to 'Here'");
		loginPage.clickToHereLink();

		log.info("REGISTER - STEP 03: Input to Email ID textbox");
		registerPage.inputToEmailTextbox(email);

		log.info("REGISTER - STEP 04: Click to SUBMIT button");
		registerPage.clickToSubmitButton();

		log.info("REGISTER - STEP 05: Get Username/ Password infor");
		username = registerPage.getUsernameInformation();
		password = registerPage.getPasswordInformation();
	}

	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	DepositPageObject depositPage;
	NewAccountPageObject newAccountPage;
	String email, username, password, loginPageUrl;

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
