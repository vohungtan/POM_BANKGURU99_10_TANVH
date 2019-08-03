package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
	
	private WebDriver driver;
	
	public WebDriver openMultiBrowser(String browserName) {
		String rootFolder = System.getProperty("user.dir");
		
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", rootFolder + "/resources/chromedriver");
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("chromeheadless")) {
			
			System.setProperty("webdriver.chrome.driver", rootFolder + "/resources/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1280x800");
			driver = new ChromeDriver(options);
			
		} else {
			System.out.println("Please choose your browser in TestNG xml file");
		}
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

}
