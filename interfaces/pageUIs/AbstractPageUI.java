package pageUIs;

public class AbstractPageUI {
	
	public static final String NEW_CUSTOMER_LINK = "//a[text()='New Customer']";
	public static final String NEW_ACCOUNT_LINK = "//a[text()='New Account']";
	public static final String MANAGER_LINK = "//a[text()='Manager']";
	public static final String DEPOSIT_LINK = "//a[text()='Deposit']";
	public static final String LOGOUT_LINK = "//a[text()='Log out']";
	
	public static final String DYNAMIC_MENU_LINK = "//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX = "//input[@name='%s']";
	public static final String DYNAMIC_TEXTAREA = "//textarea[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@value='%s']";
	public static final String DYNAMIC_BUTTON = "//input[@value='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE = "//td[text()='%s']/following-sibling::td/label";
}

