package com.bankguru.account;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.BeforeClass;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Account_02_RegisterAndLogin_AbstractPage_02 extends AbstractPage {
    WebDriver driver;
	String email, username, password, loginPageUrl;
  
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();  
	  email = "pom" + randomDataTest() + "@gmail.com";
	  
	  //Selenium API
	  //driver.get("http://demo.guru99.com/v4/index.php");
	  
	  //AbstractPage
	  openUrl(driver, "http://demo.guru99.com/v4/index.php");
	  
	  //loginPageUrl = driver.getCurrentUrl();
	  loginPageUrl = getCurrentPageUrl(driver);
	  
  }	
	
	
  @Test
  public void TC_01_RegisterToSystem() {
	  
	  System.out.println("REGISTER - STEP 1: Click to 'Here'");
	  clickToElement(driver, "//a[text()='here']");
	  
	  System.out.println("REGISTER - STEP 2: Input to Email ID textbox");
	  sendKeyToElement(driver, "//input[@name='emailid']", email);
	  
	  System.out.println("REGISTER - STEP 3: Click to SUBMIT button");
	  clickToElement(driver, "//input[@name='btnLogin']");
	  
	  System.out.println("REGISTER - STEP 4: Get Username/ Password infor");	  
	  getTextElement(driver, "//td[text()='User ID :']/following-sibling::td");
	  getTextElement(driver, "//td[text()='Password :']/following-sibling::td");
	  
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

