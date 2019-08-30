package com.bankguru.account;

import org.testng.annotations.Test;

import com.bankguru.commons.Common_01_RegisterToSystem;

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

public class Account_11_RegisterAndLogin_ShareState extends AbstractTest{
	
	WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("Pre-condition - STEP 01: Input to UserID/ Password textbox");
		loginPage.inputToUserIDTextbox(Common_01_RegisterToSystem.USERNAME);
		loginPage.inputToPasswordTextbox(Common_01_RegisterToSystem.PASSWORD);

		log.info("Pre-condition - STEP 02: Click to LOGIN button");
		homePage = loginPage.clickToLoginButton();

		log.info("Pre-condition - STEP 03: Verify Welcome Message displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));

		log.info("Pre-condition - STEP 04: Verify UserID displayed");
		verifyTrue(homePage.isUserIDDisplayed(Common_01_RegisterToSystem.USERNAME));
		
		System.out.println("Username in Class Account_11_RegisterAndLogin_ShareState = " + Common_01_RegisterToSystem.USERNAME);
		System.out.println("Password in Class Account_11_RegisterAndLogin_ShareState = " + Common_01_RegisterToSystem.PASSWORD);
	}

	@Test
	public void TC_01_CreateNewCustomer() {

	}

	@Test
	public void TC_02_EditCustomer() {
		
	}
	
	@Test
	public void TC_03_CreateNewAccount() {
		
	}
	
	@Test
	public void TC_04_DepositToOtherUser() {
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	DepositPageObject depositPage;
	NewAccountPageObject newAccountPage;
}
