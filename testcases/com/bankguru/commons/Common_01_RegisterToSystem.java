package com.bankguru.commons;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.LoginPageObject;

import pageObjects.RegisterPageObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;

public class Common_01_RegisterToSystem extends AbstractTest {
	WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		email = "pom" + randomDataTest() + "@gmail.com";

		log.info("REGISTER - STEP 01: Verify Login Page is displayed");
		verifyTrue(loginPage.isLoginPageDisplayed());

		log.info("REGISTER - STEP 02: Click to 'Here'");
		registerPage = loginPage.clickToHereLink();

		log.info("REGISTER - STEP 03: Input to Email ID textbox");
		registerPage.inputToEmailTextbox(email);

		log.info("REGISTER - STEP 04: Click to SUBMIT button");
		registerPage.clickToSubmitButton();

		log.info("REGISTER - STEP 05: Get Username/ Password infor");
		USERNAME = registerPage.getUsernameInformation();
		PASSWORD = registerPage.getPasswordInformation();
		System.out.println("Username in Class Commons_01_RegisterToSystem = " + USERNAME);
		System.out.println("Password in Class Commons_01_RegisterToSystem = " + PASSWORD);

		closeBrowserAndDriver(driver);
	}

	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	public static String USERNAME, PASSWORD;
	String email;

}
