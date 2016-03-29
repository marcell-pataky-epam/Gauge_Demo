package driver;

import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.BeforeSpec;
import driver.creator.ChromeWebDriverCreator;
import driver.creator.FirefoxWebDriverCreator;
import driver.creator.WebDriverCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;

/**
 * Created by Marcell_Pataky on 2016-03-29.
 */
public class DriverFactory {

    private static final String BROWSER_PROPERTY = "config.browserType";

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSpec
    public void Setup() {
        String browserName = System.getenv(BROWSER_PROPERTY);
        WebDriverCreator creator = null;

        if (browserName.equals(BrowserType.FIREFOX)) {
            creator = new FirefoxWebDriverCreator();
        } else if (browserName.equals(BrowserType.CHROME)) {
            creator = new ChromeWebDriverCreator();
        }
        driver = creator.createWebDriver();
    }

    @AfterSpec
    public void TearDown() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

}
