package view;

import org.openqa.selenium.By;

/**
 * Created by Marcell_Pataky on 2016-03-29.
 */
public enum ContributePageElements {

    HOW_TO_CONTRIBUTE_SECTION(By.cssSelector(".how-contribute")),
    CONTRIBUTION_PROCESS_SECTION(By.cssSelector(".contribution-process")),

    CONTRIBUTE_PAGE(By.cssSelector(".contribute"));

    private By by;

    ContributePageElements(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }

}
