package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

	/* Web Driver */

	public void openUrl(WebDriver driver, String urlValue) {
		driver.get(urlValue);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	public String getCurrentPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();

	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendKeyToAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	/* Web Element */
	public void clickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemText) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(itemText);
	}

	public String getSelectedItemInDropdown(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String allItemsInDropdown,
			String expectedText) throws Exception {
		element = driver.findElement(By.xpath(parentLocator));

		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsInDropdown)));

		elements = driver.findElements(By.xpath(allItemsInDropdown));

		for (WebElement childElement : elements) {
			if (childElement.getText().contains(expectedText)) {
				if (childElement.isDisplayed()) {
					childElement.click();
				} else {
					javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", childElement);
					Thread.sleep(1000);
					javascriptExecutor.executeScript("arguments[0].click();", childElement);
				}
				Thread.sleep(1000);
				break;
			}
		}

	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checktoCheckbox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToCheckbox(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void switchToChildWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();

		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.contextClick(element).perform();

	}

	public void dragAndDrop(WebDriver driver, String locator, String sourceItem, String targetItem) {
		element = driver.findElement(By.xpath(locator));

		WebElement source = driver.findElement(By.xpath(sourceItem));
		WebElement target = driver.findElement(By.xpath(targetItem));

		action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
	}

	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		element = driver.findElement(By.xpath(locator));
		action = new Actions(driver);
		action.sendKeys(element, key).perform();
	}
	

	public void uploadFile(WebDriver driver, String uploadFileLocator, String startUploadLocator, String fileNamePath) {
		element = driver.findElement(By.xpath(uploadFileLocator));
		element.sendKeys(fileNamePath);
		if (driver.toString().contains("internet explorer")) {
			clickToElementByJS(driver, startUploadLocator);
		} else {
			driver.findElement(By.xpath(startUploadLocator)).click();
		}
	}

	public Object clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].click();", element);
	}

	public void uploadMultiFile(WebDriver driver, String uploadFileLocator, String startUploadLocator, String[] files) {
		element = driver.findElement(By.xpath(uploadFileLocator));

		String filePaths = "";
		for (String file : files) {
			filePaths = file + "\n";
		}
		element.sendKeys(filePaths);

		if (driver.toString().contains("internet explorer")) {
			clickToElementByJS(driver, startUploadLocator);
		} else {
			driver.findElement(By.xpath(startUploadLocator)).click();
		}
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		
		waitExplicit = new WebDriverWait(driver, 10);
		
		waitExplicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		waitExplicit = new WebDriverWait(driver, 10);
		
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}

	private WebElement element;
	private List<WebElement> elements;
	private Select select;
	private JavascriptExecutor javascriptExecutor;
	private WebDriverWait waitExplicit;
	private Actions action;
}