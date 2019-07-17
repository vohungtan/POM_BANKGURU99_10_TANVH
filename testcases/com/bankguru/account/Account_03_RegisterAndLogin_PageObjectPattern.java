package com.bankguru.account;

import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_03_RegisterAndLogin_PageObjectPattern {
	WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomer;
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

		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);
		homePage = new HomePageObject(driver);
		newCustomer = new NewCustomerPageObject(driver);

		System.out.println("PRE-CONDITION - STEP: 1. Open BankGuru Application");
		driver.get("http://demo.guru99.com/v4/");

		System.out.println("PRE-CONDITION - STEP: 2. Get Login Page Url");
		loginPageUrl = loginPage.getLoginPageUrl();
		driver.manage().window().maximize();

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

	//@Test
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

	//@Test
	public void TC_03_CreateNewCustomer() {
		System.out.println("NEW_CUSTOMER - STEP: 1. Open New Customer page");
		homePage.clickToNewCustomerPage();

		System.out.println("NEW_CUSTOMER - STEP: 2. Verify New Customer page displayed");
		Assert.assertTrue(newCustomer.isNewCustomerPageDisplayed());

		System.out.println("NEW_CUSTOMER - STEP: 3. Input to Customer Name textbox");
		newCustomer.inputNewCustomerName(customerNameValue);

		System.out.println("NEW_CUSTOMER - STEP: 4. Click to Gender with 'male' value");
		newCustomer.clickToGenderMale();

		System.out.println("NEW_CUSTOMER - STEP: 5. Input to Date of Birth textbox");
		newCustomer.inputToDateOfBirthTextbox(dateOfBirthValue);

		System.out.println("NEW_CUSTOMER - STEP: 6. Input to Address textarea");
		newCustomer.inputToAddressTextArea(addressValue);

		System.out.println("NEW_CUSTOMER - STEP: 7. Input to City textbox");
		newCustomer.inputToCityTextbox(cityValue);

		System.out.println("NEW_CUSTOMER - STEP: 8. Input to State textbox");
		newCustomer.inputToStateTextbox(stateValue);

		System.out.println("NEW_CUSTOMER - STEP: 9. Input to PIN textbox");
		newCustomer.inputToPINTextbox(pinValue);

		System.out.println("NEW_CUSTOMER - STEP: 10. Input to Phone textbox");
		newCustomer.inputToPhoneTextbox(phoneValue);

		System.out.println("NEW_CUSTOMER - STEP: 11. Input to Email textbox");
		newCustomer.inputToEmailTextbox(emailValue);

		System.out.println("NEW_CUSTOMER - STEP: 12. Input to Password textbox");
		newCustomer.inputToPasswordTextbox(passwordValue);

		System.out.println("NEW_CUSTOMER - STEP: 13. Click to Submit button");
		newCustomer.clickToSubmitButton();
		
		System.out.println("NEW CUSTOMER - STEP: 14. Verify 'Customer Registered Successfully!!!' message displayed");
		newCustomer.isCustomerRegisteredSuccessMessageDisplayed();
		
		System.out.println("NEW CUSTOMER - STEP: 15. Verify all information show correct");
		Assert.assertEquals(newCustomer.getCustomerNameValueInTable(), customerNameValue);
		Assert.assertEquals(newCustomer.getGenderValueInTable(), genderMaleValue);
		Assert.assertEquals(newCustomer.getBirthDayValueInTable(), dateOfBirthValue);
		Assert.assertEquals(newCustomer.getAddressValueInTable(), addressValue);
		Assert.assertEquals(newCustomer.getStateValueInTable(), stateValue);
		Assert.assertEquals(newCustomer.getCityValueInTable(), cityValue);
		Assert.assertEquals(newCustomer.getPinValueInTable(), pinValue);
		Assert.assertEquals(newCustomer.getPhoneValueInTable(), phoneValue);
		Assert.assertEquals(newCustomer.getEmailValueInTable(), emailValue);
		
	}

	public int randomDataTest() {
		Random random = new Random();
		return random.nextInt(999999);
	}

	//@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

}
