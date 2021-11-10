package moon.ioo.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import moon.ioo.tests.steps.WebSteps;
import org.junit.jupiter.api.Test;

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
