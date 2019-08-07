package com.bankguru.account;

import org.testng.annotations.Test;

import commons.PageGeneratorManager;
import pageObjects.DepositPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Account_05_RegisterAndLogin_PageGenerator {

	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	DepositPageObject depositPage;
	String email, username, password, loginPageUrl;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		email = "pom" + randomDataTest() + "@gmail.com";

		System.out.println("PRE-CONDITION - STEP: 1. Open BankGuru Application");
		driver.get("http://demo.guru99.com/v4/");
		loginPage = PageGeneratorManager.getLoginPage(driver);

		System.out.println("PRE-CONDITION - STEP: 2. Get Login Page Url");
		loginPageUrl = loginPage.getLoginPageUrl();
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_RegisterToSystem() {

		System.out.println("REGISTER - STEP 1: Click to 'Here'");
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
	

	public int randomDataTest() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
