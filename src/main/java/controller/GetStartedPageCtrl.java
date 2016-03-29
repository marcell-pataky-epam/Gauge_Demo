package controller;

import driver.AsynchronousFinder;
import org.openqa.selenium.WebDriver;
import view.GetStartedPageElements;

/**
 * Created by Marcell_Pataky on 2016-03-29.
 */
public class GetStartedPageCtrl {

    private final WebDriver driver;

    public GetStartedPageCtrl(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLinuxButton() {
        AsynchronousFinder.waitForElementDisplayed(driver, GetStartedPageElements.LINUX_BUTTON.getBy()).click();
    }

    public boolean isGetStartedDisplayed() {
        return AsynchronousFinder.isElementDisplayed(driver, GetStartedPageElements.GET_STARTED_PAGE.getBy());
    }

    public String getDownload32BitHref() {
        return AsynchronousFinder.waitForElementDisplayed(driver, GetStartedPageElements.DOWNLOAD_LINK_32_BIT.getBy()).getAttribute("href");
    }

    public String getDownload64BitHref() {
        return AsynchronousFinder.waitForElementDisplayed(driver, GetStartedPageElements.DOWNLOAD_LINK_64_BIT.getBy()).getAttribute("href");
    }

}
