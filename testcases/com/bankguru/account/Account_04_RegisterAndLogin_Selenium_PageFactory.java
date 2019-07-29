package com.bankguru.account;

import org.testng.annotations.Test;

import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.RegisterPageFactory;

import org.testng.annotations.BeforeClass;

import java.util.Random;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Account_04_RegisterAndLogin_Selenium_PageFactory {
	WebDriver driver;
	LoginPageFactory loginPage;
	RegisterPageFactory registerPage;
	HomePageFactory homePage;
	String email, username, password, loginPageUrl;
	String customerNameValue, genderMaleValue, dateOfBirthValue, addressValue, cityValue;
	String stateValue, pinValue, phoneValue, emailValue, passwordValue;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		email = "pom" + randomDataTest() + "@gmail.com";

		customerNameValue = "Brain";
		genderMaleValue = "male";
		dateOfBirthValue = "1990-01-01";
		addressValue = "691 Sloan Drive";
		cityValue = "Sarasota";
		stateValue = "Florida";
		pinValue = "342335";
		phoneValue = "9416479654";
		emailValue = "otrevon" + randomDataTest() + "@shareasale.com";
		passwordValue = "111222333";

		loginPage = new LoginPageFactory(driver);
		registerPage = new RegisterPageFactory(driver);
		homePage = new HomePageFactory(driver);

		System.out.println("PRE-CONDITION - STEP: 1. Open BankGuru Application");
		driver.get("http://demo.guru99.com/v4");
		driver.manage().window().maximize();

		System.out.println("PRE-CONDITION - STEP: 2. Get Login Page Url");
		loginPageUrl = loginPage.getLoginPageUrl();
		
	}

	@Test
	public void TC_01_RegisterToSystem() {

		System.out.println("REGISTER - STEP 1: Click to 'Here'");
		loginPage.clickToHereLink();

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
		registerPage.openLoginPageUrl(loginPageUrl);

		System.out.println("LOGIN - STEP 2: Input to UserID/ Password textbox");
		loginPage.inputToUserIDTextbox(username);
		loginPage.inputToPasswordTextbox(password);

		System.out.println("LOGIN - STEP 3: Click to LOGIN button");
		loginPage.clickToLoginButton();

		System.out.println("LOGIN - STEP 4: Verify Welcome Message displayed");
		Assert.assertTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));

		System.out.println("LOGIN - STEP 5: Verify UserID displayed");
		Assert.assertTrue(homePage.isUserIDDisplayed(username));
	}


	public int randomDataTest() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
