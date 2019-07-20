package com.bankguru.validation;

import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;

import org.testng.annotations.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Validation_01_NewCustomer {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomer;
	String username, password;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		
		loginPage = new LoginPageObject(driver);
		homePage = new HomePageObject(driver);
		newCustomer = new NewCustomerPageObject(driver);
		
		System.out.println("PRE-CONDITION - STEP: 1. Open BankGuru Application");
		driver.get("http://demo.guru99.com/v4/");
		
		System.out.println("PRE-CONDITION - STEP: 2. Input to UserID/ Password textbox");
		loginPage.inputToUserIDTextbox("mngr210170");
		loginPage.inputToPasswordTextbox("tugYbuv");

		System.out.println("PRE-CONDITION - STEP: 3. Click to LOGIN button");
		loginPage.clickToLoginButton();

		System.out.println("PRE-CONDITION - STEP: 4. Open New Customer page");
		homePage.clickToNewCustomerPage();
	}

	@Test
	public void TC_01_NameCannotBeEmpty() {
		System.out.println("TC_01_NameCannotBeEmpty");
		newCustomer.inputNewCustomerName("");
		newCustomer.pressTabToMoveNextField();
		Assert.assertEquals(newCustomer.getCustomerNameErrorMessageText(), "Customer name must not be blank");
	}

	@Test
	public void TC_02_NameCannotBeNumeric() {
		System.out.println("TC_02_NameCannotBeNumeric");
		newCustomer.inputNewCustomerName("1");
		Assert.assertEquals(newCustomer.getCustomerNameErrorMessageText(), "Numbers are not allowed");
	}

	@Test
	public void TC_03_NameCannotHaveSpecialCharacters() {
		System.out.println("TC_03_NameCannotHaveSpecialCharacters");
		newCustomer.inputNewCustomerName("@#$%");
		Assert.assertEquals(newCustomer.getCustomerNameErrorMessageText(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_04_NameCannotHaveFirstCharAsBlankSpace() {
		System.out.println("TC_04_NameCannotHaveFirstCharAsBlankSpace");
		newCustomer.inputNewCustomerName(" ");
		Assert.assertEquals(newCustomer.getCustomerNameErrorMessageText(), "First character can not have space");
	}
	
	@Test
	public void TC_05_AddressCannotBeEmpty() {
		System.out.println("TC_05_AddressCannotBeEmpty");
		newCustomer.inputToAddressTextArea("");
		newCustomer.pressTabToMoveNextField();
		Assert.assertEquals(newCustomer.getAddressErrorMessageText(), "Address Field must not be blank");
	}
	
	@Test
	public void TC_06_AddressCannotHaveFirstCharAsBlankSpace() {
		System.out.println("TC_06_AddressCannotHaveFirstCharAsBlankSpace");
		newCustomer.inputToAddressTextArea(" ");
		Assert.assertEquals(newCustomer.getAddressErrorMessageText(), "First character can not have space");
	}
	
	@Test
	public void TC_07_CityCannotBeEmpty() {
		System.out.println("TC_07_CityCannotBeEmpty");
		newCustomer.inputToCityTextbox("");
		newCustomer.pressTabToMoveNextField();
		Assert.assertEquals(newCustomer.getCityErrorMessageText(), "City Field must not be blank");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_08_CityCannotBeNumeric() {
		System.out.println("TC_08_CityCannotBeNumeric");
		newCustomer.inputToCityTextbox("1");
		Assert.assertEquals(newCustomer.getCityErrorMessageText(), "Numbers are not allowed");
	}

	
	@Test
	public void TC_09_CityCannotHaveSpecialCharacters() {
		System.out.println("TC_08_CityCannotHaveSpecialCharacters");
		newCustomer.inputToCityTextbox("@#$%");
		Assert.assertEquals(newCustomer.getCityErrorMessageText(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_10_CityCannotHaveFirstCharAsBlankSpace() {
		System.out.println("TC_10_CityCannotHaveFirstCharAsBlankSpace");
		newCustomer.inputToCityTextbox(" ");
		Assert.assertEquals(newCustomer.getCityErrorMessageText(), "First character can not have space");
	}
	
	@Test
	public void TC_11_StateCannotBeEmpty() {
		System.out.println("TC_11_StateCannotBeEmpty");
		newCustomer.inputToStateTextbox("");
		newCustomer.pressTabToMoveNextField();
		Assert.assertEquals(newCustomer.getStateErrorMessageText(), "State Field must not be blank");
	}
	
	@Test
	public void TC_12_StateCannotBeNumeric() {
		System.out.println("TC_12_StateCannotBeNumeric");
		newCustomer.inputToStateTextbox("1");
		Assert.assertEquals(newCustomer.getStateErrorMessageText(), "Numbers are not allowed");
	}
	
	@Test
	public void TC_13_StateCannotHaveSpecialCharacters() {
		System.out.println("TC_13_StateCannotHaveSpecialCharacters");
		newCustomer.inputToStateTextbox("@#$%");
		Assert.assertEquals(newCustomer.getStateErrorMessageText(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_14_StateCannotHaveFirstCharAsBlankSpace() {
		System.out.println("TC_14_StateCannotHaveFirstCharAsBlankSpace");
		newCustomer.inputToStateTextbox(" ");
		Assert.assertEquals(newCustomer.getStateErrorMessageText(), "First character can not have space");
	}
	
	@Test
	public void TC_15_PinMustBeNumeric() {
		System.out.println("TC_15_PinMustBeNumeric");
		newCustomer.inputToPINTextbox("PIN12345");
		Assert.assertEquals(newCustomer.getPinErrorMessageText(), "Characters are not allowed");
	}
	
	@Test
	public void TC_16_PinCannotBeEmpty() {
		System.out.println("TC_16_PinCannotBeEmpty");
		newCustomer.inputToPINTextbox("");
		newCustomer.pressTabToMoveNextField();
		Assert.assertEquals(newCustomer.getPinErrorMessageText(), "PIN Code must not be blank");
	}
	
	@Test
	public void TC_17_PinMustHave6Digits() {
		System.out.println("TC_17_PinMustHave6Digits");
		newCustomer.inputToPINTextbox("123");
		Assert.assertEquals(newCustomer.getPinErrorMessageText(), "PIN Code must have 6 Digits");
	}
	
	@Test
	public void TC_18_PinCannotHaveSpecialCharacters() {
		System.out.println("TC_18_PinCannotHaveSpecialCharacters");
		newCustomer.inputToPINTextbox("@#$%");
		Assert.assertEquals(newCustomer.getPinErrorMessageText(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_19_PinCannotHaveFirstCharAsBlankSpace() {
		System.out.println("TC_19_PinCannotHaveFirstCharAsBlankSpace");
		newCustomer.inputToPINTextbox(" ");
		Assert.assertEquals(newCustomer.getPinErrorMessageText(), "First character can not have space");
	}
	
	@Test
	public void TC_20_PinCannotHaveBlankSpace() {
		System.out.println("TC_20_PinCannotHaveBlankSpace");
		newCustomer.inputToPINTextbox("123 45");
		Assert.assertEquals(newCustomer.getPinErrorMessageText(), "Characters are not allowed");
	}
	
	@Test
	public void TC_21_TelephoneCannotBeEmpty() {
		System.out.println("TC_21_TelephoneCannotBeEmpty");
		newCustomer.inputToPhoneTextbox("");
		newCustomer.pressTabToMoveNextField();
		Assert.assertEquals(newCustomer.getPhoneErrorMessageText(), "Mobile no must not be blank");
	}
	
	@Test
	public void TC_22_PhoneCannotHaveFirstCharAsBlankSpace() {
		System.out.println("TC_22_PhoneCannotHaveFirstCharAsBlankSpace");
		newCustomer.inputToPhoneTextbox(" ");
		Assert.assertEquals(newCustomer.getPhoneErrorMessageText(), "First character can not have space");
	}
	
	@Test
	public void TC_23_PhoneCannotHaveBlankSpace() {
		System.out.println("TC_23_PhoneCannotHaveBlankSpace");
		newCustomer.inputToPhoneTextbox("0905 123456");
		Assert.assertEquals(newCustomer.getPhoneErrorMessageText(), "Characters are not allowed");
	}
	
	@Test
	public void TC_24_PhoneCannotHaveSpecialCharacters() {
		System.out.println("TC_24_PhoneCannotHaveSpecialCharacters");
		newCustomer.inputToPhoneTextbox("@#$%0905123");
		Assert.assertEquals(newCustomer.getPhoneErrorMessageText(), "Special characters are not allowed");
	}
	
	@Test
	public void TC_25_EmailCannotBeEmpty() {
		System.out.println("TC_25_EmailCannotBeEmpty");
		newCustomer.inputToEmailTextbox("");
		newCustomer.pressTabToMoveNextField();
		Assert.assertEquals(newCustomer.getEmailErrorMessageText(), "Email-ID must not be blank");
	}
	
	@Test
	public void TC_26_EmailMustBeInCorrectFormat() {
		System.out.println("TC_26_EmailMustBeInCorrectFormat");
		newCustomer.inputToEmailTextbox("abc@mail");
		Assert.assertEquals(newCustomer.getEmailErrorMessageText(), "Email-ID is not valid");
	}
	
	@Test
	public void TC_27_EmailCannotHaveFirstCharAsBlankSpace() {
		System.out.println("TC_27_EmailCannotHaveFirstCharAsBlankSpace");
		newCustomer.inputToEmailTextbox(" abc@gmail.com");
		Assert.assertEquals(newCustomer.getEmailErrorMessageText(), "First character can not have space");
	}

}
