package controller;

import driver.AsynchronousFinder;
import org.openqa.selenium.WebDriver;
import view.ContributePageElements;

/**
 * Created by Marcell_Pataky on 2016-03-29.
 */
public class ContributePageCtrl {

    private final WebDriver driver;

    public ContributePageCtrl(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isContributePageDisplayed() {
        return AsynchronousFinder.isElementDisplayed(driver, ContributePageElements.CONTRIBUTE_PAGE.getBy());
    }

    public boolean isHowToContributeSectionDisplayed() {
        return AsynchronousFinder.isElementDisplayed(driver, ContributePageElements.HOW_TO_CONTRIBUTE_SECTION.getBy());
    }

    public boolean isContributionProcessSectionDisplayed() {
        return AsynchronousFinder.isElementDisplayed(driver, ContributePageElements.CONTRIBUTION_PROCESS_SECTION.getBy());
    }

}
