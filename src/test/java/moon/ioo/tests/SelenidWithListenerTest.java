package moon.ioo.tests;

import org.junit.jupiter.api.Test;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenidWithListenerTest {
    @Test
    public void testGitHub(){

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();

        $(linkText("eroshenkoam/allure-example")).click();

        $("#issues-tab").shouldHave(text("Issues"));
    }
}
