package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import commons.PageGeneratorManager;
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

	public boolean isCustomerRegisteredSuccessMessageDisplayed() {
		waitForElementVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_REGISTERED_HEADING);
		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_REGISTERED_HEADING);
		
	}

	public String getCustomerNameValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_NAME_VALUE_IN_TABLE);
	}

	public String getGenderValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.GENDER_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.GENDER_VALUE_IN_TABLE);
	}

	public String getBirthDayValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_VALUE_IN_TABLE);
	}

	public String getAddressValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.ADDRESS_VALUE_IN_TABLE);
	}

	public String getStateValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.STATE_VALUE_IN_TABLE);
	}

	public String getPhoneValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.PHONE_VALUE_IN_TABLE);
	}

	public String getEmailValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.EMAIL_VALUE_IN_TABLE);
	}

	public String getCityValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.CITY_VALUE_IN_TABLE);
	}

	public String getPinValueInTable() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_VALUE_IN_TABLE);
		return getTextElement(driver, NewCustomerPageUI.PIN_VALUE_IN_TABLE);
	}

	public void pressTabToMoveNextField() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyboardToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, Keys.TAB);
		
	}

	public String getCustomerNameErrorMessageText() {
		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_ERROR_MESSAGE);
		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_NAME_ERROR_MESSAGE);
	}

	public String getAddressErrorMessageText() {
		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_ERROR_MESSAGE);
		return getTextElement(driver, NewCustomerPageUI.ADDRESS_ERROR_MESSAGE);
	}

	public String getCityErrorMessageText() {
		waitForElementVisible(driver, NewCustomerPageUI.CITY_ERROR_MESSAGE);
		return getTextElement(driver, NewCustomerPageUI.CITY_ERROR_MESSAGE);
	}

	public String getStateErrorMessageText() {
		waitForElementVisible(driver, NewCustomerPageUI.STATE_ERROR_MESSAGE);
		return getTextElement(driver, NewCustomerPageUI.STATE_ERROR_MESSAGE);
	}

	public String getPinErrorMessageText() {
		waitForElementVisible(driver, NewCustomerPageUI.PIN_ERROR_MESSAGE);
		return getTextElement(driver, NewCustomerPageUI.PIN_ERROR_MESSAGE);
	}

	public String getPhoneErrorMessageText() {
		waitForElementVisible(driver, NewCustomerPageUI.PHONE_ERROR_MESSAGE);
		return getTextElement(driver, NewCustomerPageUI.PHONE_ERROR_MESSAGE);
	}

	public String getEmailErrorMessageText() {
		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, NewCustomerPageUI.EMAIL_ERROR_MESSAGE);
	}

	public Object openDepositPage() {
		waitForElementVisible(driver, NewCustomerPageUI.DEPOSIT_LINK);
		clickToElement(driver, NewCustomerPageUI.DEPOSIT_LINK);
		return PageGeneratorManager.getDepositPage(driver);
	}
}
//=======
//import pageUIs.NewCustomerPageUI;
//
//public class NewCustomerPageObject extends AbstractPage {
//WebDriver driver;
//	
//	public NewCustomerPageObject(WebDriver mappingDriver) {
//		driver = mappingDriver;
//	}
//
//	public boolean isNewCustomerPageDisplayed() {
//		waitForElementVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_PAGE_HEADING);
//		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_PAGE_HEADING);
//	}
//
//	public void inputNewCustomerName(String customerName) {
//		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
//		sendKeyToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, customerName);
//		
//	}
//
//	public void clickToGenderMale() {
//		waitForElementVisible(driver, NewCustomerPageUI.GENDER_MALE_RADIO);
//		clickToElement(driver, NewCustomerPageUI.GENDER_MALE_RADIO);
//		
//	}
//
//	public void inputToDateOfBirthTextbox(String dateOfBirth) {
//		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX);
//		sendKeyToElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_TEXTBOX, dateOfBirth);
//		
//	}
//
//	public void inputToAddressTextArea(String address) {
//		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
//		sendKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, address);
//		
//	}
//
//	public void inputToCityTextbox(String city) {
//		waitForElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
//		sendKeyToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, city);
//		
//	}
//
//	public void inputToStateTextbox(String state) {
//		waitForElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
//		sendKeyToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, state);
//		
//	}
//
//	public void inputToPINTextbox(String pinNumber) {
//		waitForElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
//		sendKeyToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, pinNumber);
//		
//	}
//
//	public void inputToPhoneTextbox(String phoneNumber) {
//		waitForElementVisible(driver, NewCustomerPageUI.PHONE_TEXTBOX);
//		sendKeyToElement(driver, NewCustomerPageUI.PHONE_TEXTBOX, phoneNumber);
//		
//	}
//
//	public void inputToEmailTextbox(String email) {
//		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
//		sendKeyToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, email);
//		
//	}
//
//	public void inputToPasswordTextbox(String password) {
//		waitForElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
//		sendKeyToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX, password);
//		
//	}
//
//	public void clickToSubmitButton() {
//		waitForElementVisible(driver, NewCustomerPageUI.SUBMIT_BUTTON);
//		clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
//		
//	}
//
//	public boolean isCustomerRegisteredSuccessMessageDisplayed() {
//		waitForElementVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_REGISTERED_HEADING);
//		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_REGISTERED_HEADING);
//		
//	}
//
//	public String getCustomerNameValueInTable() {
//		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_VALUE_IN_TABLE);
//		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_NAME_VALUE_IN_TABLE);
//	}
//
//	public String getGenderValueInTable() {
//		waitForElementVisible(driver, NewCustomerPageUI.GENDER_VALUE_IN_TABLE);
//		return getTextElement(driver, NewCustomerPageUI.GENDER_VALUE_IN_TABLE);
//	}
//
//	public String getBirthDayValueInTable() {
//		waitForElementVisible(driver, NewCustomerPageUI.DATE_OF_BIRTH_VALUE_IN_TABLE);
//		return getTextElement(driver, NewCustomerPageUI.DATE_OF_BIRTH_VALUE_IN_TABLE);
//	}
//
//	public String getAddressValueInTable() {
//		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_VALUE_IN_TABLE);
//		return getTextElement(driver, NewCustomerPageUI.ADDRESS_VALUE_IN_TABLE);
//	}
//
//	public String getStateValueInTable() {
//		waitForElementVisible(driver, NewCustomerPageUI.STATE_VALUE_IN_TABLE);
//		return getTextElement(driver, NewCustomerPageUI.STATE_VALUE_IN_TABLE);
//	}
//
//	public String getPhoneValueInTable() {
//		waitForElementVisible(driver, NewCustomerPageUI.PHONE_VALUE_IN_TABLE);
//		return getTextElement(driver, NewCustomerPageUI.PHONE_VALUE_IN_TABLE);
//	}
//
//	public String getEmailValueInTable() {
//		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_VALUE_IN_TABLE);
//		return getTextElement(driver, NewCustomerPageUI.EMAIL_VALUE_IN_TABLE);
//	}
//
//	public String getCityValueInTable() {
//		waitForElementVisible(driver, NewCustomerPageUI.CITY_VALUE_IN_TABLE);
//		return getTextElement(driver, NewCustomerPageUI.CITY_VALUE_IN_TABLE);
//	}
//
//	public String getPinValueInTable() {
//		waitForElementVisible(driver, NewCustomerPageUI.PIN_VALUE_IN_TABLE);
//		return getTextElement(driver, NewCustomerPageUI.PIN_VALUE_IN_TABLE);
//	}
//
//	public void pressTabToMoveNextField() {
//		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
//		sendKeyboardToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, Keys.TAB);
//		
//	}
//
//	public String getCustomerNameErrorMessageText() {
//		waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_ERROR_MESSAGE);
//		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_NAME_ERROR_MESSAGE);
//	}
//
//	public String getAddressErrorMessageText() {
//		waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_ERROR_MESSAGE);
//		return getTextElement(driver, NewCustomerPageUI.ADDRESS_ERROR_MESSAGE);
//	}
//
//	public String getCityErrorMessageText() {
//		waitForElementVisible(driver, NewCustomerPageUI.CITY_ERROR_MESSAGE);
//		return getTextElement(driver, NewCustomerPageUI.CITY_ERROR_MESSAGE);
//	}
//
//	public String getStateErrorMessageText() {
//		waitForElementVisible(driver, NewCustomerPageUI.STATE_ERROR_MESSAGE);
//		return getTextElement(driver, NewCustomerPageUI.STATE_ERROR_MESSAGE);
//	}
//
//	public String getPinErrorMessageText() {
//		waitForElementVisible(driver, NewCustomerPageUI.PIN_ERROR_MESSAGE);
//		return getTextElement(driver, NewCustomerPageUI.PIN_ERROR_MESSAGE);
//	}
//
//	public String getPhoneErrorMessageText() {
//		waitForElementVisible(driver, NewCustomerPageUI.PHONE_ERROR_MESSAGE);
//		return getTextElement(driver, NewCustomerPageUI.PHONE_ERROR_MESSAGE);
//	}
//
//	public String getEmailErrorMessageText() {
//		waitForElementVisible(driver, NewCustomerPageUI.EMAIL_ERROR_MESSAGE);
//		return getTextElement(driver, NewCustomerPageUI.EMAIL_ERROR_MESSAGE);
//>>>>>>> branch 'master' of https://github.com/vohungtan/POM_BANKGURU99_10_TANVH
//	}

