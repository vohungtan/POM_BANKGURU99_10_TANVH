package com.bankguru.account;

import org.testng.annotations.Test;

import commons.AbstractPage;
import org.testng.annotations.BeforeClass;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Account_02_RegisterAndLogin_AbstractPage_01 {
    WebDriver driver;
	String email, username, password, loginPageUrl;
	AbstractPage abstractPage;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();  
	  abstractPage = new AbstractPage();
	  email = "pom" + randomDataTest() + "@gmail.com";
	  
	  //AbstractPage
	  abstractPage.openUrl(driver, "http://demo.guru99.com/v4/index.php");
	  
	  //loginPageUrl = driver.getCurrentUrl();
	  loginPageUrl = abstractPage.getCurrentPageUrl(driver);
	  
  }	
	
	
  @Test
  public void TC_01_RegisterToSystem() {
	  
	  System.out.println("REGISTER - STEP 1: Click to 'Here'");
	  abstractPage.clickToElement(driver, "//a[text()='here']");
	  
	  System.out.println("REGISTER - STEP 2: Input to Email ID textbox");
	  abstractPage.sendKeyToElement(driver, "//input[@name='emailid']", email);
	  
	  System.out.println("REGISTER - STEP 3: Click to SUBMIT button");
	  abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
	  
	  System.out.println("REGISTER - STEP 4: Get Username/ Password infor");	  
	  abstractPage.getTextElement(driver, "//td[text()='User ID :']/following-sibling::td");
	  abstractPage.getTextElement(driver, "//td[text()='Password :']/following-sibling::td");
	  
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

