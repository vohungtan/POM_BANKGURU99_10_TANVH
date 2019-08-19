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

public class Account_09_RegisterAndLogin_ElementUndisplayed extends AbstractTest{

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		email = "pom" + randomDataTest() + "@gmail.com";

	}

	@Test
	public void TC_01_RegisterToSystem() {

		System.out.println("REGISTER - STEP 1.1: Verify Login Page is displayed");
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		
		System.out.println("REGISTER - STEP 1.2.1: Verify Delete Customer Form is not displayed");
		Assert.assertTrue(loginPage.isDeleteCustomerFormLinkUndisplayed());
		
		System.out.println("REGISTER - STEP 1.2.2: Click to Selenium Toogle");
		loginPage.clickToSeleniumDropdownToogle();
		
		System.out.println("REGISTER - STEP 1.2.3: Verify Delete Customer Form is displayed");
		Assert.assertTrue(loginPage.isDeleteCustomerFormLinkDisplayed());
		
		System.out.println("REGISTER - STEP 1.3: Verify Home Page is not displayed");
		Assert.assertTrue(loginPage.isRegisterPageUndisplayed());
		
		System.out.println("REGISTER - STEP 1.4: Verify Register Page is not displayed");
		Assert.assertTrue(loginPage.isHomePageUndisplayed());
		
	}

	@Test(enabled=false)
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
	
	@Test(enabled=false)
	public void TC_03_CheckHomePage() {
		System.out.println("LOGIN - STEP 1: Verify Welcome Message displayed");
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));

		System.out.println("LOGIN - STEP 2: Verify UserID displayed");
		Assert.assertTrue(homePage.isUserIDDisplayed(username));
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
