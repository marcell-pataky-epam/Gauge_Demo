package view;

import org.openqa.selenium.By;

/**
 * Created by Marcell_Pataky on 2016-03-29.
 */
public enum GetStartedPageElements {

    LINUX_BUTTON(By.cssSelector("#Linux>a")),
    DOWNLOAD_LINK_32_BIT(By.xpath("(//li[@id='tab3']//a[@class='download button'])[1]")),
    DOWNLOAD_LINK_64_BIT(By.xpath("(//li[@id='tab3']//a[@class='download button'])[2]")),

    GET_STARTED_PAGE(By.cssSelector(".get-started"));

    private By by;

    GetStartedPageElements(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }


}
