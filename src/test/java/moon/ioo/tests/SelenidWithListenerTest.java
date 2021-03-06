package moon.ioo.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import io.qameta.allure.selenide.AllureSelenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

@Owner("ioomoon")
@Feature("Issues")
@Story("Issue display")
public class SelenidWithListenerTest {
    private static final String REPO = "eroshenkoam/allure-example";
    private static final String ISSUE = "69 nice";

    @Test
    public void testGitHub(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPO);
        $(".header-search-input").submit();

        $(linkText(REPO)).click();

        $(partialLinkText("Issues")).click();
        $(withText(ISSUE)).should(visible);
    }
}
