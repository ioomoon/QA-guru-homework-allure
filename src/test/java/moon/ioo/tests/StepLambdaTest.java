package moon.ioo.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaTest {
    private static final String REPO = "eroshenkoam/allure-example";
    private static final String ISSUE = "69 nice";

    @Test
    public void testGitHub(){
        step("Open GitHub page", () -> {
            open("https://github.com");
        });

        step("Search repository" + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPO);
            $(".header-search-input").submit();
        });

        step("Go to repository" + REPO, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });

        step("Open Issues", () -> {
            $(partialLinkText("Issues")).click();
        });

        step("Issues should have issue with name" + ISSUE, () -> {
            $(withText(ISSUE)).should(visible);
        });
    }
}
