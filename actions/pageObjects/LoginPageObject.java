package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;

	public String getLoginPageUrl() {
		return getCurrentPageUrl(driver);
	}

	public void clickToHereLink() {
		
		waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		clickToElement(driver, LoginPageUI.USER_ID_TEXTBOX);
		
	}

	public void inputToUserIDTextbox(String username) {
		// TODO Auto-generated method stub
		
	}

	public void inputToPasswordTextbox(String password) {
		// TODO Auto-generated method stub
		
	}

	public void clickToLoginButton() {
		// TODO Auto-generated method stub
		
	}

}
