import com.thoughtworks.gauge.Step;
import controller.ContributePageCtrl;
import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by Marcell_Pataky on 2016-03-29.
 */
public class ContributePageSteps {

    private final WebDriver driver;
    private final ContributePageCtrl contributePageCtrl;

    public ContributePageSteps() {
        this.driver = DriverFactory.getDriver();
        this.contributePageCtrl = new ContributePageCtrl(driver);
    }

    @Step("The Contribute page is displayed")
    public void verifyContributePageDisplayed() {
        assertThat(contributePageCtrl.isContributePageDisplayed()).isTrue();
    }

    @Step("The How to contribute section is displayed")
    public void verifyContributeSectionPresence() {
        assertThat(contributePageCtrl.isHowToContributeSectionDisplayed()).isTrue();
    }

    @Step("The code contribution process is displayed")
    public void verifyContributionProcessSectionPresence() {
        assertThat(contributePageCtrl.isContributionProcessSectionDisplayed()).isTrue();
    }
}
