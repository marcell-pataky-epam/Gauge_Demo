package driver.creator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Creator class for Firefox driver with basic profile settings.
 * @author Marcell_Pataky
 */
public class FirefoxWebDriverCreator implements WebDriverCreator {

    private WebDriver driver;

    @Override
    public WebDriver createWebDriver() {

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.MINUTES);
        driver.manage().window().maximize();

        return driver;
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

}
