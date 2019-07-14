package com.bankguru.validation;

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

public class Valication_01_NewCustomer {
	WebDriver driver;
	

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		

	}

	@Test
	public void TC_01_NameCannotBeEmpty() {

		
	}

	@Test
	public void TC_02_NameCannotBeNumeric() {
		
	}

	@Test
	public void TC_03_NameCannotHaveSpecialCharacters() {
		
		
	}
	
	@Test
	public void TC_04_NameCannotHaveFirstCharAsBlankSpace() {
		
		
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
