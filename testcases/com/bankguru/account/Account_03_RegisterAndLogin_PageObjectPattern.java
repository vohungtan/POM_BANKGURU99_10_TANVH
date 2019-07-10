package com.bankguru.account;

import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_03_RegisterAndLogin_PageObjectPattern {
    WebDriver driver;
	String email, username, password, loginPageUrl;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	HomePageObject homePage;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();  
	  email = "pom" + randomDataTest() + "@gmail.com";
	  
	  loginPage = new LoginPageObject(driver);
	  registerPage = new RegisterPageObject(driver);
	  homePage = new HomePageObject(driver);
	  
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

  @Test
  public void TC_03_CreateNewCustomer() {
	  System.out.println("NEW_CUSTOMER - STEP: 1. Open New Customer page");
	  
	  System.out.println("NEW_CUSTOMER - STEP: 2. Verify New Customer page displayed");
	  
	  System.out.println("NEW_CUSTOMER - STEP: 3. Input to Customer Name textbox");
	  
	  System.out.println("NEW_CUSTOMER - STEP: 4. Click to Gender with 'male' value");
	  
	  System.out.println("NEW_CUSTOMER - STEP: 5. Input to Date of Birth textbox");
	  
	  System.out.println("NEW_CUSTOMER - STEP: 6. Input to Address textarea");
	  
	  System.out.println("NEW_CUSTOMER - STEP: 7. Input to City textbox");
	  
	  System.out.println("NEW_CUSTOMER - STEP: 8. Input to State textbox");
	  
	  System.out.println("NEW_CUSTOMER - STEP: 9. Input to PIN textbox");
	  
	  System.out.println("NEW_CUSTOMER - STEP: 10. Input to Phone textbox");
	  
	  System.out.println("NEW_CUSTOMER - STEP: 11. Input to Email textbox");
	  
	  System.out.println("NEW_CUSTOMER - STEP: 12. Input to Password textbox");
	  
	  System.out.println("NEW_CUSTOMER - STEP: 13. Input to Submit textbox");
	  
  }
  
  
  public int randomDataTest() {
	  Random random = new Random();
	  return random.nextInt(999999);
  }
  
  @AfterClass (alwaysRun = true)
  public void afterClass() {
	  driver.quit(); 
  }

}

