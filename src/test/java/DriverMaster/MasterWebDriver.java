package DriverMaster;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MasterWebDriver extends Constants {
	

	public static WebDriver driver;
	protected JavascriptExecutor jsExecutor;


	public MasterWebDriver() throws IOException {
		jsExecutor = ((JavascriptExecutor) driver);
	}

	public static WebDriver getLocalDriver(String osType, String browserType) throws IOException {

		try {

			if (browserType.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();

				driver= new ChromeDriver();

			} else if (browserType.equalsIgnoreCase("firefox")) {

				if (osType.equalsIgnoreCase("mac")) {

					System.setProperty("webdriver.gecko.driver",
							"/Users/sami/Desktop/RocketLauncher/Mac/Drivers/geckodriver_V_19_1");

				} else if (osType.equalsIgnoreCase("win")) {

					System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver.exe");

				}
				driver = new FirefoxDriver();

			}
			
		} catch (Exception e) {

			System.out.println("Unable to load browser: " + e.getMessage());

		}

		return driver;

	}
	
	
	public static MasterWebDriver loadUrl(String url) throws Exception {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return new MasterWebDriver();
	}

	
	public static void selectDropDownOptionByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public static void selectDropDownOptionByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	
	public static void selectOptionWithText(String textToSelect) {
		try {
		
			WebElement autoOptions = driver.findElement(By.xpath(".//div[@class='searchresult']/ul"));
			WebDriverWait wait = new WebDriverWait(driver, 7);
			boolean isDisplayed = autoOptions.isDisplayed();
			System.out.println(isDisplayed);
			wait.until(ExpectedConditions.visibilityOf(autoOptions));
			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			for (WebElement option : optionsToSelect) {
				System.out.println(option.getText());
				if (option.getText().equals(textToSelect)) {
					System.out.println("Trying to select: " + textToSelect);
					option.click();
					break;
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public static ArrayList<WebElement> getListOfWebElementsByXpath(String locator) {
		ArrayList<WebElement> list = new ArrayList<WebElement>();
		list = (ArrayList<WebElement>) driver.findElements(By.xpath(locator));

		return list;

	}

	
	
	

}
