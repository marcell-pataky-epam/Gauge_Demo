package controller;

import driver.AsynchronousFinder;
import org.openqa.selenium.WebDriver;
import view.HomePageElements;

/**
 * Created by Marcell_Pataky on 2016-03-29.
 */
public class HomePageCtrl {

    private final WebDriver driver;

    public HomePageCtrl(WebDriver driver) {
        this.driver = driver;
    }

    public void startHomePage() {
        String url = System.getenv("config.url");
        driver.get(url);
    }

    public boolean isHomePageDisplayed() {
        return AsynchronousFinder.isElementDisplayed(driver, HomePageElements.HOME_PAGE.getBy());
    }

    public boolean isSimpleSyntaxLogoDisplayed() {
        return AsynchronousFinder.isElementDisplayed(driver, HomePageElements.LOGO_SIMPLE_SINTAX.getBy());
    }

    public boolean isGetStartedFastLogoDisplayed() {
        return AsynchronousFinder.isElementDisplayed(driver, HomePageElements.LOGO_GET_STARTED_FAST.getBy());
    }

    public boolean isYourEnvLogoDisplayed() {
        return AsynchronousFinder.isElementDisplayed(driver, HomePageElements.LOGO_YOUR_ENVS.getBy());
    }

    public boolean isDataDrivenLogoDisplayed() {
        return AsynchronousFinder.isElementDisplayed(driver, HomePageElements.LOGO_DATA_DRIVEN.getBy());
    }

    public void clickGetStartedButton() {
        AsynchronousFinder.waitForElementDisplayed(driver, HomePageElements.GET_STARTED_BUTTON.getBy()).click();
    }

    public void clickContributeButton() {
        AsynchronousFinder.waitForElementDisplayed(driver, HomePageElements.CONTRIBUTE_BUTTON.getBy()).click();
    }

}
