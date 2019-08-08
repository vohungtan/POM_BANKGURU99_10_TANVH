package commons;

public class DynamicLocator {

	public static void main(String[] args) {
		
		String HOMEPAGE_LINK = "//a[text()='Manager']";
		String NEW_CUSTOMER_PAGE_LINK = "//a[text()='New Customer']";
		String EDIT_CUSTOMER_LINK = "//a[text()='Edit Customer']";
		String DYNAMIC_MENU_LINK = "//a[text()='%s']";
		
		clickToElement(HOMEPAGE_LINK);
		clickToElement(NEW_CUSTOMER_PAGE_LINK);
		clickToElement(EDIT_CUSTOMER_LINK);
		
		clickToElement(DYNAMIC_MENU_LINK, "Manager");
		clickToElement(DYNAMIC_MENU_LINK, "New Customer");
		clickToElement(DYNAMIC_MENU_LINK, "Edit Customer");
		clickToElement(DYNAMIC_MENU_LINK, "New Account");
		clickToElement(DYNAMIC_MENU_LINK, "Edit Account");
		clickToElement(DYNAMIC_MENU_LINK, "Delete Account");
		clickToElement(DYNAMIC_MENU_LINK, "Logout");

	}
	
	public static void clickToElement(String locator) {
		System.out.println("Click to element: " + locator);
	}
	
	public static void clickToElement(String locator, String pageName) {
		locator = String.format(locator, pageName);
		System.out.println("Click to element: " + locator);
	}

	public static void clickToElement(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		System.out.println("Click to element: " + locator);
	}
}
