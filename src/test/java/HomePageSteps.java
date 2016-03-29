import com.thoughtworks.gauge.Step;
import controller.HomePageCtrl;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by Marcell_Pataky on 2016-03-29.
 */
public class HomePageSteps {

    private final WebDriver driver;
    private final HomePageCtrl homePageCtrl;

    public HomePageSteps() {
        this.driver = DriverFactory.getDriver();
        this.homePageCtrl = new HomePageCtrl(driver);
    }

    @Step("The user launches the Gauge home page")
    public void goToHomePage() {
        homePageCtrl.startHomePage();
    }

    @Step("The home page is displayed")
    public void verifyHomePageDisplayed() {
        assertThat(homePageCtrl.isHomePageDisplayed()).isTrue();
    }

    @Step("The user clicks on the Get Started button")
    public void clickGetStartedButton() {
        homePageCtrl.clickGetStartedButton();
    }

    @Step("The Simple Syntax logo is displayed")
    public void checkSimpleSyntaxLog() {
        assertThat(homePageCtrl.isSimpleSyntaxLogoDisplayed()).isTrue();
    }

    @Step("The Get Started Fast logo is displayed")
    public void checkGetStartedLogo() {
        assertThat(homePageCtrl.isGetStartedFastLogoDisplayed()).isTrue();
    }

    @Step("The Your Environment Your Tools logo is displayed")
    public void checkYourEnvLogo() {
        assertThat(homePageCtrl.isYourEnvLogoDisplayed()).isTrue();
    }

    @Step("The Data Driven Execution logo is displayed")
    public void checkDataDriveLogo() {
        assertThat(homePageCtrl.isDataDrivenLogoDisplayed()).isTrue();
    }

    @Step("The user clicks on the Contribute button")
    public void clickContributeButton() {
        homePageCtrl.clickContributeButton();
    }
}
