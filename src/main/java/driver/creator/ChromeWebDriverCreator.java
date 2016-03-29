package driver.creator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Creator class for Chrome driver with basic profile settings.
 */
public class ChromeWebDriverCreator implements WebDriverCreator {

    private WebDriver driver;

    @Override
    public WebDriver createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.MINUTES);
        driver.manage().window().maximize();
        return driver;
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

}
