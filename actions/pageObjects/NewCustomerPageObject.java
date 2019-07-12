package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage {
WebDriver driver;
	
	public NewCustomerPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}

	public boolean isNewCustomerPageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_PAGE_HEADING);
		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_PAGE_HEADING);
	}

	public void inputNewCustomerName(String customerName) {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, customerName);
		
	}

	public void clickToGenderMale() {
		waitForElementVisible(driver, NewCustomerPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, NewCustomerPageUI.GENDER_MALE_RADIO);
		
	}

	public void inputToDateOfBirthTextbox(String dateOfBirth) {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
		
	}

	public void inputToAddressTextArea(String address) {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, address);
		
	}

	public void inputToCityTextbox(String city) {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, city);
		
	}

	public void inputToStateTextbox(String state) {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, state);
		
	}

	public void inputToPINTextbox(String pinNumber) {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, pinNumber);
		
	}

	public void inputToPhoneTextbox(String phoneNumber) {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.PHONE_TEXTBOX, phoneNumber);
		
	}

	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
		
	}

	public void isCustomerRegisteredSuccessMessageDisplayed() {
		// TODO Auto-generated method stub
		
	}

	public String getCustomerNameValueInTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGenderValueInTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBirthDayValueInTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAddressValueInTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getStateValueInTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPhoneValueInTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmailValueInTable() {
		// TODO Auto-generated method stub
		return null;
	}


}
