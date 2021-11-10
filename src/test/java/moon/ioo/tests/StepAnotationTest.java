package moon.ioo.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import moon.ioo.tests.steps.WebSteps;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@Owner("ioomoon")
@Feature("Issues")
@Story("Issue display")
public class StepAnotationTest {
    private static final String REPO = "eroshenkoam/allure-example";
    private static final String ISSUE = "69 nice";

    private WebSteps steps = new WebSteps();

    @Test
    public void testGitHub(){
        steps.openPage();
        steps.searchRepo(REPO);
        steps.goToRepo(REPO);
        steps.openIssues();
        steps.checkIssue(ISSUE);
    }
}
