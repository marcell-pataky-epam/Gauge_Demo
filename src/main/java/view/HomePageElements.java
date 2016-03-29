package view;

import org.openqa.selenium.By;

/**
 * Created by Marcell_Pataky on 2016-03-29.
 */
public enum HomePageElements {

    HOME_PAGE(By.cssSelector(".hero-banner")),

    LOGO_SIMPLE_SINTAX(By.cssSelector(".simple-syntax.logo")),
    LOGO_GET_STARTED_FAST(By.cssSelector(".start-fast.logo")),
    LOGO_YOUR_ENVS(By.cssSelector(".env-tools.logo")),
    LOGO_DATA_DRIVEN(By.cssSelector(".simple-syntax.logo")),

    CONTRIBUTE_BUTTON(By.cssSelector(".button[href='contribute/index.html']")),
    GET_STARTED_BUTTON(By.cssSelector(".button[href='get-started/index.html']"));

    private By by;

    HomePageElements(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }

}
