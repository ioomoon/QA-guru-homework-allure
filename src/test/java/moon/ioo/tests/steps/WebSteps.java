package moon.ioo.tests.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {
    @Step("Open GitHub page")
    public void openPage() {
        open("https://github.com");
    }

    @Step("Search repository {repository}")
    public void searchRepo(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Go to repository")
    public void goToRepo(String repo) {
        $(linkText("eroshenkoam/allure-example")).click();
    }
    @Step("Open Issues")
    public void openIssues() {
        $(partialLinkText("Issues")).click();
    }
    @Step("Issues should have issue with name {issue}")
    public void checkIssue(String issue) {
        $(withText(issue)).should(visible);
    }
}
