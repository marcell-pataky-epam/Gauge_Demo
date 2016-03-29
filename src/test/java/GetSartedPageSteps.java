import com.thoughtworks.gauge.Step;
import controller.GetStartedPageCtrl;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by Marcell_Pataky on 2016-03-29.
 */
public class GetSartedPageSteps {

    private final WebDriver driver;
    private final GetStartedPageCtrl getStartedPageCtrl;

    public GetSartedPageSteps() {
        this.driver = DriverFactory.getDriver();
        this.getStartedPageCtrl = new GetStartedPageCtrl(driver);
    }

    @Step("The Get started page is displayed")
    public void verifyGetStartedPageDisplayed() {
        assertThat(getStartedPageCtrl.isGetStartedDisplayed());
    }

    @Step("The user clicks on the Linux button")
    public void clickLinuxButton() {
        getStartedPageCtrl.clickLinuxButton();
    }

    @Step("The 32 bit version link has URL ending <gauge-0.3.2-linux.x86.zip>")
    public void verify32BitUrlEnding(String url) {
        assertThat(getStartedPageCtrl.getDownload32BitHref()).endsWith(url);
    }

    @Step("The 64 bit version link has URL ending <gauge-0.3.2-linux.x86_64.zip>")
    public void verify64BitUrlEnding(String url) {
        assertThat(getStartedPageCtrl.getDownload64BitHref()).endsWith(url);
    }
}
