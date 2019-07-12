package pageUIs;

public class NewCustomerPageUI {
	
	public static final String NEW_CUSTOMER_PAGE_HEADING = "//p[@class='heading3' and text()='Add New Customer']";
	public static final String NEW_CUSTOMER_REGISTERED_HEADING = "//p[@class='heading3' and text()='Customer Registered Successfully!!!']";
	public static final String CUSTOMER_NAME_TEXTBOX = "//input[@name='name']";
	public static final String GENDER_MALE_RADIO = "//input[@value='m']";
	public static final String DATE_OF_BIRTH_TEXTBOX = "//input[@name='dob']";
	public static final String ADDRESS_TEXTAREA = "//textarea[@name='addr']";
	public static final String CITY_TEXTBOX = "//input[@name='city']";
	public static final String STATE_TEXTBOX = "//input[@name='state']";
	public static final String PIN_TEXTBOX = "//input[@name='pinno']";
	public static final String PHONE_TEXTBOX = "//input[@name='telephoneno']";
	public static final String EMAIL_TEXTBOX = "//input[@name='emailid']";
	public static final String PASSWORD_TEXTBOX = "//input[@name='password']";
	public static final String SUBMIT_BUTTON = "//input[@name='sub']";
	public static final String CUSTOMER_NAME_VALUE_IN_TABLE = "//table[@id='customer']//td[text()='Customer Name']/following-sibling::td";
	public static final String GENDER_VALUE_IN_TABLE = "//table[@id='customer']//td[text()='Gender']/following-sibling::td";
	public static final String DATE_OF_BIRTH_VALUE_IN_TABLE = "//table[@id='customer']//td[text()='BirthDate']/following-sibling::td";
	public static final String ADDRESS_VALUE_IN_TABLE = "//table[@id='customer']//td[text()='Address']/following-sibling::td";
	public static final String CITY_VALUE_IN_TABLE = "//table[@id='customer']//td[text()='City']/following-sibling::td";
	public static final String STATE_VALUE_IN_TABLE = "//table[@id='customer']//td[text()='State']/following-sibling::td";
	public static final String PHONE_VALUE_IN_TABLE = "//table[@id='customer']//td[text()='Mobile No.']/following-sibling::td";
	public static final String PIN_VALUE_IN_TABLE = "//table[@id='customer']//td[text()='Pin']/following-sibling::td";
	public static final String EMAIL_VALUE_IN_TABLE = "//table[@id='customer']//td[text()='Email']/following-sibling::td";

}
