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

public class Account_12_RegisterAndLogin_DynamicPageElement extends AbstractTest{

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		email = "pom" + randomDataTest() + "@gmail.com";

		log.info("Pre-condition - STEP 01: Input to UserID/ Password textbox");
		loginPage.inputToUserIDTextbox(Common_01_RegisterToSystem.USERNAME);
		loginPage.inputToPasswordTextbox(Common_01_RegisterToSystem.PASSWORD);
		
		log.info("Pre-condition - STEP 02: Click to LOGIN button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Pre-condition - STEP 03: Verify Welcome Message displayed");
		verifyTrue(homePage.isWelcomeMessageDisplayed("Welcome To Manager's Page of Guru99 Bank"));
		
	}

	@Test
	public void TC_02_ValidateNewCustomerForm() {
		System.out.println("NewCustomer - STEP 01: Open New Customer page");
		newCustomerPage = (NewCustomerPageObject) homePage.openMultiplePage(driver, "New Customer");
		
		//Press Tab to textbox
		newCustomerPage.pressTabToDynamicTextbox(driver, "name");
		newCustomerPage.pressTabToDynamicTextbox(driver, "dob");
		newCustomerPage.pressTabToDynamicTextbox(driver, "city");
		newCustomerPage.pressTabToDynamicTextbox(driver, "state");
		newCustomerPage.pressTabToDynamicTextbox(driver, "pinno");
		newCustomerPage.pressTabToDynamicTextbox(driver, "telephoneno");
		newCustomerPage.pressTabToDynamicTextbox(driver, "emailid");
		newCustomerPage.pressTabToDynamicTextbox(driver, "password");
		
		//Verify error message
		verifyEquals(newCustomerPage.getErrorMessageOfDynamicField(driver, "Customer Name"), "Customer name must not be blank");
		verifyEquals(newCustomerPage.getErrorMessageOfDynamicField(driver, "Date of Birth"), "Date Field must not be blank");
		verifyEquals(newCustomerPage.getErrorMessageOfDynamicField(driver, "City"), "City Field must not be blank");
		verifyEquals(newCustomerPage.getErrorMessageOfDynamicField(driver, "State"), "State must not be blank");
		verifyEquals(newCustomerPage.getErrorMessageOfDynamicField(driver, "PIN"), "PIN Code must not be blank");
		
		//Radio Button
		newCustomerPage.clickToDynamicRadioButton(driver, "f");
		
		//Textbox
		newCustomerPage.inputToDynamicTextbox(driver, "name", "Selenium Test");
		newCustomerPage.inputToDynamicTextbox(driver, "dob", "01/01/1990");
		newCustomerPage.inputToDynamicTextbox(driver, "city", "Los Angeles");
		newCustomerPage.inputToDynamicTextbox(driver, "state", "Florida");
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", "121415");
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", "0123456789");
		newCustomerPage.inputToDynamicTextbox(driver, "emailid", "seleniumtest@gmail.com");
		newCustomerPage.inputToDynamicTextbox(driver, "password", "111222");
		
		//Button
		newCustomerPage.clickToDynamicButton(driver, "Reset");
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	DepositPageObject depositPage;
	NewAccountPageObject newAccountPage;
	String email, username, password, loginPageUrl;

	

}
