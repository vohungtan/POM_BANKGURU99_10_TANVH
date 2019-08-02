package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	
	WebDriver driver;
	
	public RegisterPageObject(WebDriver mappingDriver) {
		driver = mappingDriver;
	}
	
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void clickToSubmitButton() {
		waitForElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
		
	}

	public String getUsernameInformation() {
		waitForElementVisible(driver, RegisterPageUI.USERID_TEXT);
		return getTextElement(driver, RegisterPageUI.USERID_TEXT);
	}

	public String getPasswordInformation() {
		
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getTextElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	public LoginPageObject openLoginPageUrl(String loginPageUrl) {
		openUrl(driver, loginPageUrl);
		return new LoginPageObject(driver);
	}


}
