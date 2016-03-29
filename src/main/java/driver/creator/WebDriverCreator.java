package driver.creator;


import org.openqa.selenium.WebDriver;

public interface WebDriverCreator {
	
	WebDriver createWebDriver();

	WebDriver getDriver();
}
