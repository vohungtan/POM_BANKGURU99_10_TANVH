package com.bankguru.account;

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

import java.util.Random;
import org.openqa.selenium.WebDriver;

public class Account_10_RegisterAndLogin_Assert_Verify_Log_ReportHTML extends AbstractTest{

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		email = "pom" + randomDataTest() + "@gmail.com";

	}

	@Test
	public void TC_01_RegisterToSystem() {

		log.info("REGISTER - STEP 01: Verify Login Page is displayed");
		verifyTrue(loginPage.isLoginPageDisplayed());
		
		log.info("REGISTER - STEP 02: Verify Delete Customer Form is not displayed");
		verifyTrue(loginPage.isDeleteCustomerFormLinkUndisplayed());
		
		log.info("REGISTER - STEP 03: Click to Selenium Toogle");
		loginPage.clickToSeleniumDropdownToogle();
		
		log.info("REGISTER - STEP 04: Verify Delete Customer Form is displayed");
		verifyTrue(loginPage.isDeleteCustomerFormLinkDisplayed());
		
		log.info("REGISTER - STEP 05: Verify Home Page is not displayed");
		verifyTrue(loginPage.isRegisterPageUndisplayed());
		
		log.info("REGISTER - STEP 06: Verify Register Page is not displayed");
		verifyTrue(loginPage.isHomePageUndisplayed());
		
	}

	

	public int randomDataTest() {
		Random random = new Random();
		return random.nextInt(999999);
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
