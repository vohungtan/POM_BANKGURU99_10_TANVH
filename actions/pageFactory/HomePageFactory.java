package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
	private WebDriver driver;
	
	@FindBy(how = How.XPATH,using = "//marquee[@class='heading3']")
	private WebElement welcomeMessageText;
	
	@FindBy(how = How.XPATH,using = "//tr[@class='heading3']/child::td")
	private WebElement userIDText;
	
	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isWelcomeMessageDisplayed(String expectedText) {
		String actualText = welcomeMessageText.getText().trim();
		return actualText.equals(expectedText);
	}
	
	public boolean isUserIDDisplayed(String userID) {
		String actualText = userIDText.getText().trim();
		return actualText.contains(userID);

	}

	public void openLoginPageUrl(String loginPageUrl) {
		driver.get(loginPageUrl);
	}


}
