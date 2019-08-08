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
import org.testng.Assert;

public class Account_08_RegisterAndLogin_DynamicLocator_RestParameter extends AbstractTest{

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		email = "pom" + randomDataTest() + "@gmail.com";

	}

	@Test
	public void TC_01_RegisterToSystem() {

		System.out.println("REGISTER - STEP 1: Click to 'Here'");
		loginPageUrl = loginPage.getLoginPageUrl();
		registerPage = loginPage.clickToHereLink();

		System.out.println("REGISTER - STEP 2: Input to Email ID textbox");
		registerPage.inputToEmailTextbox(email);

		System.out.println("REGISTER - STEP 3: Click to SUBMIT button");
		registerPage.clickToSubmitButton();

		System.out.println("REGISTER - STEP 4: Get Username/ Password infor");
		username = registerPage.getUsernameInformation();
		password = registerPage.getPasswordInformation();
	}

	@Test
	public void TC_02_LoginToSystem() {
		System.out.println("LOGIN - STEP 1: Open Login Page");
		loginPage = registerPage.openLoginPageUrl(loginPageUrl);

		System.out.println("LOGIN - STEP 2: Input to UserID/ Password textbox");
		loginPage.inputToUserIDTextbox(username);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("LOGIN - STEP 3: Click to LOGIN button");
		homePage = loginPage.clickToLoginButton();

		System.out.println("LOGIN - STEP 4: Verify Welcome Message displayed");
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));

		System.out.println("LOGIN - STEP 5: Verify UserID displayed");
		Assert.assertTrue(homePage.isUserIDDisplayed(username));
	}

	@Test
	public void TC_03_OpenMultiplePage() {
		
		newCustomerPage = homePage.openNewCustomerPage(driver);

		depositPage = newCustomerPage.openDepositPage(driver);
		
		newAccountPage = depositPage.openNewAccountPage(driver);
		
		homePage = newAccountPage.openHomePage(driver);
		
		depositPage = homePage.openDepositPage(driver);
		
		newCustomerPage = depositPage.openNewCustomerPage(driver);
		
		homePage = newCustomerPage.openHomePage(driver);
		
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
