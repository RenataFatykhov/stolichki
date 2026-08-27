package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static testdata.TestData.*;

public class TutuMainPage {
    private final ElementsCollection headers = $$("[data-ti='header']");
    private final ElementsCollection headerLogos = $$("[data-ti='header-logo']");
    private final SelenideElement searchForm = $("[data-ti='search-form']");
    private final ElementsCollection loginButtons = $$("[data-ti='login-button']");
    private final SelenideElement footer = $("[data-ti='footer']");

    @Step("Открыть страницу")
    public TutuMainPage openPage() {
        open("");
        return this;
    }

    @Step("Открыть страницу справочной")
    public TutuMainPage openHelpPage() {
        open(HELP_PAGE_URL);
        return this;
    }

    @Step("Открыть страницу путеводителя")
    public TutuMainPage openGuidePage() {
        open(GUIDE_PAGE_URL);
        return this;
    }

    @Step("Открыть страницу ЖД билетов")
    public TutuMainPage openTrainsPage() {
        open(TRAINS_PAGE_URL);
        return this;
    }

    @Step("Подготовить страницу")
    public TutuMainPage preparePage() {
        return this;
    }

    @Step("Проверка видимости шапки сайта")
    public TutuMainPage checkHeaderVisible() {
        headers.findBy(visible).shouldBe(visible);
        return this;
    }

    @Step("Проверка заголовка страницы")
    public TutuMainPage checkTitle(String expectedText) {
        assertTrue(title().contains(expectedText));
        return this;
    }

    @Step("Проверка meta description")
    public TutuMainPage checkMetaDescription(String expectedText) {
        $("meta[name='description']")
                .shouldHave(attributeMatching("content", "(?s).*" + expectedText + ".*"));
        return this;
    }

    @Step("Проверка логотипа в шапке")
    public TutuMainPage checkHeaderLogo() {
        headerLogos.findBy(visible)
                .shouldHave(attribute("href", "https://www.tutu.ru/"));
        return this;
    }

    @Step("Проверка формы поиска")
    public TutuMainPage checkSearchFormVisible() {
        searchForm.shouldBe(visible);
        return this;
    }

    @Step("Проверка кнопки входа")
    public TutuMainPage checkLoginButton() {
        loginButtons.findBy(visible).shouldHave(text(LOGIN_BUTTON_TEXT));
        return this;
    }

    @Step("Проверка видимости футера")
    public TutuMainPage checkFooterVisible() {
        footer.scrollTo().shouldBe(visible);
        return this;
    }

    @Step("Проверка текущего URL")
    public TutuMainPage checkPageOpen(String expectedPath) {
        String expectedUrl = Configuration.baseUrl.replaceAll("/+$", "") + expectedPath;
        String currentUrl = WebDriverRunner.getWebDriver()
                .getCurrentUrl()
                .replaceFirst("^(https?://[^/]+)//+", "$1/");
        assertEquals(expectedUrl, currentUrl);
        return this;
    }

}
