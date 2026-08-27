package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static testdata.TestData.*;

public class TutuMainPage {

    private final SelenideElement header = $("[data-ti='header']");
    private final SelenideElement headerLogo = $("[data-ti='header-logo']");
    private final SelenideElement searchForm = $("[data-ti='search-form']");
    private final SelenideElement loginButton = $("[data-ti='login-button']");
    private final SelenideElement footer = $("[data-ti='footer']");
    private final SelenideElement aviaLink = $("a[href='https://avia.tutu.ru/']");
    private final SelenideElement trainsLink = $("a[href='https://www.tutu.ru/poezda/']");
    private final SelenideElement hotelsLink = $("a[href='https://hotel.tutu.ru/']");
    private final SelenideElement trainTab = $("[data-ti='tab-train']");
    private final SelenideElement aviaTab = $("[data-ti='tab-avia']");
    private final SelenideElement hotelTab = $("[data-ti='tab-hotel']");

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
        if (header.exists()) {
            header.scrollTo();
        }
        return this;
    }

    @Step("Проверка видимости шапки сайта")
    public TutuMainPage checkHeaderVisible() {
        header.shouldBe(visible);
        return this;
    }

    @Step("Проверка заголовка страницы")
    public TutuMainPage checkTitle(String expectedText) {
        assertTrue(title().contains(expectedText));
        return this;
    }

    @Step("Проверка meta description")
    public TutuMainPage checkMetaDescription(String expectedText) {
        $("meta[name='description']").shouldHave(attribute("content", expectedText));
        return this;
    }

    @Step("Проверка логотипа в шапке")
    public TutuMainPage checkHeaderLogo() {
        headerLogo.shouldBe(visible).shouldHave(attribute("href", "https://www.tutu.ru/"));
        return this;
    }

    @Step("Проверка формы поиска")
    public TutuMainPage checkSearchFormVisible() {
        searchForm.shouldBe(visible);
        return this;
    }

    @Step("Проверка кнопки входа")
    public TutuMainPage checkLoginButton() {
        loginButton.shouldBe(visible).shouldHave(text(LOGIN_BUTTON_TEXT));
        return this;
    }

    @Step("Проверка видимости футера")
    public TutuMainPage checkFooterVisible() {
        footer.scrollTo().shouldBe(visible);
        return this;
    }

    @Step("Проверка ссылок на основные разделы")
    public TutuMainPage checkHeaderLinks() {
        aviaLink.should(exist).shouldHave(text(AVIABILETY_TEXT)).shouldHave(attribute("href", AVIA_LINK_URL));
        trainsLink.should(exist).shouldHave(text(TRAIN_TICKETS_TEXT)).shouldHave(attribute("href", TRAINS_LINK_URL));
        hotelsLink.should(exist).shouldHave(text(HOTELS_TEXT)).shouldHave(attribute("href", HOTELS_LINK_URL));
        return this;
    }

    @Step("Проверка вкладок формы поиска")
    public TutuMainPage checkSearchTabsVisible() {
        trainTab.shouldBe(visible);
        aviaTab.shouldBe(visible);
        hotelTab.shouldBe(visible);
        return this;
    }

    @Step("Проверка текущего URL")
    public TutuMainPage checkPageOpen(String expectedText) {
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(expectedText, currentUrl);
        return this;
    }

    @Step("Проверка наличия текста на странице")
    public TutuMainPage checkPageContainsText(String expectedText) {
        $("body").shouldHave(text(expectedText));
        return this;
    }
}
